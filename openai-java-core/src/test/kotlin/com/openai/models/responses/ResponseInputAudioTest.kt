// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseInputAudioTest {

    @Test
    fun createAndRoundtrip() {
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

        val jsonMapper = jsonMapper()

        val roundtrippedResponseInputAudio =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseInputAudio),
                jacksonTypeRef<ResponseInputAudio>(),
            )

        assertThat(roundtrippedResponseInputAudio).isEqualTo(responseInputAudio)
    }
}
