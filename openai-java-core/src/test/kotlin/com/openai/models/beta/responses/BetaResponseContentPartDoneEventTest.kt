// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseContentPartDoneEventTest {

    @Test
    fun create() {
        val betaResponseContentPartDoneEvent =
            BetaResponseContentPartDoneEvent.builder()
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
                    BetaResponseContentPartDoneEvent.Agent.builder().agentName("agent_name").build()
                )
                .build()

        assertThat(betaResponseContentPartDoneEvent.contentIndex()).isEqualTo(0L)
        assertThat(betaResponseContentPartDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseContentPartDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseContentPartDoneEvent.part())
            .isEqualTo(
                BetaResponseContentPartDoneEvent.Part.ofOutputText(
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
        assertThat(betaResponseContentPartDoneEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseContentPartDoneEvent.agent())
            .contains(
                BetaResponseContentPartDoneEvent.Agent.builder().agentName("agent_name").build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseContentPartDoneEvent =
            BetaResponseContentPartDoneEvent.builder()
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
                    BetaResponseContentPartDoneEvent.Agent.builder().agentName("agent_name").build()
                )
                .build()

        val roundtrippedBetaResponseContentPartDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseContentPartDoneEvent),
                jacksonTypeRef<BetaResponseContentPartDoneEvent>(),
            )

        assertThat(roundtrippedBetaResponseContentPartDoneEvent)
            .isEqualTo(betaResponseContentPartDoneEvent)
    }
}
