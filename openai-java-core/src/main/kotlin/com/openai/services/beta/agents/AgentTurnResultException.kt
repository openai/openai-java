package com.openai.services.beta.agents

import com.openai.errors.OpenAIException
import com.openai.models.beta.agents.AgentSession
import com.openai.models.beta.agents.AgentSessionMessage
import com.openai.models.beta.agents.sessions.turns.Turn
import java.util.Collections
import java.util.Optional

/**
 * A beta Agents outcome or observation failure. Observation failure does not cancel the hosted
 * turn.
 */
class AgentTurnResultException
internal constructor(
    private val reason: Reason,
    private val turn: Turn?,
    private val sessionId: String?,
    messages: List<AgentSessionMessage>,
    requiredActions: List<AgentSession.RequiredAction> = emptyList(),
    cause: Throwable? = null,
) : OpenAIException("Could not collect the Agents turn result: $reason", cause) {
    enum class Reason {
        TURN_FAILED,
        TURN_CANCELLED,
        REQUIRES_ACTION,
        INCOMPLETE_STREAM,
        NO_SELECTED_TURN,
        STREAM_ERROR,
        CLOSED,
    }

    private val messages = Collections.unmodifiableList(messages.toList())
    private val requiredActions = Collections.unmodifiableList(requiredActions.toList())

    fun reason(): Reason = reason

    fun turn(): Optional<Turn> = Optional.ofNullable(turn)

    fun sessionId(): Optional<String> = Optional.ofNullable(sessionId)

    fun turnId(): Optional<String> = Optional.ofNullable(turn?.id())

    /** Completed assistant messages available before collection stopped. */
    fun messages(): List<AgentSessionMessage> = messages

    fun requiredActions(): List<AgentSession.RequiredAction> = requiredActions
}
