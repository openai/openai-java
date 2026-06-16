// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.spendalerts

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SpendAlertRetrieveParamsTest {

    @Test
    fun create() {
        SpendAlertRetrieveParams.builder().projectId("project_id").alertId("alert_id").build()
    }

    @Test
    fun pathParams() {
        val params =
            SpendAlertRetrieveParams.builder().projectId("project_id").alertId("alert_id").build()

        assertThat(params._pathParam(0)).isEqualTo("project_id")
        assertThat(params._pathParam(1)).isEqualTo("alert_id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }
}
