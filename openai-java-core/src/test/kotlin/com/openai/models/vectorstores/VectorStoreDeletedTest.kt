// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VectorStoreDeletedTest {

    @Test
    fun create() {
        val vectorStoreDeleted = VectorStoreDeleted.builder().id("id").deleted(true).build()

        assertThat(vectorStoreDeleted.id()).isEqualTo("id")
        assertThat(vectorStoreDeleted.deleted()).isEqualTo(true)
    }
}
