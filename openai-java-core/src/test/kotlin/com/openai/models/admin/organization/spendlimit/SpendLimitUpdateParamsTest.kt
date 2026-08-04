// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.spendlimit

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SpendLimitUpdateParamsTest {

    @Test
    fun create() {
        SpendLimitUpdateParams.builder()
            .currency(SpendLimitUpdateParams.Currency.USD)
            .interval(SpendLimitUpdateParams.Interval.MONTH)
            .thresholdAmount(1L)
            .build()
    }

    @Test
    fun body() {
        val params =
            SpendLimitUpdateParams.builder()
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
