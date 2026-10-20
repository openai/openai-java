package com.openai.client.okhttp

import com.openai.client.OpenAIClient
import com.openai.credential.BearerTokenCredential
import com.openai.credential.Credential
import com.openai.errors.InvalidResourceIdException
import com.openai.models.containers.files.FileCreateParams
import java.io.FileInputStream
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.util.concurrent.CountDownLatch
import java.util.concurrent.ExecutionException
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger
import java.util.function.Supplier
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.io.TempDir

internal class UploadResourcePathValidationTest {
    @TempDir lateinit var directory: Path

    @TestFactory
    fun rejectedUploadsCloseBeforeReturningWithoutAcquiringCredentials() =
        listOf(false, true).flatMap { async ->
            listOf(false, true).map { throwingClose ->
                dynamicTest("async=$async throwingClose=$throwingClose") {
                    val cleanupFailure = IOException("test close failure")
                    val stream =
                        object : FileInputStream(uploadFile().toFile()) {
                            override fun close() {
                                super.close()
                                if (throwingClose) throw cleanupFailure
                            }
                        }
                    val tokenCalls = AtomicInteger()
                    val credential =
                        BearerTokenCredential.create(
                            Supplier<String> {
                                tokenCalls.incrementAndGet()
                                error("credential unavailable")
                            }
                        )
                    try {
                        withClient(credential) { client, server ->
                            val params =
                                FileCreateParams.builder().containerId(".").file(stream).build()
                            val failure =
                                if (async) {
                                    val future = client.async().containers().files().create(params)
                                    assertThrows<ExecutionException> {
                                            future.get(5, TimeUnit.SECONDS)
                                        }
                                        .cause!!
                                } else {
                                    assertThrows<InvalidResourceIdException> {
                                        client.containers().files().create(params)
                                    }
                                }
                            assertThat(failure).isInstanceOf(InvalidResourceIdException::class.java)
                            assertThat(tokenCalls.get()).isZero()
                            assertThat(server.requestCount).isZero()
                            // Check ownership before either the client or test closes the file.
                            assertThat(stream.channel.isOpen).isFalse()
                            assertThrows<IOException> { stream.read() }
                            if (throwingClose) {
                                assertThat(failure.suppressed).containsExactly(cleanupFailure)
                            } else {
                                assertThat(failure.suppressed).isEmpty()
                            }
                        }
                    } finally {
                        // Release the real descriptor even when a regression leaves it open.
                        try {
                            stream.close()
                        } catch (_: IOException) {}
                    }
                }
            }
        }

    @TestFactory
    fun callerCanRetrySameUploadAfterCredentialFailure() =
        listOf(false, true).map { async ->
            dynamicTest("credential failure preserves stream async=$async") {
                val closed = CountDownLatch(1)
                val stream =
                    object : FileInputStream(uploadFile().toFile()) {
                        override fun close() {
                            super.close()
                            closed.countDown()
                        }
                    }
                stream.use {
                    val failNextToken = AtomicBoolean(true)
                    val authFailure = IllegalStateException("temporary credential failure")
                    val credential =
                        BearerTokenCredential.create(
                            Supplier {
                                if (failNextToken.getAndSet(false)) throw authFailure
                                "test-token"
                            }
                        )
                    withClient(credential) { client, server ->
                        val params =
                            FileCreateParams.builder()
                                .containerId("container-ok")
                                .file(stream)
                                .build()
                        val send = {
                            if (async)
                                client
                                    .async()
                                    .containers()
                                    .files()
                                    .create(params)
                                    .get(5, TimeUnit.SECONDS)
                            else client.containers().files().create(params)
                        }
                        // Even an async client preserves the existing synchronous credential error.
                        assertThat(assertThrows<IllegalStateException> { send() })
                            .isSameAs(authFailure)
                        assertThat(stream.channel.isOpen).isTrue()
                        assertThat(stream.channel.position()).isZero()
                        assertThat(server.requestCount).isZero()

                        assertThat(send().id()).isEqualTo("file-ok")
                        val request = server.takeRequest(5, TimeUnit.SECONDS)!!
                        assertThat(request.method).isEqualTo("POST")
                        assertThat(request.path).isEqualTo("/v1/containers/container-ok/files")
                        assertThat(request.body.readUtf8()).contains("original upload bytes")
                        assertThat(server.requestCount).isEqualTo(1)
                        assertThat(closed.await(5, TimeUnit.SECONDS)).isTrue()
                        assertThat(stream.channel.isOpen).isFalse()
                    }
                }
            }
        }

    private fun uploadFile(): Path =
        Files.createTempFile(directory, "upload", ".txt").also {
            Files.write(it, "original upload bytes".toByteArray())
        }

    private fun withClient(credential: Credential, block: (OpenAIClient, MockWebServer) -> Unit) {
        MockWebServer().use { server ->
            server.enqueue(
                MockResponse()
                    .setHeader("Content-Type", "application/json")
                    .setBody(
                        """{"id":"file-ok","bytes":21,"container_id":"container-ok","created_at":1,"object":"container.file","path":"upload.txt","source":"user"}"""
                    )
            )
            val client =
                OpenAIOkHttpClient.builder()
                    .credential(credential)
                    .baseUrl(server.url("/v1/").toString())
                    .maxRetries(0)
                    .build()
            try {
                block(client, server)
            } finally {
                client.close()
            }
        }
    }
}
