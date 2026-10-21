// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EvalRunFailedWebhookEventTest {

    @Test
    fun createAndRoundtrip() {
        val evalRunFailedWebhookEvent =
            EvalRunFailedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(EvalRunFailedWebhookEvent.Data.builder().id("id").build())
                .object_(EvalRunFailedWebhookEvent.Object.EVENT)
                .build()

        assertThat(evalRunFailedWebhookEvent.id()).isEqualTo("id")
        assertThat(evalRunFailedWebhookEvent.createdAt()).isEqualTo(0L)
        assertThat(evalRunFailedWebhookEvent.data())
            .isEqualTo(EvalRunFailedWebhookEvent.Data.builder().id("id").build())
        assertThat(evalRunFailedWebhookEvent.object_())
            .contains(EvalRunFailedWebhookEvent.Object.EVENT)

        val jsonMapper = jsonMapper()

        val roundtrippedEvalRunFailedWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(evalRunFailedWebhookEvent),
                jacksonTypeRef<EvalRunFailedWebhookEvent>(),
            )

        assertThat(roundtrippedEvalRunFailedWebhookEvent).isEqualTo(evalRunFailedWebhookEvent)
    }
}
