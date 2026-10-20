// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionUsageTest {

    @Test
    fun create() {
        val sessionUsage = SessionUsage.builder().seconds(0.0).build()

        assertThat(sessionUsage.seconds()).isEqualTo(0.0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val sessionUsage = SessionUsage.builder().seconds(0.0).build()

        val roundtrippedSessionUsage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sessionUsage),
                jacksonTypeRef<SessionUsage>(),
            )

        assertThat(roundtrippedSessionUsage).isEqualTo(sessionUsage)
    }
}
