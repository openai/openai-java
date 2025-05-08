// File generated from our OpenAPI spec by Stainless.

package com.openai.core

import com.openai.core.http.AsyncStreamResponse
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.mockito.kotlin.clearInvocations
import org.mockito.kotlin.doAnswer
import org.mockito.kotlin.inOrder
import org.mockito.kotlin.mock
import org.mockito.kotlin.never
import org.mockito.kotlin.spy
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ExtendWith(MockitoExtension::class)
internal class AutoPagerAsyncTest {

    companion object {

        private val ERROR = RuntimeException("ERROR!")
    }

    private class PageAsyncImpl(
        private val items: List<String>,
        private val hasNext: Boolean = true,
    ) : PageAsync<String> {

        val nextPageFuture: CompletableFuture<PageAsync<String>> = CompletableFuture()

        override fun hasNextPage(): Boolean = hasNext

        override fun nextPage(): CompletableFuture<PageAsync<String>> = nextPageFuture

        override fun items(): List<String> = items
    }

    private val executor =
        spy<Executor> {
            doAnswer { invocation -> invocation.getArgument<Runnable>(0).run() }
                .whenever(it)
                .execute(any())
        }
    private val handler = mock<AsyncStreamResponse.Handler<String>>()

    @Test
    fun subscribe_whenAlreadySubscribed_throws() {
        val autoPagerAsync = AutoPagerAsync.from(PageAsyncImpl(emptyList()), executor)
        autoPagerAsync.subscribe {}
        clearInvocations(executor)

        val throwable = catchThrowable { autoPagerAsync.subscribe {} }

        assertThat(throwable).isInstanceOf(IllegalStateException::class.java)
        assertThat(throwable).hasMessage("Cannot subscribe more than once")
        verify(executor, never()).execute(any())
    }

    @Test
    fun subscribe_whenClosed_throws() {
        val autoPagerAsync = AutoPagerAsync.from(PageAsyncImpl(emptyList()), executor)
        autoPagerAsync.close()

        val throwable = catchThrowable { autoPagerAsync.subscribe {} }

        assertThat(throwable).isInstanceOf(IllegalStateException::class.java)
        assertThat(throwable).hasMessage("Cannot subscribe after the response is closed")
        verify(executor, never()).execute(any())
    }

    @Test
    fun subscribe_whenFirstPageNonEmpty_runsHandler() {
        val page = PageAsyncImpl(listOf("item1", "item2", "item3"), hasNext = false)
        val autoPagerAsync = AutoPagerAsync.from(page, executor)

        autoPagerAsync.subscribe(handler)

        inOrder(executor, handler) {
            verify(executor, times(1)).execute(any())
            verify(handler, times(1)).onNext("item1")
            verify(handler, times(1)).onNext("item2")
            verify(handler, times(1)).onNext("item3")
            verify(handler, times(1)).onComplete(Optional.empty())
        }
    }

    @Test
    fun subscribe_whenFutureCompletesAfterClose_doesNothing() {
        val page = PageAsyncImpl(listOf("page1"))
        val autoPagerAsync = AutoPagerAsync.from(page, executor)
        autoPagerAsync.subscribe(handler)
        autoPagerAsync.close()

        page.nextPageFuture.complete(PageAsyncImpl(listOf("page2")))

        verify(handler, times(1)).onNext("page1")
        verify(handler, never()).onNext("page2")
        verify(handler, times(1)).onComplete(Optional.empty())
        verify(executor, times(1)).execute(any())
    }

    @Test
    fun subscribe_whenFutureErrors_callsOnComplete() {
        val page = PageAsyncImpl(emptyList())
        val autoPagerAsync = AutoPagerAsync.from(page, executor)
        autoPagerAsync.subscribe(handler)

        page.nextPageFuture.completeExceptionally(ERROR)

        verify(executor, times(1)).execute(any())
        verify(handler, never()).onNext(any())
        verify(handler, times(1)).onComplete(Optional.of(ERROR))
    }

    @Test
    fun subscribe_whenFutureCompletes_runsHandler() {
        val page = PageAsyncImpl(listOf("chunk1", "chunk2"))
        val autoPagerAsync = AutoPagerAsync.from(page, executor)

        autoPagerAsync.subscribe(handler)

        verify(handler, never()).onComplete(any())
        inOrder(executor, handler) {
            verify(executor, times(1)).execute(any())
            verify(handler, times(1)).onNext("chunk1")
            verify(handler, times(1)).onNext("chunk2")
        }
        clearInvocations(executor, handler)

        page.nextPageFuture.complete(PageAsyncImpl(listOf("chunk3", "chunk4"), hasNext = false))

        verify(executor, never()).execute(any())
        inOrder(handler) {
            verify(handler, times(1)).onNext("chunk3")
            verify(handler, times(1)).onNext("chunk4")
            verify(handler, times(1)).onComplete(Optional.empty())
        }
    }

    @Test
    fun onCompleteFuture_whenNextPageFutureNotCompleted_onCompleteFutureNotCompleted() {
        val page = PageAsyncImpl(listOf("chunk1", "chunk2"))
        val autoPagerAsync = AutoPagerAsync.from(page, executor)
        autoPagerAsync.subscribe {}

        val onCompletableFuture = autoPagerAsync.onCompleteFuture()

        assertThat(onCompletableFuture).isNotCompleted
    }

    @Test
    fun onCompleteFuture_whenNextPageFutureErrors_onCompleteFutureCompletedExceptionally() {
        val page = PageAsyncImpl(listOf("chunk1", "chunk2"))
        val autoPagerAsync = AutoPagerAsync.from(page, executor)
        autoPagerAsync.subscribe {}
        page.nextPageFuture.completeExceptionally(ERROR)

        val onCompletableFuture = autoPagerAsync.onCompleteFuture()

        assertThat(onCompletableFuture).isCompletedExceptionally
    }

    @Test
    fun onCompleteFuture_whenNoNextPage_onCompleteFutureCompleted() {
        val page = PageAsyncImpl(listOf("chunk1", "chunk2"), hasNext = false)
        val autoPagerAsync = AutoPagerAsync.from(page, executor)
        autoPagerAsync.subscribe {}

        val onCompletableFuture = autoPagerAsync.onCompleteFuture()

        assertThat(onCompletableFuture).isCompleted
    }
}
