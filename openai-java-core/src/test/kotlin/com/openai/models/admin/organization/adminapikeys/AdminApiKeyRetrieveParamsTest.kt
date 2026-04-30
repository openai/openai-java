// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.adminapikeys

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AdminApiKeyRetrieveParamsTest {

    @Test
    fun create() {
        AdminApiKeyRetrieveParams.builder().keyId("key_id").build()
    }

    @Test
    fun pathParams() {
        val params = AdminApiKeyRetrieveParams.builder().keyId("key_id").build()

        assertThat(params._pathParam(0)).isEqualTo("key_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
