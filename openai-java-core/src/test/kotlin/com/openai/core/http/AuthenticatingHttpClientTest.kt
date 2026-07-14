package com.openai.core.http

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doThrow
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

internal class AuthenticatingHttpClientTest {

    @Test
    fun closeClosesDelegateAndSuppressesItsFailureWhenAuthenticatorCloseFails() {
        val authenticatorFailure = IllegalStateException("authenticator close failed")
        val delegateFailure = IllegalArgumentException("delegate close failed")
        val authenticator = mock<HttpRequestAuthenticator>()
        val delegate = mock<HttpClient>()
        doThrow(authenticatorFailure).whenever(authenticator).close()
        doThrow(delegateFailure).whenever(delegate).close()
        val client = AuthenticatingHttpClient(delegate, authenticator)

        val thrown = runCatching { client.close() }.exceptionOrNull()

        assertThat(thrown).isSameAs(authenticatorFailure)
        assertThat(thrown!!.suppressed).containsExactly(delegateFailure)
        verify(delegate).close()
    }

    @Test
    fun closePropagatesDelegateFailureWhenAuthenticatorClosesSuccessfully() {
        val delegateFailure = IllegalStateException("delegate close failed")
        val authenticator = mock<HttpRequestAuthenticator>()
        val delegate = mock<HttpClient>()
        doThrow(delegateFailure).whenever(delegate).close()
        val client = AuthenticatingHttpClient(delegate, authenticator)

        val thrown = runCatching { client.close() }.exceptionOrNull()

        assertThat(thrown).isSameAs(delegateFailure)
        verify(authenticator).close()
        verify(delegate).close()
    }
}
