// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.spendalerts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrganizationSpendAlertDeletedTest {

    @Test
    fun createAndRoundtrip() {
        val organizationSpendAlertDeleted =
            OrganizationSpendAlertDeleted.builder().id("id").deleted(true).build()

        assertThat(organizationSpendAlertDeleted.id()).isEqualTo("id")
        assertThat(organizationSpendAlertDeleted.deleted()).isEqualTo(true)

        val jsonMapper = jsonMapper()

        val roundtrippedOrganizationSpendAlertDeleted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(organizationSpendAlertDeleted),
                jacksonTypeRef<OrganizationSpendAlertDeleted>(),
            )

        assertThat(roundtrippedOrganizationSpendAlertDeleted)
            .isEqualTo(organizationSpendAlertDeleted)
    }
}
