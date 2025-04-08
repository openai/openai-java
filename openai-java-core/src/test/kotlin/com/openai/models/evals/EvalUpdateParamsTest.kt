// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EvalUpdateParamsTest {

    @Test
    fun create() {
        EvalUpdateParams.builder()
            .evalId("eval_id")
            .metadata(
                EvalUpdateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
            .name("name")
            .build()
    }

    @Test
    fun pathParams() {
        val params = EvalUpdateParams.builder().evalId("eval_id").build()

        assertThat(params._pathParam(0)).isEqualTo("eval_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            EvalUpdateParams.builder()
                .evalId("eval_id")
                .metadata(
                    EvalUpdateParams.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .name("name")
                .build()

        val body = params._body()

        assertThat(body.metadata())
            .contains(
                EvalUpdateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(body.name()).contains("name")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = EvalUpdateParams.builder().evalId("eval_id").build()

        val body = params._body()
    }
}
