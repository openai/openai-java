// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.videos

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VideoDeleteResponseTest {

    @Test
    fun createAndRoundtrip() {
        val videoDeleteResponse = VideoDeleteResponse.builder().id("id").deleted(true).build()

        assertThat(videoDeleteResponse.id()).contains("id")
        assertThat(videoDeleteResponse.deleted()).contains(true)

        val jsonMapper = jsonMapper()

        val roundtrippedVideoDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(videoDeleteResponse),
                jacksonTypeRef<VideoDeleteResponse>(),
            )

        assertThat(roundtrippedVideoDeleteResponse).isEqualTo(videoDeleteResponse)
    }
}
