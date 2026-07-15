// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.spendalerts

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SpendAlertCreateParamsTest {

    @Test
    fun create() {
        SpendAlertCreateParams.builder()
            .projectId("project_id")
            .currency(SpendAlertCreateParams.Currency.USD)
            .interval(SpendAlertCreateParams.Interval.MONTH)
            .notificationChannel(
                SpendAlertCreateParams.NotificationChannel.builder()
                    .addRecipient("string")
                    .subjectPrefix("subject_prefix")
                    .build()
            )
            .thresholdAmount(0L)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            SpendAlertCreateParams.builder()
                .projectId("project_id")
                .currency(SpendAlertCreateParams.Currency.USD)
                .interval(SpendAlertCreateParams.Interval.MONTH)
                .notificationChannel(
                    SpendAlertCreateParams.NotificationChannel.builder()
                        .addRecipient("string")
                        .build()
                )
                .thresholdAmount(0L)
                .build()

        assertThat(params._pathParam(0)).isEqualTo("project_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            SpendAlertCreateParams.builder()
                .projectId("project_id")
                .currency(SpendAlertCreateParams.Currency.USD)
                .interval(SpendAlertCreateParams.Interval.MONTH)
                .notificationChannel(
                    SpendAlertCreateParams.NotificationChannel.builder()
                        .addRecipient("string")
                        .subjectPrefix("subject_prefix")
                        .build()
                )
                .thresholdAmount(0L)
                .build()

        val body = params._body()

        assertThat(body.currency()).isEqualTo(SpendAlertCreateParams.Currency.USD)
        assertThat(body.interval()).isEqualTo(SpendAlertCreateParams.Interval.MONTH)
        assertThat(body.notificationChannel())
            .isEqualTo(
                SpendAlertCreateParams.NotificationChannel.builder()
                    .addRecipient("string")
                    .subjectPrefix("subject_prefix")
                    .build()
            )
        assertThat(body.thresholdAmount()).isEqualTo(0L)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            SpendAlertCreateParams.builder()
                .projectId("project_id")
                .currency(SpendAlertCreateParams.Currency.USD)
                .interval(SpendAlertCreateParams.Interval.MONTH)
                .notificationChannel(
                    SpendAlertCreateParams.NotificationChannel.builder()
                        .addRecipient("string")
                        .build()
                )
                .thresholdAmount(0L)
                .build()

        val body = params._body()

        assertThat(body.currency()).isEqualTo(SpendAlertCreateParams.Currency.USD)
        assertThat(body.interval()).isEqualTo(SpendAlertCreateParams.Interval.MONTH)
        assertThat(body.notificationChannel())
            .isEqualTo(
                SpendAlertCreateParams.NotificationChannel.builder().addRecipient("string").build()
            )
        assertThat(body.thresholdAmount()).isEqualTo(0L)
    }
}
