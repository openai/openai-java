// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CompoundFilterTest {

    @Test
    fun create() {
        val compoundFilter =
            CompoundFilter.builder()
                .addFilter(
                    ComparisonFilter.builder()
                        .key("key")
                        .type(ComparisonFilter.Type.EQ)
                        .value("string")
                        .build()
                )
                .type(CompoundFilter.Type.AND)
                .build()

        assertThat(compoundFilter.filters())
            .containsExactly(
                CompoundFilter.Filter.ofComparison(
                    ComparisonFilter.builder()
                        .key("key")
                        .type(ComparisonFilter.Type.EQ)
                        .value("string")
                        .build()
                )
            )
        assertThat(compoundFilter.type()).isEqualTo(CompoundFilter.Type.AND)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val compoundFilter =
            CompoundFilter.builder()
                .addFilter(
                    ComparisonFilter.builder()
                        .key("key")
                        .type(ComparisonFilter.Type.EQ)
                        .value("string")
                        .build()
                )
                .type(CompoundFilter.Type.AND)
                .build()

        val roundtrippedCompoundFilter =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(compoundFilter),
                jacksonTypeRef<CompoundFilter>(),
            )

        assertThat(roundtrippedCompoundFilter).isEqualTo(compoundFilter)
    }
}
