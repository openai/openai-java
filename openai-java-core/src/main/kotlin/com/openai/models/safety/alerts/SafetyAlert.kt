// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.safety.alerts

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

class SafetyAlert
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<Long>,
    private val errorType: JsonField<ErrorType>,
    private val model: JsonField<String>,
    private val object_: JsonValue,
    private val reason: JsonField<String>,
    private val requestId: JsonField<String>,
    private val requestPaused: JsonField<Boolean>,
    private val responseId: JsonField<String>,
    private val detailedExplanation: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("error_type")
        @ExcludeMissing
        errorType: JsonField<ErrorType> = JsonMissing.of(),
        @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("reason") @ExcludeMissing reason: JsonField<String> = JsonMissing.of(),
        @JsonProperty("request_id") @ExcludeMissing requestId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("request_paused")
        @ExcludeMissing
        requestPaused: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("response_id")
        @ExcludeMissing
        responseId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("detailed_explanation")
        @ExcludeMissing
        detailedExplanation: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        createdAt,
        errorType,
        model,
        object_,
        reason,
        requestId,
        requestPaused,
        responseId,
        detailedExplanation,
        mutableMapOf(),
    )

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
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun createdAt(): java.util.Optional<Long> = createdAt.getOptional("created_at")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun createdAtOrThrow(): Long = createdAt.getRequired("created_at")

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun errorType(): java.util.Optional<ErrorType> = errorType.getOptional("error_type")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun errorTypeOrThrow(): ErrorType = errorType.getRequired("error_type")

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun model(): java.util.Optional<String> = model.getOptional("model")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun modelOrThrow(): String = model.getRequired("model")

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun object_(): java.util.Optional<JsonValue> {
        val raw = object_
        return when {
            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
            !(raw == JsonValue.from("safety.alert")) ->
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
     * A customer-safe description derived from error_type, or null for zero data retention
     * requests. The schema requires this property. Returns empty if the JSON property is missing or
     * null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun reason(): java.util.Optional<String> = reason.getOptional("reason")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun reasonOrThrow(): String = reason.getRequired("reason")

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun requestId(): java.util.Optional<String> = requestId.getOptional("request_id")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun requestIdOrThrow(): String = requestId.getRequired("request_id")

    /**
     * Whether block registration succeeded for this request. This does not confirm that response
     * execution stopped. The schema requires this property. Returns empty if the JSON property is
     * missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun requestPaused(): java.util.Optional<Boolean> = requestPaused.getOptional("request_paused")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun requestPausedOrThrow(): Boolean = requestPaused.getRequired("request_paused")

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun responseId(): java.util.Optional<String> = responseId.getOptional("response_id")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun responseIdOrThrow(): String = responseId.getRequired("response_id")

    /**
     * A generated explanation, temporarily available for eligible zero data retention alerts.
     * Omitted when unavailable. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun detailedExplanation(): java.util.Optional<String> =
        detailedExplanation.getOptional("detailed_explanation")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun detailedExplanationOrThrow(): String =
        detailedExplanation.getRequired("detailed_explanation")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt(): JsonField<Long> = createdAt

    /**
     * Returns the raw JSON value of [errorType].
     *
     * Unlike [errorType], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("error_type") @ExcludeMissing fun _errorType(): JsonField<ErrorType> = errorType

    /**
     * Returns the raw JSON value of [model].
     *
     * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

    /**
     * Returns the raw JSON value of [reason].
     *
     * Unlike [reason], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<String> = reason

    /**
     * Returns the raw JSON value of [requestId].
     *
     * Unlike [requestId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("request_id") @ExcludeMissing fun _requestId(): JsonField<String> = requestId

    /**
     * Returns the raw JSON value of [requestPaused].
     *
     * Unlike [requestPaused], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("request_paused")
    @ExcludeMissing
    fun _requestPaused(): JsonField<Boolean> = requestPaused

    /**
     * Returns the raw JSON value of [responseId].
     *
     * Unlike [responseId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("response_id") @ExcludeMissing fun _responseId(): JsonField<String> = responseId

    /**
     * Returns the raw JSON value of [detailedExplanation].
     *
     * Unlike [detailedExplanation], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("detailed_explanation")
    @ExcludeMissing
    fun _detailedExplanation(): JsonField<String> = detailedExplanation

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
            "created_at" to this.createdAt,
            "error_type" to this.errorType,
            "model" to this.model,
            "object" to this.object_,
            "reason" to this.reason,
            "request_id" to this.requestId,
            "request_paused" to this.requestPaused,
            "response_id" to this.responseId,
            "detailed_explanation" to this.detailedExplanation,
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
         * Returns a mutable builder for constructing an instance of [SafetyAlert].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .errorType()
         * .model()
         * .requestId()
         * .requestPaused()
         * .responseId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SafetyAlert]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var createdAt: JsonField<Long>? = null
        private var errorType: JsonField<ErrorType>? = null
        private var model: JsonField<String>? = null
        private var object_: JsonValue = JsonValue.from("safety.alert")
        private var reason: JsonField<String>? = JsonNull.of()
        private var requestId: JsonField<String>? = null
        private var requestPaused: JsonField<Boolean>? = null
        private var responseId: JsonField<String>? = null
        private var detailedExplanation: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(safetyAlert: SafetyAlert) = apply {
            id = safetyAlert.id
            createdAt = safetyAlert.createdAt
            errorType = safetyAlert.errorType
            model = safetyAlert.model
            object_ = safetyAlert.object_
            reason = safetyAlert.reason
            requestId = safetyAlert.requestId
            requestPaused = safetyAlert.requestPaused
            responseId = safetyAlert.responseId
            detailedExplanation = safetyAlert.detailedExplanation
            additionalProperties = safetyAlert.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        fun errorType(errorType: ErrorType) = errorType(JsonField.of(errorType))

        /**
         * Sets [Builder.errorType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.errorType] with a well-typed [ErrorType] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun errorType(errorType: JsonField<ErrorType>) = apply { this.errorType = errorType }

        fun model(model: String) = model(JsonField.of(model))

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(model: JsonField<String>) = apply { this.model = model }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("safety.alert")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /**
         * A customer-safe description derived from error_type, or null for zero data retention
         * requests.
         */
        fun reason(reason: String?) = reason(JsonField.ofNullable(reason))

        /** Alias for calling [Builder.reason] with `reason.orElse(null)`. */
        fun reason(reason: Optional<String>) = reason(reason.getOrNull())

        /**
         * Sets [Builder.reason] to an arbitrary JSON value.
         *
         * You should usually call [Builder.reason] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun reason(reason: JsonField<String>) = apply { this.reason = reason }

        fun requestId(requestId: String) = requestId(JsonField.of(requestId))

        /**
         * Sets [Builder.requestId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.requestId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun requestId(requestId: JsonField<String>) = apply { this.requestId = requestId }

        /**
         * Whether block registration succeeded for this request. This does not confirm that
         * response execution stopped.
         */
        fun requestPaused(requestPaused: Boolean) = requestPaused(JsonField.of(requestPaused))

        /**
         * Sets [Builder.requestPaused] to an arbitrary JSON value.
         *
         * You should usually call [Builder.requestPaused] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun requestPaused(requestPaused: JsonField<Boolean>) = apply {
            this.requestPaused = requestPaused
        }

        fun responseId(responseId: String) = responseId(JsonField.of(responseId))

        /**
         * Sets [Builder.responseId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.responseId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun responseId(responseId: JsonField<String>) = apply { this.responseId = responseId }

        /**
         * A generated explanation, temporarily available for eligible zero data retention alerts.
         * Omitted when unavailable.
         */
        fun detailedExplanation(detailedExplanation: String?) =
            detailedExplanation(JsonField.ofNullable(detailedExplanation))

        /**
         * Alias for calling [Builder.detailedExplanation] with `detailedExplanation.orElse(null)`.
         */
        fun detailedExplanation(detailedExplanation: Optional<String>) =
            detailedExplanation(detailedExplanation.getOrNull())

        /**
         * Sets [Builder.detailedExplanation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.detailedExplanation] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun detailedExplanation(detailedExplanation: JsonField<String>) = apply {
            this.detailedExplanation = detailedExplanation
        }

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
         * Returns an immutable instance of [SafetyAlert].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .errorType()
         * .model()
         * .requestId()
         * .requestPaused()
         * .responseId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SafetyAlert =
            SafetyAlert(
                checkRequired("id", id),
                checkRequired("createdAt", createdAt),
                checkRequired("errorType", errorType),
                checkRequired("model", model),
                object_,
                checkRequired("reason", reason),
                checkRequired("requestId", requestId),
                checkRequired("requestPaused", requestPaused),
                checkRequired("responseId", responseId),
                detailedExplanation,
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
    fun validate(): SafetyAlert = apply {
        if (validated) {
            return@apply
        }

        idOrThrow()
        createdAtOrThrow()
        errorTypeOrThrow().validate()
        modelOrThrow()
        object_OrThrow()
        reason()
        requestIdOrThrow()
        requestPausedOrThrow()
        responseIdOrThrow()
        detailedExplanation()
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
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (errorType.asKnown().getOrNull()?.validity() ?: 0) +
            (if (model.asKnown().isPresent) 1 else 0) +
            object_.let { if (it == JsonValue.from("safety.alert")) 1 else 0 } +
            (if (reason.asKnown().isPresent) 1 else 0) +
            (if (requestId.asKnown().isPresent) 1 else 0) +
            (if (requestPaused.asKnown().isPresent) 1 else 0) +
            (if (responseId.asKnown().isPresent) 1 else 0) +
            (if (detailedExplanation.asKnown().isPresent) 1 else 0)

    class ErrorType @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField
            val POTENTIALLY_UNINTENDED_DATA_TRANSFER = of("potentially_unintended_data_transfer")

            @JvmField
            val POTENTIALLY_UNINTENDED_DATA_ACCESS = of("potentially_unintended_data_access")

            @JvmField
            val POTENTIALLY_UNINTENDED_DESTRUCTIVE_ACTIVITY =
                of("potentially_unintended_destructive_activity")

            @JvmField val OTHER = of("other")

            @JvmStatic fun of(value: String) = ErrorType(JsonField.of(value))
        }

        /** An enum containing [ErrorType]'s known values. */
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
        enum class Known {
            POTENTIALLY_UNINTENDED_DATA_TRANSFER,
            POTENTIALLY_UNINTENDED_DATA_ACCESS,
            POTENTIALLY_UNINTENDED_DESTRUCTIVE_ACTIVITY,
            OTHER,
        }

        /**
         * An enum containing [ErrorType]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [ErrorType] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
        enum class Value {
            POTENTIALLY_UNINTENDED_DATA_TRANSFER,
            POTENTIALLY_UNINTENDED_DATA_ACCESS,
            POTENTIALLY_UNINTENDED_DESTRUCTIVE_ACTIVITY,
            OTHER,
            /**
             * An enum member indicating that [ErrorType] was instantiated with an unknown value.
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
                POTENTIALLY_UNINTENDED_DATA_TRANSFER -> Value.POTENTIALLY_UNINTENDED_DATA_TRANSFER
                POTENTIALLY_UNINTENDED_DATA_ACCESS -> Value.POTENTIALLY_UNINTENDED_DATA_ACCESS
                POTENTIALLY_UNINTENDED_DESTRUCTIVE_ACTIVITY ->
                    Value.POTENTIALLY_UNINTENDED_DESTRUCTIVE_ACTIVITY
                OTHER -> Value.OTHER
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
                POTENTIALLY_UNINTENDED_DATA_TRANSFER -> Known.POTENTIALLY_UNINTENDED_DATA_TRANSFER
                POTENTIALLY_UNINTENDED_DATA_ACCESS -> Known.POTENTIALLY_UNINTENDED_DATA_ACCESS
                POTENTIALLY_UNINTENDED_DESTRUCTIVE_ACTIVITY ->
                    Known.POTENTIALLY_UNINTENDED_DESTRUCTIVE_ACTIVITY
                OTHER -> Known.OTHER
                else -> throw OpenAIInvalidDataException("Unknown ErrorType: $value")
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
        fun validate(): ErrorType = apply {
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

            return other is ErrorType && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SafetyAlert &&
            id == other.id &&
            createdAt == other.createdAt &&
            errorType == other.errorType &&
            model == other.model &&
            object_ == other.object_ &&
            reason == other.reason &&
            requestId == other.requestId &&
            requestPaused == other.requestPaused &&
            responseId == other.responseId &&
            detailedExplanation == other.detailedExplanation &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            createdAt,
            errorType,
            model,
            object_,
            reason,
            requestId,
            requestPaused,
            responseId,
            detailedExplanation,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SafetyAlert{id=$id, createdAt=$createdAt, errorType=$errorType, model=$model, object_=$object_, reason=$reason, requestId=$requestId, requestPaused=$requestPaused, responseId=$responseId, detailedExplanation=$detailedExplanation, additionalProperties=$additionalProperties}"
}
