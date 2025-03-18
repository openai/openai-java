// File generated from our OpenAPI spec by Stainless.

package com.openai.models.images

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ImageTest {

    @Test
    fun create() {
        val image =
            Image.builder().b64Json("b64_json").revisedPrompt("revised_prompt").url("url").build()

        assertThat(image.b64Json()).contains("b64_json")
        assertThat(image.revisedPrompt()).contains("revised_prompt")
        assertThat(image.url()).contains("url")
    }
}
