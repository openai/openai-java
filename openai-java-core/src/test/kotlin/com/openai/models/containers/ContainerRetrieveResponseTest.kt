// File generated from our OpenAPI spec by Stainless.

package com.openai.models.containers

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContainerRetrieveResponseTest {

    @Test
    fun create() {
        val containerRetrieveResponse =
            ContainerRetrieveResponse.builder()
                .id("id")
                .createdAt(0L)
                .name("name")
                .object_("object")
                .status("status")
                .expiresAfter(
                    ContainerRetrieveResponse.ExpiresAfter.builder()
                        .anchor(ContainerRetrieveResponse.ExpiresAfter.Anchor.LAST_ACTIVE_AT)
                        .minutes(0L)
                        .build()
                )
                .lastActiveAt(0L)
                .memoryLimit(ContainerRetrieveResponse.MemoryLimit._1G)
                .build()

        assertThat(containerRetrieveResponse.id()).isEqualTo("id")
        assertThat(containerRetrieveResponse.createdAt()).isEqualTo(0L)
        assertThat(containerRetrieveResponse.name()).isEqualTo("name")
        assertThat(containerRetrieveResponse.object_()).isEqualTo("object")
        assertThat(containerRetrieveResponse.status()).isEqualTo("status")
        assertThat(containerRetrieveResponse.expiresAfter())
            .contains(
                ContainerRetrieveResponse.ExpiresAfter.builder()
                    .anchor(ContainerRetrieveResponse.ExpiresAfter.Anchor.LAST_ACTIVE_AT)
                    .minutes(0L)
                    .build()
            )
        assertThat(containerRetrieveResponse.lastActiveAt()).contains(0L)
        assertThat(containerRetrieveResponse.memoryLimit())
            .contains(ContainerRetrieveResponse.MemoryLimit._1G)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val containerRetrieveResponse =
            ContainerRetrieveResponse.builder()
                .id("id")
                .createdAt(0L)
                .name("name")
                .object_("object")
                .status("status")
                .expiresAfter(
                    ContainerRetrieveResponse.ExpiresAfter.builder()
                        .anchor(ContainerRetrieveResponse.ExpiresAfter.Anchor.LAST_ACTIVE_AT)
                        .minutes(0L)
                        .build()
                )
                .lastActiveAt(0L)
                .memoryLimit(ContainerRetrieveResponse.MemoryLimit._1G)
                .build()

        val roundtrippedContainerRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(containerRetrieveResponse),
                jacksonTypeRef<ContainerRetrieveResponse>(),
            )

        assertThat(roundtrippedContainerRetrieveResponse).isEqualTo(containerRetrieveResponse)
    }
}
