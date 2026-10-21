// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApplyPatchToolTest {

    @Test
    fun createAndRoundtrip() {
        val applyPatchTool =
            ApplyPatchTool.builder().addAllowedCaller(ApplyPatchTool.AllowedCaller.DIRECT).build()

        assertThat(applyPatchTool.allowedCallers().getOrNull())
            .containsExactly(ApplyPatchTool.AllowedCaller.DIRECT)

        val jsonMapper = jsonMapper()

        val roundtrippedApplyPatchTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(applyPatchTool),
                jacksonTypeRef<ApplyPatchTool>(),
            )

        assertThat(roundtrippedApplyPatchTool).isEqualTo(applyPatchTool)
    }
}
