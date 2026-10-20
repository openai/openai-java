// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.projects.apikeys

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiKeyUpdateParamsTest {

    @Test
    fun create() {
        ApiKeyUpdateParams.builder()
            .projectId("project_id")
            .apiKeyId("api_key_id")
            .expiresInSeconds(1L)
            .addScope("api.all.read")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ApiKeyUpdateParams.builder().projectId("project_id").apiKeyId("api_key_id").build()

        assertThat(params._pathParam(0)).isEqualTo("project_id")
        assertThat(params._pathParam(1)).isEqualTo("api_key_id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            ApiKeyUpdateParams.builder()
                .projectId("project_id")
                .apiKeyId("api_key_id")
                .expiresInSeconds(1L)
                .addScope("api.all.read")
                .build()

        val body = params._body()

        assertThat(body.expiresInSecondsOptional()).contains(1L)
        assertThat(body.scopes().getOrNull()).containsExactly("api.all.read")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ApiKeyUpdateParams.builder().projectId("project_id").apiKeyId("api_key_id").build()

        val body = params._body()
    }
}
