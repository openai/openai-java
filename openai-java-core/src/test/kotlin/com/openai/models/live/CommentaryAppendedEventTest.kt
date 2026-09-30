// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CommentaryAppendedEventTest {

    @Test
    fun create() {
        val commentaryAppendedEvent =
            CommentaryAppendedEvent.builder()
                .endMs(5400L)
                .eventId("evt_commentary_002")
                .startMs(5200L)
                .clientEventId("evt_commentary_001")
                .build()

        assertThat(commentaryAppendedEvent.endMs()).isEqualTo(5400L)
        assertThat(commentaryAppendedEvent.eventId()).isEqualTo("evt_commentary_002")
        assertThat(commentaryAppendedEvent.startMs()).isEqualTo(5200L)
        assertThat(commentaryAppendedEvent.clientEventId()).contains("evt_commentary_001")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val commentaryAppendedEvent =
            CommentaryAppendedEvent.builder()
                .endMs(5400L)
                .eventId("evt_commentary_002")
                .startMs(5200L)
                .clientEventId("evt_commentary_001")
                .build()

        val roundtrippedCommentaryAppendedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(commentaryAppendedEvent),
                jacksonTypeRef<CommentaryAppendedEvent>(),
            )

        assertThat(roundtrippedCommentaryAppendedEvent).isEqualTo(commentaryAppendedEvent)
    }
}
