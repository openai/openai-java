// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.workloadidentityproviders

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WorkloadIdentityProviderUpdateParamsTest {

    @Test
    fun create() {
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
    }

    @Test
    fun pathParams() {
        val params =
            WorkloadIdentityProviderUpdateParams.builder().workloadIdentityProviderId("x").build()

        assertThat(params._pathParam(0)).isEqualTo("x")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
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

        val body = params._body()

        assertThat(body.attributeTransformations().getOrNull())
            .containsExactly(
                WorkloadIdentityProviderUpdateParams.AttributeTransformation.builder()
                    .attribute("x")
                    .expression("x")
                    .build()
            )
        assertThat(body.audience()).contains("x")
        assertThat(body.description()).contains("description")
        assertThat(body.enabled()).contains(true)
        assertThat(body.issuer()).contains("x")
        assertThat(body.name()).contains("x")
        assertThat(body.verification())
            .contains(
                WorkloadIdentityProviderUpdateParams.Verification.ofDiscoveryVerificationParam(
                    WorkloadIdentityProviderUpdateParams.Verification.DiscoveryVerificationParam
                        .builder()
                        .discoveryUrl("discovery_url")
                        .build()
                )
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            WorkloadIdentityProviderUpdateParams.builder().workloadIdentityProviderId("x").build()

        val body = params._body()
    }
}
