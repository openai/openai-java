// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

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

/** Emitted when all injected input items were validated and committed to the active response. */
class BetaResponseInjectCreatedEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val responseId: JsonField<String>,
    private val sequenceNumber: JsonField<Long>,
    private val type: JsonValue,
    private val streamId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("response_id")
        @ExcludeMissing
        responseId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("sequence_number")
        @ExcludeMissing
        sequenceNumber: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("stream_id") @ExcludeMissing streamId: JsonField<String> = JsonMissing.of(),
    ) : this(responseId, sequenceNumber, type, streamId, mutableMapOf())

    /**
     * The ID of the response that accepted the input.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun responseId(): String = responseId.getRequired("response_id")

    /**
     * The sequence number for this event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

    /**
     * The event discriminator. Always `response.inject.created`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("response.inject.created")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * The multiplexed WebSocket stream that emitted the event. This field is present only when
     * WebSocket multiplexing is enabled separately.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun streamId(): Optional<String> = streamId.getOptional("stream_id")

    /**
     * Returns the raw JSON value of [responseId].
     *
     * Unlike [responseId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("response_id") @ExcludeMissing fun _responseId(): JsonField<String> = responseId

    /**
     * Returns the raw JSON value of [sequenceNumber].
     *
     * Unlike [sequenceNumber], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sequence_number")
    @ExcludeMissing
    fun _sequenceNumber(): JsonField<Long> = sequenceNumber

    /**
     * Returns the raw JSON value of [streamId].
     *
     * Unlike [streamId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("stream_id") @ExcludeMissing fun _streamId(): JsonField<String> = streamId

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
         * Returns a mutable builder for constructing an instance of
         * [BetaResponseInjectCreatedEvent].
         *
         * The following fields are required:
         * ```java
         * .responseId()
         * .sequenceNumber()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BetaResponseInjectCreatedEvent]. */
    class Builder internal constructor() {

        private var responseId: JsonField<String>? = null
        private var sequenceNumber: JsonField<Long>? = null
        private var type: JsonValue = JsonValue.from("response.inject.created")
        private var streamId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(betaResponseInjectCreatedEvent: BetaResponseInjectCreatedEvent) = apply {
            responseId = betaResponseInjectCreatedEvent.responseId
            sequenceNumber = betaResponseInjectCreatedEvent.sequenceNumber
            type = betaResponseInjectCreatedEvent.type
            streamId = betaResponseInjectCreatedEvent.streamId
            additionalProperties =
                betaResponseInjectCreatedEvent.additionalProperties.toMutableMap()
        }

        /** The ID of the response that accepted the input. */
        fun responseId(responseId: String) = responseId(JsonField.of(responseId))

        /**
         * Sets [Builder.responseId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.responseId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun responseId(responseId: JsonField<String>) = apply { this.responseId = responseId }

        /** The sequence number for this event. */
        fun sequenceNumber(sequenceNumber: Long) = sequenceNumber(JsonField.of(sequenceNumber))

        /**
         * Sets [Builder.sequenceNumber] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sequenceNumber] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun sequenceNumber(sequenceNumber: JsonField<Long>) = apply {
            this.sequenceNumber = sequenceNumber
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("response.inject.created")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /**
         * The multiplexed WebSocket stream that emitted the event. This field is present only when
         * WebSocket multiplexing is enabled separately.
         */
        fun streamId(streamId: String) = streamId(JsonField.of(streamId))

        /**
         * Sets [Builder.streamId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.streamId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun streamId(streamId: JsonField<String>) = apply { this.streamId = streamId }

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
         * Returns an immutable instance of [BetaResponseInjectCreatedEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .responseId()
         * .sequenceNumber()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BetaResponseInjectCreatedEvent =
            BetaResponseInjectCreatedEvent(
                checkRequired("responseId", responseId),
                checkRequired("sequenceNumber", sequenceNumber),
                type,
                streamId,
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
    fun validate(): BetaResponseInjectCreatedEvent = apply {
        if (validated) {
            return@apply
        }

        responseId()
        sequenceNumber()
        _type().let {
            if (it != JsonValue.from("response.inject.created")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        streamId()
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
        (if (responseId.asKnown().isPresent) 1 else 0) +
            (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("response.inject.created")) 1 else 0 } +
            (if (streamId.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BetaResponseInjectCreatedEvent &&
            responseId == other.responseId &&
            sequenceNumber == other.sequenceNumber &&
            type == other.type &&
            streamId == other.streamId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(responseId, sequenceNumber, type, streamId, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BetaResponseInjectCreatedEvent{responseId=$responseId, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
}
