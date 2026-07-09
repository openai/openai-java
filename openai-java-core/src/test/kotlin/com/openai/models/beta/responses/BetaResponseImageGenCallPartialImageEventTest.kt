// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseImageGenCallPartialImageEventTest {

    @Test
    fun create() {
        val betaResponseImageGenCallPartialImageEvent =
            BetaResponseImageGenCallPartialImageEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .partialImageB64("partial_image_b64")
                .partialImageIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseImageGenCallPartialImageEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseImageGenCallPartialImageEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseImageGenCallPartialImageEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseImageGenCallPartialImageEvent.partialImageB64())
            .isEqualTo("partial_image_b64")
        assertThat(betaResponseImageGenCallPartialImageEvent.partialImageIndex()).isEqualTo(0L)
        assertThat(betaResponseImageGenCallPartialImageEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseImageGenCallPartialImageEvent.agent())
            .contains(
                BetaResponseImageGenCallPartialImageEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseImageGenCallPartialImageEvent =
            BetaResponseImageGenCallPartialImageEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .partialImageB64("partial_image_b64")
                .partialImageIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseImageGenCallPartialImageEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseImageGenCallPartialImageEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseImageGenCallPartialImageEvent),
                jacksonTypeRef<BetaResponseImageGenCallPartialImageEvent>(),
            )

        assertThat(roundtrippedBetaResponseImageGenCallPartialImageEvent)
            .isEqualTo(betaResponseImageGenCallPartialImageEvent)
    }
}
