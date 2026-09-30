// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.externalstorage

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AwsExternalStorageProviderTest {

    @Test
    fun create() {
        val awsExternalStorageProvider =
            AwsExternalStorageProvider.builder()
                .accountId("account_id")
                .bucket("bucket")
                .externalId("external_id")
                .region("region")
                .roleArn("role_arn")
                .build()

        assertThat(awsExternalStorageProvider.accountId()).isEqualTo("account_id")
        assertThat(awsExternalStorageProvider.bucket()).isEqualTo("bucket")
        assertThat(awsExternalStorageProvider.externalId()).isEqualTo("external_id")
        assertThat(awsExternalStorageProvider.region()).isEqualTo("region")
        assertThat(awsExternalStorageProvider.roleArn()).isEqualTo("role_arn")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val awsExternalStorageProvider =
            AwsExternalStorageProvider.builder()
                .accountId("account_id")
                .bucket("bucket")
                .externalId("external_id")
                .region("region")
                .roleArn("role_arn")
                .build()

        val roundtrippedAwsExternalStorageProvider =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(awsExternalStorageProvider),
                jacksonTypeRef<AwsExternalStorageProvider>(),
            )

        assertThat(roundtrippedAwsExternalStorageProvider).isEqualTo(awsExternalStorageProvider)
    }
}
