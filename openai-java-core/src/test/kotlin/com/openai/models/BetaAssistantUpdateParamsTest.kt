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
            .responseFormat(
                AssistantResponseFormatOption.ofBehavior(
                    AssistantResponseFormatOption.Behavior.AUTO
                )
            )
            .temperature(1.0)
            .toolResources(
                BetaAssistantUpdateParams.ToolResources.builder()
                    .codeInterpreter(
                        BetaAssistantUpdateParams.ToolResources.CodeInterpreter.builder()
                            .fileIds(listOf("string"))
                            .build()
                    )
                    .fileSearch(
                        BetaAssistantUpdateParams.ToolResources.FileSearch.builder()
                            .vectorStoreIds(listOf("string"))
                            .build()
                    )
                    .build()
            )
            .tools(
                listOf(
                    AssistantTool.ofCodeInterpreterTool(
                        CodeInterpreterTool.builder()
                            .type(CodeInterpreterTool.Type.CODE_INTERPRETER)
                            .build()
                    )
                )
            )
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
                .responseFormat(
                    AssistantResponseFormatOption.ofBehavior(
                        AssistantResponseFormatOption.Behavior.AUTO
                    )
                )
                .temperature(1.0)
                .toolResources(
                    BetaAssistantUpdateParams.ToolResources.builder()
                        .codeInterpreter(
                            BetaAssistantUpdateParams.ToolResources.CodeInterpreter.builder()
                                .fileIds(listOf("string"))
                                .build()
                        )
                        .fileSearch(
                            BetaAssistantUpdateParams.ToolResources.FileSearch.builder()
                                .vectorStoreIds(listOf("string"))
                                .build()
                        )
                        .build()
                )
                .tools(
                    listOf(
                        AssistantTool.ofCodeInterpreterTool(
                            CodeInterpreterTool.builder()
                                .type(CodeInterpreterTool.Type.CODE_INTERPRETER)
                                .build()
                        )
                    )
                )
                .topP(1.0)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.description()).contains("description")
        assertThat(body.instructions()).contains("instructions")
        assertThat(body.metadata()).contains(JsonValue.from(mapOf<String, Any>()))
        assertThat(body.model()).contains("model")
        assertThat(body.name()).contains("name")
        assertThat(body.responseFormat())
            .contains(
                AssistantResponseFormatOption.ofBehavior(
                    AssistantResponseFormatOption.Behavior.AUTO
                )
            )
        assertThat(body.temperature()).contains(1.0)
        assertThat(body.toolResources())
            .contains(
                BetaAssistantUpdateParams.ToolResources.builder()
                    .codeInterpreter(
                        BetaAssistantUpdateParams.ToolResources.CodeInterpreter.builder()
                            .fileIds(listOf("string"))
                            .build()
                    )
                    .fileSearch(
                        BetaAssistantUpdateParams.ToolResources.FileSearch.builder()
                            .vectorStoreIds(listOf("string"))
                            .build()
                    )
                    .build()
            )
        assertThat(body.tools())
            .contains(
                listOf(
                    AssistantTool.ofCodeInterpreterTool(
                        CodeInterpreterTool.builder()
                            .type(CodeInterpreterTool.Type.CODE_INTERPRETER)
                            .build()
                    )
                )
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
