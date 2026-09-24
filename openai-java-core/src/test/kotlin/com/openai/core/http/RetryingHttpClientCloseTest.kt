package com.openai.core.http

import com.openai.core.Sleeper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doThrow
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

internal class RetryingHttpClientCloseTest {

    @Test
    fun closeClosesDelegateAndSleeper() {
        val delegate = mock<HttpClient>()
        val sleeper = mock<Sleeper>()
        val client = client(delegate, sleeper)

        client.close()

        verify(delegate).close()
        verify(sleeper).close()
    }

    @Test
    fun closeStillClosesSleeperWhenDelegateCloseFails() {
        val delegateFailure = IllegalStateException("delegate close failed")
        val delegate = mock<HttpClient>()
        val sleeper = mock<Sleeper>()
        doThrow(delegateFailure).whenever(delegate).close()
        val client = client(delegate, sleeper)

        val thrown = runCatching { client.close() }.exceptionOrNull()

        assertThat(thrown).isSameAs(delegateFailure)
        verify(sleeper).close()
    }

    @Test
    fun closeSuppressesSleeperFailureWhenBothCloseOperationsFail() {
        val delegateFailure = IllegalStateException("delegate close failed")
        val sleeperFailure = IllegalArgumentException("sleeper close failed")
        val delegate = mock<HttpClient>()
        val sleeper = mock<Sleeper>()
        doThrow(delegateFailure).whenever(delegate).close()
        doThrow(sleeperFailure).whenever(sleeper).close()
        val client = client(delegate, sleeper)

        val thrown = runCatching { client.close() }.exceptionOrNull()

        assertThat(thrown).isSameAs(delegateFailure)
        assertThat(thrown!!.suppressed).containsExactly(sleeperFailure)
        verify(sleeper).close()
    }

    @Test
    fun closePropagatesSleeperFailureWhenDelegateClosesSuccessfully() {
        val sleeperFailure = IllegalStateException("sleeper close failed")
        val delegate = mock<HttpClient>()
        val sleeper = mock<Sleeper>()
        doThrow(sleeperFailure).whenever(sleeper).close()
        val client = client(delegate, sleeper)

        val thrown = runCatching { client.close() }.exceptionOrNull()

        assertThat(thrown).isSameAs(sleeperFailure)
        verify(delegate).close()
        verify(sleeper).close()
    }

    private fun client(delegate: HttpClient, sleeper: Sleeper): HttpClient =
        RetryingHttpClient.builder().httpClient(delegate).sleeper(sleeper).build()
}
