// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChatCompletionToolTest {

    @Test
    fun createChatCompletionTool() {
        val chatCompletionTool =
            ChatCompletionTool.builder()
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
                .type(ChatCompletionTool.Type.FUNCTION)
                .build()
        assertThat(chatCompletionTool).isNotNull
        assertThat(chatCompletionTool.function())
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
        assertThat(chatCompletionTool.type()).isEqualTo(ChatCompletionTool.Type.FUNCTION)
    }
}
