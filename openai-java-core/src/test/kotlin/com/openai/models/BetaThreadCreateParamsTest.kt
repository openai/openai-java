// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BetaThreadCreateParamsTest {

    @Test
    fun create() {
        BetaThreadCreateParams.builder()
            .addMessage(
                BetaThreadCreateParams.Message.builder()
                    .content("string")
                    .role(BetaThreadCreateParams.Message.Role.USER)
                    .addAttachment(
                        BetaThreadCreateParams.Message.Attachment.builder()
                            .fileId("file_id")
                            .addTool(CodeInterpreterTool.builder().build())
                            .build()
                    )
                    .metadata(
                        Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .build()
            )
            .metadata(
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
            )
            .toolResources(
                BetaThreadCreateParams.ToolResources.builder()
                    .codeInterpreter(
                        BetaThreadCreateParams.ToolResources.CodeInterpreter.builder()
                            .addFileId("string")
                            .build()
                    )
                    .fileSearch(
                        BetaThreadCreateParams.ToolResources.FileSearch.builder()
                            .addVectorStoreId("string")
                            .addVectorStore(
                                BetaThreadCreateParams.ToolResources.FileSearch.VectorStore
                                    .builder()
                                    .chunkingStrategy(
                                        AutoFileChunkingStrategyParam.builder().build()
                                    )
                                    .addFileId("string")
                                    .metadata(
                                        Metadata.builder()
                                            .putAdditionalProperty("foo", JsonValue.from("string"))
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            BetaThreadCreateParams.builder()
                .addMessage(
                    BetaThreadCreateParams.Message.builder()
                        .content("string")
                        .role(BetaThreadCreateParams.Message.Role.USER)
                        .addAttachment(
                            BetaThreadCreateParams.Message.Attachment.builder()
                                .fileId("file_id")
                                .addTool(CodeInterpreterTool.builder().build())
                                .build()
                        )
                        .metadata(
                            Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .build()
                )
                .metadata(
                    Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .toolResources(
                    BetaThreadCreateParams.ToolResources.builder()
                        .codeInterpreter(
                            BetaThreadCreateParams.ToolResources.CodeInterpreter.builder()
                                .addFileId("string")
                                .build()
                        )
                        .fileSearch(
                            BetaThreadCreateParams.ToolResources.FileSearch.builder()
                                .addVectorStoreId("string")
                                .addVectorStore(
                                    BetaThreadCreateParams.ToolResources.FileSearch.VectorStore
                                        .builder()
                                        .chunkingStrategy(
                                            AutoFileChunkingStrategyParam.builder().build()
                                        )
                                        .addFileId("string")
                                        .metadata(
                                            Metadata.builder()
                                                .putAdditionalProperty(
                                                    "foo",
                                                    JsonValue.from("string")
                                                )
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .build()
        val body = params._body()
        assertThat(body).isNotNull
        assertThat(body.messages())
            .contains(
                listOf(
                    BetaThreadCreateParams.Message.builder()
                        .content("string")
                        .role(BetaThreadCreateParams.Message.Role.USER)
                        .addAttachment(
                            BetaThreadCreateParams.Message.Attachment.builder()
                                .fileId("file_id")
                                .addTool(CodeInterpreterTool.builder().build())
                                .build()
                        )
                        .metadata(
                            Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .build()
                )
            )
        assertThat(body.metadata())
            .contains(
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
            )
        assertThat(body.toolResources())
            .contains(
                BetaThreadCreateParams.ToolResources.builder()
                    .codeInterpreter(
                        BetaThreadCreateParams.ToolResources.CodeInterpreter.builder()
                            .addFileId("string")
                            .build()
                    )
                    .fileSearch(
                        BetaThreadCreateParams.ToolResources.FileSearch.builder()
                            .addVectorStoreId("string")
                            .addVectorStore(
                                BetaThreadCreateParams.ToolResources.FileSearch.VectorStore
                                    .builder()
                                    .chunkingStrategy(
                                        AutoFileChunkingStrategyParam.builder().build()
                                    )
                                    .addFileId("string")
                                    .metadata(
                                        Metadata.builder()
                                            .putAdditionalProperty("foo", JsonValue.from("string"))
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = BetaThreadCreateParams.builder().build()
        val body = params._body()
        assertThat(body).isNotNull
    }
}
