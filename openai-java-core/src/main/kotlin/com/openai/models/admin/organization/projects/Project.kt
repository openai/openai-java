// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.projects

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

/** Represents an individual project. */
class Project
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<Long>,
    private val object_: JsonValue,
    private val archivedAt: JsonField<Long>,
    private val externalKeyId: JsonField<String>,
    private val name: JsonField<String>,
    private val residency: JsonField<Residency>,
    private val status: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("archived_at") @ExcludeMissing archivedAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("external_key_id")
        @ExcludeMissing
        externalKeyId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("residency")
        @ExcludeMissing
        residency: JsonField<Residency> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        createdAt,
        object_,
        archivedAt,
        externalKeyId,
        name,
        residency,
        status,
        mutableMapOf(),
    )

    /**
     * The identifier, which can be referenced in API endpoints
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The Unix timestamp (in seconds) of when the project was created.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /**
     * The object type, which is always `organization.project`
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("organization.project")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * The Unix timestamp (in seconds) of when the project was archived or `null`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun archivedAt(): Optional<Long> = archivedAt.getOptional("archived_at")

    /**
     * The external key associated with the project.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun externalKeyId(): Optional<String> = externalKeyId.getOptional("external_key_id")

    /**
     * The name of the project. This appears in reporting.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = name.getOptional("name")

    /**
     * The residency configuration for the project.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun residency(): Optional<Residency> = residency.getOptional("residency")

    /**
     * `active` or `archived`
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun status(): Optional<String> = status.getOptional("status")

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
     * Returns the raw JSON value of [archivedAt].
     *
     * Unlike [archivedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("archived_at") @ExcludeMissing fun _archivedAt(): JsonField<Long> = archivedAt

    /**
     * Returns the raw JSON value of [externalKeyId].
     *
     * Unlike [externalKeyId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("external_key_id")
    @ExcludeMissing
    fun _externalKeyId(): JsonField<String> = externalKeyId

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [residency].
     *
     * Unlike [residency], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("residency") @ExcludeMissing fun _residency(): JsonField<Residency> = residency

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

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
         * Returns a mutable builder for constructing an instance of [Project].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Project]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var createdAt: JsonField<Long>? = null
        private var object_: JsonValue = JsonValue.from("organization.project")
        private var archivedAt: JsonField<Long> = JsonMissing.of()
        private var externalKeyId: JsonField<String> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var residency: JsonField<Residency> = JsonMissing.of()
        private var status: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(project: Project) = apply {
            id = project.id
            createdAt = project.createdAt
            object_ = project.object_
            archivedAt = project.archivedAt
            externalKeyId = project.externalKeyId
            name = project.name
            residency = project.residency
            status = project.status
            additionalProperties = project.additionalProperties.toMutableMap()
        }

        /** The identifier, which can be referenced in API endpoints */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The Unix timestamp (in seconds) of when the project was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("organization.project")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /** The Unix timestamp (in seconds) of when the project was archived or `null`. */
        fun archivedAt(archivedAt: Long?) = archivedAt(JsonField.ofNullable(archivedAt))

        /**
         * Alias for [Builder.archivedAt].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun archivedAt(archivedAt: Long) = archivedAt(archivedAt as Long?)

        /** Alias for calling [Builder.archivedAt] with `archivedAt.orElse(null)`. */
        fun archivedAt(archivedAt: Optional<Long>) = archivedAt(archivedAt.getOrNull())

        /**
         * Sets [Builder.archivedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.archivedAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun archivedAt(archivedAt: JsonField<Long>) = apply { this.archivedAt = archivedAt }

        /** The external key associated with the project. */
        fun externalKeyId(externalKeyId: String?) =
            externalKeyId(JsonField.ofNullable(externalKeyId))

        /** Alias for calling [Builder.externalKeyId] with `externalKeyId.orElse(null)`. */
        fun externalKeyId(externalKeyId: Optional<String>) =
            externalKeyId(externalKeyId.getOrNull())

        /**
         * Sets [Builder.externalKeyId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.externalKeyId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun externalKeyId(externalKeyId: JsonField<String>) = apply {
            this.externalKeyId = externalKeyId
        }

        /** The name of the project. This appears in reporting. */
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

        /** The residency configuration for the project. */
        fun residency(residency: Residency) = residency(JsonField.of(residency))

        /**
         * Sets [Builder.residency] to an arbitrary JSON value.
         *
         * You should usually call [Builder.residency] with a well-typed [Residency] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun residency(residency: JsonField<Residency>) = apply { this.residency = residency }

        /** `active` or `archived` */
        fun status(status: String?) = status(JsonField.ofNullable(status))

        /** Alias for calling [Builder.status] with `status.orElse(null)`. */
        fun status(status: Optional<String>) = status(status.getOrNull())

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<String>) = apply { this.status = status }

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
         * Returns an immutable instance of [Project].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Project =
            Project(
                checkRequired("id", id),
                checkRequired("createdAt", createdAt),
                object_,
                archivedAt,
                externalKeyId,
                name,
                residency,
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
    fun validate(): Project = apply {
        if (validated) {
            return@apply
        }

        id()
        createdAt()
        _object_().let {
            if (it != JsonValue.from("organization.project")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        archivedAt()
        externalKeyId()
        name()
        residency().ifPresent { it.validate() }
        status()
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
            object_.let { if (it == JsonValue.from("organization.project")) 1 else 0 } +
            (if (archivedAt.asKnown().isPresent) 1 else 0) +
            (if (externalKeyId.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (residency.asKnown().getOrNull()?.validity() ?: 0) +
            (if (status.asKnown().isPresent) 1 else 0)

    /** The residency configuration for the project. */
    class Residency @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val GLOBAL = of("GLOBAL")

            @JvmField val US_STORAGE_PROCESSING = of("US_STORAGE_PROCESSING")

            @JvmField val EU_STORAGE_PROCESSING = of("EU_STORAGE_PROCESSING")

            @JvmField val JP_STORAGE = of("JP_STORAGE")

            @JvmField val KR_STORAGE = of("KR_STORAGE")

            @JvmField val CA_STORAGE = of("CA_STORAGE")

            @JvmField val SG_STORAGE = of("SG_STORAGE")

            @JvmField val IN_STORAGE = of("IN_STORAGE")

            @JvmField val AU_STORAGE = of("AU_STORAGE")

            @JvmField val GB_STORAGE = of("GB_STORAGE")

            @JvmField val AE_STORAGE = of("AE_STORAGE")

            @JvmField val AE_STORAGE_PROCESSING = of("AE_STORAGE_PROCESSING")

            @JvmStatic fun of(value: String) = Residency(JsonField.of(value))
        }

        /** An enum containing [Residency]'s known values. */
        enum class Known {
            GLOBAL,
            US_STORAGE_PROCESSING,
            EU_STORAGE_PROCESSING,
            JP_STORAGE,
            KR_STORAGE,
            CA_STORAGE,
            SG_STORAGE,
            IN_STORAGE,
            AU_STORAGE,
            GB_STORAGE,
            AE_STORAGE,
            AE_STORAGE_PROCESSING,
        }

        /**
         * An enum containing [Residency]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Residency] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            GLOBAL,
            US_STORAGE_PROCESSING,
            EU_STORAGE_PROCESSING,
            JP_STORAGE,
            KR_STORAGE,
            CA_STORAGE,
            SG_STORAGE,
            IN_STORAGE,
            AU_STORAGE,
            GB_STORAGE,
            AE_STORAGE,
            AE_STORAGE_PROCESSING,
            /**
             * An enum member indicating that [Residency] was instantiated with an unknown value.
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
                GLOBAL -> Value.GLOBAL
                US_STORAGE_PROCESSING -> Value.US_STORAGE_PROCESSING
                EU_STORAGE_PROCESSING -> Value.EU_STORAGE_PROCESSING
                JP_STORAGE -> Value.JP_STORAGE
                KR_STORAGE -> Value.KR_STORAGE
                CA_STORAGE -> Value.CA_STORAGE
                SG_STORAGE -> Value.SG_STORAGE
                IN_STORAGE -> Value.IN_STORAGE
                AU_STORAGE -> Value.AU_STORAGE
                GB_STORAGE -> Value.GB_STORAGE
                AE_STORAGE -> Value.AE_STORAGE
                AE_STORAGE_PROCESSING -> Value.AE_STORAGE_PROCESSING
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
                GLOBAL -> Known.GLOBAL
                US_STORAGE_PROCESSING -> Known.US_STORAGE_PROCESSING
                EU_STORAGE_PROCESSING -> Known.EU_STORAGE_PROCESSING
                JP_STORAGE -> Known.JP_STORAGE
                KR_STORAGE -> Known.KR_STORAGE
                CA_STORAGE -> Known.CA_STORAGE
                SG_STORAGE -> Known.SG_STORAGE
                IN_STORAGE -> Known.IN_STORAGE
                AU_STORAGE -> Known.AU_STORAGE
                GB_STORAGE -> Known.GB_STORAGE
                AE_STORAGE -> Known.AE_STORAGE
                AE_STORAGE_PROCESSING -> Known.AE_STORAGE_PROCESSING
                else -> throw OpenAIInvalidDataException("Unknown Residency: $value")
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
        fun validate(): Residency = apply {
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

            return other is Residency && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Project &&
            id == other.id &&
            createdAt == other.createdAt &&
            object_ == other.object_ &&
            archivedAt == other.archivedAt &&
            externalKeyId == other.externalKeyId &&
            name == other.name &&
            residency == other.residency &&
            status == other.status &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            createdAt,
            object_,
            archivedAt,
            externalKeyId,
            name,
            residency,
            status,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Project{id=$id, createdAt=$createdAt, object_=$object_, archivedAt=$archivedAt, externalKeyId=$externalKeyId, name=$name, residency=$residency, status=$status, additionalProperties=$additionalProperties}"
}
