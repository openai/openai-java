package com.openai.core.http

import com.openai.core.CancellationPropagatingFuture
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.util.concurrent.CompletionException
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class PipelineResponseLeaseTest {
    @Test
    fun voidTerminalPropagatesPipelineResponseCloseFailure() {
        val failure = IllegalStateException("close failed")
        val response =
            object : HttpResponse {
                override fun statusCode(): Int = 200

                override fun headers(): Headers = Headers.builder().build()

                override fun body(): InputStream = ByteArrayInputStream(ByteArray(0))

                override fun close(): Unit = throw failure
            }

        val terminal =
            CancellationPropagatingFuture.completed(response.asPipelineOwned()).thenAccept {
                it.closeIfPipelineOwned()
            }

        assertThatThrownBy(terminal::join)
            .isInstanceOf(CompletionException::class.java)
            .hasCause(failure)
    }
}
