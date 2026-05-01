// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.certificates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CertificateDeactivateResponseTest {

    @Test
    fun create() {
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

        assertThat(certificateDeactivateResponse.id()).isEqualTo("id")
        assertThat(certificateDeactivateResponse.active()).isEqualTo(true)
        assertThat(certificateDeactivateResponse.certificateDetails())
            .isEqualTo(
                CertificateDeactivateResponse.CertificateDetails.builder()
                    .expiresAt(0L)
                    .validAt(0L)
                    .build()
            )
        assertThat(certificateDeactivateResponse.createdAt()).isEqualTo(0L)
        assertThat(certificateDeactivateResponse.name()).contains("name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
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

        val roundtrippedCertificateDeactivateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(certificateDeactivateResponse),
                jacksonTypeRef<CertificateDeactivateResponse>(),
            )

        assertThat(roundtrippedCertificateDeactivateResponse)
            .isEqualTo(certificateDeactivateResponse)
    }
}
