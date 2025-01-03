// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class VectorStoreDeletedTest {

    @Test
    fun createVectorStoreDeleted() {
        val vectorStoreDeleted =
            VectorStoreDeleted.builder()
                .id("id")
                .deleted(true)
                .object_(VectorStoreDeleted.Object.VECTOR_STORE_DELETED)
                .build()
        assertThat(vectorStoreDeleted).isNotNull
        assertThat(vectorStoreDeleted.id()).isEqualTo("id")
        assertThat(vectorStoreDeleted.deleted()).isEqualTo(true)
        assertThat(vectorStoreDeleted.object_())
            .isEqualTo(VectorStoreDeleted.Object.VECTOR_STORE_DELETED)
    }
}
