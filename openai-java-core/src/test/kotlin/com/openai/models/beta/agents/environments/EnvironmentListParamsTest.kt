// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.environments

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EnvironmentListParamsTest {

    @Test
    fun create() {
        EnvironmentListParams.builder()
            .after("after")
            .limit(1L)
            .order(EnvironmentListParams.Order.ASC)
            .type(EnvironmentListParams.Type.OPENAI_HOSTED)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            EnvironmentListParams.builder()
                .after("after")
                .limit(1L)
                .order(EnvironmentListParams.Order.ASC)
                .type(EnvironmentListParams.Type.OPENAI_HOSTED)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("limit", "1")
                    .put("order", "asc")
                    .put("type", "openai_hosted")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = EnvironmentListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
