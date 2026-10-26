// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.videos

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ImageInputReferenceParamTest {

    @Test
    fun createAndRoundtrip() {
        val imageInputReferenceParam =
            ImageInputReferenceParam.builder()
                .fileId("file-123")
                .imageUrl("https://example.com")
                .build()

        assertThat(imageInputReferenceParam.fileId()).contains("file-123")
        assertThat(imageInputReferenceParam.imageUrl()).contains("https://example.com")

        val jsonMapper = jsonMapper()

        val roundtrippedImageInputReferenceParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(imageInputReferenceParam),
                jacksonTypeRef<ImageInputReferenceParam>(),
            )

        assertThat(roundtrippedImageInputReferenceParam).isEqualTo(imageInputReferenceParam)
    }
}
