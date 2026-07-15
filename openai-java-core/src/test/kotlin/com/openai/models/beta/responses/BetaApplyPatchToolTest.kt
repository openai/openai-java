// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaApplyPatchToolTest {

    @Test
    fun create() {
        val betaApplyPatchTool =
            BetaApplyPatchTool.builder()
                .addAllowedCaller(BetaApplyPatchTool.AllowedCaller.DIRECT)
                .build()

        assertThat(betaApplyPatchTool.allowedCallers().getOrNull())
            .containsExactly(BetaApplyPatchTool.AllowedCaller.DIRECT)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaApplyPatchTool =
            BetaApplyPatchTool.builder()
                .addAllowedCaller(BetaApplyPatchTool.AllowedCaller.DIRECT)
                .build()

        val roundtrippedBetaApplyPatchTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaApplyPatchTool),
                jacksonTypeRef<BetaApplyPatchTool>(),
            )

        assertThat(roundtrippedBetaApplyPatchTool).isEqualTo(betaApplyPatchTool)
    }
}
