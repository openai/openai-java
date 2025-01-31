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
            .metadata(
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
            )
            .name("name")
            .build()
    }

    @Test
    fun body() {
        val params =
            BetaVectorStoreCreateParams.builder()
                .chunkingStrategy(AutoFileChunkingStrategyParam.builder().build())
                .expiresAfter(BetaVectorStoreCreateParams.ExpiresAfter.builder().days(1L).build())
                .addFileId("string")
                .metadata(
                    Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .name("name")
                .build()
        val body = params._body()
        assertThat(body).isNotNull
        assertThat(body.chunkingStrategy())
            .contains(
                FileChunkingStrategyParam.ofAuto(AutoFileChunkingStrategyParam.builder().build())
            )
        assertThat(body.expiresAfter())
            .contains(BetaVectorStoreCreateParams.ExpiresAfter.builder().days(1L).build())
        assertThat(body.fileIds()).contains(listOf("string"))
        assertThat(body.metadata())
            .contains(
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
            )
        assertThat(body.name()).contains("name")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = BetaVectorStoreCreateParams.builder().build()
        val body = params._body()
        assertThat(body).isNotNull
    }
}
