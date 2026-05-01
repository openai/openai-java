// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProjectUpdateParamsTest {

    @Test
    fun create() {
        ProjectUpdateParams.builder()
            .projectId("project_id")
            .externalKeyId("external_key_id")
            .geography("geography")
            .name("name")
            .build()
    }

    @Test
    fun pathParams() {
        val params = ProjectUpdateParams.builder().projectId("project_id").build()

        assertThat(params._pathParam(0)).isEqualTo("project_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            ProjectUpdateParams.builder()
                .projectId("project_id")
                .externalKeyId("external_key_id")
                .geography("geography")
                .name("name")
                .build()

        val body = params._body()

        assertThat(body.externalKeyId()).contains("external_key_id")
        assertThat(body.geography()).contains("geography")
        assertThat(body.name()).contains("name")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ProjectUpdateParams.builder().projectId("project_id").build()

        val body = params._body()
    }
}
