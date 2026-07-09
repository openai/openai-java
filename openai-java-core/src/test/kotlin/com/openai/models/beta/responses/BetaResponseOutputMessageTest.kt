// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseOutputMessageTest {

    @Test
    fun create() {
        val betaResponseOutputMessage =
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
                .agent(BetaResponseOutputMessage.Agent.builder().agentName("agent_name").build())
                .phase(BetaResponseOutputMessage.Phase.COMMENTARY)
                .build()

        assertThat(betaResponseOutputMessage.id()).isEqualTo("id")
        assertThat(betaResponseOutputMessage.content())
            .containsExactly(
                BetaResponseOutputMessage.Content.ofOutputText(
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
        assertThat(betaResponseOutputMessage.status())
            .isEqualTo(BetaResponseOutputMessage.Status.IN_PROGRESS)
        assertThat(betaResponseOutputMessage.agent())
            .contains(BetaResponseOutputMessage.Agent.builder().agentName("agent_name").build())
        assertThat(betaResponseOutputMessage.phase())
            .contains(BetaResponseOutputMessage.Phase.COMMENTARY)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputMessage =
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
                .agent(BetaResponseOutputMessage.Agent.builder().agentName("agent_name").build())
                .phase(BetaResponseOutputMessage.Phase.COMMENTARY)
                .build()

        val roundtrippedBetaResponseOutputMessage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputMessage),
                jacksonTypeRef<BetaResponseOutputMessage>(),
            )

        assertThat(roundtrippedBetaResponseOutputMessage).isEqualTo(betaResponseOutputMessage)
    }
}
