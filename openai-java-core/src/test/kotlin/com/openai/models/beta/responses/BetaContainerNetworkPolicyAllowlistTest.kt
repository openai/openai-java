// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaContainerNetworkPolicyAllowlistTest {

    @Test
    fun create() {
        val betaContainerNetworkPolicyAllowlist =
            BetaContainerNetworkPolicyAllowlist.builder()
                .addAllowedDomain("string")
                .addDomainSecret(
                    BetaContainerNetworkPolicyDomainSecret.builder()
                        .domain("x")
                        .name("x")
                        .value("x")
                        .build()
                )
                .build()

        assertThat(betaContainerNetworkPolicyAllowlist.allowedDomains()).containsExactly("string")
        assertThat(betaContainerNetworkPolicyAllowlist.domainSecrets().getOrNull())
            .containsExactly(
                BetaContainerNetworkPolicyDomainSecret.builder()
                    .domain("x")
                    .name("x")
                    .value("x")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaContainerNetworkPolicyAllowlist =
            BetaContainerNetworkPolicyAllowlist.builder()
                .addAllowedDomain("string")
                .addDomainSecret(
                    BetaContainerNetworkPolicyDomainSecret.builder()
                        .domain("x")
                        .name("x")
                        .value("x")
                        .build()
                )
                .build()

        val roundtrippedBetaContainerNetworkPolicyAllowlist =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaContainerNetworkPolicyAllowlist),
                jacksonTypeRef<BetaContainerNetworkPolicyAllowlist>(),
            )

        assertThat(roundtrippedBetaContainerNetworkPolicyAllowlist)
            .isEqualTo(betaContainerNetworkPolicyAllowlist)
    }
}
