// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseContentPartAddedEventTest {

    @Test
    fun createAndRoundtrip() {
        val betaResponseContentPartAddedEvent =
            BetaResponseContentPartAddedEvent.builder()
                .contentIndex(0L)
                .itemId("item_id")
                .outputIndex(0L)
                .part(
                    BetaResponseOutputText.builder()
                        .addAnnotation(
                            BetaResponseOutputText.Annotation.FileCitation.builder()
                                .fileId("file_id")
                                .filename("filename")
                                .index(0L)
                                .build()
                        )
                        .text("text")
                        .addLogprob(
                            BetaResponseOutputText.Logprob.builder()
                                .token("token")
                                .addByte(0L)
                                .logprob(0.0)
                                .addTopLogprob(
                                    BetaResponseOutputText.Logprob.TopLogprob.builder()
                                        .token("token")
                                        .addByte(0L)
                                        .logprob(0.0)
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .sequenceNumber(0L)
                .agent(
                    BetaResponseContentPartAddedEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseContentPartAddedEvent.contentIndex()).contains(0L)
        assertThat(betaResponseContentPartAddedEvent.itemId()).contains("item_id")
        assertThat(betaResponseContentPartAddedEvent.outputIndex()).contains(0L)
        assertThat(betaResponseContentPartAddedEvent.part())
            .contains(
                BetaResponseContentPartAddedEvent.Part.ofOutputText(
                    BetaResponseOutputText.builder()
                        .addAnnotation(
                            BetaResponseOutputText.Annotation.FileCitation.builder()
                                .fileId("file_id")
                                .filename("filename")
                                .index(0L)
                                .build()
                        )
                        .text("text")
                        .addLogprob(
                            BetaResponseOutputText.Logprob.builder()
                                .token("token")
                                .addByte(0L)
                                .logprob(0.0)
                                .addTopLogprob(
                                    BetaResponseOutputText.Logprob.TopLogprob.builder()
                                        .token("token")
                                        .addByte(0L)
                                        .logprob(0.0)
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
            )
        assertThat(betaResponseContentPartAddedEvent.sequenceNumber()).contains(0L)
        assertThat(betaResponseContentPartAddedEvent.agent())
            .contains(
                BetaResponseContentPartAddedEvent.Agent.builder().agentName("agent_name").build()
            )

        val jsonMapper = jsonMapper()

        val roundtrippedBetaResponseContentPartAddedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseContentPartAddedEvent),
                jacksonTypeRef<BetaResponseContentPartAddedEvent>(),
            )

        assertThat(roundtrippedBetaResponseContentPartAddedEvent)
            .isEqualTo(betaResponseContentPartAddedEvent)
    }
}
