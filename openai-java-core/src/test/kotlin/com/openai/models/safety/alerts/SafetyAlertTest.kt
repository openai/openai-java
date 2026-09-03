// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.safety.alerts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SafetyAlertTest {

    @Test
    fun create() {
        val safetyAlert =
            SafetyAlert.builder()
                .id("id")
                .createdAt(0L)
                .errorType(SafetyAlert.ErrorType.POTENTIALLY_UNINTENDED_DATA_TRANSFER)
                .model("model")
                .reason("reason")
                .requestId("request_id")
                .requestPaused(true)
                .responseId("response_id")
                .build()

        assertThat(safetyAlert.id()).isEqualTo("id")
        assertThat(safetyAlert.createdAt()).isEqualTo(0L)
        assertThat(safetyAlert.errorType())
            .isEqualTo(SafetyAlert.ErrorType.POTENTIALLY_UNINTENDED_DATA_TRANSFER)
        assertThat(safetyAlert.model()).isEqualTo("model")
        assertThat(safetyAlert.reason()).contains("reason")
        assertThat(safetyAlert.requestId()).isEqualTo("request_id")
        assertThat(safetyAlert.requestPaused()).isEqualTo(true)
        assertThat(safetyAlert.responseId()).isEqualTo("response_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val safetyAlert =
            SafetyAlert.builder()
                .id("id")
                .createdAt(0L)
                .errorType(SafetyAlert.ErrorType.POTENTIALLY_UNINTENDED_DATA_TRANSFER)
                .model("model")
                .reason("reason")
                .requestId("request_id")
                .requestPaused(true)
                .responseId("response_id")
                .build()

        val roundtrippedSafetyAlert =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(safetyAlert),
                jacksonTypeRef<SafetyAlert>(),
            )

        assertThat(roundtrippedSafetyAlert).isEqualTo(safetyAlert)
    }
}
