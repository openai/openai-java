// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.workloadidentityproviders

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WorkloadIdentityProviderTest {

    @Test
    fun createAndRoundtrip() {
        val workloadIdentityProvider =
            WorkloadIdentityProvider.builder()
                .id("id")
                .addAttributeTransformation(
                    WorkloadIdentityProvider.AttributeTransformation.builder()
                        .attribute("attribute")
                        .expression("expression")
                        .build()
                )
                .audience("audience")
                .createdAt(0L)
                .description("description")
                .enabled(true)
                .issuer("issuer")
                .name("name")
                .updatedAt(0L)
                .discoveryVerification("discovery_url")
                .build()

        assertThat(workloadIdentityProvider.id()).isEqualTo("id")
        assertThat(workloadIdentityProvider.attributeTransformations())
            .containsExactly(
                WorkloadIdentityProvider.AttributeTransformation.builder()
                    .attribute("attribute")
                    .expression("expression")
                    .build()
            )
        assertThat(workloadIdentityProvider.audience()).isEqualTo("audience")
        assertThat(workloadIdentityProvider.createdAt()).isEqualTo(0L)
        assertThat(workloadIdentityProvider.description()).contains("description")
        assertThat(workloadIdentityProvider.enabled()).isEqualTo(true)
        assertThat(workloadIdentityProvider.issuer()).isEqualTo("issuer")
        assertThat(workloadIdentityProvider.name()).isEqualTo("name")
        assertThat(workloadIdentityProvider.updatedAt()).isEqualTo(0L)
        assertThat(workloadIdentityProvider.verification())
            .isEqualTo(
                WorkloadIdentityProvider.Verification.ofDiscovery(
                    WorkloadIdentityProvider.Verification.Discovery.builder()
                        .discoveryUrl("discovery_url")
                        .build()
                )
            )

        val jsonMapper = jsonMapper()

        val roundtrippedWorkloadIdentityProvider =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(workloadIdentityProvider),
                jacksonTypeRef<WorkloadIdentityProvider>(),
            )

        assertThat(roundtrippedWorkloadIdentityProvider).isEqualTo(workloadIdentityProvider)
    }
}
