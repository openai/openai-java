// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BetaAssistantUpdateParamsTest {

    @Test
    fun createBetaAssistantUpdateParams() {
        BetaAssistantUpdateParams.builder()
            .assistantId("assistant_id")
            .description("description")
            .instructions("instructions")
            .metadata(JsonValue.from(mapOf<String, Any>()))
            .model("model")
            .name("name")
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
    }

    @Test
    fun getBody() {
        val params =
            BetaAssistantUpdateParams.builder()
                .assistantId("assistant_id")
                .description("description")
                .instructions("instructions")
                .metadata(JsonValue.from(mapOf<String, Any>()))
                .model("model")
                .name("name")
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
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.description()).contains("description")
        assertThat(body.instructions()).contains("instructions")
        assertThat(body._metadata()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(body.model()).contains("model")
        assertThat(body.name()).contains("name")
        assertThat(body.responseFormat()).contains(AssistantResponseFormatOption.ofAuto())
        assertThat(body.temperature()).contains(1.0)
        assertThat(body.toolResources())
            .contains(
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
        assertThat(body.tools())
            .contains(
                listOf(AssistantTool.ofCodeInterpreter(CodeInterpreterTool.builder().build()))
            )
        assertThat(body.topP()).contains(1.0)
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params = BetaAssistantUpdateParams.builder().assistantId("assistant_id").build()
        val body = params.getBody()
        assertThat(body).isNotNull
    }

    @Test
    fun getPathParam() {
        val params = BetaAssistantUpdateParams.builder().assistantId("assistant_id").build()
        assertThat(params).isNotNull
        // path param "assistantId"
        assertThat(params.getPathParam(0)).isEqualTo("assistant_id")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
