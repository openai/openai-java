// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VectorStoreRetrieveParamsTest {

    @Test
    fun create() {
        VectorStoreRetrieveParams.builder().vectorStoreId("vector_store_id").build()
    }

    @Test
    fun pathParams() {
        val params = VectorStoreRetrieveParams.builder().vectorStoreId("vector_store_id").build()

        assertThat(params._pathParam(0)).isEqualTo("vector_store_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
