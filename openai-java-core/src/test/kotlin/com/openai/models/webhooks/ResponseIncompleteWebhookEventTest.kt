// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseIncompleteWebhookEventTest {

    @Test
    fun createAndRoundtrip() {
        val responseIncompleteWebhookEvent =
            ResponseIncompleteWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(ResponseIncompleteWebhookEvent.Data.builder().id("id").build())
                .object_(ResponseIncompleteWebhookEvent.Object.EVENT)
                .build()

        assertThat(responseIncompleteWebhookEvent.id()).contains("id")
        assertThat(responseIncompleteWebhookEvent.createdAt()).contains(0L)
        assertThat(responseIncompleteWebhookEvent.data())
            .contains(ResponseIncompleteWebhookEvent.Data.builder().id("id").build())
        assertThat(responseIncompleteWebhookEvent.object_()).contains(JsonValue.from("event"))

        val jsonMapper = jsonMapper()

        val roundtrippedResponseIncompleteWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseIncompleteWebhookEvent),
                jacksonTypeRef<ResponseIncompleteWebhookEvent>(),
            )

        assertThat(roundtrippedResponseIncompleteWebhookEvent)
            .isEqualTo(responseIncompleteWebhookEvent)
    }
}
