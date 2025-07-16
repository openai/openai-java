// File generated from our OpenAPI spec by Stainless.

package com.openai.models.images

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ImageEditCompletedEventTest {

    @Test
    fun create() {
        val imageEditCompletedEvent =
            ImageEditCompletedEvent.builder()
                .b64Json("b64_json")
                .background(ImageEditCompletedEvent.Background.TRANSPARENT)
                .createdAt(0L)
                .outputFormat(ImageEditCompletedEvent.OutputFormat.PNG)
                .quality(ImageEditCompletedEvent.Quality.LOW)
                .size(ImageEditCompletedEvent.Size._1024X1024)
                .usage(
                    ImageEditCompletedEvent.Usage.builder()
                        .inputTokens(0L)
                        .inputTokensDetails(
                            ImageEditCompletedEvent.Usage.InputTokensDetails.builder()
                                .imageTokens(0L)
                                .textTokens(0L)
                                .build()
                        )
                        .outputTokens(0L)
                        .totalTokens(0L)
                        .build()
                )
                .build()

        assertThat(imageEditCompletedEvent.b64Json()).isEqualTo("b64_json")
        assertThat(imageEditCompletedEvent.background())
            .isEqualTo(ImageEditCompletedEvent.Background.TRANSPARENT)
        assertThat(imageEditCompletedEvent.createdAt()).isEqualTo(0L)
        assertThat(imageEditCompletedEvent.outputFormat())
            .isEqualTo(ImageEditCompletedEvent.OutputFormat.PNG)
        assertThat(imageEditCompletedEvent.quality()).isEqualTo(ImageEditCompletedEvent.Quality.LOW)
        assertThat(imageEditCompletedEvent.size())
            .isEqualTo(ImageEditCompletedEvent.Size._1024X1024)
        assertThat(imageEditCompletedEvent.usage())
            .isEqualTo(
                ImageEditCompletedEvent.Usage.builder()
                    .inputTokens(0L)
                    .inputTokensDetails(
                        ImageEditCompletedEvent.Usage.InputTokensDetails.builder()
                            .imageTokens(0L)
                            .textTokens(0L)
                            .build()
                    )
                    .outputTokens(0L)
                    .totalTokens(0L)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val imageEditCompletedEvent =
            ImageEditCompletedEvent.builder()
                .b64Json("b64_json")
                .background(ImageEditCompletedEvent.Background.TRANSPARENT)
                .createdAt(0L)
                .outputFormat(ImageEditCompletedEvent.OutputFormat.PNG)
                .quality(ImageEditCompletedEvent.Quality.LOW)
                .size(ImageEditCompletedEvent.Size._1024X1024)
                .usage(
                    ImageEditCompletedEvent.Usage.builder()
                        .inputTokens(0L)
                        .inputTokensDetails(
                            ImageEditCompletedEvent.Usage.InputTokensDetails.builder()
                                .imageTokens(0L)
                                .textTokens(0L)
                                .build()
                        )
                        .outputTokens(0L)
                        .totalTokens(0L)
                        .build()
                )
                .build()

        val roundtrippedImageEditCompletedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(imageEditCompletedEvent),
                jacksonTypeRef<ImageEditCompletedEvent>(),
            )

        assertThat(roundtrippedImageEditCompletedEvent).isEqualTo(imageEditCompletedEvent)
    }
}
