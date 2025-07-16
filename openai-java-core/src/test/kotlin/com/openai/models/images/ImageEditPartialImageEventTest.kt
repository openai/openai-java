// File generated from our OpenAPI spec by Stainless.

package com.openai.models.images

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ImageEditPartialImageEventTest {

    @Test
    fun create() {
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

        assertThat(imageEditPartialImageEvent.b64Json()).isEqualTo("b64_json")
        assertThat(imageEditPartialImageEvent.background())
            .isEqualTo(ImageEditPartialImageEvent.Background.TRANSPARENT)
        assertThat(imageEditPartialImageEvent.createdAt()).isEqualTo(0L)
        assertThat(imageEditPartialImageEvent.outputFormat())
            .isEqualTo(ImageEditPartialImageEvent.OutputFormat.PNG)
        assertThat(imageEditPartialImageEvent.partialImageIndex()).isEqualTo(0L)
        assertThat(imageEditPartialImageEvent.quality())
            .isEqualTo(ImageEditPartialImageEvent.Quality.LOW)
        assertThat(imageEditPartialImageEvent.size())
            .isEqualTo(ImageEditPartialImageEvent.Size._1024X1024)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
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

        val roundtrippedImageEditPartialImageEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(imageEditPartialImageEvent),
                jacksonTypeRef<ImageEditPartialImageEvent>(),
            )

        assertThat(roundtrippedImageEditPartialImageEvent).isEqualTo(imageEditPartialImageEvent)
    }
}
