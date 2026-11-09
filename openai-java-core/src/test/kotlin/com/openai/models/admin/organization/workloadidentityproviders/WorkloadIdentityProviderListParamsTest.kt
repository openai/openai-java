// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.workloadidentityproviders

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WorkloadIdentityProviderListParamsTest {

    @Test
    fun create() {
        WorkloadIdentityProviderListParams.builder()
            .after("x")
            .limit(1L)
            .order(WorkloadIdentityProviderListParams.Order.ASC)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            WorkloadIdentityProviderListParams.builder()
                .after("x")
                .limit(1L)
                .order(WorkloadIdentityProviderListParams.Order.ASC)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "x")
                    .put("limit", "1")
                    .put("order", "asc")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = WorkloadIdentityProviderListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
