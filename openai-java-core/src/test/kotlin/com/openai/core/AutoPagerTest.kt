// File generated from our OpenAPI spec by Stainless.

package com.openai.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AutoPagerTest {

    private class PageImpl(
        private val items: List<String>,
        private val nextPage: Page<String>? = null,
    ) : Page<String> {

        override fun hasNextPage(): Boolean = nextPage != null

        override fun nextPage(): Page<String> = nextPage!!

        override fun items(): List<String> = items
    }

    @Test
    fun iterator() {
        val firstPage =
            PageImpl(listOf("chunk1", "chunk2"), nextPage = PageImpl(listOf("chunk3", "chunk4")))

        val autoPager = AutoPager.from(firstPage)

        assertThat(autoPager).containsExactly("chunk1", "chunk2", "chunk3", "chunk4")
    }

    @Test
    fun stream() {
        val firstPage =
            PageImpl(listOf("chunk1", "chunk2"), nextPage = PageImpl(listOf("chunk3", "chunk4")))

        val autoPager = AutoPager.from(firstPage)

        assertThat(autoPager.stream()).containsExactly("chunk1", "chunk2", "chunk3", "chunk4")
    }
}
