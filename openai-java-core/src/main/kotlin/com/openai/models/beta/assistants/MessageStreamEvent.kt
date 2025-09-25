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
import com.openai.models.beta.threads.messages.Message
import com.openai.models.beta.threads.messages.MessageDeltaEvent
import java.util.Collections
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

    fun <T> accept(visitor: Visitor<T>): T =
        when {
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

    private var validated: Boolean = false

    fun validate(): MessageStreamEvent = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
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

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MessageStreamEvent &&
            threadMessageCreated == other.threadMessageCreated &&
            threadMessageInProgress == other.threadMessageInProgress &&
            threadMessageDelta == other.threadMessageDelta &&
            threadMessageCompleted == other.threadMessageCompleted &&
            threadMessageIncomplete == other.threadMessageIncomplete
    }

    override fun hashCode(): Int =
        Objects.hash(
            threadMessageCreated,
            threadMessageInProgress,
            threadMessageDelta,
            threadMessageCompleted,
            threadMessageIncomplete,
        )

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

    /**
     * An interface that defines how to map each variant of [MessageStreamEvent] to a value of type
     * [T].
     */
    interface Visitor<out T> {

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
         * Maps an unknown variant of [MessageStreamEvent] to a value of type [T].
         *
         * An instance of [MessageStreamEvent] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown MessageStreamEvent: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<MessageStreamEvent>(MessageStreamEvent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): MessageStreamEvent {
            val json = JsonValue.fromJsonNode(node)
            val event = json.asObject().getOrNull()?.get("event")?.asString()?.getOrNull()

            when (event) {
                "thread.message.created" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadMessageCreated>())?.let {
                        MessageStreamEvent(threadMessageCreated = it, _json = json)
                    } ?: MessageStreamEvent(_json = json)
                }
                "thread.message.in_progress" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadMessageInProgress>())?.let {
                        MessageStreamEvent(threadMessageInProgress = it, _json = json)
                    } ?: MessageStreamEvent(_json = json)
                }
                "thread.message.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadMessageDelta>())?.let {
                        MessageStreamEvent(threadMessageDelta = it, _json = json)
                    } ?: MessageStreamEvent(_json = json)
                }
                "thread.message.completed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadMessageCompleted>())?.let {
                        MessageStreamEvent(threadMessageCompleted = it, _json = json)
                    } ?: MessageStreamEvent(_json = json)
                }
                "thread.message.incomplete" -> {
                    return tryDeserialize(node, jacksonTypeRef<ThreadMessageIncomplete>())?.let {
                        MessageStreamEvent(threadMessageIncomplete = it, _json = json)
                    } ?: MessageStreamEvent(_json = json)
                }
            }

            return MessageStreamEvent(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<MessageStreamEvent>(MessageStreamEvent::class) {

        override fun serialize(
            value: MessageStreamEvent,
            generator: JsonGenerator,
            provider: SerializerProvider,
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
    class ThreadMessageCreated
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
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
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
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
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
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
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
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
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
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
}
