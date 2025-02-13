// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChatCompletionUpdateParamsTest {

    @Test
    fun create() {
        ChatCompletionUpdateParams.builder()
            .completionId("completion_id")
            .metadata(
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            ChatCompletionUpdateParams.builder()
                .completionId("completion_id")
                .metadata(
                    Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .build()
        val body = params._body()
        assertThat(body).isNotNull
        assertThat(body.metadata())
            .contains(
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ChatCompletionUpdateParams.builder()
                .completionId("completion_id")
                .metadata(
                    Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .build()
        val body = params._body()
        assertThat(body).isNotNull
        assertThat(body.metadata())
            .contains(
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
            )
    }

    @Test
    fun getPathParam() {
        val params =
            ChatCompletionUpdateParams.builder()
                .completionId("completion_id")
                .metadata(
                    Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .build()
        assertThat(params).isNotNull
        // path param "completionId"
        assertThat(params.getPathParam(0)).isEqualTo("completion_id")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
