// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.FilePurpose
import com.openai.models.UploadCancelParams
import com.openai.models.UploadCompleteParams
import com.openai.models.UploadCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class UploadServiceTest {

    @Test
    fun callCreate() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val uploadService = client.uploads()
        val upload =
            uploadService.create(
                UploadCreateParams.builder()
                    .bytes(0L)
                    .filename("filename")
                    .mimeType("mime_type")
                    .purpose(FilePurpose.ASSISTANTS)
                    .build()
            )
        println(upload)
        upload.validate()
    }

    @Test
    fun callCancel() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val uploadService = client.uploads()
        val upload =
            uploadService.cancel(UploadCancelParams.builder().uploadId("upload_abc123").build())
        println(upload)
        upload.validate()
    }

    @Test
    fun callComplete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val uploadService = client.uploads()
        val upload =
            uploadService.complete(
                UploadCompleteParams.builder()
                    .uploadId("upload_abc123")
                    .addPartId("string")
                    .md5("md5")
                    .build()
            )
        println(upload)
        upload.validate()
    }
}
