// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RefusalContentBlockTest {

    @Test
    fun create() {
        val refusalContentBlock = RefusalContentBlock.builder().refusal("refusal").build()

        assertThat(refusalContentBlock.refusal()).isEqualTo("refusal")
    }
}
