// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.workloadidentityproviders

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WorkloadIdentityProviderRetrieveParamsTest {

    @Test
    fun create() {
        WorkloadIdentityProviderRetrieveParams.builder().workloadIdentityProviderId("x").build()
    }

    @Test
    fun pathParams() {
        val params =
            WorkloadIdentityProviderRetrieveParams.builder().workloadIdentityProviderId("x").build()

        assertThat(params._pathParam(0)).isEqualTo("x")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
