// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CompoundFilterTest {

    @Test
    fun createCompoundFilter() {
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
        assertThat(compoundFilter).isNotNull
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
}
