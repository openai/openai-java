// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization.projects.serviceaccounts

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.admin.organization.projects.serviceaccounts.apikeys.ApiKeyCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ApiKeyServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val apiKeyService = client.admin().organization().projects().serviceAccounts().apiKeys()

        val apiKey =
            apiKeyService.create(
                ApiKeyCreateParams.builder()
                    .projectId("project_id")
                    .serviceAccountId("service_account_id")
                    .name("name")
                    .addScope("string")
                    .build()
            )

        apiKey.validate()
    }
}
