// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.externalkeys

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
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.Params
import com.openai.core.checkRequired
import com.openai.core.collectAllProperties
import com.openai.core.getOrThrow
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Add an external key config for an organization */
class ExternalKeyCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun body(): Body = body

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ExternalKeyCreateParams].
         *
         * The following fields are required:
         * ```java
         * .body()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ExternalKeyCreateParams]. */
    class Builder internal constructor() {

        private var body: Body? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(externalKeyCreateParams: ExternalKeyCreateParams) = apply {
            body = externalKeyCreateParams.body
            additionalHeaders = externalKeyCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = externalKeyCreateParams.additionalQueryParams.toBuilder()
        }

        fun body(body: Body) = apply { this.body = body }

        /** Alias for calling [body] with `Body.ofAws(aws)`. */
        fun body(aws: Body.Aws) = body(Body.ofAws(aws))

        /** Alias for calling [body] with `Body.ofGcp(gcp)`. */
        fun body(gcp: Body.Gcp) = body(Body.ofGcp(gcp))

        /** Alias for calling [body] with `Body.ofAzure(azure)`. */
        fun body(azure: Body.Azure) = body(Body.ofAzure(azure))

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
         * Returns an immutable instance of [ExternalKeyCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .body()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ExternalKeyCreateParams =
            ExternalKeyCreateParams(
                checkRequired("body", body),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    @JsonDeserialize(using = Body.Deserializer::class)
    @JsonSerialize(using = Body.Serializer::class)
    class Body
    private constructor(
        private val aws: Aws? = null,
        private val gcp: Gcp? = null,
        private val azure: Azure? = null,
        private val _json: JsonValue? = null,
    ) {

        fun aws(): Optional<Aws> = Optional.ofNullable(aws)

        fun gcp(): Optional<Gcp> = Optional.ofNullable(gcp)

        fun azure(): Optional<Azure> = Optional.ofNullable(azure)

        fun isAws(): Boolean = aws != null

        fun isGcp(): Boolean = gcp != null

        fun isAzure(): Boolean = azure != null

        fun asAws(): Aws = aws.getOrThrow("aws")

        fun asGcp(): Gcp = gcp.getOrThrow("gcp")

        fun asAzure(): Azure = azure.getOrThrow("azure")

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
         * Optional<String> result = body.accept(new Body.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitAws(Aws aws) {
         *         return Optional.of(aws.toString());
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
                aws != null -> visitor.visitAws(aws)
                gcp != null -> visitor.visitGcp(gcp)
                azure != null -> visitor.visitAzure(azure)
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
        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitAws(aws: Aws) {
                        aws.validate()
                    }

                    override fun visitGcp(gcp: Gcp) {
                        gcp.validate()
                    }

                    override fun visitAzure(azure: Azure) {
                        azure.validate()
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
                    override fun visitAws(aws: Aws) = aws.validity()

                    override fun visitGcp(gcp: Gcp) = gcp.validity()

                    override fun visitAzure(azure: Azure) = azure.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                aws == other.aws &&
                gcp == other.gcp &&
                azure == other.azure &&
                (aws != null || gcp != null || azure != null || _json == other._json)
        }

        override fun hashCode(): Int =
            if (aws == null && gcp == null && azure == null) Objects.hash(_json)
            else Objects.hash(aws, gcp, azure)

        override fun toString(): String =
            when {
                aws != null -> "Body{aws=$aws}"
                gcp != null -> "Body{gcp=$gcp}"
                azure != null -> "Body{azure=$azure}"
                _json != null -> "Body{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Body")
            }

        companion object {

            @JvmStatic fun ofAws(aws: Aws) = Body(aws = aws)

            @JvmStatic fun ofGcp(gcp: Gcp) = Body(gcp = gcp)

            @JvmStatic fun ofAzure(azure: Azure) = Body(azure = azure)
        }

        /** An interface that defines how to map each variant of [Body] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitAws(aws: Aws): T = unknown(JsonValue.from(aws))

            fun visitGcp(gcp: Gcp): T = unknown(JsonValue.from(gcp))

            fun visitAzure(azure: Azure): T = unknown(JsonValue.from(azure))

            /**
             * Maps an unknown variant of [Body] to a value of type [T].
             *
             * An instance of [Body] can contain an unknown variant if it was deserialized from data
             * that doesn't match any known variant. For example, if the SDK is on an older version
             * than the API, then the API may respond with new variants that the SDK is unaware of.
             *
             * Unhandled known JSON variants reach this method as JSON values.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Body")
            }
        }

        internal class Deserializer : BaseDeserializer<Body>(Body::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Body {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "aws" -> {
                        return tryDeserialize(node, jacksonTypeRef<Aws>())?.let {
                            Body(aws = it, _json = json)
                        } ?: Body(_json = json)
                    }
                    "gcp" -> {
                        return tryDeserialize(node, jacksonTypeRef<Gcp>())?.let {
                            Body(gcp = it, _json = json)
                        } ?: Body(_json = json)
                    }
                    "azure" -> {
                        return tryDeserialize(node, jacksonTypeRef<Azure>())?.let {
                            Body(azure = it, _json = json)
                        } ?: Body(_json = json)
                    }
                }

                return Body(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Body>(Body::class) {

            override fun serialize(
                value: Body,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.aws != null -> generator.writeObject(value.aws)
                    value.gcp != null -> generator.writeObject(value.gcp)
                    value.azure != null -> generator.writeObject(value.azure)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Body")
                }
            }
        }

        class Aws
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val externalId: JsonField<String>,
            private val kmsArn: JsonField<String>,
            private val name: JsonField<String>,
            private val roleArn: JsonField<String>,
            private val type: JsonValue,
            private val purpose: JsonField<Purpose>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("external_id")
                @ExcludeMissing
                externalId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("kms_arn")
                @ExcludeMissing
                kmsArn: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("role_arn")
                @ExcludeMissing
                roleArn: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("purpose")
                @ExcludeMissing
                purpose: JsonField<Purpose> = JsonMissing.of(),
            ) : this(externalId, kmsArn, name, roleArn, type, purpose, mutableMapOf())

            /**
             * The ExternalID that OpenAI will pass in the AssumeRole call for the customer's AWS
             * account. This must be the OpenAI organization ID or an API project ID that belongs to
             * the organization. The schema requires this property. Returns empty if the JSON
             * property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun externalId(): java.util.Optional<String> = externalId.getOptional("external_id")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun externalIdOrThrow(): String = externalId.getRequired("external_id")

            /**
             * The Key Management System ARN for the master key you manage The schema requires this
             * property. Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun kmsArn(): java.util.Optional<String> = kmsArn.getOptional("kms_arn")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun kmsArnOrThrow(): String = kmsArn.getRequired("kms_arn")

            /**
             * A friendly name to identify this config The schema requires this property. Returns
             * empty if the JSON property is missing or null.
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
             * The Role ARN that OpenAI will assume to call your KMS The schema requires this
             * property. Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun roleArn(): java.util.Optional<String> = roleArn.getOptional("role_arn")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun roleArnOrThrow(): String = roleArn.getRequired("role_arn")

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
                    !(raw == JsonValue.from("aws")) ->
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
             * Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun purpose(): java.util.Optional<Purpose> = purpose.getOptional("purpose")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun purposeOrThrow(): Purpose = purpose.getRequired("purpose")

            /**
             * Returns the raw JSON value of [externalId].
             *
             * Unlike [externalId], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("external_id")
            @ExcludeMissing
            fun _externalId(): JsonField<String> = externalId

            /**
             * Returns the raw JSON value of [kmsArn].
             *
             * Unlike [kmsArn], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("kms_arn") @ExcludeMissing fun _kmsArn(): JsonField<String> = kmsArn

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [roleArn].
             *
             * Unlike [roleArn], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("role_arn") @ExcludeMissing fun _roleArn(): JsonField<String> = roleArn

            /**
             * Returns the raw JSON value of [purpose].
             *
             * Unlike [purpose], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("purpose") @ExcludeMissing fun _purpose(): JsonField<Purpose> = purpose

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
                    "external_id" to this.externalId,
                    "kms_arn" to this.kmsArn,
                    "name" to this.name,
                    "role_arn" to this.roleArn,
                    "type" to this.type,
                    "purpose" to this.purpose,
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
                 * Returns a mutable builder for constructing an instance of [Aws].
                 *
                 * The following fields are required:
                 * ```java
                 * .externalId()
                 * .kmsArn()
                 * .name()
                 * .roleArn()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Aws]. */
            class Builder internal constructor() {

                private var externalId: JsonField<String>? = null
                private var kmsArn: JsonField<String>? = null
                private var name: JsonField<String>? = null
                private var roleArn: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("aws")
                private var purpose: JsonField<Purpose> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(aws: Aws) = apply {
                    externalId = aws.externalId
                    kmsArn = aws.kmsArn
                    name = aws.name
                    roleArn = aws.roleArn
                    type = aws.type
                    purpose = aws.purpose
                    additionalProperties = aws.additionalProperties.toMutableMap()
                }

                /**
                 * The ExternalID that OpenAI will pass in the AssumeRole call for the customer's
                 * AWS account. This must be the OpenAI organization ID or an API project ID that
                 * belongs to the organization.
                 */
                fun externalId(externalId: String) = externalId(JsonField.of(externalId))

                /**
                 * Sets [Builder.externalId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.externalId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun externalId(externalId: JsonField<String>) = apply {
                    this.externalId = externalId
                }

                /** The Key Management System ARN for the master key you manage */
                fun kmsArn(kmsArn: String) = kmsArn(JsonField.of(kmsArn))

                /**
                 * Sets [Builder.kmsArn] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.kmsArn] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun kmsArn(kmsArn: JsonField<String>) = apply { this.kmsArn = kmsArn }

                /** A friendly name to identify this config */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                /** The Role ARN that OpenAI will assume to call your KMS */
                fun roleArn(roleArn: String) = roleArn(JsonField.of(roleArn))

                /**
                 * Sets [Builder.roleArn] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.roleArn] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun roleArn(roleArn: JsonField<String>) = apply { this.roleArn = roleArn }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("aws")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                fun purpose(purpose: Purpose) = purpose(JsonField.of(purpose))

                /**
                 * Sets [Builder.purpose] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.purpose] with a well-typed [Purpose] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun purpose(purpose: JsonField<Purpose>) = apply { this.purpose = purpose }

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
                 * Returns an immutable instance of [Aws].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .externalId()
                 * .kmsArn()
                 * .name()
                 * .roleArn()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Aws =
                    Aws(
                        checkRequired("externalId", externalId),
                        checkRequired("kmsArn", kmsArn),
                        checkRequired("name", name),
                        checkRequired("roleArn", roleArn),
                        type,
                        purpose,
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
            fun validate(): Aws = apply {
                if (validated) {
                    return@apply
                }

                externalIdOrThrow()
                kmsArnOrThrow()
                nameOrThrow()
                roleArnOrThrow()
                typeOrThrow()
                purpose().ifPresent { it.validate() }
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
                (if (externalId.asKnown().isPresent) 1 else 0) +
                    (if (kmsArn.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (if (roleArn.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("aws")) 1 else 0 } +
                    (purpose.asKnown().getOrNull()?.validity() ?: 0)

            class Purpose @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val EKM = of("ekm")

                    @JvmField val PSP_DECRYPTION = of("psp_decryption")

                    @JvmStatic fun of(value: String) = Purpose(JsonField.of(value))
                }

                /** An enum containing [Purpose]'s known values. */
                @Deprecated("Use asString() for string values or _value() for raw JSON.")
                enum class Known {
                    EKM,
                    PSP_DECRYPTION,
                }

                /**
                 * An enum containing [Purpose]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Purpose] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                @Deprecated("Use asString() for string values or _value() for raw JSON.")
                enum class Value {
                    EKM,
                    PSP_DECRYPTION,
                    /**
                     * An enum member indicating that [Purpose] was instantiated with an unknown
                     * value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                @Deprecated("Use asString() for string values or _value() for raw JSON.")
                fun value(): Value =
                    when (this) {
                        EKM -> Value.EKM
                        PSP_DECRYPTION -> Value.PSP_DECRYPTION
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value is a not a
                 *   known member.
                 */
                @Deprecated("Use asString() for string values or _value() for raw JSON.")
                fun known(): Known =
                    when (this) {
                        EKM -> Known.EKM
                        PSP_DECRYPTION -> Known.PSP_DECRYPTION
                        else -> throw OpenAIInvalidDataException("Unknown Purpose: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value does not have
                 *   the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        OpenAIInvalidDataException("Value is not a String")
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
                fun validate(): Purpose = apply {
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

                    return other is Purpose && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Aws &&
                    externalId == other.externalId &&
                    kmsArn == other.kmsArn &&
                    name == other.name &&
                    roleArn == other.roleArn &&
                    type == other.type &&
                    purpose == other.purpose &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(externalId, kmsArn, name, roleArn, type, purpose, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Aws{externalId=$externalId, kmsArn=$kmsArn, name=$name, roleArn=$roleArn, type=$type, purpose=$purpose, additionalProperties=$additionalProperties}"
        }

        class Gcp
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val audience: JsonField<String>,
            private val kmsKeyLocation: JsonField<String>,
            private val kmsKeyName: JsonField<String>,
            private val kmsKeyRingName: JsonField<String>,
            private val kmsProjectId: JsonField<String>,
            private val name: JsonField<String>,
            private val type: JsonValue,
            private val workloadIdentityPoolId: JsonField<String>,
            private val workloadIdentityProjectNumber: JsonField<String>,
            private val workloadIdentityProviderId: JsonField<String>,
            private val kmsKeyVersion: JsonField<String>,
            private val purpose: JsonField<Purpose>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("audience")
                @ExcludeMissing
                audience: JsonField<String> = JsonMissing.of(),
                @JsonProperty("kms_key_location")
                @ExcludeMissing
                kmsKeyLocation: JsonField<String> = JsonMissing.of(),
                @JsonProperty("kms_key_name")
                @ExcludeMissing
                kmsKeyName: JsonField<String> = JsonMissing.of(),
                @JsonProperty("kms_key_ring_name")
                @ExcludeMissing
                kmsKeyRingName: JsonField<String> = JsonMissing.of(),
                @JsonProperty("kms_project_id")
                @ExcludeMissing
                kmsProjectId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("workload_identity_pool_id")
                @ExcludeMissing
                workloadIdentityPoolId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("workload_identity_project_number")
                @ExcludeMissing
                workloadIdentityProjectNumber: JsonField<String> = JsonMissing.of(),
                @JsonProperty("workload_identity_provider_id")
                @ExcludeMissing
                workloadIdentityProviderId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("kms_key_version")
                @ExcludeMissing
                kmsKeyVersion: JsonField<String> = JsonMissing.of(),
                @JsonProperty("purpose")
                @ExcludeMissing
                purpose: JsonField<Purpose> = JsonMissing.of(),
            ) : this(
                audience,
                kmsKeyLocation,
                kmsKeyName,
                kmsKeyRingName,
                kmsProjectId,
                name,
                type,
                workloadIdentityPoolId,
                workloadIdentityProjectNumber,
                workloadIdentityProviderId,
                kmsKeyVersion,
                purpose,
                mutableMapOf(),
            )

            /**
             * The aud field in the identity token OpenAI will pass in the call to the customer's
             * GCP STS. This must be the OpenAI organization ID or an API project ID that belongs to
             * the organization. The schema requires this property. Returns empty if the JSON
             * property is missing or null.
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
             * The region where your Key Management System master key is located The schema requires
             * this property. Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun kmsKeyLocation(): java.util.Optional<String> =
                kmsKeyLocation.getOptional("kms_key_location")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun kmsKeyLocationOrThrow(): String = kmsKeyLocation.getRequired("kms_key_location")

            /**
             * The name of the Key Management System master key you manage The schema requires this
             * property. Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun kmsKeyName(): java.util.Optional<String> = kmsKeyName.getOptional("kms_key_name")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun kmsKeyNameOrThrow(): String = kmsKeyName.getRequired("kms_key_name")

            /**
             * The Key Management System key ring for the master key you manage The schema requires
             * this property. Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun kmsKeyRingName(): java.util.Optional<String> =
                kmsKeyRingName.getOptional("kms_key_ring_name")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun kmsKeyRingNameOrThrow(): String = kmsKeyRingName.getRequired("kms_key_ring_name")

            /**
             * The string GCP project name where your KMS resides The schema requires this property.
             * Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun kmsProjectId(): java.util.Optional<String> =
                kmsProjectId.getOptional("kms_project_id")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun kmsProjectIdOrThrow(): String = kmsProjectId.getRequired("kms_project_id")

            /**
             * A friendly name to identify this config The schema requires this property. Returns
             * empty if the JSON property is missing or null.
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
             * The schema requires this property. Returns empty if the JSON property is missing or
             * null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun type(): java.util.Optional<JsonValue> {
                val raw = type
                return when {
                    raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                    !(raw == JsonValue.from("gcp")) ->
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
             * The pool containing the Workload Identity provider that you registered for OpenAI The
             * schema requires this property. Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun workloadIdentityPoolId(): java.util.Optional<String> =
                workloadIdentityPoolId.getOptional("workload_identity_pool_id")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun workloadIdentityPoolIdOrThrow(): String =
                workloadIdentityPoolId.getRequired("workload_identity_pool_id")

            /**
             * The numeric GCP project number where you registered OpenAI's workload identity The
             * schema requires this property. Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun workloadIdentityProjectNumber(): java.util.Optional<String> =
                workloadIdentityProjectNumber.getOptional("workload_identity_project_number")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun workloadIdentityProjectNumberOrThrow(): String =
                workloadIdentityProjectNumber.getRequired("workload_identity_project_number")

            /**
             * The Workload Identity provider that you registered for OpenAI The schema requires
             * this property. Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun workloadIdentityProviderId(): java.util.Optional<String> =
                workloadIdentityProviderId.getOptional("workload_identity_provider_id")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun workloadIdentityProviderIdOrThrow(): String =
                workloadIdentityProviderId.getRequired("workload_identity_provider_id")

            /**
             * An exact CryptoKeyVersion number. Required for PSP decryption; not accepted for EKM.
             * Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun kmsKeyVersion(): java.util.Optional<String> =
                kmsKeyVersion.getOptional("kms_key_version")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun kmsKeyVersionOrThrow(): String = kmsKeyVersion.getRequired("kms_key_version")

            /**
             * Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun purpose(): java.util.Optional<Purpose> = purpose.getOptional("purpose")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun purposeOrThrow(): Purpose = purpose.getRequired("purpose")

            /**
             * Returns the raw JSON value of [audience].
             *
             * Unlike [audience], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("audience") @ExcludeMissing fun _audience(): JsonField<String> = audience

            /**
             * Returns the raw JSON value of [kmsKeyLocation].
             *
             * Unlike [kmsKeyLocation], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("kms_key_location")
            @ExcludeMissing
            fun _kmsKeyLocation(): JsonField<String> = kmsKeyLocation

            /**
             * Returns the raw JSON value of [kmsKeyName].
             *
             * Unlike [kmsKeyName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("kms_key_name")
            @ExcludeMissing
            fun _kmsKeyName(): JsonField<String> = kmsKeyName

            /**
             * Returns the raw JSON value of [kmsKeyRingName].
             *
             * Unlike [kmsKeyRingName], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("kms_key_ring_name")
            @ExcludeMissing
            fun _kmsKeyRingName(): JsonField<String> = kmsKeyRingName

            /**
             * Returns the raw JSON value of [kmsProjectId].
             *
             * Unlike [kmsProjectId], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("kms_project_id")
            @ExcludeMissing
            fun _kmsProjectId(): JsonField<String> = kmsProjectId

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [workloadIdentityPoolId].
             *
             * Unlike [workloadIdentityPoolId], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("workload_identity_pool_id")
            @ExcludeMissing
            fun _workloadIdentityPoolId(): JsonField<String> = workloadIdentityPoolId

            /**
             * Returns the raw JSON value of [workloadIdentityProjectNumber].
             *
             * Unlike [workloadIdentityProjectNumber], this method doesn't throw if the JSON field
             * has an unexpected type.
             */
            @JsonProperty("workload_identity_project_number")
            @ExcludeMissing
            fun _workloadIdentityProjectNumber(): JsonField<String> = workloadIdentityProjectNumber

            /**
             * Returns the raw JSON value of [workloadIdentityProviderId].
             *
             * Unlike [workloadIdentityProviderId], this method doesn't throw if the JSON field has
             * an unexpected type.
             */
            @JsonProperty("workload_identity_provider_id")
            @ExcludeMissing
            fun _workloadIdentityProviderId(): JsonField<String> = workloadIdentityProviderId

            /**
             * Returns the raw JSON value of [kmsKeyVersion].
             *
             * Unlike [kmsKeyVersion], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("kms_key_version")
            @ExcludeMissing
            fun _kmsKeyVersion(): JsonField<String> = kmsKeyVersion

            /**
             * Returns the raw JSON value of [purpose].
             *
             * Unlike [purpose], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("purpose") @ExcludeMissing fun _purpose(): JsonField<Purpose> = purpose

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
                    "audience" to this.audience,
                    "kms_key_location" to this.kmsKeyLocation,
                    "kms_key_name" to this.kmsKeyName,
                    "kms_key_ring_name" to this.kmsKeyRingName,
                    "kms_project_id" to this.kmsProjectId,
                    "name" to this.name,
                    "type" to this.type,
                    "workload_identity_pool_id" to this.workloadIdentityPoolId,
                    "workload_identity_project_number" to this.workloadIdentityProjectNumber,
                    "workload_identity_provider_id" to this.workloadIdentityProviderId,
                    "kms_key_version" to this.kmsKeyVersion,
                    "purpose" to this.purpose,
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
                 * Returns a mutable builder for constructing an instance of [Gcp].
                 *
                 * The following fields are required:
                 * ```java
                 * .audience()
                 * .kmsKeyLocation()
                 * .kmsKeyName()
                 * .kmsKeyRingName()
                 * .kmsProjectId()
                 * .name()
                 * .workloadIdentityPoolId()
                 * .workloadIdentityProjectNumber()
                 * .workloadIdentityProviderId()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Gcp]. */
            class Builder internal constructor() {

                private var audience: JsonField<String>? = null
                private var kmsKeyLocation: JsonField<String>? = null
                private var kmsKeyName: JsonField<String>? = null
                private var kmsKeyRingName: JsonField<String>? = null
                private var kmsProjectId: JsonField<String>? = null
                private var name: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("gcp")
                private var workloadIdentityPoolId: JsonField<String>? = null
                private var workloadIdentityProjectNumber: JsonField<String>? = null
                private var workloadIdentityProviderId: JsonField<String>? = null
                private var kmsKeyVersion: JsonField<String> = JsonMissing.of()
                private var purpose: JsonField<Purpose> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(gcp: Gcp) = apply {
                    audience = gcp.audience
                    kmsKeyLocation = gcp.kmsKeyLocation
                    kmsKeyName = gcp.kmsKeyName
                    kmsKeyRingName = gcp.kmsKeyRingName
                    kmsProjectId = gcp.kmsProjectId
                    name = gcp.name
                    type = gcp.type
                    workloadIdentityPoolId = gcp.workloadIdentityPoolId
                    workloadIdentityProjectNumber = gcp.workloadIdentityProjectNumber
                    workloadIdentityProviderId = gcp.workloadIdentityProviderId
                    kmsKeyVersion = gcp.kmsKeyVersion
                    purpose = gcp.purpose
                    additionalProperties = gcp.additionalProperties.toMutableMap()
                }

                /**
                 * The aud field in the identity token OpenAI will pass in the call to the
                 * customer's GCP STS. This must be the OpenAI organization ID or an API project ID
                 * that belongs to the organization.
                 */
                fun audience(audience: String) = audience(JsonField.of(audience))

                /**
                 * Sets [Builder.audience] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.audience] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun audience(audience: JsonField<String>) = apply { this.audience = audience }

                /** The region where your Key Management System master key is located */
                fun kmsKeyLocation(kmsKeyLocation: String) =
                    kmsKeyLocation(JsonField.of(kmsKeyLocation))

                /**
                 * Sets [Builder.kmsKeyLocation] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.kmsKeyLocation] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun kmsKeyLocation(kmsKeyLocation: JsonField<String>) = apply {
                    this.kmsKeyLocation = kmsKeyLocation
                }

                /** The name of the Key Management System master key you manage */
                fun kmsKeyName(kmsKeyName: String) = kmsKeyName(JsonField.of(kmsKeyName))

                /**
                 * Sets [Builder.kmsKeyName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.kmsKeyName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun kmsKeyName(kmsKeyName: JsonField<String>) = apply {
                    this.kmsKeyName = kmsKeyName
                }

                /** The Key Management System key ring for the master key you manage */
                fun kmsKeyRingName(kmsKeyRingName: String) =
                    kmsKeyRingName(JsonField.of(kmsKeyRingName))

                /**
                 * Sets [Builder.kmsKeyRingName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.kmsKeyRingName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun kmsKeyRingName(kmsKeyRingName: JsonField<String>) = apply {
                    this.kmsKeyRingName = kmsKeyRingName
                }

                /** The string GCP project name where your KMS resides */
                fun kmsProjectId(kmsProjectId: String) = kmsProjectId(JsonField.of(kmsProjectId))

                /**
                 * Sets [Builder.kmsProjectId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.kmsProjectId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun kmsProjectId(kmsProjectId: JsonField<String>) = apply {
                    this.kmsProjectId = kmsProjectId
                }

                /** A friendly name to identify this config */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("gcp")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                /**
                 * The pool containing the Workload Identity provider that you registered for OpenAI
                 */
                fun workloadIdentityPoolId(workloadIdentityPoolId: String) =
                    workloadIdentityPoolId(JsonField.of(workloadIdentityPoolId))

                /**
                 * Sets [Builder.workloadIdentityPoolId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.workloadIdentityPoolId] with a well-typed
                 * [String] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun workloadIdentityPoolId(workloadIdentityPoolId: JsonField<String>) = apply {
                    this.workloadIdentityPoolId = workloadIdentityPoolId
                }

                /**
                 * The numeric GCP project number where you registered OpenAI's workload identity
                 */
                fun workloadIdentityProjectNumber(workloadIdentityProjectNumber: String) =
                    workloadIdentityProjectNumber(JsonField.of(workloadIdentityProjectNumber))

                /**
                 * Sets [Builder.workloadIdentityProjectNumber] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.workloadIdentityProjectNumber] with a well-typed
                 * [String] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun workloadIdentityProjectNumber(
                    workloadIdentityProjectNumber: JsonField<String>
                ) = apply { this.workloadIdentityProjectNumber = workloadIdentityProjectNumber }

                /** The Workload Identity provider that you registered for OpenAI */
                fun workloadIdentityProviderId(workloadIdentityProviderId: String) =
                    workloadIdentityProviderId(JsonField.of(workloadIdentityProviderId))

                /**
                 * Sets [Builder.workloadIdentityProviderId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.workloadIdentityProviderId] with a well-typed
                 * [String] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun workloadIdentityProviderId(workloadIdentityProviderId: JsonField<String>) =
                    apply {
                        this.workloadIdentityProviderId = workloadIdentityProviderId
                    }

                /**
                 * An exact CryptoKeyVersion number. Required for PSP decryption; not accepted for
                 * EKM.
                 */
                fun kmsKeyVersion(kmsKeyVersion: String) =
                    kmsKeyVersion(JsonField.of(kmsKeyVersion))

                /**
                 * Sets [Builder.kmsKeyVersion] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.kmsKeyVersion] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun kmsKeyVersion(kmsKeyVersion: JsonField<String>) = apply {
                    this.kmsKeyVersion = kmsKeyVersion
                }

                fun purpose(purpose: Purpose) = purpose(JsonField.of(purpose))

                /**
                 * Sets [Builder.purpose] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.purpose] with a well-typed [Purpose] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun purpose(purpose: JsonField<Purpose>) = apply { this.purpose = purpose }

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
                 * Returns an immutable instance of [Gcp].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .audience()
                 * .kmsKeyLocation()
                 * .kmsKeyName()
                 * .kmsKeyRingName()
                 * .kmsProjectId()
                 * .name()
                 * .workloadIdentityPoolId()
                 * .workloadIdentityProjectNumber()
                 * .workloadIdentityProviderId()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Gcp =
                    Gcp(
                        checkRequired("audience", audience),
                        checkRequired("kmsKeyLocation", kmsKeyLocation),
                        checkRequired("kmsKeyName", kmsKeyName),
                        checkRequired("kmsKeyRingName", kmsKeyRingName),
                        checkRequired("kmsProjectId", kmsProjectId),
                        checkRequired("name", name),
                        type,
                        checkRequired("workloadIdentityPoolId", workloadIdentityPoolId),
                        checkRequired(
                            "workloadIdentityProjectNumber",
                            workloadIdentityProjectNumber,
                        ),
                        checkRequired("workloadIdentityProviderId", workloadIdentityProviderId),
                        kmsKeyVersion,
                        purpose,
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
            fun validate(): Gcp = apply {
                if (validated) {
                    return@apply
                }

                audienceOrThrow()
                kmsKeyLocationOrThrow()
                kmsKeyNameOrThrow()
                kmsKeyRingNameOrThrow()
                kmsProjectIdOrThrow()
                nameOrThrow()
                typeOrThrow()
                workloadIdentityPoolIdOrThrow()
                workloadIdentityProjectNumberOrThrow()
                workloadIdentityProviderIdOrThrow()
                kmsKeyVersion()
                purpose().ifPresent { it.validate() }
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
                    (if (kmsKeyLocation.asKnown().isPresent) 1 else 0) +
                    (if (kmsKeyName.asKnown().isPresent) 1 else 0) +
                    (if (kmsKeyRingName.asKnown().isPresent) 1 else 0) +
                    (if (kmsProjectId.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("gcp")) 1 else 0 } +
                    (if (workloadIdentityPoolId.asKnown().isPresent) 1 else 0) +
                    (if (workloadIdentityProjectNumber.asKnown().isPresent) 1 else 0) +
                    (if (workloadIdentityProviderId.asKnown().isPresent) 1 else 0) +
                    (if (kmsKeyVersion.asKnown().isPresent) 1 else 0) +
                    (purpose.asKnown().getOrNull()?.validity() ?: 0)

            class Purpose @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val EKM = of("ekm")

                    @JvmField val PSP_DECRYPTION = of("psp_decryption")

                    @JvmStatic fun of(value: String) = Purpose(JsonField.of(value))
                }

                /** An enum containing [Purpose]'s known values. */
                @Deprecated("Use asString() for string values or _value() for raw JSON.")
                enum class Known {
                    EKM,
                    PSP_DECRYPTION,
                }

                /**
                 * An enum containing [Purpose]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Purpose] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                @Deprecated("Use asString() for string values or _value() for raw JSON.")
                enum class Value {
                    EKM,
                    PSP_DECRYPTION,
                    /**
                     * An enum member indicating that [Purpose] was instantiated with an unknown
                     * value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                @Deprecated("Use asString() for string values or _value() for raw JSON.")
                fun value(): Value =
                    when (this) {
                        EKM -> Value.EKM
                        PSP_DECRYPTION -> Value.PSP_DECRYPTION
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value is a not a
                 *   known member.
                 */
                @Deprecated("Use asString() for string values or _value() for raw JSON.")
                fun known(): Known =
                    when (this) {
                        EKM -> Known.EKM
                        PSP_DECRYPTION -> Known.PSP_DECRYPTION
                        else -> throw OpenAIInvalidDataException("Unknown Purpose: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value does not have
                 *   the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        OpenAIInvalidDataException("Value is not a String")
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
                fun validate(): Purpose = apply {
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

                    return other is Purpose && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Gcp &&
                    audience == other.audience &&
                    kmsKeyLocation == other.kmsKeyLocation &&
                    kmsKeyName == other.kmsKeyName &&
                    kmsKeyRingName == other.kmsKeyRingName &&
                    kmsProjectId == other.kmsProjectId &&
                    name == other.name &&
                    type == other.type &&
                    workloadIdentityPoolId == other.workloadIdentityPoolId &&
                    workloadIdentityProjectNumber == other.workloadIdentityProjectNumber &&
                    workloadIdentityProviderId == other.workloadIdentityProviderId &&
                    kmsKeyVersion == other.kmsKeyVersion &&
                    purpose == other.purpose &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    audience,
                    kmsKeyLocation,
                    kmsKeyName,
                    kmsKeyRingName,
                    kmsProjectId,
                    name,
                    type,
                    workloadIdentityPoolId,
                    workloadIdentityProjectNumber,
                    workloadIdentityProviderId,
                    kmsKeyVersion,
                    purpose,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Gcp{audience=$audience, kmsKeyLocation=$kmsKeyLocation, kmsKeyName=$kmsKeyName, kmsKeyRingName=$kmsKeyRingName, kmsProjectId=$kmsProjectId, name=$name, type=$type, workloadIdentityPoolId=$workloadIdentityPoolId, workloadIdentityProjectNumber=$workloadIdentityProjectNumber, workloadIdentityProviderId=$workloadIdentityProviderId, kmsKeyVersion=$kmsKeyVersion, purpose=$purpose, additionalProperties=$additionalProperties}"
        }

        class Azure
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val keyName: JsonField<String>,
            private val name: JsonField<String>,
            private val tenantId: JsonField<String>,
            private val type: JsonValue,
            private val vaultUri: JsonField<String>,
            private val keyVersion: JsonField<String>,
            private val purpose: JsonField<Purpose>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("key_name")
                @ExcludeMissing
                keyName: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("tenant_id")
                @ExcludeMissing
                tenantId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("vault_uri")
                @ExcludeMissing
                vaultUri: JsonField<String> = JsonMissing.of(),
                @JsonProperty("key_version")
                @ExcludeMissing
                keyVersion: JsonField<String> = JsonMissing.of(),
                @JsonProperty("purpose")
                @ExcludeMissing
                purpose: JsonField<Purpose> = JsonMissing.of(),
            ) : this(keyName, name, tenantId, type, vaultUri, keyVersion, purpose, mutableMapOf())

            /**
             * The name of the Azure Key Vault master key that you manage The schema requires this
             * property. Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun keyName(): java.util.Optional<String> = keyName.getOptional("key_name")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun keyNameOrThrow(): String = keyName.getRequired("key_name")

            /**
             * A friendly name to identify this config The schema requires this property. Returns
             * empty if the JSON property is missing or null.
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
             * Your Azure tenant UUID The schema requires this property. Returns empty if the JSON
             * property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun tenantId(): java.util.Optional<String> = tenantId.getOptional("tenant_id")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun tenantIdOrThrow(): String = tenantId.getRequired("tenant_id")

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
                    !(raw == JsonValue.from("azure")) ->
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
             * The URI of the Azure vault containing the master key you manage The schema requires
             * this property. Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun vaultUri(): java.util.Optional<String> = vaultUri.getOptional("vault_uri")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun vaultUriOrThrow(): String = vaultUri.getRequired("vault_uri")

            /**
             * An exact Azure Key Vault key version. Required for PSP decryption; not accepted for
             * EKM. Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun keyVersion(): java.util.Optional<String> = keyVersion.getOptional("key_version")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun keyVersionOrThrow(): String = keyVersion.getRequired("key_version")

            /**
             * Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun purpose(): java.util.Optional<Purpose> = purpose.getOptional("purpose")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun purposeOrThrow(): Purpose = purpose.getRequired("purpose")

            /**
             * Returns the raw JSON value of [keyName].
             *
             * Unlike [keyName], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("key_name") @ExcludeMissing fun _keyName(): JsonField<String> = keyName

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [tenantId].
             *
             * Unlike [tenantId], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("tenant_id") @ExcludeMissing fun _tenantId(): JsonField<String> = tenantId

            /**
             * Returns the raw JSON value of [vaultUri].
             *
             * Unlike [vaultUri], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("vault_uri") @ExcludeMissing fun _vaultUri(): JsonField<String> = vaultUri

            /**
             * Returns the raw JSON value of [keyVersion].
             *
             * Unlike [keyVersion], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("key_version")
            @ExcludeMissing
            fun _keyVersion(): JsonField<String> = keyVersion

            /**
             * Returns the raw JSON value of [purpose].
             *
             * Unlike [purpose], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("purpose") @ExcludeMissing fun _purpose(): JsonField<Purpose> = purpose

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
                    "key_name" to this.keyName,
                    "name" to this.name,
                    "tenant_id" to this.tenantId,
                    "type" to this.type,
                    "vault_uri" to this.vaultUri,
                    "key_version" to this.keyVersion,
                    "purpose" to this.purpose,
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
                 * Returns a mutable builder for constructing an instance of [Azure].
                 *
                 * The following fields are required:
                 * ```java
                 * .keyName()
                 * .name()
                 * .tenantId()
                 * .vaultUri()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Azure]. */
            class Builder internal constructor() {

                private var keyName: JsonField<String>? = null
                private var name: JsonField<String>? = null
                private var tenantId: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("azure")
                private var vaultUri: JsonField<String>? = null
                private var keyVersion: JsonField<String> = JsonMissing.of()
                private var purpose: JsonField<Purpose> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(azure: Azure) = apply {
                    keyName = azure.keyName
                    name = azure.name
                    tenantId = azure.tenantId
                    type = azure.type
                    vaultUri = azure.vaultUri
                    keyVersion = azure.keyVersion
                    purpose = azure.purpose
                    additionalProperties = azure.additionalProperties.toMutableMap()
                }

                /** The name of the Azure Key Vault master key that you manage */
                fun keyName(keyName: String) = keyName(JsonField.of(keyName))

                /**
                 * Sets [Builder.keyName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.keyName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun keyName(keyName: JsonField<String>) = apply { this.keyName = keyName }

                /** A friendly name to identify this config */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                /** Your Azure tenant UUID */
                fun tenantId(tenantId: String) = tenantId(JsonField.of(tenantId))

                /**
                 * Sets [Builder.tenantId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.tenantId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun tenantId(tenantId: JsonField<String>) = apply { this.tenantId = tenantId }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("azure")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                /** The URI of the Azure vault containing the master key you manage */
                fun vaultUri(vaultUri: String) = vaultUri(JsonField.of(vaultUri))

                /**
                 * Sets [Builder.vaultUri] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.vaultUri] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun vaultUri(vaultUri: JsonField<String>) = apply { this.vaultUri = vaultUri }

                /**
                 * An exact Azure Key Vault key version. Required for PSP decryption; not accepted
                 * for EKM.
                 */
                fun keyVersion(keyVersion: String) = keyVersion(JsonField.of(keyVersion))

                /**
                 * Sets [Builder.keyVersion] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.keyVersion] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun keyVersion(keyVersion: JsonField<String>) = apply {
                    this.keyVersion = keyVersion
                }

                fun purpose(purpose: Purpose) = purpose(JsonField.of(purpose))

                /**
                 * Sets [Builder.purpose] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.purpose] with a well-typed [Purpose] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun purpose(purpose: JsonField<Purpose>) = apply { this.purpose = purpose }

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
                 * Returns an immutable instance of [Azure].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .keyName()
                 * .name()
                 * .tenantId()
                 * .vaultUri()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Azure =
                    Azure(
                        checkRequired("keyName", keyName),
                        checkRequired("name", name),
                        checkRequired("tenantId", tenantId),
                        type,
                        checkRequired("vaultUri", vaultUri),
                        keyVersion,
                        purpose,
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
            fun validate(): Azure = apply {
                if (validated) {
                    return@apply
                }

                keyNameOrThrow()
                nameOrThrow()
                tenantIdOrThrow()
                typeOrThrow()
                vaultUriOrThrow()
                keyVersion()
                purpose().ifPresent { it.validate() }
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
                (if (keyName.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (if (tenantId.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("azure")) 1 else 0 } +
                    (if (vaultUri.asKnown().isPresent) 1 else 0) +
                    (if (keyVersion.asKnown().isPresent) 1 else 0) +
                    (purpose.asKnown().getOrNull()?.validity() ?: 0)

            class Purpose @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val EKM = of("ekm")

                    @JvmField val PSP_DECRYPTION = of("psp_decryption")

                    @JvmStatic fun of(value: String) = Purpose(JsonField.of(value))
                }

                /** An enum containing [Purpose]'s known values. */
                @Deprecated("Use asString() for string values or _value() for raw JSON.")
                enum class Known {
                    EKM,
                    PSP_DECRYPTION,
                }

                /**
                 * An enum containing [Purpose]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Purpose] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                @Deprecated("Use asString() for string values or _value() for raw JSON.")
                enum class Value {
                    EKM,
                    PSP_DECRYPTION,
                    /**
                     * An enum member indicating that [Purpose] was instantiated with an unknown
                     * value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                @Deprecated("Use asString() for string values or _value() for raw JSON.")
                fun value(): Value =
                    when (this) {
                        EKM -> Value.EKM
                        PSP_DECRYPTION -> Value.PSP_DECRYPTION
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value is a not a
                 *   known member.
                 */
                @Deprecated("Use asString() for string values or _value() for raw JSON.")
                fun known(): Known =
                    when (this) {
                        EKM -> Known.EKM
                        PSP_DECRYPTION -> Known.PSP_DECRYPTION
                        else -> throw OpenAIInvalidDataException("Unknown Purpose: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value does not have
                 *   the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        OpenAIInvalidDataException("Value is not a String")
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
                fun validate(): Purpose = apply {
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

                    return other is Purpose && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Azure &&
                    keyName == other.keyName &&
                    name == other.name &&
                    tenantId == other.tenantId &&
                    type == other.type &&
                    vaultUri == other.vaultUri &&
                    keyVersion == other.keyVersion &&
                    purpose == other.purpose &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    keyName,
                    name,
                    tenantId,
                    type,
                    vaultUri,
                    keyVersion,
                    purpose,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Azure{keyName=$keyName, name=$name, tenantId=$tenantId, type=$type, vaultUri=$vaultUri, keyVersion=$keyVersion, purpose=$purpose, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ExternalKeyCreateParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "ExternalKeyCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
