// File generated from our OpenAPI spec by Stainless.

package com.openai.models.webhooks

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

/** Sent when a batch API request has been cancelled. */
@JsonDeserialize(using = UnwrapWebhookEvent.Deserializer::class)
@JsonSerialize(using = UnwrapWebhookEvent.Serializer::class)
class UnwrapWebhookEvent
private constructor(
    private val batchCancelled: BatchCancelledWebhookEvent? = null,
    private val batchCompleted: BatchCompletedWebhookEvent? = null,
    private val batchExpired: BatchExpiredWebhookEvent? = null,
    private val batchFailed: BatchFailedWebhookEvent? = null,
    private val evalRunCanceled: EvalRunCanceledWebhookEvent? = null,
    private val evalRunFailed: EvalRunFailedWebhookEvent? = null,
    private val evalRunSucceeded: EvalRunSucceededWebhookEvent? = null,
    private val fineTuningJobCancelled: FineTuningJobCancelledWebhookEvent? = null,
    private val fineTuningJobFailed: FineTuningJobFailedWebhookEvent? = null,
    private val fineTuningJobSucceeded: FineTuningJobSucceededWebhookEvent? = null,
    private val realtimeCallIncoming: RealtimeCallIncomingWebhookEvent? = null,
    private val responseCancelled: ResponseCancelledWebhookEvent? = null,
    private val responseCompleted: ResponseCompletedWebhookEvent? = null,
    private val responseFailed: ResponseFailedWebhookEvent? = null,
    private val responseIncomplete: ResponseIncompleteWebhookEvent? = null,
    private val _json: JsonValue? = null,
) {

    /** Sent when a batch API request has been cancelled. */
    fun batchCancelled(): Optional<BatchCancelledWebhookEvent> = Optional.ofNullable(batchCancelled)

    /** Sent when a batch API request has been completed. */
    fun batchCompleted(): Optional<BatchCompletedWebhookEvent> = Optional.ofNullable(batchCompleted)

    /** Sent when a batch API request has expired. */
    fun batchExpired(): Optional<BatchExpiredWebhookEvent> = Optional.ofNullable(batchExpired)

    /** Sent when a batch API request has failed. */
    fun batchFailed(): Optional<BatchFailedWebhookEvent> = Optional.ofNullable(batchFailed)

    /** Sent when an eval run has been canceled. */
    fun evalRunCanceled(): Optional<EvalRunCanceledWebhookEvent> =
        Optional.ofNullable(evalRunCanceled)

    /** Sent when an eval run has failed. */
    fun evalRunFailed(): Optional<EvalRunFailedWebhookEvent> = Optional.ofNullable(evalRunFailed)

    /** Sent when an eval run has succeeded. */
    fun evalRunSucceeded(): Optional<EvalRunSucceededWebhookEvent> =
        Optional.ofNullable(evalRunSucceeded)

    /** Sent when a fine-tuning job has been cancelled. */
    fun fineTuningJobCancelled(): Optional<FineTuningJobCancelledWebhookEvent> =
        Optional.ofNullable(fineTuningJobCancelled)

    /** Sent when a fine-tuning job has failed. */
    fun fineTuningJobFailed(): Optional<FineTuningJobFailedWebhookEvent> =
        Optional.ofNullable(fineTuningJobFailed)

    /** Sent when a fine-tuning job has succeeded. */
    fun fineTuningJobSucceeded(): Optional<FineTuningJobSucceededWebhookEvent> =
        Optional.ofNullable(fineTuningJobSucceeded)

    /** Sent when Realtime API Receives a incoming SIP call. */
    fun realtimeCallIncoming(): Optional<RealtimeCallIncomingWebhookEvent> =
        Optional.ofNullable(realtimeCallIncoming)

    /** Sent when a background response has been cancelled. */
    fun responseCancelled(): Optional<ResponseCancelledWebhookEvent> =
        Optional.ofNullable(responseCancelled)

    /** Sent when a background response has been completed. */
    fun responseCompleted(): Optional<ResponseCompletedWebhookEvent> =
        Optional.ofNullable(responseCompleted)

    /** Sent when a background response has failed. */
    fun responseFailed(): Optional<ResponseFailedWebhookEvent> = Optional.ofNullable(responseFailed)

    /** Sent when a background response has been interrupted. */
    fun responseIncomplete(): Optional<ResponseIncompleteWebhookEvent> =
        Optional.ofNullable(responseIncomplete)

    fun isBatchCancelled(): Boolean = batchCancelled != null

    fun isBatchCompleted(): Boolean = batchCompleted != null

    fun isBatchExpired(): Boolean = batchExpired != null

    fun isBatchFailed(): Boolean = batchFailed != null

    fun isEvalRunCanceled(): Boolean = evalRunCanceled != null

    fun isEvalRunFailed(): Boolean = evalRunFailed != null

    fun isEvalRunSucceeded(): Boolean = evalRunSucceeded != null

    fun isFineTuningJobCancelled(): Boolean = fineTuningJobCancelled != null

    fun isFineTuningJobFailed(): Boolean = fineTuningJobFailed != null

    fun isFineTuningJobSucceeded(): Boolean = fineTuningJobSucceeded != null

    fun isRealtimeCallIncoming(): Boolean = realtimeCallIncoming != null

    fun isResponseCancelled(): Boolean = responseCancelled != null

    fun isResponseCompleted(): Boolean = responseCompleted != null

    fun isResponseFailed(): Boolean = responseFailed != null

    fun isResponseIncomplete(): Boolean = responseIncomplete != null

    /** Sent when a batch API request has been cancelled. */
    fun asBatchCancelled(): BatchCancelledWebhookEvent = batchCancelled.getOrThrow("batchCancelled")

    /** Sent when a batch API request has been completed. */
    fun asBatchCompleted(): BatchCompletedWebhookEvent = batchCompleted.getOrThrow("batchCompleted")

    /** Sent when a batch API request has expired. */
    fun asBatchExpired(): BatchExpiredWebhookEvent = batchExpired.getOrThrow("batchExpired")

    /** Sent when a batch API request has failed. */
    fun asBatchFailed(): BatchFailedWebhookEvent = batchFailed.getOrThrow("batchFailed")

    /** Sent when an eval run has been canceled. */
    fun asEvalRunCanceled(): EvalRunCanceledWebhookEvent =
        evalRunCanceled.getOrThrow("evalRunCanceled")

    /** Sent when an eval run has failed. */
    fun asEvalRunFailed(): EvalRunFailedWebhookEvent = evalRunFailed.getOrThrow("evalRunFailed")

    /** Sent when an eval run has succeeded. */
    fun asEvalRunSucceeded(): EvalRunSucceededWebhookEvent =
        evalRunSucceeded.getOrThrow("evalRunSucceeded")

    /** Sent when a fine-tuning job has been cancelled. */
    fun asFineTuningJobCancelled(): FineTuningJobCancelledWebhookEvent =
        fineTuningJobCancelled.getOrThrow("fineTuningJobCancelled")

    /** Sent when a fine-tuning job has failed. */
    fun asFineTuningJobFailed(): FineTuningJobFailedWebhookEvent =
        fineTuningJobFailed.getOrThrow("fineTuningJobFailed")

    /** Sent when a fine-tuning job has succeeded. */
    fun asFineTuningJobSucceeded(): FineTuningJobSucceededWebhookEvent =
        fineTuningJobSucceeded.getOrThrow("fineTuningJobSucceeded")

    /** Sent when Realtime API Receives a incoming SIP call. */
    fun asRealtimeCallIncoming(): RealtimeCallIncomingWebhookEvent =
        realtimeCallIncoming.getOrThrow("realtimeCallIncoming")

    /** Sent when a background response has been cancelled. */
    fun asResponseCancelled(): ResponseCancelledWebhookEvent =
        responseCancelled.getOrThrow("responseCancelled")

    /** Sent when a background response has been completed. */
    fun asResponseCompleted(): ResponseCompletedWebhookEvent =
        responseCompleted.getOrThrow("responseCompleted")

    /** Sent when a background response has failed. */
    fun asResponseFailed(): ResponseFailedWebhookEvent = responseFailed.getOrThrow("responseFailed")

    /** Sent when a background response has been interrupted. */
    fun asResponseIncomplete(): ResponseIncompleteWebhookEvent =
        responseIncomplete.getOrThrow("responseIncomplete")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            batchCancelled != null -> visitor.visitBatchCancelled(batchCancelled)
            batchCompleted != null -> visitor.visitBatchCompleted(batchCompleted)
            batchExpired != null -> visitor.visitBatchExpired(batchExpired)
            batchFailed != null -> visitor.visitBatchFailed(batchFailed)
            evalRunCanceled != null -> visitor.visitEvalRunCanceled(evalRunCanceled)
            evalRunFailed != null -> visitor.visitEvalRunFailed(evalRunFailed)
            evalRunSucceeded != null -> visitor.visitEvalRunSucceeded(evalRunSucceeded)
            fineTuningJobCancelled != null ->
                visitor.visitFineTuningJobCancelled(fineTuningJobCancelled)
            fineTuningJobFailed != null -> visitor.visitFineTuningJobFailed(fineTuningJobFailed)
            fineTuningJobSucceeded != null ->
                visitor.visitFineTuningJobSucceeded(fineTuningJobSucceeded)
            realtimeCallIncoming != null -> visitor.visitRealtimeCallIncoming(realtimeCallIncoming)
            responseCancelled != null -> visitor.visitResponseCancelled(responseCancelled)
            responseCompleted != null -> visitor.visitResponseCompleted(responseCompleted)
            responseFailed != null -> visitor.visitResponseFailed(responseFailed)
            responseIncomplete != null -> visitor.visitResponseIncomplete(responseIncomplete)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): UnwrapWebhookEvent = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitBatchCancelled(batchCancelled: BatchCancelledWebhookEvent) {
                    batchCancelled.validate()
                }

                override fun visitBatchCompleted(batchCompleted: BatchCompletedWebhookEvent) {
                    batchCompleted.validate()
                }

                override fun visitBatchExpired(batchExpired: BatchExpiredWebhookEvent) {
                    batchExpired.validate()
                }

                override fun visitBatchFailed(batchFailed: BatchFailedWebhookEvent) {
                    batchFailed.validate()
                }

                override fun visitEvalRunCanceled(evalRunCanceled: EvalRunCanceledWebhookEvent) {
                    evalRunCanceled.validate()
                }

                override fun visitEvalRunFailed(evalRunFailed: EvalRunFailedWebhookEvent) {
                    evalRunFailed.validate()
                }

                override fun visitEvalRunSucceeded(evalRunSucceeded: EvalRunSucceededWebhookEvent) {
                    evalRunSucceeded.validate()
                }

                override fun visitFineTuningJobCancelled(
                    fineTuningJobCancelled: FineTuningJobCancelledWebhookEvent
                ) {
                    fineTuningJobCancelled.validate()
                }

                override fun visitFineTuningJobFailed(
                    fineTuningJobFailed: FineTuningJobFailedWebhookEvent
                ) {
                    fineTuningJobFailed.validate()
                }

                override fun visitFineTuningJobSucceeded(
                    fineTuningJobSucceeded: FineTuningJobSucceededWebhookEvent
                ) {
                    fineTuningJobSucceeded.validate()
                }

                override fun visitRealtimeCallIncoming(
                    realtimeCallIncoming: RealtimeCallIncomingWebhookEvent
                ) {
                    realtimeCallIncoming.validate()
                }

                override fun visitResponseCancelled(
                    responseCancelled: ResponseCancelledWebhookEvent
                ) {
                    responseCancelled.validate()
                }

                override fun visitResponseCompleted(
                    responseCompleted: ResponseCompletedWebhookEvent
                ) {
                    responseCompleted.validate()
                }

                override fun visitResponseFailed(responseFailed: ResponseFailedWebhookEvent) {
                    responseFailed.validate()
                }

                override fun visitResponseIncomplete(
                    responseIncomplete: ResponseIncompleteWebhookEvent
                ) {
                    responseIncomplete.validate()
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
                override fun visitBatchCancelled(batchCancelled: BatchCancelledWebhookEvent) =
                    batchCancelled.validity()

                override fun visitBatchCompleted(batchCompleted: BatchCompletedWebhookEvent) =
                    batchCompleted.validity()

                override fun visitBatchExpired(batchExpired: BatchExpiredWebhookEvent) =
                    batchExpired.validity()

                override fun visitBatchFailed(batchFailed: BatchFailedWebhookEvent) =
                    batchFailed.validity()

                override fun visitEvalRunCanceled(evalRunCanceled: EvalRunCanceledWebhookEvent) =
                    evalRunCanceled.validity()

                override fun visitEvalRunFailed(evalRunFailed: EvalRunFailedWebhookEvent) =
                    evalRunFailed.validity()

                override fun visitEvalRunSucceeded(evalRunSucceeded: EvalRunSucceededWebhookEvent) =
                    evalRunSucceeded.validity()

                override fun visitFineTuningJobCancelled(
                    fineTuningJobCancelled: FineTuningJobCancelledWebhookEvent
                ) = fineTuningJobCancelled.validity()

                override fun visitFineTuningJobFailed(
                    fineTuningJobFailed: FineTuningJobFailedWebhookEvent
                ) = fineTuningJobFailed.validity()

                override fun visitFineTuningJobSucceeded(
                    fineTuningJobSucceeded: FineTuningJobSucceededWebhookEvent
                ) = fineTuningJobSucceeded.validity()

                override fun visitRealtimeCallIncoming(
                    realtimeCallIncoming: RealtimeCallIncomingWebhookEvent
                ) = realtimeCallIncoming.validity()

                override fun visitResponseCancelled(
                    responseCancelled: ResponseCancelledWebhookEvent
                ) = responseCancelled.validity()

                override fun visitResponseCompleted(
                    responseCompleted: ResponseCompletedWebhookEvent
                ) = responseCompleted.validity()

                override fun visitResponseFailed(responseFailed: ResponseFailedWebhookEvent) =
                    responseFailed.validity()

                override fun visitResponseIncomplete(
                    responseIncomplete: ResponseIncompleteWebhookEvent
                ) = responseIncomplete.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UnwrapWebhookEvent &&
            batchCancelled == other.batchCancelled &&
            batchCompleted == other.batchCompleted &&
            batchExpired == other.batchExpired &&
            batchFailed == other.batchFailed &&
            evalRunCanceled == other.evalRunCanceled &&
            evalRunFailed == other.evalRunFailed &&
            evalRunSucceeded == other.evalRunSucceeded &&
            fineTuningJobCancelled == other.fineTuningJobCancelled &&
            fineTuningJobFailed == other.fineTuningJobFailed &&
            fineTuningJobSucceeded == other.fineTuningJobSucceeded &&
            realtimeCallIncoming == other.realtimeCallIncoming &&
            responseCancelled == other.responseCancelled &&
            responseCompleted == other.responseCompleted &&
            responseFailed == other.responseFailed &&
            responseIncomplete == other.responseIncomplete
    }

    override fun hashCode(): Int =
        Objects.hash(
            batchCancelled,
            batchCompleted,
            batchExpired,
            batchFailed,
            evalRunCanceled,
            evalRunFailed,
            evalRunSucceeded,
            fineTuningJobCancelled,
            fineTuningJobFailed,
            fineTuningJobSucceeded,
            realtimeCallIncoming,
            responseCancelled,
            responseCompleted,
            responseFailed,
            responseIncomplete,
        )

    override fun toString(): String =
        when {
            batchCancelled != null -> "UnwrapWebhookEvent{batchCancelled=$batchCancelled}"
            batchCompleted != null -> "UnwrapWebhookEvent{batchCompleted=$batchCompleted}"
            batchExpired != null -> "UnwrapWebhookEvent{batchExpired=$batchExpired}"
            batchFailed != null -> "UnwrapWebhookEvent{batchFailed=$batchFailed}"
            evalRunCanceled != null -> "UnwrapWebhookEvent{evalRunCanceled=$evalRunCanceled}"
            evalRunFailed != null -> "UnwrapWebhookEvent{evalRunFailed=$evalRunFailed}"
            evalRunSucceeded != null -> "UnwrapWebhookEvent{evalRunSucceeded=$evalRunSucceeded}"
            fineTuningJobCancelled != null ->
                "UnwrapWebhookEvent{fineTuningJobCancelled=$fineTuningJobCancelled}"
            fineTuningJobFailed != null ->
                "UnwrapWebhookEvent{fineTuningJobFailed=$fineTuningJobFailed}"
            fineTuningJobSucceeded != null ->
                "UnwrapWebhookEvent{fineTuningJobSucceeded=$fineTuningJobSucceeded}"
            realtimeCallIncoming != null ->
                "UnwrapWebhookEvent{realtimeCallIncoming=$realtimeCallIncoming}"
            responseCancelled != null -> "UnwrapWebhookEvent{responseCancelled=$responseCancelled}"
            responseCompleted != null -> "UnwrapWebhookEvent{responseCompleted=$responseCompleted}"
            responseFailed != null -> "UnwrapWebhookEvent{responseFailed=$responseFailed}"
            responseIncomplete != null ->
                "UnwrapWebhookEvent{responseIncomplete=$responseIncomplete}"
            _json != null -> "UnwrapWebhookEvent{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid UnwrapWebhookEvent")
        }

    companion object {

        /** Sent when a batch API request has been cancelled. */
        @JvmStatic
        fun ofBatchCancelled(batchCancelled: BatchCancelledWebhookEvent) =
            UnwrapWebhookEvent(batchCancelled = batchCancelled)

        /** Sent when a batch API request has been completed. */
        @JvmStatic
        fun ofBatchCompleted(batchCompleted: BatchCompletedWebhookEvent) =
            UnwrapWebhookEvent(batchCompleted = batchCompleted)

        /** Sent when a batch API request has expired. */
        @JvmStatic
        fun ofBatchExpired(batchExpired: BatchExpiredWebhookEvent) =
            UnwrapWebhookEvent(batchExpired = batchExpired)

        /** Sent when a batch API request has failed. */
        @JvmStatic
        fun ofBatchFailed(batchFailed: BatchFailedWebhookEvent) =
            UnwrapWebhookEvent(batchFailed = batchFailed)

        /** Sent when an eval run has been canceled. */
        @JvmStatic
        fun ofEvalRunCanceled(evalRunCanceled: EvalRunCanceledWebhookEvent) =
            UnwrapWebhookEvent(evalRunCanceled = evalRunCanceled)

        /** Sent when an eval run has failed. */
        @JvmStatic
        fun ofEvalRunFailed(evalRunFailed: EvalRunFailedWebhookEvent) =
            UnwrapWebhookEvent(evalRunFailed = evalRunFailed)

        /** Sent when an eval run has succeeded. */
        @JvmStatic
        fun ofEvalRunSucceeded(evalRunSucceeded: EvalRunSucceededWebhookEvent) =
            UnwrapWebhookEvent(evalRunSucceeded = evalRunSucceeded)

        /** Sent when a fine-tuning job has been cancelled. */
        @JvmStatic
        fun ofFineTuningJobCancelled(fineTuningJobCancelled: FineTuningJobCancelledWebhookEvent) =
            UnwrapWebhookEvent(fineTuningJobCancelled = fineTuningJobCancelled)

        /** Sent when a fine-tuning job has failed. */
        @JvmStatic
        fun ofFineTuningJobFailed(fineTuningJobFailed: FineTuningJobFailedWebhookEvent) =
            UnwrapWebhookEvent(fineTuningJobFailed = fineTuningJobFailed)

        /** Sent when a fine-tuning job has succeeded. */
        @JvmStatic
        fun ofFineTuningJobSucceeded(fineTuningJobSucceeded: FineTuningJobSucceededWebhookEvent) =
            UnwrapWebhookEvent(fineTuningJobSucceeded = fineTuningJobSucceeded)

        /** Sent when Realtime API Receives a incoming SIP call. */
        @JvmStatic
        fun ofRealtimeCallIncoming(realtimeCallIncoming: RealtimeCallIncomingWebhookEvent) =
            UnwrapWebhookEvent(realtimeCallIncoming = realtimeCallIncoming)

        /** Sent when a background response has been cancelled. */
        @JvmStatic
        fun ofResponseCancelled(responseCancelled: ResponseCancelledWebhookEvent) =
            UnwrapWebhookEvent(responseCancelled = responseCancelled)

        /** Sent when a background response has been completed. */
        @JvmStatic
        fun ofResponseCompleted(responseCompleted: ResponseCompletedWebhookEvent) =
            UnwrapWebhookEvent(responseCompleted = responseCompleted)

        /** Sent when a background response has failed. */
        @JvmStatic
        fun ofResponseFailed(responseFailed: ResponseFailedWebhookEvent) =
            UnwrapWebhookEvent(responseFailed = responseFailed)

        /** Sent when a background response has been interrupted. */
        @JvmStatic
        fun ofResponseIncomplete(responseIncomplete: ResponseIncompleteWebhookEvent) =
            UnwrapWebhookEvent(responseIncomplete = responseIncomplete)
    }

    /**
     * An interface that defines how to map each variant of [UnwrapWebhookEvent] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /** Sent when a batch API request has been cancelled. */
        fun visitBatchCancelled(batchCancelled: BatchCancelledWebhookEvent): T

        /** Sent when a batch API request has been completed. */
        fun visitBatchCompleted(batchCompleted: BatchCompletedWebhookEvent): T

        /** Sent when a batch API request has expired. */
        fun visitBatchExpired(batchExpired: BatchExpiredWebhookEvent): T

        /** Sent when a batch API request has failed. */
        fun visitBatchFailed(batchFailed: BatchFailedWebhookEvent): T

        /** Sent when an eval run has been canceled. */
        fun visitEvalRunCanceled(evalRunCanceled: EvalRunCanceledWebhookEvent): T

        /** Sent when an eval run has failed. */
        fun visitEvalRunFailed(evalRunFailed: EvalRunFailedWebhookEvent): T

        /** Sent when an eval run has succeeded. */
        fun visitEvalRunSucceeded(evalRunSucceeded: EvalRunSucceededWebhookEvent): T

        /** Sent when a fine-tuning job has been cancelled. */
        fun visitFineTuningJobCancelled(
            fineTuningJobCancelled: FineTuningJobCancelledWebhookEvent
        ): T

        /** Sent when a fine-tuning job has failed. */
        fun visitFineTuningJobFailed(fineTuningJobFailed: FineTuningJobFailedWebhookEvent): T

        /** Sent when a fine-tuning job has succeeded. */
        fun visitFineTuningJobSucceeded(
            fineTuningJobSucceeded: FineTuningJobSucceededWebhookEvent
        ): T

        /** Sent when Realtime API Receives a incoming SIP call. */
        fun visitRealtimeCallIncoming(realtimeCallIncoming: RealtimeCallIncomingWebhookEvent): T

        /** Sent when a background response has been cancelled. */
        fun visitResponseCancelled(responseCancelled: ResponseCancelledWebhookEvent): T

        /** Sent when a background response has been completed. */
        fun visitResponseCompleted(responseCompleted: ResponseCompletedWebhookEvent): T

        /** Sent when a background response has failed. */
        fun visitResponseFailed(responseFailed: ResponseFailedWebhookEvent): T

        /** Sent when a background response has been interrupted. */
        fun visitResponseIncomplete(responseIncomplete: ResponseIncompleteWebhookEvent): T

        /**
         * Maps an unknown variant of [UnwrapWebhookEvent] to a value of type [T].
         *
         * An instance of [UnwrapWebhookEvent] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown UnwrapWebhookEvent: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<UnwrapWebhookEvent>(UnwrapWebhookEvent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): UnwrapWebhookEvent {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "batch.cancelled" -> {
                    return tryDeserialize(node, jacksonTypeRef<BatchCancelledWebhookEvent>())?.let {
                        UnwrapWebhookEvent(batchCancelled = it, _json = json)
                    } ?: UnwrapWebhookEvent(_json = json)
                }
                "batch.completed" -> {
                    return tryDeserialize(node, jacksonTypeRef<BatchCompletedWebhookEvent>())?.let {
                        UnwrapWebhookEvent(batchCompleted = it, _json = json)
                    } ?: UnwrapWebhookEvent(_json = json)
                }
                "batch.expired" -> {
                    return tryDeserialize(node, jacksonTypeRef<BatchExpiredWebhookEvent>())?.let {
                        UnwrapWebhookEvent(batchExpired = it, _json = json)
                    } ?: UnwrapWebhookEvent(_json = json)
                }
                "batch.failed" -> {
                    return tryDeserialize(node, jacksonTypeRef<BatchFailedWebhookEvent>())?.let {
                        UnwrapWebhookEvent(batchFailed = it, _json = json)
                    } ?: UnwrapWebhookEvent(_json = json)
                }
                "eval.run.canceled" -> {
                    return tryDeserialize(node, jacksonTypeRef<EvalRunCanceledWebhookEvent>())
                        ?.let { UnwrapWebhookEvent(evalRunCanceled = it, _json = json) }
                        ?: UnwrapWebhookEvent(_json = json)
                }
                "eval.run.failed" -> {
                    return tryDeserialize(node, jacksonTypeRef<EvalRunFailedWebhookEvent>())?.let {
                        UnwrapWebhookEvent(evalRunFailed = it, _json = json)
                    } ?: UnwrapWebhookEvent(_json = json)
                }
                "eval.run.succeeded" -> {
                    return tryDeserialize(node, jacksonTypeRef<EvalRunSucceededWebhookEvent>())
                        ?.let { UnwrapWebhookEvent(evalRunSucceeded = it, _json = json) }
                        ?: UnwrapWebhookEvent(_json = json)
                }
                "fine_tuning.job.cancelled" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<FineTuningJobCancelledWebhookEvent>(),
                        )
                        ?.let { UnwrapWebhookEvent(fineTuningJobCancelled = it, _json = json) }
                        ?: UnwrapWebhookEvent(_json = json)
                }
                "fine_tuning.job.failed" -> {
                    return tryDeserialize(node, jacksonTypeRef<FineTuningJobFailedWebhookEvent>())
                        ?.let { UnwrapWebhookEvent(fineTuningJobFailed = it, _json = json) }
                        ?: UnwrapWebhookEvent(_json = json)
                }
                "fine_tuning.job.succeeded" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<FineTuningJobSucceededWebhookEvent>(),
                        )
                        ?.let { UnwrapWebhookEvent(fineTuningJobSucceeded = it, _json = json) }
                        ?: UnwrapWebhookEvent(_json = json)
                }
                "realtime.call.incoming" -> {
                    return tryDeserialize(node, jacksonTypeRef<RealtimeCallIncomingWebhookEvent>())
                        ?.let { UnwrapWebhookEvent(realtimeCallIncoming = it, _json = json) }
                        ?: UnwrapWebhookEvent(_json = json)
                }
                "response.cancelled" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseCancelledWebhookEvent>())
                        ?.let { UnwrapWebhookEvent(responseCancelled = it, _json = json) }
                        ?: UnwrapWebhookEvent(_json = json)
                }
                "response.completed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseCompletedWebhookEvent>())
                        ?.let { UnwrapWebhookEvent(responseCompleted = it, _json = json) }
                        ?: UnwrapWebhookEvent(_json = json)
                }
                "response.failed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseFailedWebhookEvent>())?.let {
                        UnwrapWebhookEvent(responseFailed = it, _json = json)
                    } ?: UnwrapWebhookEvent(_json = json)
                }
                "response.incomplete" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseIncompleteWebhookEvent>())
                        ?.let { UnwrapWebhookEvent(responseIncomplete = it, _json = json) }
                        ?: UnwrapWebhookEvent(_json = json)
                }
            }

            return UnwrapWebhookEvent(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<UnwrapWebhookEvent>(UnwrapWebhookEvent::class) {

        override fun serialize(
            value: UnwrapWebhookEvent,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.batchCancelled != null -> generator.writeObject(value.batchCancelled)
                value.batchCompleted != null -> generator.writeObject(value.batchCompleted)
                value.batchExpired != null -> generator.writeObject(value.batchExpired)
                value.batchFailed != null -> generator.writeObject(value.batchFailed)
                value.evalRunCanceled != null -> generator.writeObject(value.evalRunCanceled)
                value.evalRunFailed != null -> generator.writeObject(value.evalRunFailed)
                value.evalRunSucceeded != null -> generator.writeObject(value.evalRunSucceeded)
                value.fineTuningJobCancelled != null ->
                    generator.writeObject(value.fineTuningJobCancelled)
                value.fineTuningJobFailed != null ->
                    generator.writeObject(value.fineTuningJobFailed)
                value.fineTuningJobSucceeded != null ->
                    generator.writeObject(value.fineTuningJobSucceeded)
                value.realtimeCallIncoming != null ->
                    generator.writeObject(value.realtimeCallIncoming)
                value.responseCancelled != null -> generator.writeObject(value.responseCancelled)
                value.responseCompleted != null -> generator.writeObject(value.responseCompleted)
                value.responseFailed != null -> generator.writeObject(value.responseFailed)
                value.responseIncomplete != null -> generator.writeObject(value.responseIncomplete)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid UnwrapWebhookEvent")
            }
        }
    }
}
