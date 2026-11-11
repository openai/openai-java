// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.automations.invocations

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonNull
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.core.collectAllProperties
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** One attempted delivery by an automation. */
class AutomationInvocation
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val automationId: JsonField<String>,
    private val createdAt: JsonField<Long>,
    private val error: JsonField<Error>,
    private val object_: JsonValue,
    private val scheduledAt: JsonField<Long>,
    private val sessionId: JsonField<String>,
    private val skipReason: JsonField<SkipReason>,
    private val source: JsonField<AutomationInvocationSource>,
    private val status: JsonField<Status>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("automation_id")
        @ExcludeMissing
        automationId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("error") @ExcludeMissing error: JsonField<Error> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("scheduled_at")
        @ExcludeMissing
        scheduledAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("session_id") @ExcludeMissing sessionId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("skip_reason")
        @ExcludeMissing
        skipReason: JsonField<SkipReason> = JsonMissing.of(),
        @JsonProperty("source")
        @ExcludeMissing
        source: JsonField<AutomationInvocationSource> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
    ) : this(
        id,
        automationId,
        createdAt,
        error,
        object_,
        scheduledAt,
        sessionId,
        skipReason,
        source,
        status,
        mutableMapOf(),
    )

    /**
     * The invocation ID. The schema requires this property. Returns empty if the JSON property is
     * missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun id(): java.util.Optional<String> = id.getOptional("id")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun idOrThrow(): String = id.getRequired("id")

    /**
     * The automation that owns the invocation. The schema requires this property. Returns empty if
     * the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun automationId(): java.util.Optional<String> = automationId.getOptional("automation_id")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun automationIdOrThrow(): String = automationId.getRequired("automation_id")

    /**
     * The creation time as a Unix timestamp in seconds. The schema requires this property. Returns
     * empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun createdAt(): java.util.Optional<Long> = createdAt.getOptional("created_at")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun createdAtOrThrow(): Long = createdAt.getRequired("created_at")

    /**
     * The permanent delivery failure, or null when no failure occurred. The schema requires this
     * property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun error(): java.util.Optional<Error> = error.getOptional("error")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun errorOrThrow(): Error = error.getRequired("error")

    /**
     * Always `agent.automation.invocation`. The schema requires this property. Returns empty if the
     * JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun object_(): java.util.Optional<JsonValue> {
        val raw = object_
        return when {
            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
            !(raw == JsonValue.from("agent.automation.invocation")) ->
                throw OpenAIInvalidDataException("`object` is invalid")
            else -> java.util.Optional.of(raw)
        }
    }

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun object_OrThrow(): JsonValue = object_().orElseGet { object_.getRequired("object") }

    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<JsonValue> = object_

    /**
     * The intended occurrence as a Unix timestamp in seconds, or null for manual runs. The schema
     * requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun scheduledAt(): java.util.Optional<Long> = scheduledAt.getOptional("scheduled_at")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun scheduledAtOrThrow(): Long = scheduledAt.getRequired("scheduled_at")

    /**
     * The target or newly created session ID, or null before one is available. The schema requires
     * this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun sessionId(): java.util.Optional<String> = sessionId.getOptional("session_id")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun sessionIdOrThrow(): String = sessionId.getRequired("session_id")

    /**
     * Why an occurrence was skipped, or null when it was not skipped. The schema requires this
     * property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun skipReason(): java.util.Optional<JsonValue> {
        val raw = JsonValue.from(skipReason)
        return when {
            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
            !(raw == JsonValue.from("pending_delivery")) ->
                throw OpenAIInvalidDataException("`skip_reason` is invalid")
            else -> java.util.Optional.of(raw)
        }
    }

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun skipReasonOrThrow(): JsonValue =
        skipReason().orElseGet { JsonValue.from(skipReason).getRequired("skip_reason") }

    @JsonProperty("skip_reason")
    @ExcludeMissing
    fun _skipReason(): JsonField<JsonValue> = JsonValue.from(skipReason)

    /**
     * Whether the invocation was manual or scheduled. The schema requires this property. Returns
     * empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun source(): java.util.Optional<AutomationInvocationSource> = source.getOptional("source")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun sourceOrThrow(): AutomationInvocationSource = source.getRequired("source")

    /**
     * Delivery status; completed does not mean the agent's work has finished. The schema requires
     * this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun status(): java.util.Optional<Status> = status.getOptional("status")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun statusOrThrow(): Status = status.getRequired("status")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [automationId].
     *
     * Unlike [automationId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("automation_id")
    @ExcludeMissing
    fun _automationId(): JsonField<String> = automationId

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
    @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<Error> = error

    /**
     * Returns the raw JSON value of [scheduledAt].
     *
     * Unlike [scheduledAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("scheduled_at") @ExcludeMissing fun _scheduledAt(): JsonField<Long> = scheduledAt

    /**
     * Returns the raw JSON value of [sessionId].
     *
     * Unlike [sessionId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("session_id") @ExcludeMissing fun _sessionId(): JsonField<String> = sessionId

    /**
     * Returns the raw JSON value of [source].
     *
     * Unlike [source], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("source")
    @ExcludeMissing
    fun _source(): JsonField<AutomationInvocationSource> = source

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
            "automation_id" to this.automationId,
            "created_at" to this.createdAt,
            "error" to this.error,
            "object" to this.object_,
            "scheduled_at" to this.scheduledAt,
            "session_id" to this.sessionId,
            "skip_reason" to this.skipReason,
            "source" to this.source,
            "status" to this.status,
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
         * Returns a mutable builder for constructing an instance of [AutomationInvocation].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .automationId()
         * .createdAt()
         * .source()
         * .status()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AutomationInvocation]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var automationId: JsonField<String>? = null
        private var createdAt: JsonField<Long>? = null
        private var error: JsonField<Error>? = JsonNull.of()
        private var object_: JsonValue = JsonValue.from("agent.automation.invocation")
        private var scheduledAt: JsonField<Long>? = JsonNull.of()
        private var sessionId: JsonField<String>? = JsonNull.of()
        private var skipReason: JsonField<SkipReason>? = JsonNull.of()
        private var source: JsonField<AutomationInvocationSource>? = null
        private var status: JsonField<Status>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(automationInvocation: AutomationInvocation) = apply {
            id = automationInvocation.id
            automationId = automationInvocation.automationId
            createdAt = automationInvocation.createdAt
            error = automationInvocation.error
            object_ = automationInvocation.object_
            scheduledAt = automationInvocation.scheduledAt
            sessionId = automationInvocation.sessionId
            skipReason = automationInvocation.skipReason
            source = automationInvocation.source
            status = automationInvocation.status
            additionalProperties = automationInvocation.additionalProperties.toMutableMap()
        }

        /** The invocation ID. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The automation that owns the invocation. */
        fun automationId(automationId: String) = automationId(JsonField.of(automationId))

        /**
         * Sets [Builder.automationId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.automationId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun automationId(automationId: JsonField<String>) = apply {
            this.automationId = automationId
        }

        /** The creation time as a Unix timestamp in seconds. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /** The permanent delivery failure, or null when no failure occurred. */
        fun error(error: Error?) = error(JsonField.ofNullable(error))

        /** Alias for calling [Builder.error] with `error.orElse(null)`. */
        fun error(error: Optional<Error>) = error(error.getOrNull())

        /**
         * Sets [Builder.error] to an arbitrary JSON value.
         *
         * You should usually call [Builder.error] with a well-typed [Error] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun error(error: JsonField<Error>) = apply { this.error = error }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("agent.automation.invocation")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /** The intended occurrence as a Unix timestamp in seconds, or null for manual runs. */
        fun scheduledAt(scheduledAt: Long?) = scheduledAt(JsonField.ofNullable(scheduledAt))

        /**
         * Alias for [Builder.scheduledAt].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun scheduledAt(scheduledAt: Long) = scheduledAt(scheduledAt as Long?)

        /** Alias for calling [Builder.scheduledAt] with `scheduledAt.orElse(null)`. */
        fun scheduledAt(scheduledAt: Optional<Long>) = scheduledAt(scheduledAt.getOrNull())

        /**
         * Sets [Builder.scheduledAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.scheduledAt] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun scheduledAt(scheduledAt: JsonField<Long>) = apply { this.scheduledAt = scheduledAt }

        /** The target or newly created session ID, or null before one is available. */
        fun sessionId(sessionId: String?) = sessionId(JsonField.ofNullable(sessionId))

        /** Alias for calling [Builder.sessionId] with `sessionId.orElse(null)`. */
        fun sessionId(sessionId: Optional<String>) = sessionId(sessionId.getOrNull())

        /**
         * Sets [Builder.sessionId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sessionId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun sessionId(sessionId: JsonField<String>) = apply { this.sessionId = sessionId }

        /** Why an occurrence was skipped, or null when it was not skipped. */
        fun skipReason(skipReason: SkipReason?) = skipReason(JsonField.ofNullable(skipReason))

        /** Alias for calling [Builder.skipReason] with `skipReason.orElse(null)`. */
        fun skipReason(skipReason: Optional<SkipReason>) = skipReason(skipReason.getOrNull())

        /**
         * Sets [Builder.skipReason] to an arbitrary JSON value.
         *
         * You should usually call [Builder.skipReason] with a well-typed [SkipReason] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun skipReason(skipReason: JsonField<SkipReason>) = apply { this.skipReason = skipReason }

        /** Whether the invocation was manual or scheduled. */
        fun source(source: AutomationInvocationSource) = source(JsonField.of(source))

        /**
         * Sets [Builder.source] to an arbitrary JSON value.
         *
         * You should usually call [Builder.source] with a well-typed [AutomationInvocationSource]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun source(source: JsonField<AutomationInvocationSource>) = apply { this.source = source }

        /** Alias for calling [source] with `AutomationInvocationSource.ofManual()`. */
        fun sourceManual() = source(AutomationInvocationSource.ofManual())

        /**
         * Alias for calling [source] with `AutomationInvocationSource.ofAutomation(automation)`.
         */
        fun source(automation: AutomationInvocationSourceAutomation) =
            source(AutomationInvocationSource.ofAutomation(automation))

        /** Delivery status; completed does not mean the agent's work has finished. */
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
         * Returns an immutable instance of [AutomationInvocation].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .automationId()
         * .createdAt()
         * .source()
         * .status()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AutomationInvocation =
            AutomationInvocation(
                checkRequired("id", id),
                checkRequired("automationId", automationId),
                checkRequired("createdAt", createdAt),
                checkRequired("error", error),
                object_,
                checkRequired("scheduledAt", scheduledAt),
                checkRequired("sessionId", sessionId),
                checkRequired("skipReason", skipReason),
                checkRequired("source", source),
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
    fun validate(): AutomationInvocation = apply {
        if (validated) {
            return@apply
        }

        idOrThrow()
        automationIdOrThrow()
        createdAtOrThrow()
        error().ifPresent { it.validate() }
        object_OrThrow()
        scheduledAt()
        sessionId()
        skipReason()
        sourceOrThrow().validate()
        statusOrThrow().validate()
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
            (if (automationId.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (error.asKnown().getOrNull()?.validity() ?: 0) +
            object_.let { if (it == JsonValue.from("agent.automation.invocation")) 1 else 0 } +
            (if (scheduledAt.asKnown().isPresent) 1 else 0) +
            (if (sessionId.asKnown().isPresent) 1 else 0) +
            (skipReason.asKnown().getOrNull()?.validity() ?: 0) +
            (source.asKnown().getOrNull()?.validity() ?: 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0)

    /** The permanent delivery failure, or null when no failure occurred. */
    class Error
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val code: JsonField<String>,
        private val message: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("code") @ExcludeMissing code: JsonField<String> = JsonMissing.of(),
            @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
        ) : this(code, message, mutableMapOf())

        /**
         * A machine-readable error code. The schema requires this property. Returns empty if the
         * JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun code(): java.util.Optional<String> = code.getOptional("code")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun codeOrThrow(): String = code.getRequired("code")

        /**
         * A public explanation of the delivery failure. The schema requires this property. Returns
         * empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun message(): java.util.Optional<String> = message.getOptional("message")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun messageOrThrow(): String = message.getRequired("message")

        /**
         * Returns the raw JSON value of [code].
         *
         * Unlike [code], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<String> = code

        /**
         * Returns the raw JSON value of [message].
         *
         * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

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
                "code" to this.code,
                "message" to this.message,
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
             * Returns a mutable builder for constructing an instance of [Error].
             *
             * The following fields are required:
             * ```java
             * .code()
             * .message()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Error]. */
        class Builder internal constructor() {

            private var code: JsonField<String>? = null
            private var message: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(error: Error) = apply {
                code = error.code
                message = error.message
                additionalProperties = error.additionalProperties.toMutableMap()
            }

            /** A machine-readable error code. */
            fun code(code: String) = code(JsonField.of(code))

            /**
             * Sets [Builder.code] to an arbitrary JSON value.
             *
             * You should usually call [Builder.code] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun code(code: JsonField<String>) = apply { this.code = code }

            /** A public explanation of the delivery failure. */
            fun message(message: String) = message(JsonField.of(message))

            /**
             * Sets [Builder.message] to an arbitrary JSON value.
             *
             * You should usually call [Builder.message] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun message(message: JsonField<String>) = apply { this.message = message }

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
             * Returns an immutable instance of [Error].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .code()
             * .message()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Error =
                Error(
                    checkRequired("code", code),
                    checkRequired("message", message),
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
        fun validate(): Error = apply {
            if (validated) {
                return@apply
            }

            codeOrThrow()
            messageOrThrow()
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
            (if (code.asKnown().isPresent) 1 else 0) + (if (message.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Error &&
                code == other.code &&
                message == other.message &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(code, message, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Error{code=$code, message=$message, additionalProperties=$additionalProperties}"
    }

    /** Why an occurrence was skipped, or null when it was not skipped. */
    class SkipReason @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val PENDING_DELIVERY = of("pending_delivery")

            @JvmStatic fun of(value: String) = SkipReason(JsonField.of(value))
        }

        /** An enum containing [SkipReason]'s known values. */
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
        enum class Known {
            PENDING_DELIVERY
        }

        /**
         * An enum containing [SkipReason]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [SkipReason] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
        enum class Value {
            PENDING_DELIVERY,
            /**
             * An enum member indicating that [SkipReason] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
        fun value(): Value =
            when (this) {
                PENDING_DELIVERY -> Value.PENDING_DELIVERY
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
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
        fun known(): Known =
            when (this) {
                PENDING_DELIVERY -> Known.PENDING_DELIVERY
                else -> throw OpenAIInvalidDataException("Unknown SkipReason: $value")
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
        fun validate(): SkipReason = apply {
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

            return other is SkipReason && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Delivery status; completed does not mean the agent's work has finished. */
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

            @JvmField val QUEUED = of("queued")

            @JvmField val COMPLETED = of("completed")

            @JvmField val FAILED = of("failed")

            @JvmField val SKIPPED = of("skipped")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
        enum class Known {
            QUEUED,
            COMPLETED,
            FAILED,
            SKIPPED,
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
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
        enum class Value {
            QUEUED,
            COMPLETED,
            FAILED,
            SKIPPED,
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
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
        fun value(): Value =
            when (this) {
                QUEUED -> Value.QUEUED
                COMPLETED -> Value.COMPLETED
                FAILED -> Value.FAILED
                SKIPPED -> Value.SKIPPED
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
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
        fun known(): Known =
            when (this) {
                QUEUED -> Known.QUEUED
                COMPLETED -> Known.COMPLETED
                FAILED -> Known.FAILED
                SKIPPED -> Known.SKIPPED
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

        return other is AutomationInvocation &&
            id == other.id &&
            automationId == other.automationId &&
            createdAt == other.createdAt &&
            error == other.error &&
            object_ == other.object_ &&
            scheduledAt == other.scheduledAt &&
            sessionId == other.sessionId &&
            skipReason == other.skipReason &&
            source == other.source &&
            status == other.status &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            automationId,
            createdAt,
            error,
            object_,
            scheduledAt,
            sessionId,
            skipReason,
            source,
            status,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AutomationInvocation{id=$id, automationId=$automationId, createdAt=$createdAt, error=$error, object_=$object_, scheduledAt=$scheduledAt, sessionId=$sessionId, skipReason=$skipReason, source=$source, status=$status, additionalProperties=$additionalProperties}"
}
