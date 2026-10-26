// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseErrorTest {

    @Test
    fun createAndRoundtrip() {
        val responseError =
            ResponseError.builder()
                .code(ResponseError.Code.SERVER_ERROR)
                .message("message")
                .misalignment(
                    ResponseError.Misalignment.builder()
                        .detailedExplanation("detailed_explanation")
                        .errorType(
                            ResponseError.Misalignment.ErrorType
                                .POTENTIALLY_UNINTENDED_DATA_TRANSFER
                        )
                        .reviewTarget("review_target")
                        .steer(
                            ResponseError.Misalignment.Steer.builder().message("message").build()
                        )
                        .build()
                )
                .param("param")
                .type("type")
                .build()

        assertThat(responseError.code()).isEqualTo(ResponseError.Code.SERVER_ERROR)
        assertThat(responseError.message()).isEqualTo("message")
        assertThat(responseError.misalignment())
            .contains(
                ResponseError.Misalignment.builder()
                    .detailedExplanation("detailed_explanation")
                    .errorType(
                        ResponseError.Misalignment.ErrorType.POTENTIALLY_UNINTENDED_DATA_TRANSFER
                    )
                    .reviewTarget("review_target")
                    .steer(ResponseError.Misalignment.Steer.builder().message("message").build())
                    .build()
            )
        assertThat(responseError.param()).contains("param")
        assertThat(responseError.type()).contains("type")

        val jsonMapper = jsonMapper()

        val roundtrippedResponseError =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseError),
                jacksonTypeRef<ResponseError>(),
            )

        assertThat(roundtrippedResponseError).isEqualTo(responseError)
    }
}
