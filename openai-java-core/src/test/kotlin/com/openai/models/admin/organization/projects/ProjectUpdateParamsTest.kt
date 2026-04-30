// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProjectUpdateParamsTest {

    @Test
    fun create() {
        ProjectUpdateParams.builder().projectId("project_id").name("name").build()
    }

    @Test
    fun pathParams() {
        val params = ProjectUpdateParams.builder().projectId("project_id").name("name").build()

        assertThat(params._pathParam(0)).isEqualTo("project_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params = ProjectUpdateParams.builder().projectId("project_id").name("name").build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("name")
    }
}
