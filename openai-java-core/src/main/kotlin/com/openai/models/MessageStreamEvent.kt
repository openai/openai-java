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
 * Occurs when a [message](https://platform.openai.com/docs/api-reference/messages/object) is
 * created.
 */
@JsonDeserialize(using = MessageStreamEvent.Deserializer::class)
@JsonSerialize(using = MessageStreamEvent.Serializer::class)
class MessageStreamEvent
private constructor(
    private val threadMessageCreated: ThreadMessageCreated? = null,
    private val threadMessageInProgress: ThreadMessageInProgress? = null,
    private val threadMessageDelta: ThreadMessageDelta? = null,
    private val threadMessageCompleted: ThreadMessageCompleted? = null,
    private val threadMessageIncomplete: ThreadMessageIncomplete? = null,
    private val _json: JsonValue? = null,
) {

    private var validated: Boolean = false

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

    fun isThreadMessageCreated(): Boolean = threadMessageCreated != null

    fun isThreadMessageInProgress(): Boolean = threadMessageInProgress != null

    fun isThreadMessageDelta(): Boolean = threadMessageDelta != null

    fun isThreadMessageCompleted(): Boolean = threadMessageCompleted != null

    fun isThreadMessageIncomplete(): Boolean = threadMessageIncomplete != null

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

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            threadMessageCreated != null -> visitor.visitThreadMessageCreated(threadMessageCreated)
            threadMessageInProgress != null ->
                visitor.visitThreadMessageInProgress(threadMessageInProgress)
            threadMessageDelta != null -> visitor.visitThreadMessageDelta(threadMessageDelta)
            threadMessageCompleted != null ->
                visitor.visitThreadMessageCompleted(threadMessageCompleted)
            threadMessageIncomplete != null ->
                visitor.visitThreadMessageIncomplete(threadMessageIncomplete)
            else -> visitor.unknown(_json)
        }
    }

    fun validate(): MessageStreamEvent = apply {
        if (!validated) {
            if (
                threadMessageCreated == null &&
                    threadMessageInProgress == null &&
                    threadMessageDelta == null &&
                    threadMessageCompleted == null &&
                    threadMessageIncomplete == null
            ) {
                throw OpenAIInvalidDataException("Unknown MessageStreamEvent: $_json")
            }
            threadMessageCreated?.validate()
            threadMessageInProgress?.validate()
            threadMessageDelta?.validate()
            threadMessageCompleted?.validate()
            threadMessageIncomplete?.validate()
            validated = true
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MessageStreamEvent && threadMessageCreated == other.threadMessageCreated && threadMessageInProgress == other.threadMessageInProgress && threadMessageDelta == other.threadMessageDelta && threadMessageCompleted == other.threadMessageCompleted && threadMessageIncomplete == other.threadMessageIncomplete /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(threadMessageCreated, threadMessageInProgress, threadMessageDelta, threadMessageCompleted, threadMessageIncomplete) /* spotless:on */

    override fun toString(): String =
        when {
            threadMessageCreated != null ->
                "MessageStreamEvent{threadMessageCreated=$threadMessageCreated}"
            threadMessageInProgress != null ->
                "MessageStreamEvent{threadMessageInProgress=$threadMessageInProgress}"
            threadMessageDelta != null ->
                "MessageStreamEvent{threadMessageDelta=$threadMessageDelta}"
            threadMessageCompleted != null ->
                "MessageStreamEvent{threadMessageCompleted=$threadMessageCompleted}"
            threadMessageIncomplete != null ->
                "MessageStreamEvent{threadMessageIncomplete=$threadMessageIncomplete}"
            _json != null -> "MessageStreamEvent{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid MessageStreamEvent")
        }

    companion object {

        /**
         * Occurs when a [message](https://platform.openai.com/docs/api-reference/messages/object)
         * is created.
         */
        @JvmStatic
        fun ofThreadMessageCreated(threadMessageCreated: ThreadMessageCreated) =
            MessageStreamEvent(threadMessageCreated = threadMessageCreated)

        /**
         * Occurs when a [message](https://platform.openai.com/docs/api-reference/messages/object)
         * moves to an `in_progress` state.
         */
        @JvmStatic
        fun ofThreadMessageInProgress(threadMessageInProgress: ThreadMessageInProgress) =
            MessageStreamEvent(threadMessageInProgress = threadMessageInProgress)

        /**
         * Occurs when parts of a
         * [Message](https://platform.openai.com/docs/api-reference/messages/object) are being
         * streamed.
         */
        @JvmStatic
        fun ofThreadMessageDelta(threadMessageDelta: ThreadMessageDelta) =
            MessageStreamEvent(threadMessageDelta = threadMessageDelta)

        /**
         * Occurs when a [message](https://platform.openai.com/docs/api-reference/messages/object)
         * is completed.
         */
        @JvmStatic
        fun ofThreadMessageCompleted(threadMessageCompleted: ThreadMessageCompleted) =
            MessageStreamEvent(threadMessageCompleted = threadMessageCompleted)

        /**
         * Occurs when a [message](https://platform.openai.com/docs/api-reference/messages/object)
         * ends before it is completed.
         */
        @JvmStatic
        fun ofThreadMessageIncomplete(threadMessageIncomplete: ThreadMessageIncomplete) =
            MessageStreamEvent(threadMessageIncomplete = threadMessageIncomplete)
    }

    interface Visitor<out T> {

        fun visitThreadMessageCreated(threadMessageCreated: ThreadMessageCreated): T

        fun visitThreadMessageInProgress(threadMessageInProgress: ThreadMessageInProgress): T

        fun visitThreadMessageDelta(threadMessageDelta: ThreadMessageDelta): T

        fun visitThreadMessageCompleted(threadMessageCompleted: ThreadMessageCompleted): T

        fun visitThreadMessageIncomplete(threadMessageIncomplete: ThreadMessageIncomplete): T

        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown MessageStreamEvent: $json")
        }
    }

    class Deserializer : BaseDeserializer<MessageStreamEvent>(MessageStreamEvent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): MessageStreamEvent {
            val json = JsonValue.fromJsonNode(node)
            val event = json.asObject().getOrNull()?.get("event")?.asString()?.getOrNull()

            when (event) {
                "thread.message.created" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadMessageCreated>()) { it.validate() }
                        ?.let {
                            return MessageStreamEvent(threadMessageCreated = it, _json = json)
                        }
                }
                "thread.message.in_progress" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadMessageInProgress>()) {
                            it.validate()
                        }
                        ?.let {
                            return MessageStreamEvent(threadMessageInProgress = it, _json = json)
                        }
                }
                "thread.message.delta" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadMessageDelta>()) { it.validate() }
                        ?.let {
                            return MessageStreamEvent(threadMessageDelta = it, _json = json)
                        }
                }
                "thread.message.completed" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadMessageCompleted>()) { it.validate() }
                        ?.let {
                            return MessageStreamEvent(threadMessageCompleted = it, _json = json)
                        }
                }
                "thread.message.incomplete" -> {
                    tryDeserialize(node, jacksonTypeRef<ThreadMessageIncomplete>()) {
                            it.validate()
                        }
                        ?.let {
                            return MessageStreamEvent(threadMessageIncomplete = it, _json = json)
                        }
                }
            }

            return MessageStreamEvent(_json = json)
        }
    }

    class Serializer : BaseSerializer<MessageStreamEvent>(MessageStreamEvent::class) {

        override fun serialize(
            value: MessageStreamEvent,
            generator: JsonGenerator,
            provider: SerializerProvider
        ) {
            when {
                value.threadMessageCreated != null ->
                    generator.writeObject(value.threadMessageCreated)
                value.threadMessageInProgress != null ->
                    generator.writeObject(value.threadMessageInProgress)
                value.threadMessageDelta != null -> generator.writeObject(value.threadMessageDelta)
                value.threadMessageCompleted != null ->
                    generator.writeObject(value.threadMessageCompleted)
                value.threadMessageIncomplete != null ->
                    generator.writeObject(value.threadMessageIncomplete)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid MessageStreamEvent")
            }
        }
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
}
