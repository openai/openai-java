// File generated from our OpenAPI spec by Stainless.

package com.openai.models.videos

import com.openai.core.MultipartField
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VideoCreateParamsTest {

    @Test
    fun create() {
        VideoCreateParams.builder()
            .prompt("x")
            .addCharacterId("char_123")
            .inputReference("some content".byteInputStream())
            .model(VideoModel.of("string"))
            .seconds(VideoSeconds._4)
            .size(VideoSize._720X1280)
            .build()
    }

    @Test
    fun body() {
        val params =
            VideoCreateParams.builder()
                .prompt("x")
                .addCharacterId("char_123")
                .inputReference("some content".byteInputStream())
                .model(VideoModel.of("string"))
                .seconds(VideoSeconds._4)
                .size(VideoSize._720X1280)
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
                        "prompt" to MultipartField.of("x"),
                        "character_ids" to MultipartField.of(listOf("char_123")),
                        "input_reference" to MultipartField.of("some content".byteInputStream()),
                        "model" to MultipartField.of(VideoModel.of("string")),
                        "seconds" to MultipartField.of(VideoSeconds._4),
                        "size" to MultipartField.of(VideoSize._720X1280),
                    )
                    .mapValues { (_, field) ->
                        field.map { (it as? ByteArray)?.inputStream() ?: it }
                    }
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = VideoCreateParams.builder().prompt("x").build()

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
                mapOf("prompt" to MultipartField.of("x")).mapValues { (_, field) ->
                    field.map { (it as? ByteArray)?.inputStream() ?: it }
                }
            )
    }
}
