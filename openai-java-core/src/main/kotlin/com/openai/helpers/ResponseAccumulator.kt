package com.openai.helpers

import com.openai.core.JsonField
import com.openai.core.JsonValue
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
import com.openai.models.responses.ResponseCompactionCompactingEvent
import com.openai.models.responses.ResponseCompletedEvent
import com.openai.models.responses.ResponseContentPartAddedEvent
import com.openai.models.responses.ResponseContentPartDoneEvent
import com.openai.models.responses.ResponseCreatedEvent
import com.openai.models.responses.ResponseCustomToolCallInputDeltaEvent
import com.openai.models.responses.ResponseCustomToolCallInputDoneEvent
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
import com.openai.models.responses.ResponseOutputItem
import com.openai.models.responses.ResponseOutputItemAddedEvent
import com.openai.models.responses.ResponseOutputItemDoneEvent
import com.openai.models.responses.ResponseOutputMessage
import com.openai.models.responses.ResponseOutputText
import com.openai.models.responses.ResponseOutputTextAnnotationAddedEvent
import com.openai.models.responses.ResponseQueuedEvent
import com.openai.models.responses.ResponseReasoningSummaryPartAddedEvent
import com.openai.models.responses.ResponseReasoningSummaryPartDoneEvent
import com.openai.models.responses.ResponseReasoningSummaryTextDeltaEvent
import com.openai.models.responses.ResponseReasoningSummaryTextDoneEvent
import com.openai.models.responses.ResponseReasoningTextDeltaEvent
import com.openai.models.responses.ResponseReasoningTextDoneEvent
import com.openai.models.responses.ResponseRefusalDeltaEvent
import com.openai.models.responses.ResponseRefusalDoneEvent
import com.openai.models.responses.ResponseShellCallCommandAddedEvent
import com.openai.models.responses.ResponseShellCallCommandDeltaEvent
import com.openai.models.responses.ResponseShellCallCommandDoneEvent
import com.openai.models.responses.ResponseShellCallOutputContentDeltaEvent
import com.openai.models.responses.ResponseShellCallOutputContentDoneEvent
import com.openai.models.responses.ResponseStreamEvent
import com.openai.models.responses.ResponseTextDeltaEvent
import com.openai.models.responses.ResponseTextDoneEvent
import com.openai.models.responses.ResponseWebSearchCallCompletedEvent
import com.openai.models.responses.ResponseWebSearchCallInProgressEvent
import com.openai.models.responses.ResponseWebSearchCallSearchingEvent
import com.openai.models.responses.StructuredResponse
import java.util.Optional

/**
 * An accumulator that constructs a [Response] from a sequence of streamed events. Pass all events
 * to [accumulate] and then call [response] to get the final accumulated response. The final
 * `Response` will be similar to what would have been received had the non-streaming API been used.
 *
 * A [ResponseAccumulator] may only be used to accumulate _one_ response. To accumulate another
 * response, create another instance of `ResponseAccumulator`.
 */
class ResponseAccumulator private constructor(private val snapshotsEnabled: Boolean) {

    /**
     * The response accumulated from the event stream. This is set when a terminal event is
     * accumulated. That single event carries all the response details.
     */
    private var response: Response? = null
    private var partial: Response? = null
    private var materialized: Response? = null

    private class PendingItem(val item: ResponseOutputItem) {
        var input: StringBuilder? = null
        val content =
            item
                .message()
                .orElse(null)
                ?._content()
                ?.asKnown()
                ?.orElse(null)
                ?.map { PendingContent(it) }
                ?.toMutableList()
    }

    private class PendingContent(var part: ResponseOutputMessage.Content) {
        var text: StringBuilder? = null
        var annotations: MutableList<ResponseOutputText.Annotation>? = null
        var logprobs: MutableList<ResponseOutputText.Logprob>? = null
    }

    private var output: MutableList<PendingItem>? = null

    companion object {
        @JvmStatic fun create() = ResponseAccumulator(false)

        /**
         * Opts into incremental snapshots for this single response (or WebSocket lane). Raw events
         * remain available from [accumulate]. Tool calls are data; this helper never executes them.
         */
        @JvmStatic fun createWithSnapshots() = ResponseAccumulator(true)
    }

    /**
     * The most recently observed response, including incremental output text, refusal and function
     * call arguments. Empty until a response-bearing event arrives. Fields the server omitted
     * remain omitted. A snapshot is not a completed response: only [response] requires a terminal
     * event. Failed and incomplete terminal events replace the snapshot with their full response.
     * Other item kinds are retained when output-item events arrive and in the raw stream.
     *
     * Use [createWithSnapshots] to enable this method. One accumulator handles one response only.
     */
    fun snapshot(): Optional<Response> {
        check(snapshotsEnabled) { "Snapshots require ResponseAccumulator.createWithSnapshots()." }
        if (response != null) return Optional.ofNullable(response)
        val current = partial ?: return Optional.empty()
        materialized?.let {
            return Optional.of(it)
        }
        val output = output ?: return Optional.of(current)
        val items =
            output.map { pending ->
                val item = pending.item
                val arguments = pending.input
                val call = item.functionCall().orElse(null)
                if (call != null && arguments != null) {
                    return@map ResponseOutputItem.ofFunctionCall(
                        call.toBuilder().arguments(arguments.toString()).build()
                    )
                }
                val custom = item.customToolCall().orElse(null)
                if (custom != null && arguments != null) {
                    return@map ResponseOutputItem.ofCustomToolCall(
                        custom.toBuilder().input(arguments.toString()).build()
                    )
                }
                val message = item.message().orElse(null) ?: return@map item
                val parts = pending.content ?: return@map item
                val content =
                    parts.map content@{ data ->
                        val part = data.part
                        val text = data.text
                        val outputText = part.outputText().orElse(null)
                        if (outputText != null) {
                            if (text == null && data.annotations == null && data.logprobs == null)
                                return@content part
                            val builder = outputText.toBuilder()
                            if (text != null) builder.text(text.toString())
                            data.annotations?.let { builder.annotations(it) }
                            data.logprobs?.let { builder.logprobs(it) }
                            ResponseOutputMessage.Content.ofOutputText(builder.build())
                        } else {
                            val refusal = part.refusal().orElse(null)
                            if (refusal == null || text == null) return@content part
                            ResponseOutputMessage.Content.ofRefusal(
                                refusal.toBuilder().refusal(text.toString()).build()
                            )
                        }
                    }
                ResponseOutputItem.ofMessage(message.toBuilder().content(content).build())
            }
        return Optional.of(current.toBuilder().output(items).build().also { materialized = it })
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
     * Accumulates a Responses WebSocket event while returning the same event for raw processing.
     * Use one accumulator per response or lane. Unknown and nonterminal events do not change the
     * final snapshot. Protocol errors remain available on the returned event for caller handling.
     */
    fun accumulate(
        event: com.openai.models.responses.ResponsesServerEvent
    ): com.openai.models.responses.ResponsesServerEvent {
        event.responseCompleted().ifPresent { accumulate(ResponseStreamEvent.ofCompleted(it)) }
        event.responseFailed().ifPresent { accumulate(ResponseStreamEvent.ofFailed(it)) }
        event.responseIncomplete().ifPresent { accumulate(ResponseStreamEvent.ofIncomplete(it)) }
        if (snapshotsEnabled && response == null) {
            event.responseCreated().ifPresent { accumulate(ResponseStreamEvent.ofCreated(it)) }
            event.responseInProgress().ifPresent {
                accumulate(ResponseStreamEvent.ofInProgress(it))
            }
            event.responseQueued().ifPresent { accumulate(ResponseStreamEvent.ofQueued(it)) }
            event.responseOutputItemAdded().ifPresent {
                accumulate(ResponseStreamEvent.ofOutputItemAdded(it))
            }
            event.responseOutputItemDone().ifPresent {
                accumulate(ResponseStreamEvent.ofOutputItemDone(it))
            }
            event.responseContentPartAdded().ifPresent {
                accumulate(ResponseStreamEvent.ofContentPartAdded(it))
            }
            event.responseContentPartDone().ifPresent {
                accumulate(ResponseStreamEvent.ofContentPartDone(it))
            }
            event.responseOutputTextDelta().ifPresent {
                accumulate(ResponseStreamEvent.ofOutputTextDelta(it))
            }
            event.responseOutputTextDone().ifPresent {
                accumulate(ResponseStreamEvent.ofOutputTextDone(it))
            }
            event.responseOutputTextAnnotationAdded().ifPresent {
                accumulate(ResponseStreamEvent.ofOutputTextAnnotationAdded(it))
            }
            event.responseRefusalDelta().ifPresent {
                accumulate(ResponseStreamEvent.ofRefusalDelta(it))
            }
            event.responseRefusalDone().ifPresent {
                accumulate(ResponseStreamEvent.ofRefusalDone(it))
            }
            event.responseFunctionCallArgumentsDelta().ifPresent {
                accumulate(ResponseStreamEvent.ofFunctionCallArgumentsDelta(it))
            }
            event.responseFunctionCallArgumentsDone().ifPresent {
                accumulate(ResponseStreamEvent.ofFunctionCallArgumentsDone(it))
            }
            event.responseCustomToolCallInputDelta().ifPresent {
                accumulate(ResponseStreamEvent.ofCustomToolCallInputDelta(it))
            }
            event.responseCustomToolCallInputDone().ifPresent {
                accumulate(ResponseStreamEvent.ofCustomToolCallInputDone(it))
            }
        }
        return event
    }

    /**
     * Accumulates a streamed event and uses it to construct a [Response]. When all events have been
     * accumulated, the response can be retrieved by calling [response]. The last event is detected
     * if one of `ResponseCompletedEvent`, `ResponseIncompleteEvent`, or `ResponseFailedEvent` is
     * accumulated. After that event, additional stream events may still arrive, but they do not
     * affect the accumulated response.
     *
     * @return The given [event] for convenience, such as when chaining method calls.
     */
    fun accumulate(event: ResponseStreamEvent): ResponseStreamEvent {
        // The API may send non-response events (e.g. `response.rate_limits.updated`) after a
        // terminal event (`response.completed`, `response.failed`, `response.incomplete`). These
        // events do not change the accumulated response.
        if (response != null) {
            return event
        }

        event.accept(
            object : ResponseStreamEvent.Visitor<Unit> {
                // --------------------------------------------------------------------------------
                // The following events _all_ have a `response` property.

                override fun visitCreated(created: ResponseCreatedEvent) {
                    if (snapshotsEnabled) replacePartial(created.response())
                }

                override fun visitCompleted(completed: ResponseCompletedEvent) {
                    response = completed.response()
                }

                override fun visitInProgress(inProgress: ResponseInProgressEvent) {
                    if (snapshotsEnabled) replacePartial(inProgress.response())
                }

                override fun visitQueued(queued: ResponseQueuedEvent) {
                    if (snapshotsEnabled) replacePartial(queued.response())
                }

                override fun visitCustomToolCallInputDelta(
                    customToolCallInputDelta: ResponseCustomToolCallInputDeltaEvent
                ) {
                    if (!snapshotsEnabled) return
                    append(
                        customToolCallInputDelta.outputIndex(),
                        customToolCallInputDelta._itemId(),
                        customToolCallInputDelta.delta(),
                    ) { item ->
                        item.customToolCall().orElse(null)?._input()?.asKnown()?.orElse(null)
                    }
                }

                override fun visitCustomToolCallInputDone(
                    customToolCallInputDone: ResponseCustomToolCallInputDoneEvent
                ) {
                    if (!snapshotsEnabled) return
                    updateItem(
                        customToolCallInputDone.outputIndex(),
                        customToolCallInputDone._itemId(),
                    ) { item ->
                        val call = item?.customToolCall()?.orElse(null) ?: return@updateItem null
                        ResponseOutputItem.ofCustomToolCall(
                            call.toBuilder().input(customToolCallInputDone.input()).build()
                        )
                    }
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

                override fun visitCompactionCompacting(
                    compactionCompacting: ResponseCompactionCompactingEvent
                ) {}

                override fun visitContentPartAdded(
                    contentPartAdded: ResponseContentPartAddedEvent
                ) {
                    if (!snapshotsEnabled) return
                    val part = contentPartAdded.part()
                    val content =
                        part
                            .outputText()
                            .map(ResponseOutputMessage.Content::ofOutputText)
                            .orElseGet {
                                part
                                    .refusal()
                                    .map(ResponseOutputMessage.Content::ofRefusal)
                                    .orElse(null)
                            }
                    if (content != null)
                        updateContent(
                            contentPartAdded.outputIndex(),
                            contentPartAdded.contentIndex(),
                            contentPartAdded._itemId(),
                        ) {
                            PendingContent(content)
                        }
                }

                override fun visitContentPartDone(contentPartDone: ResponseContentPartDoneEvent) {
                    if (!snapshotsEnabled) return
                    val part = contentPartDone.part()
                    val content =
                        part
                            .outputText()
                            .map(ResponseOutputMessage.Content::ofOutputText)
                            .orElseGet {
                                part
                                    .refusal()
                                    .map(ResponseOutputMessage.Content::ofRefusal)
                                    .orElse(null)
                            }
                    if (content != null)
                        updateContent(
                            contentPartDone.outputIndex(),
                            contentPartDone.contentIndex(),
                            contentPartDone._itemId(),
                        ) {
                            PendingContent(content)
                        }
                }

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
                ) {
                    if (!snapshotsEnabled) return
                    append(
                        functionCallArgumentsDelta.outputIndex(),
                        functionCallArgumentsDelta._itemId(),
                        functionCallArgumentsDelta.delta(),
                    ) { item ->
                        item.functionCall().orElse(null)?._arguments()?.asKnown()?.orElse(null)
                    }
                }

                override fun visitFunctionCallArgumentsDone(
                    functionCallArgumentsDone: ResponseFunctionCallArgumentsDoneEvent
                ) {
                    if (!snapshotsEnabled) return
                    updateItem(
                        functionCallArgumentsDone.outputIndex(),
                        functionCallArgumentsDone._itemId(),
                    ) { item ->
                        val call = item?.functionCall()?.orElse(null) ?: return@updateItem null
                        val result =
                            ResponseOutputItem.ofFunctionCall(
                                call
                                    .toBuilder()
                                    .arguments(functionCallArgumentsDone.arguments())
                                    .build()
                            )
                        result
                    }
                }

                override fun visitShellCallCommandAdded(
                    shellCallCommandAdded: ResponseShellCallCommandAddedEvent
                ) {}

                override fun visitShellCallCommandDelta(
                    shellCallCommandDelta: ResponseShellCallCommandDeltaEvent
                ) {}

                override fun visitShellCallCommandDone(
                    shellCallCommandDone: ResponseShellCallCommandDoneEvent
                ) {}

                override fun visitShellCallOutputContentDelta(
                    shellCallOutputContentDelta: ResponseShellCallOutputContentDeltaEvent
                ) {}

                override fun visitShellCallOutputContentDone(
                    shellCallOutputContentDone: ResponseShellCallOutputContentDoneEvent
                ) {}

                override fun visitOutputItemAdded(outputItemAdded: ResponseOutputItemAddedEvent) {
                    if (snapshotsEnabled)
                        updateItem(outputItemAdded.outputIndex()) { outputItemAdded.item() }
                }

                override fun visitOutputItemDone(outputItemDone: ResponseOutputItemDoneEvent) {
                    if (snapshotsEnabled)
                        updateItem(outputItemDone.outputIndex()) { outputItemDone.item() }
                }

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

                override fun visitReasoningTextDelta(
                    reasoningTextDelta: ResponseReasoningTextDeltaEvent
                ) {}

                override fun visitReasoningTextDone(
                    reasoningTextDone: ResponseReasoningTextDoneEvent
                ) {}

                override fun visitRefusalDelta(refusalDelta: ResponseRefusalDeltaEvent) {
                    if (!snapshotsEnabled) return
                    appendContent(
                        refusalDelta.outputIndex(),
                        refusalDelta.contentIndex(),
                        refusalDelta._itemId(),
                        refusalDelta.delta(),
                    ) { content ->
                        content.refusal().orElse(null)?._refusal()?.asKnown()?.orElse(null)
                    }
                }

                override fun visitRefusalDone(refusalDone: ResponseRefusalDoneEvent) {
                    if (!snapshotsEnabled) return
                    updateContent(
                        refusalDone.outputIndex(),
                        refusalDone.contentIndex(),
                        refusalDone._itemId(),
                    ) { content ->
                        val refusal =
                            content?.part?.refusal()?.orElse(null) ?: return@updateContent null
                        val result =
                            ResponseOutputMessage.Content.ofRefusal(
                                refusal.toBuilder().refusal(refusalDone.refusal()).build()
                            )
                        content.part = result
                        content.text = null
                        content
                    }
                }

                override fun visitOutputTextDelta(outputTextDelta: ResponseTextDeltaEvent) {
                    if (!snapshotsEnabled) return
                    val part =
                        appendContent(
                            outputTextDelta.outputIndex(),
                            outputTextDelta.contentIndex(),
                            outputTextDelta._itemId(),
                            outputTextDelta.delta(),
                        ) { content ->
                            content.outputText().orElse(null)?._text()?.asKnown()?.orElse(null)
                        } ?: return
                    val probabilities = outputTextDelta._logprobs().asKnown().orElse(null) ?: return
                    val buffer =
                        part.logprobs
                            ?: part.part
                                .asOutputText()
                                ._logprobs()
                                .asKnown()
                                .orElse(emptyList())
                                .toMutableList()
                                .also { part.logprobs = it }
                    probabilities.forEach {
                        JsonValue.from(it)
                            .convert(ResponseOutputText.Logprob::class.java)
                            ?.let(buffer::add)
                    }
                }

                override fun visitOutputTextDone(outputTextDone: ResponseTextDoneEvent) {
                    if (!snapshotsEnabled) return
                    updateContent(
                        outputTextDone.outputIndex(),
                        outputTextDone.contentIndex(),
                        outputTextDone._itemId(),
                    ) { content ->
                        val outputText =
                            content?.part?.outputText()?.orElse(null) ?: return@updateContent null
                        val result =
                            ResponseOutputMessage.Content.ofOutputText(
                                outputText.toBuilder().text(outputTextDone.text()).build()
                            )
                        val probabilities = outputTextDone._logprobs().asKnown().orElse(null)
                        val converted =
                            probabilities?.mapNotNull {
                                JsonValue.from(it).convert(ResponseOutputText.Logprob::class.java)
                            }
                        content.part = result
                        content.text = null
                        if (converted != null) content.logprobs = converted.toMutableList()
                        content
                    }
                }

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
                ) {
                    if (!snapshotsEnabled) return
                    val annotation =
                        outputTextAnnotationAdded._annotation().asKnown().orElse(null) ?: return
                    val annotationIndex =
                        outputTextAnnotationAdded._annotationIndex().asKnown().orElse(null)
                            ?: return
                    updateContent(
                        outputTextAnnotationAdded.outputIndex(),
                        outputTextAnnotationAdded.contentIndex(),
                        outputTextAnnotationAdded._itemId(),
                    ) { content ->
                        val text =
                            content?.part?.outputText()?.orElse(null) ?: return@updateContent null
                        val previous =
                            text._annotations().asKnown().orElse(null) ?: return@updateContent null
                        if (
                            annotationIndex < 0 ||
                                annotationIndex > (content.annotations ?: previous).size.toLong()
                        )
                            return@updateContent null
                        // The generated event and output unions are distinct Kotlin types with
                        // the same wire form. Preserve additional fields, including future kinds.
                        val converted =
                            JsonValue.from(annotation)
                                .convert(ResponseOutputText.Annotation::class.java)
                                ?: return@updateContent null
                        val annotations = content.annotations ?: previous.toMutableList()
                        val index = annotationIndex.toInt()
                        if (index == annotations.size) annotations.add(converted)
                        else annotations[index] = converted
                        content.annotations = annotations
                        content
                    }
                }

                // Ignore unknown variants for forwards compatibility.
                override fun unknown(json: JsonValue?) {}
            }
        )

        if (response != null) {
            output = null
            materialized = null
            partial = null
        }
        return event
    }

    private fun replacePartial(value: Response) {
        partial = value
        materialized = value
        output = value._output().asKnown().orElse(null)?.map { PendingItem(it) }?.toMutableList()
    }

    private fun append(
        outputIndex: Long,
        expectedId: JsonField<String>,
        delta: String,
        initial: (ResponseOutputItem) -> String?,
    ) {
        val output = output ?: return
        if (outputIndex < 0 || outputIndex >= output.size.toLong()) return
        val data = output[outputIndex.toInt()]
        if (!matchesId(data.item, expectedId)) return
        val text = initial(data.item) ?: return
        val buffer = data.input ?: StringBuilder(text).also { data.input = it }
        buffer.append(delta)
        materialized = null
    }

    private fun appendContent(
        outputIndex: Long,
        contentIndex: Long,
        expectedId: JsonField<String>,
        delta: String,
        initial: (ResponseOutputMessage.Content) -> String?,
    ): PendingContent? {
        val output = output ?: return null
        if (outputIndex < 0 || outputIndex >= output.size.toLong()) return null
        val item = output[outputIndex.toInt()]
        if (!matchesId(item.item, expectedId)) return null
        val parts = item.content ?: return null
        if (contentIndex < 0 || contentIndex >= parts.size.toLong()) return null
        val part = parts[contentIndex.toInt()]
        val text = initial(part.part) ?: return null
        val buffer = part.text ?: StringBuilder(text).also { part.text = it }
        buffer.append(delta)
        materialized = null
        return part
    }

    private fun matchesId(item: ResponseOutputItem?, expectedId: JsonField<String>): Boolean {
        val expected = expectedId.asKnown().orElse(null) ?: return false
        val actual =
            item?.message()?.orElse(null)?._id()
                ?: item?.functionCall()?.orElse(null)?._id()
                ?: item?.customToolCall()?.orElse(null)?._id()
        return actual?.asKnown()?.orElse(null) == expected
    }

    // Never allocate invented items/parts to fill a missing index. A missing output/content field
    // likewise remains missing: only apply deltas for which the preceding data was observed.
    private fun updateItem(
        index: Long,
        expectedId: JsonField<String>? = null,
        update: (ResponseOutputItem?) -> ResponseOutputItem?,
    ) {
        val output = output ?: return
        if (index < 0 || index > output.size.toLong()) return
        val i = index.toInt()
        val previous = output.getOrNull(i)?.item
        // Full output-item events replace the index. Subsequent deltas/parts must name the
        // current item; never let a late event for an older occupant change its replacement.
        if (expectedId != null && !matchesId(previous, expectedId)) return
        val item = update(previous) ?: return
        if (i == output.size) output.add(PendingItem(item)) else output[i] = PendingItem(item)
        materialized = null
    }

    private fun updateContent(
        outputIndex: Long,
        contentIndex: Long,
        expectedId: JsonField<String>,
        update: (PendingContent?) -> PendingContent?,
    ) {
        val output = output ?: return
        if (outputIndex < 0 || outputIndex >= output.size.toLong()) return
        val item = output[outputIndex.toInt()]
        if (!matchesId(item.item, expectedId)) return
        val content = item.content ?: return
        if (contentIndex < 0 || contentIndex > content.size.toLong()) return
        val i = contentIndex.toInt()
        val part = update(content.getOrNull(i)) ?: return
        if (i == content.size) content.add(part) else content[i] = part
        materialized = null
    }
}
