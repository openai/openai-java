// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.automations.invocations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
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

        assertThat(automationInvocation.id()).contains("id")
        assertThat(automationInvocation.automationId()).contains("automation_id")
        assertThat(automationInvocation.createdAt()).contains(0L)
        assertThat(automationInvocation.error())
            .contains(AutomationInvocation.Error.builder().code("code").message("message").build())
        assertThat(automationInvocation.scheduledAt()).contains(0L)
        assertThat(automationInvocation.sessionId()).contains("session_id")
        assertThat(automationInvocation.skipReason()).contains(JsonValue.from("pending_delivery"))
        assertThat(automationInvocation.source()).contains(AutomationInvocationSource.ofManual())
        assertThat(automationInvocation.status()).contains(AutomationInvocation.Status.QUEUED)

        val jsonMapper = jsonMapper()

        val roundtrippedAutomationInvocation =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(automationInvocation),
                jacksonTypeRef<AutomationInvocation>(),
            )

        assertThat(roundtrippedAutomationInvocation).isEqualTo(automationInvocation)
    }
}
