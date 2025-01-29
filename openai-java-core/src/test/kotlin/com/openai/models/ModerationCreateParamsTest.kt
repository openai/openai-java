// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ModerationCreateParamsTest {

    @Test
    fun createModerationCreateParams() {
        ModerationCreateParams.builder()
            .input("I want to kill them.")
            .model(ModerationModel.OMNI_MODERATION_LATEST)
            .build()
    }

    @Test
    fun body() {
        val params =
            ModerationCreateParams.builder()
                .input("I want to kill them.")
                .model(ModerationModel.OMNI_MODERATION_LATEST)
                .build()
        val body = params._body()
        assertThat(body).isNotNull
        assertThat(body.input())
            .isEqualTo(ModerationCreateParams.Input.ofString("I want to kill them."))
        assertThat(body.model()).contains(ModerationModel.OMNI_MODERATION_LATEST)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ModerationCreateParams.builder().input("I want to kill them.").build()
        val body = params._body()
        assertThat(body).isNotNull
        assertThat(body.input())
            .isEqualTo(ModerationCreateParams.Input.ofString("I want to kill them."))
    }
}
