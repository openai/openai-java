// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.spendalerts

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SpendAlertUpdateParamsTest {

    @Test
    fun create() {
        SpendAlertUpdateParams.builder()
            .alertId("alert_id")
            .currency(SpendAlertUpdateParams.Currency.USD)
            .interval(SpendAlertUpdateParams.Interval.MONTH)
            .notificationChannel(
                SpendAlertUpdateParams.NotificationChannel.builder()
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
            SpendAlertUpdateParams.builder()
                .alertId("alert_id")
                .currency(SpendAlertUpdateParams.Currency.USD)
                .interval(SpendAlertUpdateParams.Interval.MONTH)
                .notificationChannel(
                    SpendAlertUpdateParams.NotificationChannel.builder()
                        .addRecipient("string")
                        .build()
                )
                .thresholdAmount(0L)
                .build()

        assertThat(params._pathParam(0)).isEqualTo("alert_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            SpendAlertUpdateParams.builder()
                .alertId("alert_id")
                .currency(SpendAlertUpdateParams.Currency.USD)
                .interval(SpendAlertUpdateParams.Interval.MONTH)
                .notificationChannel(
                    SpendAlertUpdateParams.NotificationChannel.builder()
                        .addRecipient("string")
                        .subjectPrefix("subject_prefix")
                        .build()
                )
                .thresholdAmount(0L)
                .build()

        val body = params._body()

        assertThat(body.currency()).isEqualTo(SpendAlertUpdateParams.Currency.USD)
        assertThat(body.interval()).isEqualTo(SpendAlertUpdateParams.Interval.MONTH)
        assertThat(body.notificationChannel())
            .isEqualTo(
                SpendAlertUpdateParams.NotificationChannel.builder()
                    .addRecipient("string")
                    .subjectPrefix("subject_prefix")
                    .build()
            )
        assertThat(body.thresholdAmount()).isEqualTo(0L)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            SpendAlertUpdateParams.builder()
                .alertId("alert_id")
                .currency(SpendAlertUpdateParams.Currency.USD)
                .interval(SpendAlertUpdateParams.Interval.MONTH)
                .notificationChannel(
                    SpendAlertUpdateParams.NotificationChannel.builder()
                        .addRecipient("string")
                        .build()
                )
                .thresholdAmount(0L)
                .build()

        val body = params._body()

        assertThat(body.currency()).isEqualTo(SpendAlertUpdateParams.Currency.USD)
        assertThat(body.interval()).isEqualTo(SpendAlertUpdateParams.Interval.MONTH)
        assertThat(body.notificationChannel())
            .isEqualTo(
                SpendAlertUpdateParams.NotificationChannel.builder().addRecipient("string").build()
            )
        assertThat(body.thresholdAmount()).isEqualTo(0L)
    }
}
