// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.automations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AutomationDeletedTest {

    @Test
    fun createAndRoundtrip() {
        val automationDeleted = AutomationDeleted.builder().id("id").deleted(true).build()

        assertThat(automationDeleted.id()).isEqualTo("id")
        assertThat(automationDeleted.deleted()).isEqualTo(true)

        val jsonMapper = jsonMapper()

        val roundtrippedAutomationDeleted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(automationDeleted),
                jacksonTypeRef<AutomationDeleted>(),
            )

        assertThat(roundtrippedAutomationDeleted).isEqualTo(automationDeleted)
    }
}
