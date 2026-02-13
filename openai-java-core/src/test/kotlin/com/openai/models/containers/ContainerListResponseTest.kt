// File generated from our OpenAPI spec by Stainless.

package com.openai.models.containers

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContainerListResponseTest {

    @Test
    fun create() {
        val containerListResponse =
            ContainerListResponse.builder()
                .id("id")
                .createdAt(0L)
                .name("name")
                .object_("object")
                .status("status")
                .expiresAfter(
                    ContainerListResponse.ExpiresAfter.builder()
                        .anchor(ContainerListResponse.ExpiresAfter.Anchor.LAST_ACTIVE_AT)
                        .minutes(0L)
                        .build()
                )
                .lastActiveAt(0L)
                .memoryLimit(ContainerListResponse.MemoryLimit._1G)
                .networkPolicy(
                    ContainerListResponse.NetworkPolicy.builder()
                        .type(ContainerListResponse.NetworkPolicy.Type.ALLOWLIST)
                        .addAllowedDomain("string")
                        .build()
                )
                .build()

        assertThat(containerListResponse.id()).isEqualTo("id")
        assertThat(containerListResponse.createdAt()).isEqualTo(0L)
        assertThat(containerListResponse.name()).isEqualTo("name")
        assertThat(containerListResponse.object_()).isEqualTo("object")
        assertThat(containerListResponse.status()).isEqualTo("status")
        assertThat(containerListResponse.expiresAfter())
            .contains(
                ContainerListResponse.ExpiresAfter.builder()
                    .anchor(ContainerListResponse.ExpiresAfter.Anchor.LAST_ACTIVE_AT)
                    .minutes(0L)
                    .build()
            )
        assertThat(containerListResponse.lastActiveAt()).contains(0L)
        assertThat(containerListResponse.memoryLimit())
            .contains(ContainerListResponse.MemoryLimit._1G)
        assertThat(containerListResponse.networkPolicy())
            .contains(
                ContainerListResponse.NetworkPolicy.builder()
                    .type(ContainerListResponse.NetworkPolicy.Type.ALLOWLIST)
                    .addAllowedDomain("string")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val containerListResponse =
            ContainerListResponse.builder()
                .id("id")
                .createdAt(0L)
                .name("name")
                .object_("object")
                .status("status")
                .expiresAfter(
                    ContainerListResponse.ExpiresAfter.builder()
                        .anchor(ContainerListResponse.ExpiresAfter.Anchor.LAST_ACTIVE_AT)
                        .minutes(0L)
                        .build()
                )
                .lastActiveAt(0L)
                .memoryLimit(ContainerListResponse.MemoryLimit._1G)
                .networkPolicy(
                    ContainerListResponse.NetworkPolicy.builder()
                        .type(ContainerListResponse.NetworkPolicy.Type.ALLOWLIST)
                        .addAllowedDomain("string")
                        .build()
                )
                .build()

        val roundtrippedContainerListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(containerListResponse),
                jacksonTypeRef<ContainerListResponse>(),
            )

        assertThat(roundtrippedContainerListResponse).isEqualTo(containerListResponse)
    }
}
