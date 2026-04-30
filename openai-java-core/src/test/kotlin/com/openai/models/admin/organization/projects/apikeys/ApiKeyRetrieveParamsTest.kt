// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.apikeys

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiKeyRetrieveParamsTest {

    @Test
    fun create() {
        ApiKeyRetrieveParams.builder().projectId("project_id").keyId("key_id").build()
    }

    @Test
    fun pathParams() {
        val params = ApiKeyRetrieveParams.builder().projectId("project_id").keyId("key_id").build()

        assertThat(params._pathParam(0)).isEqualTo("project_id")
        assertThat(params._pathParam(1)).isEqualTo("key_id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }
}
