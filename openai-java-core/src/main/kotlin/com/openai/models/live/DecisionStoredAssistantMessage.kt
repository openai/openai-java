// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

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
import com.openai.core.collectAllProperties
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class DecisionStoredAssistantMessage
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val content: JsonField<DecisionAssistantMessageContent>,
    private val role: JsonValue,
    private val phase: JsonField<Phase>,
    private val type: JsonField<Type>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("content")
        @ExcludeMissing
        content: JsonField<DecisionAssistantMessageContent> = JsonMissing.of(),
        @JsonProperty("role") @ExcludeMissing role: JsonValue = JsonMissing.of(),
        @JsonProperty("phase") @ExcludeMissing phase: JsonField<Phase> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
    ) : this(id, content, role, phase, type, mutableMapOf())

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun id(): java.util.Optional<String> = id.getOptional("id")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun idOrThrow(): String = id.getRequired("id")

    /**
     * The text input to the model. The schema requires this property. Returns empty if the JSON
     * property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun content(): java.util.Optional<DecisionAssistantMessageContent> =
        content.getOptional("content")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun contentOrThrow(): DecisionAssistantMessageContent = content.getRequired("content")

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun role(): java.util.Optional<JsonValue> {
        val raw = role
        return when {
            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
            !(raw == JsonValue.from("assistant")) ->
                throw OpenAIInvalidDataException("`role` is invalid")
            else -> java.util.Optional.of(raw)
        }
    }

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun roleOrThrow(): JsonValue = role().orElseGet { role.getRequired("role") }

    @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<JsonValue> = role

    /**
     * Labels an `assistant` message as intermediate commentary (`commentary`) or the final answer
     * (`final_answer`). For models like `gpt-5.3-codex` and beyond, when sending follow-up
     * requests, preserve and resend phase on all assistant messages — dropping it can degrade
     * performance. Not used for user messages. Returns empty if the JSON property is missing or
     * null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun phase(): java.util.Optional<Phase> = phase.getOptional("phase")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun phaseOrThrow(): Phase = phase.getRequired("phase")

    /**
     * Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun type(): java.util.Optional<JsonValue> {
        val raw = JsonValue.from(type)
        return when {
            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
            !(raw == JsonValue.from("message")) ->
                throw OpenAIInvalidDataException("`type` is invalid")
            else -> java.util.Optional.of(raw)
        }
    }

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun typeOrThrow(): JsonValue = type().orElseGet { JsonValue.from(type).getRequired("type") }

    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = JsonValue.from(type)

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
    @JsonProperty("content")
    @ExcludeMissing
    fun _content(): JsonField<DecisionAssistantMessageContent> = content

    /**
     * Returns the raw JSON value of [phase].
     *
     * Unlike [phase], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("phase") @ExcludeMissing fun _phase(): JsonField<Phase> = phase

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    /**
     * Returns an immutable snapshot of all present JSON properties, including declared and
     * additional properties.
     *
     * Keys use their JSON names. Declared properties take precedence over additional properties
     * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
     * values are preserved.
     */
    fun _allProperties(): Map<String, JsonValue> =
        collectAllProperties(
            additionalProperties,
            "id" to this.id,
            "content" to this.content,
            "role" to this.role,
            "phase" to this.phase,
            "type" to this.type,
        )

    @JvmSynthetic
    internal fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    @JsonAnyGetter
    @ExcludeMissing
    private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [DecisionStoredAssistantMessage].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .content()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DecisionStoredAssistantMessage]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var content: JsonField<DecisionAssistantMessageContent>? = null
        private var role: JsonValue = JsonValue.from("assistant")
        private var phase: JsonField<Phase> = JsonMissing.of()
        private var type: JsonField<Type> = JsonField.of(Type.MESSAGE)
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(decisionStoredAssistantMessage: DecisionStoredAssistantMessage) = apply {
            id = decisionStoredAssistantMessage.id
            content = decisionStoredAssistantMessage.content
            role = decisionStoredAssistantMessage.role
            phase = decisionStoredAssistantMessage.phase
            type = decisionStoredAssistantMessage.type
            additionalProperties =
                decisionStoredAssistantMessage.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The text input to the model. */
        fun content(content: DecisionAssistantMessageContent) = content(JsonField.of(content))

        /**
         * Sets [Builder.content] to an arbitrary JSON value.
         *
         * You should usually call [Builder.content] with a well-typed
         * [DecisionAssistantMessageContent] value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun content(content: JsonField<DecisionAssistantMessageContent>) = apply {
            this.content = content
        }

        /** Alias for calling [content] with `DecisionAssistantMessageContent.ofString(string)`. */
        fun content(string: String) = content(DecisionAssistantMessageContent.ofString(string))

        /** Alias for calling [content] with `DecisionAssistantMessageContent.ofParts(parts)`. */
        fun contentOfParts(parts: List<DecisionAssistantMessageContentPart>) =
            content(DecisionAssistantMessageContent.ofParts(parts))

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

        /**
         * Labels an `assistant` message as intermediate commentary (`commentary`) or the final
         * answer (`final_answer`). For models like `gpt-5.3-codex` and beyond, when sending
         * follow-up requests, preserve and resend phase on all assistant messages — dropping it can
         * degrade performance. Not used for user messages.
         */
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

        fun type(type: Type) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [Type] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<Type>) = apply { this.type = type }

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
         * Returns an immutable instance of [DecisionStoredAssistantMessage].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .content()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): DecisionStoredAssistantMessage =
            DecisionStoredAssistantMessage(
                checkRequired("id", id),
                checkRequired("content", content),
                role,
                phase,
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
    fun validate(): DecisionStoredAssistantMessage = apply {
        if (validated) {
            return@apply
        }

        idOrThrow()
        contentOrThrow().validate()
        roleOrThrow()
        phase().ifPresent { it.validate() }
        type()
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
            (content.asKnown().getOrNull()?.validity() ?: 0) +
            role.let { if (it == JsonValue.from("assistant")) 1 else 0 } +
            (phase.asKnown().getOrNull()?.validity() ?: 0) +
            (type.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * Labels an `assistant` message as intermediate commentary (`commentary`) or the final answer
     * (`final_answer`). For models like `gpt-5.3-codex` and beyond, when sending follow-up
     * requests, preserve and resend phase on all assistant messages — dropping it can degrade
     * performance. Not used for user messages.
     */
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

            @JvmField val COMMENTARY = of("commentary")

            @JvmField val FINAL_ANSWER = of("final_answer")

            @JvmStatic fun of(value: String) = Phase(JsonField.of(value))
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

            asString()
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
            when (this) {
                COMMENTARY -> 1
                FINAL_ANSWER -> 1
                else -> 0
            }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Phase && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val MESSAGE = of("message")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
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
        fun validate(): Type = apply {
            if (validated) {
                return@apply
            }

            asString()
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
            when (this) {
                MESSAGE -> 1
                else -> 0
            }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Type && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DecisionStoredAssistantMessage &&
            id == other.id &&
            content == other.content &&
            role == other.role &&
            phase == other.phase &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, content, role, phase, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "DecisionStoredAssistantMessage{id=$id, content=$content, role=$role, phase=$phase, type=$type, additionalProperties=$additionalProperties}"
}
