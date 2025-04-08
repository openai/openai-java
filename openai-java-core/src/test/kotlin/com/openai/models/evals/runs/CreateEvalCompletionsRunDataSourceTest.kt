// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals.runs

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CreateEvalCompletionsRunDataSourceTest {

    @Test
    fun create() {
        val createEvalCompletionsRunDataSource =
            CreateEvalCompletionsRunDataSource.builder()
                .templateInputMessages(
                    listOf(
                        CreateEvalCompletionsRunDataSource.InputMessages.Template.InnerTemplate
                            .ofChatMessage(
                                CreateEvalCompletionsRunDataSource.InputMessages.Template
                                    .InnerTemplate
                                    .ChatMessage
                                    .builder()
                                    .content("content")
                                    .role("role")
                                    .build()
                            )
                    )
                )
                .model("model")
                .fileContentSource(
                    listOf(
                        CreateEvalCompletionsRunDataSource.Source.FileContent.Content.builder()
                            .item(
                                CreateEvalCompletionsRunDataSource.Source.FileContent.Content.Item
                                    .builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .sample(
                                CreateEvalCompletionsRunDataSource.Source.FileContent.Content.Sample
                                    .builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .build()
                    )
                )
                .type(CreateEvalCompletionsRunDataSource.Type.COMPLETIONS)
                .samplingParams(
                    CreateEvalCompletionsRunDataSource.SamplingParams.builder()
                        .maxCompletionTokens(0L)
                        .seed(0L)
                        .temperature(0.0)
                        .topP(0.0)
                        .build()
                )
                .build()

        assertThat(createEvalCompletionsRunDataSource.inputMessages())
            .isEqualTo(
                CreateEvalCompletionsRunDataSource.InputMessages.ofTemplate(
                    CreateEvalCompletionsRunDataSource.InputMessages.Template.builder()
                        .addTemplate(
                            CreateEvalCompletionsRunDataSource.InputMessages.Template.InnerTemplate
                                .ChatMessage
                                .builder()
                                .content("content")
                                .role("role")
                                .build()
                        )
                        .build()
                )
            )
        assertThat(createEvalCompletionsRunDataSource.model()).isEqualTo("model")
        assertThat(createEvalCompletionsRunDataSource.source())
            .isEqualTo(
                CreateEvalCompletionsRunDataSource.Source.ofFileContent(
                    CreateEvalCompletionsRunDataSource.Source.FileContent.builder()
                        .addContent(
                            CreateEvalCompletionsRunDataSource.Source.FileContent.Content.builder()
                                .item(
                                    CreateEvalCompletionsRunDataSource.Source.FileContent.Content
                                        .Item
                                        .builder()
                                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                                        .build()
                                )
                                .sample(
                                    CreateEvalCompletionsRunDataSource.Source.FileContent.Content
                                        .Sample
                                        .builder()
                                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
            )
        assertThat(createEvalCompletionsRunDataSource.type())
            .isEqualTo(CreateEvalCompletionsRunDataSource.Type.COMPLETIONS)
        assertThat(createEvalCompletionsRunDataSource.samplingParams())
            .contains(
                CreateEvalCompletionsRunDataSource.SamplingParams.builder()
                    .maxCompletionTokens(0L)
                    .seed(0L)
                    .temperature(0.0)
                    .topP(0.0)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val createEvalCompletionsRunDataSource =
            CreateEvalCompletionsRunDataSource.builder()
                .templateInputMessages(
                    listOf(
                        CreateEvalCompletionsRunDataSource.InputMessages.Template.InnerTemplate
                            .ofChatMessage(
                                CreateEvalCompletionsRunDataSource.InputMessages.Template
                                    .InnerTemplate
                                    .ChatMessage
                                    .builder()
                                    .content("content")
                                    .role("role")
                                    .build()
                            )
                    )
                )
                .model("model")
                .fileContentSource(
                    listOf(
                        CreateEvalCompletionsRunDataSource.Source.FileContent.Content.builder()
                            .item(
                                CreateEvalCompletionsRunDataSource.Source.FileContent.Content.Item
                                    .builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .sample(
                                CreateEvalCompletionsRunDataSource.Source.FileContent.Content.Sample
                                    .builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .build()
                    )
                )
                .type(CreateEvalCompletionsRunDataSource.Type.COMPLETIONS)
                .samplingParams(
                    CreateEvalCompletionsRunDataSource.SamplingParams.builder()
                        .maxCompletionTokens(0L)
                        .seed(0L)
                        .temperature(0.0)
                        .topP(0.0)
                        .build()
                )
                .build()

        val roundtrippedCreateEvalCompletionsRunDataSource =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(createEvalCompletionsRunDataSource),
                jacksonTypeRef<CreateEvalCompletionsRunDataSource>(),
            )

        assertThat(roundtrippedCreateEvalCompletionsRunDataSource)
            .isEqualTo(createEvalCompletionsRunDataSource)
    }
}
