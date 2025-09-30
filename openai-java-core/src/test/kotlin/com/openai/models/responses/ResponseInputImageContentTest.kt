// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseInputImageContentTest {

    @Test
    fun create() {
        val responseInputImageContent =
            ResponseInputImageContent.builder()
                .detail(ResponseInputImageContent.Detail.LOW)
                .fileId("file-123")
                .imageUrl("image_url")
                .build()

        assertThat(responseInputImageContent.detail())
            .contains(ResponseInputImageContent.Detail.LOW)
        assertThat(responseInputImageContent.fileId()).contains("file-123")
        assertThat(responseInputImageContent.imageUrl()).contains("image_url")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseInputImageContent =
            ResponseInputImageContent.builder()
                .detail(ResponseInputImageContent.Detail.LOW)
                .fileId("file-123")
                .imageUrl("image_url")
                .build()

        val roundtrippedResponseInputImageContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseInputImageContent),
                jacksonTypeRef<ResponseInputImageContent>(),
            )

        assertThat(roundtrippedResponseInputImageContent).isEqualTo(responseInputImageContent)
    }
}
