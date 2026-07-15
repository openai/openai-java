// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.modelpermissions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ModelPermissionUpdateParamsTest {

    @Test
    fun create() {
        ModelPermissionUpdateParams.builder()
            .projectId("project_id")
            .mode(ModelPermissionUpdateParams.Mode.ALLOW_LIST)
            .addModelId("string")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ModelPermissionUpdateParams.builder()
                .projectId("project_id")
                .mode(ModelPermissionUpdateParams.Mode.ALLOW_LIST)
                .addModelId("string")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("project_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            ModelPermissionUpdateParams.builder()
                .projectId("project_id")
                .mode(ModelPermissionUpdateParams.Mode.ALLOW_LIST)
                .addModelId("string")
                .build()

        val body = params._body()

        assertThat(body.mode()).isEqualTo(ModelPermissionUpdateParams.Mode.ALLOW_LIST)
        assertThat(body.modelIds()).containsExactly("string")
    }
}
