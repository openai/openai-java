// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.videos

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.videos.character.CharacterCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class CharacterServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val characterService = client.videos().character()

        val character =
            characterService.create(
                CharacterCreateParams.builder()
                    .name("x")
                    .video("Example data".byteInputStream())
                    .build()
            )

        character.validate()
    }

    @Test
    fun get() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val characterService = client.videos().character()

        val character = characterService.get("char_123")

        character.validate()
    }
}
