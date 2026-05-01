// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.users

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

/** Represents an individual `user` within an organization. */
class OrganizationUser
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val addedAt: JsonField<Long>,
    private val object_: JsonValue,
    private val apiKeyLastUsedAt: JsonField<Long>,
    private val created: JsonField<Long>,
    private val developerPersona: JsonField<String>,
    private val email: JsonField<String>,
    private val isDefault: JsonField<Boolean>,
    private val isScaleTierAuthorizedPurchaser: JsonField<Boolean>,
    private val isScimManaged: JsonField<Boolean>,
    private val isServiceAccount: JsonField<Boolean>,
    private val name: JsonField<String>,
    private val projects: JsonField<Projects>,
    private val role: JsonField<String>,
    private val technicalLevel: JsonField<String>,
    private val user: JsonField<User>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("added_at") @ExcludeMissing addedAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("api_key_last_used_at")
        @ExcludeMissing
        apiKeyLastUsedAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("created") @ExcludeMissing created: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("developer_persona")
        @ExcludeMissing
        developerPersona: JsonField<String> = JsonMissing.of(),
        @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of(),
        @JsonProperty("is_default")
        @ExcludeMissing
        isDefault: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("is_scale_tier_authorized_purchaser")
        @ExcludeMissing
        isScaleTierAuthorizedPurchaser: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("is_scim_managed")
        @ExcludeMissing
        isScimManaged: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("is_service_account")
        @ExcludeMissing
        isServiceAccount: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("projects") @ExcludeMissing projects: JsonField<Projects> = JsonMissing.of(),
        @JsonProperty("role") @ExcludeMissing role: JsonField<String> = JsonMissing.of(),
        @JsonProperty("technical_level")
        @ExcludeMissing
        technicalLevel: JsonField<String> = JsonMissing.of(),
        @JsonProperty("user") @ExcludeMissing user: JsonField<User> = JsonMissing.of(),
    ) : this(
        id,
        addedAt,
        object_,
        apiKeyLastUsedAt,
        created,
        developerPersona,
        email,
        isDefault,
        isScaleTierAuthorizedPurchaser,
        isScimManaged,
        isServiceAccount,
        name,
        projects,
        role,
        technicalLevel,
        user,
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
     * The Unix timestamp (in seconds) of when the user was added.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun addedAt(): Long = addedAt.getRequired("added_at")

    /**
     * The object type, which is always `organization.user`
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("organization.user")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * The Unix timestamp (in seconds) of the user's last API key usage.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun apiKeyLastUsedAt(): Optional<Long> = apiKeyLastUsedAt.getOptional("api_key_last_used_at")

    /**
     * The Unix timestamp (in seconds) of when the user was created.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun created(): Optional<Long> = created.getOptional("created")

    /**
     * The developer persona metadata for the user.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun developerPersona(): Optional<String> = developerPersona.getOptional("developer_persona")

    /**
     * The email address of the user
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun email(): Optional<String> = email.getOptional("email")

    /**
     * Whether this is the organization's default user.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun isDefault(): Optional<Boolean> = isDefault.getOptional("is_default")

    /**
     * Whether the user is an authorized purchaser for Scale Tier.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun isScaleTierAuthorizedPurchaser(): Optional<Boolean> =
        isScaleTierAuthorizedPurchaser.getOptional("is_scale_tier_authorized_purchaser")

    /**
     * Whether the user is managed through SCIM.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun isScimManaged(): Optional<Boolean> = isScimManaged.getOptional("is_scim_managed")

    /**
     * Whether the user is a service account.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun isServiceAccount(): Optional<Boolean> = isServiceAccount.getOptional("is_service_account")

    /**
     * The name of the user
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = name.getOptional("name")

    /**
     * Projects associated with the user, if included.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun projects(): Optional<Projects> = projects.getOptional("projects")

    /**
     * `owner` or `reader`
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun role(): Optional<String> = role.getOptional("role")

    /**
     * The technical level metadata for the user.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun technicalLevel(): Optional<String> = technicalLevel.getOptional("technical_level")

    /**
     * Nested user details.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun user(): Optional<User> = user.getOptional("user")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [addedAt].
     *
     * Unlike [addedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("added_at") @ExcludeMissing fun _addedAt(): JsonField<Long> = addedAt

    /**
     * Returns the raw JSON value of [apiKeyLastUsedAt].
     *
     * Unlike [apiKeyLastUsedAt], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("api_key_last_used_at")
    @ExcludeMissing
    fun _apiKeyLastUsedAt(): JsonField<Long> = apiKeyLastUsedAt

    /**
     * Returns the raw JSON value of [created].
     *
     * Unlike [created], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created") @ExcludeMissing fun _created(): JsonField<Long> = created

    /**
     * Returns the raw JSON value of [developerPersona].
     *
     * Unlike [developerPersona], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("developer_persona")
    @ExcludeMissing
    fun _developerPersona(): JsonField<String> = developerPersona

    /**
     * Returns the raw JSON value of [email].
     *
     * Unlike [email], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<String> = email

    /**
     * Returns the raw JSON value of [isDefault].
     *
     * Unlike [isDefault], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("is_default") @ExcludeMissing fun _isDefault(): JsonField<Boolean> = isDefault

    /**
     * Returns the raw JSON value of [isScaleTierAuthorizedPurchaser].
     *
     * Unlike [isScaleTierAuthorizedPurchaser], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("is_scale_tier_authorized_purchaser")
    @ExcludeMissing
    fun _isScaleTierAuthorizedPurchaser(): JsonField<Boolean> = isScaleTierAuthorizedPurchaser

    /**
     * Returns the raw JSON value of [isScimManaged].
     *
     * Unlike [isScimManaged], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("is_scim_managed")
    @ExcludeMissing
    fun _isScimManaged(): JsonField<Boolean> = isScimManaged

    /**
     * Returns the raw JSON value of [isServiceAccount].
     *
     * Unlike [isServiceAccount], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("is_service_account")
    @ExcludeMissing
    fun _isServiceAccount(): JsonField<Boolean> = isServiceAccount

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [projects].
     *
     * Unlike [projects], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("projects") @ExcludeMissing fun _projects(): JsonField<Projects> = projects

    /**
     * Returns the raw JSON value of [role].
     *
     * Unlike [role], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<String> = role

    /**
     * Returns the raw JSON value of [technicalLevel].
     *
     * Unlike [technicalLevel], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("technical_level")
    @ExcludeMissing
    fun _technicalLevel(): JsonField<String> = technicalLevel

    /**
     * Returns the raw JSON value of [user].
     *
     * Unlike [user], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("user") @ExcludeMissing fun _user(): JsonField<User> = user

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
         * Returns a mutable builder for constructing an instance of [OrganizationUser].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .addedAt()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [OrganizationUser]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var addedAt: JsonField<Long>? = null
        private var object_: JsonValue = JsonValue.from("organization.user")
        private var apiKeyLastUsedAt: JsonField<Long> = JsonMissing.of()
        private var created: JsonField<Long> = JsonMissing.of()
        private var developerPersona: JsonField<String> = JsonMissing.of()
        private var email: JsonField<String> = JsonMissing.of()
        private var isDefault: JsonField<Boolean> = JsonMissing.of()
        private var isScaleTierAuthorizedPurchaser: JsonField<Boolean> = JsonMissing.of()
        private var isScimManaged: JsonField<Boolean> = JsonMissing.of()
        private var isServiceAccount: JsonField<Boolean> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var projects: JsonField<Projects> = JsonMissing.of()
        private var role: JsonField<String> = JsonMissing.of()
        private var technicalLevel: JsonField<String> = JsonMissing.of()
        private var user: JsonField<User> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(organizationUser: OrganizationUser) = apply {
            id = organizationUser.id
            addedAt = organizationUser.addedAt
            object_ = organizationUser.object_
            apiKeyLastUsedAt = organizationUser.apiKeyLastUsedAt
            created = organizationUser.created
            developerPersona = organizationUser.developerPersona
            email = organizationUser.email
            isDefault = organizationUser.isDefault
            isScaleTierAuthorizedPurchaser = organizationUser.isScaleTierAuthorizedPurchaser
            isScimManaged = organizationUser.isScimManaged
            isServiceAccount = organizationUser.isServiceAccount
            name = organizationUser.name
            projects = organizationUser.projects
            role = organizationUser.role
            technicalLevel = organizationUser.technicalLevel
            user = organizationUser.user
            additionalProperties = organizationUser.additionalProperties.toMutableMap()
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

        /** The Unix timestamp (in seconds) of when the user was added. */
        fun addedAt(addedAt: Long) = addedAt(JsonField.of(addedAt))

        /**
         * Sets [Builder.addedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.addedAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun addedAt(addedAt: JsonField<Long>) = apply { this.addedAt = addedAt }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("organization.user")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /** The Unix timestamp (in seconds) of the user's last API key usage. */
        fun apiKeyLastUsedAt(apiKeyLastUsedAt: Long?) =
            apiKeyLastUsedAt(JsonField.ofNullable(apiKeyLastUsedAt))

        /**
         * Alias for [Builder.apiKeyLastUsedAt].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun apiKeyLastUsedAt(apiKeyLastUsedAt: Long) = apiKeyLastUsedAt(apiKeyLastUsedAt as Long?)

        /** Alias for calling [Builder.apiKeyLastUsedAt] with `apiKeyLastUsedAt.orElse(null)`. */
        fun apiKeyLastUsedAt(apiKeyLastUsedAt: Optional<Long>) =
            apiKeyLastUsedAt(apiKeyLastUsedAt.getOrNull())

        /**
         * Sets [Builder.apiKeyLastUsedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.apiKeyLastUsedAt] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun apiKeyLastUsedAt(apiKeyLastUsedAt: JsonField<Long>) = apply {
            this.apiKeyLastUsedAt = apiKeyLastUsedAt
        }

        /** The Unix timestamp (in seconds) of when the user was created. */
        fun created(created: Long) = created(JsonField.of(created))

        /**
         * Sets [Builder.created] to an arbitrary JSON value.
         *
         * You should usually call [Builder.created] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun created(created: JsonField<Long>) = apply { this.created = created }

        /** The developer persona metadata for the user. */
        fun developerPersona(developerPersona: String?) =
            developerPersona(JsonField.ofNullable(developerPersona))

        /** Alias for calling [Builder.developerPersona] with `developerPersona.orElse(null)`. */
        fun developerPersona(developerPersona: Optional<String>) =
            developerPersona(developerPersona.getOrNull())

        /**
         * Sets [Builder.developerPersona] to an arbitrary JSON value.
         *
         * You should usually call [Builder.developerPersona] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun developerPersona(developerPersona: JsonField<String>) = apply {
            this.developerPersona = developerPersona
        }

        /** The email address of the user */
        fun email(email: String?) = email(JsonField.ofNullable(email))

        /** Alias for calling [Builder.email] with `email.orElse(null)`. */
        fun email(email: Optional<String>) = email(email.getOrNull())

        /**
         * Sets [Builder.email] to an arbitrary JSON value.
         *
         * You should usually call [Builder.email] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun email(email: JsonField<String>) = apply { this.email = email }

        /** Whether this is the organization's default user. */
        fun isDefault(isDefault: Boolean) = isDefault(JsonField.of(isDefault))

        /**
         * Sets [Builder.isDefault] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isDefault] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun isDefault(isDefault: JsonField<Boolean>) = apply { this.isDefault = isDefault }

        /** Whether the user is an authorized purchaser for Scale Tier. */
        fun isScaleTierAuthorizedPurchaser(isScaleTierAuthorizedPurchaser: Boolean?) =
            isScaleTierAuthorizedPurchaser(JsonField.ofNullable(isScaleTierAuthorizedPurchaser))

        /**
         * Alias for [Builder.isScaleTierAuthorizedPurchaser].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun isScaleTierAuthorizedPurchaser(isScaleTierAuthorizedPurchaser: Boolean) =
            isScaleTierAuthorizedPurchaser(isScaleTierAuthorizedPurchaser as Boolean?)

        /**
         * Alias for calling [Builder.isScaleTierAuthorizedPurchaser] with
         * `isScaleTierAuthorizedPurchaser.orElse(null)`.
         */
        fun isScaleTierAuthorizedPurchaser(isScaleTierAuthorizedPurchaser: Optional<Boolean>) =
            isScaleTierAuthorizedPurchaser(isScaleTierAuthorizedPurchaser.getOrNull())

        /**
         * Sets [Builder.isScaleTierAuthorizedPurchaser] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isScaleTierAuthorizedPurchaser] with a well-typed
         * [Boolean] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun isScaleTierAuthorizedPurchaser(isScaleTierAuthorizedPurchaser: JsonField<Boolean>) =
            apply {
                this.isScaleTierAuthorizedPurchaser = isScaleTierAuthorizedPurchaser
            }

        /** Whether the user is managed through SCIM. */
        fun isScimManaged(isScimManaged: Boolean) = isScimManaged(JsonField.of(isScimManaged))

        /**
         * Sets [Builder.isScimManaged] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isScimManaged] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun isScimManaged(isScimManaged: JsonField<Boolean>) = apply {
            this.isScimManaged = isScimManaged
        }

        /** Whether the user is a service account. */
        fun isServiceAccount(isServiceAccount: Boolean) =
            isServiceAccount(JsonField.of(isServiceAccount))

        /**
         * Sets [Builder.isServiceAccount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isServiceAccount] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun isServiceAccount(isServiceAccount: JsonField<Boolean>) = apply {
            this.isServiceAccount = isServiceAccount
        }

        /** The name of the user */
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

        /** Projects associated with the user, if included. */
        fun projects(projects: Projects?) = projects(JsonField.ofNullable(projects))

        /** Alias for calling [Builder.projects] with `projects.orElse(null)`. */
        fun projects(projects: Optional<Projects>) = projects(projects.getOrNull())

        /**
         * Sets [Builder.projects] to an arbitrary JSON value.
         *
         * You should usually call [Builder.projects] with a well-typed [Projects] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun projects(projects: JsonField<Projects>) = apply { this.projects = projects }

        /** `owner` or `reader` */
        fun role(role: String?) = role(JsonField.ofNullable(role))

        /** Alias for calling [Builder.role] with `role.orElse(null)`. */
        fun role(role: Optional<String>) = role(role.getOrNull())

        /**
         * Sets [Builder.role] to an arbitrary JSON value.
         *
         * You should usually call [Builder.role] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun role(role: JsonField<String>) = apply { this.role = role }

        /** The technical level metadata for the user. */
        fun technicalLevel(technicalLevel: String?) =
            technicalLevel(JsonField.ofNullable(technicalLevel))

        /** Alias for calling [Builder.technicalLevel] with `technicalLevel.orElse(null)`. */
        fun technicalLevel(technicalLevel: Optional<String>) =
            technicalLevel(technicalLevel.getOrNull())

        /**
         * Sets [Builder.technicalLevel] to an arbitrary JSON value.
         *
         * You should usually call [Builder.technicalLevel] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun technicalLevel(technicalLevel: JsonField<String>) = apply {
            this.technicalLevel = technicalLevel
        }

        /** Nested user details. */
        fun user(user: User) = user(JsonField.of(user))

        /**
         * Sets [Builder.user] to an arbitrary JSON value.
         *
         * You should usually call [Builder.user] with a well-typed [User] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun user(user: JsonField<User>) = apply { this.user = user }

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
         * Returns an immutable instance of [OrganizationUser].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .addedAt()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): OrganizationUser =
            OrganizationUser(
                checkRequired("id", id),
                checkRequired("addedAt", addedAt),
                object_,
                apiKeyLastUsedAt,
                created,
                developerPersona,
                email,
                isDefault,
                isScaleTierAuthorizedPurchaser,
                isScimManaged,
                isServiceAccount,
                name,
                projects,
                role,
                technicalLevel,
                user,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): OrganizationUser = apply {
        if (validated) {
            return@apply
        }

        id()
        addedAt()
        _object_().let {
            if (it != JsonValue.from("organization.user")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        apiKeyLastUsedAt()
        created()
        developerPersona()
        email()
        isDefault()
        isScaleTierAuthorizedPurchaser()
        isScimManaged()
        isServiceAccount()
        name()
        projects().ifPresent { it.validate() }
        role()
        technicalLevel()
        user().ifPresent { it.validate() }
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
            (if (addedAt.asKnown().isPresent) 1 else 0) +
            object_.let { if (it == JsonValue.from("organization.user")) 1 else 0 } +
            (if (apiKeyLastUsedAt.asKnown().isPresent) 1 else 0) +
            (if (created.asKnown().isPresent) 1 else 0) +
            (if (developerPersona.asKnown().isPresent) 1 else 0) +
            (if (email.asKnown().isPresent) 1 else 0) +
            (if (isDefault.asKnown().isPresent) 1 else 0) +
            (if (isScaleTierAuthorizedPurchaser.asKnown().isPresent) 1 else 0) +
            (if (isScimManaged.asKnown().isPresent) 1 else 0) +
            (if (isServiceAccount.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (projects.asKnown().getOrNull()?.validity() ?: 0) +
            (if (role.asKnown().isPresent) 1 else 0) +
            (if (technicalLevel.asKnown().isPresent) 1 else 0) +
            (user.asKnown().getOrNull()?.validity() ?: 0)

    /** Projects associated with the user, if included. */
    class Projects
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val data: JsonField<List<Data>>,
        private val object_: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data") @ExcludeMissing data: JsonField<List<Data>> = JsonMissing.of(),
            @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        ) : this(data, object_, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun data(): List<Data> = data.getRequired("data")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("list")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<List<Data>> = data

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
             * Returns a mutable builder for constructing an instance of [Projects].
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Projects]. */
        class Builder internal constructor() {

            private var data: JsonField<MutableList<Data>>? = null
            private var object_: JsonValue = JsonValue.from("list")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(projects: Projects) = apply {
                data = projects.data.map { it.toMutableList() }
                object_ = projects.object_
                additionalProperties = projects.additionalProperties.toMutableMap()
            }

            fun data(data: List<Data>) = data(JsonField.of(data))

            /**
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed `List<Data>` value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun data(data: JsonField<List<Data>>) = apply {
                this.data = data.map { it.toMutableList() }
            }

            /**
             * Adds a single [Data] to [Builder.data].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addData(data: Data) = apply {
                this.data =
                    (this.data ?: JsonField.of(mutableListOf())).also {
                        checkKnown("data", it).add(data)
                    }
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("list")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun object_(object_: JsonValue) = apply { this.object_ = object_ }

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
             * Returns an immutable instance of [Projects].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Projects =
                Projects(
                    checkRequired("data", data).map { it.toImmutable() },
                    object_,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Projects = apply {
            if (validated) {
                return@apply
            }

            data().forEach { it.validate() }
            _object_().let {
                if (it != JsonValue.from("list")) {
                    throw OpenAIInvalidDataException("'object_' is invalid, received $it")
                }
            }
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
            (data.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                object_.let { if (it == JsonValue.from("list")) 1 else 0 }

        class Data
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val name: JsonField<String>,
            private val role: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("role") @ExcludeMissing role: JsonField<String> = JsonMissing.of(),
            ) : this(id, name, role, mutableMapOf())

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun id(): Optional<String> = id.getOptional("id")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun name(): Optional<String> = name.getOptional("name")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun role(): Optional<String> = role.getOptional("role")

            /**
             * Returns the raw JSON value of [id].
             *
             * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [role].
             *
             * Unlike [role], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<String> = role

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

                /** Returns a mutable builder for constructing an instance of [Data]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Data]. */
            class Builder internal constructor() {

                private var id: JsonField<String> = JsonMissing.of()
                private var name: JsonField<String> = JsonMissing.of()
                private var role: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(data: Data) = apply {
                    id = data.id
                    name = data.name
                    role = data.role
                    additionalProperties = data.additionalProperties.toMutableMap()
                }

                fun id(id: String?) = id(JsonField.ofNullable(id))

                /** Alias for calling [Builder.id] with `id.orElse(null)`. */
                fun id(id: Optional<String>) = id(id.getOrNull())

                /**
                 * Sets [Builder.id] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.id] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun id(id: JsonField<String>) = apply { this.id = id }

                fun name(name: String?) = name(JsonField.ofNullable(name))

                /** Alias for calling [Builder.name] with `name.orElse(null)`. */
                fun name(name: Optional<String>) = name(name.getOrNull())

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun role(role: String?) = role(JsonField.ofNullable(role))

                /** Alias for calling [Builder.role] with `role.orElse(null)`. */
                fun role(role: Optional<String>) = role(role.getOrNull())

                /**
                 * Sets [Builder.role] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.role] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun role(role: JsonField<String>) = apply { this.role = role }

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
                 * Returns an immutable instance of [Data].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Data = Data(id, name, role, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): Data = apply {
                if (validated) {
                    return@apply
                }

                id()
                name()
                role()
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
                (if (id.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (if (role.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Data &&
                    id == other.id &&
                    name == other.name &&
                    role == other.role &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(id, name, role, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Data{id=$id, name=$name, role=$role, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Projects &&
                data == other.data &&
                object_ == other.object_ &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(data, object_, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Projects{data=$data, object_=$object_, additionalProperties=$additionalProperties}"
    }

    /** Nested user details. */
    class User
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val object_: JsonValue,
        private val banned: JsonField<Boolean>,
        private val bannedAt: JsonField<Long>,
        private val email: JsonField<String>,
        private val enabled: JsonField<Boolean>,
        private val name: JsonField<String>,
        private val picture: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
            @JsonProperty("banned") @ExcludeMissing banned: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("banned_at") @ExcludeMissing bannedAt: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of(),
            @JsonProperty("enabled") @ExcludeMissing enabled: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("picture") @ExcludeMissing picture: JsonField<String> = JsonMissing.of(),
        ) : this(id, object_, banned, bannedAt, email, enabled, name, picture, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("user")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun banned(): Optional<Boolean> = banned.getOptional("banned")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun bannedAt(): Optional<Long> = bannedAt.getOptional("banned_at")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun email(): Optional<String> = email.getOptional("email")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun enabled(): Optional<Boolean> = enabled.getOptional("enabled")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun picture(): Optional<String> = picture.getOptional("picture")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [banned].
         *
         * Unlike [banned], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("banned") @ExcludeMissing fun _banned(): JsonField<Boolean> = banned

        /**
         * Returns the raw JSON value of [bannedAt].
         *
         * Unlike [bannedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("banned_at") @ExcludeMissing fun _bannedAt(): JsonField<Long> = bannedAt

        /**
         * Returns the raw JSON value of [email].
         *
         * Unlike [email], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<String> = email

        /**
         * Returns the raw JSON value of [enabled].
         *
         * Unlike [enabled], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("enabled") @ExcludeMissing fun _enabled(): JsonField<Boolean> = enabled

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [picture].
         *
         * Unlike [picture], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("picture") @ExcludeMissing fun _picture(): JsonField<String> = picture

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
             * Returns a mutable builder for constructing an instance of [User].
             *
             * The following fields are required:
             * ```java
             * .id()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [User]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var object_: JsonValue = JsonValue.from("user")
            private var banned: JsonField<Boolean> = JsonMissing.of()
            private var bannedAt: JsonField<Long> = JsonMissing.of()
            private var email: JsonField<String> = JsonMissing.of()
            private var enabled: JsonField<Boolean> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var picture: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(user: User) = apply {
                id = user.id
                object_ = user.object_
                banned = user.banned
                bannedAt = user.bannedAt
                email = user.email
                enabled = user.enabled
                name = user.name
                picture = user.picture
                additionalProperties = user.additionalProperties.toMutableMap()
            }

            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("user")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun object_(object_: JsonValue) = apply { this.object_ = object_ }

            fun banned(banned: Boolean?) = banned(JsonField.ofNullable(banned))

            /**
             * Alias for [Builder.banned].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun banned(banned: Boolean) = banned(banned as Boolean?)

            /** Alias for calling [Builder.banned] with `banned.orElse(null)`. */
            fun banned(banned: Optional<Boolean>) = banned(banned.getOrNull())

            /**
             * Sets [Builder.banned] to an arbitrary JSON value.
             *
             * You should usually call [Builder.banned] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun banned(banned: JsonField<Boolean>) = apply { this.banned = banned }

            fun bannedAt(bannedAt: Long?) = bannedAt(JsonField.ofNullable(bannedAt))

            /**
             * Alias for [Builder.bannedAt].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun bannedAt(bannedAt: Long) = bannedAt(bannedAt as Long?)

            /** Alias for calling [Builder.bannedAt] with `bannedAt.orElse(null)`. */
            fun bannedAt(bannedAt: Optional<Long>) = bannedAt(bannedAt.getOrNull())

            /**
             * Sets [Builder.bannedAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bannedAt] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun bannedAt(bannedAt: JsonField<Long>) = apply { this.bannedAt = bannedAt }

            fun email(email: String?) = email(JsonField.ofNullable(email))

            /** Alias for calling [Builder.email] with `email.orElse(null)`. */
            fun email(email: Optional<String>) = email(email.getOrNull())

            /**
             * Sets [Builder.email] to an arbitrary JSON value.
             *
             * You should usually call [Builder.email] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun email(email: JsonField<String>) = apply { this.email = email }

            fun enabled(enabled: Boolean?) = enabled(JsonField.ofNullable(enabled))

            /**
             * Alias for [Builder.enabled].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun enabled(enabled: Boolean) = enabled(enabled as Boolean?)

            /** Alias for calling [Builder.enabled] with `enabled.orElse(null)`. */
            fun enabled(enabled: Optional<Boolean>) = enabled(enabled.getOrNull())

            /**
             * Sets [Builder.enabled] to an arbitrary JSON value.
             *
             * You should usually call [Builder.enabled] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun enabled(enabled: JsonField<Boolean>) = apply { this.enabled = enabled }

            fun name(name: String?) = name(JsonField.ofNullable(name))

            /** Alias for calling [Builder.name] with `name.orElse(null)`. */
            fun name(name: Optional<String>) = name(name.getOrNull())

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            fun picture(picture: String?) = picture(JsonField.ofNullable(picture))

            /** Alias for calling [Builder.picture] with `picture.orElse(null)`. */
            fun picture(picture: Optional<String>) = picture(picture.getOrNull())

            /**
             * Sets [Builder.picture] to an arbitrary JSON value.
             *
             * You should usually call [Builder.picture] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun picture(picture: JsonField<String>) = apply { this.picture = picture }

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
             * Returns an immutable instance of [User].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): User =
                User(
                    checkRequired("id", id),
                    object_,
                    banned,
                    bannedAt,
                    email,
                    enabled,
                    name,
                    picture,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): User = apply {
            if (validated) {
                return@apply
            }

            id()
            _object_().let {
                if (it != JsonValue.from("user")) {
                    throw OpenAIInvalidDataException("'object_' is invalid, received $it")
                }
            }
            banned()
            bannedAt()
            email()
            enabled()
            name()
            picture()
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
            (if (id.asKnown().isPresent) 1 else 0) +
                object_.let { if (it == JsonValue.from("user")) 1 else 0 } +
                (if (banned.asKnown().isPresent) 1 else 0) +
                (if (bannedAt.asKnown().isPresent) 1 else 0) +
                (if (email.asKnown().isPresent) 1 else 0) +
                (if (enabled.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (picture.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is User &&
                id == other.id &&
                object_ == other.object_ &&
                banned == other.banned &&
                bannedAt == other.bannedAt &&
                email == other.email &&
                enabled == other.enabled &&
                name == other.name &&
                picture == other.picture &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                object_,
                banned,
                bannedAt,
                email,
                enabled,
                name,
                picture,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "User{id=$id, object_=$object_, banned=$banned, bannedAt=$bannedAt, email=$email, enabled=$enabled, name=$name, picture=$picture, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is OrganizationUser &&
            id == other.id &&
            addedAt == other.addedAt &&
            object_ == other.object_ &&
            apiKeyLastUsedAt == other.apiKeyLastUsedAt &&
            created == other.created &&
            developerPersona == other.developerPersona &&
            email == other.email &&
            isDefault == other.isDefault &&
            isScaleTierAuthorizedPurchaser == other.isScaleTierAuthorizedPurchaser &&
            isScimManaged == other.isScimManaged &&
            isServiceAccount == other.isServiceAccount &&
            name == other.name &&
            projects == other.projects &&
            role == other.role &&
            technicalLevel == other.technicalLevel &&
            user == other.user &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            addedAt,
            object_,
            apiKeyLastUsedAt,
            created,
            developerPersona,
            email,
            isDefault,
            isScaleTierAuthorizedPurchaser,
            isScimManaged,
            isServiceAccount,
            name,
            projects,
            role,
            technicalLevel,
            user,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "OrganizationUser{id=$id, addedAt=$addedAt, object_=$object_, apiKeyLastUsedAt=$apiKeyLastUsedAt, created=$created, developerPersona=$developerPersona, email=$email, isDefault=$isDefault, isScaleTierAuthorizedPurchaser=$isScaleTierAuthorizedPurchaser, isScimManaged=$isScimManaged, isServiceAccount=$isServiceAccount, name=$name, projects=$projects, role=$role, technicalLevel=$technicalLevel, user=$user, additionalProperties=$additionalProperties}"
}
