// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.externalkeys

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExternalKeyListPageResponseTest {

    @Test
    fun createAndRoundtrip() {
        val externalKeyListPageResponse =
            ExternalKeyListPageResponse.builder()
                .addData(
                    ExternalKey.builder()
                        .id("id")
                        .addApiProjectId("string")
                        .createdAt(0L)
                        .name("name")
                        .object_("object")
                        .type("type")
                        .workspaceId("workspace_id")
                        .audience("audience")
                        .externalId("external_id")
                        .keyName("key_name")
                        .keyVersion("key_version")
                        .kmsArn("kms_arn")
                        .kmsKeyLocation("kms_key_location")
                        .kmsKeyName("kms_key_name")
                        .kmsKeyRingName("kms_key_ring_name")
                        .kmsKeyVersion("kms_key_version")
                        .kmsProjectId("kms_project_id")
                        .purpose(ExternalKey.Purpose.EKM)
                        .roleArn("role_arn")
                        .tenantId("tenant_id")
                        .vaultUri("vault_uri")
                        .workloadIdentityPoolId("workload_identity_pool_id")
                        .workloadIdentityProjectNumber("workload_identity_project_number")
                        .workloadIdentityProviderId("workload_identity_provider_id")
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(externalKeyListPageResponse.data())
            .containsExactly(
                ExternalKey.builder()
                    .id("id")
                    .addApiProjectId("string")
                    .createdAt(0L)
                    .name("name")
                    .object_("object")
                    .type("type")
                    .workspaceId("workspace_id")
                    .audience("audience")
                    .externalId("external_id")
                    .keyName("key_name")
                    .keyVersion("key_version")
                    .kmsArn("kms_arn")
                    .kmsKeyLocation("kms_key_location")
                    .kmsKeyName("kms_key_name")
                    .kmsKeyRingName("kms_key_ring_name")
                    .kmsKeyVersion("kms_key_version")
                    .kmsProjectId("kms_project_id")
                    .purpose(ExternalKey.Purpose.EKM)
                    .roleArn("role_arn")
                    .tenantId("tenant_id")
                    .vaultUri("vault_uri")
                    .workloadIdentityPoolId("workload_identity_pool_id")
                    .workloadIdentityProjectNumber("workload_identity_project_number")
                    .workloadIdentityProviderId("workload_identity_provider_id")
                    .build()
            )
        assertThat(externalKeyListPageResponse.firstId()).contains("first_id")
        assertThat(externalKeyListPageResponse.hasMore()).isEqualTo(true)
        assertThat(externalKeyListPageResponse.lastId()).contains("last_id")

        val jsonMapper = jsonMapper()

        val roundtrippedExternalKeyListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(externalKeyListPageResponse),
                jacksonTypeRef<ExternalKeyListPageResponse>(),
            )

        assertThat(roundtrippedExternalKeyListPageResponse).isEqualTo(externalKeyListPageResponse)
    }
}
