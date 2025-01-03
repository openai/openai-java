// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OtherFileChunkingStrategyObjectTest {

    @Test
    fun createOtherFileChunkingStrategyObject() {
        val otherFileChunkingStrategyObject =
            OtherFileChunkingStrategyObject.builder()
                .type(OtherFileChunkingStrategyObject.Type.OTHER)
                .build()
        assertThat(otherFileChunkingStrategyObject).isNotNull
        assertThat(otherFileChunkingStrategyObject.type())
            .isEqualTo(OtherFileChunkingStrategyObject.Type.OTHER)
    }
}
