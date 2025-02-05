// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BetaVectorStoreFileBatchRetrieveParamsTest {

    @Test
    fun create() {
        BetaVectorStoreFileBatchRetrieveParams.builder()
            .vectorStoreId("vs_abc123")
            .batchId("vsfb_abc123")
            .build()
    }

    @Test
    fun getPathParam() {
        val params =
            BetaVectorStoreFileBatchRetrieveParams.builder()
                .vectorStoreId("vs_abc123")
                .batchId("vsfb_abc123")
                .build()
        assertThat(params).isNotNull
        // path param "vectorStoreId"
        assertThat(params.getPathParam(0)).isEqualTo("vs_abc123")
        // path param "batchId"
        assertThat(params.getPathParam(1)).isEqualTo("vsfb_abc123")
        // out-of-bound path param
        assertThat(params.getPathParam(2)).isEqualTo("")
    }
}
