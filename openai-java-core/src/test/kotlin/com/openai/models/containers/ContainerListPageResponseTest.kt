// File generated from our OpenAPI spec by Stainless.

package com.openai.models.containers

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContainerListPageResponseTest {

    @Test
    fun create() {
        val containerListPageResponse =
            ContainerListPageResponse.builder()
                .addData(
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
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(containerListPageResponse.data())
            .containsExactly(
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
                    .build()
            )
        assertThat(containerListPageResponse.firstId()).isEqualTo("first_id")
        assertThat(containerListPageResponse.hasMore()).isEqualTo(true)
        assertThat(containerListPageResponse.lastId()).isEqualTo("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val containerListPageResponse =
            ContainerListPageResponse.builder()
                .addData(
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
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        val roundtrippedContainerListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(containerListPageResponse),
                jacksonTypeRef<ContainerListPageResponse>(),
            )

        assertThat(roundtrippedContainerListPageResponse).isEqualTo(containerListPageResponse)
    }
}
