// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.videos

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VideoCreateErrorTest {

    @Test
    fun create() {
        val videoCreateError =
            VideoCreateError.builder()
                .code("code")
                .message("message")
                .misalignment(
                    VideoCreateError.Misalignment.builder()
                        .detailedExplanation("detailed_explanation")
                        .errorType(
                            VideoCreateError.Misalignment.ErrorType
                                .POTENTIALLY_UNINTENDED_DATA_TRANSFER
                        )
                        .steer(
                            VideoCreateError.Misalignment.Steer.builder().message("message").build()
                        )
                        .build()
                )
                .build()

        assertThat(videoCreateError.code()).isEqualTo("code")
        assertThat(videoCreateError.message()).isEqualTo("message")
        assertThat(videoCreateError.misalignment())
            .contains(
                VideoCreateError.Misalignment.builder()
                    .detailedExplanation("detailed_explanation")
                    .errorType(
                        VideoCreateError.Misalignment.ErrorType.POTENTIALLY_UNINTENDED_DATA_TRANSFER
                    )
                    .steer(VideoCreateError.Misalignment.Steer.builder().message("message").build())
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val videoCreateError =
            VideoCreateError.builder()
                .code("code")
                .message("message")
                .misalignment(
                    VideoCreateError.Misalignment.builder()
                        .detailedExplanation("detailed_explanation")
                        .errorType(
                            VideoCreateError.Misalignment.ErrorType
                                .POTENTIALLY_UNINTENDED_DATA_TRANSFER
                        )
                        .steer(
                            VideoCreateError.Misalignment.Steer.builder().message("message").build()
                        )
                        .build()
                )
                .build()

        val roundtrippedVideoCreateError =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(videoCreateError),
                jacksonTypeRef<VideoCreateError>(),
            )

        assertThat(roundtrippedVideoCreateError).isEqualTo(videoCreateError)
    }
}
