// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime.clientsecrets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeSessionClientSecretTest {

    @Test
    fun create() {
        val realtimeSessionClientSecret =
            RealtimeSessionClientSecret.builder().expiresAt(0L).value("value").build()

        assertThat(realtimeSessionClientSecret.expiresAt()).isEqualTo(0L)
        assertThat(realtimeSessionClientSecret.value()).isEqualTo("value")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeSessionClientSecret =
            RealtimeSessionClientSecret.builder().expiresAt(0L).value("value").build()

        val roundtrippedRealtimeSessionClientSecret =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeSessionClientSecret),
                jacksonTypeRef<RealtimeSessionClientSecret>(),
            )

        assertThat(roundtrippedRealtimeSessionClientSecret).isEqualTo(realtimeSessionClientSecret)
    }
}
