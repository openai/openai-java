// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class VectorStoreDeletedTest {

    @Test
    fun createVectorStoreDeleted() {
        val vectorStoreDeleted = VectorStoreDeleted.builder().id("id").deleted(true).build()
        assertThat(vectorStoreDeleted).isNotNull
        assertThat(vectorStoreDeleted.id()).isEqualTo("id")
        assertThat(vectorStoreDeleted.deleted()).isEqualTo(true)
    }
}
