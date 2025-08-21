// File generated from our OpenAPI spec by Stainless.

package com.openai.models.conversations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileCitationBodyTest {

    @Test
    fun create() {
        val fileCitationBody =
            FileCitationBody.builder().fileId("file_id").filename("filename").index(0L).build()

        assertThat(fileCitationBody.fileId()).isEqualTo("file_id")
        assertThat(fileCitationBody.filename()).isEqualTo("filename")
        assertThat(fileCitationBody.index()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileCitationBody =
            FileCitationBody.builder().fileId("file_id").filename("filename").index(0L).build()

        val roundtrippedFileCitationBody =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileCitationBody),
                jacksonTypeRef<FileCitationBody>(),
            )

        assertThat(roundtrippedFileCitationBody).isEqualTo(fileCitationBody)
    }
}
