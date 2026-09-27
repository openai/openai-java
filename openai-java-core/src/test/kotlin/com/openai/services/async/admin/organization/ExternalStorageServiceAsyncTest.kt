// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.admin.organization

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.admin.organization.externalstorage.ExternalStorageCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ExternalStorageServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val externalStorageServiceAsync = client.admin().organization().externalStorage()

        val externalStorageConfigurationFuture =
            externalStorageServiceAsync.create(
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

        val externalStorageConfiguration = externalStorageConfigurationFuture.get()
        externalStorageConfiguration.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val externalStorageServiceAsync = client.admin().organization().externalStorage()

        val externalStorageConfigurationFuture =
            externalStorageServiceAsync.retrieve("extstorage_123")

        val externalStorageConfiguration = externalStorageConfigurationFuture.get()
        externalStorageConfiguration.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val externalStorageServiceAsync = client.admin().organization().externalStorage()

        val pageFuture = externalStorageServiceAsync.list()

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
        val externalStorageServiceAsync = client.admin().organization().externalStorage()

        val externalStorageDeletedFuture = externalStorageServiceAsync.delete("extstorage_123")

        val externalStorageDeleted = externalStorageDeletedFuture.get()
        externalStorageDeleted.validate()
    }

    @Test
    fun validate() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val externalStorageServiceAsync = client.admin().organization().externalStorage()

        val externalStorageConfigurationFuture =
            externalStorageServiceAsync.validate("extstorage_123")

        val externalStorageConfiguration = externalStorageConfigurationFuture.get()
        externalStorageConfiguration.validate()
    }
}
