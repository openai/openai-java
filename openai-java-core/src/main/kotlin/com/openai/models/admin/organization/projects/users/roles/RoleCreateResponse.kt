// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.users.roles

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.admin.organization.roles.Role
import com.openai.models.admin.organization.users.OrganizationUser
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** Role assignment linking a user to a role. */
class RoleCreateResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val object_: JsonValue,
    private val role: JsonField<Role>,
    private val user: JsonField<OrganizationUser>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("role") @ExcludeMissing role: JsonField<Role> = JsonMissing.of(),
        @JsonProperty("user") @ExcludeMissing user: JsonField<OrganizationUser> = JsonMissing.of(),
    ) : this(object_, role, user, mutableMapOf())

    /**
     * Always `user.role`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("user.role")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * Details about a role that can be assigned through the public Roles API.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun role(): Role = role.getRequired("role")

    /**
     * Represents an individual `user` within an organization.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun user(): OrganizationUser = user.getRequired("user")

    /**
     * Returns the raw JSON value of [role].
     *
     * Unlike [role], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<Role> = role

    /**
     * Returns the raw JSON value of [user].
     *
     * Unlike [user], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("user") @ExcludeMissing fun _user(): JsonField<OrganizationUser> = user

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
         * Returns a mutable builder for constructing an instance of [RoleCreateResponse].
         *
         * The following fields are required:
         * ```java
         * .role()
         * .user()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RoleCreateResponse]. */
    class Builder internal constructor() {

        private var object_: JsonValue = JsonValue.from("user.role")
        private var role: JsonField<Role>? = null
        private var user: JsonField<OrganizationUser>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(roleCreateResponse: RoleCreateResponse) = apply {
            object_ = roleCreateResponse.object_
            role = roleCreateResponse.role
            user = roleCreateResponse.user
            additionalProperties = roleCreateResponse.additionalProperties.toMutableMap()
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("user.role")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /** Details about a role that can be assigned through the public Roles API. */
        fun role(role: Role) = role(JsonField.of(role))

        /**
         * Sets [Builder.role] to an arbitrary JSON value.
         *
         * You should usually call [Builder.role] with a well-typed [Role] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun role(role: JsonField<Role>) = apply { this.role = role }

        /** Represents an individual `user` within an organization. */
        fun user(user: OrganizationUser) = user(JsonField.of(user))

        /**
         * Sets [Builder.user] to an arbitrary JSON value.
         *
         * You should usually call [Builder.user] with a well-typed [OrganizationUser] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun user(user: JsonField<OrganizationUser>) = apply { this.user = user }

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
         * Returns an immutable instance of [RoleCreateResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .role()
         * .user()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): RoleCreateResponse =
            RoleCreateResponse(
                object_,
                checkRequired("role", role),
                checkRequired("user", user),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): RoleCreateResponse = apply {
        if (validated) {
            return@apply
        }

        _object_().let {
            if (it != JsonValue.from("user.role")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        role().validate()
        user().validate()
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
        object_.let { if (it == JsonValue.from("user.role")) 1 else 0 } +
            (role.asKnown().getOrNull()?.validity() ?: 0) +
            (user.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RoleCreateResponse &&
            object_ == other.object_ &&
            role == other.role &&
            user == other.user &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(object_, role, user, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RoleCreateResponse{object_=$object_, role=$role, user=$user, additionalProperties=$additionalProperties}"
}
