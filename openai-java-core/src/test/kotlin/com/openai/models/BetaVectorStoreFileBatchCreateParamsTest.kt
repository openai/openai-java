// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BetaVectorStoreFileBatchCreateParamsTest {

    @Test
    fun createBetaVectorStoreFileBatchCreateParams() {
        BetaVectorStoreFileBatchCreateParams.builder()
            .vectorStoreId("vs_abc123")
            .fileIds(listOf("string"))
            .chunkingStrategy(
                FileChunkingStrategyParam.ofAutoFileChunkingStrategyParam(
                    AutoFileChunkingStrategyParam.builder()
                        .type(AutoFileChunkingStrategyParam.Type.AUTO)
                        .build()
                )
            )
            .build()
    }

    @Test
    fun getBody() {
        val params =
            BetaVectorStoreFileBatchCreateParams.builder()
                .vectorStoreId("vs_abc123")
                .fileIds(listOf("string"))
                .chunkingStrategy(
                    FileChunkingStrategyParam.ofAutoFileChunkingStrategyParam(
                        AutoFileChunkingStrategyParam.builder()
                            .type(AutoFileChunkingStrategyParam.Type.AUTO)
                            .build()
                    )
                )
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.fileIds()).isEqualTo(listOf("string"))
        assertThat(body.chunkingStrategy())
            .contains(
                FileChunkingStrategyParam.ofAutoFileChunkingStrategyParam(
                    AutoFileChunkingStrategyParam.builder()
                        .type(AutoFileChunkingStrategyParam.Type.AUTO)
                        .build()
                )
            )
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            BetaVectorStoreFileBatchCreateParams.builder()
                .vectorStoreId("vs_abc123")
                .fileIds(listOf("string"))
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.fileIds()).isEqualTo(listOf("string"))
    }

    @Test
    fun getPathParam() {
        val params =
            BetaVectorStoreFileBatchCreateParams.builder()
                .vectorStoreId("vs_abc123")
                .fileIds(listOf("string"))
                .build()
        assertThat(params).isNotNull
        // path param "vectorStoreId"
        assertThat(params.getPathParam(0)).isEqualTo("vs_abc123")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
