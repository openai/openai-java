// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.admin.organization.certificates.CertificateActivateParams
import com.openai.models.admin.organization.certificates.CertificateCreateParams
import com.openai.models.admin.organization.certificates.CertificateDeactivateParams
import com.openai.models.admin.organization.certificates.CertificateRetrieveParams
import com.openai.models.admin.organization.certificates.CertificateUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class CertificateServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val certificateServiceAsync = client.admin().organization().certificates()

        val certificateFuture =
            certificateServiceAsync.create(
                CertificateCreateParams.builder().certificate("certificate").name("name").build()
            )

        val certificate = certificateFuture.get()
        certificate.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val certificateServiceAsync = client.admin().organization().certificates()

        val certificateFuture =
            certificateServiceAsync.retrieve(
                CertificateRetrieveParams.builder()
                    .certificateId("certificate_id")
                    .addInclude(CertificateRetrieveParams.Include.CONTENT)
                    .build()
            )

        val certificate = certificateFuture.get()
        certificate.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val certificateServiceAsync = client.admin().organization().certificates()

        val certificateFuture =
            certificateServiceAsync.update(
                CertificateUpdateParams.builder()
                    .certificateId("certificate_id")
                    .name("name")
                    .build()
            )

        val certificate = certificateFuture.get()
        certificate.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val certificateServiceAsync = client.admin().organization().certificates()

        val pageFuture = certificateServiceAsync.list()

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val certificateServiceAsync = client.admin().organization().certificates()

        val certificateFuture = certificateServiceAsync.delete("certificate_id")

        val certificate = certificateFuture.get()
        certificate.validate()
    }

    @Test
    fun activate() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val certificateServiceAsync = client.admin().organization().certificates()

        val pageFuture =
            certificateServiceAsync.activate(
                CertificateActivateParams.builder().addCertificateId("cert_abc").build()
            )

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun deactivate() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val certificateServiceAsync = client.admin().organization().certificates()

        val pageFuture =
            certificateServiceAsync.deactivate(
                CertificateDeactivateParams.builder().addCertificateId("cert_abc").build()
            )

        val page = pageFuture.get()
        page.response().validate()
    }
}
