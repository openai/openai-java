// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.admin.organization.spendlimit.SpendLimitUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class SpendLimitServiceAsyncTest {

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val spendLimitServiceAsync = client.admin().organization().spendLimit()

        val organizationSpendLimitFuture = spendLimitServiceAsync.retrieve()

        val organizationSpendLimit = organizationSpendLimitFuture.get()
        organizationSpendLimit.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val spendLimitServiceAsync = client.admin().organization().spendLimit()

        val organizationSpendLimitFuture =
            spendLimitServiceAsync.update(
                SpendLimitUpdateParams.builder()
                    .currency(SpendLimitUpdateParams.Currency.USD)
                    .interval(SpendLimitUpdateParams.Interval.MONTH)
                    .thresholdAmount(1L)
                    .build()
            )

        val organizationSpendLimit = organizationSpendLimitFuture.get()
        organizationSpendLimit.validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val spendLimitServiceAsync = client.admin().organization().spendLimit()

        val organizationSpendLimitDeletedFuture = spendLimitServiceAsync.delete()

        val organizationSpendLimitDeleted = organizationSpendLimitDeletedFuture.get()
        organizationSpendLimitDeleted.validate()
    }
}
