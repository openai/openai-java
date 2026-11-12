package com.openai.client.okhttp

import com.openai.azure.AzureUrlPathMode
import com.openai.client.OpenAIClient
import com.openai.client.OpenAIClientAsync
import com.openai.models.images.ImageEditParams
import com.openai.models.skills.SkillCreateParams
import com.openai.models.skills.versions.VersionCreateParams
import java.io.IOException
import java.nio.file.Path
import java.util.ArrayDeque
import java.util.Collections
import java.util.IdentityHashMap
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

    private fun failsDuringCall(
        async: Boolean,
        server: MockWebServer,
        azureLegacy: Boolean = false,
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
                    .jsonMapper(bufferingUploadMapper())
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
                    .jsonMapper(bufferingUploadMapper())
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
