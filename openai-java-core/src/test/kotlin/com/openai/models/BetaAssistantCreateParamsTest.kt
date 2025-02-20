// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BetaAssistantCreateParamsTest {

    @Test
    fun create() {
        BetaAssistantCreateParams.builder()
            .model(ChatModel.O3_MINI)
            .description("description")
            .instructions("instructions")
            .metadata(
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
            )
            .name("name")
            .reasoningEffort(BetaAssistantCreateParams.ReasoningEffort.LOW)
            .responseFormatAuto()
            .temperature(1.0)
            .toolResources(
                BetaAssistantCreateParams.ToolResources.builder()
                    .codeInterpreter(
                        BetaAssistantCreateParams.ToolResources.CodeInterpreter.builder()
                            .addFileId("string")
                            .build()
                    )
                    .fileSearch(
                        BetaAssistantCreateParams.ToolResources.FileSearch.builder()
                            .addVectorStoreId("string")
                            .addVectorStore(
                                BetaAssistantCreateParams.ToolResources.FileSearch.VectorStore
                                    .builder()
                                    .chunkingStrategy(
                                        AutoFileChunkingStrategyParam.builder().build()
                                    )
                                    .addFileId("string")
                                    .metadata(
                                        Metadata.builder()
                                            .putAdditionalProperty("foo", JsonValue.from("string"))
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )
            .addTool(CodeInterpreterTool.builder().build())
            .topP(1.0)
            .build()
    }

    @Test
    fun body() {
        val params =
            BetaAssistantCreateParams.builder()
                .model(ChatModel.O3_MINI)
                .description("description")
                .instructions("instructions")
                .metadata(
                    Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .name("name")
                .reasoningEffort(BetaAssistantCreateParams.ReasoningEffort.LOW)
                .responseFormatAuto()
                .temperature(1.0)
                .toolResources(
                    BetaAssistantCreateParams.ToolResources.builder()
                        .codeInterpreter(
                            BetaAssistantCreateParams.ToolResources.CodeInterpreter.builder()
                                .addFileId("string")
                                .build()
                        )
                        .fileSearch(
                            BetaAssistantCreateParams.ToolResources.FileSearch.builder()
                                .addVectorStoreId("string")
                                .addVectorStore(
                                    BetaAssistantCreateParams.ToolResources.FileSearch.VectorStore
                                        .builder()
                                        .chunkingStrategy(
                                            AutoFileChunkingStrategyParam.builder().build()
                                        )
                                        .addFileId("string")
                                        .metadata(
                                            Metadata.builder()
                                                .putAdditionalProperty(
                                                    "foo",
                                                    JsonValue.from("string"),
                                                )
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .addTool(CodeInterpreterTool.builder().build())
                .topP(1.0)
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.model()).isEqualTo(ChatModel.O3_MINI)
        assertThat(body.description()).contains("description")
        assertThat(body.instructions()).contains("instructions")
        assertThat(body.metadata())
            .contains(
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
            )
        assertThat(body.name()).contains("name")
        assertThat(body.reasoningEffort()).contains(BetaAssistantCreateParams.ReasoningEffort.LOW)
        assertThat(body.responseFormat()).contains(AssistantResponseFormatOption.ofAuto())
        assertThat(body.temperature()).contains(1.0)
        assertThat(body.toolResources())
            .contains(
                BetaAssistantCreateParams.ToolResources.builder()
                    .codeInterpreter(
                        BetaAssistantCreateParams.ToolResources.CodeInterpreter.builder()
                            .addFileId("string")
                            .build()
                    )
                    .fileSearch(
                        BetaAssistantCreateParams.ToolResources.FileSearch.builder()
                            .addVectorStoreId("string")
                            .addVectorStore(
                                BetaAssistantCreateParams.ToolResources.FileSearch.VectorStore
                                    .builder()
                                    .chunkingStrategy(
                                        AutoFileChunkingStrategyParam.builder().build()
                                    )
                                    .addFileId("string")
                                    .metadata(
                                        Metadata.builder()
                                            .putAdditionalProperty("foo", JsonValue.from("string"))
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )
        assertThat(body.tools())
            .contains(
                listOf(AssistantTool.ofCodeInterpreter(CodeInterpreterTool.builder().build()))
            )
        assertThat(body.topP()).contains(1.0)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = BetaAssistantCreateParams.builder().model(ChatModel.O3_MINI).build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.model()).isEqualTo(ChatModel.O3_MINI)
    }
}
