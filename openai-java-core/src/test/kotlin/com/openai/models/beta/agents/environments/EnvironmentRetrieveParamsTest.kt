// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.environments

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EnvironmentRetrieveParamsTest {

    @Test
    fun create() {
        EnvironmentRetrieveParams.builder().environmentId("environment_id").build()
    }

    @Test
    fun pathParams() {
        val params = EnvironmentRetrieveParams.builder().environmentId("environment_id").build()

        assertThat(params._pathParam(0)).isEqualTo("environment_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
