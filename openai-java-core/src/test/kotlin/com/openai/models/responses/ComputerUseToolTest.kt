// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ComputerUseToolTest {

    @Test
    fun create() {
        val computerUseTool = ComputerUseTool.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val computerUseTool = ComputerUseTool.builder().build()

        val roundtrippedComputerUseTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(computerUseTool),
                jacksonTypeRef<ComputerUseTool>(),
            )

        assertThat(roundtrippedComputerUseTool).isEqualTo(computerUseTool)
    }
}
