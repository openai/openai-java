// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.containers

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.containers.files.FileCreateParams
import com.openai.models.containers.files.FileDeleteParams
import com.openai.models.containers.files.FileRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class FileServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileServiceAsync = client.containers().files()

        val fileFuture =
            fileServiceAsync.create(
                FileCreateParams.builder()
                    .containerId("container_id")
                    .file("some content".byteInputStream())
                    .fileId("file_id")
                    .build()
            )

        val file = fileFuture.get()
        file.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileServiceAsync = client.containers().files()

        val fileFuture =
            fileServiceAsync.retrieve(
                FileRetrieveParams.builder().containerId("container_id").fileId("file_id").build()
            )

        val file = fileFuture.get()
        file.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileServiceAsync = client.containers().files()

        val pageFuture = fileServiceAsync.list("container_id")

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileServiceAsync = client.containers().files()

        val future =
            fileServiceAsync.delete(
                FileDeleteParams.builder().containerId("container_id").fileId("file_id").build()
            )

        val response = future.get()
    }
}
