// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.MultipartField
import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FileCreateParamsTest {

    @Test
    fun create() {
        FileCreateParams.builder()
            .file("some content".toByteArray())
            .purpose(FilePurpose.ASSISTANTS)
            .build()
    }

    @Test
    fun body() {
        val params =
            FileCreateParams.builder()
                .file("some content".toByteArray())
                .purpose(FilePurpose.ASSISTANTS)
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.filterValues { !it.value.isNull() })
            .isEqualTo(
                mapOf(
                    "file" to MultipartField.of("some content".toByteArray()),
                    "purpose" to MultipartField.of(FilePurpose.ASSISTANTS),
                )
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            FileCreateParams.builder()
                .file("some content".toByteArray())
                .purpose(FilePurpose.ASSISTANTS)
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.filterValues { !it.value.isNull() })
            .isEqualTo(
                mapOf(
                    "file" to MultipartField.of("some content".toByteArray()),
                    "purpose" to MultipartField.of(FilePurpose.ASSISTANTS),
                )
            )
    }
}
