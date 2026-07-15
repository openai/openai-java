// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.apikeys

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiKeyDeleteParamsTest {

    @Test
    fun create() {
        ApiKeyDeleteParams.builder().projectId("project_id").apiKeyId("api_key_id").build()
    }

    @Test
    fun pathParams() {
        val params =
            ApiKeyDeleteParams.builder().projectId("project_id").apiKeyId("api_key_id").build()

        assertThat(params._pathParam(0)).isEqualTo("project_id")
        assertThat(params._pathParam(1)).isEqualTo("api_key_id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }
}
