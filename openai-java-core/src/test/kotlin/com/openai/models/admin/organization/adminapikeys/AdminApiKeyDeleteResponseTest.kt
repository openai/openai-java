// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.adminapikeys

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AdminApiKeyDeleteResponseTest {

    @Test
    fun createAndRoundtrip() {
        val adminApiKeyDeleteResponse =
            AdminApiKeyDeleteResponse.builder().id("key_abc").deleted(true).build()

        assertThat(adminApiKeyDeleteResponse.id()).isEqualTo("key_abc")
        assertThat(adminApiKeyDeleteResponse.deleted()).isEqualTo(true)

        val jsonMapper = jsonMapper()

        val roundtrippedAdminApiKeyDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(adminApiKeyDeleteResponse),
                jacksonTypeRef<AdminApiKeyDeleteResponse>(),
            )

        assertThat(roundtrippedAdminApiKeyDeleteResponse).isEqualTo(adminApiKeyDeleteResponse)
    }
}
