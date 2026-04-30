// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization.projects

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.admin.organization.projects.apikeys.ApiKeyDeleteParams
import com.openai.models.admin.organization.projects.apikeys.ApiKeyRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ApiKeyServiceAsyncTest {

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val apiKeyServiceAsync = client.admin().organization().projects().apiKeys()

        val projectApiKeyFuture =
            apiKeyServiceAsync.retrieve(
                ApiKeyRetrieveParams.builder().projectId("project_id").keyId("key_id").build()
            )

        val projectApiKey = projectApiKeyFuture.get()
        projectApiKey.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val apiKeyServiceAsync = client.admin().organization().projects().apiKeys()

        val pageFuture = apiKeyServiceAsync.list("project_id")

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val apiKeyServiceAsync = client.admin().organization().projects().apiKeys()

        val apiKeyFuture =
            apiKeyServiceAsync.delete(
                ApiKeyDeleteParams.builder().projectId("project_id").keyId("key_id").build()
            )

        val apiKey = apiKeyFuture.get()
        apiKey.validate()
    }
}
