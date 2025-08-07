// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class ChatCompletionMessageToolCallTest {

    @Test
    fun ofFunction() {
        val function =
            ChatCompletionMessageFunctionToolCall.builder()
                .id("id")
                .function(
                    ChatCompletionMessageFunctionToolCall.Function.builder()
                        .arguments("arguments")
                        .name("name")
                        .build()
                )
                .build()

        val chatCompletionMessageToolCall = ChatCompletionMessageToolCall.ofFunction(function)

        assertThat(chatCompletionMessageToolCall.function()).contains(function)
        assertThat(chatCompletionMessageToolCall.custom()).isEmpty
    }

    @Test
    fun ofFunctionRoundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionMessageToolCall =
            ChatCompletionMessageToolCall.ofFunction(
                ChatCompletionMessageFunctionToolCall.builder()
                    .id("id")
                    .function(
                        ChatCompletionMessageFunctionToolCall.Function.builder()
                            .arguments("arguments")
                            .name("name")
                            .build()
                    )
                    .build()
            )

        val roundtrippedChatCompletionMessageToolCall =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionMessageToolCall),
                jacksonTypeRef<ChatCompletionMessageToolCall>(),
            )

        assertThat(roundtrippedChatCompletionMessageToolCall)
            .isEqualTo(chatCompletionMessageToolCall)
    }

    @Test
    fun ofCustom() {
        val custom =
            ChatCompletionMessageCustomToolCall.builder()
                .id("id")
                .custom(
                    ChatCompletionMessageCustomToolCall.Custom.builder()
                        .input("input")
                        .name("name")
                        .build()
                )
                .build()

        val chatCompletionMessageToolCall = ChatCompletionMessageToolCall.ofCustom(custom)

        assertThat(chatCompletionMessageToolCall.function()).isEmpty
        assertThat(chatCompletionMessageToolCall.custom()).contains(custom)
    }

    @Test
    fun ofCustomRoundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionMessageToolCall =
            ChatCompletionMessageToolCall.ofCustom(
                ChatCompletionMessageCustomToolCall.builder()
                    .id("id")
                    .custom(
                        ChatCompletionMessageCustomToolCall.Custom.builder()
                            .input("input")
                            .name("name")
                            .build()
                    )
                    .build()
            )

        val roundtrippedChatCompletionMessageToolCall =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionMessageToolCall),
                jacksonTypeRef<ChatCompletionMessageToolCall>(),
            )

        assertThat(roundtrippedChatCompletionMessageToolCall)
            .isEqualTo(chatCompletionMessageToolCall)
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
        val chatCompletionMessageToolCall =
            jsonMapper()
                .convertValue(testCase.value, jacksonTypeRef<ChatCompletionMessageToolCall>())

        val e =
            assertThrows<OpenAIInvalidDataException> { chatCompletionMessageToolCall.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
