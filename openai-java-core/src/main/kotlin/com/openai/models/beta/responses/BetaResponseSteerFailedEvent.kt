// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

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
import kotlin.jvm.optionals.getOrNull

/**
 * Emitted when steering input is rejected or cannot be committed to a successor response. Returns
 * the original, uncommitted input so the client can carry it into `response.create` when
 * appropriate. Invalid input must be corrected before retrying.
 *
 * Failures after acceptance include the same steering ID. Failures before an ID is allocated omit
 * `steer.id`. A lost connection or missing acknowledgement leaves the outcome unknown; it is not
 * proof that the input was rejected.
 */
class BetaResponseSteerFailedEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val error: JsonField<Error>,
    private val sequenceNumber: JsonField<Long>,
    private val steer: JsonField<Steer>,
    private val type: JsonValue,
    private val streamId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("error") @ExcludeMissing error: JsonField<Error> = JsonMissing.of(),
        @JsonProperty("sequence_number")
        @ExcludeMissing
        sequenceNumber: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("steer") @ExcludeMissing steer: JsonField<Steer> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("stream_id") @ExcludeMissing streamId: JsonField<String> = JsonMissing.of(),
    ) : this(error, sequenceNumber, steer, type, streamId, mutableMapOf())

    /**
     * Information about why the input could not be committed.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun error(): Error = error.getRequired("error")

    /**
     * The sequence number for this event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

    /**
     * The steering submission that could not be committed.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun steer(): Steer = steer.getRequired("steer")

    /**
     * The event discriminator. Always `response.steer.failed`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("response.steer.failed")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * The WebSocket lane that emitted this event, when the target response is available and its
     * `response.create` event supplied a `stream_id`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun streamId(): Optional<String> = streamId.getOptional("stream_id")

    /**
     * Returns the raw JSON value of [error].
     *
     * Unlike [error], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<Error> = error

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
         * Returns a mutable builder for constructing an instance of [BetaResponseSteerFailedEvent].
         *
         * The following fields are required:
         * ```java
         * .error()
         * .sequenceNumber()
         * .steer()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BetaResponseSteerFailedEvent]. */
    class Builder internal constructor() {

        private var error: JsonField<Error>? = null
        private var sequenceNumber: JsonField<Long>? = null
        private var steer: JsonField<Steer>? = null
        private var type: JsonValue = JsonValue.from("response.steer.failed")
        private var streamId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(betaResponseSteerFailedEvent: BetaResponseSteerFailedEvent) = apply {
            error = betaResponseSteerFailedEvent.error
            sequenceNumber = betaResponseSteerFailedEvent.sequenceNumber
            steer = betaResponseSteerFailedEvent.steer
            type = betaResponseSteerFailedEvent.type
            streamId = betaResponseSteerFailedEvent.streamId
            additionalProperties = betaResponseSteerFailedEvent.additionalProperties.toMutableMap()
        }

        /** Information about why the input could not be committed. */
        fun error(error: Error) = error(JsonField.of(error))

        /**
         * Sets [Builder.error] to an arbitrary JSON value.
         *
         * You should usually call [Builder.error] with a well-typed [Error] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun error(error: JsonField<Error>) = apply { this.error = error }

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

        /** The steering submission that could not be committed. */
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
         * JsonValue.from("response.steer.failed")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /**
         * The WebSocket lane that emitted this event, when the target response is available and its
         * `response.create` event supplied a `stream_id`.
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
         * Returns an immutable instance of [BetaResponseSteerFailedEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .error()
         * .sequenceNumber()
         * .steer()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BetaResponseSteerFailedEvent =
            BetaResponseSteerFailedEvent(
                checkRequired("error", error),
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
    fun validate(): BetaResponseSteerFailedEvent = apply {
        if (validated) {
            return@apply
        }

        error().validate()
        sequenceNumber()
        steer().validate()
        _type().let {
            if (it != JsonValue.from("response.steer.failed")) {
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
        (error.asKnown().getOrNull()?.validity() ?: 0) +
            (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
            (steer.asKnown().getOrNull()?.validity() ?: 0) +
            type.let { if (it == JsonValue.from("response.steer.failed")) 1 else 0 } +
            (if (streamId.asKnown().isPresent) 1 else 0)

    /** Information about why the input could not be committed. */
    class Error
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val code: JsonField<BetaResponseSteerErrorCode>,
        private val message: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("code")
            @ExcludeMissing
            code: JsonField<BetaResponseSteerErrorCode> = JsonMissing.of(),
            @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(code, message, type, mutableMapOf())

        /**
         * A machine-readable steering error code. Clients should handle unknown values because
         * additional codes may be introduced. Known values include:
         * - `response_not_found`: The target response is not available on this connection.
         * - `invalid_input`: The event or input failed validation.
         * - `steering_not_supported`: The model or response execution mode does not support
         *   steering.
         * - `too_many_pending_steers`: Too much steering input is pending for the response.
         * - `response_already_completed`: The response completed and is no longer accepting
         *   steering input.
         * - `response_not_active`: The response is no longer accepting steering input.
         * - `successor_creation_failed`: The successor response could not be created.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun code(): BetaResponseSteerErrorCode = code.getRequired("code")

        /**
         * A human-readable description of the error.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun message(): String = message.getRequired("message")

        /**
         * The error type. Always `invalid_request_error`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("invalid_request_error")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [code].
         *
         * Unlike [code], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("code")
        @ExcludeMissing
        fun _code(): JsonField<BetaResponseSteerErrorCode> = code

        /**
         * Returns the raw JSON value of [message].
         *
         * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

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
             * Returns a mutable builder for constructing an instance of [Error].
             *
             * The following fields are required:
             * ```java
             * .code()
             * .message()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Error]. */
        class Builder internal constructor() {

            private var code: JsonField<BetaResponseSteerErrorCode>? = null
            private var message: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("invalid_request_error")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(error: Error) = apply {
                code = error.code
                message = error.message
                type = error.type
                additionalProperties = error.additionalProperties.toMutableMap()
            }

            /**
             * A machine-readable steering error code. Clients should handle unknown values because
             * additional codes may be introduced. Known values include:
             * - `response_not_found`: The target response is not available on this connection.
             * - `invalid_input`: The event or input failed validation.
             * - `steering_not_supported`: The model or response execution mode does not support
             *   steering.
             * - `too_many_pending_steers`: Too much steering input is pending for the response.
             * - `response_already_completed`: The response completed and is no longer accepting
             *   steering input.
             * - `response_not_active`: The response is no longer accepting steering input.
             * - `successor_creation_failed`: The successor response could not be created.
             */
            fun code(code: BetaResponseSteerErrorCode) = code(JsonField.of(code))

            /**
             * Sets [Builder.code] to an arbitrary JSON value.
             *
             * You should usually call [Builder.code] with a well-typed [BetaResponseSteerErrorCode]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun code(code: JsonField<BetaResponseSteerErrorCode>) = apply { this.code = code }

            /**
             * Sets [code] to an arbitrary [String].
             *
             * You should usually call [code] with a well-typed [BetaResponseSteerErrorCode]
             * constant instead. This method is primarily for setting the field to an undocumented
             * or not yet supported value.
             */
            fun code(value: String) = code(BetaResponseSteerErrorCode.of(value))

            /** A human-readable description of the error. */
            fun message(message: String) = message(JsonField.of(message))

            /**
             * Sets [Builder.message] to an arbitrary JSON value.
             *
             * You should usually call [Builder.message] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun message(message: JsonField<String>) = apply { this.message = message }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("invalid_request_error")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * Returns an immutable instance of [Error].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .code()
             * .message()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Error =
                Error(
                    checkRequired("code", code),
                    checkRequired("message", message),
                    type,
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
        fun validate(): Error = apply {
            if (validated) {
                return@apply
            }

            code()
            message()
            _type().let {
                if (it != JsonValue.from("invalid_request_error")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
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
            (if (code.asKnown().isPresent) 1 else 0) +
                (if (message.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("invalid_request_error")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Error &&
                code == other.code &&
                message == other.message &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(code, message, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Error{code=$code, message=$message, type=$type, additionalProperties=$additionalProperties}"
    }

    /** The steering submission that could not be committed. */
    class Steer
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val input: JsonField<BetaResponseSteerInput>,
        private val previousResponseId: JsonField<String>,
        private val id: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("input")
            @ExcludeMissing
            input: JsonField<BetaResponseSteerInput> = JsonMissing.of(),
            @JsonProperty("previous_response_id")
            @ExcludeMissing
            previousResponseId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        ) : this(input, previousResponseId, id, mutableMapOf())

        /**
         * Input to queue for a continuation of the response. Uses the same string or input-item
         * shape as `response.create.input`, with a non-empty array when supplying input items.
         *
         * Steering accepts only messages with the `user` role. Each message may contain only
         * `type`, `role`, and `content`, with `content` as a string or an array of `input_text`,
         * `input_image`, and `input_file` parts. The optional `type` must be `message`. Other
         * roles, tool outputs, and item types are not supported for steering.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun input(): BetaResponseSteerInput = input.getRequired("input")

        /**
         * The ID of the response that was targeted for steering.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun previousResponseId(): String = previousResponseId.getRequired("previous_response_id")

        /**
         * The ID assigned to the steering submission, if one was allocated.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * Returns the raw JSON value of [input].
         *
         * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("input")
        @ExcludeMissing
        fun _input(): JsonField<BetaResponseSteerInput> = input

        /**
         * Returns the raw JSON value of [previousResponseId].
         *
         * Unlike [previousResponseId], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("previous_response_id")
        @ExcludeMissing
        fun _previousResponseId(): JsonField<String> = previousResponseId

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

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
             * .input()
             * .previousResponseId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Steer]. */
        class Builder internal constructor() {

            private var input: JsonField<BetaResponseSteerInput>? = null
            private var previousResponseId: JsonField<String>? = null
            private var id: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(steer: Steer) = apply {
                input = steer.input
                previousResponseId = steer.previousResponseId
                id = steer.id
                additionalProperties = steer.additionalProperties.toMutableMap()
            }

            /**
             * Input to queue for a continuation of the response. Uses the same string or input-item
             * shape as `response.create.input`, with a non-empty array when supplying input items.
             *
             * Steering accepts only messages with the `user` role. Each message may contain only
             * `type`, `role`, and `content`, with `content` as a string or an array of
             * `input_text`, `input_image`, and `input_file` parts. The optional `type` must be
             * `message`. Other roles, tool outputs, and item types are not supported for steering.
             */
            fun input(input: BetaResponseSteerInput) = input(JsonField.of(input))

            /**
             * Sets [Builder.input] to an arbitrary JSON value.
             *
             * You should usually call [Builder.input] with a well-typed [BetaResponseSteerInput]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun input(input: JsonField<BetaResponseSteerInput>) = apply { this.input = input }

            /** Alias for calling [input] with `BetaResponseSteerInput.ofText(text)`. */
            fun input(text: String) = input(BetaResponseSteerInput.ofText(text))

            /**
             * Alias for calling [input] with
             * `BetaResponseSteerInput.ofResponseSteerInputItemList(responseSteerInputItemList)`.
             */
            fun inputOfResponseSteerInputItemList(
                responseSteerInputItemList: List<BetaResponseSteerInput.ResponseSteerInputItem>
            ) =
                input(
                    BetaResponseSteerInput.ofResponseSteerInputItemList(responseSteerInputItemList)
                )

            /** The ID of the response that was targeted for steering. */
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

            /** The ID assigned to the steering submission, if one was allocated. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

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
             * .input()
             * .previousResponseId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Steer =
                Steer(
                    checkRequired("input", input),
                    checkRequired("previousResponseId", previousResponseId),
                    id,
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

            input().validate()
            previousResponseId()
            id()
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
            (input.asKnown().getOrNull()?.validity() ?: 0) +
                (if (previousResponseId.asKnown().isPresent) 1 else 0) +
                (if (id.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Steer &&
                input == other.input &&
                previousResponseId == other.previousResponseId &&
                id == other.id &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(input, previousResponseId, id, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Steer{input=$input, previousResponseId=$previousResponseId, id=$id, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BetaResponseSteerFailedEvent &&
            error == other.error &&
            sequenceNumber == other.sequenceNumber &&
            steer == other.steer &&
            type == other.type &&
            streamId == other.streamId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(error, sequenceNumber, steer, type, streamId, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BetaResponseSteerFailedEvent{error=$error, sequenceNumber=$sequenceNumber, steer=$steer, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
}
