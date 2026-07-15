// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.admin.organization.spendalerts.SpendAlertCreateParams
import com.openai.models.admin.organization.spendalerts.SpendAlertUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class SpendAlertServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val spendAlertServiceAsync = client.admin().organization().spendAlerts()

        val organizationSpendAlertFuture =
            spendAlertServiceAsync.create(
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

        val organizationSpendAlert = organizationSpendAlertFuture.get()
        organizationSpendAlert.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val spendAlertServiceAsync = client.admin().organization().spendAlerts()

        val organizationSpendAlertFuture = spendAlertServiceAsync.retrieve("alert_id")

        val organizationSpendAlert = organizationSpendAlertFuture.get()
        organizationSpendAlert.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val spendAlertServiceAsync = client.admin().organization().spendAlerts()

        val organizationSpendAlertFuture =
            spendAlertServiceAsync.update(
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

        val organizationSpendAlert = organizationSpendAlertFuture.get()
        organizationSpendAlert.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val spendAlertServiceAsync = client.admin().organization().spendAlerts()

        val pageFuture = spendAlertServiceAsync.list()

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val spendAlertServiceAsync = client.admin().organization().spendAlerts()

        val organizationSpendAlertDeletedFuture = spendAlertServiceAsync.delete("alert_id")

        val organizationSpendAlertDeleted = organizationSpendAlertDeletedFuture.get()
        organizationSpendAlertDeleted.validate()
    }
}
