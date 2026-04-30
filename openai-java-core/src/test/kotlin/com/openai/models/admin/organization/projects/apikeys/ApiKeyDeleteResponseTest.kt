// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.apikeys

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiKeyDeleteResponseTest {

    @Test
    fun create() {
        val apiKeyDeleteResponse = ApiKeyDeleteResponse.builder().id("id").deleted(true).build()

        assertThat(apiKeyDeleteResponse.id()).isEqualTo("id")
        assertThat(apiKeyDeleteResponse.deleted()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiKeyDeleteResponse = ApiKeyDeleteResponse.builder().id("id").deleted(true).build()

        val roundtrippedApiKeyDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiKeyDeleteResponse),
                jacksonTypeRef<ApiKeyDeleteResponse>(),
            )

        assertThat(roundtrippedApiKeyDeleteResponse).isEqualTo(apiKeyDeleteResponse)
    }
}
