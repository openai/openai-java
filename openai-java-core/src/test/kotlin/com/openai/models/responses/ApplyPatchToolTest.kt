// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApplyPatchToolTest {

    @Test
    fun create() {
        val applyPatchTool = ApplyPatchTool.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val applyPatchTool = ApplyPatchTool.builder().build()

        val roundtrippedApplyPatchTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(applyPatchTool),
                jacksonTypeRef<ApplyPatchTool>(),
            )

        assertThat(roundtrippedApplyPatchTool).isEqualTo(applyPatchTool)
    }
}
