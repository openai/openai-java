// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LiveCreateResponseTest {

    @Test
    fun create() {
        val liveCreateResponse =
            LiveCreateResponse.builder()
                .session(LiveCreateResponse.Session.builder().id("id").build())
                .transport(LiveCreateResponse.Transport.builder().sdp("x").build())
                .build()

        assertThat(liveCreateResponse.session())
            .isEqualTo(LiveCreateResponse.Session.builder().id("id").build())
        assertThat(liveCreateResponse.transport())
            .isEqualTo(LiveCreateResponse.Transport.builder().sdp("x").build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val liveCreateResponse =
            LiveCreateResponse.builder()
                .session(LiveCreateResponse.Session.builder().id("id").build())
                .transport(LiveCreateResponse.Transport.builder().sdp("x").build())
                .build()

        val roundtrippedLiveCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(liveCreateResponse),
                jacksonTypeRef<LiveCreateResponse>(),
            )

        assertThat(roundtrippedLiveCreateResponse).isEqualTo(liveCreateResponse)
    }
}
