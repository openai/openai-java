// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
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

/** Emitted when a reasoning summary part is completed. */
class BetaResponseReasoningSummaryPartDoneEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val itemId: JsonField<String>,
    private val outputIndex: JsonField<Long>,
    private val part: JsonField<Part>,
    private val sequenceNumber: JsonField<Long>,
    private val summaryIndex: JsonField<Long>,
    private val type: JsonValue,
    private val agent: JsonField<Agent>,
    private val status: JsonField<Status>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("output_index")
        @ExcludeMissing
        outputIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("part") @ExcludeMissing part: JsonField<Part> = JsonMissing.of(),
        @JsonProperty("sequence_number")
        @ExcludeMissing
        sequenceNumber: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("summary_index")
        @ExcludeMissing
        summaryIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("agent") @ExcludeMissing agent: JsonField<Agent> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
    ) : this(
        itemId,
        outputIndex,
        part,
        sequenceNumber,
        summaryIndex,
        type,
        agent,
        status,
        mutableMapOf(),
    )

    /**
     * The ID of the item this summary part is associated with.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun itemId(): String = itemId.getRequired("item_id")

    /**
     * The index of the output item this summary part is associated with.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun outputIndex(): Long = outputIndex.getRequired("output_index")

    /**
     * The completed summary part.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun part(): Part = part.getRequired("part")

    /**
     * The sequence number of this event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

    /**
     * The index of the summary part within the reasoning summary.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun summaryIndex(): Long = summaryIndex.getRequired("summary_index")

    /**
     * The type of the event. Always `response.reasoning_summary_part.done`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("response.reasoning_summary_part.done")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * The agent that owns this multi-agent streaming event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun agent(): Optional<Agent> = agent.getOptional("agent")

    /**
     * The completion status of the summary part. Omitted when the part completed normally and set
     * to `incomplete` when generation was interrupted.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun status(): Optional<Status> = status.getOptional("status")

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
     * Returns the raw JSON value of [part].
     *
     * Unlike [part], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("part") @ExcludeMissing fun _part(): JsonField<Part> = part

    /**
     * Returns the raw JSON value of [sequenceNumber].
     *
     * Unlike [sequenceNumber], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sequence_number")
    @ExcludeMissing
    fun _sequenceNumber(): JsonField<Long> = sequenceNumber

    /**
     * Returns the raw JSON value of [summaryIndex].
     *
     * Unlike [summaryIndex], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("summary_index")
    @ExcludeMissing
    fun _summaryIndex(): JsonField<Long> = summaryIndex

    /**
     * Returns the raw JSON value of [agent].
     *
     * Unlike [agent], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("agent") @ExcludeMissing fun _agent(): JsonField<Agent> = agent

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

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
         * [BetaResponseReasoningSummaryPartDoneEvent].
         *
         * The following fields are required:
         * ```java
         * .itemId()
         * .outputIndex()
         * .part()
         * .sequenceNumber()
         * .summaryIndex()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BetaResponseReasoningSummaryPartDoneEvent]. */
    class Builder internal constructor() {

        private var itemId: JsonField<String>? = null
        private var outputIndex: JsonField<Long>? = null
        private var part: JsonField<Part>? = null
        private var sequenceNumber: JsonField<Long>? = null
        private var summaryIndex: JsonField<Long>? = null
        private var type: JsonValue = JsonValue.from("response.reasoning_summary_part.done")
        private var agent: JsonField<Agent> = JsonMissing.of()
        private var status: JsonField<Status> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            betaResponseReasoningSummaryPartDoneEvent: BetaResponseReasoningSummaryPartDoneEvent
        ) = apply {
            itemId = betaResponseReasoningSummaryPartDoneEvent.itemId
            outputIndex = betaResponseReasoningSummaryPartDoneEvent.outputIndex
            part = betaResponseReasoningSummaryPartDoneEvent.part
            sequenceNumber = betaResponseReasoningSummaryPartDoneEvent.sequenceNumber
            summaryIndex = betaResponseReasoningSummaryPartDoneEvent.summaryIndex
            type = betaResponseReasoningSummaryPartDoneEvent.type
            agent = betaResponseReasoningSummaryPartDoneEvent.agent
            status = betaResponseReasoningSummaryPartDoneEvent.status
            additionalProperties =
                betaResponseReasoningSummaryPartDoneEvent.additionalProperties.toMutableMap()
        }

        /** The ID of the item this summary part is associated with. */
        fun itemId(itemId: String) = itemId(JsonField.of(itemId))

        /**
         * Sets [Builder.itemId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.itemId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

        /** The index of the output item this summary part is associated with. */
        fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

        /**
         * Sets [Builder.outputIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

        /** The completed summary part. */
        fun part(part: Part) = part(JsonField.of(part))

        /**
         * Sets [Builder.part] to an arbitrary JSON value.
         *
         * You should usually call [Builder.part] with a well-typed [Part] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun part(part: JsonField<Part>) = apply { this.part = part }

        /** The sequence number of this event. */
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

        /** The index of the summary part within the reasoning summary. */
        fun summaryIndex(summaryIndex: Long) = summaryIndex(JsonField.of(summaryIndex))

        /**
         * Sets [Builder.summaryIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.summaryIndex] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun summaryIndex(summaryIndex: JsonField<Long>) = apply { this.summaryIndex = summaryIndex }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("response.reasoning_summary_part.done")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** The agent that owns this multi-agent streaming event. */
        fun agent(agent: Agent?) = agent(JsonField.ofNullable(agent))

        /** Alias for calling [Builder.agent] with `agent.orElse(null)`. */
        fun agent(agent: Optional<Agent>) = agent(agent.getOrNull())

        /**
         * Sets [Builder.agent] to an arbitrary JSON value.
         *
         * You should usually call [Builder.agent] with a well-typed [Agent] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun agent(agent: JsonField<Agent>) = apply { this.agent = agent }

        /**
         * The completion status of the summary part. Omitted when the part completed normally and
         * set to `incomplete` when generation was interrupted.
         */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

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
         * Returns an immutable instance of [BetaResponseReasoningSummaryPartDoneEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .itemId()
         * .outputIndex()
         * .part()
         * .sequenceNumber()
         * .summaryIndex()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BetaResponseReasoningSummaryPartDoneEvent =
            BetaResponseReasoningSummaryPartDoneEvent(
                checkRequired("itemId", itemId),
                checkRequired("outputIndex", outputIndex),
                checkRequired("part", part),
                checkRequired("sequenceNumber", sequenceNumber),
                checkRequired("summaryIndex", summaryIndex),
                type,
                agent,
                status,
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
    fun validate(): BetaResponseReasoningSummaryPartDoneEvent = apply {
        if (validated) {
            return@apply
        }

        itemId()
        outputIndex()
        part().validate()
        sequenceNumber()
        summaryIndex()
        _type().let {
            if (it != JsonValue.from("response.reasoning_summary_part.done")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        agent().ifPresent { it.validate() }
        status().ifPresent { it.validate() }
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
        (if (itemId.asKnown().isPresent) 1 else 0) +
            (if (outputIndex.asKnown().isPresent) 1 else 0) +
            (part.asKnown().getOrNull()?.validity() ?: 0) +
            (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
            (if (summaryIndex.asKnown().isPresent) 1 else 0) +
            type.let {
                if (it == JsonValue.from("response.reasoning_summary_part.done")) 1 else 0
            } +
            (agent.asKnown().getOrNull()?.validity() ?: 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0)

    /** The completed summary part. */
    class Part
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val text: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(text, type, mutableMapOf())

        /**
         * The text of the summary part.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun text(): String = text.getRequired("text")

        /**
         * The type of the summary part. Always `summary_text`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("summary_text")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [text].
         *
         * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

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
             * Returns a mutable builder for constructing an instance of [Part].
             *
             * The following fields are required:
             * ```java
             * .text()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Part]. */
        class Builder internal constructor() {

            private var text: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("summary_text")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(part: Part) = apply {
                text = part.text
                type = part.type
                additionalProperties = part.additionalProperties.toMutableMap()
            }

            /** The text of the summary part. */
            fun text(text: String) = text(JsonField.of(text))

            /**
             * Sets [Builder.text] to an arbitrary JSON value.
             *
             * You should usually call [Builder.text] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun text(text: JsonField<String>) = apply { this.text = text }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("summary_text")
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
             * Returns an immutable instance of [Part].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .text()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Part =
                Part(checkRequired("text", text), type, additionalProperties.toMutableMap())
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
        fun validate(): Part = apply {
            if (validated) {
                return@apply
            }

            text()
            _type().let {
                if (it != JsonValue.from("summary_text")) {
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
            (if (text.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("summary_text")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Part &&
                text == other.text &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(text, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Part{text=$text, type=$type, additionalProperties=$additionalProperties}"
    }

    /** The agent that owns this multi-agent streaming event. */
    class Agent
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val agentName: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("agent_name")
            @ExcludeMissing
            agentName: JsonField<String> = JsonMissing.of()
        ) : this(agentName, mutableMapOf())

        /**
         * The canonical name of the agent that produced this item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun agentName(): String = agentName.getRequired("agent_name")

        /**
         * Returns the raw JSON value of [agentName].
         *
         * Unlike [agentName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("agent_name") @ExcludeMissing fun _agentName(): JsonField<String> = agentName

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
             * Returns a mutable builder for constructing an instance of [Agent].
             *
             * The following fields are required:
             * ```java
             * .agentName()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Agent]. */
        class Builder internal constructor() {

            private var agentName: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(agent: Agent) = apply {
                agentName = agent.agentName
                additionalProperties = agent.additionalProperties.toMutableMap()
            }

            /** The canonical name of the agent that produced this item. */
            fun agentName(agentName: String) = agentName(JsonField.of(agentName))

            /**
             * Sets [Builder.agentName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.agentName] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun agentName(agentName: JsonField<String>) = apply { this.agentName = agentName }

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
             * Returns an immutable instance of [Agent].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .agentName()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Agent =
                Agent(checkRequired("agentName", agentName), additionalProperties.toMutableMap())
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
        fun validate(): Agent = apply {
            if (validated) {
                return@apply
            }

            agentName()
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
        @JvmSynthetic internal fun validity(): Int = (if (agentName.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Agent &&
                agentName == other.agentName &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(agentName, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Agent{agentName=$agentName, additionalProperties=$additionalProperties}"
    }

    /**
     * The completion status of the summary part. Omitted when the part completed normally and set
     * to `incomplete` when generation was interrupted.
     */
    class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val INCOMPLETE = of("incomplete")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            INCOMPLETE
        }

        /**
         * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Status] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            INCOMPLETE,
            /** An enum member indicating that [Status] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                INCOMPLETE -> Value.INCOMPLETE
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws OpenAIInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                INCOMPLETE -> Known.INCOMPLETE
                else -> throw OpenAIInvalidDataException("Unknown Status: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws OpenAIInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

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
        fun validate(): Status = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Status && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BetaResponseReasoningSummaryPartDoneEvent &&
            itemId == other.itemId &&
            outputIndex == other.outputIndex &&
            part == other.part &&
            sequenceNumber == other.sequenceNumber &&
            summaryIndex == other.summaryIndex &&
            type == other.type &&
            agent == other.agent &&
            status == other.status &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            itemId,
            outputIndex,
            part,
            sequenceNumber,
            summaryIndex,
            type,
            agent,
            status,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BetaResponseReasoningSummaryPartDoneEvent{itemId=$itemId, outputIndex=$outputIndex, part=$part, sequenceNumber=$sequenceNumber, summaryIndex=$summaryIndex, type=$type, agent=$agent, status=$status, additionalProperties=$additionalProperties}"
}
