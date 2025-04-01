// File generated from our OpenAPI spec by Stainless.

package com.openai.models.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileDeletedTest {

    @Test
    fun create() {
        val fileDeleted = FileDeleted.builder().id("id").deleted(true).build()

        assertThat(fileDeleted.id()).isEqualTo("id")
        assertThat(fileDeleted.deleted()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileDeleted = FileDeleted.builder().id("id").deleted(true).build()

        val roundtrippedFileDeleted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileDeleted),
                jacksonTypeRef<FileDeleted>(),
            )

        assertThat(roundtrippedFileDeleted).isEqualTo(fileDeleted)
    }
}
