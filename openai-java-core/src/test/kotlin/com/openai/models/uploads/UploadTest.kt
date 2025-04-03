// File generated from our OpenAPI spec by Stainless.

package com.openai.models.uploads

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.files.FileObject
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UploadTest {

    @Test
    fun create() {
        val upload =
            Upload.builder()
                .id("id")
                .bytes(0L)
                .createdAt(0L)
                .expiresAt(0L)
                .filename("filename")
                .purpose("purpose")
                .status(Upload.Status.PENDING)
                .file(
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
                )
                .build()

        assertThat(upload.id()).isEqualTo("id")
        assertThat(upload.bytes()).isEqualTo(0L)
        assertThat(upload.createdAt()).isEqualTo(0L)
        assertThat(upload.expiresAt()).isEqualTo(0L)
        assertThat(upload.filename()).isEqualTo("filename")
        assertThat(upload.purpose()).isEqualTo("purpose")
        assertThat(upload.status()).isEqualTo(Upload.Status.PENDING)
        assertThat(upload.file())
            .contains(
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
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val upload =
            Upload.builder()
                .id("id")
                .bytes(0L)
                .createdAt(0L)
                .expiresAt(0L)
                .filename("filename")
                .purpose("purpose")
                .status(Upload.Status.PENDING)
                .file(
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
                )
                .build()

        val roundtrippedUpload =
            jsonMapper.readValue(jsonMapper.writeValueAsString(upload), jacksonTypeRef<Upload>())

        assertThat(roundtrippedUpload).isEqualTo(upload)
    }
}
