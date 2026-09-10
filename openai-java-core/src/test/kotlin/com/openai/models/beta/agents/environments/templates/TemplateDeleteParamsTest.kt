// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.environments.templates

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TemplateDeleteParamsTest {

    @Test
    fun create() {
        TemplateDeleteParams.builder().environmentTemplateId("environment_template_id").build()
    }

    @Test
    fun pathParams() {
        val params =
            TemplateDeleteParams.builder().environmentTemplateId("environment_template_id").build()

        assertThat(params._pathParam(0)).isEqualTo("environment_template_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
