package com.openai.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class UtilsTest {
    @Test
    fun contentDeepEquals() {
        assertThat(42 contentEquals 42).isTrue()
        assertThat(42 contentEquals "Hello World!").isFalse()
        assertThat(byteArrayOf(1, 2, 3) contentEquals byteArrayOf(1, 2, 3)).isTrue()
        assertThat(byteArrayOf(1, 2, 3) contentEquals byteArrayOf(1, 2, 4)).isFalse()
        assertThat(
                arrayOf(byteArrayOf(1, 2), byteArrayOf(3)) contentEquals
                    arrayOf(byteArrayOf(1, 2), byteArrayOf(3))
            )
            .isTrue()
        assertThat(
                arrayOf(byteArrayOf(1, 2), byteArrayOf(3)) contentEquals
                    arrayOf(byteArrayOf(1), byteArrayOf(2, 3))
            )
            .isFalse()
    }

    @Test
    fun contentToString() {
        assertThat((42).contentToString()).isEqualTo("42")
        assertThat("Hello World!".contentToString()).isEqualTo("Hello World!")
        assertThat(byteArrayOf(1, 2, 3).contentToString()).isEqualTo("[1, 2, 3]")
        assertThat(arrayOf(byteArrayOf(1, 2), byteArrayOf(3)).contentToString())
            .isEqualTo("[[1, 2], [3]]")
    }

    @Test
    fun isAzureEndpoint() {
        // Valid Azure endpoints

        // legacy
        assertThat(isAzureEndpoint("https://region.openai.azure.com")).isTrue()
        assertThat(isAzureEndpoint("https://region.openai.azure.com/")).isTrue()
        // unified with OpenAI
        assertThat(isAzureEndpoint("https://region.services.ai.azure.com")).isTrue()
        assertThat(isAzureEndpoint("https://region.services.ai.azure.com/")).isTrue()
        // other known valid schemas
        assertThat(isAzureEndpoint("https://region.azure-api.net")).isTrue()
        assertThat(isAzureEndpoint("https://region.azure-api.net/")).isTrue()
        assertThat(isAzureEndpoint("https://region.cognitiveservices.azure.com")).isTrue()
        assertThat(isAzureEndpoint("https://region.cognitiveservices.azure.com/")).isTrue()

        // Invalid Azure endpoints
        assertThat(isAzureEndpoint("https://example.com")).isFalse()
        assertThat(isAzureEndpoint("https://region.openai.com")).isFalse()
        assertThat(isAzureEndpoint("https://region.azure.com")).isFalse()
        assertThrows<NullPointerException> {isAzureEndpoint("")}
        assertThrows<NullPointerException>{isAzureEndpoint("   ")}
    }

    @Test
    fun isAzureUnifiedEndpoint() {
        // Valid Azure unified endpoints
        assertThat(isAzureUnifiedEndpoint("https://region.services.ai.azure.com/openai/v1")).isTrue()
        assertThat(isAzureUnifiedEndpoint("https://region.services.ai.azure.com/openai/v1/")).isTrue()

        // Invalid Azure unified endpoints
        assertThat(isAzureUnifiedEndpoint("https://region.services.ai.azure.com")).isFalse()
        assertThat(isAzureUnifiedEndpoint("https://region.services.ai.azure.com/")).isFalse()
        assertThat(isAzureUnifiedEndpoint("https://region.openai.azure.com")).isFalse()
        assertThat(isAzureUnifiedEndpoint("https://example.com")).isFalse()
        assertThat(isAzureUnifiedEndpoint("https://region.openai.com")).isFalse()
        assertThat(isAzureUnifiedEndpoint("https://region.azure.com")).isFalse()
        assertThat(isAzureUnifiedEndpoint("")).isFalse()
        assertThat(isAzureUnifiedEndpoint("    ")).isFalse()
    }
}