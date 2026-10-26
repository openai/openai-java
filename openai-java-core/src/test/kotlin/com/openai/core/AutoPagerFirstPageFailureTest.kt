package com.openai.core

import com.openai.core.http.AsyncStreamResponse
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class AutoPagerFirstPageFailureTest {
    @ParameterizedTest
    @ValueSource(strings = ["items", "hasNextPage", "nextPage", "onNext"])
    fun reportsSynchronousFailureThroughCompletion(operation: String) {
        val failure = IllegalStateException("Malformed first page")
        val page =
            object : PageAsync<String> {
                override fun items(): List<String> {
                    if (operation == "items") throw failure
                    return listOf("test")
                }

                override fun hasNextPage(): Boolean {
                    if (operation == "hasNextPage") throw failure
                    return true
                }

                override fun nextPage(): CompletableFuture<PageAsync<String>> {
                    throw failure
                }
            }
        val executor = Executors.newSingleThreadExecutor()
        try {
            var reported: Throwable? = null
            val pager = AutoPagerAsync.from(page, executor)
            pager.subscribe(
                object : AsyncStreamResponse.Handler<String> {
                    override fun onNext(value: String) {
                        if (operation == "onNext") throw failure
                    }

                    override fun onComplete(error: Optional<Throwable>) {
                        reported = error.orElse(null)
                    }
                }
            )
            assertThatThrownBy { pager.onCompleteFuture().get(5, TimeUnit.SECONDS) }
                .hasCause(failure)
            assertThat(reported).isSameAs(failure)
        } finally {
            executor.shutdownNow()
        }
    }
}
