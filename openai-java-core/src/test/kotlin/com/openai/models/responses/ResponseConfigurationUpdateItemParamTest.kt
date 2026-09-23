// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.ReasoningEffort
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseConfigurationUpdateItemParamTest {

    @Test
    fun create() {
        val responseConfigurationUpdateItemParam =
            ResponseConfigurationUpdateItemParam.builder()
                .id("cnfu_123")
                .reasoning(
                    ResponseConfigurationUpdateItemParam.Reasoning.builder()
                        .effort(ReasoningEffort.NONE)
                        .build()
                )
                .build()

        assertThat(responseConfigurationUpdateItemParam.id()).contains("cnfu_123")
        assertThat(responseConfigurationUpdateItemParam.reasoning())
            .contains(
                ResponseConfigurationUpdateItemParam.Reasoning.builder()
                    .effort(ReasoningEffort.NONE)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseConfigurationUpdateItemParam =
            ResponseConfigurationUpdateItemParam.builder()
                .id("cnfu_123")
                .reasoning(
                    ResponseConfigurationUpdateItemParam.Reasoning.builder()
                        .effort(ReasoningEffort.NONE)
                        .build()
                )
                .build()

        val roundtrippedResponseConfigurationUpdateItemParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseConfigurationUpdateItemParam),
                jacksonTypeRef<ResponseConfigurationUpdateItemParam>(),
            )

        assertThat(roundtrippedResponseConfigurationUpdateItemParam)
            .isEqualTo(responseConfigurationUpdateItemParam)
    }
}
