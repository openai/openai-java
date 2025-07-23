// File generated from our OpenAPI spec by Stainless.

package com.openai.models.images

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ImageGenPartialImageEventTest {

    @Test
    fun create() {
        val imageGenPartialImageEvent =
            ImageGenPartialImageEvent.builder()
                .b64Json("b64_json")
                .background(ImageGenPartialImageEvent.Background.TRANSPARENT)
                .createdAt(0L)
                .outputFormat(ImageGenPartialImageEvent.OutputFormat.PNG)
                .partialImageIndex(0L)
                .quality(ImageGenPartialImageEvent.Quality.LOW)
                .size(ImageGenPartialImageEvent.Size._1024X1024)
                .build()

        assertThat(imageGenPartialImageEvent.b64Json()).isEqualTo("b64_json")
        assertThat(imageGenPartialImageEvent.background())
            .isEqualTo(ImageGenPartialImageEvent.Background.TRANSPARENT)
        assertThat(imageGenPartialImageEvent.createdAt()).isEqualTo(0L)
        assertThat(imageGenPartialImageEvent.outputFormat())
            .isEqualTo(ImageGenPartialImageEvent.OutputFormat.PNG)
        assertThat(imageGenPartialImageEvent.partialImageIndex()).isEqualTo(0L)
        assertThat(imageGenPartialImageEvent.quality())
            .isEqualTo(ImageGenPartialImageEvent.Quality.LOW)
        assertThat(imageGenPartialImageEvent.size())
            .isEqualTo(ImageGenPartialImageEvent.Size._1024X1024)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val imageGenPartialImageEvent =
            ImageGenPartialImageEvent.builder()
                .b64Json("b64_json")
                .background(ImageGenPartialImageEvent.Background.TRANSPARENT)
                .createdAt(0L)
                .outputFormat(ImageGenPartialImageEvent.OutputFormat.PNG)
                .partialImageIndex(0L)
                .quality(ImageGenPartialImageEvent.Quality.LOW)
                .size(ImageGenPartialImageEvent.Size._1024X1024)
                .build()

        val roundtrippedImageGenPartialImageEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(imageGenPartialImageEvent),
                jacksonTypeRef<ImageGenPartialImageEvent>(),
            )

        assertThat(roundtrippedImageGenPartialImageEvent).isEqualTo(imageGenPartialImageEvent)
    }
}
