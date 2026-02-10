// File generated from our OpenAPI spec by Stainless.

package com.openai.models.skills.versions

import com.openai.core.MultipartField
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VersionCreateParamsTest {

    @Test
    fun create() {
        VersionCreateParams.builder()
            .skillId("skill_123")
            .default_(true)
            .filesOfInputStreams(listOf("some content".byteInputStream()))
            .build()
    }

    @Test
    fun pathParams() {
        val params = VersionCreateParams.builder().skillId("skill_123").build()

        assertThat(params._pathParam(0)).isEqualTo("skill_123")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            VersionCreateParams.builder()
                .skillId("skill_123")
                .default_(true)
                .filesOfInputStreams(listOf("some content".byteInputStream()))
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
                        "default" to MultipartField.of(true),
                        "files" to
                            MultipartField.builder<VersionCreateParams.Files>()
                                .value(
                                    VersionCreateParams.Files.ofInputStreams(
                                        listOf("some content".byteInputStream())
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

    @Test
    fun bodyWithoutOptionalFields() {
        val params = VersionCreateParams.builder().skillId("skill_123").build()

        val body = params._body()

        assertThat(body.filterValues { !it.value.isNull() }).isEmpty()
    }
}
