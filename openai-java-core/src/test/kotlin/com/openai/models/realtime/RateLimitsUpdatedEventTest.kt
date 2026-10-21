// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RateLimitsUpdatedEventTest {

    @Test
    fun createAndRoundtrip() {
        val rateLimitsUpdatedEvent =
            RateLimitsUpdatedEvent.builder()
                .eventId("event_id")
                .addRateLimit(
                    RateLimitsUpdatedEvent.RateLimit.builder()
                        .limit(0L)
                        .name(RateLimitsUpdatedEvent.RateLimit.Name.REQUESTS)
                        .remaining(0L)
                        .resetSeconds(0.0)
                        .build()
                )
                .build()

        assertThat(rateLimitsUpdatedEvent.eventId()).isEqualTo("event_id")
        assertThat(rateLimitsUpdatedEvent.rateLimits())
            .containsExactly(
                RateLimitsUpdatedEvent.RateLimit.builder()
                    .limit(0L)
                    .name(RateLimitsUpdatedEvent.RateLimit.Name.REQUESTS)
                    .remaining(0L)
                    .resetSeconds(0.0)
                    .build()
            )

        val jsonMapper = jsonMapper()

        val roundtrippedRateLimitsUpdatedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(rateLimitsUpdatedEvent),
                jacksonTypeRef<RateLimitsUpdatedEvent>(),
            )

        assertThat(roundtrippedRateLimitsUpdatedEvent).isEqualTo(rateLimitsUpdatedEvent)
    }
}
