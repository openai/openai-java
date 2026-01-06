// File generated from our OpenAPI spec by Stainless.

package com.openai.models.moderations

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ModerationCreateParamsTest {

    @Test
    fun create() {
        ModerationCreateParams.builder()
            .input("I want to kill them.")
            .model(ModerationModel.of("string"))
            .build()
    }

    @Test
    fun body() {
        val params =
            ModerationCreateParams.builder()
                .input("I want to kill them.")
                .model(ModerationModel.of("string"))
                .build()

        val body = params._body()

        assertThat(body.input())
            .isEqualTo(ModerationCreateParams.Input.ofString("I want to kill them."))
        assertThat(body.model()).contains(ModerationModel.of("string"))
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ModerationCreateParams.builder().input("I want to kill them.").build()

        val body = params._body()

        assertThat(body.input())
            .isEqualTo(ModerationCreateParams.Input.ofString("I want to kill them."))
    }
}
