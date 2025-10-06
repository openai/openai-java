// File generated from our OpenAPI spec by Stainless.

package com.openai.models.videos

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VideoDeleteParamsTest {

    @Test
    fun create() {
        VideoDeleteParams.builder().videoId("video_123").build()
    }

    @Test
    fun pathParams() {
        val params = VideoDeleteParams.builder().videoId("video_123").build()

        assertThat(params._pathParam(0)).isEqualTo("video_123")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
