// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

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
import kotlin.jvm.optionals.getOrNull

/**
 * Emitted when steering input has been validated and queued. Acceptance means the server owns the
 * input, not that it has been applied. The successor's `response.created` event is the commit
 * point. If accepted input cannot be committed, `response.steer.failed` returns it with the same
 * steering ID.
 *
 * When the response stops for client-owned tool output or approval, the input remains queued and
 * `response.steer.pending` is emitted after `response.completed`. Fill the pending event's
 * `required_input` stubs with saved results and send one matching explicit `response.create` per
 * parent. Do not resend accepted input while it is still queued.
 */
class ResponseSteerAcceptedEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val sequenceNumber: JsonField<Long>,
    private val steer: JsonField<Steer>,
    private val type: JsonValue,
    private val streamId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("sequence_number")
        @ExcludeMissing
        sequenceNumber: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("steer") @ExcludeMissing steer: JsonField<Steer> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("stream_id") @ExcludeMissing streamId: JsonField<String> = JsonMissing.of(),
    ) : this(sequenceNumber, steer, type, streamId, mutableMapOf())

    /**
     * The sequence number for this event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

    /**
     * The accepted steering submission.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun steer(): Steer = steer.getRequired("steer")

    /**
     * The event discriminator. Always `response.steer.accepted`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("response.steer.accepted")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * The WebSocket lane that emitted this event. This field is present when the target response's
     * `response.create` event supplied a `stream_id`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun streamId(): Optional<String> = streamId.getOptional("stream_id")

    /**
     * Returns the raw JSON value of [sequenceNumber].
     *
     * Unlike [sequenceNumber], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sequence_number")
    @ExcludeMissing
    fun _sequenceNumber(): JsonField<Long> = sequenceNumber

    /**
     * Returns the raw JSON value of [steer].
     *
     * Unlike [steer], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("steer") @ExcludeMissing fun _steer(): JsonField<Steer> = steer

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
         * Returns a mutable builder for constructing an instance of [ResponseSteerAcceptedEvent].
         *
         * The following fields are required:
         * ```java
         * .sequenceNumber()
         * .steer()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseSteerAcceptedEvent]. */
    class Builder internal constructor() {

        private var sequenceNumber: JsonField<Long>? = null
        private var steer: JsonField<Steer>? = null
        private var type: JsonValue = JsonValue.from("response.steer.accepted")
        private var streamId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseSteerAcceptedEvent: ResponseSteerAcceptedEvent) = apply {
            sequenceNumber = responseSteerAcceptedEvent.sequenceNumber
            steer = responseSteerAcceptedEvent.steer
            type = responseSteerAcceptedEvent.type
            streamId = responseSteerAcceptedEvent.streamId
            additionalProperties = responseSteerAcceptedEvent.additionalProperties.toMutableMap()
        }

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

        /** The accepted steering submission. */
        fun steer(steer: Steer) = steer(JsonField.of(steer))

        /**
         * Sets [Builder.steer] to an arbitrary JSON value.
         *
         * You should usually call [Builder.steer] with a well-typed [Steer] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun steer(steer: JsonField<Steer>) = apply { this.steer = steer }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("response.steer.accepted")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /**
         * The WebSocket lane that emitted this event. This field is present when the target
         * response's `response.create` event supplied a `stream_id`.
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
         * Returns an immutable instance of [ResponseSteerAcceptedEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .sequenceNumber()
         * .steer()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ResponseSteerAcceptedEvent =
            ResponseSteerAcceptedEvent(
                checkRequired("sequenceNumber", sequenceNumber),
                checkRequired("steer", steer),
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
    fun validate(): ResponseSteerAcceptedEvent = apply {
        if (validated) {
            return@apply
        }

        sequenceNumber()
        steer().validate()
        _type().let {
            if (it != JsonValue.from("response.steer.accepted")) {
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
        (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
            (steer.asKnown().getOrNull()?.validity() ?: 0) +
            type.let { if (it == JsonValue.from("response.steer.accepted")) 1 else 0 } +
            (if (streamId.asKnown().isPresent) 1 else 0)

    /** The accepted steering submission. */
    class Steer
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val previousResponseId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("previous_response_id")
            @ExcludeMissing
            previousResponseId: JsonField<String> = JsonMissing.of(),
        ) : this(id, previousResponseId, mutableMapOf())

        /**
         * The ID assigned to the steering submission.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * The ID of the response being steered.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun previousResponseId(): String = previousResponseId.getRequired("previous_response_id")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [previousResponseId].
         *
         * Unlike [previousResponseId], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("previous_response_id")
        @ExcludeMissing
        fun _previousResponseId(): JsonField<String> = previousResponseId

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
             * Returns a mutable builder for constructing an instance of [Steer].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .previousResponseId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Steer]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var previousResponseId: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(steer: Steer) = apply {
                id = steer.id
                previousResponseId = steer.previousResponseId
                additionalProperties = steer.additionalProperties.toMutableMap()
            }

            /** The ID assigned to the steering submission. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The ID of the response being steered. */
            fun previousResponseId(previousResponseId: String) =
                previousResponseId(JsonField.of(previousResponseId))

            /**
             * Sets [Builder.previousResponseId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.previousResponseId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun previousResponseId(previousResponseId: JsonField<String>) = apply {
                this.previousResponseId = previousResponseId
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
             * Returns an immutable instance of [Steer].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .previousResponseId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Steer =
                Steer(
                    checkRequired("id", id),
                    checkRequired("previousResponseId", previousResponseId),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Steer = apply {
            if (validated) {
                return@apply
            }

            id()
            previousResponseId()
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (previousResponseId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Steer &&
                id == other.id &&
                previousResponseId == other.previousResponseId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, previousResponseId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Steer{id=$id, previousResponseId=$previousResponseId, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ResponseSteerAcceptedEvent &&
            sequenceNumber == other.sequenceNumber &&
            steer == other.steer &&
            type == other.type &&
            streamId == other.streamId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(sequenceNumber, steer, type, streamId, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseSteerAcceptedEvent{sequenceNumber=$sequenceNumber, steer=$steer, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
}
