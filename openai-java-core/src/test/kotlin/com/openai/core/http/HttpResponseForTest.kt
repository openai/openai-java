package com.openai.core.http

import com.openai.core.handlers.streamHandler
import java.io.ByteArrayInputStream
import java.io.IOException
import java.io.InputStream
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doAnswer
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

internal class HttpResponseForTest {
    @Test
    fun closesWithoutParsing() {
        val response = mock<HttpResponse>()
        val raw = response.parseable<String> { error("Unexpected parsing") }

        raw.close()

        verify(response).close()
    }

    @Test
    fun closesAfterParsingOrdinaryBody() {
        val response = mock<HttpResponse>()
        val raw = response.parseable { "body" }

        assertThat(raw.parse()).isEqualTo("body")
        raw.close()

        verify(response).close()
    }

    @Test
    fun closesAfterParseFailure() {
        val response = mock<HttpResponse>()
        val error = IllegalStateException("Cannot parse")
        val raw = response.parseable<String> { throw error }

        assertThatThrownBy { raw.parse() }.isSameAs(error)
        raw.close()

        verify(response).close()
    }

    @Test
    fun closesTransportWhenParsedReaderCloseFails() {
        val response = mock<HttpResponse>()
        val error = IOException("Reader close failed")
        whenever(response.body())
            .thenReturn(
                object : ByteArrayInputStream(byteArrayOf()) {
                    override fun close() {
                        throw error
                    }
                }
            )
        val raw =
            response.parseable {
                streamHandler<String> { _, lines -> yieldAll(lines) }.handle(response)
            }
        raw.parse()

        assertThatThrownBy { raw.close() }.isSameAs(error)

        verify(response).close()
    }

    @Test
    fun closesTransportToUnblockParsedReader() {
        val reading = CountDownLatch(1)
        val releaseRead = CountDownLatch(1)
        val response = mock<HttpResponse>()
        whenever(response.body())
            .thenReturn(
                object : InputStream() {
                    override fun read(): Int {
                        reading.countDown()
                        releaseRead.await()
                        return -1
                    }
                }
            )
        doAnswer {
                releaseRead.countDown()
                null
            }
            .whenever(response)
            .close()
        val raw =
            response.parseable {
                streamHandler<String> { _, lines -> yieldAll(lines) }.handle(response)
            }
        val executor = Executors.newFixedThreadPool(2)
        try {
            val readFuture = executor.submit { raw.parse().stream().forEach {} }
            assertThat(reading.await(5, TimeUnit.SECONDS)).isTrue()

            executor.submit { raw.close() }.get(5, TimeUnit.SECONDS)
            readFuture.get(5, TimeUnit.SECONDS)

            verify(response).close()
        } finally {
            releaseRead.countDown()
            executor.shutdownNow()
            assertThat(executor.awaitTermination(5, TimeUnit.SECONDS)).isTrue()
        }
    }
}
