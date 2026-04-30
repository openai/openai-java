// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.serviceaccounts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ServiceAccountCreateResponseTest {

    @Test
    fun create() {
        val serviceAccountCreateResponse =
            ServiceAccountCreateResponse.builder()
                .id("id")
                .apiKey(
                    ServiceAccountCreateResponse.ApiKey.builder()
                        .id("id")
                        .createdAt(0L)
                        .name("name")
                        .value("value")
                        .build()
                )
                .createdAt(0L)
                .name("name")
                .build()

        assertThat(serviceAccountCreateResponse.id()).isEqualTo("id")
        assertThat(serviceAccountCreateResponse.apiKey())
            .isEqualTo(
                ServiceAccountCreateResponse.ApiKey.builder()
                    .id("id")
                    .createdAt(0L)
                    .name("name")
                    .value("value")
                    .build()
            )
        assertThat(serviceAccountCreateResponse.createdAt()).isEqualTo(0L)
        assertThat(serviceAccountCreateResponse.name()).isEqualTo("name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val serviceAccountCreateResponse =
            ServiceAccountCreateResponse.builder()
                .id("id")
                .apiKey(
                    ServiceAccountCreateResponse.ApiKey.builder()
                        .id("id")
                        .createdAt(0L)
                        .name("name")
                        .value("value")
                        .build()
                )
                .createdAt(0L)
                .name("name")
                .build()

        val roundtrippedServiceAccountCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(serviceAccountCreateResponse),
                jacksonTypeRef<ServiceAccountCreateResponse>(),
            )

        assertThat(roundtrippedServiceAccountCreateResponse).isEqualTo(serviceAccountCreateResponse)
    }
}
