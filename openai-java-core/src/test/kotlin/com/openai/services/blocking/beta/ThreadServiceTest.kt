// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.AssistantToolChoiceOption
import com.openai.models.AutoFileChunkingStrategyParam
import com.openai.models.BetaThreadCreateAndRunParams
import com.openai.models.BetaThreadCreateParams
import com.openai.models.BetaThreadDeleteParams
import com.openai.models.BetaThreadRetrieveParams
import com.openai.models.BetaThreadUpdateParams
import com.openai.models.ChatModel
import com.openai.models.CodeInterpreterTool
import com.openai.models.Metadata
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class ThreadServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val threadService = client.beta().threads()

        val thread =
            threadService.create(
                BetaThreadCreateParams.builder()
                    .addMessage(
                        BetaThreadCreateParams.Message.builder()
                            .content("string")
                            .role(BetaThreadCreateParams.Message.Role.USER)
                            .addAttachment(
                                BetaThreadCreateParams.Message.Attachment.builder()
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
                        BetaThreadCreateParams.ToolResources.builder()
                            .codeInterpreter(
                                BetaThreadCreateParams.ToolResources.CodeInterpreter.builder()
                                    .addFileId("string")
                                    .build()
                            )
                            .fileSearch(
                                BetaThreadCreateParams.ToolResources.FileSearch.builder()
                                    .addVectorStoreId("string")
                                    .addVectorStore(
                                        BetaThreadCreateParams.ToolResources.FileSearch.VectorStore
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

        thread.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val threadService = client.beta().threads()

        val thread =
            threadService.retrieve(BetaThreadRetrieveParams.builder().threadId("thread_id").build())

        thread.validate()
    }

    @Test
    fun update() {
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
                    .metadata(
                        Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .toolResources(
                        BetaThreadUpdateParams.ToolResources.builder()
                            .codeInterpreter(
                                BetaThreadUpdateParams.ToolResources.CodeInterpreter.builder()
                                    .addFileId("string")
                                    .build()
                            )
                            .fileSearch(
                                BetaThreadUpdateParams.ToolResources.FileSearch.builder()
                                    .addVectorStoreId("string")
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )

        thread.validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val threadService = client.beta().threads()

        val threadDeleted =
            threadService.delete(BetaThreadDeleteParams.builder().threadId("thread_id").build())

        threadDeleted.validate()
    }

    @Test
    fun createAndRun() {
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
                        BetaThreadCreateAndRunParams.Thread.builder()
                            .addMessage(
                                BetaThreadCreateAndRunParams.Thread.Message.builder()
                                    .content("string")
                                    .role(BetaThreadCreateAndRunParams.Thread.Message.Role.USER)
                                    .addAttachment(
                                        BetaThreadCreateAndRunParams.Thread.Message.Attachment
                                            .builder()
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
                                                        AutoFileChunkingStrategyParam.builder()
                                                            .build()
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
            )

        run.validate()
    }

    @Test
    fun createAndRunStreaming() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val threadService = client.beta().threads()

        val runStreamResponse =
            threadService.createAndRunStreaming(
                BetaThreadCreateAndRunParams.builder()
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
                        BetaThreadCreateAndRunParams.Thread.builder()
                            .addMessage(
                                BetaThreadCreateAndRunParams.Thread.Message.builder()
                                    .content("string")
                                    .role(BetaThreadCreateAndRunParams.Thread.Message.Role.USER)
                                    .addAttachment(
                                        BetaThreadCreateAndRunParams.Thread.Message.Attachment
                                            .builder()
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
                                                        AutoFileChunkingStrategyParam.builder()
                                                            .build()
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
            )

        runStreamResponse.use { runStreamResponse.stream().forEach { run -> run.validate() } }
    }
}
