package com.openai.client.okhttp

import com.openai.client.OpenAIClient
import com.openai.errors.InvalidResourceIdException
import com.openai.models.beta.threads.messages.MessageDeleteParams
import com.openai.models.beta.threads.runs.RunCreateParams
import java.util.concurrent.ExecutionException
import java.util.concurrent.TimeUnit
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.assertThrows

internal class ResourcePathValidationTest {
    @TestFactory
    fun rejectsInvalidParentAndFinalIds() =
        listOf(false, true).flatMap { async ->
            listOf("", ".", "..").flatMap { id ->
                listOf(id to "message-ok", "thread-ok" to id).map { (thread, message) ->
                    dynamicTest("async=$async thread=$thread message=$message") {
                        withClient { client, server ->
                            val params = params(thread, message)
                            if (async) {
                                // The call itself must return normally, before observing its
                                // failure.
                                val future =
                                    client.async().beta().threads().messages().delete(params)
                                assertThat(
                                        assertThrows<ExecutionException> {
                                                future.get(5, TimeUnit.SECONDS)
                                            }
                                            .cause
                                    )
                                    .isInstanceOf(InvalidResourceIdException::class.java)
                            } else {
                                assertThrows<InvalidResourceIdException> {
                                    client.beta().threads().messages().delete(params)
                                }
                            }
                            assertThat(server.requestCount).isZero()
                        }
                    }
                }
            }
        }

    @TestFactory
    fun emptyIdsCannotSelectDifferentEndpoints() =
        listOf(false, true).map { async ->
            dynamicTest("file content and thread run aliases async=$async") {
                withClient { client, server ->
                    val run = RunCreateParams.builder().threadId("").assistantId("test").build()
                    if (async) {
                        val content = client.async().files().content("")
                        val creation = client.async().beta().threads().runs().create(run)
                        for (future in listOf(content, creation)) {
                            assertThat(
                                    assertThrows<ExecutionException> {
                                            future.get(5, TimeUnit.SECONDS)
                                        }
                                        .cause
                                )
                                .isInstanceOf(InvalidResourceIdException::class.java)
                        }
                    } else {
                        assertThrows<InvalidResourceIdException> {
                            client.files().content("").use {}
                        }
                        assertThrows<InvalidResourceIdException> {
                            client.beta().threads().runs().create(run)
                        }
                    }
                    assertThat(server.requestCount).isZero()
                }
            }
        }

    @TestFactory
    fun acceptedIdsKeepTheirLiteralIdentityOnWire() =
        listOf(
                "message-ok" to "message-ok",
                "file.txt" to "file.txt",
                "..." to "...",
                "%2e" to "%252e",
                "%2E%2e" to "%252E%252e",
                ".%2e" to ".%252e",
                "%2e." to "%252e.",
                "%252e" to "%25252e",
                "%2f" to "%252f",
                "%5c" to "%255c",
                "a/b" to "a%2Fb",
                "../other" to "..%2Fother",
                "a/../b" to "a%2F..%2Fb",
                "..\\other" to "..%5Cother",
                "\\.." to "%5C..",
                "/" to "%2F",
                "//" to "%2F%2F",
                "a?b" to "a%3Fb",
                "a#b" to "a%23b",
                "+" to "+",
                " " to "%20",
                " ." to "%20.",
                ".. " to "..%20",
                "\t.." to "%09..",
                "..\n" to "..%0A",
                "\r.." to "%0D..",
                "\u0000" to "%00",
                ".\u007f" to ".%7F",
                "\uFF0E" to "%EF%BC%8E",
                "\u2024" to "%E2%80%A4",
                "café" to "caf%C3%A9",
            )
            .map { (id, encoded) ->
                dynamicTest("literal ID ${id.toCharArray().map { it.code }}") {
                    withClient { client, server ->
                        val params = params(id, id)
                        assertThat(client.beta().threads().messages().delete(params).deleted())
                            .isTrue()
                        assertThat(
                                client
                                    .async()
                                    .beta()
                                    .threads()
                                    .messages()
                                    .delete(params)
                                    .get(5, TimeUnit.SECONDS)
                                    .deleted()
                            )
                            .isTrue()
                        repeat(2) {
                            val request = server.takeRequest(5, TimeUnit.SECONDS)!!
                            assertThat(request.method).isEqualTo("DELETE")
                            assertThat(request.path)
                                .isEqualTo("/v1/threads/$encoded/messages/$encoded")
                            assertThat(request.requestUrl!!.pathSegments)
                                .containsExactly("v1", "threads", id, "messages", id)
                            assertThat(request.requestUrl!!.query).isNull()
                        }
                        assertThat(server.requestCount).isEqualTo(2)
                    }
                }
            }

    private fun params(thread: String, message: String) =
        MessageDeleteParams.builder().threadId(thread).messageId(message).build()

    private fun withClient(block: (OpenAIClient, MockWebServer) -> Unit) {
        MockWebServer().use { server ->
            repeat(2) {
                server.enqueue(
                    MockResponse()
                        .setHeader("Content-Type", "application/json")
                        .setBody("""{"id":"ok","deleted":true,"object":"thread.message.deleted"}""")
                )
            }
            val client =
                OpenAIOkHttpClient.builder()
                    .apiKey("test-key")
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
