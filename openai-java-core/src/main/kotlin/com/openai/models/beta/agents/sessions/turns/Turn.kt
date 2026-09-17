// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.sessions.turns

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
import com.openai.models.beta.agents.SessionTurnError
import com.openai.models.beta.agents.TokenUsage
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** The canonical public representation of a session turn. */
class Turn
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val agentId: JsonField<String>,
    private val completedAt: JsonField<Long>,
    private val createdAt: JsonField<Long>,
    private val error: JsonField<SessionTurnError>,
    private val object_: JsonField<Object>,
    private val sessionId: JsonField<String>,
    private val startedAt: JsonField<Long>,
    private val status: JsonField<Status>,
    private val subagentId: JsonField<String>,
    private val usage: JsonField<TokenUsage>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("agent_id") @ExcludeMissing agentId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("completed_at")
        @ExcludeMissing
        completedAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("error")
        @ExcludeMissing
        error: JsonField<SessionTurnError> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonField<Object> = JsonMissing.of(),
        @JsonProperty("session_id") @ExcludeMissing sessionId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("started_at") @ExcludeMissing startedAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("subagent_id")
        @ExcludeMissing
        subagentId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("usage") @ExcludeMissing usage: JsonField<TokenUsage> = JsonMissing.of(),
    ) : this(
        id,
        agentId,
        completedAt,
        createdAt,
        error,
        object_,
        sessionId,
        startedAt,
        status,
        subagentId,
        usage,
        mutableMapOf(),
    )

    /**
     * The ID of the turn.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The ID of the agent that ran the turn.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun agentId(): String = agentId.getRequired("agent_id")

    /**
     * The Unix timestamp, in seconds, when the turn reached a terminal state.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun completedAt(): Optional<Long> = completedAt.getOptional("completed_at")

    /**
     * The Unix timestamp, in seconds, used to order the turn by creation time. Subagent turns use
     * their start time, falling back to completion time or the subagent opening time when the
     * preceding timestamps are unavailable.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /**
     * A customer-safe error describing why a session request failed.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun error(): Optional<SessionTurnError> = error.getOptional("error")

    /**
     * The object type. Always `agent.session.turn`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun object_(): Object = object_.getRequired("object")

    /**
     * The ID of the session that owns the turn.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun sessionId(): String = sessionId.getRequired("session_id")

    /**
     * The Unix timestamp, in seconds, when the turn started.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun startedAt(): Optional<Long> = startedAt.getOptional("started_at")

    /**
     * The current status of the turn.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): Status = status.getRequired("status")

    /**
     * The ID of the subagent that ran the turn, if applicable.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun subagentId(): Optional<String> = subagentId.getOptional("subagent_id")

    /**
     * Recorded token usage for a session or turn. Usage is best effort and may change.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun usage(): Optional<TokenUsage> = usage.getOptional("usage")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [agentId].
     *
     * Unlike [agentId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("agent_id") @ExcludeMissing fun _agentId(): JsonField<String> = agentId

    /**
     * Returns the raw JSON value of [completedAt].
     *
     * Unlike [completedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("completed_at") @ExcludeMissing fun _completedAt(): JsonField<Long> = completedAt

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt(): JsonField<Long> = createdAt

    /**
     * Returns the raw JSON value of [error].
     *
     * Unlike [error], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<SessionTurnError> = error

    /**
     * Returns the raw JSON value of [object_].
     *
     * Unlike [object_], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<Object> = object_

    /**
     * Returns the raw JSON value of [sessionId].
     *
     * Unlike [sessionId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("session_id") @ExcludeMissing fun _sessionId(): JsonField<String> = sessionId

    /**
     * Returns the raw JSON value of [startedAt].
     *
     * Unlike [startedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("started_at") @ExcludeMissing fun _startedAt(): JsonField<Long> = startedAt

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /**
     * Returns the raw JSON value of [subagentId].
     *
     * Unlike [subagentId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("subagent_id") @ExcludeMissing fun _subagentId(): JsonField<String> = subagentId

    /**
     * Returns the raw JSON value of [usage].
     *
     * Unlike [usage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("usage") @ExcludeMissing fun _usage(): JsonField<TokenUsage> = usage

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
         * Returns a mutable builder for constructing an instance of [Turn].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .agentId()
         * .completedAt()
         * .createdAt()
         * .error()
         * .sessionId()
         * .startedAt()
         * .status()
         * .subagentId()
         * .usage()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Turn]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var agentId: JsonField<String>? = null
        private var completedAt: JsonField<Long>? = null
        private var createdAt: JsonField<Long>? = null
        private var error: JsonField<SessionTurnError>? = null
        private var object_: JsonField<Object>? = JsonField.of(Object.AGENT_SESSION_TURN)
        private var sessionId: JsonField<String>? = null
        private var startedAt: JsonField<Long>? = null
        private var status: JsonField<Status>? = null
        private var subagentId: JsonField<String>? = null
        private var usage: JsonField<TokenUsage>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(turn: Turn) = apply {
            id = turn.id
            agentId = turn.agentId
            completedAt = turn.completedAt
            createdAt = turn.createdAt
            error = turn.error
            object_ = turn.object_
            sessionId = turn.sessionId
            startedAt = turn.startedAt
            status = turn.status
            subagentId = turn.subagentId
            usage = turn.usage
            additionalProperties = turn.additionalProperties.toMutableMap()
        }

        /** The ID of the turn. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The ID of the agent that ran the turn. */
        fun agentId(agentId: String) = agentId(JsonField.of(agentId))

        /**
         * Sets [Builder.agentId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.agentId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun agentId(agentId: JsonField<String>) = apply { this.agentId = agentId }

        /** The Unix timestamp, in seconds, when the turn reached a terminal state. */
        fun completedAt(completedAt: Long?) = completedAt(JsonField.ofNullable(completedAt))

        /**
         * Alias for [Builder.completedAt].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun completedAt(completedAt: Long) = completedAt(completedAt as Long?)

        /** Alias for calling [Builder.completedAt] with `completedAt.orElse(null)`. */
        fun completedAt(completedAt: Optional<Long>) = completedAt(completedAt.getOrNull())

        /**
         * Sets [Builder.completedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.completedAt] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun completedAt(completedAt: JsonField<Long>) = apply { this.completedAt = completedAt }

        /**
         * The Unix timestamp, in seconds, used to order the turn by creation time. Subagent turns
         * use their start time, falling back to completion time or the subagent opening time when
         * the preceding timestamps are unavailable.
         */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /** A customer-safe error describing why a session request failed. */
        fun error(error: SessionTurnError?) = error(JsonField.ofNullable(error))

        /** Alias for calling [Builder.error] with `error.orElse(null)`. */
        fun error(error: Optional<SessionTurnError>) = error(error.getOrNull())

        /**
         * Sets [Builder.error] to an arbitrary JSON value.
         *
         * You should usually call [Builder.error] with a well-typed [SessionTurnError] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun error(error: JsonField<SessionTurnError>) = apply { this.error = error }

        /** The object type. Always `agent.session.turn`. */
        fun object_(object_: Object) = object_(JsonField.of(object_))

        /**
         * Sets [Builder.object_] to an arbitrary JSON value.
         *
         * You should usually call [Builder.object_] with a well-typed [Object] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

        /** The ID of the session that owns the turn. */
        fun sessionId(sessionId: String) = sessionId(JsonField.of(sessionId))

        /**
         * Sets [Builder.sessionId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sessionId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun sessionId(sessionId: JsonField<String>) = apply { this.sessionId = sessionId }

        /** The Unix timestamp, in seconds, when the turn started. */
        fun startedAt(startedAt: Long?) = startedAt(JsonField.ofNullable(startedAt))

        /**
         * Alias for [Builder.startedAt].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun startedAt(startedAt: Long) = startedAt(startedAt as Long?)

        /** Alias for calling [Builder.startedAt] with `startedAt.orElse(null)`. */
        fun startedAt(startedAt: Optional<Long>) = startedAt(startedAt.getOrNull())

        /**
         * Sets [Builder.startedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.startedAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun startedAt(startedAt: JsonField<Long>) = apply { this.startedAt = startedAt }

        /** The current status of the turn. */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /** The ID of the subagent that ran the turn, if applicable. */
        fun subagentId(subagentId: String?) = subagentId(JsonField.ofNullable(subagentId))

        /** Alias for calling [Builder.subagentId] with `subagentId.orElse(null)`. */
        fun subagentId(subagentId: Optional<String>) = subagentId(subagentId.getOrNull())

        /**
         * Sets [Builder.subagentId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.subagentId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun subagentId(subagentId: JsonField<String>) = apply { this.subagentId = subagentId }

        /** Recorded token usage for a session or turn. Usage is best effort and may change. */
        fun usage(usage: TokenUsage?) = usage(JsonField.ofNullable(usage))

        /** Alias for calling [Builder.usage] with `usage.orElse(null)`. */
        fun usage(usage: Optional<TokenUsage>) = usage(usage.getOrNull())

        /**
         * Sets [Builder.usage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.usage] with a well-typed [TokenUsage] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun usage(usage: JsonField<TokenUsage>) = apply { this.usage = usage }

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
         * Returns an immutable instance of [Turn].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .agentId()
         * .completedAt()
         * .createdAt()
         * .error()
         * .sessionId()
         * .startedAt()
         * .status()
         * .subagentId()
         * .usage()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Turn =
            Turn(
                checkRequired("id", id),
                checkRequired("agentId", agentId),
                checkRequired("completedAt", completedAt),
                checkRequired("createdAt", createdAt),
                checkRequired("error", error),
                checkRequired("object_", object_),
                checkRequired("sessionId", sessionId),
                checkRequired("startedAt", startedAt),
                checkRequired("status", status),
                checkRequired("subagentId", subagentId),
                checkRequired("usage", usage),
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
    fun validate(): Turn = apply {
        if (validated) {
            return@apply
        }

        id()
        agentId()
        completedAt()
        createdAt()
        error().ifPresent { it.validate() }
        object_().validate()
        sessionId()
        startedAt()
        status().validate()
        subagentId()
        usage().ifPresent { it.validate() }
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
            (if (agentId.asKnown().isPresent) 1 else 0) +
            (if (completedAt.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (error.asKnown().getOrNull()?.validity() ?: 0) +
            (object_.asKnown().getOrNull()?.validity() ?: 0) +
            (if (sessionId.asKnown().isPresent) 1 else 0) +
            (if (startedAt.asKnown().isPresent) 1 else 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (subagentId.asKnown().isPresent) 1 else 0) +
            (usage.asKnown().getOrNull()?.validity() ?: 0)

    /** The object type. Always `agent.session.turn`. */
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

            @JvmField val AGENT_SESSION_TURN = of("agent.session.turn")

            @JvmStatic fun of(value: String) = Object(JsonField.of(value))
        }

        /** An enum containing [Object]'s known values. */
        enum class Known {
            AGENT_SESSION_TURN
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
            AGENT_SESSION_TURN,
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
                AGENT_SESSION_TURN -> Value.AGENT_SESSION_TURN
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
                AGENT_SESSION_TURN -> Known.AGENT_SESSION_TURN
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

    /** The current status of the turn. */
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

            /** The turn is waiting to start. */
            @JvmField val QUEUED = of("queued")

            /** The turn is in progress. */
            @JvmField val IN_PROGRESS = of("in_progress")

            /** The turn is waiting for external input. */
            @JvmField val WAITING = of("waiting")

            /** The turn completed successfully. */
            @JvmField val COMPLETED = of("completed")

            /** The turn failed. */
            @JvmField val FAILED = of("failed")

            /** The turn was cancelled. */
            @JvmField val CANCELLED = of("cancelled")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            /** The turn is waiting to start. */
            QUEUED,
            /** The turn is in progress. */
            IN_PROGRESS,
            /** The turn is waiting for external input. */
            WAITING,
            /** The turn completed successfully. */
            COMPLETED,
            /** The turn failed. */
            FAILED,
            /** The turn was cancelled. */
            CANCELLED,
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
            /** The turn is waiting to start. */
            QUEUED,
            /** The turn is in progress. */
            IN_PROGRESS,
            /** The turn is waiting for external input. */
            WAITING,
            /** The turn completed successfully. */
            COMPLETED,
            /** The turn failed. */
            FAILED,
            /** The turn was cancelled. */
            CANCELLED,
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
                QUEUED -> Value.QUEUED
                IN_PROGRESS -> Value.IN_PROGRESS
                WAITING -> Value.WAITING
                COMPLETED -> Value.COMPLETED
                FAILED -> Value.FAILED
                CANCELLED -> Value.CANCELLED
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
                QUEUED -> Known.QUEUED
                IN_PROGRESS -> Known.IN_PROGRESS
                WAITING -> Known.WAITING
                COMPLETED -> Known.COMPLETED
                FAILED -> Known.FAILED
                CANCELLED -> Known.CANCELLED
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

        return other is Turn &&
            id == other.id &&
            agentId == other.agentId &&
            completedAt == other.completedAt &&
            createdAt == other.createdAt &&
            error == other.error &&
            object_ == other.object_ &&
            sessionId == other.sessionId &&
            startedAt == other.startedAt &&
            status == other.status &&
            subagentId == other.subagentId &&
            usage == other.usage &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            agentId,
            completedAt,
            createdAt,
            error,
            object_,
            sessionId,
            startedAt,
            status,
            subagentId,
            usage,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Turn{id=$id, agentId=$agentId, completedAt=$completedAt, createdAt=$createdAt, error=$error, object_=$object_, sessionId=$sessionId, startedAt=$startedAt, status=$status, subagentId=$subagentId, usage=$usage, additionalProperties=$additionalProperties}"
}
