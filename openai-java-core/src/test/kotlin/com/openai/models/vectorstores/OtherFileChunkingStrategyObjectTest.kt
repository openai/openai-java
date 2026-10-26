// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.vectorstores

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OtherFileChunkingStrategyObjectTest {

    @Test
    fun createAndRoundtrip() {
        val otherFileChunkingStrategyObject = OtherFileChunkingStrategyObject.builder().build()

        val jsonMapper = jsonMapper()

        val roundtrippedOtherFileChunkingStrategyObject =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(otherFileChunkingStrategyObject),
                jacksonTypeRef<OtherFileChunkingStrategyObject>(),
            )

        assertThat(roundtrippedOtherFileChunkingStrategyObject)
            .isEqualTo(otherFileChunkingStrategyObject)
    }
}
