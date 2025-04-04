// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.assistants

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.FunctionDefinition
import com.openai.models.ResponseFormatJsonObject
import com.openai.models.ResponseFormatJsonSchema
import com.openai.models.ResponseFormatText
import com.openai.models.beta.threads.AssistantResponseFormatOption
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Represents an `assistant` that can call the model and use tools. */
class Assistant
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<Long>,
    private val description: JsonField<String>,
    private val instructions: JsonField<String>,
    private val metadata: JsonField<Metadata>,
    private val model: JsonField<String>,
    private val name: JsonField<String>,
    private val object_: JsonValue,
    private val tools: JsonField<List<AssistantTool>>,
    private val responseFormat: JsonField<AssistantResponseFormatOption>,
    private val temperature: JsonField<Double>,
    private val toolResources: JsonField<ToolResources>,
    private val topP: JsonField<Double>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("description")
        @ExcludeMissing
        description: JsonField<String> = JsonMissing.of(),
        @JsonProperty("instructions")
        @ExcludeMissing
        instructions: JsonField<String> = JsonMissing.of(),
        @JsonProperty("metadata") @ExcludeMissing metadata: JsonField<Metadata> = JsonMissing.of(),
        @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("tools")
        @ExcludeMissing
        tools: JsonField<List<AssistantTool>> = JsonMissing.of(),
        @JsonProperty("response_format")
        @ExcludeMissing
        responseFormat: JsonField<AssistantResponseFormatOption> = JsonMissing.of(),
        @JsonProperty("temperature")
        @ExcludeMissing
        temperature: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("tool_resources")
        @ExcludeMissing
        toolResources: JsonField<ToolResources> = JsonMissing.of(),
        @JsonProperty("top_p") @ExcludeMissing topP: JsonField<Double> = JsonMissing.of(),
    ) : this(
        id,
        createdAt,
        description,
        instructions,
        metadata,
        model,
        name,
        object_,
        tools,
        responseFormat,
        temperature,
        toolResources,
        topP,
        mutableMapOf(),
    )

    /**
     * The identifier, which can be referenced in API endpoints.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The Unix timestamp (in seconds) for when the assistant was created.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /**
     * The description of the assistant. The maximum length is 512 characters.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun description(): Optional<String> = description.getOptional("description")

    /**
     * The system instructions that the assistant uses. The maximum length is 256,000 characters.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun instructions(): Optional<String> = instructions.getOptional("instructions")

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format, and querying for objects via
     * API or the dashboard.
     *
     * Keys are strings with a maximum length of 64 characters. Values are strings with a maximum
     * length of 512 characters.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun metadata(): Optional<Metadata> = metadata.getOptional("metadata")

    /**
     * ID of the model to use. You can use the
     * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all of
     * your available models, or see our [Model overview](https://platform.openai.com/docs/models)
     * for descriptions of them.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun model(): String = model.getRequired("model")

    /**
     * The name of the assistant. The maximum length is 256 characters.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = name.getOptional("name")

    /**
     * The object type, which is always `assistant`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("assistant")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * A list of tool enabled on the assistant. There can be a maximum of 128 tools per assistant.
     * Tools can be of types `code_interpreter`, `file_search`, or `function`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun tools(): List<AssistantTool> = tools.getRequired("tools")

    /**
     * Specifies the format that the model must output. Compatible with
     * [GPT-4o](https://platform.openai.com/docs/models#gpt-4o), [GPT-4
     * Turbo](https://platform.openai.com/docs/models#gpt-4-turbo-and-gpt-4), and all GPT-3.5 Turbo
     * models since `gpt-3.5-turbo-1106`.
     *
     * Setting to `{ "type": "json_schema", "json_schema": {...} }` enables Structured Outputs which
     * ensures the model will match your supplied JSON schema. Learn more in the
     * [Structured Outputs guide](https://platform.openai.com/docs/guides/structured-outputs).
     *
     * Setting to `{ "type": "json_object" }` enables JSON mode, which ensures the message the model
     * generates is valid JSON.
     *
     * **Important:** when using JSON mode, you **must** also instruct the model to produce JSON
     * yourself via a system or user message. Without this, the model may generate an unending
     * stream of whitespace until the generation reaches the token limit, resulting in a
     * long-running and seemingly "stuck" request. Also note that the message content may be
     * partially cut off if `finish_reason="length"`, which indicates the generation exceeded
     * `max_tokens` or the conversation exceeded the max context length.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun responseFormat(): Optional<AssistantResponseFormatOption> =
        responseFormat.getOptional("response_format")

    /**
     * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
     * output more random, while lower values like 0.2 will make it more focused and deterministic.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun temperature(): Optional<Double> = temperature.getOptional("temperature")

    /**
     * A set of resources that are used by the assistant's tools. The resources are specific to the
     * type of tool. For example, the `code_interpreter` tool requires a list of file IDs, while the
     * `file_search` tool requires a list of vector store IDs.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun toolResources(): Optional<ToolResources> = toolResources.getOptional("tool_resources")

    /**
     * An alternative to sampling with temperature, called nucleus sampling, where the model
     * considers the results of the tokens with top_p probability mass. So 0.1 means only the tokens
     * comprising the top 10% probability mass are considered.
     *
     * We generally recommend altering this or temperature but not both.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun topP(): Optional<Double> = topP.getOptional("top_p")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt(): JsonField<Long> = createdAt

    /**
     * Returns the raw JSON value of [description].
     *
     * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("description") @ExcludeMissing fun _description(): JsonField<String> = description

    /**
     * Returns the raw JSON value of [instructions].
     *
     * Unlike [instructions], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("instructions")
    @ExcludeMissing
    fun _instructions(): JsonField<String> = instructions

    /**
     * Returns the raw JSON value of [metadata].
     *
     * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonField<Metadata> = metadata

    /**
     * Returns the raw JSON value of [model].
     *
     * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

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
    @JsonProperty("tools") @ExcludeMissing fun _tools(): JsonField<List<AssistantTool>> = tools

    /**
     * Returns the raw JSON value of [responseFormat].
     *
     * Unlike [responseFormat], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("response_format")
    @ExcludeMissing
    fun _responseFormat(): JsonField<AssistantResponseFormatOption> = responseFormat

    /**
     * Returns the raw JSON value of [temperature].
     *
     * Unlike [temperature], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("temperature") @ExcludeMissing fun _temperature(): JsonField<Double> = temperature

    /**
     * Returns the raw JSON value of [toolResources].
     *
     * Unlike [toolResources], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tool_resources")
    @ExcludeMissing
    fun _toolResources(): JsonField<ToolResources> = toolResources

    /**
     * Returns the raw JSON value of [topP].
     *
     * Unlike [topP], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("top_p") @ExcludeMissing fun _topP(): JsonField<Double> = topP

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
         * Returns a mutable builder for constructing an instance of [Assistant].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .description()
         * .instructions()
         * .metadata()
         * .model()
         * .name()
         * .tools()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Assistant]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var createdAt: JsonField<Long>? = null
        private var description: JsonField<String>? = null
        private var instructions: JsonField<String>? = null
        private var metadata: JsonField<Metadata>? = null
        private var model: JsonField<String>? = null
        private var name: JsonField<String>? = null
        private var object_: JsonValue = JsonValue.from("assistant")
        private var tools: JsonField<MutableList<AssistantTool>>? = null
        private var responseFormat: JsonField<AssistantResponseFormatOption> = JsonMissing.of()
        private var temperature: JsonField<Double> = JsonMissing.of()
        private var toolResources: JsonField<ToolResources> = JsonMissing.of()
        private var topP: JsonField<Double> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(assistant: Assistant) = apply {
            id = assistant.id
            createdAt = assistant.createdAt
            description = assistant.description
            instructions = assistant.instructions
            metadata = assistant.metadata
            model = assistant.model
            name = assistant.name
            object_ = assistant.object_
            tools = assistant.tools.map { it.toMutableList() }
            responseFormat = assistant.responseFormat
            temperature = assistant.temperature
            toolResources = assistant.toolResources
            topP = assistant.topP
            additionalProperties = assistant.additionalProperties.toMutableMap()
        }

        /** The identifier, which can be referenced in API endpoints. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The Unix timestamp (in seconds) for when the assistant was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /** The description of the assistant. The maximum length is 512 characters. */
        fun description(description: String?) = description(JsonField.ofNullable(description))

        /** Alias for calling [Builder.description] with `description.orElse(null)`. */
        fun description(description: Optional<String>) = description(description.getOrNull())

        /**
         * Sets [Builder.description] to an arbitrary JSON value.
         *
         * You should usually call [Builder.description] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun description(description: JsonField<String>) = apply { this.description = description }

        /**
         * The system instructions that the assistant uses. The maximum length is 256,000
         * characters.
         */
        fun instructions(instructions: String?) = instructions(JsonField.ofNullable(instructions))

        /** Alias for calling [Builder.instructions] with `instructions.orElse(null)`. */
        fun instructions(instructions: Optional<String>) = instructions(instructions.getOrNull())

        /**
         * Sets [Builder.instructions] to an arbitrary JSON value.
         *
         * You should usually call [Builder.instructions] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun instructions(instructions: JsonField<String>) = apply {
            this.instructions = instructions
        }

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard.
         *
         * Keys are strings with a maximum length of 64 characters. Values are strings with a
         * maximum length of 512 characters.
         */
        fun metadata(metadata: Metadata?) = metadata(JsonField.ofNullable(metadata))

        /** Alias for calling [Builder.metadata] with `metadata.orElse(null)`. */
        fun metadata(metadata: Optional<Metadata>) = metadata(metadata.getOrNull())

        /**
         * Sets [Builder.metadata] to an arbitrary JSON value.
         *
         * You should usually call [Builder.metadata] with a well-typed [Metadata] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

        /**
         * ID of the model to use. You can use the
         * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all
         * of your available models, or see our
         * [Model overview](https://platform.openai.com/docs/models) for descriptions of them.
         */
        fun model(model: String) = model(JsonField.of(model))

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(model: JsonField<String>) = apply { this.model = model }

        /** The name of the assistant. The maximum length is 256 characters. */
        fun name(name: String?) = name(JsonField.ofNullable(name))

        /** Alias for calling [Builder.name] with `name.orElse(null)`. */
        fun name(name: Optional<String>) = name(name.getOrNull())

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("assistant")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /**
         * A list of tool enabled on the assistant. There can be a maximum of 128 tools per
         * assistant. Tools can be of types `code_interpreter`, `file_search`, or `function`.
         */
        fun tools(tools: List<AssistantTool>) = tools(JsonField.of(tools))

        /**
         * Sets [Builder.tools] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tools] with a well-typed `List<AssistantTool>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun tools(tools: JsonField<List<AssistantTool>>) = apply {
            this.tools = tools.map { it.toMutableList() }
        }

        /**
         * Adds a single [AssistantTool] to [tools].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTool(tool: AssistantTool) = apply {
            tools =
                (tools ?: JsonField.of(mutableListOf())).also { checkKnown("tools", it).add(tool) }
        }

        /** Alias for calling [addTool] with `AssistantTool.ofCodeInterpreter(codeInterpreter)`. */
        fun addTool(codeInterpreter: CodeInterpreterTool) =
            addTool(AssistantTool.ofCodeInterpreter(codeInterpreter))

        /** Alias for calling [addTool] with `AssistantTool.ofFileSearch(fileSearch)`. */
        fun addTool(fileSearch: FileSearchTool) = addTool(AssistantTool.ofFileSearch(fileSearch))

        /** Alias for calling [addTool] with `AssistantTool.ofFunction(function)`. */
        fun addTool(function: FunctionTool) = addTool(AssistantTool.ofFunction(function))

        /**
         * Alias for calling [addTool] with the following:
         * ```java
         * FunctionTool.builder()
         *     .function(function)
         *     .build()
         * ```
         */
        fun addFunctionTool(function: FunctionDefinition) =
            addTool(FunctionTool.builder().function(function).build())

        /**
         * Specifies the format that the model must output. Compatible with
         * [GPT-4o](https://platform.openai.com/docs/models#gpt-4o), [GPT-4
         * Turbo](https://platform.openai.com/docs/models#gpt-4-turbo-and-gpt-4), and all GPT-3.5
         * Turbo models since `gpt-3.5-turbo-1106`.
         *
         * Setting to `{ "type": "json_schema", "json_schema": {...} }` enables Structured Outputs
         * which ensures the model will match your supplied JSON schema. Learn more in the
         * [Structured Outputs guide](https://platform.openai.com/docs/guides/structured-outputs).
         *
         * Setting to `{ "type": "json_object" }` enables JSON mode, which ensures the message the
         * model generates is valid JSON.
         *
         * **Important:** when using JSON mode, you **must** also instruct the model to produce JSON
         * yourself via a system or user message. Without this, the model may generate an unending
         * stream of whitespace until the generation reaches the token limit, resulting in a
         * long-running and seemingly "stuck" request. Also note that the message content may be
         * partially cut off if `finish_reason="length"`, which indicates the generation exceeded
         * `max_tokens` or the conversation exceeded the max context length.
         */
        fun responseFormat(responseFormat: AssistantResponseFormatOption?) =
            responseFormat(JsonField.ofNullable(responseFormat))

        /** Alias for calling [Builder.responseFormat] with `responseFormat.orElse(null)`. */
        fun responseFormat(responseFormat: Optional<AssistantResponseFormatOption>) =
            responseFormat(responseFormat.getOrNull())

        /**
         * Sets [Builder.responseFormat] to an arbitrary JSON value.
         *
         * You should usually call [Builder.responseFormat] with a well-typed
         * [AssistantResponseFormatOption] value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun responseFormat(responseFormat: JsonField<AssistantResponseFormatOption>) = apply {
            this.responseFormat = responseFormat
        }

        /** Alias for calling [responseFormat] with `AssistantResponseFormatOption.ofAuto()`. */
        fun responseFormatAuto() = responseFormat(AssistantResponseFormatOption.ofAuto())

        /**
         * Alias for calling [responseFormat] with
         * `AssistantResponseFormatOption.ofResponseFormatText(responseFormatText)`.
         */
        fun responseFormat(responseFormatText: ResponseFormatText) =
            responseFormat(AssistantResponseFormatOption.ofResponseFormatText(responseFormatText))

        /**
         * Alias for calling [responseFormat] with
         * `AssistantResponseFormatOption.ofResponseFormatJsonObject(responseFormatJsonObject)`.
         */
        fun responseFormat(responseFormatJsonObject: ResponseFormatJsonObject) =
            responseFormat(
                AssistantResponseFormatOption.ofResponseFormatJsonObject(responseFormatJsonObject)
            )

        /**
         * Alias for calling [responseFormat] with
         * `AssistantResponseFormatOption.ofResponseFormatJsonSchema(responseFormatJsonSchema)`.
         */
        fun responseFormat(responseFormatJsonSchema: ResponseFormatJsonSchema) =
            responseFormat(
                AssistantResponseFormatOption.ofResponseFormatJsonSchema(responseFormatJsonSchema)
            )

        /**
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic.
         */
        fun temperature(temperature: Double?) = temperature(JsonField.ofNullable(temperature))

        /**
         * Alias for [Builder.temperature].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun temperature(temperature: Double) = temperature(temperature as Double?)

        /** Alias for calling [Builder.temperature] with `temperature.orElse(null)`. */
        fun temperature(temperature: Optional<Double>) = temperature(temperature.getOrNull())

        /**
         * Sets [Builder.temperature] to an arbitrary JSON value.
         *
         * You should usually call [Builder.temperature] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun temperature(temperature: JsonField<Double>) = apply { this.temperature = temperature }

        /**
         * A set of resources that are used by the assistant's tools. The resources are specific to
         * the type of tool. For example, the `code_interpreter` tool requires a list of file IDs,
         * while the `file_search` tool requires a list of vector store IDs.
         */
        fun toolResources(toolResources: ToolResources?) =
            toolResources(JsonField.ofNullable(toolResources))

        /** Alias for calling [Builder.toolResources] with `toolResources.orElse(null)`. */
        fun toolResources(toolResources: Optional<ToolResources>) =
            toolResources(toolResources.getOrNull())

        /**
         * Sets [Builder.toolResources] to an arbitrary JSON value.
         *
         * You should usually call [Builder.toolResources] with a well-typed [ToolResources] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun toolResources(toolResources: JsonField<ToolResources>) = apply {
            this.toolResources = toolResources
        }

        /**
         * An alternative to sampling with temperature, called nucleus sampling, where the model
         * considers the results of the tokens with top_p probability mass. So 0.1 means only the
         * tokens comprising the top 10% probability mass are considered.
         *
         * We generally recommend altering this or temperature but not both.
         */
        fun topP(topP: Double?) = topP(JsonField.ofNullable(topP))

        /**
         * Alias for [Builder.topP].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun topP(topP: Double) = topP(topP as Double?)

        /** Alias for calling [Builder.topP] with `topP.orElse(null)`. */
        fun topP(topP: Optional<Double>) = topP(topP.getOrNull())

        /**
         * Sets [Builder.topP] to an arbitrary JSON value.
         *
         * You should usually call [Builder.topP] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun topP(topP: JsonField<Double>) = apply { this.topP = topP }

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
         * Returns an immutable instance of [Assistant].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .description()
         * .instructions()
         * .metadata()
         * .model()
         * .name()
         * .tools()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Assistant =
            Assistant(
                checkRequired("id", id),
                checkRequired("createdAt", createdAt),
                checkRequired("description", description),
                checkRequired("instructions", instructions),
                checkRequired("metadata", metadata),
                checkRequired("model", model),
                checkRequired("name", name),
                object_,
                checkRequired("tools", tools).map { it.toImmutable() },
                responseFormat,
                temperature,
                toolResources,
                topP,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Assistant = apply {
        if (validated) {
            return@apply
        }

        id()
        createdAt()
        description()
        instructions()
        metadata().ifPresent { it.validate() }
        model()
        name()
        _object_().let {
            if (it != JsonValue.from("assistant")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        tools().forEach { it.validate() }
        responseFormat().ifPresent { it.validate() }
        temperature()
        toolResources().ifPresent { it.validate() }
        topP()
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (description.asKnown().isPresent) 1 else 0) +
            (if (instructions.asKnown().isPresent) 1 else 0) +
            (metadata.asKnown().getOrNull()?.validity() ?: 0) +
            (if (model.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            object_.let { if (it == JsonValue.from("assistant")) 1 else 0 } +
            (tools.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (responseFormat.asKnown().getOrNull()?.validity() ?: 0) +
            (if (temperature.asKnown().isPresent) 1 else 0) +
            (toolResources.asKnown().getOrNull()?.validity() ?: 0) +
            (if (topP.asKnown().isPresent) 1 else 0)

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format, and querying for objects via
     * API or the dashboard.
     *
     * Keys are strings with a maximum length of 64 characters. Values are strings with a maximum
     * length of 512 characters.
     */
    class Metadata
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

            return /* spotless:off */ other is Metadata && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "Metadata{additionalProperties=$additionalProperties}"
    }

    /**
     * A set of resources that are used by the assistant's tools. The resources are specific to the
     * type of tool. For example, the `code_interpreter` tool requires a list of file IDs, while the
     * `file_search` tool requires a list of vector store IDs.
     */
    class ToolResources
    private constructor(
        private val codeInterpreter: JsonField<CodeInterpreter>,
        private val fileSearch: JsonField<FileSearch>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("code_interpreter")
            @ExcludeMissing
            codeInterpreter: JsonField<CodeInterpreter> = JsonMissing.of(),
            @JsonProperty("file_search")
            @ExcludeMissing
            fileSearch: JsonField<FileSearch> = JsonMissing.of(),
        ) : this(codeInterpreter, fileSearch, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun codeInterpreter(): Optional<CodeInterpreter> =
            codeInterpreter.getOptional("code_interpreter")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun fileSearch(): Optional<FileSearch> = fileSearch.getOptional("file_search")

        /**
         * Returns the raw JSON value of [codeInterpreter].
         *
         * Unlike [codeInterpreter], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("code_interpreter")
        @ExcludeMissing
        fun _codeInterpreter(): JsonField<CodeInterpreter> = codeInterpreter

        /**
         * Returns the raw JSON value of [fileSearch].
         *
         * Unlike [fileSearch], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("file_search")
        @ExcludeMissing
        fun _fileSearch(): JsonField<FileSearch> = fileSearch

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

            /** Returns a mutable builder for constructing an instance of [ToolResources]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ToolResources]. */
        class Builder internal constructor() {

            private var codeInterpreter: JsonField<CodeInterpreter> = JsonMissing.of()
            private var fileSearch: JsonField<FileSearch> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(toolResources: ToolResources) = apply {
                codeInterpreter = toolResources.codeInterpreter
                fileSearch = toolResources.fileSearch
                additionalProperties = toolResources.additionalProperties.toMutableMap()
            }

            fun codeInterpreter(codeInterpreter: CodeInterpreter) =
                codeInterpreter(JsonField.of(codeInterpreter))

            /**
             * Sets [Builder.codeInterpreter] to an arbitrary JSON value.
             *
             * You should usually call [Builder.codeInterpreter] with a well-typed [CodeInterpreter]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun codeInterpreter(codeInterpreter: JsonField<CodeInterpreter>) = apply {
                this.codeInterpreter = codeInterpreter
            }

            fun fileSearch(fileSearch: FileSearch) = fileSearch(JsonField.of(fileSearch))

            /**
             * Sets [Builder.fileSearch] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fileSearch] with a well-typed [FileSearch] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun fileSearch(fileSearch: JsonField<FileSearch>) = apply {
                this.fileSearch = fileSearch
            }

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
             * Returns an immutable instance of [ToolResources].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): ToolResources =
                ToolResources(codeInterpreter, fileSearch, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): ToolResources = apply {
            if (validated) {
                return@apply
            }

            codeInterpreter().ifPresent { it.validate() }
            fileSearch().ifPresent { it.validate() }
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
            (codeInterpreter.asKnown().getOrNull()?.validity() ?: 0) +
                (fileSearch.asKnown().getOrNull()?.validity() ?: 0)

        class CodeInterpreter
        private constructor(
            private val fileIds: JsonField<List<String>>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("file_ids")
                @ExcludeMissing
                fileIds: JsonField<List<String>> = JsonMissing.of()
            ) : this(fileIds, mutableMapOf())

            /**
             * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs made
             * available to the `code_interpreter`` tool. There can be a maximum of 20 files
             * associated with the tool.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun fileIds(): Optional<List<String>> = fileIds.getOptional("file_ids")

            /**
             * Returns the raw JSON value of [fileIds].
             *
             * Unlike [fileIds], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("file_ids")
            @ExcludeMissing
            fun _fileIds(): JsonField<List<String>> = fileIds

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

                /** Returns a mutable builder for constructing an instance of [CodeInterpreter]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [CodeInterpreter]. */
            class Builder internal constructor() {

                private var fileIds: JsonField<MutableList<String>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(codeInterpreter: CodeInterpreter) = apply {
                    fileIds = codeInterpreter.fileIds.map { it.toMutableList() }
                    additionalProperties = codeInterpreter.additionalProperties.toMutableMap()
                }

                /**
                 * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs made
                 * available to the `code_interpreter`` tool. There can be a maximum of 20 files
                 * associated with the tool.
                 */
                fun fileIds(fileIds: List<String>) = fileIds(JsonField.of(fileIds))

                /**
                 * Sets [Builder.fileIds] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.fileIds] with a well-typed `List<String>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun fileIds(fileIds: JsonField<List<String>>) = apply {
                    this.fileIds = fileIds.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [fileIds].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addFileId(fileId: String) = apply {
                    fileIds =
                        (fileIds ?: JsonField.of(mutableListOf())).also {
                            checkKnown("fileIds", it).add(fileId)
                        }
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
                 * Returns an immutable instance of [CodeInterpreter].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): CodeInterpreter =
                    CodeInterpreter(
                        (fileIds ?: JsonMissing.of()).map { it.toImmutable() },
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): CodeInterpreter = apply {
                if (validated) {
                    return@apply
                }

                fileIds()
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
            @JvmSynthetic internal fun validity(): Int = (fileIds.asKnown().getOrNull()?.size ?: 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is CodeInterpreter && fileIds == other.fileIds && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(fileIds, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "CodeInterpreter{fileIds=$fileIds, additionalProperties=$additionalProperties}"
        }

        class FileSearch
        private constructor(
            private val vectorStoreIds: JsonField<List<String>>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("vector_store_ids")
                @ExcludeMissing
                vectorStoreIds: JsonField<List<String>> = JsonMissing.of()
            ) : this(vectorStoreIds, mutableMapOf())

            /**
             * The ID of the
             * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
             * attached to this assistant. There can be a maximum of 1 vector store attached to the
             * assistant.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun vectorStoreIds(): Optional<List<String>> =
                vectorStoreIds.getOptional("vector_store_ids")

            /**
             * Returns the raw JSON value of [vectorStoreIds].
             *
             * Unlike [vectorStoreIds], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("vector_store_ids")
            @ExcludeMissing
            fun _vectorStoreIds(): JsonField<List<String>> = vectorStoreIds

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

                /** Returns a mutable builder for constructing an instance of [FileSearch]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [FileSearch]. */
            class Builder internal constructor() {

                private var vectorStoreIds: JsonField<MutableList<String>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(fileSearch: FileSearch) = apply {
                    vectorStoreIds = fileSearch.vectorStoreIds.map { it.toMutableList() }
                    additionalProperties = fileSearch.additionalProperties.toMutableMap()
                }

                /**
                 * The ID of the
                 * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
                 * attached to this assistant. There can be a maximum of 1 vector store attached to
                 * the assistant.
                 */
                fun vectorStoreIds(vectorStoreIds: List<String>) =
                    vectorStoreIds(JsonField.of(vectorStoreIds))

                /**
                 * Sets [Builder.vectorStoreIds] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.vectorStoreIds] with a well-typed `List<String>`
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun vectorStoreIds(vectorStoreIds: JsonField<List<String>>) = apply {
                    this.vectorStoreIds = vectorStoreIds.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [vectorStoreIds].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addVectorStoreId(vectorStoreId: String) = apply {
                    vectorStoreIds =
                        (vectorStoreIds ?: JsonField.of(mutableListOf())).also {
                            checkKnown("vectorStoreIds", it).add(vectorStoreId)
                        }
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
                 * Returns an immutable instance of [FileSearch].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): FileSearch =
                    FileSearch(
                        (vectorStoreIds ?: JsonMissing.of()).map { it.toImmutable() },
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): FileSearch = apply {
                if (validated) {
                    return@apply
                }

                vectorStoreIds()
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
            internal fun validity(): Int = (vectorStoreIds.asKnown().getOrNull()?.size ?: 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is FileSearch && vectorStoreIds == other.vectorStoreIds && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(vectorStoreIds, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "FileSearch{vectorStoreIds=$vectorStoreIds, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ToolResources && codeInterpreter == other.codeInterpreter && fileSearch == other.fileSearch && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(codeInterpreter, fileSearch, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ToolResources{codeInterpreter=$codeInterpreter, fileSearch=$fileSearch, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is Assistant && id == other.id && createdAt == other.createdAt && description == other.description && instructions == other.instructions && metadata == other.metadata && model == other.model && name == other.name && object_ == other.object_ && tools == other.tools && responseFormat == other.responseFormat && temperature == other.temperature && toolResources == other.toolResources && topP == other.topP && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, createdAt, description, instructions, metadata, model, name, object_, tools, responseFormat, temperature, toolResources, topP, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Assistant{id=$id, createdAt=$createdAt, description=$description, instructions=$instructions, metadata=$metadata, model=$model, name=$name, object_=$object_, tools=$tools, responseFormat=$responseFormat, temperature=$temperature, toolResources=$toolResources, topP=$topP, additionalProperties=$additionalProperties}"
}
