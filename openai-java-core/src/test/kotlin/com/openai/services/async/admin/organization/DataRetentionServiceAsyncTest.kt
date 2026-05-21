// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.admin.organization.dataretention.DataRetentionUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class DataRetentionServiceAsyncTest {

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val dataRetentionServiceAsync = client.admin().organization().dataRetention()

        val organizationDataRetentionFuture = dataRetentionServiceAsync.retrieve()

        val organizationDataRetention = organizationDataRetentionFuture.get()
        organizationDataRetention.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val dataRetentionServiceAsync = client.admin().organization().dataRetention()

        val organizationDataRetentionFuture =
            dataRetentionServiceAsync.update(
                DataRetentionUpdateParams.builder()
                    .retentionType(DataRetentionUpdateParams.RetentionType.ZERO_DATA_RETENTION)
                    .build()
            )

        val organizationDataRetention = organizationDataRetentionFuture.get()
        organizationDataRetention.validate()
    }
}
