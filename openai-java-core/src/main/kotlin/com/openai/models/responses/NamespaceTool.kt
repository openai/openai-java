// File generated from our OpenAPI spec by Stainless.

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

/** Groups function/custom tools under a shared namespace. */
class NamespaceTool
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val description: JsonField<String>,
    private val name: JsonField<String>,
    private val tools: JsonField<List<Tool>>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("description")
        @ExcludeMissing
        description: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("tools") @ExcludeMissing tools: JsonField<List<Tool>> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(description, name, tools, type, mutableMapOf())

    /**
     * A description of the namespace shown to the model.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun description(): String = description.getRequired("description")

    /**
     * The namespace name used in tool calls (for example, `crm`).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = name.getRequired("name")

    /**
     * The function/custom tools available inside this namespace.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun tools(): List<Tool> = tools.getRequired("tools")

    /**
     * The type of the tool. Always `namespace`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("namespace")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [description].
     *
     * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("description") @ExcludeMissing fun _description(): JsonField<String> = description

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [tools].
     *
     * Unlike [tools], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tools") @ExcludeMissing fun _tools(): JsonField<List<Tool>> = tools

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
         * Returns a mutable builder for constructing an instance of [NamespaceTool].
         *
         * The following fields are required:
         * ```java
         * .description()
         * .name()
         * .tools()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [NamespaceTool]. */
    class Builder internal constructor() {

        private var description: JsonField<String>? = null
        private var name: JsonField<String>? = null
        private var tools: JsonField<MutableList<Tool>>? = null
        private var type: JsonValue = JsonValue.from("namespace")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(namespaceTool: NamespaceTool) = apply {
            description = namespaceTool.description
            name = namespaceTool.name
            tools = namespaceTool.tools.map { it.toMutableList() }
            type = namespaceTool.type
            additionalProperties = namespaceTool.additionalProperties.toMutableMap()
        }

        /** A description of the namespace shown to the model. */
        fun description(description: String) = description(JsonField.of(description))

        /**
         * Sets [Builder.description] to an arbitrary JSON value.
         *
         * You should usually call [Builder.description] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun description(description: JsonField<String>) = apply { this.description = description }

        /** The namespace name used in tool calls (for example, `crm`). */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** The function/custom tools available inside this namespace. */
        fun tools(tools: List<Tool>) = tools(JsonField.of(tools))

        /**
         * Sets [Builder.tools] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tools] with a well-typed `List<Tool>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun tools(tools: JsonField<List<Tool>>) = apply {
            this.tools = tools.map { it.toMutableList() }
        }

        /**
         * Adds a single [Tool] to [tools].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTool(tool: Tool) = apply {
            tools =
                (tools ?: JsonField.of(mutableListOf())).also { checkKnown("tools", it).add(tool) }
        }

        /** Alias for calling [addTool] with `Tool.ofFunction(function)`. */
        fun addTool(function: Tool.Function) = addTool(Tool.ofFunction(function))

        /**
         * Alias for calling [addTool] with the following:
         * ```java
         * Tool.Function.builder()
         *     .name(name)
         *     .build()
         * ```
         */
        fun addFunctionTool(name: String) = addTool(Tool.Function.builder().name(name).build())

        /** Alias for calling [addTool] with `Tool.ofCustom(custom)`. */
        fun addTool(custom: CustomTool) = addTool(Tool.ofCustom(custom))

        /**
         * Alias for calling [addTool] with the following:
         * ```java
         * CustomTool.builder()
         *     .name(name)
         *     .build()
         * ```
         */
        fun addCustomTool(name: String) = addTool(CustomTool.builder().name(name).build())

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("namespace")
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
         * Returns an immutable instance of [NamespaceTool].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .description()
         * .name()
         * .tools()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): NamespaceTool =
            NamespaceTool(
                checkRequired("description", description),
                checkRequired("name", name),
                checkRequired("tools", tools).map { it.toImmutable() },
                type,
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
    fun validate(): NamespaceTool = apply {
        if (validated) {
            return@apply
        }

        description()
        name()
        tools().forEach { it.validate() }
        _type().let {
            if (it != JsonValue.from("namespace")) {
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
        (if (description.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (tools.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            type.let { if (it == JsonValue.from("namespace")) 1 else 0 }

    /** A function or custom tool that belongs to a namespace. */
    @JsonDeserialize(using = Tool.Deserializer::class)
    @JsonSerialize(using = Tool.Serializer::class)
    class Tool
    private constructor(
        private val function: Function? = null,
        private val custom: CustomTool? = null,
        private val _json: JsonValue? = null,
    ) {

        fun function(): Optional<Function> = Optional.ofNullable(function)

        /**
         * A custom tool that processes input using a specified format. Learn more about
         * [custom tools](https://platform.openai.com/docs/guides/function-calling#custom-tools)
         */
        fun custom(): Optional<CustomTool> = Optional.ofNullable(custom)

        fun isFunction(): Boolean = function != null

        fun isCustom(): Boolean = custom != null

        fun asFunction(): Function = function.getOrThrow("function")

        /**
         * A custom tool that processes input using a specified format. Learn more about
         * [custom tools](https://platform.openai.com/docs/guides/function-calling#custom-tools)
         */
        fun asCustom(): CustomTool = custom.getOrThrow("custom")

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
         * Optional<String> result = tool.accept(new Tool.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitFunction(Function function) {
         *         return Optional.of(function.toString());
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
                function != null -> visitor.visitFunction(function)
                custom != null -> visitor.visitCustom(custom)
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
        fun validate(): Tool = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitFunction(function: Function) {
                        function.validate()
                    }

                    override fun visitCustom(custom: CustomTool) {
                        custom.validate()
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
                    override fun visitFunction(function: Function) = function.validity()

                    override fun visitCustom(custom: CustomTool) = custom.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Tool && function == other.function && custom == other.custom
        }

        override fun hashCode(): Int = Objects.hash(function, custom)

        override fun toString(): String =
            when {
                function != null -> "Tool{function=$function}"
                custom != null -> "Tool{custom=$custom}"
                _json != null -> "Tool{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Tool")
            }

        companion object {

            @JvmStatic fun ofFunction(function: Function) = Tool(function = function)

            /**
             * A custom tool that processes input using a specified format. Learn more about
             * [custom tools](https://platform.openai.com/docs/guides/function-calling#custom-tools)
             */
            @JvmStatic fun ofCustom(custom: CustomTool) = Tool(custom = custom)
        }

        /** An interface that defines how to map each variant of [Tool] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitFunction(function: Function): T

            /**
             * A custom tool that processes input using a specified format. Learn more about
             * [custom tools](https://platform.openai.com/docs/guides/function-calling#custom-tools)
             */
            fun visitCustom(custom: CustomTool): T

            /**
             * Maps an unknown variant of [Tool] to a value of type [T].
             *
             * An instance of [Tool] can contain an unknown variant if it was deserialized from data
             * that doesn't match any known variant. For example, if the SDK is on an older version
             * than the API, then the API may respond with new variants that the SDK is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Tool: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Tool>(Tool::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Tool {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "function" -> {
                        return tryDeserialize(node, jacksonTypeRef<Function>())?.let {
                            Tool(function = it, _json = json)
                        } ?: Tool(_json = json)
                    }
                    "custom" -> {
                        return tryDeserialize(node, jacksonTypeRef<CustomTool>())?.let {
                            Tool(custom = it, _json = json)
                        } ?: Tool(_json = json)
                    }
                }

                return Tool(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Tool>(Tool::class) {

            override fun serialize(
                value: Tool,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.function != null -> generator.writeObject(value.function)
                    value.custom != null -> generator.writeObject(value.custom)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Tool")
                }
            }
        }

        class Function
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val name: JsonField<String>,
            private val type: JsonValue,
            private val allowedCallers: JsonField<List<AllowedCaller>>,
            private val deferLoading: JsonField<Boolean>,
            private val description: JsonField<String>,
            private val outputSchema: JsonField<OutputSchema>,
            private val parameters: JsonValue,
            private val strict: JsonField<Boolean>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("allowed_callers")
                @ExcludeMissing
                allowedCallers: JsonField<List<AllowedCaller>> = JsonMissing.of(),
                @JsonProperty("defer_loading")
                @ExcludeMissing
                deferLoading: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("description")
                @ExcludeMissing
                description: JsonField<String> = JsonMissing.of(),
                @JsonProperty("output_schema")
                @ExcludeMissing
                outputSchema: JsonField<OutputSchema> = JsonMissing.of(),
                @JsonProperty("parameters")
                @ExcludeMissing
                parameters: JsonValue = JsonMissing.of(),
                @JsonProperty("strict")
                @ExcludeMissing
                strict: JsonField<Boolean> = JsonMissing.of(),
            ) : this(
                name,
                type,
                allowedCallers,
                deferLoading,
                description,
                outputSchema,
                parameters,
                strict,
                mutableMapOf(),
            )

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * Expected to always return the following:
             * ```java
             * JsonValue.from("function")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * The tool invocation context(s).
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun allowedCallers(): Optional<List<AllowedCaller>> =
                allowedCallers.getOptional("allowed_callers")

            /**
             * Whether this function should be deferred and discovered via tool search.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun deferLoading(): Optional<Boolean> = deferLoading.getOptional("defer_loading")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun description(): Optional<String> = description.getOptional("description")

            /**
             * A JSON Schema describing the JSON value encoded in string outputs for this function
             * tool. This does not describe content-array outputs.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun outputSchema(): Optional<OutputSchema> = outputSchema.getOptional("output_schema")

            /**
             * This arbitrary value can be deserialized into a custom type using the `convert`
             * method:
             * ```java
             * MyClass myObject = function.parameters().convert(MyClass.class);
             * ```
             */
            @JsonProperty("parameters") @ExcludeMissing fun _parameters(): JsonValue = parameters

            /**
             * Whether to enforce strict parameter validation. If omitted, Responses attempts to use
             * strict validation when the schema is compatible, and falls back to non-strict
             * validation otherwise.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun strict(): Optional<Boolean> = strict.getOptional("strict")

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [allowedCallers].
             *
             * Unlike [allowedCallers], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("allowed_callers")
            @ExcludeMissing
            fun _allowedCallers(): JsonField<List<AllowedCaller>> = allowedCallers

            /**
             * Returns the raw JSON value of [deferLoading].
             *
             * Unlike [deferLoading], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("defer_loading")
            @ExcludeMissing
            fun _deferLoading(): JsonField<Boolean> = deferLoading

            /**
             * Returns the raw JSON value of [description].
             *
             * Unlike [description], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("description")
            @ExcludeMissing
            fun _description(): JsonField<String> = description

            /**
             * Returns the raw JSON value of [outputSchema].
             *
             * Unlike [outputSchema], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("output_schema")
            @ExcludeMissing
            fun _outputSchema(): JsonField<OutputSchema> = outputSchema

            /**
             * Returns the raw JSON value of [strict].
             *
             * Unlike [strict], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("strict") @ExcludeMissing fun _strict(): JsonField<Boolean> = strict

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
                 * Returns a mutable builder for constructing an instance of [Function].
                 *
                 * The following fields are required:
                 * ```java
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Function]. */
            class Builder internal constructor() {

                private var name: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("function")
                private var allowedCallers: JsonField<MutableList<AllowedCaller>>? = null
                private var deferLoading: JsonField<Boolean> = JsonMissing.of()
                private var description: JsonField<String> = JsonMissing.of()
                private var outputSchema: JsonField<OutputSchema> = JsonMissing.of()
                private var parameters: JsonValue = JsonMissing.of()
                private var strict: JsonField<Boolean> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(function: Function) = apply {
                    name = function.name
                    type = function.type
                    allowedCallers = function.allowedCallers.map { it.toMutableList() }
                    deferLoading = function.deferLoading
                    description = function.description
                    outputSchema = function.outputSchema
                    parameters = function.parameters
                    strict = function.strict
                    additionalProperties = function.additionalProperties.toMutableMap()
                }

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
                 * JsonValue.from("function")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                /** The tool invocation context(s). */
                fun allowedCallers(allowedCallers: List<AllowedCaller>?) =
                    allowedCallers(JsonField.ofNullable(allowedCallers))

                /**
                 * Alias for calling [Builder.allowedCallers] with `allowedCallers.orElse(null)`.
                 */
                fun allowedCallers(allowedCallers: Optional<List<AllowedCaller>>) =
                    allowedCallers(allowedCallers.getOrNull())

                /**
                 * Sets [Builder.allowedCallers] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.allowedCallers] with a well-typed
                 * `List<AllowedCaller>` value instead. This method is primarily for setting the
                 * field to an undocumented or not yet supported value.
                 */
                fun allowedCallers(allowedCallers: JsonField<List<AllowedCaller>>) = apply {
                    this.allowedCallers = allowedCallers.map { it.toMutableList() }
                }

                /**
                 * Adds a single [AllowedCaller] to [allowedCallers].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addAllowedCaller(allowedCaller: AllowedCaller) = apply {
                    allowedCallers =
                        (allowedCallers ?: JsonField.of(mutableListOf())).also {
                            checkKnown("allowedCallers", it).add(allowedCaller)
                        }
                }

                /** Whether this function should be deferred and discovered via tool search. */
                fun deferLoading(deferLoading: Boolean) = deferLoading(JsonField.of(deferLoading))

                /**
                 * Sets [Builder.deferLoading] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.deferLoading] with a well-typed [Boolean] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun deferLoading(deferLoading: JsonField<Boolean>) = apply {
                    this.deferLoading = deferLoading
                }

                fun description(description: String?) =
                    description(JsonField.ofNullable(description))

                /** Alias for calling [Builder.description] with `description.orElse(null)`. */
                fun description(description: Optional<String>) =
                    description(description.getOrNull())

                /**
                 * Sets [Builder.description] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.description] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun description(description: JsonField<String>) = apply {
                    this.description = description
                }

                /**
                 * A JSON Schema describing the JSON value encoded in string outputs for this
                 * function tool. This does not describe content-array outputs.
                 */
                fun outputSchema(outputSchema: OutputSchema?) =
                    outputSchema(JsonField.ofNullable(outputSchema))

                /** Alias for calling [Builder.outputSchema] with `outputSchema.orElse(null)`. */
                fun outputSchema(outputSchema: Optional<OutputSchema>) =
                    outputSchema(outputSchema.getOrNull())

                /**
                 * Sets [Builder.outputSchema] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.outputSchema] with a well-typed [OutputSchema]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun outputSchema(outputSchema: JsonField<OutputSchema>) = apply {
                    this.outputSchema = outputSchema
                }

                fun parameters(parameters: JsonValue) = apply { this.parameters = parameters }

                /**
                 * Whether to enforce strict parameter validation. If omitted, Responses attempts to
                 * use strict validation when the schema is compatible, and falls back to non-strict
                 * validation otherwise.
                 */
                fun strict(strict: Boolean?) = strict(JsonField.ofNullable(strict))

                /**
                 * Alias for [Builder.strict].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun strict(strict: Boolean) = strict(strict as Boolean?)

                /** Alias for calling [Builder.strict] with `strict.orElse(null)`. */
                fun strict(strict: Optional<Boolean>) = strict(strict.getOrNull())

                /**
                 * Sets [Builder.strict] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.strict] with a well-typed [Boolean] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun strict(strict: JsonField<Boolean>) = apply { this.strict = strict }

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
                 * Returns an immutable instance of [Function].
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
                fun build(): Function =
                    Function(
                        checkRequired("name", name),
                        type,
                        (allowedCallers ?: JsonMissing.of()).map { it.toImmutable() },
                        deferLoading,
                        description,
                        outputSchema,
                        parameters,
                        strict,
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
            fun validate(): Function = apply {
                if (validated) {
                    return@apply
                }

                name()
                _type().let {
                    if (it != JsonValue.from("function")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                allowedCallers().ifPresent { it.forEach { it.validate() } }
                deferLoading()
                description()
                outputSchema().ifPresent { it.validate() }
                strict()
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
                    type.let { if (it == JsonValue.from("function")) 1 else 0 } +
                    (allowedCallers.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                    (if (deferLoading.asKnown().isPresent) 1 else 0) +
                    (if (description.asKnown().isPresent) 1 else 0) +
                    (outputSchema.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (strict.asKnown().isPresent) 1 else 0)

            class AllowedCaller
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

                    @JvmField val DIRECT = of("direct")

                    @JvmField val PROGRAMMATIC = of("programmatic")

                    @JvmStatic fun of(value: String) = AllowedCaller(JsonField.of(value))
                }

                /** An enum containing [AllowedCaller]'s known values. */
                enum class Known {
                    DIRECT,
                    PROGRAMMATIC,
                }

                /**
                 * An enum containing [AllowedCaller]'s known values, as well as an [_UNKNOWN]
                 * member.
                 *
                 * An instance of [AllowedCaller] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    DIRECT,
                    PROGRAMMATIC,
                    /**
                     * An enum member indicating that [AllowedCaller] was instantiated with an
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
                        DIRECT -> Value.DIRECT
                        PROGRAMMATIC -> Value.PROGRAMMATIC
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
                        DIRECT -> Known.DIRECT
                        PROGRAMMATIC -> Known.PROGRAMMATIC
                        else -> throw OpenAIInvalidDataException("Unknown AllowedCaller: $value")
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
                fun validate(): AllowedCaller = apply {
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

                    return other is AllowedCaller && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            /**
             * A JSON Schema describing the JSON value encoded in string outputs for this function
             * tool. This does not describe content-array outputs.
             */
            class OutputSchema
            @JsonCreator
            private constructor(
                @com.fasterxml.jackson.annotation.JsonValue
                private val additionalProperties: Map<String, JsonValue>
            ) {

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun toBuilder() = Builder().from(this)

                companion object {

                    /** Returns a mutable builder for constructing an instance of [OutputSchema]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [OutputSchema]. */
                class Builder internal constructor() {

                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(outputSchema: OutputSchema) = apply {
                        additionalProperties = outputSchema.additionalProperties.toMutableMap()
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
                     * Returns an immutable instance of [OutputSchema].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): OutputSchema = OutputSchema(additionalProperties.toImmutable())
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
                fun validate(): OutputSchema = apply {
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

                    return other is OutputSchema &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() = "OutputSchema{additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Function &&
                    name == other.name &&
                    type == other.type &&
                    allowedCallers == other.allowedCallers &&
                    deferLoading == other.deferLoading &&
                    description == other.description &&
                    outputSchema == other.outputSchema &&
                    parameters == other.parameters &&
                    strict == other.strict &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    name,
                    type,
                    allowedCallers,
                    deferLoading,
                    description,
                    outputSchema,
                    parameters,
                    strict,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Function{name=$name, type=$type, allowedCallers=$allowedCallers, deferLoading=$deferLoading, description=$description, outputSchema=$outputSchema, parameters=$parameters, strict=$strict, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is NamespaceTool &&
            description == other.description &&
            name == other.name &&
            tools == other.tools &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(description, name, tools, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "NamespaceTool{description=$description, name=$name, tools=$tools, type=$type, additionalProperties=$additionalProperties}"
}
