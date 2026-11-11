// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.projects.spendalerts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProjectSpendAlertTest {

    @Test
    fun createAndRoundtrip() {
        val projectSpendAlert =
            ProjectSpendAlert.builder()
                .id("id")
                .currency(ProjectSpendAlert.Currency.USD)
                .interval(ProjectSpendAlert.Interval.MONTH)
                .notificationChannel(
                    ProjectSpendAlert.NotificationChannel.builder()
                        .addRecipient("string")
                        .subjectPrefix("subject_prefix")
                        .build()
                )
                .thresholdAmount(0L)
                .build()

        assertThat(projectSpendAlert.id()).contains("id")
        assertThat(projectSpendAlert.currency()).contains(ProjectSpendAlert.Currency.USD)
        assertThat(projectSpendAlert.interval()).contains(ProjectSpendAlert.Interval.MONTH)
        assertThat(projectSpendAlert.notificationChannel())
            .contains(
                ProjectSpendAlert.NotificationChannel.builder()
                    .addRecipient("string")
                    .subjectPrefix("subject_prefix")
                    .build()
            )
        assertThat(projectSpendAlert.thresholdAmount()).contains(0L)

        val jsonMapper = jsonMapper()

        val roundtrippedProjectSpendAlert =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(projectSpendAlert),
                jacksonTypeRef<ProjectSpendAlert>(),
            )

        assertThat(roundtrippedProjectSpendAlert).isEqualTo(projectSpendAlert)
    }
}
