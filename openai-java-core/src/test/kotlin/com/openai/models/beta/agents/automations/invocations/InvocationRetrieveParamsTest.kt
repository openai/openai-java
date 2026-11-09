// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.automations.invocations

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InvocationRetrieveParamsTest {

    @Test
    fun create() {
        InvocationRetrieveParams.builder()
            .automationId("automation_id")
            .invocationId("invocation_id")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            InvocationRetrieveParams.builder()
                .automationId("automation_id")
                .invocationId("invocation_id")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("automation_id")
        assertThat(params._pathParam(1)).isEqualTo("invocation_id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }
}
