// File generated from our OpenAPI spec by Stainless.

package com.openai.models.videos

import com.openai.core.MultipartField
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VideoEditParamsTest {

    @Test
    fun create() {
        VideoEditParams.builder().prompt("x").video("Example data".byteInputStream()).build()
    }

    @Test
    fun body() {
        val params =
            VideoEditParams.builder().prompt("x").video("Example data".byteInputStream()).build()

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
                        "prompt" to MultipartField.of("x"),
                        "video" to
                            MultipartField.builder<VideoEditParams.Video>()
                                .value(
                                    VideoEditParams.Video.ofInputStream(
                                        "Example data".byteInputStream()
                                    )
                                )
                                .contentType("application/octet-stream")
                                .build(),
                    )
                    .mapValues { (_, field) ->
                        field.map { (it as? ByteArray)?.inputStream() ?: it }
                    }
            )
    }
}
