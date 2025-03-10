// File generated from our OpenAPI spec by Stainless.

package com.openai.models.images

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ImagesResponseTest {

    @Test
    fun createImagesResponse() {
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
        assertThat(imagesResponse).isNotNull
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
}
