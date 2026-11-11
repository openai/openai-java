// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.spendalerts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrganizationSpendAlertTest {

    @Test
    fun createAndRoundtrip() {
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

        assertThat(organizationSpendAlert.id()).contains("id")
        assertThat(organizationSpendAlert.currency()).contains(OrganizationSpendAlert.Currency.USD)
        assertThat(organizationSpendAlert.interval())
            .contains(OrganizationSpendAlert.Interval.MONTH)
        assertThat(organizationSpendAlert.notificationChannel())
            .contains(
                OrganizationSpendAlert.NotificationChannel.builder()
                    .addRecipient("string")
                    .subjectPrefix("subject_prefix")
                    .build()
            )
        assertThat(organizationSpendAlert.thresholdAmount()).contains(0L)

        val jsonMapper = jsonMapper()

        val roundtrippedOrganizationSpendAlert =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(organizationSpendAlert),
                jacksonTypeRef<OrganizationSpendAlert>(),
            )

        assertThat(roundtrippedOrganizationSpendAlert).isEqualTo(organizationSpendAlert)
    }
}
