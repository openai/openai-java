// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.containers

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContainerDeleteResponseTest {

    @Test
    fun createAndRoundtrip() {
        val containerDeleteResponse =
            ContainerDeleteResponse.builder()
                .id("id")
                .deleted(true)
                .object_(ContainerDeleteResponse.Object.CONTAINER_DELETED)
                .build()

        assertThat(containerDeleteResponse.id()).contains("id")
        assertThat(containerDeleteResponse.deleted()).contains(true)
        assertThat(containerDeleteResponse.object_())
            .contains(ContainerDeleteResponse.Object.CONTAINER_DELETED)

        val jsonMapper = jsonMapper()

        val roundtrippedContainerDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(containerDeleteResponse),
                jacksonTypeRef<ContainerDeleteResponse>(),
            )

        assertThat(roundtrippedContainerDeleteResponse).isEqualTo(containerDeleteResponse)
    }
}
