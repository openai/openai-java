// File generated from our OpenAPI spec by Stainless.

package com.openai.models.uploads

import com.openai.models.files.FilePurpose
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UploadCreateParamsTest {

    @Test
    fun create() {
        UploadCreateParams.builder()
            .bytes(0L)
            .filename("filename")
            .mimeType("mime_type")
            .purpose(FilePurpose.ASSISTANTS)
            .expiresAfter(UploadCreateParams.ExpiresAfter.builder().seconds(3600L).build())
            .build()
    }

    @Test
    fun body() {
        val params =
            UploadCreateParams.builder()
                .bytes(0L)
                .filename("filename")
                .mimeType("mime_type")
                .purpose(FilePurpose.ASSISTANTS)
                .expiresAfter(UploadCreateParams.ExpiresAfter.builder().seconds(3600L).build())
                .build()

        val body = params._body()

        assertThat(body.bytes()).isEqualTo(0L)
        assertThat(body.filename()).isEqualTo("filename")
        assertThat(body.mimeType()).isEqualTo("mime_type")
        assertThat(body.purpose()).isEqualTo(FilePurpose.ASSISTANTS)
        assertThat(body.expiresAfter())
            .contains(UploadCreateParams.ExpiresAfter.builder().seconds(3600L).build())
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            UploadCreateParams.builder()
                .bytes(0L)
                .filename("filename")
                .mimeType("mime_type")
                .purpose(FilePurpose.ASSISTANTS)
                .build()

        val body = params._body()

        assertThat(body.bytes()).isEqualTo(0L)
        assertThat(body.filename()).isEqualTo("filename")
        assertThat(body.mimeType()).isEqualTo("mime_type")
        assertThat(body.purpose()).isEqualTo(FilePurpose.ASSISTANTS)
    }
}
