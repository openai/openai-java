// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaContainerNetworkPolicyDomainSecretTest {

    @Test
    fun create() {
        val betaContainerNetworkPolicyDomainSecret =
            BetaContainerNetworkPolicyDomainSecret.builder()
                .domain("x")
                .name("x")
                .value("x")
                .build()

        assertThat(betaContainerNetworkPolicyDomainSecret.domain()).isEqualTo("x")
        assertThat(betaContainerNetworkPolicyDomainSecret.name()).isEqualTo("x")
        assertThat(betaContainerNetworkPolicyDomainSecret.value()).isEqualTo("x")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaContainerNetworkPolicyDomainSecret =
            BetaContainerNetworkPolicyDomainSecret.builder()
                .domain("x")
                .name("x")
                .value("x")
                .build()

        val roundtrippedBetaContainerNetworkPolicyDomainSecret =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaContainerNetworkPolicyDomainSecret),
                jacksonTypeRef<BetaContainerNetworkPolicyDomainSecret>(),
            )

        assertThat(roundtrippedBetaContainerNetworkPolicyDomainSecret)
            .isEqualTo(betaContainerNetworkPolicyDomainSecret)
    }
}
