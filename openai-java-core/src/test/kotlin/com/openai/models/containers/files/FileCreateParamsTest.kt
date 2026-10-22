package com.openai.models.containers.files

import com.openai.core.MultipartField
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileCreateParamsTest {

    @Test
    fun create() {
        FileCreateParams.builder()
            .containerId("container_id")
            .file("Example data".byteInputStream())
            .fileId("file_id")
            .build()
    }

    @Test
    fun getBody() {
        val params =
            FileCreateParams.builder()
                .containerId("container_id")
                .file("Example data".byteInputStream())
                .fileId("file_id")
                .build()

        val body = params._body()

        assertThat(body.filterValues { !it.value.isNull() })
            .usingRecursiveComparison()
            .withEqualsForType(
                { a, b -> a.readBytes() contentEquals b.readBytes() },
                InputStream::class.java,
            )
            .isEqualTo(
                mapOf(
                    "file" to
                        MultipartField.builder<InputStream>()
                            .value("Example data".byteInputStream())
                            .filename("file.bin")
                            .build(),
                    "file_id" to MultipartField.of("file_id"),
                )
            )
    }

    @Test
    fun fileWithInputStreamUsesDefaultFilename() {
        val params =
            FileCreateParams.builder()
                .containerId("container_id")
                .file("Example data".byteInputStream())
                .build()

        assertThat(params._file().filename()).contains("file.bin")
        assertThat(params._file().contentType).isEqualTo("application/octet-stream")
    }

    @Test
    fun fileWithBytesUsesDefaultFilename() {
        val params =
            FileCreateParams.builder()
                .containerId("container_id")
                .file("Example data".toByteArray())
                .build()

        assertThat(params._file().filename()).contains("file.bin")
        assertThat(params._file().contentType).isEqualTo("application/octet-stream")
    }

    @Test
    fun fileWithInputStreamAndFilename() {
        val params =
            FileCreateParams.builder()
                .containerId("container_id")
                .file("Example data".byteInputStream(), "container-input.txt")
                .build()

        assertThat(params._file().filename()).contains("container-input.txt")
        assertThat(params._file().contentType).isEqualTo("application/octet-stream")
    }

    @Test
    fun fileWithBytesAndFilename() {
        val params =
            FileCreateParams.builder()
                .containerId("container_id")
                .file("Example data".toByteArray(), "container-input.txt")
                .build()

        assertThat(params._file().filename()).contains("container-input.txt")
        assertThat(params._file().contentType).isEqualTo("application/octet-stream")
    }
}
