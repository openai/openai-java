package com.openai.services.beta.agents

import com.openai.models.beta.agents.*
import com.openai.models.beta.agents.sessions.turns.Turn
import com.openai.services.beta.agents.AgentTurnResultException.Reason
import kotlin.jvm.optionals.getOrNull

/** Collects authoritative completed messages; no input submission or tool execution. */
internal class AgentTurnCollector(
    private val handledTools: Set<String> = emptySet(),
    private var sessionId: String? = null,
) {
    private var enabled = false
    private var started = false

    fun enable() {
        check(enabled || !started) {
            "Enable AgentTurnResults.withResultCollection(stream) before consuming events"
        }
        enabled = true
    }

    fun isEnabled(): Boolean = enabled

    private val messages = linkedMapOf<String, Pair<Long, AgentSessionMessage>>()
    private var turn: Turn? = null
    private var completed = false
    private var idle = false
    private var failure: AgentTurnResultException? = null
    private var pending: List<AgentSession.RequiredAction> = emptyList()
    private var result: AgentTurnResult? = null

    fun accept(event: AgentSessionEvent) {
        started = true
        if (!enabled) return
        if (failure != null || isReady()) return
        try {
            event.created().getOrNull()?.let {
                if (sessionId == null) sessionId = it.session().id()
            }
            event.turnCreated().getOrNull()?.turn()?.let {
                if (
                    turn == null &&
                        !it.subagentId().isPresent &&
                        (sessionId == null || sessionId == it.sessionId())
                ) {
                    turn = it
                    sessionId = it.sessionId()
                }
            }
            val updated =
                event.turnInProgress().getOrNull()?.turn()
                    ?: event.turnCompleted().getOrNull()?.turn()
                    ?: event.turnFailed().getOrNull()?.turn()
                    ?: event.turnCancelled().getOrNull()?.turn()
            if (updated != null && updated.id() == turn?.id() && updated.sessionId() == sessionId) {
                turn = updated
                if (event.isTurnCompleted()) {
                    completed = true
                    pending = emptyList()
                }
                if (event.isTurnFailed()) failure = error(Reason.TURN_FAILED)
                if (event.isTurnCancelled()) failure = error(Reason.TURN_CANCELLED)
            }
            event.turnItemDone().getOrNull()?.let {
                val message = it.item().message().getOrNull()
                if (
                    message != null && it.sessionId() == sessionId && message.turnId() == turn?.id()
                ) {
                    if (
                        message.phase().getOrNull() == AgentSessionAssistantMessage.Phase.COMMENTARY
                    )
                        messages.remove(message.id())
                    else messages[message.id()] = it.outputIndex() to normalize(message)
                }
            }
            event.requiresAction().getOrNull()?.session()?.let {
                if (it.id() == sessionId && !completed)
                    pending =
                        it.requiredActions().filter { action ->
                            action.functionCall().getOrNull()?.name() !in handledTools
                        }
            }
            event.inProgress().getOrNull()?.session()?.let {
                if (it.id() == sessionId) pending = emptyList()
            }
            event.failed().getOrNull()?.session()?.let {
                if (sessionId == null || it.id() == sessionId) failure = error(Reason.TURN_FAILED)
            }
            if (event.isError()) failure = error(Reason.STREAM_ERROR)
            event.idle().getOrNull()?.session()?.let {
                if (completed && it.id() == sessionId) idle = true
            }
        } catch (cause: Exception) {
            failure = error(Reason.STREAM_ERROR, cause)
        }
    }

    private fun normalize(message: AgentSessionAssistantMessage): AgentSessionMessage =
        AgentSessionMessage.builder()
            .id(message.id())
            .turnId(message.turnId())
            .role(AgentSessionMessage.Role.ASSISTANT)
            .phase(message.phase().map { AgentSessionMessage.Phase.of(it.toString()) })
            .status(message.status())
            .content(
                message.content().map {
                    AgentSessionMessageContent.ofOutputText(
                        AgentSessionMessageContent.OutputText.builder()
                            .text(it.text())
                            .putAllAdditionalProperties(it._additionalProperties())
                            .build()
                    )
                }
            )
            .putAllAdditionalProperties(message._additionalProperties())
            .build()

    fun isReady(): Boolean = idle && completed

    fun stoppingError(): AgentTurnResultException? =
        failure ?: if (pending.isNotEmpty()) error(Reason.REQUIRES_ACTION) else null

    fun closed() {
        if (enabled && !isReady() && stoppingError() == null) failure = error(Reason.CLOSED)
    }

    fun failed(cause: Throwable) {
        if (enabled && !isReady() && failure == null) failure = error(Reason.STREAM_ERROR, cause)
    }

    fun error(reason: Reason, cause: Throwable? = null): AgentTurnResultException =
        AgentTurnResultException(reason, turn, sessionId, finalMessages(), pending, cause)

    fun finalResult(): AgentTurnResult {
        result?.let {
            return it
        }
        stoppingError()?.let { throw it }
        if (!isReady()) throw error(Reason.INCOMPLETE_STREAM)
        return AgentTurnResult(requireNotNull(turn), finalMessages()).also {
            result = it
            messages.clear()
        }
    }

    private fun finalMessages(): List<AgentSessionMessage> =
        messages.values.sortedBy { it.first }.map { it.second }
}
