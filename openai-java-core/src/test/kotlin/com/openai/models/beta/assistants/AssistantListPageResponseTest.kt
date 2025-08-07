// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.assistants

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AssistantListPageResponseTest {

    @Test
    fun create() {
        val assistantListPageResponse =
            AssistantListPageResponse.builder()
                .addData(
                    Assistant.builder()
                        .id("id")
                        .createdAt(0L)
                        .description("description")
                        .instructions("instructions")
                        .metadata(
                            Assistant.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .model("model")
                        .name("name")
                        .addTool(CodeInterpreterTool.builder().build())
                        .responseFormatAuto()
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
                )
                .firstId("asst_abc123")
                .hasMore(false)
                .lastId("asst_abc456")
                .object_("list")
                .build()

        assertThat(assistantListPageResponse.data())
            .containsExactly(
                Assistant.builder()
                    .id("id")
                    .createdAt(0L)
                    .description("description")
                    .instructions("instructions")
                    .metadata(
                        Assistant.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .model("model")
                    .name("name")
                    .addTool(CodeInterpreterTool.builder().build())
                    .responseFormatAuto()
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
            )
        assertThat(assistantListPageResponse.firstId()).isEqualTo("asst_abc123")
        assertThat(assistantListPageResponse.hasMore()).isEqualTo(false)
        assertThat(assistantListPageResponse.lastId()).isEqualTo("asst_abc456")
        assertThat(assistantListPageResponse.object_()).isEqualTo("list")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val assistantListPageResponse =
            AssistantListPageResponse.builder()
                .addData(
                    Assistant.builder()
                        .id("id")
                        .createdAt(0L)
                        .description("description")
                        .instructions("instructions")
                        .metadata(
                            Assistant.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .model("model")
                        .name("name")
                        .addTool(CodeInterpreterTool.builder().build())
                        .responseFormatAuto()
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
                )
                .firstId("asst_abc123")
                .hasMore(false)
                .lastId("asst_abc456")
                .object_("list")
                .build()

        val roundtrippedAssistantListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantListPageResponse),
                jacksonTypeRef<AssistantListPageResponse>(),
            )

        assertThat(roundtrippedAssistantListPageResponse).isEqualTo(assistantListPageResponse)
    }
}
