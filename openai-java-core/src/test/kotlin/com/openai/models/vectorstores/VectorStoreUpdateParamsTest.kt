// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

import com.openai.core.JsonValue
import com.openai.models.Metadata
import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VectorStoreUpdateParamsTest {

    @Test
    fun create() {
        VectorStoreUpdateParams.builder()
            .vectorStoreId("vector_store_id")
            .expiresAfter(VectorStoreUpdateParams.ExpiresAfter.builder().days(1L).build())
            .metadata(
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
            )
            .name("name")
            .build()
    }

    @Test
    fun pathParams() {
        val params = VectorStoreUpdateParams.builder().vectorStoreId("vector_store_id").build()

        assertThat(params._pathParam(0)).isEqualTo("vector_store_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            VectorStoreUpdateParams.builder()
                .vectorStoreId("vector_store_id")
                .expiresAfter(VectorStoreUpdateParams.ExpiresAfter.builder().days(1L).build())
                .metadata(
                    Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .name("name")
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.expiresAfter())
            .contains(VectorStoreUpdateParams.ExpiresAfter.builder().days(1L).build())
        assertThat(body.metadata())
            .contains(
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
            )
        assertThat(body.name()).contains("name")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = VectorStoreUpdateParams.builder().vectorStoreId("vector_store_id").build()

        val body = params._body()

        assertNotNull(body)
    }
}
