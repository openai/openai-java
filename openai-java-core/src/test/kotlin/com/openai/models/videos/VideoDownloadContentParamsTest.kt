// File generated from our OpenAPI spec by Stainless.

package com.openai.models.videos

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VideoDownloadContentParamsTest {

    @Test
    fun create() {
        VideoDownloadContentParams.builder()
            .videoId("video_123")
            .variant(VideoDownloadContentParams.Variant.VIDEO)
            .build()
    }

    @Test
    fun pathParams() {
        val params = VideoDownloadContentParams.builder().videoId("video_123").build()

        assertThat(params._pathParam(0)).isEqualTo("video_123")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            VideoDownloadContentParams.builder()
                .videoId("video_123")
                .variant(VideoDownloadContentParams.Variant.VIDEO)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("variant", "video").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = VideoDownloadContentParams.builder().videoId("video_123").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
