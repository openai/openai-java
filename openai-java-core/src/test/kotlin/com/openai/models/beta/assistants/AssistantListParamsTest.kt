// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.assistants

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AssistantListParamsTest {

    @Test
    fun create() {
        AssistantListParams.builder()
            .after("after")
            .before("before")
            .limit(0L)
            .order(AssistantListParams.Order.ASC)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            AssistantListParams.builder()
                .after("after")
                .before("before")
                .limit(0L)
                .order(AssistantListParams.Order.ASC)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("before", "before")
                    .put("limit", "0")
                    .put("order", "asc")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = AssistantListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
