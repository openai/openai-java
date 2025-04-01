// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VectorStoreFileDeletedTest {

    @Test
    fun create() {
        val vectorStoreFileDeleted = VectorStoreFileDeleted.builder().id("id").deleted(true).build()

        assertThat(vectorStoreFileDeleted.id()).isEqualTo("id")
        assertThat(vectorStoreFileDeleted.deleted()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val vectorStoreFileDeleted = VectorStoreFileDeleted.builder().id("id").deleted(true).build()

        val roundtrippedVectorStoreFileDeleted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(vectorStoreFileDeleted),
                jacksonTypeRef<VectorStoreFileDeleted>(),
            )

        assertThat(roundtrippedVectorStoreFileDeleted).isEqualTo(vectorStoreFileDeleted)
    }
}
