// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.externalstorage

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExternalStorageCreateParamsTest {

    @Test
    fun create() {
        ExternalStorageCreateParams.builder()
            .projectId("proj_123")
            .provider(
                ExternalStorageCreateParams.Provider.Aws.builder()
                    .bucket("bucket")
                    .roleArn("role_arn")
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            ExternalStorageCreateParams.builder()
                .projectId("proj_123")
                .provider(
                    ExternalStorageCreateParams.Provider.Aws.builder()
                        .bucket("bucket")
                        .roleArn("role_arn")
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.projectId()).isEqualTo("proj_123")
        assertThat(body.provider())
            .isEqualTo(
                ExternalStorageCreateParams.Provider.ofAws(
                    ExternalStorageCreateParams.Provider.Aws.builder()
                        .bucket("bucket")
                        .roleArn("role_arn")
                        .build()
                )
            )
    }
}
