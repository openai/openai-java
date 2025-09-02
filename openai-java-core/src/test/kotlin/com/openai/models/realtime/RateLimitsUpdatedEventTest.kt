// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RateLimitsUpdatedEventTest {

    @Test
    fun create() {
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
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
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

        val roundtrippedRateLimitsUpdatedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(rateLimitsUpdatedEvent),
                jacksonTypeRef<RateLimitsUpdatedEvent>(),
            )

        assertThat(roundtrippedRateLimitsUpdatedEvent).isEqualTo(rateLimitsUpdatedEvent)
    }
}
