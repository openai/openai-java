// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.ChatModel
import com.openai.models.beta.assistants.CodeInterpreterTool
import com.openai.models.beta.threads.AssistantToolChoiceOption
import com.openai.models.beta.threads.ThreadCreateAndRunParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ThreadServiceStreamingServerContractTest {

    @Test
    fun createAndRunStreaming() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val threadService = client.beta().threads()

        val runStreamResponse =
            threadService.createAndRunStreaming(
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

        var received = 0
        runStreamResponse.use {
            runStreamResponse.stream().forEach { event ->
                event.validate()
                received++
            }
        }
        check(received > 0) { "Expected at least one streaming event" }
    }
}
