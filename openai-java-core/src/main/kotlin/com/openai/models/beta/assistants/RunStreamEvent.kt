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
import com.openai.models.beta.threads.runs.Run
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Occurs when a new [run](https://platform.openai.com/docs/api-reference/runs/object) is created.
 */
@JsonDeserialize(using = RunStreamEvent.Deserializer::class)
@JsonSerialize(using = RunStreamEvent.Serializer::class)
class RunStreamEvent
private constructor(
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
    private val _json: JsonValue? = null,
) {

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

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
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
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): RunStreamEvent = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
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

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RunStreamEvent &&
            threadRunCreated == other.threadRunCreated &&
            threadRunQueued == other.threadRunQueued &&
            threadRunInProgress == other.threadRunInProgress &&
            threadRunRequiresAction == other.threadRunRequiresAction &&
            threadRunCompleted == other.threadRunCompleted &&
            threadRunIncomplete == other.threadRunIncomplete &&
            threadRunFailed == other.threadRunFailed &&
            threadRunCancelling == other.threadRunCancelling &&
            threadRunCancelled == other.threadRunCancelled &&
            threadRunExpired == other.threadRunExpired
    }

    override fun hashCode(): Int =
        Objects.hash(
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
        )

    override fun toString(): String =
        when {
            threadRunCreated != null -> "RunStreamEvent{threadRunCreated=$threadRunCreated}"
            threadRunQueued != null -> "RunStreamEvent{threadRunQueued=$threadRunQueued}"
            threadRunInProgress != null ->
                "RunStreamEvent{threadRunInProgress=$threadRunInProgress}"
            threadRunRequiresAction != null ->
                "RunStreamEvent{threadRunRequiresAction=$threadRunRequiresAction}"
            threadRunCompleted != null -> "RunStreamEvent{threadRunCompleted=$threadRunCompleted}"
            threadRunIncomplete != null ->
                "RunStreamEvent{threadRunIncomplete=$threadRunIncomplete}"
            threadRunFailed != null -> "RunStreamEvent{threadRunFailed=$threadRunFailed}"
            threadRunCancelling != null ->
                "RunStreamEvent{threadRunCancelling=$threadRunCancelling}"
            threadRunCancelled != null -> "RunStreamEvent{threadRunCancelled=$threadRunCancelled}"
            threadRunExpired != null -> "RunStreamEvent{threadRunExpired=$threadRunExpired}"
            _json != null -> "RunStreamEvent{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid RunStreamEvent")
        }

    companion object {

        /**
         * Occurs when a new [run](https://platform.openai.com/docs/api-reference/runs/object) is
         * created.
         */
        @JvmStatic
        fun ofThreadRunCreated(threadRunCreated: ThreadRunCreated) =
            RunStreamEvent(threadRunCreated = threadRunCreated)

        /**
         * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) moves to
         * a `queued` status.
         */
        @JvmStatic
        fun ofThreadRunQueued(threadRunQueued: ThreadRunQueued) =
            RunStreamEvent(threadRunQueued = threadRunQueued)

        /**
         * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) moves to
         * an `in_progress` status.
         */
        @JvmStatic
        fun ofThreadRunInProgress(threadRunInProgress: ThreadRunInProgress) =
            RunStreamEvent(threadRunInProgress = threadRunInProgress)

        /**
         * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) moves to
         * a `requires_action` status.
         */
        @JvmStatic
        fun ofThreadRunRequiresAction(threadRunRequiresAction: ThreadRunRequiresAction) =
            RunStreamEvent(threadRunRequiresAction = threadRunRequiresAction)

        /**
         * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) is
         * completed.
         */
        @JvmStatic
        fun ofThreadRunCompleted(threadRunCompleted: ThreadRunCompleted) =
            RunStreamEvent(threadRunCompleted = threadRunCompleted)

        /**
         * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) ends with
         * status `incomplete`.
         */
        @JvmStatic
        fun ofThreadRunIncomplete(threadRunIncomplete: ThreadRunIncomplete) =
            RunStreamEvent(threadRunIncomplete = threadRunIncomplete)

        /**
         * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) fails.
         */
        @JvmStatic
        fun ofThreadRunFailed(threadRunFailed: ThreadRunFailed) =
            RunStreamEvent(threadRunFailed = threadRunFailed)

        /**
         * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) moves to
         * a `cancelling` status.
         */
        @JvmStatic
        fun ofThreadRunCancelling(threadRunCancelling: ThreadRunCancelling) =
            RunStreamEvent(threadRunCancelling = threadRunCancelling)

        /**
         * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) is
         * cancelled.
         */
        @JvmStatic
        fun ofThreadRunCancelled(threadRunCancelled: ThreadRunCancelled) =
            RunStreamEvent(threadRunCancelled = threadRunCancelled)

        /**
         * Occurs when a [run](https://platform.openai.com/docs/api-reference/runs/object) expires.
         */
        @JvmStatic
        fun ofThreadRunExpired(threadRunExpired: ThreadRunExpired) =
            RunStreamEvent(threadRunExpired = threadRunExpired)
    }

    /**
     * An interface that defines how to map each variant of [RunStreamEvent] to a value of type [T].
     */
    interface Visitor<out T> {

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
         * Maps an unknown variant of [RunStreamEvent] to a value of type [T].
         *
         * An instance of [RunStreamEvent] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown RunStreamEvent: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<RunStreamEvent>(RunStreamEvent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): RunStreamEvent {
            val json = JsonValue.fromJsonNode(node)
            val event = json.asObject().getOrNull()?.get("event")?.asString()?.getOrNull()

            when (event) {
                "thread.run.created" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadRunCreated>())?.let {
                        RunStreamEvent(threadRunCreated = it, _json = json)
                    } ?: RunStreamEvent(_json = json)
                }
                "thread.run.queued" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadRunQueued>())?.let {
                        RunStreamEvent(threadRunQueued = it, _json = json)
                    } ?: RunStreamEvent(_json = json)
                }
                "thread.run.in_progress" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadRunInProgress>())?.let {
                        RunStreamEvent(threadRunInProgress = it, _json = json)
                    } ?: RunStreamEvent(_json = json)
                }
                "thread.run.requires_action" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadRunRequiresAction>())?.let {
                        RunStreamEvent(threadRunRequiresAction = it, _json = json)
                    } ?: RunStreamEvent(_json = json)
                }
                "thread.run.completed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadRunCompleted>())?.let {
                        RunStreamEvent(threadRunCompleted = it, _json = json)
                    } ?: RunStreamEvent(_json = json)
                }
                "thread.run.incomplete" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadRunIncomplete>())?.let {
                        RunStreamEvent(threadRunIncomplete = it, _json = json)
                    } ?: RunStreamEvent(_json = json)
                }
                "thread.run.failed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadRunFailed>())?.let {
                        RunStreamEvent(threadRunFailed = it, _json = json)
                    } ?: RunStreamEvent(_json = json)
                }
                "thread.run.cancelling" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadRunCancelling>())?.let {
                        RunStreamEvent(threadRunCancelling = it, _json = json)
                    } ?: RunStreamEvent(_json = json)
                }
                "thread.run.cancelled" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadRunCancelled>())?.let {
                        RunStreamEvent(threadRunCancelled = it, _json = json)
                    } ?: RunStreamEvent(_json = json)
                }
                "thread.run.expired" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadRunExpired>())?.let {
                        RunStreamEvent(threadRunExpired = it, _json = json)
                    } ?: RunStreamEvent(_json = json)
                }
            }

            return RunStreamEvent(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<RunStreamEvent>(RunStreamEvent::class) {

        override fun serialize(
            value: RunStreamEvent,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
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
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid RunStreamEvent")
            }
        }
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
}
