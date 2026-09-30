package com.openai.services.beta.agents

import com.openai.core.http.AsyncStreamResponse
import com.openai.core.http.StreamResponse
import com.openai.models.beta.agents.AgentSessionEvent
import java.util.concurrent.CompletableFuture

/** Final-output helpers for beta Agents creation and follow-up streams. */
object AgentTurnResults {
    /**
     * Consumes the remaining events and returns the selected root turn's final answer. Events
     * already consumed through stream() are included. Existing tool handlers continue to run. The
     * result is cached; repeated calls do not submit input or run handlers again.
     *
     * Accepts streams returned by beta agents sessions createStreaming() and stream(). The caller
     * must not consume the stream concurrently with this method.
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
     * Cancelling the future closes observation without cancelling hosted execution.
     */
    @JvmStatic
    fun getFinalResult(
        stream: AsyncStreamResponse<AgentSessionEvent>
    ): CompletableFuture<AgentTurnResult> =
        requireNotNull(stream as? AgentTurnResultStreamAsync) {
                "Use a beta Agents sessions createStreaming() or stream() response"
            }
            .finalResult()

    @JvmSynthetic
    internal fun collecting(
        stream: StreamResponse<AgentSessionEvent>,
        handledTools: Set<String> = emptySet(),
        sessionId: String? = null,
    ): StreamResponse<AgentSessionEvent> =
        AgentTurnResultStream(stream, AgentTurnCollector(handledTools, sessionId))

    @JvmSynthetic
    internal fun collecting(
        stream: AsyncStreamResponse<AgentSessionEvent>,
        handledTools: Set<String> = emptySet(),
        sessionId: String? = null,
    ): AsyncStreamResponse<AgentSessionEvent> =
        AgentTurnResultStreamAsync(stream, AgentTurnCollector(handledTools, sessionId))
}
