// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores.files

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VectorStoreFileDeletedTest {

    @Test
    fun create() {
        val vectorStoreFileDeleted = VectorStoreFileDeleted.builder().id("id").deleted(true).build()

        assertThat(vectorStoreFileDeleted.id()).isEqualTo("id")
        assertThat(vectorStoreFileDeleted.deleted()).isEqualTo(true)
    }
}
