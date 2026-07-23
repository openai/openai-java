// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.spendlimit

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrganizationSpendLimitTest {

    @Test
    fun create() {
        val organizationSpendLimit =
            OrganizationSpendLimit.builder()
                .currency(OrganizationSpendLimit.Currency.USD)
                .enforcement(
                    OrganizationSpendLimit.Enforcement.builder()
                        .status(OrganizationSpendLimit.Enforcement.Status.INACTIVE)
                        .build()
                )
                .interval(OrganizationSpendLimit.Interval.MONTH)
                .thresholdAmount(0L)
                .build()

        assertThat(organizationSpendLimit.currency()).isEqualTo(OrganizationSpendLimit.Currency.USD)
        assertThat(organizationSpendLimit.enforcement())
            .isEqualTo(
                OrganizationSpendLimit.Enforcement.builder()
                    .status(OrganizationSpendLimit.Enforcement.Status.INACTIVE)
                    .build()
            )
        assertThat(organizationSpendLimit.interval())
            .isEqualTo(OrganizationSpendLimit.Interval.MONTH)
        assertThat(organizationSpendLimit.thresholdAmount()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val organizationSpendLimit =
            OrganizationSpendLimit.builder()
                .currency(OrganizationSpendLimit.Currency.USD)
                .enforcement(
                    OrganizationSpendLimit.Enforcement.builder()
                        .status(OrganizationSpendLimit.Enforcement.Status.INACTIVE)
                        .build()
                )
                .interval(OrganizationSpendLimit.Interval.MONTH)
                .thresholdAmount(0L)
                .build()

        val roundtrippedOrganizationSpendLimit =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(organizationSpendLimit),
                jacksonTypeRef<OrganizationSpendLimit>(),
            )

        assertThat(roundtrippedOrganizationSpendLimit).isEqualTo(organizationSpendLimit)
    }
}
