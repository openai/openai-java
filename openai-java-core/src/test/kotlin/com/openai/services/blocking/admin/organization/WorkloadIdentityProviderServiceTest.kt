// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.admin.organization

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProviderCreateParams
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProviderUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class WorkloadIdentityProviderServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val workloadIdentityProviderService =
            client.admin().organization().workloadIdentityProviders()

        val workloadIdentityProvider =
            workloadIdentityProviderService.create(
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

        workloadIdentityProvider.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val workloadIdentityProviderService =
            client.admin().organization().workloadIdentityProviders()

        val workloadIdentityProvider = workloadIdentityProviderService.retrieve("x")

        workloadIdentityProvider.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val workloadIdentityProviderService =
            client.admin().organization().workloadIdentityProviders()

        val workloadIdentityProvider =
            workloadIdentityProviderService.update(
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

        workloadIdentityProvider.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val workloadIdentityProviderService =
            client.admin().organization().workloadIdentityProviders()

        val page = workloadIdentityProviderService.list()

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
        val workloadIdentityProviderService =
            client.admin().organization().workloadIdentityProviders()

        val workloadIdentityProviderDeleted = workloadIdentityProviderService.delete("x")

        workloadIdentityProviderDeleted.validate()
    }
}
