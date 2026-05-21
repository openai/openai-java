// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization.projects

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.admin.organization.projects.spendalerts.SpendAlertCreateParams
import com.openai.models.admin.organization.projects.spendalerts.SpendAlertDeleteParams
import com.openai.models.admin.organization.projects.spendalerts.SpendAlertUpdateParams
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
        val spendAlertService = client.admin().organization().projects().spendAlerts()

        val projectSpendAlert =
            spendAlertService.create(
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

        projectSpendAlert.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val spendAlertService = client.admin().organization().projects().spendAlerts()

        val projectSpendAlert =
            spendAlertService.update(
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

        projectSpendAlert.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val spendAlertService = client.admin().organization().projects().spendAlerts()

        val page = spendAlertService.list("project_id")

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
        val spendAlertService = client.admin().organization().projects().spendAlerts()

        val projectSpendAlertDeleted =
            spendAlertService.delete(
                SpendAlertDeleteParams.builder().projectId("project_id").alertId("alert_id").build()
            )

        projectSpendAlertDeleted.validate()
    }
}
