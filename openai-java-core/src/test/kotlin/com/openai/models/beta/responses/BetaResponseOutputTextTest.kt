// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseOutputTextTest {

    @Test
    fun create() {
        val betaResponseOutputText =
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

        assertThat(betaResponseOutputText.annotations())
            .containsExactly(
                BetaResponseOutputText.Annotation.ofFileCitation(
                    BetaResponseOutputText.Annotation.FileCitation.builder()
                        .fileId("file_id")
                        .filename("filename")
                        .index(0L)
                        .build()
                )
            )
        assertThat(betaResponseOutputText.text()).isEqualTo("text")
        assertThat(betaResponseOutputText.logprobs().getOrNull())
            .containsExactly(
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
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputText =
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

        val roundtrippedBetaResponseOutputText =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputText),
                jacksonTypeRef<BetaResponseOutputText>(),
            )

        assertThat(roundtrippedBetaResponseOutputText).isEqualTo(betaResponseOutputText)
    }
}
