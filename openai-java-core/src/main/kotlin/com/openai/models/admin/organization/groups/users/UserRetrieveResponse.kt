// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.groups.users

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

/** Details about a user returned from an organization group membership lookup. */
class UserRetrieveResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val email: JsonField<String>,
    private val isServiceAccount: JsonField<Boolean>,
    private val name: JsonField<String>,
    private val picture: JsonField<String>,
    private val userType: JsonField<UserType>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of(),
        @JsonProperty("is_service_account")
        @ExcludeMissing
        isServiceAccount: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("picture") @ExcludeMissing picture: JsonField<String> = JsonMissing.of(),
        @JsonProperty("user_type") @ExcludeMissing userType: JsonField<UserType> = JsonMissing.of(),
    ) : this(id, email, isServiceAccount, name, picture, userType, mutableMapOf())

    /**
     * Identifier for the user.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Email address of the user, or `null` for users without an email.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun email(): Optional<String> = email.getOptional("email")

    /**
     * Whether the user is a service account.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun isServiceAccount(): Optional<Boolean> = isServiceAccount.getOptional("is_service_account")

    /**
     * Display name of the user.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = name.getRequired("name")

    /**
     * URL of the user's profile picture, if available.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun picture(): Optional<String> = picture.getOptional("picture")

    /**
     * The type of user.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun userType(): UserType = userType.getRequired("user_type")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [email].
     *
     * Unlike [email], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<String> = email

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
     * Returns the raw JSON value of [picture].
     *
     * Unlike [picture], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("picture") @ExcludeMissing fun _picture(): JsonField<String> = picture

    /**
     * Returns the raw JSON value of [userType].
     *
     * Unlike [userType], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("user_type") @ExcludeMissing fun _userType(): JsonField<UserType> = userType

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
         * Returns a mutable builder for constructing an instance of [UserRetrieveResponse].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .email()
         * .isServiceAccount()
         * .name()
         * .picture()
         * .userType()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UserRetrieveResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var email: JsonField<String>? = null
        private var isServiceAccount: JsonField<Boolean>? = null
        private var name: JsonField<String>? = null
        private var picture: JsonField<String>? = null
        private var userType: JsonField<UserType>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(userRetrieveResponse: UserRetrieveResponse) = apply {
            id = userRetrieveResponse.id
            email = userRetrieveResponse.email
            isServiceAccount = userRetrieveResponse.isServiceAccount
            name = userRetrieveResponse.name
            picture = userRetrieveResponse.picture
            userType = userRetrieveResponse.userType
            additionalProperties = userRetrieveResponse.additionalProperties.toMutableMap()
        }

        /** Identifier for the user. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Email address of the user, or `null` for users without an email. */
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

        /** Whether the user is a service account. */
        fun isServiceAccount(isServiceAccount: Boolean?) =
            isServiceAccount(JsonField.ofNullable(isServiceAccount))

        /**
         * Alias for [Builder.isServiceAccount].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun isServiceAccount(isServiceAccount: Boolean) =
            isServiceAccount(isServiceAccount as Boolean?)

        /** Alias for calling [Builder.isServiceAccount] with `isServiceAccount.orElse(null)`. */
        fun isServiceAccount(isServiceAccount: Optional<Boolean>) =
            isServiceAccount(isServiceAccount.getOrNull())

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

        /** Display name of the user. */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** URL of the user's profile picture, if available. */
        fun picture(picture: String?) = picture(JsonField.ofNullable(picture))

        /** Alias for calling [Builder.picture] with `picture.orElse(null)`. */
        fun picture(picture: Optional<String>) = picture(picture.getOrNull())

        /**
         * Sets [Builder.picture] to an arbitrary JSON value.
         *
         * You should usually call [Builder.picture] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun picture(picture: JsonField<String>) = apply { this.picture = picture }

        /** The type of user. */
        fun userType(userType: UserType) = userType(JsonField.of(userType))

        /**
         * Sets [Builder.userType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.userType] with a well-typed [UserType] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun userType(userType: JsonField<UserType>) = apply { this.userType = userType }

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
         * Returns an immutable instance of [UserRetrieveResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .email()
         * .isServiceAccount()
         * .name()
         * .picture()
         * .userType()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): UserRetrieveResponse =
            UserRetrieveResponse(
                checkRequired("id", id),
                checkRequired("email", email),
                checkRequired("isServiceAccount", isServiceAccount),
                checkRequired("name", name),
                checkRequired("picture", picture),
                checkRequired("userType", userType),
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
    fun validate(): UserRetrieveResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        email()
        isServiceAccount()
        name()
        picture()
        userType().validate()
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
            (if (email.asKnown().isPresent) 1 else 0) +
            (if (isServiceAccount.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (if (picture.asKnown().isPresent) 1 else 0) +
            (userType.asKnown().getOrNull()?.validity() ?: 0)

    /** The type of user. */
    class UserType @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val USER = of("user")

            @JvmField val TENANT_USER = of("tenant_user")

            @JvmStatic fun of(value: String) = UserType(JsonField.of(value))
        }

        /** An enum containing [UserType]'s known values. */
        enum class Known {
            USER,
            TENANT_USER,
        }

        /**
         * An enum containing [UserType]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [UserType] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            USER,
            TENANT_USER,
            /** An enum member indicating that [UserType] was instantiated with an unknown value. */
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
                USER -> Value.USER
                TENANT_USER -> Value.TENANT_USER
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
                USER -> Known.USER
                TENANT_USER -> Known.TENANT_USER
                else -> throw OpenAIInvalidDataException("Unknown UserType: $value")
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
        fun validate(): UserType = apply {
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

            return other is UserType && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UserRetrieveResponse &&
            id == other.id &&
            email == other.email &&
            isServiceAccount == other.isServiceAccount &&
            name == other.name &&
            picture == other.picture &&
            userType == other.userType &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, email, isServiceAccount, name, picture, userType, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "UserRetrieveResponse{id=$id, email=$email, isServiceAccount=$isServiceAccount, name=$name, picture=$picture, userType=$userType, additionalProperties=$additionalProperties}"
}
