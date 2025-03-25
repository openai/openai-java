// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.assistants

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
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.FunctionDefinition
import com.openai.models.Metadata
import com.openai.models.ReasoningEffort
import com.openai.models.ResponseFormatJsonObject
import com.openai.models.ResponseFormatJsonSchema
import com.openai.models.ResponseFormatText
import com.openai.models.beta.threads.AssistantResponseFormatOption
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Modifies an assistant. */
class AssistantUpdateParams
private constructor(
    private val assistantId: String,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun assistantId(): String = assistantId

    /**
     * The description of the assistant. The maximum length is 512 characters.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun description(): Optional<String> = body.description()

    /**
     * The system instructions that the assistant uses. The maximum length is 256,000 characters.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun instructions(): Optional<String> = body.instructions()

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
    fun metadata(): Optional<Metadata> = body.metadata()

    /**
     * ID of the model to use. You can use the
     * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all of
     * your available models, or see our [Model overview](https://platform.openai.com/docs/models)
     * for descriptions of them.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun model(): Optional<Model> = body.model()

    /**
     * The name of the assistant. The maximum length is 256 characters.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = body.name()

    /**
     * **o-series models only**
     *
     * Constrains effort on reasoning for
     * [reasoning models](https://platform.openai.com/docs/guides/reasoning). Currently supported
     * values are `low`, `medium`, and `high`. Reducing reasoning effort can result in faster
     * responses and fewer tokens used on reasoning in a response.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun reasoningEffort(): Optional<ReasoningEffort> = body.reasoningEffort()

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
    fun responseFormat(): Optional<AssistantResponseFormatOption> = body.responseFormat()

    /**
     * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
     * output more random, while lower values like 0.2 will make it more focused and deterministic.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun temperature(): Optional<Double> = body.temperature()

    /**
     * A set of resources that are used by the assistant's tools. The resources are specific to the
     * type of tool. For example, the `code_interpreter` tool requires a list of file IDs, while the
     * `file_search` tool requires a list of vector store IDs.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun toolResources(): Optional<ToolResources> = body.toolResources()

    /**
     * A list of tool enabled on the assistant. There can be a maximum of 128 tools per assistant.
     * Tools can be of types `code_interpreter`, `file_search`, or `function`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tools(): Optional<List<AssistantTool>> = body.tools()

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
    fun topP(): Optional<Double> = body.topP()

    /**
     * Returns the raw JSON value of [description].
     *
     * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _description(): JsonField<String> = body._description()

    /**
     * Returns the raw JSON value of [instructions].
     *
     * Unlike [instructions], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _instructions(): JsonField<String> = body._instructions()

    /**
     * Returns the raw JSON value of [metadata].
     *
     * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _metadata(): JsonField<Metadata> = body._metadata()

    /**
     * Returns the raw JSON value of [model].
     *
     * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _model(): JsonField<Model> = body._model()

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _name(): JsonField<String> = body._name()

    /**
     * Returns the raw JSON value of [reasoningEffort].
     *
     * Unlike [reasoningEffort], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _reasoningEffort(): JsonField<ReasoningEffort> = body._reasoningEffort()

    /**
     * Returns the raw JSON value of [responseFormat].
     *
     * Unlike [responseFormat], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _responseFormat(): JsonField<AssistantResponseFormatOption> = body._responseFormat()

    /**
     * Returns the raw JSON value of [temperature].
     *
     * Unlike [temperature], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _temperature(): JsonField<Double> = body._temperature()

    /**
     * Returns the raw JSON value of [toolResources].
     *
     * Unlike [toolResources], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _toolResources(): JsonField<ToolResources> = body._toolResources()

    /**
     * Returns the raw JSON value of [tools].
     *
     * Unlike [tools], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _tools(): JsonField<List<AssistantTool>> = body._tools()

    /**
     * Returns the raw JSON value of [topP].
     *
     * Unlike [topP], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _topP(): JsonField<Double> = body._topP()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [AssistantUpdateParams].
         *
         * The following fields are required:
         * ```java
         * .assistantId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AssistantUpdateParams]. */
    class Builder internal constructor() {

        private var assistantId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(assistantUpdateParams: AssistantUpdateParams) = apply {
            assistantId = assistantUpdateParams.assistantId
            body = assistantUpdateParams.body.toBuilder()
            additionalHeaders = assistantUpdateParams.additionalHeaders.toBuilder()
            additionalQueryParams = assistantUpdateParams.additionalQueryParams.toBuilder()
        }

        fun assistantId(assistantId: String) = apply { this.assistantId = assistantId }

        /** The description of the assistant. The maximum length is 512 characters. */
        fun description(description: String?) = apply { body.description(description) }

        /** Alias for calling [Builder.description] with `description.orElse(null)`. */
        fun description(description: Optional<String>) = description(description.getOrNull())

        /**
         * Sets [Builder.description] to an arbitrary JSON value.
         *
         * You should usually call [Builder.description] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun description(description: JsonField<String>) = apply { body.description(description) }

        /**
         * The system instructions that the assistant uses. The maximum length is 256,000
         * characters.
         */
        fun instructions(instructions: String?) = apply { body.instructions(instructions) }

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
            body.instructions(instructions)
        }

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard.
         *
         * Keys are strings with a maximum length of 64 characters. Values are strings with a
         * maximum length of 512 characters.
         */
        fun metadata(metadata: Metadata?) = apply { body.metadata(metadata) }

        /** Alias for calling [Builder.metadata] with `metadata.orElse(null)`. */
        fun metadata(metadata: Optional<Metadata>) = metadata(metadata.getOrNull())

        /**
         * Sets [Builder.metadata] to an arbitrary JSON value.
         *
         * You should usually call [Builder.metadata] with a well-typed [Metadata] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun metadata(metadata: JsonField<Metadata>) = apply { body.metadata(metadata) }

        /**
         * ID of the model to use. You can use the
         * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all
         * of your available models, or see our
         * [Model overview](https://platform.openai.com/docs/models) for descriptions of them.
         */
        fun model(model: Model) = apply { body.model(model) }

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [Model] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(model: JsonField<Model>) = apply { body.model(model) }

        /**
         * Sets [model] to an arbitrary [String].
         *
         * You should usually call [model] with a well-typed [Model] constant instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(value: String) = apply { body.model(value) }

        /** The name of the assistant. The maximum length is 256 characters. */
        fun name(name: String?) = apply { body.name(name) }

        /** Alias for calling [Builder.name] with `name.orElse(null)`. */
        fun name(name: Optional<String>) = name(name.getOrNull())

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { body.name(name) }

        /**
         * **o-series models only**
         *
         * Constrains effort on reasoning for
         * [reasoning models](https://platform.openai.com/docs/guides/reasoning). Currently
         * supported values are `low`, `medium`, and `high`. Reducing reasoning effort can result in
         * faster responses and fewer tokens used on reasoning in a response.
         */
        fun reasoningEffort(reasoningEffort: ReasoningEffort?) = apply {
            body.reasoningEffort(reasoningEffort)
        }

        /** Alias for calling [Builder.reasoningEffort] with `reasoningEffort.orElse(null)`. */
        fun reasoningEffort(reasoningEffort: Optional<ReasoningEffort>) =
            reasoningEffort(reasoningEffort.getOrNull())

        /**
         * Sets [Builder.reasoningEffort] to an arbitrary JSON value.
         *
         * You should usually call [Builder.reasoningEffort] with a well-typed [ReasoningEffort]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun reasoningEffort(reasoningEffort: JsonField<ReasoningEffort>) = apply {
            body.reasoningEffort(reasoningEffort)
        }

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
        fun responseFormat(responseFormat: AssistantResponseFormatOption?) = apply {
            body.responseFormat(responseFormat)
        }

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
            body.responseFormat(responseFormat)
        }

        /**
         * Alias for calling [responseFormat] with `AssistantResponseFormatOption.ofJsonValue()`.
         */
        fun responseFormatJsonValue() = apply { body.responseFormatJsonValue() }

        /**
         * Alias for calling [responseFormat] with
         * `AssistantResponseFormatOption.ofResponseFormatText(responseFormatText)`.
         */
        fun responseFormat(responseFormatText: ResponseFormatText) = apply {
            body.responseFormat(responseFormatText)
        }

        /**
         * Alias for calling [responseFormat] with
         * `AssistantResponseFormatOption.ofResponseFormatJsonObject(responseFormatJsonObject)`.
         */
        fun responseFormat(responseFormatJsonObject: ResponseFormatJsonObject) = apply {
            body.responseFormat(responseFormatJsonObject)
        }

        /**
         * Alias for calling [responseFormat] with
         * `AssistantResponseFormatOption.ofResponseFormatJsonSchema(responseFormatJsonSchema)`.
         */
        fun responseFormat(responseFormatJsonSchema: ResponseFormatJsonSchema) = apply {
            body.responseFormat(responseFormatJsonSchema)
        }

        /**
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic.
         */
        fun temperature(temperature: Double?) = apply { body.temperature(temperature) }

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
        fun temperature(temperature: JsonField<Double>) = apply { body.temperature(temperature) }

        /**
         * A set of resources that are used by the assistant's tools. The resources are specific to
         * the type of tool. For example, the `code_interpreter` tool requires a list of file IDs,
         * while the `file_search` tool requires a list of vector store IDs.
         */
        fun toolResources(toolResources: ToolResources?) = apply {
            body.toolResources(toolResources)
        }

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
            body.toolResources(toolResources)
        }

        /**
         * A list of tool enabled on the assistant. There can be a maximum of 128 tools per
         * assistant. Tools can be of types `code_interpreter`, `file_search`, or `function`.
         */
        fun tools(tools: List<AssistantTool>) = apply { body.tools(tools) }

        /**
         * Sets [Builder.tools] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tools] with a well-typed `List<AssistantTool>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun tools(tools: JsonField<List<AssistantTool>>) = apply { body.tools(tools) }

        /**
         * Adds a single [AssistantTool] to [tools].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTool(tool: AssistantTool) = apply { body.addTool(tool) }

        /** Alias for calling [addTool] with `AssistantTool.ofCodeInterpreter(codeInterpreter)`. */
        fun addTool(codeInterpreter: CodeInterpreterTool) = apply { body.addTool(codeInterpreter) }

        /** Alias for calling [addTool] with `AssistantTool.ofFileSearch(fileSearch)`. */
        fun addTool(fileSearch: FileSearchTool) = apply { body.addTool(fileSearch) }

        /** Alias for calling [addTool] with `AssistantTool.ofFunction(function)`. */
        fun addTool(function: FunctionTool) = apply { body.addTool(function) }

        /**
         * Alias for calling [addTool] with the following:
         * ```java
         * FunctionTool.builder()
         *     .function(function)
         *     .build()
         * ```
         */
        fun addFunctionTool(function: FunctionDefinition) = apply { body.addFunctionTool(function) }

        /**
         * An alternative to sampling with temperature, called nucleus sampling, where the model
         * considers the results of the tokens with top_p probability mass. So 0.1 means only the
         * tokens comprising the top 10% probability mass are considered.
         *
         * We generally recommend altering this or temperature but not both.
         */
        fun topP(topP: Double?) = apply { body.topP(topP) }

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
        fun topP(topP: JsonField<Double>) = apply { body.topP(topP) }

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
         * Returns an immutable instance of [AssistantUpdateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .assistantId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AssistantUpdateParams =
            AssistantUpdateParams(
                checkRequired("assistantId", assistantId),
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    @JvmSynthetic internal fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> assistantId
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    private constructor(
        private val description: JsonField<String>,
        private val instructions: JsonField<String>,
        private val metadata: JsonField<Metadata>,
        private val model: JsonField<Model>,
        private val name: JsonField<String>,
        private val reasoningEffort: JsonField<ReasoningEffort>,
        private val responseFormat: JsonField<AssistantResponseFormatOption>,
        private val temperature: JsonField<Double>,
        private val toolResources: JsonField<ToolResources>,
        private val tools: JsonField<List<AssistantTool>>,
        private val topP: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("description")
            @ExcludeMissing
            description: JsonField<String> = JsonMissing.of(),
            @JsonProperty("instructions")
            @ExcludeMissing
            instructions: JsonField<String> = JsonMissing.of(),
            @JsonProperty("metadata")
            @ExcludeMissing
            metadata: JsonField<Metadata> = JsonMissing.of(),
            @JsonProperty("model") @ExcludeMissing model: JsonField<Model> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("reasoning_effort")
            @ExcludeMissing
            reasoningEffort: JsonField<ReasoningEffort> = JsonMissing.of(),
            @JsonProperty("response_format")
            @ExcludeMissing
            responseFormat: JsonField<AssistantResponseFormatOption> = JsonMissing.of(),
            @JsonProperty("temperature")
            @ExcludeMissing
            temperature: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("tool_resources")
            @ExcludeMissing
            toolResources: JsonField<ToolResources> = JsonMissing.of(),
            @JsonProperty("tools")
            @ExcludeMissing
            tools: JsonField<List<AssistantTool>> = JsonMissing.of(),
            @JsonProperty("top_p") @ExcludeMissing topP: JsonField<Double> = JsonMissing.of(),
        ) : this(
            description,
            instructions,
            metadata,
            model,
            name,
            reasoningEffort,
            responseFormat,
            temperature,
            toolResources,
            tools,
            topP,
            mutableMapOf(),
        )

        /**
         * The description of the assistant. The maximum length is 512 characters.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun description(): Optional<String> =
            Optional.ofNullable(description.getNullable("description"))

        /**
         * The system instructions that the assistant uses. The maximum length is 256,000
         * characters.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun instructions(): Optional<String> =
            Optional.ofNullable(instructions.getNullable("instructions"))

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard.
         *
         * Keys are strings with a maximum length of 64 characters. Values are strings with a
         * maximum length of 512 characters.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun metadata(): Optional<Metadata> = Optional.ofNullable(metadata.getNullable("metadata"))

        /**
         * ID of the model to use. You can use the
         * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all
         * of your available models, or see our
         * [Model overview](https://platform.openai.com/docs/models) for descriptions of them.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun model(): Optional<Model> = Optional.ofNullable(model.getNullable("model"))

        /**
         * The name of the assistant. The maximum length is 256 characters.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

        /**
         * **o-series models only**
         *
         * Constrains effort on reasoning for
         * [reasoning models](https://platform.openai.com/docs/guides/reasoning). Currently
         * supported values are `low`, `medium`, and `high`. Reducing reasoning effort can result in
         * faster responses and fewer tokens used on reasoning in a response.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun reasoningEffort(): Optional<ReasoningEffort> =
            Optional.ofNullable(reasoningEffort.getNullable("reasoning_effort"))

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
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun responseFormat(): Optional<AssistantResponseFormatOption> =
            Optional.ofNullable(responseFormat.getNullable("response_format"))

        /**
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun temperature(): Optional<Double> =
            Optional.ofNullable(temperature.getNullable("temperature"))

        /**
         * A set of resources that are used by the assistant's tools. The resources are specific to
         * the type of tool. For example, the `code_interpreter` tool requires a list of file IDs,
         * while the `file_search` tool requires a list of vector store IDs.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun toolResources(): Optional<ToolResources> =
            Optional.ofNullable(toolResources.getNullable("tool_resources"))

        /**
         * A list of tool enabled on the assistant. There can be a maximum of 128 tools per
         * assistant. Tools can be of types `code_interpreter`, `file_search`, or `function`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun tools(): Optional<List<AssistantTool>> = Optional.ofNullable(tools.getNullable("tools"))

        /**
         * An alternative to sampling with temperature, called nucleus sampling, where the model
         * considers the results of the tokens with top_p probability mass. So 0.1 means only the
         * tokens comprising the top 10% probability mass are considered.
         *
         * We generally recommend altering this or temperature but not both.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun topP(): Optional<Double> = Optional.ofNullable(topP.getNullable("top_p"))

        /**
         * Returns the raw JSON value of [description].
         *
         * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

        /**
         * Returns the raw JSON value of [instructions].
         *
         * Unlike [instructions], this method doesn't throw if the JSON field has an unexpected
         * type.
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
        @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<Model> = model

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [reasoningEffort].
         *
         * Unlike [reasoningEffort], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("reasoning_effort")
        @ExcludeMissing
        fun _reasoningEffort(): JsonField<ReasoningEffort> = reasoningEffort

        /**
         * Returns the raw JSON value of [responseFormat].
         *
         * Unlike [responseFormat], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("response_format")
        @ExcludeMissing
        fun _responseFormat(): JsonField<AssistantResponseFormatOption> = responseFormat

        /**
         * Returns the raw JSON value of [temperature].
         *
         * Unlike [temperature], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("temperature")
        @ExcludeMissing
        fun _temperature(): JsonField<Double> = temperature

        /**
         * Returns the raw JSON value of [toolResources].
         *
         * Unlike [toolResources], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("tool_resources")
        @ExcludeMissing
        fun _toolResources(): JsonField<ToolResources> = toolResources

        /**
         * Returns the raw JSON value of [tools].
         *
         * Unlike [tools], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tools") @ExcludeMissing fun _tools(): JsonField<List<AssistantTool>> = tools

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

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var description: JsonField<String> = JsonMissing.of()
            private var instructions: JsonField<String> = JsonMissing.of()
            private var metadata: JsonField<Metadata> = JsonMissing.of()
            private var model: JsonField<Model> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var reasoningEffort: JsonField<ReasoningEffort> = JsonMissing.of()
            private var responseFormat: JsonField<AssistantResponseFormatOption> = JsonMissing.of()
            private var temperature: JsonField<Double> = JsonMissing.of()
            private var toolResources: JsonField<ToolResources> = JsonMissing.of()
            private var tools: JsonField<MutableList<AssistantTool>>? = null
            private var topP: JsonField<Double> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                description = body.description
                instructions = body.instructions
                metadata = body.metadata
                model = body.model
                name = body.name
                reasoningEffort = body.reasoningEffort
                responseFormat = body.responseFormat
                temperature = body.temperature
                toolResources = body.toolResources
                tools = body.tools.map { it.toMutableList() }
                topP = body.topP
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** The description of the assistant. The maximum length is 512 characters. */
            fun description(description: String?) = description(JsonField.ofNullable(description))

            /** Alias for calling [Builder.description] with `description.orElse(null)`. */
            fun description(description: Optional<String>) = description(description.getOrNull())

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

            /**
             * The system instructions that the assistant uses. The maximum length is 256,000
             * characters.
             */
            fun instructions(instructions: String?) =
                instructions(JsonField.ofNullable(instructions))

            /** Alias for calling [Builder.instructions] with `instructions.orElse(null)`. */
            fun instructions(instructions: Optional<String>) =
                instructions(instructions.getOrNull())

            /**
             * Sets [Builder.instructions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.instructions] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun instructions(instructions: JsonField<String>) = apply {
                this.instructions = instructions
            }

            /**
             * Set of 16 key-value pairs that can be attached to an object. This can be useful for
             * storing additional information about the object in a structured format, and querying
             * for objects via API or the dashboard.
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
             * You should usually call [Builder.metadata] with a well-typed [Metadata] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

            /**
             * ID of the model to use. You can use the
             * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see
             * all of your available models, or see our
             * [Model overview](https://platform.openai.com/docs/models) for descriptions of them.
             */
            fun model(model: Model) = model(JsonField.of(model))

            /**
             * Sets [Builder.model] to an arbitrary JSON value.
             *
             * You should usually call [Builder.model] with a well-typed [Model] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun model(model: JsonField<Model>) = apply { this.model = model }

            /**
             * Sets [model] to an arbitrary [String].
             *
             * You should usually call [model] with a well-typed [Model] constant instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun model(value: String) = model(Model.of(value))

            /** The name of the assistant. The maximum length is 256 characters. */
            fun name(name: String?) = name(JsonField.ofNullable(name))

            /** Alias for calling [Builder.name] with `name.orElse(null)`. */
            fun name(name: Optional<String>) = name(name.getOrNull())

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /**
             * **o-series models only**
             *
             * Constrains effort on reasoning for
             * [reasoning models](https://platform.openai.com/docs/guides/reasoning). Currently
             * supported values are `low`, `medium`, and `high`. Reducing reasoning effort can
             * result in faster responses and fewer tokens used on reasoning in a response.
             */
            fun reasoningEffort(reasoningEffort: ReasoningEffort?) =
                reasoningEffort(JsonField.ofNullable(reasoningEffort))

            /** Alias for calling [Builder.reasoningEffort] with `reasoningEffort.orElse(null)`. */
            fun reasoningEffort(reasoningEffort: Optional<ReasoningEffort>) =
                reasoningEffort(reasoningEffort.getOrNull())

            /**
             * Sets [Builder.reasoningEffort] to an arbitrary JSON value.
             *
             * You should usually call [Builder.reasoningEffort] with a well-typed [ReasoningEffort]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun reasoningEffort(reasoningEffort: JsonField<ReasoningEffort>) = apply {
                this.reasoningEffort = reasoningEffort
            }

            /**
             * Specifies the format that the model must output. Compatible with
             * [GPT-4o](https://platform.openai.com/docs/models#gpt-4o), [GPT-4
             * Turbo](https://platform.openai.com/docs/models#gpt-4-turbo-and-gpt-4), and all
             * GPT-3.5 Turbo models since `gpt-3.5-turbo-1106`.
             *
             * Setting to `{ "type": "json_schema", "json_schema": {...} }` enables Structured
             * Outputs which ensures the model will match your supplied JSON schema. Learn more in
             * the
             * [Structured Outputs guide](https://platform.openai.com/docs/guides/structured-outputs).
             *
             * Setting to `{ "type": "json_object" }` enables JSON mode, which ensures the message
             * the model generates is valid JSON.
             *
             * **Important:** when using JSON mode, you **must** also instruct the model to produce
             * JSON yourself via a system or user message. Without this, the model may generate an
             * unending stream of whitespace until the generation reaches the token limit, resulting
             * in a long-running and seemingly "stuck" request. Also note that the message content
             * may be partially cut off if `finish_reason="length"`, which indicates the generation
             * exceeded `max_tokens` or the conversation exceeded the max context length.
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
             * [AssistantResponseFormatOption] value instead. This method is primarily for setting
             * the field to an undocumented or not yet supported value.
             */
            fun responseFormat(responseFormat: JsonField<AssistantResponseFormatOption>) = apply {
                this.responseFormat = responseFormat
            }

            /**
             * Alias for calling [responseFormat] with
             * `AssistantResponseFormatOption.ofJsonValue()`.
             */
            fun responseFormatJsonValue() =
                responseFormat(AssistantResponseFormatOption.ofJsonValue())

            /**
             * Alias for calling [responseFormat] with
             * `AssistantResponseFormatOption.ofResponseFormatText(responseFormatText)`.
             */
            fun responseFormat(responseFormatText: ResponseFormatText) =
                responseFormat(
                    AssistantResponseFormatOption.ofResponseFormatText(responseFormatText)
                )

            /**
             * Alias for calling [responseFormat] with
             * `AssistantResponseFormatOption.ofResponseFormatJsonObject(responseFormatJsonObject)`.
             */
            fun responseFormat(responseFormatJsonObject: ResponseFormatJsonObject) =
                responseFormat(
                    AssistantResponseFormatOption.ofResponseFormatJsonObject(
                        responseFormatJsonObject
                    )
                )

            /**
             * Alias for calling [responseFormat] with
             * `AssistantResponseFormatOption.ofResponseFormatJsonSchema(responseFormatJsonSchema)`.
             */
            fun responseFormat(responseFormatJsonSchema: ResponseFormatJsonSchema) =
                responseFormat(
                    AssistantResponseFormatOption.ofResponseFormatJsonSchema(
                        responseFormatJsonSchema
                    )
                )

            /**
             * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make
             * the output more random, while lower values like 0.2 will make it more focused and
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
             * You should usually call [Builder.temperature] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun temperature(temperature: JsonField<Double>) = apply {
                this.temperature = temperature
            }

            /**
             * A set of resources that are used by the assistant's tools. The resources are specific
             * to the type of tool. For example, the `code_interpreter` tool requires a list of file
             * IDs, while the `file_search` tool requires a list of vector store IDs.
             */
            fun toolResources(toolResources: ToolResources?) =
                toolResources(JsonField.ofNullable(toolResources))

            /** Alias for calling [Builder.toolResources] with `toolResources.orElse(null)`. */
            fun toolResources(toolResources: Optional<ToolResources>) =
                toolResources(toolResources.getOrNull())

            /**
             * Sets [Builder.toolResources] to an arbitrary JSON value.
             *
             * You should usually call [Builder.toolResources] with a well-typed [ToolResources]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun toolResources(toolResources: JsonField<ToolResources>) = apply {
                this.toolResources = toolResources
            }

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
                    (tools ?: JsonField.of(mutableListOf())).also {
                        checkKnown("tools", it).add(tool)
                    }
            }

            /**
             * Alias for calling [addTool] with `AssistantTool.ofCodeInterpreter(codeInterpreter)`.
             */
            fun addTool(codeInterpreter: CodeInterpreterTool) =
                addTool(AssistantTool.ofCodeInterpreter(codeInterpreter))

            /** Alias for calling [addTool] with `AssistantTool.ofFileSearch(fileSearch)`. */
            fun addTool(fileSearch: FileSearchTool) =
                addTool(AssistantTool.ofFileSearch(fileSearch))

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
             * An alternative to sampling with temperature, called nucleus sampling, where the model
             * considers the results of the tokens with top_p probability mass. So 0.1 means only
             * the tokens comprising the top 10% probability mass are considered.
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
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Body =
                Body(
                    description,
                    instructions,
                    metadata,
                    model,
                    name,
                    reasoningEffort,
                    responseFormat,
                    temperature,
                    toolResources,
                    (tools ?: JsonMissing.of()).map { it.toImmutable() },
                    topP,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            description()
            instructions()
            metadata().ifPresent { it.validate() }
            model()
            name()
            reasoningEffort()
            responseFormat().ifPresent { it.validate() }
            temperature()
            toolResources().ifPresent { it.validate() }
            tools().ifPresent { it.forEach { it.validate() } }
            topP()
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && description == other.description && instructions == other.instructions && metadata == other.metadata && model == other.model && name == other.name && reasoningEffort == other.reasoningEffort && responseFormat == other.responseFormat && temperature == other.temperature && toolResources == other.toolResources && tools == other.tools && topP == other.topP && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(description, instructions, metadata, model, name, reasoningEffort, responseFormat, temperature, toolResources, tools, topP, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{description=$description, instructions=$instructions, metadata=$metadata, model=$model, name=$name, reasoningEffort=$reasoningEffort, responseFormat=$responseFormat, temperature=$temperature, toolResources=$toolResources, tools=$tools, topP=$topP, additionalProperties=$additionalProperties}"
    }

    /**
     * ID of the model to use. You can use the
     * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all of
     * your available models, or see our [Model overview](https://platform.openai.com/docs/models)
     * for descriptions of them.
     */
    class Model @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val O3_MINI = of("o3-mini")

            @JvmField val O3_MINI_2025_01_31 = of("o3-mini-2025-01-31")

            @JvmField val O1 = of("o1")

            @JvmField val O1_2024_12_17 = of("o1-2024-12-17")

            @JvmField val GPT_4O = of("gpt-4o")

            @JvmField val GPT_4O_2024_11_20 = of("gpt-4o-2024-11-20")

            @JvmField val GPT_4O_2024_08_06 = of("gpt-4o-2024-08-06")

            @JvmField val GPT_4O_2024_05_13 = of("gpt-4o-2024-05-13")

            @JvmField val GPT_4O_MINI = of("gpt-4o-mini")

            @JvmField val GPT_4O_MINI_2024_07_18 = of("gpt-4o-mini-2024-07-18")

            @JvmField val GPT_4_5_PREVIEW = of("gpt-4.5-preview")

            @JvmField val GPT_4_5_PREVIEW_2025_02_27 = of("gpt-4.5-preview-2025-02-27")

            @JvmField val GPT_4_TURBO = of("gpt-4-turbo")

            @JvmField val GPT_4_TURBO_2024_04_09 = of("gpt-4-turbo-2024-04-09")

            @JvmField val GPT_4_0125_PREVIEW = of("gpt-4-0125-preview")

            @JvmField val GPT_4_TURBO_PREVIEW = of("gpt-4-turbo-preview")

            @JvmField val GPT_4_1106_PREVIEW = of("gpt-4-1106-preview")

            @JvmField val GPT_4_VISION_PREVIEW = of("gpt-4-vision-preview")

            @JvmField val GPT_4 = of("gpt-4")

            @JvmField val GPT_4_0314 = of("gpt-4-0314")

            @JvmField val GPT_4_0613 = of("gpt-4-0613")

            @JvmField val GPT_4_32K = of("gpt-4-32k")

            @JvmField val GPT_4_32K_0314 = of("gpt-4-32k-0314")

            @JvmField val GPT_4_32K_0613 = of("gpt-4-32k-0613")

            @JvmField val GPT_3_5_TURBO = of("gpt-3.5-turbo")

            @JvmField val GPT_3_5_TURBO_16K = of("gpt-3.5-turbo-16k")

            @JvmField val GPT_3_5_TURBO_0613 = of("gpt-3.5-turbo-0613")

            @JvmField val GPT_3_5_TURBO_1106 = of("gpt-3.5-turbo-1106")

            @JvmField val GPT_3_5_TURBO_0125 = of("gpt-3.5-turbo-0125")

            @JvmField val GPT_3_5_TURBO_16K_0613 = of("gpt-3.5-turbo-16k-0613")

            @JvmStatic fun of(value: String) = Model(JsonField.of(value))
        }

        /** An enum containing [Model]'s known values. */
        enum class Known {
            O3_MINI,
            O3_MINI_2025_01_31,
            O1,
            O1_2024_12_17,
            GPT_4O,
            GPT_4O_2024_11_20,
            GPT_4O_2024_08_06,
            GPT_4O_2024_05_13,
            GPT_4O_MINI,
            GPT_4O_MINI_2024_07_18,
            GPT_4_5_PREVIEW,
            GPT_4_5_PREVIEW_2025_02_27,
            GPT_4_TURBO,
            GPT_4_TURBO_2024_04_09,
            GPT_4_0125_PREVIEW,
            GPT_4_TURBO_PREVIEW,
            GPT_4_1106_PREVIEW,
            GPT_4_VISION_PREVIEW,
            GPT_4,
            GPT_4_0314,
            GPT_4_0613,
            GPT_4_32K,
            GPT_4_32K_0314,
            GPT_4_32K_0613,
            GPT_3_5_TURBO,
            GPT_3_5_TURBO_16K,
            GPT_3_5_TURBO_0613,
            GPT_3_5_TURBO_1106,
            GPT_3_5_TURBO_0125,
            GPT_3_5_TURBO_16K_0613,
        }

        /**
         * An enum containing [Model]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Model] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            O3_MINI,
            O3_MINI_2025_01_31,
            O1,
            O1_2024_12_17,
            GPT_4O,
            GPT_4O_2024_11_20,
            GPT_4O_2024_08_06,
            GPT_4O_2024_05_13,
            GPT_4O_MINI,
            GPT_4O_MINI_2024_07_18,
            GPT_4_5_PREVIEW,
            GPT_4_5_PREVIEW_2025_02_27,
            GPT_4_TURBO,
            GPT_4_TURBO_2024_04_09,
            GPT_4_0125_PREVIEW,
            GPT_4_TURBO_PREVIEW,
            GPT_4_1106_PREVIEW,
            GPT_4_VISION_PREVIEW,
            GPT_4,
            GPT_4_0314,
            GPT_4_0613,
            GPT_4_32K,
            GPT_4_32K_0314,
            GPT_4_32K_0613,
            GPT_3_5_TURBO,
            GPT_3_5_TURBO_16K,
            GPT_3_5_TURBO_0613,
            GPT_3_5_TURBO_1106,
            GPT_3_5_TURBO_0125,
            GPT_3_5_TURBO_16K_0613,
            /** An enum member indicating that [Model] was instantiated with an unknown value. */
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
                O3_MINI -> Value.O3_MINI
                O3_MINI_2025_01_31 -> Value.O3_MINI_2025_01_31
                O1 -> Value.O1
                O1_2024_12_17 -> Value.O1_2024_12_17
                GPT_4O -> Value.GPT_4O
                GPT_4O_2024_11_20 -> Value.GPT_4O_2024_11_20
                GPT_4O_2024_08_06 -> Value.GPT_4O_2024_08_06
                GPT_4O_2024_05_13 -> Value.GPT_4O_2024_05_13
                GPT_4O_MINI -> Value.GPT_4O_MINI
                GPT_4O_MINI_2024_07_18 -> Value.GPT_4O_MINI_2024_07_18
                GPT_4_5_PREVIEW -> Value.GPT_4_5_PREVIEW
                GPT_4_5_PREVIEW_2025_02_27 -> Value.GPT_4_5_PREVIEW_2025_02_27
                GPT_4_TURBO -> Value.GPT_4_TURBO
                GPT_4_TURBO_2024_04_09 -> Value.GPT_4_TURBO_2024_04_09
                GPT_4_0125_PREVIEW -> Value.GPT_4_0125_PREVIEW
                GPT_4_TURBO_PREVIEW -> Value.GPT_4_TURBO_PREVIEW
                GPT_4_1106_PREVIEW -> Value.GPT_4_1106_PREVIEW
                GPT_4_VISION_PREVIEW -> Value.GPT_4_VISION_PREVIEW
                GPT_4 -> Value.GPT_4
                GPT_4_0314 -> Value.GPT_4_0314
                GPT_4_0613 -> Value.GPT_4_0613
                GPT_4_32K -> Value.GPT_4_32K
                GPT_4_32K_0314 -> Value.GPT_4_32K_0314
                GPT_4_32K_0613 -> Value.GPT_4_32K_0613
                GPT_3_5_TURBO -> Value.GPT_3_5_TURBO
                GPT_3_5_TURBO_16K -> Value.GPT_3_5_TURBO_16K
                GPT_3_5_TURBO_0613 -> Value.GPT_3_5_TURBO_0613
                GPT_3_5_TURBO_1106 -> Value.GPT_3_5_TURBO_1106
                GPT_3_5_TURBO_0125 -> Value.GPT_3_5_TURBO_0125
                GPT_3_5_TURBO_16K_0613 -> Value.GPT_3_5_TURBO_16K_0613
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
                O3_MINI -> Known.O3_MINI
                O3_MINI_2025_01_31 -> Known.O3_MINI_2025_01_31
                O1 -> Known.O1
                O1_2024_12_17 -> Known.O1_2024_12_17
                GPT_4O -> Known.GPT_4O
                GPT_4O_2024_11_20 -> Known.GPT_4O_2024_11_20
                GPT_4O_2024_08_06 -> Known.GPT_4O_2024_08_06
                GPT_4O_2024_05_13 -> Known.GPT_4O_2024_05_13
                GPT_4O_MINI -> Known.GPT_4O_MINI
                GPT_4O_MINI_2024_07_18 -> Known.GPT_4O_MINI_2024_07_18
                GPT_4_5_PREVIEW -> Known.GPT_4_5_PREVIEW
                GPT_4_5_PREVIEW_2025_02_27 -> Known.GPT_4_5_PREVIEW_2025_02_27
                GPT_4_TURBO -> Known.GPT_4_TURBO
                GPT_4_TURBO_2024_04_09 -> Known.GPT_4_TURBO_2024_04_09
                GPT_4_0125_PREVIEW -> Known.GPT_4_0125_PREVIEW
                GPT_4_TURBO_PREVIEW -> Known.GPT_4_TURBO_PREVIEW
                GPT_4_1106_PREVIEW -> Known.GPT_4_1106_PREVIEW
                GPT_4_VISION_PREVIEW -> Known.GPT_4_VISION_PREVIEW
                GPT_4 -> Known.GPT_4
                GPT_4_0314 -> Known.GPT_4_0314
                GPT_4_0613 -> Known.GPT_4_0613
                GPT_4_32K -> Known.GPT_4_32K
                GPT_4_32K_0314 -> Known.GPT_4_32K_0314
                GPT_4_32K_0613 -> Known.GPT_4_32K_0613
                GPT_3_5_TURBO -> Known.GPT_3_5_TURBO
                GPT_3_5_TURBO_16K -> Known.GPT_3_5_TURBO_16K
                GPT_3_5_TURBO_0613 -> Known.GPT_3_5_TURBO_0613
                GPT_3_5_TURBO_1106 -> Known.GPT_3_5_TURBO_1106
                GPT_3_5_TURBO_0125 -> Known.GPT_3_5_TURBO_0125
                GPT_3_5_TURBO_16K_0613 -> Known.GPT_3_5_TURBO_16K_0613
                else -> throw OpenAIInvalidDataException("Unknown Model: $value")
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Model && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
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
            Optional.ofNullable(codeInterpreter.getNullable("code_interpreter"))

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun fileSearch(): Optional<FileSearch> =
            Optional.ofNullable(fileSearch.getNullable("file_search"))

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
             * Overrides the list of [file](https://platform.openai.com/docs/api-reference/files)
             * IDs made available to the `code_interpreter` tool. There can be a maximum of 20 files
             * associated with the tool.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun fileIds(): Optional<List<String>> =
                Optional.ofNullable(fileIds.getNullable("file_ids"))

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
                 * Overrides the list of
                 * [file](https://platform.openai.com/docs/api-reference/files) IDs made available
                 * to the `code_interpreter` tool. There can be a maximum of 20 files associated
                 * with the tool.
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
             * Overrides the
             * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
             * attached to this assistant. There can be a maximum of 1 vector store attached to the
             * assistant.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun vectorStoreIds(): Optional<List<String>> =
                Optional.ofNullable(vectorStoreIds.getNullable("vector_store_ids"))

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
                 * Overrides the
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

        return /* spotless:off */ other is AssistantUpdateParams && assistantId == other.assistantId && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(assistantId, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "AssistantUpdateParams{assistantId=$assistantId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
