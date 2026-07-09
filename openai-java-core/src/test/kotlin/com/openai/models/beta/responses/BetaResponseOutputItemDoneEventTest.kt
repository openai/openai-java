// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseOutputItemDoneEventTest {

    @Test
    fun create() {
        val betaResponseOutputItemDoneEvent =
            BetaResponseOutputItemDoneEvent.builder()
                .item(
                    BetaResponseOutputMessage.builder()
                        .id("id")
                        .addContent(
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
                        .status(BetaResponseOutputMessage.Status.IN_PROGRESS)
                        .agent(
                            BetaResponseOutputMessage.Agent.builder()
                                .agentName("agent_name")
                                .build()
                        )
                        .phase(BetaResponseOutputMessage.Phase.COMMENTARY)
                        .build()
                )
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseOutputItemDoneEvent.Agent.builder().agentName("agent_name").build()
                )
                .build()

        assertThat(betaResponseOutputItemDoneEvent.item())
            .isEqualTo(
                BetaResponseOutputItem.ofMessage(
                    BetaResponseOutputMessage.builder()
                        .id("id")
                        .addContent(
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
                        .status(BetaResponseOutputMessage.Status.IN_PROGRESS)
                        .agent(
                            BetaResponseOutputMessage.Agent.builder()
                                .agentName("agent_name")
                                .build()
                        )
                        .phase(BetaResponseOutputMessage.Phase.COMMENTARY)
                        .build()
                )
            )
        assertThat(betaResponseOutputItemDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseOutputItemDoneEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseOutputItemDoneEvent.agent())
            .contains(
                BetaResponseOutputItemDoneEvent.Agent.builder().agentName("agent_name").build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputItemDoneEvent =
            BetaResponseOutputItemDoneEvent.builder()
                .item(
                    BetaResponseOutputMessage.builder()
                        .id("id")
                        .addContent(
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
                        .status(BetaResponseOutputMessage.Status.IN_PROGRESS)
                        .agent(
                            BetaResponseOutputMessage.Agent.builder()
                                .agentName("agent_name")
                                .build()
                        )
                        .phase(BetaResponseOutputMessage.Phase.COMMENTARY)
                        .build()
                )
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseOutputItemDoneEvent.Agent.builder().agentName("agent_name").build()
                )
                .build()

        val roundtrippedBetaResponseOutputItemDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputItemDoneEvent),
                jacksonTypeRef<BetaResponseOutputItemDoneEvent>(),
            )

        assertThat(roundtrippedBetaResponseOutputItemDoneEvent)
            .isEqualTo(betaResponseOutputItemDoneEvent)
    }
}
