// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

/** A Live server event selector for the WebRTC frontend data channel. */
class ServerEventSelector
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val type: JsonField<String>,
    private val responseEvent: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
        @JsonProperty("response_event")
        @ExcludeMissing
        responseEvent: JsonField<String> = JsonMissing.of(),
    ) : this(type, responseEvent, mutableMapOf())

    /**
     * The outer Live server event type. Use 'response.event' for Responses events.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun type(): String = type.getRequired("type")

    /**
     * The nested Responses event type. Required when type is 'response.event'; forbidden for other
     * event types.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun responseEvent(): Optional<String> = responseEvent.getOptional("response_event")

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

    /**
     * Returns the raw JSON value of [responseEvent].
     *
     * Unlike [responseEvent], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("response_event")
    @ExcludeMissing
    fun _responseEvent(): JsonField<String> = responseEvent

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
         * Returns a mutable builder for constructing an instance of [ServerEventSelector].
         *
         * The following fields are required:
         * ```java
         * .type()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ServerEventSelector]. */
    class Builder internal constructor() {

        private var type: JsonField<String>? = null
        private var responseEvent: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(serverEventSelector: ServerEventSelector) = apply {
            type = serverEventSelector.type
            responseEvent = serverEventSelector.responseEvent
            additionalProperties = serverEventSelector.additionalProperties.toMutableMap()
        }

        /** The outer Live server event type. Use 'response.event' for Responses events. */
        fun type(type: String) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<String>) = apply { this.type = type }

        /**
         * The nested Responses event type. Required when type is 'response.event'; forbidden for
         * other event types.
         */
        fun responseEvent(responseEvent: String) = responseEvent(JsonField.of(responseEvent))

        /**
         * Sets [Builder.responseEvent] to an arbitrary JSON value.
         *
         * You should usually call [Builder.responseEvent] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun responseEvent(responseEvent: JsonField<String>) = apply {
            this.responseEvent = responseEvent
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

        /**
         * Returns an immutable instance of [ServerEventSelector].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .type()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ServerEventSelector =
            ServerEventSelector(
                checkRequired("type", type),
                responseEvent,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): ServerEventSelector = apply {
        if (validated) {
            return@apply
        }

        type()
        responseEvent()
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
        (if (type.asKnown().isPresent) 1 else 0) + (if (responseEvent.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ServerEventSelector &&
            type == other.type &&
            responseEvent == other.responseEvent &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(type, responseEvent, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ServerEventSelector{type=$type, responseEvent=$responseEvent, additionalProperties=$additionalProperties}"
}
