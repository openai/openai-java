// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.admin.organization.spendlimit.SpendLimitUpdateParams
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
        val spendLimitService = client.admin().organization().spendLimit()

        val organizationSpendLimit = spendLimitService.retrieve()

        organizationSpendLimit.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val spendLimitService = client.admin().organization().spendLimit()

        val organizationSpendLimit =
            spendLimitService.update(
                SpendLimitUpdateParams.builder()
                    .currency(SpendLimitUpdateParams.Currency.USD)
                    .interval(SpendLimitUpdateParams.Interval.MONTH)
                    .thresholdAmount(1L)
                    .build()
            )

        organizationSpendLimit.validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val spendLimitService = client.admin().organization().spendLimit()

        val organizationSpendLimitDeleted = spendLimitService.delete()

        organizationSpendLimitDeleted.validate()
    }
}
