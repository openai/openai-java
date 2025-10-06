// File generated from our OpenAPI spec by Stainless.

package com.openai.models.videos

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VideoTest {

    @Test
    fun create() {
        val video =
            Video.builder()
                .id("id")
                .completedAt(0L)
                .createdAt(0L)
                .error(VideoCreateError.builder().code("code").message("message").build())
                .expiresAt(0L)
                .model(VideoModel.SORA_2)
                .progress(0L)
                .remixedFromVideoId("remixed_from_video_id")
                .seconds(VideoSeconds._4)
                .size(VideoSize._720X1280)
                .status(Video.Status.QUEUED)
                .build()

        assertThat(video.id()).isEqualTo("id")
        assertThat(video.completedAt()).contains(0L)
        assertThat(video.createdAt()).isEqualTo(0L)
        assertThat(video.error())
            .contains(VideoCreateError.builder().code("code").message("message").build())
        assertThat(video.expiresAt()).contains(0L)
        assertThat(video.model()).isEqualTo(VideoModel.SORA_2)
        assertThat(video.progress()).isEqualTo(0L)
        assertThat(video.remixedFromVideoId()).contains("remixed_from_video_id")
        assertThat(video.seconds()).isEqualTo(VideoSeconds._4)
        assertThat(video.size()).isEqualTo(VideoSize._720X1280)
        assertThat(video.status()).isEqualTo(Video.Status.QUEUED)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val video =
            Video.builder()
                .id("id")
                .completedAt(0L)
                .createdAt(0L)
                .error(VideoCreateError.builder().code("code").message("message").build())
                .expiresAt(0L)
                .model(VideoModel.SORA_2)
                .progress(0L)
                .remixedFromVideoId("remixed_from_video_id")
                .seconds(VideoSeconds._4)
                .size(VideoSize._720X1280)
                .status(Video.Status.QUEUED)
                .build()

        val roundtrippedVideo =
            jsonMapper.readValue(jsonMapper.writeValueAsString(video), jacksonTypeRef<Video>())

        assertThat(roundtrippedVideo).isEqualTo(video)
    }
}
