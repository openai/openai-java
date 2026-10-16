// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.projects.apikeys

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiKeyUpdateParamsTest {

    @Test
    fun create() {
        ApiKeyUpdateParams.builder()
            .projectId("project_id")
            .apiKeyId("api_key_id")
            .expiresInSeconds(1L)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ApiKeyUpdateParams.builder()
                .projectId("project_id")
                .apiKeyId("api_key_id")
                .expiresInSeconds(1L)
                .build()

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
                .build()

        val body = params._body()

        assertThat(body.expiresInSeconds()).isEqualTo(1L)
    }
}
