// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BetaAssistantCreateParamsTest {

    @Test
    fun createBetaAssistantCreateParams() {
        BetaAssistantCreateParams.builder()
            .model(ChatModel.GPT_4O)
            .description("description")
            .instructions("instructions")
            .metadata(JsonValue.from(mapOf<String, Any>()))
            .name("name")
            .responseFormat(
                AssistantResponseFormatOption.ofBehavior(
                    AssistantResponseFormatOption.Behavior.AUTO
                )
            )
            .temperature(1.0)
            .toolResources(
                BetaAssistantCreateParams.ToolResources.builder()
                    .codeInterpreter(
                        BetaAssistantCreateParams.ToolResources.CodeInterpreter.builder()
                            .fileIds(listOf("string"))
                            .build()
                    )
                    .fileSearch(
                        BetaAssistantCreateParams.ToolResources.FileSearch.builder()
                            .vectorStoreIds(listOf("string"))
                            .vectorStores(
                                listOf(
                                    BetaAssistantCreateParams.ToolResources.FileSearch.VectorStore
                                        .builder()
                                        .chunkingStrategy(
                                            FileChunkingStrategyParam
                                                .ofAutoFileChunkingStrategyParam(
                                                    AutoFileChunkingStrategyParam.builder()
                                                        .type(
                                                            AutoFileChunkingStrategyParam.Type.AUTO
                                                        )
                                                        .build()
                                                )
                                        )
                                        .fileIds(listOf("string"))
                                        .metadata(JsonValue.from(mapOf<String, Any>()))
                                        .build()
                                )
                            )
                            .build()
                    )
                    .build()
            )
            .tools(
                listOf(
                    AssistantTool.ofCodeInterpreterTool(
                        CodeInterpreterTool.builder()
                            .type(CodeInterpreterTool.Type.CODE_INTERPRETER)
                            .build()
                    )
                )
            )
            .topP(1.0)
            .build()
    }

    @Test
    fun getBody() {
        val params =
            BetaAssistantCreateParams.builder()
                .model(ChatModel.GPT_4O)
                .description("description")
                .instructions("instructions")
                .metadata(JsonValue.from(mapOf<String, Any>()))
                .name("name")
                .responseFormat(
                    AssistantResponseFormatOption.ofBehavior(
                        AssistantResponseFormatOption.Behavior.AUTO
                    )
                )
                .temperature(1.0)
                .toolResources(
                    BetaAssistantCreateParams.ToolResources.builder()
                        .codeInterpreter(
                            BetaAssistantCreateParams.ToolResources.CodeInterpreter.builder()
                                .fileIds(listOf("string"))
                                .build()
                        )
                        .fileSearch(
                            BetaAssistantCreateParams.ToolResources.FileSearch.builder()
                                .vectorStoreIds(listOf("string"))
                                .vectorStores(
                                    listOf(
                                        BetaAssistantCreateParams.ToolResources.FileSearch
                                            .VectorStore
                                            .builder()
                                            .chunkingStrategy(
                                                FileChunkingStrategyParam
                                                    .ofAutoFileChunkingStrategyParam(
                                                        AutoFileChunkingStrategyParam.builder()
                                                            .type(
                                                                AutoFileChunkingStrategyParam.Type
                                                                    .AUTO
                                                            )
                                                            .build()
                                                    )
                                            )
                                            .fileIds(listOf("string"))
                                            .metadata(JsonValue.from(mapOf<String, Any>()))
                                            .build()
                                    )
                                )
                                .build()
                        )
                        .build()
                )
                .tools(
                    listOf(
                        AssistantTool.ofCodeInterpreterTool(
                            CodeInterpreterTool.builder()
                                .type(CodeInterpreterTool.Type.CODE_INTERPRETER)
                                .build()
                        )
                    )
                )
                .topP(1.0)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo(ChatModel.GPT_4O)
        assertThat(body.description()).contains("description")
        assertThat(body.instructions()).contains("instructions")
        assertThat(body.metadata()).contains(JsonValue.from(mapOf<String, Any>()))
        assertThat(body.name()).contains("name")
        assertThat(body.responseFormat())
            .contains(
                AssistantResponseFormatOption.ofBehavior(
                    AssistantResponseFormatOption.Behavior.AUTO
                )
            )
        assertThat(body.temperature()).contains(1.0)
        assertThat(body.toolResources())
            .contains(
                BetaAssistantCreateParams.ToolResources.builder()
                    .codeInterpreter(
                        BetaAssistantCreateParams.ToolResources.CodeInterpreter.builder()
                            .fileIds(listOf("string"))
                            .build()
                    )
                    .fileSearch(
                        BetaAssistantCreateParams.ToolResources.FileSearch.builder()
                            .vectorStoreIds(listOf("string"))
                            .vectorStores(
                                listOf(
                                    BetaAssistantCreateParams.ToolResources.FileSearch.VectorStore
                                        .builder()
                                        .chunkingStrategy(
                                            FileChunkingStrategyParam
                                                .ofAutoFileChunkingStrategyParam(
                                                    AutoFileChunkingStrategyParam.builder()
                                                        .type(
                                                            AutoFileChunkingStrategyParam.Type.AUTO
                                                        )
                                                        .build()
                                                )
                                        )
                                        .fileIds(listOf("string"))
                                        .metadata(JsonValue.from(mapOf<String, Any>()))
                                        .build()
                                )
                            )
                            .build()
                    )
                    .build()
            )
        assertThat(body.tools())
            .contains(
                listOf(
                    AssistantTool.ofCodeInterpreterTool(
                        CodeInterpreterTool.builder()
                            .type(CodeInterpreterTool.Type.CODE_INTERPRETER)
                            .build()
                    )
                )
            )
        assertThat(body.topP()).contains(1.0)
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params = BetaAssistantCreateParams.builder().model(ChatModel.GPT_4O).build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo(ChatModel.GPT_4O)
    }
}
