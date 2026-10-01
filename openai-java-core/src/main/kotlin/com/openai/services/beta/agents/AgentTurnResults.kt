package com.openai.services.beta.agents

import com.openai.core.http.AsyncStreamResponse
import com.openai.core.http.StreamResponse
import com.openai.models.beta.agents.AgentSessionEvent
import java.util.concurrent.CompletableFuture

/** Final-output helpers for beta Agents creation and follow-up streams. */
object AgentTurnResults {
    /**
     * Enables final-output collection before consuming progress events. Returns the same stream.
     */
    @JvmStatic
    fun withResultCollection(
        stream: StreamResponse<AgentSessionEvent>
    ): StreamResponse<AgentSessionEvent> =
        stream.apply {
            requireNotNull(this as? AgentTurnResultStream) {
                    "Use a beta Agents sessions createStreaming() or stream() response"
                }
                .enableResultCollection()
        }

    /**
     * Enables final-output collection before subscribing to progress events. Returns the same
     * stream.
     */
    @JvmStatic
    fun withResultCollection(
        stream: AsyncStreamResponse<AgentSessionEvent>
    ): AsyncStreamResponse<AgentSessionEvent> =
        stream.apply {
            requireNotNull(this as? AgentTurnResultStreamAsync) {
                    "Use a beta Agents sessions createStreaming() or stream() response"
                }
                .enableResultCollection()
        }

    /**
     * Consumes the remaining events and returns the selected root turn's final answer. Collection
     * is enabled automatically on a fresh stream. To consume progress first, call
     * withResultCollection() before reading events. Existing tool handlers continue to run. The
     * result is cached; repeated calls do not submit input or run handlers again.
     *
     * Accepts streams returned by beta agents sessions createStreaming() and stream(). The caller
     * must not consume the stream concurrently with this method. Creation streams require initial
     * input; consume input-less creation as a raw stream. Input-less stream() attaches to existing
     * work; an already-idle session without a selected turn has no final result.
     */
    @JvmStatic
    fun getFinalResult(stream: StreamResponse<AgentSessionEvent>): AgentTurnResult =
        requireNotNull(stream as? AgentTurnResultStream) {
                "Use a beta Agents sessions createStreaming() or stream() response"
            }
            .finalResult()

    /**
     * Subscribes when needed, or joins an existing subscription. The returned future completes with
     * a final answer or an [AgentTurnResultException] retaining the available partial state.
     * Cancelling the future closes observation without cancelling hosted execution. Creation
     * streams require initial input; enable withResultCollection() before subscribing to progress
     * events.
     */
    @JvmStatic
    fun getFinalResult(
        stream: AsyncStreamResponse<AgentSessionEvent>
    ): CompletableFuture<AgentTurnResult> =
        requireNotNull(stream as? AgentTurnResultStreamAsync) {
                "Use a beta Agents sessions createStreaming() or stream() response"
            }
            .finalResult()

    /** Collects a completed turn and parses it; the session must already use this output schema. */
    @JvmStatic
    fun <T : Any> getFinalResult(
        stream: StreamResponse<AgentSessionEvent>,
        outputType: AgentOutputType<T>,
    ): ParsedAgentTurnResult<T> = outputType.parse(getFinalResult(stream))

    /**
     * Async typed collection; does not submit schema updates or change existing session settings.
     */
    @JvmStatic
    fun <T : Any> getFinalResult(
        stream: AsyncStreamResponse<AgentSessionEvent>,
        outputType: AgentOutputType<T>,
    ): CompletableFuture<ParsedAgentTurnResult<T>> {
        val raw = getFinalResult(stream)
        val parsed = raw.thenApply(outputType::parse)
        parsed.whenComplete { _, _ -> if (parsed.isCancelled) raw.cancel(true) }
        return parsed
    }

    /** The async adapter installs its own collector; do not retain an unused sync collector. */
    @JvmSynthetic
    internal fun uncollected(
        stream: StreamResponse<AgentSessionEvent>
    ): StreamResponse<AgentSessionEvent> = (stream as? AgentTurnResultStream)?.source ?: stream

    @JvmSynthetic
    internal fun collecting(
        stream: StreamResponse<AgentSessionEvent>,
        handledTools: Set<String> = emptySet(),
        sessionId: String? = null,
    ): StreamResponse<AgentSessionEvent> =
        AgentTurnResultStream(
            stream,
            (stream as? AgentSessionStream)?.collector
                ?: AgentTurnCollector(handledTools, sessionId),
        )

    @JvmSynthetic
    internal fun collecting(
        stream: AsyncStreamResponse<AgentSessionEvent>,
        handledTools: Set<String> = emptySet(),
        sessionId: String? = null,
    ): AsyncStreamResponse<AgentSessionEvent> =
        AgentTurnResultStreamAsync(
            stream,
            (stream as? AgentSessionStreamAsync)?.collector
                ?: AgentTurnCollector(handledTools, sessionId),
        )
}
