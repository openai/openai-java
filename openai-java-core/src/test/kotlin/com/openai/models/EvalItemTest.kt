// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EvalItemTest {

    @Test
    fun create() {
        val evalItem =
            EvalItem.builder()
                .content("string")
                .role(EvalItem.Role.USER)
                .type(EvalItem.Type.MESSAGE)
                .build()

        assertThat(evalItem.content()).isEqualTo(EvalItem.Content.ofTextInput("string"))
        assertThat(evalItem.role()).isEqualTo(EvalItem.Role.USER)
        assertThat(evalItem.type()).contains(EvalItem.Type.MESSAGE)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val evalItem =
            EvalItem.builder()
                .content("string")
                .role(EvalItem.Role.USER)
                .type(EvalItem.Type.MESSAGE)
                .build()

        val roundtrippedEvalItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(evalItem),
                jacksonTypeRef<EvalItem>(),
            )

        assertThat(roundtrippedEvalItem).isEqualTo(evalItem)
    }
}
