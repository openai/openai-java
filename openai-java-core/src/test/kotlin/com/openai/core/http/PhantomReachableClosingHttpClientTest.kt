package com.openai.core.http

import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

internal class PhantomReachableClosingHttpClientTest {

    @Test
    fun close_closesDelegateAtMostOnce() {
        val delegate = mock<HttpClient>()
        val client = PhantomReachableClosingHttpClient(delegate)

        client.close()
        client.close()

        verify(delegate, times(1)).close()
    }
}
