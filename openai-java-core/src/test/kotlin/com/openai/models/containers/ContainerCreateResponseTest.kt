// File generated from our OpenAPI spec by Stainless.

package com.openai.models.containers

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContainerCreateResponseTest {

    @Test
    fun create() {
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
                .build()

        assertThat(containerCreateResponse.id()).isEqualTo("id")
        assertThat(containerCreateResponse.createdAt()).isEqualTo(0L)
        assertThat(containerCreateResponse.name()).isEqualTo("name")
        assertThat(containerCreateResponse.object_()).isEqualTo("object")
        assertThat(containerCreateResponse.status()).isEqualTo("status")
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
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
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
                .build()

        val roundtrippedContainerCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(containerCreateResponse),
                jacksonTypeRef<ContainerCreateResponse>(),
            )

        assertThat(roundtrippedContainerCreateResponse).isEqualTo(containerCreateResponse)
    }
}
