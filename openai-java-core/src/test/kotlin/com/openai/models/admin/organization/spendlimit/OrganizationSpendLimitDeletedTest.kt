// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.spendlimit

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrganizationSpendLimitDeletedTest {

    @Test
    fun create() {
        val organizationSpendLimitDeleted =
            OrganizationSpendLimitDeleted.builder().deleted(true).build()

        assertThat(organizationSpendLimitDeleted.deleted()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val organizationSpendLimitDeleted =
            OrganizationSpendLimitDeleted.builder().deleted(true).build()

        val roundtrippedOrganizationSpendLimitDeleted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(organizationSpendLimitDeleted),
                jacksonTypeRef<OrganizationSpendLimitDeleted>(),
            )

        assertThat(roundtrippedOrganizationSpendLimitDeleted)
            .isEqualTo(organizationSpendLimitDeleted)
    }
}
