// File generated from our OpenAPI spec by Stainless.

package com.openai.models.conversations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RefusalContentTest {

    @Test
    fun create() {
        val refusalContent = RefusalContent.builder().refusal("refusal").build()

        assertThat(refusalContent.refusal()).isEqualTo("refusal")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val refusalContent = RefusalContent.builder().refusal("refusal").build()

        val roundtrippedRefusalContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(refusalContent),
                jacksonTypeRef<RefusalContent>(),
            )

        assertThat(roundtrippedRefusalContent).isEqualTo(refusalContent)
    }
}
