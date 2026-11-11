// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DelegationCreatedEventTest {

    @Test
    fun createAndRoundtrip() {
        val delegationCreatedEvent =
            DelegationCreatedEvent.builder()
                .delegation(
                    DelegationCreatedEvent.Delegation.builder()
                        .id("del_abc123")
                        .target(DelegationCreatedEvent.Delegation.Target.CLIENT)
                        .responseId("response_id")
                        .build()
                )
                .eventId("evt_delegation_001")
                .offsetMs(3600L)
                .clientEventId("client_event_id")
                .build()

        assertThat(delegationCreatedEvent.delegation())
            .contains(
                DelegationCreatedEvent.Delegation.builder()
                    .id("del_abc123")
                    .target(DelegationCreatedEvent.Delegation.Target.CLIENT)
                    .responseId("response_id")
                    .build()
            )
        assertThat(delegationCreatedEvent.eventId()).contains("evt_delegation_001")
        assertThat(delegationCreatedEvent.offsetMs()).contains(3600L)
        assertThat(delegationCreatedEvent.clientEventId()).contains("client_event_id")

        val jsonMapper = jsonMapper()

        val roundtrippedDelegationCreatedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(delegationCreatedEvent),
                jacksonTypeRef<DelegationCreatedEvent>(),
            )

        assertThat(roundtrippedDelegationCreatedEvent).isEqualTo(delegationCreatedEvent)
    }
}
