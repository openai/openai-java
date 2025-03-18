// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.openai.core.JsonValue
import com.openai.models.FunctionDefinition
import com.openai.models.FunctionParameters
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionToolTest {

    @Test
    fun create() {
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
                .build()

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
    }
}
