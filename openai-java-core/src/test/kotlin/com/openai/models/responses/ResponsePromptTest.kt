// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponsePromptTest {

    @Test
    fun create() {
        val responsePrompt =
            ResponsePrompt.builder()
                .id("id")
                .variables(
                    ResponsePrompt.Variables.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .version("version")
                .build()

        assertThat(responsePrompt.id()).isEqualTo("id")
        assertThat(responsePrompt.variables())
            .contains(
                ResponsePrompt.Variables.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(responsePrompt.version()).contains("version")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responsePrompt =
            ResponsePrompt.builder()
                .id("id")
                .variables(
                    ResponsePrompt.Variables.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .version("version")
                .build()

        val roundtrippedResponsePrompt =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsePrompt),
                jacksonTypeRef<ResponsePrompt>(),
            )

        assertThat(roundtrippedResponsePrompt).isEqualTo(responsePrompt)
    }
}
