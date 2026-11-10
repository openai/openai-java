// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.workloadidentityproviders

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

/** Register an OIDC provider for keyless project service-account authentication. */
class WorkloadIdentityProviderCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun audience(): String = body.audience()

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun issuer(): String = body.issuer()

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = body.name()

    /**
     * Expected to always return the following:
     * ```java
     * JsonValue.from("oidc")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    fun _type(): JsonValue = body._type()

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun attributeTransformations(): Optional<List<AttributeTransformation>> =
        body.attributeTransformations()

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
    fun verification(): Optional<Verification> = body.verification()

    /**
     * Returns the raw JSON value of [audience].
     *
     * Unlike [audience], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _audience(): JsonField<String> = body._audience()

    /**
     * Returns the raw JSON value of [issuer].
     *
     * Unlike [issuer], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _issuer(): JsonField<String> = body._issuer()

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _name(): JsonField<String> = body._name()

    /**
     * Returns the raw JSON value of [attributeTransformations].
     *
     * Unlike [attributeTransformations], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    fun _attributeTransformations(): JsonField<List<AttributeTransformation>> =
        body._attributeTransformations()

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
     * Returns the raw JSON value of [verification].
     *
     * Unlike [verification], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _verification(): JsonField<Verification> = body._verification()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [WorkloadIdentityProviderCreateParams].
         *
         * The following fields are required:
         * ```java
         * .audience()
         * .issuer()
         * .name()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WorkloadIdentityProviderCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(
            workloadIdentityProviderCreateParams: WorkloadIdentityProviderCreateParams
        ) = apply {
            body = workloadIdentityProviderCreateParams.body.toBuilder()
            additionalHeaders = workloadIdentityProviderCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams =
                workloadIdentityProviderCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [audience]
         * - [issuer]
         * - [name]
         * - [type]
         * - [attributeTransformations]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        fun audience(audience: String) = apply { body.audience(audience) }

        /**
         * Sets [Builder.audience] to an arbitrary JSON value.
         *
         * You should usually call [Builder.audience] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun audience(audience: JsonField<String>) = apply { body.audience(audience) }

        fun issuer(issuer: String) = apply { body.issuer(issuer) }

        /**
         * Sets [Builder.issuer] to an arbitrary JSON value.
         *
         * You should usually call [Builder.issuer] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun issuer(issuer: JsonField<String>) = apply { body.issuer(issuer) }

        fun name(name: String) = apply { body.name(name) }

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { body.name(name) }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("oidc")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { body.type(type) }

        fun attributeTransformations(attributeTransformations: List<AttributeTransformation>) =
            apply {
                body.attributeTransformations(attributeTransformations)
            }

        /**
         * Sets [Builder.attributeTransformations] to an arbitrary JSON value.
         *
         * You should usually call [Builder.attributeTransformations] with a well-typed
         * `List<AttributeTransformation>` value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun attributeTransformations(
            attributeTransformations: JsonField<List<AttributeTransformation>>
        ) = apply { body.attributeTransformations(attributeTransformations) }

        /**
         * Adds a single [AttributeTransformation] to [attributeTransformations].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addAttributeTransformation(attributeTransformation: AttributeTransformation) = apply {
            body.addAttributeTransformation(attributeTransformation)
        }

        fun description(description: String) = apply { body.description(description) }

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

        fun verification(verification: Verification) = apply { body.verification(verification) }

        /**
         * Sets [Builder.verification] to an arbitrary JSON value.
         *
         * You should usually call [Builder.verification] with a well-typed [Verification] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun verification(verification: JsonField<Verification>) = apply {
            body.verification(verification)
        }

        /** Alias for calling [verification] with `Verification.ofDiscovery(discovery)`. */
        fun verification(discovery: Verification.Discovery) = apply { body.verification(discovery) }

        /**
         * Alias for calling [verification] with the following:
         * ```java
         * Verification.Discovery.builder()
         *     .discoveryUrl(discoveryUrl)
         *     .build()
         * ```
         */
        fun discoveryVerification(discoveryUrl: String?) = apply {
            body.discoveryVerification(discoveryUrl)
        }

        /** Alias for calling [discoveryVerification] with `discoveryUrl.orElse(null)`. */
        fun discoveryVerification(discoveryUrl: Optional<String>) =
            discoveryVerification(discoveryUrl.getOrNull())

        /** Alias for calling [verification] with `Verification.ofUploadedJwks(uploadedJwks)`. */
        fun verification(uploadedJwks: Verification.UploadedJwks) = apply {
            body.verification(uploadedJwks)
        }

        /**
         * Alias for calling [verification] with the following:
         * ```java
         * Verification.UploadedJwks.builder()
         *     .jwks(jwks)
         *     .build()
         * ```
         */
        fun uploadedJwksVerification(jwks: Verification.UploadedJwks.Jwks) = apply {
            body.uploadedJwksVerification(jwks)
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
         * Returns an immutable instance of [WorkloadIdentityProviderCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .audience()
         * .issuer()
         * .name()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): WorkloadIdentityProviderCreateParams =
            WorkloadIdentityProviderCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val audience: JsonField<String>,
        private val issuer: JsonField<String>,
        private val name: JsonField<String>,
        private val type: JsonValue,
        private val attributeTransformations: JsonField<List<AttributeTransformation>>,
        private val description: JsonField<String>,
        private val enabled: JsonField<Boolean>,
        private val verification: JsonField<Verification>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("audience")
            @ExcludeMissing
            audience: JsonField<String> = JsonMissing.of(),
            @JsonProperty("issuer") @ExcludeMissing issuer: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("attribute_transformations")
            @ExcludeMissing
            attributeTransformations: JsonField<List<AttributeTransformation>> = JsonMissing.of(),
            @JsonProperty("description")
            @ExcludeMissing
            description: JsonField<String> = JsonMissing.of(),
            @JsonProperty("enabled") @ExcludeMissing enabled: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("verification")
            @ExcludeMissing
            verification: JsonField<Verification> = JsonMissing.of(),
        ) : this(
            audience,
            issuer,
            name,
            type,
            attributeTransformations,
            description,
            enabled,
            verification,
            mutableMapOf(),
        )

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun audience(): String = audience.getRequired("audience")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun issuer(): String = issuer.getRequired("issuer")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("oidc")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun attributeTransformations(): Optional<List<AttributeTransformation>> =
            attributeTransformations.getOptional("attribute_transformations")

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
        fun verification(): Optional<Verification> = verification.getOptional("verification")

        /**
         * Returns the raw JSON value of [audience].
         *
         * Unlike [audience], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("audience") @ExcludeMissing fun _audience(): JsonField<String> = audience

        /**
         * Returns the raw JSON value of [issuer].
         *
         * Unlike [issuer], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("issuer") @ExcludeMissing fun _issuer(): JsonField<String> = issuer

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [attributeTransformations].
         *
         * Unlike [attributeTransformations], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("attribute_transformations")
        @ExcludeMissing
        fun _attributeTransformations(): JsonField<List<AttributeTransformation>> =
            attributeTransformations

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
         * Returns the raw JSON value of [verification].
         *
         * Unlike [verification], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("verification")
        @ExcludeMissing
        fun _verification(): JsonField<Verification> = verification

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
                "audience" to this.audience,
                "issuer" to this.issuer,
                "name" to this.name,
                "type" to this.type,
                "attribute_transformations" to this.attributeTransformations,
                "description" to this.description,
                "enabled" to this.enabled,
                "verification" to this.verification,
            )

        /**
         * Returns the legacy additional-properties view.
         *
         * @deprecated Use [_allProperties] to access both declared and additional JSON properties.
         *   This accessor retains its legacy additional-properties behavior.
         */
        @Deprecated("Use _allProperties() to access both declared and additional JSON properties.")
        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .audience()
             * .issuer()
             * .name()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var audience: JsonField<String>? = null
            private var issuer: JsonField<String>? = null
            private var name: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("oidc")
            private var attributeTransformations: JsonField<MutableList<AttributeTransformation>>? =
                null
            private var description: JsonField<String> = JsonMissing.of()
            private var enabled: JsonField<Boolean> = JsonMissing.of()
            private var verification: JsonField<Verification> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                audience = body.audience
                issuer = body.issuer
                name = body.name
                type = body.type
                attributeTransformations = body.attributeTransformations.map { it.toMutableList() }
                description = body.description
                enabled = body.enabled
                verification = body.verification
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            fun audience(audience: String) = audience(JsonField.of(audience))

            /**
             * Sets [Builder.audience] to an arbitrary JSON value.
             *
             * You should usually call [Builder.audience] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun audience(audience: JsonField<String>) = apply { this.audience = audience }

            fun issuer(issuer: String) = issuer(JsonField.of(issuer))

            /**
             * Sets [Builder.issuer] to an arbitrary JSON value.
             *
             * You should usually call [Builder.issuer] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun issuer(issuer: JsonField<String>) = apply { this.issuer = issuer }

            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("oidc")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            fun attributeTransformations(attributeTransformations: List<AttributeTransformation>) =
                attributeTransformations(JsonField.of(attributeTransformations))

            /**
             * Sets [Builder.attributeTransformations] to an arbitrary JSON value.
             *
             * You should usually call [Builder.attributeTransformations] with a well-typed
             * `List<AttributeTransformation>` value instead. This method is primarily for setting
             * the field to an undocumented or not yet supported value.
             */
            fun attributeTransformations(
                attributeTransformations: JsonField<List<AttributeTransformation>>
            ) = apply {
                this.attributeTransformations = attributeTransformations.map { it.toMutableList() }
            }

            /**
             * Adds a single [AttributeTransformation] to [attributeTransformations].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addAttributeTransformation(attributeTransformation: AttributeTransformation) =
                apply {
                    attributeTransformations =
                        (attributeTransformations?.takeUnless { it.isMissing() }
                                ?: JsonField.of(mutableListOf()))
                            .also {
                                checkKnown("attributeTransformations", it)
                                    .add(attributeTransformation)
                            }
                }

            fun description(description: String) = description(JsonField.of(description))

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

            fun verification(verification: Verification) = verification(JsonField.of(verification))

            /**
             * Sets [Builder.verification] to an arbitrary JSON value.
             *
             * You should usually call [Builder.verification] with a well-typed [Verification] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun verification(verification: JsonField<Verification>) = apply {
                this.verification = verification
            }

            /** Alias for calling [verification] with `Verification.ofDiscovery(discovery)`. */
            fun verification(discovery: Verification.Discovery) =
                verification(Verification.ofDiscovery(discovery))

            /**
             * Alias for calling [verification] with the following:
             * ```java
             * Verification.Discovery.builder()
             *     .discoveryUrl(discoveryUrl)
             *     .build()
             * ```
             */
            fun discoveryVerification(discoveryUrl: String?) =
                verification(Verification.Discovery.builder().discoveryUrl(discoveryUrl).build())

            /**
             * Alias for calling [verification] with `Verification.ofUploadedJwks(uploadedJwks)`.
             */
            fun verification(uploadedJwks: Verification.UploadedJwks) =
                verification(Verification.ofUploadedJwks(uploadedJwks))

            /**
             * Alias for calling [verification] with the following:
             * ```java
             * Verification.UploadedJwks.builder()
             *     .jwks(jwks)
             *     .build()
             * ```
             */
            fun uploadedJwksVerification(jwks: Verification.UploadedJwks.Jwks) =
                verification(Verification.UploadedJwks.builder().jwks(jwks).build())

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
             *
             * The following fields are required:
             * ```java
             * .audience()
             * .issuer()
             * .name()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("audience", audience),
                    checkRequired("issuer", issuer),
                    checkRequired("name", name),
                    type,
                    (attributeTransformations ?: JsonMissing.of()).map { it.toImmutable() },
                    description,
                    enabled,
                    verification,
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

            audience()
            issuer()
            name()
            _type().let {
                if (it != JsonValue.from("oidc")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            attributeTransformations().ifPresent { it.forEach { it.validate() } }
            description()
            enabled()
            verification().ifPresent { it.validate() }
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
            (if (audience.asKnown().isPresent) 1 else 0) +
                (if (issuer.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("oidc")) 1 else 0 } +
                (attributeTransformations.asKnown().getOrNull()?.sumOf { it.validity().toInt() }
                    ?: 0) +
                (if (description.asKnown().isPresent) 1 else 0) +
                (if (enabled.asKnown().isPresent) 1 else 0) +
                (verification.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                audience == other.audience &&
                issuer == other.issuer &&
                name == other.name &&
                type == other.type &&
                attributeTransformations == other.attributeTransformations &&
                description == other.description &&
                enabled == other.enabled &&
                verification == other.verification &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                audience,
                issuer,
                name,
                type,
                attributeTransformations,
                description,
                enabled,
                verification,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{audience=$audience, issuer=$issuer, name=$name, type=$type, attributeTransformations=$attributeTransformations, description=$description, enabled=$enabled, verification=$verification, additionalProperties=$additionalProperties}"
    }

    class AttributeTransformation
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val attribute: JsonField<String>,
        private val expression: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("attribute")
            @ExcludeMissing
            attribute: JsonField<String> = JsonMissing.of(),
            @JsonProperty("expression")
            @ExcludeMissing
            expression: JsonField<String> = JsonMissing.of(),
        ) : this(attribute, expression, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun attribute(): String = attribute.getRequired("attribute")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun expression(): String = expression.getRequired("expression")

        /**
         * Returns the raw JSON value of [attribute].
         *
         * Unlike [attribute], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("attribute") @ExcludeMissing fun _attribute(): JsonField<String> = attribute

        /**
         * Returns the raw JSON value of [expression].
         *
         * Unlike [expression], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("expression")
        @ExcludeMissing
        fun _expression(): JsonField<String> = expression

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
                "attribute" to this.attribute,
                "expression" to this.expression,
            )

        /**
         * Returns the legacy additional-properties view.
         *
         * @deprecated Use [_allProperties] to access both declared and additional JSON properties.
         *   This accessor retains its legacy additional-properties behavior.
         */
        @Deprecated("Use _allProperties() to access both declared and additional JSON properties.")
        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [AttributeTransformation].
             *
             * The following fields are required:
             * ```java
             * .attribute()
             * .expression()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [AttributeTransformation]. */
        class Builder internal constructor() {

            private var attribute: JsonField<String>? = null
            private var expression: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(attributeTransformation: AttributeTransformation) = apply {
                attribute = attributeTransformation.attribute
                expression = attributeTransformation.expression
                additionalProperties = attributeTransformation.additionalProperties.toMutableMap()
            }

            fun attribute(attribute: String) = attribute(JsonField.of(attribute))

            /**
             * Sets [Builder.attribute] to an arbitrary JSON value.
             *
             * You should usually call [Builder.attribute] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun attribute(attribute: JsonField<String>) = apply { this.attribute = attribute }

            fun expression(expression: String) = expression(JsonField.of(expression))

            /**
             * Sets [Builder.expression] to an arbitrary JSON value.
             *
             * You should usually call [Builder.expression] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun expression(expression: JsonField<String>) = apply { this.expression = expression }

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
             * Returns an immutable instance of [AttributeTransformation].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .attribute()
             * .expression()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): AttributeTransformation =
                AttributeTransformation(
                    checkRequired("attribute", attribute),
                    checkRequired("expression", expression),
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
        fun validate(): AttributeTransformation = apply {
            if (validated) {
                return@apply
            }

            attribute()
            expression()
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
            (if (attribute.asKnown().isPresent) 1 else 0) +
                (if (expression.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AttributeTransformation &&
                attribute == other.attribute &&
                expression == other.expression &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(attribute, expression, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "AttributeTransformation{attribute=$attribute, expression=$expression, additionalProperties=$additionalProperties}"
    }

    @JsonDeserialize(using = Verification.Deserializer::class)
    @JsonSerialize(using = Verification.Serializer::class)
    class Verification
    private constructor(
        private val discovery: Discovery? = null,
        private val uploadedJwks: UploadedJwks? = null,
        private val _json: JsonValue? = null,
    ) {

        fun discovery(): Optional<Discovery> = Optional.ofNullable(discovery)

        fun uploadedJwks(): Optional<UploadedJwks> = Optional.ofNullable(uploadedJwks)

        fun isDiscovery(): Boolean = discovery != null

        fun isUploadedJwks(): Boolean = uploadedJwks != null

        fun asDiscovery(): Discovery = discovery.getOrThrow("discovery")

        fun asUploadedJwks(): UploadedJwks = uploadedJwks.getOrThrow("uploadedJwks")

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
         * Optional<String> result = verification.accept(new Verification.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitDiscovery(Discovery discovery) {
         *         return Optional.of(discovery.toString());
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
                discovery != null -> visitor.visitDiscovery(discovery)
                uploadedJwks != null -> visitor.visitUploadedJwks(uploadedJwks)
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
        fun validate(): Verification = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitDiscovery(discovery: Discovery) {
                        discovery.validate()
                    }

                    override fun visitUploadedJwks(uploadedJwks: UploadedJwks) {
                        uploadedJwks.validate()
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
                    override fun visitDiscovery(discovery: Discovery) = discovery.validity()

                    override fun visitUploadedJwks(uploadedJwks: UploadedJwks) =
                        uploadedJwks.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Verification &&
                discovery == other.discovery &&
                uploadedJwks == other.uploadedJwks &&
                (discovery != null || uploadedJwks != null || _json == other._json)
        }

        override fun hashCode(): Int =
            if (discovery == null && uploadedJwks == null) Objects.hash(_json)
            else Objects.hash(discovery, uploadedJwks)

        override fun toString(): String =
            when {
                discovery != null -> "Verification{discovery=$discovery}"
                uploadedJwks != null -> "Verification{uploadedJwks=$uploadedJwks}"
                _json != null -> "Verification{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Verification")
            }

        companion object {

            @JvmStatic fun ofDiscovery(discovery: Discovery) = Verification(discovery = discovery)

            @JvmStatic
            fun ofUploadedJwks(uploadedJwks: UploadedJwks) =
                Verification(uploadedJwks = uploadedJwks)
        }

        /**
         * An interface that defines how to map each variant of [Verification] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            fun visitDiscovery(discovery: Discovery): T = unknown(JsonValue.from(discovery))

            fun visitUploadedJwks(uploadedJwks: UploadedJwks): T =
                unknown(JsonValue.from(uploadedJwks))

            /**
             * Maps an unknown variant of [Verification] to a value of type [T].
             *
             * An instance of [Verification] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * Unhandled known JSON variants reach this method as JSON values.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Verification")
            }
        }

        internal class Deserializer : BaseDeserializer<Verification>(Verification::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Verification {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "discovery" -> {
                        return tryDeserialize(node, jacksonTypeRef<Discovery>())?.let {
                            Verification(discovery = it, _json = json)
                        } ?: Verification(_json = json)
                    }
                    "uploaded_jwks" -> {
                        return tryDeserialize(node, jacksonTypeRef<UploadedJwks>())?.let {
                            Verification(uploadedJwks = it, _json = json)
                        } ?: Verification(_json = json)
                    }
                }

                return Verification(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Verification>(Verification::class) {

            override fun serialize(
                value: Verification,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.discovery != null -> generator.writeObject(value.discovery)
                    value.uploadedJwks != null -> generator.writeObject(value.uploadedJwks)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Verification")
                }
            }
        }

        class Discovery
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val discoveryUrl: JsonField<String>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("discovery_url")
                @ExcludeMissing
                discoveryUrl: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(discoveryUrl, type, mutableMapOf())

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun discoveryUrl(): Optional<String> = discoveryUrl.getOptional("discovery_url")

            /**
             * Expected to always return the following:
             * ```java
             * JsonValue.from("discovery")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Returns the raw JSON value of [discoveryUrl].
             *
             * Unlike [discoveryUrl], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("discovery_url")
            @ExcludeMissing
            fun _discoveryUrl(): JsonField<String> = discoveryUrl

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
                    "discovery_url" to this.discoveryUrl,
                    "type" to this.type,
                )

            /**
             * Returns the legacy additional-properties view.
             *
             * @deprecated Use [_allProperties] to access both declared and additional JSON
             *   properties. This accessor retains its legacy additional-properties behavior.
             */
            @Deprecated(
                "Use _allProperties() to access both declared and additional JSON properties."
            )
            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Discovery].
                 *
                 * The following fields are required:
                 * ```java
                 * .discoveryUrl()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Discovery]. */
            class Builder internal constructor() {

                private var discoveryUrl: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("discovery")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(discovery: Discovery) = apply {
                    discoveryUrl = discovery.discoveryUrl
                    type = discovery.type
                    additionalProperties = discovery.additionalProperties.toMutableMap()
                }

                fun discoveryUrl(discoveryUrl: String?) =
                    discoveryUrl(JsonField.ofNullable(discoveryUrl))

                /** Alias for calling [Builder.discoveryUrl] with `discoveryUrl.orElse(null)`. */
                fun discoveryUrl(discoveryUrl: Optional<String>) =
                    discoveryUrl(discoveryUrl.getOrNull())

                /**
                 * Sets [Builder.discoveryUrl] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.discoveryUrl] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun discoveryUrl(discoveryUrl: JsonField<String>) = apply {
                    this.discoveryUrl = discoveryUrl
                }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("discovery")
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
                 * Returns an immutable instance of [Discovery].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .discoveryUrl()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Discovery =
                    Discovery(
                        checkRequired("discoveryUrl", discoveryUrl),
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
            fun validate(): Discovery = apply {
                if (validated) {
                    return@apply
                }

                discoveryUrl()
                _type().let {
                    if (it != JsonValue.from("discovery")) {
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
                (if (discoveryUrl.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("discovery")) 1 else 0 }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Discovery &&
                    discoveryUrl == other.discoveryUrl &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(discoveryUrl, type, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Discovery{discoveryUrl=$discoveryUrl, type=$type, additionalProperties=$additionalProperties}"
        }

        class UploadedJwks
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val jwks: JsonField<Jwks>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("jwks") @ExcludeMissing jwks: JsonField<Jwks> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(jwks, type, mutableMapOf())

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun jwks(): Jwks = jwks.getRequired("jwks")

            /**
             * Expected to always return the following:
             * ```java
             * JsonValue.from("uploaded_jwks")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Returns the raw JSON value of [jwks].
             *
             * Unlike [jwks], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("jwks") @ExcludeMissing fun _jwks(): JsonField<Jwks> = jwks

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
                collectAllProperties(additionalProperties, "jwks" to this.jwks, "type" to this.type)

            /**
             * Returns the legacy additional-properties view.
             *
             * @deprecated Use [_allProperties] to access both declared and additional JSON
             *   properties. This accessor retains its legacy additional-properties behavior.
             */
            @Deprecated(
                "Use _allProperties() to access both declared and additional JSON properties."
            )
            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [UploadedJwks].
                 *
                 * The following fields are required:
                 * ```java
                 * .jwks()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [UploadedJwks]. */
            class Builder internal constructor() {

                private var jwks: JsonField<Jwks>? = null
                private var type: JsonValue = JsonValue.from("uploaded_jwks")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(uploadedJwks: UploadedJwks) = apply {
                    jwks = uploadedJwks.jwks
                    type = uploadedJwks.type
                    additionalProperties = uploadedJwks.additionalProperties.toMutableMap()
                }

                fun jwks(jwks: Jwks) = jwks(JsonField.of(jwks))

                /**
                 * Sets [Builder.jwks] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.jwks] with a well-typed [Jwks] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun jwks(jwks: JsonField<Jwks>) = apply { this.jwks = jwks }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("uploaded_jwks")
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
                 * Returns an immutable instance of [UploadedJwks].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .jwks()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): UploadedJwks =
                    UploadedJwks(
                        checkRequired("jwks", jwks),
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
            fun validate(): UploadedJwks = apply {
                if (validated) {
                    return@apply
                }

                jwks().validate()
                _type().let {
                    if (it != JsonValue.from("uploaded_jwks")) {
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
                (jwks.asKnown().getOrNull()?.validity() ?: 0) +
                    type.let { if (it == JsonValue.from("uploaded_jwks")) 1 else 0 }

            class Jwks
            @JsonCreator
            private constructor(
                @com.fasterxml.jackson.annotation.JsonValue
                private val additionalProperties: Map<String, JsonValue>
            ) {

                /**
                 * Returns an immutable snapshot of all present JSON properties, including declared
                 * and additional properties.
                 *
                 * Keys use their JSON names. Declared properties take precedence over additional
                 * properties with the same name. Missing properties are omitted, while explicit
                 * nulls and unrecognized values are preserved.
                 */
                fun _allProperties(): Map<String, JsonValue> =
                    collectAllProperties(additionalProperties)

                /**
                 * Returns the legacy additional-properties view.
                 *
                 * @deprecated Use [_allProperties] to access both declared and additional JSON
                 *   properties. This accessor retains its legacy additional-properties behavior.
                 */
                @Deprecated(
                    "Use _allProperties() to access both declared and additional JSON properties."
                )
                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun toBuilder() = Builder().from(this)

                companion object {

                    /** Returns a mutable builder for constructing an instance of [Jwks]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Jwks]. */
                class Builder internal constructor() {

                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(jwks: Jwks) = apply {
                        additionalProperties = jwks.additionalProperties.toMutableMap()
                    }

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
                     * Returns an immutable instance of [Jwks].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Jwks = Jwks(additionalProperties.toImmutable())
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Jwks = apply {
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
                    additionalProperties.count { (_, value) ->
                        !value.isNull() && !value.isMissing()
                    }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Jwks && additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() = "Jwks{additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is UploadedJwks &&
                    jwks == other.jwks &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(jwks, type, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "UploadedJwks{jwks=$jwks, type=$type, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WorkloadIdentityProviderCreateParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "WorkloadIdentityProviderCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
