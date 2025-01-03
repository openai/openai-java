// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.AssistantResponseFormatOption
import com.openai.models.AssistantToolChoiceOption
import com.openai.models.AutoFileChunkingStrategyParam
import com.openai.models.BetaThreadCreateAndRunParams
import com.openai.models.BetaThreadCreateParams
import com.openai.models.BetaThreadDeleteParams
import com.openai.models.BetaThreadRetrieveParams
import com.openai.models.BetaThreadUpdateParams
import com.openai.models.ChatModel
import com.openai.models.CodeInterpreterTool
import com.openai.models.FileChunkingStrategyParam
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class ThreadServiceTest {

    @Test
    fun callCreate() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val threadService = client.beta().threads()
        val thread =
            threadService.create(
                BetaThreadCreateParams.builder()
                    .messages(
                        listOf(
                            BetaThreadCreateParams.Message.builder()
                                .content(
                                    BetaThreadCreateParams.Message.Content.ofTextContent("string")
                                )
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
                                            BetaThreadCreateParams.ToolResources.FileSearch
                                                .VectorStore
                                                .builder()
                                                .chunkingStrategy(
                                                    FileChunkingStrategyParam
                                                        .ofAutoFileChunkingStrategyParam(
                                                            AutoFileChunkingStrategyParam.builder()
                                                                .type(
                                                                    AutoFileChunkingStrategyParam
                                                                        .Type
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
            )
        println(thread)
        thread.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val threadService = client.beta().threads()
        val thread =
            threadService.retrieve(BetaThreadRetrieveParams.builder().threadId("thread_id").build())
        println(thread)
        thread.validate()
    }

    @Test
    fun callUpdate() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val threadService = client.beta().threads()
        val thread =
            threadService.update(
                BetaThreadUpdateParams.builder()
                    .threadId("thread_id")
                    .metadata(JsonValue.from(mapOf<String, Any>()))
                    .toolResources(
                        BetaThreadUpdateParams.ToolResources.builder()
                            .codeInterpreter(
                                BetaThreadUpdateParams.ToolResources.CodeInterpreter.builder()
                                    .fileIds(listOf("string"))
                                    .build()
                            )
                            .fileSearch(
                                BetaThreadUpdateParams.ToolResources.FileSearch.builder()
                                    .vectorStoreIds(listOf("string"))
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )
        println(thread)
        thread.validate()
    }

    @Test
    fun callDelete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val threadService = client.beta().threads()
        val threadDeleted =
            threadService.delete(BetaThreadDeleteParams.builder().threadId("thread_id").build())
        println(threadDeleted)
        threadDeleted.validate()
    }

    @Test
    fun callCreateAndRun() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val threadService = client.beta().threads()
        val run =
            threadService.createAndRun(
                BetaThreadCreateAndRunParams.builder()
                    .assistantId("assistant_id")
                    .instructions("instructions")
                    .maxCompletionTokens(256L)
                    .maxPromptTokens(256L)
                    .metadata(JsonValue.from(mapOf<String, Any>()))
                    .model(ChatModel.GPT_4O)
                    .parallelToolCalls(true)
                    .responseFormat(
                        AssistantResponseFormatOption.ofBehavior(
                            AssistantResponseFormatOption.Behavior.AUTO
                        )
                    )
                    .temperature(1.0)
                    .thread(
                        BetaThreadCreateAndRunParams.Thread.builder()
                            .messages(
                                listOf(
                                    BetaThreadCreateAndRunParams.Thread.Message.builder()
                                        .content(
                                            BetaThreadCreateAndRunParams.Thread.Message.Content
                                                .ofTextContent("string")
                                        )
                                        .role(BetaThreadCreateAndRunParams.Thread.Message.Role.USER)
                                        .attachments(
                                            listOf(
                                                BetaThreadCreateAndRunParams.Thread.Message
                                                    .Attachment
                                                    .builder()
                                                    .fileId("file_id")
                                                    .tools(
                                                        listOf(
                                                            BetaThreadCreateAndRunParams.Thread
                                                                .Message
                                                                .Attachment
                                                                .Tool
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
                                BetaThreadCreateAndRunParams.Thread.ToolResources.builder()
                                    .codeInterpreter(
                                        BetaThreadCreateAndRunParams.Thread.ToolResources
                                            .CodeInterpreter
                                            .builder()
                                            .fileIds(listOf("string"))
                                            .build()
                                    )
                                    .fileSearch(
                                        BetaThreadCreateAndRunParams.Thread.ToolResources.FileSearch
                                            .builder()
                                            .vectorStoreIds(listOf("string"))
                                            .vectorStores(
                                                listOf(
                                                    BetaThreadCreateAndRunParams.Thread
                                                        .ToolResources
                                                        .FileSearch
                                                        .VectorStore
                                                        .builder()
                                                        .chunkingStrategy(
                                                            FileChunkingStrategyParam
                                                                .ofAutoFileChunkingStrategyParam(
                                                                    AutoFileChunkingStrategyParam
                                                                        .builder()
                                                                        .type(
                                                                            AutoFileChunkingStrategyParam
                                                                                .Type
                                                                                .AUTO
                                                                        )
                                                                        .build()
                                                                )
                                                        )
                                                        .fileIds(listOf("string"))
                                                        .metadata(
                                                            JsonValue.from(mapOf<String, Any>())
                                                        )
                                                        .build()
                                                )
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .toolChoice(
                        AssistantToolChoiceOption.ofBehavior(
                            AssistantToolChoiceOption.Behavior.NONE
                        )
                    )
                    .toolResources(
                        BetaThreadCreateAndRunParams.ToolResources.builder()
                            .codeInterpreter(
                                BetaThreadCreateAndRunParams.ToolResources.CodeInterpreter.builder()
                                    .fileIds(listOf("string"))
                                    .build()
                            )
                            .fileSearch(
                                BetaThreadCreateAndRunParams.ToolResources.FileSearch.builder()
                                    .vectorStoreIds(listOf("string"))
                                    .build()
                            )
                            .build()
                    )
                    .tools(
                        listOf(
                            BetaThreadCreateAndRunParams.Tool.ofCodeInterpreterTool(
                                CodeInterpreterTool.builder()
                                    .type(CodeInterpreterTool.Type.CODE_INTERPRETER)
                                    .build()
                            )
                        )
                    )
                    .topP(1.0)
                    .truncationStrategy(
                        BetaThreadCreateAndRunParams.TruncationStrategy.builder()
                            .type(BetaThreadCreateAndRunParams.TruncationStrategy.Type.AUTO)
                            .lastMessages(1L)
                            .build()
                    )
                    .build()
            )
        println(run)
        run.validate()
    }

    @Test
    fun callCreateAndRunStreaming() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val threadService = client.beta().threads()

        val runStream =
            threadService.createAndRunStreaming(
                BetaThreadCreateAndRunParams.builder()
                    .assistantId("assistant_id")
                    .instructions("instructions")
                    .maxCompletionTokens(256L)
                    .maxPromptTokens(256L)
                    .metadata(JsonValue.from(mapOf<String, Any>()))
                    .model(ChatModel.GPT_4O)
                    .parallelToolCalls(true)
                    .responseFormat(
                        AssistantResponseFormatOption.ofBehavior(
                            AssistantResponseFormatOption.Behavior.AUTO
                        )
                    )
                    .temperature(1.0)
                    .thread(
                        BetaThreadCreateAndRunParams.Thread.builder()
                            .messages(
                                listOf(
                                    BetaThreadCreateAndRunParams.Thread.Message.builder()
                                        .content(
                                            BetaThreadCreateAndRunParams.Thread.Message.Content
                                                .ofTextContent("string")
                                        )
                                        .role(BetaThreadCreateAndRunParams.Thread.Message.Role.USER)
                                        .attachments(
                                            listOf(
                                                BetaThreadCreateAndRunParams.Thread.Message
                                                    .Attachment
                                                    .builder()
                                                    .fileId("file_id")
                                                    .tools(
                                                        listOf(
                                                            BetaThreadCreateAndRunParams.Thread
                                                                .Message
                                                                .Attachment
                                                                .Tool
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
                                BetaThreadCreateAndRunParams.Thread.ToolResources.builder()
                                    .codeInterpreter(
                                        BetaThreadCreateAndRunParams.Thread.ToolResources
                                            .CodeInterpreter
                                            .builder()
                                            .fileIds(listOf("string"))
                                            .build()
                                    )
                                    .fileSearch(
                                        BetaThreadCreateAndRunParams.Thread.ToolResources.FileSearch
                                            .builder()
                                            .vectorStoreIds(listOf("string"))
                                            .vectorStores(
                                                listOf(
                                                    BetaThreadCreateAndRunParams.Thread
                                                        .ToolResources
                                                        .FileSearch
                                                        .VectorStore
                                                        .builder()
                                                        .chunkingStrategy(
                                                            FileChunkingStrategyParam
                                                                .ofAutoFileChunkingStrategyParam(
                                                                    AutoFileChunkingStrategyParam
                                                                        .builder()
                                                                        .type(
                                                                            AutoFileChunkingStrategyParam
                                                                                .Type
                                                                                .AUTO
                                                                        )
                                                                        .build()
                                                                )
                                                        )
                                                        .fileIds(listOf("string"))
                                                        .metadata(
                                                            JsonValue.from(mapOf<String, Any>())
                                                        )
                                                        .build()
                                                )
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .toolChoice(
                        AssistantToolChoiceOption.ofBehavior(
                            AssistantToolChoiceOption.Behavior.NONE
                        )
                    )
                    .toolResources(
                        BetaThreadCreateAndRunParams.ToolResources.builder()
                            .codeInterpreter(
                                BetaThreadCreateAndRunParams.ToolResources.CodeInterpreter.builder()
                                    .fileIds(listOf("string"))
                                    .build()
                            )
                            .fileSearch(
                                BetaThreadCreateAndRunParams.ToolResources.FileSearch.builder()
                                    .vectorStoreIds(listOf("string"))
                                    .build()
                            )
                            .build()
                    )
                    .tools(
                        listOf(
                            BetaThreadCreateAndRunParams.Tool.ofCodeInterpreterTool(
                                CodeInterpreterTool.builder()
                                    .type(CodeInterpreterTool.Type.CODE_INTERPRETER)
                                    .build()
                            )
                        )
                    )
                    .topP(1.0)
                    .truncationStrategy(
                        BetaThreadCreateAndRunParams.TruncationStrategy.builder()
                            .type(BetaThreadCreateAndRunParams.TruncationStrategy.Type.AUTO)
                            .lastMessages(1L)
                            .build()
                    )
                    .build()
            )

        runStream.use {
            runStream.stream().forEach {
                println(it)
                it.validate()
            }
        }
    }
}
