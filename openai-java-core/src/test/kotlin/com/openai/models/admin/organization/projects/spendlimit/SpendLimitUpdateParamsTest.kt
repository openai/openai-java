// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.spendlimit

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SpendLimitUpdateParamsTest {

    @Test
    fun create() {
        SpendLimitUpdateParams.builder()
            .projectId("proj_123")
            .currency(SpendLimitUpdateParams.Currency.USD)
            .interval(SpendLimitUpdateParams.Interval.MONTH)
            .thresholdAmount(1L)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            SpendLimitUpdateParams.builder()
                .projectId("proj_123")
                .currency(SpendLimitUpdateParams.Currency.USD)
                .interval(SpendLimitUpdateParams.Interval.MONTH)
                .thresholdAmount(1L)
                .build()

        assertThat(params._pathParam(0)).isEqualTo("proj_123")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            SpendLimitUpdateParams.builder()
                .projectId("proj_123")
                .currency(SpendLimitUpdateParams.Currency.USD)
                .interval(SpendLimitUpdateParams.Interval.MONTH)
                .thresholdAmount(1L)
                .build()

        val body = params._body()

        assertThat(body.currency()).isEqualTo(SpendLimitUpdateParams.Currency.USD)
        assertThat(body.interval()).isEqualTo(SpendLimitUpdateParams.Interval.MONTH)
        assertThat(body.thresholdAmount()).isEqualTo(1L)
    }
}
