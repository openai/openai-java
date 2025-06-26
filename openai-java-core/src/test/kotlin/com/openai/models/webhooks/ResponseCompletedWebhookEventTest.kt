// File generated from our OpenAPI spec by Stainless.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseCompletedWebhookEventTest {

    @Test
    fun create() {
        val responseCompletedWebhookEvent =
            ResponseCompletedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(ResponseCompletedWebhookEvent.Data.builder().id("id").build())
                .object_(ResponseCompletedWebhookEvent.Object.EVENT)
                .build()

        assertThat(responseCompletedWebhookEvent.id()).isEqualTo("id")
        assertThat(responseCompletedWebhookEvent.createdAt()).isEqualTo(0L)
        assertThat(responseCompletedWebhookEvent.data())
            .isEqualTo(ResponseCompletedWebhookEvent.Data.builder().id("id").build())
        assertThat(responseCompletedWebhookEvent.object_())
            .contains(ResponseCompletedWebhookEvent.Object.EVENT)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseCompletedWebhookEvent =
            ResponseCompletedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(ResponseCompletedWebhookEvent.Data.builder().id("id").build())
                .object_(ResponseCompletedWebhookEvent.Object.EVENT)
                .build()

        val roundtrippedResponseCompletedWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseCompletedWebhookEvent),
                jacksonTypeRef<ResponseCompletedWebhookEvent>(),
            )

        assertThat(roundtrippedResponseCompletedWebhookEvent)
            .isEqualTo(responseCompletedWebhookEvent)
    }
}
