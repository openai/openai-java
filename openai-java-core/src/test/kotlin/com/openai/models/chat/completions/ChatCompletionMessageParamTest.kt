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

internal class ChatCompletionMessageParamTest {

    @Test
    fun ofDeveloper() {
        val developer =
            ChatCompletionDeveloperMessageParam.builder().content("string").name("name").build()

        val chatCompletionMessageParam = ChatCompletionMessageParam.ofDeveloper(developer)

        assertThat(chatCompletionMessageParam.developer()).contains(developer)
        assertThat(chatCompletionMessageParam.system()).isEmpty
        assertThat(chatCompletionMessageParam.user()).isEmpty
        assertThat(chatCompletionMessageParam.assistant()).isEmpty
        assertThat(chatCompletionMessageParam.tool()).isEmpty
        assertThat(chatCompletionMessageParam.function()).isEmpty
    }

    @Test
    fun ofDeveloperRoundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionMessageParam =
            ChatCompletionMessageParam.ofDeveloper(
                ChatCompletionDeveloperMessageParam.builder().content("string").name("name").build()
            )

        val roundtrippedChatCompletionMessageParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionMessageParam),
                jacksonTypeRef<ChatCompletionMessageParam>(),
            )

        assertThat(roundtrippedChatCompletionMessageParam).isEqualTo(chatCompletionMessageParam)
    }

    @Test
    fun ofSystem() {
        val system =
            ChatCompletionSystemMessageParam.builder().content("string").name("name").build()

        val chatCompletionMessageParam = ChatCompletionMessageParam.ofSystem(system)

        assertThat(chatCompletionMessageParam.developer()).isEmpty
        assertThat(chatCompletionMessageParam.system()).contains(system)
        assertThat(chatCompletionMessageParam.user()).isEmpty
        assertThat(chatCompletionMessageParam.assistant()).isEmpty
        assertThat(chatCompletionMessageParam.tool()).isEmpty
        assertThat(chatCompletionMessageParam.function()).isEmpty
    }

    @Test
    fun ofSystemRoundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionMessageParam =
            ChatCompletionMessageParam.ofSystem(
                ChatCompletionSystemMessageParam.builder().content("string").name("name").build()
            )

        val roundtrippedChatCompletionMessageParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionMessageParam),
                jacksonTypeRef<ChatCompletionMessageParam>(),
            )

        assertThat(roundtrippedChatCompletionMessageParam).isEqualTo(chatCompletionMessageParam)
    }

    @Test
    fun ofUser() {
        val user = ChatCompletionUserMessageParam.builder().content("string").name("name").build()

        val chatCompletionMessageParam = ChatCompletionMessageParam.ofUser(user)

        assertThat(chatCompletionMessageParam.developer()).isEmpty
        assertThat(chatCompletionMessageParam.system()).isEmpty
        assertThat(chatCompletionMessageParam.user()).contains(user)
        assertThat(chatCompletionMessageParam.assistant()).isEmpty
        assertThat(chatCompletionMessageParam.tool()).isEmpty
        assertThat(chatCompletionMessageParam.function()).isEmpty
    }

    @Test
    fun ofUserRoundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionMessageParam =
            ChatCompletionMessageParam.ofUser(
                ChatCompletionUserMessageParam.builder().content("string").name("name").build()
            )

        val roundtrippedChatCompletionMessageParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionMessageParam),
                jacksonTypeRef<ChatCompletionMessageParam>(),
            )

        assertThat(roundtrippedChatCompletionMessageParam).isEqualTo(chatCompletionMessageParam)
    }

    @Test
    fun ofAssistant() {
        val assistant =
            ChatCompletionAssistantMessageParam.builder()
                .audio(ChatCompletionAssistantMessageParam.Audio.builder().id("id").build())
                .content("string")
                .functionCall(
                    ChatCompletionAssistantMessageParam.FunctionCall.builder()
                        .arguments("arguments")
                        .name("name")
                        .build()
                )
                .name("name")
                .refusal("refusal")
                .addToolCall(
                    ChatCompletionMessageToolCall.builder()
                        .id("id")
                        .function(
                            ChatCompletionMessageToolCall.Function.builder()
                                .arguments("arguments")
                                .name("name")
                                .build()
                        )
                        .build()
                )
                .build()

        val chatCompletionMessageParam = ChatCompletionMessageParam.ofAssistant(assistant)

        assertThat(chatCompletionMessageParam.developer()).isEmpty
        assertThat(chatCompletionMessageParam.system()).isEmpty
        assertThat(chatCompletionMessageParam.user()).isEmpty
        assertThat(chatCompletionMessageParam.assistant()).contains(assistant)
        assertThat(chatCompletionMessageParam.tool()).isEmpty
        assertThat(chatCompletionMessageParam.function()).isEmpty
    }

    @Test
    fun ofAssistantRoundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionMessageParam =
            ChatCompletionMessageParam.ofAssistant(
                ChatCompletionAssistantMessageParam.builder()
                    .audio(ChatCompletionAssistantMessageParam.Audio.builder().id("id").build())
                    .content("string")
                    .functionCall(
                        ChatCompletionAssistantMessageParam.FunctionCall.builder()
                            .arguments("arguments")
                            .name("name")
                            .build()
                    )
                    .name("name")
                    .refusal("refusal")
                    .addToolCall(
                        ChatCompletionMessageToolCall.builder()
                            .id("id")
                            .function(
                                ChatCompletionMessageToolCall.Function.builder()
                                    .arguments("arguments")
                                    .name("name")
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )

        val roundtrippedChatCompletionMessageParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionMessageParam),
                jacksonTypeRef<ChatCompletionMessageParam>(),
            )

        assertThat(roundtrippedChatCompletionMessageParam).isEqualTo(chatCompletionMessageParam)
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
    fun ofToolRoundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionMessageParam =
            ChatCompletionMessageParam.ofTool(
                ChatCompletionToolMessageParam.builder()
                    .content("string")
                    .toolCallId("tool_call_id")
                    .build()
            )

        val roundtrippedChatCompletionMessageParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionMessageParam),
                jacksonTypeRef<ChatCompletionMessageParam>(),
            )

        assertThat(roundtrippedChatCompletionMessageParam).isEqualTo(chatCompletionMessageParam)
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

    @Test
    fun ofFunctionRoundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionMessageParam =
            ChatCompletionMessageParam.ofFunction(
                ChatCompletionFunctionMessageParam.builder().content("content").name("name").build()
            )

        val roundtrippedChatCompletionMessageParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionMessageParam),
                jacksonTypeRef<ChatCompletionMessageParam>(),
            )

        assertThat(roundtrippedChatCompletionMessageParam).isEqualTo(chatCompletionMessageParam)
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
        val chatCompletionMessageParam =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<ChatCompletionMessageParam>())

        val e = assertThrows<OpenAIInvalidDataException> { chatCompletionMessageParam.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
