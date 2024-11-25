// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UploadPartTest {

    @Test
    fun createUploadPart() {
        val uploadPart =
            UploadPart.builder()
                .id("id")
                .createdAt(0L)
                .object_(UploadPart.Object.UPLOAD_PART)
                .uploadId("upload_id")
                .build()
        assertThat(uploadPart).isNotNull
        assertThat(uploadPart.id()).isEqualTo("id")
        assertThat(uploadPart.createdAt()).isEqualTo(0L)
        assertThat(uploadPart.object_()).isEqualTo(UploadPart.Object.UPLOAD_PART)
        assertThat(uploadPart.uploadId()).isEqualTo("upload_id")
    }
}
