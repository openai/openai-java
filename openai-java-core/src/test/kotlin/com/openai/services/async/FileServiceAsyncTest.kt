// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.FileContentParams
import com.openai.models.FileDeleteParams
import com.openai.models.FileRetrieveParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
@WireMockTest
class FileServiceAsyncTest {

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileServiceAsync = client.files()

        val fileObjectFuture =
            fileServiceAsync.retrieve(FileRetrieveParams.builder().fileId("file_id").build())

        val fileObject = fileObjectFuture.get()
        fileObject.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileServiceAsync = client.files()

        val pageFuture = fileServiceAsync.list()

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
        val fileServiceAsync = client.files()

        val fileDeletedFuture =
            fileServiceAsync.delete(FileDeleteParams.builder().fileId("file_id").build())

        val fileDeleted = fileDeletedFuture.get()
        fileDeleted.validate()
    }

    @Test
    fun content(wmRuntimeInfo: WireMockRuntimeInfo) {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .build()
        val fileServiceAsync = client.files()
        stubFor(get(anyUrl()).willReturn(ok().withBody("abc")))

        val responseFuture =
            fileServiceAsync.content(FileContentParams.builder().fileId("file_id").build())

        val response = responseFuture.get()
        assertThat(response.body()).hasContent("abc")
    }
}
