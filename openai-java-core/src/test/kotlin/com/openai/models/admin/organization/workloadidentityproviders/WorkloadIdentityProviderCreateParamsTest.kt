// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.workloadidentityproviders

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WorkloadIdentityProviderCreateParamsTest {

    @Test
    fun create() {
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
    }

    @Test
    fun body() {
        val params =
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

        val body = params._body()

        assertThat(body.audienceOrThrow()).isEqualTo("x")
        assertThat(body.issuerOrThrow()).isEqualTo("x")
        assertThat(body.nameOrThrow()).isEqualTo("x")
        assertThat(body.attributeTransformations().getOrNull())
            .containsExactly(
                WorkloadIdentityProviderCreateParams.AttributeTransformation.builder()
                    .attribute("x")
                    .expression("x")
                    .build()
            )
        assertThat(body.description()).contains("description")
        assertThat(body.enabled()).contains(true)
        assertThat(body.verification())
            .contains(
                WorkloadIdentityProviderCreateParams.Verification.ofDiscovery(
                    WorkloadIdentityProviderCreateParams.Verification.Discovery.builder()
                        .discoveryUrl("discovery_url")
                        .build()
                )
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            WorkloadIdentityProviderCreateParams.builder()
                .audience("x")
                .issuer("x")
                .name("x")
                .build()

        val body = params._body()

        assertThat(body.audienceOrThrow()).isEqualTo("x")
        assertThat(body.issuerOrThrow()).isEqualTo("x")
        assertThat(body.nameOrThrow()).isEqualTo("x")
    }
}
