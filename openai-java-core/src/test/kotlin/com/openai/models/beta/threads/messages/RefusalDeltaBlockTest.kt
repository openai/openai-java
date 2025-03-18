// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RefusalDeltaBlockTest {

    @Test
    fun create() {
        val refusalDeltaBlock = RefusalDeltaBlock.builder().index(0L).refusal("refusal").build()

        assertThat(refusalDeltaBlock.index()).isEqualTo(0L)
        assertThat(refusalDeltaBlock.refusal()).contains("refusal")
    }
}
