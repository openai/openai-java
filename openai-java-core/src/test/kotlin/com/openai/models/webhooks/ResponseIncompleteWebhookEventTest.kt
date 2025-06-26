// File generated from our OpenAPI spec by Stainless.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseIncompleteWebhookEventTest {

    @Test
    fun create() {
        val responseIncompleteWebhookEvent =
            ResponseIncompleteWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(ResponseIncompleteWebhookEvent.Data.builder().id("id").build())
                .object_(ResponseIncompleteWebhookEvent.Object.EVENT)
                .build()

        assertThat(responseIncompleteWebhookEvent.id()).isEqualTo("id")
        assertThat(responseIncompleteWebhookEvent.createdAt()).isEqualTo(0L)
        assertThat(responseIncompleteWebhookEvent.data())
            .isEqualTo(ResponseIncompleteWebhookEvent.Data.builder().id("id").build())
        assertThat(responseIncompleteWebhookEvent.object_())
            .contains(ResponseIncompleteWebhookEvent.Object.EVENT)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseIncompleteWebhookEvent =
            ResponseIncompleteWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(ResponseIncompleteWebhookEvent.Data.builder().id("id").build())
                .object_(ResponseIncompleteWebhookEvent.Object.EVENT)
                .build()

        val roundtrippedResponseIncompleteWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseIncompleteWebhookEvent),
                jacksonTypeRef<ResponseIncompleteWebhookEvent>(),
            )

        assertThat(roundtrippedResponseIncompleteWebhookEvent)
            .isEqualTo(responseIncompleteWebhookEvent)
    }
}
