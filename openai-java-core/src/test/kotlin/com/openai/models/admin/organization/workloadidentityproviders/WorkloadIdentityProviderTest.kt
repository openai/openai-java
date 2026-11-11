// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.workloadidentityproviders

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
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

        assertThat(workloadIdentityProvider.id()).contains("id")
        assertThat(workloadIdentityProvider.attributeTransformations().getOrNull())
            .containsExactly(
                WorkloadIdentityProvider.AttributeTransformation.builder()
                    .attribute("attribute")
                    .expression("expression")
                    .build()
            )
        assertThat(workloadIdentityProvider.audience()).contains("audience")
        assertThat(workloadIdentityProvider.createdAt()).contains(0L)
        assertThat(workloadIdentityProvider.description()).contains("description")
        assertThat(workloadIdentityProvider.enabled()).contains(true)
        assertThat(workloadIdentityProvider.issuer()).contains("issuer")
        assertThat(workloadIdentityProvider.name()).contains("name")
        assertThat(workloadIdentityProvider.updatedAt()).contains(0L)
        assertThat(workloadIdentityProvider.verification())
            .contains(
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
