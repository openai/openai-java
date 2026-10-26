package com.openai.core.http

import com.openai.core.MultipartField
import com.openai.core.RequestOptions
import com.openai.core.Sleeper
import com.openai.core.jsonMapper
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

internal class HttpRequestBodyContentTest {

    @Test
    fun jsonContent_canBeReadAgainAfterClosingAnEarlierStream() {
        val body = json(jsonMapper(), mapOf("message" to "hello 🌍"))
        val expected = ByteArrayOutputStream().also(body::writeTo).toByteArray()

        repeat(2) { body.content().use { assertThat(it.readBytes()).isEqualTo(expected) } }
        assertThat(body.repeatable()).isTrue()
        assertThat(body.contentLength()).isEqualTo(expected.size.toLong())
        body.close()
    }

    @Test
    fun multipartContent_doesNotReadUploadsUntilConsumed() {
        val upload = RecordingInputStream("file contents")
        val body = uploadBody(upload)
        val content = body.content()

        assertThat(upload.readCalls).isZero()
        assertThat(content.read()).isEqualTo('-'.code)
        assertThat(upload.readCalls).isZero()
        assertThat(body.repeatable()).isFalse()
        assertThat(body.contentLength()).isEqualTo(-1L)
        content.close()
        body.close()
        assertThat(upload.closeCalls).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun multipartContent_closesUploadsOnceOnEarlyCloseOrEof(readToEnd: Boolean) {
        val first = RecordingInputStream("one")
        val second = RecordingInputStream("two")
        val body = uploadBody(first, second)
        val content = body.content()

        if (readToEnd)
            assertThat(content.readBytes().toString(Charsets.UTF_8)).contains("one", "two")
        else content.read()
        content.close()
        content.close()
        body.close()
        body.close()

        assertThat(listOf(first.closeCalls, second.closeCalls)).containsExactly(1, 1)
        if (!readToEnd) assertThat(listOf(first.readCalls, second.readCalls)).containsExactly(0, 0)
    }

    @Test
    fun multipartContent_closesSharedUploadOnce() {
        val upload = RecordingInputStream("shared")
        val body = uploadBody(upload, upload)

        body.content().close()
        body.close()

        assertThat(upload.closeCalls).isEqualTo(1)
    }

    @Test
    fun multipartContent_matchesWriteToWithASharedCloseSensitiveUpload() {
        val pushUpload = "shared".byteInputStream().buffered()
        val pullUpload = "shared".byteInputStream().buffered()
        uploadBody(pushUpload, pushUpload).use { pushBody ->
            uploadBody(pullUpload, pullUpload).use { pullBody ->
                val expected =
                    ByteArrayOutputStream()
                        .also(pushBody::writeTo)
                        .toString("UTF-8")
                        .replace(
                            pushBody.contentType()!!.substringAfter("boundary="),
                            pullBody.contentType()!!.substringAfter("boundary="),
                        )

                pullBody.content().use {
                    assertThat(it.readBytes().toString(Charsets.UTF_8)).isEqualTo(expected)
                }
            }
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun multipartContent_attemptsEveryCloseWhenCleanupThrows(sharedFailure: Boolean) {
        val firstFailure = IOException("first close")
        val secondFailure = if (sharedFailure) firstFailure else IOException("second close")
        val first = RecordingInputStream(closeFailure = firstFailure)
        val second = RecordingInputStream(closeFailure = secondFailure)
        val third = RecordingInputStream()
        val body = uploadBody(first, second, third)
        val content = body.content()

        val failure = catchThrowable { content.close() }
        body.close()
        content.close()

        assertThat(failure).isSameAs(firstFailure)
        if (sharedFailure) assertThat(failure.suppressed).isEmpty()
        else assertThat(failure.suppressed).containsExactly(secondFailure)
        assertThat(listOf(first.closeCalls, second.closeCalls, third.closeCalls))
            .containsExactly(1, 1, 1)
    }

    @Test
    fun multipartContent_closeAfterCancellationDoesNotCloseUploadsAgain() {
        val upload = RecordingInputStream()
        val body = uploadBody(upload)
        val content = body.content()

        body.cancelMultipart(java.util.concurrent.CancellationException())
        content.close()
        body.close()

        assertThat(upload.closeCalls).isEqualTo(1)
    }

    @Test
    fun multipartContent_canBeReadAgainAndMixedWithWriteToForRepeatableBodies() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "field\nname" to
                        MultipartField.builder<String>()
                            .value("héllo")
                            .filename("file\".txt")
                            .build(),
                    "binary" to
                        MultipartField.builder<ByteArray>().value(byteArrayOf(0, 1, -1)).build(),
                ),
            )
        val expected = ByteArrayOutputStream().also(body::writeTo).toByteArray()

        repeat(2) { body.content().use { assertThat(it.readBytes()).isEqualTo(expected) } }
        assertThat(ByteArrayOutputStream().also(body::writeTo).toByteArray()).isEqualTo(expected)
        assertThat(body.contentLength()).isEqualTo(expected.size.toLong())
        body.close()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun contentTransport_retriesOnlyRepeatableBodies(repeatable: Boolean) {
        val body =
            if (repeatable) json(jsonMapper(), mapOf("key" to "value"))
            else uploadBody(RecordingInputStream())
        val payloads = mutableListOf<ByteArray>()
        val transport = mock<HttpClient>()
        whenever(transport.execute(any(), any())).thenAnswer { invocation ->
            val request = invocation.getArgument<HttpRequest>(0)
            request.body!!.content().use { payloads.add(it.readBytes()) }
            mock<HttpResponse>().also {
                whenever(it.statusCode()).thenReturn(if (payloads.size == 1) 500 else 200)
                whenever(it.headers()).thenReturn(Headers.builder().build())
            }
        }
        val client =
            RetryingHttpClient.builder()
                .httpClient(transport)
                .sleeper(mock<Sleeper>())
                .maxRetries(1)
                .build()
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .baseUrl("https://example.com")
                .body(body)
                .build()

        client.use { it.execute(request, RequestOptions.none()).close() }
        body.close()

        assertThat(payloads).hasSize(if (repeatable) 2 else 1)
        if (repeatable) assertThat(payloads[1]).isEqualTo(payloads[0])
    }

    private fun uploadBody(vararg inputs: InputStream): HttpRequestBody =
        multipartFormData(
            jsonMapper(),
            inputs
                .mapIndexed { index, input ->
                    "file-$index" to MultipartField.builder<InputStream>().value(input).build()
                }
                .toMap(),
        )

    // A real stream is needed to exercise partial reads and repeated/throwing close calls.
    private class RecordingInputStream(
        text: String = "file",
        private val closeFailure: IOException? = null,
    ) : InputStream() {
        private val delegate = text.byteInputStream()
        var readCalls = 0
        var closeCalls = 0

        override fun read(): Int {
            readCalls++
            return delegate.read()
        }

        override fun close() {
            closeCalls++
            closeFailure?.let { throw it }
        }
    }

    @Test
    fun content_defaultsToWriteTo() {
        val body =
            object : HttpRequestBody {
                override fun writeTo(outputStream: OutputStream) {
                    outputStream.write("body".toByteArray())
                }

                override fun contentType(): String = "text/plain"

                override fun contentLength(): Long = 4L

                override fun repeatable(): Boolean = true

                override fun close() {}
            }

        body.content().use { content ->
            assertThat(content.readBytes()).isEqualTo("body".toByteArray())
        }
    }

    @Test
    fun multipartContent_matchesWriteTo() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "field" to
                        MultipartField.builder<String>()
                            .value("value")
                            .contentType("text/plain")
                            .build(),
                    "binary" to
                        MultipartField.builder<ByteArray>()
                            .value("abc".toByteArray())
                            .contentType("application/octet-stream")
                            .build(),
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        body.content().use { content ->
            assertThat(content.readBytes()).isEqualTo(output.toByteArray())
        }
    }

    @Test
    fun multipartContent_streamsInputStreamParts() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "data" to
                        MultipartField.builder<java.io.InputStream>()
                            .value("stream content".byteInputStream().buffered())
                            .contentType("application/octet-stream")
                            .build()
                ),
            )

        val content = body.content().use { it.readBytes().toString(Charsets.UTF_8) }

        assertThat(body.repeatable()).isFalse()
        assertThat(content).contains("Content-Disposition: form-data; name=\"data\"")
        assertThat(content).contains("Content-Type: application/octet-stream")
        assertThat(content).contains("stream content")
    }
}
