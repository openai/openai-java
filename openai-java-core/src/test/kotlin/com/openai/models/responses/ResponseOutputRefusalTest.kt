// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseOutputRefusalTest {

    @Test
    fun create() {
        val responseOutputRefusal = ResponseOutputRefusal.builder().refusal("refusal").build()

        assertThat(responseOutputRefusal.refusal()).isEqualTo("refusal")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseOutputRefusal = ResponseOutputRefusal.builder().refusal("refusal").build()

        val roundtrippedResponseOutputRefusal =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseOutputRefusal),
                jacksonTypeRef<ResponseOutputRefusal>(),
            )

        assertThat(roundtrippedResponseOutputRefusal).isEqualTo(responseOutputRefusal)
    }
}
