// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.externalstorage

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExternalStorageListPageResponseTest {

    @Test
    fun create() {
        val externalStorageListPageResponse =
            ExternalStorageListPageResponse.builder()
                .addData(
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
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(externalStorageListPageResponse.data())
            .containsExactly(
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
            )
        assertThat(externalStorageListPageResponse.firstId()).contains("first_id")
        assertThat(externalStorageListPageResponse.hasMore()).isEqualTo(true)
        assertThat(externalStorageListPageResponse.lastId()).contains("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val externalStorageListPageResponse =
            ExternalStorageListPageResponse.builder()
                .addData(
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
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        val roundtrippedExternalStorageListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(externalStorageListPageResponse),
                jacksonTypeRef<ExternalStorageListPageResponse>(),
            )

        assertThat(roundtrippedExternalStorageListPageResponse)
            .isEqualTo(externalStorageListPageResponse)
    }
}
