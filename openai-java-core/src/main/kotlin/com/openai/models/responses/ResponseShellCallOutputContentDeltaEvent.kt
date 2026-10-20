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

/** A streaming event that indicated shell call output was incrementally added. */
class ResponseShellCallOutputContentDeltaEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val commandIndex: JsonField<Long>,
    private val delta: JsonField<Delta>,
    private val itemId: JsonField<String>,
    private val outputIndex: JsonField<Long>,
    private val sequenceNumber: JsonField<Long>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("command_index")
        @ExcludeMissing
        commandIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("delta") @ExcludeMissing delta: JsonField<Delta> = JsonMissing.of(),
        @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("output_index")
        @ExcludeMissing
        outputIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("sequence_number")
        @ExcludeMissing
        sequenceNumber: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(commandIndex, delta, itemId, outputIndex, sequenceNumber, type, mutableMapOf())

    /**
     * The index of the shell command that produced output.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun commandIndex(): Long = commandIndex.getRequired("command_index")

    /**
     * The stdout/stderr delta that was emitted.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun delta(): Delta = delta.getRequired("delta")

    /**
     * The ID of the output item that was updated.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun itemId(): String = itemId.getRequired("item_id")

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
     * The type of the event, always `response.shell_call_output_content.delta`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("response.shell_call_output_content.delta")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

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
    @JsonProperty("delta") @ExcludeMissing fun _delta(): JsonField<Delta> = delta

    /**
     * Returns the raw JSON value of [itemId].
     *
     * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

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
         * [ResponseShellCallOutputContentDeltaEvent].
         *
         * The following fields are required:
         * ```java
         * .commandIndex()
         * .delta()
         * .itemId()
         * .outputIndex()
         * .sequenceNumber()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseShellCallOutputContentDeltaEvent]. */
    class Builder internal constructor() {

        private var commandIndex: JsonField<Long>? = null
        private var delta: JsonField<Delta>? = null
        private var itemId: JsonField<String>? = null
        private var outputIndex: JsonField<Long>? = null
        private var sequenceNumber: JsonField<Long>? = null
        private var type: JsonValue = JsonValue.from("response.shell_call_output_content.delta")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            responseShellCallOutputContentDeltaEvent: ResponseShellCallOutputContentDeltaEvent
        ) = apply {
            commandIndex = responseShellCallOutputContentDeltaEvent.commandIndex
            delta = responseShellCallOutputContentDeltaEvent.delta
            itemId = responseShellCallOutputContentDeltaEvent.itemId
            outputIndex = responseShellCallOutputContentDeltaEvent.outputIndex
            sequenceNumber = responseShellCallOutputContentDeltaEvent.sequenceNumber
            type = responseShellCallOutputContentDeltaEvent.type
            additionalProperties =
                responseShellCallOutputContentDeltaEvent.additionalProperties.toMutableMap()
        }

        /** The index of the shell command that produced output. */
        fun commandIndex(commandIndex: Long) = commandIndex(JsonField.of(commandIndex))

        /**
         * Sets [Builder.commandIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.commandIndex] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun commandIndex(commandIndex: JsonField<Long>) = apply { this.commandIndex = commandIndex }

        /** The stdout/stderr delta that was emitted. */
        fun delta(delta: Delta) = delta(JsonField.of(delta))

        /**
         * Sets [Builder.delta] to an arbitrary JSON value.
         *
         * You should usually call [Builder.delta] with a well-typed [Delta] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun delta(delta: JsonField<Delta>) = apply { this.delta = delta }

        /** The ID of the output item that was updated. */
        fun itemId(itemId: String) = itemId(JsonField.of(itemId))

        /**
         * Sets [Builder.itemId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.itemId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

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
         * JsonValue.from("response.shell_call_output_content.delta")
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
         * Returns an immutable instance of [ResponseShellCallOutputContentDeltaEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .commandIndex()
         * .delta()
         * .itemId()
         * .outputIndex()
         * .sequenceNumber()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ResponseShellCallOutputContentDeltaEvent =
            ResponseShellCallOutputContentDeltaEvent(
                checkRequired("commandIndex", commandIndex),
                checkRequired("delta", delta),
                checkRequired("itemId", itemId),
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
    fun validate(): ResponseShellCallOutputContentDeltaEvent = apply {
        if (validated) {
            return@apply
        }

        commandIndex()
        delta().validate()
        itemId()
        outputIndex()
        sequenceNumber()
        _type().let {
            if (it != JsonValue.from("response.shell_call_output_content.delta")) {
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
        (if (commandIndex.asKnown().isPresent) 1 else 0) +
            (delta.asKnown().getOrNull()?.validity() ?: 0) +
            (if (itemId.asKnown().isPresent) 1 else 0) +
            (if (outputIndex.asKnown().isPresent) 1 else 0) +
            (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
            type.let {
                if (it == JsonValue.from("response.shell_call_output_content.delta")) 1 else 0
            }

    /** The stdout/stderr delta that was emitted. */
    class Delta
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val stderr: JsonField<String>,
        private val stdout: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("stderr") @ExcludeMissing stderr: JsonField<String> = JsonMissing.of(),
            @JsonProperty("stdout") @ExcludeMissing stdout: JsonField<String> = JsonMissing.of(),
        ) : this(stderr, stdout, mutableMapOf())

        /**
         * The stderr delta that was emitted.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun stderr(): Optional<String> = stderr.getOptional("stderr")

        /**
         * The stdout delta that was emitted.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun stdout(): Optional<String> = stdout.getOptional("stdout")

        /**
         * Returns the raw JSON value of [stderr].
         *
         * Unlike [stderr], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("stderr") @ExcludeMissing fun _stderr(): JsonField<String> = stderr

        /**
         * Returns the raw JSON value of [stdout].
         *
         * Unlike [stdout], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("stdout") @ExcludeMissing fun _stdout(): JsonField<String> = stdout

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

            /** Returns a mutable builder for constructing an instance of [Delta]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Delta]. */
        class Builder internal constructor() {

            private var stderr: JsonField<String> = JsonMissing.of()
            private var stdout: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(delta: Delta) = apply {
                stderr = delta.stderr
                stdout = delta.stdout
                additionalProperties = delta.additionalProperties.toMutableMap()
            }

            /** The stderr delta that was emitted. */
            fun stderr(stderr: String) = stderr(JsonField.of(stderr))

            /**
             * Sets [Builder.stderr] to an arbitrary JSON value.
             *
             * You should usually call [Builder.stderr] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun stderr(stderr: JsonField<String>) = apply { this.stderr = stderr }

            /** The stdout delta that was emitted. */
            fun stdout(stdout: String) = stdout(JsonField.of(stdout))

            /**
             * Sets [Builder.stdout] to an arbitrary JSON value.
             *
             * You should usually call [Builder.stdout] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun stdout(stdout: JsonField<String>) = apply { this.stdout = stdout }

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
             * Returns an immutable instance of [Delta].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Delta = Delta(stderr, stdout, additionalProperties.toMutableMap())
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
        fun validate(): Delta = apply {
            if (validated) {
                return@apply
            }

            stderr()
            stdout()
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
            (if (stderr.asKnown().isPresent) 1 else 0) + (if (stdout.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Delta &&
                stderr == other.stderr &&
                stdout == other.stdout &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(stderr, stdout, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Delta{stderr=$stderr, stdout=$stdout, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ResponseShellCallOutputContentDeltaEvent &&
            commandIndex == other.commandIndex &&
            delta == other.delta &&
            itemId == other.itemId &&
            outputIndex == other.outputIndex &&
            sequenceNumber == other.sequenceNumber &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            commandIndex,
            delta,
            itemId,
            outputIndex,
            sequenceNumber,
            type,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseShellCallOutputContentDeltaEvent{commandIndex=$commandIndex, delta=$delta, itemId=$itemId, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, additionalProperties=$additionalProperties}"
}
