// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization.projects

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.admin.organization.projects.apikeys.ApiKeyDeleteParams
import com.openai.models.admin.organization.projects.apikeys.ApiKeyRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ApiKeyServiceTest {

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val apiKeyService = client.admin().organization().projects().apiKeys()

        val projectApiKey =
            apiKeyService.retrieve(
                ApiKeyRetrieveParams.builder()
                    .projectId("project_id")
                    .apiKeyId("api_key_id")
                    .build()
            )

        projectApiKey.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val apiKeyService = client.admin().organization().projects().apiKeys()

        val page = apiKeyService.list("project_id")

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
        val apiKeyService = client.admin().organization().projects().apiKeys()

        val apiKey =
            apiKeyService.delete(
                ApiKeyDeleteParams.builder().projectId("project_id").apiKeyId("api_key_id").build()
            )

        apiKey.validate()
    }
}
