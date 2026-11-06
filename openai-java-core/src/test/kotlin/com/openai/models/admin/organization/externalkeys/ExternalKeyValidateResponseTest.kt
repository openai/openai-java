// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.externalkeys

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExternalKeyValidateResponseTest {

    @Test
    fun createAndRoundtrip() {
        val externalKeyValidateResponse =
            ExternalKeyValidateResponse.builder().status("status").build()

        assertThat(externalKeyValidateResponse.status()).isEqualTo("status")

        val jsonMapper = jsonMapper()

        val roundtrippedExternalKeyValidateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(externalKeyValidateResponse),
                jacksonTypeRef<ExternalKeyValidateResponse>(),
            )

        assertThat(roundtrippedExternalKeyValidateResponse).isEqualTo(externalKeyValidateResponse)
    }
}
