// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.responses.EasyInputMessage
import com.openai.models.responses.ResponseInputItem
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseItemCreateEventTest {

    @Test
    fun create() {
        val responseItemCreateEvent =
            ResponseItemCreateEvent.builder()
                .item(
                    EasyInputMessage.builder()
                        .content("string")
                        .role(EasyInputMessage.Role.USER)
                        .phase(EasyInputMessage.Phase.COMMENTARY)
                        .type(EasyInputMessage.Type.MESSAGE)
                        .build()
                )
                .eventId("evt_item_001")
                .build()

        assertThat(responseItemCreateEvent.item())
            .isEqualTo(
                ResponseInputItem.ofEasyInputMessage(
                    EasyInputMessage.builder()
                        .content("string")
                        .role(EasyInputMessage.Role.USER)
                        .phase(EasyInputMessage.Phase.COMMENTARY)
                        .type(EasyInputMessage.Type.MESSAGE)
                        .build()
                )
            )
        assertThat(responseItemCreateEvent.eventId()).contains("evt_item_001")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseItemCreateEvent =
            ResponseItemCreateEvent.builder()
                .item(
                    EasyInputMessage.builder()
                        .content("string")
                        .role(EasyInputMessage.Role.USER)
                        .phase(EasyInputMessage.Phase.COMMENTARY)
                        .type(EasyInputMessage.Type.MESSAGE)
                        .build()
                )
                .eventId("evt_item_001")
                .build()

        val roundtrippedResponseItemCreateEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseItemCreateEvent),
                jacksonTypeRef<ResponseItemCreateEvent>(),
            )

        assertThat(roundtrippedResponseItemCreateEvent).isEqualTo(responseItemCreateEvent)
    }
}
