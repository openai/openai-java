package com.openai.services.beta.agents

import com.openai.models.beta.agents.*
import com.openai.models.beta.agents.sessions.turns.Turn
import com.openai.services.beta.agents.AgentTurnResultException.Reason
import kotlin.jvm.optionals.getOrNull

/** Event reduction only: no input submission, tool execution or network requests. */
internal class AgentTurnCollector(
    private val handledTools: Set<String> = emptySet(),
    private var sessionId: String? = null,
) {
    private data class Message(val index: Long, val value: AgentSessionMessage, val done: Boolean)

    private val messages = linkedMapOf<String, Message>()
    private val textItems = hashSetOf<String>()
    private val commentaryIds = hashSetOf<String>()
    private val completedIds = hashSetOf<String>()
    private var turn: Turn? = null
    private var completed = false
    private var idle = false
    private var failure: AgentTurnResultException? = null
    private var pending: List<AgentSession.RequiredAction> = emptyList()
    private var result: AgentTurnResult? = null

    fun accept(event: AgentSessionEvent) {
        if (failure != null || result != null || idle) return
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
            event.turnItemAdded().getOrNull()?.let {
                record(
                    it.sessionId(),
                    it.turnId().orElse(null),
                    it.outputIndex().orElse(Long.MAX_VALUE),
                    it.item().message().orElse(null),
                    false,
                )
            }
            event.turnItemDone().getOrNull()?.let {
                record(
                    it.sessionId(),
                    it.turnId().orElse(null),
                    it.outputIndex(),
                    it.item().message().map(::normalize).orElse(null),
                    true,
                )
            }
            event.turnOutputTextDelta().getOrNull()?.let {
                if (
                    it.sessionId() == sessionId &&
                        it.turnId().orElse(null) == turn?.id() &&
                        turn != null
                )
                    if (it.itemId() !in commentaryIds) textItems.add(it.itemId())
            }
            event.requiresAction().getOrNull()?.session()?.let {
                if (it.id() == sessionId && !completed)
                    pending =
                        it.requiredActions().filter { action ->
                            action.functionCall().getOrNull()?.name() !in handledTools
                        }
            }
            event.failed().getOrNull()?.session()?.let {
                if (sessionId == null || it.id() == sessionId) failure = error(Reason.TURN_FAILED)
            }
            if (event.isError()) failure = error(Reason.STREAM_ERROR)
            event.idle().getOrNull()?.session()?.let {
                if (completed && it.id() == sessionId) idle = true
            }
        } catch (cause: Exception) {
            failure = error(Reason.INCOMPLETE_OUTPUT, cause)
        }
    }

    private fun record(
        session: String,
        id: String?,
        index: Long,
        message: AgentSessionMessage?,
        done: Boolean,
    ) {
        if (message == null || message.role() != AgentSessionMessage.Role.ASSISTANT) return
        if (
            session != sessionId ||
                (id != null && id != turn?.id()) ||
                message.turnId() != turn?.id()
        )
            return
        val itemId =
            message.id().orElseThrow { IllegalStateException("Assistant message missing ID") }
        if (!done && itemId in completedIds) return
        if (done) completedIds.add(itemId)
        if (message.phase().orElse(null) == AgentSessionMessage.Phase.COMMENTARY) {
            messages.remove(itemId)
            textItems.remove(itemId)
            commentaryIds.add(itemId)
            return
        }
        commentaryIds.remove(itemId)
        messages[itemId] = Message(index, message, done)
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

    fun failed(cause: Throwable) {
        if (!isReady() && failure == null) failure = error(Reason.STREAM_ERROR, cause)
    }

    fun error(reason: Reason, cause: Throwable? = null): AgentTurnResultException =
        AgentTurnResultException(reason, turn, sessionId, finalMessages(), pending, cause)

    fun finalResult(): AgentTurnResult {
        result?.let {
            return it
        }
        stoppingError()?.let { throw it }
        if (!isReady()) throw error(Reason.INCOMPLETE_STREAM)
        if (textItems.any { messages[it]?.done != true }) throw error(Reason.INCOMPLETE_OUTPUT)
        if (
            messages.values.any {
                !it.value.phase().isPresent ||
                    it.value.phase().get() !in
                        setOf(
                            AgentSessionMessage.Phase.COMMENTARY,
                            AgentSessionMessage.Phase.FINAL_ANSWER,
                        )
            }
        ) {
            throw error(Reason.OUTPUT_SELECTION)
        }
        if (
            messages.values.any {
                it.value.phase().getOrNull() == AgentSessionMessage.Phase.FINAL_ANSWER &&
                    (!it.done || it.value.status() != AgentOutputItemStatus.COMPLETED)
            }
        ) {
            throw error(Reason.INCOMPLETE_OUTPUT)
        }
        val selected = requireNotNull(turn)
        if (selected.status() != Turn.Status.COMPLETED) throw error(Reason.INCOMPLETE_OUTPUT)
        return AgentTurnResult(selected, finalMessages()).also {
            result = it
            messages.clear()
            textItems.clear()
            commentaryIds.clear()
            completedIds.clear()
        }
    }

    private fun finalMessages(): List<AgentSessionMessage> =
        messages.values
            .sortedBy { it.index }
            .filter { it.value.phase().getOrNull() == AgentSessionMessage.Phase.FINAL_ANSWER }
            .map { it.value }
}
