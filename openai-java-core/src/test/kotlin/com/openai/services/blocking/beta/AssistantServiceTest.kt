// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
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
internal class AssistantServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val assistantService = client.beta().assistants()

        val assistant =
            assistantService.create(
                AssistantCreateParams.builder()
                    .model(ChatModel.O3_MINI)
                    .description("description")
                    .instructions("instructions")
                    .metadata(
                        AssistantCreateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .name("name")
                    .reasoningEffort(ReasoningEffort.LOW)
                    .responseFormatJsonValue()
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

        assistant.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val assistantService = client.beta().assistants()

        val assistant =
            assistantService.retrieve(
                AssistantRetrieveParams.builder().assistantId("assistant_id").build()
            )

        assistant.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val assistantService = client.beta().assistants()

        val assistant =
            assistantService.update(
                AssistantUpdateParams.builder()
                    .assistantId("assistant_id")
                    .description("description")
                    .instructions("instructions")
                    .metadata(
                        AssistantUpdateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .model(AssistantUpdateParams.Model.O3_MINI)
                    .name("name")
                    .reasoningEffort(ReasoningEffort.LOW)
                    .responseFormatJsonValue()
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

        assistant.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val assistantService = client.beta().assistants()

        val page = assistantService.list()

        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val assistantService = client.beta().assistants()

        val assistantDeleted =
            assistantService.delete(
                AssistantDeleteParams.builder().assistantId("assistant_id").build()
            )

        assistantDeleted.validate()
    }
}
