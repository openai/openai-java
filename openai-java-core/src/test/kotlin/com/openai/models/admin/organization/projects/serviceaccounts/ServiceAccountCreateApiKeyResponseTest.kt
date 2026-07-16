// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.serviceaccounts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ServiceAccountCreateApiKeyResponseTest {

    @Test
    fun create() {
        val serviceAccountCreateApiKeyResponse =
            ServiceAccountCreateApiKeyResponse.builder()
                .id("id")
                .createdAt(0L)
                .name("name")
                .value("value")
                .build()

        assertThat(serviceAccountCreateApiKeyResponse.id()).isEqualTo("id")
        assertThat(serviceAccountCreateApiKeyResponse.createdAt()).isEqualTo(0L)
        assertThat(serviceAccountCreateApiKeyResponse.name()).isEqualTo("name")
        assertThat(serviceAccountCreateApiKeyResponse.value()).isEqualTo("value")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val serviceAccountCreateApiKeyResponse =
            ServiceAccountCreateApiKeyResponse.builder()
                .id("id")
                .createdAt(0L)
                .name("name")
                .value("value")
                .build()

        val roundtrippedServiceAccountCreateApiKeyResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(serviceAccountCreateApiKeyResponse),
                jacksonTypeRef<ServiceAccountCreateApiKeyResponse>(),
            )

        assertThat(roundtrippedServiceAccountCreateApiKeyResponse)
            .isEqualTo(serviceAccountCreateApiKeyResponse)
    }
}
