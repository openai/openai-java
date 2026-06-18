// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.models.embeddings.EmbeddingCreateParams
import com.openai.models.embeddings.EmbeddingModel
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

internal class EmbeddingServiceAsyncTest {

    @Test
    @ExtendWith(TestServerExtension::class)
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val embeddingServiceAsync = client.embeddings()

        val createEmbeddingResponseFuture =
            embeddingServiceAsync.create(
                EmbeddingCreateParams.builder()
                    .input("The quick brown fox jumped over the lazy dog")
                    .model(EmbeddingModel.TEXT_EMBEDDING_3_SMALL)
                    .dimensions(1L)
                    .encodingFormat(EmbeddingCreateParams.EncodingFormat.FLOAT)
                    .user("user-1234")
                    .build()
            )

        val createEmbeddingResponse = createEmbeddingResponseFuture.get()
        createEmbeddingResponse.validate()
    }

    @Test
    fun create_whenFutureCancelled_cancelsHttpFuture() {
        val httpClient = RecordingHttpClient()
        val embeddingServiceAsync =
            EmbeddingServiceAsyncImpl(
                ClientOptions.builder()
                    .httpClient(httpClient)
                    .baseUrl("http://localhost")
                    .apiKey("My API Key")
                    .build()
            )

        val createEmbeddingResponseFuture =
            embeddingServiceAsync.create(
                EmbeddingCreateParams.builder()
                    .input("The quick brown fox jumped over the lazy dog")
                    .model(EmbeddingModel.TEXT_EMBEDDING_3_SMALL)
                    .build()
            )
        httpClient.requestReceived.get(5, TimeUnit.SECONDS)

        assertThat(createEmbeddingResponseFuture.cancel(false)).isTrue()
        waitUntilCancelled(httpClient.responseFuture)

        assertThat(httpClient.responseFuture).isCancelled()
    }

    private class RecordingHttpClient : HttpClient {
        val responseFuture = CompletableFuture<HttpResponse>()
        val requestReceived = CompletableFuture<Void?>()

        override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
            throw UnsupportedOperationException()
        }

        override fun executeAsync(
            request: HttpRequest,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            requestReceived.complete(null)
            return responseFuture
        }

        override fun close() {}
    }

    private companion object {
        fun waitUntilCancelled(future: CompletableFuture<*>) {
            val deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(5)
            while (!future.isCancelled && System.nanoTime() < deadline) {
                TimeUnit.MILLISECONDS.sleep(10)
            }
        }
    }
}
