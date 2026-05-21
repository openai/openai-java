// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.roles

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoleRetrieveParamsTest {

    @Test
    fun create() {
        RoleRetrieveParams.builder().roleId("role_id").build()
    }

    @Test
    fun pathParams() {
        val params = RoleRetrieveParams.builder().roleId("role_id").build()

        assertThat(params._pathParam(0)).isEqualTo("role_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
