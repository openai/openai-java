// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime.clientsecrets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeTranscriptionSessionClientSecretTest {

    @Test
    fun create() {
        val realtimeTranscriptionSessionClientSecret =
            RealtimeTranscriptionSessionClientSecret.builder().expiresAt(0L).value("value").build()

        assertThat(realtimeTranscriptionSessionClientSecret.expiresAt()).isEqualTo(0L)
        assertThat(realtimeTranscriptionSessionClientSecret.value()).isEqualTo("value")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranscriptionSessionClientSecret =
            RealtimeTranscriptionSessionClientSecret.builder().expiresAt(0L).value("value").build()

        val roundtrippedRealtimeTranscriptionSessionClientSecret =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranscriptionSessionClientSecret),
                jacksonTypeRef<RealtimeTranscriptionSessionClientSecret>(),
            )

        assertThat(roundtrippedRealtimeTranscriptionSessionClientSecret)
            .isEqualTo(realtimeTranscriptionSessionClientSecret)
    }
}
