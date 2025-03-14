// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads

import com.openai.core.JsonValue
import com.openai.models.Metadata
import com.openai.models.beta.assistants.CodeInterpreterTool
import com.openai.models.beta.vectorstores.AutoFileChunkingStrategyParam
import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ThreadCreateParamsTest {

    @Test
    fun create() {
        ThreadCreateParams.builder()
            .addMessage(
                ThreadCreateParams.Message.builder()
                    .content("string")
                    .role(ThreadCreateParams.Message.Role.USER)
                    .addAttachment(
                        ThreadCreateParams.Message.Attachment.builder()
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
                ThreadCreateParams.ToolResources.builder()
                    .codeInterpreter(
                        ThreadCreateParams.ToolResources.CodeInterpreter.builder()
                            .addFileId("string")
                            .build()
                    )
                    .fileSearch(
                        ThreadCreateParams.ToolResources.FileSearch.builder()
                            .addVectorStoreId("string")
                            .addVectorStore(
                                ThreadCreateParams.ToolResources.FileSearch.VectorStore.builder()
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
            ThreadCreateParams.builder()
                .addMessage(
                    ThreadCreateParams.Message.builder()
                        .content("string")
                        .role(ThreadCreateParams.Message.Role.USER)
                        .addAttachment(
                            ThreadCreateParams.Message.Attachment.builder()
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
                    ThreadCreateParams.ToolResources.builder()
                        .codeInterpreter(
                            ThreadCreateParams.ToolResources.CodeInterpreter.builder()
                                .addFileId("string")
                                .build()
                        )
                        .fileSearch(
                            ThreadCreateParams.ToolResources.FileSearch.builder()
                                .addVectorStoreId("string")
                                .addVectorStore(
                                    ThreadCreateParams.ToolResources.FileSearch.VectorStore
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
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.messages())
            .contains(
                listOf(
                    ThreadCreateParams.Message.builder()
                        .content("string")
                        .role(ThreadCreateParams.Message.Role.USER)
                        .addAttachment(
                            ThreadCreateParams.Message.Attachment.builder()
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
                ThreadCreateParams.ToolResources.builder()
                    .codeInterpreter(
                        ThreadCreateParams.ToolResources.CodeInterpreter.builder()
                            .addFileId("string")
                            .build()
                    )
                    .fileSearch(
                        ThreadCreateParams.ToolResources.FileSearch.builder()
                            .addVectorStoreId("string")
                            .addVectorStore(
                                ThreadCreateParams.ToolResources.FileSearch.VectorStore.builder()
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
        val params = ThreadCreateParams.builder().build()

        val body = params._body()

        assertNotNull(body)
    }
}
