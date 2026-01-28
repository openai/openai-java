// File generated from our OpenAPI spec by Stainless.

package com.openai.models.videos

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VideoListPageResponseTest {

    @Test
    fun create() {
        val videoListPageResponse =
            VideoListPageResponse.builder()
                .addData(
                    Video.builder()
                        .id("id")
                        .completedAt(0L)
                        .createdAt(0L)
                        .error(VideoCreateError.builder().code("code").message("message").build())
                        .expiresAt(0L)
                        .model(VideoModel.SORA_2)
                        .progress(0L)
                        .prompt("prompt")
                        .remixedFromVideoId("remixed_from_video_id")
                        .seconds(VideoSeconds._4)
                        .size(VideoSize._720X1280)
                        .status(Video.Status.QUEUED)
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(videoListPageResponse.data())
            .containsExactly(
                Video.builder()
                    .id("id")
                    .completedAt(0L)
                    .createdAt(0L)
                    .error(VideoCreateError.builder().code("code").message("message").build())
                    .expiresAt(0L)
                    .model(VideoModel.SORA_2)
                    .progress(0L)
                    .prompt("prompt")
                    .remixedFromVideoId("remixed_from_video_id")
                    .seconds(VideoSeconds._4)
                    .size(VideoSize._720X1280)
                    .status(Video.Status.QUEUED)
                    .build()
            )
        assertThat(videoListPageResponse.firstId()).contains("first_id")
        assertThat(videoListPageResponse.hasMore()).isEqualTo(true)
        assertThat(videoListPageResponse.lastId()).contains("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val videoListPageResponse =
            VideoListPageResponse.builder()
                .addData(
                    Video.builder()
                        .id("id")
                        .completedAt(0L)
                        .createdAt(0L)
                        .error(VideoCreateError.builder().code("code").message("message").build())
                        .expiresAt(0L)
                        .model(VideoModel.SORA_2)
                        .progress(0L)
                        .prompt("prompt")
                        .remixedFromVideoId("remixed_from_video_id")
                        .seconds(VideoSeconds._4)
                        .size(VideoSize._720X1280)
                        .status(Video.Status.QUEUED)
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        val roundtrippedVideoListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(videoListPageResponse),
                jacksonTypeRef<VideoListPageResponse>(),
            )

        assertThat(roundtrippedVideoListPageResponse).isEqualTo(videoListPageResponse)
    }
}
