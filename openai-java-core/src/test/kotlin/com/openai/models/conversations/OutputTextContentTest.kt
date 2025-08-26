// File generated from our OpenAPI spec by Stainless.

package com.openai.models.conversations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OutputTextContentTest {

    @Test
    fun create() {
        val outputTextContent =
            OutputTextContent.builder()
                .addAnnotation(
                    FileCitationBody.builder()
                        .fileId("file_id")
                        .filename("filename")
                        .index(0L)
                        .build()
                )
                .text("text")
                .addLogprob(
                    LobProb.builder()
                        .token("token")
                        .addByte(0L)
                        .logprob(0.0)
                        .addTopLogprob(
                            TopLogProb.builder().token("token").addByte(0L).logprob(0.0).build()
                        )
                        .build()
                )
                .build()

        assertThat(outputTextContent.annotations())
            .containsExactly(
                OutputTextContent.Annotation.ofFileCitation(
                    FileCitationBody.builder()
                        .fileId("file_id")
                        .filename("filename")
                        .index(0L)
                        .build()
                )
            )
        assertThat(outputTextContent.text()).isEqualTo("text")
        assertThat(outputTextContent.logprobs().getOrNull())
            .containsExactly(
                LobProb.builder()
                    .token("token")
                    .addByte(0L)
                    .logprob(0.0)
                    .addTopLogprob(
                        TopLogProb.builder().token("token").addByte(0L).logprob(0.0).build()
                    )
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val outputTextContent =
            OutputTextContent.builder()
                .addAnnotation(
                    FileCitationBody.builder()
                        .fileId("file_id")
                        .filename("filename")
                        .index(0L)
                        .build()
                )
                .text("text")
                .addLogprob(
                    LobProb.builder()
                        .token("token")
                        .addByte(0L)
                        .logprob(0.0)
                        .addTopLogprob(
                            TopLogProb.builder().token("token").addByte(0L).logprob(0.0).build()
                        )
                        .build()
                )
                .build()

        val roundtrippedOutputTextContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(outputTextContent),
                jacksonTypeRef<OutputTextContent>(),
            )

        assertThat(roundtrippedOutputTextContent).isEqualTo(outputTextContent)
    }
}
