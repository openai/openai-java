// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaToolChoiceMcpTest {

    @Test
    fun create() {
        val betaToolChoiceMcp =
            BetaToolChoiceMcp.builder().serverLabel("server_label").name("name").build()

        assertThat(betaToolChoiceMcp.serverLabel()).isEqualTo("server_label")
        assertThat(betaToolChoiceMcp.name()).contains("name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaToolChoiceMcp =
            BetaToolChoiceMcp.builder().serverLabel("server_label").name("name").build()

        val roundtrippedBetaToolChoiceMcp =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaToolChoiceMcp),
                jacksonTypeRef<BetaToolChoiceMcp>(),
            )

        assertThat(roundtrippedBetaToolChoiceMcp).isEqualTo(betaToolChoiceMcp)
    }
}
