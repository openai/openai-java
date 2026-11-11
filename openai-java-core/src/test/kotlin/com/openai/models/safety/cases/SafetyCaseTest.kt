// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.safety.cases

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SafetyCaseTest {

    @Test
    fun createAndRoundtrip() {
        val safetyCase =
            SafetyCase.builder()
                .id("id")
                .createdAt(0L)
                .entityIdentifier("entity_identifier")
                .notice(SafetyCase.Notice.builder().type(SafetyCase.Notice.Type.WARNING).build())
                .reason("reason")
                .build()

        assertThat(safetyCase.id()).contains("id")
        assertThat(safetyCase.createdAt()).contains(0L)
        assertThat(safetyCase.entityIdentifier()).contains("entity_identifier")
        assertThat(safetyCase.notice())
            .contains(SafetyCase.Notice.builder().type(SafetyCase.Notice.Type.WARNING).build())
        assertThat(safetyCase.reason()).contains("reason")

        val jsonMapper = jsonMapper()

        val roundtrippedSafetyCase =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(safetyCase),
                jacksonTypeRef<SafetyCase>(),
            )

        assertThat(roundtrippedSafetyCase).isEqualTo(safetyCase)
    }
}
