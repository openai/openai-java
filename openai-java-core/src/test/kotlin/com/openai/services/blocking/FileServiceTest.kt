// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.FileDeleteParams
import com.openai.models.FileListParams
import com.openai.models.FileRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class FileServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileService = client.files()
        val fileObject =
            fileService.retrieve(FileRetrieveParams.builder().fileId("file_id").build())
        println(fileObject)
        fileObject.validate()
    }

    @Test
    fun callList() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileService = client.files()
        val listFilesResponse = fileService.list(FileListParams.builder().build())
        println(listFilesResponse)
        listFilesResponse.data().forEach { it.validate() }
    }

    @Test
    fun callDelete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileService = client.files()
        val fileDeleted = fileService.delete(FileDeleteParams.builder().fileId("file_id").build())
        println(fileDeleted)
        fileDeleted.validate()
    }
}
