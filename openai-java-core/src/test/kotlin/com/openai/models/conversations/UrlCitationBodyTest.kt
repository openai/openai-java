// File generated from our OpenAPI spec by Stainless.

package com.openai.models.conversations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UrlCitationBodyTest {

    @Test
    fun create() {
        val urlCitationBody =
            UrlCitationBody.builder().endIndex(0L).startIndex(0L).title("title").url("url").build()

        assertThat(urlCitationBody.endIndex()).isEqualTo(0L)
        assertThat(urlCitationBody.startIndex()).isEqualTo(0L)
        assertThat(urlCitationBody.title()).isEqualTo("title")
        assertThat(urlCitationBody.url()).isEqualTo("url")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val urlCitationBody =
            UrlCitationBody.builder().endIndex(0L).startIndex(0L).title("title").url("url").build()

        val roundtrippedUrlCitationBody =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(urlCitationBody),
                jacksonTypeRef<UrlCitationBody>(),
            )

        assertThat(roundtrippedUrlCitationBody).isEqualTo(urlCitationBody)
    }
}
