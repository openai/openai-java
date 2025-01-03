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
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
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

    private var validated: Boolean = false

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

    fun validate(): AssistantStreamEvent = apply {
        if (!validated) {
            if (
                threadCreated == null &&
                    threadRunCreated == null &&
                    threadRunQueued == null &&
                    threadRunInProgress == null &&
                    threadRunRequiresAction == null &&
                    threadRunCompleted == null &&
                    threadRunIncomplete == null &&
                    threadRunFailed == null &&
                    threadRunCancelling == null &&
                    threadRunCancelled == null &&
                    threadRunExpired == null &&
                    threadRunStepCreated == null &&
                    threadRunStepInProgress == null &&
                    threadRunStepDelta == null &&
                    threadRunStepCompleted == null &&
                    threadRunStepFailed == null &&
                    threadRunStepCancelled == null &&
                    threadRunStepExpired == null &&
                    threadMessageCreated == null &&
                    threadMessageInProgress == null &&
                    threadMessageDelta == null &&
                    threadMessageCompleted == null &&
                    threadMessageIncomplete == null &&
                    errorEvent == null
            ) {
                throw OpenAIInvalidDataException("Unknown AssistantStreamEvent: $_json")
            }
            threadCreated?.validate()
            threadRunCreated?.validate()
            threadRunQueued?.validate()
            threadRunInProgress?.validate()
            threadRunRequiresAction?.validate()
            threadRunCompleted?.validate()
            threadRunIncomplete?.validate()
            threadRunFailed?.validate()
            threadRunCancelling?.validate()
            threadRunCancelled?.validate()
            threadRunExpired?.validate()
            threadRunStepCreated?.validate()
            threadRunStepInProgress?.validate()
            threadRunStepDelta?.validate()
            threadRunStepCompleted?.validate()
            threadRunStepFailed?.validate()
            threadRunStepCancelled?.validate()
            threadRunStepExpired?.validate()
            threadMessageCreated?.validate()
            threadMessageInProgress?.validate()
            threadMessageDelta?.validate()
            threadMessageCompleted?.validate()
            threadMessageIncomplete?.validate()
            errorEvent?.validate()
            validated = true
        }
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

        fun visitThreadCreated(threadCreated: ThreadCreated): T

        fun visitThreadRunCreated(threadRunCreated: ThreadRunCreated): T

        fun visitThreadRunQueued(threadRunQueued: ThreadRunQueued): T

        fun visitThreadRunInProgress(threadRunInProgress: ThreadRunInProgress): T

        fun visitThreadRunRequiresAction(threadRunRequiresAction: ThreadRunRequiresAction): T

        fun visitThreadRunCompleted(threadRunCompleted: ThreadRunCompleted): T

        fun visitThreadRunIncomplete(threadRunIncomplete: ThreadRunIncomplete): T

        fun visitThreadRunFailed(threadRunFailed: ThreadRunFailed): T

        fun visitThreadRunCancelling(threadRunCancelling: ThreadRunCancelling): T

        fun visitThreadRunCancelled(threadRunCancelled: ThreadRunCancelled): T

        fun visitThreadRunExpired(threadRunExpired: ThreadRunExpired): T

        fun visitThreadRunStepCreated(threadRunStepCreated: ThreadRunStepCreated): T

        fun visitThreadRunStepInProgress(threadRunStepInProgress: ThreadRunStepInProgress): T

        fun visitThreadRunStepDelta(threadRunStepDelta: ThreadRunStepDelta): T

        fun visitThreadRunStepCompleted(threadRunStepCompleted: ThreadRunStepCompleted): T

        fun visitThreadRunStepFailed(threadRunStepFailed: ThreadRunStepFailed): T

        fun visitThreadRunStepCancelled(threadRunStepCancelled: ThreadRunStepCancelled): T

        fun visitThreadRunStepExpired(threadRunStepExpired: ThreadRunStepExpired): T

        fun visitThreadMessageCreated(threadMessageCreated: ThreadMessageCreated): T

        fun visitThreadMessageInProgress(threadMessageInProgress: ThreadMessageInProgress): T

        fun visitThreadMessageDelta(threadMessageDelta: ThreadMessageDelta): T

        fun visitThreadMessageCompleted(threadMessageCompleted: ThreadMessageCompleted): T

        fun visitThreadMessageIncomplete(threadMessageIncomplete: ThreadMessageIncomplete): T

        fun visitErrorEvent(errorEvent: ErrorEvent): T

        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown AssistantStreamEvent: $json")
        }
    }

    class Deserializer : BaseDeserializer<AssistantStreamEvent>(AssistantStreamEvent::class) {

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

    class Serializer : BaseSerializer<AssistantStreamEvent>(AssistantStreamEvent::class) {

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
        @JsonProperty("enabled")
        @ExcludeMissing
        private val enabled: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("event")
        @ExcludeMissing
        private val event: JsonField<Event> = JsonMissing.of(),
        @JsonProperty("data")
        @ExcludeMissing
        private val data: JsonField<Thread> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** Whether to enable input audio transcription. */
        fun enabled(): Optional<Boolean> = Optional.ofNullable(enabled.getNullable("enabled"))

        fun event(): Event = event.getRequired("event")

        /**
         * Represents a thread that contains
         * [messages](https://platform.openai.com/docs/api-reference/messages).
         */
        fun data(): Thread = data.getRequired("data")

        /** Whether to enable input audio transcription. */
        @JsonProperty("enabled") @ExcludeMissing fun _enabled() = enabled

        @JsonProperty("event") @ExcludeMissing fun _event() = event

        /**
         * Represents a thread that contains
         * [messages](https://platform.openai.com/docs/api-reference/messages).
         */
        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadCreated = apply {
            if (!validated) {
                enabled()
                event()
                data().validate()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var enabled: JsonField<Boolean> = JsonMissing.of()
            private var event: JsonField<Event> = JsonMissing.of()
            private var data: JsonField<Thread> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadCreated: ThreadCreated) = apply {
                enabled = threadCreated.enabled
                event = threadCreated.event
                data = threadCreated.data
                additionalProperties = threadCreated.additionalProperties.toMutableMap()
            }

            /** Whether to enable input audio transcription. */
            fun enabled(enabled: Boolean) = enabled(JsonField.of(enabled))

            /** Whether to enable input audio transcription. */
            fun enabled(enabled: JsonField<Boolean>) = apply { this.enabled = enabled }

            fun event(event: Event) = event(JsonField.of(event))

            fun event(event: JsonField<Event>) = apply { this.event = event }

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
                    enabled,
                    event,
                    data,
                    additionalProperties.toImmutable(),
                )
        }

        class Event
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val THREAD_CREATED = of("thread.created")

                @JvmStatic fun of(value: String) = Event(JsonField.of(value))
            }

            enum class Known {
                THREAD_CREATED,
            }

            enum class Value {
                THREAD_CREATED,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    THREAD_CREATED -> Value.THREAD_CREATED
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    THREAD_CREATED -> Known.THREAD_CREATED
                    else -> throw OpenAIInvalidDataException("Unknown Event: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Event && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadCreated && enabled == other.enabled && event == other.event && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(enabled, event, data, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadCreated{enabled=$enabled, event=$event, data=$data, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a new [run](https://platform.openai.com/docs/api-reference/runs/object) is
     * created.
     */
    @NoAutoDetect
    class ThreadRunCreated
    @JsonCreator
    private constructor(
        @JsonProperty("event")
        @ExcludeMissing
        private val event: JsonField<Event> = JsonMissing.of(),
        @JsonProperty("data") @ExcludeMissing private val data: JsonField<Run> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun event(): Event = event.getRequired("event")

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Run = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event() = event

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunCreated = apply {
            if (!validated) {
                event()
                data().validate()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var event: JsonField<Event> = JsonMissing.of()
            private var data: JsonField<Run> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadRunCreated: ThreadRunCreated) = apply {
                event = threadRunCreated.event
                data = threadRunCreated.data
                additionalProperties = threadRunCreated.additionalProperties.toMutableMap()
            }

            fun event(event: Event) = event(JsonField.of(event))

            fun event(event: JsonField<Event>) = apply { this.event = event }

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
                    event,
                    data,
                    additionalProperties.toImmutable(),
                )
        }

        class Event
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val THREAD_RUN_CREATED = of("thread.run.created")

                @JvmStatic fun of(value: String) = Event(JsonField.of(value))
            }

            enum class Known {
                THREAD_RUN_CREATED,
            }

            enum class Value {
                THREAD_RUN_CREATED,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    THREAD_RUN_CREATED -> Value.THREAD_RUN_CREATED
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    THREAD_RUN_CREATED -> Known.THREAD_RUN_CREATED
                    else -> throw OpenAIInvalidDataException("Unknown Event: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Event && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadRunCreated && event == other.event && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(event, data, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunCreated{event=$event, data=$data, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) moves to a
     * `queued` status.
     */
    @NoAutoDetect
    class ThreadRunQueued
    @JsonCreator
    private constructor(
        @JsonProperty("event")
        @ExcludeMissing
        private val event: JsonField<Event> = JsonMissing.of(),
        @JsonProperty("data") @ExcludeMissing private val data: JsonField<Run> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun event(): Event = event.getRequired("event")

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Run = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event() = event

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunQueued = apply {
            if (!validated) {
                event()
                data().validate()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var event: JsonField<Event> = JsonMissing.of()
            private var data: JsonField<Run> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadRunQueued: ThreadRunQueued) = apply {
                event = threadRunQueued.event
                data = threadRunQueued.data
                additionalProperties = threadRunQueued.additionalProperties.toMutableMap()
            }

            fun event(event: Event) = event(JsonField.of(event))

            fun event(event: JsonField<Event>) = apply { this.event = event }

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
                    event,
                    data,
                    additionalProperties.toImmutable(),
                )
        }

        class Event
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val THREAD_RUN_QUEUED = of("thread.run.queued")

                @JvmStatic fun of(value: String) = Event(JsonField.of(value))
            }

            enum class Known {
                THREAD_RUN_QUEUED,
            }

            enum class Value {
                THREAD_RUN_QUEUED,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    THREAD_RUN_QUEUED -> Value.THREAD_RUN_QUEUED
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    THREAD_RUN_QUEUED -> Known.THREAD_RUN_QUEUED
                    else -> throw OpenAIInvalidDataException("Unknown Event: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Event && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadRunQueued && event == other.event && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(event, data, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunQueued{event=$event, data=$data, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) moves to an
     * `in_progress` status.
     */
    @NoAutoDetect
    class ThreadRunInProgress
    @JsonCreator
    private constructor(
        @JsonProperty("event")
        @ExcludeMissing
        private val event: JsonField<Event> = JsonMissing.of(),
        @JsonProperty("data") @ExcludeMissing private val data: JsonField<Run> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun event(): Event = event.getRequired("event")

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Run = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event() = event

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunInProgress = apply {
            if (!validated) {
                event()
                data().validate()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var event: JsonField<Event> = JsonMissing.of()
            private var data: JsonField<Run> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadRunInProgress: ThreadRunInProgress) = apply {
                event = threadRunInProgress.event
                data = threadRunInProgress.data
                additionalProperties = threadRunInProgress.additionalProperties.toMutableMap()
            }

            fun event(event: Event) = event(JsonField.of(event))

            fun event(event: JsonField<Event>) = apply { this.event = event }

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
                    event,
                    data,
                    additionalProperties.toImmutable(),
                )
        }

        class Event
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val THREAD_RUN_IN_PROGRESS = of("thread.run.in_progress")

                @JvmStatic fun of(value: String) = Event(JsonField.of(value))
            }

            enum class Known {
                THREAD_RUN_IN_PROGRESS,
            }

            enum class Value {
                THREAD_RUN_IN_PROGRESS,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    THREAD_RUN_IN_PROGRESS -> Value.THREAD_RUN_IN_PROGRESS
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    THREAD_RUN_IN_PROGRESS -> Known.THREAD_RUN_IN_PROGRESS
                    else -> throw OpenAIInvalidDataException("Unknown Event: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Event && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadRunInProgress && event == other.event && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(event, data, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunInProgress{event=$event, data=$data, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) moves to a
     * `requires_action` status.
     */
    @NoAutoDetect
    class ThreadRunRequiresAction
    @JsonCreator
    private constructor(
        @JsonProperty("event")
        @ExcludeMissing
        private val event: JsonField<Event> = JsonMissing.of(),
        @JsonProperty("data") @ExcludeMissing private val data: JsonField<Run> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun event(): Event = event.getRequired("event")

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Run = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event() = event

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunRequiresAction = apply {
            if (!validated) {
                event()
                data().validate()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var event: JsonField<Event> = JsonMissing.of()
            private var data: JsonField<Run> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadRunRequiresAction: ThreadRunRequiresAction) = apply {
                event = threadRunRequiresAction.event
                data = threadRunRequiresAction.data
                additionalProperties = threadRunRequiresAction.additionalProperties.toMutableMap()
            }

            fun event(event: Event) = event(JsonField.of(event))

            fun event(event: JsonField<Event>) = apply { this.event = event }

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
                    event,
                    data,
                    additionalProperties.toImmutable(),
                )
        }

        class Event
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val THREAD_RUN_REQUIRES_ACTION = of("thread.run.requires_action")

                @JvmStatic fun of(value: String) = Event(JsonField.of(value))
            }

            enum class Known {
                THREAD_RUN_REQUIRES_ACTION,
            }

            enum class Value {
                THREAD_RUN_REQUIRES_ACTION,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    THREAD_RUN_REQUIRES_ACTION -> Value.THREAD_RUN_REQUIRES_ACTION
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    THREAD_RUN_REQUIRES_ACTION -> Known.THREAD_RUN_REQUIRES_ACTION
                    else -> throw OpenAIInvalidDataException("Unknown Event: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Event && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadRunRequiresAction && event == other.event && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(event, data, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunRequiresAction{event=$event, data=$data, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) is completed.
     */
    @NoAutoDetect
    class ThreadRunCompleted
    @JsonCreator
    private constructor(
        @JsonProperty("event")
        @ExcludeMissing
        private val event: JsonField<Event> = JsonMissing.of(),
        @JsonProperty("data") @ExcludeMissing private val data: JsonField<Run> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun event(): Event = event.getRequired("event")

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Run = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event() = event

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunCompleted = apply {
            if (!validated) {
                event()
                data().validate()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var event: JsonField<Event> = JsonMissing.of()
            private var data: JsonField<Run> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadRunCompleted: ThreadRunCompleted) = apply {
                event = threadRunCompleted.event
                data = threadRunCompleted.data
                additionalProperties = threadRunCompleted.additionalProperties.toMutableMap()
            }

            fun event(event: Event) = event(JsonField.of(event))

            fun event(event: JsonField<Event>) = apply { this.event = event }

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
                    event,
                    data,
                    additionalProperties.toImmutable(),
                )
        }

        class Event
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val THREAD_RUN_COMPLETED = of("thread.run.completed")

                @JvmStatic fun of(value: String) = Event(JsonField.of(value))
            }

            enum class Known {
                THREAD_RUN_COMPLETED,
            }

            enum class Value {
                THREAD_RUN_COMPLETED,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    THREAD_RUN_COMPLETED -> Value.THREAD_RUN_COMPLETED
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    THREAD_RUN_COMPLETED -> Known.THREAD_RUN_COMPLETED
                    else -> throw OpenAIInvalidDataException("Unknown Event: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Event && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadRunCompleted && event == other.event && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(event, data, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunCompleted{event=$event, data=$data, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) ends with
     * status `incomplete`.
     */
    @NoAutoDetect
    class ThreadRunIncomplete
    @JsonCreator
    private constructor(
        @JsonProperty("event")
        @ExcludeMissing
        private val event: JsonField<Event> = JsonMissing.of(),
        @JsonProperty("data") @ExcludeMissing private val data: JsonField<Run> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun event(): Event = event.getRequired("event")

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Run = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event() = event

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunIncomplete = apply {
            if (!validated) {
                event()
                data().validate()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var event: JsonField<Event> = JsonMissing.of()
            private var data: JsonField<Run> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadRunIncomplete: ThreadRunIncomplete) = apply {
                event = threadRunIncomplete.event
                data = threadRunIncomplete.data
                additionalProperties = threadRunIncomplete.additionalProperties.toMutableMap()
            }

            fun event(event: Event) = event(JsonField.of(event))

            fun event(event: JsonField<Event>) = apply { this.event = event }

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
                    event,
                    data,
                    additionalProperties.toImmutable(),
                )
        }

        class Event
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val THREAD_RUN_INCOMPLETE = of("thread.run.incomplete")

                @JvmStatic fun of(value: String) = Event(JsonField.of(value))
            }

            enum class Known {
                THREAD_RUN_INCOMPLETE,
            }

            enum class Value {
                THREAD_RUN_INCOMPLETE,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    THREAD_RUN_INCOMPLETE -> Value.THREAD_RUN_INCOMPLETE
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    THREAD_RUN_INCOMPLETE -> Known.THREAD_RUN_INCOMPLETE
                    else -> throw OpenAIInvalidDataException("Unknown Event: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Event && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadRunIncomplete && event == other.event && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(event, data, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunIncomplete{event=$event, data=$data, additionalProperties=$additionalProperties}"
    }

    /** Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) fails. */
    @NoAutoDetect
    class ThreadRunFailed
    @JsonCreator
    private constructor(
        @JsonProperty("event")
        @ExcludeMissing
        private val event: JsonField<Event> = JsonMissing.of(),
        @JsonProperty("data") @ExcludeMissing private val data: JsonField<Run> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun event(): Event = event.getRequired("event")

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Run = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event() = event

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunFailed = apply {
            if (!validated) {
                event()
                data().validate()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var event: JsonField<Event> = JsonMissing.of()
            private var data: JsonField<Run> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadRunFailed: ThreadRunFailed) = apply {
                event = threadRunFailed.event
                data = threadRunFailed.data
                additionalProperties = threadRunFailed.additionalProperties.toMutableMap()
            }

            fun event(event: Event) = event(JsonField.of(event))

            fun event(event: JsonField<Event>) = apply { this.event = event }

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
                    event,
                    data,
                    additionalProperties.toImmutable(),
                )
        }

        class Event
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val THREAD_RUN_FAILED = of("thread.run.failed")

                @JvmStatic fun of(value: String) = Event(JsonField.of(value))
            }

            enum class Known {
                THREAD_RUN_FAILED,
            }

            enum class Value {
                THREAD_RUN_FAILED,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    THREAD_RUN_FAILED -> Value.THREAD_RUN_FAILED
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    THREAD_RUN_FAILED -> Known.THREAD_RUN_FAILED
                    else -> throw OpenAIInvalidDataException("Unknown Event: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Event && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadRunFailed && event == other.event && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(event, data, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunFailed{event=$event, data=$data, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) moves to a
     * `cancelling` status.
     */
    @NoAutoDetect
    class ThreadRunCancelling
    @JsonCreator
    private constructor(
        @JsonProperty("event")
        @ExcludeMissing
        private val event: JsonField<Event> = JsonMissing.of(),
        @JsonProperty("data") @ExcludeMissing private val data: JsonField<Run> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun event(): Event = event.getRequired("event")

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Run = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event() = event

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunCancelling = apply {
            if (!validated) {
                event()
                data().validate()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var event: JsonField<Event> = JsonMissing.of()
            private var data: JsonField<Run> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadRunCancelling: ThreadRunCancelling) = apply {
                event = threadRunCancelling.event
                data = threadRunCancelling.data
                additionalProperties = threadRunCancelling.additionalProperties.toMutableMap()
            }

            fun event(event: Event) = event(JsonField.of(event))

            fun event(event: JsonField<Event>) = apply { this.event = event }

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
                    event,
                    data,
                    additionalProperties.toImmutable(),
                )
        }

        class Event
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val THREAD_RUN_CANCELLING = of("thread.run.cancelling")

                @JvmStatic fun of(value: String) = Event(JsonField.of(value))
            }

            enum class Known {
                THREAD_RUN_CANCELLING,
            }

            enum class Value {
                THREAD_RUN_CANCELLING,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    THREAD_RUN_CANCELLING -> Value.THREAD_RUN_CANCELLING
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    THREAD_RUN_CANCELLING -> Known.THREAD_RUN_CANCELLING
                    else -> throw OpenAIInvalidDataException("Unknown Event: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Event && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadRunCancelling && event == other.event && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(event, data, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunCancelling{event=$event, data=$data, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) is cancelled.
     */
    @NoAutoDetect
    class ThreadRunCancelled
    @JsonCreator
    private constructor(
        @JsonProperty("event")
        @ExcludeMissing
        private val event: JsonField<Event> = JsonMissing.of(),
        @JsonProperty("data") @ExcludeMissing private val data: JsonField<Run> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun event(): Event = event.getRequired("event")

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Run = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event() = event

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunCancelled = apply {
            if (!validated) {
                event()
                data().validate()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var event: JsonField<Event> = JsonMissing.of()
            private var data: JsonField<Run> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadRunCancelled: ThreadRunCancelled) = apply {
                event = threadRunCancelled.event
                data = threadRunCancelled.data
                additionalProperties = threadRunCancelled.additionalProperties.toMutableMap()
            }

            fun event(event: Event) = event(JsonField.of(event))

            fun event(event: JsonField<Event>) = apply { this.event = event }

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
                    event,
                    data,
                    additionalProperties.toImmutable(),
                )
        }

        class Event
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val THREAD_RUN_CANCELLED = of("thread.run.cancelled")

                @JvmStatic fun of(value: String) = Event(JsonField.of(value))
            }

            enum class Known {
                THREAD_RUN_CANCELLED,
            }

            enum class Value {
                THREAD_RUN_CANCELLED,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    THREAD_RUN_CANCELLED -> Value.THREAD_RUN_CANCELLED
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    THREAD_RUN_CANCELLED -> Known.THREAD_RUN_CANCELLED
                    else -> throw OpenAIInvalidDataException("Unknown Event: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Event && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadRunCancelled && event == other.event && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(event, data, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunCancelled{event=$event, data=$data, additionalProperties=$additionalProperties}"
    }

    /** Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) expires. */
    @NoAutoDetect
    class ThreadRunExpired
    @JsonCreator
    private constructor(
        @JsonProperty("event")
        @ExcludeMissing
        private val event: JsonField<Event> = JsonMissing.of(),
        @JsonProperty("data") @ExcludeMissing private val data: JsonField<Run> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun event(): Event = event.getRequired("event")

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Run = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event() = event

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunExpired = apply {
            if (!validated) {
                event()
                data().validate()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var event: JsonField<Event> = JsonMissing.of()
            private var data: JsonField<Run> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadRunExpired: ThreadRunExpired) = apply {
                event = threadRunExpired.event
                data = threadRunExpired.data
                additionalProperties = threadRunExpired.additionalProperties.toMutableMap()
            }

            fun event(event: Event) = event(JsonField.of(event))

            fun event(event: JsonField<Event>) = apply { this.event = event }

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
                    event,
                    data,
                    additionalProperties.toImmutable(),
                )
        }

        class Event
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val THREAD_RUN_EXPIRED = of("thread.run.expired")

                @JvmStatic fun of(value: String) = Event(JsonField.of(value))
            }

            enum class Known {
                THREAD_RUN_EXPIRED,
            }

            enum class Value {
                THREAD_RUN_EXPIRED,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    THREAD_RUN_EXPIRED -> Value.THREAD_RUN_EXPIRED
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    THREAD_RUN_EXPIRED -> Known.THREAD_RUN_EXPIRED
                    else -> throw OpenAIInvalidDataException("Unknown Event: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Event && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadRunExpired && event == other.event && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(event, data, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunExpired{event=$event, data=$data, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a
     * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) is created.
     */
    @NoAutoDetect
    class ThreadRunStepCreated
    @JsonCreator
    private constructor(
        @JsonProperty("event")
        @ExcludeMissing
        private val event: JsonField<Event> = JsonMissing.of(),
        @JsonProperty("data")
        @ExcludeMissing
        private val data: JsonField<RunStep> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun event(): Event = event.getRequired("event")

        /** Represents a step in execution of a run. */
        fun data(): RunStep = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event() = event

        /** Represents a step in execution of a run. */
        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunStepCreated = apply {
            if (!validated) {
                event()
                data().validate()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var event: JsonField<Event> = JsonMissing.of()
            private var data: JsonField<RunStep> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadRunStepCreated: ThreadRunStepCreated) = apply {
                event = threadRunStepCreated.event
                data = threadRunStepCreated.data
                additionalProperties = threadRunStepCreated.additionalProperties.toMutableMap()
            }

            fun event(event: Event) = event(JsonField.of(event))

            fun event(event: JsonField<Event>) = apply { this.event = event }

            /** Represents a step in execution of a run. */
            fun data(data: RunStep) = data(JsonField.of(data))

            /** Represents a step in execution of a run. */
            fun data(data: JsonField<RunStep>) = apply { this.data = data }

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
                    event,
                    data,
                    additionalProperties.toImmutable(),
                )
        }

        class Event
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val THREAD_RUN_STEP_CREATED = of("thread.run.step.created")

                @JvmStatic fun of(value: String) = Event(JsonField.of(value))
            }

            enum class Known {
                THREAD_RUN_STEP_CREATED,
            }

            enum class Value {
                THREAD_RUN_STEP_CREATED,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    THREAD_RUN_STEP_CREATED -> Value.THREAD_RUN_STEP_CREATED
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    THREAD_RUN_STEP_CREATED -> Known.THREAD_RUN_STEP_CREATED
                    else -> throw OpenAIInvalidDataException("Unknown Event: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Event && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadRunStepCreated && event == other.event && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(event, data, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunStepCreated{event=$event, data=$data, additionalProperties=$additionalProperties}"
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
        @JsonProperty("event")
        @ExcludeMissing
        private val event: JsonField<Event> = JsonMissing.of(),
        @JsonProperty("data")
        @ExcludeMissing
        private val data: JsonField<RunStep> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun event(): Event = event.getRequired("event")

        /** Represents a step in execution of a run. */
        fun data(): RunStep = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event() = event

        /** Represents a step in execution of a run. */
        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunStepInProgress = apply {
            if (!validated) {
                event()
                data().validate()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var event: JsonField<Event> = JsonMissing.of()
            private var data: JsonField<RunStep> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadRunStepInProgress: ThreadRunStepInProgress) = apply {
                event = threadRunStepInProgress.event
                data = threadRunStepInProgress.data
                additionalProperties = threadRunStepInProgress.additionalProperties.toMutableMap()
            }

            fun event(event: Event) = event(JsonField.of(event))

            fun event(event: JsonField<Event>) = apply { this.event = event }

            /** Represents a step in execution of a run. */
            fun data(data: RunStep) = data(JsonField.of(data))

            /** Represents a step in execution of a run. */
            fun data(data: JsonField<RunStep>) = apply { this.data = data }

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
                    event,
                    data,
                    additionalProperties.toImmutable(),
                )
        }

        class Event
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val THREAD_RUN_STEP_IN_PROGRESS = of("thread.run.step.in_progress")

                @JvmStatic fun of(value: String) = Event(JsonField.of(value))
            }

            enum class Known {
                THREAD_RUN_STEP_IN_PROGRESS,
            }

            enum class Value {
                THREAD_RUN_STEP_IN_PROGRESS,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    THREAD_RUN_STEP_IN_PROGRESS -> Value.THREAD_RUN_STEP_IN_PROGRESS
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    THREAD_RUN_STEP_IN_PROGRESS -> Known.THREAD_RUN_STEP_IN_PROGRESS
                    else -> throw OpenAIInvalidDataException("Unknown Event: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Event && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadRunStepInProgress && event == other.event && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(event, data, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunStepInProgress{event=$event, data=$data, additionalProperties=$additionalProperties}"
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
        @JsonProperty("event")
        @ExcludeMissing
        private val event: JsonField<Event> = JsonMissing.of(),
        @JsonProperty("data")
        @ExcludeMissing
        private val data: JsonField<RunStepDeltaEvent> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun event(): Event = event.getRequired("event")

        /** Represents a run step delta i.e. any changed fields on a run step during streaming. */
        fun data(): RunStepDeltaEvent = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event() = event

        /** Represents a run step delta i.e. any changed fields on a run step during streaming. */
        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunStepDelta = apply {
            if (!validated) {
                event()
                data().validate()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var event: JsonField<Event> = JsonMissing.of()
            private var data: JsonField<RunStepDeltaEvent> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadRunStepDelta: ThreadRunStepDelta) = apply {
                event = threadRunStepDelta.event
                data = threadRunStepDelta.data
                additionalProperties = threadRunStepDelta.additionalProperties.toMutableMap()
            }

            fun event(event: Event) = event(JsonField.of(event))

            fun event(event: JsonField<Event>) = apply { this.event = event }

            /**
             * Represents a run step delta i.e. any changed fields on a run step during streaming.
             */
            fun data(data: RunStepDeltaEvent) = data(JsonField.of(data))

            /**
             * Represents a run step delta i.e. any changed fields on a run step during streaming.
             */
            fun data(data: JsonField<RunStepDeltaEvent>) = apply { this.data = data }

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
                    event,
                    data,
                    additionalProperties.toImmutable(),
                )
        }

        class Event
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val THREAD_RUN_STEP_DELTA = of("thread.run.step.delta")

                @JvmStatic fun of(value: String) = Event(JsonField.of(value))
            }

            enum class Known {
                THREAD_RUN_STEP_DELTA,
            }

            enum class Value {
                THREAD_RUN_STEP_DELTA,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    THREAD_RUN_STEP_DELTA -> Value.THREAD_RUN_STEP_DELTA
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    THREAD_RUN_STEP_DELTA -> Known.THREAD_RUN_STEP_DELTA
                    else -> throw OpenAIInvalidDataException("Unknown Event: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Event && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadRunStepDelta && event == other.event && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(event, data, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunStepDelta{event=$event, data=$data, additionalProperties=$additionalProperties}"
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
        @JsonProperty("event")
        @ExcludeMissing
        private val event: JsonField<Event> = JsonMissing.of(),
        @JsonProperty("data")
        @ExcludeMissing
        private val data: JsonField<RunStep> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun event(): Event = event.getRequired("event")

        /** Represents a step in execution of a run. */
        fun data(): RunStep = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event() = event

        /** Represents a step in execution of a run. */
        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunStepCompleted = apply {
            if (!validated) {
                event()
                data().validate()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var event: JsonField<Event> = JsonMissing.of()
            private var data: JsonField<RunStep> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadRunStepCompleted: ThreadRunStepCompleted) = apply {
                event = threadRunStepCompleted.event
                data = threadRunStepCompleted.data
                additionalProperties = threadRunStepCompleted.additionalProperties.toMutableMap()
            }

            fun event(event: Event) = event(JsonField.of(event))

            fun event(event: JsonField<Event>) = apply { this.event = event }

            /** Represents a step in execution of a run. */
            fun data(data: RunStep) = data(JsonField.of(data))

            /** Represents a step in execution of a run. */
            fun data(data: JsonField<RunStep>) = apply { this.data = data }

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
                    event,
                    data,
                    additionalProperties.toImmutable(),
                )
        }

        class Event
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val THREAD_RUN_STEP_COMPLETED = of("thread.run.step.completed")

                @JvmStatic fun of(value: String) = Event(JsonField.of(value))
            }

            enum class Known {
                THREAD_RUN_STEP_COMPLETED,
            }

            enum class Value {
                THREAD_RUN_STEP_COMPLETED,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    THREAD_RUN_STEP_COMPLETED -> Value.THREAD_RUN_STEP_COMPLETED
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    THREAD_RUN_STEP_COMPLETED -> Known.THREAD_RUN_STEP_COMPLETED
                    else -> throw OpenAIInvalidDataException("Unknown Event: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Event && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadRunStepCompleted && event == other.event && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(event, data, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunStepCompleted{event=$event, data=$data, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a
     * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) fails.
     */
    @NoAutoDetect
    class ThreadRunStepFailed
    @JsonCreator
    private constructor(
        @JsonProperty("event")
        @ExcludeMissing
        private val event: JsonField<Event> = JsonMissing.of(),
        @JsonProperty("data")
        @ExcludeMissing
        private val data: JsonField<RunStep> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun event(): Event = event.getRequired("event")

        /** Represents a step in execution of a run. */
        fun data(): RunStep = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event() = event

        /** Represents a step in execution of a run. */
        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunStepFailed = apply {
            if (!validated) {
                event()
                data().validate()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var event: JsonField<Event> = JsonMissing.of()
            private var data: JsonField<RunStep> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadRunStepFailed: ThreadRunStepFailed) = apply {
                event = threadRunStepFailed.event
                data = threadRunStepFailed.data
                additionalProperties = threadRunStepFailed.additionalProperties.toMutableMap()
            }

            fun event(event: Event) = event(JsonField.of(event))

            fun event(event: JsonField<Event>) = apply { this.event = event }

            /** Represents a step in execution of a run. */
            fun data(data: RunStep) = data(JsonField.of(data))

            /** Represents a step in execution of a run. */
            fun data(data: JsonField<RunStep>) = apply { this.data = data }

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
                    event,
                    data,
                    additionalProperties.toImmutable(),
                )
        }

        class Event
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val THREAD_RUN_STEP_FAILED = of("thread.run.step.failed")

                @JvmStatic fun of(value: String) = Event(JsonField.of(value))
            }

            enum class Known {
                THREAD_RUN_STEP_FAILED,
            }

            enum class Value {
                THREAD_RUN_STEP_FAILED,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    THREAD_RUN_STEP_FAILED -> Value.THREAD_RUN_STEP_FAILED
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    THREAD_RUN_STEP_FAILED -> Known.THREAD_RUN_STEP_FAILED
                    else -> throw OpenAIInvalidDataException("Unknown Event: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Event && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadRunStepFailed && event == other.event && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(event, data, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunStepFailed{event=$event, data=$data, additionalProperties=$additionalProperties}"
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
        @JsonProperty("event")
        @ExcludeMissing
        private val event: JsonField<Event> = JsonMissing.of(),
        @JsonProperty("data")
        @ExcludeMissing
        private val data: JsonField<RunStep> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun event(): Event = event.getRequired("event")

        /** Represents a step in execution of a run. */
        fun data(): RunStep = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event() = event

        /** Represents a step in execution of a run. */
        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunStepCancelled = apply {
            if (!validated) {
                event()
                data().validate()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var event: JsonField<Event> = JsonMissing.of()
            private var data: JsonField<RunStep> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadRunStepCancelled: ThreadRunStepCancelled) = apply {
                event = threadRunStepCancelled.event
                data = threadRunStepCancelled.data
                additionalProperties = threadRunStepCancelled.additionalProperties.toMutableMap()
            }

            fun event(event: Event) = event(JsonField.of(event))

            fun event(event: JsonField<Event>) = apply { this.event = event }

            /** Represents a step in execution of a run. */
            fun data(data: RunStep) = data(JsonField.of(data))

            /** Represents a step in execution of a run. */
            fun data(data: JsonField<RunStep>) = apply { this.data = data }

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
                    event,
                    data,
                    additionalProperties.toImmutable(),
                )
        }

        class Event
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val THREAD_RUN_STEP_CANCELLED = of("thread.run.step.cancelled")

                @JvmStatic fun of(value: String) = Event(JsonField.of(value))
            }

            enum class Known {
                THREAD_RUN_STEP_CANCELLED,
            }

            enum class Value {
                THREAD_RUN_STEP_CANCELLED,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    THREAD_RUN_STEP_CANCELLED -> Value.THREAD_RUN_STEP_CANCELLED
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    THREAD_RUN_STEP_CANCELLED -> Known.THREAD_RUN_STEP_CANCELLED
                    else -> throw OpenAIInvalidDataException("Unknown Event: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Event && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadRunStepCancelled && event == other.event && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(event, data, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunStepCancelled{event=$event, data=$data, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a
     * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) expires.
     */
    @NoAutoDetect
    class ThreadRunStepExpired
    @JsonCreator
    private constructor(
        @JsonProperty("event")
        @ExcludeMissing
        private val event: JsonField<Event> = JsonMissing.of(),
        @JsonProperty("data")
        @ExcludeMissing
        private val data: JsonField<RunStep> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun event(): Event = event.getRequired("event")

        /** Represents a step in execution of a run. */
        fun data(): RunStep = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event() = event

        /** Represents a step in execution of a run. */
        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunStepExpired = apply {
            if (!validated) {
                event()
                data().validate()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var event: JsonField<Event> = JsonMissing.of()
            private var data: JsonField<RunStep> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadRunStepExpired: ThreadRunStepExpired) = apply {
                event = threadRunStepExpired.event
                data = threadRunStepExpired.data
                additionalProperties = threadRunStepExpired.additionalProperties.toMutableMap()
            }

            fun event(event: Event) = event(JsonField.of(event))

            fun event(event: JsonField<Event>) = apply { this.event = event }

            /** Represents a step in execution of a run. */
            fun data(data: RunStep) = data(JsonField.of(data))

            /** Represents a step in execution of a run. */
            fun data(data: JsonField<RunStep>) = apply { this.data = data }

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
                    event,
                    data,
                    additionalProperties.toImmutable(),
                )
        }

        class Event
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val THREAD_RUN_STEP_EXPIRED = of("thread.run.step.expired")

                @JvmStatic fun of(value: String) = Event(JsonField.of(value))
            }

            enum class Known {
                THREAD_RUN_STEP_EXPIRED,
            }

            enum class Value {
                THREAD_RUN_STEP_EXPIRED,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    THREAD_RUN_STEP_EXPIRED -> Value.THREAD_RUN_STEP_EXPIRED
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    THREAD_RUN_STEP_EXPIRED -> Known.THREAD_RUN_STEP_EXPIRED
                    else -> throw OpenAIInvalidDataException("Unknown Event: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Event && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadRunStepExpired && event == other.event && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(event, data, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunStepExpired{event=$event, data=$data, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a [message](https://platform.openai.com/docs/api-reference/messages/object) is
     * created.
     */
    @NoAutoDetect
    class ThreadMessageCreated
    @JsonCreator
    private constructor(
        @JsonProperty("event")
        @ExcludeMissing
        private val event: JsonField<Event> = JsonMissing.of(),
        @JsonProperty("data")
        @ExcludeMissing
        private val data: JsonField<Message> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun event(): Event = event.getRequired("event")

        /**
         * Represents a message within a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Message = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event() = event

        /**
         * Represents a message within a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadMessageCreated = apply {
            if (!validated) {
                event()
                data().validate()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var event: JsonField<Event> = JsonMissing.of()
            private var data: JsonField<Message> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadMessageCreated: ThreadMessageCreated) = apply {
                event = threadMessageCreated.event
                data = threadMessageCreated.data
                additionalProperties = threadMessageCreated.additionalProperties.toMutableMap()
            }

            fun event(event: Event) = event(JsonField.of(event))

            fun event(event: JsonField<Event>) = apply { this.event = event }

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
                    event,
                    data,
                    additionalProperties.toImmutable(),
                )
        }

        class Event
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val THREAD_MESSAGE_CREATED = of("thread.message.created")

                @JvmStatic fun of(value: String) = Event(JsonField.of(value))
            }

            enum class Known {
                THREAD_MESSAGE_CREATED,
            }

            enum class Value {
                THREAD_MESSAGE_CREATED,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    THREAD_MESSAGE_CREATED -> Value.THREAD_MESSAGE_CREATED
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    THREAD_MESSAGE_CREATED -> Known.THREAD_MESSAGE_CREATED
                    else -> throw OpenAIInvalidDataException("Unknown Event: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Event && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadMessageCreated && event == other.event && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(event, data, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadMessageCreated{event=$event, data=$data, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a [message](https://platform.openai.com/docs/api-reference/messages/object) moves
     * to an `in_progress` state.
     */
    @NoAutoDetect
    class ThreadMessageInProgress
    @JsonCreator
    private constructor(
        @JsonProperty("event")
        @ExcludeMissing
        private val event: JsonField<Event> = JsonMissing.of(),
        @JsonProperty("data")
        @ExcludeMissing
        private val data: JsonField<Message> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun event(): Event = event.getRequired("event")

        /**
         * Represents a message within a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Message = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event() = event

        /**
         * Represents a message within a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadMessageInProgress = apply {
            if (!validated) {
                event()
                data().validate()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var event: JsonField<Event> = JsonMissing.of()
            private var data: JsonField<Message> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadMessageInProgress: ThreadMessageInProgress) = apply {
                event = threadMessageInProgress.event
                data = threadMessageInProgress.data
                additionalProperties = threadMessageInProgress.additionalProperties.toMutableMap()
            }

            fun event(event: Event) = event(JsonField.of(event))

            fun event(event: JsonField<Event>) = apply { this.event = event }

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
                    event,
                    data,
                    additionalProperties.toImmutable(),
                )
        }

        class Event
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val THREAD_MESSAGE_IN_PROGRESS = of("thread.message.in_progress")

                @JvmStatic fun of(value: String) = Event(JsonField.of(value))
            }

            enum class Known {
                THREAD_MESSAGE_IN_PROGRESS,
            }

            enum class Value {
                THREAD_MESSAGE_IN_PROGRESS,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    THREAD_MESSAGE_IN_PROGRESS -> Value.THREAD_MESSAGE_IN_PROGRESS
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    THREAD_MESSAGE_IN_PROGRESS -> Known.THREAD_MESSAGE_IN_PROGRESS
                    else -> throw OpenAIInvalidDataException("Unknown Event: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Event && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadMessageInProgress && event == other.event && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(event, data, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadMessageInProgress{event=$event, data=$data, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when parts of a
     * [Message](https://platform.openai.com/docs/api-reference/messages/object) are being streamed.
     */
    @NoAutoDetect
    class ThreadMessageDelta
    @JsonCreator
    private constructor(
        @JsonProperty("event")
        @ExcludeMissing
        private val event: JsonField<Event> = JsonMissing.of(),
        @JsonProperty("data")
        @ExcludeMissing
        private val data: JsonField<MessageDeltaEvent> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun event(): Event = event.getRequired("event")

        /** Represents a message delta i.e. any changed fields on a message during streaming. */
        fun data(): MessageDeltaEvent = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event() = event

        /** Represents a message delta i.e. any changed fields on a message during streaming. */
        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadMessageDelta = apply {
            if (!validated) {
                event()
                data().validate()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var event: JsonField<Event> = JsonMissing.of()
            private var data: JsonField<MessageDeltaEvent> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadMessageDelta: ThreadMessageDelta) = apply {
                event = threadMessageDelta.event
                data = threadMessageDelta.data
                additionalProperties = threadMessageDelta.additionalProperties.toMutableMap()
            }

            fun event(event: Event) = event(JsonField.of(event))

            fun event(event: JsonField<Event>) = apply { this.event = event }

            /** Represents a message delta i.e. any changed fields on a message during streaming. */
            fun data(data: MessageDeltaEvent) = data(JsonField.of(data))

            /** Represents a message delta i.e. any changed fields on a message during streaming. */
            fun data(data: JsonField<MessageDeltaEvent>) = apply { this.data = data }

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
                    event,
                    data,
                    additionalProperties.toImmutable(),
                )
        }

        class Event
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val THREAD_MESSAGE_DELTA = of("thread.message.delta")

                @JvmStatic fun of(value: String) = Event(JsonField.of(value))
            }

            enum class Known {
                THREAD_MESSAGE_DELTA,
            }

            enum class Value {
                THREAD_MESSAGE_DELTA,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    THREAD_MESSAGE_DELTA -> Value.THREAD_MESSAGE_DELTA
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    THREAD_MESSAGE_DELTA -> Known.THREAD_MESSAGE_DELTA
                    else -> throw OpenAIInvalidDataException("Unknown Event: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Event && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadMessageDelta && event == other.event && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(event, data, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadMessageDelta{event=$event, data=$data, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a [message](https://platform.openai.com/docs/api-reference/messages/object) is
     * completed.
     */
    @NoAutoDetect
    class ThreadMessageCompleted
    @JsonCreator
    private constructor(
        @JsonProperty("event")
        @ExcludeMissing
        private val event: JsonField<Event> = JsonMissing.of(),
        @JsonProperty("data")
        @ExcludeMissing
        private val data: JsonField<Message> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun event(): Event = event.getRequired("event")

        /**
         * Represents a message within a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Message = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event() = event

        /**
         * Represents a message within a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadMessageCompleted = apply {
            if (!validated) {
                event()
                data().validate()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var event: JsonField<Event> = JsonMissing.of()
            private var data: JsonField<Message> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadMessageCompleted: ThreadMessageCompleted) = apply {
                event = threadMessageCompleted.event
                data = threadMessageCompleted.data
                additionalProperties = threadMessageCompleted.additionalProperties.toMutableMap()
            }

            fun event(event: Event) = event(JsonField.of(event))

            fun event(event: JsonField<Event>) = apply { this.event = event }

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
                    event,
                    data,
                    additionalProperties.toImmutable(),
                )
        }

        class Event
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val THREAD_MESSAGE_COMPLETED = of("thread.message.completed")

                @JvmStatic fun of(value: String) = Event(JsonField.of(value))
            }

            enum class Known {
                THREAD_MESSAGE_COMPLETED,
            }

            enum class Value {
                THREAD_MESSAGE_COMPLETED,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    THREAD_MESSAGE_COMPLETED -> Value.THREAD_MESSAGE_COMPLETED
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    THREAD_MESSAGE_COMPLETED -> Known.THREAD_MESSAGE_COMPLETED
                    else -> throw OpenAIInvalidDataException("Unknown Event: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Event && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadMessageCompleted && event == other.event && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(event, data, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadMessageCompleted{event=$event, data=$data, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a [message](https://platform.openai.com/docs/api-reference/messages/object) ends
     * before it is completed.
     */
    @NoAutoDetect
    class ThreadMessageIncomplete
    @JsonCreator
    private constructor(
        @JsonProperty("event")
        @ExcludeMissing
        private val event: JsonField<Event> = JsonMissing.of(),
        @JsonProperty("data")
        @ExcludeMissing
        private val data: JsonField<Message> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun event(): Event = event.getRequired("event")

        /**
         * Represents a message within a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Message = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event() = event

        /**
         * Represents a message within a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadMessageIncomplete = apply {
            if (!validated) {
                event()
                data().validate()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var event: JsonField<Event> = JsonMissing.of()
            private var data: JsonField<Message> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(threadMessageIncomplete: ThreadMessageIncomplete) = apply {
                event = threadMessageIncomplete.event
                data = threadMessageIncomplete.data
                additionalProperties = threadMessageIncomplete.additionalProperties.toMutableMap()
            }

            fun event(event: Event) = event(JsonField.of(event))

            fun event(event: JsonField<Event>) = apply { this.event = event }

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
                    event,
                    data,
                    additionalProperties.toImmutable(),
                )
        }

        class Event
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val THREAD_MESSAGE_INCOMPLETE = of("thread.message.incomplete")

                @JvmStatic fun of(value: String) = Event(JsonField.of(value))
            }

            enum class Known {
                THREAD_MESSAGE_INCOMPLETE,
            }

            enum class Value {
                THREAD_MESSAGE_INCOMPLETE,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    THREAD_MESSAGE_INCOMPLETE -> Value.THREAD_MESSAGE_INCOMPLETE
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    THREAD_MESSAGE_INCOMPLETE -> Known.THREAD_MESSAGE_INCOMPLETE
                    else -> throw OpenAIInvalidDataException("Unknown Event: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Event && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ThreadMessageIncomplete && event == other.event && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(event, data, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadMessageIncomplete{event=$event, data=$data, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when an [error](https://platform.openai.com/docs/guides/error-codes#api-errors)
     * occurs. This can happen due to an internal server error or a timeout.
     */
    @NoAutoDetect
    class ErrorEvent
    @JsonCreator
    private constructor(
        @JsonProperty("event")
        @ExcludeMissing
        private val event: JsonField<Event> = JsonMissing.of(),
        @JsonProperty("data")
        @ExcludeMissing
        private val data: JsonField<ErrorObject> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun event(): Event = event.getRequired("event")

        fun data(): ErrorObject = data.getRequired("data")

        @JsonProperty("event") @ExcludeMissing fun _event() = event

        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ErrorEvent = apply {
            if (!validated) {
                event()
                data().validate()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var event: JsonField<Event> = JsonMissing.of()
            private var data: JsonField<ErrorObject> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(errorEvent: ErrorEvent) = apply {
                event = errorEvent.event
                data = errorEvent.data
                additionalProperties = errorEvent.additionalProperties.toMutableMap()
            }

            fun event(event: Event) = event(JsonField.of(event))

            fun event(event: JsonField<Event>) = apply { this.event = event }

            fun data(data: ErrorObject) = data(JsonField.of(data))

            fun data(data: JsonField<ErrorObject>) = apply { this.data = data }

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
                    event,
                    data,
                    additionalProperties.toImmutable(),
                )
        }

        class Event
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val ERROR = of("error")

                @JvmStatic fun of(value: String) = Event(JsonField.of(value))
            }

            enum class Known {
                ERROR,
            }

            enum class Value {
                ERROR,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    ERROR -> Value.ERROR
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    ERROR -> Known.ERROR
                    else -> throw OpenAIInvalidDataException("Unknown Event: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Event && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ErrorEvent && event == other.event && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(event, data, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ErrorEvent{event=$event, data=$data, additionalProperties=$additionalProperties}"
    }
}
