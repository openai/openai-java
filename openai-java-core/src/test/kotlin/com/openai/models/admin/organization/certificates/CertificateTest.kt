// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.certificates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CertificateTest {

    @Test
    fun createAndRoundtrip() {
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

        assertThat(certificate.id()).contains("id")
        assertThat(certificate.certificateDetails())
            .contains(
                Certificate.CertificateDetails.builder()
                    .content("content")
                    .expiresAt(0L)
                    .validAt(0L)
                    .build()
            )
        assertThat(certificate.createdAt()).contains(0L)
        assertThat(certificate.name()).contains("name")
        assertThat(certificate.object_()).contains(Certificate.Object.CERTIFICATE)
        assertThat(certificate.active()).contains(true)

        val jsonMapper = jsonMapper()

        val roundtrippedCertificate =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(certificate),
                jacksonTypeRef<Certificate>(),
            )

        assertThat(roundtrippedCertificate).isEqualTo(certificate)
    }
}
