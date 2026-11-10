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
import com.openai.core.JsonNull
import com.openai.core.JsonValue
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.collectAllProperties
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class WorkloadIdentityProvider
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val attributeTransformations: JsonField<List<AttributeTransformation>>,
    private val audience: JsonField<String>,
    private val createdAt: JsonField<Long>,
    private val description: JsonField<String>,
    private val enabled: JsonField<Boolean>,
    private val issuer: JsonField<String>,
    private val name: JsonField<String>,
    private val object_: JsonValue,
    private val type: JsonValue,
    private val updatedAt: JsonField<Long>,
    private val verification: JsonField<Verification>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("attribute_transformations")
        @ExcludeMissing
        attributeTransformations: JsonField<List<AttributeTransformation>> = JsonMissing.of(),
        @JsonProperty("audience") @ExcludeMissing audience: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("description")
        @ExcludeMissing
        description: JsonField<String> = JsonMissing.of(),
        @JsonProperty("enabled") @ExcludeMissing enabled: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("issuer") @ExcludeMissing issuer: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("updated_at") @ExcludeMissing updatedAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("verification")
        @ExcludeMissing
        verification: JsonField<Verification> = JsonMissing.of(),
    ) : this(
        id,
        attributeTransformations,
        audience,
        createdAt,
        description,
        enabled,
        issuer,
        name,
        object_,
        type,
        updatedAt,
        verification,
        mutableMapOf(),
    )

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun attributeTransformations(): List<AttributeTransformation> =
        attributeTransformations.getRequired("attribute_transformations")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun audience(): String = audience.getRequired("audience")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun description(): Optional<String> = description.getOptional("description")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun enabled(): Boolean = enabled.getRequired("enabled")

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
     * JsonValue.from("organization.workload_identity_provider")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * Expected to always return the following:
     * ```java
     * JsonValue.from("oidc")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun updatedAt(): Long = updatedAt.getRequired("updated_at")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun verification(): Verification = verification.getRequired("verification")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

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
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt(): JsonField<Long> = createdAt

    /**
     * Returns the raw JSON value of [description].
     *
     * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("description") @ExcludeMissing fun _description(): JsonField<String> = description

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
     * Returns the raw JSON value of [updatedAt].
     *
     * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("updated_at") @ExcludeMissing fun _updatedAt(): JsonField<Long> = updatedAt

    /**
     * Returns the raw JSON value of [verification].
     *
     * Unlike [verification], this method doesn't throw if the JSON field has an unexpected type.
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
            "id" to this.id,
            "attribute_transformations" to this.attributeTransformations,
            "audience" to this.audience,
            "created_at" to this.createdAt,
            "description" to this.description,
            "enabled" to this.enabled,
            "issuer" to this.issuer,
            "name" to this.name,
            "object" to this.object_,
            "type" to this.type,
            "updated_at" to this.updatedAt,
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

        /**
         * Returns a mutable builder for constructing an instance of [WorkloadIdentityProvider].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .attributeTransformations()
         * .audience()
         * .createdAt()
         * .enabled()
         * .issuer()
         * .name()
         * .updatedAt()
         * .verification()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WorkloadIdentityProvider]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var attributeTransformations: JsonField<MutableList<AttributeTransformation>>? =
            null
        private var audience: JsonField<String>? = null
        private var createdAt: JsonField<Long>? = null
        private var description: JsonField<String>? = JsonNull.of()
        private var enabled: JsonField<Boolean>? = null
        private var issuer: JsonField<String>? = null
        private var name: JsonField<String>? = null
        private var object_: JsonValue = JsonValue.from("organization.workload_identity_provider")
        private var type: JsonValue = JsonValue.from("oidc")
        private var updatedAt: JsonField<Long>? = null
        private var verification: JsonField<Verification>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(workloadIdentityProvider: WorkloadIdentityProvider) = apply {
            id = workloadIdentityProvider.id
            attributeTransformations =
                workloadIdentityProvider.attributeTransformations.map { it.toMutableList() }
            audience = workloadIdentityProvider.audience
            createdAt = workloadIdentityProvider.createdAt
            description = workloadIdentityProvider.description
            enabled = workloadIdentityProvider.enabled
            issuer = workloadIdentityProvider.issuer
            name = workloadIdentityProvider.name
            object_ = workloadIdentityProvider.object_
            type = workloadIdentityProvider.type
            updatedAt = workloadIdentityProvider.updatedAt
            verification = workloadIdentityProvider.verification
            additionalProperties = workloadIdentityProvider.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun attributeTransformations(attributeTransformations: List<AttributeTransformation>) =
            attributeTransformations(JsonField.of(attributeTransformations))

        /**
         * Sets [Builder.attributeTransformations] to an arbitrary JSON value.
         *
         * You should usually call [Builder.attributeTransformations] with a well-typed
         * `List<AttributeTransformation>` value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
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
        fun addAttributeTransformation(attributeTransformation: AttributeTransformation) = apply {
            attributeTransformations =
                (attributeTransformations ?: JsonField.of(mutableListOf())).also {
                    checkKnown("attributeTransformations", it).add(attributeTransformation)
                }
        }

        fun audience(audience: String) = audience(JsonField.of(audience))

        /**
         * Sets [Builder.audience] to an arbitrary JSON value.
         *
         * You should usually call [Builder.audience] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun audience(audience: JsonField<String>) = apply { this.audience = audience }

        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

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

        fun enabled(enabled: Boolean) = enabled(JsonField.of(enabled))

        /**
         * Sets [Builder.enabled] to an arbitrary JSON value.
         *
         * You should usually call [Builder.enabled] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun enabled(enabled: JsonField<Boolean>) = apply { this.enabled = enabled }

        fun issuer(issuer: String) = issuer(JsonField.of(issuer))

        /**
         * Sets [Builder.issuer] to an arbitrary JSON value.
         *
         * You should usually call [Builder.issuer] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun issuer(issuer: JsonField<String>) = apply { this.issuer = issuer }

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
         * JsonValue.from("organization.workload_identity_provider")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

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
        fun type(type: JsonValue) = apply { this.type = type }

        fun updatedAt(updatedAt: Long) = updatedAt(JsonField.of(updatedAt))

        /**
         * Sets [Builder.updatedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.updatedAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun updatedAt(updatedAt: JsonField<Long>) = apply { this.updatedAt = updatedAt }

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

        /** Alias for calling [discoveryVerification] with `discoveryUrl.orElse(null)`. */
        fun discoveryVerification(discoveryUrl: Optional<String>) =
            discoveryVerification(discoveryUrl.getOrNull())

        /** Alias for calling [verification] with `Verification.ofUploadedJwks(uploadedJwks)`. */
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
         * Returns an immutable instance of [WorkloadIdentityProvider].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .attributeTransformations()
         * .audience()
         * .createdAt()
         * .enabled()
         * .issuer()
         * .name()
         * .updatedAt()
         * .verification()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): WorkloadIdentityProvider =
            WorkloadIdentityProvider(
                checkRequired("id", id),
                checkRequired("attributeTransformations", attributeTransformations).map {
                    it.toImmutable()
                },
                checkRequired("audience", audience),
                checkRequired("createdAt", createdAt),
                checkRequired("description", description),
                checkRequired("enabled", enabled),
                checkRequired("issuer", issuer),
                checkRequired("name", name),
                object_,
                type,
                checkRequired("updatedAt", updatedAt),
                checkRequired("verification", verification),
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
    fun validate(): WorkloadIdentityProvider = apply {
        if (validated) {
            return@apply
        }

        id()
        attributeTransformations().forEach { it.validate() }
        audience()
        createdAt()
        description()
        enabled()
        issuer()
        name()
        _object_().let {
            if (it != JsonValue.from("organization.workload_identity_provider")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        _type().let {
            if (it != JsonValue.from("oidc")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        updatedAt()
        verification().validate()
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
            (attributeTransformations.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (audience.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (description.asKnown().isPresent) 1 else 0) +
            (if (enabled.asKnown().isPresent) 1 else 0) +
            (if (issuer.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            object_.let {
                if (it == JsonValue.from("organization.workload_identity_provider")) 1 else 0
            } +
            type.let { if (it == JsonValue.from("oidc")) 1 else 0 } +
            (if (updatedAt.asKnown().isPresent) 1 else 0) +
            (verification.asKnown().getOrNull()?.validity() ?: 0)

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

            @JvmSynthetic
            internal fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            @JsonAnyGetter
            @ExcludeMissing
            private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [Discovery]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Discovery]. */
            class Builder internal constructor() {

                private var discoveryUrl: JsonField<String>? = JsonNull.of()
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

            @JvmSynthetic
            internal fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            @JsonAnyGetter
            @ExcludeMissing
            private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

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

        return other is WorkloadIdentityProvider &&
            id == other.id &&
            attributeTransformations == other.attributeTransformations &&
            audience == other.audience &&
            createdAt == other.createdAt &&
            description == other.description &&
            enabled == other.enabled &&
            issuer == other.issuer &&
            name == other.name &&
            object_ == other.object_ &&
            type == other.type &&
            updatedAt == other.updatedAt &&
            verification == other.verification &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            attributeTransformations,
            audience,
            createdAt,
            description,
            enabled,
            issuer,
            name,
            object_,
            type,
            updatedAt,
            verification,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "WorkloadIdentityProvider{id=$id, attributeTransformations=$attributeTransformations, audience=$audience, createdAt=$createdAt, description=$description, enabled=$enabled, issuer=$issuer, name=$name, object_=$object_, type=$type, updatedAt=$updatedAt, verification=$verification, additionalProperties=$additionalProperties}"
}
