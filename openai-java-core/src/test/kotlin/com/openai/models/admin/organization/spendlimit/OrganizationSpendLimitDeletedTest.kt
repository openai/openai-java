// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.spendlimit

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrganizationSpendLimitDeletedTest {

    @Test
    fun createAndRoundtrip() {
        val organizationSpendLimitDeleted =
            OrganizationSpendLimitDeleted.builder().deleted(true).build()

        assertThat(organizationSpendLimitDeleted.deleted()).isEqualTo(true)

        val jsonMapper = jsonMapper()

        val roundtrippedOrganizationSpendLimitDeleted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(organizationSpendLimitDeleted),
                jacksonTypeRef<OrganizationSpendLimitDeleted>(),
            )

        assertThat(roundtrippedOrganizationSpendLimitDeleted)
            .isEqualTo(organizationSpendLimitDeleted)
    }
}
