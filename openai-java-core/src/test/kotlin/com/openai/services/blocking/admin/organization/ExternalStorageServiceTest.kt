// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.admin.organization

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.admin.organization.externalstorage.ExternalStorageCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ExternalStorageServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val externalStorageService = client.admin().organization().externalStorage()

        val externalStorageConfiguration =
            externalStorageService.create(
                ExternalStorageCreateParams.builder()
                    .projectId("proj_123")
                    .provider(
                        ExternalStorageCreateParams.Provider.Aws.builder()
                            .bucket("bucket")
                            .roleArn("role_arn")
                            .build()
                    )
                    .build()
            )

        externalStorageConfiguration.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val externalStorageService = client.admin().organization().externalStorage()

        val externalStorageConfiguration = externalStorageService.retrieve("extstorage_123")

        externalStorageConfiguration.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val externalStorageService = client.admin().organization().externalStorage()

        val page = externalStorageService.list()

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
        val externalStorageService = client.admin().organization().externalStorage()

        val externalStorageDeleted = externalStorageService.delete("extstorage_123")

        externalStorageDeleted.validate()
    }

    @Test
    fun validate() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val externalStorageService = client.admin().organization().externalStorage()

        val externalStorageConfiguration = externalStorageService.validate("extstorage_123")

        externalStorageConfiguration.validate()
    }
}
