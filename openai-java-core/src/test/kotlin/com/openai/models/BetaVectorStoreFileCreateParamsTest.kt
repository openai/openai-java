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
            .chunkingStrategy(AutoFileChunkingStrategyParam.builder().build())
            .build()
    }

    @Test
    fun body() {
        val params =
            BetaVectorStoreFileCreateParams.builder()
                .vectorStoreId("vs_abc123")
                .fileId("file_id")
                .chunkingStrategy(AutoFileChunkingStrategyParam.builder().build())
                .build()
        val body = params._body()
        assertThat(body).isNotNull
        assertThat(body.fileId()).isEqualTo("file_id")
        assertThat(body.chunkingStrategy())
            .contains(
                FileChunkingStrategyParam.ofAuto(AutoFileChunkingStrategyParam.builder().build())
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            BetaVectorStoreFileCreateParams.builder()
                .vectorStoreId("vs_abc123")
                .fileId("file_id")
                .build()
        val body = params._body()
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
