// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeClientSecretConfigTest {

    @Test
    fun create() {
        val realtimeClientSecretConfig =
            RealtimeClientSecretConfig.builder()
                .expiresAfter(
                    RealtimeClientSecretConfig.ExpiresAfter.builder()
                        .anchor(RealtimeClientSecretConfig.ExpiresAfter.Anchor.CREATED_AT)
                        .seconds(0L)
                        .build()
                )
                .build()

        assertThat(realtimeClientSecretConfig.expiresAfter())
            .contains(
                RealtimeClientSecretConfig.ExpiresAfter.builder()
                    .anchor(RealtimeClientSecretConfig.ExpiresAfter.Anchor.CREATED_AT)
                    .seconds(0L)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeClientSecretConfig =
            RealtimeClientSecretConfig.builder()
                .expiresAfter(
                    RealtimeClientSecretConfig.ExpiresAfter.builder()
                        .anchor(RealtimeClientSecretConfig.ExpiresAfter.Anchor.CREATED_AT)
                        .seconds(0L)
                        .build()
                )
                .build()

        val roundtrippedRealtimeClientSecretConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeClientSecretConfig),
                jacksonTypeRef<RealtimeClientSecretConfig>(),
            )

        assertThat(roundtrippedRealtimeClientSecretConfig).isEqualTo(realtimeClientSecretConfig)
    }
}
