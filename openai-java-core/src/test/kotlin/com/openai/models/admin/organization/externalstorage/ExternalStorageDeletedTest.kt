// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.externalstorage

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExternalStorageDeletedTest {

    @Test
    fun create() {
        val externalStorageDeleted = ExternalStorageDeleted.builder().id("id").deleted(true).build()

        assertThat(externalStorageDeleted.id()).isEqualTo("id")
        assertThat(externalStorageDeleted.deleted()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val externalStorageDeleted = ExternalStorageDeleted.builder().id("id").deleted(true).build()

        val roundtrippedExternalStorageDeleted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(externalStorageDeleted),
                jacksonTypeRef<ExternalStorageDeleted>(),
            )

        assertThat(roundtrippedExternalStorageDeleted).isEqualTo(externalStorageDeleted)
    }
}
