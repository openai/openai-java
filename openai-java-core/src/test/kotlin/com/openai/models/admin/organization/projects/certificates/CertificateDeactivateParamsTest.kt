// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.certificates

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CertificateDeactivateParamsTest {

    @Test
    fun create() {
        CertificateDeactivateParams.builder()
            .projectId("project_id")
            .addCertificateId("cert_abc")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            CertificateDeactivateParams.builder()
                .projectId("project_id")
                .addCertificateId("cert_abc")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("project_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            CertificateDeactivateParams.builder()
                .projectId("project_id")
                .addCertificateId("cert_abc")
                .build()

        val body = params._body()

        assertThat(body.certificateIds()).containsExactly("cert_abc")
    }
}
