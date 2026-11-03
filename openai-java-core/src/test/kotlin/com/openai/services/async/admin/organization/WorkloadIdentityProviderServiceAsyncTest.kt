// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.admin.organization

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProviderCreateParams
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProviderUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class WorkloadIdentityProviderServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val workloadIdentityProviderServiceAsync =
            client.admin().organization().workloadIdentityProviders()

        val workloadIdentityProviderFuture =
            workloadIdentityProviderServiceAsync.create(
                WorkloadIdentityProviderCreateParams.builder()
                    .audience("x")
                    .issuer("x")
                    .name("x")
                    .addAttributeTransformation(
                        WorkloadIdentityProviderCreateParams.AttributeTransformation.builder()
                            .attribute("x")
                            .expression("x")
                            .build()
                    )
                    .description("description")
                    .enabled(true)
                    .discoveryVerification("discovery_url")
                    .build()
            )

        val workloadIdentityProvider = workloadIdentityProviderFuture.get()
        workloadIdentityProvider.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val workloadIdentityProviderServiceAsync =
            client.admin().organization().workloadIdentityProviders()

        val workloadIdentityProviderFuture = workloadIdentityProviderServiceAsync.retrieve("x")

        val workloadIdentityProvider = workloadIdentityProviderFuture.get()
        workloadIdentityProvider.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val workloadIdentityProviderServiceAsync =
            client.admin().organization().workloadIdentityProviders()

        val workloadIdentityProviderFuture =
            workloadIdentityProviderServiceAsync.update(
                WorkloadIdentityProviderUpdateParams.builder()
                    .workloadIdentityProviderId("x")
                    .addAttributeTransformation(
                        WorkloadIdentityProviderUpdateParams.AttributeTransformation.builder()
                            .attribute("x")
                            .expression("x")
                            .build()
                    )
                    .audience("x")
                    .description("description")
                    .enabled(true)
                    .issuer("x")
                    .name("x")
                    .verification(
                        WorkloadIdentityProviderUpdateParams.Verification.DiscoveryVerificationParam
                            .builder()
                            .discoveryUrl("discovery_url")
                            .build()
                    )
                    .build()
            )

        val workloadIdentityProvider = workloadIdentityProviderFuture.get()
        workloadIdentityProvider.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val workloadIdentityProviderServiceAsync =
            client.admin().organization().workloadIdentityProviders()

        val pageFuture = workloadIdentityProviderServiceAsync.list()

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
        val workloadIdentityProviderServiceAsync =
            client.admin().organization().workloadIdentityProviders()

        val workloadIdentityProviderDeletedFuture = workloadIdentityProviderServiceAsync.delete("x")

        val workloadIdentityProviderDeleted = workloadIdentityProviderDeletedFuture.get()
        workloadIdentityProviderDeleted.validate()
    }
}
