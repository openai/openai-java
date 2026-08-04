// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization.projects

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.admin.organization.projects.spendlimit.SpendLimitUpdateParams
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
        val spendLimitServiceAsync = client.admin().organization().projects().spendLimit()

        val projectSpendLimitFuture = spendLimitServiceAsync.retrieve("proj_123")

        val projectSpendLimit = projectSpendLimitFuture.get()
        projectSpendLimit.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val spendLimitServiceAsync = client.admin().organization().projects().spendLimit()

        val projectSpendLimitFuture =
            spendLimitServiceAsync.update(
                SpendLimitUpdateParams.builder()
                    .projectId("proj_123")
                    .currency(SpendLimitUpdateParams.Currency.USD)
                    .interval(SpendLimitUpdateParams.Interval.MONTH)
                    .thresholdAmount(1L)
                    .build()
            )

        val projectSpendLimit = projectSpendLimitFuture.get()
        projectSpendLimit.validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val spendLimitServiceAsync = client.admin().organization().projects().spendLimit()

        val projectSpendLimitDeletedFuture = spendLimitServiceAsync.delete("proj_123")

        val projectSpendLimitDeleted = projectSpendLimitDeletedFuture.get()
        projectSpendLimitDeleted.validate()
    }
}
