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
            .expiresAfter(BetaVectorStoreUpdateParams.ExpiresAfter.builder().days(1L).build())
            .metadata(JsonValue.from(mapOf<String, Any>()))
            .name("name")
            .build()
    }

    @Test
    fun body() {
        val params =
            BetaVectorStoreUpdateParams.builder()
                .vectorStoreId("vector_store_id")
                .expiresAfter(BetaVectorStoreUpdateParams.ExpiresAfter.builder().days(1L).build())
                .metadata(JsonValue.from(mapOf<String, Any>()))
                .name("name")
                .build()
        val body = params._body()
        assertThat(body).isNotNull
        assertThat(body.expiresAfter())
            .contains(BetaVectorStoreUpdateParams.ExpiresAfter.builder().days(1L).build())
        assertThat(body._metadata()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(body.name()).contains("name")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = BetaVectorStoreUpdateParams.builder().vectorStoreId("vector_store_id").build()
        val body = params._body()
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
