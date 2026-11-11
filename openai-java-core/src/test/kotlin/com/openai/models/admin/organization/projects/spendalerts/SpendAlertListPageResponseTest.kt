// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.projects.spendalerts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SpendAlertListPageResponseTest {

    @Test
    fun createAndRoundtrip() {
        val spendAlertListPageResponse =
            SpendAlertListPageResponse.builder()
                .addData(
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
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(spendAlertListPageResponse.data().getOrNull())
            .containsExactly(
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
            )
        assertThat(spendAlertListPageResponse.firstId()).contains("first_id")
        assertThat(spendAlertListPageResponse.hasMore()).contains(true)
        assertThat(spendAlertListPageResponse.lastId()).contains("last_id")

        val jsonMapper = jsonMapper()

        val roundtrippedSpendAlertListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(spendAlertListPageResponse),
                jacksonTypeRef<SpendAlertListPageResponse>(),
            )

        assertThat(roundtrippedSpendAlertListPageResponse).isEqualTo(spendAlertListPageResponse)
    }
}
