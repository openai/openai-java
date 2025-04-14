// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.JsonValue
import com.openai.models.ChatModel
import com.openai.models.ReasoningEffort
import com.openai.models.beta.assistants.AssistantCreateParams
import com.openai.models.beta.assistants.AssistantDeleteParams
import com.openai.models.beta.assistants.AssistantRetrieveParams
import com.openai.models.beta.assistants.AssistantUpdateParams
import com.openai.models.beta.assistants.CodeInterpreterTool
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class AssistantServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val assistantServiceAsync = client.beta().assistants()

        val assistantFuture =
            assistantServiceAsync.create(
                AssistantCreateParams.builder()
                    .model(ChatModel.GPT_4_1)
                    .description("description")
                    .instructions("instructions")
                    .metadata(
                        AssistantCreateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .name("name")
                    .reasoningEffort(ReasoningEffort.LOW)
                    .responseFormatAuto()
                    .temperature(1.0)
                    .toolResources(
                        AssistantCreateParams.ToolResources.builder()
                            .codeInterpreter(
                                AssistantCreateParams.ToolResources.CodeInterpreter.builder()
                                    .addFileId("string")
                                    .build()
                            )
                            .fileSearch(
                                AssistantCreateParams.ToolResources.FileSearch.builder()
                                    .addVectorStoreId("string")
                                    .addVectorStore(
                                        AssistantCreateParams.ToolResources.FileSearch.VectorStore
                                            .builder()
                                            .chunkingStrategyAuto()
                                            .addFileId("string")
                                            .metadata(
                                                AssistantCreateParams.ToolResources.FileSearch
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
                    .addTool(CodeInterpreterTool.builder().build())
                    .topP(1.0)
                    .build()
            )

        val assistant = assistantFuture.get()
        assistant.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val assistantServiceAsync = client.beta().assistants()

        val assistantFuture =
            assistantServiceAsync.retrieve(
                AssistantRetrieveParams.builder().assistantId("assistant_id").build()
            )

        val assistant = assistantFuture.get()
        assistant.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val assistantServiceAsync = client.beta().assistants()

        val assistantFuture =
            assistantServiceAsync.update(
                AssistantUpdateParams.builder()
                    .assistantId("assistant_id")
                    .description("description")
                    .instructions("instructions")
                    .metadata(
                        AssistantUpdateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .model(AssistantUpdateParams.Model.GPT_4_1)
                    .name("name")
                    .reasoningEffort(ReasoningEffort.LOW)
                    .responseFormatAuto()
                    .temperature(1.0)
                    .toolResources(
                        AssistantUpdateParams.ToolResources.builder()
                            .codeInterpreter(
                                AssistantUpdateParams.ToolResources.CodeInterpreter.builder()
                                    .addFileId("string")
                                    .build()
                            )
                            .fileSearch(
                                AssistantUpdateParams.ToolResources.FileSearch.builder()
                                    .addVectorStoreId("string")
                                    .build()
                            )
                            .build()
                    )
                    .addTool(CodeInterpreterTool.builder().build())
                    .topP(1.0)
                    .build()
            )

        val assistant = assistantFuture.get()
        assistant.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val assistantServiceAsync = client.beta().assistants()

        val pageFuture = assistantServiceAsync.list()

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val assistantServiceAsync = client.beta().assistants()

        val assistantDeletedFuture =
            assistantServiceAsync.delete(
                AssistantDeleteParams.builder().assistantId("assistant_id").build()
            )

        val assistantDeleted = assistantDeletedFuture.get()
        assistantDeleted.validate()
    }
}
