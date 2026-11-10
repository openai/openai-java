// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.workloadidentityproviders.federationrules

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.Params
import com.openai.core.allMaxBy
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.collectAllProperties
import com.openai.core.getOrThrow
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Update supplied matcher, permission, metadata, or enabled fields. */
class FederationRuleUpdateParams
private constructor(
    private val workloadIdentityProviderId: String,
    private val workloadIdentityFederationRuleId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun workloadIdentityProviderId(): String = workloadIdentityProviderId

    fun workloadIdentityFederationRuleId(): Optional<String> =
        Optional.ofNullable(workloadIdentityFederationRuleId)

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun attributeMatchers(): Optional<AttributeMatchers> = body.attributeMatchers()

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun description(): Optional<String> = body.description()

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun enabled(): Optional<Boolean> = body.enabled()

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = body.name()

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun permissions(): Optional<Permissions> = body.permissions()

    /**
     * Returns the raw JSON value of [attributeMatchers].
     *
     * Unlike [attributeMatchers], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _attributeMatchers(): JsonField<AttributeMatchers> = body._attributeMatchers()

    /**
     * Returns the raw JSON value of [description].
     *
     * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _description(): JsonField<String> = body._description()

    /**
     * Returns the raw JSON value of [enabled].
     *
     * Unlike [enabled], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _enabled(): JsonField<Boolean> = body._enabled()

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _name(): JsonField<String> = body._name()

    /**
     * Returns the raw JSON value of [permissions].
     *
     * Unlike [permissions], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _permissions(): JsonField<Permissions> = body._permissions()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [FederationRuleUpdateParams].
         *
         * The following fields are required:
         * ```java
         * .workloadIdentityProviderId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FederationRuleUpdateParams]. */
    class Builder internal constructor() {

        private var workloadIdentityProviderId: String? = null
        private var workloadIdentityFederationRuleId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(federationRuleUpdateParams: FederationRuleUpdateParams) = apply {
            workloadIdentityProviderId = federationRuleUpdateParams.workloadIdentityProviderId
            workloadIdentityFederationRuleId =
                federationRuleUpdateParams.workloadIdentityFederationRuleId
            body = federationRuleUpdateParams.body.toBuilder()
            additionalHeaders = federationRuleUpdateParams.additionalHeaders.toBuilder()
            additionalQueryParams = federationRuleUpdateParams.additionalQueryParams.toBuilder()
        }

        fun workloadIdentityProviderId(workloadIdentityProviderId: String) = apply {
            this.workloadIdentityProviderId = workloadIdentityProviderId
        }

        fun workloadIdentityFederationRuleId(workloadIdentityFederationRuleId: String?) = apply {
            this.workloadIdentityFederationRuleId = workloadIdentityFederationRuleId
        }

        /**
         * Alias for calling [Builder.workloadIdentityFederationRuleId] with
         * `workloadIdentityFederationRuleId.orElse(null)`.
         */
        fun workloadIdentityFederationRuleId(workloadIdentityFederationRuleId: Optional<String>) =
            workloadIdentityFederationRuleId(workloadIdentityFederationRuleId.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [attributeMatchers]
         * - [description]
         * - [enabled]
         * - [name]
         * - [permissions]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        fun attributeMatchers(attributeMatchers: AttributeMatchers) = apply {
            body.attributeMatchers(attributeMatchers)
        }

        /**
         * Sets [Builder.attributeMatchers] to an arbitrary JSON value.
         *
         * You should usually call [Builder.attributeMatchers] with a well-typed [AttributeMatchers]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun attributeMatchers(attributeMatchers: JsonField<AttributeMatchers>) = apply {
            body.attributeMatchers(attributeMatchers)
        }

        fun description(description: String?) = apply { body.description(description) }

        /** Alias for calling [Builder.description] with `description.orElse(null)`. */
        fun description(description: Optional<String>) = description(description.getOrNull())

        /**
         * Sets [Builder.description] to an arbitrary JSON value.
         *
         * You should usually call [Builder.description] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun description(description: JsonField<String>) = apply { body.description(description) }

        fun enabled(enabled: Boolean) = apply { body.enabled(enabled) }

        /**
         * Sets [Builder.enabled] to an arbitrary JSON value.
         *
         * You should usually call [Builder.enabled] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun enabled(enabled: JsonField<Boolean>) = apply { body.enabled(enabled) }

        fun name(name: String?) = apply { body.name(name) }

        /** Alias for calling [Builder.name] with `name.orElse(null)`. */
        fun name(name: Optional<String>) = name(name.getOrNull())

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { body.name(name) }

        fun permissions(permissions: Permissions) = apply { body.permissions(permissions) }

        /**
         * Sets [Builder.permissions] to an arbitrary JSON value.
         *
         * You should usually call [Builder.permissions] with a well-typed [Permissions] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun permissions(permissions: JsonField<Permissions>) = apply {
            body.permissions(permissions)
        }

        /** Alias for calling [permissions] with `Permissions.ofDefaultPermissionsParam()`. */
        fun permissionsDefaultPermissionsParam() = apply {
            body.permissionsDefaultPermissionsParam()
        }

        /**
         * Alias for calling [permissions] with
         * `Permissions.ofRestrictedPermissionsParam(restrictedPermissionsParam)`.
         */
        fun permissions(restrictedPermissionsParam: Permissions.RestrictedPermissionsParam) =
            apply {
                body.permissions(restrictedPermissionsParam)
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
         * Returns an immutable instance of [FederationRuleUpdateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .workloadIdentityProviderId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FederationRuleUpdateParams =
            FederationRuleUpdateParams(
                checkRequired("workloadIdentityProviderId", workloadIdentityProviderId),
                workloadIdentityFederationRuleId,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> workloadIdentityProviderId
            1 -> workloadIdentityFederationRuleId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val attributeMatchers: JsonField<AttributeMatchers>,
        private val description: JsonField<String>,
        private val enabled: JsonField<Boolean>,
        private val name: JsonField<String>,
        private val permissions: JsonField<Permissions>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("attribute_matchers")
            @ExcludeMissing
            attributeMatchers: JsonField<AttributeMatchers> = JsonMissing.of(),
            @JsonProperty("description")
            @ExcludeMissing
            description: JsonField<String> = JsonMissing.of(),
            @JsonProperty("enabled") @ExcludeMissing enabled: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("permissions")
            @ExcludeMissing
            permissions: JsonField<Permissions> = JsonMissing.of(),
        ) : this(attributeMatchers, description, enabled, name, permissions, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun attributeMatchers(): Optional<AttributeMatchers> =
            attributeMatchers.getOptional("attribute_matchers")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun description(): Optional<String> = description.getOptional("description")

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
        fun permissions(): Optional<Permissions> = permissions.getOptional("permissions")

        /**
         * Returns the raw JSON value of [attributeMatchers].
         *
         * Unlike [attributeMatchers], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("attribute_matchers")
        @ExcludeMissing
        fun _attributeMatchers(): JsonField<AttributeMatchers> = attributeMatchers

        /**
         * Returns the raw JSON value of [description].
         *
         * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

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
         * Returns the raw JSON value of [permissions].
         *
         * Unlike [permissions], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("permissions")
        @ExcludeMissing
        fun _permissions(): JsonField<Permissions> = permissions

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
                "attribute_matchers" to this.attributeMatchers,
                "description" to this.description,
                "enabled" to this.enabled,
                "name" to this.name,
                "permissions" to this.permissions,
            )

        @JvmSynthetic
        internal fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        @JsonAnyGetter
        @ExcludeMissing
        private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var attributeMatchers: JsonField<AttributeMatchers> = JsonMissing.of()
            private var description: JsonField<String> = JsonMissing.of()
            private var enabled: JsonField<Boolean> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var permissions: JsonField<Permissions> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                attributeMatchers = body.attributeMatchers
                description = body.description
                enabled = body.enabled
                name = body.name
                permissions = body.permissions
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            fun attributeMatchers(attributeMatchers: AttributeMatchers) =
                attributeMatchers(JsonField.of(attributeMatchers))

            /**
             * Sets [Builder.attributeMatchers] to an arbitrary JSON value.
             *
             * You should usually call [Builder.attributeMatchers] with a well-typed
             * [AttributeMatchers] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun attributeMatchers(attributeMatchers: JsonField<AttributeMatchers>) = apply {
                this.attributeMatchers = attributeMatchers
            }

            fun description(description: String?) = description(JsonField.ofNullable(description))

            /** Alias for calling [Builder.description] with `description.orElse(null)`. */
            fun description(description: Optional<String>) = description(description.getOrNull())

            /**
             * Sets [Builder.description] to an arbitrary JSON value.
             *
             * You should usually call [Builder.description] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun description(description: JsonField<String>) = apply {
                this.description = description
            }

            fun enabled(enabled: Boolean) = enabled(JsonField.of(enabled))

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

            fun permissions(permissions: Permissions) = permissions(JsonField.of(permissions))

            /**
             * Sets [Builder.permissions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.permissions] with a well-typed [Permissions] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun permissions(permissions: JsonField<Permissions>) = apply {
                this.permissions = permissions
            }

            /** Alias for calling [permissions] with `Permissions.ofDefaultPermissionsParam()`. */
            fun permissionsDefaultPermissionsParam() =
                permissions(Permissions.ofDefaultPermissionsParam())

            /**
             * Alias for calling [permissions] with
             * `Permissions.ofRestrictedPermissionsParam(restrictedPermissionsParam)`.
             */
            fun permissions(restrictedPermissionsParam: Permissions.RestrictedPermissionsParam) =
                permissions(Permissions.ofRestrictedPermissionsParam(restrictedPermissionsParam))

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
                    attributeMatchers,
                    description,
                    enabled,
                    name,
                    permissions,
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
        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            attributeMatchers().ifPresent { it.validate() }
            description()
            enabled()
            name()
            permissions().ifPresent { it.validate() }
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
            (attributeMatchers.asKnown().getOrNull()?.validity() ?: 0) +
                (if (description.asKnown().isPresent) 1 else 0) +
                (if (enabled.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (permissions.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                attributeMatchers == other.attributeMatchers &&
                description == other.description &&
                enabled == other.enabled &&
                name == other.name &&
                permissions == other.permissions &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                attributeMatchers,
                description,
                enabled,
                name,
                permissions,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{attributeMatchers=$attributeMatchers, description=$description, enabled=$enabled, name=$name, permissions=$permissions, additionalProperties=$additionalProperties}"
    }

    class AttributeMatchers
    @JsonCreator
    private constructor(
        @com.fasterxml.jackson.annotation.JsonValue
        private val additionalProperties: Map<String, JsonValue>
    ) {

        /**
         * Returns an immutable snapshot of all present JSON properties, including declared and
         * additional properties.
         *
         * Keys use their JSON names. Declared properties take precedence over additional properties
         * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
         * values are preserved.
         */
        fun _allProperties(): Map<String, JsonValue> = collectAllProperties(additionalProperties)

        @JvmSynthetic
        internal fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        @JsonAnyGetter
        @ExcludeMissing
        private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [AttributeMatchers]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [AttributeMatchers]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(attributeMatchers: AttributeMatchers) = apply {
                additionalProperties = attributeMatchers.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [AttributeMatchers].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): AttributeMatchers = AttributeMatchers(additionalProperties.toImmutable())
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
        fun validate(): AttributeMatchers = apply {
            if (validated) {
                return@apply
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
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AttributeMatchers && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "AttributeMatchers{additionalProperties=$additionalProperties}"
    }

    @JsonDeserialize(using = Permissions.Deserializer::class)
    @JsonSerialize(using = Permissions.Serializer::class)
    class Permissions
    private constructor(
        private val defaultPermissionsParam: JsonValue? = null,
        private val restrictedPermissionsParam: RestrictedPermissionsParam? = null,
        private val _json: JsonValue? = null,
    ) {

        fun defaultPermissionsParam(): Optional<JsonValue> =
            Optional.ofNullable(defaultPermissionsParam)

        fun restrictedPermissionsParam(): Optional<RestrictedPermissionsParam> =
            Optional.ofNullable(restrictedPermissionsParam)

        fun isDefaultPermissionsParam(): Boolean = defaultPermissionsParam != null

        fun isRestrictedPermissionsParam(): Boolean = restrictedPermissionsParam != null

        fun asDefaultPermissionsParam(): JsonValue =
            defaultPermissionsParam.getOrThrow("defaultPermissionsParam")

        fun asRestrictedPermissionsParam(): RestrictedPermissionsParam =
            restrictedPermissionsParam.getOrThrow("restrictedPermissionsParam")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        /**
         * Maps this instance's current variant to a value of type [T] using the given [visitor].
         *
         * Note that this method is _not_ forwards compatible with new variants from the API, unless
         * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of
         * the SDK gracefully, consider overriding [Visitor.unknown]:
         * ```java
         * import com.openai.core.JsonValue;
         * import java.util.Optional;
         *
         * Optional<String> result = permissions.accept(new Permissions.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitDefaultPermissionsParam(JsonValue defaultPermissionsParam) {
         *         return Optional.of(defaultPermissionsParam.toString());
         *     }
         *
         *     // ...
         *
         *     @Override
         *     public Optional<String> unknown(JsonValue json) {
         *         // Or inspect the `json`.
         *         return Optional.empty();
         *     }
         * });
         * ```
         *
         * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in [visitor]
         *   and the current variant is unknown.
         */
        fun <T> accept(visitor: Visitor<T>): T =
            when {
                defaultPermissionsParam != null ->
                    visitor.visitDefaultPermissionsParam(defaultPermissionsParam)
                restrictedPermissionsParam != null ->
                    visitor.visitRestrictedPermissionsParam(restrictedPermissionsParam)
                else -> visitor.unknown(_json)
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
        fun validate(): Permissions = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitDefaultPermissionsParam(defaultPermissionsParam: JsonValue) {
                        defaultPermissionsParam.let {
                            if (it != JsonValue.from(mapOf("type" to "service_account_default"))) {
                                throw OpenAIInvalidDataException(
                                    "'defaultPermissionsParam' is invalid, received $it"
                                )
                            }
                        }
                    }

                    override fun visitRestrictedPermissionsParam(
                        restrictedPermissionsParam: RestrictedPermissionsParam
                    ) {
                        restrictedPermissionsParam.validate()
                    }
                }
            )
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
            accept(
                object : Visitor<Int> {
                    override fun visitDefaultPermissionsParam(defaultPermissionsParam: JsonValue) =
                        defaultPermissionsParam.let {
                            if (it == JsonValue.from(mapOf("type" to "service_account_default"))) 1
                            else 0
                        }

                    override fun visitRestrictedPermissionsParam(
                        restrictedPermissionsParam: RestrictedPermissionsParam
                    ) = restrictedPermissionsParam.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Permissions &&
                defaultPermissionsParam == other.defaultPermissionsParam &&
                restrictedPermissionsParam == other.restrictedPermissionsParam &&
                (defaultPermissionsParam != null ||
                    restrictedPermissionsParam != null ||
                    _json == other._json)
        }

        override fun hashCode(): Int =
            if (defaultPermissionsParam == null && restrictedPermissionsParam == null)
                Objects.hash(_json)
            else Objects.hash(defaultPermissionsParam, restrictedPermissionsParam)

        override fun toString(): String =
            when {
                defaultPermissionsParam != null ->
                    "Permissions{defaultPermissionsParam=$defaultPermissionsParam}"
                restrictedPermissionsParam != null ->
                    "Permissions{restrictedPermissionsParam=$restrictedPermissionsParam}"
                _json != null -> "Permissions{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Permissions")
            }

        companion object {

            @JvmStatic
            fun ofDefaultPermissionsParam() =
                Permissions(
                    defaultPermissionsParam =
                        JsonValue.from(mapOf("type" to "service_account_default"))
                )

            @JvmStatic
            fun ofRestrictedPermissionsParam(
                restrictedPermissionsParam: RestrictedPermissionsParam
            ) = Permissions(restrictedPermissionsParam = restrictedPermissionsParam)
        }

        /**
         * An interface that defines how to map each variant of [Permissions] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            fun visitDefaultPermissionsParam(defaultPermissionsParam: JsonValue): T =
                unknown(JsonValue.from(defaultPermissionsParam))

            fun visitRestrictedPermissionsParam(
                restrictedPermissionsParam: RestrictedPermissionsParam
            ): T = unknown(JsonValue.from(restrictedPermissionsParam))

            /**
             * Maps an unknown variant of [Permissions] to a value of type [T].
             *
             * An instance of [Permissions] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * Unhandled known JSON variants reach this method as JSON values.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Permissions")
            }
        }

        internal class Deserializer : BaseDeserializer<Permissions>(Permissions::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Permissions {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                ?.let { Permissions(defaultPermissionsParam = it, _json = json) }
                                ?.takeIf { it.isValid() },
                            tryDeserialize(node, jacksonTypeRef<RestrictedPermissionsParam>())
                                ?.let { Permissions(restrictedPermissionsParam = it, _json = json) },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Permissions(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Permissions>(Permissions::class) {

            override fun serialize(
                value: Permissions,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.defaultPermissionsParam != null ->
                        generator.writeObject(value.defaultPermissionsParam)
                    value.restrictedPermissionsParam != null ->
                        generator.writeObject(value.restrictedPermissionsParam)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Permissions")
                }
            }
        }

        class RestrictedPermissionsParam
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val scopes: JsonField<List<String>>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("scopes")
                @ExcludeMissing
                scopes: JsonField<List<String>> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(scopes, type, mutableMapOf())

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun scopes(): List<String> = scopes.getRequired("scopes")

            /**
             * Expected to always return the following:
             * ```java
             * JsonValue.from("restricted")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Returns the raw JSON value of [scopes].
             *
             * Unlike [scopes], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("scopes") @ExcludeMissing fun _scopes(): JsonField<List<String>> = scopes

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            /**
             * Returns an immutable snapshot of all present JSON properties, including declared and
             * additional properties.
             *
             * Keys use their JSON names. Declared properties take precedence over additional
             * properties with the same name. Missing properties are omitted, while explicit nulls
             * and unrecognized values are preserved.
             */
            fun _allProperties(): Map<String, JsonValue> =
                collectAllProperties(
                    additionalProperties,
                    "scopes" to this.scopes,
                    "type" to this.type,
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
                 * Returns a mutable builder for constructing an instance of
                 * [RestrictedPermissionsParam].
                 *
                 * The following fields are required:
                 * ```java
                 * .scopes()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [RestrictedPermissionsParam]. */
            class Builder internal constructor() {

                private var scopes: JsonField<MutableList<String>>? = null
                private var type: JsonValue = JsonValue.from("restricted")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(restrictedPermissionsParam: RestrictedPermissionsParam) = apply {
                    scopes = restrictedPermissionsParam.scopes.map { it.toMutableList() }
                    type = restrictedPermissionsParam.type
                    additionalProperties =
                        restrictedPermissionsParam.additionalProperties.toMutableMap()
                }

                fun scopes(scopes: List<String>) = scopes(JsonField.of(scopes))

                /**
                 * Sets [Builder.scopes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.scopes] with a well-typed `List<String>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun scopes(scopes: JsonField<List<String>>) = apply {
                    this.scopes = scopes.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [scopes].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addScope(scope: String) = apply {
                    scopes =
                        (scopes ?: JsonField.of(mutableListOf())).also {
                            checkKnown("scopes", it).add(scope)
                        }
                }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("restricted")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

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
                 * Returns an immutable instance of [RestrictedPermissionsParam].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .scopes()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): RestrictedPermissionsParam =
                    RestrictedPermissionsParam(
                        checkRequired("scopes", scopes).map { it.toImmutable() },
                        type,
                        additionalProperties.toMutableMap(),
                    )
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
            fun validate(): RestrictedPermissionsParam = apply {
                if (validated) {
                    return@apply
                }

                scopes()
                _type().let {
                    if (it != JsonValue.from("restricted")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
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
                (scopes.asKnown().getOrNull()?.size ?: 0) +
                    type.let { if (it == JsonValue.from("restricted")) 1 else 0 }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is RestrictedPermissionsParam &&
                    scopes == other.scopes &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(scopes, type, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "RestrictedPermissionsParam{scopes=$scopes, type=$type, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FederationRuleUpdateParams &&
            workloadIdentityProviderId == other.workloadIdentityProviderId &&
            workloadIdentityFederationRuleId == other.workloadIdentityFederationRuleId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            workloadIdentityProviderId,
            workloadIdentityFederationRuleId,
            body,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "FederationRuleUpdateParams{workloadIdentityProviderId=$workloadIdentityProviderId, workloadIdentityFederationRuleId=$workloadIdentityFederationRuleId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
