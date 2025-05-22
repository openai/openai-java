// File generated from our OpenAPI spec by Stainless.

package com.openai.models.containers

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContainerCreateParamsTest {

    @Test
    fun create() {
        ContainerCreateParams.builder()
            .name("name")
            .expiresAfter(
                ContainerCreateParams.ExpiresAfter.builder()
                    .anchor(ContainerCreateParams.ExpiresAfter.Anchor.LAST_ACTIVE_AT)
                    .minutes(0L)
                    .build()
            )
            .addFileId("string")
            .build()
    }

    @Test
    fun body() {
        val params =
            ContainerCreateParams.builder()
                .name("name")
                .expiresAfter(
                    ContainerCreateParams.ExpiresAfter.builder()
                        .anchor(ContainerCreateParams.ExpiresAfter.Anchor.LAST_ACTIVE_AT)
                        .minutes(0L)
                        .build()
                )
                .addFileId("string")
                .build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("name")
        assertThat(body.expiresAfter())
            .contains(
                ContainerCreateParams.ExpiresAfter.builder()
                    .anchor(ContainerCreateParams.ExpiresAfter.Anchor.LAST_ACTIVE_AT)
                    .minutes(0L)
                    .build()
            )
        assertThat(body.fileIds().getOrNull()).containsExactly("string")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ContainerCreateParams.builder().name("name").build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("name")
    }
}
