package com.openai.client.okhttp

import com.openai.core.RequestOptions
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import java.util.concurrent.TimeUnit
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RedirectCredentialBoundaryTest {

    @Test fun crossOriginRedirectDoesNotForwardAzureApiKey() = checkCrossOriginRedirect(false)

    @Test fun asyncCrossOriginRedirectDoesNotForwardAzureApiKey() = checkCrossOriginRedirect(true)

    private fun checkCrossOriginRedirect(async: Boolean) {
        MockWebServer().use { origin ->
            MockWebServer().use { destination ->
                origin.enqueue(
                    MockResponse()
                        .setResponseCode(302)
                        .setHeader("Location", destination.url("/redirected"))
                )
                destination.enqueue(MockResponse().setBody("ok"))
                val request = request(origin)

                OkHttpClient.builder().build().use { client ->
                    val response =
                        if (async) {
                            client
                                .executeAsync(request, RequestOptions.none())
                                .get(5, TimeUnit.SECONDS)
                        } else {
                            client.execute(request, RequestOptions.none())
                        }
                    response.use { assertThat(it.statusCode()).isEqualTo(200) }
                }

                assertThat(origin.takeRequest(5, TimeUnit.SECONDS)?.getHeader("api-key"))
                    .isEqualTo("test-azure-key")
                val redirected = destination.takeRequest(5, TimeUnit.SECONDS)
                assertThat(redirected).isNotNull()
                assertThat(redirected?.getHeader("api-key")).isNull()
                assertThat(redirected?.getHeader("X-Test")).isEqualTo("retained")
            }
        }
    }

    @Test
    fun sameOriginRedirectKeepsAzureApiKey() {
        MockWebServer().use { origin ->
            origin.enqueue(MockResponse().setResponseCode(302).setHeader("Location", "/redirected"))
            origin.enqueue(MockResponse().setBody("ok"))

            OkHttpClient.builder().build().use { client ->
                client.execute(request(origin), RequestOptions.none()).close()
            }

            assertThat(origin.takeRequest(5, TimeUnit.SECONDS)?.getHeader("api-key"))
                .isEqualTo("test-azure-key")
            assertThat(origin.takeRequest(5, TimeUnit.SECONDS)?.getHeader("api-key"))
                .isEqualTo("test-azure-key")
        }
    }

    @Test
    fun redirectChainKeepsCredentialsWithinOriginalOrigin() {
        MockWebServer().use { origin ->
            MockWebServer().use { destination ->
                origin.enqueue(
                    MockResponse()
                        .setResponseCode(302)
                        .setHeader("Location", destination.url("/redirected"))
                )
                destination.enqueue(
                    MockResponse()
                        .setResponseCode(302)
                        .setHeader("Location", origin.url("/returned"))
                )
                origin.enqueue(MockResponse().setBody("ok"))

                OkHttpClient.builder().build().use { client ->
                    client.execute(request(origin), RequestOptions.none()).close()
                }

                origin.takeRequest(5, TimeUnit.SECONDS)
                assertThat(destination.takeRequest(5, TimeUnit.SECONDS)?.getHeader("api-key"))
                    .isNull()
                assertThat(origin.takeRequest(5, TimeUnit.SECONDS)?.getHeader("api-key"))
                    .isEqualTo("test-azure-key")
            }
        }
    }

    private fun request(origin: MockWebServer): HttpRequest =
        HttpRequest.builder()
            .method(HttpMethod.GET)
            .baseUrl(origin.url("/original").toString())
            .putHeader("Api-Key", "test-azure-key")
            .putHeader("X-Test", "retained")
            .build()
}
