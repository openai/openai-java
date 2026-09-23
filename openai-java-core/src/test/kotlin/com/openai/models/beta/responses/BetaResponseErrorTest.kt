// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseErrorTest {

    @Test
    fun create() {
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
                        .steer(
                            BetaResponseError.Misalignment.Steer.builder()
                                .message("message")
                                .build()
                        )
                        .build()
                )
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
                    .steer(
                        BetaResponseError.Misalignment.Steer.builder().message("message").build()
                    )
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
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
                        .steer(
                            BetaResponseError.Misalignment.Steer.builder()
                                .message("message")
                                .build()
                        )
                        .build()
                )
                .build()

        val roundtrippedBetaResponseError =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseError),
                jacksonTypeRef<BetaResponseError>(),
            )

        assertThat(roundtrippedBetaResponseError).isEqualTo(betaResponseError)
    }
}
