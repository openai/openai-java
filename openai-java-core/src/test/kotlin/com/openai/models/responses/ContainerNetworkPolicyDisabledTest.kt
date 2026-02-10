// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContainerNetworkPolicyDisabledTest {

    @Test
    fun create() {
        val containerNetworkPolicyDisabled = ContainerNetworkPolicyDisabled.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val containerNetworkPolicyDisabled = ContainerNetworkPolicyDisabled.builder().build()

        val roundtrippedContainerNetworkPolicyDisabled =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(containerNetworkPolicyDisabled),
                jacksonTypeRef<ContainerNetworkPolicyDisabled>(),
            )

        assertThat(roundtrippedContainerNetworkPolicyDisabled)
            .isEqualTo(containerNetworkPolicyDisabled)
    }
}
