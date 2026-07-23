// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization.projects.serviceaccounts

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.admin.organization.projects.serviceaccounts.apikeys.ApiKeyCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ApiKeyServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val apiKeyServiceAsync =
            client.admin().organization().projects().serviceAccounts().apiKeys()

        val apiKeyFuture =
            apiKeyServiceAsync.create(
                ApiKeyCreateParams.builder()
                    .projectId("project_id")
                    .serviceAccountId("service_account_id")
                    .name("name")
                    .addScope("string")
                    .build()
            )

        val apiKey = apiKeyFuture.get()
        apiKey.validate()
    }
}
