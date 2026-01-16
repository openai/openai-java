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

internal class ChatCompletionToolChoiceOptionTest {

    @Test
    fun ofAuto() {
        val auto = ChatCompletionToolChoiceOption.Auto.NONE

        val chatCompletionToolChoiceOption = ChatCompletionToolChoiceOption.ofAuto(auto)

        assertThat(chatCompletionToolChoiceOption.auto()).contains(auto)
        assertThat(chatCompletionToolChoiceOption.allowedToolChoice()).isEmpty
        assertThat(chatCompletionToolChoiceOption.namedToolChoice()).isEmpty
        assertThat(chatCompletionToolChoiceOption.namedToolChoiceCustom()).isEmpty
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
    fun ofAllowedToolChoice() {
        val allowedToolChoice =
            ChatCompletionAllowedToolChoice.builder()
                .allowedTools(
                    ChatCompletionAllowedTools.builder()
                        .mode(ChatCompletionAllowedTools.Mode.AUTO)
                        .addTool(
                            ChatCompletionAllowedTools.Tool.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
                .build()

        val chatCompletionToolChoiceOption =
            ChatCompletionToolChoiceOption.ofAllowedToolChoice(allowedToolChoice)

        assertThat(chatCompletionToolChoiceOption.auto()).isEmpty
        assertThat(chatCompletionToolChoiceOption.allowedToolChoice()).contains(allowedToolChoice)
        assertThat(chatCompletionToolChoiceOption.namedToolChoice()).isEmpty
        assertThat(chatCompletionToolChoiceOption.namedToolChoiceCustom()).isEmpty
    }

    @Test
    fun ofAllowedToolChoiceRoundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionToolChoiceOption =
            ChatCompletionToolChoiceOption.ofAllowedToolChoice(
                ChatCompletionAllowedToolChoice.builder()
                    .allowedTools(
                        ChatCompletionAllowedTools.builder()
                            .mode(ChatCompletionAllowedTools.Mode.AUTO)
                            .addTool(
                                ChatCompletionAllowedTools.Tool.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .build()
                    )
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
    fun ofNamedToolChoice() {
        val namedToolChoice =
            ChatCompletionNamedToolChoice.builder()
                .function(ChatCompletionNamedToolChoice.Function.builder().name("name").build())
                .build()

        val chatCompletionToolChoiceOption =
            ChatCompletionToolChoiceOption.ofNamedToolChoice(namedToolChoice)

        assertThat(chatCompletionToolChoiceOption.auto()).isEmpty
        assertThat(chatCompletionToolChoiceOption.allowedToolChoice()).isEmpty
        assertThat(chatCompletionToolChoiceOption.namedToolChoice()).contains(namedToolChoice)
        assertThat(chatCompletionToolChoiceOption.namedToolChoiceCustom()).isEmpty
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
    fun ofNamedToolChoiceCustom() {
        val namedToolChoiceCustom =
            ChatCompletionNamedToolChoiceCustom.builder()
                .custom(ChatCompletionNamedToolChoiceCustom.Custom.builder().name("name").build())
                .build()

        val chatCompletionToolChoiceOption =
            ChatCompletionToolChoiceOption.ofNamedToolChoiceCustom(namedToolChoiceCustom)

        assertThat(chatCompletionToolChoiceOption.auto()).isEmpty
        assertThat(chatCompletionToolChoiceOption.allowedToolChoice()).isEmpty
        assertThat(chatCompletionToolChoiceOption.namedToolChoice()).isEmpty
        assertThat(chatCompletionToolChoiceOption.namedToolChoiceCustom())
            .contains(namedToolChoiceCustom)
    }

    @Test
    fun ofNamedToolChoiceCustomRoundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionToolChoiceOption =
            ChatCompletionToolChoiceOption.ofNamedToolChoiceCustom(
                ChatCompletionNamedToolChoiceCustom.builder()
                    .custom(
                        ChatCompletionNamedToolChoiceCustom.Custom.builder().name("name").build()
                    )
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

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val chatCompletionToolChoiceOption =
            jsonMapper()
                .convertValue(testCase.value, jacksonTypeRef<ChatCompletionToolChoiceOption>())

        val e =
            assertThrows<OpenAIInvalidDataException> { chatCompletionToolChoiceOption.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
