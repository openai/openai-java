// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseOutputAudioTest {

    @Test
    fun create() {
        val responseOutputAudio =
            ResponseOutputAudio.builder().data("data").transcript("transcript").build()

        assertThat(responseOutputAudio.data()).isEqualTo("data")
        assertThat(responseOutputAudio.transcript()).isEqualTo("transcript")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseOutputAudio =
            ResponseOutputAudio.builder().data("data").transcript("transcript").build()

        val roundtrippedResponseOutputAudio =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseOutputAudio),
                jacksonTypeRef<ResponseOutputAudio>(),
            )

        assertThat(roundtrippedResponseOutputAudio).isEqualTo(responseOutputAudio)
    }
}
