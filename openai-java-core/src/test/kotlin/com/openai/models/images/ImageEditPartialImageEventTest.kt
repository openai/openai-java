// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.images

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ImageEditPartialImageEventTest {

    @Test
    fun createAndRoundtrip() {
        val imageEditPartialImageEvent =
            ImageEditPartialImageEvent.builder()
                .b64Json("b64_json")
                .background(ImageEditPartialImageEvent.Background.TRANSPARENT)
                .createdAt(0L)
                .outputFormat(ImageEditPartialImageEvent.OutputFormat.PNG)
                .partialImageIndex(0L)
                .quality(ImageEditPartialImageEvent.Quality.LOW)
                .size(ImageEditPartialImageEvent.Size._1024X1024)
                .build()

        assertThat(imageEditPartialImageEvent.b64Json()).contains("b64_json")
        assertThat(imageEditPartialImageEvent.background())
            .contains(ImageEditPartialImageEvent.Background.TRANSPARENT)
        assertThat(imageEditPartialImageEvent.createdAt()).contains(0L)
        assertThat(imageEditPartialImageEvent.outputFormat())
            .contains(ImageEditPartialImageEvent.OutputFormat.PNG)
        assertThat(imageEditPartialImageEvent.partialImageIndex()).contains(0L)
        assertThat(imageEditPartialImageEvent.quality())
            .contains(ImageEditPartialImageEvent.Quality.LOW)
        assertThat(imageEditPartialImageEvent.size())
            .contains(ImageEditPartialImageEvent.Size._1024X1024)

        val jsonMapper = jsonMapper()

        val roundtrippedImageEditPartialImageEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(imageEditPartialImageEvent),
                jacksonTypeRef<ImageEditPartialImageEvent>(),
            )

        assertThat(roundtrippedImageEditPartialImageEvent).isEqualTo(imageEditPartialImageEvent)
    }
}
