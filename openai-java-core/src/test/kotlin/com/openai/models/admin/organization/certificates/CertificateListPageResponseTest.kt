// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.certificates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CertificateListPageResponseTest {

    @Test
    fun create() {
        val certificateListPageResponse =
            CertificateListPageResponse.builder()
                .addData(
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
                )
                .firstId("cert_abc")
                .hasMore(true)
                .lastId("cert_abc")
                .build()

        assertThat(certificateListPageResponse.data())
            .containsExactly(
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
            )
        assertThat(certificateListPageResponse.firstId()).contains("cert_abc")
        assertThat(certificateListPageResponse.hasMore()).isEqualTo(true)
        assertThat(certificateListPageResponse.lastId()).contains("cert_abc")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val certificateListPageResponse =
            CertificateListPageResponse.builder()
                .addData(
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
                )
                .firstId("cert_abc")
                .hasMore(true)
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
