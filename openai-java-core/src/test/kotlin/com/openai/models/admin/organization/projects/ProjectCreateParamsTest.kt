// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProjectCreateParamsTest {

    @Test
    fun create() {
        ProjectCreateParams.builder()
            .name("name")
            .externalKeyId("external_key_id")
            .geography("geography")
            .build()
    }

    @Test
    fun body() {
        val params =
            ProjectCreateParams.builder()
                .name("name")
                .externalKeyId("external_key_id")
                .geography("geography")
                .build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("name")
        assertThat(body.externalKeyId()).contains("external_key_id")
        assertThat(body.geography()).contains("geography")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ProjectCreateParams.builder().name("name").build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("name")
    }
}
