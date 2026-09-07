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
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Emitted when accepted steering input remains queued after the target response completes. The
 * server still owns the input. Do not resend it. The successor's `response.created` event is the
 * commit point.
 *
 * When `reason` is `waiting_for_required_input`, this event follows `response.completed` while the
 * response waits for the tool results or approval decisions identified by `required_input`. Copy
 * those stubs, fill their result fields using the ordinary `response.create` input schemas, and
 * submit one continuation per parent with the same `previous_response_id` and WebSocket lane. Use
 * saved results without rerunning tools. The queued steering input is prepended in submission order
 * to the continuation's input. That explicit request retains its own settings.
 *
 * This notification is emitted at most once per steering submission. Multiple submissions for the
 * same parent can report the same required inputs; they do not each require a separate
 * continuation.
 */
class BetaResponseSteerPendingEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val reason: JsonField<BetaResponseSteerPendingReason>,
    private val requiredInput: JsonField<List<BetaResponseSteerRequiredInput>>,
    private val sequenceNumber: JsonField<Long>,
    private val steer: JsonField<Steer>,
    private val type: JsonValue,
    private val streamId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("reason")
        @ExcludeMissing
        reason: JsonField<BetaResponseSteerPendingReason> = JsonMissing.of(),
        @JsonProperty("required_input")
        @ExcludeMissing
        requiredInput: JsonField<List<BetaResponseSteerRequiredInput>> = JsonMissing.of(),
        @JsonProperty("sequence_number")
        @ExcludeMissing
        sequenceNumber: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("steer") @ExcludeMissing steer: JsonField<Steer> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("stream_id") @ExcludeMissing streamId: JsonField<String> = JsonMissing.of(),
    ) : this(reason, requiredInput, sequenceNumber, steer, type, streamId, mutableMapOf())

    /**
     * An extensible enum describing why accepted steering input is still queued. Clients should
     * handle unknown values because additional reasons may be introduced. Known values include:
     * - `waiting_for_required_input`: The response is waiting for the tool results or approval
     *   decisions identified by `required_input`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun reason(): BetaResponseSteerPendingReason = reason.getRequired("reason")

    /**
     * Input stubs identifying outstanding client-owned tool results or approval decisions. Each
     * stub contains identifying fields only; the client supplies the result before including it in
     * `response.create`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun requiredInput(): List<BetaResponseSteerRequiredInput> =
        requiredInput.getRequired("required_input")

    /**
     * The sequence number for this event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

    /**
     * The steering submission that remains queued.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun steer(): Steer = steer.getRequired("steer")

    /**
     * The event discriminator. Always `response.steer.pending`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("response.steer.pending")
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
     * Returns the raw JSON value of [reason].
     *
     * Unlike [reason], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("reason")
    @ExcludeMissing
    fun _reason(): JsonField<BetaResponseSteerPendingReason> = reason

    /**
     * Returns the raw JSON value of [requiredInput].
     *
     * Unlike [requiredInput], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("required_input")
    @ExcludeMissing
    fun _requiredInput(): JsonField<List<BetaResponseSteerRequiredInput>> = requiredInput

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
         * Returns a mutable builder for constructing an instance of
         * [BetaResponseSteerPendingEvent].
         *
         * The following fields are required:
         * ```java
         * .reason()
         * .requiredInput()
         * .sequenceNumber()
         * .steer()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BetaResponseSteerPendingEvent]. */
    class Builder internal constructor() {

        private var reason: JsonField<BetaResponseSteerPendingReason>? = null
        private var requiredInput: JsonField<MutableList<BetaResponseSteerRequiredInput>>? = null
        private var sequenceNumber: JsonField<Long>? = null
        private var steer: JsonField<Steer>? = null
        private var type: JsonValue = JsonValue.from("response.steer.pending")
        private var streamId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(betaResponseSteerPendingEvent: BetaResponseSteerPendingEvent) = apply {
            reason = betaResponseSteerPendingEvent.reason
            requiredInput = betaResponseSteerPendingEvent.requiredInput.map { it.toMutableList() }
            sequenceNumber = betaResponseSteerPendingEvent.sequenceNumber
            steer = betaResponseSteerPendingEvent.steer
            type = betaResponseSteerPendingEvent.type
            streamId = betaResponseSteerPendingEvent.streamId
            additionalProperties = betaResponseSteerPendingEvent.additionalProperties.toMutableMap()
        }

        /**
         * An extensible enum describing why accepted steering input is still queued. Clients should
         * handle unknown values because additional reasons may be introduced. Known values include:
         * - `waiting_for_required_input`: The response is waiting for the tool results or approval
         *   decisions identified by `required_input`.
         */
        fun reason(reason: BetaResponseSteerPendingReason) = reason(JsonField.of(reason))

        /**
         * Sets [Builder.reason] to an arbitrary JSON value.
         *
         * You should usually call [Builder.reason] with a well-typed
         * [BetaResponseSteerPendingReason] value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun reason(reason: JsonField<BetaResponseSteerPendingReason>) = apply {
            this.reason = reason
        }

        /**
         * Sets [reason] to an arbitrary [String].
         *
         * You should usually call [reason] with a well-typed [BetaResponseSteerPendingReason]
         * constant instead. This method is primarily for setting the field to an undocumented or
         * not yet supported value.
         */
        fun reason(value: String) = reason(BetaResponseSteerPendingReason.of(value))

        /**
         * Input stubs identifying outstanding client-owned tool results or approval decisions. Each
         * stub contains identifying fields only; the client supplies the result before including it
         * in `response.create`.
         */
        fun requiredInput(requiredInput: List<BetaResponseSteerRequiredInput>) =
            requiredInput(JsonField.of(requiredInput))

        /**
         * Sets [Builder.requiredInput] to an arbitrary JSON value.
         *
         * You should usually call [Builder.requiredInput] with a well-typed
         * `List<BetaResponseSteerRequiredInput>` value instead. This method is primarily for
         * setting the field to an undocumented or not yet supported value.
         */
        fun requiredInput(requiredInput: JsonField<List<BetaResponseSteerRequiredInput>>) = apply {
            this.requiredInput = requiredInput.map { it.toMutableList() }
        }

        /**
         * Adds a single [BetaResponseSteerRequiredInput] to [Builder.requiredInput].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addRequiredInput(requiredInput: BetaResponseSteerRequiredInput) = apply {
            this.requiredInput =
                (this.requiredInput ?: JsonField.of(mutableListOf())).also {
                    checkKnown("requiredInput", it).add(requiredInput)
                }
        }

        /**
         * Alias for calling [addRequiredInput] with
         * `BetaResponseSteerRequiredInput.ofFunctionCallOutput(functionCallOutput)`.
         */
        fun addRequiredInput(
            functionCallOutput: BetaResponseSteerRequiredInput.FunctionCallOutput
        ) =
            addRequiredInput(
                BetaResponseSteerRequiredInput.ofFunctionCallOutput(functionCallOutput)
            )

        /**
         * Alias for calling [addRequiredInput] with
         * `BetaResponseSteerRequiredInput.ofCustomToolCallOutput(customToolCallOutput)`.
         */
        fun addRequiredInput(
            customToolCallOutput: BetaResponseSteerRequiredInput.CustomToolCallOutput
        ) =
            addRequiredInput(
                BetaResponseSteerRequiredInput.ofCustomToolCallOutput(customToolCallOutput)
            )

        /**
         * Alias for calling [addRequiredInput] with the following:
         * ```java
         * BetaResponseSteerRequiredInput.CustomToolCallOutput.builder()
         *     .callId(callId)
         *     .build()
         * ```
         */
        fun addCustomToolCallOutputRequiredInput(callId: String) =
            addRequiredInput(
                BetaResponseSteerRequiredInput.CustomToolCallOutput.builder().callId(callId).build()
            )

        /**
         * Alias for calling [addRequiredInput] with
         * `BetaResponseSteerRequiredInput.ofComputerCallOutput(computerCallOutput)`.
         */
        fun addRequiredInput(
            computerCallOutput: BetaResponseSteerRequiredInput.ComputerCallOutput
        ) =
            addRequiredInput(
                BetaResponseSteerRequiredInput.ofComputerCallOutput(computerCallOutput)
            )

        /**
         * Alias for calling [addRequiredInput] with the following:
         * ```java
         * BetaResponseSteerRequiredInput.ComputerCallOutput.builder()
         *     .callId(callId)
         *     .build()
         * ```
         */
        fun addComputerCallOutputRequiredInput(callId: String) =
            addRequiredInput(
                BetaResponseSteerRequiredInput.ComputerCallOutput.builder().callId(callId).build()
            )

        /**
         * Alias for calling [addRequiredInput] with
         * `BetaResponseSteerRequiredInput.ofShellCallOutput(shellCallOutput)`.
         */
        fun addRequiredInput(shellCallOutput: BetaResponseSteerRequiredInput.ShellCallOutput) =
            addRequiredInput(BetaResponseSteerRequiredInput.ofShellCallOutput(shellCallOutput))

        /**
         * Alias for calling [addRequiredInput] with the following:
         * ```java
         * BetaResponseSteerRequiredInput.ShellCallOutput.builder()
         *     .callId(callId)
         *     .build()
         * ```
         */
        fun addShellCallOutputRequiredInput(callId: String) =
            addRequiredInput(
                BetaResponseSteerRequiredInput.ShellCallOutput.builder().callId(callId).build()
            )

        /**
         * Alias for calling [addRequiredInput] with
         * `BetaResponseSteerRequiredInput.ofApplyPatchCallOutput(applyPatchCallOutput)`.
         */
        fun addRequiredInput(
            applyPatchCallOutput: BetaResponseSteerRequiredInput.ApplyPatchCallOutput
        ) =
            addRequiredInput(
                BetaResponseSteerRequiredInput.ofApplyPatchCallOutput(applyPatchCallOutput)
            )

        /**
         * Alias for calling [addRequiredInput] with the following:
         * ```java
         * BetaResponseSteerRequiredInput.ApplyPatchCallOutput.builder()
         *     .callId(callId)
         *     .build()
         * ```
         */
        fun addApplyPatchCallOutputRequiredInput(callId: String) =
            addRequiredInput(
                BetaResponseSteerRequiredInput.ApplyPatchCallOutput.builder().callId(callId).build()
            )

        /**
         * Alias for calling [addRequiredInput] with
         * `BetaResponseSteerRequiredInput.ofToolSearchOutput(toolSearchOutput)`.
         */
        fun addRequiredInput(toolSearchOutput: BetaResponseSteerRequiredInput.ToolSearchOutput) =
            addRequiredInput(BetaResponseSteerRequiredInput.ofToolSearchOutput(toolSearchOutput))

        /**
         * Alias for calling [addRequiredInput] with the following:
         * ```java
         * BetaResponseSteerRequiredInput.ToolSearchOutput.builder()
         *     .callId(callId)
         *     .build()
         * ```
         */
        fun addToolSearchOutputRequiredInput(callId: String) =
            addRequiredInput(
                BetaResponseSteerRequiredInput.ToolSearchOutput.builder().callId(callId).build()
            )

        /**
         * Alias for calling [addRequiredInput] with
         * `BetaResponseSteerRequiredInput.ofMcpApprovalResponse(mcpApprovalResponse)`.
         */
        fun addRequiredInput(
            mcpApprovalResponse: BetaResponseSteerRequiredInput.McpApprovalResponse
        ) =
            addRequiredInput(
                BetaResponseSteerRequiredInput.ofMcpApprovalResponse(mcpApprovalResponse)
            )

        /**
         * Alias for calling [addRequiredInput] with the following:
         * ```java
         * BetaResponseSteerRequiredInput.McpApprovalResponse.builder()
         *     .approvalRequestId(approvalRequestId)
         *     .build()
         * ```
         */
        fun addMcpApprovalResponseRequiredInput(approvalRequestId: String) =
            addRequiredInput(
                BetaResponseSteerRequiredInput.McpApprovalResponse.builder()
                    .approvalRequestId(approvalRequestId)
                    .build()
            )

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

        /** The steering submission that remains queued. */
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
         * JsonValue.from("response.steer.pending")
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
         * Returns an immutable instance of [BetaResponseSteerPendingEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .reason()
         * .requiredInput()
         * .sequenceNumber()
         * .steer()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BetaResponseSteerPendingEvent =
            BetaResponseSteerPendingEvent(
                checkRequired("reason", reason),
                checkRequired("requiredInput", requiredInput).map { it.toImmutable() },
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
    fun validate(): BetaResponseSteerPendingEvent = apply {
        if (validated) {
            return@apply
        }

        reason()
        requiredInput().forEach { it.validate() }
        sequenceNumber()
        steer().validate()
        _type().let {
            if (it != JsonValue.from("response.steer.pending")) {
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
        (if (reason.asKnown().isPresent) 1 else 0) +
            (requiredInput.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
            (steer.asKnown().getOrNull()?.validity() ?: 0) +
            type.let { if (it == JsonValue.from("response.steer.pending")) 1 else 0 } +
            (if (streamId.asKnown().isPresent) 1 else 0)

    /** The steering submission that remains queued. */
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

        return other is BetaResponseSteerPendingEvent &&
            reason == other.reason &&
            requiredInput == other.requiredInput &&
            sequenceNumber == other.sequenceNumber &&
            steer == other.steer &&
            type == other.type &&
            streamId == other.streamId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            reason,
            requiredInput,
            sequenceNumber,
            steer,
            type,
            streamId,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BetaResponseSteerPendingEvent{reason=$reason, requiredInput=$requiredInput, sequenceNumber=$sequenceNumber, steer=$steer, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
}
