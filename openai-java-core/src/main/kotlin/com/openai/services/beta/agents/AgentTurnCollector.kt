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
                if (sessionId == null) sessionId = it.sessionOrThrow().idOrThrow()
            }
            event.turnCreated().getOrNull()?.turnOrThrow()?.let {
                if (
                    turn == null &&
                        !it.subagentId().isPresent &&
                        (sessionId == null || sessionId == it.sessionIdOrThrow())
                ) {
                    turn = it
                    sessionId = it.sessionIdOrThrow()
                }
            }
            val updated =
                event.turnInProgress().getOrNull()?.turnOrThrow()
                    ?: event.turnCompleted().getOrNull()?.turnOrThrow()
                    ?: event.turnFailed().getOrNull()?.turnOrThrow()
                    ?: event.turnCancelled().getOrNull()?.turnOrThrow()
            if (
                updated != null &&
                    updated.idOrThrow() == turn?.idOrThrow() &&
                    updated.sessionIdOrThrow() == sessionId
            ) {
                turn = updated
                if (event.isTurnCompleted()) {
                    completed = true
                    pending = emptyList()
                }
                if (event.isTurnFailed()) failure = error(Reason.TURN_FAILED)
                if (event.isTurnCancelled()) failure = error(Reason.TURN_CANCELLED)
            }
            event.turnItemDone().getOrNull()?.let {
                val message = it.itemOrThrow().message().getOrNull()
                if (
                    message != null &&
                        it.sessionIdOrThrow() == sessionId &&
                        message.turnIdOrThrow() == turn?.idOrThrow()
                ) {
                    if (
                        message.phase().getOrNull() == AgentSessionAssistantMessage.Phase.COMMENTARY
                    )
                        messages.remove(message.idOrThrow())
                    else
                        messages[message.idOrThrow()] =
                            it.outputIndexOrThrow() to normalize(message)
                }
            }
            event.requiresAction().getOrNull()?.sessionOrThrow()?.let {
                if (it.idOrThrow() == sessionId && !completed)
                    pending =
                        it.requiredActionsOrThrow().filter { action ->
                            action.functionCall().getOrNull()?.nameOrThrow() !in handledTools
                        }
            }
            event.inProgress().getOrNull()?.sessionOrThrow()?.let {
                if (it.idOrThrow() == sessionId) pending = emptyList()
            }
            event.failed().getOrNull()?.sessionOrThrow()?.let {
                if (sessionId == null || it.idOrThrow() == sessionId)
                    failure = error(Reason.TURN_FAILED)
            }
            if (event.isError()) failure = error(Reason.STREAM_ERROR)
            event.idle().getOrNull()?.sessionOrThrow()?.let {
                if (completed && it.idOrThrow() == sessionId) idle = true
            }
        } catch (cause: Exception) {
            failure = error(Reason.STREAM_ERROR, cause)
        }
    }

    private fun normalize(message: AgentSessionAssistantMessage): AgentSessionMessage =
        AgentSessionMessage.builder()
            .id(message.idOrThrow())
            .turnId(message.turnIdOrThrow())
            .role(AgentSessionMessage.Role.ASSISTANT)
            .phase(message.phase().map { AgentSessionMessage.Phase.of(it.toString()) })
            .status(message.statusOrThrow())
            .content(
                message.contentOrThrow().map {
                    AgentSessionMessageContent.ofOutputText(
                        AgentSessionMessageContent.OutputText.builder()
                            .text(it.textOrThrow())
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
