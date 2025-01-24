// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BetaThreadCreateAndRunParamsTest {

    @Test
    fun createBetaThreadCreateAndRunParams() {
        BetaThreadCreateAndRunParams.builder()
            .assistantId("assistant_id")
            .instructions("instructions")
            .maxCompletionTokens(256L)
            .maxPromptTokens(256L)
            .metadata(JsonValue.from(mapOf<String, Any>()))
            .model(ChatModel.GPT_4O)
            .parallelToolCalls(true)
            .responseFormatAuto()
            .temperature(1.0)
            .thread(
                BetaThreadCreateAndRunParams.Thread.builder()
                    .addMessage(
                        BetaThreadCreateAndRunParams.Thread.Message.builder()
                            .content("string")
                            .role(BetaThreadCreateAndRunParams.Thread.Message.Role.USER)
                            .addAttachment(
                                BetaThreadCreateAndRunParams.Thread.Message.Attachment.builder()
                                    .fileId("file_id")
                                    .addTool(CodeInterpreterTool.builder().build())
                                    .build()
                            )
                            .metadata(JsonValue.from(mapOf<String, Any>()))
                            .build()
                    )
                    .metadata(JsonValue.from(mapOf<String, Any>()))
                    .toolResources(
                        BetaThreadCreateAndRunParams.Thread.ToolResources.builder()
                            .codeInterpreter(
                                BetaThreadCreateAndRunParams.Thread.ToolResources.CodeInterpreter
                                    .builder()
                                    .addFileId("string")
                                    .build()
                            )
                            .fileSearch(
                                BetaThreadCreateAndRunParams.Thread.ToolResources.FileSearch
                                    .builder()
                                    .addVectorStoreId("string")
                                    .addVectorStore(
                                        BetaThreadCreateAndRunParams.Thread.ToolResources.FileSearch
                                            .VectorStore
                                            .builder()
                                            .chunkingStrategy(
                                                AutoFileChunkingStrategyParam.builder().build()
                                            )
                                            .addFileId("string")
                                            .metadata(JsonValue.from(mapOf<String, Any>()))
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )
            .toolChoice(AssistantToolChoiceOption.Auto.NONE)
            .toolResources(
                BetaThreadCreateAndRunParams.ToolResources.builder()
                    .codeInterpreter(
                        BetaThreadCreateAndRunParams.ToolResources.CodeInterpreter.builder()
                            .addFileId("string")
                            .build()
                    )
                    .fileSearch(
                        BetaThreadCreateAndRunParams.ToolResources.FileSearch.builder()
                            .addVectorStoreId("string")
                            .build()
                    )
                    .build()
            )
            .addTool(CodeInterpreterTool.builder().build())
            .topP(1.0)
            .truncationStrategy(
                BetaThreadCreateAndRunParams.TruncationStrategy.builder()
                    .type(BetaThreadCreateAndRunParams.TruncationStrategy.Type.AUTO)
                    .lastMessages(1L)
                    .build()
            )
            .build()
    }

    @Test
    fun getBody() {
        val params =
            BetaThreadCreateAndRunParams.builder()
                .assistantId("assistant_id")
                .instructions("instructions")
                .maxCompletionTokens(256L)
                .maxPromptTokens(256L)
                .metadata(JsonValue.from(mapOf<String, Any>()))
                .model(ChatModel.GPT_4O)
                .parallelToolCalls(true)
                .responseFormatAuto()
                .temperature(1.0)
                .thread(
                    BetaThreadCreateAndRunParams.Thread.builder()
                        .addMessage(
                            BetaThreadCreateAndRunParams.Thread.Message.builder()
                                .content("string")
                                .role(BetaThreadCreateAndRunParams.Thread.Message.Role.USER)
                                .addAttachment(
                                    BetaThreadCreateAndRunParams.Thread.Message.Attachment.builder()
                                        .fileId("file_id")
                                        .addTool(CodeInterpreterTool.builder().build())
                                        .build()
                                )
                                .metadata(JsonValue.from(mapOf<String, Any>()))
                                .build()
                        )
                        .metadata(JsonValue.from(mapOf<String, Any>()))
                        .toolResources(
                            BetaThreadCreateAndRunParams.Thread.ToolResources.builder()
                                .codeInterpreter(
                                    BetaThreadCreateAndRunParams.Thread.ToolResources
                                        .CodeInterpreter
                                        .builder()
                                        .addFileId("string")
                                        .build()
                                )
                                .fileSearch(
                                    BetaThreadCreateAndRunParams.Thread.ToolResources.FileSearch
                                        .builder()
                                        .addVectorStoreId("string")
                                        .addVectorStore(
                                            BetaThreadCreateAndRunParams.Thread.ToolResources
                                                .FileSearch
                                                .VectorStore
                                                .builder()
                                                .chunkingStrategy(
                                                    AutoFileChunkingStrategyParam.builder().build()
                                                )
                                                .addFileId("string")
                                                .metadata(JsonValue.from(mapOf<String, Any>()))
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .toolChoice(AssistantToolChoiceOption.Auto.NONE)
                .toolResources(
                    BetaThreadCreateAndRunParams.ToolResources.builder()
                        .codeInterpreter(
                            BetaThreadCreateAndRunParams.ToolResources.CodeInterpreter.builder()
                                .addFileId("string")
                                .build()
                        )
                        .fileSearch(
                            BetaThreadCreateAndRunParams.ToolResources.FileSearch.builder()
                                .addVectorStoreId("string")
                                .build()
                        )
                        .build()
                )
                .addTool(CodeInterpreterTool.builder().build())
                .topP(1.0)
                .truncationStrategy(
                    BetaThreadCreateAndRunParams.TruncationStrategy.builder()
                        .type(BetaThreadCreateAndRunParams.TruncationStrategy.Type.AUTO)
                        .lastMessages(1L)
                        .build()
                )
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.assistantId()).isEqualTo("assistant_id")
        assertThat(body.instructions()).contains("instructions")
        assertThat(body.maxCompletionTokens()).contains(256L)
        assertThat(body.maxPromptTokens()).contains(256L)
        assertThat(body._metadata()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(body.model()).contains(ChatModel.GPT_4O)
        assertThat(body.parallelToolCalls()).contains(true)
        assertThat(body.responseFormat()).contains(AssistantResponseFormatOption.ofAuto())
        assertThat(body.temperature()).contains(1.0)
        assertThat(body.thread())
            .contains(
                BetaThreadCreateAndRunParams.Thread.builder()
                    .addMessage(
                        BetaThreadCreateAndRunParams.Thread.Message.builder()
                            .content("string")
                            .role(BetaThreadCreateAndRunParams.Thread.Message.Role.USER)
                            .addAttachment(
                                BetaThreadCreateAndRunParams.Thread.Message.Attachment.builder()
                                    .fileId("file_id")
                                    .addTool(CodeInterpreterTool.builder().build())
                                    .build()
                            )
                            .metadata(JsonValue.from(mapOf<String, Any>()))
                            .build()
                    )
                    .metadata(JsonValue.from(mapOf<String, Any>()))
                    .toolResources(
                        BetaThreadCreateAndRunParams.Thread.ToolResources.builder()
                            .codeInterpreter(
                                BetaThreadCreateAndRunParams.Thread.ToolResources.CodeInterpreter
                                    .builder()
                                    .addFileId("string")
                                    .build()
                            )
                            .fileSearch(
                                BetaThreadCreateAndRunParams.Thread.ToolResources.FileSearch
                                    .builder()
                                    .addVectorStoreId("string")
                                    .addVectorStore(
                                        BetaThreadCreateAndRunParams.Thread.ToolResources.FileSearch
                                            .VectorStore
                                            .builder()
                                            .chunkingStrategy(
                                                AutoFileChunkingStrategyParam.builder().build()
                                            )
                                            .addFileId("string")
                                            .metadata(JsonValue.from(mapOf<String, Any>()))
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )
        assertThat(body.toolChoice())
            .contains(AssistantToolChoiceOption.ofAuto(AssistantToolChoiceOption.Auto.NONE))
        assertThat(body.toolResources())
            .contains(
                BetaThreadCreateAndRunParams.ToolResources.builder()
                    .codeInterpreter(
                        BetaThreadCreateAndRunParams.ToolResources.CodeInterpreter.builder()
                            .addFileId("string")
                            .build()
                    )
                    .fileSearch(
                        BetaThreadCreateAndRunParams.ToolResources.FileSearch.builder()
                            .addVectorStoreId("string")
                            .build()
                    )
                    .build()
            )
        assertThat(body.tools())
            .contains(
                listOf(
                    BetaThreadCreateAndRunParams.Tool.ofCodeInterpreter(
                        CodeInterpreterTool.builder().build()
                    )
                )
            )
        assertThat(body.topP()).contains(1.0)
        assertThat(body.truncationStrategy())
            .contains(
                BetaThreadCreateAndRunParams.TruncationStrategy.builder()
                    .type(BetaThreadCreateAndRunParams.TruncationStrategy.Type.AUTO)
                    .lastMessages(1L)
                    .build()
            )
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params = BetaThreadCreateAndRunParams.builder().assistantId("assistant_id").build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.assistantId()).isEqualTo("assistant_id")
    }
}
