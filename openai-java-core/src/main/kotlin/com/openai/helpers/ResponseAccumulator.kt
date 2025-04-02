package com.openai.helpers

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
import com.openai.models.responses.ResponseInProgressEvent
import com.openai.models.responses.ResponseIncompleteEvent
import com.openai.models.responses.ResponseOutputItemAddedEvent
import com.openai.models.responses.ResponseOutputItemDoneEvent
import com.openai.models.responses.ResponseRefusalDeltaEvent
import com.openai.models.responses.ResponseRefusalDoneEvent
import com.openai.models.responses.ResponseStreamEvent
import com.openai.models.responses.ResponseTextAnnotationDeltaEvent
import com.openai.models.responses.ResponseTextDeltaEvent
import com.openai.models.responses.ResponseTextDoneEvent
import com.openai.models.responses.ResponseWebSearchCallCompletedEvent
import com.openai.models.responses.ResponseWebSearchCallInProgressEvent
import com.openai.models.responses.ResponseWebSearchCallSearchingEvent

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
     * Accumulates a streamed event and uses it to construct a [Response]. When all events have been
     * accumulated, the response can be retrieved by calling [response].
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
                // The following events _all_ have a `Response` property.

                override fun visitCreated(created: ResponseCreatedEvent) {
                    // TODO: Taking not action here on the assumption that there is no need to store
                    //   the initial `Response` (devoid of any content), as it will be replaced
                    //   later by one of the "terminal" events. OTOH, this could be useful if the
                    //   events stop suddenly before any further response details can be recorded.
                }

                override fun visitInProgress(inProgress: ResponseInProgressEvent) {
                    // TODO: Taking no action here on the assumption that this is just some sort of
                    //   "keep-alive" event that carries no new data that needs to be accumulated.
                    //   OTOH, if the events stop suddenly, this could be used as a "partial"
                    //   response, or an ongoing "story so far".
                }

                override fun visitCompleted(completed: ResponseCompletedEvent) {
                    response = completed.response()
                }

                override fun visitFailed(failed: ResponseFailedEvent) {
                    // TODO: Confirm that this is a "terminal" event and will occur _instead of_
                    //   `ResponseCompletedEvent`.
                    response = failed.response()
                }

                override fun visitIncomplete(incomplete: ResponseIncompleteEvent) {
                    // TODO: Confirm that this is a "terminal" event and will occur _instead of_
                    //   `ResponseCompletedEvent`.
                    response = incomplete.response()
                }

                // --------------------------------------------------------------------------------
                // The following events do _not_ have a `Response` property.

                override fun visitError(error: ResponseErrorEvent) {}

                override fun visitOutputItemAdded(outputItemAdded: ResponseOutputItemAddedEvent) {}

                override fun visitOutputItemDone(outputItemDone: ResponseOutputItemDoneEvent) {}

                override fun visitContentPartAdded(
                    contentPartAdded: ResponseContentPartAddedEvent
                ) {}

                override fun visitContentPartDone(contentPartDone: ResponseContentPartDoneEvent) {}

                override fun visitOutputTextDelta(outputTextDelta: ResponseTextDeltaEvent) {}

                override fun visitOutputTextAnnotationAdded(
                    outputTextAnnotationAdded: ResponseTextAnnotationDeltaEvent
                ) {}

                override fun visitOutputTextDone(outputTextDone: ResponseTextDoneEvent) {}

                override fun visitRefusalDelta(refusalDelta: ResponseRefusalDeltaEvent) {}

                override fun visitRefusalDone(refusalDone: ResponseRefusalDoneEvent) {}

                override fun visitFunctionCallArgumentsDelta(
                    functionCallArgumentsDelta: ResponseFunctionCallArgumentsDeltaEvent
                ) {}

                override fun visitFunctionCallArgumentsDone(
                    functionCallArgumentsDone: ResponseFunctionCallArgumentsDoneEvent
                ) {}

                override fun visitFileSearchCallInProgress(
                    fileSearchCallInProgress: ResponseFileSearchCallInProgressEvent
                ) {}

                override fun visitFileSearchCallSearching(
                    fileSearchCallSearching: ResponseFileSearchCallSearchingEvent
                ) {}

                override fun visitFileSearchCallCompleted(
                    fileSearchCallCompleted: ResponseFileSearchCallCompletedEvent
                ) {}

                override fun visitWebSearchCallInProgress(
                    webSearchCallInProgress: ResponseWebSearchCallInProgressEvent
                ) {}

                override fun visitWebSearchCallSearching(
                    webSearchCallSearching: ResponseWebSearchCallSearchingEvent
                ) {}

                override fun visitWebSearchCallCompleted(
                    webSearchCallCompleted: ResponseWebSearchCallCompletedEvent
                ) {}

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

                override fun visitCodeInterpreterCallInProgress(
                    codeInterpreterCallInProgress: ResponseCodeInterpreterCallInProgressEvent
                ) {}

                override fun visitCodeInterpreterCallInterpreting(
                    codeInterpreterCallInterpreting: ResponseCodeInterpreterCallInterpretingEvent
                ) {}

                override fun visitCodeInterpreterCallCompleted(
                    codeInterpreterCallCompleted: ResponseCodeInterpreterCallCompletedEvent
                ) {}
            }
        )

        return event
    }
}
