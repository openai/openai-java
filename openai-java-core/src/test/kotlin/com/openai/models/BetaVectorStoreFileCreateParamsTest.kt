// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BetaVectorStoreFileCreateParamsTest {

    @Test
    fun createBetaVectorStoreFileCreateParams() {
        BetaVectorStoreFileCreateParams.builder()
            .vectorStoreId("vs_abc123")
            .fileId("file_id")
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
            BetaVectorStoreFileCreateParams.builder()
                .vectorStoreId("vs_abc123")
                .fileId("file_id")
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
        assertThat(body.fileId()).isEqualTo("file_id")
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
            BetaVectorStoreFileCreateParams.builder()
                .vectorStoreId("vs_abc123")
                .fileId("file_id")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.fileId()).isEqualTo("file_id")
    }

    @Test
    fun getPathParam() {
        val params =
            BetaVectorStoreFileCreateParams.builder()
                .vectorStoreId("vs_abc123")
                .fileId("file_id")
                .build()
        assertThat(params).isNotNull
        // path param "vectorStoreId"
        assertThat(params.getPathParam(0)).isEqualTo("vs_abc123")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
