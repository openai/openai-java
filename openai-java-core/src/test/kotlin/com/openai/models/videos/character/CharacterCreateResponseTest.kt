// File generated from our OpenAPI spec by Stainless.

package com.openai.models.videos.character

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CharacterCreateResponseTest {

    @Test
    fun create() {
        val characterCreateResponse =
            CharacterCreateResponse.builder().id("id").createdAt(0L).name("name").build()

        assertThat(characterCreateResponse.id()).contains("id")
        assertThat(characterCreateResponse.createdAt()).isEqualTo(0L)
        assertThat(characterCreateResponse.name()).contains("name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val characterCreateResponse =
            CharacterCreateResponse.builder().id("id").createdAt(0L).name("name").build()

        val roundtrippedCharacterCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(characterCreateResponse),
                jacksonTypeRef<CharacterCreateResponse>(),
            )

        assertThat(roundtrippedCharacterCreateResponse).isEqualTo(characterCreateResponse)
    }
}
