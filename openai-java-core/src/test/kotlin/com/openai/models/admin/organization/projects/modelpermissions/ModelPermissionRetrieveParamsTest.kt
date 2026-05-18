// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.modelpermissions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ModelPermissionRetrieveParamsTest {

    @Test
    fun create() {
        ModelPermissionRetrieveParams.builder().projectId("project_id").build()
    }

    @Test
    fun pathParams() {
        val params = ModelPermissionRetrieveParams.builder().projectId("project_id").build()

        assertThat(params._pathParam(0)).isEqualTo("project_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
