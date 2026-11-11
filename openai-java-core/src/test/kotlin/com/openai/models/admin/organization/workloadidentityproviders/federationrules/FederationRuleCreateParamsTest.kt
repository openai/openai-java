// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.workloadidentityproviders.federationrules

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FederationRuleCreateParamsTest {

    @Test
    fun create() {
        FederationRuleCreateParams.builder()
            .workloadIdentityProviderId("x")
            .attributeMatchers(
                FederationRuleCreateParams.AttributeMatchers.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
            .projectId("x")
            .serviceAccountId("x")
            .description("description")
            .enabled(true)
            .name("name")
            .permissionsServiceAccountDefault()
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            FederationRuleCreateParams.builder()
                .workloadIdentityProviderId("x")
                .attributeMatchers(
                    FederationRuleCreateParams.AttributeMatchers.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .projectId("x")
                .serviceAccountId("x")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("x")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            FederationRuleCreateParams.builder()
                .workloadIdentityProviderId("x")
                .attributeMatchers(
                    FederationRuleCreateParams.AttributeMatchers.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .projectId("x")
                .serviceAccountId("x")
                .description("description")
                .enabled(true)
                .name("name")
                .permissionsServiceAccountDefault()
                .build()

        val body = params._body()

        assertThat(body.attributeMatchersOrThrow())
            .isEqualTo(
                FederationRuleCreateParams.AttributeMatchers.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(body.projectIdOrThrow()).isEqualTo("x")
        assertThat(body.serviceAccountIdOrThrow()).isEqualTo("x")
        assertThat(body.description()).contains("description")
        assertThat(body.enabled()).contains(true)
        assertThat(body.name()).contains("name")
        assertThat(body.permissions())
            .contains(FederationRuleCreateParams.Permissions.ofServiceAccountDefault())
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            FederationRuleCreateParams.builder()
                .workloadIdentityProviderId("x")
                .attributeMatchers(
                    FederationRuleCreateParams.AttributeMatchers.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .projectId("x")
                .serviceAccountId("x")
                .build()

        val body = params._body()

        assertThat(body.attributeMatchersOrThrow())
            .isEqualTo(
                FederationRuleCreateParams.AttributeMatchers.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(body.projectIdOrThrow()).isEqualTo("x")
        assertThat(body.serviceAccountIdOrThrow()).isEqualTo("x")
    }
}
