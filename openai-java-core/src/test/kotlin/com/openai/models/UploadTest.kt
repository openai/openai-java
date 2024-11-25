// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UploadTest {

    @Test
    fun createUpload() {
        val upload =
            Upload.builder()
                .id("id")
                .bytes(0L)
                .createdAt(0L)
                .expiresAt(0L)
                .filename("filename")
                .object_(Upload.Object.UPLOAD)
                .purpose("purpose")
                .status(Upload.Status.PENDING)
                .file(
                    FileObject.builder()
                        .id("id")
                        .bytes(0L)
                        .createdAt(0L)
                        .filename("filename")
                        .object_(FileObject.Object.FILE)
                        .purpose(FileObject.Purpose.ASSISTANTS)
                        .status(FileObject.Status.UPLOADED)
                        .statusDetails("status_details")
                        .build()
                )
                .build()
        assertThat(upload).isNotNull
        assertThat(upload.id()).isEqualTo("id")
        assertThat(upload.bytes()).isEqualTo(0L)
        assertThat(upload.createdAt()).isEqualTo(0L)
        assertThat(upload.expiresAt()).isEqualTo(0L)
        assertThat(upload.filename()).isEqualTo("filename")
        assertThat(upload.object_()).isEqualTo(Upload.Object.UPLOAD)
        assertThat(upload.purpose()).isEqualTo("purpose")
        assertThat(upload.status()).isEqualTo(Upload.Status.PENDING)
        assertThat(upload.file())
            .contains(
                FileObject.builder()
                    .id("id")
                    .bytes(0L)
                    .createdAt(0L)
                    .filename("filename")
                    .object_(FileObject.Object.FILE)
                    .purpose(FileObject.Purpose.ASSISTANTS)
                    .status(FileObject.Status.UPLOADED)
                    .statusDetails("status_details")
                    .build()
            )
    }
}
