// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.containers

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContainerCreateResponseTest {

    @Test
    fun createAndRoundtrip() {
        val containerCreateResponse =
            ContainerCreateResponse.builder()
                .id("id")
                .createdAt(0L)
                .name("name")
                .object_("object")
                .status("status")
                .expiresAfter(
                    ContainerCreateResponse.ExpiresAfter.builder()
                        .anchor(ContainerCreateResponse.ExpiresAfter.Anchor.LAST_ACTIVE_AT)
                        .minutes(0L)
                        .build()
                )
                .lastActiveAt(0L)
                .memoryLimit(ContainerCreateResponse.MemoryLimit._1G)
                .networkPolicy(
                    ContainerCreateResponse.NetworkPolicy.builder()
                        .type(ContainerCreateResponse.NetworkPolicy.Type.ALLOWLIST)
                        .addAllowedDomain("string")
                        .build()
                )
                .build()

        assertThat(containerCreateResponse.id()).contains("id")
        assertThat(containerCreateResponse.createdAt()).contains(0L)
        assertThat(containerCreateResponse.name()).contains("name")
        assertThat(containerCreateResponse.object_()).contains("object")
        assertThat(containerCreateResponse.status()).contains("status")
        assertThat(containerCreateResponse.expiresAfter())
            .contains(
                ContainerCreateResponse.ExpiresAfter.builder()
                    .anchor(ContainerCreateResponse.ExpiresAfter.Anchor.LAST_ACTIVE_AT)
                    .minutes(0L)
                    .build()
            )
        assertThat(containerCreateResponse.lastActiveAt()).contains(0L)
        assertThat(containerCreateResponse.memoryLimit())
            .contains(ContainerCreateResponse.MemoryLimit._1G)
        assertThat(containerCreateResponse.networkPolicy())
            .contains(
                ContainerCreateResponse.NetworkPolicy.builder()
                    .type(ContainerCreateResponse.NetworkPolicy.Type.ALLOWLIST)
                    .addAllowedDomain("string")
                    .build()
            )

        val jsonMapper = jsonMapper()

        val roundtrippedContainerCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(containerCreateResponse),
                jacksonTypeRef<ContainerCreateResponse>(),
            )

        assertThat(roundtrippedContainerCreateResponse).isEqualTo(containerCreateResponse)
    }
}
