// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.FunctionDefinition
import com.openai.models.FunctionParameters
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionFunctionToolTest {

    @Test
    fun createAndRoundtrip() {
        val chatCompletionFunctionTool =
            ChatCompletionFunctionTool.builder()
                .function(
                    FunctionDefinition.builder()
                        .name("name")
                        .description("description")
                        .parameters(
                            FunctionParameters.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .strict(true)
                        .build()
                )
                .build()

        assertThat(chatCompletionFunctionTool.function())
            .isEqualTo(
                FunctionDefinition.builder()
                    .name("name")
                    .description("description")
                    .parameters(
                        FunctionParameters.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .strict(true)
                    .build()
            )

        val jsonMapper = jsonMapper()

        val roundtrippedChatCompletionFunctionTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionFunctionTool),
                jacksonTypeRef<ChatCompletionFunctionTool>(),
            )

        assertThat(roundtrippedChatCompletionFunctionTool).isEqualTo(chatCompletionFunctionTool)
    }
}
