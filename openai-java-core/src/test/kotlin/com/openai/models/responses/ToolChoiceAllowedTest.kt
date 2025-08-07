// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ToolChoiceAllowedTest {

    @Test
    fun create() {
        val toolChoiceAllowed =
            ToolChoiceAllowed.builder()
                .mode(ToolChoiceAllowed.Mode.AUTO)
                .addTool(
                    ToolChoiceAllowed.Tool.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .build()

        assertThat(toolChoiceAllowed.mode()).isEqualTo(ToolChoiceAllowed.Mode.AUTO)
        assertThat(toolChoiceAllowed.tools())
            .containsExactly(
                ToolChoiceAllowed.Tool.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val toolChoiceAllowed =
            ToolChoiceAllowed.builder()
                .mode(ToolChoiceAllowed.Mode.AUTO)
                .addTool(
                    ToolChoiceAllowed.Tool.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .build()

        val roundtrippedToolChoiceAllowed =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(toolChoiceAllowed),
                jacksonTypeRef<ToolChoiceAllowed>(),
            )

        assertThat(roundtrippedToolChoiceAllowed).isEqualTo(toolChoiceAllowed)
    }
}
