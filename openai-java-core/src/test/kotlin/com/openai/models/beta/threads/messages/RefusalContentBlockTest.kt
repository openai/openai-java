// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RefusalContentBlockTest {

    @Test
    fun create() {
        val refusalContentBlock = RefusalContentBlock.builder().refusal("refusal").build()

        assertThat(refusalContentBlock.refusal()).isEqualTo("refusal")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val refusalContentBlock = RefusalContentBlock.builder().refusal("refusal").build()

        val roundtrippedRefusalContentBlock =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(refusalContentBlock),
                jacksonTypeRef<RefusalContentBlock>(),
            )

        assertThat(roundtrippedRefusalContentBlock).isEqualTo(refusalContentBlock)
    }
}
