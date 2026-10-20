package com.openai.client.okhttp

import com.openai.client.OpenAIClient
import com.openai.client.OpenAIClientAsync
import com.openai.core.ClientOptions
import com.openai.core.DataResidency
import java.util.Optional
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class DataResidencyTest {
    @Test
    fun syncAndAsyncBuildersExposeResidency() {
        val sync =
            OpenAIOkHttpClient.builder().apiKey("test").dataResidency(DataResidency.EU).build()
        val async =
            OpenAIOkHttpClientAsync.builder()
                .apiKey("test")
                .dataResidency(Optional.of(DataResidency.AE))
                .build()
        assertThat(baseUrl(sync)).isEqualTo("https://eu.api.openai.com/v1")
        assertThat(baseUrl(async)).isEqualTo("https://ae.api.openai.com/v1")
        assertThat(baseUrl(sync.withOptions { it.dataResidency(DataResidency.US) }))
            .isEqualTo("https://us.api.openai.com/v1")
        assertThat(baseUrl(async.withOptions { it.dataResidency(DataResidency.GLOBAL) }))
            .isEqualTo(ClientOptions.PRODUCTION_URL)
        assertThat(baseUrl(sync)).isEqualTo("https://eu.api.openai.com/v1")
        assertThat(baseUrl(async)).isEqualTo("https://ae.api.openai.com/v1")
        sync.close()
        async.close()
    }

    @Test
    fun publicBuildersRejectBothExplicitOptions() {
        assertThrows<IllegalArgumentException> {
            OpenAIOkHttpClient.builder()
                .baseUrl("https://example.com")
                .dataResidency(DataResidency.EU)
        }
        assertThrows<IllegalArgumentException> {
            OpenAIOkHttpClient.builder()
                .dataResidency(DataResidency.EU)
                .baseUrl("https://example.com")
        }
        assertThrows<IllegalArgumentException> {
            OpenAIOkHttpClientAsync.builder()
                .baseUrl("https://example.com")
                .dataResidency(DataResidency.EU)
        }
        assertThrows<IllegalArgumentException> {
            OpenAIOkHttpClientAsync.builder()
                .dataResidency(DataResidency.EU)
                .baseUrl("https://example.com")
        }
    }

    private fun baseUrl(client: OpenAIClient): String {
        var result = ""
        client.withOptions { result = it.build().baseUrl() }
        return result
    }

    private fun baseUrl(client: OpenAIClientAsync): String {
        var result = ""
        client.withOptions { result = it.build().baseUrl() }
        return result
    }
}
