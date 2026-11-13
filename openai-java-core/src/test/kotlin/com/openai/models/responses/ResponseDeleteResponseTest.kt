// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseDeleteResponseTest {

    @Test
    fun createAndRoundtrip() {
        val responseDeleteResponse = ResponseDeleteResponse.builder().id("id").deleted(true).build()

        assertThat(responseDeleteResponse.id()).contains("id")
        assertThat(responseDeleteResponse.deleted()).contains(true)

        val jsonMapper = jsonMapper()

        val roundtrippedResponseDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseDeleteResponse),
                jacksonTypeRef<ResponseDeleteResponse>(),
            )

        assertThat(roundtrippedResponseDeleteResponse).isEqualTo(responseDeleteResponse)
    }
}
