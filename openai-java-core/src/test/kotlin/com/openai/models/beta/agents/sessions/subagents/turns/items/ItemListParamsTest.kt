// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.sessions.subagents.turns.items

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ItemListParamsTest {

    @Test
    fun create() {
        ItemListParams.builder()
            .sessionId("session_id")
            .subagentId("subagent_id")
            .turnId("turn_id")
            .after("after")
            .limit(1L)
            .order(ItemListParams.Order.ASC)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ItemListParams.builder()
                .sessionId("session_id")
                .subagentId("subagent_id")
                .turnId("turn_id")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("session_id")
        assertThat(params._pathParam(1)).isEqualTo("subagent_id")
        assertThat(params._pathParam(2)).isEqualTo("turn_id")
        // out-of-bound path param
        assertThat(params._pathParam(3)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            ItemListParams.builder()
                .sessionId("session_id")
                .subagentId("subagent_id")
                .turnId("turn_id")
                .after("after")
                .limit(1L)
                .order(ItemListParams.Order.ASC)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("limit", "1")
                    .put("order", "asc")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            ItemListParams.builder()
                .sessionId("session_id")
                .subagentId("subagent_id")
                .turnId("turn_id")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
