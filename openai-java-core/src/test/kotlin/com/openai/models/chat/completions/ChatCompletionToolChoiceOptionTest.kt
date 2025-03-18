// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionToolChoiceOptionTest {

    @Test
    fun ofAuto() {
        val auto = ChatCompletionToolChoiceOption.Auto.NONE

        val chatCompletionToolChoiceOption = ChatCompletionToolChoiceOption.ofAuto(auto)

        assertThat(chatCompletionToolChoiceOption.auto()).contains(auto)
        assertThat(chatCompletionToolChoiceOption.namedToolChoice()).isEmpty
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
}
