// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.externalstorage

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GcpExternalStorageProviderTest {

    @Test
    fun createAndRoundtrip() {
        val gcpExternalStorageProvider =
            GcpExternalStorageProvider.builder()
                .audience("audience")
                .bucket("bucket")
                .region("region")
                .workloadIdentityPoolId("workload_identity_pool_id")
                .workloadIdentityProjectNumber("workload_identity_project_number")
                .workloadIdentityProviderId("workload_identity_provider_id")
                .build()

        assertThat(gcpExternalStorageProvider.audience()).contains("audience")
        assertThat(gcpExternalStorageProvider.bucket()).contains("bucket")
        assertThat(gcpExternalStorageProvider.region()).contains("region")
        assertThat(gcpExternalStorageProvider.workloadIdentityPoolId())
            .contains("workload_identity_pool_id")
        assertThat(gcpExternalStorageProvider.workloadIdentityProjectNumber())
            .contains("workload_identity_project_number")
        assertThat(gcpExternalStorageProvider.workloadIdentityProviderId())
            .contains("workload_identity_provider_id")

        val jsonMapper = jsonMapper()

        val roundtrippedGcpExternalStorageProvider =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(gcpExternalStorageProvider),
                jacksonTypeRef<GcpExternalStorageProvider>(),
            )

        assertThat(roundtrippedGcpExternalStorageProvider).isEqualTo(gcpExternalStorageProvider)
    }
}
