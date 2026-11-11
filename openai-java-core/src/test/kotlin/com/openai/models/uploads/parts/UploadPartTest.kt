// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.uploads.parts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UploadPartTest {

    @Test
    fun createAndRoundtrip() {
        val uploadPart = UploadPart.builder().id("id").createdAt(0L).uploadId("upload_id").build()

        assertThat(uploadPart.id()).contains("id")
        assertThat(uploadPart.createdAt()).contains(0L)
        assertThat(uploadPart.uploadId()).contains("upload_id")

        val jsonMapper = jsonMapper()

        val roundtrippedUploadPart =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(uploadPart),
                jacksonTypeRef<UploadPart>(),
            )

        assertThat(roundtrippedUploadPart).isEqualTo(uploadPart)
    }
}
