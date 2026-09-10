// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

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

/** A tool available to the agent. */
@JsonDeserialize(using = AgentTool.Deserializer::class)
@JsonSerialize(using = AgentTool.Serializer::class)
class AgentTool
private constructor(
    private val function: Function? = null,
    private val programmaticToolCalling: ProgrammaticToolCalling? = null,
    private val mcp: Mcp? = null,
    private val webSearch: WebSearch? = null,
    private val _json: JsonValue? = null,
) {

    /** A function defined by the application. */
    fun function(): Optional<Function> = Optional.ofNullable(function)

    /** Enables calling tools from model-generated code. */
    fun programmaticToolCalling(): Optional<ProgrammaticToolCalling> =
        Optional.ofNullable(programmaticToolCalling)

    /** Tools provided by a remote MCP server. */
    fun mcp(): Optional<Mcp> = Optional.ofNullable(mcp)

    /** Web search. */
    fun webSearch(): Optional<WebSearch> = Optional.ofNullable(webSearch)

    fun isFunction(): Boolean = function != null

    fun isProgrammaticToolCalling(): Boolean = programmaticToolCalling != null

    fun isMcp(): Boolean = mcp != null

    fun isWebSearch(): Boolean = webSearch != null

    /** A function defined by the application. */
    fun asFunction(): Function = function.getOrThrow("function")

    /** Enables calling tools from model-generated code. */
    fun asProgrammaticToolCalling(): ProgrammaticToolCalling =
        programmaticToolCalling.getOrThrow("programmaticToolCalling")

    /** Tools provided by a remote MCP server. */
    fun asMcp(): Mcp = mcp.getOrThrow("mcp")

    /** Web search. */
    fun asWebSearch(): WebSearch = webSearch.getOrThrow("webSearch")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    /**
     * Maps this instance's current variant to a value of type [T] using the given [visitor].
     *
     * Note that this method is _not_ forwards compatible with new variants from the API, unless
     * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of the
     * SDK gracefully, consider overriding [Visitor.unknown]:
     * ```java
     * import com.openai.core.JsonValue;
     * import java.util.Optional;
     *
     * Optional<String> result = agentTool.accept(new AgentTool.Visitor<Optional<String>>() {
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
     * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in [visitor] and
     *   the current variant is unknown.
     */
    fun <T> accept(visitor: Visitor<T>): T =
        when {
            function != null -> visitor.visitFunction(function)
            programmaticToolCalling != null ->
                visitor.visitProgrammaticToolCalling(programmaticToolCalling)
            mcp != null -> visitor.visitMcp(mcp)
            webSearch != null -> visitor.visitWebSearch(webSearch)
            else -> visitor.unknown(_json)
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
    fun validate(): AgentTool = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitFunction(function: Function) {
                    function.validate()
                }

                override fun visitProgrammaticToolCalling(
                    programmaticToolCalling: ProgrammaticToolCalling
                ) {
                    programmaticToolCalling.validate()
                }

                override fun visitMcp(mcp: Mcp) {
                    mcp.validate()
                }

                override fun visitWebSearch(webSearch: WebSearch) {
                    webSearch.validate()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        accept(
            object : Visitor<Int> {
                override fun visitFunction(function: Function) = function.validity()

                override fun visitProgrammaticToolCalling(
                    programmaticToolCalling: ProgrammaticToolCalling
                ) = programmaticToolCalling.validity()

                override fun visitMcp(mcp: Mcp) = mcp.validity()

                override fun visitWebSearch(webSearch: WebSearch) = webSearch.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AgentTool &&
            function == other.function &&
            programmaticToolCalling == other.programmaticToolCalling &&
            mcp == other.mcp &&
            webSearch == other.webSearch
    }

    override fun hashCode(): Int = Objects.hash(function, programmaticToolCalling, mcp, webSearch)

    override fun toString(): String =
        when {
            function != null -> "AgentTool{function=$function}"
            programmaticToolCalling != null ->
                "AgentTool{programmaticToolCalling=$programmaticToolCalling}"
            mcp != null -> "AgentTool{mcp=$mcp}"
            webSearch != null -> "AgentTool{webSearch=$webSearch}"
            _json != null -> "AgentTool{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid AgentTool")
        }

    companion object {

        /** A function defined by the application. */
        @JvmStatic fun ofFunction(function: Function) = AgentTool(function = function)

        /** Enables calling tools from model-generated code. */
        @JvmStatic
        fun ofProgrammaticToolCalling(programmaticToolCalling: ProgrammaticToolCalling) =
            AgentTool(programmaticToolCalling = programmaticToolCalling)

        /** Tools provided by a remote MCP server. */
        @JvmStatic fun ofMcp(mcp: Mcp) = AgentTool(mcp = mcp)

        /** Web search. */
        @JvmStatic fun ofWebSearch(webSearch: WebSearch) = AgentTool(webSearch = webSearch)
    }

    /** An interface that defines how to map each variant of [AgentTool] to a value of type [T]. */
    interface Visitor<out T> {

        /** A function defined by the application. */
        fun visitFunction(function: Function): T

        /** Enables calling tools from model-generated code. */
        fun visitProgrammaticToolCalling(programmaticToolCalling: ProgrammaticToolCalling): T

        /** Tools provided by a remote MCP server. */
        fun visitMcp(mcp: Mcp): T

        /** Web search. */
        fun visitWebSearch(webSearch: WebSearch): T

        /**
         * Maps an unknown variant of [AgentTool] to a value of type [T].
         *
         * An instance of [AgentTool] can contain an unknown variant if it was deserialized from
         * data that doesn't match any known variant. For example, if the SDK is on an older version
         * than the API, then the API may respond with new variants that the SDK is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown AgentTool: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<AgentTool>(AgentTool::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): AgentTool {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "function" -> {
                    return tryDeserialize(node, jacksonTypeRef<Function>())?.let {
                        AgentTool(function = it, _json = json)
                    } ?: AgentTool(_json = json)
                }
                "programmatic_tool_calling" -> {
                    return tryDeserialize(node, jacksonTypeRef<ProgrammaticToolCalling>())?.let {
                        AgentTool(programmaticToolCalling = it, _json = json)
                    } ?: AgentTool(_json = json)
                }
                "mcp" -> {
                    return tryDeserialize(node, jacksonTypeRef<Mcp>())?.let {
                        AgentTool(mcp = it, _json = json)
                    } ?: AgentTool(_json = json)
                }
                "web_search" -> {
                    return tryDeserialize(node, jacksonTypeRef<WebSearch>())?.let {
                        AgentTool(webSearch = it, _json = json)
                    } ?: AgentTool(_json = json)
                }
            }

            return AgentTool(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<AgentTool>(AgentTool::class) {

        override fun serialize(
            value: AgentTool,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.function != null -> generator.writeObject(value.function)
                value.programmaticToolCalling != null ->
                    generator.writeObject(value.programmaticToolCalling)
                value.mcp != null -> generator.writeObject(value.mcp)
                value.webSearch != null -> generator.writeObject(value.webSearch)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid AgentTool")
            }
        }
    }

    /** A function defined by the application. */
    class Function
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val deferLoading: JsonField<Boolean>,
        private val description: JsonField<String>,
        private val name: JsonField<String>,
        private val parameters: JsonField<Parameters>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("defer_loading")
            @ExcludeMissing
            deferLoading: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("description")
            @ExcludeMissing
            description: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("parameters")
            @ExcludeMissing
            parameters: JsonField<Parameters> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(deferLoading, description, name, parameters, type, mutableMapOf())

        /**
         * Whether the function is deferred and discovered through tool search.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun deferLoading(): Boolean = deferLoading.getRequired("defer_loading")

        /**
         * A description of what the function does.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun description(): String = description.getRequired("description")

        /**
         * The name of the function.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * A JSON Schema object describing the function's arguments.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun parameters(): Parameters = parameters.getRequired("parameters")

        /**
         * The type of the object. Always `function`.
         *
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
         * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [parameters].
         *
         * Unlike [parameters], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("parameters")
        @ExcludeMissing
        fun _parameters(): JsonField<Parameters> = parameters

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
             * .deferLoading()
             * .description()
             * .name()
             * .parameters()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Function]. */
        class Builder internal constructor() {

            private var deferLoading: JsonField<Boolean>? = null
            private var description: JsonField<String>? = null
            private var name: JsonField<String>? = null
            private var parameters: JsonField<Parameters>? = null
            private var type: JsonValue = JsonValue.from("function")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(function: Function) = apply {
                deferLoading = function.deferLoading
                description = function.description
                name = function.name
                parameters = function.parameters
                type = function.type
                additionalProperties = function.additionalProperties.toMutableMap()
            }

            /** Whether the function is deferred and discovered through tool search. */
            fun deferLoading(deferLoading: Boolean) = deferLoading(JsonField.of(deferLoading))

            /**
             * Sets [Builder.deferLoading] to an arbitrary JSON value.
             *
             * You should usually call [Builder.deferLoading] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun deferLoading(deferLoading: JsonField<Boolean>) = apply {
                this.deferLoading = deferLoading
            }

            /** A description of what the function does. */
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

            /** The name of the function. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** A JSON Schema object describing the function's arguments. */
            fun parameters(parameters: Parameters) = parameters(JsonField.of(parameters))

            /**
             * Sets [Builder.parameters] to an arbitrary JSON value.
             *
             * You should usually call [Builder.parameters] with a well-typed [Parameters] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun parameters(parameters: JsonField<Parameters>) = apply {
                this.parameters = parameters
            }

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
             * Returns an immutable instance of [Function].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .deferLoading()
             * .description()
             * .name()
             * .parameters()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Function =
                Function(
                    checkRequired("deferLoading", deferLoading),
                    checkRequired("description", description),
                    checkRequired("name", name),
                    checkRequired("parameters", parameters),
                    type,
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
        fun validate(): Function = apply {
            if (validated) {
                return@apply
            }

            deferLoading()
            description()
            name()
            parameters().validate()
            _type().let {
                if (it != JsonValue.from("function")) {
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
            (if (deferLoading.asKnown().isPresent) 1 else 0) +
                (if (description.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (parameters.asKnown().getOrNull()?.validity() ?: 0) +
                type.let { if (it == JsonValue.from("function")) 1 else 0 }

        /** A JSON Schema object describing the function's arguments. */
        class Parameters
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

                /** Returns a mutable builder for constructing an instance of [Parameters]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Parameters]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(parameters: Parameters) = apply {
                    additionalProperties = parameters.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [Parameters].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Parameters = Parameters(additionalProperties.toImmutable())
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
            fun validate(): Parameters = apply {
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

                return other is Parameters && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Parameters{additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Function &&
                deferLoading == other.deferLoading &&
                description == other.description &&
                name == other.name &&
                parameters == other.parameters &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(deferLoading, description, name, parameters, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Function{deferLoading=$deferLoading, description=$description, name=$name, parameters=$parameters, type=$type, additionalProperties=$additionalProperties}"
    }

    /** Enables calling tools from model-generated code. */
    class ProgrammaticToolCalling
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val enabled: JsonField<Boolean>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("enabled") @ExcludeMissing enabled: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(enabled, type, mutableMapOf())

        /**
         * Whether tools can be called from model-generated code.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun enabled(): Boolean = enabled.getRequired("enabled")

        /**
         * The type of the object. Always `programmatic_tool_calling`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("programmatic_tool_calling")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [enabled].
         *
         * Unlike [enabled], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("enabled") @ExcludeMissing fun _enabled(): JsonField<Boolean> = enabled

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
             * Returns a mutable builder for constructing an instance of [ProgrammaticToolCalling].
             *
             * The following fields are required:
             * ```java
             * .enabled()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ProgrammaticToolCalling]. */
        class Builder internal constructor() {

            private var enabled: JsonField<Boolean>? = null
            private var type: JsonValue = JsonValue.from("programmatic_tool_calling")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(programmaticToolCalling: ProgrammaticToolCalling) = apply {
                enabled = programmaticToolCalling.enabled
                type = programmaticToolCalling.type
                additionalProperties = programmaticToolCalling.additionalProperties.toMutableMap()
            }

            /** Whether tools can be called from model-generated code. */
            fun enabled(enabled: Boolean) = enabled(JsonField.of(enabled))

            /**
             * Sets [Builder.enabled] to an arbitrary JSON value.
             *
             * You should usually call [Builder.enabled] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun enabled(enabled: JsonField<Boolean>) = apply { this.enabled = enabled }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("programmatic_tool_calling")
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

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [ProgrammaticToolCalling].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .enabled()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ProgrammaticToolCalling =
                ProgrammaticToolCalling(
                    checkRequired("enabled", enabled),
                    type,
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
        fun validate(): ProgrammaticToolCalling = apply {
            if (validated) {
                return@apply
            }

            enabled()
            _type().let {
                if (it != JsonValue.from("programmatic_tool_calling")) {
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
            (if (enabled.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("programmatic_tool_calling")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ProgrammaticToolCalling &&
                enabled == other.enabled &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(enabled, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ProgrammaticToolCalling{enabled=$enabled, type=$type, additionalProperties=$additionalProperties}"
    }

    /** Tools provided by a remote MCP server. */
    class Mcp
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val allowedTools: JsonField<List<String>>,
        private val connectionOrigin: JsonField<ConnectionOrigin>,
        private val credentialId: JsonField<String>,
        private val requestMetadata: JsonField<RequestMetadata>,
        private val required: JsonField<Boolean>,
        private val serverLabel: JsonField<String>,
        private val transport: JsonField<McpTransport>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("allowed_tools")
            @ExcludeMissing
            allowedTools: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("connection_origin")
            @ExcludeMissing
            connectionOrigin: JsonField<ConnectionOrigin> = JsonMissing.of(),
            @JsonProperty("credential_id")
            @ExcludeMissing
            credentialId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("request_metadata")
            @ExcludeMissing
            requestMetadata: JsonField<RequestMetadata> = JsonMissing.of(),
            @JsonProperty("required")
            @ExcludeMissing
            required: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("server_label")
            @ExcludeMissing
            serverLabel: JsonField<String> = JsonMissing.of(),
            @JsonProperty("transport")
            @ExcludeMissing
            transport: JsonField<McpTransport> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(
            allowedTools,
            connectionOrigin,
            credentialId,
            requestMetadata,
            required,
            serverLabel,
            transport,
            type,
            mutableMapOf(),
        )

        /**
         * The MCP tools the agent may call.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun allowedTools(): Optional<List<String>> = allowedTools.getOptional("allowed_tools")

        /**
         * Where outbound MCP HTTP connections originate.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun connectionOrigin(): ConnectionOrigin = connectionOrigin.getRequired("connection_origin")

        /**
         * The attached vault credential selected for this MCP server, if any. Optional when exactly
         * one attached credential matches the server URL.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun credentialId(): Optional<String> = credentialId.getOptional("credential_id")

        /**
         * Metadata included with requests to this MCP server.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun requestMetadata(): RequestMetadata = requestMetadata.getRequired("request_metadata")

        /**
         * Whether this MCP server must initialize before the first turn.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun required(): Boolean = required.getRequired("required")

        /**
         * A label used to identify the MCP server in tool calls.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun serverLabel(): String = serverLabel.getRequired("server_label")

        /**
         * The transport used to connect to the MCP server.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun transport(): McpTransport = transport.getRequired("transport")

        /**
         * The type of the object. Always `mcp`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("mcp")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [allowedTools].
         *
         * Unlike [allowedTools], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("allowed_tools")
        @ExcludeMissing
        fun _allowedTools(): JsonField<List<String>> = allowedTools

        /**
         * Returns the raw JSON value of [connectionOrigin].
         *
         * Unlike [connectionOrigin], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("connection_origin")
        @ExcludeMissing
        fun _connectionOrigin(): JsonField<ConnectionOrigin> = connectionOrigin

        /**
         * Returns the raw JSON value of [credentialId].
         *
         * Unlike [credentialId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("credential_id")
        @ExcludeMissing
        fun _credentialId(): JsonField<String> = credentialId

        /**
         * Returns the raw JSON value of [requestMetadata].
         *
         * Unlike [requestMetadata], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("request_metadata")
        @ExcludeMissing
        fun _requestMetadata(): JsonField<RequestMetadata> = requestMetadata

        /**
         * Returns the raw JSON value of [required].
         *
         * Unlike [required], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("required") @ExcludeMissing fun _required(): JsonField<Boolean> = required

        /**
         * Returns the raw JSON value of [serverLabel].
         *
         * Unlike [serverLabel], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("server_label")
        @ExcludeMissing
        fun _serverLabel(): JsonField<String> = serverLabel

        /**
         * Returns the raw JSON value of [transport].
         *
         * Unlike [transport], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("transport")
        @ExcludeMissing
        fun _transport(): JsonField<McpTransport> = transport

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
             * Returns a mutable builder for constructing an instance of [Mcp].
             *
             * The following fields are required:
             * ```java
             * .allowedTools()
             * .connectionOrigin()
             * .credentialId()
             * .requestMetadata()
             * .required()
             * .serverLabel()
             * .transport()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Mcp]. */
        class Builder internal constructor() {

            private var allowedTools: JsonField<MutableList<String>>? = null
            private var connectionOrigin: JsonField<ConnectionOrigin>? = null
            private var credentialId: JsonField<String>? = null
            private var requestMetadata: JsonField<RequestMetadata>? = null
            private var required: JsonField<Boolean>? = null
            private var serverLabel: JsonField<String>? = null
            private var transport: JsonField<McpTransport>? = null
            private var type: JsonValue = JsonValue.from("mcp")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(mcp: Mcp) = apply {
                allowedTools = mcp.allowedTools.map { it.toMutableList() }
                connectionOrigin = mcp.connectionOrigin
                credentialId = mcp.credentialId
                requestMetadata = mcp.requestMetadata
                required = mcp.required
                serverLabel = mcp.serverLabel
                transport = mcp.transport
                type = mcp.type
                additionalProperties = mcp.additionalProperties.toMutableMap()
            }

            /** The MCP tools the agent may call. */
            fun allowedTools(allowedTools: List<String>?) =
                allowedTools(JsonField.ofNullable(allowedTools))

            /** Alias for calling [Builder.allowedTools] with `allowedTools.orElse(null)`. */
            fun allowedTools(allowedTools: Optional<List<String>>) =
                allowedTools(allowedTools.getOrNull())

            /**
             * Sets [Builder.allowedTools] to an arbitrary JSON value.
             *
             * You should usually call [Builder.allowedTools] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun allowedTools(allowedTools: JsonField<List<String>>) = apply {
                this.allowedTools = allowedTools.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [allowedTools].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addAllowedTool(allowedTool: String) = apply {
                allowedTools =
                    (allowedTools ?: JsonField.of(mutableListOf())).also {
                        checkKnown("allowedTools", it).add(allowedTool)
                    }
            }

            /** Where outbound MCP HTTP connections originate. */
            fun connectionOrigin(connectionOrigin: ConnectionOrigin) =
                connectionOrigin(JsonField.of(connectionOrigin))

            /**
             * Sets [Builder.connectionOrigin] to an arbitrary JSON value.
             *
             * You should usually call [Builder.connectionOrigin] with a well-typed
             * [ConnectionOrigin] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun connectionOrigin(connectionOrigin: JsonField<ConnectionOrigin>) = apply {
                this.connectionOrigin = connectionOrigin
            }

            /**
             * The attached vault credential selected for this MCP server, if any. Optional when
             * exactly one attached credential matches the server URL.
             */
            fun credentialId(credentialId: String?) =
                credentialId(JsonField.ofNullable(credentialId))

            /** Alias for calling [Builder.credentialId] with `credentialId.orElse(null)`. */
            fun credentialId(credentialId: Optional<String>) =
                credentialId(credentialId.getOrNull())

            /**
             * Sets [Builder.credentialId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.credentialId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun credentialId(credentialId: JsonField<String>) = apply {
                this.credentialId = credentialId
            }

            /** Metadata included with requests to this MCP server. */
            fun requestMetadata(requestMetadata: RequestMetadata) =
                requestMetadata(JsonField.of(requestMetadata))

            /**
             * Sets [Builder.requestMetadata] to an arbitrary JSON value.
             *
             * You should usually call [Builder.requestMetadata] with a well-typed [RequestMetadata]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun requestMetadata(requestMetadata: JsonField<RequestMetadata>) = apply {
                this.requestMetadata = requestMetadata
            }

            /** Whether this MCP server must initialize before the first turn. */
            fun required(required: Boolean) = required(JsonField.of(required))

            /**
             * Sets [Builder.required] to an arbitrary JSON value.
             *
             * You should usually call [Builder.required] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun required(required: JsonField<Boolean>) = apply { this.required = required }

            /** A label used to identify the MCP server in tool calls. */
            fun serverLabel(serverLabel: String) = serverLabel(JsonField.of(serverLabel))

            /**
             * Sets [Builder.serverLabel] to an arbitrary JSON value.
             *
             * You should usually call [Builder.serverLabel] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun serverLabel(serverLabel: JsonField<String>) = apply {
                this.serverLabel = serverLabel
            }

            /** The transport used to connect to the MCP server. */
            fun transport(transport: McpTransport) = transport(JsonField.of(transport))

            /**
             * Sets [Builder.transport] to an arbitrary JSON value.
             *
             * You should usually call [Builder.transport] with a well-typed [McpTransport] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun transport(transport: JsonField<McpTransport>) = apply { this.transport = transport }

            /** Alias for calling [transport] with `McpTransport.ofHttp(http)`. */
            fun transport(http: McpTransport.Http) = transport(McpTransport.ofHttp(http))

            /**
             * Alias for calling [transport] with the following:
             * ```java
             * McpTransport.Http.builder()
             *     .serverUrl(serverUrl)
             *     .build()
             * ```
             */
            fun httpTransport(serverUrl: String) =
                transport(McpTransport.Http.builder().serverUrl(serverUrl).build())

            /** Alias for calling [transport] with `McpTransport.ofStdio(stdio)`. */
            fun transport(stdio: McpTransport.Stdio) = transport(McpTransport.ofStdio(stdio))

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("mcp")
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

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Mcp].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .allowedTools()
             * .connectionOrigin()
             * .credentialId()
             * .requestMetadata()
             * .required()
             * .serverLabel()
             * .transport()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Mcp =
                Mcp(
                    checkRequired("allowedTools", allowedTools).map { it.toImmutable() },
                    checkRequired("connectionOrigin", connectionOrigin),
                    checkRequired("credentialId", credentialId),
                    checkRequired("requestMetadata", requestMetadata),
                    checkRequired("required", required),
                    checkRequired("serverLabel", serverLabel),
                    checkRequired("transport", transport),
                    type,
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
        fun validate(): Mcp = apply {
            if (validated) {
                return@apply
            }

            allowedTools()
            connectionOrigin().validate()
            credentialId()
            requestMetadata().validate()
            required()
            serverLabel()
            transport().validate()
            _type().let {
                if (it != JsonValue.from("mcp")) {
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
            (allowedTools.asKnown().getOrNull()?.size ?: 0) +
                (connectionOrigin.asKnown().getOrNull()?.validity() ?: 0) +
                (if (credentialId.asKnown().isPresent) 1 else 0) +
                (requestMetadata.asKnown().getOrNull()?.validity() ?: 0) +
                (if (required.asKnown().isPresent) 1 else 0) +
                (if (serverLabel.asKnown().isPresent) 1 else 0) +
                (transport.asKnown().getOrNull()?.validity() ?: 0) +
                type.let { if (it == JsonValue.from("mcp")) 1 else 0 }

        /** Where outbound MCP HTTP connections originate. */
        class ConnectionOrigin
        @JsonCreator
        private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val SERVICE = of("service")

                @JvmField val ENVIRONMENT = of("environment")

                @JvmStatic fun of(value: String) = ConnectionOrigin(JsonField.of(value))
            }

            /** An enum containing [ConnectionOrigin]'s known values. */
            enum class Known {
                SERVICE,
                ENVIRONMENT,
            }

            /**
             * An enum containing [ConnectionOrigin]'s known values, as well as an [_UNKNOWN]
             * member.
             *
             * An instance of [ConnectionOrigin] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                SERVICE,
                ENVIRONMENT,
                /**
                 * An enum member indicating that [ConnectionOrigin] was instantiated with an
                 * unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    SERVICE -> Value.SERVICE
                    ENVIRONMENT -> Value.ENVIRONMENT
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws OpenAIInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    SERVICE -> Known.SERVICE
                    ENVIRONMENT -> Known.ENVIRONMENT
                    else -> throw OpenAIInvalidDataException("Unknown ConnectionOrigin: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws OpenAIInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
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
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): ConnectionOrigin = apply {
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

                return other is ConnectionOrigin && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /** Metadata included with requests to this MCP server. */
        class RequestMetadata
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

                /** Returns a mutable builder for constructing an instance of [RequestMetadata]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [RequestMetadata]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(requestMetadata: RequestMetadata) = apply {
                    additionalProperties = requestMetadata.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [RequestMetadata].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): RequestMetadata = RequestMetadata(additionalProperties.toImmutable())
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
            fun validate(): RequestMetadata = apply {
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

                return other is RequestMetadata &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "RequestMetadata{additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Mcp &&
                allowedTools == other.allowedTools &&
                connectionOrigin == other.connectionOrigin &&
                credentialId == other.credentialId &&
                requestMetadata == other.requestMetadata &&
                required == other.required &&
                serverLabel == other.serverLabel &&
                transport == other.transport &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                allowedTools,
                connectionOrigin,
                credentialId,
                requestMetadata,
                required,
                serverLabel,
                transport,
                type,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Mcp{allowedTools=$allowedTools, connectionOrigin=$connectionOrigin, credentialId=$credentialId, requestMetadata=$requestMetadata, required=$required, serverLabel=$serverLabel, transport=$transport, type=$type, additionalProperties=$additionalProperties}"
    }

    /** Web search. */
    class WebSearch
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val allowedDomains: JsonField<List<String>>,
        private val contextSize: JsonField<ContextSize>,
        private val location: JsonField<Location>,
        private val mode: JsonField<Mode>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("allowed_domains")
            @ExcludeMissing
            allowedDomains: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("context_size")
            @ExcludeMissing
            contextSize: JsonField<ContextSize> = JsonMissing.of(),
            @JsonProperty("location")
            @ExcludeMissing
            location: JsonField<Location> = JsonMissing.of(),
            @JsonProperty("mode") @ExcludeMissing mode: JsonField<Mode> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(allowedDomains, contextSize, location, mode, type, mutableMapOf())

        /**
         * Allowed search domains, or `null` when the search is unrestricted.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun allowedDomains(): Optional<List<String>> = allowedDomains.getOptional("allowed_domains")

        /**
         * The amount of search context made available to the model. Defaults to `medium`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun contextSize(): ContextSize = contextSize.getRequired("context_size")

        /**
         * Approximate user location used to localize web search results.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun location(): Optional<Location> = location.getOptional("location")

        /**
         * The source used for web search results.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun mode(): Mode = mode.getRequired("mode")

        /**
         * The type of the object. Always `web_search`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("web_search")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [allowedDomains].
         *
         * Unlike [allowedDomains], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("allowed_domains")
        @ExcludeMissing
        fun _allowedDomains(): JsonField<List<String>> = allowedDomains

        /**
         * Returns the raw JSON value of [contextSize].
         *
         * Unlike [contextSize], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("context_size")
        @ExcludeMissing
        fun _contextSize(): JsonField<ContextSize> = contextSize

        /**
         * Returns the raw JSON value of [location].
         *
         * Unlike [location], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("location") @ExcludeMissing fun _location(): JsonField<Location> = location

        /**
         * Returns the raw JSON value of [mode].
         *
         * Unlike [mode], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("mode") @ExcludeMissing fun _mode(): JsonField<Mode> = mode

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
             * Returns a mutable builder for constructing an instance of [WebSearch].
             *
             * The following fields are required:
             * ```java
             * .allowedDomains()
             * .contextSize()
             * .location()
             * .mode()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [WebSearch]. */
        class Builder internal constructor() {

            private var allowedDomains: JsonField<MutableList<String>>? = null
            private var contextSize: JsonField<ContextSize>? = null
            private var location: JsonField<Location>? = null
            private var mode: JsonField<Mode>? = null
            private var type: JsonValue = JsonValue.from("web_search")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(webSearch: WebSearch) = apply {
                allowedDomains = webSearch.allowedDomains.map { it.toMutableList() }
                contextSize = webSearch.contextSize
                location = webSearch.location
                mode = webSearch.mode
                type = webSearch.type
                additionalProperties = webSearch.additionalProperties.toMutableMap()
            }

            /** Allowed search domains, or `null` when the search is unrestricted. */
            fun allowedDomains(allowedDomains: List<String>?) =
                allowedDomains(JsonField.ofNullable(allowedDomains))

            /** Alias for calling [Builder.allowedDomains] with `allowedDomains.orElse(null)`. */
            fun allowedDomains(allowedDomains: Optional<List<String>>) =
                allowedDomains(allowedDomains.getOrNull())

            /**
             * Sets [Builder.allowedDomains] to an arbitrary JSON value.
             *
             * You should usually call [Builder.allowedDomains] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun allowedDomains(allowedDomains: JsonField<List<String>>) = apply {
                this.allowedDomains = allowedDomains.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [allowedDomains].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addAllowedDomain(allowedDomain: String) = apply {
                allowedDomains =
                    (allowedDomains ?: JsonField.of(mutableListOf())).also {
                        checkKnown("allowedDomains", it).add(allowedDomain)
                    }
            }

            /** The amount of search context made available to the model. Defaults to `medium`. */
            fun contextSize(contextSize: ContextSize) = contextSize(JsonField.of(contextSize))

            /**
             * Sets [Builder.contextSize] to an arbitrary JSON value.
             *
             * You should usually call [Builder.contextSize] with a well-typed [ContextSize] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun contextSize(contextSize: JsonField<ContextSize>) = apply {
                this.contextSize = contextSize
            }

            /** Approximate user location used to localize web search results. */
            fun location(location: Location?) = location(JsonField.ofNullable(location))

            /** Alias for calling [Builder.location] with `location.orElse(null)`. */
            fun location(location: Optional<Location>) = location(location.getOrNull())

            /**
             * Sets [Builder.location] to an arbitrary JSON value.
             *
             * You should usually call [Builder.location] with a well-typed [Location] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun location(location: JsonField<Location>) = apply { this.location = location }

            /** The source used for web search results. */
            fun mode(mode: Mode) = mode(JsonField.of(mode))

            /**
             * Sets [Builder.mode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.mode] with a well-typed [Mode] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun mode(mode: JsonField<Mode>) = apply { this.mode = mode }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("web_search")
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

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [WebSearch].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .allowedDomains()
             * .contextSize()
             * .location()
             * .mode()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): WebSearch =
                WebSearch(
                    checkRequired("allowedDomains", allowedDomains).map { it.toImmutable() },
                    checkRequired("contextSize", contextSize),
                    checkRequired("location", location),
                    checkRequired("mode", mode),
                    type,
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
        fun validate(): WebSearch = apply {
            if (validated) {
                return@apply
            }

            allowedDomains()
            contextSize().validate()
            location().ifPresent { it.validate() }
            mode().validate()
            _type().let {
                if (it != JsonValue.from("web_search")) {
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
            (allowedDomains.asKnown().getOrNull()?.size ?: 0) +
                (contextSize.asKnown().getOrNull()?.validity() ?: 0) +
                (location.asKnown().getOrNull()?.validity() ?: 0) +
                (mode.asKnown().getOrNull()?.validity() ?: 0) +
                type.let { if (it == JsonValue.from("web_search")) 1 else 0 }

        /** The amount of search context made available to the model. Defaults to `medium`. */
        class ContextSize @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val LOW = of("low")

                @JvmField val MEDIUM = of("medium")

                @JvmField val HIGH = of("high")

                @JvmStatic fun of(value: String) = ContextSize(JsonField.of(value))
            }

            /** An enum containing [ContextSize]'s known values. */
            enum class Known {
                LOW,
                MEDIUM,
                HIGH,
            }

            /**
             * An enum containing [ContextSize]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [ContextSize] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                LOW,
                MEDIUM,
                HIGH,
                /**
                 * An enum member indicating that [ContextSize] was instantiated with an unknown
                 * value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    LOW -> Value.LOW
                    MEDIUM -> Value.MEDIUM
                    HIGH -> Value.HIGH
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws OpenAIInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    LOW -> Known.LOW
                    MEDIUM -> Known.MEDIUM
                    HIGH -> Known.HIGH
                    else -> throw OpenAIInvalidDataException("Unknown ContextSize: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws OpenAIInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
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
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): ContextSize = apply {
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

                return other is ContextSize && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /** Approximate user location used to localize web search results. */
        class Location
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val city: JsonField<String>,
            private val country: JsonField<String>,
            private val region: JsonField<String>,
            private val timezone: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("city") @ExcludeMissing city: JsonField<String> = JsonMissing.of(),
                @JsonProperty("country")
                @ExcludeMissing
                country: JsonField<String> = JsonMissing.of(),
                @JsonProperty("region")
                @ExcludeMissing
                region: JsonField<String> = JsonMissing.of(),
                @JsonProperty("timezone")
                @ExcludeMissing
                timezone: JsonField<String> = JsonMissing.of(),
            ) : this(city, country, region, timezone, mutableMapOf())

            /**
             * The city name.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun city(): Optional<String> = city.getOptional("city")

            /**
             * The two-letter ISO country code, such as `US`.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun country(): Optional<String> = country.getOptional("country")

            /**
             * The region or state name.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun region(): Optional<String> = region.getOptional("region")

            /**
             * The IANA timezone, such as `America/Los_Angeles`.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun timezone(): Optional<String> = timezone.getOptional("timezone")

            /**
             * Returns the raw JSON value of [city].
             *
             * Unlike [city], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("city") @ExcludeMissing fun _city(): JsonField<String> = city

            /**
             * Returns the raw JSON value of [country].
             *
             * Unlike [country], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("country") @ExcludeMissing fun _country(): JsonField<String> = country

            /**
             * Returns the raw JSON value of [region].
             *
             * Unlike [region], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("region") @ExcludeMissing fun _region(): JsonField<String> = region

            /**
             * Returns the raw JSON value of [timezone].
             *
             * Unlike [timezone], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("timezone") @ExcludeMissing fun _timezone(): JsonField<String> = timezone

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
                 * Returns a mutable builder for constructing an instance of [Location].
                 *
                 * The following fields are required:
                 * ```java
                 * .city()
                 * .country()
                 * .region()
                 * .timezone()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Location]. */
            class Builder internal constructor() {

                private var city: JsonField<String>? = null
                private var country: JsonField<String>? = null
                private var region: JsonField<String>? = null
                private var timezone: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(location: Location) = apply {
                    city = location.city
                    country = location.country
                    region = location.region
                    timezone = location.timezone
                    additionalProperties = location.additionalProperties.toMutableMap()
                }

                /** The city name. */
                fun city(city: String?) = city(JsonField.ofNullable(city))

                /** Alias for calling [Builder.city] with `city.orElse(null)`. */
                fun city(city: Optional<String>) = city(city.getOrNull())

                /**
                 * Sets [Builder.city] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.city] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun city(city: JsonField<String>) = apply { this.city = city }

                /** The two-letter ISO country code, such as `US`. */
                fun country(country: String?) = country(JsonField.ofNullable(country))

                /** Alias for calling [Builder.country] with `country.orElse(null)`. */
                fun country(country: Optional<String>) = country(country.getOrNull())

                /**
                 * Sets [Builder.country] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.country] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun country(country: JsonField<String>) = apply { this.country = country }

                /** The region or state name. */
                fun region(region: String?) = region(JsonField.ofNullable(region))

                /** Alias for calling [Builder.region] with `region.orElse(null)`. */
                fun region(region: Optional<String>) = region(region.getOrNull())

                /**
                 * Sets [Builder.region] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.region] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun region(region: JsonField<String>) = apply { this.region = region }

                /** The IANA timezone, such as `America/Los_Angeles`. */
                fun timezone(timezone: String?) = timezone(JsonField.ofNullable(timezone))

                /** Alias for calling [Builder.timezone] with `timezone.orElse(null)`. */
                fun timezone(timezone: Optional<String>) = timezone(timezone.getOrNull())

                /**
                 * Sets [Builder.timezone] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.timezone] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun timezone(timezone: JsonField<String>) = apply { this.timezone = timezone }

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
                 * Returns an immutable instance of [Location].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .city()
                 * .country()
                 * .region()
                 * .timezone()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Location =
                    Location(
                        checkRequired("city", city),
                        checkRequired("country", country),
                        checkRequired("region", region),
                        checkRequired("timezone", timezone),
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
            fun validate(): Location = apply {
                if (validated) {
                    return@apply
                }

                city()
                country()
                region()
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
                (if (city.asKnown().isPresent) 1 else 0) +
                    (if (country.asKnown().isPresent) 1 else 0) +
                    (if (region.asKnown().isPresent) 1 else 0) +
                    (if (timezone.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Location &&
                    city == other.city &&
                    country == other.country &&
                    region == other.region &&
                    timezone == other.timezone &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(city, country, region, timezone, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Location{city=$city, country=$country, region=$region, timezone=$timezone, additionalProperties=$additionalProperties}"
        }

        /** The source used for web search results. */
        class Mode @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val DISABLED = of("disabled")

                @JvmField val CACHED = of("cached")

                @JvmField val LIVE = of("live")

                @JvmStatic fun of(value: String) = Mode(JsonField.of(value))
            }

            /** An enum containing [Mode]'s known values. */
            enum class Known {
                DISABLED,
                CACHED,
                LIVE,
            }

            /**
             * An enum containing [Mode]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Mode] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                DISABLED,
                CACHED,
                LIVE,
                /** An enum member indicating that [Mode] was instantiated with an unknown value. */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    DISABLED -> Value.DISABLED
                    CACHED -> Value.CACHED
                    LIVE -> Value.LIVE
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws OpenAIInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    DISABLED -> Known.DISABLED
                    CACHED -> Known.CACHED
                    LIVE -> Known.LIVE
                    else -> throw OpenAIInvalidDataException("Unknown Mode: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws OpenAIInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
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
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Mode = apply {
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

                return other is Mode && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is WebSearch &&
                allowedDomains == other.allowedDomains &&
                contextSize == other.contextSize &&
                location == other.location &&
                mode == other.mode &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(allowedDomains, contextSize, location, mode, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "WebSearch{allowedDomains=$allowedDomains, contextSize=$contextSize, location=$location, mode=$mode, type=$type, additionalProperties=$additionalProperties}"
    }
}
