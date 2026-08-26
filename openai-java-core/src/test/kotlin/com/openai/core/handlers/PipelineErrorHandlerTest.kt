package com.openai.core.handlers

import com.openai.core.JsonField
import com.openai.core.http.Headers
import com.openai.core.http.HttpResponse
import com.openai.core.http.asPipelineOwned
import com.openai.models.ErrorObject
import java.io.ByteArrayInputStream
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class PipelineErrorHandlerTest {
    @Test
    fun statusInspectionFailureClosesPipelineResponse() {
        val failure = IllegalStateException("status unavailable")
        var closes = 0
        val response =
            object : HttpResponse {
                    override fun statusCode(): Int = throw failure

                    override fun headers(): Headers = Headers.builder().build()

                    override fun body() = ByteArrayInputStream(ByteArray(0))

                    override fun close() {
                        closes++
                    }
                }
                .asPipelineOwned()
        val handler =
            errorHandler(
                object : HttpResponse.Handler<JsonField<ErrorObject>> {
                    override fun handle(response: HttpResponse): JsonField<ErrorObject> =
                        error("unused")
                }
            )

        assertThatThrownBy { handler.handle(response) }.isSameAs(failure)
        assertThat(closes).isEqualTo(1)
    }
}
