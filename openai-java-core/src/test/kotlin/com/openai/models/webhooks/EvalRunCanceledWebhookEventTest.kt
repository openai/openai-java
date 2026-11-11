// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EvalRunCanceledWebhookEventTest {

    @Test
    fun createAndRoundtrip() {
        val evalRunCanceledWebhookEvent =
            EvalRunCanceledWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(EvalRunCanceledWebhookEvent.Data.builder().id("id").build())
                .object_(EvalRunCanceledWebhookEvent.Object.EVENT)
                .build()

        assertThat(evalRunCanceledWebhookEvent.id()).contains("id")
        assertThat(evalRunCanceledWebhookEvent.createdAt()).contains(0L)
        assertThat(evalRunCanceledWebhookEvent.data())
            .contains(EvalRunCanceledWebhookEvent.Data.builder().id("id").build())
        assertThat(evalRunCanceledWebhookEvent.object_()).contains(JsonValue.from("event"))

        val jsonMapper = jsonMapper()

        val roundtrippedEvalRunCanceledWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(evalRunCanceledWebhookEvent),
                jacksonTypeRef<EvalRunCanceledWebhookEvent>(),
            )

        assertThat(roundtrippedEvalRunCanceledWebhookEvent).isEqualTo(evalRunCanceledWebhookEvent)
    }
}
