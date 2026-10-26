// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseErrorTest {

    @Test
    fun createAndRoundtrip() {
        val betaResponseError =
            BetaResponseError.builder()
                .code(BetaResponseError.Code.SERVER_ERROR)
                .message("message")
                .misalignment(
                    BetaResponseError.Misalignment.builder()
                        .detailedExplanation("detailed_explanation")
                        .errorType(
                            BetaResponseError.Misalignment.ErrorType
                                .POTENTIALLY_UNINTENDED_DATA_TRANSFER
                        )
                        .reviewTarget("review_target")
                        .steer(
                            BetaResponseError.Misalignment.Steer.builder()
                                .message("message")
                                .build()
                        )
                        .build()
                )
                .param("param")
                .type("type")
                .build()

        assertThat(betaResponseError.code()).isEqualTo(BetaResponseError.Code.SERVER_ERROR)
        assertThat(betaResponseError.message()).isEqualTo("message")
        assertThat(betaResponseError.misalignment())
            .contains(
                BetaResponseError.Misalignment.builder()
                    .detailedExplanation("detailed_explanation")
                    .errorType(
                        BetaResponseError.Misalignment.ErrorType
                            .POTENTIALLY_UNINTENDED_DATA_TRANSFER
                    )
                    .reviewTarget("review_target")
                    .steer(
                        BetaResponseError.Misalignment.Steer.builder().message("message").build()
                    )
                    .build()
            )
        assertThat(betaResponseError.param()).contains("param")
        assertThat(betaResponseError.type()).contains("type")

        val jsonMapper = jsonMapper()

        val roundtrippedBetaResponseError =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseError),
                jacksonTypeRef<BetaResponseError>(),
            )

        assertThat(roundtrippedBetaResponseError).isEqualTo(betaResponseError)
    }
}
