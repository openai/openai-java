// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BetaVectorStoreCreateParamsTest {

    @Test
    fun createBetaVectorStoreCreateParams() {
        BetaVectorStoreCreateParams.builder()
            .chunkingStrategy(AutoFileChunkingStrategyParam.builder().build())
            .expiresAfter(BetaVectorStoreCreateParams.ExpiresAfter.builder().days(1L).build())
            .addFileId("string")
            .metadata(JsonValue.from(mapOf<String, Any>()))
            .name("name")
            .build()
    }

    @Test
    fun getBody() {
        val params =
            BetaVectorStoreCreateParams.builder()
                .chunkingStrategy(AutoFileChunkingStrategyParam.builder().build())
                .expiresAfter(BetaVectorStoreCreateParams.ExpiresAfter.builder().days(1L).build())
                .addFileId("string")
                .metadata(JsonValue.from(mapOf<String, Any>()))
                .name("name")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.chunkingStrategy())
            .contains(
                FileChunkingStrategyParam.ofAuto(AutoFileChunkingStrategyParam.builder().build())
            )
        assertThat(body.expiresAfter())
            .contains(BetaVectorStoreCreateParams.ExpiresAfter.builder().days(1L).build())
        assertThat(body.fileIds()).contains(listOf("string"))
        assertThat(body._metadata()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(body.name()).contains("name")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params = BetaVectorStoreCreateParams.builder().build()
        val body = params.getBody()
        assertThat(body).isNotNull
    }
}
