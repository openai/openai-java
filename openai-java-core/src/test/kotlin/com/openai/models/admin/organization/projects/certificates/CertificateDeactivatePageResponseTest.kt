// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.certificates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CertificateDeactivatePageResponseTest {

    @Test
    fun create() {
        val certificateDeactivatePageResponse =
            CertificateDeactivatePageResponse.builder()
                .addData(
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
                )
                .build()

        assertThat(certificateDeactivatePageResponse.data())
            .containsExactly(
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
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val certificateDeactivatePageResponse =
            CertificateDeactivatePageResponse.builder()
                .addData(
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
                )
                .build()

        val roundtrippedCertificateDeactivatePageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(certificateDeactivatePageResponse),
                jacksonTypeRef<CertificateDeactivatePageResponse>(),
            )

        assertThat(roundtrippedCertificateDeactivatePageResponse)
            .isEqualTo(certificateDeactivatePageResponse)
    }
}
