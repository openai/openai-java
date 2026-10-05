package com.openai.core.http

import com.openai.client.OpenAIClientImpl
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import java.io.InputStream
import java.util.concurrent.CompletableFuture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CopiedClientCredentialsTest {
    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun changingCopiedApiKeyReplacesTheCredential(async: Boolean) {
        val headers = mutableListOf<Headers>()
        val transport =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse {
                    headers.add(request.headers)
                    return object : HttpResponse {
                        override fun statusCode() = 200

                        override fun headers() =
                            Headers.builder().put("content-type", "application/json").build()

                        override fun body(): InputStream =
                            """{"id":"model-test","object":"model","created":0,"owned_by":"test"}"""
                                .byteInputStream()

                        override fun close() {}
                    }
                }

                override fun executeAsync(request: HttpRequest, requestOptions: RequestOptions) =
                    CompletableFuture.completedFuture(execute(request, requestOptions))

                override fun close() {}
            }
        val original =
            OpenAIClientImpl(
                ClientOptions.builder().httpClient(transport).apiKey("old-test-key").build()
            )
        val copied = original.withOptions { it.apiKey("new-test-key") }
        if (async) {
            copied.async().models().retrieve("model-test").join()
            original.async().models().retrieve("model-test").join()
        } else {
            copied.models().retrieve("model-test")
            original.models().retrieve("model-test")
        }
        assertThat(headers[0].values("Authorization")).containsExactly("Bearer new-test-key")
        assertThat(headers[1].values("Authorization")).containsExactly("Bearer old-test-key")
    }
}
