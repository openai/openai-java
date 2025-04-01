// File generated from our OpenAPI spec by Stainless.

package com.openai.models.uploads.parts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UploadPartTest {

    @Test
    fun create() {
        val uploadPart = UploadPart.builder().id("id").createdAt(0L).uploadId("upload_id").build()

        assertThat(uploadPart.id()).isEqualTo("id")
        assertThat(uploadPart.createdAt()).isEqualTo(0L)
        assertThat(uploadPart.uploadId()).isEqualTo("upload_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val uploadPart = UploadPart.builder().id("id").createdAt(0L).uploadId("upload_id").build()

        val roundtrippedUploadPart =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(uploadPart),
                jacksonTypeRef<UploadPart>(),
            )

        assertThat(roundtrippedUploadPart).isEqualTo(uploadPart)
    }
}
