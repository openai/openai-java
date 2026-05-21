// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.spendalerts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrganizationSpendAlertTest {

    @Test
    fun create() {
        val organizationSpendAlert =
            OrganizationSpendAlert.builder()
                .id("id")
                .currency(OrganizationSpendAlert.Currency.USD)
                .interval(OrganizationSpendAlert.Interval.MONTH)
                .notificationChannel(
                    OrganizationSpendAlert.NotificationChannel.builder()
                        .addRecipient("string")
                        .subjectPrefix("subject_prefix")
                        .build()
                )
                .thresholdAmount(0L)
                .build()

        assertThat(organizationSpendAlert.id()).isEqualTo("id")
        assertThat(organizationSpendAlert.currency()).isEqualTo(OrganizationSpendAlert.Currency.USD)
        assertThat(organizationSpendAlert.interval())
            .isEqualTo(OrganizationSpendAlert.Interval.MONTH)
        assertThat(organizationSpendAlert.notificationChannel())
            .isEqualTo(
                OrganizationSpendAlert.NotificationChannel.builder()
                    .addRecipient("string")
                    .subjectPrefix("subject_prefix")
                    .build()
            )
        assertThat(organizationSpendAlert.thresholdAmount()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val organizationSpendAlert =
            OrganizationSpendAlert.builder()
                .id("id")
                .currency(OrganizationSpendAlert.Currency.USD)
                .interval(OrganizationSpendAlert.Interval.MONTH)
                .notificationChannel(
                    OrganizationSpendAlert.NotificationChannel.builder()
                        .addRecipient("string")
                        .subjectPrefix("subject_prefix")
                        .build()
                )
                .thresholdAmount(0L)
                .build()

        val roundtrippedOrganizationSpendAlert =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(organizationSpendAlert),
                jacksonTypeRef<OrganizationSpendAlert>(),
            )

        assertThat(roundtrippedOrganizationSpendAlert).isEqualTo(organizationSpendAlert)
    }
}
