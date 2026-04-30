// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.admin.organization.adminapikeys.AdminApiKeyCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class AdminApiKeyServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val adminApiKeyService = client.admin().organization().adminApiKeys()

        val adminApiKey =
            adminApiKeyService.create(
                AdminApiKeyCreateParams.builder().name("New Admin Key").build()
            )

        adminApiKey.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val adminApiKeyService = client.admin().organization().adminApiKeys()

        val adminApiKey = adminApiKeyService.retrieve("key_id")

        adminApiKey.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val adminApiKeyService = client.admin().organization().adminApiKeys()

        val page = adminApiKeyService.list()

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
        val adminApiKeyService = client.admin().organization().adminApiKeys()

        val adminApiKey = adminApiKeyService.delete("key_id")

        adminApiKey.validate()
    }
}
