// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.externalstorage

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
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Register one customer-managed external storage configuration. */
class ExternalStorageCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun projectId(): String = body.projectId()

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun provider(): Provider = body.provider()

    /**
     * Returns the raw JSON value of [projectId].
     *
     * Unlike [projectId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _projectId(): JsonField<String> = body._projectId()

    /**
     * Returns the raw JSON value of [provider].
     *
     * Unlike [provider], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _provider(): JsonField<Provider> = body._provider()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ExternalStorageCreateParams].
         *
         * The following fields are required:
         * ```java
         * .projectId()
         * .provider()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ExternalStorageCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(externalStorageCreateParams: ExternalStorageCreateParams) = apply {
            body = externalStorageCreateParams.body.toBuilder()
            additionalHeaders = externalStorageCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = externalStorageCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [projectId]
         * - [provider]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        fun projectId(projectId: String) = apply { body.projectId(projectId) }

        /**
         * Sets [Builder.projectId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.projectId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun projectId(projectId: JsonField<String>) = apply { body.projectId(projectId) }

        fun provider(provider: Provider) = apply { body.provider(provider) }

        /**
         * Sets [Builder.provider] to an arbitrary JSON value.
         *
         * You should usually call [Builder.provider] with a well-typed [Provider] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun provider(provider: JsonField<Provider>) = apply { body.provider(provider) }

        /** Alias for calling [provider] with `Provider.ofAws(aws)`. */
        fun provider(aws: Provider.Aws) = apply { body.provider(aws) }

        /** Alias for calling [provider] with `Provider.ofAzure(azure)`. */
        fun provider(azure: Provider.Azure) = apply { body.provider(azure) }

        /** Alias for calling [provider] with `Provider.ofGcp(gcp)`. */
        fun provider(gcp: Provider.Gcp) = apply { body.provider(gcp) }

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
         * Returns an immutable instance of [ExternalStorageCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .projectId()
         * .provider()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ExternalStorageCreateParams =
            ExternalStorageCreateParams(
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
        private val projectId: JsonField<String>,
        private val provider: JsonField<Provider>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("project_id")
            @ExcludeMissing
            projectId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("provider")
            @ExcludeMissing
            provider: JsonField<Provider> = JsonMissing.of(),
        ) : this(projectId, provider, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun projectId(): String = projectId.getRequired("project_id")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun provider(): Provider = provider.getRequired("provider")

        /**
         * Returns the raw JSON value of [projectId].
         *
         * Unlike [projectId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("project_id") @ExcludeMissing fun _projectId(): JsonField<String> = projectId

        /**
         * Returns the raw JSON value of [provider].
         *
         * Unlike [provider], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("provider") @ExcludeMissing fun _provider(): JsonField<Provider> = provider

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
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .projectId()
             * .provider()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var projectId: JsonField<String>? = null
            private var provider: JsonField<Provider>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                projectId = body.projectId
                provider = body.provider
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            fun projectId(projectId: String) = projectId(JsonField.of(projectId))

            /**
             * Sets [Builder.projectId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.projectId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun projectId(projectId: JsonField<String>) = apply { this.projectId = projectId }

            fun provider(provider: Provider) = provider(JsonField.of(provider))

            /**
             * Sets [Builder.provider] to an arbitrary JSON value.
             *
             * You should usually call [Builder.provider] with a well-typed [Provider] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun provider(provider: JsonField<Provider>) = apply { this.provider = provider }

            /** Alias for calling [provider] with `Provider.ofAws(aws)`. */
            fun provider(aws: Provider.Aws) = provider(Provider.ofAws(aws))

            /** Alias for calling [provider] with `Provider.ofAzure(azure)`. */
            fun provider(azure: Provider.Azure) = provider(Provider.ofAzure(azure))

            /** Alias for calling [provider] with `Provider.ofGcp(gcp)`. */
            fun provider(gcp: Provider.Gcp) = provider(Provider.ofGcp(gcp))

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
             * .projectId()
             * .provider()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("projectId", projectId),
                    checkRequired("provider", provider),
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

            projectId()
            provider().validate()
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
            (if (projectId.asKnown().isPresent) 1 else 0) +
                (provider.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                projectId == other.projectId &&
                provider == other.provider &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(projectId, provider, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{projectId=$projectId, provider=$provider, additionalProperties=$additionalProperties}"
    }

    @JsonDeserialize(using = Provider.Deserializer::class)
    @JsonSerialize(using = Provider.Serializer::class)
    class Provider
    private constructor(
        private val aws: Aws? = null,
        private val azure: Azure? = null,
        private val gcp: Gcp? = null,
        private val _json: JsonValue? = null,
    ) {

        fun aws(): Optional<Aws> = Optional.ofNullable(aws)

        fun azure(): Optional<Azure> = Optional.ofNullable(azure)

        fun gcp(): Optional<Gcp> = Optional.ofNullable(gcp)

        fun isAws(): Boolean = aws != null

        fun isAzure(): Boolean = azure != null

        fun isGcp(): Boolean = gcp != null

        fun asAws(): Aws = aws.getOrThrow("aws")

        fun asAzure(): Azure = azure.getOrThrow("azure")

        fun asGcp(): Gcp = gcp.getOrThrow("gcp")

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
         * Optional<String> result = provider.accept(new Provider.Visitor<Optional<String>>() {
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
         *   and the current variant is unknown or its visit method is not overridden.
         */
        fun <T> accept(visitor: Visitor<T>): T =
            when {
                aws != null -> visitor.visitAws(aws)
                azure != null -> visitor.visitAzure(azure)
                gcp != null -> visitor.visitGcp(gcp)
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
        fun validate(): Provider = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitAws(aws: Aws) {
                        aws.validate()
                    }

                    override fun visitAzure(azure: Azure) {
                        azure.validate()
                    }

                    override fun visitGcp(gcp: Gcp) {
                        gcp.validate()
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

                    override fun visitAzure(azure: Azure) = azure.validity()

                    override fun visitGcp(gcp: Gcp) = gcp.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Provider && aws == other.aws && azure == other.azure && gcp == other.gcp
        }

        override fun hashCode(): Int = Objects.hash(aws, azure, gcp)

        override fun toString(): String =
            when {
                aws != null -> "Provider{aws=$aws}"
                azure != null -> "Provider{azure=$azure}"
                gcp != null -> "Provider{gcp=$gcp}"
                _json != null -> "Provider{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Provider")
            }

        companion object {

            @JvmStatic fun ofAws(aws: Aws) = Provider(aws = aws)

            @JvmStatic fun ofAzure(azure: Azure) = Provider(azure = azure)

            @JvmStatic fun ofGcp(gcp: Gcp) = Provider(gcp = gcp)
        }

        /**
         * An interface that defines how to map each variant of [Provider] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitAws(aws: Aws): T = unknown(JsonValue.from(aws))

            fun visitAzure(azure: Azure): T = unknown(JsonValue.from(azure))

            fun visitGcp(gcp: Gcp): T = unknown(JsonValue.from(gcp))

            /**
             * Maps an unknown variant of [Provider] to a value of type [T].
             *
             * An instance of [Provider] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * Recognized variants also reach this method when their visit method is not overridden.
             * This allows existing visitors to handle variants added by newer SDK versions.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Provider: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Provider>(Provider::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Provider {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "aws" -> {
                        return tryDeserialize(node, jacksonTypeRef<Aws>())?.let {
                            Provider(aws = it, _json = json)
                        } ?: Provider(_json = json)
                    }
                    "azure" -> {
                        return tryDeserialize(node, jacksonTypeRef<Azure>())?.let {
                            Provider(azure = it, _json = json)
                        } ?: Provider(_json = json)
                    }
                    "gcp" -> {
                        return tryDeserialize(node, jacksonTypeRef<Gcp>())?.let {
                            Provider(gcp = it, _json = json)
                        } ?: Provider(_json = json)
                    }
                }

                return Provider(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Provider>(Provider::class) {

            override fun serialize(
                value: Provider,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.aws != null -> generator.writeObject(value.aws)
                    value.azure != null -> generator.writeObject(value.azure)
                    value.gcp != null -> generator.writeObject(value.gcp)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Provider")
                }
            }
        }

        class Aws
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val bucket: JsonField<String>,
            private val roleArn: JsonField<String>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("bucket")
                @ExcludeMissing
                bucket: JsonField<String> = JsonMissing.of(),
                @JsonProperty("role_arn")
                @ExcludeMissing
                roleArn: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(bucket, roleArn, type, mutableMapOf())

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun bucket(): String = bucket.getRequired("bucket")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun roleArn(): String = roleArn.getRequired("role_arn")

            /**
             * Expected to always return the following:
             * ```java
             * JsonValue.from("aws")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Returns the raw JSON value of [bucket].
             *
             * Unlike [bucket], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("bucket") @ExcludeMissing fun _bucket(): JsonField<String> = bucket

            /**
             * Returns the raw JSON value of [roleArn].
             *
             * Unlike [roleArn], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("role_arn") @ExcludeMissing fun _roleArn(): JsonField<String> = roleArn

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
                 * Returns a mutable builder for constructing an instance of [Aws].
                 *
                 * The following fields are required:
                 * ```java
                 * .bucket()
                 * .roleArn()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Aws]. */
            class Builder internal constructor() {

                private var bucket: JsonField<String>? = null
                private var roleArn: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("aws")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(aws: Aws) = apply {
                    bucket = aws.bucket
                    roleArn = aws.roleArn
                    type = aws.type
                    additionalProperties = aws.additionalProperties.toMutableMap()
                }

                fun bucket(bucket: String) = bucket(JsonField.of(bucket))

                /**
                 * Sets [Builder.bucket] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.bucket] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun bucket(bucket: JsonField<String>) = apply { this.bucket = bucket }

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
                 * .bucket()
                 * .roleArn()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Aws =
                    Aws(
                        checkRequired("bucket", bucket),
                        checkRequired("roleArn", roleArn),
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
            fun validate(): Aws = apply {
                if (validated) {
                    return@apply
                }

                bucket()
                roleArn()
                _type().let {
                    if (it != JsonValue.from("aws")) {
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
                (if (bucket.asKnown().isPresent) 1 else 0) +
                    (if (roleArn.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("aws")) 1 else 0 }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Aws &&
                    bucket == other.bucket &&
                    roleArn == other.roleArn &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(bucket, roleArn, type, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Aws{bucket=$bucket, roleArn=$roleArn, type=$type, additionalProperties=$additionalProperties}"
        }

        class Azure
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val accountName: JsonField<String>,
            private val container: JsonField<String>,
            private val resourceGroup: JsonField<String>,
            private val subscriptionId: JsonField<String>,
            private val tenantId: JsonField<String>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("account_name")
                @ExcludeMissing
                accountName: JsonField<String> = JsonMissing.of(),
                @JsonProperty("container")
                @ExcludeMissing
                container: JsonField<String> = JsonMissing.of(),
                @JsonProperty("resource_group")
                @ExcludeMissing
                resourceGroup: JsonField<String> = JsonMissing.of(),
                @JsonProperty("subscription_id")
                @ExcludeMissing
                subscriptionId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("tenant_id")
                @ExcludeMissing
                tenantId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(
                accountName,
                container,
                resourceGroup,
                subscriptionId,
                tenantId,
                type,
                mutableMapOf(),
            )

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun accountName(): String = accountName.getRequired("account_name")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun container(): String = container.getRequired("container")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun resourceGroup(): String = resourceGroup.getRequired("resource_group")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun subscriptionId(): String = subscriptionId.getRequired("subscription_id")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun tenantId(): String = tenantId.getRequired("tenant_id")

            /**
             * Expected to always return the following:
             * ```java
             * JsonValue.from("azure")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Returns the raw JSON value of [accountName].
             *
             * Unlike [accountName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("account_name")
            @ExcludeMissing
            fun _accountName(): JsonField<String> = accountName

            /**
             * Returns the raw JSON value of [container].
             *
             * Unlike [container], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("container")
            @ExcludeMissing
            fun _container(): JsonField<String> = container

            /**
             * Returns the raw JSON value of [resourceGroup].
             *
             * Unlike [resourceGroup], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("resource_group")
            @ExcludeMissing
            fun _resourceGroup(): JsonField<String> = resourceGroup

            /**
             * Returns the raw JSON value of [subscriptionId].
             *
             * Unlike [subscriptionId], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("subscription_id")
            @ExcludeMissing
            fun _subscriptionId(): JsonField<String> = subscriptionId

            /**
             * Returns the raw JSON value of [tenantId].
             *
             * Unlike [tenantId], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("tenant_id") @ExcludeMissing fun _tenantId(): JsonField<String> = tenantId

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
                 * Returns a mutable builder for constructing an instance of [Azure].
                 *
                 * The following fields are required:
                 * ```java
                 * .accountName()
                 * .container()
                 * .resourceGroup()
                 * .subscriptionId()
                 * .tenantId()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Azure]. */
            class Builder internal constructor() {

                private var accountName: JsonField<String>? = null
                private var container: JsonField<String>? = null
                private var resourceGroup: JsonField<String>? = null
                private var subscriptionId: JsonField<String>? = null
                private var tenantId: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("azure")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(azure: Azure) = apply {
                    accountName = azure.accountName
                    container = azure.container
                    resourceGroup = azure.resourceGroup
                    subscriptionId = azure.subscriptionId
                    tenantId = azure.tenantId
                    type = azure.type
                    additionalProperties = azure.additionalProperties.toMutableMap()
                }

                fun accountName(accountName: String) = accountName(JsonField.of(accountName))

                /**
                 * Sets [Builder.accountName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.accountName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun accountName(accountName: JsonField<String>) = apply {
                    this.accountName = accountName
                }

                fun container(container: String) = container(JsonField.of(container))

                /**
                 * Sets [Builder.container] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.container] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun container(container: JsonField<String>) = apply { this.container = container }

                fun resourceGroup(resourceGroup: String) =
                    resourceGroup(JsonField.of(resourceGroup))

                /**
                 * Sets [Builder.resourceGroup] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.resourceGroup] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun resourceGroup(resourceGroup: JsonField<String>) = apply {
                    this.resourceGroup = resourceGroup
                }

                fun subscriptionId(subscriptionId: String) =
                    subscriptionId(JsonField.of(subscriptionId))

                /**
                 * Sets [Builder.subscriptionId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.subscriptionId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun subscriptionId(subscriptionId: JsonField<String>) = apply {
                    this.subscriptionId = subscriptionId
                }

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
                 * .accountName()
                 * .container()
                 * .resourceGroup()
                 * .subscriptionId()
                 * .tenantId()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Azure =
                    Azure(
                        checkRequired("accountName", accountName),
                        checkRequired("container", container),
                        checkRequired("resourceGroup", resourceGroup),
                        checkRequired("subscriptionId", subscriptionId),
                        checkRequired("tenantId", tenantId),
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
            fun validate(): Azure = apply {
                if (validated) {
                    return@apply
                }

                accountName()
                container()
                resourceGroup()
                subscriptionId()
                tenantId()
                _type().let {
                    if (it != JsonValue.from("azure")) {
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
                (if (accountName.asKnown().isPresent) 1 else 0) +
                    (if (container.asKnown().isPresent) 1 else 0) +
                    (if (resourceGroup.asKnown().isPresent) 1 else 0) +
                    (if (subscriptionId.asKnown().isPresent) 1 else 0) +
                    (if (tenantId.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("azure")) 1 else 0 }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Azure &&
                    accountName == other.accountName &&
                    container == other.container &&
                    resourceGroup == other.resourceGroup &&
                    subscriptionId == other.subscriptionId &&
                    tenantId == other.tenantId &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    accountName,
                    container,
                    resourceGroup,
                    subscriptionId,
                    tenantId,
                    type,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Azure{accountName=$accountName, container=$container, resourceGroup=$resourceGroup, subscriptionId=$subscriptionId, tenantId=$tenantId, type=$type, additionalProperties=$additionalProperties}"
        }

        class Gcp
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val bucket: JsonField<String>,
            private val type: JsonValue,
            private val workloadIdentityPoolId: JsonField<String>,
            private val workloadIdentityProjectNumber: JsonField<String>,
            private val workloadIdentityProviderId: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("bucket")
                @ExcludeMissing
                bucket: JsonField<String> = JsonMissing.of(),
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
            ) : this(
                bucket,
                type,
                workloadIdentityPoolId,
                workloadIdentityProjectNumber,
                workloadIdentityProviderId,
                mutableMapOf(),
            )

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun bucket(): String = bucket.getRequired("bucket")

            /**
             * Expected to always return the following:
             * ```java
             * JsonValue.from("gcp")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun workloadIdentityPoolId(): String =
                workloadIdentityPoolId.getRequired("workload_identity_pool_id")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun workloadIdentityProjectNumber(): String =
                workloadIdentityProjectNumber.getRequired("workload_identity_project_number")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun workloadIdentityProviderId(): String =
                workloadIdentityProviderId.getRequired("workload_identity_provider_id")

            /**
             * Returns the raw JSON value of [bucket].
             *
             * Unlike [bucket], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("bucket") @ExcludeMissing fun _bucket(): JsonField<String> = bucket

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
                 * Returns a mutable builder for constructing an instance of [Gcp].
                 *
                 * The following fields are required:
                 * ```java
                 * .bucket()
                 * .workloadIdentityPoolId()
                 * .workloadIdentityProjectNumber()
                 * .workloadIdentityProviderId()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Gcp]. */
            class Builder internal constructor() {

                private var bucket: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("gcp")
                private var workloadIdentityPoolId: JsonField<String>? = null
                private var workloadIdentityProjectNumber: JsonField<String>? = null
                private var workloadIdentityProviderId: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(gcp: Gcp) = apply {
                    bucket = gcp.bucket
                    type = gcp.type
                    workloadIdentityPoolId = gcp.workloadIdentityPoolId
                    workloadIdentityProjectNumber = gcp.workloadIdentityProjectNumber
                    workloadIdentityProviderId = gcp.workloadIdentityProviderId
                    additionalProperties = gcp.additionalProperties.toMutableMap()
                }

                fun bucket(bucket: String) = bucket(JsonField.of(bucket))

                /**
                 * Sets [Builder.bucket] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.bucket] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun bucket(bucket: JsonField<String>) = apply { this.bucket = bucket }

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
                 * .bucket()
                 * .workloadIdentityPoolId()
                 * .workloadIdentityProjectNumber()
                 * .workloadIdentityProviderId()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Gcp =
                    Gcp(
                        checkRequired("bucket", bucket),
                        type,
                        checkRequired("workloadIdentityPoolId", workloadIdentityPoolId),
                        checkRequired(
                            "workloadIdentityProjectNumber",
                            workloadIdentityProjectNumber,
                        ),
                        checkRequired("workloadIdentityProviderId", workloadIdentityProviderId),
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

                bucket()
                _type().let {
                    if (it != JsonValue.from("gcp")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                workloadIdentityPoolId()
                workloadIdentityProjectNumber()
                workloadIdentityProviderId()
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
                (if (bucket.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("gcp")) 1 else 0 } +
                    (if (workloadIdentityPoolId.asKnown().isPresent) 1 else 0) +
                    (if (workloadIdentityProjectNumber.asKnown().isPresent) 1 else 0) +
                    (if (workloadIdentityProviderId.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Gcp &&
                    bucket == other.bucket &&
                    type == other.type &&
                    workloadIdentityPoolId == other.workloadIdentityPoolId &&
                    workloadIdentityProjectNumber == other.workloadIdentityProjectNumber &&
                    workloadIdentityProviderId == other.workloadIdentityProviderId &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    bucket,
                    type,
                    workloadIdentityPoolId,
                    workloadIdentityProjectNumber,
                    workloadIdentityProviderId,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Gcp{bucket=$bucket, type=$type, workloadIdentityPoolId=$workloadIdentityPoolId, workloadIdentityProjectNumber=$workloadIdentityProjectNumber, workloadIdentityProviderId=$workloadIdentityProviderId, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ExternalStorageCreateParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "ExternalStorageCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
