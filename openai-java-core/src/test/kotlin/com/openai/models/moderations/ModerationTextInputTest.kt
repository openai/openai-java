// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.moderations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ModerationTextInputTest {

    @Test
    fun createAndRoundtrip() {
        val moderationTextInput =
            ModerationTextInput.builder().text("...text to classify goes here...").build()

        assertThat(moderationTextInput.text()).isEqualTo("...text to classify goes here...")

        val jsonMapper = jsonMapper()

        val roundtrippedModerationTextInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(moderationTextInput),
                jacksonTypeRef<ModerationTextInput>(),
            )

        assertThat(roundtrippedModerationTextInput).isEqualTo(moderationTextInput)
    }
}
