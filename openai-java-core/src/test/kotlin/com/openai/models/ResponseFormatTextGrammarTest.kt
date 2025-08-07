// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseFormatTextGrammarTest {

    @Test
    fun create() {
        val responseFormatTextGrammar =
            ResponseFormatTextGrammar.builder().grammar("grammar").build()

        assertThat(responseFormatTextGrammar.grammar()).isEqualTo("grammar")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseFormatTextGrammar =
            ResponseFormatTextGrammar.builder().grammar("grammar").build()

        val roundtrippedResponseFormatTextGrammar =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFormatTextGrammar),
                jacksonTypeRef<ResponseFormatTextGrammar>(),
            )

        assertThat(roundtrippedResponseFormatTextGrammar).isEqualTo(responseFormatTextGrammar)
    }
}
