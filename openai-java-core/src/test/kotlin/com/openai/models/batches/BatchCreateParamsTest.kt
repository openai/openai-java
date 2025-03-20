// File generated from our OpenAPI spec by Stainless.

package com.openai.models.batches

import com.openai.core.JsonValue
import com.openai.models.Metadata
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BatchCreateParamsTest {

    @Test
    fun create() {
        BatchCreateParams.builder()
            .completionWindow(BatchCreateParams.CompletionWindow._24H)
            .endpoint(BatchCreateParams.Endpoint.V1_RESPONSES)
            .inputFileId("input_file_id")
            .metadata(
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            BatchCreateParams.builder()
                .completionWindow(BatchCreateParams.CompletionWindow._24H)
                .endpoint(BatchCreateParams.Endpoint.V1_RESPONSES)
                .inputFileId("input_file_id")
                .metadata(
                    Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.completionWindow()).isEqualTo(BatchCreateParams.CompletionWindow._24H)
        assertThat(body.endpoint()).isEqualTo(BatchCreateParams.Endpoint.V1_RESPONSES)
        assertThat(body.inputFileId()).isEqualTo("input_file_id")
        assertThat(body.metadata())
            .contains(
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            BatchCreateParams.builder()
                .completionWindow(BatchCreateParams.CompletionWindow._24H)
                .endpoint(BatchCreateParams.Endpoint.V1_RESPONSES)
                .inputFileId("input_file_id")
                .build()

        val body = params._body()

        assertThat(body.completionWindow()).isEqualTo(BatchCreateParams.CompletionWindow._24H)
        assertThat(body.endpoint()).isEqualTo(BatchCreateParams.Endpoint.V1_RESPONSES)
        assertThat(body.inputFileId()).isEqualTo("input_file_id")
    }
}
