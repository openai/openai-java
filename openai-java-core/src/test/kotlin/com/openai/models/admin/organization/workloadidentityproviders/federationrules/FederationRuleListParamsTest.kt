// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.workloadidentityproviders.federationrules

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FederationRuleListParamsTest {

    @Test
    fun create() {
        FederationRuleListParams.builder()
            .workloadIdentityProviderId("x")
            .after("x")
            .limit(1L)
            .order(FederationRuleListParams.Order.ASC)
            .serviceAccountId("x")
            .build()
    }

    @Test
    fun pathParams() {
        val params = FederationRuleListParams.builder().workloadIdentityProviderId("x").build()

        assertThat(params._pathParam(0)).isEqualTo("x")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            FederationRuleListParams.builder()
                .workloadIdentityProviderId("x")
                .after("x")
                .limit(1L)
                .order(FederationRuleListParams.Order.ASC)
                .serviceAccountId("x")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "x")
                    .put("limit", "1")
                    .put("order", "asc")
                    .put("service_account_id", "x")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = FederationRuleListParams.builder().workloadIdentityProviderId("x").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
