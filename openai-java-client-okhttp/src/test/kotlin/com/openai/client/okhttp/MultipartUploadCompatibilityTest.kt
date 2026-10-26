package com.openai.client.okhttp

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.openai.core.jsonMapper
import com.openai.models.containers.files.FileCreateParams
import com.openai.models.images.ImageEditParams
import java.io.ByteArrayInputStream
import java.io.IOException
import java.nio.file.Path
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicReference
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.io.TempDir

internal class MultipartUploadCompatibilityTest {
    @TempDir lateinit var directory: Path

    @TestFactory
    fun aliasedInputsAreClosedOnceAfterConstructionFails() =
        listOf(false, true).map { async ->
            dynamicTest("aliased union and mask inputs async=$async") {
                val original = IOException("aliased input close failed")
                withUploadFixture(
                    directory,
                    FileBehavior(closeFailure = original),
                    FileBehavior(),
                ) { files, server ->
                    server.enqueue(imageResponse())
                    val params =
                        ImageEditParams.builder()
                            .imageOfInputStreams(listOf(files[0], files[0], files[1]))
                            .mask(files[0])
                            .prompt("alias probe")
                            .build()
                    val failure = assertThrows<RuntimeException> { edit(async, server, params) }
                    assertThat(failure.message).contains(original.message)
                    assertClosedOnce(files)
                    assertThat(server.requestCount).isZero()
                }
            }
        }

    @TestFactory
    fun distinctEqualInputsAreAllClosedAfterConstructionFails() =
        listOf(false, true).map { async ->
            dynamicTest("equal but distinct inputs async=$async") {
                val original = IOException("first equal input close failed")
                withUploadFixture(
                    directory,
                    FileBehavior(closeFailure = original, equalityGroup = "same"),
                    FileBehavior(equalityGroup = "same"),
                ) { files, server ->
                    server.enqueue(imageResponse())
                    assertThat(files[0]).isEqualTo(files[1]).isNotSameAs(files[1])
                    val params =
                        ImageEditParams.builder()
                            .imageOfInputStreams(files)
                            .prompt("equality probe")
                            .build()
                    val failure = assertThrows<RuntimeException> { edit(async, server, params) }
                    assertThat(failure.message).contains(original.message)
                    assertClosedOnce(files)
                    assertThat(server.requestCount).isZero()
                }
            }
        }

    @TestFactory
    fun configuredStreamSubclassSerializerPreservesPayloadAndInvocationCount() =
        listOf(false, true).map { async ->
            dynamicTest("custom subclass serializer succeeds async=$async") {
                withUploadFixture(directory, FileBehavior()) { files, server ->
                    server.enqueue(imageResponse())
                    val calls = AtomicInteger()
                    val mapper =
                        mapperWith(
                            object : JsonSerializer<ObservedFileInputStream>() {
                                override fun serialize(
                                    value: ObservedFileInputStream,
                                    generator: JsonGenerator,
                                    provider: SerializerProvider,
                                ) {
                                    calls.incrementAndGet()
                                    value.use {
                                        generator.writeBinary(
                                            "CUSTOM:${String(it.readBytes(), Charsets.UTF_8)}"
                                                .toByteArray()
                                        )
                                    }
                                }
                            }
                        )
                    val params =
                        ImageEditParams.builder()
                            .image(files.single())
                            .prompt("custom success")
                            .build()
                    edit(async, server, params, mapper)

                    val request = server.takeRequest(5, TimeUnit.SECONDS)!!
                    assertThat(request.path).isEqualTo("/v1/images/edits")
                    assertThat(partPayload(request, "image")).isEqualTo("CUSTOM:file 0 payload")
                    assertThat(calls.get()).isEqualTo(1)
                    assertClosedOnce(files)
                    assertThat(server.requestCount).isEqualTo(1)
                }
            }
        }

    @TestFactory
    fun customSerializerFailureBeforeReadingReleasesAllInputs() =
        listOf(false, true).map { async ->
            dynamicTest("custom serializer fails before reading async=$async") {
                withUploadFixture(directory, FileBehavior(), FileBehavior(), FileBehavior()) {
                    files,
                    server ->
                    server.enqueue(imageResponse())
                    val calls = AtomicInteger()
                    val mapper =
                        mapperWith(
                            object : JsonSerializer<ObservedFileInputStream>() {
                                override fun serialize(
                                    value: ObservedFileInputStream,
                                    generator: JsonGenerator,
                                    provider: SerializerProvider,
                                ) {
                                    calls.incrementAndGet()
                                    throw IOException("custom serializer refused before reading")
                                }
                            }
                        )
                    val params =
                        ImageEditParams.builder()
                            .imageOfInputStreams(files.take(2))
                            .mask(files[2])
                            .prompt("custom failure")
                            .build()
                    val failure =
                        assertThrows<RuntimeException> { edit(async, server, params, mapper) }
                    assertThat(failure.message).contains("custom serializer refused before reading")
                    assertThat(calls.get()).isEqualTo(1)
                    files.forEach { assertThat(it.readCalls.get()).isZero() }
                    assertClosedOnce(files)
                    assertThat(server.requestCount).isZero()
                }
            }
        }

    @TestFactory
    fun directByteArrayUploadsRemainReplayable() =
        listOf(false, true).map { async ->
            dynamicTest("direct byte array upload retries async=$async") {
                MockWebServer().use { server ->
                    server.enqueue(
                        MockResponse()
                            .setResponseCode(429)
                            .setHeader("retry-after-ms", "1")
                            .setHeader("Content-Type", "application/json")
                            .setBody("""{"error":{"message":"retry","type":"rate_limit_error"}}""")
                    )
                    server.enqueue(
                        MockResponse()
                            .setHeader("Content-Type", "application/json")
                            .setBody(
                                """{"id":"file-ok","bytes":18,"container_id":"container-ok","created_at":1,"object":"container.file","path":"upload.txt","source":"user"}"""
                            )
                    )
                    val params =
                        FileCreateParams.builder()
                            .containerId("container-ok")
                            .file(ByteArrayInputStream("byte-array payload".toByteArray()))
                            .build()
                    val client =
                        OpenAIOkHttpClient.builder()
                            .apiKey("test-key")
                            .baseUrl(server.url("/v1/").toString())
                            .maxRetries(1)
                            .build()
                    try {
                        val result =
                            if (async) {
                                client
                                    .async()
                                    .containers()
                                    .files()
                                    .create(params)
                                    .get(5, TimeUnit.SECONDS)
                            } else client.containers().files().create(params)
                        assertThat(result.id()).isEqualTo("file-ok")
                        val requests = List(2) { server.takeRequest(5, TimeUnit.SECONDS)!! }
                        requests.forEach {
                            assertThat(it.path).isEqualTo("/v1/containers/container-ok/files")
                            assertThat(it.getHeader("Transfer-Encoding")).isNull()
                            assertThat(it.getHeader("Content-Length")!!.toLong()).isPositive()
                        }
                        val bodies = requests.map { it.body.readUtf8() }
                        assertThat(bodies[0]).isEqualTo(bodies[1]).contains("byte-array payload")
                        assertThat(server.requestCount).isEqualTo(2)
                    } finally {
                        client.close()
                    }
                }
            }
        }

    @TestFactory
    fun reentrantSerializerFailurePreservesOuterCleanup() =
        listOf(false, true).map { async ->
            dynamicTest("reentrant serializer restores outer cleanup async=$async") {
                withUploadFixture(
                    directory,
                    FileBehavior(closeFailure = IOException("outer image close failed")),
                    FileBehavior(),
                    FileBehavior(closeFailure = IOException("inner image close failed")),
                ) { files, server ->
                    server.enqueue(imageResponse())
                    val innerFailure = AtomicReference<RuntimeException>()
                    val calls = AtomicInteger()
                    val module =
                        SimpleModule()
                            .addSerializer(
                                ImageEditParams.Image::class.java,
                                object : JsonSerializer<ImageEditParams.Image>() {
                                    override fun serialize(
                                        value: ImageEditParams.Image,
                                        generator: JsonGenerator,
                                        provider: SerializerProvider,
                                    ) {
                                        calls.incrementAndGet()
                                        val innerParams =
                                            ImageEditParams.builder()
                                                .image(files[2])
                                                .prompt("inner failure")
                                                .build()
                                        innerFailure.set(
                                            assertThrows<RuntimeException> {
                                                edit(false, server, innerParams)
                                            }
                                        )
                                        generator.writeObject(value.asInputStream())
                                    }
                                },
                            )
                    val mapper =
                        bufferingUploadMapper().copy().also {
                            // The model selects its default serializer by annotation. A
                            // caller mix-in lets the configured module replace that choice.
                            it.addMixIn(
                                ImageEditParams.Image::class.java,
                                UseConfiguredImageSerializer::class.java,
                            )
                            it.registerModule(module)
                        }
                    val outerParams =
                        ImageEditParams.builder()
                            .image(files[0])
                            .mask(files[1])
                            .prompt("outer failure")
                            .build()
                    val failure =
                        assertThrows<RuntimeException> { edit(async, server, outerParams, mapper) }
                    assertThat(failure.message).contains("outer image close failed")
                    assertThat(calls.get()).isEqualTo(1)
                    assertThat(innerFailure.get()).isNotNull()
                    assertThat(innerFailure.get().message).contains("inner image close failed")
                    assertClosedOnce(files)
                    assertThat(server.requestCount).isZero()
                }
            }
        }

    @Test
    fun concurrentConstructionFailuresKeepTheirCleanupIndependent() {
        val bothConstructing = CountDownLatch(2)
        val firstFinished = CountDownLatch(1)
        withUploadFixture(
            directory,
            FileBehavior(
                closeFailure = IOException("first concurrent image close failed"),
                beforeClose = {
                    bothConstructing.countDown()
                    check(bothConstructing.await(5, TimeUnit.SECONDS)) {
                        "Both uploads must reach stream closure"
                    }
                },
            ),
            FileBehavior(),
            FileBehavior(
                closeFailure = IOException("second concurrent image close failed"),
                beforeClose = {
                    bothConstructing.countDown()
                    check(firstFinished.await(5, TimeUnit.SECONDS)) {
                        "The first upload must finish while the second is still constructing"
                    }
                },
            ),
            FileBehavior(),
        ) { files, server ->
            repeat(2) { server.enqueue(imageResponse()) }
            server.start()
            val firstParams =
                ImageEditParams.builder()
                    .image(files[0])
                    .mask(files[1])
                    .prompt("first concurrent upload")
                    .build()
            val secondParams =
                ImageEditParams.builder()
                    .image(files[2])
                    .mask(files[3])
                    .prompt("second concurrent upload")
                    .build()
            val executor = Executors.newFixedThreadPool(2)
            try {
                val first =
                    executor.submit<RuntimeException> {
                        try {
                            assertThrows<RuntimeException> { edit(false, server, firstParams) }
                        } finally {
                            firstFinished.countDown()
                        }
                    }
                val second =
                    executor.submit<RuntimeException> {
                        assertThrows<RuntimeException> { edit(false, server, secondParams) }
                    }
                assertThat(first.get(10, TimeUnit.SECONDS).message)
                    .contains("first concurrent image close failed")
                assertThat(second.get(10, TimeUnit.SECONDS).message)
                    .contains("second concurrent image close failed")
                assertClosedOnce(files)
                assertThat(server.requestCount).isZero()
            } finally {
                firstFinished.countDown()
                executor.shutdownNow()
                check(executor.awaitTermination(5, TimeUnit.SECONDS)) {
                    "Concurrent upload workers did not stop"
                }
            }
        }
    }

    private fun edit(
        async: Boolean,
        server: MockWebServer,
        params: ImageEditParams,
        mapper: JsonMapper = bufferingUploadMapper(),
    ) {
        val client =
            OpenAIOkHttpClient.builder()
                .apiKey("test-key")
                .baseUrl(server.url("/v1/").toString())
                .jsonMapper(mapper)
                .maxRetries(0)
                .build()
        try {
            val result =
                if (async) client.async().images().edit(params).get(5, TimeUnit.SECONDS)
                else client.images().edit(params)
            assertThat(result.created()).isEqualTo(1L)
        } finally {
            client.close()
        }
    }

    private fun mapperWith(serializer: JsonSerializer<ObservedFileInputStream>): JsonMapper =
        jsonMapper().copy().also {
            it.registerModule(
                SimpleModule().addSerializer(ObservedFileInputStream::class.java, serializer)
            )
        }

    private fun partPayload(request: RecordedRequest, name: String): String {
        val boundary = request.getHeader("Content-Type")!!.substringAfter("boundary=")
        val part =
            request.body.readUtf8().split("--$boundary").single {
                it.substringBefore("\r\n\r\n").contains("name=\"$name\"")
            }
        return part.substringAfter("\r\n\r\n").removeSuffix("\r\n")
    }

    private fun imageResponse() =
        MockResponse()
            .setHeader("Content-Type", "application/json")
            .setBody("""{"created":1,"data":[]}""")

    private fun assertClosedOnce(files: List<ObservedFileInputStream>) {
        files.forEach {
            assertThat(it.channel.isOpen).isFalse()
            assertThat(it.closeCalls.get()).isEqualTo(1)
        }
    }

    @JsonSerialize(using = JsonSerializer.None::class)
    private abstract class UseConfiguredImageSerializer
}
