// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class ResponseSteerInputTest {

    @Test
    fun ofText() {
        val text = "string"

        val responseSteerInput = ResponseSteerInput.ofText(text)

        assertThat(responseSteerInput.text()).contains(text)
        assertThat(responseSteerInput.itemList()).isEmpty
    }

    @Test
    fun ofTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseSteerInput = ResponseSteerInput.ofText("string")

        val roundtrippedResponseSteerInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseSteerInput),
                jacksonTypeRef<ResponseSteerInput>(),
            )

        assertThat(roundtrippedResponseSteerInput).isEqualTo(responseSteerInput)
    }

    @Test
    fun ofItemList() {
        val itemList =
            listOf(
                ResponseSteerInput.ResponseSteerInputItem.ofMessage(
                    ResponseSteerInput.ResponseSteerInputItem.Message.builder()
                        .contentOfResponseSteerInputContents(
                            listOf(
                                ResponseSteerInputContent.ofInputText(
                                    ResponseInputTextContent.builder()
                                        .text("text")
                                        .promptCacheBreakpoint(
                                            ResponseInputTextContent.PromptCacheBreakpoint.builder()
                                                .build()
                                        )
                                        .build()
                                )
                            )
                        )
                        .id("msg_123")
                        .status("status")
                        .build()
                )
            )

        val responseSteerInput = ResponseSteerInput.ofItemList(itemList)

        assertThat(responseSteerInput.text()).isEmpty
        assertThat(responseSteerInput.itemList()).contains(itemList)
    }

    @Test
    fun ofItemListRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseSteerInput =
            ResponseSteerInput.ofItemList(
                listOf(
                    ResponseSteerInput.ResponseSteerInputItem.ofMessage(
                        ResponseSteerInput.ResponseSteerInputItem.Message.builder()
                            .contentOfResponseSteerInputContents(
                                listOf(
                                    ResponseSteerInputContent.ofInputText(
                                        ResponseInputTextContent.builder()
                                            .text("text")
                                            .promptCacheBreakpoint(
                                                ResponseInputTextContent.PromptCacheBreakpoint
                                                    .builder()
                                                    .build()
                                            )
                                            .build()
                                    )
                                )
                            )
                            .id("msg_123")
                            .status("status")
                            .build()
                    )
                )
            )

        val roundtrippedResponseSteerInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseSteerInput),
                jacksonTypeRef<ResponseSteerInput>(),
            )

        assertThat(roundtrippedResponseSteerInput).isEqualTo(responseSteerInput)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        OBJECT(JsonValue.from(mapOf("invalid" to "object"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val responseSteerInput =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<ResponseSteerInput>())

        val e = assertThrows<OpenAIInvalidDataException> { responseSteerInput.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
