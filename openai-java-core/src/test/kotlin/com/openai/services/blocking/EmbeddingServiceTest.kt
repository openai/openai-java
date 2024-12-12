// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.EmbeddingCreateParams
import com.openai.models.EmbeddingModel
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class EmbeddingServiceTest {

    @Test
    fun callCreate() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val embeddingService = client.embeddings()
        val createEmbeddingResponse =
            embeddingService.create(
                EmbeddingCreateParams.builder()
                    .input(
                        EmbeddingCreateParams.Input.ofString(
                            "The quick brown fox jumped over the lazy dog"
                        )
                    )
                    .model(EmbeddingModel.TEXT_EMBEDDING_ADA_002)
                    .dimensions(1L)
                    .encodingFormat(EmbeddingCreateParams.EncodingFormat.FLOAT)
                    .user("user-1234")
                    .build()
            )
        println(createEmbeddingResponse)
        createEmbeddingResponse.validate()
    }
}
