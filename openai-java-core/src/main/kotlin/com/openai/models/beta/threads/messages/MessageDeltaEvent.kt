// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

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

/** Represents a message delta i.e. any changed fields on a message during streaming. */
@NoAutoDetect
class MessageDeltaEvent
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("delta")
    @ExcludeMissing
    private val delta: JsonField<MessageDelta> = JsonMissing.of(),
    @JsonProperty("object") @ExcludeMissing private val object_: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * The identifier of the message, which can be referenced in API endpoints.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The delta containing the fields that have changed on the Message.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun delta(): MessageDelta = delta.getRequired("delta")

    /**
     * The object type, which is always `thread.message.delta`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("thread.message.delta")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [delta].
     *
     * Unlike [delta], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("delta") @ExcludeMissing fun _delta(): JsonField<MessageDelta> = delta

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
        _object_().let {
            if (it != JsonValue.from("thread.message.delta")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [MessageDeltaEvent].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .delta()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MessageDeltaEvent]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var delta: JsonField<MessageDelta>? = null
        private var object_: JsonValue = JsonValue.from("thread.message.delta")
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

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The delta containing the fields that have changed on the Message. */
        fun delta(delta: MessageDelta) = delta(JsonField.of(delta))

        /**
         * Sets [Builder.delta] to an arbitrary JSON value.
         *
         * You should usually call [Builder.delta] with a well-typed [MessageDelta] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun delta(delta: JsonField<MessageDelta>) = apply { this.delta = delta }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("thread.message.delta")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

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
         * Returns an immutable instance of [MessageDeltaEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .delta()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MessageDeltaEvent =
            MessageDeltaEvent(
                checkRequired("id", id),
                checkRequired("delta", delta),
                object_,
                additionalProperties.toImmutable(),
            )
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
