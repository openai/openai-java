// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.dataretention

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DataRetentionUpdateParamsTest {

    @Test
    fun create() {
        DataRetentionUpdateParams.builder()
            .projectId("project_id")
            .retentionType(DataRetentionUpdateParams.RetentionType.ORGANIZATION_DEFAULT)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            DataRetentionUpdateParams.builder()
                .projectId("project_id")
                .retentionType(DataRetentionUpdateParams.RetentionType.ORGANIZATION_DEFAULT)
                .build()

        assertThat(params._pathParam(0)).isEqualTo("project_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            DataRetentionUpdateParams.builder()
                .projectId("project_id")
                .retentionType(DataRetentionUpdateParams.RetentionType.ORGANIZATION_DEFAULT)
                .build()

        val body = params._body()

        assertThat(body.retentionType())
            .isEqualTo(DataRetentionUpdateParams.RetentionType.ORGANIZATION_DEFAULT)
    }
}
