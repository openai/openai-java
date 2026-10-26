// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.certificates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CertificateListResponseTest {

    @Test
    fun createAndRoundtrip() {
        val certificateListResponse =
            CertificateListResponse.builder()
                .id("id")
                .active(true)
                .certificateDetails(
                    CertificateListResponse.CertificateDetails.builder()
                        .expiresAt(0L)
                        .validAt(0L)
                        .build()
                )
                .createdAt(0L)
                .name("name")
                .build()

        assertThat(certificateListResponse.id()).isEqualTo("id")
        assertThat(certificateListResponse.active()).isEqualTo(true)
        assertThat(certificateListResponse.certificateDetails())
            .isEqualTo(
                CertificateListResponse.CertificateDetails.builder()
                    .expiresAt(0L)
                    .validAt(0L)
                    .build()
            )
        assertThat(certificateListResponse.createdAt()).isEqualTo(0L)
        assertThat(certificateListResponse.name()).contains("name")

        val jsonMapper = jsonMapper()

        val roundtrippedCertificateListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(certificateListResponse),
                jacksonTypeRef<CertificateListResponse>(),
            )

        assertThat(roundtrippedCertificateListResponse).isEqualTo(certificateListResponse)
    }
}
