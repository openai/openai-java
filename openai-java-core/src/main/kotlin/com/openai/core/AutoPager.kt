// File generated from our OpenAPI spec by Stainless.

package com.openai.core

import java.util.stream.Stream
import java.util.stream.StreamSupport

class AutoPager<T> private constructor(private val firstPage: Page<T>) : Iterable<T> {

    companion object {

        fun <T> from(firstPage: Page<T>): AutoPager<T> = AutoPager(firstPage)
    }

    override fun iterator(): Iterator<T> =
        generateSequence(firstPage) { if (it.hasNextPage()) it.nextPage() else null }
            .flatMap { it.items() }
            .iterator()

    fun stream(): Stream<T> = StreamSupport.stream(spliterator(), false)
}
