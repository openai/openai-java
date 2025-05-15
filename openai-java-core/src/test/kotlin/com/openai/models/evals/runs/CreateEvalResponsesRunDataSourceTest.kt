// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals.runs

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CreateEvalResponsesRunDataSourceTest {

    @Test
    fun create() {
        val createEvalResponsesRunDataSource =
            CreateEvalResponsesRunDataSource.builder()
                .fileContentSource(
                    listOf(
                        CreateEvalResponsesRunDataSource.Source.FileContent.Content.builder()
                            .item(
                                CreateEvalResponsesRunDataSource.Source.FileContent.Content.Item
                                    .builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .sample(
                                CreateEvalResponsesRunDataSource.Source.FileContent.Content.Sample
                                    .builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .build()
                    )
                )
                .type(CreateEvalResponsesRunDataSource.Type.RESPONSES)
                .templateInputMessages(
                    listOf(
                        CreateEvalResponsesRunDataSource.InputMessages.Template.InnerTemplate
                            .ofChatMessage(
                                CreateEvalResponsesRunDataSource.InputMessages.Template
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
                .samplingParams(
                    CreateEvalResponsesRunDataSource.SamplingParams.builder()
                        .maxCompletionTokens(0L)
                        .seed(0L)
                        .temperature(0.0)
                        .topP(0.0)
                        .build()
                )
                .build()

        assertThat(createEvalResponsesRunDataSource.source())
            .isEqualTo(
                CreateEvalResponsesRunDataSource.Source.ofFileContent(
                    CreateEvalResponsesRunDataSource.Source.FileContent.builder()
                        .addContent(
                            CreateEvalResponsesRunDataSource.Source.FileContent.Content.builder()
                                .item(
                                    CreateEvalResponsesRunDataSource.Source.FileContent.Content.Item
                                        .builder()
                                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                                        .build()
                                )
                                .sample(
                                    CreateEvalResponsesRunDataSource.Source.FileContent.Content
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
        assertThat(createEvalResponsesRunDataSource.type())
            .isEqualTo(CreateEvalResponsesRunDataSource.Type.RESPONSES)
        assertThat(createEvalResponsesRunDataSource.inputMessages())
            .contains(
                CreateEvalResponsesRunDataSource.InputMessages.ofTemplate(
                    CreateEvalResponsesRunDataSource.InputMessages.Template.builder()
                        .addTemplate(
                            CreateEvalResponsesRunDataSource.InputMessages.Template.InnerTemplate
                                .ChatMessage
                                .builder()
                                .content("content")
                                .role("role")
                                .build()
                        )
                        .build()
                )
            )
        assertThat(createEvalResponsesRunDataSource.model()).contains("model")
        assertThat(createEvalResponsesRunDataSource.samplingParams())
            .contains(
                CreateEvalResponsesRunDataSource.SamplingParams.builder()
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
        val createEvalResponsesRunDataSource =
            CreateEvalResponsesRunDataSource.builder()
                .fileContentSource(
                    listOf(
                        CreateEvalResponsesRunDataSource.Source.FileContent.Content.builder()
                            .item(
                                CreateEvalResponsesRunDataSource.Source.FileContent.Content.Item
                                    .builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .sample(
                                CreateEvalResponsesRunDataSource.Source.FileContent.Content.Sample
                                    .builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .build()
                    )
                )
                .type(CreateEvalResponsesRunDataSource.Type.RESPONSES)
                .templateInputMessages(
                    listOf(
                        CreateEvalResponsesRunDataSource.InputMessages.Template.InnerTemplate
                            .ofChatMessage(
                                CreateEvalResponsesRunDataSource.InputMessages.Template
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
                .samplingParams(
                    CreateEvalResponsesRunDataSource.SamplingParams.builder()
                        .maxCompletionTokens(0L)
                        .seed(0L)
                        .temperature(0.0)
                        .topP(0.0)
                        .build()
                )
                .build()

        val roundtrippedCreateEvalResponsesRunDataSource =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(createEvalResponsesRunDataSource),
                jacksonTypeRef<CreateEvalResponsesRunDataSource>(),
            )

        assertThat(roundtrippedCreateEvalResponsesRunDataSource)
            .isEqualTo(createEvalResponsesRunDataSource)
    }
}
