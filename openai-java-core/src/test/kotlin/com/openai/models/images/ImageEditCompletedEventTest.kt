// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.images

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ImageEditCompletedEventTest {

    @Test
    fun createAndRoundtrip() {
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
                .safetyIdentifier("safety_identifier")
                .build()

        assertThat(imageEditCompletedEvent.b64Json()).contains("b64_json")
        assertThat(imageEditCompletedEvent.background())
            .contains(ImageEditCompletedEvent.Background.TRANSPARENT)
        assertThat(imageEditCompletedEvent.createdAt()).contains(0L)
        assertThat(imageEditCompletedEvent.outputFormat())
            .contains(ImageEditCompletedEvent.OutputFormat.PNG)
        assertThat(imageEditCompletedEvent.quality()).contains(ImageEditCompletedEvent.Quality.LOW)
        assertThat(imageEditCompletedEvent.size()).contains(ImageEditCompletedEvent.Size._1024X1024)
        assertThat(imageEditCompletedEvent.usage())
            .contains(
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
        assertThat(imageEditCompletedEvent.safetyIdentifier()).contains("safety_identifier")

        val jsonMapper = jsonMapper()

        val roundtrippedImageEditCompletedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(imageEditCompletedEvent),
                jacksonTypeRef<ImageEditCompletedEvent>(),
            )

        assertThat(roundtrippedImageEditCompletedEvent).isEqualTo(imageEditCompletedEvent)
    }
}
