// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import com.openai.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BatchCreateParamsTest {

    @Test
    fun createBatchCreateParams() {
        BatchCreateParams.builder()
            .completionWindow(BatchCreateParams.CompletionWindow._24H)
            .endpoint(BatchCreateParams.Endpoint.V1_CHAT_COMPLETIONS)
            .inputFileId("input_file_id")
            .metadata(
                BatchCreateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
            .build()
    }

    @Test
    fun getBody() {
        val params =
            BatchCreateParams.builder()
                .completionWindow(BatchCreateParams.CompletionWindow._24H)
                .endpoint(BatchCreateParams.Endpoint.V1_CHAT_COMPLETIONS)
                .inputFileId("input_file_id")
                .metadata(
                    BatchCreateParams.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.completionWindow()).isEqualTo(BatchCreateParams.CompletionWindow._24H)
        assertThat(body.endpoint()).isEqualTo(BatchCreateParams.Endpoint.V1_CHAT_COMPLETIONS)
        assertThat(body.inputFileId()).isEqualTo("input_file_id")
        assertThat(body.metadata())
            .isEqualTo(
                BatchCreateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            BatchCreateParams.builder()
                .completionWindow(BatchCreateParams.CompletionWindow._24H)
                .endpoint(BatchCreateParams.Endpoint.V1_CHAT_COMPLETIONS)
                .inputFileId("input_file_id")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.completionWindow()).isEqualTo(BatchCreateParams.CompletionWindow._24H)
        assertThat(body.endpoint()).isEqualTo(BatchCreateParams.Endpoint.V1_CHAT_COMPLETIONS)
        assertThat(body.inputFileId()).isEqualTo("input_file_id")
    }
}
