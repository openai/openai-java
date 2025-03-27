// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionUpdateParamsTest {

    @Test
    fun create() {
        ChatCompletionUpdateParams.builder()
            .completionId("completion_id")
            .metadata(
                ChatCompletionUpdateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ChatCompletionUpdateParams.builder()
                .completionId("completion_id")
                .metadata(
                    ChatCompletionUpdateParams.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .build()

        assertThat(params._pathParam(0)).isEqualTo("completion_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            ChatCompletionUpdateParams.builder()
                .completionId("completion_id")
                .metadata(
                    ChatCompletionUpdateParams.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.metadata())
            .contains(
                ChatCompletionUpdateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
    }
}
