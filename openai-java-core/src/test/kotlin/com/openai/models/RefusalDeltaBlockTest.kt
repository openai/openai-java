// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RefusalDeltaBlockTest {

    @Test
    fun createRefusalDeltaBlock() {
        val refusalDeltaBlock =
            RefusalDeltaBlock.builder()
                .index(0L)
                .type(RefusalDeltaBlock.Type.REFUSAL)
                .refusal("refusal")
                .build()
        assertThat(refusalDeltaBlock).isNotNull
        assertThat(refusalDeltaBlock.index()).isEqualTo(0L)
        assertThat(refusalDeltaBlock.type()).isEqualTo(RefusalDeltaBlock.Type.REFUSAL)
        assertThat(refusalDeltaBlock.refusal()).contains("refusal")
    }
}
