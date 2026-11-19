// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionUsageTest {

    @Test
    fun createAndRoundtrip() {
        val sessionUsage =
            SessionUsage.builder().seconds(0.0).activeSeconds(0L).pausedSeconds(0L).build()

        assertThat(sessionUsage.seconds()).isEqualTo(0.0)
        assertThat(sessionUsage.activeSeconds()).contains(0L)
        assertThat(sessionUsage.pausedSeconds()).contains(0L)

        val jsonMapper = jsonMapper()

        val roundtrippedSessionUsage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sessionUsage),
                jacksonTypeRef<SessionUsage>(),
            )

        assertThat(roundtrippedSessionUsage).isEqualTo(sessionUsage)
    }
}
