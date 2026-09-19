// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.externalstorage

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExternalStorageConfigurationTest {

    @Test
    fun create() {
        val externalStorageConfiguration =
            ExternalStorageConfiguration.builder()
                .id("id")
                .createdAt(0L)
                .geography("geography")
                .projectId("project_id")
                .provider(
                    AwsExternalStorageProvider.builder()
                        .accountId("account_id")
                        .bucket("bucket")
                        .externalId("external_id")
                        .region("region")
                        .roleArn("role_arn")
                        .build()
                )
                .status(ExternalStorageConfiguration.Status.PENDING)
                .build()

        assertThat(externalStorageConfiguration.id()).isEqualTo("id")
        assertThat(externalStorageConfiguration.createdAt()).isEqualTo(0L)
        assertThat(externalStorageConfiguration.geography()).isEqualTo("geography")
        assertThat(externalStorageConfiguration.projectId()).isEqualTo("project_id")
        assertThat(externalStorageConfiguration.provider())
            .isEqualTo(
                ExternalStorageConfiguration.Provider.ofAws(
                    AwsExternalStorageProvider.builder()
                        .accountId("account_id")
                        .bucket("bucket")
                        .externalId("external_id")
                        .region("region")
                        .roleArn("role_arn")
                        .build()
                )
            )
        assertThat(externalStorageConfiguration.status())
            .isEqualTo(ExternalStorageConfiguration.Status.PENDING)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val externalStorageConfiguration =
            ExternalStorageConfiguration.builder()
                .id("id")
                .createdAt(0L)
                .geography("geography")
                .projectId("project_id")
                .provider(
                    AwsExternalStorageProvider.builder()
                        .accountId("account_id")
                        .bucket("bucket")
                        .externalId("external_id")
                        .region("region")
                        .roleArn("role_arn")
                        .build()
                )
                .status(ExternalStorageConfiguration.Status.PENDING)
                .build()

        val roundtrippedExternalStorageConfiguration =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(externalStorageConfiguration),
                jacksonTypeRef<ExternalStorageConfiguration>(),
            )

        assertThat(roundtrippedExternalStorageConfiguration).isEqualTo(externalStorageConfiguration)
    }
}
