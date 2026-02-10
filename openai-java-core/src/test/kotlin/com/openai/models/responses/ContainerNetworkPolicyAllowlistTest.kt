// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContainerNetworkPolicyAllowlistTest {

    @Test
    fun create() {
        val containerNetworkPolicyAllowlist =
            ContainerNetworkPolicyAllowlist.builder()
                .addAllowedDomain("string")
                .addDomainSecret(
                    ContainerNetworkPolicyDomainSecret.builder()
                        .domain("x")
                        .name("x")
                        .value("x")
                        .build()
                )
                .build()

        assertThat(containerNetworkPolicyAllowlist.allowedDomains()).containsExactly("string")
        assertThat(containerNetworkPolicyAllowlist.domainSecrets().getOrNull())
            .containsExactly(
                ContainerNetworkPolicyDomainSecret.builder()
                    .domain("x")
                    .name("x")
                    .value("x")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val containerNetworkPolicyAllowlist =
            ContainerNetworkPolicyAllowlist.builder()
                .addAllowedDomain("string")
                .addDomainSecret(
                    ContainerNetworkPolicyDomainSecret.builder()
                        .domain("x")
                        .name("x")
                        .value("x")
                        .build()
                )
                .build()

        val roundtrippedContainerNetworkPolicyAllowlist =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(containerNetworkPolicyAllowlist),
                jacksonTypeRef<ContainerNetworkPolicyAllowlist>(),
            )

        assertThat(roundtrippedContainerNetworkPolicyAllowlist)
            .isEqualTo(containerNetworkPolicyAllowlist)
    }
}
