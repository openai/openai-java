// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.containers.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileDeleteResponseTest {

    @Test
    fun createAndRoundtrip() {
        val fileDeleteResponse =
            FileDeleteResponse.builder()
                .id("id")
                .deleted(true)
                .object_(FileDeleteResponse.Object.CONTAINER_FILE_DELETED)
                .build()

        assertThat(fileDeleteResponse.id()).contains("id")
        assertThat(fileDeleteResponse.deleted()).contains(true)
        assertThat(fileDeleteResponse.object_())
            .contains(FileDeleteResponse.Object.CONTAINER_FILE_DELETED)

        val jsonMapper = jsonMapper()

        val roundtrippedFileDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileDeleteResponse),
                jacksonTypeRef<FileDeleteResponse>(),
            )

        assertThat(roundtrippedFileDeleteResponse).isEqualTo(fileDeleteResponse)
    }
}
