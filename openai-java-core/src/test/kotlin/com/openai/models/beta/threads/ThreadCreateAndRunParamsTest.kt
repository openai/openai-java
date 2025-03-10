// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads

import com.openai.core.JsonValue
import com.openai.models.ChatModel
import com.openai.models.Metadata
import com.openai.models.beta.assistants.CodeInterpreterTool
import com.openai.models.beta.vectorstores.AutoFileChunkingStrategyParam
import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ThreadCreateAndRunParamsTest {

    @Test
    fun create() {
        ThreadCreateAndRunParams.builder()
            .assistantId("assistant_id")
            .instructions("instructions")
            .maxCompletionTokens(256L)
            .maxPromptTokens(256L)
            .metadata(
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
            )
            .model(ChatModel.O3_MINI)
            .parallelToolCalls(true)
            .responseFormatAuto()
            .temperature(1.0)
            .thread(
                ThreadCreateAndRunParams.Thread.builder()
                    .addMessage(
                        ThreadCreateAndRunParams.Thread.Message.builder()
                            .content("string")
                            .role(ThreadCreateAndRunParams.Thread.Message.Role.USER)
                            .addAttachment(
                                ThreadCreateAndRunParams.Thread.Message.Attachment.builder()
                                    .fileId("file_id")
                                    .addTool(CodeInterpreterTool.builder().build())
                                    .build()
                            )
                            .metadata(
                                Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .build()
                    )
                    .metadata(
                        Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .toolResources(
                        ThreadCreateAndRunParams.Thread.ToolResources.builder()
                            .codeInterpreter(
                                ThreadCreateAndRunParams.Thread.ToolResources.CodeInterpreter
                                    .builder()
                                    .addFileId("string")
                                    .build()
                            )
                            .fileSearch(
                                ThreadCreateAndRunParams.Thread.ToolResources.FileSearch.builder()
                                    .addVectorStoreId("string")
                                    .addVectorStore(
                                        ThreadCreateAndRunParams.Thread.ToolResources.FileSearch
                                            .VectorStore
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
                    .build()
            )
            .toolChoice(AssistantToolChoiceOption.Auto.NONE)
            .toolResources(
                ThreadCreateAndRunParams.ToolResources.builder()
                    .codeInterpreter(
                        ThreadCreateAndRunParams.ToolResources.CodeInterpreter.builder()
                            .addFileId("string")
                            .build()
                    )
                    .fileSearch(
                        ThreadCreateAndRunParams.ToolResources.FileSearch.builder()
                            .addVectorStoreId("string")
                            .build()
                    )
                    .build()
            )
            .addTool(CodeInterpreterTool.builder().build())
            .topP(1.0)
            .truncationStrategy(
                ThreadCreateAndRunParams.TruncationStrategy.builder()
                    .type(ThreadCreateAndRunParams.TruncationStrategy.Type.AUTO)
                    .lastMessages(1L)
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            ThreadCreateAndRunParams.builder()
                .assistantId("assistant_id")
                .instructions("instructions")
                .maxCompletionTokens(256L)
                .maxPromptTokens(256L)
                .metadata(
                    Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .model(ChatModel.O3_MINI)
                .parallelToolCalls(true)
                .responseFormatAuto()
                .temperature(1.0)
                .thread(
                    ThreadCreateAndRunParams.Thread.builder()
                        .addMessage(
                            ThreadCreateAndRunParams.Thread.Message.builder()
                                .content("string")
                                .role(ThreadCreateAndRunParams.Thread.Message.Role.USER)
                                .addAttachment(
                                    ThreadCreateAndRunParams.Thread.Message.Attachment.builder()
                                        .fileId("file_id")
                                        .addTool(CodeInterpreterTool.builder().build())
                                        .build()
                                )
                                .metadata(
                                    Metadata.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("string"))
                                        .build()
                                )
                                .build()
                        )
                        .metadata(
                            Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .toolResources(
                            ThreadCreateAndRunParams.Thread.ToolResources.builder()
                                .codeInterpreter(
                                    ThreadCreateAndRunParams.Thread.ToolResources.CodeInterpreter
                                        .builder()
                                        .addFileId("string")
                                        .build()
                                )
                                .fileSearch(
                                    ThreadCreateAndRunParams.Thread.ToolResources.FileSearch
                                        .builder()
                                        .addVectorStoreId("string")
                                        .addVectorStore(
                                            ThreadCreateAndRunParams.Thread.ToolResources.FileSearch
                                                .VectorStore
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
                        .build()
                )
                .toolChoice(AssistantToolChoiceOption.Auto.NONE)
                .toolResources(
                    ThreadCreateAndRunParams.ToolResources.builder()
                        .codeInterpreter(
                            ThreadCreateAndRunParams.ToolResources.CodeInterpreter.builder()
                                .addFileId("string")
                                .build()
                        )
                        .fileSearch(
                            ThreadCreateAndRunParams.ToolResources.FileSearch.builder()
                                .addVectorStoreId("string")
                                .build()
                        )
                        .build()
                )
                .addTool(CodeInterpreterTool.builder().build())
                .topP(1.0)
                .truncationStrategy(
                    ThreadCreateAndRunParams.TruncationStrategy.builder()
                        .type(ThreadCreateAndRunParams.TruncationStrategy.Type.AUTO)
                        .lastMessages(1L)
                        .build()
                )
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.assistantId()).isEqualTo("assistant_id")
        assertThat(body.instructions()).contains("instructions")
        assertThat(body.maxCompletionTokens()).contains(256L)
        assertThat(body.maxPromptTokens()).contains(256L)
        assertThat(body.metadata())
            .contains(
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
            )
        assertThat(body.model()).contains(ChatModel.O3_MINI)
        assertThat(body.parallelToolCalls()).contains(true)
        assertThat(body.responseFormat()).contains(AssistantResponseFormatOption.ofAuto())
        assertThat(body.temperature()).contains(1.0)
        assertThat(body.thread())
            .contains(
                ThreadCreateAndRunParams.Thread.builder()
                    .addMessage(
                        ThreadCreateAndRunParams.Thread.Message.builder()
                            .content("string")
                            .role(ThreadCreateAndRunParams.Thread.Message.Role.USER)
                            .addAttachment(
                                ThreadCreateAndRunParams.Thread.Message.Attachment.builder()
                                    .fileId("file_id")
                                    .addTool(CodeInterpreterTool.builder().build())
                                    .build()
                            )
                            .metadata(
                                Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .build()
                    )
                    .metadata(
                        Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .toolResources(
                        ThreadCreateAndRunParams.Thread.ToolResources.builder()
                            .codeInterpreter(
                                ThreadCreateAndRunParams.Thread.ToolResources.CodeInterpreter
                                    .builder()
                                    .addFileId("string")
                                    .build()
                            )
                            .fileSearch(
                                ThreadCreateAndRunParams.Thread.ToolResources.FileSearch.builder()
                                    .addVectorStoreId("string")
                                    .addVectorStore(
                                        ThreadCreateAndRunParams.Thread.ToolResources.FileSearch
                                            .VectorStore
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
                    .build()
            )
        assertThat(body.toolChoice())
            .contains(AssistantToolChoiceOption.ofAuto(AssistantToolChoiceOption.Auto.NONE))
        assertThat(body.toolResources())
            .contains(
                ThreadCreateAndRunParams.ToolResources.builder()
                    .codeInterpreter(
                        ThreadCreateAndRunParams.ToolResources.CodeInterpreter.builder()
                            .addFileId("string")
                            .build()
                    )
                    .fileSearch(
                        ThreadCreateAndRunParams.ToolResources.FileSearch.builder()
                            .addVectorStoreId("string")
                            .build()
                    )
                    .build()
            )
        assertThat(body.tools())
            .contains(
                listOf(
                    ThreadCreateAndRunParams.Tool.ofCodeInterpreter(
                        CodeInterpreterTool.builder().build()
                    )
                )
            )
        assertThat(body.topP()).contains(1.0)
        assertThat(body.truncationStrategy())
            .contains(
                ThreadCreateAndRunParams.TruncationStrategy.builder()
                    .type(ThreadCreateAndRunParams.TruncationStrategy.Type.AUTO)
                    .lastMessages(1L)
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ThreadCreateAndRunParams.builder().assistantId("assistant_id").build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.assistantId()).isEqualTo("assistant_id")
    }
}
