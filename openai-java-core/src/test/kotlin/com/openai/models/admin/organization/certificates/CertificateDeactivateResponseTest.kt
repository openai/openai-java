// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.certificates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CertificateDeactivateResponseTest {

    @Test
    fun createAndRoundtrip() {
        val certificateDeactivateResponse =
            CertificateDeactivateResponse.builder()
                .id("id")
                .active(true)
                .certificateDetails(
                    CertificateDeactivateResponse.CertificateDetails.builder()
                        .expiresAt(0L)
                        .validAt(0L)
                        .build()
                )
                .createdAt(0L)
                .name("name")
                .build()

        assertThat(certificateDeactivateResponse.id()).contains("id")
        assertThat(certificateDeactivateResponse.active()).contains(true)
        assertThat(certificateDeactivateResponse.certificateDetails())
            .contains(
                CertificateDeactivateResponse.CertificateDetails.builder()
                    .expiresAt(0L)
                    .validAt(0L)
                    .build()
            )
        assertThat(certificateDeactivateResponse.createdAt()).contains(0L)
        assertThat(certificateDeactivateResponse.name()).contains("name")

        val jsonMapper = jsonMapper()

        val roundtrippedCertificateDeactivateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(certificateDeactivateResponse),
                jacksonTypeRef<CertificateDeactivateResponse>(),
            )

        assertThat(roundtrippedCertificateDeactivateResponse)
            .isEqualTo(certificateDeactivateResponse)
    }
}
