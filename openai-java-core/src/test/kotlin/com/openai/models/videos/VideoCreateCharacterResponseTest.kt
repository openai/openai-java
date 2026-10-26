// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.videos

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VideoCreateCharacterResponseTest {

    @Test
    fun createAndRoundtrip() {
        val videoCreateCharacterResponse =
            VideoCreateCharacterResponse.builder().id("id").createdAt(0L).name("name").build()

        assertThat(videoCreateCharacterResponse.id()).contains("id")
        assertThat(videoCreateCharacterResponse.createdAt()).isEqualTo(0L)
        assertThat(videoCreateCharacterResponse.name()).contains("name")

        val jsonMapper = jsonMapper()

        val roundtrippedVideoCreateCharacterResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(videoCreateCharacterResponse),
                jacksonTypeRef<VideoCreateCharacterResponse>(),
            )

        assertThat(roundtrippedVideoCreateCharacterResponse).isEqualTo(videoCreateCharacterResponse)
    }
}
