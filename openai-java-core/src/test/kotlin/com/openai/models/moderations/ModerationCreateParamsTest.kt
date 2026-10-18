// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.moderations

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ModerationCreateParamsTest {

    @Test
    fun create() {
        ModerationCreateParams.builder()
            .input("...text to classify goes here...")
            .model(ModerationModel.OMNI_MODERATION_2024_09_26)
            .build()
    }

    @Test
    fun body() {
        val params =
            ModerationCreateParams.builder()
                .input("...text to classify goes here...")
                .model(ModerationModel.OMNI_MODERATION_2024_09_26)
                .build()

        val body = params._body()

        assertThat(body.input())
            .isEqualTo(ModerationCreateParams.Input.ofString("...text to classify goes here..."))
        assertThat(body.model()).contains(ModerationModel.OMNI_MODERATION_2024_09_26)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ModerationCreateParams.builder().input("...text to classify goes here...").build()

        val body = params._body()

        assertThat(body.input())
            .isEqualTo(ModerationCreateParams.Input.ofString("...text to classify goes here..."))
    }
}
