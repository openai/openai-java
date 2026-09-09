// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseImageGenCallPartialImageEventTest {

    @Test
    fun create() {
        val responseImageGenCallPartialImageEvent =
            ResponseImageGenCallPartialImageEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .partialImageB64("partial_image_b64")
                .partialImageIndex(0L)
                .sequenceNumber(0L)
                .background("background")
                .outputFormat("output_format")
                .quality("quality")
                .size("size")
                .build()

        assertThat(responseImageGenCallPartialImageEvent.itemId()).isEqualTo("item_id")
        assertThat(responseImageGenCallPartialImageEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseImageGenCallPartialImageEvent.partialImageB64())
            .isEqualTo("partial_image_b64")
        assertThat(responseImageGenCallPartialImageEvent.partialImageIndex()).isEqualTo(0L)
        assertThat(responseImageGenCallPartialImageEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(responseImageGenCallPartialImageEvent.background()).contains("background")
        assertThat(responseImageGenCallPartialImageEvent.outputFormat()).contains("output_format")
        assertThat(responseImageGenCallPartialImageEvent.quality()).contains("quality")
        assertThat(responseImageGenCallPartialImageEvent.size()).contains("size")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseImageGenCallPartialImageEvent =
            ResponseImageGenCallPartialImageEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .partialImageB64("partial_image_b64")
                .partialImageIndex(0L)
                .sequenceNumber(0L)
                .background("background")
                .outputFormat("output_format")
                .quality("quality")
                .size("size")
                .build()

        val roundtrippedResponseImageGenCallPartialImageEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseImageGenCallPartialImageEvent),
                jacksonTypeRef<ResponseImageGenCallPartialImageEvent>(),
            )

        assertThat(roundtrippedResponseImageGenCallPartialImageEvent)
            .isEqualTo(responseImageGenCallPartialImageEvent)
    }
}
