// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.workloadidentityproviders.federationrules

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FederationRuleTest {

    @Test
    fun createAndRoundtrip() {
        val federationRule =
            FederationRule.builder()
                .id("id")
                .attributeMatchers(
                    FederationRule.AttributeMatchers.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .createdAt(0L)
                .description("description")
                .enabled(true)
                .name("name")
                .permissionsServiceAccountDefault()
                .projectId("project_id")
                .serviceAccountId("service_account_id")
                .updatedAt(0L)
                .workloadIdentityProviderId("workload_identity_provider_id")
                .build()

        assertThat(federationRule.id()).contains("id")
        assertThat(federationRule.attributeMatchers())
            .contains(
                FederationRule.AttributeMatchers.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(federationRule.createdAt()).contains(0L)
        assertThat(federationRule.description()).contains("description")
        assertThat(federationRule.enabled()).contains(true)
        assertThat(federationRule.name()).contains("name")
        assertThat(federationRule.permissions())
            .contains(FederationRule.Permissions.ofServiceAccountDefault())
        assertThat(federationRule.projectId()).contains("project_id")
        assertThat(federationRule.serviceAccountId()).contains("service_account_id")
        assertThat(federationRule.updatedAt()).contains(0L)
        assertThat(federationRule.workloadIdentityProviderId())
            .contains("workload_identity_provider_id")

        val jsonMapper = jsonMapper()

        val roundtrippedFederationRule =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(federationRule),
                jacksonTypeRef<FederationRule>(),
            )

        assertThat(roundtrippedFederationRule).isEqualTo(federationRule)
    }
}
