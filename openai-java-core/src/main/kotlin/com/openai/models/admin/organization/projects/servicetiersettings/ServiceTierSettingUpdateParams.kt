// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.projects.servicetiersettings

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
import com.openai.core.allMaxBy
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

/**
 * Update the default or enabled service tiers atomically. Supply at least one field. Omitted fields
 * keep their current values.
 */
class ServiceTierSettingUpdateParams
private constructor(
    private val projectId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** The ID of the project */
    fun projectId(): Optional<String> = Optional.ofNullable(projectId)

    /**
     * Default tier for requests that omit service_tier or use auto.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun default_(): Optional<Default> = body.default_()

    /**
     * Additional service tiers enabled for this project. "all" includes future tiers. An empty
     * array allows only Standard. Organization policy and eligibility still apply.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun enabledTiers(): Optional<EnabledTiers> = body.enabledTiers()

    /**
     * Returns the raw JSON value of [default_].
     *
     * Unlike [default_], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _default_(): JsonField<Default> = body._default_()

    /**
     * Returns the raw JSON value of [enabledTiers].
     *
     * Unlike [enabledTiers], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _enabledTiers(): JsonField<EnabledTiers> = body._enabledTiers()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): ServiceTierSettingUpdateParams = builder().build()

        /**
         * Returns a mutable builder for constructing an instance of
         * [ServiceTierSettingUpdateParams].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ServiceTierSettingUpdateParams]. */
    class Builder internal constructor() {

        private var projectId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(serviceTierSettingUpdateParams: ServiceTierSettingUpdateParams) = apply {
            projectId = serviceTierSettingUpdateParams.projectId
            body = serviceTierSettingUpdateParams.body.toBuilder()
            additionalHeaders = serviceTierSettingUpdateParams.additionalHeaders.toBuilder()
            additionalQueryParams = serviceTierSettingUpdateParams.additionalQueryParams.toBuilder()
        }

        /** The ID of the project */
        fun projectId(projectId: String?) = apply { this.projectId = projectId }

        /** Alias for calling [Builder.projectId] with `projectId.orElse(null)`. */
        fun projectId(projectId: Optional<String>) = projectId(projectId.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [default_]
         * - [enabledTiers]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Default tier for requests that omit service_tier or use auto. */
        fun default_(default_: Default) = apply { body.default_(default_) }

        /**
         * Sets [Builder.default_] to an arbitrary JSON value.
         *
         * You should usually call [Builder.default_] with a well-typed [Default] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun default_(default_: JsonField<Default>) = apply { body.default_(default_) }

        /**
         * Additional service tiers enabled for this project. "all" includes future tiers. An empty
         * array allows only Standard. Organization policy and eligibility still apply.
         */
        fun enabledTiers(enabledTiers: EnabledTiers) = apply { body.enabledTiers(enabledTiers) }

        /**
         * Sets [Builder.enabledTiers] to an arbitrary JSON value.
         *
         * You should usually call [Builder.enabledTiers] with a well-typed [EnabledTiers] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun enabledTiers(enabledTiers: JsonField<EnabledTiers>) = apply {
            body.enabledTiers(enabledTiers)
        }

        /** Alias for calling [enabledTiers] with `EnabledTiers.ofAll()`. */
        fun enabledTiersAll() = apply { body.enabledTiersAll() }

        /**
         * Alias for calling [enabledTiers] with
         * `EnabledTiers.ofProjectOptionalService(projectOptionalService)`.
         */
        fun enabledTiersOfProjectOptionalService(
            projectOptionalService: List<ProjectOptionalServiceTier>
        ) = apply { body.enabledTiersOfProjectOptionalService(projectOptionalService) }

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
         * Returns an immutable instance of [ServiceTierSettingUpdateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ServiceTierSettingUpdateParams =
            ServiceTierSettingUpdateParams(
                projectId,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> projectId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val default_: JsonField<Default>,
        private val enabledTiers: JsonField<EnabledTiers>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("default")
            @ExcludeMissing
            default_: JsonField<Default> = JsonMissing.of(),
            @JsonProperty("enabled_tiers")
            @ExcludeMissing
            enabledTiers: JsonField<EnabledTiers> = JsonMissing.of(),
        ) : this(default_, enabledTiers, mutableMapOf())

        /**
         * Default tier for requests that omit service_tier or use auto.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun default_(): Optional<Default> = default_.getOptional("default")

        /**
         * Additional service tiers enabled for this project. "all" includes future tiers. An empty
         * array allows only Standard. Organization policy and eligibility still apply.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun enabledTiers(): Optional<EnabledTiers> = enabledTiers.getOptional("enabled_tiers")

        /**
         * Returns the raw JSON value of [default_].
         *
         * Unlike [default_], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("default") @ExcludeMissing fun _default_(): JsonField<Default> = default_

        /**
         * Returns the raw JSON value of [enabledTiers].
         *
         * Unlike [enabledTiers], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("enabled_tiers")
        @ExcludeMissing
        fun _enabledTiers(): JsonField<EnabledTiers> = enabledTiers

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
                "default" to this.default_,
                "enabled_tiers" to this.enabledTiers,
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

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var default_: JsonField<Default> = JsonMissing.of()
            private var enabledTiers: JsonField<EnabledTiers> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                default_ = body.default_
                enabledTiers = body.enabledTiers
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Default tier for requests that omit service_tier or use auto. */
            fun default_(default_: Default) = default_(JsonField.of(default_))

            /**
             * Sets [Builder.default_] to an arbitrary JSON value.
             *
             * You should usually call [Builder.default_] with a well-typed [Default] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun default_(default_: JsonField<Default>) = apply { this.default_ = default_ }

            /**
             * Additional service tiers enabled for this project. "all" includes future tiers. An
             * empty array allows only Standard. Organization policy and eligibility still apply.
             */
            fun enabledTiers(enabledTiers: EnabledTiers) = enabledTiers(JsonField.of(enabledTiers))

            /**
             * Sets [Builder.enabledTiers] to an arbitrary JSON value.
             *
             * You should usually call [Builder.enabledTiers] with a well-typed [EnabledTiers] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun enabledTiers(enabledTiers: JsonField<EnabledTiers>) = apply {
                this.enabledTiers = enabledTiers
            }

            /** Alias for calling [enabledTiers] with `EnabledTiers.ofAll()`. */
            fun enabledTiersAll() = enabledTiers(EnabledTiers.ofAll())

            /**
             * Alias for calling [enabledTiers] with
             * `EnabledTiers.ofProjectOptionalService(projectOptionalService)`.
             */
            fun enabledTiersOfProjectOptionalService(
                projectOptionalService: List<ProjectOptionalServiceTier>
            ) = enabledTiers(EnabledTiers.ofProjectOptionalService(projectOptionalService))

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
            fun build(): Body = Body(default_, enabledTiers, additionalProperties.toMutableMap())
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

            default_().ifPresent { it.validate() }
            enabledTiers().ifPresent { it.validate() }
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
            (default_.asKnown().getOrNull()?.validity() ?: 0) +
                (enabledTiers.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                default_ == other.default_ &&
                enabledTiers == other.enabledTiers &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(default_, enabledTiers, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{default_=$default_, enabledTiers=$enabledTiers, additionalProperties=$additionalProperties}"
    }

    /** Default tier for requests that omit service_tier or use auto. */
    class Default @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val STANDARD = of("standard")

            @JvmField val FAST = of("fast")

            @JvmField val SCALE = of("scale")

            @JvmStatic fun of(value: String) = Default(JsonField.of(value))
        }

        /** An enum containing [Default]'s known values. */
        enum class Known {
            STANDARD,
            FAST,
            SCALE,
        }

        /**
         * An enum containing [Default]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Default] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            STANDARD,
            FAST,
            SCALE,
            /** An enum member indicating that [Default] was instantiated with an unknown value. */
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
                STANDARD -> Value.STANDARD
                FAST -> Value.FAST
                SCALE -> Value.SCALE
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
                STANDARD -> Known.STANDARD
                FAST -> Known.FAST
                SCALE -> Known.SCALE
                else -> throw OpenAIInvalidDataException("Unknown Default: $value")
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
        fun validate(): Default = apply {
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

            return other is Default && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Additional service tiers enabled for this project. "all" includes future tiers. An empty
     * array allows only Standard. Organization policy and eligibility still apply.
     */
    @JsonDeserialize(using = EnabledTiers.Deserializer::class)
    @JsonSerialize(using = EnabledTiers.Serializer::class)
    class EnabledTiers
    private constructor(
        private val all: JsonValue? = null,
        private val projectOptionalService: List<ProjectOptionalServiceTier>? = null,
        private val _json: JsonValue? = null,
    ) {

        fun all(): Optional<JsonValue> = Optional.ofNullable(all)

        fun projectOptionalService(): Optional<List<ProjectOptionalServiceTier>> =
            Optional.ofNullable(projectOptionalService)

        fun isAll(): Boolean = all != null

        fun isProjectOptionalService(): Boolean = projectOptionalService != null

        fun asAll(): JsonValue = all.getOrThrow("all")

        fun asProjectOptionalService(): List<ProjectOptionalServiceTier> =
            projectOptionalService.getOrThrow("projectOptionalService")

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
         * Optional<String> result = enabledTiers.accept(new EnabledTiers.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitAll(JsonValue all) {
         *         return Optional.of(all.toString());
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
                all != null -> visitor.visitAll(all)
                projectOptionalService != null ->
                    visitor.visitProjectOptionalService(projectOptionalService)
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
        fun validate(): EnabledTiers = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitAll(all: JsonValue) {
                        all.let {
                            if (it != JsonValue.from("all")) {
                                throw OpenAIInvalidDataException("'all' is invalid, received $it")
                            }
                        }
                    }

                    override fun visitProjectOptionalService(
                        projectOptionalService: List<ProjectOptionalServiceTier>
                    ) {
                        projectOptionalService.forEach { it.validate() }
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
                    override fun visitAll(all: JsonValue) =
                        all.let { if (it == JsonValue.from("all")) 1 else 0 }

                    override fun visitProjectOptionalService(
                        projectOptionalService: List<ProjectOptionalServiceTier>
                    ) = projectOptionalService.sumOf { it.validity().toInt() }

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is EnabledTiers &&
                all == other.all &&
                projectOptionalService == other.projectOptionalService &&
                (all != null || projectOptionalService != null || _json == other._json)
        }

        override fun hashCode(): Int =
            if (all == null && projectOptionalService == null) Objects.hash(_json)
            else Objects.hash(all, projectOptionalService)

        override fun toString(): String =
            when {
                all != null -> "EnabledTiers{all=$all}"
                projectOptionalService != null ->
                    "EnabledTiers{projectOptionalService=$projectOptionalService}"
                _json != null -> "EnabledTiers{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid EnabledTiers")
            }

        companion object {

            @JvmStatic fun ofAll() = EnabledTiers(all = JsonValue.from("all"))

            @JvmStatic
            fun ofProjectOptionalService(projectOptionalService: List<ProjectOptionalServiceTier>) =
                EnabledTiers(projectOptionalService = projectOptionalService.toImmutable())
        }

        /**
         * An interface that defines how to map each variant of [EnabledTiers] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            fun visitAll(all: JsonValue): T = unknown(JsonValue.from(all))

            fun visitProjectOptionalService(
                projectOptionalService: List<ProjectOptionalServiceTier>
            ): T = unknown(JsonValue.from(projectOptionalService))

            /**
             * Maps an unknown variant of [EnabledTiers] to a value of type [T].
             *
             * An instance of [EnabledTiers] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * Unhandled known JSON variants reach this method as JSON values.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown EnabledTiers")
            }
        }

        internal class Deserializer : BaseDeserializer<EnabledTiers>(EnabledTiers::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): EnabledTiers {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                ?.let { EnabledTiers(all = it, _json = json) }
                                ?.takeIf { it.isValid() },
                            tryDeserialize(node, jacksonTypeRef<List<ProjectOptionalServiceTier>>())
                                ?.let { EnabledTiers(projectOptionalService = it, _json = json) },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> EnabledTiers(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<EnabledTiers>(EnabledTiers::class) {

            override fun serialize(
                value: EnabledTiers,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.all != null -> generator.writeObject(value.all)
                    value.projectOptionalService != null ->
                        generator.writeObject(value.projectOptionalService)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid EnabledTiers")
                }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ServiceTierSettingUpdateParams &&
            projectId == other.projectId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(projectId, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "ServiceTierSettingUpdateParams{projectId=$projectId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
