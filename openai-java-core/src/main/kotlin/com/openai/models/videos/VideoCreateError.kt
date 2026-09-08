// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.videos

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

/** An error that occurred while generating the response. */
class VideoCreateError
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val code: JsonField<String>,
    private val message: JsonField<String>,
    private val misalignment: JsonField<Misalignment>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("code") @ExcludeMissing code: JsonField<String> = JsonMissing.of(),
        @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
        @JsonProperty("misalignment")
        @ExcludeMissing
        misalignment: JsonField<Misalignment> = JsonMissing.of(),
    ) : this(code, message, misalignment, mutableMapOf())

    /**
     * A machine-readable error code that was returned.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun code(): String = code.getRequired("code")

    /**
     * A human-readable description of the error that was returned.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun message(): String = message.getRequired("message")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun misalignment(): Optional<Misalignment> = misalignment.getOptional("misalignment")

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

    /**
     * Returns the raw JSON value of [misalignment].
     *
     * Unlike [misalignment], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("misalignment")
    @ExcludeMissing
    fun _misalignment(): JsonField<Misalignment> = misalignment

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
         * Returns a mutable builder for constructing an instance of [VideoCreateError].
         *
         * The following fields are required:
         * ```java
         * .code()
         * .message()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [VideoCreateError]. */
    class Builder internal constructor() {

        private var code: JsonField<String>? = null
        private var message: JsonField<String>? = null
        private var misalignment: JsonField<Misalignment> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(videoCreateError: VideoCreateError) = apply {
            code = videoCreateError.code
            message = videoCreateError.message
            misalignment = videoCreateError.misalignment
            additionalProperties = videoCreateError.additionalProperties.toMutableMap()
        }

        /** A machine-readable error code that was returned. */
        fun code(code: String) = code(JsonField.of(code))

        /**
         * Sets [Builder.code] to an arbitrary JSON value.
         *
         * You should usually call [Builder.code] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun code(code: JsonField<String>) = apply { this.code = code }

        /** A human-readable description of the error that was returned. */
        fun message(message: String) = message(JsonField.of(message))

        /**
         * Sets [Builder.message] to an arbitrary JSON value.
         *
         * You should usually call [Builder.message] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun message(message: JsonField<String>) = apply { this.message = message }

        fun misalignment(misalignment: Misalignment) = misalignment(JsonField.of(misalignment))

        /**
         * Sets [Builder.misalignment] to an arbitrary JSON value.
         *
         * You should usually call [Builder.misalignment] with a well-typed [Misalignment] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun misalignment(misalignment: JsonField<Misalignment>) = apply {
            this.misalignment = misalignment
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
         * Returns an immutable instance of [VideoCreateError].
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
        fun build(): VideoCreateError =
            VideoCreateError(
                checkRequired("code", code),
                checkRequired("message", message),
                misalignment,
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
    fun validate(): VideoCreateError = apply {
        if (validated) {
            return@apply
        }

        code()
        message()
        misalignment().ifPresent { it.validate() }
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
        (if (code.asKnown().isPresent) 1 else 0) +
            (if (message.asKnown().isPresent) 1 else 0) +
            (misalignment.asKnown().getOrNull()?.validity() ?: 0)

    class Misalignment
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val detailedExplanation: JsonField<String>,
        private val errorType: JsonField<ErrorType>,
        private val steer: JsonField<Steer>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("detailed_explanation")
            @ExcludeMissing
            detailedExplanation: JsonField<String> = JsonMissing.of(),
            @JsonProperty("error_type")
            @ExcludeMissing
            errorType: JsonField<ErrorType> = JsonMissing.of(),
            @JsonProperty("steer") @ExcludeMissing steer: JsonField<Steer> = JsonMissing.of(),
        ) : this(detailedExplanation, errorType, steer, mutableMapOf())

        /**
         * The public explanation for this block.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun detailedExplanation(): Optional<String> =
            detailedExplanation.getOptional("detailed_explanation")

        /**
         * An optional classification; clients must accept additional values.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun errorType(): Optional<ErrorType> = errorType.getOptional("error_type")

        /**
         * An optional public continuation instruction.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun steer(): Optional<Steer> = steer.getOptional("steer")

        /**
         * Returns the raw JSON value of [detailedExplanation].
         *
         * Unlike [detailedExplanation], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("detailed_explanation")
        @ExcludeMissing
        fun _detailedExplanation(): JsonField<String> = detailedExplanation

        /**
         * Returns the raw JSON value of [errorType].
         *
         * Unlike [errorType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("error_type")
        @ExcludeMissing
        fun _errorType(): JsonField<ErrorType> = errorType

        /**
         * Returns the raw JSON value of [steer].
         *
         * Unlike [steer], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("steer") @ExcludeMissing fun _steer(): JsonField<Steer> = steer

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

            /** Returns a mutable builder for constructing an instance of [Misalignment]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Misalignment]. */
        class Builder internal constructor() {

            private var detailedExplanation: JsonField<String> = JsonMissing.of()
            private var errorType: JsonField<ErrorType> = JsonMissing.of()
            private var steer: JsonField<Steer> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(misalignment: Misalignment) = apply {
                detailedExplanation = misalignment.detailedExplanation
                errorType = misalignment.errorType
                steer = misalignment.steer
                additionalProperties = misalignment.additionalProperties.toMutableMap()
            }

            /** The public explanation for this block. */
            fun detailedExplanation(detailedExplanation: String) =
                detailedExplanation(JsonField.of(detailedExplanation))

            /**
             * Sets [Builder.detailedExplanation] to an arbitrary JSON value.
             *
             * You should usually call [Builder.detailedExplanation] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun detailedExplanation(detailedExplanation: JsonField<String>) = apply {
                this.detailedExplanation = detailedExplanation
            }

            /** An optional classification; clients must accept additional values. */
            fun errorType(errorType: ErrorType) = errorType(JsonField.of(errorType))

            /**
             * Sets [Builder.errorType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.errorType] with a well-typed [ErrorType] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun errorType(errorType: JsonField<ErrorType>) = apply { this.errorType = errorType }

            /**
             * Sets [errorType] to an arbitrary [String].
             *
             * You should usually call [errorType] with a well-typed [ErrorType] constant instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun errorType(value: String) = errorType(ErrorType.of(value))

            /** An optional public continuation instruction. */
            fun steer(steer: Steer) = steer(JsonField.of(steer))

            /**
             * Sets [Builder.steer] to an arbitrary JSON value.
             *
             * You should usually call [Builder.steer] with a well-typed [Steer] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun steer(steer: JsonField<Steer>) = apply { this.steer = steer }

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
             * Returns an immutable instance of [Misalignment].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Misalignment =
                Misalignment(
                    detailedExplanation,
                    errorType,
                    steer,
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
        fun validate(): Misalignment = apply {
            if (validated) {
                return@apply
            }

            detailedExplanation()
            errorType()
            steer().ifPresent { it.validate() }
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
            (if (detailedExplanation.asKnown().isPresent) 1 else 0) +
                (if (errorType.asKnown().isPresent) 1 else 0) +
                (steer.asKnown().getOrNull()?.validity() ?: 0)

        /** An optional classification; clients must accept additional values. */
        class ErrorType @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField
                val POTENTIALLY_UNINTENDED_DATA_TRANSFER =
                    of("potentially_unintended_data_transfer")

                @JvmField
                val POTENTIALLY_UNINTENDED_DATA_ACCESS = of("potentially_unintended_data_access")

                @JvmField
                val POTENTIALLY_UNINTENDED_DESTRUCTIVE_ACTIVITY =
                    of("potentially_unintended_destructive_activity")

                @JvmField val OTHER = of("other")

                @JvmStatic fun of(value: String) = ErrorType(JsonField.of(value))
            }

            /** An enum containing [ErrorType]'s known values. */
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
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                POTENTIALLY_UNINTENDED_DATA_TRANSFER,
                POTENTIALLY_UNINTENDED_DATA_ACCESS,
                POTENTIALLY_UNINTENDED_DESTRUCTIVE_ACTIVITY,
                OTHER,
                /**
                 * An enum member indicating that [ErrorType] was instantiated with an unknown
                 * value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    POTENTIALLY_UNINTENDED_DATA_TRANSFER ->
                        Value.POTENTIALLY_UNINTENDED_DATA_TRANSFER
                    POTENTIALLY_UNINTENDED_DATA_ACCESS -> Value.POTENTIALLY_UNINTENDED_DATA_ACCESS
                    POTENTIALLY_UNINTENDED_DESTRUCTIVE_ACTIVITY ->
                        Value.POTENTIALLY_UNINTENDED_DESTRUCTIVE_ACTIVITY
                    OTHER -> Value.OTHER
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws OpenAIInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    POTENTIALLY_UNINTENDED_DATA_TRANSFER ->
                        Known.POTENTIALLY_UNINTENDED_DATA_TRANSFER
                    POTENTIALLY_UNINTENDED_DATA_ACCESS -> Known.POTENTIALLY_UNINTENDED_DATA_ACCESS
                    POTENTIALLY_UNINTENDED_DESTRUCTIVE_ACTIVITY ->
                        Known.POTENTIALLY_UNINTENDED_DESTRUCTIVE_ACTIVITY
                    OTHER -> Known.OTHER
                    else -> throw OpenAIInvalidDataException("Unknown ErrorType: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws OpenAIInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    OpenAIInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
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

        /** An optional public continuation instruction. */
        class Steer
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val message: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("message")
                @ExcludeMissing
                message: JsonField<String> = JsonMissing.of()
            ) : this(message, mutableMapOf())

            /**
             * The public continuation instruction.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun message(): String = message.getRequired("message")

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

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Steer].
                 *
                 * The following fields are required:
                 * ```java
                 * .message()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Steer]. */
            class Builder internal constructor() {

                private var message: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(steer: Steer) = apply {
                    message = steer.message
                    additionalProperties = steer.additionalProperties.toMutableMap()
                }

                /** The public continuation instruction. */
                fun message(message: String) = message(JsonField.of(message))

                /**
                 * Sets [Builder.message] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.message] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun message(message: JsonField<String>) = apply { this.message = message }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Steer].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .message()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Steer =
                    Steer(checkRequired("message", message), additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Steer = apply {
                if (validated) {
                    return@apply
                }

                message()
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
            @JvmSynthetic internal fun validity(): Int = (if (message.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Steer &&
                    message == other.message &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(message, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Steer{message=$message, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Misalignment &&
                detailedExplanation == other.detailedExplanation &&
                errorType == other.errorType &&
                steer == other.steer &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(detailedExplanation, errorType, steer, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Misalignment{detailedExplanation=$detailedExplanation, errorType=$errorType, steer=$steer, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is VideoCreateError &&
            code == other.code &&
            message == other.message &&
            misalignment == other.misalignment &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(code, message, misalignment, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "VideoCreateError{code=$code, message=$message, misalignment=$misalignment, additionalProperties=$additionalProperties}"
}
