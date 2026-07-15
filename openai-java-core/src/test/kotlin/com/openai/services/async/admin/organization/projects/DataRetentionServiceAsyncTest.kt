// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization.projects

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.admin.organization.projects.dataretention.DataRetentionUpdateParams
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
        val dataRetentionServiceAsync = client.admin().organization().projects().dataRetention()

        val projectDataRetentionFuture = dataRetentionServiceAsync.retrieve("project_id")

        val projectDataRetention = projectDataRetentionFuture.get()
        projectDataRetention.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val dataRetentionServiceAsync = client.admin().organization().projects().dataRetention()

        val projectDataRetentionFuture =
            dataRetentionServiceAsync.update(
                DataRetentionUpdateParams.builder()
                    .projectId("project_id")
                    .retentionType(DataRetentionUpdateParams.RetentionType.ORGANIZATION_DEFAULT)
                    .build()
            )

        val projectDataRetention = projectDataRetentionFuture.get()
        projectDataRetention.validate()
    }
}
