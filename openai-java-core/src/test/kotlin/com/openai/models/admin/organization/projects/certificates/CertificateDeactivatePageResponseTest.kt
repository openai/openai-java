// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.certificates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.admin.organization.certificates.Certificate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CertificateDeactivatePageResponseTest {

    @Test
    fun create() {
        val certificateDeactivatePageResponse =
            CertificateDeactivatePageResponse.builder()
                .addData(
                    Certificate.builder()
                        .id("id")
                        .certificateDetails(
                            Certificate.CertificateDetails.builder()
                                .content("content")
                                .expiresAt(0L)
                                .validAt(0L)
                                .build()
                        )
                        .createdAt(0L)
                        .name("name")
                        .object_(Certificate.Object.CERTIFICATE)
                        .active(true)
                        .build()
                )
                .hasMore(true)
                .firstId("cert_abc")
                .lastId("cert_abc")
                .build()

        assertThat(certificateDeactivatePageResponse.data())
            .containsExactly(
                Certificate.builder()
                    .id("id")
                    .certificateDetails(
                        Certificate.CertificateDetails.builder()
                            .content("content")
                            .expiresAt(0L)
                            .validAt(0L)
                            .build()
                    )
                    .createdAt(0L)
                    .name("name")
                    .object_(Certificate.Object.CERTIFICATE)
                    .active(true)
                    .build()
            )
        assertThat(certificateDeactivatePageResponse.hasMore()).isEqualTo(true)
        assertThat(certificateDeactivatePageResponse.firstId()).contains("cert_abc")
        assertThat(certificateDeactivatePageResponse.lastId()).contains("cert_abc")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val certificateDeactivatePageResponse =
            CertificateDeactivatePageResponse.builder()
                .addData(
                    Certificate.builder()
                        .id("id")
                        .certificateDetails(
                            Certificate.CertificateDetails.builder()
                                .content("content")
                                .expiresAt(0L)
                                .validAt(0L)
                                .build()
                        )
                        .createdAt(0L)
                        .name("name")
                        .object_(Certificate.Object.CERTIFICATE)
                        .active(true)
                        .build()
                )
                .hasMore(true)
                .firstId("cert_abc")
                .lastId("cert_abc")
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
