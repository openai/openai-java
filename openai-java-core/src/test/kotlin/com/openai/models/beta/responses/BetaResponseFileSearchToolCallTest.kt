// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseFileSearchToolCallTest {

    @Test
    fun create() {
        val betaResponseFileSearchToolCall =
            BetaResponseFileSearchToolCall.builder()
                .id("id")
                .addQuery("string")
                .status(BetaResponseFileSearchToolCall.Status.IN_PROGRESS)
                .agent(
                    BetaResponseFileSearchToolCall.Agent.builder().agentName("agent_name").build()
                )
                .addResult(
                    BetaResponseFileSearchToolCall.Result.builder()
                        .attributes(
                            BetaResponseFileSearchToolCall.Result.Attributes.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .fileId("file_id")
                        .filename("filename")
                        .score(0.0f)
                        .text("text")
                        .build()
                )
                .build()

        assertThat(betaResponseFileSearchToolCall.id()).isEqualTo("id")
        assertThat(betaResponseFileSearchToolCall.queries()).containsExactly("string")
        assertThat(betaResponseFileSearchToolCall.status())
            .isEqualTo(BetaResponseFileSearchToolCall.Status.IN_PROGRESS)
        assertThat(betaResponseFileSearchToolCall.agent())
            .contains(
                BetaResponseFileSearchToolCall.Agent.builder().agentName("agent_name").build()
            )
        assertThat(betaResponseFileSearchToolCall.results().getOrNull())
            .containsExactly(
                BetaResponseFileSearchToolCall.Result.builder()
                    .attributes(
                        BetaResponseFileSearchToolCall.Result.Attributes.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .fileId("file_id")
                    .filename("filename")
                    .score(0.0f)
                    .text("text")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseFileSearchToolCall =
            BetaResponseFileSearchToolCall.builder()
                .id("id")
                .addQuery("string")
                .status(BetaResponseFileSearchToolCall.Status.IN_PROGRESS)
                .agent(
                    BetaResponseFileSearchToolCall.Agent.builder().agentName("agent_name").build()
                )
                .addResult(
                    BetaResponseFileSearchToolCall.Result.builder()
                        .attributes(
                            BetaResponseFileSearchToolCall.Result.Attributes.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .fileId("file_id")
                        .filename("filename")
                        .score(0.0f)
                        .text("text")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseFileSearchToolCall =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseFileSearchToolCall),
                jacksonTypeRef<BetaResponseFileSearchToolCall>(),
            )

        assertThat(roundtrippedBetaResponseFileSearchToolCall)
            .isEqualTo(betaResponseFileSearchToolCall)
    }
}
