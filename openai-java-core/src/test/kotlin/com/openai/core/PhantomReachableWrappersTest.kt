package com.openai.core

import com.openai.core.http.AsyncStreamResponse
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpRequestAuthenticator
import com.openai.core.http.PhantomReachableClosingAsyncStreamResponse
import com.openai.core.http.PhantomReachableClosingHttpClient
import com.openai.core.http.PhantomReachableClosingHttpRequestAuthenticator
import com.openai.core.http.PhantomReachableClosingStreamResponse
import com.openai.core.http.StreamResponse
import java.util.stream.Stream
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import org.mockito.kotlin.doAnswer
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

internal class PhantomReachableWrappersTest {
    @ParameterizedTest
    @EnumSource(Wrapper::class)
    fun repeatedCloseClosesDelegateOnce(wrapper: Wrapper) {
        var calls = 0
        val close = wrapper.wrap { calls++ }

        assertThat(calls).isZero()
        close()
        close()

        assertThat(calls).isEqualTo(1)
    }

    @ParameterizedTest
    @EnumSource(Wrapper::class)
    fun closePropagatesFailureWithoutRetryingDelegate(wrapper: Wrapper) {
        var calls = 0
        val failure = IllegalStateException("cleanup failed")
        val close =
            wrapper.wrap {
                calls++
                throw failure
            }

        assertThatThrownBy { close() }.isSameAs(failure)
        close()

        assertThat(calls).isEqualTo(1)
    }

    @Test
    fun closingReturnedStreamAndResponseClosesDelegateOnce() {
        var calls = 0
        val delegate = mock<StreamResponse<String>>()
        whenever(delegate.stream()).thenReturn(Stream.of("Frodo"))
        doAnswer {
                calls++
                null
            }
            .whenever(delegate)
            .close()
        val response = PhantomReachableClosingStreamResponse(delegate)

        response.stream().close()
        response.close()

        assertThat(calls).isEqualTo(1)
    }

    enum class Wrapper {
        HTTP_CLIENT,
        AUTHENTICATOR,
        SLEEPER,
        STREAM,
        ASYNC_STREAM;

        fun wrap(onClose: () -> Unit): () -> Unit =
            when (this) {
                HTTP_CLIENT -> {
                    val delegate = mock<HttpClient>()
                    doAnswer {
                            onClose()
                            null
                        }
                        .whenever(delegate)
                        .close()
                    PhantomReachableClosingHttpClient.wrap(delegate)::close
                }
                AUTHENTICATOR -> {
                    val delegate = mock<HttpRequestAuthenticator>()
                    doAnswer {
                            onClose()
                            null
                        }
                        .whenever(delegate)
                        .close()
                    PhantomReachableClosingHttpRequestAuthenticator(delegate)::close
                }
                SLEEPER -> {
                    val delegate = mock<Sleeper>()
                    doAnswer {
                            onClose()
                            null
                        }
                        .whenever(delegate)
                        .close()
                    PhantomReachableSleeper(delegate)::close
                }
                STREAM -> {
                    val delegate = mock<StreamResponse<String>>()
                    doAnswer {
                            onClose()
                            null
                        }
                        .whenever(delegate)
                        .close()
                    PhantomReachableClosingStreamResponse(delegate)::close
                }
                ASYNC_STREAM -> {
                    val delegate = mock<AsyncStreamResponse<String>>()
                    doAnswer {
                            onClose()
                            null
                        }
                        .whenever(delegate)
                        .close()
                    PhantomReachableClosingAsyncStreamResponse(delegate)::close
                }
            }
    }
}
