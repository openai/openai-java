// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.files

import com.openai.core.MultipartField
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class FileCreateParamsTest {

    @Test
    fun create() {
        FileCreateParams.builder()
            .file("Example data".byteInputStream())
            .purpose(FilePurpose.BATCH)
            .expiresAfter(FileCreateParams.ExpiresAfter.builder().seconds(3600L).build())
            .build()
    }

    @Test
    fun body() {
        val params =
            FileCreateParams.builder()
                .file("Example data".byteInputStream())
                .purpose(FilePurpose.BATCH)
                .expiresAfter(FileCreateParams.ExpiresAfter.builder().seconds(3600L).build())
                .build()

        val body = params._body()

        assertThat(body.filterValues { !it.value.isNull() })
            .usingRecursiveComparison()
            // TODO(AssertJ): Replace this and the `mapValues` below with:
            // https://github.com/assertj/assertj/issues/3165
            .withEqualsForType(
                { a, b -> a.readBytes() contentEquals b.readBytes() },
                InputStream::class.java,
            )
            .isEqualTo(
                mapOf(
                        "file" to
                            MultipartField.builder<InputStream>()
                                .value("Example data".byteInputStream())
                                .filename("batch_data.jsonl")
                                .build(),
                        "purpose" to MultipartField.of(FilePurpose.BATCH),
                        "expires_after" to
                            MultipartField.of(
                                FileCreateParams.ExpiresAfter.builder().seconds(3600L).build()
                            ),
                    )
                    .mapValues { (_, field) ->
                        field.map { (it as? ByteArray)?.inputStream() ?: it }
                    }
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            FileCreateParams.builder()
                .file("Example data".byteInputStream())
                .purpose(FilePurpose.BATCH)
                .build()

        val body = params._body()

        assertThat(body.filterValues { !it.value.isNull() })
            .usingRecursiveComparison()
            // TODO(AssertJ): Replace this and the `mapValues` below with:
            // https://github.com/assertj/assertj/issues/3165
            .withEqualsForType(
                { a, b -> a.readBytes() contentEquals b.readBytes() },
                InputStream::class.java,
            )
            .isEqualTo(
                mapOf(
                        "file" to
                            MultipartField.builder<InputStream>()
                                .value("Example data".byteInputStream())
                                .filename("batch_data.jsonl")
                                .build(),
                        "purpose" to MultipartField.of(FilePurpose.BATCH),
                    )
                    .mapValues { (_, field) ->
                        field.map { (it as? ByteArray)?.inputStream() ?: it }
                    }
            )
    }

    @Test
    fun fileWithInputStreamUsesDefaultBatchFilename() {
        val params =
            FileCreateParams.builder()
                .file("Example data".byteInputStream())
                .purpose(FilePurpose.BATCH)
                .build()

        assertThat(params._file().filename()).contains("batch_data.jsonl")
        assertThat(params._file().contentType).isEqualTo("application/octet-stream")
    }

    @Test
    fun fileWithInputStreamUsesDefaultFineTuneFilename() {
        val params =
            FileCreateParams.builder()
                .file("Example data".byteInputStream())
                .purpose(FilePurpose.FINE_TUNE)
                .build()

        assertThat(params._file().filename()).contains("training_data.jsonl")
        assertThat(params._file().contentType).isEqualTo("application/octet-stream")
    }

    @Test
    fun fileWithBytesUsesDefaultBatchFilename() {
        val params =
            FileCreateParams.builder()
                .file("Example data".toByteArray())
                .purpose(FilePurpose.BATCH)
                .build()

        assertThat(params._file().filename()).contains("batch_data.jsonl")
        assertThat(params._file().contentType).isEqualTo("application/octet-stream")
    }

    @Test
    fun fileWithInputStreamWithoutFilename_forAssistants_throwsIllegalArgument() {
        assertThrows<IllegalArgumentException> {
            FileCreateParams.builder()
                .file("Example data".byteInputStream())
                .purpose(FilePurpose.ASSISTANTS)
                .build()
        }
    }

    @Test
    fun fileWithInputStreamAndFilename() {
        val params =
            FileCreateParams.builder()
                .file("Example data".byteInputStream(), "input.jsonl")
                .purpose(FilePurpose.BATCH)
                .build()

        assertThat(params._file().filename()).contains("input.jsonl")
        assertThat(params._file().contentType).isEqualTo("application/octet-stream")
    }

    @Test
    fun fileWithBytesAndFilename() {
        val params =
            FileCreateParams.builder()
                .file("Example data".toByteArray(), "custom.pdf")
                .purpose(FilePurpose.ASSISTANTS)
                .build()

        assertThat(params._file().filename()).contains("custom.pdf")
        assertThat(params._file().contentType).isEqualTo("application/octet-stream")
    }
}
