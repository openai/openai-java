// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.adminapikeys

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AdminApiKeyCreateParamsTest {

    @Test
    fun create() {
        AdminApiKeyCreateParams.builder().name("New Admin Key").build()
    }

    @Test
    fun body() {
        val params = AdminApiKeyCreateParams.builder().name("New Admin Key").build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("New Admin Key")
    }
}
