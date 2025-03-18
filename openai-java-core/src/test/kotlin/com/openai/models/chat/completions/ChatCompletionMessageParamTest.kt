// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionMessageParamTest {

    @Test
    fun ofDeveloper() {
        val developer = ChatCompletionDeveloperMessageParam.builder().content("string").build()

        val chatCompletionMessageParam = ChatCompletionMessageParam.ofDeveloper(developer)

        assertThat(chatCompletionMessageParam.developer()).contains(developer)
        assertThat(chatCompletionMessageParam.system()).isEmpty
        assertThat(chatCompletionMessageParam.user()).isEmpty
        assertThat(chatCompletionMessageParam.assistant()).isEmpty
        assertThat(chatCompletionMessageParam.tool()).isEmpty
        assertThat(chatCompletionMessageParam.function()).isEmpty
    }

    @Test
    fun ofSystem() {
        val system = ChatCompletionSystemMessageParam.builder().content("string").build()

        val chatCompletionMessageParam = ChatCompletionMessageParam.ofSystem(system)

        assertThat(chatCompletionMessageParam.developer()).isEmpty
        assertThat(chatCompletionMessageParam.system()).contains(system)
        assertThat(chatCompletionMessageParam.user()).isEmpty
        assertThat(chatCompletionMessageParam.assistant()).isEmpty
        assertThat(chatCompletionMessageParam.tool()).isEmpty
        assertThat(chatCompletionMessageParam.function()).isEmpty
    }

    @Test
    fun ofUser() {
        val user = ChatCompletionUserMessageParam.builder().content("string").build()

        val chatCompletionMessageParam = ChatCompletionMessageParam.ofUser(user)

        assertThat(chatCompletionMessageParam.developer()).isEmpty
        assertThat(chatCompletionMessageParam.system()).isEmpty
        assertThat(chatCompletionMessageParam.user()).contains(user)
        assertThat(chatCompletionMessageParam.assistant()).isEmpty
        assertThat(chatCompletionMessageParam.tool()).isEmpty
        assertThat(chatCompletionMessageParam.function()).isEmpty
    }

    @Test
    fun ofAssistant() {
        val assistant = ChatCompletionAssistantMessageParam.builder().build()

        val chatCompletionMessageParam = ChatCompletionMessageParam.ofAssistant(assistant)

        assertThat(chatCompletionMessageParam.developer()).isEmpty
        assertThat(chatCompletionMessageParam.system()).isEmpty
        assertThat(chatCompletionMessageParam.user()).isEmpty
        assertThat(chatCompletionMessageParam.assistant()).contains(assistant)
        assertThat(chatCompletionMessageParam.tool()).isEmpty
        assertThat(chatCompletionMessageParam.function()).isEmpty
    }

    @Test
    fun ofTool() {
        val tool =
            ChatCompletionToolMessageParam.builder()
                .content("string")
                .toolCallId("tool_call_id")
                .build()

        val chatCompletionMessageParam = ChatCompletionMessageParam.ofTool(tool)

        assertThat(chatCompletionMessageParam.developer()).isEmpty
        assertThat(chatCompletionMessageParam.system()).isEmpty
        assertThat(chatCompletionMessageParam.user()).isEmpty
        assertThat(chatCompletionMessageParam.assistant()).isEmpty
        assertThat(chatCompletionMessageParam.tool()).contains(tool)
        assertThat(chatCompletionMessageParam.function()).isEmpty
    }

    @Test
    fun ofFunction() {
        val function =
            ChatCompletionFunctionMessageParam.builder().content("content").name("name").build()

        val chatCompletionMessageParam = ChatCompletionMessageParam.ofFunction(function)

        assertThat(chatCompletionMessageParam.developer()).isEmpty
        assertThat(chatCompletionMessageParam.system()).isEmpty
        assertThat(chatCompletionMessageParam.user()).isEmpty
        assertThat(chatCompletionMessageParam.assistant()).isEmpty
        assertThat(chatCompletionMessageParam.tool()).isEmpty
        assertThat(chatCompletionMessageParam.function()).contains(function)
    }
}
