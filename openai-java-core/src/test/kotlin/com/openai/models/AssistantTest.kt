// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AssistantTest {

    @Test
    fun createAssistant() {
        val assistant =
            Assistant.builder()
                .id("id")
                .createdAt(0L)
                .description("description")
                .instructions("instructions")
                .metadata(JsonValue.from(mapOf<String, Any>()))
                .model("model")
                .name("name")
                .object_(Assistant.Object.ASSISTANT)
                .addTool(
                    CodeInterpreterTool.builder()
                        .type(CodeInterpreterTool.Type.CODE_INTERPRETER)
                        .build()
                )
                .responseFormat(AssistantResponseFormatOption.Behavior.AUTO)
                .temperature(1.0)
                .toolResources(
                    Assistant.ToolResources.builder()
                        .codeInterpreter(
                            Assistant.ToolResources.CodeInterpreter.builder()
                                .addFileId("string")
                                .build()
                        )
                        .fileSearch(
                            Assistant.ToolResources.FileSearch.builder()
                                .addVectorStoreId("string")
                                .build()
                        )
                        .build()
                )
                .topP(1.0)
                .build()
        assertThat(assistant).isNotNull
        assertThat(assistant.id()).isEqualTo("id")
        assertThat(assistant.createdAt()).isEqualTo(0L)
        assertThat(assistant.description()).contains("description")
        assertThat(assistant.instructions()).contains("instructions")
        assertThat(assistant._metadata()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(assistant.model()).isEqualTo("model")
        assertThat(assistant.name()).contains("name")
        assertThat(assistant.object_()).isEqualTo(Assistant.Object.ASSISTANT)
        assertThat(assistant.tools())
            .containsExactly(
                AssistantTool.ofCodeInterpreterTool(
                    CodeInterpreterTool.builder()
                        .type(CodeInterpreterTool.Type.CODE_INTERPRETER)
                        .build()
                )
            )
        assertThat(assistant.responseFormat())
            .contains(
                AssistantResponseFormatOption.ofBehavior(
                    AssistantResponseFormatOption.Behavior.AUTO
                )
            )
        assertThat(assistant.temperature()).contains(1.0)
        assertThat(assistant.toolResources())
            .contains(
                Assistant.ToolResources.builder()
                    .codeInterpreter(
                        Assistant.ToolResources.CodeInterpreter.builder()
                            .addFileId("string")
                            .build()
                    )
                    .fileSearch(
                        Assistant.ToolResources.FileSearch.builder()
                            .addVectorStoreId("string")
                            .build()
                    )
                    .build()
            )
        assertThat(assistant.topP()).contains(1.0)
    }
}
