// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.certificates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.admin.organization.certificates.Certificate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CertificateListPageResponseTest {

    @Test
    fun create() {
        val certificateListPageResponse =
            CertificateListPageResponse.builder()
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

        assertThat(certificateListPageResponse.data())
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
        assertThat(certificateListPageResponse.hasMore()).isEqualTo(true)
        assertThat(certificateListPageResponse.firstId()).contains("cert_abc")
        assertThat(certificateListPageResponse.lastId()).contains("cert_abc")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val certificateListPageResponse =
            CertificateListPageResponse.builder()
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

        val roundtrippedCertificateListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(certificateListPageResponse),
                jacksonTypeRef<CertificateListPageResponse>(),
            )

        assertThat(roundtrippedCertificateListPageResponse).isEqualTo(certificateListPageResponse)
    }
}
