package com.openai.services.beta.agents

import com.openai.models.beta.agents.AgentSessionMessage
import com.openai.models.beta.agents.sessions.turns.Turn
import java.util.Collections

/**
 * The completed root turn and its final assistant messages. This helper is part of the beta Agents
 * API.
 */
class AgentTurnResult
internal constructor(private val turn: Turn, messages: List<AgentSessionMessage>) {
    private val messages = Collections.unmodifiableList(messages.toList())

    fun turn(): Turn = turn

    /** Final answers in output order, excluding commentary and child turns. */
    fun messages(): List<AgentSessionMessage> = messages

    fun sessionId(): String = turn.sessionId()

    fun turnId(): String = turn.id()

    /** Joins output-text blocks without separators. Reading the result never makes a request. */
    fun outputText(): String =
        messages.joinToString("") { message ->
            message.content().joinToString("") {
                it.outputText().map { text -> text.text() }.orElse("")
            }
        }
}
