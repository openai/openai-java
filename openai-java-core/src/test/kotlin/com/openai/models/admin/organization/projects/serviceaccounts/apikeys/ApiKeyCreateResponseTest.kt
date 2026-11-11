// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.projects.serviceaccounts.apikeys

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiKeyCreateResponseTest {

    @Test
    fun createAndRoundtrip() {
        val apiKeyCreateResponse =
            ApiKeyCreateResponse.builder()
                .id("id")
                .createdAt(0L)
                .name("name")
                .value("value")
                .expiresAt(0L)
                .build()

        assertThat(apiKeyCreateResponse.id()).contains("id")
        assertThat(apiKeyCreateResponse.createdAt()).contains(0L)
        assertThat(apiKeyCreateResponse.name()).contains("name")
        assertThat(apiKeyCreateResponse.value()).contains("value")
        assertThat(apiKeyCreateResponse.expiresAt()).contains(0L)

        val jsonMapper = jsonMapper()

        val roundtrippedApiKeyCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiKeyCreateResponse),
                jacksonTypeRef<ApiKeyCreateResponse>(),
            )

        assertThat(roundtrippedApiKeyCreateResponse).isEqualTo(apiKeyCreateResponse)
    }
}
