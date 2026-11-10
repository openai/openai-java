// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.automations

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.Params
import com.openai.core.collectAllProperties
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Updates supplied fields; target and metadata replace the whole field. */
class AutomationUpdateParams
private constructor(
    private val automationId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun automationId(): Optional<String> = Optional.ofNullable(automationId)

    /**
     * Only accepted for periodic automations.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun expression(): Optional<String> = body.expression()

    /**
     * Replaces all metadata; omit to leave unchanged.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun metadata(): Optional<Metadata> = body.metadata()

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = body.name()

    /**
     * A future Unix timestamp in seconds; accepted only before a one-time scheduled invocation
     * exists.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun runAt(): Optional<Long> = body.runAt()

    /**
     * Replaces the complete target, retaining its type and any creator session.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun target(): Optional<AutomationTargetParam> = body.target()

    /**
     * Only accepted for periodic automations.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun timezone(): Optional<String> = body.timezone()

    /**
     * Returns the raw JSON value of [expression].
     *
     * Unlike [expression], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _expression(): JsonField<String> = body._expression()

    /**
     * Returns the raw JSON value of [metadata].
     *
     * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _metadata(): JsonField<Metadata> = body._metadata()

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _name(): JsonField<String> = body._name()

    /**
     * Returns the raw JSON value of [runAt].
     *
     * Unlike [runAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _runAt(): JsonField<Long> = body._runAt()

    /**
     * Returns the raw JSON value of [target].
     *
     * Unlike [target], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _target(): JsonField<AutomationTargetParam> = body._target()

    /**
     * Returns the raw JSON value of [timezone].
     *
     * Unlike [timezone], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _timezone(): JsonField<String> = body._timezone()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): AutomationUpdateParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [AutomationUpdateParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AutomationUpdateParams]. */
    class Builder internal constructor() {

        private var automationId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(automationUpdateParams: AutomationUpdateParams) = apply {
            automationId = automationUpdateParams.automationId
            body = automationUpdateParams.body.toBuilder()
            additionalHeaders = automationUpdateParams.additionalHeaders.toBuilder()
            additionalQueryParams = automationUpdateParams.additionalQueryParams.toBuilder()
        }

        fun automationId(automationId: String?) = apply { this.automationId = automationId }

        /** Alias for calling [Builder.automationId] with `automationId.orElse(null)`. */
        fun automationId(automationId: Optional<String>) = automationId(automationId.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [expression]
         * - [metadata]
         * - [name]
         * - [runAt]
         * - [target]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Only accepted for periodic automations. */
        fun expression(expression: String) = apply { body.expression(expression) }

        /**
         * Sets [Builder.expression] to an arbitrary JSON value.
         *
         * You should usually call [Builder.expression] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun expression(expression: JsonField<String>) = apply { body.expression(expression) }

        /** Replaces all metadata; omit to leave unchanged. */
        fun metadata(metadata: Metadata) = apply { body.metadata(metadata) }

        /**
         * Sets [Builder.metadata] to an arbitrary JSON value.
         *
         * You should usually call [Builder.metadata] with a well-typed [Metadata] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun metadata(metadata: JsonField<Metadata>) = apply { body.metadata(metadata) }

        fun name(name: String) = apply { body.name(name) }

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { body.name(name) }

        /**
         * A future Unix timestamp in seconds; accepted only before a one-time scheduled invocation
         * exists.
         */
        fun runAt(runAt: Long) = apply { body.runAt(runAt) }

        /**
         * Sets [Builder.runAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.runAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun runAt(runAt: JsonField<Long>) = apply { body.runAt(runAt) }

        /** Replaces the complete target, retaining its type and any creator session. */
        fun target(target: AutomationTargetParam) = apply { body.target(target) }

        /**
         * Sets [Builder.target] to an arbitrary JSON value.
         *
         * You should usually call [Builder.target] with a well-typed [AutomationTargetParam] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun target(target: JsonField<AutomationTargetParam>) = apply { body.target(target) }

        /** Alias for calling [target] with `AutomationTargetParam.ofNewSession(newSession)`. */
        fun target(newSession: AutomationTargetParam.NewSession) = apply { body.target(newSession) }

        /**
         * Alias for calling [target] with
         * `AutomationTargetParam.ofExistingSession(existingSession)`.
         */
        fun target(existingSession: AutomationTargetParam.ExistingSession) = apply {
            body.target(existingSession)
        }

        /** Only accepted for periodic automations. */
        fun timezone(timezone: String) = apply { body.timezone(timezone) }

        /**
         * Sets [Builder.timezone] to an arbitrary JSON value.
         *
         * You should usually call [Builder.timezone] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun timezone(timezone: JsonField<String>) = apply { body.timezone(timezone) }

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
         * Returns an immutable instance of [AutomationUpdateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): AutomationUpdateParams =
            AutomationUpdateParams(
                automationId,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> automationId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** Updates configuration; timing fields must match the stored automation type. */
    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val expression: JsonField<String>,
        private val metadata: JsonField<Metadata>,
        private val name: JsonField<String>,
        private val runAt: JsonField<Long>,
        private val target: JsonField<AutomationTargetParam>,
        private val timezone: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("expression")
            @ExcludeMissing
            expression: JsonField<String> = JsonMissing.of(),
            @JsonProperty("metadata")
            @ExcludeMissing
            metadata: JsonField<Metadata> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("run_at") @ExcludeMissing runAt: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("target")
            @ExcludeMissing
            target: JsonField<AutomationTargetParam> = JsonMissing.of(),
            @JsonProperty("timezone") @ExcludeMissing timezone: JsonField<String> = JsonMissing.of(),
        ) : this(expression, metadata, name, runAt, target, timezone, mutableMapOf())

        /**
         * Only accepted for periodic automations.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun expression(): Optional<String> = expression.getOptional("expression")

        /**
         * Replaces all metadata; omit to leave unchanged.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun metadata(): Optional<Metadata> = metadata.getOptional("metadata")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * A future Unix timestamp in seconds; accepted only before a one-time scheduled invocation
         * exists.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun runAt(): Optional<Long> = runAt.getOptional("run_at")

        /**
         * Replaces the complete target, retaining its type and any creator session.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun target(): Optional<AutomationTargetParam> = target.getOptional("target")

        /**
         * Only accepted for periodic automations.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun timezone(): Optional<String> = timezone.getOptional("timezone")

        /**
         * Returns the raw JSON value of [expression].
         *
         * Unlike [expression], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("expression")
        @ExcludeMissing
        fun _expression(): JsonField<String> = expression

        /**
         * Returns the raw JSON value of [metadata].
         *
         * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonField<Metadata> = metadata

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [runAt].
         *
         * Unlike [runAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("run_at") @ExcludeMissing fun _runAt(): JsonField<Long> = runAt

        /**
         * Returns the raw JSON value of [target].
         *
         * Unlike [target], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("target")
        @ExcludeMissing
        fun _target(): JsonField<AutomationTargetParam> = target

        /**
         * Returns the raw JSON value of [timezone].
         *
         * Unlike [timezone], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("timezone") @ExcludeMissing fun _timezone(): JsonField<String> = timezone

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
                "expression" to this.expression,
                "metadata" to this.metadata,
                "name" to this.name,
                "run_at" to this.runAt,
                "target" to this.target,
                "timezone" to this.timezone,
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

            private var expression: JsonField<String> = JsonMissing.of()
            private var metadata: JsonField<Metadata> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var runAt: JsonField<Long> = JsonMissing.of()
            private var target: JsonField<AutomationTargetParam> = JsonMissing.of()
            private var timezone: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                expression = body.expression
                metadata = body.metadata
                name = body.name
                runAt = body.runAt
                target = body.target
                timezone = body.timezone
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Only accepted for periodic automations. */
            fun expression(expression: String) = expression(JsonField.of(expression))

            /**
             * Sets [Builder.expression] to an arbitrary JSON value.
             *
             * You should usually call [Builder.expression] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun expression(expression: JsonField<String>) = apply { this.expression = expression }

            /** Replaces all metadata; omit to leave unchanged. */
            fun metadata(metadata: Metadata) = metadata(JsonField.of(metadata))

            /**
             * Sets [Builder.metadata] to an arbitrary JSON value.
             *
             * You should usually call [Builder.metadata] with a well-typed [Metadata] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

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
             * A future Unix timestamp in seconds; accepted only before a one-time scheduled
             * invocation exists.
             */
            fun runAt(runAt: Long) = runAt(JsonField.of(runAt))

            /**
             * Sets [Builder.runAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.runAt] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun runAt(runAt: JsonField<Long>) = apply { this.runAt = runAt }

            /** Replaces the complete target, retaining its type and any creator session. */
            fun target(target: AutomationTargetParam) = target(JsonField.of(target))

            /**
             * Sets [Builder.target] to an arbitrary JSON value.
             *
             * You should usually call [Builder.target] with a well-typed [AutomationTargetParam]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun target(target: JsonField<AutomationTargetParam>) = apply { this.target = target }

            /** Alias for calling [target] with `AutomationTargetParam.ofNewSession(newSession)`. */
            fun target(newSession: AutomationTargetParam.NewSession) =
                target(AutomationTargetParam.ofNewSession(newSession))

            /**
             * Alias for calling [target] with
             * `AutomationTargetParam.ofExistingSession(existingSession)`.
             */
            fun target(existingSession: AutomationTargetParam.ExistingSession) =
                target(AutomationTargetParam.ofExistingSession(existingSession))

            /** Only accepted for periodic automations. */
            fun timezone(timezone: String) = timezone(JsonField.of(timezone))

            /**
             * Sets [Builder.timezone] to an arbitrary JSON value.
             *
             * You should usually call [Builder.timezone] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun timezone(timezone: JsonField<String>) = apply { this.timezone = timezone }

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
                    expression,
                    metadata,
                    name,
                    runAt,
                    target,
                    timezone,
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

            expression()
            metadata().ifPresent { it.validate() }
            name()
            runAt()
            target().ifPresent { it.validate() }
            timezone()
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
            (if (expression.asKnown().isPresent) 1 else 0) +
                (metadata.asKnown().getOrNull()?.validity() ?: 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (runAt.asKnown().isPresent) 1 else 0) +
                (target.asKnown().getOrNull()?.validity() ?: 0) +
                (if (timezone.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                expression == other.expression &&
                metadata == other.metadata &&
                name == other.name &&
                runAt == other.runAt &&
                target == other.target &&
                timezone == other.timezone &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(expression, metadata, name, runAt, target, timezone, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{expression=$expression, metadata=$metadata, name=$name, runAt=$runAt, target=$target, timezone=$timezone, additionalProperties=$additionalProperties}"
    }

    /** Replaces all metadata; omit to leave unchanged. */
    class Metadata
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

            /** Returns a mutable builder for constructing an instance of [Metadata]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Metadata]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(metadata: Metadata) = apply {
                additionalProperties = metadata.additionalProperties.toMutableMap()
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            /** Adds a string-valued property. */
            fun putProperty(key: String, value: String) = apply {
                putAdditionalProperty(key, JsonValue.from(value))
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Metadata].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Metadata = Metadata(additionalProperties.toImmutable())
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
        fun validate(): Metadata = apply {
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

            return other is Metadata && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Metadata{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AutomationUpdateParams &&
            automationId == other.automationId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(automationId, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "AutomationUpdateParams{automationId=$automationId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
