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

    // A null content index denotes function-call arguments, which belong to the output item.
    private data class Position(val output: Long, val content: Long? = null)

    private val fragments = mutableMapOf<Position, StringBuilder>()

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
        if (fragments.isEmpty()) return Optional.of(current)
        val output = current._output().asKnown().orElse(null) ?: return Optional.of(current)
        val items =
            output.mapIndexed { index, item ->
                val arguments = fragments[Position(index.toLong())]
                val call = item.functionCall().orElse(null)
                if (call != null && arguments != null) {
                    return@mapIndexed ResponseOutputItem.ofFunctionCall(
                        call.toBuilder().arguments(arguments.toString()).build()
                    )
                }
                val message = item.message().orElse(null) ?: return@mapIndexed item
                val parts = message._content().asKnown().orElse(null) ?: return@mapIndexed item
                val content =
                    parts.mapIndexed content@{ contentIndex, part ->
                        val text =
                            fragments[Position(index.toLong(), contentIndex.toLong())]
                                ?: return@content part
                        val outputText = part.outputText().orElse(null)
                        if (outputText != null) {
                            ResponseOutputMessage.Content.ofOutputText(
                                outputText.toBuilder().text(text.toString()).build()
                            )
                        } else {
                            val refusal = part.refusal().orElse(null) ?: return@content part
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
                ) {}

                override fun visitCustomToolCallInputDone(
                    customToolCallInputDone: ResponseCustomToolCallInputDoneEvent
                ) {}

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
                            fragments.remove(
                                Position(
                                    contentPartAdded.outputIndex(),
                                    contentPartAdded.contentIndex(),
                                )
                            )
                            content
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
                            fragments.remove(
                                Position(
                                    contentPartDone.outputIndex(),
                                    contentPartDone.contentIndex(),
                                )
                            )
                            content
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
                        null,
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
                        fragments.remove(Position(functionCallArgumentsDone.outputIndex()))
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
                        updateItem(outputItemAdded.outputIndex()) {
                            val item = outputItemAdded.item()
                            fragments.keys.removeAll { it.output == outputItemAdded.outputIndex() }
                            item
                        }
                }

                override fun visitOutputItemDone(outputItemDone: ResponseOutputItemDoneEvent) {
                    if (snapshotsEnabled)
                        updateItem(outputItemDone.outputIndex()) {
                            val item = outputItemDone.item()
                            fragments.keys.removeAll { it.output == outputItemDone.outputIndex() }
                            item
                        }
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
                        val refusal = content?.refusal()?.orElse(null) ?: return@updateContent null
                        val result =
                            ResponseOutputMessage.Content.ofRefusal(
                                refusal.toBuilder().refusal(refusalDone.refusal()).build()
                            )
                        fragments.remove(
                            Position(refusalDone.outputIndex(), refusalDone.contentIndex())
                        )
                        result
                    }
                }

                override fun visitOutputTextDelta(outputTextDelta: ResponseTextDeltaEvent) {
                    if (!snapshotsEnabled) return
                    appendContent(
                        outputTextDelta.outputIndex(),
                        outputTextDelta.contentIndex(),
                        outputTextDelta._itemId(),
                        outputTextDelta.delta(),
                    ) { content ->
                        content.outputText().orElse(null)?._text()?.asKnown()?.orElse(null)
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
                            content?.outputText()?.orElse(null) ?: return@updateContent null
                        val result =
                            ResponseOutputMessage.Content.ofOutputText(
                                outputText.toBuilder().text(outputTextDone.text()).build()
                            )
                        fragments.remove(
                            Position(outputTextDone.outputIndex(), outputTextDone.contentIndex())
                        )
                        result
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
                        val text = content?.outputText()?.orElse(null) ?: return@updateContent null
                        val annotations =
                            text._annotations().asKnown().orElse(null)?.toMutableList()
                                ?: return@updateContent null
                        if (annotationIndex < 0 || annotationIndex > annotations.size.toLong())
                            return@updateContent null
                        // The generated event and output unions are distinct Kotlin types with
                        // the same wire form. Preserve additional fields, including future kinds.
                        val converted =
                            JsonValue.from(annotation)
                                .convert(ResponseOutputText.Annotation::class.java)
                                ?: return@updateContent null
                        val index = annotationIndex.toInt()
                        if (index == annotations.size) annotations.add(converted)
                        else annotations[index] = converted
                        ResponseOutputMessage.Content.ofOutputText(
                            text.toBuilder().annotations(annotations).build()
                        )
                    }
                }

                // Ignore unknown variants for forwards compatibility.
                override fun unknown(json: JsonValue?) {}
            }
        )

        if (response != null) {
            fragments.clear()
            materialized = null
            partial = null
        }
        return event
    }

    private fun replacePartial(value: Response) {
        partial = value
        materialized = null
        fragments.clear()
    }

    private fun append(
        outputIndex: Long,
        contentIndex: Long?,
        expectedId: JsonField<String>,
        delta: String,
        initial: (ResponseOutputItem) -> String?,
    ) {
        val output = partial?._output()?.asKnown()?.orElse(null) ?: return
        if (outputIndex < 0 || outputIndex >= output.size.toLong()) return
        val item = output[outputIndex.toInt()]
        if (!matchesId(item, expectedId)) return
        val text = initial(item) ?: return
        fragments
            .getOrPut(Position(outputIndex, contentIndex)) { StringBuilder(text) }
            .append(delta)
        materialized = null
    }

    private fun appendContent(
        outputIndex: Long,
        contentIndex: Long,
        expectedId: JsonField<String>,
        delta: String,
        initial: (ResponseOutputMessage.Content) -> String?,
    ) {
        append(outputIndex, contentIndex, expectedId, delta) { item ->
            val parts =
                item.message().orElse(null)?._content()?.asKnown()?.orElse(null)
                    ?: return@append null
            if (contentIndex < 0 || contentIndex >= parts.size.toLong()) return@append null
            initial(parts[contentIndex.toInt()])
        }
    }

    private fun matchesId(item: ResponseOutputItem?, expectedId: JsonField<String>): Boolean {
        val expected = expectedId.asKnown().orElse(null) ?: return false
        val actual =
            item?.message()?.orElse(null)?._id() ?: item?.functionCall()?.orElse(null)?._id()
        return actual?.asKnown()?.orElse(null) == expected
    }

    // Never allocate invented items/parts to fill a missing index. A missing output/content field
    // likewise remains missing: only apply deltas for which the preceding data was observed.
    private fun updateItem(
        index: Long,
        expectedId: JsonField<String>? = null,
        update: (ResponseOutputItem?) -> ResponseOutputItem?,
    ) {
        val current = partial ?: return
        val output = current._output().asKnown().orElse(null)?.toMutableList() ?: return
        if (index < 0 || index > output.size.toLong()) return
        val i = index.toInt()
        val previous = output.getOrNull(i)
        // Full output-item events replace the index. Subsequent deltas/parts must name the
        // current item; never let a late event for an older occupant change its replacement.
        if (expectedId != null && !matchesId(previous, expectedId)) return
        val item = update(previous) ?: return
        if (i == output.size) output.add(item) else output[i] = item
        partial = current.toBuilder().output(output).build()
        materialized = null
    }

    private fun updateContent(
        outputIndex: Long,
        contentIndex: Long,
        expectedId: JsonField<String>,
        update: (ResponseOutputMessage.Content?) -> ResponseOutputMessage.Content?,
    ) {
        updateItem(outputIndex, expectedId) { item ->
            val message = item?.message()?.orElse(null) ?: return@updateItem null
            val content =
                message._content().asKnown().orElse(null)?.toMutableList() ?: return@updateItem null
            if (contentIndex < 0 || contentIndex > content.size.toLong()) return@updateItem null
            val i = contentIndex.toInt()
            val part = update(content.getOrNull(i)) ?: return@updateItem null
            if (i == content.size) content.add(part) else content[i] = part
            ResponseOutputItem.ofMessage(message.toBuilder().content(content).build())
        }
    }
}
