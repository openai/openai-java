// File generated from our OpenAPI spec by Stainless.

package com.openai.models.videos

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VideoDeleteResponseTest {

    @Test
    fun create() {
        val videoDeleteResponse = VideoDeleteResponse.builder().id("id").deleted(true).build()

        assertThat(videoDeleteResponse.id()).isEqualTo("id")
        assertThat(videoDeleteResponse.deleted()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val videoDeleteResponse = VideoDeleteResponse.builder().id("id").deleted(true).build()

        val roundtrippedVideoDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(videoDeleteResponse),
                jacksonTypeRef<VideoDeleteResponse>(),
            )

        assertThat(roundtrippedVideoDeleteResponse).isEqualTo(videoDeleteResponse)
    }
}
