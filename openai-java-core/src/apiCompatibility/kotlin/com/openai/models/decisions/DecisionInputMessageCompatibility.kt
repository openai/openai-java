package com.openai.models.decisions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DecisionInputMessageCompatibility {

    @Test
    fun roundtrip() {
        val mapper = jsonMapper()
        val message =
            mapper.readValue(
                """{"role":"user","type":"message","content":"string"}""",
                jacksonTypeRef<DecisionInputMessage>(),
            )

        val roundtripped =
            mapper.readValue(
                mapper.writeValueAsString(message),
                jacksonTypeRef<DecisionInputMessage>(),
            )

        assertThat(roundtripped).isEqualTo(message)
    }
}
