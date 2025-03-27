// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.assistants

import com.openai.core.JsonValue
import com.openai.models.ReasoningEffort
import com.openai.models.beta.threads.AssistantResponseFormatOption
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AssistantUpdateParamsTest {

    @Test
    fun create() {
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
    }

    @Test
    fun pathParams() {
        val params = AssistantUpdateParams.builder().assistantId("assistant_id").build()

        assertThat(params._pathParam(0)).isEqualTo("assistant_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
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

        val body = params._body()

        assertThat(body.description()).contains("description")
        assertThat(body.instructions()).contains("instructions")
        assertThat(body.metadata())
            .contains(
                AssistantUpdateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(body.model()).contains(AssistantUpdateParams.Model.O3_MINI)
        assertThat(body.name()).contains("name")
        assertThat(body.reasoningEffort()).contains(ReasoningEffort.LOW)
        assertThat(body.responseFormat()).contains(AssistantResponseFormatOption.ofJsonValue())
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
        assertThat(body.tools().getOrNull())
            .containsExactly(AssistantTool.ofCodeInterpreter(CodeInterpreterTool.builder().build()))
        assertThat(body.topP()).contains(1.0)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = AssistantUpdateParams.builder().assistantId("assistant_id").build()

        val body = params._body()
    }
}
