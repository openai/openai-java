package com.openai.core.http

import com.openai.azure.credential.AzureApiKeyCredential
import com.openai.client.okhttp.OkHttpClient
import com.openai.core.ClientOptions
import com.openai.credential.BearerTokenCredential
import java.util.stream.Stream
import kotlin.test.Test
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class ClientOptionsTest {

    companion object {
        private const val FAKE_API_KEY = "test-api-key"

        @JvmStatic
        private fun createOkHttpClient(baseUrl: String): OkHttpClient {
            return OkHttpClient.builder().baseUrl(baseUrl).build()
        }

        @JvmStatic
        private fun provideBaseUrls(): Stream<String> {
            return Stream.of(
                "https://api.openai.com/v1",
                "https://example.openai.azure.com",
                "https://example.azure-api.net"
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideBaseUrls")
    fun clientOptionsWithoutBaseUrl(baseUrl: String) {
        // Arrange
        val apiKey = FAKE_API_KEY

        // Act
        val clientOptions =
            ClientOptions.builder()
                .httpClient(createOkHttpClient(baseUrl))
                .credential(BearerTokenCredential.create(apiKey))
                .build()

        // Assert
        assertThat(clientOptions.baseUrl).isEqualTo(ClientOptions.PRODUCTION_URL)
    }

    @ParameterizedTest
    @MethodSource("provideBaseUrls")
    fun throwExceptionWhenNullCredential(baseUrl: String) {
        // Act
        val clientOptionsBuilder =
            ClientOptions.builder().httpClient(createOkHttpClient(baseUrl)).baseUrl(baseUrl)

        // Assert
        assertThatThrownBy { clientOptionsBuilder.build() }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("`credential` is required, but was not set")
    }

    @Test
    fun throwExceptionWhenEmptyCredential() {
        assertThatThrownBy { AzureApiKeyCredential.create("") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Azure API key cannot be empty.")
    }
}
