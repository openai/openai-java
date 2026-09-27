// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.safety.alerts

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AlertRetrieveParamsTest {

    @Test
    fun create() {
        AlertRetrieveParams.builder().id("id").build()
    }

    @Test
    fun pathParams() {
        val params = AlertRetrieveParams.builder().id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
