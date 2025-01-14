// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.checkRequired
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects

/** Represents a message delta i.e. any changed fields on a message during streaming. */
@NoAutoDetect
class MessageDeltaEvent
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("delta")
    @ExcludeMissing
    private val delta: JsonField<MessageDelta> = JsonMissing.of(),
    @JsonProperty("object")
    @ExcludeMissing
    private val object_: JsonField<Object> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The identifier of the message, which can be referenced in API endpoints. */
    fun id(): String = id.getRequired("id")

    /** The delta containing the fields that have changed on the Message. */
    fun delta(): MessageDelta = delta.getRequired("delta")

    /** The object type, which is always `thread.message.delta`. */
    fun object_(): Object = object_.getRequired("object")

    /** The identifier of the message, which can be referenced in API endpoints. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** The delta containing the fields that have changed on the Message. */
    @JsonProperty("delta") @ExcludeMissing fun _delta(): JsonField<MessageDelta> = delta

    /** The object type, which is always `thread.message.delta`. */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<Object> = object_

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): MessageDeltaEvent = apply {
        if (validated) {
            return@apply
        }

        id()
        delta().validate()
        object_()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String>? = null
        private var delta: JsonField<MessageDelta>? = null
        private var object_: JsonField<Object>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(messageDeltaEvent: MessageDeltaEvent) = apply {
            id = messageDeltaEvent.id
            delta = messageDeltaEvent.delta
            object_ = messageDeltaEvent.object_
            additionalProperties = messageDeltaEvent.additionalProperties.toMutableMap()
        }

        /** The identifier of the message, which can be referenced in API endpoints. */
        fun id(id: String) = id(JsonField.of(id))

        /** The identifier of the message, which can be referenced in API endpoints. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The delta containing the fields that have changed on the Message. */
        fun delta(delta: MessageDelta) = delta(JsonField.of(delta))

        /** The delta containing the fields that have changed on the Message. */
        fun delta(delta: JsonField<MessageDelta>) = apply { this.delta = delta }

        /** The object type, which is always `thread.message.delta`. */
        fun object_(object_: Object) = object_(JsonField.of(object_))

        /** The object type, which is always `thread.message.delta`. */
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

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

        fun build(): MessageDeltaEvent =
            MessageDeltaEvent(
                checkRequired("id", id),
                checkRequired("delta", delta),
                checkRequired("object_", object_),
                additionalProperties.toImmutable(),
            )
    }

    class Object
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val THREAD_MESSAGE_DELTA = of("thread.message.delta")

            @JvmStatic fun of(value: String) = Object(JsonField.of(value))
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
                else -> throw OpenAIInvalidDataException("Unknown Object: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Object && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MessageDeltaEvent && id == other.id && delta == other.delta && object_ == other.object_ && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, delta, object_, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MessageDeltaEvent{id=$id, delta=$delta, object_=$object_, additionalProperties=$additionalProperties}"
}
