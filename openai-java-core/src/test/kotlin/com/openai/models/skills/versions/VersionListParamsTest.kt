// File generated from our OpenAPI spec by Stainless.

package com.openai.models.skills.versions

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VersionListParamsTest {

    @Test
    fun create() {
        VersionListParams.builder()
            .skillId("skill_123")
            .after("skillver_123")
            .limit(0L)
            .order(VersionListParams.Order.ASC)
            .build()
    }

    @Test
    fun pathParams() {
        val params = VersionListParams.builder().skillId("skill_123").build()

        assertThat(params._pathParam(0)).isEqualTo("skill_123")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            VersionListParams.builder()
                .skillId("skill_123")
                .after("skillver_123")
                .limit(0L)
                .order(VersionListParams.Order.ASC)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "skillver_123")
                    .put("limit", "0")
                    .put("order", "asc")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = VersionListParams.builder().skillId("skill_123").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
