// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.serviceaccounts

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ServiceAccountDeleteParamsTest {

    @Test
    fun create() {
        ServiceAccountDeleteParams.builder()
            .projectId("project_id")
            .serviceAccountId("service_account_id")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ServiceAccountDeleteParams.builder()
                .projectId("project_id")
                .serviceAccountId("service_account_id")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("project_id")
        assertThat(params._pathParam(1)).isEqualTo("service_account_id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }
}
