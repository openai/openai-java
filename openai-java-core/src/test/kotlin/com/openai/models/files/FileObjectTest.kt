// File generated from our OpenAPI spec by Stainless.

package com.openai.models.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileObjectTest {

    @Test
    fun create() {
        val fileObject =
            FileObject.builder()
                .id("id")
                .bytes(0L)
                .createdAt(0L)
                .filename("filename")
                .purpose(FileObject.Purpose.ASSISTANTS)
                .status(FileObject.Status.UPLOADED)
                .expiresAt(0L)
                .statusDetails("status_details")
                .build()

        assertThat(fileObject.id()).isEqualTo("id")
        assertThat(fileObject.bytes()).isEqualTo(0L)
        assertThat(fileObject.createdAt()).isEqualTo(0L)
        assertThat(fileObject.filename()).isEqualTo("filename")
        assertThat(fileObject.purpose()).isEqualTo(FileObject.Purpose.ASSISTANTS)
        assertThat(fileObject.status()).isEqualTo(FileObject.Status.UPLOADED)
        assertThat(fileObject.expiresAt()).contains(0L)
        assertThat(fileObject.statusDetails()).contains("status_details")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileObject =
            FileObject.builder()
                .id("id")
                .bytes(0L)
                .createdAt(0L)
                .filename("filename")
                .purpose(FileObject.Purpose.ASSISTANTS)
                .status(FileObject.Status.UPLOADED)
                .expiresAt(0L)
                .statusDetails("status_details")
                .build()

        val roundtrippedFileObject =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileObject),
                jacksonTypeRef<FileObject>(),
            )

        assertThat(roundtrippedFileObject).isEqualTo(fileObject)
    }
}
