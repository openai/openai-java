// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseOutputAudioTest {

    @Test
    fun createAndRoundtrip() {
        val responseOutputAudio =
            ResponseOutputAudio.builder().data("data").transcript("transcript").build()

        assertThat(responseOutputAudio.data()).isEqualTo("data")
        assertThat(responseOutputAudio.transcript()).isEqualTo("transcript")

        val jsonMapper = jsonMapper()

        val roundtrippedResponseOutputAudio =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseOutputAudio),
                jacksonTypeRef<ResponseOutputAudio>(),
            )

        assertThat(roundtrippedResponseOutputAudio).isEqualTo(responseOutputAudio)
    }
}
