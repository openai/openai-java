// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.images

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ImageGenPartialImageEventTest {

    @Test
    fun createAndRoundtrip() {
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

        assertThat(imageGenPartialImageEvent.b64Json()).contains("b64_json")
        assertThat(imageGenPartialImageEvent.background())
            .contains(ImageGenPartialImageEvent.Background.TRANSPARENT)
        assertThat(imageGenPartialImageEvent.createdAt()).contains(0L)
        assertThat(imageGenPartialImageEvent.outputFormat())
            .contains(ImageGenPartialImageEvent.OutputFormat.PNG)
        assertThat(imageGenPartialImageEvent.partialImageIndex()).contains(0L)
        assertThat(imageGenPartialImageEvent.quality())
            .contains(ImageGenPartialImageEvent.Quality.LOW)
        assertThat(imageGenPartialImageEvent.size())
            .contains(ImageGenPartialImageEvent.Size._1024X1024)

        val jsonMapper = jsonMapper()

        val roundtrippedImageGenPartialImageEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(imageGenPartialImageEvent),
                jacksonTypeRef<ImageGenPartialImageEvent>(),
            )

        assertThat(roundtrippedImageGenPartialImageEvent).isEqualTo(imageGenPartialImageEvent)
    }
}
