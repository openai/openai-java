// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.certificates

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CertificateRetrieveParamsTest {

    @Test
    fun create() {
        CertificateRetrieveParams.builder()
            .certificateId("certificate_id")
            .addInclude(CertificateRetrieveParams.Include.CONTENT)
            .build()
    }

    @Test
    fun pathParams() {
        val params = CertificateRetrieveParams.builder().certificateId("certificate_id").build()

        assertThat(params._pathParam(0)).isEqualTo("certificate_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            CertificateRetrieveParams.builder()
                .certificateId("certificate_id")
                .addInclude(CertificateRetrieveParams.Include.CONTENT)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("include[]", "content").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = CertificateRetrieveParams.builder().certificateId("certificate_id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
