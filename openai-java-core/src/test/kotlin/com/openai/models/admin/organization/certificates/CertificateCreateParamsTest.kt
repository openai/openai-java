// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.certificates

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CertificateCreateParamsTest {

    @Test
    fun create() {
        CertificateCreateParams.builder().certificate("certificate").name("name").build()
    }

    @Test
    fun body() {
        val params =
            CertificateCreateParams.builder().certificate("certificate").name("name").build()

        val body = params._body()

        assertThat(body.certificate()).isEqualTo("certificate")
        assertThat(body.name()).contains("name")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = CertificateCreateParams.builder().certificate("certificate").build()

        val body = params._body()

        assertThat(body.certificate()).isEqualTo("certificate")
    }
}
