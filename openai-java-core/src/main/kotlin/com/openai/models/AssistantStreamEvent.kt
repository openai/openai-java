// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Represents an event emitted when streaming a Run.
 *
 * Each event in a server-sent events stream has an `event` and `data` property:
 * ```
 * event: thread.created
 * data: {"id": "thread_123", "object": "thread", ...}
 * ```
 *
 * We emit events whenever a new object is created, transitions to a new state, or is being streamed
 * in parts (deltas). For example, we emit `thread.run.created` when a new run is created,
 * `thread.run.completed` when a run completes, and so on. When an Assistant chooses to create a
 * message during a run, we emit a `thread.message.created event`, a `thread.message.in_progress`
 * event, many `thread.message.delta` events, and finally a `thread.message.completed` event.
 *
 * We may add additional events over time, so we recommend handling unknown events gracefully in
 * your code. See the
 * [Assistants API quickstart](https://platform.openai.com/docs/assistants/overview) to learn how to
 * integrate the Assistants API with streaming.
 */
@JsonDeserialize(using = AssistantStreamEvent.Deserializer::class)
@JsonSerialize(using = AssistantStreamEvent.Serializer::class)
class AssistantStreamEvent
private constructor(
    private val threadCreated: ThreadCreated? = null,
    private val threadRunCreated: ThreadRunCreated? = null,
    private val threadRunQueued: ThreadRunQueued? = null,
    private val threadRunInProgress: ThreadRunInProgress? = null,
    private val threadRunRequiresAction: ThreadRunRequiresAction? = null,
    private val threadRunCompleted: ThreadRunCompleted? = null,
    private val threadRunIncomplete: ThreadRunIncomplete? = null,
    private val threadRunFailed: ThreadRunFailed? = null,
    private val threadRunCancelling: ThreadRunCancelling? = null,
    private val threadRunCancelled: ThreadRunCancelled? = null,
    private val threadRunExpired: ThreadRunExpired? = null,
    private val threadRunStepCreated: ThreadRunStepCreated? = null,
    private val threadRunStepInProgress: ThreadRunStepInProgress? = null,
    private val threadRunStepDelta: ThreadRunStepDelta? = null,
    private val threadRunStepCompleted: ThreadRunStepCompleted? = null,
    private val threadRunStepFailed: ThreadRunStepFailed? = null,
    private val threadRunStepCancelled: ThreadRunStepCancelled? = null,
    private val threadRunStepExpired: ThreadRunStepExpired? = null,
    private val threadMessageCreated: ThreadMessageCreated? = null,
    private val threadMessageInProgress: ThreadMessageInProgress? = null,
    private val threadMessageDelta: ThreadMessageDelta? = null,
    private val threadMessageCompleted: ThreadMessageCompleted? = null,
    private val threadMessageIncomplete: ThreadMessageIncomplete? = null,
    private val errorEvent: ErrorEvent? = null,
    private val _json: JsonValue? = null,
) {

    /**
     * Occurs when a new [thread](https://platform.openai.com/docs/api-reference/threads/object) is
     * created.
     */
    fun threadCreated(): Optional<ThreadCreated> = Optional.ofNullable(threadCreated)

    /**
     * Occurs when a new [run](https://platform.openai.com/docs/api-reference/runs/object) is
     * created.
     */
    fun threadRunCreated(): Optional<ThreadRunCreated> = Optional.ofNullable(threadRunCreated)

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) moves to a
     * `queued` status.
     */
    fun threadRunQueued(): Optional<ThreadRunQueued> = Optional.ofNullable(threadRunQueued)

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) moves to an
     * `in_progress` status.
     */
    fun threadRunInProgress(): Optional<ThreadRunInProgress> =
        Optional.ofNullable(threadRunInProgress)

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) moves to a
     * `requires_action` status.
     */
    fun threadRunRequiresAction(): Optional<ThreadRunRequiresAction> =
        Optional.ofNullable(threadRunRequiresAction)

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) is completed.
     */
    fun threadRunCompleted(): Optional<ThreadRunCompleted> = Optional.ofNullable(threadRunCompleted)

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) ends with
     * status `incomplete`.
     */
    fun threadRunIncomplete(): Optional<ThreadRunIncomplete> =
        Optional.ofNullable(threadRunIncomplete)

    /** Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) fails. */
    fun threadRunFailed(): Optional<ThreadRunFailed> = Optional.ofNullable(threadRunFailed)

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) moves to a
     * `cancelling` status.
     */
    fun threadRunCancelling(): Optional<ThreadRunCancelling> =
        Optional.ofNullable(threadRunCancelling)

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) is cancelled.
     */
    fun threadRunCancelled(): Optional<ThreadRunCancelled> = Optional.ofNullable(threadRunCancelled)

    /** Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) expires. */
    fun threadRunExpired(): Optional<ThreadRunExpired> = Optional.ofNullable(threadRunExpired)

    /**
     * Occurs when a
     * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) is created.
     */
    fun threadRunStepCreated(): Optional<ThreadRunStepCreated> =
        Optional.ofNullable(threadRunStepCreated)

    /**
     * Occurs when a
     * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) moves to an
     * `in_progress` state.
     */
    fun threadRunStepInProgress(): Optional<ThreadRunStepInProgress> =
        Optional.ofNullable(threadRunStepInProgress)

    /**
     * Occurs when parts of a
     * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) are being
     * streamed.
     */
    fun threadRunStepDelta(): Optional<ThreadRunStepDelta> = Optional.ofNullable(threadRunStepDelta)

    /**
     * Occurs when a
     * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) is
     * completed.
     */
    fun threadRunStepCompleted(): Optional<ThreadRunStepCompleted> =
        Optional.ofNullable(threadRunStepCompleted)

    /**
     * Occurs when a
     * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) fails.
     */
    fun threadRunStepFailed(): Optional<ThreadRunStepFailed> =
        Optional.ofNullable(threadRunStepFailed)

    /**
     * Occurs when a
     * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) is
     * cancelled.
     */
    fun threadRunStepCancelled(): Optional<ThreadRunStepCancelled> =
        Optional.ofNullable(threadRunStepCancelled)

    /**
     * Occurs when a
     * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) expires.
     */
    fun threadRunStepExpired(): Optional<ThreadRunStepExpired> =
        Optional.ofNullable(threadRunStepExpired)

    /**
     * Occurs when a [message](https://platform.openai.com/docs/api-reference/messages/object) is
     * created.
     */
    fun threadMessageCreated(): Optional<ThreadMessageCreated> =
        Optional.ofNullable(threadMessageCreated)

    /**
     * Occurs when a [message](https://platform.openai.com/docs/api-reference/messages/object) moves
     * to an `in_progress` state.
     */
    fun threadMessageInProgress(): Optional<ThreadMessageInProgress> =
        Optional.ofNullable(threadMessageInProgress)

    /**
     * Occurs when parts of a
     * [Message](https://platform.openai.com/docs/api-reference/messages/object) are being streamed.
     */
    fun threadMessageDelta(): Optional<ThreadMessageDelta> = Optional.ofNullable(threadMessageDelta)

    /**
     * Occurs when a [message](https://platform.openai.com/docs/api-reference/messages/object) is
     * completed.
     */
    fun threadMessageCompleted(): Optional<ThreadMessageCompleted> =
        Optional.ofNullable(threadMessageCompleted)

    /**
     * Occurs when a [message](https://platform.openai.com/docs/api-reference/messages/object) ends
     * before it is completed.
     */
    fun threadMessageIncomplete(): Optional<ThreadMessageIncomplete> =
        Optional.ofNullable(threadMessageIncomplete)

    /**
     * Occurs when an [error](https://platform.openai.com/docs/guides/error-codes#api-errors)
     * occurs. This can happen due to an internal server error or a timeout.
     */
    fun errorEvent(): Optional<ErrorEvent> = Optional.ofNullable(errorEvent)

    fun isThreadCreated(): Boolean = threadCreated != null

    fun isThreadRunCreated(): Boolean = threadRunCreated != null

    fun isThreadRunQueued(): Boolean = threadRunQueued != null

    fun isThreadRunInProgress(): Boolean = threadRunInProgress != null

    fun isThreadRunRequiresAction(): Boolean = threadRunRequiresAction != null

    fun isThreadRunCompleted(): Boolean = threadRunCompleted != null

    fun isThreadRunIncomplete(): Boolean = threadRunIncomplete != null

    fun isThreadRunFailed(): Boolean = threadRunFailed != null

    fun isThreadRunCancelling(): Boolean = threadRunCancelling != null

    fun isThreadRunCancelled(): Boolean = threadRunCancelled != null

    fun isThreadRunExpired(): Boolean = threadRunExpired != null

    fun isThreadRunStepCreated(): Boolean = threadRunStepCreated != null

    fun isThreadRunStepInProgress(): Boolean = threadRunStepInProgress != null

    fun isThreadRunStepDelta(): Boolean = threadRunStepDelta != null

    fun isThreadRunStepCompleted(): Boolean = threadRunStepCompleted != null

    fun isThreadRunStepFailed(): Boolean = threadRunStepFailed != null

    fun isThreadRunStepCancelled(): Boolean = threadRunStepCancelled != null

    fun isThreadRunStepExpired(): Boolean = threadRunStepExpired != null

    fun isThreadMessageCreated(): Boolean = threadMessageCreated != null

    fun isThreadMessageInProgress(): Boolean = threadMessageInProgress != null

    fun isThreadMessageDelta(): Boolean = threadMessageDelta != null

    fun isThreadMessageCompleted(): Boolean = threadMessageCompleted != null

    fun isThreadMessageIncomplete(): Boolean = threadMessageIncomplete != null

    fun isErrorEvent(): Boolean = errorEvent != null

    /**
     * Occurs when a new [thread](https://platform.openai.com/docs/api-reference/threads/object) is
     * created.
     */
    fun asThreadCreated(): ThreadCreated = threadCreated.getOrThrow("threadCreated")

    /**
     * Occurs when a new [run](https://platform.openai.com/docs/api-reference/runs/object) is
     * created.
     */
    fun asThreadRunCreated(): ThreadRunCreated = threadRunCreated.getOrThrow("threadRunCreated")

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) moves to a
     * `queued` status.
     */
    fun asThreadRunQueued(): ThreadRunQueued = threadRunQueued.getOrThrow("threadRunQueued")

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) moves to an
     * `in_progress` status.
     */
    fun asThreadRunInProgress(): ThreadRunInProgress =
        threadRunInProgress.getOrThrow("threadRunInProgress")

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) moves to a
     * `requires_action` status.
     */
    fun asThreadRunRequiresAction(): ThreadRunRequiresAction =
        threadRunRequiresAction.getOrThrow("threadRunRequiresAction")

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) is completed.
     */
    fun asThreadRunCompleted(): ThreadRunCompleted =
        threadRunCompleted.getOrThrow("threadRunCompleted")

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) ends with
     * status `incomplete`.
     */
    fun asThreadRunIncomplete(): ThreadRunIncomplete =
        threadRunIncomplete.getOrThrow("threadRunIncomplete")

    /** Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) fails. */
    fun asThreadRunFailed(): ThreadRunFailed = threadRunFailed.getOrThrow("threadRunFailed")

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) moves to a
     * `cancelling` status.
     */
    fun asThreadRunCancelling(): ThreadRunCancelling =
        threadRunCancelling.getOrThrow("threadRunCancelling")

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) is cancelled.
     */
    fun asThreadRunCancelled(): ThreadRunCancelled =
        threadRunCancelled.getOrThrow("threadRunCancelled")

    /** Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) expires. */
    fun asThreadRunExpired(): ThreadRunExpired = threadRunExpired.getOrThrow("threadRunExpired")

    /**
     * Occurs when a
     * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) is created.
     */
    fun asThreadRunStepCreated(): ThreadRunStepCreated =
        threadRunStepCreated.getOrThrow("threadRunStepCreated")

    /**
     * Occurs when a
     * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) moves to an
     * `in_progress` state.
     */
    fun asThreadRunStepInProgress(): ThreadRunStepInProgress =
        threadRunStepInProgress.getOrThrow("threadRunStepInProgress")

    /**
     * Occurs when parts of a
     * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) are being
     * streamed.
     */
    fun asThreadRunStepDelta(): ThreadRunStepDelta =
        threadRunStepDelta.getOrThrow("threadRunStepDelta")

    /**
     * Occurs when a
     * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) is
     * completed.
     */
    fun asThreadRunStepCompleted(): ThreadRunStepCompleted =
        threadRunStepCompleted.getOrThrow("threadRunStepCompleted")

    /**
     * Occurs when a
     * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) fails.
     */
    fun asThreadRunStepFailed(): ThreadRunStepFailed =
        threadRunStepFailed.getOrThrow("threadRunStepFailed")

    /**
     * Occurs when a
     * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) is
     * cancelled.
     */
    fun asThreadRunStepCancelled(): ThreadRunStepCancelled =
        threadRunStepCancelled.getOrThrow("threadRunStepCancelled")

    /**
     * Occurs when a
     * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) expires.
     */
    fun asThreadRunStepExpired(): ThreadRunStepExpired =
        threadRunStepExpired.getOrThrow("threadRunStepExpired")

    /**
     * Occurs when a [message](https://platform.openai.com/docs/api-reference/messages/object) is
     * created.
     */
    fun asThreadMessageCreated(): ThreadMessageCreated =
        threadMessageCreated.getOrThrow("threadMessageCreated")

    /**
     * Occurs when a [message](https://platform.openai.com/docs/api-reference/messages/object) moves
     * to an `in_progress` state.
     */
    fun asThreadMessageInProgress(): ThreadMessageInProgress =
        threadMessageInProgress.getOrThrow("threadMessageInProgress")

    /**
     * Occurs when parts of a
     * [Message](https://platform.openai.com/docs/api-reference/messages/object) are being streamed.
     */
    fun asThreadMessageDelta(): ThreadMessageDelta =
        threadMessageDelta.getOrThrow("threadMessageDelta")

    /**
     * Occurs when a [message](https://platform.openai.com/docs/api-reference/messages/object) is
     * completed.
     */
    fun asThreadMessageCompleted(): ThreadMessageCompleted =
        threadMessageCompleted.getOrThrow("threadMessageCompleted")

    /**
     * Occurs when a [message](https://platform.openai.com/docs/api-reference/messages/object) ends
     * before it is completed.
     */
    fun asThreadMessageIncomplete(): ThreadMessageIncomplete =
        threadMessageIncomplete.getOrThrow("threadMessageIncomplete")

    /**
     * Occurs when an [error](https://platform.openai.com/docs/guides/error-codes#api-errors)
     * occurs. This can happen due to an internal server error or a timeout.
     */
    fun asErrorEvent(): ErrorEvent = errorEvent.getOrThrow("errorEvent")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            threadCreated != null -> visitor.visitThreadCreated(threadCreated)
            threadRunCreated != null -> visitor.visitThreadRunCreated(threadRunCreated)
            threadRunQueued != null -> visitor.visitThreadRunQueued(threadRunQueued)
            threadRunInProgress != null -> visitor.visitThreadRunInProgress(threadRunInProgress)
            threadRunRequiresAction != null ->
                visitor.visitThreadRunRequiresAction(threadRunRequiresAction)
            threadRunCompleted != null -> visitor.visitThreadRunCompleted(threadRunCompleted)
            threadRunIncomplete != null -> visitor.visitThreadRunIncomplete(threadRunIncomplete)
            threadRunFailed != null -> visitor.visitThreadRunFailed(threadRunFailed)
            threadRunCancelling != null -> visitor.visitThreadRunCancelling(threadRunCancelling)
            threadRunCancelled != null -> visitor.visitThreadRunCancelled(threadRunCancelled)
            threadRunExpired != null -> visitor.visitThreadRunExpired(threadRunExpired)
            threadRunStepCreated != null -> visitor.visitThreadRunStepCreated(threadRunStepCreated)
            threadRunStepInProgress != null ->
                visitor.visitThreadRunStepInProgress(threadRunStepInProgress)
            threadRunStepDelta != null -> visitor.visitThreadRunStepDelta(threadRunStepDelta)
            threadRunStepCompleted != null ->
                visitor.visitThreadRunStepCompleted(threadRunStepCompleted)
            threadRunStepFailed != null -> visitor.visitThreadRunStepFailed(threadRunStepFailed)
            threadRunStepCancelled != null ->
                visitor.visitThreadRunStepCancelled(threadRunStepCancelled)
            threadRunStepExpired != null -> visitor.visitThreadRunStepExpired(threadRunStepExpired)
            threadMessageCreated != null -> visitor.visitThreadMessageCreated(threadMessageCreated)
            threadMessageInProgress != null ->
                visitor.visitThreadMessageInProgress(threadMessageInProgress)
            threadMessageDelta != null -> visitor.visitThreadMessageDelta(threadMessageDelta)
            threadMessageCompleted != null ->
                visitor.visitThreadMessageCompleted(threadMessageCompleted)
            threadMessageIncomplete != null ->
                visitor.visitThreadMessageIncomplete(threadMessageIncomplete)
            errorEvent != null -> visitor.visitErrorEvent(errorEvent)
            else -> visitor.unknown(_json)
        }
    }

    private var validated: Boolean = false

    fun validate(): AssistantStreamEvent = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitThreadCreated(threadCreated: ThreadCreated) {
                    threadCreated.validate()
                }

                override fun visitThreadRunCreated(threadRunCreated: ThreadRunCreated) {
                    threadRunCreated.validate()
                }

                override fun visitThreadRunQueued(threadRunQueued: ThreadRunQueued) {
                    threadRunQueued.validate()
                }

                override fun visitThreadRunInProgress(threadRunInProgress: ThreadRunInProgress) {
                    threadRunInProgress.validate()
                }

                override fun visitThreadRunRequiresAction(
                    threadRunRequiresAction: ThreadRunRequiresAction
                ) {
                    threadRunRequiresAction.validate()
                }

                override fun visitThreadRunCompleted(threadRunCompleted: ThreadRunCompleted) {
                    threadRunCompleted.validate()
                }

                override fun visitThreadRunIncomplete(threadRunIncomplete: ThreadRunIncomplete) {
                    threadRunIncomplete.validate()
                }

                override fun visitThreadRunFailed(threadRunFailed: ThreadRunFailed) {
                    threadRunFailed.validate()
                }

                override fun visitThreadRunCancelling(threadRunCancelling: ThreadRunCancelling) {
                    threadRunCancelling.validate()
                }

                override fun visitThreadRunCancelled(threadRunCancelled: ThreadRunCancelled) {
                    threadRunCancelled.validate()
                }

                override fun visitThreadRunExpired(threadRunExpired: ThreadRunExpired) {
                    threadRunExpired.validate()
                }

                override fun visitThreadRunStepCreated(threadRunStepCreated: ThreadRunStepCreated) {
                    threadRunStepCreated.validate()
                }

                override fun visitThreadRunStepInProgress(
                    threadRunStepInProgress: ThreadRunStepInProgress
                ) {
                    threadRunStepInProgress.validate()
                }

                override fun visitThreadRunStepDelta(threadRunStepDelta: ThreadRunStepDelta) {
                    threadRunStepDelta.validate()
                }

                override fun visitThreadRunStepCompleted(
                    threadRunStepCompleted: ThreadRunStepCompleted
                ) {
                    threadRunStepCompleted.validate()
                }

                override fun visitThreadRunStepFailed(threadRunStepFailed: ThreadRunStepFailed) {
                    threadRunStepFailed.validate()
                }

                override fun visitThreadRunStepCancelled(
                    threadRunStepCancelled: ThreadRunStepCancelled
                ) {
                    threadRunStepCancelled.validate()
                }

                override fun visitThreadRunStepExpired(threadRunStepExpired: ThreadRunStepExpired) {
                    threadRunStepExpired.validate()
                }

                override fun visitThreadMessageCreated(threadMessageCreated: ThreadMessageCreated) {
                    threadMessageCreated.validate()
                }

                override fun visitThreadMessageInProgress(
                    threadMessageInProgress: ThreadMessageInProgress
                ) {
                    threadMessageInProgress.validate()
                }

                override fun visitThreadMessageDelta(threadMessageDelta: ThreadMessageDelta) {
                    threadMessageDelta.validate()
                }

                override fun visitThreadMessageCompleted(
                    threadMessageCompleted: ThreadMessageCompleted
                ) {
                    threadMessageCompleted.validate()
                }

                override fun visitThreadMessageIncomplete(
                    threadMessageIncomplete: ThreadMessageIncomplete
                ) {
                    threadMessageIncomplete.validate()
                }

                override fun visitErrorEvent(errorEvent: ErrorEvent) {
                    errorEvent.validate()
                }
            }
        )
        validated = true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is AssistantStreamEvent && threadCreated == other.threadCreated && threadRunCreated == other.threadRunCreated && threadRunQueued == other.threadRunQueued && threadRunInProgress == other.threadRunInProgress && threadRunRequiresAction == other.threadRunRequiresAction && threadRunCompleted == other.threadRunCompleted && threadRunIncomplete == other.threadRunIncomplete && threadRunFailed == other.threadRunFailed && threadRunCancelling == other.threadRunCancelling && threadRunCancelled == other.threadRunCancelled && threadRunExpired == other.threadRunExpired && threadRunStepCreated == other.threadRunStepCreated && threadRunStepInProgress == other.threadRunStepInProgress && threadRunStepDelta == other.threadRunStepDelta && threadRunStepCompleted == other.threadRunStepCompleted && threadRunStepFailed == other.threadRunStepFailed && threadRunStepCancelled == other.threadRunStepCancelled && threadRunStepExpired == other.threadRunStepExpired && threadMessageCreated == other.threadMessageCreated && threadMessageInProgress == other.threadMessageInProgress && threadMessageDelta == other.threadMessageDelta && threadMessageCompleted == other.threadMessageCompleted && threadMessageIncomplete == other.threadMessageIncomplete && errorEvent == other.errorEvent /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(threadCreated, threadRunCreated, threadRunQueued, threadRunInProgress, threadRunRequiresAction, threadRunCompleted, threadRunIncomplete, threadRunFailed, threadRunCancelling, threadRunCancelled, threadRunExpired, threadRunStepCreated, threadRunStepInProgress, threadRunStepDelta, threadRunStepCompleted, threadRunStepFailed, threadRunStepCancelled, threadRunStepExpired, threadMessageCreated, threadMessageInProgress, threadMessageDelta, threadMessageCompleted, threadMessageIncomplete, errorEvent) /* spotless:on */

    override fun toString(): String =
        when {
            threadCreated != null -> "AssistantStreamEvent{threadCreated=$threadCreated}"
            threadRunCreated != null -> "AssistantStreamEvent{threadRunCreated=$threadRunCreated}"
            threadRunQueued != null -> "AssistantStreamEvent{threadRunQueued=$threadRunQueued}"
            threadRunInProgress != null ->
                "AssistantStreamEvent{threadRunInProgress=$threadRunInProgress}"
            threadRunRequiresAction != null ->
                "AssistantStreamEvent{threadRunRequiresAction=$threadRunRequiresAction}"
            threadRunCompleted != null ->
                "AssistantStreamEvent{threadRunCompleted=$threadRunCompleted}"
            threadRunIncomplete != null ->
                "AssistantStreamEvent{threadRunIncomplete=$threadRunIncomplete}"
            threadRunFailed != null -> "AssistantStreamEvent{threadRunFailed=$threadRunFailed}"
            threadRunCancelling != null ->
                "AssistantStreamEvent{threadRunCancelling=$threadRunCancelling}"
            threadRunCancelled != null ->
                "AssistantStreamEvent{threadRunCancelled=$threadRunCancelled}"
            threadRunExpired != null -> "AssistantStreamEvent{threadRunExpired=$threadRunExpired}"
            threadRunStepCreated != null ->
                "AssistantStreamEvent{threadRunStepCreated=$threadRunStepCreated}"
            threadRunStepInProgress != null ->
                "AssistantStreamEvent{threadRunStepInProgress=$threadRunStepInProgress}"
            threadRunStepDelta != null ->
                "AssistantStreamEvent{threadRunStepDelta=$threadRunStepDelta}"
            threadRunStepCompleted != null ->
                "AssistantStreamEvent{threadRunStepCompleted=$threadRunStepCompleted}"
            threadRunStepFailed != null ->
                "AssistantStreamEvent{threadRunStepFailed=$threadRunStepFailed}"
            threadRunStepCancelled != null ->
                "AssistantStreamEvent{threadRunStepCancelled=$threadRunStepCancelled}"
            threadRunStepExpired != null ->
                "AssistantStreamEvent{threadRunStepExpired=$threadRunStepExpired}"
            threadMessageCreated != null ->
                "AssistantStreamEvent{threadMessageCreated=$threadMessageCreated}"
            threadMessageInProgress != null ->
                "AssistantStreamEvent{threadMessageInProgress=$threadMessageInProgress}"
            threadMessageDelta != null ->
                "AssistantStreamEvent{threadMessageDelta=$threadMessageDelta}"
            threadMessageCompleted != null ->
                "AssistantStreamEvent{threadMessageCompleted=$threadMessageCompleted}"
            threadMessageIncomplete != null ->
                "AssistantStreamEvent{threadMessageIncomplete=$threadMessageIncomplete}"
            errorEvent != null -> "AssistantStreamEvent{errorEvent=$errorEvent}"
            _json != null -> "AssistantStreamEvent{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid AssistantStreamEvent")
        }

    companion object {

        /**
         * Occurs when a new [thread](https://platform.openai.com/docs/api-reference/threads/object)
         * is created.
         */
        @JvmStatic
        fun ofThreadCreated(threadCreated: ThreadCreated) =
            AssistantStreamEvent(threadCreated = threadCreated)

        /**
         * Occurs when a new [run](https://platform.openai.com/docs/api-reference/runs/object) is
         * created.
         */
        @JvmStatic
        fun ofThreadRunCreated(threadRunCreated: ThreadRunCreated) =
            AssistantStreamEvent(threadRunCreated = threadRunCreated)

        /**
         * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) moves to
         * a `queued` status.
         */
        @JvmStatic
        fun ofThreadRunQueued(threadRunQueued: ThreadRunQueued) =
            AssistantStreamEvent(threadRunQueued = threadRunQueued)

        /**
         * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) moves to
         * an `in_progress` status.
         */
        @JvmStatic
        fun ofThreadRunInProgress(threadRunInProgress: ThreadRunInProgress) =
            AssistantStreamEvent(threadRunInProgress = threadRunInProgress)

        /**
         * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) moves to
         * a `requires_action` status.
         */
        @JvmStatic
        fun ofThreadRunRequiresAction(threadRunRequiresAction: ThreadRunRequiresAction) =
            AssistantStreamEvent(threadRunRequiresAction = threadRunRequiresAction)

        /**
         * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) is
         * completed.
         */
        @JvmStatic
        fun ofThreadRunCompleted(threadRunCompleted: ThreadRunCompleted) =
            AssistantStreamEvent(threadRunCompleted = threadRunCompleted)

        /**
         * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) ends with
         * status `incomplete`.
         */
        @JvmStatic
        fun ofThreadRunIncomplete(threadRunIncomplete: ThreadRunIncomplete) =
            AssistantStreamEvent(threadRunIncomplete = threadRunIncomplete)

        /**
         * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) fails.
         */
        @JvmStatic
        fun ofThreadRunFailed(threadRunFailed: ThreadRunFailed) =
            AssistantStreamEvent(threadRunFailed = threadRunFailed)

        /**
         * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) moves to
         * a `cancelling` status.
         */
        @JvmStatic
        fun ofThreadRunCancelling(threadRunCancelling: ThreadRunCancelling) =
            AssistantStreamEvent(threadRunCancelling = threadRunCancelling)

        /**
         * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) is
         * cancelled.
         */
        @JvmStatic
        fun ofThreadRunCancelled(threadRunCancelled: ThreadRunCancelled) =
            AssistantStreamEvent(threadRunCancelled = threadRunCancelled)

        /**
         * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) expires.
         */
        @JvmStatic
        fun ofThreadRunExpired(threadRunExpired: ThreadRunExpired) =
            AssistantStreamEvent(threadRunExpired = threadRunExpired)

        /**
         * Occurs when a
         * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) is
         * created.
         */
        @JvmStatic
        fun ofThreadRunStepCreated(threadRunStepCreated: ThreadRunStepCreated) =
            AssistantStreamEvent(threadRunStepCreated = threadRunStepCreated)

        /**
         * Occurs when a
         * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) moves to
         * an `in_progress` state.
         */
        @JvmStatic
        fun ofThreadRunStepInProgress(threadRunStepInProgress: ThreadRunStepInProgress) =
            AssistantStreamEvent(threadRunStepInProgress = threadRunStepInProgress)

        /**
         * Occurs when parts of a
         * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) are
         * being streamed.
         */
        @JvmStatic
        fun ofThreadRunStepDelta(threadRunStepDelta: ThreadRunStepDelta) =
            AssistantStreamEvent(threadRunStepDelta = threadRunStepDelta)

        /**
         * Occurs when a
         * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) is
         * completed.
         */
        @JvmStatic
        fun ofThreadRunStepCompleted(threadRunStepCompleted: ThreadRunStepCompleted) =
            AssistantStreamEvent(threadRunStepCompleted = threadRunStepCompleted)

        /**
         * Occurs when a
         * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) fails.
         */
        @JvmStatic
        fun ofThreadRunStepFailed(threadRunStepFailed: ThreadRunStepFailed) =
            AssistantStreamEvent(threadRunStepFailed = threadRunStepFailed)

        /**
         * Occurs when a
         * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) is
         * cancelled.
         */
        @JvmStatic
        fun ofThreadRunStepCancelled(threadRunStepCancelled: ThreadRunStepCancelled) =
            AssistantStreamEvent(threadRunStepCancelled = threadRunStepCancelled)

        /**
         * Occurs when a
         * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) expires.
         */
        @JvmStatic
        fun ofThreadRunStepExpired(threadRunStepExpired: ThreadRunStepExpired) =
            AssistantStreamEvent(threadRunStepExpired = threadRunStepExpired)

        /**
         * Occurs when a [message](https://platform.openai.com/docs/api-reference/messages/object)
         * is created.
         */
        @JvmStatic
        fun ofThreadMessageCreated(threadMessageCreated: ThreadMessageCreated) =
            AssistantStreamEvent(threadMessageCreated = threadMessageCreated)

        /**
         * Occurs when a [message](https://platform.openai.com/docs/api-reference/messages/object)
         * moves to an `in_progress` state.
         */
        @JvmStatic
        fun ofThreadMessageInProgress(threadMessageInProgress: ThreadMessageInProgress) =
            AssistantStreamEvent(threadMessageInProgress = threadMessageInProgress)

        /**
         * Occurs when parts of a
         * [Message](https://platform.openai.com/docs/api-reference/messages/object) are being
         * streamed.
         */
        @JvmStatic
        fun ofThreadMessageDelta(threadMessageDelta: ThreadMessageDelta) =
            AssistantStreamEvent(threadMessageDelta = threadMessageDelta)

        /**
         * Occurs when a [message](https://platform.openai.com/docs/api-reference/messages/object)
         * is completed.
         */
        @JvmStatic
        fun ofThreadMessageCompleted(threadMessageCompleted: ThreadMessageCompleted) =
            AssistantStreamEvent(threadMessageCompleted = threadMessageCompleted)

        /**
         * Occurs when a [message](https://platform.openai.com/docs/api-reference/messages/object)
         * ends before it is completed.
         */
        @JvmStatic
        fun ofThreadMessageIncomplete(threadMessageIncomplete: ThreadMessageIncomplete) =
            AssistantStreamEvent(threadMessageIncomplete = threadMessageIncomplete)

        /**
         * Occurs when an [error](https://platform.openai.com/docs/guides/error-codes#api-errors)
         * occurs. This can happen due to an internal server error or a timeout.
         */
        @JvmStatic
        fun ofErrorEvent(errorEvent: ErrorEvent) = AssistantStreamEvent(errorEvent = errorEvent)
    }

    interface Visitor<out T> {

        /**
         * Occurs when a new [thread](https://platform.openai.com/docs/api-reference/threads/object)
         * is created.
         */
        fun visitThreadCreated(threadCreated: ThreadCreated): T

        /**
         * Occurs when a new [run](https://platform.openai.com/docs/api-reference/runs/object) is
         * created.
         */
        fun visitThreadRunCreated(threadRunCreated: ThreadRunCreated): T

        /**
         * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) moves to
         * a `queued` status.
         */
        fun visitThreadRunQueued(threadRunQueued: ThreadRunQueued): T

        /**
         * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) moves to
         * an `in_progress` status.
         */
        fun visitThreadRunInProgress(threadRunInProgress: ThreadRunInProgress): T

        /**
         * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) moves to
         * a `requires_action` status.
         */
        fun visitThreadRunRequiresAction(threadRunRequiresAction: ThreadRunRequiresAction): T

        /**
         * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) is
         * completed.
         */
        fun visitThreadRunCompleted(threadRunCompleted: ThreadRunCompleted): T

        /**
         * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) ends with
         * status `incomplete`.
         */
        fun visitThreadRunIncomplete(threadRunIncomplete: ThreadRunIncomplete): T

        /**
         * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) fails.
         */
        fun visitThreadRunFailed(threadRunFailed: ThreadRunFailed): T

        /**
         * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) moves to
         * a `cancelling` status.
         */
        fun visitThreadRunCancelling(threadRunCancelling: ThreadRunCancelling): T

        /**
         * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) is
         * cancelled.
         */
        fun visitThreadRunCancelled(threadRunCancelled: ThreadRunCancelled): T

        /**
         * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) expires.
         */
        fun visitThreadRunExpired(threadRunExpired: ThreadRunExpired): T

        /**
         * Occurs when a
         * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) is
         * created.
         */
        fun visitThreadRunStepCreated(threadRunStepCreated: ThreadRunStepCreated): T

        /**
         * Occurs when a
         * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) moves to
         * an `in_progress` state.
         */
        fun visitThreadRunStepInProgress(threadRunStepInProgress: ThreadRunStepInProgress): T

        /**
         * Occurs when parts of a
         * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) are
         * being streamed.
         */
        fun visitThreadRunStepDelta(threadRunStepDelta: ThreadRunStepDelta): T

        /**
         * Occurs when a
         * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) is
         * completed.
         */
        fun visitThreadRunStepCompleted(threadRunStepCompleted: ThreadRunStepCompleted): T

        /**
         * Occurs when a
         * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) fails.
         */
        fun visitThreadRunStepFailed(threadRunStepFailed: ThreadRunStepFailed): T

        /**
         * Occurs when a
         * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) is
         * cancelled.
         */
        fun visitThreadRunStepCancelled(threadRunStepCancelled: ThreadRunStepCancelled): T

        /**
         * Occurs when a
         * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) expires.
         */
        fun visitThreadRunStepExpired(threadRunStepExpired: ThreadRunStepExpired): T

        /**
         * Occurs when a [message](https://platform.openai.com/docs/api-reference/messages/object)
         * is created.
         */
        fun visitThreadMessageCreated(threadMessageCreated: ThreadMessageCreated): T

        /**
         * Occurs when a [message](https://platform.openai.com/docs/api-reference/messages/object)
         * moves to an `in_progress` state.
         */
        fun visitThreadMessageInProgress(threadMessageInProgress: ThreadMessageInProgress): T

        /**
         * Occurs when parts of a
         * [Message](https://platform.openai.com/docs/api-reference/messages/object) are being
         * streamed.
         */
        fun visitThreadMessageDelta(threadMessageDelta: ThreadMessageDelta): T

        /**
         * Occurs when a [message](https://platform.openai.com/docs/api-reference/messages/object)
         * is completed.
         */
        fun visitThreadMessageCompleted(threadMessageCompleted: ThreadMessageCompleted): T

        /**
         * Occurs when a [message](https://platform.openai.com/docs/api-reference/messages/object)
         * ends before it is completed.
         */
        fun visitThreadMessageIncomplete(threadMessageIncomplete: ThreadMessageIncomplete): T

        /**
         * Occurs when an [error](https://platform.openai.com/docs/guides/error-codes#api-errors)
         * occurs. This can happen due to an internal server error or a timeout.
         */
        fun visitErrorEvent(errorEvent: ErrorEvent): T

        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown AssistantStreamEvent: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<AssistantStreamEvent>(AssistantStreamEvent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): AssistantStreamEvent {
            val json = JsonValue.fromJsonNode(node)
            val event = json.asObject().getOrNull()?.get("event")?.asString()?.getOrNull()

            when (event) {
                "thread.created" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadCreated>()) { it.validate() }
                        ?.let {
                            return AssistantStreamEvent(threadCreated = it, _json = json)
                        }
                }
                "thread.run.created" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadRunCreated>()) { it.validate() }
                        ?.let {
                            return AssistantStreamEvent(threadRunCreated = it, _json = json)
                        }
                }
                "thread.run.queued" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadRunQueued>()) { it.validate() }
                        ?.let {
                            return AssistantStreamEvent(threadRunQueued = it, _json = json)
                        }
                }
                "thread.run.in_progress" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadRunInProgress>()) { it.validate() }
                        ?.let {
                            return AssistantStreamEvent(threadRunInProgress = it, _json = json)
                        }
                }
                "thread.run.requires_action" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadRunRequiresAction>()) {
                            it.validate()
                        }
                        ?.let {
                            return AssistantStreamEvent(threadRunRequiresAction = it, _json = json)
                        }
                }
                "thread.run.completed" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadRunCompleted>()) { it.validate() }
                        ?.let {
                            return AssistantStreamEvent(threadRunCompleted = it, _json = json)
                        }
                }
                "thread.run.incomplete" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadRunIncomplete>()) { it.validate() }
                        ?.let {
                            return AssistantStreamEvent(threadRunIncomplete = it, _json = json)
                        }
                }
                "thread.run.failed" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadRunFailed>()) { it.validate() }
                        ?.let {
                            return AssistantStreamEvent(threadRunFailed = it, _json = json)
                        }
                }
                "thread.run.cancelling" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadRunCancelling>()) { it.validate() }
                        ?.let {
                            return AssistantStreamEvent(threadRunCancelling = it, _json = json)
                        }
                }
                "thread.run.cancelled" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadRunCancelled>()) { it.validate() }
                        ?.let {
                            return AssistantStreamEvent(threadRunCancelled = it, _json = json)
                        }
                }
                "thread.run.expired" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadRunExpired>()) { it.validate() }
                        ?.let {
                            return AssistantStreamEvent(threadRunExpired = it, _json = json)
                        }
                }
                "thread.run.step.created" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadRunStepCreated>()) { it.validate() }
                        ?.let {
                            return AssistantStreamEvent(threadRunStepCreated = it, _json = json)
                        }
                }
                "thread.run.step.in_progress" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadRunStepInProgress>()) {
                            it.validate()
                        }
                        ?.let {
                            return AssistantStreamEvent(threadRunStepInProgress = it, _json = json)
                        }
                }
                "thread.run.step.delta" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadRunStepDelta>()) { it.validate() }
                        ?.let {
                            return AssistantStreamEvent(threadRunStepDelta = it, _json = json)
                        }
                }
                "thread.run.step.completed" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadRunStepCompleted>()) { it.validate() }
                        ?.let {
                            return AssistantStreamEvent(threadRunStepCompleted = it, _json = json)
                        }
                }
                "thread.run.step.failed" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadRunStepFailed>()) { it.validate() }
                        ?.let {
                            return AssistantStreamEvent(threadRunStepFailed = it, _json = json)
                        }
                }
                "thread.run.step.cancelled" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadRunStepCancelled>()) { it.validate() }
                        ?.let {
                            return AssistantStreamEvent(threadRunStepCancelled = it, _json = json)
                        }
                }
                "thread.run.step.expired" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadRunStepExpired>()) { it.validate() }
                        ?.let {
                            return AssistantStreamEvent(threadRunStepExpired = it, _json = json)
                        }
                }
                "thread.message.created" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadMessageCreated>()) { it.validate() }
                        ?.let {
                            return AssistantStreamEvent(threadMessageCreated = it, _json = json)
                        }
                }
                "thread.message.in_progress" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadMessageInProgress>()) {
                            it.validate()
                        }
                        ?.let {
                            return AssistantStreamEvent(threadMessageInProgress = it, _json = json)
                        }
                }
                "thread.message.delta" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadMessageDelta>()) { it.validate() }
                        ?.let {
                            return AssistantStreamEvent(threadMessageDelta = it, _json = json)
                        }
                }
                "thread.message.completed" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadMessageCompleted>()) { it.validate() }
                        ?.let {
                            return AssistantStreamEvent(threadMessageCompleted = it, _json = json)
                        }
                }
                "thread.message.incomplete" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadMessageIncomplete>()) {
                            it.validate()
                        }
                        ?.let {
                            return AssistantStreamEvent(threadMessageIncomplete = it, _json = json)
                        }
                }
                "error" -> {
                    tryDeserialize(node, jacksonTypeRef<ErrorEvent>()) { it.validate() }
                        ?.let {
                            return AssistantStreamEvent(errorEvent = it, _json = json)
                        }
                }
            }

            return AssistantStreamEvent(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<AssistantStreamEvent>(AssistantStreamEvent::class) {

        override fun serialize(
            value: AssistantStreamEvent,
            generator: JsonGenerator,
            provider: SerializerProvider
        ) {
            when {
                value.threadCreated != null -> generator.writeObject(value.threadCreated)
                value.threadRunCreated != null -> generator.writeObject(value.threadRunCreated)
                value.threadRunQueued != null -> generator.writeObject(value.threadRunQueued)
                value.threadRunInProgress != null ->
                    generator.writeObject(value.threadRunInProgress)
                value.threadRunRequiresAction != null ->
                    generator.writeObject(value.threadRunRequiresAction)
                value.threadRunCompleted != null -> generator.writeObject(value.threadRunCompleted)
                value.threadRunIncomplete != null ->
                    generator.writeObject(value.threadRunIncomplete)
                value.threadRunFailed != null -> generator.writeObject(value.threadRunFailed)
                value.threadRunCancelling != null ->
                    generator.writeObject(value.threadRunCancelling)
                value.threadRunCancelled != null -> generator.writeObject(value.threadRunCancelled)
                value.threadRunExpired != null -> generator.writeObject(value.threadRunExpired)
                value.threadRunStepCreated != null ->
                    generator.writeObject(value.threadRunStepCreated)
                value.threadRunStepInProgress != null ->
                    generator.writeObject(value.threadRunStepInProgress)
                value.threadRunStepDelta != null -> generator.writeObject(value.threadRunStepDelta)
                value.threadRunStepCompleted != null ->
                    generator.writeObject(value.threadRunStepCompleted)
                value.threadRunStepFailed != null ->
                    generator.writeObject(value.threadRunStepFailed)
                value.threadRunStepCancelled != null ->
                    generator.writeObject(value.threadRunStepCancelled)
                value.threadRunStepExpired != null ->
                    generator.writeObject(value.threadRunStepExpired)
                value.threadMessageCreated != null ->
                    generator.writeObject(value.threadMessageCreated)
                value.threadMessageInProgress != null ->
                    generator.writeObject(value.threadMessageInProgress)
                value.threadMessageDelta != null -> generator.writeObject(value.threadMessageDelta)
                value.threadMessageCompleted != null ->
                    generator.writeObject(value.threadMessageCompleted)
                value.threadMessageIncomplete != null ->
                    generator.writeObject(value.threadMessageIncomplete)
                value.errorEvent != null -> generator.writeObject(value.errorEvent)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid AssistantStreamEvent")
            }
        }
    }

    /**
     * Occurs when a new [thread](https://platform.openai.com/docs/api-reference/threads/object) is
     * created.
     */
    @NoAutoDetect
    class ThreadCreated
    @JsonCreator
    private constructor(
        @JsonProperty("data")
        @ExcludeMissing
        private val data: JsonField<Thread> = JsonMissing.of(),
        @JsonProperty("event") @ExcludeMissing private val event: JsonValue = JsonMissing.of(),
        @JsonProperty("enabled")
        @ExcludeMissing
        private val enabled: JsonField<Boolean> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Represents a thread that contains
         * [messages](https://platform.openai.com/docs/api-reference/messages).
         */
        fun data(): Thread = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /** Whether to enable input audio transcription. */
        fun enabled(): Optional<Boolean> = Optional.ofNullable(enabled.getNullable("enabled"))

        /**
         * Represents a thread that contains
         * [messages](https://platform.openai.com/docs/api-reference/messages).
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Thread> = data

        /** Whether to enable input audio transcription. */
        @JsonProperty("enabled") @ExcludeMissing fun _enabled(): JsonField<Boolean> = enabled

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadCreated = apply {
            if (validated) {
                return@apply
            }

            data().validate()
            _event().let {
                if (it != JsonValue.from("thread.created")) {
                    throw OpenAIInvalidDataException("'event' is invalid, received $it")
                }
            }
            enabled()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder internal constructor() {

            private var data: JsonField<Thread>? = null
            private var event: JsonValue = JsonValue.from("thread.created")
            private var enabled: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadCreated: ThreadCreated) = apply {
                data = threadCreated.data
                event = threadCreated.event
                enabled = threadCreated.enabled
                additionalProperties = threadCreated.additionalProperties.toMutableMap()
            }

            /**
             * Represents a thread that contains
             * [messages](https://platform.openai.com/docs/api-reference/messages).
             */
            fun data(data: Thread) = data(JsonField.of(data))

            /**
             * Represents a thread that contains
             * [messages](https://platform.openai.com/docs/api-reference/messages).
             */
            fun data(data: JsonField<Thread>) = apply { this.data = data }

            fun event(event: JsonValue) = apply { this.event = event }

            /** Whether to enable input audio transcription. */
            fun enabled(enabled: Boolean) = enabled(JsonField.of(enabled))

            /** Whether to enable input audio transcription. */
            fun enabled(enabled: JsonField<Boolean>) = apply { this.enabled = enabled }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            fun build(): ThreadCreated =
                ThreadCreated(
                    checkRequired("data", data),
                    event,
                    enabled,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadCreated && data == other.data && event == other.event && enabled == other.enabled && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(data, event, enabled, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadCreated{data=$data, event=$event, enabled=$enabled, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a new [run](https://platform.openai.com/docs/api-reference/runs/object) is
     * created.
     */
    @NoAutoDetect
    class ThreadRunCreated
    @JsonCreator
    private constructor(
        @JsonProperty("data") @ExcludeMissing private val data: JsonField<Run> = JsonMissing.of(),
        @JsonProperty("event") @ExcludeMissing private val event: JsonValue = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Run = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Run> = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunCreated = apply {
            if (validated) {
                return@apply
            }

            data().validate()
            _event().let {
                if (it != JsonValue.from("thread.run.created")) {
                    throw OpenAIInvalidDataException("'event' is invalid, received $it")
                }
            }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder internal constructor() {

            private var data: JsonField<Run>? = null
            private var event: JsonValue = JsonValue.from("thread.run.created")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadRunCreated: ThreadRunCreated) = apply {
                data = threadRunCreated.data
                event = threadRunCreated.event
                additionalProperties = threadRunCreated.additionalProperties.toMutableMap()
            }

            /**
             * Represents an execution run on a
             * [thread](https://platform.openai.com/docs/api-reference/threads).
             */
            fun data(data: Run) = data(JsonField.of(data))

            /**
             * Represents an execution run on a
             * [thread](https://platform.openai.com/docs/api-reference/threads).
             */
            fun data(data: JsonField<Run>) = apply { this.data = data }

            fun event(event: JsonValue) = apply { this.event = event }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            fun build(): ThreadRunCreated =
                ThreadRunCreated(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadRunCreated && data == other.data && event == other.event && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunCreated{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) moves to a
     * `queued` status.
     */
    @NoAutoDetect
    class ThreadRunQueued
    @JsonCreator
    private constructor(
        @JsonProperty("data") @ExcludeMissing private val data: JsonField<Run> = JsonMissing.of(),
        @JsonProperty("event") @ExcludeMissing private val event: JsonValue = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Run = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Run> = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunQueued = apply {
            if (validated) {
                return@apply
            }

            data().validate()
            _event().let {
                if (it != JsonValue.from("thread.run.queued")) {
                    throw OpenAIInvalidDataException("'event' is invalid, received $it")
                }
            }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder internal constructor() {

            private var data: JsonField<Run>? = null
            private var event: JsonValue = JsonValue.from("thread.run.queued")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadRunQueued: ThreadRunQueued) = apply {
                data = threadRunQueued.data
                event = threadRunQueued.event
                additionalProperties = threadRunQueued.additionalProperties.toMutableMap()
            }

            /**
             * Represents an execution run on a
             * [thread](https://platform.openai.com/docs/api-reference/threads).
             */
            fun data(data: Run) = data(JsonField.of(data))

            /**
             * Represents an execution run on a
             * [thread](https://platform.openai.com/docs/api-reference/threads).
             */
            fun data(data: JsonField<Run>) = apply { this.data = data }

            fun event(event: JsonValue) = apply { this.event = event }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            fun build(): ThreadRunQueued =
                ThreadRunQueued(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadRunQueued && data == other.data && event == other.event && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunQueued{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) moves to an
     * `in_progress` status.
     */
    @NoAutoDetect
    class ThreadRunInProgress
    @JsonCreator
    private constructor(
        @JsonProperty("data") @ExcludeMissing private val data: JsonField<Run> = JsonMissing.of(),
        @JsonProperty("event") @ExcludeMissing private val event: JsonValue = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Run = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Run> = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunInProgress = apply {
            if (validated) {
                return@apply
            }

            data().validate()
            _event().let {
                if (it != JsonValue.from("thread.run.in_progress")) {
                    throw OpenAIInvalidDataException("'event' is invalid, received $it")
                }
            }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder internal constructor() {

            private var data: JsonField<Run>? = null
            private var event: JsonValue = JsonValue.from("thread.run.in_progress")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadRunInProgress: ThreadRunInProgress) = apply {
                data = threadRunInProgress.data
                event = threadRunInProgress.event
                additionalProperties = threadRunInProgress.additionalProperties.toMutableMap()
            }

            /**
             * Represents an execution run on a
             * [thread](https://platform.openai.com/docs/api-reference/threads).
             */
            fun data(data: Run) = data(JsonField.of(data))

            /**
             * Represents an execution run on a
             * [thread](https://platform.openai.com/docs/api-reference/threads).
             */
            fun data(data: JsonField<Run>) = apply { this.data = data }

            fun event(event: JsonValue) = apply { this.event = event }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            fun build(): ThreadRunInProgress =
                ThreadRunInProgress(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadRunInProgress && data == other.data && event == other.event && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunInProgress{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) moves to a
     * `requires_action` status.
     */
    @NoAutoDetect
    class ThreadRunRequiresAction
    @JsonCreator
    private constructor(
        @JsonProperty("data") @ExcludeMissing private val data: JsonField<Run> = JsonMissing.of(),
        @JsonProperty("event") @ExcludeMissing private val event: JsonValue = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Run = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Run> = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunRequiresAction = apply {
            if (validated) {
                return@apply
            }

            data().validate()
            _event().let {
                if (it != JsonValue.from("thread.run.requires_action")) {
                    throw OpenAIInvalidDataException("'event' is invalid, received $it")
                }
            }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder internal constructor() {

            private var data: JsonField<Run>? = null
            private var event: JsonValue = JsonValue.from("thread.run.requires_action")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadRunRequiresAction: ThreadRunRequiresAction) = apply {
                data = threadRunRequiresAction.data
                event = threadRunRequiresAction.event
                additionalProperties = threadRunRequiresAction.additionalProperties.toMutableMap()
            }

            /**
             * Represents an execution run on a
             * [thread](https://platform.openai.com/docs/api-reference/threads).
             */
            fun data(data: Run) = data(JsonField.of(data))

            /**
             * Represents an execution run on a
             * [thread](https://platform.openai.com/docs/api-reference/threads).
             */
            fun data(data: JsonField<Run>) = apply { this.data = data }

            fun event(event: JsonValue) = apply { this.event = event }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            fun build(): ThreadRunRequiresAction =
                ThreadRunRequiresAction(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadRunRequiresAction && data == other.data && event == other.event && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunRequiresAction{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) is completed.
     */
    @NoAutoDetect
    class ThreadRunCompleted
    @JsonCreator
    private constructor(
        @JsonProperty("data") @ExcludeMissing private val data: JsonField<Run> = JsonMissing.of(),
        @JsonProperty("event") @ExcludeMissing private val event: JsonValue = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Run = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Run> = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunCompleted = apply {
            if (validated) {
                return@apply
            }

            data().validate()
            _event().let {
                if (it != JsonValue.from("thread.run.completed")) {
                    throw OpenAIInvalidDataException("'event' is invalid, received $it")
                }
            }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder internal constructor() {

            private var data: JsonField<Run>? = null
            private var event: JsonValue = JsonValue.from("thread.run.completed")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadRunCompleted: ThreadRunCompleted) = apply {
                data = threadRunCompleted.data
                event = threadRunCompleted.event
                additionalProperties = threadRunCompleted.additionalProperties.toMutableMap()
            }

            /**
             * Represents an execution run on a
             * [thread](https://platform.openai.com/docs/api-reference/threads).
             */
            fun data(data: Run) = data(JsonField.of(data))

            /**
             * Represents an execution run on a
             * [thread](https://platform.openai.com/docs/api-reference/threads).
             */
            fun data(data: JsonField<Run>) = apply { this.data = data }

            fun event(event: JsonValue) = apply { this.event = event }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            fun build(): ThreadRunCompleted =
                ThreadRunCompleted(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadRunCompleted && data == other.data && event == other.event && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunCompleted{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) ends with
     * status `incomplete`.
     */
    @NoAutoDetect
    class ThreadRunIncomplete
    @JsonCreator
    private constructor(
        @JsonProperty("data") @ExcludeMissing private val data: JsonField<Run> = JsonMissing.of(),
        @JsonProperty("event") @ExcludeMissing private val event: JsonValue = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Run = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Run> = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunIncomplete = apply {
            if (validated) {
                return@apply
            }

            data().validate()
            _event().let {
                if (it != JsonValue.from("thread.run.incomplete")) {
                    throw OpenAIInvalidDataException("'event' is invalid, received $it")
                }
            }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder internal constructor() {

            private var data: JsonField<Run>? = null
            private var event: JsonValue = JsonValue.from("thread.run.incomplete")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadRunIncomplete: ThreadRunIncomplete) = apply {
                data = threadRunIncomplete.data
                event = threadRunIncomplete.event
                additionalProperties = threadRunIncomplete.additionalProperties.toMutableMap()
            }

            /**
             * Represents an execution run on a
             * [thread](https://platform.openai.com/docs/api-reference/threads).
             */
            fun data(data: Run) = data(JsonField.of(data))

            /**
             * Represents an execution run on a
             * [thread](https://platform.openai.com/docs/api-reference/threads).
             */
            fun data(data: JsonField<Run>) = apply { this.data = data }

            fun event(event: JsonValue) = apply { this.event = event }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            fun build(): ThreadRunIncomplete =
                ThreadRunIncomplete(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadRunIncomplete && data == other.data && event == other.event && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunIncomplete{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /** Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) fails. */
    @NoAutoDetect
    class ThreadRunFailed
    @JsonCreator
    private constructor(
        @JsonProperty("data") @ExcludeMissing private val data: JsonField<Run> = JsonMissing.of(),
        @JsonProperty("event") @ExcludeMissing private val event: JsonValue = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Run = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Run> = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunFailed = apply {
            if (validated) {
                return@apply
            }

            data().validate()
            _event().let {
                if (it != JsonValue.from("thread.run.failed")) {
                    throw OpenAIInvalidDataException("'event' is invalid, received $it")
                }
            }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder internal constructor() {

            private var data: JsonField<Run>? = null
            private var event: JsonValue = JsonValue.from("thread.run.failed")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadRunFailed: ThreadRunFailed) = apply {
                data = threadRunFailed.data
                event = threadRunFailed.event
                additionalProperties = threadRunFailed.additionalProperties.toMutableMap()
            }

            /**
             * Represents an execution run on a
             * [thread](https://platform.openai.com/docs/api-reference/threads).
             */
            fun data(data: Run) = data(JsonField.of(data))

            /**
             * Represents an execution run on a
             * [thread](https://platform.openai.com/docs/api-reference/threads).
             */
            fun data(data: JsonField<Run>) = apply { this.data = data }

            fun event(event: JsonValue) = apply { this.event = event }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            fun build(): ThreadRunFailed =
                ThreadRunFailed(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadRunFailed && data == other.data && event == other.event && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunFailed{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) moves to a
     * `cancelling` status.
     */
    @NoAutoDetect
    class ThreadRunCancelling
    @JsonCreator
    private constructor(
        @JsonProperty("data") @ExcludeMissing private val data: JsonField<Run> = JsonMissing.of(),
        @JsonProperty("event") @ExcludeMissing private val event: JsonValue = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Run = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Run> = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunCancelling = apply {
            if (validated) {
                return@apply
            }

            data().validate()
            _event().let {
                if (it != JsonValue.from("thread.run.cancelling")) {
                    throw OpenAIInvalidDataException("'event' is invalid, received $it")
                }
            }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder internal constructor() {

            private var data: JsonField<Run>? = null
            private var event: JsonValue = JsonValue.from("thread.run.cancelling")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadRunCancelling: ThreadRunCancelling) = apply {
                data = threadRunCancelling.data
                event = threadRunCancelling.event
                additionalProperties = threadRunCancelling.additionalProperties.toMutableMap()
            }

            /**
             * Represents an execution run on a
             * [thread](https://platform.openai.com/docs/api-reference/threads).
             */
            fun data(data: Run) = data(JsonField.of(data))

            /**
             * Represents an execution run on a
             * [thread](https://platform.openai.com/docs/api-reference/threads).
             */
            fun data(data: JsonField<Run>) = apply { this.data = data }

            fun event(event: JsonValue) = apply { this.event = event }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            fun build(): ThreadRunCancelling =
                ThreadRunCancelling(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadRunCancelling && data == other.data && event == other.event && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunCancelling{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) is cancelled.
     */
    @NoAutoDetect
    class ThreadRunCancelled
    @JsonCreator
    private constructor(
        @JsonProperty("data") @ExcludeMissing private val data: JsonField<Run> = JsonMissing.of(),
        @JsonProperty("event") @ExcludeMissing private val event: JsonValue = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Run = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Run> = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunCancelled = apply {
            if (validated) {
                return@apply
            }

            data().validate()
            _event().let {
                if (it != JsonValue.from("thread.run.cancelled")) {
                    throw OpenAIInvalidDataException("'event' is invalid, received $it")
                }
            }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder internal constructor() {

            private var data: JsonField<Run>? = null
            private var event: JsonValue = JsonValue.from("thread.run.cancelled")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadRunCancelled: ThreadRunCancelled) = apply {
                data = threadRunCancelled.data
                event = threadRunCancelled.event
                additionalProperties = threadRunCancelled.additionalProperties.toMutableMap()
            }

            /**
             * Represents an execution run on a
             * [thread](https://platform.openai.com/docs/api-reference/threads).
             */
            fun data(data: Run) = data(JsonField.of(data))

            /**
             * Represents an execution run on a
             * [thread](https://platform.openai.com/docs/api-reference/threads).
             */
            fun data(data: JsonField<Run>) = apply { this.data = data }

            fun event(event: JsonValue) = apply { this.event = event }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            fun build(): ThreadRunCancelled =
                ThreadRunCancelled(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadRunCancelled && data == other.data && event == other.event && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunCancelled{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /** Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) expires. */
    @NoAutoDetect
    class ThreadRunExpired
    @JsonCreator
    private constructor(
        @JsonProperty("data") @ExcludeMissing private val data: JsonField<Run> = JsonMissing.of(),
        @JsonProperty("event") @ExcludeMissing private val event: JsonValue = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Run = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Run> = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunExpired = apply {
            if (validated) {
                return@apply
            }

            data().validate()
            _event().let {
                if (it != JsonValue.from("thread.run.expired")) {
                    throw OpenAIInvalidDataException("'event' is invalid, received $it")
                }
            }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder internal constructor() {

            private var data: JsonField<Run>? = null
            private var event: JsonValue = JsonValue.from("thread.run.expired")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadRunExpired: ThreadRunExpired) = apply {
                data = threadRunExpired.data
                event = threadRunExpired.event
                additionalProperties = threadRunExpired.additionalProperties.toMutableMap()
            }

            /**
             * Represents an execution run on a
             * [thread](https://platform.openai.com/docs/api-reference/threads).
             */
            fun data(data: Run) = data(JsonField.of(data))

            /**
             * Represents an execution run on a
             * [thread](https://platform.openai.com/docs/api-reference/threads).
             */
            fun data(data: JsonField<Run>) = apply { this.data = data }

            fun event(event: JsonValue) = apply { this.event = event }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            fun build(): ThreadRunExpired =
                ThreadRunExpired(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadRunExpired && data == other.data && event == other.event && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunExpired{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a
     * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) is created.
     */
    @NoAutoDetect
    class ThreadRunStepCreated
    @JsonCreator
    private constructor(
        @JsonProperty("data")
        @ExcludeMissing
        private val data: JsonField<RunStep> = JsonMissing.of(),
        @JsonProperty("event") @ExcludeMissing private val event: JsonValue = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** Represents a step in execution of a run. */
        fun data(): RunStep = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /** Represents a step in execution of a run. */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<RunStep> = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunStepCreated = apply {
            if (validated) {
                return@apply
            }

            data().validate()
            _event().let {
                if (it != JsonValue.from("thread.run.step.created")) {
                    throw OpenAIInvalidDataException("'event' is invalid, received $it")
                }
            }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder internal constructor() {

            private var data: JsonField<RunStep>? = null
            private var event: JsonValue = JsonValue.from("thread.run.step.created")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadRunStepCreated: ThreadRunStepCreated) = apply {
                data = threadRunStepCreated.data
                event = threadRunStepCreated.event
                additionalProperties = threadRunStepCreated.additionalProperties.toMutableMap()
            }

            /** Represents a step in execution of a run. */
            fun data(data: RunStep) = data(JsonField.of(data))

            /** Represents a step in execution of a run. */
            fun data(data: JsonField<RunStep>) = apply { this.data = data }

            fun event(event: JsonValue) = apply { this.event = event }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            fun build(): ThreadRunStepCreated =
                ThreadRunStepCreated(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadRunStepCreated && data == other.data && event == other.event && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunStepCreated{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a
     * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) moves to an
     * `in_progress` state.
     */
    @NoAutoDetect
    class ThreadRunStepInProgress
    @JsonCreator
    private constructor(
        @JsonProperty("data")
        @ExcludeMissing
        private val data: JsonField<RunStep> = JsonMissing.of(),
        @JsonProperty("event") @ExcludeMissing private val event: JsonValue = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** Represents a step in execution of a run. */
        fun data(): RunStep = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /** Represents a step in execution of a run. */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<RunStep> = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunStepInProgress = apply {
            if (validated) {
                return@apply
            }

            data().validate()
            _event().let {
                if (it != JsonValue.from("thread.run.step.in_progress")) {
                    throw OpenAIInvalidDataException("'event' is invalid, received $it")
                }
            }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder internal constructor() {

            private var data: JsonField<RunStep>? = null
            private var event: JsonValue = JsonValue.from("thread.run.step.in_progress")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadRunStepInProgress: ThreadRunStepInProgress) = apply {
                data = threadRunStepInProgress.data
                event = threadRunStepInProgress.event
                additionalProperties = threadRunStepInProgress.additionalProperties.toMutableMap()
            }

            /** Represents a step in execution of a run. */
            fun data(data: RunStep) = data(JsonField.of(data))

            /** Represents a step in execution of a run. */
            fun data(data: JsonField<RunStep>) = apply { this.data = data }

            fun event(event: JsonValue) = apply { this.event = event }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            fun build(): ThreadRunStepInProgress =
                ThreadRunStepInProgress(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadRunStepInProgress && data == other.data && event == other.event && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunStepInProgress{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when parts of a
     * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) are being
     * streamed.
     */
    @NoAutoDetect
    class ThreadRunStepDelta
    @JsonCreator
    private constructor(
        @JsonProperty("data")
        @ExcludeMissing
        private val data: JsonField<RunStepDeltaEvent> = JsonMissing.of(),
        @JsonProperty("event") @ExcludeMissing private val event: JsonValue = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** Represents a run step delta i.e. any changed fields on a run step during streaming. */
        fun data(): RunStepDeltaEvent = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /** Represents a run step delta i.e. any changed fields on a run step during streaming. */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<RunStepDeltaEvent> = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunStepDelta = apply {
            if (validated) {
                return@apply
            }

            data().validate()
            _event().let {
                if (it != JsonValue.from("thread.run.step.delta")) {
                    throw OpenAIInvalidDataException("'event' is invalid, received $it")
                }
            }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder internal constructor() {

            private var data: JsonField<RunStepDeltaEvent>? = null
            private var event: JsonValue = JsonValue.from("thread.run.step.delta")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadRunStepDelta: ThreadRunStepDelta) = apply {
                data = threadRunStepDelta.data
                event = threadRunStepDelta.event
                additionalProperties = threadRunStepDelta.additionalProperties.toMutableMap()
            }

            /**
             * Represents a run step delta i.e. any changed fields on a run step during streaming.
             */
            fun data(data: RunStepDeltaEvent) = data(JsonField.of(data))

            /**
             * Represents a run step delta i.e. any changed fields on a run step during streaming.
             */
            fun data(data: JsonField<RunStepDeltaEvent>) = apply { this.data = data }

            fun event(event: JsonValue) = apply { this.event = event }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            fun build(): ThreadRunStepDelta =
                ThreadRunStepDelta(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadRunStepDelta && data == other.data && event == other.event && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunStepDelta{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a
     * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) is
     * completed.
     */
    @NoAutoDetect
    class ThreadRunStepCompleted
    @JsonCreator
    private constructor(
        @JsonProperty("data")
        @ExcludeMissing
        private val data: JsonField<RunStep> = JsonMissing.of(),
        @JsonProperty("event") @ExcludeMissing private val event: JsonValue = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** Represents a step in execution of a run. */
        fun data(): RunStep = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /** Represents a step in execution of a run. */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<RunStep> = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunStepCompleted = apply {
            if (validated) {
                return@apply
            }

            data().validate()
            _event().let {
                if (it != JsonValue.from("thread.run.step.completed")) {
                    throw OpenAIInvalidDataException("'event' is invalid, received $it")
                }
            }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder internal constructor() {

            private var data: JsonField<RunStep>? = null
            private var event: JsonValue = JsonValue.from("thread.run.step.completed")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadRunStepCompleted: ThreadRunStepCompleted) = apply {
                data = threadRunStepCompleted.data
                event = threadRunStepCompleted.event
                additionalProperties = threadRunStepCompleted.additionalProperties.toMutableMap()
            }

            /** Represents a step in execution of a run. */
            fun data(data: RunStep) = data(JsonField.of(data))

            /** Represents a step in execution of a run. */
            fun data(data: JsonField<RunStep>) = apply { this.data = data }

            fun event(event: JsonValue) = apply { this.event = event }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            fun build(): ThreadRunStepCompleted =
                ThreadRunStepCompleted(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadRunStepCompleted && data == other.data && event == other.event && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunStepCompleted{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a
     * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) fails.
     */
    @NoAutoDetect
    class ThreadRunStepFailed
    @JsonCreator
    private constructor(
        @JsonProperty("data")
        @ExcludeMissing
        private val data: JsonField<RunStep> = JsonMissing.of(),
        @JsonProperty("event") @ExcludeMissing private val event: JsonValue = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** Represents a step in execution of a run. */
        fun data(): RunStep = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /** Represents a step in execution of a run. */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<RunStep> = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunStepFailed = apply {
            if (validated) {
                return@apply
            }

            data().validate()
            _event().let {
                if (it != JsonValue.from("thread.run.step.failed")) {
                    throw OpenAIInvalidDataException("'event' is invalid, received $it")
                }
            }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder internal constructor() {

            private var data: JsonField<RunStep>? = null
            private var event: JsonValue = JsonValue.from("thread.run.step.failed")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadRunStepFailed: ThreadRunStepFailed) = apply {
                data = threadRunStepFailed.data
                event = threadRunStepFailed.event
                additionalProperties = threadRunStepFailed.additionalProperties.toMutableMap()
            }

            /** Represents a step in execution of a run. */
            fun data(data: RunStep) = data(JsonField.of(data))

            /** Represents a step in execution of a run. */
            fun data(data: JsonField<RunStep>) = apply { this.data = data }

            fun event(event: JsonValue) = apply { this.event = event }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            fun build(): ThreadRunStepFailed =
                ThreadRunStepFailed(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadRunStepFailed && data == other.data && event == other.event && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunStepFailed{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a
     * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) is
     * cancelled.
     */
    @NoAutoDetect
    class ThreadRunStepCancelled
    @JsonCreator
    private constructor(
        @JsonProperty("data")
        @ExcludeMissing
        private val data: JsonField<RunStep> = JsonMissing.of(),
        @JsonProperty("event") @ExcludeMissing private val event: JsonValue = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** Represents a step in execution of a run. */
        fun data(): RunStep = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /** Represents a step in execution of a run. */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<RunStep> = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunStepCancelled = apply {
            if (validated) {
                return@apply
            }

            data().validate()
            _event().let {
                if (it != JsonValue.from("thread.run.step.cancelled")) {
                    throw OpenAIInvalidDataException("'event' is invalid, received $it")
                }
            }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder internal constructor() {

            private var data: JsonField<RunStep>? = null
            private var event: JsonValue = JsonValue.from("thread.run.step.cancelled")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadRunStepCancelled: ThreadRunStepCancelled) = apply {
                data = threadRunStepCancelled.data
                event = threadRunStepCancelled.event
                additionalProperties = threadRunStepCancelled.additionalProperties.toMutableMap()
            }

            /** Represents a step in execution of a run. */
            fun data(data: RunStep) = data(JsonField.of(data))

            /** Represents a step in execution of a run. */
            fun data(data: JsonField<RunStep>) = apply { this.data = data }

            fun event(event: JsonValue) = apply { this.event = event }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            fun build(): ThreadRunStepCancelled =
                ThreadRunStepCancelled(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadRunStepCancelled && data == other.data && event == other.event && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunStepCancelled{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a
     * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) expires.
     */
    @NoAutoDetect
    class ThreadRunStepExpired
    @JsonCreator
    private constructor(
        @JsonProperty("data")
        @ExcludeMissing
        private val data: JsonField<RunStep> = JsonMissing.of(),
        @JsonProperty("event") @ExcludeMissing private val event: JsonValue = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** Represents a step in execution of a run. */
        fun data(): RunStep = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /** Represents a step in execution of a run. */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<RunStep> = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunStepExpired = apply {
            if (validated) {
                return@apply
            }

            data().validate()
            _event().let {
                if (it != JsonValue.from("thread.run.step.expired")) {
                    throw OpenAIInvalidDataException("'event' is invalid, received $it")
                }
            }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder internal constructor() {

            private var data: JsonField<RunStep>? = null
            private var event: JsonValue = JsonValue.from("thread.run.step.expired")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadRunStepExpired: ThreadRunStepExpired) = apply {
                data = threadRunStepExpired.data
                event = threadRunStepExpired.event
                additionalProperties = threadRunStepExpired.additionalProperties.toMutableMap()
            }

            /** Represents a step in execution of a run. */
            fun data(data: RunStep) = data(JsonField.of(data))

            /** Represents a step in execution of a run. */
            fun data(data: JsonField<RunStep>) = apply { this.data = data }

            fun event(event: JsonValue) = apply { this.event = event }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            fun build(): ThreadRunStepExpired =
                ThreadRunStepExpired(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadRunStepExpired && data == other.data && event == other.event && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunStepExpired{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a [message](https://platform.openai.com/docs/api-reference/messages/object) is
     * created.
     */
    @NoAutoDetect
    class ThreadMessageCreated
    @JsonCreator
    private constructor(
        @JsonProperty("data")
        @ExcludeMissing
        private val data: JsonField<Message> = JsonMissing.of(),
        @JsonProperty("event") @ExcludeMissing private val event: JsonValue = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Represents a message within a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Message = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Represents a message within a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Message> = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadMessageCreated = apply {
            if (validated) {
                return@apply
            }

            data().validate()
            _event().let {
                if (it != JsonValue.from("thread.message.created")) {
                    throw OpenAIInvalidDataException("'event' is invalid, received $it")
                }
            }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder internal constructor() {

            private var data: JsonField<Message>? = null
            private var event: JsonValue = JsonValue.from("thread.message.created")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadMessageCreated: ThreadMessageCreated) = apply {
                data = threadMessageCreated.data
                event = threadMessageCreated.event
                additionalProperties = threadMessageCreated.additionalProperties.toMutableMap()
            }

            /**
             * Represents a message within a
             * [thread](https://platform.openai.com/docs/api-reference/threads).
             */
            fun data(data: Message) = data(JsonField.of(data))

            /**
             * Represents a message within a
             * [thread](https://platform.openai.com/docs/api-reference/threads).
             */
            fun data(data: JsonField<Message>) = apply { this.data = data }

            fun event(event: JsonValue) = apply { this.event = event }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            fun build(): ThreadMessageCreated =
                ThreadMessageCreated(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadMessageCreated && data == other.data && event == other.event && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadMessageCreated{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a [message](https://platform.openai.com/docs/api-reference/messages/object) moves
     * to an `in_progress` state.
     */
    @NoAutoDetect
    class ThreadMessageInProgress
    @JsonCreator
    private constructor(
        @JsonProperty("data")
        @ExcludeMissing
        private val data: JsonField<Message> = JsonMissing.of(),
        @JsonProperty("event") @ExcludeMissing private val event: JsonValue = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Represents a message within a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Message = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Represents a message within a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Message> = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadMessageInProgress = apply {
            if (validated) {
                return@apply
            }

            data().validate()
            _event().let {
                if (it != JsonValue.from("thread.message.in_progress")) {
                    throw OpenAIInvalidDataException("'event' is invalid, received $it")
                }
            }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder internal constructor() {

            private var data: JsonField<Message>? = null
            private var event: JsonValue = JsonValue.from("thread.message.in_progress")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadMessageInProgress: ThreadMessageInProgress) = apply {
                data = threadMessageInProgress.data
                event = threadMessageInProgress.event
                additionalProperties = threadMessageInProgress.additionalProperties.toMutableMap()
            }

            /**
             * Represents a message within a
             * [thread](https://platform.openai.com/docs/api-reference/threads).
             */
            fun data(data: Message) = data(JsonField.of(data))

            /**
             * Represents a message within a
             * [thread](https://platform.openai.com/docs/api-reference/threads).
             */
            fun data(data: JsonField<Message>) = apply { this.data = data }

            fun event(event: JsonValue) = apply { this.event = event }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            fun build(): ThreadMessageInProgress =
                ThreadMessageInProgress(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadMessageInProgress && data == other.data && event == other.event && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadMessageInProgress{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when parts of a
     * [Message](https://platform.openai.com/docs/api-reference/messages/object) are being streamed.
     */
    @NoAutoDetect
    class ThreadMessageDelta
    @JsonCreator
    private constructor(
        @JsonProperty("data")
        @ExcludeMissing
        private val data: JsonField<MessageDeltaEvent> = JsonMissing.of(),
        @JsonProperty("event") @ExcludeMissing private val event: JsonValue = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** Represents a message delta i.e. any changed fields on a message during streaming. */
        fun data(): MessageDeltaEvent = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /** Represents a message delta i.e. any changed fields on a message during streaming. */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<MessageDeltaEvent> = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadMessageDelta = apply {
            if (validated) {
                return@apply
            }

            data().validate()
            _event().let {
                if (it != JsonValue.from("thread.message.delta")) {
                    throw OpenAIInvalidDataException("'event' is invalid, received $it")
                }
            }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder internal constructor() {

            private var data: JsonField<MessageDeltaEvent>? = null
            private var event: JsonValue = JsonValue.from("thread.message.delta")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadMessageDelta: ThreadMessageDelta) = apply {
                data = threadMessageDelta.data
                event = threadMessageDelta.event
                additionalProperties = threadMessageDelta.additionalProperties.toMutableMap()
            }

            /** Represents a message delta i.e. any changed fields on a message during streaming. */
            fun data(data: MessageDeltaEvent) = data(JsonField.of(data))

            /** Represents a message delta i.e. any changed fields on a message during streaming. */
            fun data(data: JsonField<MessageDeltaEvent>) = apply { this.data = data }

            fun event(event: JsonValue) = apply { this.event = event }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            fun build(): ThreadMessageDelta =
                ThreadMessageDelta(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadMessageDelta && data == other.data && event == other.event && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadMessageDelta{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a [message](https://platform.openai.com/docs/api-reference/messages/object) is
     * completed.
     */
    @NoAutoDetect
    class ThreadMessageCompleted
    @JsonCreator
    private constructor(
        @JsonProperty("data")
        @ExcludeMissing
        private val data: JsonField<Message> = JsonMissing.of(),
        @JsonProperty("event") @ExcludeMissing private val event: JsonValue = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Represents a message within a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Message = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Represents a message within a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Message> = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadMessageCompleted = apply {
            if (validated) {
                return@apply
            }

            data().validate()
            _event().let {
                if (it != JsonValue.from("thread.message.completed")) {
                    throw OpenAIInvalidDataException("'event' is invalid, received $it")
                }
            }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder internal constructor() {

            private var data: JsonField<Message>? = null
            private var event: JsonValue = JsonValue.from("thread.message.completed")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadMessageCompleted: ThreadMessageCompleted) = apply {
                data = threadMessageCompleted.data
                event = threadMessageCompleted.event
                additionalProperties = threadMessageCompleted.additionalProperties.toMutableMap()
            }

            /**
             * Represents a message within a
             * [thread](https://platform.openai.com/docs/api-reference/threads).
             */
            fun data(data: Message) = data(JsonField.of(data))

            /**
             * Represents a message within a
             * [thread](https://platform.openai.com/docs/api-reference/threads).
             */
            fun data(data: JsonField<Message>) = apply { this.data = data }

            fun event(event: JsonValue) = apply { this.event = event }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            fun build(): ThreadMessageCompleted =
                ThreadMessageCompleted(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadMessageCompleted && data == other.data && event == other.event && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadMessageCompleted{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a [message](https://platform.openai.com/docs/api-reference/messages/object) ends
     * before it is completed.
     */
    @NoAutoDetect
    class ThreadMessageIncomplete
    @JsonCreator
    private constructor(
        @JsonProperty("data")
        @ExcludeMissing
        private val data: JsonField<Message> = JsonMissing.of(),
        @JsonProperty("event") @ExcludeMissing private val event: JsonValue = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Represents a message within a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Message = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Represents a message within a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Message> = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadMessageIncomplete = apply {
            if (validated) {
                return@apply
            }

            data().validate()
            _event().let {
                if (it != JsonValue.from("thread.message.incomplete")) {
                    throw OpenAIInvalidDataException("'event' is invalid, received $it")
                }
            }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder internal constructor() {

            private var data: JsonField<Message>? = null
            private var event: JsonValue = JsonValue.from("thread.message.incomplete")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadMessageIncomplete: ThreadMessageIncomplete) = apply {
                data = threadMessageIncomplete.data
                event = threadMessageIncomplete.event
                additionalProperties = threadMessageIncomplete.additionalProperties.toMutableMap()
            }

            /**
             * Represents a message within a
             * [thread](https://platform.openai.com/docs/api-reference/threads).
             */
            fun data(data: Message) = data(JsonField.of(data))

            /**
             * Represents a message within a
             * [thread](https://platform.openai.com/docs/api-reference/threads).
             */
            fun data(data: JsonField<Message>) = apply { this.data = data }

            fun event(event: JsonValue) = apply { this.event = event }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            fun build(): ThreadMessageIncomplete =
                ThreadMessageIncomplete(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadMessageIncomplete && data == other.data && event == other.event && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadMessageIncomplete{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when an [error](https://platform.openai.com/docs/guides/error-codes#api-errors)
     * occurs. This can happen due to an internal server error or a timeout.
     */
    @NoAutoDetect
    class ErrorEvent
    @JsonCreator
    private constructor(
        @JsonProperty("data")
        @ExcludeMissing
        private val data: JsonField<ErrorObject> = JsonMissing.of(),
        @JsonProperty("event") @ExcludeMissing private val event: JsonValue = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun data(): ErrorObject = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<ErrorObject> = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ErrorEvent = apply {
            if (validated) {
                return@apply
            }

            data().validate()
            _event().let {
                if (it != JsonValue.from("error")) {
                    throw OpenAIInvalidDataException("'event' is invalid, received $it")
                }
            }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder internal constructor() {

            private var data: JsonField<ErrorObject>? = null
            private var event: JsonValue = JsonValue.from("error")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(errorEvent: ErrorEvent) = apply {
                data = errorEvent.data
                event = errorEvent.event
                additionalProperties = errorEvent.additionalProperties.toMutableMap()
            }

            fun data(data: ErrorObject) = data(JsonField.of(data))

            fun data(data: JsonField<ErrorObject>) = apply { this.data = data }

            fun event(event: JsonValue) = apply { this.event = event }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            fun build(): ErrorEvent =
                ErrorEvent(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ErrorEvent && data == other.data && event == other.event && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ErrorEvent{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }
}
