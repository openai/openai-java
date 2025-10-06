// File generated from our OpenAPI spec by Stainless.

package com.openai.models.videos

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VideoCreateErrorTest {

    @Test
    fun create() {
        val videoCreateError = VideoCreateError.builder().code("code").message("message").build()

        assertThat(videoCreateError.code()).isEqualTo("code")
        assertThat(videoCreateError.message()).isEqualTo("message")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val videoCreateError = VideoCreateError.builder().code("code").message("message").build()

        val roundtrippedVideoCreateError =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(videoCreateError),
                jacksonTypeRef<VideoCreateError>(),
            )

        assertThat(roundtrippedVideoCreateError).isEqualTo(videoCreateError)
    }
}
