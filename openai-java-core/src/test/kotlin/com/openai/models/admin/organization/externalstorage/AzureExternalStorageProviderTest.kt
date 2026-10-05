// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.externalstorage

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AzureExternalStorageProviderTest {

    @Test
    fun create() {
        val azureExternalStorageProvider =
            AzureExternalStorageProvider.builder()
                .accountName("account_name")
                .container("container")
                .region("region")
                .resourceGroup("resource_group")
                .subscriptionId("subscription_id")
                .tenantId("tenant_id")
                .build()

        assertThat(azureExternalStorageProvider.accountName()).isEqualTo("account_name")
        assertThat(azureExternalStorageProvider.container()).isEqualTo("container")
        assertThat(azureExternalStorageProvider.region()).isEqualTo("region")
        assertThat(azureExternalStorageProvider.resourceGroup()).isEqualTo("resource_group")
        assertThat(azureExternalStorageProvider.subscriptionId()).isEqualTo("subscription_id")
        assertThat(azureExternalStorageProvider.tenantId()).isEqualTo("tenant_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val azureExternalStorageProvider =
            AzureExternalStorageProvider.builder()
                .accountName("account_name")
                .container("container")
                .region("region")
                .resourceGroup("resource_group")
                .subscriptionId("subscription_id")
                .tenantId("tenant_id")
                .build()

        val roundtrippedAzureExternalStorageProvider =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(azureExternalStorageProvider),
                jacksonTypeRef<AzureExternalStorageProvider>(),
            )

        assertThat(roundtrippedAzureExternalStorageProvider).isEqualTo(azureExternalStorageProvider)
    }
}
