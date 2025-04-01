// File generated from our OpenAPI spec by Stainless.

package com.openai.models.moderations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ModerationTextInputTest {

    @Test
    fun create() {
        val moderationTextInput = ModerationTextInput.builder().text("I want to kill them").build()

        assertThat(moderationTextInput.text()).isEqualTo("I want to kill them")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val moderationTextInput = ModerationTextInput.builder().text("I want to kill them").build()

        val roundtrippedModerationTextInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(moderationTextInput),
                jacksonTypeRef<ModerationTextInput>(),
            )

        assertThat(roundtrippedModerationTextInput).isEqualTo(moderationTextInput)
    }
}
