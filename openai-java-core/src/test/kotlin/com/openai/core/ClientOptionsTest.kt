// File generated from our OpenAPI spec by Stainless.

package com.openai.core

import com.openai.core.http.HttpClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.mock
import org.mockito.kotlin.never
import org.mockito.kotlin.verify

@ExtendWith(MockitoExtension::class)
internal class ClientOptionsTest {

    private val httpClient = mock<HttpClient>()

    @Test
    fun putHeader_canOverwriteDefaultHeader() {
        val clientOptions =
            ClientOptions.builder()
                .httpClient(httpClient)
                .putHeader("User-Agent", "My User Agent")
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()

        assertThat(clientOptions.headers.values("User-Agent")).containsExactly("My User Agent")
    }

    @Test
    fun toBuilder_organizationCanBeUpdated() {
        var clientOptions =
            ClientOptions.builder()
                .httpClient(httpClient)
                .organization("My Organization")
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()

        clientOptions = clientOptions.toBuilder().organization("another My Organization").build()

        assertThat(clientOptions.headers.values("OpenAI-Organization"))
            .containsExactly("another My Organization")
    }

    @Test
    fun toBuilder_whenOriginalClientOptionsGarbageCollected_doesNotCloseOriginalClient() {
        var clientOptions =
            ClientOptions.builder()
                .httpClient(httpClient)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        verify(httpClient, never()).close()

        // Overwrite the `clientOptions` variable so that the original `ClientOptions` is GC'd.
        clientOptions = clientOptions.toBuilder().build()
        System.gc()
        Thread.sleep(100)

        verify(httpClient, never()).close()
        // This exists so that `clientOptions` is still reachable.
        assertThat(clientOptions).isEqualTo(clientOptions)
    }
}
