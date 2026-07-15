// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.certificates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CertificateActivateResponseTest {

    @Test
    fun create() {
        val certificateActivateResponse =
            CertificateActivateResponse.builder()
                .id("id")
                .active(true)
                .certificateDetails(
                    CertificateActivateResponse.CertificateDetails.builder()
                        .expiresAt(0L)
                        .validAt(0L)
                        .build()
                )
                .createdAt(0L)
                .name("name")
                .build()

        assertThat(certificateActivateResponse.id()).isEqualTo("id")
        assertThat(certificateActivateResponse.active()).isEqualTo(true)
        assertThat(certificateActivateResponse.certificateDetails())
            .isEqualTo(
                CertificateActivateResponse.CertificateDetails.builder()
                    .expiresAt(0L)
                    .validAt(0L)
                    .build()
            )
        assertThat(certificateActivateResponse.createdAt()).isEqualTo(0L)
        assertThat(certificateActivateResponse.name()).contains("name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val certificateActivateResponse =
            CertificateActivateResponse.builder()
                .id("id")
                .active(true)
                .certificateDetails(
                    CertificateActivateResponse.CertificateDetails.builder()
                        .expiresAt(0L)
                        .validAt(0L)
                        .build()
                )
                .createdAt(0L)
                .name("name")
                .build()

        val roundtrippedCertificateActivateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(certificateActivateResponse),
                jacksonTypeRef<CertificateActivateResponse>(),
            )

        assertThat(roundtrippedCertificateActivateResponse).isEqualTo(certificateActivateResponse)
    }
}
