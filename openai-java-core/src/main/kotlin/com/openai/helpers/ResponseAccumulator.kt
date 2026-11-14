package com.openai.helpers

import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.responses.Response
import com.openai.models.responses.ResponseStreamEvent
import com.openai.models.responses.ResponsesServerEvent
import com.openai.models.responses.StructuredResponse
import com.openai.responses.helpers.ResponseAccumulator as ResponsesAccumulator
import java.util.Optional

/**
 * An accumulator that constructs a [Response] from a sequence of streamed events. Pass all events
 * to [accumulate] and then call [response] to get the final accumulated response. The final
 * `Response` will be similar to what would have been received had the non-streaming API been used.
 *
 * A [ResponseAccumulator] may only be used to accumulate _one_ response. To accumulate another
 * response, create another instance of `ResponseAccumulator`.
 */
class ResponseAccumulator private constructor(snapshotsEnabled: Boolean) {

    private val delegate =
        if (snapshotsEnabled) ResponsesAccumulator.createWithSnapshots()
        else ResponsesAccumulator.create()

    companion object {
        @JvmStatic fun create() = ResponseAccumulator(false)

        /**
         * Opts into incremental snapshots for this single response (or WebSocket lane). Raw events
         * remain available from [accumulate]. Tool calls are data; this helper never executes them.
         */
        @JvmStatic fun createWithSnapshots() = ResponseAccumulator(true)
    }

    /**
     * The most recently observed response, including incremental output text, refusal, function and
     * MCP call arguments. Empty until a response-bearing event arrives. Fields the server omitted
     * remain omitted. A snapshot is not a completed response: only [response] requires a terminal
     * event. Failed and incomplete terminal events replace the snapshot with their full response.
     * Other item kinds are retained when output-item events arrive and in the raw stream.
     *
     * Use [createWithSnapshots] to enable this method. One accumulator handles one response only.
     */
    fun snapshot(): Optional<Response> = delegate.snapshot()

    /**
     * Gets the final accumulated response. Until the last event has been accumulated, a [Response]
     * will not be available. Wait until all events have been handled by [accumulate] before calling
     * this method.
     *
     * @throws IllegalStateException If called before the stream has been completed.
     */
    fun response(): Response = delegate.response()

    /**
     * Returns the terminal response, filling omitted or null output with finalized output items.
     * This opt-in compatibility accessor requires [createWithSnapshots]. It leaves [response] and
     * [snapshot] unchanged: any supplied non-null terminal output, including an empty list, wins.
     *
     * Only `response.output_item.done` records contribute to reconstructed output, sorted by their
     * output index. Sparse indices are accepted; no finalized records produces an empty list.
     * Partial items and deltas never become final output. The terminal status, errors, usage and
     * other metadata remain authoritative, including for failed and incomplete responses.
     *
     * This method reads no events from the socket and never executes tool calls.
     *
     * @throws IllegalStateException If snapshots are disabled, no terminal response has arrived, or
     *   a WebSocket protocol error was observed before the terminal response.
     */
    fun reconstructedResponse(): Response = delegate.reconstructedResponse()

    /**
     * Gets the final accumulated response with support for structured outputs. Until the last event
     * has been accumulated, a [StructuredResponse] will not be available. Wait until all events
     * have been handled by [accumulate] before calling this method. See that method for more
     * details on how the last event is detected. See the
     * [SDK documentation](https://github.com/openai/openai-java/#usage-with-streaming) for more
     * details and example code.
     *
     * @param responseType The Java class from which the JSON schema in the request was derived. The
     *   output JSON conforming to that schema can be converted automatically back to an instance of
     *   that Java class by the [StructuredResponse].
     * @throws IllegalStateException If called before the last event has been accumulated.
     * @throws OpenAIInvalidDataException If the JSON data cannot be parsed to an instance of the
     *   [responseType] class.
     */
    fun <T : Any> response(responseType: Class<T>): StructuredResponse<T> =
        delegate.response(responseType)

    /**
     * Accumulates a Responses WebSocket event while returning the same event for raw processing.
     * Use one accumulator per response or lane. Unknown and nonterminal events do not change the
     * final snapshot. Protocol errors remain available on the returned event for caller handling.
     */
    fun accumulate(event: ResponsesServerEvent): ResponsesServerEvent = delegate.accumulate(event)

    /**
     * Accumulates a streamed event and uses it to construct a [Response]. When all events have been
     * accumulated, the response can be retrieved by calling [response]. The last event is detected
     * if one of `ResponseCompletedEvent`, `ResponseIncompleteEvent`, or `ResponseFailedEvent` is
     * accumulated. After that event, additional stream events may still arrive, but they do not
     * affect the accumulated response.
     *
     * @return The given [event] for convenience, such as when chaining method calls.
     */
    fun accumulate(event: ResponseStreamEvent): ResponseStreamEvent = delegate.accumulate(event)
}
