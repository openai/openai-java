// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.workloadidentityproviders.federationrules

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FederationRuleDeleteParamsTest {

    @Test
    fun create() {
        FederationRuleDeleteParams.builder()
            .workloadIdentityProviderId("x")
            .workloadIdentityFederationRuleId("x")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            FederationRuleDeleteParams.builder()
                .workloadIdentityProviderId("x")
                .workloadIdentityFederationRuleId("x")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("x")
        assertThat(params._pathParam(1)).isEqualTo("x")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }
}
