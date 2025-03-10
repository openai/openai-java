// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.vectorstores

import com.openai.core.JsonValue
import com.openai.models.Metadata
import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class VectorStoreCreateParamsTest {

    @Test
    fun create() {
        VectorStoreCreateParams.builder()
            .chunkingStrategy(AutoFileChunkingStrategyParam.builder().build())
            .expiresAfter(VectorStoreCreateParams.ExpiresAfter.builder().days(1L).build())
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
            VectorStoreCreateParams.builder()
                .chunkingStrategy(AutoFileChunkingStrategyParam.builder().build())
                .expiresAfter(VectorStoreCreateParams.ExpiresAfter.builder().days(1L).build())
                .addFileId("string")
                .metadata(
                    Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .name("name")
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.chunkingStrategy())
            .contains(
                FileChunkingStrategyParam.ofAuto(AutoFileChunkingStrategyParam.builder().build())
            )
        assertThat(body.expiresAfter())
            .contains(VectorStoreCreateParams.ExpiresAfter.builder().days(1L).build())
        assertThat(body.fileIds()).contains(listOf("string"))
        assertThat(body.metadata())
            .contains(
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
            )
        assertThat(body.name()).contains("name")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = VectorStoreCreateParams.builder().build()

        val body = params._body()

        assertNotNull(body)
    }
}
