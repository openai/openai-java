// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.images

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ImageGenCompletedEventTest {

    @Test
    fun createAndRoundtrip() {
        val imageGenCompletedEvent =
            ImageGenCompletedEvent.builder()
                .b64Json("b64_json")
                .background(ImageGenCompletedEvent.Background.TRANSPARENT)
                .createdAt(0L)
                .outputFormat(ImageGenCompletedEvent.OutputFormat.PNG)
                .quality(ImageGenCompletedEvent.Quality.LOW)
                .size(ImageGenCompletedEvent.Size._1024X1024)
                .usage(
                    ImageGenCompletedEvent.Usage.builder()
                        .inputTokens(0L)
                        .inputTokensDetails(
                            ImageGenCompletedEvent.Usage.InputTokensDetails.builder()
                                .imageTokens(0L)
                                .textTokens(0L)
                                .build()
                        )
                        .outputTokens(0L)
                        .totalTokens(0L)
                        .build()
                )
                .safetyIdentifier("safety_identifier")
                .build()

        assertThat(imageGenCompletedEvent.b64Json()).isEqualTo("b64_json")
        assertThat(imageGenCompletedEvent.background())
            .isEqualTo(ImageGenCompletedEvent.Background.TRANSPARENT)
        assertThat(imageGenCompletedEvent.createdAt()).isEqualTo(0L)
        assertThat(imageGenCompletedEvent.outputFormat())
            .isEqualTo(ImageGenCompletedEvent.OutputFormat.PNG)
        assertThat(imageGenCompletedEvent.quality()).isEqualTo(ImageGenCompletedEvent.Quality.LOW)
        assertThat(imageGenCompletedEvent.size()).isEqualTo(ImageGenCompletedEvent.Size._1024X1024)
        assertThat(imageGenCompletedEvent.usage())
            .isEqualTo(
                ImageGenCompletedEvent.Usage.builder()
                    .inputTokens(0L)
                    .inputTokensDetails(
                        ImageGenCompletedEvent.Usage.InputTokensDetails.builder()
                            .imageTokens(0L)
                            .textTokens(0L)
                            .build()
                    )
                    .outputTokens(0L)
                    .totalTokens(0L)
                    .build()
            )
        assertThat(imageGenCompletedEvent.safetyIdentifier()).contains("safety_identifier")

        val jsonMapper = jsonMapper()

        val roundtrippedImageGenCompletedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(imageGenCompletedEvent),
                jacksonTypeRef<ImageGenCompletedEvent>(),
            )

        assertThat(roundtrippedImageGenCompletedEvent).isEqualTo(imageGenCompletedEvent)
    }
}
