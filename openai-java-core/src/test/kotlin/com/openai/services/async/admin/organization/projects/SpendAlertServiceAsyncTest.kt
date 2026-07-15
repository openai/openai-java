// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization.projects

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.admin.organization.projects.spendalerts.SpendAlertCreateParams
import com.openai.models.admin.organization.projects.spendalerts.SpendAlertDeleteParams
import com.openai.models.admin.organization.projects.spendalerts.SpendAlertRetrieveParams
import com.openai.models.admin.organization.projects.spendalerts.SpendAlertUpdateParams
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
        val spendAlertServiceAsync = client.admin().organization().projects().spendAlerts()

        val projectSpendAlertFuture =
            spendAlertServiceAsync.create(
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
            )

        val projectSpendAlert = projectSpendAlertFuture.get()
        projectSpendAlert.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val spendAlertServiceAsync = client.admin().organization().projects().spendAlerts()

        val projectSpendAlertFuture =
            spendAlertServiceAsync.retrieve(
                SpendAlertRetrieveParams.builder()
                    .projectId("project_id")
                    .alertId("alert_id")
                    .build()
            )

        val projectSpendAlert = projectSpendAlertFuture.get()
        projectSpendAlert.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val spendAlertServiceAsync = client.admin().organization().projects().spendAlerts()

        val projectSpendAlertFuture =
            spendAlertServiceAsync.update(
                SpendAlertUpdateParams.builder()
                    .projectId("project_id")
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

        val projectSpendAlert = projectSpendAlertFuture.get()
        projectSpendAlert.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val spendAlertServiceAsync = client.admin().organization().projects().spendAlerts()

        val pageFuture = spendAlertServiceAsync.list("project_id")

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
        val spendAlertServiceAsync = client.admin().organization().projects().spendAlerts()

        val projectSpendAlertDeletedFuture =
            spendAlertServiceAsync.delete(
                SpendAlertDeleteParams.builder().projectId("project_id").alertId("alert_id").build()
            )

        val projectSpendAlertDeleted = projectSpendAlertDeletedFuture.get()
        projectSpendAlertDeleted.validate()
    }
}
