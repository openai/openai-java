// File generated from our OpenAPI spec by Stainless.

package com.openai.models.containers

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

class ContainerCreateResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<Long>,
    private val name: JsonField<String>,
    private val object_: JsonField<String>,
    private val status: JsonField<String>,
    private val expiresAfter: JsonField<ExpiresAfter>,
    private val lastActiveAt: JsonField<Long>,
    private val memoryLimit: JsonField<MemoryLimit>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
        @JsonProperty("expires_after")
        @ExcludeMissing
        expiresAfter: JsonField<ExpiresAfter> = JsonMissing.of(),
        @JsonProperty("last_active_at")
        @ExcludeMissing
        lastActiveAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("memory_limit")
        @ExcludeMissing
        memoryLimit: JsonField<MemoryLimit> = JsonMissing.of(),
    ) : this(
        id,
        createdAt,
        name,
        object_,
        status,
        expiresAfter,
        lastActiveAt,
        memoryLimit,
        mutableMapOf(),
    )

    /**
     * Unique identifier for the container.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Unix timestamp (in seconds) when the container was created.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /**
     * Name of the container.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = name.getRequired("name")

    /**
     * The type of this object.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun object_(): String = object_.getRequired("object")

    /**
     * Status of the container (e.g., active, deleted).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): String = status.getRequired("status")

    /**
     * The container will expire after this time period. The anchor is the reference point for the
     * expiration. The minutes is the number of minutes after the anchor before the container
     * expires.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun expiresAfter(): Optional<ExpiresAfter> = expiresAfter.getOptional("expires_after")

    /**
     * Unix timestamp (in seconds) when the container was last active.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun lastActiveAt(): Optional<Long> = lastActiveAt.getOptional("last_active_at")

    /**
     * The memory limit configured for the container.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun memoryLimit(): Optional<MemoryLimit> = memoryLimit.getOptional("memory_limit")

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
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<String> = object_

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

    /**
     * Returns the raw JSON value of [expiresAfter].
     *
     * Unlike [expiresAfter], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("expires_after")
    @ExcludeMissing
    fun _expiresAfter(): JsonField<ExpiresAfter> = expiresAfter

    /**
     * Returns the raw JSON value of [lastActiveAt].
     *
     * Unlike [lastActiveAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("last_active_at")
    @ExcludeMissing
    fun _lastActiveAt(): JsonField<Long> = lastActiveAt

    /**
     * Returns the raw JSON value of [memoryLimit].
     *
     * Unlike [memoryLimit], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("memory_limit")
    @ExcludeMissing
    fun _memoryLimit(): JsonField<MemoryLimit> = memoryLimit

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
         * Returns a mutable builder for constructing an instance of [ContainerCreateResponse].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .name()
         * .object_()
         * .status()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ContainerCreateResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var createdAt: JsonField<Long>? = null
        private var name: JsonField<String>? = null
        private var object_: JsonField<String>? = null
        private var status: JsonField<String>? = null
        private var expiresAfter: JsonField<ExpiresAfter> = JsonMissing.of()
        private var lastActiveAt: JsonField<Long> = JsonMissing.of()
        private var memoryLimit: JsonField<MemoryLimit> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(containerCreateResponse: ContainerCreateResponse) = apply {
            id = containerCreateResponse.id
            createdAt = containerCreateResponse.createdAt
            name = containerCreateResponse.name
            object_ = containerCreateResponse.object_
            status = containerCreateResponse.status
            expiresAfter = containerCreateResponse.expiresAfter
            lastActiveAt = containerCreateResponse.lastActiveAt
            memoryLimit = containerCreateResponse.memoryLimit
            additionalProperties = containerCreateResponse.additionalProperties.toMutableMap()
        }

        /** Unique identifier for the container. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Unix timestamp (in seconds) when the container was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /** Name of the container. */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** The type of this object. */
        fun object_(object_: String) = object_(JsonField.of(object_))

        /**
         * Sets [Builder.object_] to an arbitrary JSON value.
         *
         * You should usually call [Builder.object_] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun object_(object_: JsonField<String>) = apply { this.object_ = object_ }

        /** Status of the container (e.g., active, deleted). */
        fun status(status: String) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<String>) = apply { this.status = status }

        /**
         * The container will expire after this time period. The anchor is the reference point for
         * the expiration. The minutes is the number of minutes after the anchor before the
         * container expires.
         */
        fun expiresAfter(expiresAfter: ExpiresAfter) = expiresAfter(JsonField.of(expiresAfter))

        /**
         * Sets [Builder.expiresAfter] to an arbitrary JSON value.
         *
         * You should usually call [Builder.expiresAfter] with a well-typed [ExpiresAfter] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun expiresAfter(expiresAfter: JsonField<ExpiresAfter>) = apply {
            this.expiresAfter = expiresAfter
        }

        /** Unix timestamp (in seconds) when the container was last active. */
        fun lastActiveAt(lastActiveAt: Long) = lastActiveAt(JsonField.of(lastActiveAt))

        /**
         * Sets [Builder.lastActiveAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.lastActiveAt] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun lastActiveAt(lastActiveAt: JsonField<Long>) = apply { this.lastActiveAt = lastActiveAt }

        /** The memory limit configured for the container. */
        fun memoryLimit(memoryLimit: MemoryLimit) = memoryLimit(JsonField.of(memoryLimit))

        /**
         * Sets [Builder.memoryLimit] to an arbitrary JSON value.
         *
         * You should usually call [Builder.memoryLimit] with a well-typed [MemoryLimit] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun memoryLimit(memoryLimit: JsonField<MemoryLimit>) = apply {
            this.memoryLimit = memoryLimit
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
         * Returns an immutable instance of [ContainerCreateResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .name()
         * .object_()
         * .status()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ContainerCreateResponse =
            ContainerCreateResponse(
                checkRequired("id", id),
                checkRequired("createdAt", createdAt),
                checkRequired("name", name),
                checkRequired("object_", object_),
                checkRequired("status", status),
                expiresAfter,
                lastActiveAt,
                memoryLimit,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ContainerCreateResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        createdAt()
        name()
        object_()
        status()
        expiresAfter().ifPresent { it.validate() }
        lastActiveAt()
        memoryLimit().ifPresent { it.validate() }
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
            (if (name.asKnown().isPresent) 1 else 0) +
            (if (object_.asKnown().isPresent) 1 else 0) +
            (if (status.asKnown().isPresent) 1 else 0) +
            (expiresAfter.asKnown().getOrNull()?.validity() ?: 0) +
            (if (lastActiveAt.asKnown().isPresent) 1 else 0) +
            (memoryLimit.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * The container will expire after this time period. The anchor is the reference point for the
     * expiration. The minutes is the number of minutes after the anchor before the container
     * expires.
     */
    class ExpiresAfter
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val anchor: JsonField<Anchor>,
        private val minutes: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("anchor") @ExcludeMissing anchor: JsonField<Anchor> = JsonMissing.of(),
            @JsonProperty("minutes") @ExcludeMissing minutes: JsonField<Long> = JsonMissing.of(),
        ) : this(anchor, minutes, mutableMapOf())

        /**
         * The reference point for the expiration.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun anchor(): Optional<Anchor> = anchor.getOptional("anchor")

        /**
         * The number of minutes after the anchor before the container expires.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun minutes(): Optional<Long> = minutes.getOptional("minutes")

        /**
         * Returns the raw JSON value of [anchor].
         *
         * Unlike [anchor], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("anchor") @ExcludeMissing fun _anchor(): JsonField<Anchor> = anchor

        /**
         * Returns the raw JSON value of [minutes].
         *
         * Unlike [minutes], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("minutes") @ExcludeMissing fun _minutes(): JsonField<Long> = minutes

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

            /** Returns a mutable builder for constructing an instance of [ExpiresAfter]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ExpiresAfter]. */
        class Builder internal constructor() {

            private var anchor: JsonField<Anchor> = JsonMissing.of()
            private var minutes: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(expiresAfter: ExpiresAfter) = apply {
                anchor = expiresAfter.anchor
                minutes = expiresAfter.minutes
                additionalProperties = expiresAfter.additionalProperties.toMutableMap()
            }

            /** The reference point for the expiration. */
            fun anchor(anchor: Anchor) = anchor(JsonField.of(anchor))

            /**
             * Sets [Builder.anchor] to an arbitrary JSON value.
             *
             * You should usually call [Builder.anchor] with a well-typed [Anchor] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun anchor(anchor: JsonField<Anchor>) = apply { this.anchor = anchor }

            /** The number of minutes after the anchor before the container expires. */
            fun minutes(minutes: Long) = minutes(JsonField.of(minutes))

            /**
             * Sets [Builder.minutes] to an arbitrary JSON value.
             *
             * You should usually call [Builder.minutes] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun minutes(minutes: JsonField<Long>) = apply { this.minutes = minutes }

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
             * Returns an immutable instance of [ExpiresAfter].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): ExpiresAfter =
                ExpiresAfter(anchor, minutes, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): ExpiresAfter = apply {
            if (validated) {
                return@apply
            }

            anchor().ifPresent { it.validate() }
            minutes()
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
            (anchor.asKnown().getOrNull()?.validity() ?: 0) +
                (if (minutes.asKnown().isPresent) 1 else 0)

        /** The reference point for the expiration. */
        class Anchor @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val LAST_ACTIVE_AT = of("last_active_at")

                @JvmStatic fun of(value: String) = Anchor(JsonField.of(value))
            }

            /** An enum containing [Anchor]'s known values. */
            enum class Known {
                LAST_ACTIVE_AT
            }

            /**
             * An enum containing [Anchor]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Anchor] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                LAST_ACTIVE_AT,
                /**
                 * An enum member indicating that [Anchor] was instantiated with an unknown value.
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
                    LAST_ACTIVE_AT -> Value.LAST_ACTIVE_AT
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
                    LAST_ACTIVE_AT -> Known.LAST_ACTIVE_AT
                    else -> throw OpenAIInvalidDataException("Unknown Anchor: $value")
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

            fun validate(): Anchor = apply {
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

                return other is Anchor && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ExpiresAfter &&
                anchor == other.anchor &&
                minutes == other.minutes &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(anchor, minutes, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ExpiresAfter{anchor=$anchor, minutes=$minutes, additionalProperties=$additionalProperties}"
    }

    /** The memory limit configured for the container. */
    class MemoryLimit @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

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

            @JvmField val _1G = of("1g")

            @JvmField val _4G = of("4g")

            @JvmField val _16G = of("16g")

            @JvmField val _64G = of("64g")

            @JvmStatic fun of(value: String) = MemoryLimit(JsonField.of(value))
        }

        /** An enum containing [MemoryLimit]'s known values. */
        enum class Known {
            _1G,
            _4G,
            _16G,
            _64G,
        }

        /**
         * An enum containing [MemoryLimit]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [MemoryLimit] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            _1G,
            _4G,
            _16G,
            _64G,
            /**
             * An enum member indicating that [MemoryLimit] was instantiated with an unknown value.
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
        fun value(): Value =
            when (this) {
                _1G -> Value._1G
                _4G -> Value._4G
                _16G -> Value._16G
                _64G -> Value._64G
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
                _1G -> Known._1G
                _4G -> Known._4G
                _16G -> Known._16G
                _64G -> Known._64G
                else -> throw OpenAIInvalidDataException("Unknown MemoryLimit: $value")
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

        fun validate(): MemoryLimit = apply {
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

            return other is MemoryLimit && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ContainerCreateResponse &&
            id == other.id &&
            createdAt == other.createdAt &&
            name == other.name &&
            object_ == other.object_ &&
            status == other.status &&
            expiresAfter == other.expiresAfter &&
            lastActiveAt == other.lastActiveAt &&
            memoryLimit == other.memoryLimit &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            createdAt,
            name,
            object_,
            status,
            expiresAfter,
            lastActiveAt,
            memoryLimit,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ContainerCreateResponse{id=$id, createdAt=$createdAt, name=$name, object_=$object_, status=$status, expiresAfter=$expiresAfter, lastActiveAt=$lastActiveAt, memoryLimit=$memoryLimit, additionalProperties=$additionalProperties}"
}
