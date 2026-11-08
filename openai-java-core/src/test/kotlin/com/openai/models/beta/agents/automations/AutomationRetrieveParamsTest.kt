// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.automations

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AutomationRetrieveParamsTest {

    @Test
    fun create() {
        AutomationRetrieveParams.builder().automationId("automation_id").build()
    }

    @Test
    fun pathParams() {
        val params = AutomationRetrieveParams.builder().automationId("automation_id").build()

        assertThat(params._pathParam(0)).isEqualTo("automation_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
