// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProjectCreateParamsTest {

    @Test
    fun create() {
        ProjectCreateParams.builder()
            .name("name")
            .geography(ProjectCreateParams.Geography.US)
            .build()
    }

    @Test
    fun body() {
        val params =
            ProjectCreateParams.builder()
                .name("name")
                .geography(ProjectCreateParams.Geography.US)
                .build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("name")
        assertThat(body.geography()).contains(ProjectCreateParams.Geography.US)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ProjectCreateParams.builder().name("name").build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("name")
    }
}
