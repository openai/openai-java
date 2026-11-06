// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.projects.servicetiersettings

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ServiceTierSettingUpdateParamsTest {

    @Test
    fun create() {
        ServiceTierSettingUpdateParams.builder()
            .projectId("project_id")
            .default_(ServiceTierSettingUpdateParams.Default.STANDARD)
            .enabledTiersAll()
            .build()
    }

    @Test
    fun pathParams() {
        val params = ServiceTierSettingUpdateParams.builder().projectId("project_id").build()

        assertThat(params._pathParam(0)).isEqualTo("project_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            ServiceTierSettingUpdateParams.builder()
                .projectId("project_id")
                .default_(ServiceTierSettingUpdateParams.Default.STANDARD)
                .enabledTiersAll()
                .build()

        val body = params._body()

        assertThat(body.default_()).contains(ServiceTierSettingUpdateParams.Default.STANDARD)
        assertThat(body.enabledTiers())
            .contains(ServiceTierSettingUpdateParams.EnabledTiers.ofAll())
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ServiceTierSettingUpdateParams.builder().projectId("project_id").build()

        val body = params._body()
    }
}
