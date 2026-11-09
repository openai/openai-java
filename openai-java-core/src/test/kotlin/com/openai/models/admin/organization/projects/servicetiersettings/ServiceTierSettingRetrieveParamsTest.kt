// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.projects.servicetiersettings

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ServiceTierSettingRetrieveParamsTest {

    @Test
    fun create() {
        ServiceTierSettingRetrieveParams.builder().projectId("project_id").build()
    }

    @Test
    fun pathParams() {
        val params = ServiceTierSettingRetrieveParams.builder().projectId("project_id").build()

        assertThat(params._pathParam(0)).isEqualTo("project_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
