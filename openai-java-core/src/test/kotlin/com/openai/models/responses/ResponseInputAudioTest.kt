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
            ResponseInputAudio.builder().data("data").format(ResponseInputAudio.Format.MP3).build()

        assertThat(responseInputAudio.data()).isEqualTo("data")
        assertThat(responseInputAudio.format()).isEqualTo(ResponseInputAudio.Format.MP3)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseInputAudio =
            ResponseInputAudio.builder().data("data").format(ResponseInputAudio.Format.MP3).build()

        val roundtrippedResponseInputAudio =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseInputAudio),
                jacksonTypeRef<ResponseInputAudio>(),
            )

        assertThat(roundtrippedResponseInputAudio).isEqualTo(responseInputAudio)
    }
}
