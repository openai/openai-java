package com.openai.services.beta.agents

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.JsonNode
import com.openai.core.jsonMapper
import com.openai.errors.BadRequestException
import com.openai.models.beta.agents.*
import com.openai.models.beta.agents.sessions.SessionRetrieveParams
import com.openai.models.beta.agents.sessions.events.EventCreateParams
import com.openai.models.beta.agents.sessions.events.EventStreamParams
import com.openai.models.beta.agents.sessions.items.ItemListParams
import com.openai.models.beta.agents.sessions.turns.Turn
import com.openai.models.beta.agents.sessions.turns.TurnListParams
import com.openai.models.beta.agents.sessions.turns.TurnRetrieveParams
import java.util.UUID
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException
import java.util.concurrent.ExecutionException
import kotlin.jvm.optionals.getOrNull

internal class AgentSessionStreamSupport(val params: AgentSessionStreamParams) {
    private val mapper = jsonMapper()
    private val inputKey = params.idempotencyKey ?: UUID.randomUUID().toString()
    private val eventIds = linkedSetOf<String>()
    private val handledCalls = hashSetOf<Pair<String, String>>()
    private var turnId: String? = null
    private var turnEnded = false
    val attaching = params.input.isEmpty()
    var baselineRootId: String? = null
    var selectedTurn: Turn? = null
        private set

    var sessionFailed = false
        private set

    var settled = false
        private set

    fun turnListParams(after: String? = null) =
        TurnListParams.builder()
            .sessionId(params.sessionId)
            .order(TurnListParams.Order.DESC)
            .after(after)
            .putAllAdditionalHeaders(params.headers)
            .build()

    fun turnRetrieveParams(id: String) =
        TurnRetrieveParams.builder()
            .sessionId(params.sessionId)
            .turnId(id)
            .putAllAdditionalHeaders(params.headers)
            .build()

    fun itemListParams(after: String? = null) =
        ItemListParams.builder()
            .sessionId(params.sessionId)
            .order(ItemListParams.Order.ASC)
            .after(after)
            .putAllAdditionalHeaders(params.headers)
            .build()

    fun select(turn: Turn, activeOnly: Boolean = false) {
        if (turn.sessionId() != params.sessionId || turn.subagentId().isPresent) return
        if (turnId != null && turn.id() != turnId) return
        val terminal =
            turn.status() in setOf(Turn.Status.COMPLETED, Turn.Status.FAILED, Turn.Status.CANCELLED)
        if (turnEnded && !terminal) return
        if (activeOnly && terminal) return
        if (turnId == null && !activeOnly && turn.id() == baselineRootId) return
        turnId = turn.id()
        selectedTurn = turn
        turnEnded = terminal
        if (terminal) {
            settled = true
            sessionFailed = false
        }
    }

    fun observeSession(session: AgentSession) {
        if (session.id() != params.sessionId) return
        sessionFailed = !turnEnded && session.status() == AgentSession.Status.FAILED
        settled =
            turnEnded ||
                sessionFailed ||
                (session.status() == AgentSession.Status.IDLE && (turnId == null || turnEnded))
    }

    fun manualActions(
        session: AgentSession,
        latestRoot: Turn? = null,
    ): List<AgentSession.RequiredAction> {
        if (
            session.id() != params.sessionId ||
                session.status() != AgentSession.Status.REQUIRES_ACTION
        )
            return emptyList()
        val selected =
            selectedTurn
                ?: return if (
                    latestRoot == null ||
                        latestRoot.status() in
                            setOf(Turn.Status.COMPLETED, Turn.Status.FAILED, Turn.Status.CANCELLED)
                )
                    session.requiredActions().filter { it.isEnvironmentConnection() }
                else emptyList()
        if (selected.status() != Turn.Status.WAITING) return emptyList()
        return session.requiredActions().filter {
            it.computerUseApprovalRequest().getOrNull()?.turnId() == selected.id() ||
                (it.isEnvironmentConnection() && latestRoot?.id() == selected.id())
        }
    }

    fun missingTurnId(event: AgentSessionEvent): String? {
        if (!attaching || turnId != null) return null
        return eventTurn(event)?.id()
            ?: event.turnItemAdded().getOrNull()?.item()?.functionCall()?.getOrNull()?.turnId()
            ?: event
                .turnItemAdded()
                .getOrNull()
                ?.item()
                ?.computerUseApprovalRequest()
                ?.getOrNull()
                ?.turnId()
            ?: event.turnItemDone().getOrNull()?.item()?.message()?.getOrNull()?.turnId()
            ?: event
                .requiresAction()
                .getOrNull()
                ?.session()
                ?.requiredActions()
                ?.firstNotNullOfOrNull {
                    it.functionCall().getOrNull()?.turnId()
                        ?: it.computerUseApprovalRequest().getOrNull()?.turnId()
                }
    }

    fun retrieveParams() =
        SessionRetrieveParams.builder()
            .sessionId(params.sessionId)
            .putAllAdditionalHeaders(params.headers)
            .build()

    fun streamParams() =
        EventStreamParams.builder()
            .sessionId(params.sessionId)
            .putAllAdditionalHeaders(params.headers)
            .build()

    fun inputParams() =
        EventCreateParams.builder()
            .sessionId(params.sessionId)
            .idempotencyKey(inputKey)
            .putAllAdditionalHeaders(params.headers)
            .addAgentSessionInputMessageEvent(params.input)
            .build()

    fun checkIdle(session: AgentSession) {
        require(session.status() == AgentSession.Status.IDLE) {
            "stream input requires an idle session; omit input to attach to existing work"
        }
    }

    fun accept(event: AgentSessionEvent): Boolean {
        val id = mapper.valueToTree<JsonNode>(event).path("event_id").asText()
        if (!eventIds.add(id)) return false
        if (eventIds.size > 1024)
            eventIds.iterator().let {
                it.next()
                it.remove()
            }
        observeTurn(event)
        event.turnCreated().getOrNull()?.let {
            if (!attaching && turnId == null && !it.turn().subagentId().isPresent)
                turnId = it.turnId()
        }
        val ended =
            event.turnCompleted().getOrNull()?.turnId()
                ?: event.turnFailed().getOrNull()?.turnId()
                ?: event.turnCancelled().getOrNull()?.turnId()
        if (turnId != null && ended == turnId) turnEnded = true
        if (attaching) {
            event.failed().getOrNull()?.session()?.let(::observeSession)
        }
        return true
    }

    fun observeTurn(event: AgentSessionEvent) {
        if (attaching && selectedTurn != null) eventTurn(event)?.let { select(it) }
    }

    private fun eventTurn(event: AgentSessionEvent): Turn? =
        event.turnCreated().getOrNull()?.turn()
            ?: event.turnInProgress().getOrNull()?.turn()
            ?: event.turnCompleted().getOrNull()?.turn()
            ?: event.turnFailed().getOrNull()?.turn()
            ?: event.turnCancelled().getOrNull()?.turn()

    fun terminal(event: AgentSessionEvent) =
        if (attaching) settled || turnEnded else event.isFailed() || (event.isIdle() && turnEnded)

    fun result(event: AgentSessionEvent): CompletableFuture<EventCreateParams?> {
        val call =
            event.turnItemAdded().getOrNull()?.item()?.functionCall()?.getOrNull()
                ?: return CompletableFuture.completedFuture(null)
        if (attaching && call.turnId() != turnId) return CompletableFuture.completedFuture(null)
        val handler = params.handlers[call.name()] ?: return CompletableFuture.completedFuture(null)
        if (!handledCalls.add(call.turnId() to call.callId()))
            return CompletableFuture.completedFuture(null)
        val output =
            try {
                val raw = mapper.valueToTree<JsonNode>(call._arguments())
                val args = if (raw.isTextual) mapper.readTree(raw.asText()) else raw
                require(args.isObject) { "Function arguments must be a JSON object" }
                // convertValue recursively copies objects and lists so handlers cannot mutate
                // events.
                val copy = mapper.convertValue(args, object : TypeReference<Map<String, Any?>>() {})
                handler.apply(copy).toCompletableFuture()
            } catch (error: Exception) {
                CompletableFuture<Any?>().apply { completeExceptionally(error) }
            }
        val future =
            output.handle { value, error ->
                val result =
                    AgentSessionInputParam.AgentSessionInputToolResult.builder()
                        .turnId(call.turnId())
                        .callId(call.callId())
                try {
                    if (error != null) throw IllegalStateException()
                    result
                        .success(true)
                        .output(
                            when (value) {
                                null -> null
                                is String -> AgentFunctionCallOutputParam.ofString(value)
                                is Map<*, *> ->
                                    AgentFunctionCallOutputParam.ofString(
                                        mapper.writeValueAsString(value)
                                    )
                                is AgentFunctionCallOutputParam -> value
                                is List<*> ->
                                    AgentFunctionCallOutputParam.ofInputContentParams(
                                        value.map { it as InputContentParam }
                                    )
                                else -> throw IllegalArgumentException()
                            }
                        )
                    mapper.writeValueAsString(result.build())
                } catch (failure: Exception) {
                    result
                        .success(false)
                        .output(null as AgentFunctionCallOutputParam?)
                        .error("Tool handler failed.")
                }
                EventCreateParams.builder()
                    .sessionId(params.sessionId)
                    .idempotencyKey(UUID.randomUUID().toString())
                    .putAllAdditionalHeaders(params.headers)
                    .addEvent(result.build())
                    .build()
            }
        future.whenComplete { _, _ -> if (future.isCancelled) output.cancel(true) }
        return future
    }

    fun pendingCallRace(error: Throwable, result: EventCreateParams): Boolean {
        val cause = unwrap(error)
        if (cause !is BadRequestException) return false
        val body = mapper.valueToTree<JsonNode>(cause.body())
        return body.path("code").asText() == "invalid_request_error" &&
            body.path("message").asText() ==
                "Unknown pending tool call: ${result.events().single().asAgentSessionInputToolResult().callId()}"
    }

    fun unexpectedEnd() =
        IllegalStateException("Session event stream ended before the turn reached idle or failed")
}

internal fun unwrap(error: Throwable): Throwable =
    if ((error is CompletionException || error is ExecutionException) && error.cause != null)
        unwrap(error.cause!!)
    else error
