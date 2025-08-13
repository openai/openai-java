// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.assistants

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
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.ErrorObject
import com.openai.models.beta.threads.Thread
import com.openai.models.beta.threads.messages.Message
import com.openai.models.beta.threads.messages.MessageDeltaEvent
import com.openai.models.beta.threads.runs.Run
import com.openai.models.beta.threads.runs.steps.RunStep
import com.openai.models.beta.threads.runs.steps.RunStepDeltaEvent
import java.util.Collections
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

    fun <T> accept(visitor: Visitor<T>): T =
        when {
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
                override fun visitThreadCreated(threadCreated: ThreadCreated) =
                    threadCreated.validity()

                override fun visitThreadRunCreated(threadRunCreated: ThreadRunCreated) =
                    threadRunCreated.validity()

                override fun visitThreadRunQueued(threadRunQueued: ThreadRunQueued) =
                    threadRunQueued.validity()

                override fun visitThreadRunInProgress(threadRunInProgress: ThreadRunInProgress) =
                    threadRunInProgress.validity()

                override fun visitThreadRunRequiresAction(
                    threadRunRequiresAction: ThreadRunRequiresAction
                ) = threadRunRequiresAction.validity()

                override fun visitThreadRunCompleted(threadRunCompleted: ThreadRunCompleted) =
                    threadRunCompleted.validity()

                override fun visitThreadRunIncomplete(threadRunIncomplete: ThreadRunIncomplete) =
                    threadRunIncomplete.validity()

                override fun visitThreadRunFailed(threadRunFailed: ThreadRunFailed) =
                    threadRunFailed.validity()

                override fun visitThreadRunCancelling(threadRunCancelling: ThreadRunCancelling) =
                    threadRunCancelling.validity()

                override fun visitThreadRunCancelled(threadRunCancelled: ThreadRunCancelled) =
                    threadRunCancelled.validity()

                override fun visitThreadRunExpired(threadRunExpired: ThreadRunExpired) =
                    threadRunExpired.validity()

                override fun visitThreadRunStepCreated(threadRunStepCreated: ThreadRunStepCreated) =
                    threadRunStepCreated.validity()

                override fun visitThreadRunStepInProgress(
                    threadRunStepInProgress: ThreadRunStepInProgress
                ) = threadRunStepInProgress.validity()

                override fun visitThreadRunStepDelta(threadRunStepDelta: ThreadRunStepDelta) =
                    threadRunStepDelta.validity()

                override fun visitThreadRunStepCompleted(
                    threadRunStepCompleted: ThreadRunStepCompleted
                ) = threadRunStepCompleted.validity()

                override fun visitThreadRunStepFailed(threadRunStepFailed: ThreadRunStepFailed) =
                    threadRunStepFailed.validity()

                override fun visitThreadRunStepCancelled(
                    threadRunStepCancelled: ThreadRunStepCancelled
                ) = threadRunStepCancelled.validity()

                override fun visitThreadRunStepExpired(threadRunStepExpired: ThreadRunStepExpired) =
                    threadRunStepExpired.validity()

                override fun visitThreadMessageCreated(threadMessageCreated: ThreadMessageCreated) =
                    threadMessageCreated.validity()

                override fun visitThreadMessageInProgress(
                    threadMessageInProgress: ThreadMessageInProgress
                ) = threadMessageInProgress.validity()

                override fun visitThreadMessageDelta(threadMessageDelta: ThreadMessageDelta) =
                    threadMessageDelta.validity()

                override fun visitThreadMessageCompleted(
                    threadMessageCompleted: ThreadMessageCompleted
                ) = threadMessageCompleted.validity()

                override fun visitThreadMessageIncomplete(
                    threadMessageIncomplete: ThreadMessageIncomplete
                ) = threadMessageIncomplete.validity()

                override fun visitErrorEvent(errorEvent: ErrorEvent) = errorEvent.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AssistantStreamEvent &&
            threadCreated == other.threadCreated &&
            threadRunCreated == other.threadRunCreated &&
            threadRunQueued == other.threadRunQueued &&
            threadRunInProgress == other.threadRunInProgress &&
            threadRunRequiresAction == other.threadRunRequiresAction &&
            threadRunCompleted == other.threadRunCompleted &&
            threadRunIncomplete == other.threadRunIncomplete &&
            threadRunFailed == other.threadRunFailed &&
            threadRunCancelling == other.threadRunCancelling &&
            threadRunCancelled == other.threadRunCancelled &&
            threadRunExpired == other.threadRunExpired &&
            threadRunStepCreated == other.threadRunStepCreated &&
            threadRunStepInProgress == other.threadRunStepInProgress &&
            threadRunStepDelta == other.threadRunStepDelta &&
            threadRunStepCompleted == other.threadRunStepCompleted &&
            threadRunStepFailed == other.threadRunStepFailed &&
            threadRunStepCancelled == other.threadRunStepCancelled &&
            threadRunStepExpired == other.threadRunStepExpired &&
            threadMessageCreated == other.threadMessageCreated &&
            threadMessageInProgress == other.threadMessageInProgress &&
            threadMessageDelta == other.threadMessageDelta &&
            threadMessageCompleted == other.threadMessageCompleted &&
            threadMessageIncomplete == other.threadMessageIncomplete &&
            errorEvent == other.errorEvent
    }

    override fun hashCode(): Int =
        Objects.hash(
            threadCreated,
            threadRunCreated,
            threadRunQueued,
            threadRunInProgress,
            threadRunRequiresAction,
            threadRunCompleted,
            threadRunIncomplete,
            threadRunFailed,
            threadRunCancelling,
            threadRunCancelled,
            threadRunExpired,
            threadRunStepCreated,
            threadRunStepInProgress,
            threadRunStepDelta,
            threadRunStepCompleted,
            threadRunStepFailed,
            threadRunStepCancelled,
            threadRunStepExpired,
            threadMessageCreated,
            threadMessageInProgress,
            threadMessageDelta,
            threadMessageCompleted,
            threadMessageIncomplete,
            errorEvent,
        )

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

    /**
     * An interface that defines how to map each variant of [AssistantStreamEvent] to a value of
     * type [T].
     */
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

        /**
         * Maps an unknown variant of [AssistantStreamEvent] to a value of type [T].
         *
         * An instance of [AssistantStreamEvent] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
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
                    return tryDeserialize(node, jacksonTypeRef<ThreadCreated>())?.let {
                        AssistantStreamEvent(threadCreated = it, _json = json)
                    } ?: AssistantStreamEvent(_json = json)
                }
                "thread.run.created" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadRunCreated>())?.let {
                        AssistantStreamEvent(threadRunCreated = it, _json = json)
                    } ?: AssistantStreamEvent(_json = json)
                }
                "thread.run.queued" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadRunQueued>())?.let {
                        AssistantStreamEvent(threadRunQueued = it, _json = json)
                    } ?: AssistantStreamEvent(_json = json)
                }
                "thread.run.in_progress" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadRunInProgress>())?.let {
                        AssistantStreamEvent(threadRunInProgress = it, _json = json)
                    } ?: AssistantStreamEvent(_json = json)
                }
                "thread.run.requires_action" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadRunRequiresAction>())?.let {
                        AssistantStreamEvent(threadRunRequiresAction = it, _json = json)
                    } ?: AssistantStreamEvent(_json = json)
                }
                "thread.run.completed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadRunCompleted>())?.let {
                        AssistantStreamEvent(threadRunCompleted = it, _json = json)
                    } ?: AssistantStreamEvent(_json = json)
                }
                "thread.run.incomplete" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadRunIncomplete>())?.let {
                        AssistantStreamEvent(threadRunIncomplete = it, _json = json)
                    } ?: AssistantStreamEvent(_json = json)
                }
                "thread.run.failed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadRunFailed>())?.let {
                        AssistantStreamEvent(threadRunFailed = it, _json = json)
                    } ?: AssistantStreamEvent(_json = json)
                }
                "thread.run.cancelling" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadRunCancelling>())?.let {
                        AssistantStreamEvent(threadRunCancelling = it, _json = json)
                    } ?: AssistantStreamEvent(_json = json)
                }
                "thread.run.cancelled" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadRunCancelled>())?.let {
                        AssistantStreamEvent(threadRunCancelled = it, _json = json)
                    } ?: AssistantStreamEvent(_json = json)
                }
                "thread.run.expired" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadRunExpired>())?.let {
                        AssistantStreamEvent(threadRunExpired = it, _json = json)
                    } ?: AssistantStreamEvent(_json = json)
                }
                "thread.run.step.created" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadRunStepCreated>())?.let {
                        AssistantStreamEvent(threadRunStepCreated = it, _json = json)
                    } ?: AssistantStreamEvent(_json = json)
                }
                "thread.run.step.in_progress" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadRunStepInProgress>())?.let {
                        AssistantStreamEvent(threadRunStepInProgress = it, _json = json)
                    } ?: AssistantStreamEvent(_json = json)
                }
                "thread.run.step.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadRunStepDelta>())?.let {
                        AssistantStreamEvent(threadRunStepDelta = it, _json = json)
                    } ?: AssistantStreamEvent(_json = json)
                }
                "thread.run.step.completed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadRunStepCompleted>())?.let {
                        AssistantStreamEvent(threadRunStepCompleted = it, _json = json)
                    } ?: AssistantStreamEvent(_json = json)
                }
                "thread.run.step.failed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadRunStepFailed>())?.let {
                        AssistantStreamEvent(threadRunStepFailed = it, _json = json)
                    } ?: AssistantStreamEvent(_json = json)
                }
                "thread.run.step.cancelled" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadRunStepCancelled>())?.let {
                        AssistantStreamEvent(threadRunStepCancelled = it, _json = json)
                    } ?: AssistantStreamEvent(_json = json)
                }
                "thread.run.step.expired" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadRunStepExpired>())?.let {
                        AssistantStreamEvent(threadRunStepExpired = it, _json = json)
                    } ?: AssistantStreamEvent(_json = json)
                }
                "thread.message.created" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadMessageCreated>())?.let {
                        AssistantStreamEvent(threadMessageCreated = it, _json = json)
                    } ?: AssistantStreamEvent(_json = json)
                }
                "thread.message.in_progress" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadMessageInProgress>())?.let {
                        AssistantStreamEvent(threadMessageInProgress = it, _json = json)
                    } ?: AssistantStreamEvent(_json = json)
                }
                "thread.message.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadMessageDelta>())?.let {
                        AssistantStreamEvent(threadMessageDelta = it, _json = json)
                    } ?: AssistantStreamEvent(_json = json)
                }
                "thread.message.completed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadMessageCompleted>())?.let {
                        AssistantStreamEvent(threadMessageCompleted = it, _json = json)
                    } ?: AssistantStreamEvent(_json = json)
                }
                "thread.message.incomplete" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadMessageIncomplete>())?.let {
                        AssistantStreamEvent(threadMessageIncomplete = it, _json = json)
                    } ?: AssistantStreamEvent(_json = json)
                }
                "error" -> {
                    return tryDeserialize(node, jacksonTypeRef<ErrorEvent>())?.let {
                        AssistantStreamEvent(errorEvent = it, _json = json)
                    } ?: AssistantStreamEvent(_json = json)
                }
            }

            return AssistantStreamEvent(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<AssistantStreamEvent>(AssistantStreamEvent::class) {

        override fun serialize(
            value: AssistantStreamEvent,
            generator: JsonGenerator,
            provider: SerializerProvider,
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
    class ThreadCreated
    private constructor(
        private val data: JsonField<Thread>,
        private val event: JsonValue,
        private val enabled: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data") @ExcludeMissing data: JsonField<Thread> = JsonMissing.of(),
            @JsonProperty("event") @ExcludeMissing event: JsonValue = JsonMissing.of(),
            @JsonProperty("enabled") @ExcludeMissing enabled: JsonField<Boolean> = JsonMissing.of(),
        ) : this(data, event, enabled, mutableMapOf())

        /**
         * Represents a thread that contains
         * [messages](https://platform.openai.com/docs/api-reference/messages).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun data(): Thread = data.getRequired("data")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("thread.created")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Whether to enable input audio transcription.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun enabled(): Optional<Boolean> = enabled.getOptional("enabled")

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Thread> = data

        /**
         * Returns the raw JSON value of [enabled].
         *
         * Unlike [enabled], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("enabled") @ExcludeMissing fun _enabled(): JsonField<Boolean> = enabled

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [ThreadCreated].
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ThreadCreated]. */
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
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [Thread] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun data(data: JsonField<Thread>) = apply { this.data = data }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("thread.created")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun event(event: JsonValue) = apply { this.event = event }

            /** Whether to enable input audio transcription. */
            fun enabled(enabled: Boolean) = enabled(JsonField.of(enabled))

            /**
             * Sets [Builder.enabled] to an arbitrary JSON value.
             *
             * You should usually call [Builder.enabled] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
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

            /**
             * Returns an immutable instance of [ThreadCreated].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ThreadCreated =
                ThreadCreated(
                    checkRequired("data", data),
                    event,
                    enabled,
                    additionalProperties.toMutableMap(),
                )
        }

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

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (data.asKnown().getOrNull()?.validity() ?: 0) +
                event.let { if (it == JsonValue.from("thread.created")) 1 else 0 } +
                (if (enabled.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ThreadCreated &&
                data == other.data &&
                event == other.event &&
                enabled == other.enabled &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(data, event, enabled, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadCreated{data=$data, event=$event, enabled=$enabled, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a new [run](https://platform.openai.com/docs/api-reference/runs/object) is
     * created.
     */
    class ThreadRunCreated
    private constructor(
        private val data: JsonField<Run>,
        private val event: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data") @ExcludeMissing data: JsonField<Run> = JsonMissing.of(),
            @JsonProperty("event") @ExcludeMissing event: JsonValue = JsonMissing.of(),
        ) : this(data, event, mutableMapOf())

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun data(): Run = data.getRequired("data")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("thread.run.created")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Run> = data

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [ThreadRunCreated].
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ThreadRunCreated]. */
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
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [Run] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun data(data: JsonField<Run>) = apply { this.data = data }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("thread.run.created")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
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

            /**
             * Returns an immutable instance of [ThreadRunCreated].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ThreadRunCreated =
                ThreadRunCreated(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toMutableMap(),
                )
        }

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

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (data.asKnown().getOrNull()?.validity() ?: 0) +
                event.let { if (it == JsonValue.from("thread.run.created")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ThreadRunCreated &&
                data == other.data &&
                event == other.event &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunCreated{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) moves to a
     * `queued` status.
     */
    class ThreadRunQueued
    private constructor(
        private val data: JsonField<Run>,
        private val event: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data") @ExcludeMissing data: JsonField<Run> = JsonMissing.of(),
            @JsonProperty("event") @ExcludeMissing event: JsonValue = JsonMissing.of(),
        ) : this(data, event, mutableMapOf())

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun data(): Run = data.getRequired("data")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("thread.run.queued")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Run> = data

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [ThreadRunQueued].
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ThreadRunQueued]. */
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
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [Run] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun data(data: JsonField<Run>) = apply { this.data = data }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("thread.run.queued")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
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

            /**
             * Returns an immutable instance of [ThreadRunQueued].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ThreadRunQueued =
                ThreadRunQueued(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toMutableMap(),
                )
        }

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

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (data.asKnown().getOrNull()?.validity() ?: 0) +
                event.let { if (it == JsonValue.from("thread.run.queued")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ThreadRunQueued &&
                data == other.data &&
                event == other.event &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunQueued{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) moves to an
     * `in_progress` status.
     */
    class ThreadRunInProgress
    private constructor(
        private val data: JsonField<Run>,
        private val event: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data") @ExcludeMissing data: JsonField<Run> = JsonMissing.of(),
            @JsonProperty("event") @ExcludeMissing event: JsonValue = JsonMissing.of(),
        ) : this(data, event, mutableMapOf())

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun data(): Run = data.getRequired("data")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("thread.run.in_progress")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Run> = data

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [ThreadRunInProgress].
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ThreadRunInProgress]. */
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
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [Run] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun data(data: JsonField<Run>) = apply { this.data = data }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("thread.run.in_progress")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
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

            /**
             * Returns an immutable instance of [ThreadRunInProgress].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ThreadRunInProgress =
                ThreadRunInProgress(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toMutableMap(),
                )
        }

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

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (data.asKnown().getOrNull()?.validity() ?: 0) +
                event.let { if (it == JsonValue.from("thread.run.in_progress")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ThreadRunInProgress &&
                data == other.data &&
                event == other.event &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunInProgress{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) moves to a
     * `requires_action` status.
     */
    class ThreadRunRequiresAction
    private constructor(
        private val data: JsonField<Run>,
        private val event: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data") @ExcludeMissing data: JsonField<Run> = JsonMissing.of(),
            @JsonProperty("event") @ExcludeMissing event: JsonValue = JsonMissing.of(),
        ) : this(data, event, mutableMapOf())

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun data(): Run = data.getRequired("data")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("thread.run.requires_action")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Run> = data

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [ThreadRunRequiresAction].
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ThreadRunRequiresAction]. */
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
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [Run] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun data(data: JsonField<Run>) = apply { this.data = data }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("thread.run.requires_action")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
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

            /**
             * Returns an immutable instance of [ThreadRunRequiresAction].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ThreadRunRequiresAction =
                ThreadRunRequiresAction(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toMutableMap(),
                )
        }

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

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (data.asKnown().getOrNull()?.validity() ?: 0) +
                event.let { if (it == JsonValue.from("thread.run.requires_action")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ThreadRunRequiresAction &&
                data == other.data &&
                event == other.event &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunRequiresAction{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) is completed.
     */
    class ThreadRunCompleted
    private constructor(
        private val data: JsonField<Run>,
        private val event: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data") @ExcludeMissing data: JsonField<Run> = JsonMissing.of(),
            @JsonProperty("event") @ExcludeMissing event: JsonValue = JsonMissing.of(),
        ) : this(data, event, mutableMapOf())

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun data(): Run = data.getRequired("data")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("thread.run.completed")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Run> = data

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [ThreadRunCompleted].
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ThreadRunCompleted]. */
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
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [Run] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun data(data: JsonField<Run>) = apply { this.data = data }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("thread.run.completed")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
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

            /**
             * Returns an immutable instance of [ThreadRunCompleted].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ThreadRunCompleted =
                ThreadRunCompleted(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toMutableMap(),
                )
        }

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

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (data.asKnown().getOrNull()?.validity() ?: 0) +
                event.let { if (it == JsonValue.from("thread.run.completed")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ThreadRunCompleted &&
                data == other.data &&
                event == other.event &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunCompleted{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) ends with
     * status `incomplete`.
     */
    class ThreadRunIncomplete
    private constructor(
        private val data: JsonField<Run>,
        private val event: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data") @ExcludeMissing data: JsonField<Run> = JsonMissing.of(),
            @JsonProperty("event") @ExcludeMissing event: JsonValue = JsonMissing.of(),
        ) : this(data, event, mutableMapOf())

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun data(): Run = data.getRequired("data")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("thread.run.incomplete")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Run> = data

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [ThreadRunIncomplete].
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ThreadRunIncomplete]. */
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
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [Run] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun data(data: JsonField<Run>) = apply { this.data = data }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("thread.run.incomplete")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
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

            /**
             * Returns an immutable instance of [ThreadRunIncomplete].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ThreadRunIncomplete =
                ThreadRunIncomplete(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toMutableMap(),
                )
        }

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

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (data.asKnown().getOrNull()?.validity() ?: 0) +
                event.let { if (it == JsonValue.from("thread.run.incomplete")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ThreadRunIncomplete &&
                data == other.data &&
                event == other.event &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunIncomplete{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /** Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) fails. */
    class ThreadRunFailed
    private constructor(
        private val data: JsonField<Run>,
        private val event: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data") @ExcludeMissing data: JsonField<Run> = JsonMissing.of(),
            @JsonProperty("event") @ExcludeMissing event: JsonValue = JsonMissing.of(),
        ) : this(data, event, mutableMapOf())

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun data(): Run = data.getRequired("data")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("thread.run.failed")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Run> = data

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [ThreadRunFailed].
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ThreadRunFailed]. */
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
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [Run] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun data(data: JsonField<Run>) = apply { this.data = data }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("thread.run.failed")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
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

            /**
             * Returns an immutable instance of [ThreadRunFailed].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ThreadRunFailed =
                ThreadRunFailed(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toMutableMap(),
                )
        }

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

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (data.asKnown().getOrNull()?.validity() ?: 0) +
                event.let { if (it == JsonValue.from("thread.run.failed")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ThreadRunFailed &&
                data == other.data &&
                event == other.event &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunFailed{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) moves to a
     * `cancelling` status.
     */
    class ThreadRunCancelling
    private constructor(
        private val data: JsonField<Run>,
        private val event: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data") @ExcludeMissing data: JsonField<Run> = JsonMissing.of(),
            @JsonProperty("event") @ExcludeMissing event: JsonValue = JsonMissing.of(),
        ) : this(data, event, mutableMapOf())

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun data(): Run = data.getRequired("data")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("thread.run.cancelling")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Run> = data

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [ThreadRunCancelling].
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ThreadRunCancelling]. */
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
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [Run] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun data(data: JsonField<Run>) = apply { this.data = data }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("thread.run.cancelling")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
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

            /**
             * Returns an immutable instance of [ThreadRunCancelling].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ThreadRunCancelling =
                ThreadRunCancelling(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toMutableMap(),
                )
        }

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

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (data.asKnown().getOrNull()?.validity() ?: 0) +
                event.let { if (it == JsonValue.from("thread.run.cancelling")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ThreadRunCancelling &&
                data == other.data &&
                event == other.event &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunCancelling{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) is cancelled.
     */
    class ThreadRunCancelled
    private constructor(
        private val data: JsonField<Run>,
        private val event: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data") @ExcludeMissing data: JsonField<Run> = JsonMissing.of(),
            @JsonProperty("event") @ExcludeMissing event: JsonValue = JsonMissing.of(),
        ) : this(data, event, mutableMapOf())

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun data(): Run = data.getRequired("data")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("thread.run.cancelled")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Run> = data

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [ThreadRunCancelled].
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ThreadRunCancelled]. */
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
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [Run] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun data(data: JsonField<Run>) = apply { this.data = data }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("thread.run.cancelled")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
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

            /**
             * Returns an immutable instance of [ThreadRunCancelled].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ThreadRunCancelled =
                ThreadRunCancelled(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toMutableMap(),
                )
        }

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

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (data.asKnown().getOrNull()?.validity() ?: 0) +
                event.let { if (it == JsonValue.from("thread.run.cancelled")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ThreadRunCancelled &&
                data == other.data &&
                event == other.event &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunCancelled{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /** Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) expires. */
    class ThreadRunExpired
    private constructor(
        private val data: JsonField<Run>,
        private val event: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data") @ExcludeMissing data: JsonField<Run> = JsonMissing.of(),
            @JsonProperty("event") @ExcludeMissing event: JsonValue = JsonMissing.of(),
        ) : this(data, event, mutableMapOf())

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun data(): Run = data.getRequired("data")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("thread.run.expired")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Run> = data

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [ThreadRunExpired].
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ThreadRunExpired]. */
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
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [Run] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun data(data: JsonField<Run>) = apply { this.data = data }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("thread.run.expired")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
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

            /**
             * Returns an immutable instance of [ThreadRunExpired].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ThreadRunExpired =
                ThreadRunExpired(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toMutableMap(),
                )
        }

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

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (data.asKnown().getOrNull()?.validity() ?: 0) +
                event.let { if (it == JsonValue.from("thread.run.expired")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ThreadRunExpired &&
                data == other.data &&
                event == other.event &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunExpired{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a
     * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) is created.
     */
    class ThreadRunStepCreated
    private constructor(
        private val data: JsonField<RunStep>,
        private val event: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data") @ExcludeMissing data: JsonField<RunStep> = JsonMissing.of(),
            @JsonProperty("event") @ExcludeMissing event: JsonValue = JsonMissing.of(),
        ) : this(data, event, mutableMapOf())

        /**
         * Represents a step in execution of a run.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun data(): RunStep = data.getRequired("data")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("thread.run.step.created")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<RunStep> = data

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [ThreadRunStepCreated].
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ThreadRunStepCreated]. */
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

            /**
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [RunStep] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun data(data: JsonField<RunStep>) = apply { this.data = data }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("thread.run.step.created")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
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

            /**
             * Returns an immutable instance of [ThreadRunStepCreated].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ThreadRunStepCreated =
                ThreadRunStepCreated(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toMutableMap(),
                )
        }

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

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (data.asKnown().getOrNull()?.validity() ?: 0) +
                event.let { if (it == JsonValue.from("thread.run.step.created")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ThreadRunStepCreated &&
                data == other.data &&
                event == other.event &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunStepCreated{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a
     * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) moves to an
     * `in_progress` state.
     */
    class ThreadRunStepInProgress
    private constructor(
        private val data: JsonField<RunStep>,
        private val event: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data") @ExcludeMissing data: JsonField<RunStep> = JsonMissing.of(),
            @JsonProperty("event") @ExcludeMissing event: JsonValue = JsonMissing.of(),
        ) : this(data, event, mutableMapOf())

        /**
         * Represents a step in execution of a run.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun data(): RunStep = data.getRequired("data")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("thread.run.step.in_progress")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<RunStep> = data

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [ThreadRunStepInProgress].
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ThreadRunStepInProgress]. */
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

            /**
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [RunStep] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun data(data: JsonField<RunStep>) = apply { this.data = data }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("thread.run.step.in_progress")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
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

            /**
             * Returns an immutable instance of [ThreadRunStepInProgress].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ThreadRunStepInProgress =
                ThreadRunStepInProgress(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toMutableMap(),
                )
        }

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

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (data.asKnown().getOrNull()?.validity() ?: 0) +
                event.let { if (it == JsonValue.from("thread.run.step.in_progress")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ThreadRunStepInProgress &&
                data == other.data &&
                event == other.event &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunStepInProgress{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when parts of a
     * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) are being
     * streamed.
     */
    class ThreadRunStepDelta
    private constructor(
        private val data: JsonField<RunStepDeltaEvent>,
        private val event: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data")
            @ExcludeMissing
            data: JsonField<RunStepDeltaEvent> = JsonMissing.of(),
            @JsonProperty("event") @ExcludeMissing event: JsonValue = JsonMissing.of(),
        ) : this(data, event, mutableMapOf())

        /**
         * Represents a run step delta i.e. any changed fields on a run step during streaming.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun data(): RunStepDeltaEvent = data.getRequired("data")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("thread.run.step.delta")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<RunStepDeltaEvent> = data

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [ThreadRunStepDelta].
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ThreadRunStepDelta]. */
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
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [RunStepDeltaEvent] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun data(data: JsonField<RunStepDeltaEvent>) = apply { this.data = data }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("thread.run.step.delta")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
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

            /**
             * Returns an immutable instance of [ThreadRunStepDelta].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ThreadRunStepDelta =
                ThreadRunStepDelta(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toMutableMap(),
                )
        }

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

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (data.asKnown().getOrNull()?.validity() ?: 0) +
                event.let { if (it == JsonValue.from("thread.run.step.delta")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ThreadRunStepDelta &&
                data == other.data &&
                event == other.event &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunStepDelta{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a
     * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) is
     * completed.
     */
    class ThreadRunStepCompleted
    private constructor(
        private val data: JsonField<RunStep>,
        private val event: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data") @ExcludeMissing data: JsonField<RunStep> = JsonMissing.of(),
            @JsonProperty("event") @ExcludeMissing event: JsonValue = JsonMissing.of(),
        ) : this(data, event, mutableMapOf())

        /**
         * Represents a step in execution of a run.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun data(): RunStep = data.getRequired("data")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("thread.run.step.completed")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<RunStep> = data

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [ThreadRunStepCompleted].
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ThreadRunStepCompleted]. */
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

            /**
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [RunStep] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun data(data: JsonField<RunStep>) = apply { this.data = data }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("thread.run.step.completed")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
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

            /**
             * Returns an immutable instance of [ThreadRunStepCompleted].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ThreadRunStepCompleted =
                ThreadRunStepCompleted(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toMutableMap(),
                )
        }

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

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (data.asKnown().getOrNull()?.validity() ?: 0) +
                event.let { if (it == JsonValue.from("thread.run.step.completed")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ThreadRunStepCompleted &&
                data == other.data &&
                event == other.event &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunStepCompleted{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a
     * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) fails.
     */
    class ThreadRunStepFailed
    private constructor(
        private val data: JsonField<RunStep>,
        private val event: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data") @ExcludeMissing data: JsonField<RunStep> = JsonMissing.of(),
            @JsonProperty("event") @ExcludeMissing event: JsonValue = JsonMissing.of(),
        ) : this(data, event, mutableMapOf())

        /**
         * Represents a step in execution of a run.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun data(): RunStep = data.getRequired("data")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("thread.run.step.failed")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<RunStep> = data

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [ThreadRunStepFailed].
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ThreadRunStepFailed]. */
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

            /**
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [RunStep] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun data(data: JsonField<RunStep>) = apply { this.data = data }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("thread.run.step.failed")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
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

            /**
             * Returns an immutable instance of [ThreadRunStepFailed].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ThreadRunStepFailed =
                ThreadRunStepFailed(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toMutableMap(),
                )
        }

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

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (data.asKnown().getOrNull()?.validity() ?: 0) +
                event.let { if (it == JsonValue.from("thread.run.step.failed")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ThreadRunStepFailed &&
                data == other.data &&
                event == other.event &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunStepFailed{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a
     * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) is
     * cancelled.
     */
    class ThreadRunStepCancelled
    private constructor(
        private val data: JsonField<RunStep>,
        private val event: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data") @ExcludeMissing data: JsonField<RunStep> = JsonMissing.of(),
            @JsonProperty("event") @ExcludeMissing event: JsonValue = JsonMissing.of(),
        ) : this(data, event, mutableMapOf())

        /**
         * Represents a step in execution of a run.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun data(): RunStep = data.getRequired("data")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("thread.run.step.cancelled")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<RunStep> = data

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [ThreadRunStepCancelled].
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ThreadRunStepCancelled]. */
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

            /**
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [RunStep] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun data(data: JsonField<RunStep>) = apply { this.data = data }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("thread.run.step.cancelled")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
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

            /**
             * Returns an immutable instance of [ThreadRunStepCancelled].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ThreadRunStepCancelled =
                ThreadRunStepCancelled(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toMutableMap(),
                )
        }

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

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (data.asKnown().getOrNull()?.validity() ?: 0) +
                event.let { if (it == JsonValue.from("thread.run.step.cancelled")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ThreadRunStepCancelled &&
                data == other.data &&
                event == other.event &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunStepCancelled{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a
     * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) expires.
     */
    class ThreadRunStepExpired
    private constructor(
        private val data: JsonField<RunStep>,
        private val event: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data") @ExcludeMissing data: JsonField<RunStep> = JsonMissing.of(),
            @JsonProperty("event") @ExcludeMissing event: JsonValue = JsonMissing.of(),
        ) : this(data, event, mutableMapOf())

        /**
         * Represents a step in execution of a run.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun data(): RunStep = data.getRequired("data")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("thread.run.step.expired")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<RunStep> = data

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [ThreadRunStepExpired].
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ThreadRunStepExpired]. */
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

            /**
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [RunStep] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun data(data: JsonField<RunStep>) = apply { this.data = data }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("thread.run.step.expired")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
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

            /**
             * Returns an immutable instance of [ThreadRunStepExpired].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ThreadRunStepExpired =
                ThreadRunStepExpired(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toMutableMap(),
                )
        }

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

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (data.asKnown().getOrNull()?.validity() ?: 0) +
                event.let { if (it == JsonValue.from("thread.run.step.expired")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ThreadRunStepExpired &&
                data == other.data &&
                event == other.event &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunStepExpired{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a [message](https://platform.openai.com/docs/api-reference/messages/object) is
     * created.
     */
    class ThreadMessageCreated
    private constructor(
        private val data: JsonField<Message>,
        private val event: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data") @ExcludeMissing data: JsonField<Message> = JsonMissing.of(),
            @JsonProperty("event") @ExcludeMissing event: JsonValue = JsonMissing.of(),
        ) : this(data, event, mutableMapOf())

        /**
         * Represents a message within a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun data(): Message = data.getRequired("data")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("thread.message.created")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Message> = data

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [ThreadMessageCreated].
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ThreadMessageCreated]. */
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
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [Message] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun data(data: JsonField<Message>) = apply { this.data = data }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("thread.message.created")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
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

            /**
             * Returns an immutable instance of [ThreadMessageCreated].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ThreadMessageCreated =
                ThreadMessageCreated(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toMutableMap(),
                )
        }

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

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (data.asKnown().getOrNull()?.validity() ?: 0) +
                event.let { if (it == JsonValue.from("thread.message.created")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ThreadMessageCreated &&
                data == other.data &&
                event == other.event &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadMessageCreated{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a [message](https://platform.openai.com/docs/api-reference/messages/object) moves
     * to an `in_progress` state.
     */
    class ThreadMessageInProgress
    private constructor(
        private val data: JsonField<Message>,
        private val event: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data") @ExcludeMissing data: JsonField<Message> = JsonMissing.of(),
            @JsonProperty("event") @ExcludeMissing event: JsonValue = JsonMissing.of(),
        ) : this(data, event, mutableMapOf())

        /**
         * Represents a message within a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun data(): Message = data.getRequired("data")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("thread.message.in_progress")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Message> = data

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [ThreadMessageInProgress].
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ThreadMessageInProgress]. */
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
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [Message] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun data(data: JsonField<Message>) = apply { this.data = data }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("thread.message.in_progress")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
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

            /**
             * Returns an immutable instance of [ThreadMessageInProgress].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ThreadMessageInProgress =
                ThreadMessageInProgress(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toMutableMap(),
                )
        }

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

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (data.asKnown().getOrNull()?.validity() ?: 0) +
                event.let { if (it == JsonValue.from("thread.message.in_progress")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ThreadMessageInProgress &&
                data == other.data &&
                event == other.event &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadMessageInProgress{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when parts of a
     * [Message](https://platform.openai.com/docs/api-reference/messages/object) are being streamed.
     */
    class ThreadMessageDelta
    private constructor(
        private val data: JsonField<MessageDeltaEvent>,
        private val event: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data")
            @ExcludeMissing
            data: JsonField<MessageDeltaEvent> = JsonMissing.of(),
            @JsonProperty("event") @ExcludeMissing event: JsonValue = JsonMissing.of(),
        ) : this(data, event, mutableMapOf())

        /**
         * Represents a message delta i.e. any changed fields on a message during streaming.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun data(): MessageDeltaEvent = data.getRequired("data")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("thread.message.delta")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<MessageDeltaEvent> = data

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [ThreadMessageDelta].
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ThreadMessageDelta]. */
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

            /**
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [MessageDeltaEvent] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun data(data: JsonField<MessageDeltaEvent>) = apply { this.data = data }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("thread.message.delta")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
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

            /**
             * Returns an immutable instance of [ThreadMessageDelta].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ThreadMessageDelta =
                ThreadMessageDelta(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toMutableMap(),
                )
        }

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

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (data.asKnown().getOrNull()?.validity() ?: 0) +
                event.let { if (it == JsonValue.from("thread.message.delta")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ThreadMessageDelta &&
                data == other.data &&
                event == other.event &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadMessageDelta{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a [message](https://platform.openai.com/docs/api-reference/messages/object) is
     * completed.
     */
    class ThreadMessageCompleted
    private constructor(
        private val data: JsonField<Message>,
        private val event: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data") @ExcludeMissing data: JsonField<Message> = JsonMissing.of(),
            @JsonProperty("event") @ExcludeMissing event: JsonValue = JsonMissing.of(),
        ) : this(data, event, mutableMapOf())

        /**
         * Represents a message within a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun data(): Message = data.getRequired("data")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("thread.message.completed")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Message> = data

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [ThreadMessageCompleted].
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ThreadMessageCompleted]. */
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
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [Message] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun data(data: JsonField<Message>) = apply { this.data = data }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("thread.message.completed")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
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

            /**
             * Returns an immutable instance of [ThreadMessageCompleted].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ThreadMessageCompleted =
                ThreadMessageCompleted(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toMutableMap(),
                )
        }

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

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (data.asKnown().getOrNull()?.validity() ?: 0) +
                event.let { if (it == JsonValue.from("thread.message.completed")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ThreadMessageCompleted &&
                data == other.data &&
                event == other.event &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadMessageCompleted{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when a [message](https://platform.openai.com/docs/api-reference/messages/object) ends
     * before it is completed.
     */
    class ThreadMessageIncomplete
    private constructor(
        private val data: JsonField<Message>,
        private val event: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data") @ExcludeMissing data: JsonField<Message> = JsonMissing.of(),
            @JsonProperty("event") @ExcludeMissing event: JsonValue = JsonMissing.of(),
        ) : this(data, event, mutableMapOf())

        /**
         * Represents a message within a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun data(): Message = data.getRequired("data")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("thread.message.incomplete")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Message> = data

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [ThreadMessageIncomplete].
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ThreadMessageIncomplete]. */
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
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [Message] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun data(data: JsonField<Message>) = apply { this.data = data }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("thread.message.incomplete")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
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

            /**
             * Returns an immutable instance of [ThreadMessageIncomplete].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ThreadMessageIncomplete =
                ThreadMessageIncomplete(
                    checkRequired("data", data),
                    event,
                    additionalProperties.toMutableMap(),
                )
        }

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

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (data.asKnown().getOrNull()?.validity() ?: 0) +
                event.let { if (it == JsonValue.from("thread.message.incomplete")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ThreadMessageIncomplete &&
                data == other.data &&
                event == other.event &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadMessageIncomplete{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }

    /**
     * Occurs when an [error](https://platform.openai.com/docs/guides/error-codes#api-errors)
     * occurs. This can happen due to an internal server error or a timeout.
     */
    class ErrorEvent
    private constructor(
        private val data: JsonField<ErrorObject>,
        private val event: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data") @ExcludeMissing data: JsonField<ErrorObject> = JsonMissing.of(),
            @JsonProperty("event") @ExcludeMissing event: JsonValue = JsonMissing.of(),
        ) : this(data, event, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun data(): ErrorObject = data.getRequired("data")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("error")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<ErrorObject> = data

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [ErrorEvent].
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ErrorEvent]. */
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

            /**
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [ErrorObject] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun data(data: JsonField<ErrorObject>) = apply { this.data = data }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("error")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
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

            /**
             * Returns an immutable instance of [ErrorEvent].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ErrorEvent =
                ErrorEvent(checkRequired("data", data), event, additionalProperties.toMutableMap())
        }

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

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (data.asKnown().getOrNull()?.validity() ?: 0) +
                event.let { if (it == JsonValue.from("error")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ErrorEvent &&
                data == other.data &&
                event == other.event &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ErrorEvent{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }
}
