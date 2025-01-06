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

    private var validated: Boolean = false

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

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
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
    }

    fun validate(): RunStreamEvent = apply {
        if (!validated) {
            if (
                threadRunCreated == null &&
                    threadRunQueued == null &&
                    threadRunInProgress == null &&
                    threadRunRequiresAction == null &&
                    threadRunCompleted == null &&
                    threadRunIncomplete == null &&
                    threadRunFailed == null &&
                    threadRunCancelling == null &&
                    threadRunCancelled == null &&
                    threadRunExpired == null
            ) {
                throw OpenAIInvalidDataException("Unknown RunStreamEvent: $_json")
            }
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
            validated = true
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is RunStreamEvent && threadRunCreated == other.threadRunCreated && threadRunQueued == other.threadRunQueued && threadRunInProgress == other.threadRunInProgress && threadRunRequiresAction == other.threadRunRequiresAction && threadRunCompleted == other.threadRunCompleted && threadRunIncomplete == other.threadRunIncomplete && threadRunFailed == other.threadRunFailed && threadRunCancelling == other.threadRunCancelling && threadRunCancelled == other.threadRunCancelled && threadRunExpired == other.threadRunExpired /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(threadRunCreated, threadRunQueued, threadRunInProgress, threadRunRequiresAction, threadRunCompleted, threadRunIncomplete, threadRunFailed, threadRunCancelling, threadRunCancelled, threadRunExpired) /* spotless:on */

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

    interface Visitor<out T> {

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

        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown RunStreamEvent: $json")
        }
    }

    class Deserializer : BaseDeserializer<RunStreamEvent>(RunStreamEvent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): RunStreamEvent {
            val json = JsonValue.fromJsonNode(node)
            val event = json.asObject().getOrNull()?.get("event")?.asString()?.getOrNull()

            when (event) {
                "thread.run.created" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadRunCreated>()) { it.validate() }
                        ?.let {
                            return RunStreamEvent(threadRunCreated = it, _json = json)
                        }
                }
                "thread.run.queued" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadRunQueued>()) { it.validate() }
                        ?.let {
                            return RunStreamEvent(threadRunQueued = it, _json = json)
                        }
                }
                "thread.run.in_progress" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadRunInProgress>()) { it.validate() }
                        ?.let {
                            return RunStreamEvent(threadRunInProgress = it, _json = json)
                        }
                }
                "thread.run.requires_action" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadRunRequiresAction>()) {
                            it.validate()
                        }
                        ?.let {
                            return RunStreamEvent(threadRunRequiresAction = it, _json = json)
                        }
                }
                "thread.run.completed" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadRunCompleted>()) { it.validate() }
                        ?.let {
                            return RunStreamEvent(threadRunCompleted = it, _json = json)
                        }
                }
                "thread.run.incomplete" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadRunIncomplete>()) { it.validate() }
                        ?.let {
                            return RunStreamEvent(threadRunIncomplete = it, _json = json)
                        }
                }
                "thread.run.failed" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadRunFailed>()) { it.validate() }
                        ?.let {
                            return RunStreamEvent(threadRunFailed = it, _json = json)
                        }
                }
                "thread.run.cancelling" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadRunCancelling>()) { it.validate() }
                        ?.let {
                            return RunStreamEvent(threadRunCancelling = it, _json = json)
                        }
                }
                "thread.run.cancelled" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadRunCancelled>()) { it.validate() }
                        ?.let {
                            return RunStreamEvent(threadRunCancelled = it, _json = json)
                        }
                }
                "thread.run.expired" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadRunExpired>()) { it.validate() }
                        ?.let {
                            return RunStreamEvent(threadRunExpired = it, _json = json)
                        }
                }
            }

            return RunStreamEvent(_json = json)
        }
    }

    class Serializer : BaseSerializer<RunStreamEvent>(RunStreamEvent::class) {

        override fun serialize(
            value: RunStreamEvent,
            generator: JsonGenerator,
            provider: SerializerProvider
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
    @NoAutoDetect
    class ThreadRunCreated
    @JsonCreator
    private constructor(
        @JsonProperty("data") @ExcludeMissing private val data: JsonField<Run> = JsonMissing.of(),
        @JsonProperty("event")
        @ExcludeMissing
        private val event: JsonField<Event> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Run = data.getRequired("data")

        fun event(): Event = event.getRequired("event")

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonProperty("event") @ExcludeMissing fun _event() = event

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunCreated = apply {
            if (!validated) {
                data().validate()
                event()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var data: JsonField<Run> = JsonMissing.of()
            private var event: JsonField<Event> = JsonMissing.of()
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

            fun event(event: Event) = event(JsonField.of(event))

            fun event(event: JsonField<Event>) = apply { this.event = event }

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
                    data,
                    event,
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
        @JsonProperty("event")
        @ExcludeMissing
        private val event: JsonField<Event> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Run = data.getRequired("data")

        fun event(): Event = event.getRequired("event")

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonProperty("event") @ExcludeMissing fun _event() = event

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunQueued = apply {
            if (!validated) {
                data().validate()
                event()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var data: JsonField<Run> = JsonMissing.of()
            private var event: JsonField<Event> = JsonMissing.of()
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

            fun event(event: Event) = event(JsonField.of(event))

            fun event(event: JsonField<Event>) = apply { this.event = event }

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
                    data,
                    event,
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
        @JsonProperty("event")
        @ExcludeMissing
        private val event: JsonField<Event> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Run = data.getRequired("data")

        fun event(): Event = event.getRequired("event")

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonProperty("event") @ExcludeMissing fun _event() = event

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunInProgress = apply {
            if (!validated) {
                data().validate()
                event()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var data: JsonField<Run> = JsonMissing.of()
            private var event: JsonField<Event> = JsonMissing.of()
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

            fun event(event: Event) = event(JsonField.of(event))

            fun event(event: JsonField<Event>) = apply { this.event = event }

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
                    data,
                    event,
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
        @JsonProperty("event")
        @ExcludeMissing
        private val event: JsonField<Event> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Run = data.getRequired("data")

        fun event(): Event = event.getRequired("event")

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonProperty("event") @ExcludeMissing fun _event() = event

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunRequiresAction = apply {
            if (!validated) {
                data().validate()
                event()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var data: JsonField<Run> = JsonMissing.of()
            private var event: JsonField<Event> = JsonMissing.of()
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

            fun event(event: Event) = event(JsonField.of(event))

            fun event(event: JsonField<Event>) = apply { this.event = event }

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
                    data,
                    event,
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
        @JsonProperty("event")
        @ExcludeMissing
        private val event: JsonField<Event> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Run = data.getRequired("data")

        fun event(): Event = event.getRequired("event")

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonProperty("event") @ExcludeMissing fun _event() = event

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunCompleted = apply {
            if (!validated) {
                data().validate()
                event()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var data: JsonField<Run> = JsonMissing.of()
            private var event: JsonField<Event> = JsonMissing.of()
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

            fun event(event: Event) = event(JsonField.of(event))

            fun event(event: JsonField<Event>) = apply { this.event = event }

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
                    data,
                    event,
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
        @JsonProperty("event")
        @ExcludeMissing
        private val event: JsonField<Event> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Run = data.getRequired("data")

        fun event(): Event = event.getRequired("event")

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonProperty("event") @ExcludeMissing fun _event() = event

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunIncomplete = apply {
            if (!validated) {
                data().validate()
                event()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var data: JsonField<Run> = JsonMissing.of()
            private var event: JsonField<Event> = JsonMissing.of()
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

            fun event(event: Event) = event(JsonField.of(event))

            fun event(event: JsonField<Event>) = apply { this.event = event }

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
                    data,
                    event,
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
        @JsonProperty("event")
        @ExcludeMissing
        private val event: JsonField<Event> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Run = data.getRequired("data")

        fun event(): Event = event.getRequired("event")

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonProperty("event") @ExcludeMissing fun _event() = event

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunFailed = apply {
            if (!validated) {
                data().validate()
                event()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var data: JsonField<Run> = JsonMissing.of()
            private var event: JsonField<Event> = JsonMissing.of()
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

            fun event(event: Event) = event(JsonField.of(event))

            fun event(event: JsonField<Event>) = apply { this.event = event }

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
                    data,
                    event,
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
        @JsonProperty("event")
        @ExcludeMissing
        private val event: JsonField<Event> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Run = data.getRequired("data")

        fun event(): Event = event.getRequired("event")

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonProperty("event") @ExcludeMissing fun _event() = event

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunCancelling = apply {
            if (!validated) {
                data().validate()
                event()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var data: JsonField<Run> = JsonMissing.of()
            private var event: JsonField<Event> = JsonMissing.of()
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

            fun event(event: Event) = event(JsonField.of(event))

            fun event(event: JsonField<Event>) = apply { this.event = event }

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
                    data,
                    event,
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
        @JsonProperty("event")
        @ExcludeMissing
        private val event: JsonField<Event> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Run = data.getRequired("data")

        fun event(): Event = event.getRequired("event")

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonProperty("event") @ExcludeMissing fun _event() = event

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunCancelled = apply {
            if (!validated) {
                data().validate()
                event()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var data: JsonField<Run> = JsonMissing.of()
            private var event: JsonField<Event> = JsonMissing.of()
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

            fun event(event: Event) = event(JsonField.of(event))

            fun event(event: JsonField<Event>) = apply { this.event = event }

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
                    data,
                    event,
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
        @JsonProperty("event")
        @ExcludeMissing
        private val event: JsonField<Event> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        fun data(): Run = data.getRequired("data")

        fun event(): Event = event.getRequired("event")

        /**
         * Represents an execution run on a
         * [thread](https://platform.openai.com/docs/api-reference/threads).
         */
        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonProperty("event") @ExcludeMissing fun _event() = event

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ThreadRunExpired = apply {
            if (!validated) {
                data().validate()
                event()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var data: JsonField<Run> = JsonMissing.of()
            private var event: JsonField<Event> = JsonMissing.of()
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

            fun event(event: Event) = event(JsonField.of(event))

            fun event(event: JsonField<Event>) = apply { this.event = event }

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
                    data,
                    event,
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

            return /* spotless:off */ other is ThreadRunExpired && data == other.data && event == other.event && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(data, event, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ThreadRunExpired{data=$data, event=$event, additionalProperties=$additionalProperties}"
    }
}
