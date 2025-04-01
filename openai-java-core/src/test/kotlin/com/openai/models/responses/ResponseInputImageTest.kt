// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseInputImageTest {

    @Test
    fun create() {
        val responseInputImage =
            ResponseInputImage.builder()
                .detail(ResponseInputImage.Detail.HIGH)
                .fileId("file_id")
                .imageUrl("image_url")
                .build()

        assertThat(responseInputImage.detail()).isEqualTo(ResponseInputImage.Detail.HIGH)
        assertThat(responseInputImage.fileId()).contains("file_id")
        assertThat(responseInputImage.imageUrl()).contains("image_url")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseInputImage =
            ResponseInputImage.builder()
                .detail(ResponseInputImage.Detail.HIGH)
                .fileId("file_id")
                .imageUrl("image_url")
                .build()

        val roundtrippedResponseInputImage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseInputImage),
                jacksonTypeRef<ResponseInputImage>(),
            )

        assertThat(roundtrippedResponseInputImage).isEqualTo(responseInputImage)
    }
}
