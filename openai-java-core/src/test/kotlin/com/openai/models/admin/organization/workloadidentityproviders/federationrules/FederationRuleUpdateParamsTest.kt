// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.workloadidentityproviders.federationrules

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FederationRuleUpdateParamsTest {

    @Test
    fun create() {
        FederationRuleUpdateParams.builder()
            .workloadIdentityProviderId("x")
            .workloadIdentityFederationRuleId("x")
            .attributeMatchers(
                FederationRuleUpdateParams.AttributeMatchers.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
            .description("description")
            .enabled(true)
            .name("name")
            .permissionsDefaultPermissionsParam()
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            FederationRuleUpdateParams.builder()
                .workloadIdentityProviderId("x")
                .workloadIdentityFederationRuleId("x")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("x")
        assertThat(params._pathParam(1)).isEqualTo("x")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            FederationRuleUpdateParams.builder()
                .workloadIdentityProviderId("x")
                .workloadIdentityFederationRuleId("x")
                .attributeMatchers(
                    FederationRuleUpdateParams.AttributeMatchers.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .description("description")
                .enabled(true)
                .name("name")
                .permissionsDefaultPermissionsParam()
                .build()

        val body = params._body()

        assertThat(body.attributeMatchers())
            .contains(
                FederationRuleUpdateParams.AttributeMatchers.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(body.description()).contains("description")
        assertThat(body.enabled()).contains(true)
        assertThat(body.name()).contains("name")
        assertThat(body.permissions())
            .contains(FederationRuleUpdateParams.Permissions.ofDefaultPermissionsParam())
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            FederationRuleUpdateParams.builder()
                .workloadIdentityProviderId("x")
                .workloadIdentityFederationRuleId("x")
                .build()

        val body = params._body()
    }
}
