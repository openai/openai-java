// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseInputAudioTest {

    @Test
    fun create() {
        val responseInputAudio =
            ResponseInputAudio.builder()
                .inputAudio(
                    ResponseInputAudio.InputAudio.builder()
                        .data("data")
                        .format(ResponseInputAudio.InputAudio.Format.MP3)
                        .build()
                )
                .build()

        assertThat(responseInputAudio.inputAudio())
            .isEqualTo(
                ResponseInputAudio.InputAudio.builder()
                    .data("data")
                    .format(ResponseInputAudio.InputAudio.Format.MP3)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseInputAudio =
            ResponseInputAudio.builder()
                .inputAudio(
                    ResponseInputAudio.InputAudio.builder()
                        .data("data")
                        .format(ResponseInputAudio.InputAudio.Format.MP3)
                        .build()
                )
                .build()

        val roundtrippedResponseInputAudio =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseInputAudio),
                jacksonTypeRef<ResponseInputAudio>(),
            )

        assertThat(roundtrippedResponseInputAudio).isEqualTo(responseInputAudio)
    }
}
