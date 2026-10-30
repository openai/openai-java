// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.admin.organization

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.admin.organization.externalkeys.ExternalKeyCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ExternalKeyServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val externalKeyService = client.admin().organization().externalKeys()

        val externalKey =
            externalKeyService.create(
                ExternalKeyCreateParams.Body.ofAws(
                    ExternalKeyCreateParams.Body.Aws.builder()
                        .externalId("external_id")
                        .kmsArn("kms_arn")
                        .name("name")
                        .roleArn("arn:aws:iam::123456789012:role/example-role")
                        .purpose(ExternalKeyCreateParams.Body.Aws.Purpose.EKM)
                        .build()
                )
            )

        externalKey.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val externalKeyService = client.admin().organization().externalKeys()

        val externalKey = externalKeyService.retrieve("external_key_id")

        externalKey.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val externalKeyService = client.admin().organization().externalKeys()

        val page = externalKeyService.list()

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
        val externalKeyService = client.admin().organization().externalKeys()

        val externalKey = externalKeyService.delete("external_key_id")

        externalKey.validate()
    }

    @Test
    fun validate() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val externalKeyService = client.admin().organization().externalKeys()

        val response = externalKeyService.validate("external_key_id")

        response.validate()
    }
}
