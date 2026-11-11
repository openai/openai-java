// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.externalstorage

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AwsExternalStorageProviderTest {

    @Test
    fun createAndRoundtrip() {
        val awsExternalStorageProvider =
            AwsExternalStorageProvider.builder()
                .accountId("account_id")
                .bucket("bucket")
                .externalId("external_id")
                .region("region")
                .roleArn("role_arn")
                .build()

        assertThat(awsExternalStorageProvider.accountId()).contains("account_id")
        assertThat(awsExternalStorageProvider.bucket()).contains("bucket")
        assertThat(awsExternalStorageProvider.externalId()).contains("external_id")
        assertThat(awsExternalStorageProvider.region()).contains("region")
        assertThat(awsExternalStorageProvider.roleArn()).contains("role_arn")

        val jsonMapper = jsonMapper()

        val roundtrippedAwsExternalStorageProvider =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(awsExternalStorageProvider),
                jacksonTypeRef<AwsExternalStorageProvider>(),
            )

        assertThat(roundtrippedAwsExternalStorageProvider).isEqualTo(awsExternalStorageProvider)
    }
}
