// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.certificates

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CertificateActivateParamsTest {

    @Test
    fun create() {
        CertificateActivateParams.builder().addCertificateId("cert_abc").build()
    }

    @Test
    fun body() {
        val params = CertificateActivateParams.builder().addCertificateId("cert_abc").build()

        val body = params._body()

        assertThat(body.certificateIds()).containsExactly("cert_abc")
    }
}
