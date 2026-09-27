package com.openai.core.http

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.openai.auth.WorkloadIdentityAuth
import com.openai.client.OpenAIClientImpl
import com.openai.core.ClientOptions
import com.openai.core.LogLevel
import com.openai.core.RequestOptions
import com.openai.core.jsonMapper
import com.openai.credential.WorkloadIdentityCredential
import com.openai.models.images.ImageCreateVariationParams
import com.openai.models.images.ImageEditParams
import com.openai.models.skills.SkillCreateParams
import com.openai.models.skills.versions.VersionCreateParams
import com.openai.models.videos.VideoCreateParams
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.FilterInputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.util.concurrent.CancellationException
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

internal class UnionUploadStreamingTest {

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun videoReferenceUnionDefersStreamConsumptionAndCleanup(async: Boolean) {
        val stream = DeferredInputStream()
        val params = VideoCreateParams.builder().prompt("test").inputReference(stream).build()

        client { verifyStreaming(it, stream) }
            .useClient {
                if (async) it.async().videos().create(params).get(10, TimeUnit.SECONDS)
                else it.videos().withRawResponse().create(params).close()
            }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun imageEditUnionDefersStreamConsumptionAndCleanup(async: Boolean) {
        val stream = DeferredInputStream()
        val params = ImageEditParams.builder().prompt("test").image(stream).build()

        client { verifyStreaming(it, stream) }
            .useClient {
                if (async) it.async().images().edit(params).get(10, TimeUnit.SECONDS)
                else it.images().withRawResponse().edit(params).close()
            }
    }

    @Test
    fun ordinaryJsonSerializationKeepsItsExistingBinaryBehavior() {
        val stream = "test".byteInputStream()

        assertThat(jsonMapper().writeValueAsString(stream)).isEqualTo("\"dGVzdA==\"")
    }

    @Test
    fun imageListPreservesBinaryPartsThroughPublicClient() {
        val payloads = listOf(byteArrayOf(0, 1, -1, 13, 10), byteArrayOf(42, -128, 65))
        val streams = payloads.map { GuardedStream(it) }
        val params = ImageEditParams.builder().prompt("test").imageOfInputStreams(streams).build()
        client { body ->
                assertThat(streams.all { !it.closed }).isTrue()
                assertThat(body.contentLength()).isEqualTo(-1L)
                assertThat(body.repeatable()).isFalse()
                streams.forEach { it.allowReads = true }
                val output = ByteArrayOutputStream()
                body.use { it.writeTo(output) }
                val boundary = checkNotNull(body.contentType()).substringAfter("boundary=")
                val parts =
                    output.toString("ISO-8859-1").split("--$boundary").filter {
                        it.contains("name=\"image[]\"")
                    }
                assertThat(parts).hasSize(2)
                parts.forEachIndexed { index, part ->
                    assertThat(
                            part
                                .substringAfter("\r\n\r\n")
                                .removeSuffix("\r\n")
                                .toByteArray(Charsets.ISO_8859_1)
                        )
                        .isEqualTo(payloads[index])
                }
                assertThat(streams.all { it.closed }).isTrue()
            }
            .useClient { it.images().withRawResponse().edit(params).close() }
    }

    @Test
    fun byteArrayUnionRetainsRepeatabilityAndClosesOriginalStream() {
        var closed = false
        val stream =
            object : ByteArrayInputStream(byteArrayOf(1, 2, 3)) {
                override fun close() {
                    closed = true
                }
            }
        val params = ImageEditParams.builder().prompt("test").image(stream).build()
        client { body ->
                assertThat(closed).isTrue()
                assertThat(body.repeatable()).isTrue()
                val first = ByteArrayOutputStream()
                val second = ByteArrayOutputStream()
                body.use {
                    it.writeTo(first)
                    it.writeTo(second)
                }
                assertThat(first.toByteArray()).isEqualTo(second.toByteArray())
                assertThat(body.contentLength()).isEqualTo(first.size().toLong())
            }
            .useClient { it.images().withRawResponse().edit(params).close() }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun retainedUnionStreamsCloseIfALaterFieldCannotBeSerialized(closeFails: Boolean) {
        val streams =
            listOf(GuardedStream(byteArrayOf(1), closeFails), GuardedStream(byteArrayOf(2)))
        val mapper =
            jsonMapper()
                .rebuild()
                .addModule(
                    SimpleModule()
                        .addSerializer(
                            String::class.java,
                            object : JsonSerializer<String>() {
                                override fun serialize(
                                    value: String,
                                    generator: JsonGenerator,
                                    provider: SerializerProvider,
                                ) {
                                    error("test serialization failure")
                                }
                            },
                        )
                )
                .build()
        val params =
            ImageEditParams.builder()
                .imageOfInputStreams(listOf(streams[0], streams[0], streams[1]))
                .prompt("test")
                .build()
        client(mapper) { error("Transport must not receive a failed upload") }
            .useClient {
                val failure = catchThrowable { it.images().edit(params) }
                assertThat(failure)
                    .isInstanceOf(IllegalArgumentException::class.java)
                    .hasCauseInstanceOf(IOException::class.java)
                    .hasMessageContaining("test serialization failure")
                assertThat(failure.suppressed).hasSize(if (closeFails) 1 else 0)
            }
        assertThat(streams.all { it.closed && it.closeCount == 1 }).isTrue()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun normalCleanupAttemptsEveryRetainedStream(writeFails: Boolean) {
        val streams =
            listOf(GuardedStream(byteArrayOf(1), true), GuardedStream(byteArrayOf(2), true))
        val params = ImageEditParams.builder().imageOfInputStreams(streams).prompt("test").build()
        client { body ->
                streams.forEach { it.allowReads = true }
                val output =
                    if (writeFails)
                        object : OutputStream() {
                            override fun write(value: Int) {
                                error("test write failure")
                            }
                        }
                    else ByteArrayOutputStream()
                body.use { it.writeTo(output) }
            }
            .useClient {
                val failure = catchThrowable { it.images().edit(params) }
                assertThat(failure)
                    .hasMessage(if (writeFails) "test write failure" else "test close failure")
                assertThat(failure.suppressed).hasSize(1)
            }
        assertThat(streams.all { it.closed && it.closeCount == 1 }).isTrue()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun cleanupIncludesStreamsReplacedByCustomSerialization(closeFails: Boolean) {
        val streams =
            listOf(GuardedStream(byteArrayOf(1)), GuardedStream(byteArrayOf(2), closeFails))
        val mapper =
            jsonMapper()
                .rebuild()
                .addModule(
                    SimpleModule()
                        .addSerializer(
                            String::class.java,
                            object : JsonSerializer<String>() {
                                override fun serialize(
                                    value: String,
                                    generator: JsonGenerator,
                                    provider: SerializerProvider,
                                ) {
                                    generator.writeStartObject()
                                    streams.forEach {
                                        generator.writeFieldName("file")
                                        provider.defaultSerializeValue(it, generator)
                                    }
                                    generator.writeEndObject()
                                }
                            },
                        )
                )
                .build()
        val params =
            ImageEditParams.builder().image(byteArrayOf(3).inputStream()).prompt("test").build()
        client(mapper) { body ->
                streams.forEach { it.allowReads = true }
                body.use { it.writeTo(ByteArrayOutputStream()) }
            }
            .useClient {
                val failure = catchThrowable { it.images().withRawResponse().edit(params).close() }
                if (closeFails) assertThat(failure).hasMessage("test close failure")
                else assertThat(failure).isNull()
            }
        assertThat(streams.all { it.closed && it.closeCount == 1 }).isTrue()
    }

    @ParameterizedTest
    @CsvSource("false,false", "false,true", "true,false", "true,true")
    fun failuresBeforeTransportReleaseRetainedStreams(async: Boolean, workload: Boolean) {
        val streams = listOf(GuardedStream(byteArrayOf(1), true), GuardedStream(byteArrayOf(2)))
        val failure = IllegalStateException("test token failure")
        val auth = mock<WorkloadIdentityAuth>()
        whenever(auth.getToken()).thenThrow(failure)
        whenever(auth.getTokenAsync())
            .thenReturn(CompletableFuture<String>().apply { completeExceptionally(failure) })
        val params = ImageEditParams.builder().imageOfInputStreams(streams).prompt("test").build()
        var transportCalls = 0
        client(
                configure = {
                    if (workload) it.credential(WorkloadIdentityCredential(auth))
                    else it.adminApiKey("test-admin-key")
                }
            ) {
                transportCalls++
                error("Unexpected transport call")
            }
            .useClient {
                val thrown = catchThrowable {
                    if (async) it.async().images().edit(params).join() else it.images().edit(params)
                }
                val primary = if (thrown is CompletionException) thrown.cause!! else thrown
                if (workload) assertThat(primary).isSameAs(failure)
                else assertThat(primary).hasMessageContaining("requires apiKey or workloadIdentity")
                assertThat(primary.suppressed).hasSize(1)
            }
        assertThat(transportCalls).isZero()
        assertThat(streams.all { it.closed && it.closeCount == 1 }).isTrue()
    }

    @ParameterizedTest
    @CsvSource(
        "false,image,workload",
        "true,image,workload",
        "false,video,workload",
        "true,video,workload",
        "false,streaming,workload",
        "true,streaming,workload",
        "false,skill,workload",
        "true,skill,workload",
        "false,skill-version,workload",
        "true,skill-version,workload",
        "false,image,debug",
        "true,image,debug",
        "false,image,authenticator",
        "true,image,authenticator",
        "false,variation,workload",
        "true,variation,workload",
        "false,variation-close-failure,workload",
        "true,variation-close-failure,workload",
    )
    fun publicCancellationPreventsTransportAfterAuthenticationSucceeds(
        raw: Boolean,
        kind: String,
        authMode: String,
    ) {
        val stream = GuardedStream(byteArrayOf(1), closeFails = kind == "variation-close-failure")
        val tokenStarted = CountDownLatch(1)
        val transportCalls = AtomicInteger()
        val pendingToken = CompletableFuture<String>()
        val auth = mock<WorkloadIdentityAuth>()
        whenever(auth.getTokenAsync()).thenAnswer {
            tokenStarted.countDown()
            pendingToken
        }
        val authenticator = mock<HttpRequestAuthenticator>()
        whenever(authenticator.authenticateAsync(any())).thenAnswer { invocation ->
            tokenStarted.countDown()
            pendingToken.thenApply { invocation.getArgument<HttpRequest>(0) }
        }
        client(
                configure = {
                    if (authMode == "authenticator") it.httpRequestAuthenticator(authenticator)
                    else it.credential(WorkloadIdentityCredential(auth))
                    if (authMode == "debug") it.logLevel(LogLevel.DEBUG)
                }
            ) {
                transportCalls.incrementAndGet()
            }
            .useClient { client ->
                val cancel: () -> Unit =
                    if (kind == "streaming" && !raw) {
                        val params = ImageEditParams.builder().prompt("test").image(stream).build()
                        val response = client.async().images().editStreaming(params)
                        ({
                            response.close()
                            response.onCompleteFuture().get(10, TimeUnit.SECONDS)
                            Unit
                        })
                    } else {
                        val result =
                            if (kind == "skill" || kind == "skill-version") {
                                skillUpload(client, raw, kind, stream)
                            } else if (kind.startsWith("variation")) {
                                val params =
                                    ImageCreateVariationParams.builder().image(stream).build()
                                if (raw)
                                    client
                                        .async()
                                        .images()
                                        .withRawResponse()
                                        .createVariation(params)
                                else client.async().images().createVariation(params)
                            } else if (kind == "video") {
                                val params =
                                    VideoCreateParams.builder()
                                        .prompt("test")
                                        .inputReference(stream)
                                        .build()
                                if (raw) client.async().videos().withRawResponse().create(params)
                                else client.async().videos().create(params)
                            } else {
                                val params =
                                    ImageEditParams.builder().prompt("test").image(stream).build()
                                if (kind == "streaming")
                                    client.async().images().withRawResponse().editStreaming(params)
                                else if (raw) client.async().images().withRawResponse().edit(params)
                                else client.async().images().edit(params)
                            }
                        ({
                            assertThat(result.cancel(true)).isTrue()
                            val failure = catchThrowable { result.join() }
                            assertThat(failure).isInstanceOf(CancellationException::class.java)
                            if (stream.closeFails) {
                                assertThat(failure.suppressed).hasSize(1)
                                assertThat(failure.suppressed[0]).hasMessage("test close failure")
                            }
                        })
                    }
                try {
                    assertThat(tokenStarted.await(10, TimeUnit.SECONDS)).isTrue()
                    cancel()
                    assertThat(stream.closed).isTrue()
                    assertThat(stream.closeCount).isEqualTo(1)
                } finally {
                    pendingToken.complete("test-token")
                }
                assertThat(transportCalls.get()).isZero()
                assertThat(stream.closeCount).isEqualTo(1)
            }
    }

    @ParameterizedTest
    @CsvSource(
        "false,image",
        "true,image",
        "false,skill",
        "true,skill",
        "false,skill-version",
        "true,skill-version",
    )
    fun cancelledPublicUploadsCloseLateResponses(raw: Boolean, kind: String) {
        val stream = GuardedStream(byteArrayOf(1))
        val pendingResponse = CompletableFuture<HttpResponse>()
        val started = CountDownLatch(1)
        val closed = CountDownLatch(1)
        val closes = AtomicInteger()
        val params = ImageEditParams.builder().prompt("test").image(stream).build()
        client(asyncResponse = pendingResponse) { started.countDown() }
            .useClient { client ->
                val result =
                    if (kind == "skill" || kind == "skill-version")
                        skillUpload(client, raw, kind, stream)
                    else if (raw) client.async().images().withRawResponse().edit(params)
                    else client.async().images().edit(params)
                assertThat(started.await(10, TimeUnit.SECONDS)).isTrue()
                assertThat(result.cancel(true)).isTrue()
                assertThat(stream.closeCount).isEqualTo(1)
                pendingResponse.complete(
                    object : HttpResponse {
                        override fun statusCode() = 200

                        override fun headers() = Headers.builder().build()

                        override fun body(): InputStream = "{}".byteInputStream()

                        override fun close() {
                            closes.incrementAndGet()
                            closed.countDown()
                        }
                    }
                )
                assertThat(closed.await(10, TimeUnit.SECONDS)).isTrue()
                assertThat(closes.get()).isEqualTo(1)
            }
    }

    @ParameterizedTest
    @ValueSource(strings = ["skill", "skill-version"])
    fun skillUnionUploadsPreserveNormalAsyncStreaming(kind: String) {
        val stream = DeferredInputStream()
        client { verifyStreaming(it, stream) }
            .useClient { skillUpload(it, false, kind, stream).get(10, TimeUnit.SECONDS) }
    }

    private fun skillUpload(
        client: OpenAIClientImpl,
        raw: Boolean,
        kind: String,
        stream: InputStream,
    ): CompletableFuture<*> =
        if (kind == "skill") {
            val params = SkillCreateParams.builder().files(stream).build()
            if (raw) client.async().skills().withRawResponse().create(params)
            else client.async().skills().create(params)
        } else {
            val params =
                VersionCreateParams.builder()
                    .skillId("skill-test")
                    .filesOfInputStreams(listOf(stream))
                    .build()
            if (raw) client.async().skills().versions().withRawResponse().create(params)
            else client.async().skills().versions().create(params)
        }

    private fun OpenAIClientImpl.useClient(action: (OpenAIClientImpl) -> Unit) {
        try {
            action(this)
        } finally {
            close()
        }
    }

    private fun client(
        mapper: JsonMapper = jsonMapper(),
        configure: (ClientOptions.Builder) -> Unit = { it.apiKey("test-key") },
        asyncResponse: CompletableFuture<HttpResponse>? = null,
        checkBody: (HttpRequestBody) -> Unit,
    ): OpenAIClientImpl =
        OpenAIClientImpl(
            ClientOptions.builder()
                .jsonMapper(mapper)
                .apply(configure)
                .maxRetries(0)
                .httpClient(
                    object : HttpClient {
                        override fun execute(
                            request: HttpRequest,
                            requestOptions: RequestOptions,
                        ): HttpResponse {
                            checkBody(checkNotNull(request.body))
                            return object : HttpResponse {
                                override fun statusCode() = 200

                                override fun headers() = Headers.builder().build()

                                override fun body(): InputStream = "{}".byteInputStream()

                                override fun close() {}
                            }
                        }

                        override fun executeAsync(
                            request: HttpRequest,
                            requestOptions: RequestOptions,
                        ) =
                            asyncResponse?.also { checkBody(checkNotNull(request.body)) }
                                ?: CompletableFuture.completedFuture(
                                    execute(request, requestOptions)
                                )

                        override fun close() {}
                    }
                )
                .build()
        )

    private class GuardedStream(bytes: ByteArray, val closeFails: Boolean = false) :
        FilterInputStream(bytes.inputStream()) {
        var closeCount = 0
        var allowReads = false
        var closed = false

        override fun read(): Int {
            check(allowReads) { "Upload stream was read before writing the HTTP body" }
            return super.read()
        }

        override fun read(bytes: ByteArray, offset: Int, length: Int): Int {
            check(allowReads) { "Upload stream was read before writing the HTTP body" }
            return super.read(bytes, offset, length)
        }

        override fun close() {
            closed = true
            closeCount++
            super.close()
            if (closeFails) error("test close failure")
        }
    }

    private fun verifyStreaming(body: HttpRequestBody, stream: DeferredInputStream) {
        assertThat(stream.bytesRead).isZero()
        assertThat(stream.closed).isFalse()
        assertThat(body.contentLength()).isEqualTo(-1L)
        assertThat(body.repeatable()).isFalse()
        stream.allowReads = true
        body.use { it.writeTo(DiscardingOutputStream()) }
        assertThat(stream.bytesRead).isEqualTo(stream.length)
        assertThat(stream.closed).isTrue()
    }

    private class DeferredInputStream : InputStream() {
        val length = 16 * 1024 * 1024
        var bytesRead = 0
        var allowReads = false
        var closed = false

        override fun read(): Int {
            check(allowReads) { "Upload stream was read before writing the HTTP body" }
            return if (bytesRead == length) -1
            else {
                bytesRead++
                65
            }
        }

        override fun read(bytes: ByteArray, offset: Int, count: Int): Int {
            check(allowReads) { "Upload stream was read before writing the HTTP body" }
            if (count == 0) return 0
            if (bytesRead == length) return -1
            val read = minOf(count, length - bytesRead)
            bytes.fill(65, offset, offset + read)
            bytesRead += read
            return read
        }

        override fun close() {
            closed = true
        }
    }

    private class DiscardingOutputStream : OutputStream() {
        override fun write(value: Int) {}

        override fun write(bytes: ByteArray, offset: Int, count: Int) {}
    }
}
