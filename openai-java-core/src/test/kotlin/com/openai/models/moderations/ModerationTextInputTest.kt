// File generated from our OpenAPI spec by Stainless.

package com.openai.models.moderations

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ModerationTextInputTest {

    @Test
    fun create() {
        val moderationTextInput = ModerationTextInput.builder().text("I want to kill them").build()

        assertThat(moderationTextInput.text()).isEqualTo("I want to kill them")
    }
}
