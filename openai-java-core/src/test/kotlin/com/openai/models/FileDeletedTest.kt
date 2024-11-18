// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FileDeletedTest {

    @Test
    fun createFileDeleted() {
        val fileDeleted =
            FileDeleted.builder().id("id").deleted(true).object_(FileDeleted.Object.FILE).build()
        assertThat(fileDeleted).isNotNull
        assertThat(fileDeleted.id()).isEqualTo("id")
        assertThat(fileDeleted.deleted()).isEqualTo(true)
        assertThat(fileDeleted.object_()).isEqualTo(FileDeleted.Object.FILE)
    }
}