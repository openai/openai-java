// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.serviceaccounts.apikeys

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiKeyCreateParamsTest {

    @Test
    fun create() {
        ApiKeyCreateParams.builder()
            .projectId("project_id")
            .serviceAccountId("service_account_id")
            .name("name")
            .addScope("string")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ApiKeyCreateParams.builder()
                .projectId("project_id")
                .serviceAccountId("service_account_id")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("project_id")
        assertThat(params._pathParam(1)).isEqualTo("service_account_id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            ApiKeyCreateParams.builder()
                .projectId("project_id")
                .serviceAccountId("service_account_id")
                .name("name")
                .addScope("string")
                .build()

        val body = params._body()

        assertThat(body.name()).contains("name")
        assertThat(body.scopes().getOrNull()).containsExactly("string")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ApiKeyCreateParams.builder()
                .projectId("project_id")
                .serviceAccountId("service_account_id")
                .build()

        val body = params._body()
    }
}
