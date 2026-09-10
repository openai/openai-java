// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
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

/** An assistant message produced by the agent. */
class AgentSessionAssistantMessage
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val content: JsonField<List<OutputText>>,
    private val phase: JsonField<Phase>,
    private val role: JsonValue,
    private val status: JsonField<AgentOutputItemStatus>,
    private val turnId: JsonField<String>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("content")
        @ExcludeMissing
        content: JsonField<List<OutputText>> = JsonMissing.of(),
        @JsonProperty("phase") @ExcludeMissing phase: JsonField<Phase> = JsonMissing.of(),
        @JsonProperty("role") @ExcludeMissing role: JsonValue = JsonMissing.of(),
        @JsonProperty("status")
        @ExcludeMissing
        status: JsonField<AgentOutputItemStatus> = JsonMissing.of(),
        @JsonProperty("turn_id") @ExcludeMissing turnId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(id, content, phase, role, status, turnId, type, mutableMapOf())

    /**
     * The ID of the message.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The content of the message.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun content(): List<OutputText> = content.getRequired("content")

    /**
     * The phase of an assistant message.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun phase(): Optional<Phase> = phase.getOptional("phase")

    /**
     * The role of the message author. Always `assistant`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("assistant")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("role") @ExcludeMissing fun _role(): JsonValue = role

    /**
     * The status of the message.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): AgentOutputItemStatus = status.getRequired("status")

    /**
     * The ID of the turn that contains this item.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun turnId(): String = turnId.getRequired("turn_id")

    /**
     * The item type. Always `message`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("message")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [content].
     *
     * Unlike [content], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<List<OutputText>> = content

    /**
     * Returns the raw JSON value of [phase].
     *
     * Unlike [phase], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("phase") @ExcludeMissing fun _phase(): JsonField<Phase> = phase

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<AgentOutputItemStatus> = status

    /**
     * Returns the raw JSON value of [turnId].
     *
     * Unlike [turnId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("turn_id") @ExcludeMissing fun _turnId(): JsonField<String> = turnId

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
         * Returns a mutable builder for constructing an instance of [AgentSessionAssistantMessage].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .content()
         * .phase()
         * .status()
         * .turnId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AgentSessionAssistantMessage]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var content: JsonField<MutableList<OutputText>>? = null
        private var phase: JsonField<Phase>? = null
        private var role: JsonValue = JsonValue.from("assistant")
        private var status: JsonField<AgentOutputItemStatus>? = null
        private var turnId: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("message")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(agentSessionAssistantMessage: AgentSessionAssistantMessage) = apply {
            id = agentSessionAssistantMessage.id
            content = agentSessionAssistantMessage.content.map { it.toMutableList() }
            phase = agentSessionAssistantMessage.phase
            role = agentSessionAssistantMessage.role
            status = agentSessionAssistantMessage.status
            turnId = agentSessionAssistantMessage.turnId
            type = agentSessionAssistantMessage.type
            additionalProperties = agentSessionAssistantMessage.additionalProperties.toMutableMap()
        }

        /** The ID of the message. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The content of the message. */
        fun content(content: List<OutputText>) = content(JsonField.of(content))

        /**
         * Sets [Builder.content] to an arbitrary JSON value.
         *
         * You should usually call [Builder.content] with a well-typed `List<OutputText>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun content(content: JsonField<List<OutputText>>) = apply {
            this.content = content.map { it.toMutableList() }
        }

        /**
         * Adds a single [OutputText] to [Builder.content].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addContent(content: OutputText) = apply {
            this.content =
                (this.content ?: JsonField.of(mutableListOf())).also {
                    checkKnown("content", it).add(content)
                }
        }

        /** The phase of an assistant message. */
        fun phase(phase: Phase?) = phase(JsonField.ofNullable(phase))

        /** Alias for calling [Builder.phase] with `phase.orElse(null)`. */
        fun phase(phase: Optional<Phase>) = phase(phase.getOrNull())

        /**
         * Sets [Builder.phase] to an arbitrary JSON value.
         *
         * You should usually call [Builder.phase] with a well-typed [Phase] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun phase(phase: JsonField<Phase>) = apply { this.phase = phase }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("assistant")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun role(role: JsonValue) = apply { this.role = role }

        /** The status of the message. */
        fun status(status: AgentOutputItemStatus) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [AgentOutputItemStatus] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun status(status: JsonField<AgentOutputItemStatus>) = apply { this.status = status }

        /** The ID of the turn that contains this item. */
        fun turnId(turnId: String) = turnId(JsonField.of(turnId))

        /**
         * Sets [Builder.turnId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.turnId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun turnId(turnId: JsonField<String>) = apply { this.turnId = turnId }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("message")
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
         * Returns an immutable instance of [AgentSessionAssistantMessage].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .content()
         * .phase()
         * .status()
         * .turnId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AgentSessionAssistantMessage =
            AgentSessionAssistantMessage(
                checkRequired("id", id),
                checkRequired("content", content).map { it.toImmutable() },
                checkRequired("phase", phase),
                role,
                checkRequired("status", status),
                checkRequired("turnId", turnId),
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
    fun validate(): AgentSessionAssistantMessage = apply {
        if (validated) {
            return@apply
        }

        id()
        content().forEach { it.validate() }
        phase().ifPresent { it.validate() }
        _role().let {
            if (it != JsonValue.from("assistant")) {
                throw OpenAIInvalidDataException("'role' is invalid, received $it")
            }
        }
        status().validate()
        turnId()
        _type().let {
            if (it != JsonValue.from("message")) {
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (content.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (phase.asKnown().getOrNull()?.validity() ?: 0) +
            role.let { if (it == JsonValue.from("assistant")) 1 else 0 } +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (turnId.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("message")) 1 else 0 }

    /** The phase of an assistant message. */
    class Phase @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            /** Commentary produced while the agent works. */
            @JvmField val COMMENTARY = of("commentary")

            /** The agent's final answer. */
            @JvmField val FINAL_ANSWER = of("final_answer")

            @JvmStatic fun of(value: String) = Phase(JsonField.of(value))
        }

        /** An enum containing [Phase]'s known values. */
        enum class Known {
            /** Commentary produced while the agent works. */
            COMMENTARY,
            /** The agent's final answer. */
            FINAL_ANSWER,
        }

        /**
         * An enum containing [Phase]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Phase] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            /** Commentary produced while the agent works. */
            COMMENTARY,
            /** The agent's final answer. */
            FINAL_ANSWER,
            /** An enum member indicating that [Phase] was instantiated with an unknown value. */
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
                COMMENTARY -> Value.COMMENTARY
                FINAL_ANSWER -> Value.FINAL_ANSWER
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
                COMMENTARY -> Known.COMMENTARY
                FINAL_ANSWER -> Known.FINAL_ANSWER
                else -> throw OpenAIInvalidDataException("Unknown Phase: $value")
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
        fun validate(): Phase = apply {
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

            return other is Phase && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AgentSessionAssistantMessage &&
            id == other.id &&
            content == other.content &&
            phase == other.phase &&
            role == other.role &&
            status == other.status &&
            turnId == other.turnId &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, content, phase, role, status, turnId, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AgentSessionAssistantMessage{id=$id, content=$content, phase=$phase, role=$role, status=$status, turnId=$turnId, type=$type, additionalProperties=$additionalProperties}"
}
