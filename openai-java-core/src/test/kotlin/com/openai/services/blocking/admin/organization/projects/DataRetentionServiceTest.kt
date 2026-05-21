// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization.projects

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.admin.organization.projects.dataretention.DataRetentionUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class DataRetentionServiceTest {

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val dataRetentionService = client.admin().organization().projects().dataRetention()

        val projectDataRetention = dataRetentionService.retrieve("project_id")

        projectDataRetention.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val dataRetentionService = client.admin().organization().projects().dataRetention()

        val projectDataRetention =
            dataRetentionService.update(
                DataRetentionUpdateParams.builder()
                    .projectId("project_id")
                    .retentionType(DataRetentionUpdateParams.RetentionType.ORGANIZATION_DEFAULT)
                    .build()
            )

        projectDataRetention.validate()
    }
}
