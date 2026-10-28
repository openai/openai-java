// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.externalkeys

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExternalKeyTest {

    @Test
    fun createAndRoundtrip() {
        val externalKey =
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

        assertThat(externalKey.id()).isEqualTo("id")
        assertThat(externalKey.apiProjectIds()).containsExactly("string")
        assertThat(externalKey.createdAt()).isEqualTo(0L)
        assertThat(externalKey.name()).isEqualTo("name")
        assertThat(externalKey.object_()).isEqualTo("object")
        assertThat(externalKey.type()).isEqualTo("type")
        assertThat(externalKey.workspaceId()).isEqualTo("workspace_id")
        assertThat(externalKey.audience()).contains("audience")
        assertThat(externalKey.externalId()).contains("external_id")
        assertThat(externalKey.keyName()).contains("key_name")
        assertThat(externalKey.keyVersion()).contains("key_version")
        assertThat(externalKey.kmsArn()).contains("kms_arn")
        assertThat(externalKey.kmsKeyLocation()).contains("kms_key_location")
        assertThat(externalKey.kmsKeyName()).contains("kms_key_name")
        assertThat(externalKey.kmsKeyRingName()).contains("kms_key_ring_name")
        assertThat(externalKey.kmsKeyVersion()).contains("kms_key_version")
        assertThat(externalKey.kmsProjectId()).contains("kms_project_id")
        assertThat(externalKey.purpose()).contains(ExternalKey.Purpose.EKM)
        assertThat(externalKey.roleArn()).contains("role_arn")
        assertThat(externalKey.tenantId()).contains("tenant_id")
        assertThat(externalKey.vaultUri()).contains("vault_uri")
        assertThat(externalKey.workloadIdentityPoolId()).contains("workload_identity_pool_id")
        assertThat(externalKey.workloadIdentityProjectNumber())
            .contains("workload_identity_project_number")
        assertThat(externalKey.workloadIdentityProviderId())
            .contains("workload_identity_provider_id")

        val jsonMapper = jsonMapper()

        val roundtrippedExternalKey =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(externalKey),
                jacksonTypeRef<ExternalKey>(),
            )

        assertThat(roundtrippedExternalKey).isEqualTo(externalKey)
    }
}
