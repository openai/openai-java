// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
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

/** Details of the message creation by the run step. */
@NoAutoDetect
class MessageCreationStepDetails
@JsonCreator
private constructor(
    @JsonProperty("message_creation")
    @ExcludeMissing
    private val messageCreation: JsonField<MessageCreation> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun messageCreation(): MessageCreation = messageCreation.getRequired("message_creation")

    /**
     * Always `message_creation`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("message_creation")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [messageCreation].
     *
     * Unlike [messageCreation], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("message_creation")
    @ExcludeMissing
    fun _messageCreation(): JsonField<MessageCreation> = messageCreation

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): MessageCreationStepDetails = apply {
        if (validated) {
            return@apply
        }

        messageCreation().validate()
        _type().let {
            if (it != JsonValue.from("message_creation")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [MessageCreationStepDetails].
         *
         * The following fields are required:
         * ```java
         * .messageCreation()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MessageCreationStepDetails]. */
    class Builder internal constructor() {

        private var messageCreation: JsonField<MessageCreation>? = null
        private var type: JsonValue = JsonValue.from("message_creation")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(messageCreationStepDetails: MessageCreationStepDetails) = apply {
            messageCreation = messageCreationStepDetails.messageCreation
            type = messageCreationStepDetails.type
            additionalProperties = messageCreationStepDetails.additionalProperties.toMutableMap()
        }

        fun messageCreation(messageCreation: MessageCreation) =
            messageCreation(JsonField.of(messageCreation))

        /**
         * Sets [Builder.messageCreation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.messageCreation] with a well-typed [MessageCreation]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun messageCreation(messageCreation: JsonField<MessageCreation>) = apply {
            this.messageCreation = messageCreation
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("message_creation")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

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
         * Returns an immutable instance of [MessageCreationStepDetails].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .messageCreation()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MessageCreationStepDetails =
            MessageCreationStepDetails(
                checkRequired("messageCreation", messageCreation),
                type,
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

        /**
         * The ID of the message that was created by this run step.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun messageId(): String = messageId.getRequired("message_id")

        /**
         * Returns the raw JSON value of [messageId].
         *
         * Unlike [messageId], this method doesn't throw if the JSON field has an unexpected type.
         */
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

            /**
             * Returns a mutable builder for constructing an instance of [MessageCreation].
             *
             * The following fields are required:
             * ```java
             * .messageId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [MessageCreation]. */
        class Builder internal constructor() {

            private var messageId: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(messageCreation: MessageCreation) = apply {
                messageId = messageCreation.messageId
                additionalProperties = messageCreation.additionalProperties.toMutableMap()
            }

            /** The ID of the message that was created by this run step. */
            fun messageId(messageId: String) = messageId(JsonField.of(messageId))

            /**
             * Sets [Builder.messageId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.messageId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
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

            /**
             * Returns an immutable instance of [MessageCreation].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .messageId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): MessageCreation =
                MessageCreation(
                    checkRequired("messageId", messageId),
                    additionalProperties.toImmutable(),
                )
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

        return /* spotless:off */ other is MessageCreationStepDetails && messageCreation == other.messageCreation && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(messageCreation, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MessageCreationStepDetails{messageCreation=$messageCreation, type=$type, additionalProperties=$additionalProperties}"
}
