// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.workloadidentityproviders.federationrules

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FederationRuleDeletedTest {

    @Test
    fun createAndRoundtrip() {
        val federationRuleDeleted = FederationRuleDeleted.builder().id("id").deleted(true).build()

        assertThat(federationRuleDeleted.id()).isEqualTo("id")
        assertThat(federationRuleDeleted.deleted()).isEqualTo(true)

        val jsonMapper = jsonMapper()

        val roundtrippedFederationRuleDeleted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(federationRuleDeleted),
                jacksonTypeRef<FederationRuleDeleted>(),
            )

        assertThat(roundtrippedFederationRuleDeleted).isEqualTo(federationRuleDeleted)
    }
}
