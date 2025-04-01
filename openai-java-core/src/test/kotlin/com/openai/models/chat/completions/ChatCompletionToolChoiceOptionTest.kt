// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class ChatCompletionToolChoiceOptionTest {

    @Test
    fun ofAuto() {
        val auto = ChatCompletionToolChoiceOption.Auto.NONE

        val chatCompletionToolChoiceOption = ChatCompletionToolChoiceOption.ofAuto(auto)

        assertThat(chatCompletionToolChoiceOption.auto()).contains(auto)
        assertThat(chatCompletionToolChoiceOption.namedToolChoice()).isEmpty
    }

    @Test
    fun ofAutoRoundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionToolChoiceOption =
            ChatCompletionToolChoiceOption.ofAuto(ChatCompletionToolChoiceOption.Auto.NONE)

        val roundtrippedChatCompletionToolChoiceOption =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionToolChoiceOption),
                jacksonTypeRef<ChatCompletionToolChoiceOption>(),
            )

        assertThat(roundtrippedChatCompletionToolChoiceOption)
            .isEqualTo(chatCompletionToolChoiceOption)
    }

    @Test
    fun ofNamedToolChoice() {
        val namedToolChoice =
            ChatCompletionNamedToolChoice.builder()
                .function(ChatCompletionNamedToolChoice.Function.builder().name("name").build())
                .build()

        val chatCompletionToolChoiceOption =
            ChatCompletionToolChoiceOption.ofNamedToolChoice(namedToolChoice)

        assertThat(chatCompletionToolChoiceOption.auto()).isEmpty
        assertThat(chatCompletionToolChoiceOption.namedToolChoice()).contains(namedToolChoice)
    }

    @Test
    fun ofNamedToolChoiceRoundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionToolChoiceOption =
            ChatCompletionToolChoiceOption.ofNamedToolChoice(
                ChatCompletionNamedToolChoice.builder()
                    .function(ChatCompletionNamedToolChoice.Function.builder().name("name").build())
                    .build()
            )

        val roundtrippedChatCompletionToolChoiceOption =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionToolChoiceOption),
                jacksonTypeRef<ChatCompletionToolChoiceOption>(),
            )

        assertThat(roundtrippedChatCompletionToolChoiceOption)
            .isEqualTo(chatCompletionToolChoiceOption)
    }

    @Test
    fun incompatibleJsonShapeDeserializesToUnknown() {
        val value = JsonValue.from(listOf("invalid", "array"))
        val chatCompletionToolChoiceOption =
            jsonMapper().convertValue(value, jacksonTypeRef<ChatCompletionToolChoiceOption>())

        val e =
            assertThrows<OpenAIInvalidDataException> { chatCompletionToolChoiceOption.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
