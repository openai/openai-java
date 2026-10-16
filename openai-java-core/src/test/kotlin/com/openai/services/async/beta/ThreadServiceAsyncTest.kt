// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.JsonValue
import com.openai.models.ChatModel
import com.openai.models.beta.assistants.CodeInterpreterTool
import com.openai.models.beta.threads.AssistantToolChoiceOption
import com.openai.models.beta.threads.ThreadCreateAndRunParams
import com.openai.models.beta.threads.ThreadCreateParams
import com.openai.models.beta.threads.ThreadUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.parallel.ResourceLock

@ExtendWith(TestServerExtension::class)
@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ThreadServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
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
                                ThreadCreateParams.Message.Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .build()
                    )
                    .metadata(
                        ThreadCreateParams.Metadata.builder()
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
                                                ThreadCreateParams.ToolResources.FileSearch
                                                    .VectorStore
                                                    .Metadata
                                                    .builder()
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
                .adminApiKey("My Admin API Key")
                .build()
        val threadServiceAsync = client.beta().threads()

        val threadFuture = threadServiceAsync.retrieve("thread_id")

        val thread = threadFuture.get()
        thread.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val threadServiceAsync = client.beta().threads()

        val threadFuture =
            threadServiceAsync.update(
                ThreadUpdateParams.builder()
                    .threadId("thread_id")
                    .metadata(
                        ThreadUpdateParams.Metadata.builder()
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
                .adminApiKey("My Admin API Key")
                .build()
        val threadServiceAsync = client.beta().threads()

        val threadDeletedFuture = threadServiceAsync.delete("thread_id")

        val threadDeleted = threadDeletedFuture.get()
        threadDeleted.validate()
    }

    @Test
    fun createAndRun() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
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
                        ThreadCreateAndRunParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .model(ChatModel.GPT_4_1)
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
                                        ThreadCreateAndRunParams.Thread.Message.Metadata.builder()
                                            .putAdditionalProperty("foo", JsonValue.from("string"))
                                            .build()
                                    )
                                    .build()
                            )
                            .metadata(
                                ThreadCreateAndRunParams.Thread.Metadata.builder()
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
                                                        ThreadCreateAndRunParams.Thread
                                                            .ToolResources
                                                            .FileSearch
                                                            .VectorStore
                                                            .Metadata
                                                            .builder()
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
    fun createAndRunStreaming(wmRuntimeInfo: WireMockRuntimeInfo) {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val threadServiceAsync = client.beta().threads()

        stubFor(
            post(anyUrl())
                .withHeader("Accept", equalTo("text/event-stream"))
                .withRequestBody(matchingJsonPath("\$[\"stream\"]", equalTo("true")))
                .willReturn(
                    ok()
                        .withHeader("Content-Type", "text/event-stream")
                        .withBody(
                            "event: thread.created\ndata: {\"id\":\"id\",\"created_at\":0,\"metadata\":{\"foo\":\"string\"},\"object\":\"thread\",\"tool_resources\":{\"code_interpreter\":{\"file_ids\":[\"string\"]},\"file_search\":{\"vector_store_ids\":[\"string\"]}}}\n\n"
                        )
                )
        )

        val runStreamResponse =
            threadServiceAsync.createAndRunStreaming(
                ThreadCreateAndRunParams.builder()
                    .assistantId("assistant_id")
                    .instructions("instructions")
                    .maxCompletionTokens(256L)
                    .maxPromptTokens(256L)
                    .metadata(
                        ThreadCreateAndRunParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .model(ChatModel.GPT_4_1)
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
                                        ThreadCreateAndRunParams.Thread.Message.Metadata.builder()
                                            .putAdditionalProperty("foo", JsonValue.from("string"))
                                            .build()
                                    )
                                    .build()
                            )
                            .metadata(
                                ThreadCreateAndRunParams.Thread.Metadata.builder()
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
                                                        ThreadCreateAndRunParams.Thread
                                                            .ToolResources
                                                            .FileSearch
                                                            .VectorStore
                                                            .Metadata
                                                            .builder()
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

        val received = java.util.concurrent.atomic.AtomicInteger()
        val onCompleteFuture =
            runStreamResponse
                .subscribe { event ->
                    event.validate()
                    received.incrementAndGet()
                }
                .onCompleteFuture()
        onCompleteFuture.get()
        check(received.get() > 0) { "Expected at least one streaming event" }
    }
}
