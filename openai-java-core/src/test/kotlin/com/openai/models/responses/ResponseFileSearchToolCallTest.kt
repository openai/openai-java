// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseFileSearchToolCallTest {

    @Test
    fun create() {
        val responseFileSearchToolCall =
            ResponseFileSearchToolCall.builder()
                .id("id")
                .addQuery("string")
                .status(ResponseFileSearchToolCall.Status.IN_PROGRESS)
                .addResult(
                    ResponseFileSearchToolCall.Result.builder()
                        .attributes(
                            ResponseFileSearchToolCall.Result.Attributes.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .fileId("file_id")
                        .filename("filename")
                        .score(0.0)
                        .text("text")
                        .build()
                )
                .build()

        assertThat(responseFileSearchToolCall.id()).isEqualTo("id")
        assertThat(responseFileSearchToolCall.queries()).containsExactly("string")
        assertThat(responseFileSearchToolCall.status())
            .isEqualTo(ResponseFileSearchToolCall.Status.IN_PROGRESS)
        assertThat(responseFileSearchToolCall.results().getOrNull())
            .containsExactly(
                ResponseFileSearchToolCall.Result.builder()
                    .attributes(
                        ResponseFileSearchToolCall.Result.Attributes.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .fileId("file_id")
                    .filename("filename")
                    .score(0.0)
                    .text("text")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseFileSearchToolCall =
            ResponseFileSearchToolCall.builder()
                .id("id")
                .addQuery("string")
                .status(ResponseFileSearchToolCall.Status.IN_PROGRESS)
                .addResult(
                    ResponseFileSearchToolCall.Result.builder()
                        .attributes(
                            ResponseFileSearchToolCall.Result.Attributes.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .fileId("file_id")
                        .filename("filename")
                        .score(0.0)
                        .text("text")
                        .build()
                )
                .build()

        val roundtrippedResponseFileSearchToolCall =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFileSearchToolCall),
                jacksonTypeRef<ResponseFileSearchToolCall>(),
            )

        assertThat(roundtrippedResponseFileSearchToolCall).isEqualTo(responseFileSearchToolCall)
    }
}
