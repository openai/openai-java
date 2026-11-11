// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.automations.invocations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InvocationListPageResponseTest {

    @Test
    fun createAndRoundtrip() {
        val invocationListPageResponse =
            InvocationListPageResponse.builder()
                .addData(
                    AutomationInvocation.builder()
                        .id("id")
                        .automationId("automation_id")
                        .createdAt(0L)
                        .error(
                            AutomationInvocation.Error.builder()
                                .code("code")
                                .message("message")
                                .build()
                        )
                        .scheduledAt(0L)
                        .sessionId("session_id")
                        .skipReason(AutomationInvocation.SkipReason.PENDING_DELIVERY)
                        .sourceManual()
                        .status(AutomationInvocation.Status.QUEUED)
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(invocationListPageResponse.data().getOrNull())
            .containsExactly(
                AutomationInvocation.builder()
                    .id("id")
                    .automationId("automation_id")
                    .createdAt(0L)
                    .error(
                        AutomationInvocation.Error.builder().code("code").message("message").build()
                    )
                    .scheduledAt(0L)
                    .sessionId("session_id")
                    .skipReason(AutomationInvocation.SkipReason.PENDING_DELIVERY)
                    .sourceManual()
                    .status(AutomationInvocation.Status.QUEUED)
                    .build()
            )
        assertThat(invocationListPageResponse.firstId()).contains("first_id")
        assertThat(invocationListPageResponse.hasMore()).contains(true)
        assertThat(invocationListPageResponse.lastId()).contains("last_id")

        val jsonMapper = jsonMapper()

        val roundtrippedInvocationListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(invocationListPageResponse),
                jacksonTypeRef<InvocationListPageResponse>(),
            )

        assertThat(roundtrippedInvocationListPageResponse).isEqualTo(invocationListPageResponse)
    }
}
