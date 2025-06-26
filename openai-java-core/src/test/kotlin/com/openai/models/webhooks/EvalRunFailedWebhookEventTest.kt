// File generated from our OpenAPI spec by Stainless.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EvalRunFailedWebhookEventTest {

    @Test
    fun create() {
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
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val evalRunFailedWebhookEvent =
            EvalRunFailedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(EvalRunFailedWebhookEvent.Data.builder().id("id").build())
                .object_(EvalRunFailedWebhookEvent.Object.EVENT)
                .build()

        val roundtrippedEvalRunFailedWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(evalRunFailedWebhookEvent),
                jacksonTypeRef<EvalRunFailedWebhookEvent>(),
            )

        assertThat(roundtrippedEvalRunFailedWebhookEvent).isEqualTo(evalRunFailedWebhookEvent)
    }
}
