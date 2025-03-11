// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.JsonValue
import com.openai.models.ChatModel
import com.openai.models.Metadata
import com.openai.models.beta.assistants.CodeInterpreterTool
import com.openai.models.beta.threads.AssistantToolChoiceOption
import com.openai.models.beta.threads.ThreadCreateAndRunParams
import com.openai.models.beta.threads.ThreadCreateParams
import com.openai.models.beta.threads.ThreadDeleteParams
import com.openai.models.beta.threads.ThreadRetrieveParams
import com.openai.models.beta.threads.ThreadUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class ThreadServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val threadServiceAsync = client.beta().threads()

        val threadFuture =
            threadServiceAsync.create(
                ThreadCreateParams.builder()
                    .addMessage(
                        ThreadCreateParams.Message.builder()
                            .content("string")
                            .role(ThreadCreateParams.Message.Role.USER)
                            .addAttachment(
                                ThreadCreateParams.Message.Attachment.builder()
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
                        ThreadCreateParams.ToolResources.builder()
                            .codeInterpreter(
                                ThreadCreateParams.ToolResources.CodeInterpreter.builder()
                                    .addFileId("string")
                                    .build()
                            )
                            .fileSearch(
                                ThreadCreateParams.ToolResources.FileSearch.builder()
                                    .addVectorStoreId("string")
                                    .addVectorStore(
                                        ThreadCreateParams.ToolResources.FileSearch.VectorStore
                                            .builder()
                                            .chunkingStrategyAuto()
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

        val thread = threadFuture.get()
        thread.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val threadServiceAsync = client.beta().threads()

        val threadFuture =
            threadServiceAsync.retrieve(
                ThreadRetrieveParams.builder().threadId("thread_id").build()
            )

        val thread = threadFuture.get()
        thread.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val threadServiceAsync = client.beta().threads()

        val threadFuture =
            threadServiceAsync.update(
                ThreadUpdateParams.builder()
                    .threadId("thread_id")
                    .metadata(
                        Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .toolResources(
                        ThreadUpdateParams.ToolResources.builder()
                            .codeInterpreter(
                                ThreadUpdateParams.ToolResources.CodeInterpreter.builder()
                                    .addFileId("string")
                                    .build()
                            )
                            .fileSearch(
                                ThreadUpdateParams.ToolResources.FileSearch.builder()
                                    .addVectorStoreId("string")
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )

        val thread = threadFuture.get()
        thread.validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val threadServiceAsync = client.beta().threads()

        val threadDeletedFuture =
            threadServiceAsync.delete(ThreadDeleteParams.builder().threadId("thread_id").build())

        val threadDeleted = threadDeletedFuture.get()
        threadDeleted.validate()
    }

    @Test
    fun createAndRun() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val threadServiceAsync = client.beta().threads()

        val runFuture =
            threadServiceAsync.createAndRun(
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
                    .responseFormatJsonValue()
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
                                        ThreadCreateAndRunParams.Thread.ToolResources
                                            .CodeInterpreter
                                            .builder()
                                            .addFileId("string")
                                            .build()
                                    )
                                    .fileSearch(
                                        ThreadCreateAndRunParams.Thread.ToolResources.FileSearch
                                            .builder()
                                            .addVectorStoreId("string")
                                            .addVectorStore(
                                                ThreadCreateAndRunParams.Thread.ToolResources
                                                    .FileSearch
                                                    .VectorStore
                                                    .builder()
                                                    .chunkingStrategyAuto()
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
            )

        val run = runFuture.get()
        run.validate()
    }

    @Test
    fun createAndRunStreaming() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val threadServiceAsync = client.beta().threads()

        val runStreamResponse =
            threadServiceAsync.createAndRunStreaming(
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
                    .responseFormatJsonValue()
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
                                        ThreadCreateAndRunParams.Thread.ToolResources
                                            .CodeInterpreter
                                            .builder()
                                            .addFileId("string")
                                            .build()
                                    )
                                    .fileSearch(
                                        ThreadCreateAndRunParams.Thread.ToolResources.FileSearch
                                            .builder()
                                            .addVectorStoreId("string")
                                            .addVectorStore(
                                                ThreadCreateAndRunParams.Thread.ToolResources
                                                    .FileSearch
                                                    .VectorStore
                                                    .builder()
                                                    .chunkingStrategyAuto()
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
            )

        val onCompleteFuture =
            runStreamResponse.subscribe { run -> run.validate() }.onCompleteFuture()
        onCompleteFuture.get()
    }
}
