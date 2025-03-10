// File generated from our OpenAPI spec by Stainless.

package com.openai.models.files

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FileDeletedTest {

    @Test
    fun createFileDeleted() {
        val fileDeleted = FileDeleted.builder().id("id").deleted(true).build()
        assertThat(fileDeleted).isNotNull
        assertThat(fileDeleted.id()).isEqualTo("id")
        assertThat(fileDeleted.deleted()).isEqualTo(true)
    }
}
