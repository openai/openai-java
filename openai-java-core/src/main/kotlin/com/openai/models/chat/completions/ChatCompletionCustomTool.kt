// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

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
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A custom tool that processes input using a specified format. */
class ChatCompletionCustomTool
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val custom: JsonField<Custom>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("custom") @ExcludeMissing custom: JsonField<Custom> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(custom, type, mutableMapOf())

    /**
     * Properties of the custom tool.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun custom(): Custom = custom.getRequired("custom")

    /**
     * The type of the custom tool. Always `custom`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("custom")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [custom].
     *
     * Unlike [custom], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("custom") @ExcludeMissing fun _custom(): JsonField<Custom> = custom

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
         * Returns a mutable builder for constructing an instance of [ChatCompletionCustomTool].
         *
         * The following fields are required:
         * ```java
         * .custom()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ChatCompletionCustomTool]. */
    class Builder internal constructor() {

        private var custom: JsonField<Custom>? = null
        private var type: JsonValue = JsonValue.from("custom")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletionCustomTool: ChatCompletionCustomTool) = apply {
            custom = chatCompletionCustomTool.custom
            type = chatCompletionCustomTool.type
            additionalProperties = chatCompletionCustomTool.additionalProperties.toMutableMap()
        }

        /** Properties of the custom tool. */
        fun custom(custom: Custom) = custom(JsonField.of(custom))

        /**
         * Sets [Builder.custom] to an arbitrary JSON value.
         *
         * You should usually call [Builder.custom] with a well-typed [Custom] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun custom(custom: JsonField<Custom>) = apply { this.custom = custom }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("custom")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

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
         * Returns an immutable instance of [ChatCompletionCustomTool].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .custom()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ChatCompletionCustomTool =
            ChatCompletionCustomTool(
                checkRequired("custom", custom),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ChatCompletionCustomTool = apply {
        if (validated) {
            return@apply
        }

        custom().validate()
        _type().let {
            if (it != JsonValue.from("custom")) {
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (custom.asKnown().getOrNull()?.validity() ?: 0) +
            type.let { if (it == JsonValue.from("custom")) 1 else 0 }

    /** Properties of the custom tool. */
    class Custom
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val name: JsonField<String>,
        private val description: JsonField<String>,
        private val format: JsonField<Format>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("description")
            @ExcludeMissing
            description: JsonField<String> = JsonMissing.of(),
            @JsonProperty("format") @ExcludeMissing format: JsonField<Format> = JsonMissing.of(),
        ) : this(name, description, format, mutableMapOf())

        /**
         * The name of the custom tool, used to identify it in tool calls.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * Optional description of the custom tool, used to provide more context.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun description(): Optional<String> = description.getOptional("description")

        /**
         * The input format for the custom tool. Default is unconstrained text.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun format(): Optional<Format> = format.getOptional("format")

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [description].
         *
         * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

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

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Custom].
             *
             * The following fields are required:
             * ```java
             * .name()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Custom]. */
        class Builder internal constructor() {

            private var name: JsonField<String>? = null
            private var description: JsonField<String> = JsonMissing.of()
            private var format: JsonField<Format> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(custom: Custom) = apply {
                name = custom.name
                description = custom.description
                format = custom.format
                additionalProperties = custom.additionalProperties.toMutableMap()
            }

            /** The name of the custom tool, used to identify it in tool calls. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** Optional description of the custom tool, used to provide more context. */
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

            /** The input format for the custom tool. Default is unconstrained text. */
            fun format(format: Format) = format(JsonField.of(format))

            /**
             * Sets [Builder.format] to an arbitrary JSON value.
             *
             * You should usually call [Builder.format] with a well-typed [Format] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun format(format: JsonField<Format>) = apply { this.format = format }

            /** Alias for calling [format] with `Format.ofText()`. */
            fun formatText() = format(Format.ofText())

            /** Alias for calling [format] with `Format.ofGrammar(grammar)`. */
            fun format(grammar: Format.Grammar) = format(Format.ofGrammar(grammar))

            /**
             * Alias for calling [format] with the following:
             * ```java
             * Format.Grammar.builder()
             *     .grammar(grammar)
             *     .build()
             * ```
             */
            fun grammarFormat(grammar: Format.Grammar.InnerGrammar) =
                format(Format.Grammar.builder().grammar(grammar).build())

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
             * Returns an immutable instance of [Custom].
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
            fun build(): Custom =
                Custom(
                    checkRequired("name", name),
                    description,
                    format,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Custom = apply {
            if (validated) {
                return@apply
            }

            name()
            description()
            format().ifPresent { it.validate() }
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
                (if (description.asKnown().isPresent) 1 else 0) +
                (format.asKnown().getOrNull()?.validity() ?: 0)

        /** The input format for the custom tool. Default is unconstrained text. */
        @JsonDeserialize(using = Format.Deserializer::class)
        @JsonSerialize(using = Format.Serializer::class)
        class Format
        private constructor(
            private val text: JsonValue? = null,
            private val grammar: Grammar? = null,
            private val _json: JsonValue? = null,
        ) {

            /** Unconstrained free-form text. */
            fun text(): Optional<JsonValue> = Optional.ofNullable(text)

            /** A grammar defined by the user. */
            fun grammar(): Optional<Grammar> = Optional.ofNullable(grammar)

            fun isText(): Boolean = text != null

            fun isGrammar(): Boolean = grammar != null

            /** Unconstrained free-form text. */
            fun asText(): JsonValue = text.getOrThrow("text")

            /** A grammar defined by the user. */
            fun asGrammar(): Grammar = grammar.getOrThrow("grammar")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    text != null -> visitor.visitText(text)
                    grammar != null -> visitor.visitGrammar(grammar)
                    else -> visitor.unknown(_json)
                }

            private var validated: Boolean = false

            fun validate(): Format = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitText(text: JsonValue) {
                            text.let {
                                if (it != JsonValue.from(mapOf("type" to "text"))) {
                                    throw OpenAIInvalidDataException(
                                        "'text' is invalid, received $it"
                                    )
                                }
                            }
                        }

                        override fun visitGrammar(grammar: Grammar) {
                            grammar.validate()
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
                        override fun visitText(text: JsonValue) =
                            text.let { if (it == JsonValue.from(mapOf("type" to "text"))) 1 else 0 }

                        override fun visitGrammar(grammar: Grammar) = grammar.validity()

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Format && text == other.text && grammar == other.grammar
            }

            override fun hashCode(): Int = Objects.hash(text, grammar)

            override fun toString(): String =
                when {
                    text != null -> "Format{text=$text}"
                    grammar != null -> "Format{grammar=$grammar}"
                    _json != null -> "Format{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Format")
                }

            companion object {

                /** Unconstrained free-form text. */
                @JvmStatic fun ofText() = Format(text = JsonValue.from(mapOf("type" to "text")))

                /** A grammar defined by the user. */
                @JvmStatic fun ofGrammar(grammar: Grammar) = Format(grammar = grammar)
            }

            /**
             * An interface that defines how to map each variant of [Format] to a value of type [T].
             */
            interface Visitor<out T> {

                /** Unconstrained free-form text. */
                fun visitText(text: JsonValue): T

                /** A grammar defined by the user. */
                fun visitGrammar(grammar: Grammar): T

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
                    throw OpenAIInvalidDataException("Unknown Format: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<Format>(Format::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Format {
                    val json = JsonValue.fromJsonNode(node)
                    val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                    when (type) {
                        "text" -> {
                            return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                ?.let { Format(text = it, _json = json) }
                                ?.takeIf { it.isValid() } ?: Format(_json = json)
                        }
                        "grammar" -> {
                            return tryDeserialize(node, jacksonTypeRef<Grammar>())?.let {
                                Format(grammar = it, _json = json)
                            } ?: Format(_json = json)
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
                        value.grammar != null -> generator.writeObject(value.grammar)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Format")
                    }
                }
            }

            /** A grammar defined by the user. */
            class Grammar
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val grammar: JsonField<InnerGrammar>,
                private val type: JsonValue,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("grammar")
                    @ExcludeMissing
                    grammar: JsonField<InnerGrammar> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                ) : this(grammar, type, mutableMapOf())

                /**
                 * Your chosen grammar.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun grammar(): InnerGrammar = grammar.getRequired("grammar")

                /**
                 * Grammar format. Always `grammar`.
                 *
                 * Expected to always return the following:
                 * ```java
                 * JsonValue.from("grammar")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                /**
                 * Returns the raw JSON value of [grammar].
                 *
                 * Unlike [grammar], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("grammar")
                @ExcludeMissing
                fun _grammar(): JsonField<InnerGrammar> = grammar

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
                     * Returns a mutable builder for constructing an instance of [Grammar].
                     *
                     * The following fields are required:
                     * ```java
                     * .grammar()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Grammar]. */
                class Builder internal constructor() {

                    private var grammar: JsonField<InnerGrammar>? = null
                    private var type: JsonValue = JsonValue.from("grammar")
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(grammar: Grammar) = apply {
                        this.grammar = grammar.grammar
                        type = grammar.type
                        additionalProperties = grammar.additionalProperties.toMutableMap()
                    }

                    /** Your chosen grammar. */
                    fun grammar(grammar: InnerGrammar) = grammar(JsonField.of(grammar))

                    /**
                     * Sets [Builder.grammar] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.grammar] with a well-typed [InnerGrammar]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun grammar(grammar: JsonField<InnerGrammar>) = apply { this.grammar = grammar }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("grammar")
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
                     * Returns an immutable instance of [Grammar].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .grammar()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Grammar =
                        Grammar(
                            checkRequired("grammar", grammar),
                            type,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): Grammar = apply {
                    if (validated) {
                        return@apply
                    }

                    grammar().validate()
                    _type().let {
                        if (it != JsonValue.from("grammar")) {
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
                    (grammar.asKnown().getOrNull()?.validity() ?: 0) +
                        type.let { if (it == JsonValue.from("grammar")) 1 else 0 }

                /** Your chosen grammar. */
                class InnerGrammar
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val definition: JsonField<String>,
                    private val syntax: JsonField<Syntax>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("definition")
                        @ExcludeMissing
                        definition: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("syntax")
                        @ExcludeMissing
                        syntax: JsonField<Syntax> = JsonMissing.of(),
                    ) : this(definition, syntax, mutableMapOf())

                    /**
                     * The grammar definition.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun definition(): String = definition.getRequired("definition")

                    /**
                     * The syntax of the grammar definition. One of `lark` or `regex`.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun syntax(): Syntax = syntax.getRequired("syntax")

                    /**
                     * Returns the raw JSON value of [definition].
                     *
                     * Unlike [definition], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("definition")
                    @ExcludeMissing
                    fun _definition(): JsonField<String> = definition

                    /**
                     * Returns the raw JSON value of [syntax].
                     *
                     * Unlike [syntax], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("syntax")
                    @ExcludeMissing
                    fun _syntax(): JsonField<Syntax> = syntax

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
                         * Returns a mutable builder for constructing an instance of [InnerGrammar].
                         *
                         * The following fields are required:
                         * ```java
                         * .definition()
                         * .syntax()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [InnerGrammar]. */
                    class Builder internal constructor() {

                        private var definition: JsonField<String>? = null
                        private var syntax: JsonField<Syntax>? = null
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(innerGrammar: InnerGrammar) = apply {
                            definition = innerGrammar.definition
                            syntax = innerGrammar.syntax
                            additionalProperties = innerGrammar.additionalProperties.toMutableMap()
                        }

                        /** The grammar definition. */
                        fun definition(definition: String) = definition(JsonField.of(definition))

                        /**
                         * Sets [Builder.definition] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.definition] with a well-typed [String]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun definition(definition: JsonField<String>) = apply {
                            this.definition = definition
                        }

                        /** The syntax of the grammar definition. One of `lark` or `regex`. */
                        fun syntax(syntax: Syntax) = syntax(JsonField.of(syntax))

                        /**
                         * Sets [Builder.syntax] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.syntax] with a well-typed [Syntax] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun syntax(syntax: JsonField<Syntax>) = apply { this.syntax = syntax }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [InnerGrammar].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .definition()
                         * .syntax()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): InnerGrammar =
                            InnerGrammar(
                                checkRequired("definition", definition),
                                checkRequired("syntax", syntax),
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    fun validate(): InnerGrammar = apply {
                        if (validated) {
                            return@apply
                        }

                        definition()
                        syntax().validate()
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
                        (if (definition.asKnown().isPresent) 1 else 0) +
                            (syntax.asKnown().getOrNull()?.validity() ?: 0)

                    /** The syntax of the grammar definition. One of `lark` or `regex`. */
                    class Syntax
                    @JsonCreator
                    private constructor(private val value: JsonField<String>) : Enum {

                        /**
                         * Returns this class instance's raw value.
                         *
                         * This is usually only useful if this instance was deserialized from data
                         * that doesn't match any known member, and you want to know that value. For
                         * example, if the SDK is on an older version than the API, then the API may
                         * respond with new members that the SDK is unaware of.
                         */
                        @com.fasterxml.jackson.annotation.JsonValue
                        fun _value(): JsonField<String> = value

                        companion object {

                            @JvmField val LARK = of("lark")

                            @JvmField val REGEX = of("regex")

                            @JvmStatic fun of(value: String) = Syntax(JsonField.of(value))
                        }

                        /** An enum containing [Syntax]'s known values. */
                        enum class Known {
                            LARK,
                            REGEX,
                        }

                        /**
                         * An enum containing [Syntax]'s known values, as well as an [_UNKNOWN]
                         * member.
                         *
                         * An instance of [Syntax] can contain an unknown value in a couple of
                         * cases:
                         * - It was deserialized from data that doesn't match any known member. For
                         *   example, if the SDK is on an older version than the API, then the API
                         *   may respond with new members that the SDK is unaware of.
                         * - It was constructed with an arbitrary value using the [of] method.
                         */
                        enum class Value {
                            LARK,
                            REGEX,
                            /**
                             * An enum member indicating that [Syntax] was instantiated with an
                             * unknown value.
                             */
                            _UNKNOWN,
                        }

                        /**
                         * Returns an enum member corresponding to this class instance's value, or
                         * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                         *
                         * Use the [known] method instead if you're certain the value is always
                         * known or if you want to throw for the unknown case.
                         */
                        fun value(): Value =
                            when (this) {
                                LARK -> Value.LARK
                                REGEX -> Value.REGEX
                                else -> Value._UNKNOWN
                            }

                        /**
                         * Returns an enum member corresponding to this class instance's value.
                         *
                         * Use the [value] method instead if you're uncertain the value is always
                         * known and don't want to throw for the unknown case.
                         *
                         * @throws OpenAIInvalidDataException if this class instance's value is a
                         *   not a known member.
                         */
                        fun known(): Known =
                            when (this) {
                                LARK -> Known.LARK
                                REGEX -> Known.REGEX
                                else -> throw OpenAIInvalidDataException("Unknown Syntax: $value")
                            }

                        /**
                         * Returns this class instance's primitive wire representation.
                         *
                         * This differs from the [toString] method because that method is primarily
                         * for debugging and generally doesn't throw.
                         *
                         * @throws OpenAIInvalidDataException if this class instance's value does
                         *   not have the expected primitive type.
                         */
                        fun asString(): String =
                            _value().asString().orElseThrow {
                                OpenAIInvalidDataException("Value is not a String")
                            }

                        private var validated: Boolean = false

                        fun validate(): Syntax = apply {
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Syntax && value == other.value
                        }

                        override fun hashCode() = value.hashCode()

                        override fun toString() = value.toString()
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is InnerGrammar &&
                            definition == other.definition &&
                            syntax == other.syntax &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(definition, syntax, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "InnerGrammar{definition=$definition, syntax=$syntax, additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Grammar &&
                        grammar == other.grammar &&
                        type == other.type &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(grammar, type, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Grammar{grammar=$grammar, type=$type, additionalProperties=$additionalProperties}"
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Custom &&
                name == other.name &&
                description == other.description &&
                format == other.format &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(name, description, format, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Custom{name=$name, description=$description, format=$format, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ChatCompletionCustomTool &&
            custom == other.custom &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(custom, type, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatCompletionCustomTool{custom=$custom, type=$type, additionalProperties=$additionalProperties}"
}
