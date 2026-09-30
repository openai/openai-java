package com.openai.core.http

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class HeaderHashContractTest {
    @Test
    fun equalHeadersWorkAsHashKeysRegardlessOfSpellingOrOrder() {
        val first =
            Headers.builder()
                .put("X-Request-ID", listOf("one", "two"))
                .put("Content-Type", "text/plain")
                .build()
        val second =
            Headers.builder()
                .put("content-TYPE", "text/plain")
                .put("x-request-id", listOf("one", "two"))
                .build()
        assertThat(first).isEqualTo(second)
        assertThat(first.hashCode()).isEqualTo(second.hashCode())
        assertThat(hashSetOf(first, second)).hasSize(1)
        assertThat(mapOf(first to "found")[second]).isEqualTo("found")
        assertThat(first.names()).contains("X-Request-ID", "Content-Type")
    }

    @Test
    fun foldsUnicodeLikeTheExistingCaseInsensitiveComparator() {
        for ((a, b) in listOf("I" to "ı", "İ" to "i", "K" to "K", "Σ" to "ς")) {
            val first = Headers.builder().put(a, "test").build()
            val second = Headers.builder().put(b, "test").build()
            assertThat(first).isEqualTo(second)
            assertThat(first.hashCode()).isEqualTo(second.hashCode())
        }
    }
}
