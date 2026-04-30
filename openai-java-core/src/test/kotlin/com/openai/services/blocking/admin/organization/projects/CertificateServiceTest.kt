// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization.projects

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.admin.organization.projects.certificates.CertificateActivateParams
import com.openai.models.admin.organization.projects.certificates.CertificateDeactivateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class CertificateServiceTest {

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val certificateService = client.admin().organization().projects().certificates()

        val page = certificateService.list("project_id")

        page.response().validate()
    }

    @Test
    fun activate() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val certificateService = client.admin().organization().projects().certificates()

        val page =
            certificateService.activate(
                CertificateActivateParams.builder()
                    .projectId("project_id")
                    .addCertificateId("cert_abc")
                    .build()
            )

        page.response().validate()
    }

    @Test
    fun deactivate() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val certificateService = client.admin().organization().projects().certificates()

        val page =
            certificateService.deactivate(
                CertificateDeactivateParams.builder()
                    .projectId("project_id")
                    .addCertificateId("cert_abc")
                    .build()
            )

        page.response().validate()
    }
}
