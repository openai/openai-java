// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.projects

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.Params
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Create a new project in the organization. Projects can be created and archived, but cannot be
 * deleted.
 */
class ProjectCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The friendly name of the project, this name appears in reports.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = body.name()

    /**
     * External key ID to associate with the project.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun externalKeyId(): Optional<String> = body.externalKeyId()

    /**
     * Create the project with the specified data residency region. Your organization must have
     * access to Data residency functionality in order to use. See
     * [data residency controls](https://platform.openai.com/docs/guides/your-data#data-residency-controls)
     * to review the functionality and limitations of setting this field. Deprecated: use
     * `residency` instead. Do not provide both `geography` and `residency`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    @Deprecated("deprecated") fun geography(): Optional<String> = body.geography()

    /**
     * Create the project with the specified residency configuration. Your organization must have
     * access to the requested residency configuration in order to use it. See
     * [data residency controls](https://platform.openai.com/docs/guides/your-data#data-residency-controls)
     * to review the functionality and limitations of setting this field.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun residency(): Optional<Residency> = body.residency()

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _name(): JsonField<String> = body._name()

    /**
     * Returns the raw JSON value of [externalKeyId].
     *
     * Unlike [externalKeyId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _externalKeyId(): JsonField<String> = body._externalKeyId()

    /**
     * Returns the raw JSON value of [geography].
     *
     * Unlike [geography], this method doesn't throw if the JSON field has an unexpected type.
     */
    @Deprecated("deprecated") fun _geography(): JsonField<String> = body._geography()

    /**
     * Returns the raw JSON value of [residency].
     *
     * Unlike [residency], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _residency(): JsonField<Residency> = body._residency()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ProjectCreateParams].
         *
         * The following fields are required:
         * ```java
         * .name()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ProjectCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(projectCreateParams: ProjectCreateParams) = apply {
            body = projectCreateParams.body.toBuilder()
            additionalHeaders = projectCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = projectCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [name]
         * - [externalKeyId]
         * - [geography]
         * - [residency]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** The friendly name of the project, this name appears in reports. */
        fun name(name: String) = apply { body.name(name) }

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { body.name(name) }

        /** External key ID to associate with the project. */
        fun externalKeyId(externalKeyId: String?) = apply { body.externalKeyId(externalKeyId) }

        /** Alias for calling [Builder.externalKeyId] with `externalKeyId.orElse(null)`. */
        fun externalKeyId(externalKeyId: Optional<String>) =
            externalKeyId(externalKeyId.getOrNull())

        /**
         * Sets [Builder.externalKeyId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.externalKeyId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun externalKeyId(externalKeyId: JsonField<String>) = apply {
            body.externalKeyId(externalKeyId)
        }

        /**
         * Create the project with the specified data residency region. Your organization must have
         * access to Data residency functionality in order to use. See
         * [data residency controls](https://platform.openai.com/docs/guides/your-data#data-residency-controls)
         * to review the functionality and limitations of setting this field. Deprecated: use
         * `residency` instead. Do not provide both `geography` and `residency`.
         */
        @Deprecated("deprecated")
        fun geography(geography: String?) = apply { body.geography(geography) }

        /** Alias for calling [Builder.geography] with `geography.orElse(null)`. */
        @Deprecated("deprecated")
        fun geography(geography: Optional<String>) = geography(geography.getOrNull())

        /**
         * Sets [Builder.geography] to an arbitrary JSON value.
         *
         * You should usually call [Builder.geography] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        @Deprecated("deprecated")
        fun geography(geography: JsonField<String>) = apply { body.geography(geography) }

        /**
         * Create the project with the specified residency configuration. Your organization must
         * have access to the requested residency configuration in order to use it. See
         * [data residency controls](https://platform.openai.com/docs/guides/your-data#data-residency-controls)
         * to review the functionality and limitations of setting this field.
         */
        fun residency(residency: Residency?) = apply { body.residency(residency) }

        /** Alias for calling [Builder.residency] with `residency.orElse(null)`. */
        fun residency(residency: Optional<Residency>) = residency(residency.getOrNull())

        /**
         * Sets [Builder.residency] to an arbitrary JSON value.
         *
         * You should usually call [Builder.residency] with a well-typed [Residency] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun residency(residency: JsonField<Residency>) = apply { body.residency(residency) }

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
         * Returns an immutable instance of [ProjectCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .name()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ProjectCreateParams =
            ProjectCreateParams(
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
        private val name: JsonField<String>,
        private val externalKeyId: JsonField<String>,
        private val geography: JsonField<String>,
        private val residency: JsonField<Residency>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("external_key_id")
            @ExcludeMissing
            externalKeyId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("geography")
            @ExcludeMissing
            geography: JsonField<String> = JsonMissing.of(),
            @JsonProperty("residency")
            @ExcludeMissing
            residency: JsonField<Residency> = JsonMissing.of(),
        ) : this(name, externalKeyId, geography, residency, mutableMapOf())

        /**
         * The friendly name of the project, this name appears in reports.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * External key ID to associate with the project.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun externalKeyId(): Optional<String> = externalKeyId.getOptional("external_key_id")

        /**
         * Create the project with the specified data residency region. Your organization must have
         * access to Data residency functionality in order to use. See
         * [data residency controls](https://platform.openai.com/docs/guides/your-data#data-residency-controls)
         * to review the functionality and limitations of setting this field. Deprecated: use
         * `residency` instead. Do not provide both `geography` and `residency`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        @Deprecated("deprecated")
        fun geography(): Optional<String> = geography.getOptional("geography")

        /**
         * Create the project with the specified residency configuration. Your organization must
         * have access to the requested residency configuration in order to use it. See
         * [data residency controls](https://platform.openai.com/docs/guides/your-data#data-residency-controls)
         * to review the functionality and limitations of setting this field.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun residency(): Optional<Residency> = residency.getOptional("residency")

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [externalKeyId].
         *
         * Unlike [externalKeyId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("external_key_id")
        @ExcludeMissing
        fun _externalKeyId(): JsonField<String> = externalKeyId

        /**
         * Returns the raw JSON value of [geography].
         *
         * Unlike [geography], this method doesn't throw if the JSON field has an unexpected type.
         */
        @Deprecated("deprecated")
        @JsonProperty("geography")
        @ExcludeMissing
        fun _geography(): JsonField<String> = geography

        /**
         * Returns the raw JSON value of [residency].
         *
         * Unlike [residency], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("residency")
        @ExcludeMissing
        fun _residency(): JsonField<Residency> = residency

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
             * .name()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var name: JsonField<String>? = null
            private var externalKeyId: JsonField<String> = JsonMissing.of()
            private var geography: JsonField<String> = JsonMissing.of()
            private var residency: JsonField<Residency> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                name = body.name
                externalKeyId = body.externalKeyId
                geography = body.geography
                residency = body.residency
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** The friendly name of the project, this name appears in reports. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** External key ID to associate with the project. */
            fun externalKeyId(externalKeyId: String?) =
                externalKeyId(JsonField.ofNullable(externalKeyId))

            /** Alias for calling [Builder.externalKeyId] with `externalKeyId.orElse(null)`. */
            fun externalKeyId(externalKeyId: Optional<String>) =
                externalKeyId(externalKeyId.getOrNull())

            /**
             * Sets [Builder.externalKeyId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.externalKeyId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun externalKeyId(externalKeyId: JsonField<String>) = apply {
                this.externalKeyId = externalKeyId
            }

            /**
             * Create the project with the specified data residency region. Your organization must
             * have access to Data residency functionality in order to use. See
             * [data residency controls](https://platform.openai.com/docs/guides/your-data#data-residency-controls)
             * to review the functionality and limitations of setting this field. Deprecated: use
             * `residency` instead. Do not provide both `geography` and `residency`.
             */
            @Deprecated("deprecated")
            fun geography(geography: String?) = geography(JsonField.ofNullable(geography))

            /** Alias for calling [Builder.geography] with `geography.orElse(null)`. */
            @Deprecated("deprecated")
            fun geography(geography: Optional<String>) = geography(geography.getOrNull())

            /**
             * Sets [Builder.geography] to an arbitrary JSON value.
             *
             * You should usually call [Builder.geography] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            @Deprecated("deprecated")
            fun geography(geography: JsonField<String>) = apply { this.geography = geography }

            /**
             * Create the project with the specified residency configuration. Your organization must
             * have access to the requested residency configuration in order to use it. See
             * [data residency controls](https://platform.openai.com/docs/guides/your-data#data-residency-controls)
             * to review the functionality and limitations of setting this field.
             */
            fun residency(residency: Residency?) = residency(JsonField.ofNullable(residency))

            /** Alias for calling [Builder.residency] with `residency.orElse(null)`. */
            fun residency(residency: Optional<Residency>) = residency(residency.getOrNull())

            /**
             * Sets [Builder.residency] to an arbitrary JSON value.
             *
             * You should usually call [Builder.residency] with a well-typed [Residency] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun residency(residency: JsonField<Residency>) = apply { this.residency = residency }

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
             * .name()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("name", name),
                    externalKeyId,
                    geography,
                    residency,
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

            name()
            externalKeyId()
            geography()
            residency().ifPresent { it.validate() }
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
            (if (name.asKnown().isPresent) 1 else 0) +
                (if (externalKeyId.asKnown().isPresent) 1 else 0) +
                (if (geography.asKnown().isPresent) 1 else 0) +
                (residency.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                name == other.name &&
                externalKeyId == other.externalKeyId &&
                geography == other.geography &&
                residency == other.residency &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(name, externalKeyId, geography, residency, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{name=$name, externalKeyId=$externalKeyId, geography=$geography, residency=$residency, additionalProperties=$additionalProperties}"
    }

    /**
     * Create the project with the specified residency configuration. Your organization must have
     * access to the requested residency configuration in order to use it. See
     * [data residency controls](https://platform.openai.com/docs/guides/your-data#data-residency-controls)
     * to review the functionality and limitations of setting this field.
     */
    class Residency @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val GLOBAL = of("GLOBAL")

            @JvmField val US_STORAGE_PROCESSING = of("US_STORAGE_PROCESSING")

            @JvmField val EU_STORAGE_PROCESSING = of("EU_STORAGE_PROCESSING")

            @JvmField val JP_STORAGE = of("JP_STORAGE")

            @JvmField val KR_STORAGE = of("KR_STORAGE")

            @JvmField val CA_STORAGE = of("CA_STORAGE")

            @JvmField val SG_STORAGE = of("SG_STORAGE")

            @JvmField val IN_STORAGE = of("IN_STORAGE")

            @JvmField val AU_STORAGE = of("AU_STORAGE")

            @JvmField val GB_STORAGE = of("GB_STORAGE")

            @JvmField val AE_STORAGE = of("AE_STORAGE")

            @JvmField val AE_STORAGE_PROCESSING = of("AE_STORAGE_PROCESSING")

            @JvmStatic fun of(value: String) = Residency(JsonField.of(value))
        }

        /** An enum containing [Residency]'s known values. */
        enum class Known {
            GLOBAL,
            US_STORAGE_PROCESSING,
            EU_STORAGE_PROCESSING,
            JP_STORAGE,
            KR_STORAGE,
            CA_STORAGE,
            SG_STORAGE,
            IN_STORAGE,
            AU_STORAGE,
            GB_STORAGE,
            AE_STORAGE,
            AE_STORAGE_PROCESSING,
        }

        /**
         * An enum containing [Residency]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Residency] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            GLOBAL,
            US_STORAGE_PROCESSING,
            EU_STORAGE_PROCESSING,
            JP_STORAGE,
            KR_STORAGE,
            CA_STORAGE,
            SG_STORAGE,
            IN_STORAGE,
            AU_STORAGE,
            GB_STORAGE,
            AE_STORAGE,
            AE_STORAGE_PROCESSING,
            /**
             * An enum member indicating that [Residency] was instantiated with an unknown value.
             */
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
                GLOBAL -> Value.GLOBAL
                US_STORAGE_PROCESSING -> Value.US_STORAGE_PROCESSING
                EU_STORAGE_PROCESSING -> Value.EU_STORAGE_PROCESSING
                JP_STORAGE -> Value.JP_STORAGE
                KR_STORAGE -> Value.KR_STORAGE
                CA_STORAGE -> Value.CA_STORAGE
                SG_STORAGE -> Value.SG_STORAGE
                IN_STORAGE -> Value.IN_STORAGE
                AU_STORAGE -> Value.AU_STORAGE
                GB_STORAGE -> Value.GB_STORAGE
                AE_STORAGE -> Value.AE_STORAGE
                AE_STORAGE_PROCESSING -> Value.AE_STORAGE_PROCESSING
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
                GLOBAL -> Known.GLOBAL
                US_STORAGE_PROCESSING -> Known.US_STORAGE_PROCESSING
                EU_STORAGE_PROCESSING -> Known.EU_STORAGE_PROCESSING
                JP_STORAGE -> Known.JP_STORAGE
                KR_STORAGE -> Known.KR_STORAGE
                CA_STORAGE -> Known.CA_STORAGE
                SG_STORAGE -> Known.SG_STORAGE
                IN_STORAGE -> Known.IN_STORAGE
                AU_STORAGE -> Known.AU_STORAGE
                GB_STORAGE -> Known.GB_STORAGE
                AE_STORAGE -> Known.AE_STORAGE
                AE_STORAGE_PROCESSING -> Known.AE_STORAGE_PROCESSING
                else -> throw OpenAIInvalidDataException("Unknown Residency: $value")
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
        fun validate(): Residency = apply {
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

            return other is Residency && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ProjectCreateParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "ProjectCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
