// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookEventTypeListTest {

    @Test
    fun create() {
        val webhookEventTypeList = WebhookEventTypeList.builder().addData("string").build()

        assertThat(webhookEventTypeList.data()).containsExactly("string")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookEventTypeList = WebhookEventTypeList.builder().addData("string").build()

        val roundtrippedWebhookEventTypeList =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookEventTypeList),
                jacksonTypeRef<WebhookEventTypeList>(),
            )

        assertThat(roundtrippedWebhookEventTypeList).isEqualTo(webhookEventTypeList)
    }
}
