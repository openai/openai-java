// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.automations

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AutomationListParamsTest {

    @Test
    fun create() {
        AutomationListParams.builder()
            .after("after")
            .limit(1L)
            .order(AutomationListParams.Order.ASC)
            .sessionId("session_id")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            AutomationListParams.builder()
                .after("after")
                .limit(1L)
                .order(AutomationListParams.Order.ASC)
                .sessionId("session_id")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("limit", "1")
                    .put("order", "asc")
                    .put("session_id", "session_id")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = AutomationListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
