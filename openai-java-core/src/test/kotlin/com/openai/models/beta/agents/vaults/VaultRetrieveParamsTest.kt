// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.vaults

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VaultRetrieveParamsTest {

    @Test
    fun create() {
        VaultRetrieveParams.builder().vaultId("vault_id").build()
    }

    @Test
    fun pathParams() {
        val params = VaultRetrieveParams.builder().vaultId("vault_id").build()

        assertThat(params._pathParam(0)).isEqualTo("vault_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
