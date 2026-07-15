// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.spendalerts

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SpendAlertRetrieveParamsTest {

    @Test
    fun create() {
        SpendAlertRetrieveParams.builder().alertId("alert_id").build()
    }

    @Test
    fun pathParams() {
        val params = SpendAlertRetrieveParams.builder().alertId("alert_id").build()

        assertThat(params._pathParam(0)).isEqualTo("alert_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
