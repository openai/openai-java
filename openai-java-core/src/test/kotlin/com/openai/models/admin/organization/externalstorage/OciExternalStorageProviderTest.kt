// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.externalstorage

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OciExternalStorageProviderTest {

    @Test
    fun createAndRoundtrip() {
        val ociExternalStorageProvider =
            OciExternalStorageProvider.builder()
                .bucket("bucket")
                .region("region")
                .tenancyOcid("tenancy_ocid")
                .build()

        assertThat(ociExternalStorageProvider.bucket()).isEqualTo("bucket")
        assertThat(ociExternalStorageProvider.region()).isEqualTo("region")
        assertThat(ociExternalStorageProvider.tenancyOcid()).isEqualTo("tenancy_ocid")

        val jsonMapper = jsonMapper()

        val roundtrippedOciExternalStorageProvider =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(ociExternalStorageProvider),
                jacksonTypeRef<OciExternalStorageProvider>(),
            )

        assertThat(roundtrippedOciExternalStorageProvider).isEqualTo(ociExternalStorageProvider)
    }
}
