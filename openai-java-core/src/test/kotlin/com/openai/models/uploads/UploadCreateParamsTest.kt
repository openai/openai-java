// File generated from our OpenAPI spec by Stainless.

package com.openai.models.uploads

import com.openai.models.files.FilePurpose
import kotlin.test.assertNotNull
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
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.bytes()).isEqualTo(0L)
        assertThat(body.filename()).isEqualTo("filename")
        assertThat(body.mimeType()).isEqualTo("mime_type")
        assertThat(body.purpose()).isEqualTo(FilePurpose.ASSISTANTS)
    }
}
