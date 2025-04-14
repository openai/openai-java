// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class ResponsesModelTest {

    @Test
    fun ofString() {
        val string = "string"

        val responsesModel = ResponsesModel.ofString(string)

        assertThat(responsesModel.string()).contains(string)
        assertThat(responsesModel.chat()).isEmpty
        assertThat(responsesModel.only()).isEmpty
    }

    @Test
    fun ofStringRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesModel = ResponsesModel.ofString("string")

        val roundtrippedResponsesModel =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesModel),
                jacksonTypeRef<ResponsesModel>(),
            )

        assertThat(roundtrippedResponsesModel).isEqualTo(responsesModel)
    }

    @Test
    fun ofChat() {
        val chat = ChatModel.GPT_4_1

        val responsesModel = ResponsesModel.ofChat(chat)

        assertThat(responsesModel.string()).isEmpty
        assertThat(responsesModel.chat()).contains(chat)
        assertThat(responsesModel.only()).isEmpty
    }

    @Test
    fun ofChatRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesModel = ResponsesModel.ofChat(ChatModel.GPT_4_1)

        val roundtrippedResponsesModel =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesModel),
                jacksonTypeRef<ResponsesModel>(),
            )

        assertThat(roundtrippedResponsesModel).isEqualTo(responsesModel)
    }

    @Test
    fun ofOnly() {
        val only = ResponsesModel.ResponsesOnlyModel.O1_PRO

        val responsesModel = ResponsesModel.ofOnly(only)

        assertThat(responsesModel.string()).isEmpty
        assertThat(responsesModel.chat()).isEmpty
        assertThat(responsesModel.only()).contains(only)
    }

    @Test
    fun ofOnlyRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesModel = ResponsesModel.ofOnly(ResponsesModel.ResponsesOnlyModel.O1_PRO)

        val roundtrippedResponsesModel =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesModel),
                jacksonTypeRef<ResponsesModel>(),
            )

        assertThat(roundtrippedResponsesModel).isEqualTo(responsesModel)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        OBJECT(JsonValue.from(mapOf("invalid" to "object"))),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val responsesModel =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<ResponsesModel>())

        val e = assertThrows<OpenAIInvalidDataException> { responsesModel.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
