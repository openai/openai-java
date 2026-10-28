// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.externalkeys

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExternalKeyCreateParamsTest {

    @Test
    fun create() {
        ExternalKeyCreateParams.builder()
            .body(
                ExternalKeyCreateParams.Body.Aws.builder()
                    .externalId("external_id")
                    .kmsArn("kms_arn")
                    .name("name")
                    .roleArn("arn:aws:iam::732166991022:role/0*bWz\"J5bo7")
                    .purpose(ExternalKeyCreateParams.Body.Aws.Purpose.EKM)
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            ExternalKeyCreateParams.builder()
                .body(
                    ExternalKeyCreateParams.Body.Aws.builder()
                        .externalId("external_id")
                        .kmsArn("kms_arn")
                        .name("name")
                        .roleArn("arn:aws:iam::732166991022:role/0*bWz\"J5bo7")
                        .purpose(ExternalKeyCreateParams.Body.Aws.Purpose.EKM)
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                ExternalKeyCreateParams.Body.ofAws(
                    ExternalKeyCreateParams.Body.Aws.builder()
                        .externalId("external_id")
                        .kmsArn("kms_arn")
                        .name("name")
                        .roleArn("arn:aws:iam::732166991022:role/0*bWz\"J5bo7")
                        .purpose(ExternalKeyCreateParams.Body.Aws.Purpose.EKM)
                        .build()
                )
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ExternalKeyCreateParams.builder()
                .body(
                    ExternalKeyCreateParams.Body.Aws.builder()
                        .externalId("external_id")
                        .kmsArn("kms_arn")
                        .name("name")
                        .roleArn("arn:aws:iam::732166991022:role/0*bWz\"J5bo7")
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                ExternalKeyCreateParams.Body.ofAws(
                    ExternalKeyCreateParams.Body.Aws.builder()
                        .externalId("external_id")
                        .kmsArn("kms_arn")
                        .name("name")
                        .roleArn("arn:aws:iam::732166991022:role/0*bWz\"J5bo7")
                        .build()
                )
            )
    }
}
