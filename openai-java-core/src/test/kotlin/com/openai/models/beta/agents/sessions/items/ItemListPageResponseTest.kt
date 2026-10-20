// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.sessions.items

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.beta.agents.AgentOutputItemStatus
import com.openai.models.beta.agents.AgentSessionItem
import com.openai.models.beta.agents.AgentSessionMessage
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ItemListPageResponseTest {

    @Test
    fun create() {
        val itemListPageResponse =
            ItemListPageResponse.builder()
                .addData(
                    AgentSessionMessage.builder()
                        .id("id")
                        .addInputTextContent("text")
                        .phase(AgentSessionMessage.Phase.COMMENTARY)
                        .role(AgentSessionMessage.Role.USER)
                        .status(AgentOutputItemStatus.IN_PROGRESS)
                        .turnId("turn_id")
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(itemListPageResponse.data())
            .containsExactly(
                AgentSessionItem.ofMessage(
                    AgentSessionMessage.builder()
                        .id("id")
                        .addInputTextContent("text")
                        .phase(AgentSessionMessage.Phase.COMMENTARY)
                        .role(AgentSessionMessage.Role.USER)
                        .status(AgentOutputItemStatus.IN_PROGRESS)
                        .turnId("turn_id")
                        .build()
                )
            )
        assertThat(itemListPageResponse.firstId()).contains("first_id")
        assertThat(itemListPageResponse.hasMore()).isEqualTo(true)
        assertThat(itemListPageResponse.lastId()).contains("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val itemListPageResponse =
            ItemListPageResponse.builder()
                .addData(
                    AgentSessionMessage.builder()
                        .id("id")
                        .addInputTextContent("text")
                        .phase(AgentSessionMessage.Phase.COMMENTARY)
                        .role(AgentSessionMessage.Role.USER)
                        .status(AgentOutputItemStatus.IN_PROGRESS)
                        .turnId("turn_id")
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        val roundtrippedItemListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(itemListPageResponse),
                jacksonTypeRef<ItemListPageResponse>(),
            )

        assertThat(roundtrippedItemListPageResponse).isEqualTo(itemListPageResponse)
    }
}
