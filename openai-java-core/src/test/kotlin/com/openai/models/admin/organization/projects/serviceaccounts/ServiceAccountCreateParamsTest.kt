// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.serviceaccounts

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ServiceAccountCreateParamsTest {

    @Test
    fun create() {
        ServiceAccountCreateParams.builder().projectId("project_id").name("name").build()
    }

    @Test
    fun pathParams() {
        val params =
            ServiceAccountCreateParams.builder().projectId("project_id").name("name").build()

        assertThat(params._pathParam(0)).isEqualTo("project_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            ServiceAccountCreateParams.builder().projectId("project_id").name("name").build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("name")
    }
}
