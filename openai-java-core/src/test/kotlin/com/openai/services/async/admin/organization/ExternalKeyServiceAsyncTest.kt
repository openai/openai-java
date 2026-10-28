// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.admin.organization

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.admin.organization.externalkeys.ExternalKeyCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ExternalKeyServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val externalKeyServiceAsync = client.admin().organization().externalKeys()

        val externalKeyFuture =
            externalKeyServiceAsync.create(
                ExternalKeyCreateParams.Body.ofAws(
                    ExternalKeyCreateParams.Body.Aws.builder()
                        .externalId("external_id")
                        .kmsArn("kms_arn")
                        .name("name")
                        .roleArn("arn:aws:iam::732166991022:role/0*bWz\"J5bo7")
                        .purpose(ExternalKeyCreateParams.Body.Aws.Purpose.EKM)
                        .build()
                )
            )

        val externalKey = externalKeyFuture.get()
        externalKey.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val externalKeyServiceAsync = client.admin().organization().externalKeys()

        val externalKeyFuture = externalKeyServiceAsync.retrieve("external_key_id")

        val externalKey = externalKeyFuture.get()
        externalKey.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val externalKeyServiceAsync = client.admin().organization().externalKeys()

        val pageFuture = externalKeyServiceAsync.list()

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
        val externalKeyServiceAsync = client.admin().organization().externalKeys()

        val externalKeyFuture = externalKeyServiceAsync.delete("external_key_id")

        val externalKey = externalKeyFuture.get()
        externalKey.validate()
    }

    @Test
    fun validate() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val externalKeyServiceAsync = client.admin().organization().externalKeys()

        val responseFuture = externalKeyServiceAsync.validate("external_key_id")

        val response = responseFuture.get()
        response.validate()
    }
}
