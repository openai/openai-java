// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.sessions.artifacts

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ArtifactListParamsTest {

    @Test
    fun create() {
        ArtifactListParams.builder()
            .sessionId("session_id")
            .after("after")
            .environmentId("environment_id")
            .limit(1L)
            .order(ArtifactListParams.Order.ASC)
            .build()
    }

    @Test
    fun pathParams() {
        val params = ArtifactListParams.builder().sessionId("session_id").build()

        assertThat(params._pathParam(0)).isEqualTo("session_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            ArtifactListParams.builder()
                .sessionId("session_id")
                .after("after")
                .environmentId("environment_id")
                .limit(1L)
                .order(ArtifactListParams.Order.ASC)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("environment_id", "environment_id")
                    .put("limit", "1")
                    .put("order", "asc")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = ArtifactListParams.builder().sessionId("session_id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
