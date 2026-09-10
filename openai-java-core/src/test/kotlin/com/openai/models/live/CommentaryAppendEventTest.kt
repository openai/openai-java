// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CommentaryAppendEventTest {

    @Test
    fun create() {
        val commentaryAppendEvent =
            CommentaryAppendEvent.builder()
                .content("There is an outdoor table for two at 7 PM. Ask whether to reserve it.")
                .delegationId("del_abc123")
                .eventId("evt_commentary_001")
                .build()

        assertThat(commentaryAppendEvent.content())
            .isEqualTo("There is an outdoor table for two at 7 PM. Ask whether to reserve it.")
        assertThat(commentaryAppendEvent.delegationId()).contains("del_abc123")
        assertThat(commentaryAppendEvent.eventId()).contains("evt_commentary_001")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val commentaryAppendEvent =
            CommentaryAppendEvent.builder()
                .content("There is an outdoor table for two at 7 PM. Ask whether to reserve it.")
                .delegationId("del_abc123")
                .eventId("evt_commentary_001")
                .build()

        val roundtrippedCommentaryAppendEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(commentaryAppendEvent),
                jacksonTypeRef<CommentaryAppendEvent>(),
            )

        assertThat(roundtrippedCommentaryAppendEvent).isEqualTo(commentaryAppendEvent)
    }
}
