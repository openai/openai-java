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

/** A streaming event that indicated a shell command was completed. */
class ResponseShellCallCommandDoneEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val command: JsonField<String>,
    private val commandIndex: JsonField<Long>,
    private val outputIndex: JsonField<Long>,
    private val sequenceNumber: JsonField<Long>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("command") @ExcludeMissing command: JsonField<String> = JsonMissing.of(),
        @JsonProperty("command_index")
        @ExcludeMissing
        commandIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("output_index")
        @ExcludeMissing
        outputIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("sequence_number")
        @ExcludeMissing
        sequenceNumber: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(command, commandIndex, outputIndex, sequenceNumber, type, mutableMapOf())

    /**
     * The final shell command that was emitted.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun command(): String = command.getRequired("command")

    /**
     * The index of the shell command that was completed.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun commandIndex(): Long = commandIndex.getRequired("command_index")

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
     * The type of the event, always `response.shell_call_command.done`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("response.shell_call_command.done")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [command].
     *
     * Unlike [command], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("command") @ExcludeMissing fun _command(): JsonField<String> = command

    /**
     * Returns the raw JSON value of [commandIndex].
     *
     * Unlike [commandIndex], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("command_index")
    @ExcludeMissing
    fun _commandIndex(): JsonField<Long> = commandIndex

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
         * [ResponseShellCallCommandDoneEvent].
         *
         * The following fields are required:
         * ```java
         * .command()
         * .commandIndex()
         * .outputIndex()
         * .sequenceNumber()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseShellCallCommandDoneEvent]. */
    class Builder internal constructor() {

        private var command: JsonField<String>? = null
        private var commandIndex: JsonField<Long>? = null
        private var outputIndex: JsonField<Long>? = null
        private var sequenceNumber: JsonField<Long>? = null
        private var type: JsonValue = JsonValue.from("response.shell_call_command.done")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseShellCallCommandDoneEvent: ResponseShellCallCommandDoneEvent) =
            apply {
                command = responseShellCallCommandDoneEvent.command
                commandIndex = responseShellCallCommandDoneEvent.commandIndex
                outputIndex = responseShellCallCommandDoneEvent.outputIndex
                sequenceNumber = responseShellCallCommandDoneEvent.sequenceNumber
                type = responseShellCallCommandDoneEvent.type
                additionalProperties =
                    responseShellCallCommandDoneEvent.additionalProperties.toMutableMap()
            }

        /** The final shell command that was emitted. */
        fun command(command: String) = command(JsonField.of(command))

        /**
         * Sets [Builder.command] to an arbitrary JSON value.
         *
         * You should usually call [Builder.command] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun command(command: JsonField<String>) = apply { this.command = command }

        /** The index of the shell command that was completed. */
        fun commandIndex(commandIndex: Long) = commandIndex(JsonField.of(commandIndex))

        /**
         * Sets [Builder.commandIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.commandIndex] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun commandIndex(commandIndex: JsonField<Long>) = apply { this.commandIndex = commandIndex }

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
         * JsonValue.from("response.shell_call_command.done")
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
         * Returns an immutable instance of [ResponseShellCallCommandDoneEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .command()
         * .commandIndex()
         * .outputIndex()
         * .sequenceNumber()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ResponseShellCallCommandDoneEvent =
            ResponseShellCallCommandDoneEvent(
                checkRequired("command", command),
                checkRequired("commandIndex", commandIndex),
                checkRequired("outputIndex", outputIndex),
                checkRequired("sequenceNumber", sequenceNumber),
                type,
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
    fun validate(): ResponseShellCallCommandDoneEvent = apply {
        if (validated) {
            return@apply
        }

        command()
        commandIndex()
        outputIndex()
        sequenceNumber()
        _type().let {
            if (it != JsonValue.from("response.shell_call_command.done")) {
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (command.asKnown().isPresent) 1 else 0) +
            (if (commandIndex.asKnown().isPresent) 1 else 0) +
            (if (outputIndex.asKnown().isPresent) 1 else 0) +
            (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("response.shell_call_command.done")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ResponseShellCallCommandDoneEvent &&
            command == other.command &&
            commandIndex == other.commandIndex &&
            outputIndex == other.outputIndex &&
            sequenceNumber == other.sequenceNumber &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(command, commandIndex, outputIndex, sequenceNumber, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseShellCallCommandDoneEvent{command=$command, commandIndex=$commandIndex, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, additionalProperties=$additionalProperties}"
}
