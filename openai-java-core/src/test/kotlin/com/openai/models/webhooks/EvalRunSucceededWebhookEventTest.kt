// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EvalRunSucceededWebhookEventTest {

    @Test
    fun createAndRoundtrip() {
        val evalRunSucceededWebhookEvent =
            EvalRunSucceededWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(EvalRunSucceededWebhookEvent.Data.builder().id("id").build())
                .object_(EvalRunSucceededWebhookEvent.Object.EVENT)
                .build()

        assertThat(evalRunSucceededWebhookEvent.id()).contains("id")
        assertThat(evalRunSucceededWebhookEvent.createdAt()).contains(0L)
        assertThat(evalRunSucceededWebhookEvent.data())
            .contains(EvalRunSucceededWebhookEvent.Data.builder().id("id").build())
        assertThat(evalRunSucceededWebhookEvent.object_()).contains(JsonValue.from("event"))

        val jsonMapper = jsonMapper()

        val roundtrippedEvalRunSucceededWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(evalRunSucceededWebhookEvent),
                jacksonTypeRef<EvalRunSucceededWebhookEvent>(),
            )

        assertThat(roundtrippedEvalRunSucceededWebhookEvent).isEqualTo(evalRunSucceededWebhookEvent)
    }
}
