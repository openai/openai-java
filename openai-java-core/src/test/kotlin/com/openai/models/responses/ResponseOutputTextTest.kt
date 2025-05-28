// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseOutputTextTest {

    @Test
    fun create() {
        val responseOutputText =
            ResponseOutputText.builder()
                .addAnnotation(
                    ResponseOutputText.Annotation.FileCitation.builder()
                        .fileId("file_id")
                        .index(0L)
                        .build()
                )
                .text("text")
                .addLogprob(
                    ResponseOutputText.Logprob.builder()
                        .token("token")
                        .addByte(0L)
                        .logprob(0.0)
                        .addTopLogprob(
                            ResponseOutputText.Logprob.TopLogprob.builder()
                                .token("token")
                                .addByte(0L)
                                .logprob(0.0)
                                .build()
                        )
                        .build()
                )
                .build()

        assertThat(responseOutputText.annotations())
            .containsExactly(
                ResponseOutputText.Annotation.ofFileCitation(
                    ResponseOutputText.Annotation.FileCitation.builder()
                        .fileId("file_id")
                        .index(0L)
                        .build()
                )
            )
        assertThat(responseOutputText.text()).isEqualTo("text")
        assertThat(responseOutputText.logprobs().getOrNull())
            .containsExactly(
                ResponseOutputText.Logprob.builder()
                    .token("token")
                    .addByte(0L)
                    .logprob(0.0)
                    .addTopLogprob(
                        ResponseOutputText.Logprob.TopLogprob.builder()
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
        val responseOutputText =
            ResponseOutputText.builder()
                .addAnnotation(
                    ResponseOutputText.Annotation.FileCitation.builder()
                        .fileId("file_id")
                        .index(0L)
                        .build()
                )
                .text("text")
                .addLogprob(
                    ResponseOutputText.Logprob.builder()
                        .token("token")
                        .addByte(0L)
                        .logprob(0.0)
                        .addTopLogprob(
                            ResponseOutputText.Logprob.TopLogprob.builder()
                                .token("token")
                                .addByte(0L)
                                .logprob(0.0)
                                .build()
                        )
                        .build()
                )
                .build()

        val roundtrippedResponseOutputText =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseOutputText),
                jacksonTypeRef<ResponseOutputText>(),
            )

        assertThat(roundtrippedResponseOutputText).isEqualTo(responseOutputText)
    }
}
