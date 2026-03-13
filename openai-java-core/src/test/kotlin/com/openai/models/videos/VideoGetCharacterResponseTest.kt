// File generated from our OpenAPI spec by Stainless.

package com.openai.models.videos

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VideoGetCharacterResponseTest {

    @Test
    fun create() {
        val videoGetCharacterResponse =
            VideoGetCharacterResponse.builder().id("id").createdAt(0L).name("name").build()

        assertThat(videoGetCharacterResponse.id()).contains("id")
        assertThat(videoGetCharacterResponse.createdAt()).isEqualTo(0L)
        assertThat(videoGetCharacterResponse.name()).contains("name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val videoGetCharacterResponse =
            VideoGetCharacterResponse.builder().id("id").createdAt(0L).name("name").build()

        val roundtrippedVideoGetCharacterResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(videoGetCharacterResponse),
                jacksonTypeRef<VideoGetCharacterResponse>(),
            )

        assertThat(roundtrippedVideoGetCharacterResponse).isEqualTo(videoGetCharacterResponse)
    }
}
