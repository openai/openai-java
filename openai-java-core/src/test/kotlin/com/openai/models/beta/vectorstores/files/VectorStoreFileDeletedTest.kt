// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.vectorstores.files

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class VectorStoreFileDeletedTest {

    @Test
    fun createVectorStoreFileDeleted() {
        val vectorStoreFileDeleted = VectorStoreFileDeleted.builder().id("id").deleted(true).build()
        assertThat(vectorStoreFileDeleted).isNotNull
        assertThat(vectorStoreFileDeleted.id()).isEqualTo("id")
        assertThat(vectorStoreFileDeleted.deleted()).isEqualTo(true)
    }
}
