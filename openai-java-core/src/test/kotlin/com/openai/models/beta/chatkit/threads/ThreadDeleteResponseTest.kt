// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit.threads

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ThreadDeleteResponseTest {

    @Test
    fun create() {
        val threadDeleteResponse = ThreadDeleteResponse.builder().id("id").deleted(true).build()

        assertThat(threadDeleteResponse.id()).isEqualTo("id")
        assertThat(threadDeleteResponse.deleted()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val threadDeleteResponse = ThreadDeleteResponse.builder().id("id").deleted(true).build()

        val roundtrippedThreadDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(threadDeleteResponse),
                jacksonTypeRef<ThreadDeleteResponse>(),
            )

        assertThat(roundtrippedThreadDeleteResponse).isEqualTo(threadDeleteResponse)
    }
}
