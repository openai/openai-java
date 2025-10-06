// File generated from our OpenAPI spec by Stainless.

package com.openai.models.videos

import com.openai.core.MultipartField
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VideoRemixParamsTest {

    @Test
    fun create() {
        VideoRemixParams.builder().videoId("video_123").prompt("x").build()
    }

    @Test
    fun pathParams() {
        val params = VideoRemixParams.builder().videoId("video_123").prompt("x").build()

        assertThat(params._pathParam(0)).isEqualTo("video_123")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params = VideoRemixParams.builder().videoId("video_123").prompt("x").build()

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
