// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals.runs

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EvalJsonlFileContentSourceTest {

    @Test
    fun create() {
        val evalJsonlFileContentSource =
            EvalJsonlFileContentSource.builder()
                .addContent(
                    EvalJsonlFileContentSource.Content.builder()
                        .item(
                            EvalJsonlFileContentSource.Content.Item.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .sample(
                            EvalJsonlFileContentSource.Content.Sample.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
                .build()

        assertThat(evalJsonlFileContentSource.content())
            .containsExactly(
                EvalJsonlFileContentSource.Content.builder()
                    .item(
                        EvalJsonlFileContentSource.Content.Item.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .sample(
                        EvalJsonlFileContentSource.Content.Sample.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val evalJsonlFileContentSource =
            EvalJsonlFileContentSource.builder()
                .addContent(
                    EvalJsonlFileContentSource.Content.builder()
                        .item(
                            EvalJsonlFileContentSource.Content.Item.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .sample(
                            EvalJsonlFileContentSource.Content.Sample.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
                .build()

        val roundtrippedEvalJsonlFileContentSource =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(evalJsonlFileContentSource),
                jacksonTypeRef<EvalJsonlFileContentSource>(),
            )

        assertThat(roundtrippedEvalJsonlFileContentSource).isEqualTo(evalJsonlFileContentSource)
    }
}
