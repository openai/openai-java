package com.openai.helpers

import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.responses.Response
import com.openai.models.responses.ResponseAudioDeltaEvent
import com.openai.models.responses.ResponseAudioDoneEvent
import com.openai.models.responses.ResponseAudioTranscriptDeltaEvent
import com.openai.models.responses.ResponseAudioTranscriptDoneEvent
import com.openai.models.responses.ResponseCodeInterpreterCallCodeDeltaEvent
import com.openai.models.responses.ResponseCodeInterpreterCallCodeDoneEvent
import com.openai.models.responses.ResponseCodeInterpreterCallCompletedEvent
import com.openai.models.responses.ResponseCodeInterpreterCallInProgressEvent
import com.openai.models.responses.ResponseCodeInterpreterCallInterpretingEvent
import com.openai.models.responses.ResponseCompletedEvent
import com.openai.models.responses.ResponseContentPartAddedEvent
import com.openai.models.responses.ResponseContentPartDoneEvent
import com.openai.models.responses.ResponseCreatedEvent
import com.openai.models.responses.ResponseErrorEvent
import com.openai.models.responses.ResponseFailedEvent
import com.openai.models.responses.ResponseFileSearchCallCompletedEvent
import com.openai.models.responses.ResponseFileSearchCallInProgressEvent
import com.openai.models.responses.ResponseFileSearchCallSearchingEvent
import com.openai.models.responses.ResponseFunctionCallArgumentsDeltaEvent
import com.openai.models.responses.ResponseFunctionCallArgumentsDoneEvent
import com.openai.models.responses.ResponseImageGenCallCompletedEvent
import com.openai.models.responses.ResponseImageGenCallGeneratingEvent
import com.openai.models.responses.ResponseImageGenCallInProgressEvent
import com.openai.models.responses.ResponseImageGenCallPartialImageEvent
import com.openai.models.responses.ResponseInProgressEvent
import com.openai.models.responses.ResponseIncompleteEvent
import com.openai.models.responses.ResponseMcpCallArgumentsDeltaEvent
import com.openai.models.responses.ResponseMcpCallArgumentsDoneEvent
import com.openai.models.responses.ResponseMcpCallCompletedEvent
import com.openai.models.responses.ResponseMcpCallFailedEvent
import com.openai.models.responses.ResponseMcpCallInProgressEvent
import com.openai.models.responses.ResponseMcpListToolsCompletedEvent
import com.openai.models.responses.ResponseMcpListToolsFailedEvent
import com.openai.models.responses.ResponseMcpListToolsInProgressEvent
import com.openai.models.responses.ResponseOutputItemAddedEvent
import com.openai.models.responses.ResponseOutputItemDoneEvent
import com.openai.models.responses.ResponseOutputTextAnnotationAddedEvent
import com.openai.models.responses.ResponseQueuedEvent
import com.openai.models.responses.ResponseReasoningDeltaEvent
import com.openai.models.responses.ResponseReasoningDoneEvent
import com.openai.models.responses.ResponseReasoningSummaryDeltaEvent
import com.openai.models.responses.ResponseReasoningSummaryDoneEvent
import com.openai.models.responses.ResponseReasoningSummaryPartAddedEvent
import com.openai.models.responses.ResponseReasoningSummaryPartDoneEvent
import com.openai.models.responses.ResponseReasoningSummaryTextDeltaEvent
import com.openai.models.responses.ResponseReasoningSummaryTextDoneEvent
import com.openai.models.responses.ResponseRefusalDeltaEvent
import com.openai.models.responses.ResponseRefusalDoneEvent
import com.openai.models.responses.ResponseStreamEvent
import com.openai.models.responses.ResponseTextDeltaEvent
import com.openai.models.responses.ResponseTextDoneEvent
import com.openai.models.responses.ResponseWebSearchCallCompletedEvent
import com.openai.models.responses.ResponseWebSearchCallInProgressEvent
import com.openai.models.responses.ResponseWebSearchCallSearchingEvent
import com.openai.models.responses.StructuredResponse

/**
 * An accumulator that constructs a [Response] from a sequence of streamed events. Pass all events
 * to [accumulate] and then call [response] to get the final accumulated response. The final
 * `Response` will be similar to what would have been received had the non-streaming API been used.
 *
 * A [ResponseAccumulator] may only be used to accumulate _one_ response. To accumulate another
 * response, create another instance of `ResponseAccumulator`.
 */
class ResponseAccumulator private constructor() {

    /**
     * The response accumulated from the event stream. This is set when a terminal event is
     * accumulated. That single event carries all the response details.
     */
    private var response: Response? = null

    companion object {
        @JvmStatic fun create() = ResponseAccumulator()
    }

    /**
     * Gets the final accumulated response. Until the last event has been accumulated, a [Response]
     * will not be available. Wait until all events have been handled by [accumulate] before calling
     * this method.
     *
     * @throws IllegalStateException If called before the stream has been completed.
     */
    fun response() = checkNotNull(response) { "Completed response is not yet received." }

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
    fun <T : Any> response(responseType: Class<T>) = StructuredResponse(responseType, response())

    /**
     * Accumulates a streamed event and uses it to construct a [Response]. When all events have been
     * accumulated, the response can be retrieved by calling [response]. The last event is detected
     * if one of `ResponseCompletedEvent`, `ResponseIncompleteEvent`, or `ResponseFailedEvent` is
     * accumulated. After that event, no more events are expected.
     *
     * @return The given [event] for convenience, such as when chaining method calls.
     * @throws IllegalStateException If [accumulate] is called again after the last event has been
     *   accumulated. A [ResponseAccumulator] can only be used to accumulate a single [Response].
     */
    fun accumulate(event: ResponseStreamEvent): ResponseStreamEvent {
        check(response == null) { "Response has already been completed." }

        event.accept(
            object : ResponseStreamEvent.Visitor<Unit> {
                // --------------------------------------------------------------------------------
                // The following events _all_ have a `response` property.

                override fun visitCreated(created: ResponseCreatedEvent) {
                    // The initial response (on creation) has no content, so it is not stored.
                }

                override fun visitCompleted(completed: ResponseCompletedEvent) {
                    response = completed.response()
                }

                override fun visitInProgress(inProgress: ResponseInProgressEvent) {
                    // An in-progress response is not complete, so it is not stored.
                }

                override fun visitQueued(queued: ResponseQueuedEvent) {
                    // A queued response that is awaiting processing is not complete, so it is not
                    // stored.
                }

                override fun visitFailed(failed: ResponseFailedEvent) {
                    // TODO: Confirm that this is a "terminal" event and will occur _instead of_
                    //   `ResponseCompletedEvent` or `ResponseIncompleteEvent`.
                    // Store the response so the reason for the failure can be interrogated.
                    response = failed.response()
                }

                override fun visitIncomplete(incomplete: ResponseIncompleteEvent) {
                    // TODO: Confirm that this is a "terminal" event and will occur _instead of_
                    //   `ResponseCompletedEvent` or `ResponseFailedEvent`.
                    // Store the response so the reason for the incompleteness can be interrogated.
                    response = incomplete.response()
                }

                // --------------------------------------------------------------------------------
                // The following events do _not_ have a `Response` property.

                override fun visitAudioDelta(audioDelta: ResponseAudioDeltaEvent) {}

                override fun visitAudioDone(audioDone: ResponseAudioDoneEvent) {}

                override fun visitAudioTranscriptDelta(
                    audioTranscriptDelta: ResponseAudioTranscriptDeltaEvent
                ) {}

                override fun visitAudioTranscriptDone(
                    audioTranscriptDone: ResponseAudioTranscriptDoneEvent
                ) {}

                override fun visitCodeInterpreterCallCodeDelta(
                    codeInterpreterCallCodeDelta: ResponseCodeInterpreterCallCodeDeltaEvent
                ) {}

                override fun visitCodeInterpreterCallCodeDone(
                    codeInterpreterCallCodeDone: ResponseCodeInterpreterCallCodeDoneEvent
                ) {}

                override fun visitCodeInterpreterCallCompleted(
                    codeInterpreterCallCompleted: ResponseCodeInterpreterCallCompletedEvent
                ) {}

                override fun visitCodeInterpreterCallInProgress(
                    codeInterpreterCallInProgress: ResponseCodeInterpreterCallInProgressEvent
                ) {}

                override fun visitCodeInterpreterCallInterpreting(
                    codeInterpreterCallInterpreting: ResponseCodeInterpreterCallInterpretingEvent
                ) {}

                override fun visitContentPartAdded(
                    contentPartAdded: ResponseContentPartAddedEvent
                ) {}

                override fun visitContentPartDone(contentPartDone: ResponseContentPartDoneEvent) {}

                override fun visitError(error: ResponseErrorEvent) {}

                override fun visitFileSearchCallCompleted(
                    fileSearchCallCompleted: ResponseFileSearchCallCompletedEvent
                ) {}

                override fun visitFileSearchCallInProgress(
                    fileSearchCallInProgress: ResponseFileSearchCallInProgressEvent
                ) {}

                override fun visitFileSearchCallSearching(
                    fileSearchCallSearching: ResponseFileSearchCallSearchingEvent
                ) {}

                override fun visitFunctionCallArgumentsDelta(
                    functionCallArgumentsDelta: ResponseFunctionCallArgumentsDeltaEvent
                ) {}

                override fun visitFunctionCallArgumentsDone(
                    functionCallArgumentsDone: ResponseFunctionCallArgumentsDoneEvent
                ) {}

                override fun visitOutputItemAdded(outputItemAdded: ResponseOutputItemAddedEvent) {}

                override fun visitOutputItemDone(outputItemDone: ResponseOutputItemDoneEvent) {}

                override fun visitReasoningSummaryPartAdded(
                    reasoningSummaryPartAdded: ResponseReasoningSummaryPartAddedEvent
                ) {}

                override fun visitReasoningSummaryPartDone(
                    reasoningSummaryPartDone: ResponseReasoningSummaryPartDoneEvent
                ) {}

                override fun visitReasoningSummaryTextDelta(
                    reasoningSummaryTextDelta: ResponseReasoningSummaryTextDeltaEvent
                ) {}

                override fun visitReasoningSummaryTextDone(
                    reasoningSummaryTextDone: ResponseReasoningSummaryTextDoneEvent
                ) {}

                override fun visitRefusalDelta(refusalDelta: ResponseRefusalDeltaEvent) {}

                override fun visitRefusalDone(refusalDone: ResponseRefusalDoneEvent) {}

                override fun visitOutputTextDelta(outputTextDelta: ResponseTextDeltaEvent) {}

                override fun visitOutputTextDone(outputTextDone: ResponseTextDoneEvent) {}

                override fun visitWebSearchCallCompleted(
                    webSearchCallCompleted: ResponseWebSearchCallCompletedEvent
                ) {}

                override fun visitWebSearchCallInProgress(
                    webSearchCallInProgress: ResponseWebSearchCallInProgressEvent
                ) {}

                override fun visitWebSearchCallSearching(
                    webSearchCallSearching: ResponseWebSearchCallSearchingEvent
                ) {}

                override fun visitImageGenerationCallCompleted(
                    imageGenerationCallCompleted: ResponseImageGenCallCompletedEvent
                ) {}

                override fun visitImageGenerationCallGenerating(
                    imageGenerationCallGenerating: ResponseImageGenCallGeneratingEvent
                ) {}

                override fun visitImageGenerationCallInProgress(
                    imageGenerationCallInProgress: ResponseImageGenCallInProgressEvent
                ) {}

                override fun visitImageGenerationCallPartialImage(
                    imageGenerationCallPartialImage: ResponseImageGenCallPartialImageEvent
                ) {}

                override fun visitMcpCallArgumentsDelta(
                    mcpCallArgumentsDelta: ResponseMcpCallArgumentsDeltaEvent
                ) {}

                override fun visitMcpCallArgumentsDone(
                    mcpCallArgumentsDone: ResponseMcpCallArgumentsDoneEvent
                ) {}

                override fun visitMcpCallCompleted(
                    mcpCallCompleted: ResponseMcpCallCompletedEvent
                ) {}

                override fun visitMcpCallFailed(mcpCallFailed: ResponseMcpCallFailedEvent) {}

                override fun visitMcpCallInProgress(
                    mcpCallInProgress: ResponseMcpCallInProgressEvent
                ) {}

                override fun visitMcpListToolsCompleted(
                    mcpListToolsCompleted: ResponseMcpListToolsCompletedEvent
                ) {}

                override fun visitMcpListToolsFailed(
                    mcpListToolsFailed: ResponseMcpListToolsFailedEvent
                ) {}

                override fun visitMcpListToolsInProgress(
                    mcpListToolsInProgress: ResponseMcpListToolsInProgressEvent
                ) {}

                override fun visitOutputTextAnnotationAdded(
                    outputTextAnnotationAdded: ResponseOutputTextAnnotationAddedEvent
                ) {}

                override fun visitReasoningDelta(reasoningDelta: ResponseReasoningDeltaEvent) {}

                override fun visitReasoningDone(reasoningDone: ResponseReasoningDoneEvent) {}

                override fun visitReasoningSummaryDelta(
                    reasoningSummaryDelta: ResponseReasoningSummaryDeltaEvent
                ) {}

                override fun visitReasoningSummaryDone(
                    reasoningSummaryDone: ResponseReasoningSummaryDoneEvent
                ) {}
            }
        )

        return event
    }
}
