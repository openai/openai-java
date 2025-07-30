// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ThreadUpdateParamsTest {

    @Test
    fun create() {
        ThreadUpdateParams.builder()
            .threadId("thread_id")
            .metadata(
                ThreadUpdateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
            .toolResources(
                ThreadUpdateParams.ToolResources.builder()
                    .codeInterpreter(
                        ThreadUpdateParams.ToolResources.CodeInterpreter.builder()
                            .addFileId("string")
                            .build()
                    )
                    .fileSearch(
                        ThreadUpdateParams.ToolResources.FileSearch.builder()
                            .addVectorStoreId("string")
                            .build()
                    )
                    .build()
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params = ThreadUpdateParams.builder().threadId("thread_id").build()

        assertThat(params._pathParam(0)).isEqualTo("thread_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            ThreadUpdateParams.builder()
                .threadId("thread_id")
                .metadata(
                    ThreadUpdateParams.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .toolResources(
                    ThreadUpdateParams.ToolResources.builder()
                        .codeInterpreter(
                            ThreadUpdateParams.ToolResources.CodeInterpreter.builder()
                                .addFileId("string")
                                .build()
                        )
                        .fileSearch(
                            ThreadUpdateParams.ToolResources.FileSearch.builder()
                                .addVectorStoreId("string")
                                .build()
                        )
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.metadata())
            .contains(
                ThreadUpdateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(body.toolResources())
            .contains(
                ThreadUpdateParams.ToolResources.builder()
                    .codeInterpreter(
                        ThreadUpdateParams.ToolResources.CodeInterpreter.builder()
                            .addFileId("string")
                            .build()
                    )
                    .fileSearch(
                        ThreadUpdateParams.ToolResources.FileSearch.builder()
                            .addVectorStoreId("string")
                            .build()
                    )
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ThreadUpdateParams.builder().threadId("thread_id").build()

        val body = params._body()
    }
}
