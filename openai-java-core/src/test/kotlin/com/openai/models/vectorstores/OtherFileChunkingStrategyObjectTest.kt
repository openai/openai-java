// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OtherFileChunkingStrategyObjectTest {

    @Test
    fun create() {
        val otherFileChunkingStrategyObject = OtherFileChunkingStrategyObject.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val otherFileChunkingStrategyObject = OtherFileChunkingStrategyObject.builder().build()

        val roundtrippedOtherFileChunkingStrategyObject =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(otherFileChunkingStrategyObject),
                jacksonTypeRef<OtherFileChunkingStrategyObject>(),
            )

        assertThat(roundtrippedOtherFileChunkingStrategyObject)
            .isEqualTo(otherFileChunkingStrategyObject)
    }
}
