// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.certificates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CertificateDeleteResponseTest {

    @Test
    fun createAndRoundtrip() {
        val certificateDeleteResponse = CertificateDeleteResponse.builder().id("id").build()

        assertThat(certificateDeleteResponse.id()).isEqualTo("id")

        val jsonMapper = jsonMapper()

        val roundtrippedCertificateDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(certificateDeleteResponse),
                jacksonTypeRef<CertificateDeleteResponse>(),
            )

        assertThat(roundtrippedCertificateDeleteResponse).isEqualTo(certificateDeleteResponse)
    }
}
