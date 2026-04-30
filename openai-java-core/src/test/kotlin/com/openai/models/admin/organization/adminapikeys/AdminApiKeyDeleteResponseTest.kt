// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.adminapikeys

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AdminApiKeyDeleteResponseTest {

    @Test
    fun create() {
        val adminApiKeyDeleteResponse =
            AdminApiKeyDeleteResponse.builder()
                .id("key_abc")
                .deleted(true)
                .object_("organization.admin_api_key.deleted")
                .build()

        assertThat(adminApiKeyDeleteResponse.id()).contains("key_abc")
        assertThat(adminApiKeyDeleteResponse.deleted()).contains(true)
        assertThat(adminApiKeyDeleteResponse.object_())
            .contains("organization.admin_api_key.deleted")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val adminApiKeyDeleteResponse =
            AdminApiKeyDeleteResponse.builder()
                .id("key_abc")
                .deleted(true)
                .object_("organization.admin_api_key.deleted")
                .build()

        val roundtrippedAdminApiKeyDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(adminApiKeyDeleteResponse),
                jacksonTypeRef<AdminApiKeyDeleteResponse>(),
            )

        assertThat(roundtrippedAdminApiKeyDeleteResponse).isEqualTo(adminApiKeyDeleteResponse)
    }
}
