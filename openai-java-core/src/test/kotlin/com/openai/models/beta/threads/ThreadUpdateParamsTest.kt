// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads

import com.openai.core.JsonValue
import com.openai.models.Metadata
import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ThreadUpdateParamsTest {

    @Test
    fun create() {
        ThreadUpdateParams.builder()
            .threadId("thread_id")
            .metadata(
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
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
    fun body() {
        val params =
            ThreadUpdateParams.builder()
                .threadId("thread_id")
                .metadata(
                    Metadata.builder()
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

        assertNotNull(body)
        assertThat(body.metadata())
            .contains(
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
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

        assertNotNull(body)
    }

    @Test
    fun getPathParam() {
        val params = ThreadUpdateParams.builder().threadId("thread_id").build()
        assertThat(params).isNotNull
        // path param "threadId"
        assertThat(params.getPathParam(0)).isEqualTo("thread_id")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
