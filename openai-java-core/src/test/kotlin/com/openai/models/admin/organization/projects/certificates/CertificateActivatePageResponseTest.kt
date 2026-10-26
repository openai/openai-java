// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.projects.certificates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CertificateActivatePageResponseTest {

    @Test
    fun createAndRoundtrip() {
        val certificateActivatePageResponse =
            CertificateActivatePageResponse.builder()
                .addData(
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
                )
                .build()

        assertThat(certificateActivatePageResponse.data())
            .containsExactly(
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
            )

        val jsonMapper = jsonMapper()

        val roundtrippedCertificateActivatePageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(certificateActivatePageResponse),
                jacksonTypeRef<CertificateActivatePageResponse>(),
            )

        assertThat(roundtrippedCertificateActivatePageResponse)
            .isEqualTo(certificateActivatePageResponse)
    }
}
