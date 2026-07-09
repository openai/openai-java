// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaContainerNetworkPolicyDisabledTest {

    @Test
    fun create() {
        val betaContainerNetworkPolicyDisabled =
            BetaContainerNetworkPolicyDisabled.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaContainerNetworkPolicyDisabled =
            BetaContainerNetworkPolicyDisabled.builder().build()

        val roundtrippedBetaContainerNetworkPolicyDisabled =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaContainerNetworkPolicyDisabled),
                jacksonTypeRef<BetaContainerNetworkPolicyDisabled>(),
            )

        assertThat(roundtrippedBetaContainerNetworkPolicyDisabled)
            .isEqualTo(betaContainerNetworkPolicyDisabled)
    }
}
