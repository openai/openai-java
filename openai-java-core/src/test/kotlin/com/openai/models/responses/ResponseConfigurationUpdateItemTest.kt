// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.ReasoningEffort
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseConfigurationUpdateItemTest {

    @Test
    fun create() {
        val responseConfigurationUpdateItem =
            ResponseConfigurationUpdateItem.builder()
                .id("cnfu_123")
                .reasoning(
                    ResponseConfigurationUpdateItem.Reasoning.builder()
                        .effort(ReasoningEffort.NONE)
                        .build()
                )
                .build()

        assertThat(responseConfigurationUpdateItem.id()).isEqualTo("cnfu_123")
        assertThat(responseConfigurationUpdateItem.reasoning())
            .contains(
                ResponseConfigurationUpdateItem.Reasoning.builder()
                    .effort(ReasoningEffort.NONE)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseConfigurationUpdateItem =
            ResponseConfigurationUpdateItem.builder()
                .id("cnfu_123")
                .reasoning(
                    ResponseConfigurationUpdateItem.Reasoning.builder()
                        .effort(ReasoningEffort.NONE)
                        .build()
                )
                .build()

        val roundtrippedResponseConfigurationUpdateItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseConfigurationUpdateItem),
                jacksonTypeRef<ResponseConfigurationUpdateItem>(),
            )

        assertThat(roundtrippedResponseConfigurationUpdateItem)
            .isEqualTo(responseConfigurationUpdateItem)
    }
}
