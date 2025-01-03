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
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects

/** Details of the message creation by the run step. */
@NoAutoDetect
class MessageCreationStepDetails
@JsonCreator
private constructor(
    @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
    @JsonProperty("message_creation")
    @ExcludeMissing
    private val messageCreation: JsonField<MessageCreation> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** Always `message_creation`. */
    fun type(): Type = type.getRequired("type")

    fun messageCreation(): MessageCreation = messageCreation.getRequired("message_creation")

    /** Always `message_creation`. */
    @JsonProperty("type") @ExcludeMissing fun _type() = type

    @JsonProperty("message_creation") @ExcludeMissing fun _messageCreation() = messageCreation

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): MessageCreationStepDetails = apply {
        if (!validated) {
            type()
            messageCreation().validate()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var type: JsonField<Type> = JsonMissing.of()
        private var messageCreation: JsonField<MessageCreation> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(messageCreationStepDetails: MessageCreationStepDetails) = apply {
            type = messageCreationStepDetails.type
            messageCreation = messageCreationStepDetails.messageCreation
            additionalProperties = messageCreationStepDetails.additionalProperties.toMutableMap()
        }

        /** Always `message_creation`. */
        fun type(type: Type) = type(JsonField.of(type))

        /** Always `message_creation`. */
        fun type(type: JsonField<Type>) = apply { this.type = type }

        fun messageCreation(messageCreation: MessageCreation) =
            messageCreation(JsonField.of(messageCreation))

        fun messageCreation(messageCreation: JsonField<MessageCreation>) = apply {
            this.messageCreation = messageCreation
        }

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

        fun build(): MessageCreationStepDetails =
            MessageCreationStepDetails(
                type,
                messageCreation,
                additionalProperties.toImmutable(),
            )
    }

    @NoAutoDetect
    class MessageCreation
    @JsonCreator
    private constructor(
        @JsonProperty("message_id")
        @ExcludeMissing
        private val messageId: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The ID of the message that was created by this run step. */
        fun messageId(): String = messageId.getRequired("message_id")

        /** The ID of the message that was created by this run step. */
        @JsonProperty("message_id") @ExcludeMissing fun _messageId() = messageId

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): MessageCreation = apply {
            if (!validated) {
                messageId()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var messageId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(messageCreation: MessageCreation) = apply {
                messageId = messageCreation.messageId
                additionalProperties = messageCreation.additionalProperties.toMutableMap()
            }

            /** The ID of the message that was created by this run step. */
            fun messageId(messageId: String) = messageId(JsonField.of(messageId))

            /** The ID of the message that was created by this run step. */
            fun messageId(messageId: JsonField<String>) = apply { this.messageId = messageId }

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

            fun build(): MessageCreation =
                MessageCreation(messageId, additionalProperties.toImmutable())
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is MessageCreation && messageId == other.messageId && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(messageId, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "MessageCreation{messageId=$messageId, additionalProperties=$additionalProperties}"
    }

    class Type
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val MESSAGE_CREATION = of("message_creation")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            MESSAGE_CREATION,
        }

        enum class Value {
            MESSAGE_CREATION,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                MESSAGE_CREATION -> Value.MESSAGE_CREATION
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                MESSAGE_CREATION -> Known.MESSAGE_CREATION
                else -> throw OpenAIInvalidDataException("Unknown Type: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Type && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MessageCreationStepDetails && type == other.type && messageCreation == other.messageCreation && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(type, messageCreation, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MessageCreationStepDetails{type=$type, messageCreation=$messageCreation, additionalProperties=$additionalProperties}"
}
