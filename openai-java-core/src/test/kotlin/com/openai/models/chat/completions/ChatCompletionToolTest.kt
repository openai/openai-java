// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.FunctionDefinition
import com.openai.models.FunctionParameters
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class ChatCompletionToolTest {

    @Test
    fun ofFunction() {
        val function =
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

        val chatCompletionTool = ChatCompletionTool.ofFunction(function)

        assertThat(chatCompletionTool.function()).contains(function)
        assertThat(chatCompletionTool.custom()).isEmpty
    }

    @Test
    fun ofFunctionRoundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionTool =
            ChatCompletionTool.ofFunction(
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
            )

        val roundtrippedChatCompletionTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionTool),
                jacksonTypeRef<ChatCompletionTool>(),
            )

        assertThat(roundtrippedChatCompletionTool).isEqualTo(chatCompletionTool)
    }

    @Test
    fun ofCustom() {
        val custom =
            ChatCompletionCustomTool.builder()
                .custom(
                    ChatCompletionCustomTool.Custom.builder()
                        .name("name")
                        .description("description")
                        .formatText()
                        .build()
                )
                .build()

        val chatCompletionTool = ChatCompletionTool.ofCustom(custom)

        assertThat(chatCompletionTool.function()).isEmpty
        assertThat(chatCompletionTool.custom()).contains(custom)
    }

    @Test
    fun ofCustomRoundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionTool =
            ChatCompletionTool.ofCustom(
                ChatCompletionCustomTool.builder()
                    .custom(
                        ChatCompletionCustomTool.Custom.builder()
                            .name("name")
                            .description("description")
                            .formatText()
                            .build()
                    )
                    .build()
            )

        val roundtrippedChatCompletionTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionTool),
                jacksonTypeRef<ChatCompletionTool>(),
            )

        assertThat(roundtrippedChatCompletionTool).isEqualTo(chatCompletionTool)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val chatCompletionTool =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<ChatCompletionTool>())

        val e = assertThrows<OpenAIInvalidDataException> { chatCompletionTool.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
