// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.vaults

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VaultListParamsTest {

    @Test
    fun create() {
        VaultListParams.builder().after("after").limit(0L).order(VaultListParams.Order.ASC).build()
    }

    @Test
    fun queryParams() {
        val params =
            VaultListParams.builder()
                .after("after")
                .limit(0L)
                .order(VaultListParams.Order.ASC)
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
        val params = VaultListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
