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

/** A streaming event that indicated a shell command was incrementally updated. */
class ResponseShellCallCommandDeltaEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val commandIndex: JsonField<Long>,
    private val delta: JsonField<String>,
    private val outputIndex: JsonField<Long>,
    private val sequenceNumber: JsonField<Long>,
    private val type: JsonValue,
    private val obfuscation: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("command_index")
        @ExcludeMissing
        commandIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("delta") @ExcludeMissing delta: JsonField<String> = JsonMissing.of(),
        @JsonProperty("output_index")
        @ExcludeMissing
        outputIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("sequence_number")
        @ExcludeMissing
        sequenceNumber: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("obfuscation")
        @ExcludeMissing
        obfuscation: JsonField<String> = JsonMissing.of(),
    ) : this(commandIndex, delta, outputIndex, sequenceNumber, type, obfuscation, mutableMapOf())

    /**
     * The index of the shell command that was updated.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun commandIndex(): Long = commandIndex.getRequired("command_index")

    /**
     * The shell command delta that was appended.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun delta(): String = delta.getRequired("delta")

    /**
     * The index of the output item that was updated.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun outputIndex(): Long = outputIndex.getRequired("output_index")

    /**
     * The sequence number of the event that was emitted.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

    /**
     * The type of the event, always `response.shell_call_command.delta`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("response.shell_call_command.delta")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * An obfuscation string that was added to pad the event payload.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun obfuscation(): Optional<String> = obfuscation.getOptional("obfuscation")

    /**
     * Returns the raw JSON value of [commandIndex].
     *
     * Unlike [commandIndex], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("command_index")
    @ExcludeMissing
    fun _commandIndex(): JsonField<Long> = commandIndex

    /**
     * Returns the raw JSON value of [delta].
     *
     * Unlike [delta], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("delta") @ExcludeMissing fun _delta(): JsonField<String> = delta

    /**
     * Returns the raw JSON value of [outputIndex].
     *
     * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("output_index") @ExcludeMissing fun _outputIndex(): JsonField<Long> = outputIndex

    /**
     * Returns the raw JSON value of [sequenceNumber].
     *
     * Unlike [sequenceNumber], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sequence_number")
    @ExcludeMissing
    fun _sequenceNumber(): JsonField<Long> = sequenceNumber

    /**
     * Returns the raw JSON value of [obfuscation].
     *
     * Unlike [obfuscation], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("obfuscation") @ExcludeMissing fun _obfuscation(): JsonField<String> = obfuscation

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
         * [ResponseShellCallCommandDeltaEvent].
         *
         * The following fields are required:
         * ```java
         * .commandIndex()
         * .delta()
         * .outputIndex()
         * .sequenceNumber()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseShellCallCommandDeltaEvent]. */
    class Builder internal constructor() {

        private var commandIndex: JsonField<Long>? = null
        private var delta: JsonField<String>? = null
        private var outputIndex: JsonField<Long>? = null
        private var sequenceNumber: JsonField<Long>? = null
        private var type: JsonValue = JsonValue.from("response.shell_call_command.delta")
        private var obfuscation: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseShellCallCommandDeltaEvent: ResponseShellCallCommandDeltaEvent) =
            apply {
                commandIndex = responseShellCallCommandDeltaEvent.commandIndex
                delta = responseShellCallCommandDeltaEvent.delta
                outputIndex = responseShellCallCommandDeltaEvent.outputIndex
                sequenceNumber = responseShellCallCommandDeltaEvent.sequenceNumber
                type = responseShellCallCommandDeltaEvent.type
                obfuscation = responseShellCallCommandDeltaEvent.obfuscation
                additionalProperties =
                    responseShellCallCommandDeltaEvent.additionalProperties.toMutableMap()
            }

        /** The index of the shell command that was updated. */
        fun commandIndex(commandIndex: Long) = commandIndex(JsonField.of(commandIndex))

        /**
         * Sets [Builder.commandIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.commandIndex] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun commandIndex(commandIndex: JsonField<Long>) = apply { this.commandIndex = commandIndex }

        /** The shell command delta that was appended. */
        fun delta(delta: String) = delta(JsonField.of(delta))

        /**
         * Sets [Builder.delta] to an arbitrary JSON value.
         *
         * You should usually call [Builder.delta] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun delta(delta: JsonField<String>) = apply { this.delta = delta }

        /** The index of the output item that was updated. */
        fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

        /**
         * Sets [Builder.outputIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

        /** The sequence number of the event that was emitted. */
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
         * JsonValue.from("response.shell_call_command.delta")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** An obfuscation string that was added to pad the event payload. */
        fun obfuscation(obfuscation: String) = obfuscation(JsonField.of(obfuscation))

        /**
         * Sets [Builder.obfuscation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.obfuscation] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun obfuscation(obfuscation: JsonField<String>) = apply { this.obfuscation = obfuscation }

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
         * Returns an immutable instance of [ResponseShellCallCommandDeltaEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .commandIndex()
         * .delta()
         * .outputIndex()
         * .sequenceNumber()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ResponseShellCallCommandDeltaEvent =
            ResponseShellCallCommandDeltaEvent(
                checkRequired("commandIndex", commandIndex),
                checkRequired("delta", delta),
                checkRequired("outputIndex", outputIndex),
                checkRequired("sequenceNumber", sequenceNumber),
                type,
                obfuscation,
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
    fun validate(): ResponseShellCallCommandDeltaEvent = apply {
        if (validated) {
            return@apply
        }

        commandIndex()
        delta()
        outputIndex()
        sequenceNumber()
        _type().let {
            if (it != JsonValue.from("response.shell_call_command.delta")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        obfuscation()
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
        (if (commandIndex.asKnown().isPresent) 1 else 0) +
            (if (delta.asKnown().isPresent) 1 else 0) +
            (if (outputIndex.asKnown().isPresent) 1 else 0) +
            (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("response.shell_call_command.delta")) 1 else 0 } +
            (if (obfuscation.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ResponseShellCallCommandDeltaEvent &&
            commandIndex == other.commandIndex &&
            delta == other.delta &&
            outputIndex == other.outputIndex &&
            sequenceNumber == other.sequenceNumber &&
            type == other.type &&
            obfuscation == other.obfuscation &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            commandIndex,
            delta,
            outputIndex,
            sequenceNumber,
            type,
            obfuscation,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseShellCallCommandDeltaEvent{commandIndex=$commandIndex, delta=$delta, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, obfuscation=$obfuscation, additionalProperties=$additionalProperties}"
}
