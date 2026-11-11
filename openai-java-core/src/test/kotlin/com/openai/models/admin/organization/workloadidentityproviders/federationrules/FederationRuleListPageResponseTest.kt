// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.workloadidentityproviders.federationrules

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FederationRuleListPageResponseTest {

    @Test
    fun createAndRoundtrip() {
        val federationRuleListPageResponse =
            FederationRuleListPageResponse.builder()
                .addData(
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
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(federationRuleListPageResponse.data().getOrNull())
            .containsExactly(
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
            )
        assertThat(federationRuleListPageResponse.firstId()).contains("first_id")
        assertThat(federationRuleListPageResponse.hasMore()).contains(true)
        assertThat(federationRuleListPageResponse.lastId()).contains("last_id")

        val jsonMapper = jsonMapper()

        val roundtrippedFederationRuleListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(federationRuleListPageResponse),
                jacksonTypeRef<FederationRuleListPageResponse>(),
            )

        assertThat(roundtrippedFederationRuleListPageResponse)
            .isEqualTo(federationRuleListPageResponse)
    }
}
