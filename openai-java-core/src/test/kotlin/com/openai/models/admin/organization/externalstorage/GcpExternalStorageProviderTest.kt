// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.externalstorage

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GcpExternalStorageProviderTest {

    @Test
    fun create() {
        val gcpExternalStorageProvider =
            GcpExternalStorageProvider.builder()
                .audience("audience")
                .bucket("bucket")
                .region("region")
                .workloadIdentityPoolId("workload_identity_pool_id")
                .workloadIdentityProjectNumber("workload_identity_project_number")
                .workloadIdentityProviderId("workload_identity_provider_id")
                .build()

        assertThat(gcpExternalStorageProvider.audience()).isEqualTo("audience")
        assertThat(gcpExternalStorageProvider.bucket()).isEqualTo("bucket")
        assertThat(gcpExternalStorageProvider.region()).isEqualTo("region")
        assertThat(gcpExternalStorageProvider.workloadIdentityPoolId())
            .isEqualTo("workload_identity_pool_id")
        assertThat(gcpExternalStorageProvider.workloadIdentityProjectNumber())
            .isEqualTo("workload_identity_project_number")
        assertThat(gcpExternalStorageProvider.workloadIdentityProviderId())
            .isEqualTo("workload_identity_provider_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val gcpExternalStorageProvider =
            GcpExternalStorageProvider.builder()
                .audience("audience")
                .bucket("bucket")
                .region("region")
                .workloadIdentityPoolId("workload_identity_pool_id")
                .workloadIdentityProjectNumber("workload_identity_project_number")
                .workloadIdentityProviderId("workload_identity_provider_id")
                .build()

        val roundtrippedGcpExternalStorageProvider =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(gcpExternalStorageProvider),
                jacksonTypeRef<GcpExternalStorageProvider>(),
            )

        assertThat(roundtrippedGcpExternalStorageProvider).isEqualTo(gcpExternalStorageProvider)
    }
}
