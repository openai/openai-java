// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.admin.organization.adminapikeys.AdminApiKeyCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class AdminApiKeyServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val adminApiKeyServiceAsync = client.admin().organization().adminApiKeys()

        val adminApiKeyFuture =
            adminApiKeyServiceAsync.create(
                AdminApiKeyCreateParams.builder().name("New Admin Key").build()
            )

        val adminApiKey = adminApiKeyFuture.get()
        adminApiKey.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val adminApiKeyServiceAsync = client.admin().organization().adminApiKeys()

        val adminApiKeyFuture = adminApiKeyServiceAsync.retrieve("key_id")

        val adminApiKey = adminApiKeyFuture.get()
        adminApiKey.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val adminApiKeyServiceAsync = client.admin().organization().adminApiKeys()

        val pageFuture = adminApiKeyServiceAsync.list()

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
        val adminApiKeyServiceAsync = client.admin().organization().adminApiKeys()

        val adminApiKeyFuture = adminApiKeyServiceAsync.delete("key_id")

        val adminApiKey = adminApiKeyFuture.get()
        adminApiKey.validate()
    }
}
