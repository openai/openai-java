// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InlineCapabilitySourceParamTest {

    @Test
    fun create() {
        val inlineCapabilitySourceParam = InlineCapabilitySourceParam.builder().data("x").build()

        assertThat(inlineCapabilitySourceParam.data()).isEqualTo("x")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inlineCapabilitySourceParam = InlineCapabilitySourceParam.builder().data("x").build()

        val roundtrippedInlineCapabilitySourceParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inlineCapabilitySourceParam),
                jacksonTypeRef<InlineCapabilitySourceParam>(),
            )

        assertThat(roundtrippedInlineCapabilitySourceParam).isEqualTo(inlineCapabilitySourceParam)
    }
}
