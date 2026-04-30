// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.certificates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CertificateActivatePageResponseTest {

    @Test
    fun create() {
        val certificateActivatePageResponse =
            CertificateActivatePageResponse.builder()
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

        assertThat(certificateActivatePageResponse.data())
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
        assertThat(certificateActivatePageResponse.hasMore()).isEqualTo(true)
        assertThat(certificateActivatePageResponse.firstId()).contains("cert_abc")
        assertThat(certificateActivatePageResponse.lastId()).contains("cert_abc")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val certificateActivatePageResponse =
            CertificateActivatePageResponse.builder()
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

        val roundtrippedCertificateActivatePageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(certificateActivatePageResponse),
                jacksonTypeRef<CertificateActivatePageResponse>(),
            )

        assertThat(roundtrippedCertificateActivatePageResponse)
            .isEqualTo(certificateActivatePageResponse)
    }
}
