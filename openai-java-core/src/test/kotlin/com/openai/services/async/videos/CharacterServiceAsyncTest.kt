// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.videos

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.videos.character.CharacterCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class CharacterServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val characterServiceAsync = client.videos().character()

        val characterFuture =
            characterServiceAsync.create(
                CharacterCreateParams.builder()
                    .name("x")
                    .video("Example data".byteInputStream())
                    .build()
            )

        val character = characterFuture.get()
        character.validate()
    }

    @Test
    fun get() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val characterServiceAsync = client.videos().character()

        val characterFuture = characterServiceAsync.get("char_123")

        val character = characterFuture.get()
        character.validate()
    }
}
