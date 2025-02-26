// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.EmbeddingCreateParams
import com.openai.models.EmbeddingModel
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class EmbeddingServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val embeddingServiceAsync = client.embeddings()

        val createEmbeddingResponseFuture =
            embeddingServiceAsync.create(
                EmbeddingCreateParams.builder()
                    .input("The quick brown fox jumped over the lazy dog")
                    .model(EmbeddingModel.TEXT_EMBEDDING_ADA_002)
                    .dimensions(1L)
                    .encodingFormat(EmbeddingCreateParams.EncodingFormat.FLOAT)
                    .user("user-1234")
                    .build()
            )

        val createEmbeddingResponse = createEmbeddingResponseFuture.get()
        createEmbeddingResponse.validate()
    }
}
