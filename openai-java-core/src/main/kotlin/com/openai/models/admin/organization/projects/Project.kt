// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.projects

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
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
    private val residency: JsonField<ProjectResidency>,
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
        residency: JsonField<ProjectResidency> = JsonMissing.of(),
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
     * The identifier, which can be referenced in API endpoints The schema requires this property.
     * Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun id(): java.util.Optional<String> = id.getOptional("id")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun idOrThrow(): String = id.getRequired("id")

    /**
     * The Unix timestamp (in seconds) of when the project was created. The schema requires this
     * property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun createdAt(): java.util.Optional<Long> = createdAt.getOptional("created_at")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun createdAtOrThrow(): Long = createdAt.getRequired("created_at")

    /**
     * The object type, which is always `organization.project` The schema requires this property.
     * Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun object_(): java.util.Optional<JsonValue> {
        val raw = object_
        return when {
            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
            !(raw == JsonValue.from("organization.project")) ->
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
     * The Unix timestamp (in seconds) of when the project was archived or `null`. Returns empty if
     * the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun archivedAt(): java.util.Optional<Long> = archivedAt.getOptional("archived_at")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun archivedAtOrThrow(): Long = archivedAt.getRequired("archived_at")

    /**
     * The external key associated with the project. Returns empty if the JSON property is missing
     * or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun externalKeyId(): java.util.Optional<String> = externalKeyId.getOptional("external_key_id")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun externalKeyIdOrThrow(): String = externalKeyId.getRequired("external_key_id")

    /**
     * The name of the project. This appears in reporting. Returns empty if the JSON property is
     * missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun name(): java.util.Optional<String> = name.getOptional("name")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun nameOrThrow(): String = name.getRequired("name")

    /**
     * The residency configuration for the project. Returns empty if the JSON property is missing or
     * null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun residency(): java.util.Optional<ProjectResidency> = residency.getOptional("residency")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun residencyOrThrow(): ProjectResidency = residency.getRequired("residency")

    /**
     * `active` or `archived` Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun status(): java.util.Optional<String> = status.getOptional("status")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun statusOrThrow(): String = status.getRequired("status")

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
    @JsonProperty("residency")
    @ExcludeMissing
    fun _residency(): JsonField<ProjectResidency> = residency

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
            "object" to this.object_,
            "archived_at" to this.archivedAt,
            "external_key_id" to this.externalKeyId,
            "name" to this.name,
            "residency" to this.residency,
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
        private var residency: JsonField<ProjectResidency> = JsonMissing.of()
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
        fun residency(residency: ProjectResidency) = residency(JsonField.of(residency))

        /**
         * Sets [Builder.residency] to an arbitrary JSON value.
         *
         * You should usually call [Builder.residency] with a well-typed [ProjectResidency] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun residency(residency: JsonField<ProjectResidency>) = apply { this.residency = residency }

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

        idOrThrow()
        createdAtOrThrow()
        object_OrThrow()
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
