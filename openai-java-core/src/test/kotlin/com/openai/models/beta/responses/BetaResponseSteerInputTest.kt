// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class BetaResponseSteerInputTest {

    @Test
    fun ofText() {
        val text = "string"

        val betaResponseSteerInput = BetaResponseSteerInput.ofText(text)

        assertThat(betaResponseSteerInput.text()).contains(text)
        assertThat(betaResponseSteerInput.responseSteerInputItemList()).isEmpty
    }

    @Test
    fun ofTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseSteerInput = BetaResponseSteerInput.ofText("string")

        val roundtrippedBetaResponseSteerInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseSteerInput),
                jacksonTypeRef<BetaResponseSteerInput>(),
            )

        assertThat(roundtrippedBetaResponseSteerInput).isEqualTo(betaResponseSteerInput)
    }

    @Test
    fun ofResponseSteerInputItemList() {
        val responseSteerInputItemList =
            listOf(
                BetaResponseSteerInput.ResponseSteerInputItem.ofMessage(
                    BetaResponseSteerInput.ResponseSteerInputItem.Message.builder()
                        .contentOfBetaResponseSteerInputContents(
                            listOf(
                                BetaResponseSteerInputContent.ofInputText(
                                    BetaResponseInputTextContent.builder()
                                        .text("text")
                                        .promptCacheBreakpoint(
                                            BetaResponseInputTextContent.PromptCacheBreakpoint
                                                .builder()
                                                .build()
                                        )
                                        .build()
                                )
                            )
                        )
                        .id("msg_123")
                        .agent(
                            BetaResponseSteerInput.ResponseSteerInputItem.Message.Agent.builder()
                                .agentName("agent_name")
                                .build()
                        )
                        .status("status")
                        .build()
                )
            )

        val betaResponseSteerInput =
            BetaResponseSteerInput.ofResponseSteerInputItemList(responseSteerInputItemList)

        assertThat(betaResponseSteerInput.text()).isEmpty
        assertThat(betaResponseSteerInput.responseSteerInputItemList())
            .contains(responseSteerInputItemList)
    }

    @Test
    fun ofResponseSteerInputItemListRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseSteerInput =
            BetaResponseSteerInput.ofResponseSteerInputItemList(
                listOf(
                    BetaResponseSteerInput.ResponseSteerInputItem.ofMessage(
                        BetaResponseSteerInput.ResponseSteerInputItem.Message.builder()
                            .contentOfBetaResponseSteerInputContents(
                                listOf(
                                    BetaResponseSteerInputContent.ofInputText(
                                        BetaResponseInputTextContent.builder()
                                            .text("text")
                                            .promptCacheBreakpoint(
                                                BetaResponseInputTextContent.PromptCacheBreakpoint
                                                    .builder()
                                                    .build()
                                            )
                                            .build()
                                    )
                                )
                            )
                            .id("msg_123")
                            .agent(
                                BetaResponseSteerInput.ResponseSteerInputItem.Message.Agent
                                    .builder()
                                    .agentName("agent_name")
                                    .build()
                            )
                            .status("status")
                            .build()
                    )
                )
            )

        val roundtrippedBetaResponseSteerInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseSteerInput),
                jacksonTypeRef<BetaResponseSteerInput>(),
            )

        assertThat(roundtrippedBetaResponseSteerInput).isEqualTo(betaResponseSteerInput)
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
        val betaResponseSteerInput =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<BetaResponseSteerInput>())

        val e = assertThrows<OpenAIInvalidDataException> { betaResponseSteerInput.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
