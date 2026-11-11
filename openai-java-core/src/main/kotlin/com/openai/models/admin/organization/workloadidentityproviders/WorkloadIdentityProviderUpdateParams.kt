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

/** Update supplied provider fields, preserving omitted fields. */
class WorkloadIdentityProviderUpdateParams
private constructor(
    private val workloadIdentityProviderId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun workloadIdentityProviderId(): Optional<String> =
        Optional.ofNullable(workloadIdentityProviderId)

    /** @see Body.attributeTransformations */
    fun attributeTransformations(): java.util.Optional<List<AttributeTransformation>> =
        body.attributeTransformations()

    /** @see Body.attributeTransformationsOrThrow */
    fun attributeTransformationsOrThrow(): List<AttributeTransformation> =
        body.attributeTransformationsOrThrow()

    /** @see Body.audience */
    fun audience(): java.util.Optional<String> = body.audience()

    /** @see Body.audienceOrThrow */
    fun audienceOrThrow(): String = body.audienceOrThrow()

    /** @see Body.description */
    fun description(): java.util.Optional<String> = body.description()

    /** @see Body.descriptionOrThrow */
    fun descriptionOrThrow(): String = body.descriptionOrThrow()

    /** @see Body.enabled */
    fun enabled(): java.util.Optional<Boolean> = body.enabled()

    /** @see Body.enabledOrThrow */
    fun enabledOrThrow(): Boolean = body.enabledOrThrow()

    /** @see Body.issuer */
    fun issuer(): java.util.Optional<String> = body.issuer()

    /** @see Body.issuerOrThrow */
    fun issuerOrThrow(): String = body.issuerOrThrow()

    /** @see Body.name */
    fun name(): java.util.Optional<String> = body.name()

    /** @see Body.nameOrThrow */
    fun nameOrThrow(): String = body.nameOrThrow()

    /** @see Body.verification */
    fun verification(): java.util.Optional<Verification> = body.verification()

    /** @see Body.verificationOrThrow */
    fun verificationOrThrow(): Verification = body.verificationOrThrow()

    /**
     * Returns the raw JSON value of [attributeTransformations].
     *
     * Unlike [attributeTransformations], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    fun _attributeTransformations(): JsonField<List<AttributeTransformation>> =
        body._attributeTransformations()

    /**
     * Returns the raw JSON value of [audience].
     *
     * Unlike [audience], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _audience(): JsonField<String> = body._audience()

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

        @JvmStatic fun none(): WorkloadIdentityProviderUpdateParams = builder().build()

        /**
         * Returns a mutable builder for constructing an instance of
         * [WorkloadIdentityProviderUpdateParams].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WorkloadIdentityProviderUpdateParams]. */
    class Builder internal constructor() {

        private var workloadIdentityProviderId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(
            workloadIdentityProviderUpdateParams: WorkloadIdentityProviderUpdateParams
        ) = apply {
            workloadIdentityProviderId =
                workloadIdentityProviderUpdateParams.workloadIdentityProviderId
            body = workloadIdentityProviderUpdateParams.body.toBuilder()
            additionalHeaders = workloadIdentityProviderUpdateParams.additionalHeaders.toBuilder()
            additionalQueryParams =
                workloadIdentityProviderUpdateParams.additionalQueryParams.toBuilder()
        }

        fun workloadIdentityProviderId(workloadIdentityProviderId: String?) = apply {
            this.workloadIdentityProviderId = workloadIdentityProviderId
        }

        /**
         * Alias for calling [Builder.workloadIdentityProviderId] with
         * `workloadIdentityProviderId.orElse(null)`.
         */
        fun workloadIdentityProviderId(workloadIdentityProviderId: Optional<String>) =
            workloadIdentityProviderId(workloadIdentityProviderId.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [attributeTransformations]
         * - [audience]
         * - [description]
         * - [enabled]
         * - [issuer]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

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

        fun audience(audience: String) = apply { body.audience(audience) }

        /**
         * Sets [Builder.audience] to an arbitrary JSON value.
         *
         * You should usually call [Builder.audience] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun audience(audience: JsonField<String>) = apply { body.audience(audience) }

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

        /**
         * Alias for calling [verification] with
         * `Verification.ofDiscoveryVerificationParam(discoveryVerificationParam)`.
         */
        fun verification(discoveryVerificationParam: Verification.DiscoveryVerificationParam) =
            apply {
                body.verification(discoveryVerificationParam)
            }

        /**
         * Alias for calling [verification] with
         * `Verification.ofUploadedJwksVerificationParam(uploadedJwksVerificationParam)`.
         */
        fun verification(
            uploadedJwksVerificationParam: Verification.UploadedJwksVerificationParam
        ) = apply { body.verification(uploadedJwksVerificationParam) }

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
         * Returns an immutable instance of [WorkloadIdentityProviderUpdateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): WorkloadIdentityProviderUpdateParams =
            WorkloadIdentityProviderUpdateParams(
                workloadIdentityProviderId,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> workloadIdentityProviderId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val attributeTransformations: JsonField<List<AttributeTransformation>>,
        private val audience: JsonField<String>,
        private val description: JsonField<String>,
        private val enabled: JsonField<Boolean>,
        private val issuer: JsonField<String>,
        private val name: JsonField<String>,
        private val verification: JsonField<Verification>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("attribute_transformations")
            @ExcludeMissing
            attributeTransformations: JsonField<List<AttributeTransformation>> = JsonMissing.of(),
            @JsonProperty("audience")
            @ExcludeMissing
            audience: JsonField<String> = JsonMissing.of(),
            @JsonProperty("description")
            @ExcludeMissing
            description: JsonField<String> = JsonMissing.of(),
            @JsonProperty("enabled") @ExcludeMissing enabled: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("issuer") @ExcludeMissing issuer: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("verification")
            @ExcludeMissing
            verification: JsonField<Verification> = JsonMissing.of(),
        ) : this(
            attributeTransformations,
            audience,
            description,
            enabled,
            issuer,
            name,
            verification,
            mutableMapOf(),
        )

        /**
         * Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun attributeTransformations(): java.util.Optional<List<AttributeTransformation>> =
            attributeTransformations.getOptional("attribute_transformations")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun attributeTransformationsOrThrow(): List<AttributeTransformation> =
            attributeTransformations.getRequired("attribute_transformations")

        /**
         * Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun audience(): java.util.Optional<String> = audience.getOptional("audience")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun audienceOrThrow(): String = audience.getRequired("audience")

        /**
         * Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun description(): java.util.Optional<String> = description.getOptional("description")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun descriptionOrThrow(): String = description.getRequired("description")

        /**
         * Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun enabled(): java.util.Optional<Boolean> = enabled.getOptional("enabled")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun enabledOrThrow(): Boolean = enabled.getRequired("enabled")

        /**
         * Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun issuer(): java.util.Optional<String> = issuer.getOptional("issuer")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun issuerOrThrow(): String = issuer.getRequired("issuer")

        /**
         * Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun name(): java.util.Optional<String> = name.getOptional("name")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun nameOrThrow(): String = name.getRequired("name")

        /**
         * Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun verification(): java.util.Optional<Verification> =
            verification.getOptional("verification")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun verificationOrThrow(): Verification = verification.getRequired("verification")

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
         * Returns the raw JSON value of [audience].
         *
         * Unlike [audience], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("audience") @ExcludeMissing fun _audience(): JsonField<String> = audience

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
                "attribute_transformations" to this.attributeTransformations,
                "audience" to this.audience,
                "description" to this.description,
                "enabled" to this.enabled,
                "issuer" to this.issuer,
                "name" to this.name,
                "verification" to this.verification,
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

            private var attributeTransformations: JsonField<MutableList<AttributeTransformation>>? =
                null
            private var audience: JsonField<String> = JsonMissing.of()
            private var description: JsonField<String> = JsonMissing.of()
            private var enabled: JsonField<Boolean> = JsonMissing.of()
            private var issuer: JsonField<String> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var verification: JsonField<Verification> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                attributeTransformations = body.attributeTransformations.map { it.toMutableList() }
                audience = body.audience
                description = body.description
                enabled = body.enabled
                issuer = body.issuer
                name = body.name
                verification = body.verification
                additionalProperties = body.additionalProperties.toMutableMap()
            }

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

            fun audience(audience: String) = audience(JsonField.of(audience))

            /**
             * Sets [Builder.audience] to an arbitrary JSON value.
             *
             * You should usually call [Builder.audience] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun audience(audience: JsonField<String>) = apply { this.audience = audience }

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

            /**
             * Alias for calling [verification] with
             * `Verification.ofDiscoveryVerificationParam(discoveryVerificationParam)`.
             */
            fun verification(discoveryVerificationParam: Verification.DiscoveryVerificationParam) =
                verification(Verification.ofDiscoveryVerificationParam(discoveryVerificationParam))

            /**
             * Alias for calling [verification] with
             * `Verification.ofUploadedJwksVerificationParam(uploadedJwksVerificationParam)`.
             */
            fun verification(
                uploadedJwksVerificationParam: Verification.UploadedJwksVerificationParam
            ) =
                verification(
                    Verification.ofUploadedJwksVerificationParam(uploadedJwksVerificationParam)
                )

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
                    (attributeTransformations ?: JsonMissing.of()).map { it.toImmutable() },
                    audience,
                    description,
                    enabled,
                    issuer,
                    name,
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

            attributeTransformations().ifPresent { it.forEach { it.validate() } }
            audience()
            description()
            enabled()
            issuer()
            name()
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
            (attributeTransformations.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (audience.asKnown().isPresent) 1 else 0) +
                (if (description.asKnown().isPresent) 1 else 0) +
                (if (enabled.asKnown().isPresent) 1 else 0) +
                (if (issuer.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (verification.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                attributeTransformations == other.attributeTransformations &&
                audience == other.audience &&
                description == other.description &&
                enabled == other.enabled &&
                issuer == other.issuer &&
                name == other.name &&
                verification == other.verification &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                attributeTransformations,
                audience,
                description,
                enabled,
                issuer,
                name,
                verification,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{attributeTransformations=$attributeTransformations, audience=$audience, description=$description, enabled=$enabled, issuer=$issuer, name=$name, verification=$verification, additionalProperties=$additionalProperties}"
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
         * The schema requires this property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun attribute(): java.util.Optional<String> = attribute.getOptional("attribute")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun attributeOrThrow(): String = attribute.getRequired("attribute")

        /**
         * The schema requires this property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun expression(): java.util.Optional<String> = expression.getOptional("expression")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun expressionOrThrow(): String = expression.getRequired("expression")

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

        @JvmSynthetic
        internal fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        @JsonAnyGetter
        @ExcludeMissing
        private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

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

            attributeOrThrow()
            expressionOrThrow()
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
        private val discoveryVerificationParam: DiscoveryVerificationParam? = null,
        private val uploadedJwksVerificationParam: UploadedJwksVerificationParam? = null,
        private val _json: JsonValue? = null,
    ) {

        fun discoveryVerificationParam(): Optional<DiscoveryVerificationParam> =
            Optional.ofNullable(discoveryVerificationParam)

        fun uploadedJwksVerificationParam(): Optional<UploadedJwksVerificationParam> =
            Optional.ofNullable(uploadedJwksVerificationParam)

        fun isDiscoveryVerificationParam(): Boolean = discoveryVerificationParam != null

        fun isUploadedJwksVerificationParam(): Boolean = uploadedJwksVerificationParam != null

        fun asDiscoveryVerificationParam(): DiscoveryVerificationParam =
            discoveryVerificationParam.getOrThrow("discoveryVerificationParam")

        fun asUploadedJwksVerificationParam(): UploadedJwksVerificationParam =
            uploadedJwksVerificationParam.getOrThrow("uploadedJwksVerificationParam")

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
         *     public Optional<String> visitDiscoveryVerificationParam(DiscoveryVerificationParam discoveryVerificationParam) {
         *         return Optional.of(discoveryVerificationParam.toString());
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
                discoveryVerificationParam != null ->
                    visitor.visitDiscoveryVerificationParam(discoveryVerificationParam)
                uploadedJwksVerificationParam != null ->
                    visitor.visitUploadedJwksVerificationParam(uploadedJwksVerificationParam)
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
                    override fun visitDiscoveryVerificationParam(
                        discoveryVerificationParam: DiscoveryVerificationParam
                    ) {
                        discoveryVerificationParam.validate()
                    }

                    override fun visitUploadedJwksVerificationParam(
                        uploadedJwksVerificationParam: UploadedJwksVerificationParam
                    ) {
                        uploadedJwksVerificationParam.validate()
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
                    override fun visitDiscoveryVerificationParam(
                        discoveryVerificationParam: DiscoveryVerificationParam
                    ) = discoveryVerificationParam.validity()

                    override fun visitUploadedJwksVerificationParam(
                        uploadedJwksVerificationParam: UploadedJwksVerificationParam
                    ) = uploadedJwksVerificationParam.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Verification &&
                discoveryVerificationParam == other.discoveryVerificationParam &&
                uploadedJwksVerificationParam == other.uploadedJwksVerificationParam &&
                (discoveryVerificationParam != null ||
                    uploadedJwksVerificationParam != null ||
                    _json == other._json)
        }

        override fun hashCode(): Int =
            if (discoveryVerificationParam == null && uploadedJwksVerificationParam == null)
                Objects.hash(_json)
            else Objects.hash(discoveryVerificationParam, uploadedJwksVerificationParam)

        override fun toString(): String =
            when {
                discoveryVerificationParam != null ->
                    "Verification{discoveryVerificationParam=$discoveryVerificationParam}"
                uploadedJwksVerificationParam != null ->
                    "Verification{uploadedJwksVerificationParam=$uploadedJwksVerificationParam}"
                _json != null -> "Verification{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Verification")
            }

        companion object {

            @JvmStatic
            fun ofDiscoveryVerificationParam(
                discoveryVerificationParam: DiscoveryVerificationParam
            ) = Verification(discoveryVerificationParam = discoveryVerificationParam)

            @JvmStatic
            fun ofUploadedJwksVerificationParam(
                uploadedJwksVerificationParam: UploadedJwksVerificationParam
            ) = Verification(uploadedJwksVerificationParam = uploadedJwksVerificationParam)
        }

        /**
         * An interface that defines how to map each variant of [Verification] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            fun visitDiscoveryVerificationParam(
                discoveryVerificationParam: DiscoveryVerificationParam
            ): T = unknown(JsonValue.from(discoveryVerificationParam))

            fun visitUploadedJwksVerificationParam(
                uploadedJwksVerificationParam: UploadedJwksVerificationParam
            ): T = unknown(JsonValue.from(uploadedJwksVerificationParam))

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

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<DiscoveryVerificationParam>())
                                ?.let {
                                    Verification(discoveryVerificationParam = it, _json = json)
                                },
                            tryDeserialize(node, jacksonTypeRef<UploadedJwksVerificationParam>())
                                ?.let {
                                    Verification(uploadedJwksVerificationParam = it, _json = json)
                                },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Verification(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Verification>(Verification::class) {

            override fun serialize(
                value: Verification,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.discoveryVerificationParam != null ->
                        generator.writeObject(value.discoveryVerificationParam)
                    value.uploadedJwksVerificationParam != null ->
                        generator.writeObject(value.uploadedJwksVerificationParam)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Verification")
                }
            }
        }

        class DiscoveryVerificationParam
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
             * The schema requires this property. Returns empty if the JSON property is missing or
             * null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun discoveryUrl(): java.util.Optional<String> =
                discoveryUrl.getOptional("discovery_url")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun discoveryUrlOrThrow(): String = discoveryUrl.getRequired("discovery_url")

            /**
             * The schema requires this property. Returns empty if the JSON property is missing or
             * null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun type(): java.util.Optional<JsonValue> {
                val raw = type
                return when {
                    raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                    !(raw == JsonValue.from("discovery")) ->
                        throw OpenAIInvalidDataException("`type` is invalid")
                    else -> java.util.Optional.of(raw)
                }
            }

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

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
                 * [DiscoveryVerificationParam].
                 *
                 * The following fields are required:
                 * ```java
                 * .discoveryUrl()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [DiscoveryVerificationParam]. */
            class Builder internal constructor() {

                private var discoveryUrl: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("discovery")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(discoveryVerificationParam: DiscoveryVerificationParam) = apply {
                    discoveryUrl = discoveryVerificationParam.discoveryUrl
                    type = discoveryVerificationParam.type
                    additionalProperties =
                        discoveryVerificationParam.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [DiscoveryVerificationParam].
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
                fun build(): DiscoveryVerificationParam =
                    DiscoveryVerificationParam(
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
            fun validate(): DiscoveryVerificationParam = apply {
                if (validated) {
                    return@apply
                }

                discoveryUrl()
                typeOrThrow()
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

                return other is DiscoveryVerificationParam &&
                    discoveryUrl == other.discoveryUrl &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(discoveryUrl, type, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "DiscoveryVerificationParam{discoveryUrl=$discoveryUrl, type=$type, additionalProperties=$additionalProperties}"
        }

        class UploadedJwksVerificationParam
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
             * The schema requires this property. Returns empty if the JSON property is missing or
             * null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun jwks(): java.util.Optional<Jwks> = jwks.getOptional("jwks")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun jwksOrThrow(): Jwks = jwks.getRequired("jwks")

            /**
             * The schema requires this property. Returns empty if the JSON property is missing or
             * null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun type(): java.util.Optional<JsonValue> {
                val raw = type
                return when {
                    raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                    !(raw == JsonValue.from("uploaded_jwks")) ->
                        throw OpenAIInvalidDataException("`type` is invalid")
                    else -> java.util.Optional.of(raw)
                }
            }

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

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
                 * [UploadedJwksVerificationParam].
                 *
                 * The following fields are required:
                 * ```java
                 * .jwks()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [UploadedJwksVerificationParam]. */
            class Builder internal constructor() {

                private var jwks: JsonField<Jwks>? = null
                private var type: JsonValue = JsonValue.from("uploaded_jwks")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(uploadedJwksVerificationParam: UploadedJwksVerificationParam) =
                    apply {
                        jwks = uploadedJwksVerificationParam.jwks
                        type = uploadedJwksVerificationParam.type
                        additionalProperties =
                            uploadedJwksVerificationParam.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [UploadedJwksVerificationParam].
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
                fun build(): UploadedJwksVerificationParam =
                    UploadedJwksVerificationParam(
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
            fun validate(): UploadedJwksVerificationParam = apply {
                if (validated) {
                    return@apply
                }

                jwksOrThrow().validate()
                typeOrThrow()
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

                @JvmSynthetic
                internal fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                @JsonAnyGetter
                @ExcludeMissing
                private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

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

                return other is UploadedJwksVerificationParam &&
                    jwks == other.jwks &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(jwks, type, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "UploadedJwksVerificationParam{jwks=$jwks, type=$type, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WorkloadIdentityProviderUpdateParams &&
            workloadIdentityProviderId == other.workloadIdentityProviderId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(workloadIdentityProviderId, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "WorkloadIdentityProviderUpdateParams{workloadIdentityProviderId=$workloadIdentityProviderId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
