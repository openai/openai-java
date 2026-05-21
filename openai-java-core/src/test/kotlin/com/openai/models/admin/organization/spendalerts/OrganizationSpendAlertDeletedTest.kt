// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.spendalerts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrganizationSpendAlertDeletedTest {

    @Test
    fun create() {
        val organizationSpendAlertDeleted =
            OrganizationSpendAlertDeleted.builder().id("id").deleted(true).build()

        assertThat(organizationSpendAlertDeleted.id()).isEqualTo("id")
        assertThat(organizationSpendAlertDeleted.deleted()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val organizationSpendAlertDeleted =
            OrganizationSpendAlertDeleted.builder().id("id").deleted(true).build()

        val roundtrippedOrganizationSpendAlertDeleted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(organizationSpendAlertDeleted),
                jacksonTypeRef<OrganizationSpendAlertDeleted>(),
            )

        assertThat(roundtrippedOrganizationSpendAlertDeleted)
            .isEqualTo(organizationSpendAlertDeleted)
    }
}
