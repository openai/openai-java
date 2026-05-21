// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.admin.organization.spendalerts.SpendAlertCreateParams
import com.openai.models.admin.organization.spendalerts.SpendAlertUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class SpendAlertServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val spendAlertService = client.admin().organization().spendAlerts()

        val organizationSpendAlert =
            spendAlertService.create(
                SpendAlertCreateParams.builder()
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
            )

        organizationSpendAlert.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val spendAlertService = client.admin().organization().spendAlerts()

        val organizationSpendAlert =
            spendAlertService.update(
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
            )

        organizationSpendAlert.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val spendAlertService = client.admin().organization().spendAlerts()

        val page = spendAlertService.list()

        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val spendAlertService = client.admin().organization().spendAlerts()

        val organizationSpendAlertDeleted = spendAlertService.delete("alert_id")

        organizationSpendAlertDeleted.validate()
    }
}
