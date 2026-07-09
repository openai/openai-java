// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaToolChoiceApplyPatchTest {

    @Test
    fun create() {
        val betaToolChoiceApplyPatch = BetaToolChoiceApplyPatch.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaToolChoiceApplyPatch = BetaToolChoiceApplyPatch.builder().build()

        val roundtrippedBetaToolChoiceApplyPatch =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaToolChoiceApplyPatch),
                jacksonTypeRef<BetaToolChoiceApplyPatch>(),
            )

        assertThat(roundtrippedBetaToolChoiceApplyPatch).isEqualTo(betaToolChoiceApplyPatch)
    }
}
