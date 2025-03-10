// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.assistants

import com.openai.core.JsonValue
import com.openai.models.Metadata
import com.openai.models.beta.threads.AssistantResponseFormatOption
import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AssistantUpdateParamsTest {

    @Test
    fun create() {
        AssistantUpdateParams.builder()
            .assistantId("assistant_id")
            .description("description")
            .instructions("instructions")
            .metadata(
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
            )
            .model(AssistantUpdateParams.Model.O3_MINI)
            .name("name")
            .reasoningEffort(AssistantUpdateParams.ReasoningEffort.LOW)
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
    }

    @Test
    fun body() {
        val params =
            AssistantUpdateParams.builder()
                .assistantId("assistant_id")
                .description("description")
                .instructions("instructions")
                .metadata(
                    Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .model(AssistantUpdateParams.Model.O3_MINI)
                .name("name")
                .reasoningEffort(AssistantUpdateParams.ReasoningEffort.LOW)
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

        val body = params._body()

        assertNotNull(body)
        assertThat(body.description()).contains("description")
        assertThat(body.instructions()).contains("instructions")
        assertThat(body.metadata())
            .contains(
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
            )
        assertThat(body.model()).contains(AssistantUpdateParams.Model.O3_MINI)
        assertThat(body.name()).contains("name")
        assertThat(body.reasoningEffort()).contains(AssistantUpdateParams.ReasoningEffort.LOW)
        assertThat(body.responseFormat()).contains(AssistantResponseFormatOption.ofAuto())
        assertThat(body.temperature()).contains(1.0)
        assertThat(body.toolResources())
            .contains(
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
        assertThat(body.tools())
            .contains(
                listOf(AssistantTool.ofCodeInterpreter(CodeInterpreterTool.builder().build()))
            )
        assertThat(body.topP()).contains(1.0)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = AssistantUpdateParams.builder().assistantId("assistant_id").build()

        val body = params._body()

        assertNotNull(body)
    }

    @Test
    fun getPathParam() {
        val params = AssistantUpdateParams.builder().assistantId("assistant_id").build()
        assertThat(params).isNotNull
        // path param "assistantId"
        assertThat(params.getPathParam(0)).isEqualTo("assistant_id")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
