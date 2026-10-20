package com.openai.core.http

import com.openai.core.MultipartField
import com.openai.core.jsonMapper
import java.io.IOException
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class MultipartBodyCleanupTest {

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `closing an upload attempts every part and preserves the first cleanup failure`(
        sharedFailure: Boolean
    ) {
        val firstFailure = IOException("first close failed")
        val secondFailure = if (sharedFailure) firstFailure else IOException("second close failed")
        val first = CloseRecordingInputStream(firstFailure)
        val second = CloseRecordingInputStream(secondFailure)
        val third = CloseRecordingInputStream()
        val body = upload(first, second, third)

        val failure = catchThrowable { body.close() }

        assertThat(failure).isSameAs(firstFailure)
        assertThat(listOf(first, second, third).map { it.closeCalls }).containsExactly(1, 1, 1)
        assertThat(listOf(first, second, third).map { it.readCalls }).containsExactly(0, 0, 0)
        if (sharedFailure) assertThat(failure.suppressed).isEmpty()
        else assertThat(failure.suppressed).containsExactly(secondFailure)
    }

    @Test
    fun `closing an unused upload releases every part without reading it`() {
        val first = CloseRecordingInputStream()
        val second = CloseRecordingInputStream()
        val body = upload(first, second)

        body.close()

        assertThat(first.closeCalls).isEqualTo(1)
        assertThat(second.closeCalls).isEqualTo(1)
        assertThat(first.readCalls).isZero()
        assertThat(second.readCalls).isZero()
    }

    private fun upload(vararg streams: InputStream): HttpRequestBody =
        multipartFormData(
            jsonMapper(),
            streams
                .mapIndexed { index, stream ->
                    "file-$index" to MultipartField.builder<InputStream>().value(stream).build()
                }
                .toMap(),
        )

    private class CloseRecordingInputStream(private val closeFailure: IOException? = null) :
        InputStream() {
        var readCalls = 0
        var closeCalls = 0

        override fun read(): Int {
            readCalls++
            return -1
        }

        override fun close() {
            closeCalls++
            closeFailure?.let { throw it }
        }
    }
}
