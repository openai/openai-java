// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.JsonValue
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** An event emitted by a Managed Agents session. */
@JsonDeserialize(using = AgentSessionEvent.Deserializer::class)
@JsonSerialize(using = AgentSessionEvent.Serializer::class)
class AgentSessionEvent
private constructor(
    private val error: AgentSessionErrorEvent? = null,
    private val environmentReady: AgentSessionEnvironmentReadyEvent? = null,
    private val outputCommandExecutionOutputDelta: AgentOutputCommandExecutionOutputDeltaEvent? =
        null,
    private val created: AgentSessionCreatedEvent? = null,
    private val turnCreated: AgentSessionTurnCreatedEvent? = null,
    private val turnInProgress: AgentSessionTurnInProgressEvent? = null,
    private val turnCompleted: AgentSessionTurnCompletedEvent? = null,
    private val turnFailed: AgentSessionTurnFailedEvent? = null,
    private val turnCancelled: AgentSessionTurnCancelledEvent? = null,
    private val turnItemAdded: AgentSessionTurnItemAddedEvent? = null,
    private val idle: AgentSessionIdleEvent? = null,
    private val inProgress: AgentSessionInProgressEvent? = null,
    private val requiresAction: AgentSessionRequiresActionEvent? = null,
    private val failed: AgentSessionFailedEvent? = null,
    private val environmentPending: AgentSessionEnvironmentPendingEvent? = null,
    private val environmentConnected: AgentSessionEnvironmentConnectedEvent? = null,
    private val environmentDisconnected: AgentSessionEnvironmentDisconnectedEvent? = null,
    private val environmentFailed: AgentSessionEnvironmentFailedEvent? = null,
    private val subagentCreated: AgentSessionSubagentCreatedEvent? = null,
    private val subagentActive: AgentSessionSubagentActiveEvent? = null,
    private val subagentClosed: AgentSessionSubagentClosedEvent? = null,
    private val turnItemDone: AgentSessionTurnItemDoneEvent? = null,
    private val turnContentPartAdded: AgentSessionTurnContentPartAddedEvent? = null,
    private val turnContentPartDone: AgentSessionTurnContentPartDoneEvent? = null,
    private val turnOutputTextDelta: AgentSessionTurnOutputTextDeltaEvent? = null,
    private val turnOutputTextDone: AgentSessionTurnOutputTextDoneEvent? = null,
    private val turnReasoningSummaryPartAdded: AgentSessionTurnReasoningSummaryPartAddedEvent? =
        null,
    private val turnReasoningSummaryPartDone: AgentSessionTurnReasoningSummaryPartDoneEvent? = null,
    private val turnReasoningSummaryTextDelta: AgentSessionTurnReasoningSummaryTextDeltaEvent? =
        null,
    private val turnReasoningSummaryTextDone: AgentSessionTurnReasoningSummaryTextDoneEvent? = null,
    private val _json: JsonValue? = null,
) {

    /** Emitted when a turn or session fails. */
    fun error(): Optional<AgentSessionErrorEvent> = Optional.ofNullable(error)

    /** Emitted when a hosted session environment is ready to connect. */
    fun environmentReady(): Optional<AgentSessionEnvironmentReadyEvent> =
        Optional.ofNullable(environmentReady)

    /** Emitted when command execution produces an output delta. */
    fun outputCommandExecutionOutputDelta(): Optional<AgentOutputCommandExecutionOutputDeltaEvent> =
        Optional.ofNullable(outputCommandExecutionOutputDelta)

    /** Emitted when a session is created. */
    fun created(): Optional<AgentSessionCreatedEvent> = Optional.ofNullable(created)

    /** Emitted when a turn is created. */
    fun turnCreated(): Optional<AgentSessionTurnCreatedEvent> = Optional.ofNullable(turnCreated)

    /** Emitted when a turn starts running. */
    fun turnInProgress(): Optional<AgentSessionTurnInProgressEvent> =
        Optional.ofNullable(turnInProgress)

    /** Emitted when a turn completes. */
    fun turnCompleted(): Optional<AgentSessionTurnCompletedEvent> =
        Optional.ofNullable(turnCompleted)

    /** Emitted when a turn fails. */
    fun turnFailed(): Optional<AgentSessionTurnFailedEvent> = Optional.ofNullable(turnFailed)

    /** Emitted when a turn is cancelled. */
    fun turnCancelled(): Optional<AgentSessionTurnCancelledEvent> =
        Optional.ofNullable(turnCancelled)

    /** Emitted when an item is added to a turn. */
    fun turnItemAdded(): Optional<AgentSessionTurnItemAddedEvent> =
        Optional.ofNullable(turnItemAdded)

    /** Emitted when a session becomes idle. */
    fun idle(): Optional<AgentSessionIdleEvent> = Optional.ofNullable(idle)

    /** Emitted when a session starts processing a turn. */
    fun inProgress(): Optional<AgentSessionInProgressEvent> = Optional.ofNullable(inProgress)

    /** Emitted when a session is waiting for one or more required actions. */
    fun requiresAction(): Optional<AgentSessionRequiresActionEvent> =
        Optional.ofNullable(requiresAction)

    /** Emitted when a session fails. */
    fun failed(): Optional<AgentSessionFailedEvent> = Optional.ofNullable(failed)

    /** Emitted while a session environment is being prepared. */
    fun environmentPending(): Optional<AgentSessionEnvironmentPendingEvent> =
        Optional.ofNullable(environmentPending)

    /** Emitted when a session environment connects. */
    fun environmentConnected(): Optional<AgentSessionEnvironmentConnectedEvent> =
        Optional.ofNullable(environmentConnected)

    /** Emitted when a session environment disconnects. */
    fun environmentDisconnected(): Optional<AgentSessionEnvironmentDisconnectedEvent> =
        Optional.ofNullable(environmentDisconnected)

    /** Emitted when a session environment fails. */
    fun environmentFailed(): Optional<AgentSessionEnvironmentFailedEvent> =
        Optional.ofNullable(environmentFailed)

    /** Emitted when a subagent is created. */
    fun subagentCreated(): Optional<AgentSessionSubagentCreatedEvent> =
        Optional.ofNullable(subagentCreated)

    /** Emitted when a closed subagent successfully resumes. */
    fun subagentActive(): Optional<AgentSessionSubagentActiveEvent> =
        Optional.ofNullable(subagentActive)

    /** Emitted when a subagent is closed. */
    fun subagentClosed(): Optional<AgentSessionSubagentClosedEvent> =
        Optional.ofNullable(subagentClosed)

    /** Emitted when an output item is complete. */
    fun turnItemDone(): Optional<AgentSessionTurnItemDoneEvent> = Optional.ofNullable(turnItemDone)

    /** Emitted when an output text content part is added. */
    fun turnContentPartAdded(): Optional<AgentSessionTurnContentPartAddedEvent> =
        Optional.ofNullable(turnContentPartAdded)

    /** Emitted when an output content part is complete. */
    fun turnContentPartDone(): Optional<AgentSessionTurnContentPartDoneEvent> =
        Optional.ofNullable(turnContentPartDone)

    /** Emitted when text is appended to an output text content part. */
    fun turnOutputTextDelta(): Optional<AgentSessionTurnOutputTextDeltaEvent> =
        Optional.ofNullable(turnOutputTextDelta)

    /** Emitted when an output text content part is complete. */
    fun turnOutputTextDone(): Optional<AgentSessionTurnOutputTextDoneEvent> =
        Optional.ofNullable(turnOutputTextDone)

    /** Emitted when a reasoning summary content part is added. */
    fun turnReasoningSummaryPartAdded(): Optional<AgentSessionTurnReasoningSummaryPartAddedEvent> =
        Optional.ofNullable(turnReasoningSummaryPartAdded)

    /** Emitted when a reasoning summary part is complete. */
    fun turnReasoningSummaryPartDone(): Optional<AgentSessionTurnReasoningSummaryPartDoneEvent> =
        Optional.ofNullable(turnReasoningSummaryPartDone)

    /** Emitted when text is appended to a reasoning summary. */
    fun turnReasoningSummaryTextDelta(): Optional<AgentSessionTurnReasoningSummaryTextDeltaEvent> =
        Optional.ofNullable(turnReasoningSummaryTextDelta)

    /** Emitted when a reasoning summary content part is complete. */
    fun turnReasoningSummaryTextDone(): Optional<AgentSessionTurnReasoningSummaryTextDoneEvent> =
        Optional.ofNullable(turnReasoningSummaryTextDone)

    fun isError(): Boolean = error != null

    fun isEnvironmentReady(): Boolean = environmentReady != null

    fun isOutputCommandExecutionOutputDelta(): Boolean = outputCommandExecutionOutputDelta != null

    fun isCreated(): Boolean = created != null

    fun isTurnCreated(): Boolean = turnCreated != null

    fun isTurnInProgress(): Boolean = turnInProgress != null

    fun isTurnCompleted(): Boolean = turnCompleted != null

    fun isTurnFailed(): Boolean = turnFailed != null

    fun isTurnCancelled(): Boolean = turnCancelled != null

    fun isTurnItemAdded(): Boolean = turnItemAdded != null

    fun isIdle(): Boolean = idle != null

    fun isInProgress(): Boolean = inProgress != null

    fun isRequiresAction(): Boolean = requiresAction != null

    fun isFailed(): Boolean = failed != null

    fun isEnvironmentPending(): Boolean = environmentPending != null

    fun isEnvironmentConnected(): Boolean = environmentConnected != null

    fun isEnvironmentDisconnected(): Boolean = environmentDisconnected != null

    fun isEnvironmentFailed(): Boolean = environmentFailed != null

    fun isSubagentCreated(): Boolean = subagentCreated != null

    fun isSubagentActive(): Boolean = subagentActive != null

    fun isSubagentClosed(): Boolean = subagentClosed != null

    fun isTurnItemDone(): Boolean = turnItemDone != null

    fun isTurnContentPartAdded(): Boolean = turnContentPartAdded != null

    fun isTurnContentPartDone(): Boolean = turnContentPartDone != null

    fun isTurnOutputTextDelta(): Boolean = turnOutputTextDelta != null

    fun isTurnOutputTextDone(): Boolean = turnOutputTextDone != null

    fun isTurnReasoningSummaryPartAdded(): Boolean = turnReasoningSummaryPartAdded != null

    fun isTurnReasoningSummaryPartDone(): Boolean = turnReasoningSummaryPartDone != null

    fun isTurnReasoningSummaryTextDelta(): Boolean = turnReasoningSummaryTextDelta != null

    fun isTurnReasoningSummaryTextDone(): Boolean = turnReasoningSummaryTextDone != null

    /** Emitted when a turn or session fails. */
    fun asError(): AgentSessionErrorEvent = error.getOrThrow("error")

    /** Emitted when a hosted session environment is ready to connect. */
    fun asEnvironmentReady(): AgentSessionEnvironmentReadyEvent =
        environmentReady.getOrThrow("environmentReady")

    /** Emitted when command execution produces an output delta. */
    fun asOutputCommandExecutionOutputDelta(): AgentOutputCommandExecutionOutputDeltaEvent =
        outputCommandExecutionOutputDelta.getOrThrow("outputCommandExecutionOutputDelta")

    /** Emitted when a session is created. */
    fun asCreated(): AgentSessionCreatedEvent = created.getOrThrow("created")

    /** Emitted when a turn is created. */
    fun asTurnCreated(): AgentSessionTurnCreatedEvent = turnCreated.getOrThrow("turnCreated")

    /** Emitted when a turn starts running. */
    fun asTurnInProgress(): AgentSessionTurnInProgressEvent =
        turnInProgress.getOrThrow("turnInProgress")

    /** Emitted when a turn completes. */
    fun asTurnCompleted(): AgentSessionTurnCompletedEvent =
        turnCompleted.getOrThrow("turnCompleted")

    /** Emitted when a turn fails. */
    fun asTurnFailed(): AgentSessionTurnFailedEvent = turnFailed.getOrThrow("turnFailed")

    /** Emitted when a turn is cancelled. */
    fun asTurnCancelled(): AgentSessionTurnCancelledEvent =
        turnCancelled.getOrThrow("turnCancelled")

    /** Emitted when an item is added to a turn. */
    fun asTurnItemAdded(): AgentSessionTurnItemAddedEvent =
        turnItemAdded.getOrThrow("turnItemAdded")

    /** Emitted when a session becomes idle. */
    fun asIdle(): AgentSessionIdleEvent = idle.getOrThrow("idle")

    /** Emitted when a session starts processing a turn. */
    fun asInProgress(): AgentSessionInProgressEvent = inProgress.getOrThrow("inProgress")

    /** Emitted when a session is waiting for one or more required actions. */
    fun asRequiresAction(): AgentSessionRequiresActionEvent =
        requiresAction.getOrThrow("requiresAction")

    /** Emitted when a session fails. */
    fun asFailed(): AgentSessionFailedEvent = failed.getOrThrow("failed")

    /** Emitted while a session environment is being prepared. */
    fun asEnvironmentPending(): AgentSessionEnvironmentPendingEvent =
        environmentPending.getOrThrow("environmentPending")

    /** Emitted when a session environment connects. */
    fun asEnvironmentConnected(): AgentSessionEnvironmentConnectedEvent =
        environmentConnected.getOrThrow("environmentConnected")

    /** Emitted when a session environment disconnects. */
    fun asEnvironmentDisconnected(): AgentSessionEnvironmentDisconnectedEvent =
        environmentDisconnected.getOrThrow("environmentDisconnected")

    /** Emitted when a session environment fails. */
    fun asEnvironmentFailed(): AgentSessionEnvironmentFailedEvent =
        environmentFailed.getOrThrow("environmentFailed")

    /** Emitted when a subagent is created. */
    fun asSubagentCreated(): AgentSessionSubagentCreatedEvent =
        subagentCreated.getOrThrow("subagentCreated")

    /** Emitted when a closed subagent successfully resumes. */
    fun asSubagentActive(): AgentSessionSubagentActiveEvent =
        subagentActive.getOrThrow("subagentActive")

    /** Emitted when a subagent is closed. */
    fun asSubagentClosed(): AgentSessionSubagentClosedEvent =
        subagentClosed.getOrThrow("subagentClosed")

    /** Emitted when an output item is complete. */
    fun asTurnItemDone(): AgentSessionTurnItemDoneEvent = turnItemDone.getOrThrow("turnItemDone")

    /** Emitted when an output text content part is added. */
    fun asTurnContentPartAdded(): AgentSessionTurnContentPartAddedEvent =
        turnContentPartAdded.getOrThrow("turnContentPartAdded")

    /** Emitted when an output content part is complete. */
    fun asTurnContentPartDone(): AgentSessionTurnContentPartDoneEvent =
        turnContentPartDone.getOrThrow("turnContentPartDone")

    /** Emitted when text is appended to an output text content part. */
    fun asTurnOutputTextDelta(): AgentSessionTurnOutputTextDeltaEvent =
        turnOutputTextDelta.getOrThrow("turnOutputTextDelta")

    /** Emitted when an output text content part is complete. */
    fun asTurnOutputTextDone(): AgentSessionTurnOutputTextDoneEvent =
        turnOutputTextDone.getOrThrow("turnOutputTextDone")

    /** Emitted when a reasoning summary content part is added. */
    fun asTurnReasoningSummaryPartAdded(): AgentSessionTurnReasoningSummaryPartAddedEvent =
        turnReasoningSummaryPartAdded.getOrThrow("turnReasoningSummaryPartAdded")

    /** Emitted when a reasoning summary part is complete. */
    fun asTurnReasoningSummaryPartDone(): AgentSessionTurnReasoningSummaryPartDoneEvent =
        turnReasoningSummaryPartDone.getOrThrow("turnReasoningSummaryPartDone")

    /** Emitted when text is appended to a reasoning summary. */
    fun asTurnReasoningSummaryTextDelta(): AgentSessionTurnReasoningSummaryTextDeltaEvent =
        turnReasoningSummaryTextDelta.getOrThrow("turnReasoningSummaryTextDelta")

    /** Emitted when a reasoning summary content part is complete. */
    fun asTurnReasoningSummaryTextDone(): AgentSessionTurnReasoningSummaryTextDoneEvent =
        turnReasoningSummaryTextDone.getOrThrow("turnReasoningSummaryTextDone")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    /**
     * Maps this instance's current variant to a value of type [T] using the given [visitor].
     *
     * Note that this method is _not_ forwards compatible with new variants from the API, unless
     * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of the
     * SDK gracefully, consider overriding [Visitor.unknown]:
     * ```java
     * import com.openai.core.JsonValue;
     * import java.util.Optional;
     *
     * Optional<String> result = agentSessionEvent.accept(new AgentSessionEvent.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitError(AgentSessionErrorEvent error) {
     *         return Optional.of(error.toString());
     *     }
     *
     *     // ...
     *
     *     @Override
     *     public Optional<String> unknown(JsonValue json) {
     *         // Or inspect the `json`.
     *         return Optional.empty();
     *     }
     * });
     * ```
     *
     * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in [visitor] and
     *   the current variant is unknown.
     */
    fun <T> accept(visitor: Visitor<T>): T =
        when {
            error != null -> visitor.visitError(error)
            environmentReady != null -> visitor.visitEnvironmentReady(environmentReady)
            outputCommandExecutionOutputDelta != null ->
                visitor.visitOutputCommandExecutionOutputDelta(outputCommandExecutionOutputDelta)
            created != null -> visitor.visitCreated(created)
            turnCreated != null -> visitor.visitTurnCreated(turnCreated)
            turnInProgress != null -> visitor.visitTurnInProgress(turnInProgress)
            turnCompleted != null -> visitor.visitTurnCompleted(turnCompleted)
            turnFailed != null -> visitor.visitTurnFailed(turnFailed)
            turnCancelled != null -> visitor.visitTurnCancelled(turnCancelled)
            turnItemAdded != null -> visitor.visitTurnItemAdded(turnItemAdded)
            idle != null -> visitor.visitIdle(idle)
            inProgress != null -> visitor.visitInProgress(inProgress)
            requiresAction != null -> visitor.visitRequiresAction(requiresAction)
            failed != null -> visitor.visitFailed(failed)
            environmentPending != null -> visitor.visitEnvironmentPending(environmentPending)
            environmentConnected != null -> visitor.visitEnvironmentConnected(environmentConnected)
            environmentDisconnected != null ->
                visitor.visitEnvironmentDisconnected(environmentDisconnected)
            environmentFailed != null -> visitor.visitEnvironmentFailed(environmentFailed)
            subagentCreated != null -> visitor.visitSubagentCreated(subagentCreated)
            subagentActive != null -> visitor.visitSubagentActive(subagentActive)
            subagentClosed != null -> visitor.visitSubagentClosed(subagentClosed)
            turnItemDone != null -> visitor.visitTurnItemDone(turnItemDone)
            turnContentPartAdded != null -> visitor.visitTurnContentPartAdded(turnContentPartAdded)
            turnContentPartDone != null -> visitor.visitTurnContentPartDone(turnContentPartDone)
            turnOutputTextDelta != null -> visitor.visitTurnOutputTextDelta(turnOutputTextDelta)
            turnOutputTextDone != null -> visitor.visitTurnOutputTextDone(turnOutputTextDone)
            turnReasoningSummaryPartAdded != null ->
                visitor.visitTurnReasoningSummaryPartAdded(turnReasoningSummaryPartAdded)
            turnReasoningSummaryPartDone != null ->
                visitor.visitTurnReasoningSummaryPartDone(turnReasoningSummaryPartDone)
            turnReasoningSummaryTextDelta != null ->
                visitor.visitTurnReasoningSummaryTextDelta(turnReasoningSummaryTextDelta)
            turnReasoningSummaryTextDone != null ->
                visitor.visitTurnReasoningSummaryTextDone(turnReasoningSummaryTextDone)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): AgentSessionEvent = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitError(error: AgentSessionErrorEvent) {
                    error.validate()
                }

                override fun visitEnvironmentReady(
                    environmentReady: AgentSessionEnvironmentReadyEvent
                ) {
                    environmentReady.validate()
                }

                override fun visitOutputCommandExecutionOutputDelta(
                    outputCommandExecutionOutputDelta: AgentOutputCommandExecutionOutputDeltaEvent
                ) {
                    outputCommandExecutionOutputDelta.validate()
                }

                override fun visitCreated(created: AgentSessionCreatedEvent) {
                    created.validate()
                }

                override fun visitTurnCreated(turnCreated: AgentSessionTurnCreatedEvent) {
                    turnCreated.validate()
                }

                override fun visitTurnInProgress(turnInProgress: AgentSessionTurnInProgressEvent) {
                    turnInProgress.validate()
                }

                override fun visitTurnCompleted(turnCompleted: AgentSessionTurnCompletedEvent) {
                    turnCompleted.validate()
                }

                override fun visitTurnFailed(turnFailed: AgentSessionTurnFailedEvent) {
                    turnFailed.validate()
                }

                override fun visitTurnCancelled(turnCancelled: AgentSessionTurnCancelledEvent) {
                    turnCancelled.validate()
                }

                override fun visitTurnItemAdded(turnItemAdded: AgentSessionTurnItemAddedEvent) {
                    turnItemAdded.validate()
                }

                override fun visitIdle(idle: AgentSessionIdleEvent) {
                    idle.validate()
                }

                override fun visitInProgress(inProgress: AgentSessionInProgressEvent) {
                    inProgress.validate()
                }

                override fun visitRequiresAction(requiresAction: AgentSessionRequiresActionEvent) {
                    requiresAction.validate()
                }

                override fun visitFailed(failed: AgentSessionFailedEvent) {
                    failed.validate()
                }

                override fun visitEnvironmentPending(
                    environmentPending: AgentSessionEnvironmentPendingEvent
                ) {
                    environmentPending.validate()
                }

                override fun visitEnvironmentConnected(
                    environmentConnected: AgentSessionEnvironmentConnectedEvent
                ) {
                    environmentConnected.validate()
                }

                override fun visitEnvironmentDisconnected(
                    environmentDisconnected: AgentSessionEnvironmentDisconnectedEvent
                ) {
                    environmentDisconnected.validate()
                }

                override fun visitEnvironmentFailed(
                    environmentFailed: AgentSessionEnvironmentFailedEvent
                ) {
                    environmentFailed.validate()
                }

                override fun visitSubagentCreated(
                    subagentCreated: AgentSessionSubagentCreatedEvent
                ) {
                    subagentCreated.validate()
                }

                override fun visitSubagentActive(subagentActive: AgentSessionSubagentActiveEvent) {
                    subagentActive.validate()
                }

                override fun visitSubagentClosed(subagentClosed: AgentSessionSubagentClosedEvent) {
                    subagentClosed.validate()
                }

                override fun visitTurnItemDone(turnItemDone: AgentSessionTurnItemDoneEvent) {
                    turnItemDone.validate()
                }

                override fun visitTurnContentPartAdded(
                    turnContentPartAdded: AgentSessionTurnContentPartAddedEvent
                ) {
                    turnContentPartAdded.validate()
                }

                override fun visitTurnContentPartDone(
                    turnContentPartDone: AgentSessionTurnContentPartDoneEvent
                ) {
                    turnContentPartDone.validate()
                }

                override fun visitTurnOutputTextDelta(
                    turnOutputTextDelta: AgentSessionTurnOutputTextDeltaEvent
                ) {
                    turnOutputTextDelta.validate()
                }

                override fun visitTurnOutputTextDone(
                    turnOutputTextDone: AgentSessionTurnOutputTextDoneEvent
                ) {
                    turnOutputTextDone.validate()
                }

                override fun visitTurnReasoningSummaryPartAdded(
                    turnReasoningSummaryPartAdded: AgentSessionTurnReasoningSummaryPartAddedEvent
                ) {
                    turnReasoningSummaryPartAdded.validate()
                }

                override fun visitTurnReasoningSummaryPartDone(
                    turnReasoningSummaryPartDone: AgentSessionTurnReasoningSummaryPartDoneEvent
                ) {
                    turnReasoningSummaryPartDone.validate()
                }

                override fun visitTurnReasoningSummaryTextDelta(
                    turnReasoningSummaryTextDelta: AgentSessionTurnReasoningSummaryTextDeltaEvent
                ) {
                    turnReasoningSummaryTextDelta.validate()
                }

                override fun visitTurnReasoningSummaryTextDone(
                    turnReasoningSummaryTextDone: AgentSessionTurnReasoningSummaryTextDoneEvent
                ) {
                    turnReasoningSummaryTextDone.validate()
                }
            }
        )
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: OpenAIInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        accept(
            object : Visitor<Int> {
                override fun visitError(error: AgentSessionErrorEvent) = error.validity()

                override fun visitEnvironmentReady(
                    environmentReady: AgentSessionEnvironmentReadyEvent
                ) = environmentReady.validity()

                override fun visitOutputCommandExecutionOutputDelta(
                    outputCommandExecutionOutputDelta: AgentOutputCommandExecutionOutputDeltaEvent
                ) = outputCommandExecutionOutputDelta.validity()

                override fun visitCreated(created: AgentSessionCreatedEvent) = created.validity()

                override fun visitTurnCreated(turnCreated: AgentSessionTurnCreatedEvent) =
                    turnCreated.validity()

                override fun visitTurnInProgress(turnInProgress: AgentSessionTurnInProgressEvent) =
                    turnInProgress.validity()

                override fun visitTurnCompleted(turnCompleted: AgentSessionTurnCompletedEvent) =
                    turnCompleted.validity()

                override fun visitTurnFailed(turnFailed: AgentSessionTurnFailedEvent) =
                    turnFailed.validity()

                override fun visitTurnCancelled(turnCancelled: AgentSessionTurnCancelledEvent) =
                    turnCancelled.validity()

                override fun visitTurnItemAdded(turnItemAdded: AgentSessionTurnItemAddedEvent) =
                    turnItemAdded.validity()

                override fun visitIdle(idle: AgentSessionIdleEvent) = idle.validity()

                override fun visitInProgress(inProgress: AgentSessionInProgressEvent) =
                    inProgress.validity()

                override fun visitRequiresAction(requiresAction: AgentSessionRequiresActionEvent) =
                    requiresAction.validity()

                override fun visitFailed(failed: AgentSessionFailedEvent) = failed.validity()

                override fun visitEnvironmentPending(
                    environmentPending: AgentSessionEnvironmentPendingEvent
                ) = environmentPending.validity()

                override fun visitEnvironmentConnected(
                    environmentConnected: AgentSessionEnvironmentConnectedEvent
                ) = environmentConnected.validity()

                override fun visitEnvironmentDisconnected(
                    environmentDisconnected: AgentSessionEnvironmentDisconnectedEvent
                ) = environmentDisconnected.validity()

                override fun visitEnvironmentFailed(
                    environmentFailed: AgentSessionEnvironmentFailedEvent
                ) = environmentFailed.validity()

                override fun visitSubagentCreated(
                    subagentCreated: AgentSessionSubagentCreatedEvent
                ) = subagentCreated.validity()

                override fun visitSubagentActive(subagentActive: AgentSessionSubagentActiveEvent) =
                    subagentActive.validity()

                override fun visitSubagentClosed(subagentClosed: AgentSessionSubagentClosedEvent) =
                    subagentClosed.validity()

                override fun visitTurnItemDone(turnItemDone: AgentSessionTurnItemDoneEvent) =
                    turnItemDone.validity()

                override fun visitTurnContentPartAdded(
                    turnContentPartAdded: AgentSessionTurnContentPartAddedEvent
                ) = turnContentPartAdded.validity()

                override fun visitTurnContentPartDone(
                    turnContentPartDone: AgentSessionTurnContentPartDoneEvent
                ) = turnContentPartDone.validity()

                override fun visitTurnOutputTextDelta(
                    turnOutputTextDelta: AgentSessionTurnOutputTextDeltaEvent
                ) = turnOutputTextDelta.validity()

                override fun visitTurnOutputTextDone(
                    turnOutputTextDone: AgentSessionTurnOutputTextDoneEvent
                ) = turnOutputTextDone.validity()

                override fun visitTurnReasoningSummaryPartAdded(
                    turnReasoningSummaryPartAdded: AgentSessionTurnReasoningSummaryPartAddedEvent
                ) = turnReasoningSummaryPartAdded.validity()

                override fun visitTurnReasoningSummaryPartDone(
                    turnReasoningSummaryPartDone: AgentSessionTurnReasoningSummaryPartDoneEvent
                ) = turnReasoningSummaryPartDone.validity()

                override fun visitTurnReasoningSummaryTextDelta(
                    turnReasoningSummaryTextDelta: AgentSessionTurnReasoningSummaryTextDeltaEvent
                ) = turnReasoningSummaryTextDelta.validity()

                override fun visitTurnReasoningSummaryTextDone(
                    turnReasoningSummaryTextDone: AgentSessionTurnReasoningSummaryTextDoneEvent
                ) = turnReasoningSummaryTextDone.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AgentSessionEvent &&
            error == other.error &&
            environmentReady == other.environmentReady &&
            outputCommandExecutionOutputDelta == other.outputCommandExecutionOutputDelta &&
            created == other.created &&
            turnCreated == other.turnCreated &&
            turnInProgress == other.turnInProgress &&
            turnCompleted == other.turnCompleted &&
            turnFailed == other.turnFailed &&
            turnCancelled == other.turnCancelled &&
            turnItemAdded == other.turnItemAdded &&
            idle == other.idle &&
            inProgress == other.inProgress &&
            requiresAction == other.requiresAction &&
            failed == other.failed &&
            environmentPending == other.environmentPending &&
            environmentConnected == other.environmentConnected &&
            environmentDisconnected == other.environmentDisconnected &&
            environmentFailed == other.environmentFailed &&
            subagentCreated == other.subagentCreated &&
            subagentActive == other.subagentActive &&
            subagentClosed == other.subagentClosed &&
            turnItemDone == other.turnItemDone &&
            turnContentPartAdded == other.turnContentPartAdded &&
            turnContentPartDone == other.turnContentPartDone &&
            turnOutputTextDelta == other.turnOutputTextDelta &&
            turnOutputTextDone == other.turnOutputTextDone &&
            turnReasoningSummaryPartAdded == other.turnReasoningSummaryPartAdded &&
            turnReasoningSummaryPartDone == other.turnReasoningSummaryPartDone &&
            turnReasoningSummaryTextDelta == other.turnReasoningSummaryTextDelta &&
            turnReasoningSummaryTextDone == other.turnReasoningSummaryTextDone
    }

    override fun hashCode(): Int =
        Objects.hash(
            error,
            environmentReady,
            outputCommandExecutionOutputDelta,
            created,
            turnCreated,
            turnInProgress,
            turnCompleted,
            turnFailed,
            turnCancelled,
            turnItemAdded,
            idle,
            inProgress,
            requiresAction,
            failed,
            environmentPending,
            environmentConnected,
            environmentDisconnected,
            environmentFailed,
            subagentCreated,
            subagentActive,
            subagentClosed,
            turnItemDone,
            turnContentPartAdded,
            turnContentPartDone,
            turnOutputTextDelta,
            turnOutputTextDone,
            turnReasoningSummaryPartAdded,
            turnReasoningSummaryPartDone,
            turnReasoningSummaryTextDelta,
            turnReasoningSummaryTextDone,
        )

    override fun toString(): String =
        when {
            error != null -> "AgentSessionEvent{error=$error}"
            environmentReady != null -> "AgentSessionEvent{environmentReady=$environmentReady}"
            outputCommandExecutionOutputDelta != null ->
                "AgentSessionEvent{outputCommandExecutionOutputDelta=$outputCommandExecutionOutputDelta}"
            created != null -> "AgentSessionEvent{created=$created}"
            turnCreated != null -> "AgentSessionEvent{turnCreated=$turnCreated}"
            turnInProgress != null -> "AgentSessionEvent{turnInProgress=$turnInProgress}"
            turnCompleted != null -> "AgentSessionEvent{turnCompleted=$turnCompleted}"
            turnFailed != null -> "AgentSessionEvent{turnFailed=$turnFailed}"
            turnCancelled != null -> "AgentSessionEvent{turnCancelled=$turnCancelled}"
            turnItemAdded != null -> "AgentSessionEvent{turnItemAdded=$turnItemAdded}"
            idle != null -> "AgentSessionEvent{idle=$idle}"
            inProgress != null -> "AgentSessionEvent{inProgress=$inProgress}"
            requiresAction != null -> "AgentSessionEvent{requiresAction=$requiresAction}"
            failed != null -> "AgentSessionEvent{failed=$failed}"
            environmentPending != null ->
                "AgentSessionEvent{environmentPending=$environmentPending}"
            environmentConnected != null ->
                "AgentSessionEvent{environmentConnected=$environmentConnected}"
            environmentDisconnected != null ->
                "AgentSessionEvent{environmentDisconnected=$environmentDisconnected}"
            environmentFailed != null -> "AgentSessionEvent{environmentFailed=$environmentFailed}"
            subagentCreated != null -> "AgentSessionEvent{subagentCreated=$subagentCreated}"
            subagentActive != null -> "AgentSessionEvent{subagentActive=$subagentActive}"
            subagentClosed != null -> "AgentSessionEvent{subagentClosed=$subagentClosed}"
            turnItemDone != null -> "AgentSessionEvent{turnItemDone=$turnItemDone}"
            turnContentPartAdded != null ->
                "AgentSessionEvent{turnContentPartAdded=$turnContentPartAdded}"
            turnContentPartDone != null ->
                "AgentSessionEvent{turnContentPartDone=$turnContentPartDone}"
            turnOutputTextDelta != null ->
                "AgentSessionEvent{turnOutputTextDelta=$turnOutputTextDelta}"
            turnOutputTextDone != null ->
                "AgentSessionEvent{turnOutputTextDone=$turnOutputTextDone}"
            turnReasoningSummaryPartAdded != null ->
                "AgentSessionEvent{turnReasoningSummaryPartAdded=$turnReasoningSummaryPartAdded}"
            turnReasoningSummaryPartDone != null ->
                "AgentSessionEvent{turnReasoningSummaryPartDone=$turnReasoningSummaryPartDone}"
            turnReasoningSummaryTextDelta != null ->
                "AgentSessionEvent{turnReasoningSummaryTextDelta=$turnReasoningSummaryTextDelta}"
            turnReasoningSummaryTextDone != null ->
                "AgentSessionEvent{turnReasoningSummaryTextDone=$turnReasoningSummaryTextDone}"
            _json != null -> "AgentSessionEvent{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid AgentSessionEvent")
        }

    companion object {

        /** Emitted when a turn or session fails. */
        @JvmStatic fun ofError(error: AgentSessionErrorEvent) = AgentSessionEvent(error = error)

        /** Emitted when a hosted session environment is ready to connect. */
        @JvmStatic
        fun ofEnvironmentReady(environmentReady: AgentSessionEnvironmentReadyEvent) =
            AgentSessionEvent(environmentReady = environmentReady)

        /** Emitted when command execution produces an output delta. */
        @JvmStatic
        fun ofOutputCommandExecutionOutputDelta(
            outputCommandExecutionOutputDelta: AgentOutputCommandExecutionOutputDeltaEvent
        ) = AgentSessionEvent(outputCommandExecutionOutputDelta = outputCommandExecutionOutputDelta)

        /** Emitted when a session is created. */
        @JvmStatic
        fun ofCreated(created: AgentSessionCreatedEvent) = AgentSessionEvent(created = created)

        /** Emitted when a turn is created. */
        @JvmStatic
        fun ofTurnCreated(turnCreated: AgentSessionTurnCreatedEvent) =
            AgentSessionEvent(turnCreated = turnCreated)

        /** Emitted when a turn starts running. */
        @JvmStatic
        fun ofTurnInProgress(turnInProgress: AgentSessionTurnInProgressEvent) =
            AgentSessionEvent(turnInProgress = turnInProgress)

        /** Emitted when a turn completes. */
        @JvmStatic
        fun ofTurnCompleted(turnCompleted: AgentSessionTurnCompletedEvent) =
            AgentSessionEvent(turnCompleted = turnCompleted)

        /** Emitted when a turn fails. */
        @JvmStatic
        fun ofTurnFailed(turnFailed: AgentSessionTurnFailedEvent) =
            AgentSessionEvent(turnFailed = turnFailed)

        /** Emitted when a turn is cancelled. */
        @JvmStatic
        fun ofTurnCancelled(turnCancelled: AgentSessionTurnCancelledEvent) =
            AgentSessionEvent(turnCancelled = turnCancelled)

        /** Emitted when an item is added to a turn. */
        @JvmStatic
        fun ofTurnItemAdded(turnItemAdded: AgentSessionTurnItemAddedEvent) =
            AgentSessionEvent(turnItemAdded = turnItemAdded)

        /** Emitted when a session becomes idle. */
        @JvmStatic fun ofIdle(idle: AgentSessionIdleEvent) = AgentSessionEvent(idle = idle)

        /** Emitted when a session starts processing a turn. */
        @JvmStatic
        fun ofInProgress(inProgress: AgentSessionInProgressEvent) =
            AgentSessionEvent(inProgress = inProgress)

        /** Emitted when a session is waiting for one or more required actions. */
        @JvmStatic
        fun ofRequiresAction(requiresAction: AgentSessionRequiresActionEvent) =
            AgentSessionEvent(requiresAction = requiresAction)

        /** Emitted when a session fails. */
        @JvmStatic
        fun ofFailed(failed: AgentSessionFailedEvent) = AgentSessionEvent(failed = failed)

        /** Emitted while a session environment is being prepared. */
        @JvmStatic
        fun ofEnvironmentPending(environmentPending: AgentSessionEnvironmentPendingEvent) =
            AgentSessionEvent(environmentPending = environmentPending)

        /** Emitted when a session environment connects. */
        @JvmStatic
        fun ofEnvironmentConnected(environmentConnected: AgentSessionEnvironmentConnectedEvent) =
            AgentSessionEvent(environmentConnected = environmentConnected)

        /** Emitted when a session environment disconnects. */
        @JvmStatic
        fun ofEnvironmentDisconnected(
            environmentDisconnected: AgentSessionEnvironmentDisconnectedEvent
        ) = AgentSessionEvent(environmentDisconnected = environmentDisconnected)

        /** Emitted when a session environment fails. */
        @JvmStatic
        fun ofEnvironmentFailed(environmentFailed: AgentSessionEnvironmentFailedEvent) =
            AgentSessionEvent(environmentFailed = environmentFailed)

        /** Emitted when a subagent is created. */
        @JvmStatic
        fun ofSubagentCreated(subagentCreated: AgentSessionSubagentCreatedEvent) =
            AgentSessionEvent(subagentCreated = subagentCreated)

        /** Emitted when a closed subagent successfully resumes. */
        @JvmStatic
        fun ofSubagentActive(subagentActive: AgentSessionSubagentActiveEvent) =
            AgentSessionEvent(subagentActive = subagentActive)

        /** Emitted when a subagent is closed. */
        @JvmStatic
        fun ofSubagentClosed(subagentClosed: AgentSessionSubagentClosedEvent) =
            AgentSessionEvent(subagentClosed = subagentClosed)

        /** Emitted when an output item is complete. */
        @JvmStatic
        fun ofTurnItemDone(turnItemDone: AgentSessionTurnItemDoneEvent) =
            AgentSessionEvent(turnItemDone = turnItemDone)

        /** Emitted when an output text content part is added. */
        @JvmStatic
        fun ofTurnContentPartAdded(turnContentPartAdded: AgentSessionTurnContentPartAddedEvent) =
            AgentSessionEvent(turnContentPartAdded = turnContentPartAdded)

        /** Emitted when an output content part is complete. */
        @JvmStatic
        fun ofTurnContentPartDone(turnContentPartDone: AgentSessionTurnContentPartDoneEvent) =
            AgentSessionEvent(turnContentPartDone = turnContentPartDone)

        /** Emitted when text is appended to an output text content part. */
        @JvmStatic
        fun ofTurnOutputTextDelta(turnOutputTextDelta: AgentSessionTurnOutputTextDeltaEvent) =
            AgentSessionEvent(turnOutputTextDelta = turnOutputTextDelta)

        /** Emitted when an output text content part is complete. */
        @JvmStatic
        fun ofTurnOutputTextDone(turnOutputTextDone: AgentSessionTurnOutputTextDoneEvent) =
            AgentSessionEvent(turnOutputTextDone = turnOutputTextDone)

        /** Emitted when a reasoning summary content part is added. */
        @JvmStatic
        fun ofTurnReasoningSummaryPartAdded(
            turnReasoningSummaryPartAdded: AgentSessionTurnReasoningSummaryPartAddedEvent
        ) = AgentSessionEvent(turnReasoningSummaryPartAdded = turnReasoningSummaryPartAdded)

        /** Emitted when a reasoning summary part is complete. */
        @JvmStatic
        fun ofTurnReasoningSummaryPartDone(
            turnReasoningSummaryPartDone: AgentSessionTurnReasoningSummaryPartDoneEvent
        ) = AgentSessionEvent(turnReasoningSummaryPartDone = turnReasoningSummaryPartDone)

        /** Emitted when text is appended to a reasoning summary. */
        @JvmStatic
        fun ofTurnReasoningSummaryTextDelta(
            turnReasoningSummaryTextDelta: AgentSessionTurnReasoningSummaryTextDeltaEvent
        ) = AgentSessionEvent(turnReasoningSummaryTextDelta = turnReasoningSummaryTextDelta)

        /** Emitted when a reasoning summary content part is complete. */
        @JvmStatic
        fun ofTurnReasoningSummaryTextDone(
            turnReasoningSummaryTextDone: AgentSessionTurnReasoningSummaryTextDoneEvent
        ) = AgentSessionEvent(turnReasoningSummaryTextDone = turnReasoningSummaryTextDone)
    }

    /**
     * An interface that defines how to map each variant of [AgentSessionEvent] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /** Emitted when a turn or session fails. */
        fun visitError(error: AgentSessionErrorEvent): T

        /** Emitted when a hosted session environment is ready to connect. */
        fun visitEnvironmentReady(environmentReady: AgentSessionEnvironmentReadyEvent): T

        /** Emitted when command execution produces an output delta. */
        fun visitOutputCommandExecutionOutputDelta(
            outputCommandExecutionOutputDelta: AgentOutputCommandExecutionOutputDeltaEvent
        ): T

        /** Emitted when a session is created. */
        fun visitCreated(created: AgentSessionCreatedEvent): T

        /** Emitted when a turn is created. */
        fun visitTurnCreated(turnCreated: AgentSessionTurnCreatedEvent): T

        /** Emitted when a turn starts running. */
        fun visitTurnInProgress(turnInProgress: AgentSessionTurnInProgressEvent): T

        /** Emitted when a turn completes. */
        fun visitTurnCompleted(turnCompleted: AgentSessionTurnCompletedEvent): T

        /** Emitted when a turn fails. */
        fun visitTurnFailed(turnFailed: AgentSessionTurnFailedEvent): T

        /** Emitted when a turn is cancelled. */
        fun visitTurnCancelled(turnCancelled: AgentSessionTurnCancelledEvent): T

        /** Emitted when an item is added to a turn. */
        fun visitTurnItemAdded(turnItemAdded: AgentSessionTurnItemAddedEvent): T

        /** Emitted when a session becomes idle. */
        fun visitIdle(idle: AgentSessionIdleEvent): T

        /** Emitted when a session starts processing a turn. */
        fun visitInProgress(inProgress: AgentSessionInProgressEvent): T

        /** Emitted when a session is waiting for one or more required actions. */
        fun visitRequiresAction(requiresAction: AgentSessionRequiresActionEvent): T

        /** Emitted when a session fails. */
        fun visitFailed(failed: AgentSessionFailedEvent): T

        /** Emitted while a session environment is being prepared. */
        fun visitEnvironmentPending(environmentPending: AgentSessionEnvironmentPendingEvent): T

        /** Emitted when a session environment connects. */
        fun visitEnvironmentConnected(
            environmentConnected: AgentSessionEnvironmentConnectedEvent
        ): T

        /** Emitted when a session environment disconnects. */
        fun visitEnvironmentDisconnected(
            environmentDisconnected: AgentSessionEnvironmentDisconnectedEvent
        ): T

        /** Emitted when a session environment fails. */
        fun visitEnvironmentFailed(environmentFailed: AgentSessionEnvironmentFailedEvent): T

        /** Emitted when a subagent is created. */
        fun visitSubagentCreated(subagentCreated: AgentSessionSubagentCreatedEvent): T

        /** Emitted when a closed subagent successfully resumes. */
        fun visitSubagentActive(subagentActive: AgentSessionSubagentActiveEvent): T

        /** Emitted when a subagent is closed. */
        fun visitSubagentClosed(subagentClosed: AgentSessionSubagentClosedEvent): T

        /** Emitted when an output item is complete. */
        fun visitTurnItemDone(turnItemDone: AgentSessionTurnItemDoneEvent): T

        /** Emitted when an output text content part is added. */
        fun visitTurnContentPartAdded(
            turnContentPartAdded: AgentSessionTurnContentPartAddedEvent
        ): T

        /** Emitted when an output content part is complete. */
        fun visitTurnContentPartDone(turnContentPartDone: AgentSessionTurnContentPartDoneEvent): T

        /** Emitted when text is appended to an output text content part. */
        fun visitTurnOutputTextDelta(turnOutputTextDelta: AgentSessionTurnOutputTextDeltaEvent): T

        /** Emitted when an output text content part is complete. */
        fun visitTurnOutputTextDone(turnOutputTextDone: AgentSessionTurnOutputTextDoneEvent): T

        /** Emitted when a reasoning summary content part is added. */
        fun visitTurnReasoningSummaryPartAdded(
            turnReasoningSummaryPartAdded: AgentSessionTurnReasoningSummaryPartAddedEvent
        ): T

        /** Emitted when a reasoning summary part is complete. */
        fun visitTurnReasoningSummaryPartDone(
            turnReasoningSummaryPartDone: AgentSessionTurnReasoningSummaryPartDoneEvent
        ): T

        /** Emitted when text is appended to a reasoning summary. */
        fun visitTurnReasoningSummaryTextDelta(
            turnReasoningSummaryTextDelta: AgentSessionTurnReasoningSummaryTextDeltaEvent
        ): T

        /** Emitted when a reasoning summary content part is complete. */
        fun visitTurnReasoningSummaryTextDone(
            turnReasoningSummaryTextDone: AgentSessionTurnReasoningSummaryTextDoneEvent
        ): T

        /**
         * Maps an unknown variant of [AgentSessionEvent] to a value of type [T].
         *
         * An instance of [AgentSessionEvent] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown AgentSessionEvent: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<AgentSessionEvent>(AgentSessionEvent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): AgentSessionEvent {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "error" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentSessionErrorEvent>())?.let {
                        AgentSessionEvent(error = it, _json = json)
                    } ?: AgentSessionEvent(_json = json)
                }
                "agent.session.environment.ready" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentSessionEnvironmentReadyEvent>())
                        ?.let { AgentSessionEvent(environmentReady = it, _json = json) }
                        ?: AgentSessionEvent(_json = json)
                }
                "agent.output.command_execution_output.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<AgentOutputCommandExecutionOutputDeltaEvent>(),
                        )
                        ?.let {
                            AgentSessionEvent(outputCommandExecutionOutputDelta = it, _json = json)
                        } ?: AgentSessionEvent(_json = json)
                }
                "agent.session.created" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentSessionCreatedEvent>())?.let {
                        AgentSessionEvent(created = it, _json = json)
                    } ?: AgentSessionEvent(_json = json)
                }
                "agent.session.turn.created" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentSessionTurnCreatedEvent>())
                        ?.let { AgentSessionEvent(turnCreated = it, _json = json) }
                        ?: AgentSessionEvent(_json = json)
                }
                "agent.session.turn.in_progress" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentSessionTurnInProgressEvent>())
                        ?.let { AgentSessionEvent(turnInProgress = it, _json = json) }
                        ?: AgentSessionEvent(_json = json)
                }
                "agent.session.turn.completed" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentSessionTurnCompletedEvent>())
                        ?.let { AgentSessionEvent(turnCompleted = it, _json = json) }
                        ?: AgentSessionEvent(_json = json)
                }
                "agent.session.turn.failed" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentSessionTurnFailedEvent>())
                        ?.let { AgentSessionEvent(turnFailed = it, _json = json) }
                        ?: AgentSessionEvent(_json = json)
                }
                "agent.session.turn.cancelled" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentSessionTurnCancelledEvent>())
                        ?.let { AgentSessionEvent(turnCancelled = it, _json = json) }
                        ?: AgentSessionEvent(_json = json)
                }
                "agent.session.turn.item.added" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentSessionTurnItemAddedEvent>())
                        ?.let { AgentSessionEvent(turnItemAdded = it, _json = json) }
                        ?: AgentSessionEvent(_json = json)
                }
                "agent.session.idle" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentSessionIdleEvent>())?.let {
                        AgentSessionEvent(idle = it, _json = json)
                    } ?: AgentSessionEvent(_json = json)
                }
                "agent.session.in_progress" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentSessionInProgressEvent>())
                        ?.let { AgentSessionEvent(inProgress = it, _json = json) }
                        ?: AgentSessionEvent(_json = json)
                }
                "agent.session.requires_action" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentSessionRequiresActionEvent>())
                        ?.let { AgentSessionEvent(requiresAction = it, _json = json) }
                        ?: AgentSessionEvent(_json = json)
                }
                "agent.session.failed" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentSessionFailedEvent>())?.let {
                        AgentSessionEvent(failed = it, _json = json)
                    } ?: AgentSessionEvent(_json = json)
                }
                "agent.session.environment.pending" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<AgentSessionEnvironmentPendingEvent>(),
                        )
                        ?.let { AgentSessionEvent(environmentPending = it, _json = json) }
                        ?: AgentSessionEvent(_json = json)
                }
                "agent.session.environment.connected" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<AgentSessionEnvironmentConnectedEvent>(),
                        )
                        ?.let { AgentSessionEvent(environmentConnected = it, _json = json) }
                        ?: AgentSessionEvent(_json = json)
                }
                "agent.session.environment.disconnected" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<AgentSessionEnvironmentDisconnectedEvent>(),
                        )
                        ?.let { AgentSessionEvent(environmentDisconnected = it, _json = json) }
                        ?: AgentSessionEvent(_json = json)
                }
                "agent.session.environment.failed" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<AgentSessionEnvironmentFailedEvent>(),
                        )
                        ?.let { AgentSessionEvent(environmentFailed = it, _json = json) }
                        ?: AgentSessionEvent(_json = json)
                }
                "agent.session.subagent.created" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentSessionSubagentCreatedEvent>())
                        ?.let { AgentSessionEvent(subagentCreated = it, _json = json) }
                        ?: AgentSessionEvent(_json = json)
                }
                "agent.session.subagent.active" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentSessionSubagentActiveEvent>())
                        ?.let { AgentSessionEvent(subagentActive = it, _json = json) }
                        ?: AgentSessionEvent(_json = json)
                }
                "agent.session.subagent.closed" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentSessionSubagentClosedEvent>())
                        ?.let { AgentSessionEvent(subagentClosed = it, _json = json) }
                        ?: AgentSessionEvent(_json = json)
                }
                "agent.session.turn.item.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentSessionTurnItemDoneEvent>())
                        ?.let { AgentSessionEvent(turnItemDone = it, _json = json) }
                        ?: AgentSessionEvent(_json = json)
                }
                "agent.session.turn.content_part.added" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<AgentSessionTurnContentPartAddedEvent>(),
                        )
                        ?.let { AgentSessionEvent(turnContentPartAdded = it, _json = json) }
                        ?: AgentSessionEvent(_json = json)
                }
                "agent.session.turn.content_part.done" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<AgentSessionTurnContentPartDoneEvent>(),
                        )
                        ?.let { AgentSessionEvent(turnContentPartDone = it, _json = json) }
                        ?: AgentSessionEvent(_json = json)
                }
                "agent.session.turn.output_text.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<AgentSessionTurnOutputTextDeltaEvent>(),
                        )
                        ?.let { AgentSessionEvent(turnOutputTextDelta = it, _json = json) }
                        ?: AgentSessionEvent(_json = json)
                }
                "agent.session.turn.output_text.done" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<AgentSessionTurnOutputTextDoneEvent>(),
                        )
                        ?.let { AgentSessionEvent(turnOutputTextDone = it, _json = json) }
                        ?: AgentSessionEvent(_json = json)
                }
                "agent.session.turn.reasoning_summary_part.added" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<AgentSessionTurnReasoningSummaryPartAddedEvent>(),
                        )
                        ?.let {
                            AgentSessionEvent(turnReasoningSummaryPartAdded = it, _json = json)
                        } ?: AgentSessionEvent(_json = json)
                }
                "agent.session.turn.reasoning_summary_part.done" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<AgentSessionTurnReasoningSummaryPartDoneEvent>(),
                        )
                        ?.let { AgentSessionEvent(turnReasoningSummaryPartDone = it, _json = json) }
                        ?: AgentSessionEvent(_json = json)
                }
                "agent.session.turn.reasoning_summary_text.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<AgentSessionTurnReasoningSummaryTextDeltaEvent>(),
                        )
                        ?.let {
                            AgentSessionEvent(turnReasoningSummaryTextDelta = it, _json = json)
                        } ?: AgentSessionEvent(_json = json)
                }
                "agent.session.turn.reasoning_summary_text.done" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<AgentSessionTurnReasoningSummaryTextDoneEvent>(),
                        )
                        ?.let { AgentSessionEvent(turnReasoningSummaryTextDone = it, _json = json) }
                        ?: AgentSessionEvent(_json = json)
                }
            }

            return AgentSessionEvent(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<AgentSessionEvent>(AgentSessionEvent::class) {

        override fun serialize(
            value: AgentSessionEvent,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.error != null -> generator.writeObject(value.error)
                value.environmentReady != null -> generator.writeObject(value.environmentReady)
                value.outputCommandExecutionOutputDelta != null ->
                    generator.writeObject(value.outputCommandExecutionOutputDelta)
                value.created != null -> generator.writeObject(value.created)
                value.turnCreated != null -> generator.writeObject(value.turnCreated)
                value.turnInProgress != null -> generator.writeObject(value.turnInProgress)
                value.turnCompleted != null -> generator.writeObject(value.turnCompleted)
                value.turnFailed != null -> generator.writeObject(value.turnFailed)
                value.turnCancelled != null -> generator.writeObject(value.turnCancelled)
                value.turnItemAdded != null -> generator.writeObject(value.turnItemAdded)
                value.idle != null -> generator.writeObject(value.idle)
                value.inProgress != null -> generator.writeObject(value.inProgress)
                value.requiresAction != null -> generator.writeObject(value.requiresAction)
                value.failed != null -> generator.writeObject(value.failed)
                value.environmentPending != null -> generator.writeObject(value.environmentPending)
                value.environmentConnected != null ->
                    generator.writeObject(value.environmentConnected)
                value.environmentDisconnected != null ->
                    generator.writeObject(value.environmentDisconnected)
                value.environmentFailed != null -> generator.writeObject(value.environmentFailed)
                value.subagentCreated != null -> generator.writeObject(value.subagentCreated)
                value.subagentActive != null -> generator.writeObject(value.subagentActive)
                value.subagentClosed != null -> generator.writeObject(value.subagentClosed)
                value.turnItemDone != null -> generator.writeObject(value.turnItemDone)
                value.turnContentPartAdded != null ->
                    generator.writeObject(value.turnContentPartAdded)
                value.turnContentPartDone != null ->
                    generator.writeObject(value.turnContentPartDone)
                value.turnOutputTextDelta != null ->
                    generator.writeObject(value.turnOutputTextDelta)
                value.turnOutputTextDone != null -> generator.writeObject(value.turnOutputTextDone)
                value.turnReasoningSummaryPartAdded != null ->
                    generator.writeObject(value.turnReasoningSummaryPartAdded)
                value.turnReasoningSummaryPartDone != null ->
                    generator.writeObject(value.turnReasoningSummaryPartDone)
                value.turnReasoningSummaryTextDelta != null ->
                    generator.writeObject(value.turnReasoningSummaryTextDelta)
                value.turnReasoningSummaryTextDone != null ->
                    generator.writeObject(value.turnReasoningSummaryTextDone)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid AgentSessionEvent")
            }
        }
    }
}
