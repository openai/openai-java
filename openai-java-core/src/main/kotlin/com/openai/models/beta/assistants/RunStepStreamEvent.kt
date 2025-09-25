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
import com.openai.models.beta.threads.runs.steps.RunStep
import com.openai.models.beta.threads.runs.steps.RunStepDeltaEvent
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Occurs when a [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) is
 * created.
 */
@JsonDeserialize(using = RunStepStreamEvent.Deserializer::class)
@JsonSerialize(using = RunStepStreamEvent.Serializer::class)
class RunStepStreamEvent
private constructor(
    private val threadRunStepCreated: ThreadRunStepCreated? = null,
    private val threadRunStepInProgress: ThreadRunStepInProgress? = null,
    private val threadRunStepDelta: ThreadRunStepDelta? = null,
    private val threadRunStepCompleted: ThreadRunStepCompleted? = null,
    private val threadRunStepFailed: ThreadRunStepFailed? = null,
    private val threadRunStepCancelled: ThreadRunStepCancelled? = null,
    private val threadRunStepExpired: ThreadRunStepExpired? = null,
    private val _json: JsonValue? = null,
) {

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

    fun isThreadRunStepCreated(): Boolean = threadRunStepCreated != null

    fun isThreadRunStepInProgress(): Boolean = threadRunStepInProgress != null

    fun isThreadRunStepDelta(): Boolean = threadRunStepDelta != null

    fun isThreadRunStepCompleted(): Boolean = threadRunStepCompleted != null

    fun isThreadRunStepFailed(): Boolean = threadRunStepFailed != null

    fun isThreadRunStepCancelled(): Boolean = threadRunStepCancelled != null

    fun isThreadRunStepExpired(): Boolean = threadRunStepExpired != null

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

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
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
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): RunStepStreamEvent = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
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

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RunStepStreamEvent &&
            threadRunStepCreated == other.threadRunStepCreated &&
            threadRunStepInProgress == other.threadRunStepInProgress &&
            threadRunStepDelta == other.threadRunStepDelta &&
            threadRunStepCompleted == other.threadRunStepCompleted &&
            threadRunStepFailed == other.threadRunStepFailed &&
            threadRunStepCancelled == other.threadRunStepCancelled &&
            threadRunStepExpired == other.threadRunStepExpired
    }

    override fun hashCode(): Int =
        Objects.hash(
            threadRunStepCreated,
            threadRunStepInProgress,
            threadRunStepDelta,
            threadRunStepCompleted,
            threadRunStepFailed,
            threadRunStepCancelled,
            threadRunStepExpired,
        )

    override fun toString(): String =
        when {
            threadRunStepCreated != null ->
                "RunStepStreamEvent{threadRunStepCreated=$threadRunStepCreated}"
            threadRunStepInProgress != null ->
                "RunStepStreamEvent{threadRunStepInProgress=$threadRunStepInProgress}"
            threadRunStepDelta != null ->
                "RunStepStreamEvent{threadRunStepDelta=$threadRunStepDelta}"
            threadRunStepCompleted != null ->
                "RunStepStreamEvent{threadRunStepCompleted=$threadRunStepCompleted}"
            threadRunStepFailed != null ->
                "RunStepStreamEvent{threadRunStepFailed=$threadRunStepFailed}"
            threadRunStepCancelled != null ->
                "RunStepStreamEvent{threadRunStepCancelled=$threadRunStepCancelled}"
            threadRunStepExpired != null ->
                "RunStepStreamEvent{threadRunStepExpired=$threadRunStepExpired}"
            _json != null -> "RunStepStreamEvent{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid RunStepStreamEvent")
        }

    companion object {

        /**
         * Occurs when a
         * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) is
         * created.
         */
        @JvmStatic
        fun ofThreadRunStepCreated(threadRunStepCreated: ThreadRunStepCreated) =
            RunStepStreamEvent(threadRunStepCreated = threadRunStepCreated)

        /**
         * Occurs when a
         * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) moves to
         * an `in_progress` state.
         */
        @JvmStatic
        fun ofThreadRunStepInProgress(threadRunStepInProgress: ThreadRunStepInProgress) =
            RunStepStreamEvent(threadRunStepInProgress = threadRunStepInProgress)

        /**
         * Occurs when parts of a
         * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) are
         * being streamed.
         */
        @JvmStatic
        fun ofThreadRunStepDelta(threadRunStepDelta: ThreadRunStepDelta) =
            RunStepStreamEvent(threadRunStepDelta = threadRunStepDelta)

        /**
         * Occurs when a
         * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) is
         * completed.
         */
        @JvmStatic
        fun ofThreadRunStepCompleted(threadRunStepCompleted: ThreadRunStepCompleted) =
            RunStepStreamEvent(threadRunStepCompleted = threadRunStepCompleted)

        /**
         * Occurs when a
         * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) fails.
         */
        @JvmStatic
        fun ofThreadRunStepFailed(threadRunStepFailed: ThreadRunStepFailed) =
            RunStepStreamEvent(threadRunStepFailed = threadRunStepFailed)

        /**
         * Occurs when a
         * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) is
         * cancelled.
         */
        @JvmStatic
        fun ofThreadRunStepCancelled(threadRunStepCancelled: ThreadRunStepCancelled) =
            RunStepStreamEvent(threadRunStepCancelled = threadRunStepCancelled)

        /**
         * Occurs when a
         * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) expires.
         */
        @JvmStatic
        fun ofThreadRunStepExpired(threadRunStepExpired: ThreadRunStepExpired) =
            RunStepStreamEvent(threadRunStepExpired = threadRunStepExpired)
    }

    /**
     * An interface that defines how to map each variant of [RunStepStreamEvent] to a value of type
     * [T].
     */
    interface Visitor<out T> {

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
         * Maps an unknown variant of [RunStepStreamEvent] to a value of type [T].
         *
         * An instance of [RunStepStreamEvent] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown RunStepStreamEvent: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<RunStepStreamEvent>(RunStepStreamEvent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): RunStepStreamEvent {
            val json = JsonValue.fromJsonNode(node)
            val event = json.asObject().getOrNull()?.get("event")?.asString()?.getOrNull()

            when (event) {
                "thread.run.step.created" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadRunStepCreated>())?.let {
                        RunStepStreamEvent(threadRunStepCreated = it, _json = json)
                    } ?: RunStepStreamEvent(_json = json)
                }
                "thread.run.step.in_progress" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadRunStepInProgress>())?.let {
                        RunStepStreamEvent(threadRunStepInProgress = it, _json = json)
                    } ?: RunStepStreamEvent(_json = json)
                }
                "thread.run.step.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadRunStepDelta>())?.let {
                        RunStepStreamEvent(threadRunStepDelta = it, _json = json)
                    } ?: RunStepStreamEvent(_json = json)
                }
                "thread.run.step.completed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadRunStepCompleted>())?.let {
                        RunStepStreamEvent(threadRunStepCompleted = it, _json = json)
                    } ?: RunStepStreamEvent(_json = json)
                }
                "thread.run.step.failed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadRunStepFailed>())?.let {
                        RunStepStreamEvent(threadRunStepFailed = it, _json = json)
                    } ?: RunStepStreamEvent(_json = json)
                }
                "thread.run.step.cancelled" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadRunStepCancelled>())?.let {
                        RunStepStreamEvent(threadRunStepCancelled = it, _json = json)
                    } ?: RunStepStreamEvent(_json = json)
                }
                "thread.run.step.expired" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadRunStepExpired>())?.let {
                        RunStepStreamEvent(threadRunStepExpired = it, _json = json)
                    } ?: RunStepStreamEvent(_json = json)
                }
            }

            return RunStepStreamEvent(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<RunStepStreamEvent>(RunStepStreamEvent::class) {

        override fun serialize(
            value: RunStepStreamEvent,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
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
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid RunStepStreamEvent")
            }
        }
    }

    /**
     * Occurs when a
     * [run step](https://platform.openai.com/docs/api-reference/run-steps/step-object) is created.
     */
    class ThreadRunStepCreated
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
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
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
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
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
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
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
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
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
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
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
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
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
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
}
