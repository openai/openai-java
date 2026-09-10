// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.vaults.credentials

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CredentialListParamsTest {

    @Test
    fun create() {
        CredentialListParams.builder()
            .vaultId("vault_id")
            .after("after")
            .limit(0L)
            .order(CredentialListParams.Order.ASC)
            .build()
    }

    @Test
    fun pathParams() {
        val params = CredentialListParams.builder().vaultId("vault_id").build()

        assertThat(params._pathParam(0)).isEqualTo("vault_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            CredentialListParams.builder()
                .vaultId("vault_id")
                .after("after")
                .limit(0L)
                .order(CredentialListParams.Order.ASC)
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
        val params = CredentialListParams.builder().vaultId("vault_id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
