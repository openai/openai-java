// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContainerNetworkPolicyDomainSecretTest {

    @Test
    fun create() {
        val containerNetworkPolicyDomainSecret =
            ContainerNetworkPolicyDomainSecret.builder().domain("x").name("x").value("x").build()

        assertThat(containerNetworkPolicyDomainSecret.domain()).isEqualTo("x")
        assertThat(containerNetworkPolicyDomainSecret.name()).isEqualTo("x")
        assertThat(containerNetworkPolicyDomainSecret.value()).isEqualTo("x")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val containerNetworkPolicyDomainSecret =
            ContainerNetworkPolicyDomainSecret.builder().domain("x").name("x").value("x").build()

        val roundtrippedContainerNetworkPolicyDomainSecret =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(containerNetworkPolicyDomainSecret),
                jacksonTypeRef<ContainerNetworkPolicyDomainSecret>(),
            )

        assertThat(roundtrippedContainerNetworkPolicyDomainSecret)
            .isEqualTo(containerNetworkPolicyDomainSecret)
    }
}
