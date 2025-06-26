// File generated from our OpenAPI spec by Stainless.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EvalRunCanceledWebhookEventTest {

    @Test
    fun create() {
        val evalRunCanceledWebhookEvent =
            EvalRunCanceledWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(EvalRunCanceledWebhookEvent.Data.builder().id("id").build())
                .object_(EvalRunCanceledWebhookEvent.Object.EVENT)
                .build()

        assertThat(evalRunCanceledWebhookEvent.id()).isEqualTo("id")
        assertThat(evalRunCanceledWebhookEvent.createdAt()).isEqualTo(0L)
        assertThat(evalRunCanceledWebhookEvent.data())
            .isEqualTo(EvalRunCanceledWebhookEvent.Data.builder().id("id").build())
        assertThat(evalRunCanceledWebhookEvent.object_())
            .contains(EvalRunCanceledWebhookEvent.Object.EVENT)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val evalRunCanceledWebhookEvent =
            EvalRunCanceledWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(EvalRunCanceledWebhookEvent.Data.builder().id("id").build())
                .object_(EvalRunCanceledWebhookEvent.Object.EVENT)
                .build()

        val roundtrippedEvalRunCanceledWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(evalRunCanceledWebhookEvent),
                jacksonTypeRef<EvalRunCanceledWebhookEvent>(),
            )

        assertThat(roundtrippedEvalRunCanceledWebhookEvent).isEqualTo(evalRunCanceledWebhookEvent)
    }
}
