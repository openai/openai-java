// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ErrorObjectTest {

    @Test
    fun create() {
        val errorObject =
            ErrorObject.builder()
                .code("code")
                .message("message")
                .param("param")
                .type("type")
                .misalignment(
                    ErrorObject.Misalignment.builder()
                        .detailedExplanation("detailed_explanation")
                        .errorType(
                            ErrorObject.Misalignment.ErrorType.POTENTIALLY_UNINTENDED_DATA_TRANSFER
                        )
                        .steer(ErrorObject.Misalignment.Steer.builder().message("message").build())
                        .build()
                )
                .build()

        assertThat(errorObject.code()).contains("code")
        assertThat(errorObject.message()).isEqualTo("message")
        assertThat(errorObject.param()).contains("param")
        assertThat(errorObject.type()).isEqualTo("type")
        assertThat(errorObject.misalignment())
            .contains(
                ErrorObject.Misalignment.builder()
                    .detailedExplanation("detailed_explanation")
                    .errorType(
                        ErrorObject.Misalignment.ErrorType.POTENTIALLY_UNINTENDED_DATA_TRANSFER
                    )
                    .steer(ErrorObject.Misalignment.Steer.builder().message("message").build())
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val errorObject =
            ErrorObject.builder()
                .code("code")
                .message("message")
                .param("param")
                .type("type")
                .misalignment(
                    ErrorObject.Misalignment.builder()
                        .detailedExplanation("detailed_explanation")
                        .errorType(
                            ErrorObject.Misalignment.ErrorType.POTENTIALLY_UNINTENDED_DATA_TRANSFER
                        )
                        .steer(ErrorObject.Misalignment.Steer.builder().message("message").build())
                        .build()
                )
                .build()

        val roundtrippedErrorObject =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(errorObject),
                jacksonTypeRef<ErrorObject>(),
            )

        assertThat(roundtrippedErrorObject).isEqualTo(errorObject)
    }
}
