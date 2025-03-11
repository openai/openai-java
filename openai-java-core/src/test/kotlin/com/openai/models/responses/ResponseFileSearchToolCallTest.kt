// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResponseFileSearchToolCallTest {

    @Test
    fun createResponseFileSearchToolCall() {
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
        assertThat(responseFileSearchToolCall).isNotNull
        assertThat(responseFileSearchToolCall.id()).isEqualTo("id")
        assertThat(responseFileSearchToolCall.queries()).containsExactly("string")
        assertThat(responseFileSearchToolCall.status())
            .isEqualTo(ResponseFileSearchToolCall.Status.IN_PROGRESS)
        assertThat(responseFileSearchToolCall.results().get())
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
}
