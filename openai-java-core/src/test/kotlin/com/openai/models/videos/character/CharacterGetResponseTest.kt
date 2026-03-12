// File generated from our OpenAPI spec by Stainless.

package com.openai.models.videos.character

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CharacterGetResponseTest {

    @Test
    fun create() {
        val characterGetResponse =
            CharacterGetResponse.builder().id("id").createdAt(0L).name("name").build()

        assertThat(characterGetResponse.id()).contains("id")
        assertThat(characterGetResponse.createdAt()).isEqualTo(0L)
        assertThat(characterGetResponse.name()).contains("name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val characterGetResponse =
            CharacterGetResponse.builder().id("id").createdAt(0L).name("name").build()

        val roundtrippedCharacterGetResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(characterGetResponse),
                jacksonTypeRef<CharacterGetResponse>(),
            )

        assertThat(roundtrippedCharacterGetResponse).isEqualTo(characterGetResponse)
    }
}
