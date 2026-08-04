// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.spendlimit

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SpendLimitDeleteParamsTest {

    @Test
    fun create() {
        SpendLimitDeleteParams.builder().projectId("proj_123").build()
    }

    @Test
    fun pathParams() {
        val params = SpendLimitDeleteParams.builder().projectId("proj_123").build()

        assertThat(params._pathParam(0)).isEqualTo("proj_123")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
