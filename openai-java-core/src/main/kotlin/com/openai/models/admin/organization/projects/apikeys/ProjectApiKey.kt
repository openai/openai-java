// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.apikeys

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
import com.openai.models.admin.organization.projects.serviceaccounts.ProjectServiceAccount
import com.openai.models.admin.organization.projects.users.ProjectUser
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Represents an individual API key in a project. */
class ProjectApiKey
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<Long>,
    private val lastUsedAt: JsonField<Long>,
    private val name: JsonField<String>,
    private val object_: JsonValue,
    private val owner: JsonField<Owner>,
    private val redactedValue: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("last_used_at")
        @ExcludeMissing
        lastUsedAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("owner") @ExcludeMissing owner: JsonField<Owner> = JsonMissing.of(),
        @JsonProperty("redacted_value")
        @ExcludeMissing
        redactedValue: JsonField<String> = JsonMissing.of(),
    ) : this(id, createdAt, lastUsedAt, name, object_, owner, redactedValue, mutableMapOf())

    /**
     * The identifier, which can be referenced in API endpoints
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The Unix timestamp (in seconds) of when the API key was created
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /**
     * The Unix timestamp (in seconds) of when the API key was last used.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun lastUsedAt(): Long = lastUsedAt.getRequired("last_used_at")

    /**
     * The name of the API key
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = name.getRequired("name")

    /**
     * The object type, which is always `organization.project.api_key`
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("organization.project.api_key")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun owner(): Owner = owner.getRequired("owner")

    /**
     * The redacted value of the API key
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun redactedValue(): String = redactedValue.getRequired("redacted_value")

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
     * Returns the raw JSON value of [lastUsedAt].
     *
     * Unlike [lastUsedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("last_used_at") @ExcludeMissing fun _lastUsedAt(): JsonField<Long> = lastUsedAt

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [owner].
     *
     * Unlike [owner], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("owner") @ExcludeMissing fun _owner(): JsonField<Owner> = owner

    /**
     * Returns the raw JSON value of [redactedValue].
     *
     * Unlike [redactedValue], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("redacted_value")
    @ExcludeMissing
    fun _redactedValue(): JsonField<String> = redactedValue

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
         * Returns a mutable builder for constructing an instance of [ProjectApiKey].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .lastUsedAt()
         * .name()
         * .owner()
         * .redactedValue()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ProjectApiKey]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var createdAt: JsonField<Long>? = null
        private var lastUsedAt: JsonField<Long>? = null
        private var name: JsonField<String>? = null
        private var object_: JsonValue = JsonValue.from("organization.project.api_key")
        private var owner: JsonField<Owner>? = null
        private var redactedValue: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(projectApiKey: ProjectApiKey) = apply {
            id = projectApiKey.id
            createdAt = projectApiKey.createdAt
            lastUsedAt = projectApiKey.lastUsedAt
            name = projectApiKey.name
            object_ = projectApiKey.object_
            owner = projectApiKey.owner
            redactedValue = projectApiKey.redactedValue
            additionalProperties = projectApiKey.additionalProperties.toMutableMap()
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

        /** The Unix timestamp (in seconds) of when the API key was created */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /** The Unix timestamp (in seconds) of when the API key was last used. */
        fun lastUsedAt(lastUsedAt: Long) = lastUsedAt(JsonField.of(lastUsedAt))

        /**
         * Sets [Builder.lastUsedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.lastUsedAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun lastUsedAt(lastUsedAt: JsonField<Long>) = apply { this.lastUsedAt = lastUsedAt }

        /** The name of the API key */
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
         * JsonValue.from("organization.project.api_key")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        fun owner(owner: Owner) = owner(JsonField.of(owner))

        /**
         * Sets [Builder.owner] to an arbitrary JSON value.
         *
         * You should usually call [Builder.owner] with a well-typed [Owner] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun owner(owner: JsonField<Owner>) = apply { this.owner = owner }

        /** The redacted value of the API key */
        fun redactedValue(redactedValue: String) = redactedValue(JsonField.of(redactedValue))

        /**
         * Sets [Builder.redactedValue] to an arbitrary JSON value.
         *
         * You should usually call [Builder.redactedValue] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun redactedValue(redactedValue: JsonField<String>) = apply {
            this.redactedValue = redactedValue
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
         * Returns an immutable instance of [ProjectApiKey].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .lastUsedAt()
         * .name()
         * .owner()
         * .redactedValue()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ProjectApiKey =
            ProjectApiKey(
                checkRequired("id", id),
                checkRequired("createdAt", createdAt),
                checkRequired("lastUsedAt", lastUsedAt),
                checkRequired("name", name),
                object_,
                checkRequired("owner", owner),
                checkRequired("redactedValue", redactedValue),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ProjectApiKey = apply {
        if (validated) {
            return@apply
        }

        id()
        createdAt()
        lastUsedAt()
        name()
        _object_().let {
            if (it != JsonValue.from("organization.project.api_key")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        owner().validate()
        redactedValue()
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
            (if (lastUsedAt.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            object_.let { if (it == JsonValue.from("organization.project.api_key")) 1 else 0 } +
            (owner.asKnown().getOrNull()?.validity() ?: 0) +
            (if (redactedValue.asKnown().isPresent) 1 else 0)

    class Owner
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val serviceAccount: JsonField<ProjectServiceAccount>,
        private val type: JsonField<Type>,
        private val user: JsonField<ProjectUser>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("service_account")
            @ExcludeMissing
            serviceAccount: JsonField<ProjectServiceAccount> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
            @JsonProperty("user") @ExcludeMissing user: JsonField<ProjectUser> = JsonMissing.of(),
        ) : this(serviceAccount, type, user, mutableMapOf())

        /**
         * Represents an individual service account in a project.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun serviceAccount(): Optional<ProjectServiceAccount> =
            serviceAccount.getOptional("service_account")

        /**
         * `user` or `service_account`
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun type(): Optional<Type> = type.getOptional("type")

        /**
         * Represents an individual user in a project.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun user(): Optional<ProjectUser> = user.getOptional("user")

        /**
         * Returns the raw JSON value of [serviceAccount].
         *
         * Unlike [serviceAccount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("service_account")
        @ExcludeMissing
        fun _serviceAccount(): JsonField<ProjectServiceAccount> = serviceAccount

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

        /**
         * Returns the raw JSON value of [user].
         *
         * Unlike [user], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("user") @ExcludeMissing fun _user(): JsonField<ProjectUser> = user

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

            /** Returns a mutable builder for constructing an instance of [Owner]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Owner]. */
        class Builder internal constructor() {

            private var serviceAccount: JsonField<ProjectServiceAccount> = JsonMissing.of()
            private var type: JsonField<Type> = JsonMissing.of()
            private var user: JsonField<ProjectUser> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(owner: Owner) = apply {
                serviceAccount = owner.serviceAccount
                type = owner.type
                user = owner.user
                additionalProperties = owner.additionalProperties.toMutableMap()
            }

            /** Represents an individual service account in a project. */
            fun serviceAccount(serviceAccount: ProjectServiceAccount) =
                serviceAccount(JsonField.of(serviceAccount))

            /**
             * Sets [Builder.serviceAccount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.serviceAccount] with a well-typed
             * [ProjectServiceAccount] value instead. This method is primarily for setting the field
             * to an undocumented or not yet supported value.
             */
            fun serviceAccount(serviceAccount: JsonField<ProjectServiceAccount>) = apply {
                this.serviceAccount = serviceAccount
            }

            /** `user` or `service_account` */
            fun type(type: Type) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [Type] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<Type>) = apply { this.type = type }

            /** Represents an individual user in a project. */
            fun user(user: ProjectUser) = user(JsonField.of(user))

            /**
             * Sets [Builder.user] to an arbitrary JSON value.
             *
             * You should usually call [Builder.user] with a well-typed [ProjectUser] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun user(user: JsonField<ProjectUser>) = apply { this.user = user }

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
             * Returns an immutable instance of [Owner].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Owner =
                Owner(serviceAccount, type, user, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Owner = apply {
            if (validated) {
                return@apply
            }

            serviceAccount().ifPresent { it.validate() }
            type().ifPresent { it.validate() }
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (serviceAccount.asKnown().getOrNull()?.validity() ?: 0) +
                (type.asKnown().getOrNull()?.validity() ?: 0) +
                (user.asKnown().getOrNull()?.validity() ?: 0)

        /** `user` or `service_account` */
        class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val USER = of("user")

                @JvmField val SERVICE_ACCOUNT = of("service_account")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            enum class Known {
                USER,
                SERVICE_ACCOUNT,
            }

            /**
             * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Type] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                USER,
                SERVICE_ACCOUNT,
                /** An enum member indicating that [Type] was instantiated with an unknown value. */
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
                    USER -> Value.USER
                    SERVICE_ACCOUNT -> Value.SERVICE_ACCOUNT
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
                    USER -> Known.USER
                    SERVICE_ACCOUNT -> Known.SERVICE_ACCOUNT
                    else -> throw OpenAIInvalidDataException("Unknown Type: $value")
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

            fun validate(): Type = apply {
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

                return other is Type && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Owner &&
                serviceAccount == other.serviceAccount &&
                type == other.type &&
                user == other.user &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(serviceAccount, type, user, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Owner{serviceAccount=$serviceAccount, type=$type, user=$user, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ProjectApiKey &&
            id == other.id &&
            createdAt == other.createdAt &&
            lastUsedAt == other.lastUsedAt &&
            name == other.name &&
            object_ == other.object_ &&
            owner == other.owner &&
            redactedValue == other.redactedValue &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            createdAt,
            lastUsedAt,
            name,
            object_,
            owner,
            redactedValue,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ProjectApiKey{id=$id, createdAt=$createdAt, lastUsedAt=$lastUsedAt, name=$name, object_=$object_, owner=$owner, redactedValue=$redactedValue, additionalProperties=$additionalProperties}"
}
