// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RefusalContentBlockTest {

    @Test
    fun createRefusalContentBlock() {
        val refusalContentBlock =
            RefusalContentBlock.builder()
                .refusal("refusal")
                .type(RefusalContentBlock.Type.REFUSAL)
                .build()
        assertThat(refusalContentBlock).isNotNull
        assertThat(refusalContentBlock.refusal()).isEqualTo("refusal")
        assertThat(refusalContentBlock.type()).isEqualTo(RefusalContentBlock.Type.REFUSAL)
    }
}
