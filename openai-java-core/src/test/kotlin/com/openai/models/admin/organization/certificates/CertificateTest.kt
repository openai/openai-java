// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.certificates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CertificateTest {

    @Test
    fun create() {
        val certificate =
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

        assertThat(certificate.id()).isEqualTo("id")
        assertThat(certificate.certificateDetails())
            .isEqualTo(
                Certificate.CertificateDetails.builder()
                    .content("content")
                    .expiresAt(0L)
                    .validAt(0L)
                    .build()
            )
        assertThat(certificate.createdAt()).isEqualTo(0L)
        assertThat(certificate.name()).isEqualTo("name")
        assertThat(certificate.object_()).isEqualTo(Certificate.Object.CERTIFICATE)
        assertThat(certificate.active()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val certificate =
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

        val roundtrippedCertificate =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(certificate),
                jacksonTypeRef<Certificate>(),
            )

        assertThat(roundtrippedCertificate).isEqualTo(certificate)
    }
}
