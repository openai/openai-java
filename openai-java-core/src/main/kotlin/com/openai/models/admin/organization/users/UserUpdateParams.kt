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
import com.openai.core.Params
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Modifies a user's role in the organization. */
class UserUpdateParams
private constructor(
    private val userId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun userId(): Optional<String> = Optional.ofNullable(userId)

    /**
     * Developer persona metadata.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun developerPersona(): Optional<String> = body.developerPersona()

    /**
     * `owner` or `reader`
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun role(): Optional<String> = body.role()

    /**
     * Role ID to assign to the user.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun roleId(): Optional<String> = body.roleId()

    /**
     * Technical level metadata.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun technicalLevel(): Optional<String> = body.technicalLevel()

    /**
     * Returns the raw JSON value of [developerPersona].
     *
     * Unlike [developerPersona], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _developerPersona(): JsonField<String> = body._developerPersona()

    /**
     * Returns the raw JSON value of [role].
     *
     * Unlike [role], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _role(): JsonField<String> = body._role()

    /**
     * Returns the raw JSON value of [roleId].
     *
     * Unlike [roleId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _roleId(): JsonField<String> = body._roleId()

    /**
     * Returns the raw JSON value of [technicalLevel].
     *
     * Unlike [technicalLevel], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _technicalLevel(): JsonField<String> = body._technicalLevel()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): UserUpdateParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [UserUpdateParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UserUpdateParams]. */
    class Builder internal constructor() {

        private var userId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(userUpdateParams: UserUpdateParams) = apply {
            userId = userUpdateParams.userId
            body = userUpdateParams.body.toBuilder()
            additionalHeaders = userUpdateParams.additionalHeaders.toBuilder()
            additionalQueryParams = userUpdateParams.additionalQueryParams.toBuilder()
        }

        fun userId(userId: String?) = apply { this.userId = userId }

        /** Alias for calling [Builder.userId] with `userId.orElse(null)`. */
        fun userId(userId: Optional<String>) = userId(userId.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [developerPersona]
         * - [role]
         * - [roleId]
         * - [technicalLevel]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Developer persona metadata. */
        fun developerPersona(developerPersona: String?) = apply {
            body.developerPersona(developerPersona)
        }

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
            body.developerPersona(developerPersona)
        }

        /** `owner` or `reader` */
        fun role(role: String?) = apply { body.role(role) }

        /** Alias for calling [Builder.role] with `role.orElse(null)`. */
        fun role(role: Optional<String>) = role(role.getOrNull())

        /**
         * Sets [Builder.role] to an arbitrary JSON value.
         *
         * You should usually call [Builder.role] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun role(role: JsonField<String>) = apply { body.role(role) }

        /** Role ID to assign to the user. */
        fun roleId(roleId: String?) = apply { body.roleId(roleId) }

        /** Alias for calling [Builder.roleId] with `roleId.orElse(null)`. */
        fun roleId(roleId: Optional<String>) = roleId(roleId.getOrNull())

        /**
         * Sets [Builder.roleId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.roleId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun roleId(roleId: JsonField<String>) = apply { body.roleId(roleId) }

        /** Technical level metadata. */
        fun technicalLevel(technicalLevel: String?) = apply { body.technicalLevel(technicalLevel) }

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
            body.technicalLevel(technicalLevel)
        }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [UserUpdateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): UserUpdateParams =
            UserUpdateParams(
                userId,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> userId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val developerPersona: JsonField<String>,
        private val role: JsonField<String>,
        private val roleId: JsonField<String>,
        private val technicalLevel: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("developer_persona")
            @ExcludeMissing
            developerPersona: JsonField<String> = JsonMissing.of(),
            @JsonProperty("role") @ExcludeMissing role: JsonField<String> = JsonMissing.of(),
            @JsonProperty("role_id") @ExcludeMissing roleId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("technical_level")
            @ExcludeMissing
            technicalLevel: JsonField<String> = JsonMissing.of(),
        ) : this(developerPersona, role, roleId, technicalLevel, mutableMapOf())

        /**
         * Developer persona metadata.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun developerPersona(): Optional<String> = developerPersona.getOptional("developer_persona")

        /**
         * `owner` or `reader`
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun role(): Optional<String> = role.getOptional("role")

        /**
         * Role ID to assign to the user.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun roleId(): Optional<String> = roleId.getOptional("role_id")

        /**
         * Technical level metadata.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun technicalLevel(): Optional<String> = technicalLevel.getOptional("technical_level")

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
         * Returns the raw JSON value of [role].
         *
         * Unlike [role], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<String> = role

        /**
         * Returns the raw JSON value of [roleId].
         *
         * Unlike [roleId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("role_id") @ExcludeMissing fun _roleId(): JsonField<String> = roleId

        /**
         * Returns the raw JSON value of [technicalLevel].
         *
         * Unlike [technicalLevel], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("technical_level")
        @ExcludeMissing
        fun _technicalLevel(): JsonField<String> = technicalLevel

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

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var developerPersona: JsonField<String> = JsonMissing.of()
            private var role: JsonField<String> = JsonMissing.of()
            private var roleId: JsonField<String> = JsonMissing.of()
            private var technicalLevel: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                developerPersona = body.developerPersona
                role = body.role
                roleId = body.roleId
                technicalLevel = body.technicalLevel
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Developer persona metadata. */
            fun developerPersona(developerPersona: String?) =
                developerPersona(JsonField.ofNullable(developerPersona))

            /**
             * Alias for calling [Builder.developerPersona] with `developerPersona.orElse(null)`.
             */
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

            /** `owner` or `reader` */
            fun role(role: String?) = role(JsonField.ofNullable(role))

            /** Alias for calling [Builder.role] with `role.orElse(null)`. */
            fun role(role: Optional<String>) = role(role.getOrNull())

            /**
             * Sets [Builder.role] to an arbitrary JSON value.
             *
             * You should usually call [Builder.role] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun role(role: JsonField<String>) = apply { this.role = role }

            /** Role ID to assign to the user. */
            fun roleId(roleId: String?) = roleId(JsonField.ofNullable(roleId))

            /** Alias for calling [Builder.roleId] with `roleId.orElse(null)`. */
            fun roleId(roleId: Optional<String>) = roleId(roleId.getOrNull())

            /**
             * Sets [Builder.roleId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.roleId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun roleId(roleId: JsonField<String>) = apply { this.roleId = roleId }

            /** Technical level metadata. */
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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Body =
                Body(
                    developerPersona,
                    role,
                    roleId,
                    technicalLevel,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            developerPersona()
            role()
            roleId()
            technicalLevel()
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
            (if (developerPersona.asKnown().isPresent) 1 else 0) +
                (if (role.asKnown().isPresent) 1 else 0) +
                (if (roleId.asKnown().isPresent) 1 else 0) +
                (if (technicalLevel.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                developerPersona == other.developerPersona &&
                role == other.role &&
                roleId == other.roleId &&
                technicalLevel == other.technicalLevel &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(developerPersona, role, roleId, technicalLevel, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{developerPersona=$developerPersona, role=$role, roleId=$roleId, technicalLevel=$technicalLevel, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UserUpdateParams &&
            userId == other.userId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(userId, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "UserUpdateParams{userId=$userId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
