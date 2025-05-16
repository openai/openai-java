// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals.runs

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CreateEvalJsonlRunDataSourceTest {

    @Test
    fun create() {
        val createEvalJsonlRunDataSource =
            CreateEvalJsonlRunDataSource.builder()
                .fileContentSource(
                    listOf(
                        CreateEvalJsonlRunDataSource.Source.FileContent.Content.builder()
                            .item(
                                CreateEvalJsonlRunDataSource.Source.FileContent.Content.Item
                                    .builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .sample(
                                CreateEvalJsonlRunDataSource.Source.FileContent.Content.Sample
                                    .builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .build()
                    )
                )
                .build()

        assertThat(createEvalJsonlRunDataSource.source())
            .isEqualTo(
                CreateEvalJsonlRunDataSource.Source.ofFileContent(
                    CreateEvalJsonlRunDataSource.Source.FileContent.builder()
                        .addContent(
                            CreateEvalJsonlRunDataSource.Source.FileContent.Content.builder()
                                .item(
                                    CreateEvalJsonlRunDataSource.Source.FileContent.Content.Item
                                        .builder()
                                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                                        .build()
                                )
                                .sample(
                                    CreateEvalJsonlRunDataSource.Source.FileContent.Content.Sample
                                        .builder()
                                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val createEvalJsonlRunDataSource =
            CreateEvalJsonlRunDataSource.builder()
                .fileContentSource(
                    listOf(
                        CreateEvalJsonlRunDataSource.Source.FileContent.Content.builder()
                            .item(
                                CreateEvalJsonlRunDataSource.Source.FileContent.Content.Item
                                    .builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .sample(
                                CreateEvalJsonlRunDataSource.Source.FileContent.Content.Sample
                                    .builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .build()
                    )
                )
                .build()

        val roundtrippedCreateEvalJsonlRunDataSource =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(createEvalJsonlRunDataSource),
                jacksonTypeRef<CreateEvalJsonlRunDataSource>(),
            )

        assertThat(roundtrippedCreateEvalJsonlRunDataSource).isEqualTo(createEvalJsonlRunDataSource)
    }
}
