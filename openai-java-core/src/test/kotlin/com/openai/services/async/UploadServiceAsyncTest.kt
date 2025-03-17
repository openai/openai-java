// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.files.FilePurpose
import com.openai.models.uploads.UploadCancelParams
import com.openai.models.uploads.UploadCompleteParams
import com.openai.models.uploads.UploadCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class UploadServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val uploadServiceAsync = client.uploads()

        val uploadFuture =
            uploadServiceAsync.create(
                UploadCreateParams.builder()
                    .bytes(0L)
                    .filename("filename")
                    .mimeType("mime_type")
                    .purpose(FilePurpose.ASSISTANTS)
                    .build()
            )

        val upload = uploadFuture.get()
        upload.validate()
    }

    @Test
    fun cancel() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val uploadServiceAsync = client.uploads()

        val uploadFuture =
            uploadServiceAsync.cancel(
                UploadCancelParams.builder().uploadId("upload_abc123").build()
            )

        val upload = uploadFuture.get()
        upload.validate()
    }

    @Test
    fun complete() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val uploadServiceAsync = client.uploads()

        val uploadFuture =
            uploadServiceAsync.complete(
                UploadCompleteParams.builder()
                    .uploadId("upload_abc123")
                    .addPartId("string")
                    .md5("md5")
                    .build()
            )

        val upload = uploadFuture.get()
        upload.validate()
    }
}
