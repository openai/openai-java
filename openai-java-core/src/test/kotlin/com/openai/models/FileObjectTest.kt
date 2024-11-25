// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FileObjectTest {

    @Test
    fun createFileObject() {
        val fileObject =
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
        assertThat(fileObject).isNotNull
        assertThat(fileObject.id()).isEqualTo("id")
        assertThat(fileObject.bytes()).isEqualTo(0L)
        assertThat(fileObject.createdAt()).isEqualTo(0L)
        assertThat(fileObject.filename()).isEqualTo("filename")
        assertThat(fileObject.object_()).isEqualTo(FileObject.Object.FILE)
        assertThat(fileObject.purpose()).isEqualTo(FileObject.Purpose.ASSISTANTS)
        assertThat(fileObject.status()).isEqualTo(FileObject.Status.UPLOADED)
        assertThat(fileObject.statusDetails()).contains("status_details")
    }
}
