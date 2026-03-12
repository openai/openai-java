// File generated from our OpenAPI spec by Stainless.

package com.openai.models.videos

import com.openai.core.MultipartField
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VideoExtendParamsTest {

    @Test
    fun create() {
        VideoExtendParams.builder()
            .prompt("x")
            .seconds(VideoSeconds._4)
            .video(
                VideoExtendParams.Video.VideoReferenceInputParam.builder().id("video_123").build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            VideoExtendParams.builder()
                .prompt("x")
                .seconds(VideoSeconds._4)
                .video(
                    VideoExtendParams.Video.VideoReferenceInputParam.builder()
                        .id("video_123")
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.filterValues { !it.value.isNull() })
            .usingRecursiveComparison()
            // TODO(AssertJ): Replace this and the `mapValues` below with:
            // https://github.com/assertj/assertj/issues/3165
            .withEqualsForType(
                { a, b -> a.readBytes() contentEquals b.readBytes() },
                InputStream::class.java,
            )
            .isEqualTo(
                mapOf(
                        "prompt" to MultipartField.of("x"),
                        "seconds" to MultipartField.of(VideoSeconds._4),
                        "video" to
                            MultipartField.builder<VideoExtendParams.Video>()
                                .value(
                                    VideoExtendParams.Video.ofReferenceInputParam(
                                        VideoExtendParams.Video.VideoReferenceInputParam.builder()
                                            .id("video_123")
                                            .build()
                                    )
                                )
                                .contentType("application/octet-stream")
                                .build(),
                    )
                    .mapValues { (_, field) ->
                        field.map { (it as? ByteArray)?.inputStream() ?: it }
                    }
            )
    }
}
