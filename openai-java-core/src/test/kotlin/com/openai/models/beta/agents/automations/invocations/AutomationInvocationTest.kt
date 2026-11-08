// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.automations.invocations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AutomationInvocationTest {

    @Test
    fun createAndRoundtrip() {
        val automationInvocation =
            AutomationInvocation.builder()
                .id("id")
                .automationId("automation_id")
                .createdAt(0L)
                .error(AutomationInvocation.Error.builder().code("code").message("message").build())
                .scheduledAt(0L)
                .sessionId("session_id")
                .skipReason(AutomationInvocation.SkipReason.PENDING_DELIVERY)
                .sourceManual()
                .status(AutomationInvocation.Status.QUEUED)
                .build()

        assertThat(automationInvocation.id()).isEqualTo("id")
        assertThat(automationInvocation.automationId()).isEqualTo("automation_id")
        assertThat(automationInvocation.createdAt()).isEqualTo(0L)
        assertThat(automationInvocation.error())
            .contains(AutomationInvocation.Error.builder().code("code").message("message").build())
        assertThat(automationInvocation.scheduledAt()).contains(0L)
        assertThat(automationInvocation.sessionId()).contains("session_id")
        assertThat(automationInvocation.skipReason())
            .contains(AutomationInvocation.SkipReason.PENDING_DELIVERY)
        assertThat(automationInvocation.source()).isEqualTo(AutomationInvocationSource.ofManual())
        assertThat(automationInvocation.status()).isEqualTo(AutomationInvocation.Status.QUEUED)

        val jsonMapper = jsonMapper()

        val roundtrippedAutomationInvocation =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(automationInvocation),
                jacksonTypeRef<AutomationInvocation>(),
            )

        assertThat(roundtrippedAutomationInvocation).isEqualTo(automationInvocation)
    }
}
