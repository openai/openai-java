// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

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
import com.openai.core.checkRequired
import com.openai.core.collectAllProperties
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.ReasoningEffort
import com.openai.models.ResponseFormatText
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * An update to the conversation's response configuration. Supply reasoning, text, or both. Each
 * setting stays in effect until a later update replaces it.
 */
class ResponseConfigurationUpdateItemParam
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val type: JsonValue,
    private val id: JsonField<String>,
    private val reasoning: JsonField<Reasoning>,
    private val text: JsonField<Text>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("reasoning")
        @ExcludeMissing
        reasoning: JsonField<Reasoning> = JsonMissing.of(),
        @JsonProperty("text") @ExcludeMissing text: JsonField<Text> = JsonMissing.of(),
    ) : this(type, id, reasoning, text, mutableMapOf())

    /**
     * The item type. Always `configuration_update`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("configuration_update")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * The unique ID of the configuration update item.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun id(): Optional<String> = id.getOptional("id")

    /**
     * Updates to reasoning configuration. Only effort is supported.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun reasoning(): Optional<Reasoning> = reasoning.getOptional("reasoning")

    /**
     * The text output configuration for subsequent responses.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun text(): Optional<Text> = text.getOptional("text")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [reasoning].
     *
     * Unlike [reasoning], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("reasoning") @ExcludeMissing fun _reasoning(): JsonField<Reasoning> = reasoning

    /**
     * Returns the raw JSON value of [text].
     *
     * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<Text> = text

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
            "type" to this.type,
            "id" to this.id,
            "reasoning" to this.reasoning,
            "text" to this.text,
        )

    /**
     * Returns the legacy additional-properties view.
     *
     * @deprecated Use [_allProperties] to access both declared and additional JSON properties. This
     *   accessor retains its legacy additional-properties behavior.
     */
    @Deprecated("Use _allProperties() to access both declared and additional JSON properties.")
    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [ResponseConfigurationUpdateItemParam].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseConfigurationUpdateItemParam]. */
    class Builder internal constructor() {

        private var type: JsonValue = JsonValue.from("configuration_update")
        private var id: JsonField<String> = JsonMissing.of()
        private var reasoning: JsonField<Reasoning> = JsonMissing.of()
        private var text: JsonField<Text> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            responseConfigurationUpdateItemParam: ResponseConfigurationUpdateItemParam
        ) = apply {
            type = responseConfigurationUpdateItemParam.type
            id = responseConfigurationUpdateItemParam.id
            reasoning = responseConfigurationUpdateItemParam.reasoning
            text = responseConfigurationUpdateItemParam.text
            additionalProperties =
                responseConfigurationUpdateItemParam.additionalProperties.toMutableMap()
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("configuration_update")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** The unique ID of the configuration update item. */
        fun id(id: String?) = id(JsonField.ofNullable(id))

        /** Alias for calling [Builder.id] with `id.orElse(null)`. */
        fun id(id: Optional<String>) = id(id.getOrNull())

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Updates to reasoning configuration. Only effort is supported. */
        fun reasoning(reasoning: Reasoning) = reasoning(JsonField.of(reasoning))

        /**
         * Sets [Builder.reasoning] to an arbitrary JSON value.
         *
         * You should usually call [Builder.reasoning] with a well-typed [Reasoning] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun reasoning(reasoning: JsonField<Reasoning>) = apply { this.reasoning = reasoning }

        /** The text output configuration for subsequent responses. */
        fun text(text: Text) = text(JsonField.of(text))

        /**
         * Sets [Builder.text] to an arbitrary JSON value.
         *
         * You should usually call [Builder.text] with a well-typed [Text] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun text(text: JsonField<Text>) = apply { this.text = text }

        /**
         * Alias for calling [text] with the following:
         * ```java
         * Text.builder()
         *     .format(format)
         *     .build()
         * ```
         */
        fun formatText(format: Text.Format) = text(Text.builder().format(format).build())

        /** Alias for calling [formatText] with `Text.Format.ofText(text)`. */
        fun formatText(text: ResponseFormatText) = formatText(Text.Format.ofText(text))

        /** Alias for calling [formatText] with `Text.Format.ofJsonSchema(jsonSchema)`. */
        fun formatText(jsonSchema: ResponseFormatTextJsonSchemaConfig) =
            formatText(Text.Format.ofJsonSchema(jsonSchema))

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
         * Returns an immutable instance of [ResponseConfigurationUpdateItemParam].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ResponseConfigurationUpdateItemParam =
            ResponseConfigurationUpdateItemParam(
                type,
                id,
                reasoning,
                text,
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
    fun validate(): ResponseConfigurationUpdateItemParam = apply {
        if (validated) {
            return@apply
        }

        _type().let {
            if (it != JsonValue.from("configuration_update")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        id()
        reasoning().ifPresent { it.validate() }
        text().ifPresent { it.validate() }
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
        type.let { if (it == JsonValue.from("configuration_update")) 1 else 0 } +
            (if (id.asKnown().isPresent) 1 else 0) +
            (reasoning.asKnown().getOrNull()?.validity() ?: 0) +
            (text.asKnown().getOrNull()?.validity() ?: 0)

    /** Updates to reasoning configuration. Only effort is supported. */
    class Reasoning
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val effort: JsonField<ReasoningEffort>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("effort")
            @ExcludeMissing
            effort: JsonField<ReasoningEffort> = JsonMissing.of()
        ) : this(effort, mutableMapOf())

        /**
         * The reasoning effort to use for subsequent responses until another configuration update
         * replaces it.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun effort(): Optional<ReasoningEffort> = effort.getOptional("effort")

        /**
         * Returns the raw JSON value of [effort].
         *
         * Unlike [effort], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("effort") @ExcludeMissing fun _effort(): JsonField<ReasoningEffort> = effort

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
            collectAllProperties(additionalProperties, "effort" to this.effort)

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

            /** Returns a mutable builder for constructing an instance of [Reasoning]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Reasoning]. */
        class Builder internal constructor() {

            private var effort: JsonField<ReasoningEffort> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(reasoning: Reasoning) = apply {
                effort = reasoning.effort
                additionalProperties = reasoning.additionalProperties.toMutableMap()
            }

            /**
             * The reasoning effort to use for subsequent responses until another configuration
             * update replaces it.
             */
            fun effort(effort: ReasoningEffort?) = effort(JsonField.ofNullable(effort))

            /** Alias for calling [Builder.effort] with `effort.orElse(null)`. */
            fun effort(effort: Optional<ReasoningEffort>) = effort(effort.getOrNull())

            /**
             * Sets [Builder.effort] to an arbitrary JSON value.
             *
             * You should usually call [Builder.effort] with a well-typed [ReasoningEffort] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun effort(effort: JsonField<ReasoningEffort>) = apply { this.effort = effort }

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
             * Returns an immutable instance of [Reasoning].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Reasoning = Reasoning(effort, additionalProperties.toMutableMap())
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
        fun validate(): Reasoning = apply {
            if (validated) {
                return@apply
            }

            effort().ifPresent { it.validate() }
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
        @JvmSynthetic internal fun validity(): Int = (effort.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Reasoning &&
                effort == other.effort &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(effort, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Reasoning{effort=$effort, additionalProperties=$additionalProperties}"
    }

    /** The text output configuration for subsequent responses. */
    class Text
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val format: JsonField<Format>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("format") @ExcludeMissing format: JsonField<Format> = JsonMissing.of()
        ) : this(format, mutableMapOf())

        /**
         * Use a JSON schema for structured output or text to return to plain text.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun format(): Format = format.getRequired("format")

        /**
         * Returns the raw JSON value of [format].
         *
         * Unlike [format], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("format") @ExcludeMissing fun _format(): JsonField<Format> = format

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
            collectAllProperties(additionalProperties, "format" to this.format)

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
             * Returns a mutable builder for constructing an instance of [Text].
             *
             * The following fields are required:
             * ```java
             * .format()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Text]. */
        class Builder internal constructor() {

            private var format: JsonField<Format>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(text: Text) = apply {
                format = text.format
                additionalProperties = text.additionalProperties.toMutableMap()
            }

            /** Use a JSON schema for structured output or text to return to plain text. */
            fun format(format: Format) = format(JsonField.of(format))

            /**
             * Sets [Builder.format] to an arbitrary JSON value.
             *
             * You should usually call [Builder.format] with a well-typed [Format] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun format(format: JsonField<Format>) = apply { this.format = format }

            /** Alias for calling [format] with `Format.ofText(text)`. */
            fun format(text: ResponseFormatText) = format(Format.ofText(text))

            /** Alias for calling [format] with `Format.ofJsonSchema(jsonSchema)`. */
            fun format(jsonSchema: ResponseFormatTextJsonSchemaConfig) =
                format(Format.ofJsonSchema(jsonSchema))

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
             * Returns an immutable instance of [Text].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .format()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Text =
                Text(checkRequired("format", format), additionalProperties.toMutableMap())
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
        fun validate(): Text = apply {
            if (validated) {
                return@apply
            }

            format().validate()
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
        @JvmSynthetic internal fun validity(): Int = (format.asKnown().getOrNull()?.validity() ?: 0)

        /** Use a JSON schema for structured output or text to return to plain text. */
        @JsonDeserialize(using = Format.Deserializer::class)
        @JsonSerialize(using = Format.Serializer::class)
        class Format
        private constructor(
            private val text: ResponseFormatText? = null,
            private val jsonSchema: ResponseFormatTextJsonSchemaConfig? = null,
            private val _json: JsonValue? = null,
        ) {

            /** Default response format. Used to generate text responses. */
            fun text(): Optional<ResponseFormatText> = Optional.ofNullable(text)

            /**
             * JSON Schema response format. Used to generate structured JSON responses. Learn more
             * about
             * [Structured Outputs](https://developers.openai.com/api/docs/guides/structured-outputs).
             */
            fun jsonSchema(): Optional<ResponseFormatTextJsonSchemaConfig> =
                Optional.ofNullable(jsonSchema)

            fun isText(): Boolean = text != null

            fun isJsonSchema(): Boolean = jsonSchema != null

            /** Default response format. Used to generate text responses. */
            fun asText(): ResponseFormatText = text.getOrThrow("text")

            /**
             * JSON Schema response format. Used to generate structured JSON responses. Learn more
             * about
             * [Structured Outputs](https://developers.openai.com/api/docs/guides/structured-outputs).
             */
            fun asJsonSchema(): ResponseFormatTextJsonSchemaConfig =
                jsonSchema.getOrThrow("jsonSchema")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            /**
             * Maps this instance's current variant to a value of type [T] using the given
             * [visitor].
             *
             * Note that this method is _not_ forwards compatible with new variants from the API,
             * unless [visitor] overrides [Visitor.unknown]. To handle variants not known to this
             * version of the SDK gracefully, consider overriding [Visitor.unknown]:
             * ```java
             * import com.openai.core.JsonValue;
             * import java.util.Optional;
             *
             * Optional<String> result = format.accept(new Format.Visitor<Optional<String>>() {
             *     @Override
             *     public Optional<String> visitText(ResponseFormatText text) {
             *         return Optional.of(text.toString());
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
             * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in
             *   [visitor] and the current variant is unknown.
             */
            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    text != null -> visitor.visitText(text)
                    jsonSchema != null -> visitor.visitJsonSchema(jsonSchema)
                    else -> visitor.unknown(_json)
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
            fun validate(): Format = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitText(text: ResponseFormatText) {
                            text.validate()
                        }

                        override fun visitJsonSchema(
                            jsonSchema: ResponseFormatTextJsonSchemaConfig
                        ) {
                            jsonSchema.validate()
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
                        override fun visitText(text: ResponseFormatText) = text.validity()

                        override fun visitJsonSchema(
                            jsonSchema: ResponseFormatTextJsonSchemaConfig
                        ) = jsonSchema.validity()

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Format &&
                    text == other.text &&
                    jsonSchema == other.jsonSchema &&
                    (text != null || jsonSchema != null || _json == other._json)
            }

            override fun hashCode(): Int =
                if (text == null && jsonSchema == null) Objects.hash(_json)
                else Objects.hash(text, jsonSchema)

            override fun toString(): String =
                when {
                    text != null -> "Format{text=$text}"
                    jsonSchema != null -> "Format{jsonSchema=$jsonSchema}"
                    _json != null -> "Format{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Format")
                }

            companion object {

                /** Default response format. Used to generate text responses. */
                @JvmStatic fun ofText(text: ResponseFormatText) = Format(text = text)

                /**
                 * JSON Schema response format. Used to generate structured JSON responses. Learn
                 * more about
                 * [Structured Outputs](https://developers.openai.com/api/docs/guides/structured-outputs).
                 */
                @JvmStatic
                fun ofJsonSchema(jsonSchema: ResponseFormatTextJsonSchemaConfig) =
                    Format(jsonSchema = jsonSchema)
            }

            /**
             * An interface that defines how to map each variant of [Format] to a value of type [T].
             */
            interface Visitor<out T> {

                /** Default response format. Used to generate text responses. */
                fun visitText(text: ResponseFormatText): T

                /**
                 * JSON Schema response format. Used to generate structured JSON responses. Learn
                 * more about
                 * [Structured Outputs](https://developers.openai.com/api/docs/guides/structured-outputs).
                 */
                fun visitJsonSchema(jsonSchema: ResponseFormatTextJsonSchemaConfig): T

                /**
                 * Maps an unknown variant of [Format] to a value of type [T].
                 *
                 * An instance of [Format] can contain an unknown variant if it was deserialized
                 * from data that doesn't match any known variant. For example, if the SDK is on an
                 * older version than the API, then the API may respond with new variants that the
                 * SDK is unaware of.
                 *
                 * @throws OpenAIInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown Format")
                }
            }

            internal class Deserializer : BaseDeserializer<Format>(Format::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Format {
                    val json = JsonValue.fromJsonNode(node)
                    val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                    when (type) {
                        "text" -> {
                            return tryDeserialize(node, jacksonTypeRef<ResponseFormatText>())?.let {
                                Format(text = it, _json = json)
                            } ?: Format(_json = json)
                        }
                        "json_schema" -> {
                            return tryDeserialize(
                                    node,
                                    jacksonTypeRef<ResponseFormatTextJsonSchemaConfig>(),
                                )
                                ?.let { Format(jsonSchema = it, _json = json) }
                                ?: Format(_json = json)
                        }
                    }

                    return Format(_json = json)
                }
            }

            internal class Serializer : BaseSerializer<Format>(Format::class) {

                override fun serialize(
                    value: Format,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.text != null -> generator.writeObject(value.text)
                        value.jsonSchema != null -> generator.writeObject(value.jsonSchema)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Format")
                    }
                }
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Text &&
                format == other.format &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(format, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Text{format=$format, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ResponseConfigurationUpdateItemParam &&
            type == other.type &&
            id == other.id &&
            reasoning == other.reasoning &&
            text == other.text &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(type, id, reasoning, text, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseConfigurationUpdateItemParam{type=$type, id=$id, reasoning=$reasoning, text=$text, additionalProperties=$additionalProperties}"
}
