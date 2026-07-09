// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaCustomToolTest {

    @Test
    fun create() {
        val betaCustomTool =
            BetaCustomTool.builder()
                .name("name")
                .addAllowedCaller(BetaCustomTool.AllowedCaller.DIRECT)
                .deferLoading(true)
                .description("description")
                .formatText()
                .build()

        assertThat(betaCustomTool.name()).isEqualTo("name")
        assertThat(betaCustomTool.allowedCallers().getOrNull())
            .containsExactly(BetaCustomTool.AllowedCaller.DIRECT)
        assertThat(betaCustomTool.deferLoading()).contains(true)
        assertThat(betaCustomTool.description()).contains("description")
        assertThat(betaCustomTool.format()).contains(BetaCustomTool.Format.ofText())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaCustomTool =
            BetaCustomTool.builder()
                .name("name")
                .addAllowedCaller(BetaCustomTool.AllowedCaller.DIRECT)
                .deferLoading(true)
                .description("description")
                .formatText()
                .build()

        val roundtrippedBetaCustomTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaCustomTool),
                jacksonTypeRef<BetaCustomTool>(),
            )

        assertThat(roundtrippedBetaCustomTool).isEqualTo(betaCustomTool)
    }
}
