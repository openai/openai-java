package com.openai.helpers

import com.openai.core.JsonNull
import com.openai.models.ResponsesModel
import com.openai.models.responses.Response
import com.openai.models.responses.ResponseCompletedEvent
import com.openai.models.responses.ResponseCreatedEvent
import com.openai.models.responses.ResponseFailedEvent
import com.openai.models.responses.ResponseInProgressEvent
import com.openai.models.responses.ResponseIncompleteEvent
import com.openai.models.responses.ResponseOutputItem
import com.openai.models.responses.ResponseOutputMessage
import com.openai.models.responses.ResponseOutputText
import com.openai.models.responses.ResponseStreamEvent
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatNoException
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class ResponseAccumulatorTest {

    @Test
    fun responseBeforeAccumulation() {
        val accumulator = ResponseAccumulator.create()

        assertThatThrownBy { accumulator.response() }
            .isExactlyInstanceOf(IllegalStateException::class.java)
            .hasMessage("Completed response is not yet received.")
    }

    @Test
    fun structuredResponseBeforeAccumulation() {
        val accumulator = ResponseAccumulator.create()

        assertThatThrownBy { accumulator.response(String::class.java) }
            .isExactlyInstanceOf(IllegalStateException::class.java)
            .hasMessage("Completed response is not yet received.")
    }

    @Test
    fun responseAfterAccumulation() {
        val accumulator = ResponseAccumulator.create()

        accumulator.accumulate(ResponseStreamEvent.ofCompleted(responseCompletedEvent()))

        assertThatNoException().isThrownBy { accumulator.response() }
        assertThat(accumulator.response().id()).isEqualTo("response-id")
    }

    @Test
    fun structuredResponseAfterAccumulation() {
        val accumulator = ResponseAccumulator.create()

        accumulator.accumulate(ResponseStreamEvent.ofCompleted(responseCompletedEvent()))

        // No deserialization is attempted, so the `Class<T>` does not matter. Deserialization is
        // beyond the scope of this test; it is tested elsewhere at a lower level.
        assertThatNoException().isThrownBy { accumulator.response(String::class.java) }
        assertThat(accumulator.response(String::class.java).id()).isEqualTo("response-id")
        assertThat(accumulator.response(String::class.java).responseType)
            .isEqualTo(String::class.java)
    }

    @Test
    fun accumulateAfterCompleted() {
        val accumulator = ResponseAccumulator.create()

        accumulator.accumulate(ResponseStreamEvent.ofCompleted(responseCompletedEvent()))

        assertThatThrownBy {
                accumulator.accumulate(ResponseStreamEvent.ofCompleted(responseCompletedEvent()))
            }
            .isExactlyInstanceOf(IllegalStateException::class.java)
            .hasMessage("Response has already been completed.")
    }

    @Test
    fun accumulateUntilCompleted() {
        val accumulator = ResponseAccumulator.create()

        accumulator.accumulate(ResponseStreamEvent.ofCreated(responseCreatedEvent()))
        accumulator.accumulate(ResponseStreamEvent.ofInProgress(responseInProgressEvent()))
        accumulator.accumulate(ResponseStreamEvent.ofInProgress(responseInProgressEvent()))
        accumulator.accumulate(ResponseStreamEvent.ofInProgress(responseInProgressEvent()))
        accumulator.accumulate(ResponseStreamEvent.ofCompleted(responseCompletedEvent()))

        val response = accumulator.response()

        assertThat(response.id()).isEqualTo("response-id")
    }

    @Test
    fun accumulateUntilIncomplete() {
        val accumulator = ResponseAccumulator.create()

        accumulator.accumulate(ResponseStreamEvent.ofCreated(responseCreatedEvent()))
        accumulator.accumulate(ResponseStreamEvent.ofInProgress(responseInProgressEvent()))
        accumulator.accumulate(ResponseStreamEvent.ofInProgress(responseInProgressEvent()))
        accumulator.accumulate(ResponseStreamEvent.ofInProgress(responseInProgressEvent()))
        accumulator.accumulate(ResponseStreamEvent.ofIncomplete(responseIncompleteEvent()))

        val response = accumulator.response()

        assertThat(response.id()).isEqualTo("response-id")
    }

    @Test
    fun accumulateUntilFailed() {
        val accumulator = ResponseAccumulator.create()

        accumulator.accumulate(ResponseStreamEvent.ofCreated(responseCreatedEvent()))
        accumulator.accumulate(ResponseStreamEvent.ofInProgress(responseInProgressEvent()))
        accumulator.accumulate(ResponseStreamEvent.ofInProgress(responseInProgressEvent()))
        accumulator.accumulate(ResponseStreamEvent.ofInProgress(responseInProgressEvent()))
        accumulator.accumulate(ResponseStreamEvent.ofFailed(responseFailedEvent()))

        val response = accumulator.response()

        assertThat(response.id()).isEqualTo("response-id")
    }

    private fun responseCreatedEvent() =
        ResponseCreatedEvent.builder().response(response()).sequenceNumber(1L).build()

    private fun responseInProgressEvent() =
        ResponseInProgressEvent.builder().response(response()).sequenceNumber(1L).build()

    private fun responseCompletedEvent() =
        ResponseCompletedEvent.builder().response(response()).sequenceNumber(1L).build()

    private fun responseFailedEvent() =
        ResponseFailedEvent.builder().response(response()).sequenceNumber(1L).build()

    private fun responseIncompleteEvent() =
        ResponseIncompleteEvent.builder().response(response()).sequenceNumber(1L).build()

    private fun response() =
        Response.builder()
            .id("response-id")
            .createdAt(System.currentTimeMillis() / 1_000.0)
            .error(null)
            .incompleteDetails(null)
            .instructions(null)
            .metadata(null)
            .model(ResponsesModel.ResponsesOnlyModel.O1_PRO)
            .addOutput(responseOutputItemOfMessage())
            .parallelToolCalls(false)
            .temperature(null)
            .toolChoice(JsonNull.of())
            .tools(listOf())
            .topP(null)
            .build()

    private fun responseOutputItemOfMessage() =
        ResponseOutputItem.ofMessage(responseOutputMessage())

    private fun responseOutputMessage() =
        ResponseOutputMessage.builder()
            .id("message-id")
            .addContent(ResponseOutputMessage.Content.ofOutputText(responseOutputText()))
            .status(ResponseOutputMessage.Status.COMPLETED)
            .build()

    private fun responseOutputText() =
        ResponseOutputText.builder().text("Hello World").annotations(listOf()).build()
}
