// File generated from our OpenAPI spec by Stainless.

package com.openai.models.skills

import com.openai.core.MultipartField
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SkillCreateParamsTest {

    @Test
    fun create() {
        SkillCreateParams.builder()
            .filesOfInputStreams(listOf("Example data".byteInputStream()))
            .build()
    }

    @Test
    fun body() {
        val params =
            SkillCreateParams.builder()
                .filesOfInputStreams(listOf("Example data".byteInputStream()))
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
                        "files" to
                            MultipartField.builder<SkillCreateParams.Files>()
                                .value(
                                    SkillCreateParams.Files.ofInputStreams(
                                        listOf("Example data".byteInputStream())
                                    )
                                )
                                .contentType("application/octet-stream")
                                .build()
                    )
                    .mapValues { (_, field) ->
                        field.map { (it as? ByteArray)?.inputStream() ?: it }
                    }
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = SkillCreateParams.builder().build()

        val body = params._body()

        assertThat(body.filterValues { !it.value.isNull() }).isEmpty()
    }
}
