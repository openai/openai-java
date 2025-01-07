// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BetaVectorStoreUpdateParamsTest {

    @Test
    fun createBetaVectorStoreUpdateParams() {
        BetaVectorStoreUpdateParams.builder()
            .vectorStoreId("vector_store_id")
            .expiresAfter(
                BetaVectorStoreUpdateParams.ExpiresAfter.builder()
                    .anchor(BetaVectorStoreUpdateParams.ExpiresAfter.Anchor.LAST_ACTIVE_AT)
                    .days(1L)
                    .build()
            )
            .metadata(JsonValue.from(mapOf<String, Any>()))
            .name("name")
            .build()
    }

    @Test
    fun getBody() {
        val params =
            BetaVectorStoreUpdateParams.builder()
                .vectorStoreId("vector_store_id")
                .expiresAfter(
                    BetaVectorStoreUpdateParams.ExpiresAfter.builder()
                        .anchor(BetaVectorStoreUpdateParams.ExpiresAfter.Anchor.LAST_ACTIVE_AT)
                        .days(1L)
                        .build()
                )
                .metadata(JsonValue.from(mapOf<String, Any>()))
                .name("name")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.expiresAfter())
            .contains(
                BetaVectorStoreUpdateParams.ExpiresAfter.builder()
                    .anchor(BetaVectorStoreUpdateParams.ExpiresAfter.Anchor.LAST_ACTIVE_AT)
                    .days(1L)
                    .build()
            )
        assertThat(body._metadata()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(body.name()).contains("name")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params = BetaVectorStoreUpdateParams.builder().vectorStoreId("vector_store_id").build()
        val body = params.getBody()
        assertThat(body).isNotNull
    }

    @Test
    fun getPathParam() {
        val params = BetaVectorStoreUpdateParams.builder().vectorStoreId("vector_store_id").build()
        assertThat(params).isNotNull
        // path param "vectorStoreId"
        assertThat(params.getPathParam(0)).isEqualTo("vector_store_id")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
