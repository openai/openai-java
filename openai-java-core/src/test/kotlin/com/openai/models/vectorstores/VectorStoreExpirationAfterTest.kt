// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VectorStoreExpirationAfterTest {

    @Test
    fun create() {
        val vectorStoreExpirationAfter = VectorStoreExpirationAfter.builder().days(1L).build()

        assertThat(vectorStoreExpirationAfter.days()).isEqualTo(1L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val vectorStoreExpirationAfter = VectorStoreExpirationAfter.builder().days(1L).build()

        val roundtrippedVectorStoreExpirationAfter =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(vectorStoreExpirationAfter),
                jacksonTypeRef<VectorStoreExpirationAfter>(),
            )

        assertThat(roundtrippedVectorStoreExpirationAfter).isEqualTo(vectorStoreExpirationAfter)
    }
}
