// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.spendalerts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProjectSpendAlertTest {

    @Test
    fun create() {
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

        assertThat(projectSpendAlert.id()).isEqualTo("id")
        assertThat(projectSpendAlert.currency()).isEqualTo(ProjectSpendAlert.Currency.USD)
        assertThat(projectSpendAlert.interval()).isEqualTo(ProjectSpendAlert.Interval.MONTH)
        assertThat(projectSpendAlert.notificationChannel())
            .isEqualTo(
                ProjectSpendAlert.NotificationChannel.builder()
                    .addRecipient("string")
                    .subjectPrefix("subject_prefix")
                    .build()
            )
        assertThat(projectSpendAlert.thresholdAmount()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
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

        val roundtrippedProjectSpendAlert =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(projectSpendAlert),
                jacksonTypeRef<ProjectSpendAlert>(),
            )

        assertThat(roundtrippedProjectSpendAlert).isEqualTo(projectSpendAlert)
    }
}
