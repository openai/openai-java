// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization.projects

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.admin.organization.projects.spendlimit.SpendLimitUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class SpendLimitServiceTest {

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val spendLimitService = client.admin().organization().projects().spendLimit()

        val projectSpendLimit = spendLimitService.retrieve("proj_123")

        projectSpendLimit.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val spendLimitService = client.admin().organization().projects().spendLimit()

        val projectSpendLimit =
            spendLimitService.update(
                SpendLimitUpdateParams.builder()
                    .projectId("proj_123")
                    .currency(SpendLimitUpdateParams.Currency.USD)
                    .interval(SpendLimitUpdateParams.Interval.MONTH)
                    .thresholdAmount(1L)
                    .build()
            )

        projectSpendLimit.validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val spendLimitService = client.admin().organization().projects().spendLimit()

        val projectSpendLimitDeleted = spendLimitService.delete("proj_123")

        projectSpendLimitDeleted.validate()
    }
}
