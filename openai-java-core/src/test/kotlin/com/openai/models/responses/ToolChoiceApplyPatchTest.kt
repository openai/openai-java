// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ToolChoiceApplyPatchTest {

    @Test
    fun create() {
        val toolChoiceApplyPatch = ToolChoiceApplyPatch.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val toolChoiceApplyPatch = ToolChoiceApplyPatch.builder().build()

        val roundtrippedToolChoiceApplyPatch =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(toolChoiceApplyPatch),
                jacksonTypeRef<ToolChoiceApplyPatch>(),
            )

        assertThat(roundtrippedToolChoiceApplyPatch).isEqualTo(toolChoiceApplyPatch)
    }
}
