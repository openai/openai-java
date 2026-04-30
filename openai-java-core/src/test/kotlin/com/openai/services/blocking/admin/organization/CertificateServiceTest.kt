// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.admin.organization.certificates.CertificateActivateParams
import com.openai.models.admin.organization.certificates.CertificateCreateParams
import com.openai.models.admin.organization.certificates.CertificateDeactivateParams
import com.openai.models.admin.organization.certificates.CertificateRetrieveParams
import com.openai.models.admin.organization.certificates.CertificateUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class CertificateServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val certificateService = client.admin().organization().certificates()

        val certificate =
            certificateService.create(
                CertificateCreateParams.builder().content("content").name("name").build()
            )

        certificate.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val certificateService = client.admin().organization().certificates()

        val certificate =
            certificateService.retrieve(
                CertificateRetrieveParams.builder()
                    .certificateId("certificate_id")
                    .addInclude(CertificateRetrieveParams.Include.CONTENT)
                    .build()
            )

        certificate.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val certificateService = client.admin().organization().certificates()

        val certificate =
            certificateService.update(
                CertificateUpdateParams.builder()
                    .certificateId("certificate_id")
                    .name("name")
                    .build()
            )

        certificate.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val certificateService = client.admin().organization().certificates()

        val page = certificateService.list()

        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val certificateService = client.admin().organization().certificates()

        val certificate = certificateService.delete("certificate_id")

        certificate.validate()
    }

    @Test
    fun activate() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val certificateService = client.admin().organization().certificates()

        val page =
            certificateService.activate(
                CertificateActivateParams.builder().addCertificateId("cert_abc").build()
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
        val certificateService = client.admin().organization().certificates()

        val page =
            certificateService.deactivate(
                CertificateDeactivateParams.builder().addCertificateId("cert_abc").build()
            )

        page.response().validate()
    }
}
