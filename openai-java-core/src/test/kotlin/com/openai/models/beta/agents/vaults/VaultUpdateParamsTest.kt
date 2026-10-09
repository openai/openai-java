// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.vaults

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VaultUpdateParamsTest {

    @Test
    fun create() {
        VaultUpdateParams.builder()
            .vaultId("vault_id")
            .metadata(
                VaultUpdateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
            .name("x")
            .build()
    }

    @Test
    fun pathParams() {
        val params = VaultUpdateParams.builder().vaultId("vault_id").build()

        assertThat(params._pathParam(0)).isEqualTo("vault_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            VaultUpdateParams.builder()
                .vaultId("vault_id")
                .metadata(
                    VaultUpdateParams.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .name("x")
                .build()

        val body = params._body()

        assertThat(body.metadata())
            .contains(
                VaultUpdateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(body.name()).contains("x")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = VaultUpdateParams.builder().vaultId("vault_id").build()

        val body = params._body()
    }
}
