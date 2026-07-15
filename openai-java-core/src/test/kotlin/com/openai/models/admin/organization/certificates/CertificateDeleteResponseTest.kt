// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.certificates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CertificateDeleteResponseTest {

    @Test
    fun create() {
        val certificateDeleteResponse = CertificateDeleteResponse.builder().id("id").build()

        assertThat(certificateDeleteResponse.id()).isEqualTo("id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val certificateDeleteResponse = CertificateDeleteResponse.builder().id("id").build()

        val roundtrippedCertificateDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(certificateDeleteResponse),
                jacksonTypeRef<CertificateDeleteResponse>(),
            )

        assertThat(roundtrippedCertificateDeleteResponse).isEqualTo(certificateDeleteResponse)
    }
}
