// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseCompletedWebhookEventTest {

    @Test
    fun createAndRoundtrip() {
        val responseCompletedWebhookEvent =
            ResponseCompletedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(ResponseCompletedWebhookEvent.Data.builder().id("id").build())
                .object_(ResponseCompletedWebhookEvent.Object.EVENT)
                .build()

        assertThat(responseCompletedWebhookEvent.id()).contains("id")
        assertThat(responseCompletedWebhookEvent.createdAt()).contains(0L)
        assertThat(responseCompletedWebhookEvent.data())
            .contains(ResponseCompletedWebhookEvent.Data.builder().id("id").build())
        assertThat(responseCompletedWebhookEvent.object_()).contains(JsonValue.from("event"))

        val jsonMapper = jsonMapper()

        val roundtrippedResponseCompletedWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseCompletedWebhookEvent),
                jacksonTypeRef<ResponseCompletedWebhookEvent>(),
            )

        assertThat(roundtrippedResponseCompletedWebhookEvent)
            .isEqualTo(responseCompletedWebhookEvent)
    }
}
