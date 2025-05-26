// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.containers

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.containers.files.FileCreateParams
import com.openai.models.containers.files.FileDeleteParams
import com.openai.models.containers.files.FileRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class FileServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileService = client.containers().files()

        val file =
            fileService.create(
                FileCreateParams.builder()
                    .containerId("container_id")
                    .file("some content".byteInputStream())
                    .fileId("file_id")
                    .build()
            )

        file.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileService = client.containers().files()

        val file =
            fileService.retrieve(
                FileRetrieveParams.builder().containerId("container_id").fileId("file_id").build()
            )

        file.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileService = client.containers().files()

        val page = fileService.list("container_id")

        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileService = client.containers().files()

        fileService.delete(
            FileDeleteParams.builder().containerId("container_id").fileId("file_id").build()
        )
    }
}
