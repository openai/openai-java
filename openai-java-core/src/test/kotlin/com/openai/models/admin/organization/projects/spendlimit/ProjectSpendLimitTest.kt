// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.spendlimit

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProjectSpendLimitTest {

    @Test
    fun create() {
        val projectSpendLimit =
            ProjectSpendLimit.builder()
                .currency(ProjectSpendLimit.Currency.USD)
                .enforcement(
                    ProjectSpendLimit.Enforcement.builder()
                        .status(ProjectSpendLimit.Enforcement.Status.INACTIVE)
                        .build()
                )
                .interval(ProjectSpendLimit.Interval.MONTH)
                .thresholdAmount(0L)
                .build()

        assertThat(projectSpendLimit.currency()).isEqualTo(ProjectSpendLimit.Currency.USD)
        assertThat(projectSpendLimit.enforcement())
            .isEqualTo(
                ProjectSpendLimit.Enforcement.builder()
                    .status(ProjectSpendLimit.Enforcement.Status.INACTIVE)
                    .build()
            )
        assertThat(projectSpendLimit.interval()).isEqualTo(ProjectSpendLimit.Interval.MONTH)
        assertThat(projectSpendLimit.thresholdAmount()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val projectSpendLimit =
            ProjectSpendLimit.builder()
                .currency(ProjectSpendLimit.Currency.USD)
                .enforcement(
                    ProjectSpendLimit.Enforcement.builder()
                        .status(ProjectSpendLimit.Enforcement.Status.INACTIVE)
                        .build()
                )
                .interval(ProjectSpendLimit.Interval.MONTH)
                .thresholdAmount(0L)
                .build()

        val roundtrippedProjectSpendLimit =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(projectSpendLimit),
                jacksonTypeRef<ProjectSpendLimit>(),
            )

        assertThat(roundtrippedProjectSpendLimit).isEqualTo(projectSpendLimit)
    }
}
