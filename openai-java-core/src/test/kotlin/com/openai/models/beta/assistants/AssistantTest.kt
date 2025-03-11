// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.assistants

import com.openai.core.JsonValue
import com.openai.models.Metadata
import com.openai.models.beta.threads.AssistantResponseFormatOption
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
                .metadata(
                    Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .model("model")
                .name("name")
                .addTool(CodeInterpreterTool.builder().build())
                .responseFormatJsonValue()
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
        assertThat(assistant.metadata())
            .contains(
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
            )
        assertThat(assistant.model()).isEqualTo("model")
        assertThat(assistant.name()).contains("name")
        assertThat(assistant.tools())
            .containsExactly(AssistantTool.ofCodeInterpreter(CodeInterpreterTool.builder().build()))
        assertThat(assistant.responseFormat()).contains(AssistantResponseFormatOption.ofJsonValue())
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
