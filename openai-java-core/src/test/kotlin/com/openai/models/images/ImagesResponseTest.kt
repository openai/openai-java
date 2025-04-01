// File generated from our OpenAPI spec by Stainless.

package com.openai.models.images

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
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
                .build()

        assertThat(imagesResponse.created()).isEqualTo(0L)
        assertThat(imagesResponse.data())
            .containsExactly(
                Image.builder()
                    .b64Json("b64_json")
                    .revisedPrompt("revised_prompt")
                    .url("url")
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
                .build()

        val roundtrippedImagesResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(imagesResponse),
                jacksonTypeRef<ImagesResponse>(),
            )

        assertThat(roundtrippedImagesResponse).isEqualTo(imagesResponse)
    }
}
