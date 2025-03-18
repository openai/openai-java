// File generated from our OpenAPI spec by Stainless.

package com.openai.models.files

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileDeletedTest {

    @Test
    fun create() {
        val fileDeleted = FileDeleted.builder().id("id").deleted(true).build()

        assertThat(fileDeleted.id()).isEqualTo("id")
        assertThat(fileDeleted.deleted()).isEqualTo(true)
    }
}
