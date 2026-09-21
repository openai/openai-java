// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CustomVoiceTest {

    @Test
    fun create() {
        val customVoice = CustomVoice.builder().id("x").build()

        assertThat(customVoice.id()).isEqualTo("x")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val customVoice = CustomVoice.builder().id("x").build()

        val roundtrippedCustomVoice =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(customVoice),
                jacksonTypeRef<CustomVoice>(),
            )

        assertThat(roundtrippedCustomVoice).isEqualTo(customVoice)
    }
}
