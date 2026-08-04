// File generated from our OpenAPI spec by Stainless.

package com.openai.models.contentprovenancechecks

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
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class ContentProvenanceCheck
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val createdAt: JsonField<Long>,
    private val object_: JsonField<Object>,
    private val results: JsonField<List<Result>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonField<Object> = JsonMissing.of(),
        @JsonProperty("results") @ExcludeMissing results: JsonField<List<Result>> = JsonMissing.of(),
    ) : this(createdAt, object_, results, mutableMapOf())

    /**
     * The Unix timestamp, in seconds, when the provenance check was created.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /**
     * The object type. Always `content_provenance_check` for this endpoint.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun object_(): Object = object_.getRequired("object")

    /**
     * The provenance results that apply to the uploaded file. Image results include C2PA and
     * SynthID; audio results include SynthID.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun results(): List<Result> = results.getRequired("results")

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt(): JsonField<Long> = createdAt

    /**
     * Returns the raw JSON value of [object_].
     *
     * Unlike [object_], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<Object> = object_

    /**
     * Returns the raw JSON value of [results].
     *
     * Unlike [results], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("results") @ExcludeMissing fun _results(): JsonField<List<Result>> = results

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
         * Returns a mutable builder for constructing an instance of [ContentProvenanceCheck].
         *
         * The following fields are required:
         * ```java
         * .createdAt()
         * .object_()
         * .results()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ContentProvenanceCheck]. */
    class Builder internal constructor() {

        private var createdAt: JsonField<Long>? = null
        private var object_: JsonField<Object>? = null
        private var results: JsonField<MutableList<Result>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(contentProvenanceCheck: ContentProvenanceCheck) = apply {
            createdAt = contentProvenanceCheck.createdAt
            object_ = contentProvenanceCheck.object_
            results = contentProvenanceCheck.results.map { it.toMutableList() }
            additionalProperties = contentProvenanceCheck.additionalProperties.toMutableMap()
        }

        /** The Unix timestamp, in seconds, when the provenance check was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /** The object type. Always `content_provenance_check` for this endpoint. */
        fun object_(object_: Object) = object_(JsonField.of(object_))

        /**
         * Sets [Builder.object_] to an arbitrary JSON value.
         *
         * You should usually call [Builder.object_] with a well-typed [Object] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

        /**
         * The provenance results that apply to the uploaded file. Image results include C2PA and
         * SynthID; audio results include SynthID.
         */
        fun results(results: List<Result>) = results(JsonField.of(results))

        /**
         * Sets [Builder.results] to an arbitrary JSON value.
         *
         * You should usually call [Builder.results] with a well-typed `List<Result>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun results(results: JsonField<List<Result>>) = apply {
            this.results = results.map { it.toMutableList() }
        }

        /**
         * Adds a single [Result] to [results].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addResult(result: Result) = apply {
            results =
                (results ?: JsonField.of(mutableListOf())).also {
                    checkKnown("results", it).add(result)
                }
        }

        /** Alias for calling [addResult] with `Result.ofC2pa(c2pa)`. */
        fun addResult(c2pa: Result.C2pa) = addResult(Result.ofC2pa(c2pa))

        /** Alias for calling [addResult] with `Result.ofSynthID(synthID)`. */
        fun addResult(synthID: Result.SynthID) = addResult(Result.ofSynthID(synthID))

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
         * Returns an immutable instance of [ContentProvenanceCheck].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .createdAt()
         * .object_()
         * .results()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ContentProvenanceCheck =
            ContentProvenanceCheck(
                checkRequired("createdAt", createdAt),
                checkRequired("object_", object_),
                checkRequired("results", results).map { it.toImmutable() },
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
    fun validate(): ContentProvenanceCheck = apply {
        if (validated) {
            return@apply
        }

        createdAt()
        object_().validate()
        results().forEach { it.validate() }
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
        (if (createdAt.asKnown().isPresent) 1 else 0) +
            (object_.asKnown().getOrNull()?.validity() ?: 0) +
            (results.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    /** The object type. Always `content_provenance_check` for this endpoint. */
    class Object @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val CONTENT_PROVENANCE_CHECK = of("content_provenance_check")

            @JvmStatic fun of(value: String) = Object(JsonField.of(value))
        }

        /** An enum containing [Object]'s known values. */
        enum class Known {
            CONTENT_PROVENANCE_CHECK
        }

        /**
         * An enum containing [Object]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Object] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            CONTENT_PROVENANCE_CHECK,
            /** An enum member indicating that [Object] was instantiated with an unknown value. */
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
                CONTENT_PROVENANCE_CHECK -> Value.CONTENT_PROVENANCE_CHECK
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
                CONTENT_PROVENANCE_CHECK -> Known.CONTENT_PROVENANCE_CHECK
                else -> throw OpenAIInvalidDataException("Unknown Object: $value")
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
        fun validate(): Object = apply {
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

            return other is Object && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    @JsonDeserialize(using = Result.Deserializer::class)
    @JsonSerialize(using = Result.Serializer::class)
    class Result
    private constructor(
        private val c2pa: C2pa? = null,
        private val synthID: SynthID? = null,
        private val _json: JsonValue? = null,
    ) {

        fun c2pa(): Optional<C2pa> = Optional.ofNullable(c2pa)

        fun synthID(): Optional<SynthID> = Optional.ofNullable(synthID)

        fun isC2pa(): Boolean = c2pa != null

        fun isSynthID(): Boolean = synthID != null

        fun asC2pa(): C2pa = c2pa.getOrThrow("c2pa")

        fun asSynthID(): SynthID = synthID.getOrThrow("synthID")

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
         * Optional<String> result = result.accept(new Result.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitC2pa(C2pa c2pa) {
         *         return Optional.of(c2pa.toString());
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
                c2pa != null -> visitor.visitC2pa(c2pa)
                synthID != null -> visitor.visitSynthID(synthID)
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
        fun validate(): Result = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitC2pa(c2pa: C2pa) {
                        c2pa.validate()
                    }

                    override fun visitSynthID(synthID: SynthID) {
                        synthID.validate()
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
                    override fun visitC2pa(c2pa: C2pa) = c2pa.validity()

                    override fun visitSynthID(synthID: SynthID) = synthID.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Result && c2pa == other.c2pa && synthID == other.synthID
        }

        override fun hashCode(): Int = Objects.hash(c2pa, synthID)

        override fun toString(): String =
            when {
                c2pa != null -> "Result{c2pa=$c2pa}"
                synthID != null -> "Result{synthID=$synthID}"
                _json != null -> "Result{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Result")
            }

        companion object {

            @JvmStatic fun ofC2pa(c2pa: C2pa) = Result(c2pa = c2pa)

            @JvmStatic fun ofSynthID(synthID: SynthID) = Result(synthID = synthID)
        }

        /** An interface that defines how to map each variant of [Result] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitC2pa(c2pa: C2pa): T

            fun visitSynthID(synthID: SynthID): T

            /**
             * Maps an unknown variant of [Result] to a value of type [T].
             *
             * An instance of [Result] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Result: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Result>(Result::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Result {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "c2pa" -> {
                        return tryDeserialize(node, jacksonTypeRef<C2pa>())?.let {
                            Result(c2pa = it, _json = json)
                        } ?: Result(_json = json)
                    }
                    "synthid" -> {
                        return tryDeserialize(node, jacksonTypeRef<SynthID>())?.let {
                            Result(synthID = it, _json = json)
                        } ?: Result(_json = json)
                    }
                }

                return Result(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Result>(Result::class) {

            override fun serialize(
                value: Result,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.c2pa != null -> generator.writeObject(value.c2pa)
                    value.synthID != null -> generator.writeObject(value.synthID)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Result")
                }
            }
        }

        class C2pa
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val generatedAt: JsonField<String>,
            private val issuer: JsonField<String>,
            private val model: JsonField<String>,
            private val outcome: JsonField<Outcome>,
            private val type: JsonValue,
            private val validationState: JsonField<ValidationState>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("generated_at")
                @ExcludeMissing
                generatedAt: JsonField<String> = JsonMissing.of(),
                @JsonProperty("issuer")
                @ExcludeMissing
                issuer: JsonField<String> = JsonMissing.of(),
                @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
                @JsonProperty("outcome")
                @ExcludeMissing
                outcome: JsonField<Outcome> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("validation_state")
                @ExcludeMissing
                validationState: JsonField<ValidationState> = JsonMissing.of(),
            ) : this(generatedAt, issuer, model, outcome, type, validationState, mutableMapOf())

            /**
             * The UTC RFC 3339 timestamp recorded by the provenance signal for when the asset was
             * generated, when available.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun generatedAt(): Optional<String> = generatedAt.getOptional("generated_at")

            /**
             * The C2PA manifest issuer, when available.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun issuer(): Optional<String> = issuer.getOptional("issuer")

            /**
             * The OpenAI model recorded by the provenance signal, when available.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun model(): Optional<String> = model.getOptional("model")

            /**
             * Whether a supported OpenAI C2PA provenance signal was detected. If `not_detected`, it
             * means the tool did not find supported signals in the uploaded file. The content could
             * still have been generated by OpenAI if the metadata was stripped or has evidence of
             * tampering, the watermark was degraded, it comes from a legacy generation model, or it
             * was created before provenance signals were available. Content could also still be
             * AI-generated by another company's model, which the tool currently does not detect.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun outcome(): Outcome = outcome.getRequired("outcome")

            /**
             * The provenance signal type. Always `c2pa`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("c2pa")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * The validation status of the C2PA manifest in the uploaded image.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun validationState(): ValidationState = validationState.getRequired("validation_state")

            /**
             * Returns the raw JSON value of [generatedAt].
             *
             * Unlike [generatedAt], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("generated_at")
            @ExcludeMissing
            fun _generatedAt(): JsonField<String> = generatedAt

            /**
             * Returns the raw JSON value of [issuer].
             *
             * Unlike [issuer], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("issuer") @ExcludeMissing fun _issuer(): JsonField<String> = issuer

            /**
             * Returns the raw JSON value of [model].
             *
             * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

            /**
             * Returns the raw JSON value of [outcome].
             *
             * Unlike [outcome], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("outcome") @ExcludeMissing fun _outcome(): JsonField<Outcome> = outcome

            /**
             * Returns the raw JSON value of [validationState].
             *
             * Unlike [validationState], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("validation_state")
            @ExcludeMissing
            fun _validationState(): JsonField<ValidationState> = validationState

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
                 * Returns a mutable builder for constructing an instance of [C2pa].
                 *
                 * The following fields are required:
                 * ```java
                 * .generatedAt()
                 * .issuer()
                 * .model()
                 * .outcome()
                 * .validationState()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [C2pa]. */
            class Builder internal constructor() {

                private var generatedAt: JsonField<String>? = null
                private var issuer: JsonField<String>? = null
                private var model: JsonField<String>? = null
                private var outcome: JsonField<Outcome>? = null
                private var type: JsonValue = JsonValue.from("c2pa")
                private var validationState: JsonField<ValidationState>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(c2pa: C2pa) = apply {
                    generatedAt = c2pa.generatedAt
                    issuer = c2pa.issuer
                    model = c2pa.model
                    outcome = c2pa.outcome
                    type = c2pa.type
                    validationState = c2pa.validationState
                    additionalProperties = c2pa.additionalProperties.toMutableMap()
                }

                /**
                 * The UTC RFC 3339 timestamp recorded by the provenance signal for when the asset
                 * was generated, when available.
                 */
                fun generatedAt(generatedAt: String?) =
                    generatedAt(JsonField.ofNullable(generatedAt))

                /** Alias for calling [Builder.generatedAt] with `generatedAt.orElse(null)`. */
                fun generatedAt(generatedAt: Optional<String>) =
                    generatedAt(generatedAt.getOrNull())

                /**
                 * Sets [Builder.generatedAt] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.generatedAt] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun generatedAt(generatedAt: JsonField<String>) = apply {
                    this.generatedAt = generatedAt
                }

                /** The C2PA manifest issuer, when available. */
                fun issuer(issuer: String?) = issuer(JsonField.ofNullable(issuer))

                /** Alias for calling [Builder.issuer] with `issuer.orElse(null)`. */
                fun issuer(issuer: Optional<String>) = issuer(issuer.getOrNull())

                /**
                 * Sets [Builder.issuer] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.issuer] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun issuer(issuer: JsonField<String>) = apply { this.issuer = issuer }

                /** The OpenAI model recorded by the provenance signal, when available. */
                fun model(model: String?) = model(JsonField.ofNullable(model))

                /** Alias for calling [Builder.model] with `model.orElse(null)`. */
                fun model(model: Optional<String>) = model(model.getOrNull())

                /**
                 * Sets [Builder.model] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.model] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun model(model: JsonField<String>) = apply { this.model = model }

                /**
                 * Whether a supported OpenAI C2PA provenance signal was detected. If
                 * `not_detected`, it means the tool did not find supported signals in the uploaded
                 * file. The content could still have been generated by OpenAI if the metadata was
                 * stripped or has evidence of tampering, the watermark was degraded, it comes from
                 * a legacy generation model, or it was created before provenance signals were
                 * available. Content could also still be AI-generated by another company's model,
                 * which the tool currently does not detect.
                 */
                fun outcome(outcome: Outcome) = outcome(JsonField.of(outcome))

                /**
                 * Sets [Builder.outcome] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.outcome] with a well-typed [Outcome] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun outcome(outcome: JsonField<Outcome>) = apply { this.outcome = outcome }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("c2pa")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                /** The validation status of the C2PA manifest in the uploaded image. */
                fun validationState(validationState: ValidationState) =
                    validationState(JsonField.of(validationState))

                /**
                 * Sets [Builder.validationState] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.validationState] with a well-typed
                 * [ValidationState] value instead. This method is primarily for setting the field
                 * to an undocumented or not yet supported value.
                 */
                fun validationState(validationState: JsonField<ValidationState>) = apply {
                    this.validationState = validationState
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
                 * Returns an immutable instance of [C2pa].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .generatedAt()
                 * .issuer()
                 * .model()
                 * .outcome()
                 * .validationState()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): C2pa =
                    C2pa(
                        checkRequired("generatedAt", generatedAt),
                        checkRequired("issuer", issuer),
                        checkRequired("model", model),
                        checkRequired("outcome", outcome),
                        type,
                        checkRequired("validationState", validationState),
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
            fun validate(): C2pa = apply {
                if (validated) {
                    return@apply
                }

                generatedAt()
                issuer()
                model()
                outcome().validate()
                _type().let {
                    if (it != JsonValue.from("c2pa")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                validationState().validate()
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
                (if (generatedAt.asKnown().isPresent) 1 else 0) +
                    (if (issuer.asKnown().isPresent) 1 else 0) +
                    (if (model.asKnown().isPresent) 1 else 0) +
                    (outcome.asKnown().getOrNull()?.validity() ?: 0) +
                    type.let { if (it == JsonValue.from("c2pa")) 1 else 0 } +
                    (validationState.asKnown().getOrNull()?.validity() ?: 0)

            /**
             * Whether a supported OpenAI C2PA provenance signal was detected. If `not_detected`, it
             * means the tool did not find supported signals in the uploaded file. The content could
             * still have been generated by OpenAI if the metadata was stripped or has evidence of
             * tampering, the watermark was degraded, it comes from a legacy generation model, or it
             * was created before provenance signals were available. Content could also still be
             * AI-generated by another company's model, which the tool currently does not detect.
             */
            class Outcome @JsonCreator private constructor(private val value: JsonField<String>) :
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

                    @JvmField val DETECTED = of("detected")

                    @JvmField val NOT_DETECTED = of("not_detected")

                    @JvmStatic fun of(value: String) = Outcome(JsonField.of(value))
                }

                /** An enum containing [Outcome]'s known values. */
                enum class Known {
                    DETECTED,
                    NOT_DETECTED,
                }

                /**
                 * An enum containing [Outcome]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Outcome] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    DETECTED,
                    NOT_DETECTED,
                    /**
                     * An enum member indicating that [Outcome] was instantiated with an unknown
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
                fun value(): Value =
                    when (this) {
                        DETECTED -> Value.DETECTED
                        NOT_DETECTED -> Value.NOT_DETECTED
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
                fun known(): Known =
                    when (this) {
                        DETECTED -> Known.DETECTED
                        NOT_DETECTED -> Known.NOT_DETECTED
                        else -> throw OpenAIInvalidDataException("Unknown Outcome: $value")
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
                fun validate(): Outcome = apply {
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

                    return other is Outcome && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            /** The validation status of the C2PA manifest in the uploaded image. */
            class ValidationState
            @JsonCreator
            private constructor(private val value: JsonField<String>) : Enum {

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

                    @JvmField val TRUSTED = of("trusted")

                    @JvmField val VALID = of("valid")

                    @JvmField val INVALID = of("invalid")

                    @JvmField val NOT_PRESENT = of("not_present")

                    @JvmStatic fun of(value: String) = ValidationState(JsonField.of(value))
                }

                /** An enum containing [ValidationState]'s known values. */
                enum class Known {
                    TRUSTED,
                    VALID,
                    INVALID,
                    NOT_PRESENT,
                }

                /**
                 * An enum containing [ValidationState]'s known values, as well as an [_UNKNOWN]
                 * member.
                 *
                 * An instance of [ValidationState] can contain an unknown value in a couple of
                 * cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    TRUSTED,
                    VALID,
                    INVALID,
                    NOT_PRESENT,
                    /**
                     * An enum member indicating that [ValidationState] was instantiated with an
                     * unknown value.
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
                fun value(): Value =
                    when (this) {
                        TRUSTED -> Value.TRUSTED
                        VALID -> Value.VALID
                        INVALID -> Value.INVALID
                        NOT_PRESENT -> Value.NOT_PRESENT
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
                fun known(): Known =
                    when (this) {
                        TRUSTED -> Known.TRUSTED
                        VALID -> Known.VALID
                        INVALID -> Known.INVALID
                        NOT_PRESENT -> Known.NOT_PRESENT
                        else -> throw OpenAIInvalidDataException("Unknown ValidationState: $value")
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
                fun validate(): ValidationState = apply {
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

                    return other is ValidationState && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is C2pa &&
                    generatedAt == other.generatedAt &&
                    issuer == other.issuer &&
                    model == other.model &&
                    outcome == other.outcome &&
                    type == other.type &&
                    validationState == other.validationState &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    generatedAt,
                    issuer,
                    model,
                    outcome,
                    type,
                    validationState,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "C2pa{generatedAt=$generatedAt, issuer=$issuer, model=$model, outcome=$outcome, type=$type, validationState=$validationState, additionalProperties=$additionalProperties}"
        }

        class SynthID
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val generatedAt: JsonField<String>,
            private val model: JsonField<String>,
            private val outcome: JsonField<Outcome>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("generated_at")
                @ExcludeMissing
                generatedAt: JsonField<String> = JsonMissing.of(),
                @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
                @JsonProperty("outcome")
                @ExcludeMissing
                outcome: JsonField<Outcome> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(generatedAt, model, outcome, type, mutableMapOf())

            /**
             * The UTC RFC 3339 timestamp recorded by the provenance signal for when the asset was
             * generated, when available.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun generatedAt(): Optional<String> = generatedAt.getOptional("generated_at")

            /**
             * The OpenAI model recorded by the provenance signal, when available.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun model(): Optional<String> = model.getOptional("model")

            /**
             * Whether a supported OpenAI SynthID watermark was detected. If `not_detected`, it
             * means the tool did not find supported signals in the uploaded file. The content could
             * still have been generated by OpenAI if the metadata was stripped or has evidence of
             * tampering, the watermark was degraded, it comes from a legacy generation model, or it
             * was created before provenance signals were available. Content could also still be
             * AI-generated by another company's model, which the tool currently does not detect.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun outcome(): Outcome = outcome.getRequired("outcome")

            /**
             * The provenance signal type. Always `synthid`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("synthid")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Returns the raw JSON value of [generatedAt].
             *
             * Unlike [generatedAt], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("generated_at")
            @ExcludeMissing
            fun _generatedAt(): JsonField<String> = generatedAt

            /**
             * Returns the raw JSON value of [model].
             *
             * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

            /**
             * Returns the raw JSON value of [outcome].
             *
             * Unlike [outcome], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("outcome") @ExcludeMissing fun _outcome(): JsonField<Outcome> = outcome

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
                 * Returns a mutable builder for constructing an instance of [SynthID].
                 *
                 * The following fields are required:
                 * ```java
                 * .generatedAt()
                 * .model()
                 * .outcome()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [SynthID]. */
            class Builder internal constructor() {

                private var generatedAt: JsonField<String>? = null
                private var model: JsonField<String>? = null
                private var outcome: JsonField<Outcome>? = null
                private var type: JsonValue = JsonValue.from("synthid")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(synthID: SynthID) = apply {
                    generatedAt = synthID.generatedAt
                    model = synthID.model
                    outcome = synthID.outcome
                    type = synthID.type
                    additionalProperties = synthID.additionalProperties.toMutableMap()
                }

                /**
                 * The UTC RFC 3339 timestamp recorded by the provenance signal for when the asset
                 * was generated, when available.
                 */
                fun generatedAt(generatedAt: String?) =
                    generatedAt(JsonField.ofNullable(generatedAt))

                /** Alias for calling [Builder.generatedAt] with `generatedAt.orElse(null)`. */
                fun generatedAt(generatedAt: Optional<String>) =
                    generatedAt(generatedAt.getOrNull())

                /**
                 * Sets [Builder.generatedAt] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.generatedAt] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun generatedAt(generatedAt: JsonField<String>) = apply {
                    this.generatedAt = generatedAt
                }

                /** The OpenAI model recorded by the provenance signal, when available. */
                fun model(model: String?) = model(JsonField.ofNullable(model))

                /** Alias for calling [Builder.model] with `model.orElse(null)`. */
                fun model(model: Optional<String>) = model(model.getOrNull())

                /**
                 * Sets [Builder.model] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.model] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun model(model: JsonField<String>) = apply { this.model = model }

                /**
                 * Whether a supported OpenAI SynthID watermark was detected. If `not_detected`, it
                 * means the tool did not find supported signals in the uploaded file. The content
                 * could still have been generated by OpenAI if the metadata was stripped or has
                 * evidence of tampering, the watermark was degraded, it comes from a legacy
                 * generation model, or it was created before provenance signals were available.
                 * Content could also still be AI-generated by another company's model, which the
                 * tool currently does not detect.
                 */
                fun outcome(outcome: Outcome) = outcome(JsonField.of(outcome))

                /**
                 * Sets [Builder.outcome] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.outcome] with a well-typed [Outcome] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun outcome(outcome: JsonField<Outcome>) = apply { this.outcome = outcome }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("synthid")
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
                 * Returns an immutable instance of [SynthID].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .generatedAt()
                 * .model()
                 * .outcome()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): SynthID =
                    SynthID(
                        checkRequired("generatedAt", generatedAt),
                        checkRequired("model", model),
                        checkRequired("outcome", outcome),
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
            fun validate(): SynthID = apply {
                if (validated) {
                    return@apply
                }

                generatedAt()
                model()
                outcome().validate()
                _type().let {
                    if (it != JsonValue.from("synthid")) {
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
                (if (generatedAt.asKnown().isPresent) 1 else 0) +
                    (if (model.asKnown().isPresent) 1 else 0) +
                    (outcome.asKnown().getOrNull()?.validity() ?: 0) +
                    type.let { if (it == JsonValue.from("synthid")) 1 else 0 }

            /**
             * Whether a supported OpenAI SynthID watermark was detected. If `not_detected`, it
             * means the tool did not find supported signals in the uploaded file. The content could
             * still have been generated by OpenAI if the metadata was stripped or has evidence of
             * tampering, the watermark was degraded, it comes from a legacy generation model, or it
             * was created before provenance signals were available. Content could also still be
             * AI-generated by another company's model, which the tool currently does not detect.
             */
            class Outcome @JsonCreator private constructor(private val value: JsonField<String>) :
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

                    @JvmField val DETECTED = of("detected")

                    @JvmField val NOT_DETECTED = of("not_detected")

                    @JvmStatic fun of(value: String) = Outcome(JsonField.of(value))
                }

                /** An enum containing [Outcome]'s known values. */
                enum class Known {
                    DETECTED,
                    NOT_DETECTED,
                }

                /**
                 * An enum containing [Outcome]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Outcome] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    DETECTED,
                    NOT_DETECTED,
                    /**
                     * An enum member indicating that [Outcome] was instantiated with an unknown
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
                fun value(): Value =
                    when (this) {
                        DETECTED -> Value.DETECTED
                        NOT_DETECTED -> Value.NOT_DETECTED
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
                fun known(): Known =
                    when (this) {
                        DETECTED -> Known.DETECTED
                        NOT_DETECTED -> Known.NOT_DETECTED
                        else -> throw OpenAIInvalidDataException("Unknown Outcome: $value")
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
                fun validate(): Outcome = apply {
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

                    return other is Outcome && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is SynthID &&
                    generatedAt == other.generatedAt &&
                    model == other.model &&
                    outcome == other.outcome &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(generatedAt, model, outcome, type, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "SynthID{generatedAt=$generatedAt, model=$model, outcome=$outcome, type=$type, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ContentProvenanceCheck &&
            createdAt == other.createdAt &&
            object_ == other.object_ &&
            results == other.results &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(createdAt, object_, results, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ContentProvenanceCheck{createdAt=$createdAt, object_=$object_, results=$results, additionalProperties=$additionalProperties}"
}
