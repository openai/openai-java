// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.AutoFileChunkingStrategyParam
import com.openai.models.BetaAssistantCreateParams
import com.openai.models.BetaAssistantDeleteParams
import com.openai.models.BetaAssistantRetrieveParams
import com.openai.models.BetaAssistantUpdateParams
import com.openai.models.ChatModel
import com.openai.models.CodeInterpreterTool
import com.openai.models.Metadata
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class AssistantServiceTest {

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
                BetaAssistantCreateParams.builder()
                    .model(ChatModel.O3_MINI)
                    .description("description")
                    .instructions("instructions")
                    .metadata(
                        Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .name("name")
                    .reasoningEffort(BetaAssistantCreateParams.ReasoningEffort.LOW)
                    .responseFormatAuto()
                    .temperature(1.0)
                    .toolResources(
                        BetaAssistantCreateParams.ToolResources.builder()
                            .codeInterpreter(
                                BetaAssistantCreateParams.ToolResources.CodeInterpreter.builder()
                                    .addFileId("string")
                                    .build()
                            )
                            .fileSearch(
                                BetaAssistantCreateParams.ToolResources.FileSearch.builder()
                                    .addVectorStoreId("string")
                                    .addVectorStore(
                                        BetaAssistantCreateParams.ToolResources.FileSearch
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
                BetaAssistantRetrieveParams.builder().assistantId("assistant_id").build()
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
                BetaAssistantUpdateParams.builder()
                    .assistantId("assistant_id")
                    .description("description")
                    .instructions("instructions")
                    .metadata(
                        Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .model(BetaAssistantUpdateParams.Model.O3_MINI)
                    .name("name")
                    .reasoningEffort(BetaAssistantUpdateParams.ReasoningEffort.LOW)
                    .responseFormatAuto()
                    .temperature(1.0)
                    .toolResources(
                        BetaAssistantUpdateParams.ToolResources.builder()
                            .codeInterpreter(
                                BetaAssistantUpdateParams.ToolResources.CodeInterpreter.builder()
                                    .addFileId("string")
                                    .build()
                            )
                            .fileSearch(
                                BetaAssistantUpdateParams.ToolResources.FileSearch.builder()
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
                BetaAssistantDeleteParams.builder().assistantId("assistant_id").build()
            )

        assistantDeleted.validate()
    }
}
