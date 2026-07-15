// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization.projects

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.admin.organization.projects.certificates.CertificateActivateParams
import com.openai.models.admin.organization.projects.certificates.CertificateDeactivateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class CertificateServiceAsyncTest {

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val certificateServiceAsync = client.admin().organization().projects().certificates()

        val pageFuture = certificateServiceAsync.list("project_id")

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun activate() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val certificateServiceAsync = client.admin().organization().projects().certificates()

        val pageFuture =
            certificateServiceAsync.activate(
                CertificateActivateParams.builder()
                    .projectId("project_id")
                    .addCertificateId("cert_abc")
                    .build()
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
        val certificateServiceAsync = client.admin().organization().projects().certificates()

        val pageFuture =
            certificateServiceAsync.deactivate(
                CertificateDeactivateParams.builder()
                    .projectId("project_id")
                    .addCertificateId("cert_abc")
                    .build()
            )

        val page = pageFuture.get()
        page.response().validate()
    }
}
