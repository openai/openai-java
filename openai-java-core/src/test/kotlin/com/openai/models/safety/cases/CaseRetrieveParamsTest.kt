// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.safety.cases

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CaseRetrieveParamsTest {

    @Test
    fun create() {
        CaseRetrieveParams.builder().id("id").build()
    }

    @Test
    fun pathParams() {
        val params = CaseRetrieveParams.builder().id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
