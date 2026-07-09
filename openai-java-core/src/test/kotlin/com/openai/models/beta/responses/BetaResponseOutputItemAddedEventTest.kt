// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseOutputItemAddedEventTest {

    @Test
    fun create() {
        val betaResponseOutputItemAddedEvent =
            BetaResponseOutputItemAddedEvent.builder()
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
                    BetaResponseOutputItemAddedEvent.Agent.builder().agentName("agent_name").build()
                )
                .build()

        assertThat(betaResponseOutputItemAddedEvent.item())
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
        assertThat(betaResponseOutputItemAddedEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseOutputItemAddedEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseOutputItemAddedEvent.agent())
            .contains(
                BetaResponseOutputItemAddedEvent.Agent.builder().agentName("agent_name").build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputItemAddedEvent =
            BetaResponseOutputItemAddedEvent.builder()
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
                    BetaResponseOutputItemAddedEvent.Agent.builder().agentName("agent_name").build()
                )
                .build()

        val roundtrippedBetaResponseOutputItemAddedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputItemAddedEvent),
                jacksonTypeRef<BetaResponseOutputItemAddedEvent>(),
            )

        assertThat(roundtrippedBetaResponseOutputItemAddedEvent)
            .isEqualTo(betaResponseOutputItemAddedEvent)
    }
}
