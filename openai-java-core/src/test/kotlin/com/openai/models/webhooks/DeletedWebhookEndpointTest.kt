// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DeletedWebhookEndpointTest {

    @Test
    fun create() {
        val deletedWebhookEndpoint = DeletedWebhookEndpoint.builder().id("id").deleted(true).build()

        assertThat(deletedWebhookEndpoint.id()).isEqualTo("id")
        assertThat(deletedWebhookEndpoint.deleted()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val deletedWebhookEndpoint = DeletedWebhookEndpoint.builder().id("id").deleted(true).build()

        val roundtrippedDeletedWebhookEndpoint =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(deletedWebhookEndpoint),
                jacksonTypeRef<DeletedWebhookEndpoint>(),
            )

        assertThat(roundtrippedDeletedWebhookEndpoint).isEqualTo(deletedWebhookEndpoint)
    }
}
