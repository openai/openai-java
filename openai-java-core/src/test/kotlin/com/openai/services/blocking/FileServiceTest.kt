// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.http.HttpResponse
import com.openai.models.FileContentParams
import com.openai.models.FileDeleteParams
import com.openai.models.FileListParams
import com.openai.models.FileRetrieveParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
@WireMockTest
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

    @Test
    fun callContent(wmRuntimeInfo: WireMockRuntimeInfo) {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.getHttpBaseUrl())
                .apiKey("My API Key")
                .build()
        stubFor(get(anyUrl()).willReturn(ok().withBody("abc")))
        val fileService = client.files()
        val response = fileService.content(FileContentParams.builder().fileId("file_id").build())
        println(response)
        assertThat(response).isInstanceOf(HttpResponse::class.java)
        assertThat(response.body()).hasContent("abc")
    }
}
