// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BetaThreadUpdateParamsTest {

    @Test
    fun createBetaThreadUpdateParams() {
        BetaThreadUpdateParams.builder()
            .threadId("thread_id")
            .metadata(JsonValue.from(mapOf<String, Any>()))
            .toolResources(
                BetaThreadUpdateParams.ToolResources.builder()
                    .codeInterpreter(
                        BetaThreadUpdateParams.ToolResources.CodeInterpreter.builder()
                            .addFileId("string")
                            .build()
                    )
                    .fileSearch(
                        BetaThreadUpdateParams.ToolResources.FileSearch.builder()
                            .addVectorStoreId("string")
                            .build()
                    )
                    .build()
            )
            .build()
    }

    @Test
    fun getBody() {
        val params =
            BetaThreadUpdateParams.builder()
                .threadId("thread_id")
                .metadata(JsonValue.from(mapOf<String, Any>()))
                .toolResources(
                    BetaThreadUpdateParams.ToolResources.builder()
                        .codeInterpreter(
                            BetaThreadUpdateParams.ToolResources.CodeInterpreter.builder()
                                .addFileId("string")
                                .build()
                        )
                        .fileSearch(
                            BetaThreadUpdateParams.ToolResources.FileSearch.builder()
                                .addVectorStoreId("string")
                                .build()
                        )
                        .build()
                )
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body._metadata()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(body.toolResources())
            .contains(
                BetaThreadUpdateParams.ToolResources.builder()
                    .codeInterpreter(
                        BetaThreadUpdateParams.ToolResources.CodeInterpreter.builder()
                            .addFileId("string")
                            .build()
                    )
                    .fileSearch(
                        BetaThreadUpdateParams.ToolResources.FileSearch.builder()
                            .addVectorStoreId("string")
                            .build()
                    )
                    .build()
            )
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params = BetaThreadUpdateParams.builder().threadId("thread_id").build()
        val body = params.getBody()
        assertThat(body).isNotNull
    }

    @Test
    fun getPathParam() {
        val params = BetaThreadUpdateParams.builder().threadId("thread_id").build()
        assertThat(params).isNotNull
        // path param "threadId"
        assertThat(params.getPathParam(0)).isEqualTo("thread_id")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
