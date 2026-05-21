// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.dataretention

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrganizationDataRetentionTest {

    @Test
    fun create() {
        val organizationDataRetention =
            OrganizationDataRetention.builder()
                .type(OrganizationDataRetention.Type.ZERO_DATA_RETENTION)
                .build()

        assertThat(organizationDataRetention.type())
            .isEqualTo(OrganizationDataRetention.Type.ZERO_DATA_RETENTION)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val organizationDataRetention =
            OrganizationDataRetention.builder()
                .type(OrganizationDataRetention.Type.ZERO_DATA_RETENTION)
                .build()

        val roundtrippedOrganizationDataRetention =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(organizationDataRetention),
                jacksonTypeRef<OrganizationDataRetention>(),
            )

        assertThat(roundtrippedOrganizationDataRetention).isEqualTo(organizationDataRetention)
    }
}
