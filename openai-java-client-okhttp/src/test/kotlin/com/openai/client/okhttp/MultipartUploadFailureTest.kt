package com.openai.client.okhttp

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.openai.azure.AzureUrlPathMode
import com.openai.client.OpenAIClient
import com.openai.client.OpenAIClientAsync
import com.openai.models.images.ImageEditParams
import com.openai.models.skills.SkillCreateParams
import com.openai.models.skills.versions.VersionCreateParams
import com.openai.models.videos.VideoCreateParams
import com.openai.models.videos.VideoEditParams
import com.openai.models.videos.VideoExtendParams
import com.openai.models.videos.VideoSeconds
import java.io.FileInputStream
import java.io.IOException
import java.nio.file.Path
import java.util.ArrayDeque
import java.util.Collections
import java.util.IdentityHashMap
import java.util.concurrent.atomic.AtomicInteger
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.io.TempDir

@Suppress("DEPRECATION")
internal class MultipartUploadFailureTest {
    @TempDir lateinit var directory: Path

    @TestFactory
    fun failureClosingOneNestedFileReleasesTheRemainingFiles() =
        listOf(false, true).map { async ->
            dynamicTest("nested close failure async=$async") {
                val firstCloseFailure = IOException("first file close failed")
                withUploadFixture(
                    directory,
                    FileBehavior(closeFailure = firstCloseFailure),
                    FileBehavior(),
                ) { files, server ->
                    server.enqueue(MockResponse().setResponseCode(500))
                    val params =
                        VersionCreateParams.builder()
                            .skillId("skill-ok")
                            .filesOfInputStreams(files)
                            .build()
                    val failure =
                        failsDuringCall(
                            async,
                            server,
                            syncCall = { it.skills().versions().create(params) },
                            asyncCall = { it.skills().versions().create(params) },
                        )

                    assertPrimaryFailure(failure, firstCloseFailure)
                    assertThat(server.requestCount).isZero()
                    files.forEach { assertThat(it.channel.isOpen).isFalse() }
                }
            }
        }

    @TestFactory
    fun readFailureStaysPrimaryWhenSeveralFilesFailToClose() =
        listOf(false, true).map { async ->
            dynamicTest("nested read and cleanup failures async=$async") {
                val readFailure = IOException("first file read failed")
                val firstCloseFailure = IOException("first file close failed")
                val laterCloseFailure = IOException("second file close failed")
                withUploadFixture(
                    directory,
                    FileBehavior(readFailure = readFailure, closeFailure = firstCloseFailure),
                    FileBehavior(closeFailure = laterCloseFailure),
                    FileBehavior(),
                ) { files, server ->
                    server.enqueue(MockResponse().setResponseCode(500))
                    val params =
                        VersionCreateParams.builder()
                            .skillId("skill-ok")
                            .filesOfInputStreams(files)
                            .build()
                    val failure =
                        failsDuringCall(
                            async,
                            server,
                            syncCall = { it.skills().versions().create(params) },
                            asyncCall = { it.skills().versions().create(params) },
                        )

                    assertPrimaryFailure(failure, readFailure)
                    assertThat(suppressedFailures(failure))
                        .contains(firstCloseFailure, laterCloseFailure)
                    assertThat(server.requestCount).isZero()
                    files.forEach { assertThat(it.channel.isOpen).isFalse() }
                }
            }
        }

    @TestFactory
    fun imageSerializationFailureReleasesTheMask() =
        listOf(false, true).map { async ->
            dynamicTest("image close failure async=$async") {
                val imageCloseFailure = IOException("image close failed")
                withUploadFixture(
                    directory,
                    FileBehavior(closeFailure = imageCloseFailure),
                    FileBehavior(),
                ) { files, server ->
                    server.enqueue(MockResponse().setResponseCode(500))
                    val params =
                        ImageEditParams.builder()
                            .model("ordinary-model")
                            .image(files[0])
                            .mask(files[1])
                            .prompt("test image")
                            .build()
                    val failure =
                        failsDuringCall(
                            async,
                            server,
                            azureLegacy = true,
                            syncCall = { it.images().edit(params) },
                            asyncCall = { it.images().edit(params) },
                        )

                    assertPrimaryFailure(failure, imageCloseFailure)
                    assertThat(server.requestCount).isZero()
                    files.forEach { assertThat(it.channel.isOpen).isFalse() }
                }
            }
        }

    @TestFactory
    fun failedSkillCreationReleasesEveryFile() =
        listOf(false, true).map { async ->
            dynamicTest("skill creation close failure async=$async") {
                val firstCloseFailure = IOException("first skill file close failed")
                withUploadFixture(
                    directory,
                    FileBehavior(closeFailure = firstCloseFailure),
                    FileBehavior(),
                ) { files, server ->
                    server.enqueue(MockResponse().setResponseCode(500))
                    val params = SkillCreateParams.builder().filesOfInputStreams(files).build()
                    val failure =
                        failsDuringCall(
                            async,
                            server,
                            syncCall = { it.skills().create(params) },
                            asyncCall = { it.skills().create(params) },
                        )

                    assertPrimaryFailure(failure, firstCloseFailure)
                    assertThat(server.requestCount).isZero()
                    files.forEach { assertThat(it.channel.isOpen).isFalse() }
                }
            }
        }

    @TestFactory
    fun failedImageListSerializationReleasesTheRemainingImageAndMask() =
        listOf(false, true).map { async ->
            dynamicTest("image list failure async=$async") {
                val imageCloseFailure = IOException("first image close failed")
                withUploadFixture(
                    directory,
                    FileBehavior(closeFailure = imageCloseFailure),
                    FileBehavior(),
                    FileBehavior(),
                ) { files, server ->
                    server.enqueue(MockResponse().setResponseCode(500))
                    val params =
                        ImageEditParams.builder()
                            .imageOfInputStreams(files.take(2))
                            .mask(files[2])
                            .prompt("test image")
                            .build()
                    val failure =
                        failsDuringCall(
                            async,
                            server,
                            syncCall = { it.images().edit(params) },
                            asyncCall = { it.images().edit(params) },
                        )

                    assertPrimaryFailure(failure, imageCloseFailure)
                    assertThat(server.requestCount).isZero()
                    files.forEach { assertThat(it.channel.isOpen).isFalse() }
                }
            }
        }

    @TestFactory
    fun videoPromptSerializationFailureReleasesTheUnprocessedFile() =
        listOf(false, true).flatMap { async ->
            VideoOperation.values().map { operation ->
                dynamicTest("video $operation prompt failure async=$async") {
                    val promptFailure = IOException("video prompt serialization failed")
                    val serializerCalls = AtomicInteger()
                    val mapper =
                        JsonMapper.builder()
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
                                                if (value == "reject this prompt") {
                                                    serializerCalls.incrementAndGet()
                                                    throw promptFailure
                                                }
                                                generator.writeString(value)
                                            }
                                        },
                                    )
                            )
                            .build()
                    withUploadFixture(directory, FileBehavior()) { files, server ->
                        server.enqueue(MockResponse().setResponseCode(500))
                        val calls = videoCalls(operation, files.single())
                        val failure =
                            failsDuringCall(
                                async,
                                server,
                                mapper = mapper,
                                syncCall = calls.sync,
                                asyncCall = calls.async,
                            )

                        assertPrimaryFailure(failure, promptFailure)
                        assertThat(serializerCalls.get()).isEqualTo(1)
                        assertThat(server.requestCount).isZero()
                        assertThat(files.single().channel.isOpen).isFalse()
                    }
                }
            }
        }

    private enum class VideoOperation {
        CREATE,
        EDIT,
        EXTEND,
    }

    private data class ClientCalls(
        val sync: (OpenAIClient) -> Any?,
        val async: (OpenAIClientAsync) -> Any?,
    )

    private fun videoCalls(operation: VideoOperation, stream: FileInputStream): ClientCalls =
        when (operation) {
            VideoOperation.CREATE -> {
                val params =
                    VideoCreateParams.builder()
                        .prompt("reject this prompt")
                        .inputReference(stream)
                        .build()
                ClientCalls({ it.videos().create(params) }, { it.videos().create(params) })
            }
            VideoOperation.EDIT -> {
                val params =
                    VideoEditParams.builder().prompt("reject this prompt").video(stream).build()
                ClientCalls({ it.videos().edit(params) }, { it.videos().edit(params) })
            }
            VideoOperation.EXTEND -> {
                val params =
                    VideoExtendParams.builder()
                        .prompt("reject this prompt")
                        .seconds(VideoSeconds.of("4"))
                        .video(stream)
                        .build()
                ClientCalls({ it.videos().extend(params) }, { it.videos().extend(params) })
            }
        }

    private fun failsDuringCall(
        async: Boolean,
        server: MockWebServer,
        azureLegacy: Boolean = false,
        mapper: JsonMapper? = bufferingUploadMapper(),
        syncCall: (OpenAIClient) -> Any?,
        asyncCall: (OpenAIClientAsync) -> Any?,
    ): RuntimeException {
        val mode = if (azureLegacy) AzureUrlPathMode.LEGACY else AzureUrlPathMode.AUTO
        return if (async) {
            val client =
                OpenAIOkHttpClientAsync.builder()
                    .apiKey("test-key")
                    .baseUrl(server.url("/v1/").toString())
                    .azureUrlPath(mode)
                    .maxRetries(0)
                    .apply { mapper?.let { jsonMapper(it) } }
                    .build()
            try {
                // Construction failures historically throw before the async call returns a future.
                assertThrows<RuntimeException> { asyncCall(client) }
            } finally {
                client.close()
            }
        } else {
            val client =
                OpenAIOkHttpClient.builder()
                    .apiKey("test-key")
                    .baseUrl(server.url("/v1/").toString())
                    .azureUrlPathMode(mode)
                    .maxRetries(0)
                    .apply { mapper?.let { jsonMapper(it) } }
                    .build()
            try {
                assertThrows<RuntimeException> { syncCall(client) }
            } finally {
                client.close()
            }
        }
    }

    private fun assertPrimaryFailure(failure: Throwable, original: IOException) {
        // JSON serialization may wrap an IOException; its original failure must remain the
        // diagnostic, rather than a later cleanup failure.
        assertThat(failure.message).contains(original.message)
    }

    private fun suppressedFailures(failure: Throwable): List<Throwable> {
        val visited = Collections.newSetFromMap(IdentityHashMap<Throwable, Boolean>())
        val pending = ArrayDeque<Throwable>()
        val suppressed = mutableListOf<Throwable>()
        pending.add(failure)
        while (pending.isNotEmpty()) {
            val current = pending.removeFirst()
            if (!visited.add(current)) continue
            current.cause?.let { pending.add(it) }
            current.suppressed.forEach {
                suppressed.add(it)
                pending.add(it)
            }
        }
        return suppressed
    }
}
