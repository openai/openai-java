// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/** Details of the message creation by the run step. */
@NoAutoDetect
class RunStepDeltaMessageDelta
@JsonCreator
private constructor(
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonProperty("message_creation")
    @ExcludeMissing
    private val messageCreation: JsonField<MessageCreation> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** Always `message_creation`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    fun messageCreation(): Optional<MessageCreation> =
        Optional.ofNullable(messageCreation.getNullable("message_creation"))

    @JsonProperty("message_creation")
    @ExcludeMissing
    fun _messageCreation(): JsonField<MessageCreation> = messageCreation

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): RunStepDeltaMessageDelta = apply {
        if (validated) {
            return@apply
        }

        _type().let {
            if (it != JsonValue.from("message_creation")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        messageCreation().ifPresent { it.validate() }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder internal constructor() {

        private var type: JsonValue = JsonValue.from("message_creation")
        private var messageCreation: JsonField<MessageCreation> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(runStepDeltaMessageDelta: RunStepDeltaMessageDelta) = apply {
            type = runStepDeltaMessageDelta.type
            messageCreation = runStepDeltaMessageDelta.messageCreation
            additionalProperties = runStepDeltaMessageDelta.additionalProperties.toMutableMap()
        }

        /** Always `message_creation`. */
        fun type(type: JsonValue) = apply { this.type = type }

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

        fun build(): RunStepDeltaMessageDelta =
            RunStepDeltaMessageDelta(
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
        fun messageId(): Optional<String> = Optional.ofNullable(messageId.getNullable("message_id"))

        /** The ID of the message that was created by this run step. */
        @JsonProperty("message_id") @ExcludeMissing fun _messageId(): JsonField<String> = messageId

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): MessageCreation = apply {
            if (validated) {
                return@apply
            }

            messageId()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder internal constructor() {

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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is RunStepDeltaMessageDelta && type == other.type && messageCreation == other.messageCreation && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(type, messageCreation, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RunStepDeltaMessageDelta{type=$type, messageCreation=$messageCreation, additionalProperties=$additionalProperties}"
}
