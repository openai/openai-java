// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaContainerNetworkPolicyDomainSecretTest {

    @Test
    fun createAndRoundtrip() {
        val betaContainerNetworkPolicyDomainSecret =
            BetaContainerNetworkPolicyDomainSecret.builder()
                .domain("x")
                .name("x")
                .value("x")
                .build()

        assertThat(betaContainerNetworkPolicyDomainSecret.domain()).contains("x")
        assertThat(betaContainerNetworkPolicyDomainSecret.name()).contains("x")
        assertThat(betaContainerNetworkPolicyDomainSecret.value()).contains("x")

        val jsonMapper = jsonMapper()

        val roundtrippedBetaContainerNetworkPolicyDomainSecret =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaContainerNetworkPolicyDomainSecret),
                jacksonTypeRef<BetaContainerNetworkPolicyDomainSecret>(),
            )

        assertThat(roundtrippedBetaContainerNetworkPolicyDomainSecret)
            .isEqualTo(betaContainerNetworkPolicyDomainSecret)
    }
}
