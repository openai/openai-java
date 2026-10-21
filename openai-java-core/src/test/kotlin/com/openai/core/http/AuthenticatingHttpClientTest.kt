package com.openai.core.http

import com.openai.core.RequestOptions
import com.openai.core.Timeout
import com.openai.errors.OpenAIIoException
import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assumptions.assumeTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.mockito.kotlin.any
import org.mockito.kotlin.argumentCaptor
import org.mockito.kotlin.doThrow
import org.mockito.kotlin.eq
import org.mockito.kotlin.mock
import org.mockito.kotlin.same
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoInteractions
import org.mockito.kotlin.whenever

internal class AuthenticatingHttpClientTest {

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun authenticationReducesTransportTimeout(async: Boolean) {
        val request =
            HttpRequest.builder().method(HttpMethod.GET).baseUrl("https://example.com").build()
        val timeout =
            Timeout.builder().request(Duration.ofSeconds(30)).connect(Duration.ofSeconds(5)).build()
        val options = RequestOptions.builder().timeout(timeout).responseValidation(true).build()
        val authenticator = mock<TimeoutAwareHttpRequestAuthenticator>()
        val delayedRequest = {
            Thread.sleep(25)
            request
        }
        val delegate = mock<HttpClient>()
        val response = mock<HttpResponse>()
        val captured = argumentCaptor<RequestOptions>()
        val client =
            AuthenticatingHttpClient(
                delegate,
                PhantomReachableClosingHttpRequestAuthenticator.wrap(authenticator),
            )

        if (async) {
            whenever(authenticator.authenticateAsync(request, timeout.request())).thenAnswer {
                CompletableFuture.completedFuture(delayedRequest())
            }
            whenever(delegate.executeAsync(eq(request), any()))
                .thenReturn(CompletableFuture.completedFuture(response))
            assertThat(client.executeAsync(request, options).join()).isSameAs(response)
            verify(delegate).executeAsync(eq(request), captured.capture())
        } else {
            whenever(authenticator.authenticate(request, timeout.request())).thenAnswer {
                delayedRequest()
            }
            whenever(delegate.execute(eq(request), any())).thenReturn(response)
            assertThat(client.execute(request, options)).isSameAs(response)
            verify(delegate).execute(eq(request), captured.capture())
        }

        val transportOptions = captured.firstValue
        assertThat(transportOptions.timeout!!.request())
            .isLessThan(timeout.request().minusMillis(20))
        assertThat(transportOptions.timeout!!.connect()).isEqualTo(timeout.connect())
        assertThat(transportOptions.responseValidation).isTrue()
        client.close()
        verify(authenticator).close()
    }

    @Test
    fun legacyAuthenticationPreservesTransportOptions() {
        val request =
            HttpRequest.builder().method(HttpMethod.GET).baseUrl("https://example.com").build()
        val options = RequestOptions.builder().timeout(Duration.ofNanos(1)).build()
        val authenticator = mock<HttpRequestAuthenticator>()
        whenever(authenticator.authenticate(request)).thenReturn(request)
        whenever(authenticator.authenticateAsync(request))
            .thenReturn(CompletableFuture.completedFuture(request))
        val response = mock<HttpResponse>()
        val delegate = mock<HttpClient>()
        whenever(delegate.execute(request, options)).thenReturn(response)
        whenever(delegate.executeAsync(request, options))
            .thenReturn(CompletableFuture.completedFuture(response))
        val client =
            AuthenticatingHttpClient(
                delegate,
                PhantomReachableClosingHttpRequestAuthenticator.wrap(authenticator),
            )

        assertThat(client.execute(request, options)).isSameAs(response)
        assertThat(client.executeAsync(request, options).join()).isSameAs(response)
        verify(delegate).execute(eq(request), same(options))
        verify(delegate).executeAsync(eq(request), same(options))
    }

    @Test
    fun exhaustedAuthenticationTimeoutDoesNotDispatch() {
        val request =
            HttpRequest.builder().method(HttpMethod.GET).baseUrl("https://example.com").build()
        val timeout = Duration.ofNanos(1)
        val authenticator = mock<TimeoutAwareHttpRequestAuthenticator>()
        whenever(authenticator.authenticate(request, timeout)).thenReturn(request)
        val delegate = mock<HttpClient>()

        assertThatThrownBy {
                AuthenticatingHttpClient(delegate, authenticator)
                    .execute(request, RequestOptions.builder().timeout(timeout).build())
            }
            .isInstanceOf(OpenAIIoException::class.java)
        verifyNoInteractions(delegate)
    }

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

    @Test
    fun phantomReachableAuthenticatorWrapperClosesAuthenticator() {
        assumeTrue(
            runCatching { Class.forName("java.lang.ref.Cleaner") }.isSuccess,
            "Cleaner is unavailable before Java 9",
        )
        val authenticator = mock<HttpRequestAuthenticator>()

        PhantomReachableClosingHttpRequestAuthenticator(authenticator)

        val deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(5)
        while (System.nanoTime() < deadline) {
            System.gc()
            if (runCatching { verify(authenticator).close() }.isSuccess) {
                return
            }
            Thread.sleep(10)
        }

        verify(authenticator).close()
    }
}
