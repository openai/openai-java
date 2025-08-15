// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.files.FilePurpose
import com.openai.models.uploads.UploadCompleteParams
import com.openai.models.uploads.UploadCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class UploadServiceTest {

    @Test
    fun create() {
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
                    .expiresAfter(UploadCreateParams.ExpiresAfter.builder().seconds(3600L).build())
                    .build()
            )

        upload.validate()
    }

    @Test
    fun cancel() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val uploadService = client.uploads()

        val upload = uploadService.cancel("upload_abc123")

        upload.validate()
    }

    @Test
    fun complete() {
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

        upload.validate()
    }
}
