// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.workloadidentityproviders

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WorkloadIdentityProviderListPageResponseTest {

    @Test
    fun createAndRoundtrip() {
        val workloadIdentityProviderListPageResponse =
            WorkloadIdentityProviderListPageResponse.builder()
                .addData(
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
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(workloadIdentityProviderListPageResponse.data().getOrNull())
            .containsExactly(
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
            )
        assertThat(workloadIdentityProviderListPageResponse.firstId()).contains("first_id")
        assertThat(workloadIdentityProviderListPageResponse.hasMore()).contains(true)
        assertThat(workloadIdentityProviderListPageResponse.lastId()).contains("last_id")

        val jsonMapper = jsonMapper()

        val roundtrippedWorkloadIdentityProviderListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(workloadIdentityProviderListPageResponse),
                jacksonTypeRef<WorkloadIdentityProviderListPageResponse>(),
            )

        assertThat(roundtrippedWorkloadIdentityProviderListPageResponse)
            .isEqualTo(workloadIdentityProviderListPageResponse)
    }
}
