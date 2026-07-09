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
import kotlin.jvm.optionals.getOrNull

/** Emitted when there is a partial transcript of audio. */
class BetaResponseAudioTranscriptDeltaEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val delta: JsonField<String>,
    private val sequenceNumber: JsonField<Long>,
    private val type: JsonValue,
    private val agent: JsonField<Agent>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("delta") @ExcludeMissing delta: JsonField<String> = JsonMissing.of(),
        @JsonProperty("sequence_number")
        @ExcludeMissing
        sequenceNumber: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("agent") @ExcludeMissing agent: JsonField<Agent> = JsonMissing.of(),
    ) : this(delta, sequenceNumber, type, agent, mutableMapOf())

    /**
     * The partial transcript of the audio response.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun delta(): String = delta.getRequired("delta")

    /**
     * The sequence number of this event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

    /**
     * The type of the event. Always `response.audio.transcript.delta`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("response.audio.transcript.delta")
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
     * Returns the raw JSON value of [delta].
     *
     * Unlike [delta], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("delta") @ExcludeMissing fun _delta(): JsonField<String> = delta

    /**
     * Returns the raw JSON value of [sequenceNumber].
     *
     * Unlike [sequenceNumber], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sequence_number")
    @ExcludeMissing
    fun _sequenceNumber(): JsonField<Long> = sequenceNumber

    /**
     * Returns the raw JSON value of [agent].
     *
     * Unlike [agent], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("agent") @ExcludeMissing fun _agent(): JsonField<Agent> = agent

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
         * [BetaResponseAudioTranscriptDeltaEvent].
         *
         * The following fields are required:
         * ```java
         * .delta()
         * .sequenceNumber()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BetaResponseAudioTranscriptDeltaEvent]. */
    class Builder internal constructor() {

        private var delta: JsonField<String>? = null
        private var sequenceNumber: JsonField<Long>? = null
        private var type: JsonValue = JsonValue.from("response.audio.transcript.delta")
        private var agent: JsonField<Agent> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            betaResponseAudioTranscriptDeltaEvent: BetaResponseAudioTranscriptDeltaEvent
        ) = apply {
            delta = betaResponseAudioTranscriptDeltaEvent.delta
            sequenceNumber = betaResponseAudioTranscriptDeltaEvent.sequenceNumber
            type = betaResponseAudioTranscriptDeltaEvent.type
            agent = betaResponseAudioTranscriptDeltaEvent.agent
            additionalProperties =
                betaResponseAudioTranscriptDeltaEvent.additionalProperties.toMutableMap()
        }

        /** The partial transcript of the audio response. */
        fun delta(delta: String) = delta(JsonField.of(delta))

        /**
         * Sets [Builder.delta] to an arbitrary JSON value.
         *
         * You should usually call [Builder.delta] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun delta(delta: JsonField<String>) = apply { this.delta = delta }

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

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("response.audio.transcript.delta")
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
         * Returns an immutable instance of [BetaResponseAudioTranscriptDeltaEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .delta()
         * .sequenceNumber()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BetaResponseAudioTranscriptDeltaEvent =
            BetaResponseAudioTranscriptDeltaEvent(
                checkRequired("delta", delta),
                checkRequired("sequenceNumber", sequenceNumber),
                type,
                agent,
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
    fun validate(): BetaResponseAudioTranscriptDeltaEvent = apply {
        if (validated) {
            return@apply
        }

        delta()
        sequenceNumber()
        _type().let {
            if (it != JsonValue.from("response.audio.transcript.delta")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        agent().ifPresent { it.validate() }
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
        (if (delta.asKnown().isPresent) 1 else 0) +
            (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("response.audio.transcript.delta")) 1 else 0 } +
            (agent.asKnown().getOrNull()?.validity() ?: 0)

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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BetaResponseAudioTranscriptDeltaEvent &&
            delta == other.delta &&
            sequenceNumber == other.sequenceNumber &&
            type == other.type &&
            agent == other.agent &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(delta, sequenceNumber, type, agent, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BetaResponseAudioTranscriptDeltaEvent{delta=$delta, sequenceNumber=$sequenceNumber, type=$type, agent=$agent, additionalProperties=$additionalProperties}"
}
