// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseLocalEnvironmentTest {

    @Test
    fun create() {
        val responseLocalEnvironment = ResponseLocalEnvironment.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseLocalEnvironment = ResponseLocalEnvironment.builder().build()

        val roundtrippedResponseLocalEnvironment =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseLocalEnvironment),
                jacksonTypeRef<ResponseLocalEnvironment>(),
            )

        assertThat(roundtrippedResponseLocalEnvironment).isEqualTo(responseLocalEnvironment)
    }
}
