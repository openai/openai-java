// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class VectorStoreFileDeletedTest {

    @Test
    fun createVectorStoreFileDeleted() {
        val vectorStoreFileDeleted =
            VectorStoreFileDeleted.builder()
                .id("id")
                .deleted(true)
                .object_(VectorStoreFileDeleted.Object.VECTOR_STORE_FILE_DELETED)
                .build()
        assertThat(vectorStoreFileDeleted).isNotNull
        assertThat(vectorStoreFileDeleted.id()).isEqualTo("id")
        assertThat(vectorStoreFileDeleted.deleted()).isEqualTo(true)
        assertThat(vectorStoreFileDeleted.object_())
            .isEqualTo(VectorStoreFileDeleted.Object.VECTOR_STORE_FILE_DELETED)
    }
}
