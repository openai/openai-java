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

/** A subagent created within a session. */
class Subagent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val closedAt: JsonField<Long>,
    private val instructions: JsonField<List<AgentContent>>,
    private val name: JsonField<String>,
    private val object_: JsonField<Object>,
    private val openedAt: JsonField<Long>,
    private val parentAgentId: JsonField<String>,
    private val sessionId: JsonField<String>,
    private val status: JsonField<Status>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("closed_at") @ExcludeMissing closedAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("instructions")
        @ExcludeMissing
        instructions: JsonField<List<AgentContent>> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonField<Object> = JsonMissing.of(),
        @JsonProperty("opened_at") @ExcludeMissing openedAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("parent_agent_id")
        @ExcludeMissing
        parentAgentId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("session_id") @ExcludeMissing sessionId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
    ) : this(
        id,
        closedAt,
        instructions,
        name,
        object_,
        openedAt,
        parentAgentId,
        sessionId,
        status,
        mutableMapOf(),
    )

    /**
     * The ID of the subagent.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The Unix timestamp, in seconds, when the subagent was closed. Null while active, including
     * after resume.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun closedAt(): Optional<Long> = closedAt.getOptional("closed_at")

    /**
     * Initial task content, or null when unavailable. Text may contain placeholders for images or
     * audio when only a preview is available.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun instructions(): Optional<List<AgentContent>> = instructions.getOptional("instructions")

    /**
     * The runner-assigned nickname, or null when unavailable.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = name.getOptional("name")

    /**
     * The object type. Always `agent.session.subagent`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun object_(): Object = object_.getRequired("object")

    /**
     * The Unix timestamp, in seconds, when the subagent was first opened. Resuming does not change
     * it.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun openedAt(): Long = openedAt.getRequired("opened_at")

    /**
     * The ID of the agent that created this subagent.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun parentAgentId(): String = parentAgentId.getRequired("parent_agent_id")

    /**
     * The ID of the session that owns the subagent.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun sessionId(): String = sessionId.getRequired("session_id")

    /**
     * The current status of the subagent.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): Status = status.getRequired("status")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [closedAt].
     *
     * Unlike [closedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("closed_at") @ExcludeMissing fun _closedAt(): JsonField<Long> = closedAt

    /**
     * Returns the raw JSON value of [instructions].
     *
     * Unlike [instructions], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("instructions")
    @ExcludeMissing
    fun _instructions(): JsonField<List<AgentContent>> = instructions

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [object_].
     *
     * Unlike [object_], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<Object> = object_

    /**
     * Returns the raw JSON value of [openedAt].
     *
     * Unlike [openedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("opened_at") @ExcludeMissing fun _openedAt(): JsonField<Long> = openedAt

    /**
     * Returns the raw JSON value of [parentAgentId].
     *
     * Unlike [parentAgentId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("parent_agent_id")
    @ExcludeMissing
    fun _parentAgentId(): JsonField<String> = parentAgentId

    /**
     * Returns the raw JSON value of [sessionId].
     *
     * Unlike [sessionId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("session_id") @ExcludeMissing fun _sessionId(): JsonField<String> = sessionId

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
         * Returns a mutable builder for constructing an instance of [Subagent].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .closedAt()
         * .instructions()
         * .name()
         * .openedAt()
         * .parentAgentId()
         * .sessionId()
         * .status()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Subagent]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var closedAt: JsonField<Long>? = null
        private var instructions: JsonField<MutableList<AgentContent>>? = null
        private var name: JsonField<String>? = null
        private var object_: JsonField<Object>? = JsonField.of(Object.AGENT_SESSION_SUBAGENT)
        private var openedAt: JsonField<Long>? = null
        private var parentAgentId: JsonField<String>? = null
        private var sessionId: JsonField<String>? = null
        private var status: JsonField<Status>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(subagent: Subagent) = apply {
            id = subagent.id
            closedAt = subagent.closedAt
            instructions = subagent.instructions.map { it.toMutableList() }
            name = subagent.name
            object_ = subagent.object_
            openedAt = subagent.openedAt
            parentAgentId = subagent.parentAgentId
            sessionId = subagent.sessionId
            status = subagent.status
            additionalProperties = subagent.additionalProperties.toMutableMap()
        }

        /** The ID of the subagent. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /**
         * The Unix timestamp, in seconds, when the subagent was closed. Null while active,
         * including after resume.
         */
        fun closedAt(closedAt: Long?) = closedAt(JsonField.ofNullable(closedAt))

        /**
         * Alias for [Builder.closedAt].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun closedAt(closedAt: Long) = closedAt(closedAt as Long?)

        /** Alias for calling [Builder.closedAt] with `closedAt.orElse(null)`. */
        fun closedAt(closedAt: Optional<Long>) = closedAt(closedAt.getOrNull())

        /**
         * Sets [Builder.closedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.closedAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun closedAt(closedAt: JsonField<Long>) = apply { this.closedAt = closedAt }

        /**
         * Initial task content, or null when unavailable. Text may contain placeholders for images
         * or audio when only a preview is available.
         */
        fun instructions(instructions: List<AgentContent>?) =
            instructions(JsonField.ofNullable(instructions))

        /** Alias for calling [Builder.instructions] with `instructions.orElse(null)`. */
        fun instructions(instructions: Optional<List<AgentContent>>) =
            instructions(instructions.getOrNull())

        /**
         * Sets [Builder.instructions] to an arbitrary JSON value.
         *
         * You should usually call [Builder.instructions] with a well-typed `List<AgentContent>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun instructions(instructions: JsonField<List<AgentContent>>) = apply {
            this.instructions = instructions.map { it.toMutableList() }
        }

        /**
         * Adds a single [AgentContent] to [instructions].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addInstruction(instruction: AgentContent) = apply {
            instructions =
                (instructions ?: JsonField.of(mutableListOf())).also {
                    checkKnown("instructions", it).add(instruction)
                }
        }

        /** Alias for calling [addInstruction] with `AgentContent.ofOutputText(outputText)`. */
        fun addInstruction(outputText: OutputText) =
            addInstruction(AgentContent.ofOutputText(outputText))

        /**
         * Alias for calling [addInstruction] with the following:
         * ```java
         * OutputText.builder()
         *     .text(text)
         *     .build()
         * ```
         */
        fun addOutputTextInstruction(text: String) =
            addInstruction(OutputText.builder().text(text).build())

        /** Alias for calling [addInstruction] with `AgentContent.ofEncrypted(encrypted)`. */
        fun addInstruction(encrypted: AgentContent.EncryptedContent) =
            addInstruction(AgentContent.ofEncrypted(encrypted))

        /**
         * Alias for calling [addInstruction] with the following:
         * ```java
         * AgentContent.EncryptedContent.builder()
         *     .encryptedContent(encryptedContent)
         *     .build()
         * ```
         */
        fun addEncryptedInstruction(encryptedContent: String) =
            addInstruction(
                AgentContent.EncryptedContent.builder().encryptedContent(encryptedContent).build()
            )

        /** The runner-assigned nickname, or null when unavailable. */
        fun name(name: String?) = name(JsonField.ofNullable(name))

        /** Alias for calling [Builder.name] with `name.orElse(null)`. */
        fun name(name: Optional<String>) = name(name.getOrNull())

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** The object type. Always `agent.session.subagent`. */
        fun object_(object_: Object) = object_(JsonField.of(object_))

        /**
         * Sets [Builder.object_] to an arbitrary JSON value.
         *
         * You should usually call [Builder.object_] with a well-typed [Object] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

        /**
         * The Unix timestamp, in seconds, when the subagent was first opened. Resuming does not
         * change it.
         */
        fun openedAt(openedAt: Long) = openedAt(JsonField.of(openedAt))

        /**
         * Sets [Builder.openedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.openedAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun openedAt(openedAt: JsonField<Long>) = apply { this.openedAt = openedAt }

        /** The ID of the agent that created this subagent. */
        fun parentAgentId(parentAgentId: String) = parentAgentId(JsonField.of(parentAgentId))

        /**
         * Sets [Builder.parentAgentId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.parentAgentId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun parentAgentId(parentAgentId: JsonField<String>) = apply {
            this.parentAgentId = parentAgentId
        }

        /** The ID of the session that owns the subagent. */
        fun sessionId(sessionId: String) = sessionId(JsonField.of(sessionId))

        /**
         * Sets [Builder.sessionId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sessionId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun sessionId(sessionId: JsonField<String>) = apply { this.sessionId = sessionId }

        /** The current status of the subagent. */
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
         * Returns an immutable instance of [Subagent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .closedAt()
         * .instructions()
         * .name()
         * .openedAt()
         * .parentAgentId()
         * .sessionId()
         * .status()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Subagent =
            Subagent(
                checkRequired("id", id),
                checkRequired("closedAt", closedAt),
                checkRequired("instructions", instructions).map { it.toImmutable() },
                checkRequired("name", name),
                checkRequired("object_", object_),
                checkRequired("openedAt", openedAt),
                checkRequired("parentAgentId", parentAgentId),
                checkRequired("sessionId", sessionId),
                checkRequired("status", status),
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
    fun validate(): Subagent = apply {
        if (validated) {
            return@apply
        }

        id()
        closedAt()
        instructions().ifPresent { it.forEach { it.validate() } }
        name()
        object_().validate()
        openedAt()
        parentAgentId()
        sessionId()
        status().validate()
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
            (if (closedAt.asKnown().isPresent) 1 else 0) +
            (instructions.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (object_.asKnown().getOrNull()?.validity() ?: 0) +
            (if (openedAt.asKnown().isPresent) 1 else 0) +
            (if (parentAgentId.asKnown().isPresent) 1 else 0) +
            (if (sessionId.asKnown().isPresent) 1 else 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0)

    /** The object type. Always `agent.session.subagent`. */
    class Object @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val AGENT_SESSION_SUBAGENT = of("agent.session.subagent")

            @JvmStatic fun of(value: String) = Object(JsonField.of(value))
        }

        /** An enum containing [Object]'s known values. */
        enum class Known {
            AGENT_SESSION_SUBAGENT
        }

        /**
         * An enum containing [Object]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Object] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            AGENT_SESSION_SUBAGENT,
            /** An enum member indicating that [Object] was instantiated with an unknown value. */
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
                AGENT_SESSION_SUBAGENT -> Value.AGENT_SESSION_SUBAGENT
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
                AGENT_SESSION_SUBAGENT -> Known.AGENT_SESSION_SUBAGENT
                else -> throw OpenAIInvalidDataException("Unknown Object: $value")
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
        fun validate(): Object = apply {
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

            return other is Object && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** The current status of the subagent. */
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

            /** The subagent remains available, including while idle between turns. */
            @JvmField val ACTIVE = of("active")

            /** The subagent is closed. */
            @JvmField val CLOSED = of("closed")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            /** The subagent remains available, including while idle between turns. */
            ACTIVE,
            /** The subagent is closed. */
            CLOSED,
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
            /** The subagent remains available, including while idle between turns. */
            ACTIVE,
            /** The subagent is closed. */
            CLOSED,
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
                ACTIVE -> Value.ACTIVE
                CLOSED -> Value.CLOSED
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
                ACTIVE -> Known.ACTIVE
                CLOSED -> Known.CLOSED
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

        return other is Subagent &&
            id == other.id &&
            closedAt == other.closedAt &&
            instructions == other.instructions &&
            name == other.name &&
            object_ == other.object_ &&
            openedAt == other.openedAt &&
            parentAgentId == other.parentAgentId &&
            sessionId == other.sessionId &&
            status == other.status &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            closedAt,
            instructions,
            name,
            object_,
            openedAt,
            parentAgentId,
            sessionId,
            status,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Subagent{id=$id, closedAt=$closedAt, instructions=$instructions, name=$name, object_=$object_, openedAt=$openedAt, parentAgentId=$parentAgentId, sessionId=$sessionId, status=$status, additionalProperties=$additionalProperties}"
}
