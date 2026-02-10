// File generated from our OpenAPI spec by Stainless.

package com.openai.models.skills

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SkillListParamsTest {

    @Test
    fun create() {
        SkillListParams.builder().after("after").limit(0L).order(SkillListParams.Order.ASC).build()
    }

    @Test
    fun queryParams() {
        val params =
            SkillListParams.builder()
                .after("after")
                .limit(0L)
                .order(SkillListParams.Order.ASC)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("limit", "0")
                    .put("order", "asc")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = SkillListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
