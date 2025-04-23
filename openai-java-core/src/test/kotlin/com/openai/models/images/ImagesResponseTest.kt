// File generated from our OpenAPI spec by Stainless.

package com.openai.models.images

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ImagesResponseTest {

    @Test
    fun create() {
        val imagesResponse =
            ImagesResponse.builder()
                .created(0L)
                .addData(
                    Image.builder()
                        .b64Json("b64_json")
                        .revisedPrompt("revised_prompt")
                        .url("url")
                        .build()
                )
                .usage(
                    ImagesResponse.Usage.builder()
                        .inputTokens(0L)
                        .inputTokensDetails(
                            ImagesResponse.Usage.InputTokensDetails.builder()
                                .imageTokens(0L)
                                .textTokens(0L)
                                .build()
                        )
                        .outputTokens(0L)
                        .totalTokens(0L)
                        .build()
                )
                .build()

        assertThat(imagesResponse.created()).isEqualTo(0L)
        assertThat(imagesResponse.data().getOrNull())
            .containsExactly(
                Image.builder()
                    .b64Json("b64_json")
                    .revisedPrompt("revised_prompt")
                    .url("url")
                    .build()
            )
        assertThat(imagesResponse.usage())
            .contains(
                ImagesResponse.Usage.builder()
                    .inputTokens(0L)
                    .inputTokensDetails(
                        ImagesResponse.Usage.InputTokensDetails.builder()
                            .imageTokens(0L)
                            .textTokens(0L)
                            .build()
                    )
                    .outputTokens(0L)
                    .totalTokens(0L)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val imagesResponse =
            ImagesResponse.builder()
                .created(0L)
                .addData(
                    Image.builder()
                        .b64Json("b64_json")
                        .revisedPrompt("revised_prompt")
                        .url("url")
                        .build()
                )
                .usage(
                    ImagesResponse.Usage.builder()
                        .inputTokens(0L)
                        .inputTokensDetails(
                            ImagesResponse.Usage.InputTokensDetails.builder()
                                .imageTokens(0L)
                                .textTokens(0L)
                                .build()
                        )
                        .outputTokens(0L)
                        .totalTokens(0L)
                        .build()
                )
                .build()

        val roundtrippedImagesResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(imagesResponse),
                jacksonTypeRef<ImagesResponse>(),
            )

        assertThat(roundtrippedImagesResponse).isEqualTo(imagesResponse)
    }
}
