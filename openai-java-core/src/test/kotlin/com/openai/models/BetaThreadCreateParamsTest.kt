// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BetaThreadCreateParamsTest {

    @Test
    fun createBetaThreadCreateParams() {
        BetaThreadCreateParams.builder()
            .messages(
                listOf(
                    BetaThreadCreateParams.Message.builder()
                        .content(BetaThreadCreateParams.Message.Content.ofTextContent("string"))
                        .role(BetaThreadCreateParams.Message.Role.USER)
                        .attachments(
                            listOf(
                                BetaThreadCreateParams.Message.Attachment.builder()
                                    .fileId("file_id")
                                    .tools(
                                        listOf(
                                            BetaThreadCreateParams.Message.Attachment.Tool
                                                .ofCodeInterpreterTool(
                                                    CodeInterpreterTool.builder()
                                                        .type(
                                                            CodeInterpreterTool.Type
                                                                .CODE_INTERPRETER
                                                        )
                                                        .build()
                                                )
                                        )
                                    )
                                    .build()
                            )
                        )
                        .metadata(JsonValue.from(mapOf<String, Any>()))
                        .build()
                )
            )
            .metadata(JsonValue.from(mapOf<String, Any>()))
            .toolResources(
                BetaThreadCreateParams.ToolResources.builder()
                    .codeInterpreter(
                        BetaThreadCreateParams.ToolResources.CodeInterpreter.builder()
                            .fileIds(listOf("string"))
                            .build()
                    )
                    .fileSearch(
                        BetaThreadCreateParams.ToolResources.FileSearch.builder()
                            .vectorStoreIds(listOf("string"))
                            .vectorStores(
                                listOf(
                                    BetaThreadCreateParams.ToolResources.FileSearch.VectorStore
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
            .build()
    }

    @Test
    fun getBody() {
        val params =
            BetaThreadCreateParams.builder()
                .messages(
                    listOf(
                        BetaThreadCreateParams.Message.builder()
                            .content(BetaThreadCreateParams.Message.Content.ofTextContent("string"))
                            .role(BetaThreadCreateParams.Message.Role.USER)
                            .attachments(
                                listOf(
                                    BetaThreadCreateParams.Message.Attachment.builder()
                                        .fileId("file_id")
                                        .tools(
                                            listOf(
                                                BetaThreadCreateParams.Message.Attachment.Tool
                                                    .ofCodeInterpreterTool(
                                                        CodeInterpreterTool.builder()
                                                            .type(
                                                                CodeInterpreterTool.Type
                                                                    .CODE_INTERPRETER
                                                            )
                                                            .build()
                                                    )
                                            )
                                        )
                                        .build()
                                )
                            )
                            .metadata(JsonValue.from(mapOf<String, Any>()))
                            .build()
                    )
                )
                .metadata(JsonValue.from(mapOf<String, Any>()))
                .toolResources(
                    BetaThreadCreateParams.ToolResources.builder()
                        .codeInterpreter(
                            BetaThreadCreateParams.ToolResources.CodeInterpreter.builder()
                                .fileIds(listOf("string"))
                                .build()
                        )
                        .fileSearch(
                            BetaThreadCreateParams.ToolResources.FileSearch.builder()
                                .vectorStoreIds(listOf("string"))
                                .vectorStores(
                                    listOf(
                                        BetaThreadCreateParams.ToolResources.FileSearch.VectorStore
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
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.messages())
            .contains(
                listOf(
                    BetaThreadCreateParams.Message.builder()
                        .content(BetaThreadCreateParams.Message.Content.ofTextContent("string"))
                        .role(BetaThreadCreateParams.Message.Role.USER)
                        .attachments(
                            listOf(
                                BetaThreadCreateParams.Message.Attachment.builder()
                                    .fileId("file_id")
                                    .tools(
                                        listOf(
                                            BetaThreadCreateParams.Message.Attachment.Tool
                                                .ofCodeInterpreterTool(
                                                    CodeInterpreterTool.builder()
                                                        .type(
                                                            CodeInterpreterTool.Type
                                                                .CODE_INTERPRETER
                                                        )
                                                        .build()
                                                )
                                        )
                                    )
                                    .build()
                            )
                        )
                        .metadata(JsonValue.from(mapOf<String, Any>()))
                        .build()
                )
            )
        assertThat(body._metadata()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(body.toolResources())
            .contains(
                BetaThreadCreateParams.ToolResources.builder()
                    .codeInterpreter(
                        BetaThreadCreateParams.ToolResources.CodeInterpreter.builder()
                            .fileIds(listOf("string"))
                            .build()
                    )
                    .fileSearch(
                        BetaThreadCreateParams.ToolResources.FileSearch.builder()
                            .vectorStoreIds(listOf("string"))
                            .vectorStores(
                                listOf(
                                    BetaThreadCreateParams.ToolResources.FileSearch.VectorStore
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
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params = BetaThreadCreateParams.builder().build()
        val body = params.getBody()
        assertThat(body).isNotNull
    }
}
