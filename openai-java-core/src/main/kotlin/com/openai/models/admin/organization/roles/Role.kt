// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.roles

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
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

/** Details about a role that can be assigned through the public Roles API. */
class Role
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val description: JsonField<String>,
    private val name: JsonField<String>,
    private val object_: JsonValue,
    private val permissions: JsonField<List<String>>,
    private val predefinedRole: JsonField<Boolean>,
    private val resourceType: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("description")
        @ExcludeMissing
        description: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("permissions")
        @ExcludeMissing
        permissions: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("predefined_role")
        @ExcludeMissing
        predefinedRole: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("resource_type")
        @ExcludeMissing
        resourceType: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        description,
        name,
        object_,
        permissions,
        predefinedRole,
        resourceType,
        mutableMapOf(),
    )

    /**
     * Identifier for the role.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Optional description of the role.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun description(): Optional<String> = description.getOptional("description")

    /**
     * Unique name for the role.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = name.getRequired("name")

    /**
     * Always `role`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("role")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * Permissions granted by the role.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun permissions(): List<String> = permissions.getRequired("permissions")

    /**
     * Whether the role is predefined and managed by OpenAI.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun predefinedRole(): Boolean = predefinedRole.getRequired("predefined_role")

    /**
     * Resource type the role is bound to (for example `api.organization` or `api.project`).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun resourceType(): String = resourceType.getRequired("resource_type")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [description].
     *
     * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("description") @ExcludeMissing fun _description(): JsonField<String> = description

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [permissions].
     *
     * Unlike [permissions], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("permissions")
    @ExcludeMissing
    fun _permissions(): JsonField<List<String>> = permissions

    /**
     * Returns the raw JSON value of [predefinedRole].
     *
     * Unlike [predefinedRole], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("predefined_role")
    @ExcludeMissing
    fun _predefinedRole(): JsonField<Boolean> = predefinedRole

    /**
     * Returns the raw JSON value of [resourceType].
     *
     * Unlike [resourceType], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("resource_type")
    @ExcludeMissing
    fun _resourceType(): JsonField<String> = resourceType

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
         * Returns a mutable builder for constructing an instance of [Role].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .description()
         * .name()
         * .permissions()
         * .predefinedRole()
         * .resourceType()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Role]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var description: JsonField<String>? = null
        private var name: JsonField<String>? = null
        private var object_: JsonValue = JsonValue.from("role")
        private var permissions: JsonField<MutableList<String>>? = null
        private var predefinedRole: JsonField<Boolean>? = null
        private var resourceType: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(role: Role) = apply {
            id = role.id
            description = role.description
            name = role.name
            object_ = role.object_
            permissions = role.permissions.map { it.toMutableList() }
            predefinedRole = role.predefinedRole
            resourceType = role.resourceType
            additionalProperties = role.additionalProperties.toMutableMap()
        }

        /** Identifier for the role. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Optional description of the role. */
        fun description(description: String?) = description(JsonField.ofNullable(description))

        /** Alias for calling [Builder.description] with `description.orElse(null)`. */
        fun description(description: Optional<String>) = description(description.getOrNull())

        /**
         * Sets [Builder.description] to an arbitrary JSON value.
         *
         * You should usually call [Builder.description] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun description(description: JsonField<String>) = apply { this.description = description }

        /** Unique name for the role. */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("role")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /** Permissions granted by the role. */
        fun permissions(permissions: List<String>) = permissions(JsonField.of(permissions))

        /**
         * Sets [Builder.permissions] to an arbitrary JSON value.
         *
         * You should usually call [Builder.permissions] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun permissions(permissions: JsonField<List<String>>) = apply {
            this.permissions = permissions.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [permissions].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addPermission(permission: String) = apply {
            permissions =
                (permissions ?: JsonField.of(mutableListOf())).also {
                    checkKnown("permissions", it).add(permission)
                }
        }

        /** Whether the role is predefined and managed by OpenAI. */
        fun predefinedRole(predefinedRole: Boolean) = predefinedRole(JsonField.of(predefinedRole))

        /**
         * Sets [Builder.predefinedRole] to an arbitrary JSON value.
         *
         * You should usually call [Builder.predefinedRole] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun predefinedRole(predefinedRole: JsonField<Boolean>) = apply {
            this.predefinedRole = predefinedRole
        }

        /** Resource type the role is bound to (for example `api.organization` or `api.project`). */
        fun resourceType(resourceType: String) = resourceType(JsonField.of(resourceType))

        /**
         * Sets [Builder.resourceType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.resourceType] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun resourceType(resourceType: JsonField<String>) = apply {
            this.resourceType = resourceType
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
         * Returns an immutable instance of [Role].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .description()
         * .name()
         * .permissions()
         * .predefinedRole()
         * .resourceType()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Role =
            Role(
                checkRequired("id", id),
                checkRequired("description", description),
                checkRequired("name", name),
                object_,
                checkRequired("permissions", permissions).map { it.toImmutable() },
                checkRequired("predefinedRole", predefinedRole),
                checkRequired("resourceType", resourceType),
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
    fun validate(): Role = apply {
        if (validated) {
            return@apply
        }

        id()
        description()
        name()
        _object_().let {
            if (it != JsonValue.from("role")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        permissions()
        predefinedRole()
        resourceType()
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
            (if (description.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            object_.let { if (it == JsonValue.from("role")) 1 else 0 } +
            (permissions.asKnown().getOrNull()?.size ?: 0) +
            (if (predefinedRole.asKnown().isPresent) 1 else 0) +
            (if (resourceType.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Role &&
            id == other.id &&
            description == other.description &&
            name == other.name &&
            object_ == other.object_ &&
            permissions == other.permissions &&
            predefinedRole == other.predefinedRole &&
            resourceType == other.resourceType &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            description,
            name,
            object_,
            permissions,
            predefinedRole,
            resourceType,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Role{id=$id, description=$description, name=$name, object_=$object_, permissions=$permissions, predefinedRole=$predefinedRole, resourceType=$resourceType, additionalProperties=$additionalProperties}"
}
