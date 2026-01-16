// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses.inputtokens

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
import com.openai.core.checkKnown
import com.openai.core.getOrThrow
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.Reasoning
import com.openai.models.ResponseFormatJsonObject
import com.openai.models.ResponseFormatText
import com.openai.models.responses.ApplyPatchTool
import com.openai.models.responses.ComputerTool
import com.openai.models.responses.CustomTool
import com.openai.models.responses.FileSearchTool
import com.openai.models.responses.FunctionShellTool
import com.openai.models.responses.FunctionTool
import com.openai.models.responses.ResponseConversationParam
import com.openai.models.responses.ResponseFormatTextConfig
import com.openai.models.responses.ResponseFormatTextJsonSchemaConfig
import com.openai.models.responses.ResponseInputItem
import com.openai.models.responses.Tool
import com.openai.models.responses.ToolChoiceAllowed
import com.openai.models.responses.ToolChoiceApplyPatch
import com.openai.models.responses.ToolChoiceCustom
import com.openai.models.responses.ToolChoiceFunction
import com.openai.models.responses.ToolChoiceMcp
import com.openai.models.responses.ToolChoiceOptions
import com.openai.models.responses.ToolChoiceShell
import com.openai.models.responses.ToolChoiceTypes
import com.openai.models.responses.WebSearchPreviewTool
import com.openai.models.responses.WebSearchTool
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Get input token counts */
class InputTokenCountParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The conversation that this response belongs to. Items from this conversation are prepended to
     * `input_items` for this response request. Input items and output items from this response are
     * automatically added to this conversation after this response completes.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun conversation(): Optional<Conversation> = body.conversation()

    /**
     * Text, image, or file inputs to the model, used to generate a response
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun input(): Optional<Input> = body.input()

    /**
     * A system (or developer) message inserted into the model's context. When used along with
     * `previous_response_id`, the instructions from a previous response will not be carried over to
     * the next response. This makes it simple to swap out system (or developer) messages in new
     * responses.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun instructions(): Optional<String> = body.instructions()

    /**
     * Model ID used to generate the response, like `gpt-4o` or `o3`. OpenAI offers a wide range of
     * models with different capabilities, performance characteristics, and price points. Refer to
     * the [model guide](https://platform.openai.com/docs/models) to browse and compare available
     * models.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun model(): Optional<String> = body.model()

    /**
     * Whether to allow the model to run tool calls in parallel.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun parallelToolCalls(): Optional<Boolean> = body.parallelToolCalls()

    /**
     * The unique ID of the previous response to the model. Use this to create multi-turn
     * conversations. Learn more about
     * [conversation state](https://platform.openai.com/docs/guides/conversation-state). Cannot be
     * used in conjunction with `conversation`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun previousResponseId(): Optional<String> = body.previousResponseId()

    /**
     * **gpt-5 and o-series models only** Configuration options for
     * [reasoning models](https://platform.openai.com/docs/guides/reasoning).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun reasoning(): Optional<Reasoning> = body.reasoning()

    /**
     * Configuration options for a text response from the model. Can be plain text or structured
     * JSON data. Learn more:
     * - [Text inputs and outputs](https://platform.openai.com/docs/guides/text)
     * - [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs)
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun text(): Optional<Text> = body.text()

    /**
     * Controls which tool the model should use, if any.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun toolChoice(): Optional<ToolChoice> = body.toolChoice()

    /**
     * An array of tools the model may call while generating a response. You can specify which tool
     * to use by setting the `tool_choice` parameter.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tools(): Optional<List<Tool>> = body.tools()

    /**
     * The truncation strategy to use for the model response. - `auto`: If the input to this
     * Response exceeds the model's context window size, the model will truncate the response to fit
     * the context window by dropping items from the beginning of the conversation. - `disabled`
     * (default): If the input size will exceed the context window size for a model, the request
     * will fail with a 400 error.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun truncation(): Optional<Truncation> = body.truncation()

    /**
     * Returns the raw JSON value of [conversation].
     *
     * Unlike [conversation], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _conversation(): JsonField<Conversation> = body._conversation()

    /**
     * Returns the raw JSON value of [input].
     *
     * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _input(): JsonField<Input> = body._input()

    /**
     * Returns the raw JSON value of [instructions].
     *
     * Unlike [instructions], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _instructions(): JsonField<String> = body._instructions()

    /**
     * Returns the raw JSON value of [model].
     *
     * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _model(): JsonField<String> = body._model()

    /**
     * Returns the raw JSON value of [parallelToolCalls].
     *
     * Unlike [parallelToolCalls], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _parallelToolCalls(): JsonField<Boolean> = body._parallelToolCalls()

    /**
     * Returns the raw JSON value of [previousResponseId].
     *
     * Unlike [previousResponseId], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _previousResponseId(): JsonField<String> = body._previousResponseId()

    /**
     * Returns the raw JSON value of [reasoning].
     *
     * Unlike [reasoning], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _reasoning(): JsonField<Reasoning> = body._reasoning()

    /**
     * Returns the raw JSON value of [text].
     *
     * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _text(): JsonField<Text> = body._text()

    /**
     * Returns the raw JSON value of [toolChoice].
     *
     * Unlike [toolChoice], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _toolChoice(): JsonField<ToolChoice> = body._toolChoice()

    /**
     * Returns the raw JSON value of [tools].
     *
     * Unlike [tools], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _tools(): JsonField<List<Tool>> = body._tools()

    /**
     * Returns the raw JSON value of [truncation].
     *
     * Unlike [truncation], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _truncation(): JsonField<Truncation> = body._truncation()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): InputTokenCountParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [InputTokenCountParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [InputTokenCountParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(inputTokenCountParams: InputTokenCountParams) = apply {
            body = inputTokenCountParams.body.toBuilder()
            additionalHeaders = inputTokenCountParams.additionalHeaders.toBuilder()
            additionalQueryParams = inputTokenCountParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [conversation]
         * - [input]
         * - [instructions]
         * - [model]
         * - [parallelToolCalls]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * The conversation that this response belongs to. Items from this conversation are
         * prepended to `input_items` for this response request. Input items and output items from
         * this response are automatically added to this conversation after this response completes.
         */
        fun conversation(conversation: Conversation?) = apply { body.conversation(conversation) }

        /** Alias for calling [Builder.conversation] with `conversation.orElse(null)`. */
        fun conversation(conversation: Optional<Conversation>) =
            conversation(conversation.getOrNull())

        /**
         * Sets [Builder.conversation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.conversation] with a well-typed [Conversation] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun conversation(conversation: JsonField<Conversation>) = apply {
            body.conversation(conversation)
        }

        /** Alias for calling [conversation] with `Conversation.ofId(id)`. */
        fun conversation(id: String) = apply { body.conversation(id) }

        /**
         * Alias for calling [conversation] with
         * `Conversation.ofResponseConversationParam(responseConversationParam)`.
         */
        fun conversation(responseConversationParam: ResponseConversationParam) = apply {
            body.conversation(responseConversationParam)
        }

        /** Text, image, or file inputs to the model, used to generate a response */
        fun input(input: Input?) = apply { body.input(input) }

        /** Alias for calling [Builder.input] with `input.orElse(null)`. */
        fun input(input: Optional<Input>) = input(input.getOrNull())

        /**
         * Sets [Builder.input] to an arbitrary JSON value.
         *
         * You should usually call [Builder.input] with a well-typed [Input] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun input(input: JsonField<Input>) = apply { body.input(input) }

        /** Alias for calling [input] with `Input.ofString(string)`. */
        fun input(string: String) = apply { body.input(string) }

        /** Alias for calling [input] with `Input.ofResponseInputItems(responseInputItems)`. */
        fun inputOfResponseInputItems(responseInputItems: List<ResponseInputItem>) = apply {
            body.inputOfResponseInputItems(responseInputItems)
        }

        /**
         * A system (or developer) message inserted into the model's context. When used along with
         * `previous_response_id`, the instructions from a previous response will not be carried
         * over to the next response. This makes it simple to swap out system (or developer)
         * messages in new responses.
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
         * Model ID used to generate the response, like `gpt-4o` or `o3`. OpenAI offers a wide range
         * of models with different capabilities, performance characteristics, and price points.
         * Refer to the [model guide](https://platform.openai.com/docs/models) to browse and compare
         * available models.
         */
        fun model(model: String?) = apply { body.model(model) }

        /** Alias for calling [Builder.model] with `model.orElse(null)`. */
        fun model(model: Optional<String>) = model(model.getOrNull())

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(model: JsonField<String>) = apply { body.model(model) }

        /** Whether to allow the model to run tool calls in parallel. */
        fun parallelToolCalls(parallelToolCalls: Boolean?) = apply {
            body.parallelToolCalls(parallelToolCalls)
        }

        /**
         * Alias for [Builder.parallelToolCalls].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun parallelToolCalls(parallelToolCalls: Boolean) =
            parallelToolCalls(parallelToolCalls as Boolean?)

        /** Alias for calling [Builder.parallelToolCalls] with `parallelToolCalls.orElse(null)`. */
        fun parallelToolCalls(parallelToolCalls: Optional<Boolean>) =
            parallelToolCalls(parallelToolCalls.getOrNull())

        /**
         * Sets [Builder.parallelToolCalls] to an arbitrary JSON value.
         *
         * You should usually call [Builder.parallelToolCalls] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun parallelToolCalls(parallelToolCalls: JsonField<Boolean>) = apply {
            body.parallelToolCalls(parallelToolCalls)
        }

        /**
         * The unique ID of the previous response to the model. Use this to create multi-turn
         * conversations. Learn more about
         * [conversation state](https://platform.openai.com/docs/guides/conversation-state). Cannot
         * be used in conjunction with `conversation`.
         */
        fun previousResponseId(previousResponseId: String?) = apply {
            body.previousResponseId(previousResponseId)
        }

        /**
         * Alias for calling [Builder.previousResponseId] with `previousResponseId.orElse(null)`.
         */
        fun previousResponseId(previousResponseId: Optional<String>) =
            previousResponseId(previousResponseId.getOrNull())

        /**
         * Sets [Builder.previousResponseId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.previousResponseId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun previousResponseId(previousResponseId: JsonField<String>) = apply {
            body.previousResponseId(previousResponseId)
        }

        /**
         * **gpt-5 and o-series models only** Configuration options for
         * [reasoning models](https://platform.openai.com/docs/guides/reasoning).
         */
        fun reasoning(reasoning: Reasoning?) = apply { body.reasoning(reasoning) }

        /** Alias for calling [Builder.reasoning] with `reasoning.orElse(null)`. */
        fun reasoning(reasoning: Optional<Reasoning>) = reasoning(reasoning.getOrNull())

        /**
         * Sets [Builder.reasoning] to an arbitrary JSON value.
         *
         * You should usually call [Builder.reasoning] with a well-typed [Reasoning] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun reasoning(reasoning: JsonField<Reasoning>) = apply { body.reasoning(reasoning) }

        /**
         * Configuration options for a text response from the model. Can be plain text or structured
         * JSON data. Learn more:
         * - [Text inputs and outputs](https://platform.openai.com/docs/guides/text)
         * - [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs)
         */
        fun text(text: Text?) = apply { body.text(text) }

        /** Alias for calling [Builder.text] with `text.orElse(null)`. */
        fun text(text: Optional<Text>) = text(text.getOrNull())

        /**
         * Sets [Builder.text] to an arbitrary JSON value.
         *
         * You should usually call [Builder.text] with a well-typed [Text] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun text(text: JsonField<Text>) = apply { body.text(text) }

        /** Controls which tool the model should use, if any. */
        fun toolChoice(toolChoice: ToolChoice?) = apply { body.toolChoice(toolChoice) }

        /** Alias for calling [Builder.toolChoice] with `toolChoice.orElse(null)`. */
        fun toolChoice(toolChoice: Optional<ToolChoice>) = toolChoice(toolChoice.getOrNull())

        /**
         * Sets [Builder.toolChoice] to an arbitrary JSON value.
         *
         * You should usually call [Builder.toolChoice] with a well-typed [ToolChoice] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun toolChoice(toolChoice: JsonField<ToolChoice>) = apply { body.toolChoice(toolChoice) }

        /** Alias for calling [toolChoice] with `ToolChoice.ofOptions(options)`. */
        fun toolChoice(options: ToolChoiceOptions) = apply { body.toolChoice(options) }

        /** Alias for calling [toolChoice] with `ToolChoice.ofAllowed(allowed)`. */
        fun toolChoice(allowed: ToolChoiceAllowed) = apply { body.toolChoice(allowed) }

        /** Alias for calling [toolChoice] with `ToolChoice.ofTypes(types)`. */
        fun toolChoice(types: ToolChoiceTypes) = apply { body.toolChoice(types) }

        /** Alias for calling [toolChoice] with `ToolChoice.ofFunction(function)`. */
        fun toolChoice(function: ToolChoiceFunction) = apply { body.toolChoice(function) }

        /** Alias for calling [toolChoice] with `ToolChoice.ofMcp(mcp)`. */
        fun toolChoice(mcp: ToolChoiceMcp) = apply { body.toolChoice(mcp) }

        /** Alias for calling [toolChoice] with `ToolChoice.ofCustom(custom)`. */
        fun toolChoice(custom: ToolChoiceCustom) = apply { body.toolChoice(custom) }

        /** Alias for calling [toolChoice] with `ToolChoice.ofApplyPatch(applyPatch)`. */
        fun toolChoice(applyPatch: ToolChoiceApplyPatch) = apply { body.toolChoice(applyPatch) }

        /** Alias for calling [toolChoice] with `ToolChoice.ofShell(shell)`. */
        fun toolChoice(shell: ToolChoiceShell) = apply { body.toolChoice(shell) }

        /**
         * An array of tools the model may call while generating a response. You can specify which
         * tool to use by setting the `tool_choice` parameter.
         */
        fun tools(tools: List<Tool>?) = apply { body.tools(tools) }

        /** Alias for calling [Builder.tools] with `tools.orElse(null)`. */
        fun tools(tools: Optional<List<Tool>>) = tools(tools.getOrNull())

        /**
         * Sets [Builder.tools] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tools] with a well-typed `List<Tool>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun tools(tools: JsonField<List<Tool>>) = apply { body.tools(tools) }

        /**
         * Adds a single [Tool] to [tools].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTool(tool: Tool) = apply { body.addTool(tool) }

        /** Alias for calling [addTool] with `Tool.ofFunction(function)`. */
        fun addTool(function: FunctionTool) = apply { body.addTool(function) }

        /** Alias for calling [addTool] with `Tool.ofFileSearch(fileSearch)`. */
        fun addTool(fileSearch: FileSearchTool) = apply { body.addTool(fileSearch) }

        /**
         * Alias for calling [addTool] with the following:
         * ```java
         * FileSearchTool.builder()
         *     .vectorStoreIds(vectorStoreIds)
         *     .build()
         * ```
         */
        fun addFileSearchTool(vectorStoreIds: List<String>) = apply {
            body.addFileSearchTool(vectorStoreIds)
        }

        /** Alias for calling [addTool] with `Tool.ofComputerUsePreview(computerUsePreview)`. */
        fun addTool(computerUsePreview: ComputerTool) = apply { body.addTool(computerUsePreview) }

        /** Alias for calling [addTool] with `Tool.ofWebSearch(webSearch)`. */
        fun addTool(webSearch: WebSearchTool) = apply { body.addTool(webSearch) }

        /** Alias for calling [addTool] with `Tool.ofMcp(mcp)`. */
        fun addTool(mcp: Tool.Mcp) = apply { body.addTool(mcp) }

        /**
         * Alias for calling [addTool] with the following:
         * ```java
         * Tool.Mcp.builder()
         *     .serverLabel(serverLabel)
         *     .build()
         * ```
         */
        fun addMcpTool(serverLabel: String) = apply { body.addMcpTool(serverLabel) }

        /** Alias for calling [addTool] with `Tool.ofCodeInterpreter(codeInterpreter)`. */
        fun addTool(codeInterpreter: Tool.CodeInterpreter) = apply { body.addTool(codeInterpreter) }

        /**
         * Alias for calling [addTool] with the following:
         * ```java
         * Tool.CodeInterpreter.builder()
         *     .container(container)
         *     .build()
         * ```
         */
        fun addCodeInterpreterTool(container: Tool.CodeInterpreter.Container) = apply {
            body.addCodeInterpreterTool(container)
        }

        /**
         * Alias for calling [addCodeInterpreterTool] with
         * `Tool.CodeInterpreter.Container.ofString(string)`.
         */
        fun addCodeInterpreterTool(string: String) = apply { body.addCodeInterpreterTool(string) }

        /**
         * Alias for calling [addCodeInterpreterTool] with
         * `Tool.CodeInterpreter.Container.ofCodeInterpreterToolAuto(codeInterpreterToolAuto)`.
         */
        fun addCodeInterpreterTool(
            codeInterpreterToolAuto: Tool.CodeInterpreter.Container.CodeInterpreterToolAuto
        ) = apply { body.addCodeInterpreterTool(codeInterpreterToolAuto) }

        /** Alias for calling [addTool] with `Tool.ofImageGeneration(imageGeneration)`. */
        fun addTool(imageGeneration: Tool.ImageGeneration) = apply { body.addTool(imageGeneration) }

        /** Alias for calling [addTool] with `Tool.ofLocalShell()`. */
        fun addToolLocalShell() = apply { body.addToolLocalShell() }

        /** Alias for calling [addTool] with `Tool.ofShell(shell)`. */
        fun addTool(shell: FunctionShellTool) = apply { body.addTool(shell) }

        /** Alias for calling [addTool] with `Tool.ofCustom(custom)`. */
        fun addTool(custom: CustomTool) = apply { body.addTool(custom) }

        /**
         * Alias for calling [addTool] with the following:
         * ```java
         * CustomTool.builder()
         *     .name(name)
         *     .build()
         * ```
         */
        fun addCustomTool(name: String) = apply { body.addCustomTool(name) }

        /** Alias for calling [addTool] with `Tool.ofWebSearchPreview(webSearchPreview)`. */
        fun addTool(webSearchPreview: WebSearchPreviewTool) = apply {
            body.addTool(webSearchPreview)
        }

        /** Alias for calling [addTool] with `Tool.ofApplyPatch(applyPatch)`. */
        fun addTool(applyPatch: ApplyPatchTool) = apply { body.addTool(applyPatch) }

        /**
         * The truncation strategy to use for the model response. - `auto`: If the input to this
         * Response exceeds the model's context window size, the model will truncate the response to
         * fit the context window by dropping items from the beginning of the conversation. -
         * `disabled` (default): If the input size will exceed the context window size for a model,
         * the request will fail with a 400 error.
         */
        fun truncation(truncation: Truncation) = apply { body.truncation(truncation) }

        /**
         * Sets [Builder.truncation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.truncation] with a well-typed [Truncation] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun truncation(truncation: JsonField<Truncation>) = apply { body.truncation(truncation) }

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
         * Returns an immutable instance of [InputTokenCountParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): InputTokenCountParams =
            InputTokenCountParams(
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
        private val conversation: JsonField<Conversation>,
        private val input: JsonField<Input>,
        private val instructions: JsonField<String>,
        private val model: JsonField<String>,
        private val parallelToolCalls: JsonField<Boolean>,
        private val previousResponseId: JsonField<String>,
        private val reasoning: JsonField<Reasoning>,
        private val text: JsonField<Text>,
        private val toolChoice: JsonField<ToolChoice>,
        private val tools: JsonField<List<Tool>>,
        private val truncation: JsonField<Truncation>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("conversation")
            @ExcludeMissing
            conversation: JsonField<Conversation> = JsonMissing.of(),
            @JsonProperty("input") @ExcludeMissing input: JsonField<Input> = JsonMissing.of(),
            @JsonProperty("instructions")
            @ExcludeMissing
            instructions: JsonField<String> = JsonMissing.of(),
            @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
            @JsonProperty("parallel_tool_calls")
            @ExcludeMissing
            parallelToolCalls: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("previous_response_id")
            @ExcludeMissing
            previousResponseId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("reasoning")
            @ExcludeMissing
            reasoning: JsonField<Reasoning> = JsonMissing.of(),
            @JsonProperty("text") @ExcludeMissing text: JsonField<Text> = JsonMissing.of(),
            @JsonProperty("tool_choice")
            @ExcludeMissing
            toolChoice: JsonField<ToolChoice> = JsonMissing.of(),
            @JsonProperty("tools") @ExcludeMissing tools: JsonField<List<Tool>> = JsonMissing.of(),
            @JsonProperty("truncation")
            @ExcludeMissing
            truncation: JsonField<Truncation> = JsonMissing.of(),
        ) : this(
            conversation,
            input,
            instructions,
            model,
            parallelToolCalls,
            previousResponseId,
            reasoning,
            text,
            toolChoice,
            tools,
            truncation,
            mutableMapOf(),
        )

        /**
         * The conversation that this response belongs to. Items from this conversation are
         * prepended to `input_items` for this response request. Input items and output items from
         * this response are automatically added to this conversation after this response completes.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun conversation(): Optional<Conversation> = conversation.getOptional("conversation")

        /**
         * Text, image, or file inputs to the model, used to generate a response
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun input(): Optional<Input> = input.getOptional("input")

        /**
         * A system (or developer) message inserted into the model's context. When used along with
         * `previous_response_id`, the instructions from a previous response will not be carried
         * over to the next response. This makes it simple to swap out system (or developer)
         * messages in new responses.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun instructions(): Optional<String> = instructions.getOptional("instructions")

        /**
         * Model ID used to generate the response, like `gpt-4o` or `o3`. OpenAI offers a wide range
         * of models with different capabilities, performance characteristics, and price points.
         * Refer to the [model guide](https://platform.openai.com/docs/models) to browse and compare
         * available models.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun model(): Optional<String> = model.getOptional("model")

        /**
         * Whether to allow the model to run tool calls in parallel.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun parallelToolCalls(): Optional<Boolean> =
            parallelToolCalls.getOptional("parallel_tool_calls")

        /**
         * The unique ID of the previous response to the model. Use this to create multi-turn
         * conversations. Learn more about
         * [conversation state](https://platform.openai.com/docs/guides/conversation-state). Cannot
         * be used in conjunction with `conversation`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun previousResponseId(): Optional<String> =
            previousResponseId.getOptional("previous_response_id")

        /**
         * **gpt-5 and o-series models only** Configuration options for
         * [reasoning models](https://platform.openai.com/docs/guides/reasoning).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun reasoning(): Optional<Reasoning> = reasoning.getOptional("reasoning")

        /**
         * Configuration options for a text response from the model. Can be plain text or structured
         * JSON data. Learn more:
         * - [Text inputs and outputs](https://platform.openai.com/docs/guides/text)
         * - [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs)
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun text(): Optional<Text> = text.getOptional("text")

        /**
         * Controls which tool the model should use, if any.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun toolChoice(): Optional<ToolChoice> = toolChoice.getOptional("tool_choice")

        /**
         * An array of tools the model may call while generating a response. You can specify which
         * tool to use by setting the `tool_choice` parameter.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun tools(): Optional<List<Tool>> = tools.getOptional("tools")

        /**
         * The truncation strategy to use for the model response. - `auto`: If the input to this
         * Response exceeds the model's context window size, the model will truncate the response to
         * fit the context window by dropping items from the beginning of the conversation. -
         * `disabled` (default): If the input size will exceed the context window size for a model,
         * the request will fail with a 400 error.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun truncation(): Optional<Truncation> = truncation.getOptional("truncation")

        /**
         * Returns the raw JSON value of [conversation].
         *
         * Unlike [conversation], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("conversation")
        @ExcludeMissing
        fun _conversation(): JsonField<Conversation> = conversation

        /**
         * Returns the raw JSON value of [input].
         *
         * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("input") @ExcludeMissing fun _input(): JsonField<Input> = input

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
         * Returns the raw JSON value of [model].
         *
         * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

        /**
         * Returns the raw JSON value of [parallelToolCalls].
         *
         * Unlike [parallelToolCalls], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("parallel_tool_calls")
        @ExcludeMissing
        fun _parallelToolCalls(): JsonField<Boolean> = parallelToolCalls

        /**
         * Returns the raw JSON value of [previousResponseId].
         *
         * Unlike [previousResponseId], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("previous_response_id")
        @ExcludeMissing
        fun _previousResponseId(): JsonField<String> = previousResponseId

        /**
         * Returns the raw JSON value of [reasoning].
         *
         * Unlike [reasoning], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("reasoning")
        @ExcludeMissing
        fun _reasoning(): JsonField<Reasoning> = reasoning

        /**
         * Returns the raw JSON value of [text].
         *
         * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<Text> = text

        /**
         * Returns the raw JSON value of [toolChoice].
         *
         * Unlike [toolChoice], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tool_choice")
        @ExcludeMissing
        fun _toolChoice(): JsonField<ToolChoice> = toolChoice

        /**
         * Returns the raw JSON value of [tools].
         *
         * Unlike [tools], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tools") @ExcludeMissing fun _tools(): JsonField<List<Tool>> = tools

        /**
         * Returns the raw JSON value of [truncation].
         *
         * Unlike [truncation], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("truncation")
        @ExcludeMissing
        fun _truncation(): JsonField<Truncation> = truncation

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

            private var conversation: JsonField<Conversation> = JsonMissing.of()
            private var input: JsonField<Input> = JsonMissing.of()
            private var instructions: JsonField<String> = JsonMissing.of()
            private var model: JsonField<String> = JsonMissing.of()
            private var parallelToolCalls: JsonField<Boolean> = JsonMissing.of()
            private var previousResponseId: JsonField<String> = JsonMissing.of()
            private var reasoning: JsonField<Reasoning> = JsonMissing.of()
            private var text: JsonField<Text> = JsonMissing.of()
            private var toolChoice: JsonField<ToolChoice> = JsonMissing.of()
            private var tools: JsonField<MutableList<Tool>>? = null
            private var truncation: JsonField<Truncation> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                conversation = body.conversation
                input = body.input
                instructions = body.instructions
                model = body.model
                parallelToolCalls = body.parallelToolCalls
                previousResponseId = body.previousResponseId
                reasoning = body.reasoning
                text = body.text
                toolChoice = body.toolChoice
                tools = body.tools.map { it.toMutableList() }
                truncation = body.truncation
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * The conversation that this response belongs to. Items from this conversation are
             * prepended to `input_items` for this response request. Input items and output items
             * from this response are automatically added to this conversation after this response
             * completes.
             */
            fun conversation(conversation: Conversation?) =
                conversation(JsonField.ofNullable(conversation))

            /** Alias for calling [Builder.conversation] with `conversation.orElse(null)`. */
            fun conversation(conversation: Optional<Conversation>) =
                conversation(conversation.getOrNull())

            /**
             * Sets [Builder.conversation] to an arbitrary JSON value.
             *
             * You should usually call [Builder.conversation] with a well-typed [Conversation] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun conversation(conversation: JsonField<Conversation>) = apply {
                this.conversation = conversation
            }

            /** Alias for calling [conversation] with `Conversation.ofId(id)`. */
            fun conversation(id: String) = conversation(Conversation.ofId(id))

            /**
             * Alias for calling [conversation] with
             * `Conversation.ofResponseConversationParam(responseConversationParam)`.
             */
            fun conversation(responseConversationParam: ResponseConversationParam) =
                conversation(Conversation.ofResponseConversationParam(responseConversationParam))

            /** Text, image, or file inputs to the model, used to generate a response */
            fun input(input: Input?) = input(JsonField.ofNullable(input))

            /** Alias for calling [Builder.input] with `input.orElse(null)`. */
            fun input(input: Optional<Input>) = input(input.getOrNull())

            /**
             * Sets [Builder.input] to an arbitrary JSON value.
             *
             * You should usually call [Builder.input] with a well-typed [Input] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun input(input: JsonField<Input>) = apply { this.input = input }

            /** Alias for calling [input] with `Input.ofString(string)`. */
            fun input(string: String) = input(Input.ofString(string))

            /** Alias for calling [input] with `Input.ofResponseInputItems(responseInputItems)`. */
            fun inputOfResponseInputItems(responseInputItems: List<ResponseInputItem>) =
                input(Input.ofResponseInputItems(responseInputItems))

            /**
             * A system (or developer) message inserted into the model's context. When used along
             * with `previous_response_id`, the instructions from a previous response will not be
             * carried over to the next response. This makes it simple to swap out system (or
             * developer) messages in new responses.
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
             * Model ID used to generate the response, like `gpt-4o` or `o3`. OpenAI offers a wide
             * range of models with different capabilities, performance characteristics, and price
             * points. Refer to the [model guide](https://platform.openai.com/docs/models) to browse
             * and compare available models.
             */
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

            /** Whether to allow the model to run tool calls in parallel. */
            fun parallelToolCalls(parallelToolCalls: Boolean?) =
                parallelToolCalls(JsonField.ofNullable(parallelToolCalls))

            /**
             * Alias for [Builder.parallelToolCalls].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun parallelToolCalls(parallelToolCalls: Boolean) =
                parallelToolCalls(parallelToolCalls as Boolean?)

            /**
             * Alias for calling [Builder.parallelToolCalls] with `parallelToolCalls.orElse(null)`.
             */
            fun parallelToolCalls(parallelToolCalls: Optional<Boolean>) =
                parallelToolCalls(parallelToolCalls.getOrNull())

            /**
             * Sets [Builder.parallelToolCalls] to an arbitrary JSON value.
             *
             * You should usually call [Builder.parallelToolCalls] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun parallelToolCalls(parallelToolCalls: JsonField<Boolean>) = apply {
                this.parallelToolCalls = parallelToolCalls
            }

            /**
             * The unique ID of the previous response to the model. Use this to create multi-turn
             * conversations. Learn more about
             * [conversation state](https://platform.openai.com/docs/guides/conversation-state).
             * Cannot be used in conjunction with `conversation`.
             */
            fun previousResponseId(previousResponseId: String?) =
                previousResponseId(JsonField.ofNullable(previousResponseId))

            /**
             * Alias for calling [Builder.previousResponseId] with
             * `previousResponseId.orElse(null)`.
             */
            fun previousResponseId(previousResponseId: Optional<String>) =
                previousResponseId(previousResponseId.getOrNull())

            /**
             * Sets [Builder.previousResponseId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.previousResponseId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun previousResponseId(previousResponseId: JsonField<String>) = apply {
                this.previousResponseId = previousResponseId
            }

            /**
             * **gpt-5 and o-series models only** Configuration options for
             * [reasoning models](https://platform.openai.com/docs/guides/reasoning).
             */
            fun reasoning(reasoning: Reasoning?) = reasoning(JsonField.ofNullable(reasoning))

            /** Alias for calling [Builder.reasoning] with `reasoning.orElse(null)`. */
            fun reasoning(reasoning: Optional<Reasoning>) = reasoning(reasoning.getOrNull())

            /**
             * Sets [Builder.reasoning] to an arbitrary JSON value.
             *
             * You should usually call [Builder.reasoning] with a well-typed [Reasoning] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun reasoning(reasoning: JsonField<Reasoning>) = apply { this.reasoning = reasoning }

            /**
             * Configuration options for a text response from the model. Can be plain text or
             * structured JSON data. Learn more:
             * - [Text inputs and outputs](https://platform.openai.com/docs/guides/text)
             * - [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs)
             */
            fun text(text: Text?) = text(JsonField.ofNullable(text))

            /** Alias for calling [Builder.text] with `text.orElse(null)`. */
            fun text(text: Optional<Text>) = text(text.getOrNull())

            /**
             * Sets [Builder.text] to an arbitrary JSON value.
             *
             * You should usually call [Builder.text] with a well-typed [Text] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun text(text: JsonField<Text>) = apply { this.text = text }

            /** Controls which tool the model should use, if any. */
            fun toolChoice(toolChoice: ToolChoice?) = toolChoice(JsonField.ofNullable(toolChoice))

            /** Alias for calling [Builder.toolChoice] with `toolChoice.orElse(null)`. */
            fun toolChoice(toolChoice: Optional<ToolChoice>) = toolChoice(toolChoice.getOrNull())

            /**
             * Sets [Builder.toolChoice] to an arbitrary JSON value.
             *
             * You should usually call [Builder.toolChoice] with a well-typed [ToolChoice] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun toolChoice(toolChoice: JsonField<ToolChoice>) = apply {
                this.toolChoice = toolChoice
            }

            /** Alias for calling [toolChoice] with `ToolChoice.ofOptions(options)`. */
            fun toolChoice(options: ToolChoiceOptions) = toolChoice(ToolChoice.ofOptions(options))

            /** Alias for calling [toolChoice] with `ToolChoice.ofAllowed(allowed)`. */
            fun toolChoice(allowed: ToolChoiceAllowed) = toolChoice(ToolChoice.ofAllowed(allowed))

            /** Alias for calling [toolChoice] with `ToolChoice.ofTypes(types)`. */
            fun toolChoice(types: ToolChoiceTypes) = toolChoice(ToolChoice.ofTypes(types))

            /** Alias for calling [toolChoice] with `ToolChoice.ofFunction(function)`. */
            fun toolChoice(function: ToolChoiceFunction) =
                toolChoice(ToolChoice.ofFunction(function))

            /** Alias for calling [toolChoice] with `ToolChoice.ofMcp(mcp)`. */
            fun toolChoice(mcp: ToolChoiceMcp) = toolChoice(ToolChoice.ofMcp(mcp))

            /** Alias for calling [toolChoice] with `ToolChoice.ofCustom(custom)`. */
            fun toolChoice(custom: ToolChoiceCustom) = toolChoice(ToolChoice.ofCustom(custom))

            /** Alias for calling [toolChoice] with `ToolChoice.ofApplyPatch(applyPatch)`. */
            fun toolChoice(applyPatch: ToolChoiceApplyPatch) =
                toolChoice(ToolChoice.ofApplyPatch(applyPatch))

            /** Alias for calling [toolChoice] with `ToolChoice.ofShell(shell)`. */
            fun toolChoice(shell: ToolChoiceShell) = toolChoice(ToolChoice.ofShell(shell))

            /**
             * An array of tools the model may call while generating a response. You can specify
             * which tool to use by setting the `tool_choice` parameter.
             */
            fun tools(tools: List<Tool>?) = tools(JsonField.ofNullable(tools))

            /** Alias for calling [Builder.tools] with `tools.orElse(null)`. */
            fun tools(tools: Optional<List<Tool>>) = tools(tools.getOrNull())

            /**
             * Sets [Builder.tools] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tools] with a well-typed `List<Tool>` value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
                    (tools ?: JsonField.of(mutableListOf())).also {
                        checkKnown("tools", it).add(tool)
                    }
            }

            /** Alias for calling [addTool] with `Tool.ofFunction(function)`. */
            fun addTool(function: FunctionTool) = addTool(Tool.ofFunction(function))

            /** Alias for calling [addTool] with `Tool.ofFileSearch(fileSearch)`. */
            fun addTool(fileSearch: FileSearchTool) = addTool(Tool.ofFileSearch(fileSearch))

            /**
             * Alias for calling [addTool] with the following:
             * ```java
             * FileSearchTool.builder()
             *     .vectorStoreIds(vectorStoreIds)
             *     .build()
             * ```
             */
            fun addFileSearchTool(vectorStoreIds: List<String>) =
                addTool(FileSearchTool.builder().vectorStoreIds(vectorStoreIds).build())

            /** Alias for calling [addTool] with `Tool.ofComputerUsePreview(computerUsePreview)`. */
            fun addTool(computerUsePreview: ComputerTool) =
                addTool(Tool.ofComputerUsePreview(computerUsePreview))

            /** Alias for calling [addTool] with `Tool.ofWebSearch(webSearch)`. */
            fun addTool(webSearch: WebSearchTool) = addTool(Tool.ofWebSearch(webSearch))

            /** Alias for calling [addTool] with `Tool.ofMcp(mcp)`. */
            fun addTool(mcp: Tool.Mcp) = addTool(Tool.ofMcp(mcp))

            /**
             * Alias for calling [addTool] with the following:
             * ```java
             * Tool.Mcp.builder()
             *     .serverLabel(serverLabel)
             *     .build()
             * ```
             */
            fun addMcpTool(serverLabel: String) =
                addTool(Tool.Mcp.builder().serverLabel(serverLabel).build())

            /** Alias for calling [addTool] with `Tool.ofCodeInterpreter(codeInterpreter)`. */
            fun addTool(codeInterpreter: Tool.CodeInterpreter) =
                addTool(Tool.ofCodeInterpreter(codeInterpreter))

            /**
             * Alias for calling [addTool] with the following:
             * ```java
             * Tool.CodeInterpreter.builder()
             *     .container(container)
             *     .build()
             * ```
             */
            fun addCodeInterpreterTool(container: Tool.CodeInterpreter.Container) =
                addTool(Tool.CodeInterpreter.builder().container(container).build())

            /**
             * Alias for calling [addCodeInterpreterTool] with
             * `Tool.CodeInterpreter.Container.ofString(string)`.
             */
            fun addCodeInterpreterTool(string: String) =
                addCodeInterpreterTool(Tool.CodeInterpreter.Container.ofString(string))

            /**
             * Alias for calling [addCodeInterpreterTool] with
             * `Tool.CodeInterpreter.Container.ofCodeInterpreterToolAuto(codeInterpreterToolAuto)`.
             */
            fun addCodeInterpreterTool(
                codeInterpreterToolAuto: Tool.CodeInterpreter.Container.CodeInterpreterToolAuto
            ) =
                addCodeInterpreterTool(
                    Tool.CodeInterpreter.Container.ofCodeInterpreterToolAuto(
                        codeInterpreterToolAuto
                    )
                )

            /** Alias for calling [addTool] with `Tool.ofImageGeneration(imageGeneration)`. */
            fun addTool(imageGeneration: Tool.ImageGeneration) =
                addTool(Tool.ofImageGeneration(imageGeneration))

            /** Alias for calling [addTool] with `Tool.ofLocalShell()`. */
            fun addToolLocalShell() = addTool(Tool.ofLocalShell())

            /** Alias for calling [addTool] with `Tool.ofShell(shell)`. */
            fun addTool(shell: FunctionShellTool) = addTool(Tool.ofShell(shell))

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

            /** Alias for calling [addTool] with `Tool.ofWebSearchPreview(webSearchPreview)`. */
            fun addTool(webSearchPreview: WebSearchPreviewTool) =
                addTool(Tool.ofWebSearchPreview(webSearchPreview))

            /** Alias for calling [addTool] with `Tool.ofApplyPatch(applyPatch)`. */
            fun addTool(applyPatch: ApplyPatchTool) = addTool(Tool.ofApplyPatch(applyPatch))

            /**
             * The truncation strategy to use for the model response. - `auto`: If the input to this
             * Response exceeds the model's context window size, the model will truncate the
             * response to fit the context window by dropping items from the beginning of the
             * conversation. - `disabled` (default): If the input size will exceed the context
             * window size for a model, the request will fail with a 400 error.
             */
            fun truncation(truncation: Truncation) = truncation(JsonField.of(truncation))

            /**
             * Sets [Builder.truncation] to an arbitrary JSON value.
             *
             * You should usually call [Builder.truncation] with a well-typed [Truncation] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun truncation(truncation: JsonField<Truncation>) = apply {
                this.truncation = truncation
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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Body =
                Body(
                    conversation,
                    input,
                    instructions,
                    model,
                    parallelToolCalls,
                    previousResponseId,
                    reasoning,
                    text,
                    toolChoice,
                    (tools ?: JsonMissing.of()).map { it.toImmutable() },
                    truncation,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            conversation().ifPresent { it.validate() }
            input().ifPresent { it.validate() }
            instructions()
            model()
            parallelToolCalls()
            previousResponseId()
            reasoning().ifPresent { it.validate() }
            text().ifPresent { it.validate() }
            toolChoice().ifPresent { it.validate() }
            tools().ifPresent { it.forEach { it.validate() } }
            truncation().ifPresent { it.validate() }
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
            (conversation.asKnown().getOrNull()?.validity() ?: 0) +
                (input.asKnown().getOrNull()?.validity() ?: 0) +
                (if (instructions.asKnown().isPresent) 1 else 0) +
                (if (model.asKnown().isPresent) 1 else 0) +
                (if (parallelToolCalls.asKnown().isPresent) 1 else 0) +
                (if (previousResponseId.asKnown().isPresent) 1 else 0) +
                (reasoning.asKnown().getOrNull()?.validity() ?: 0) +
                (text.asKnown().getOrNull()?.validity() ?: 0) +
                (toolChoice.asKnown().getOrNull()?.validity() ?: 0) +
                (tools.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (truncation.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                conversation == other.conversation &&
                input == other.input &&
                instructions == other.instructions &&
                model == other.model &&
                parallelToolCalls == other.parallelToolCalls &&
                previousResponseId == other.previousResponseId &&
                reasoning == other.reasoning &&
                text == other.text &&
                toolChoice == other.toolChoice &&
                tools == other.tools &&
                truncation == other.truncation &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                conversation,
                input,
                instructions,
                model,
                parallelToolCalls,
                previousResponseId,
                reasoning,
                text,
                toolChoice,
                tools,
                truncation,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{conversation=$conversation, input=$input, instructions=$instructions, model=$model, parallelToolCalls=$parallelToolCalls, previousResponseId=$previousResponseId, reasoning=$reasoning, text=$text, toolChoice=$toolChoice, tools=$tools, truncation=$truncation, additionalProperties=$additionalProperties}"
    }

    /**
     * The conversation that this response belongs to. Items from this conversation are prepended to
     * `input_items` for this response request. Input items and output items from this response are
     * automatically added to this conversation after this response completes.
     */
    @JsonDeserialize(using = Conversation.Deserializer::class)
    @JsonSerialize(using = Conversation.Serializer::class)
    class Conversation
    private constructor(
        private val id: String? = null,
        private val responseConversationParam: ResponseConversationParam? = null,
        private val _json: JsonValue? = null,
    ) {

        /** The unique ID of the conversation. */
        fun id(): Optional<String> = Optional.ofNullable(id)

        /** The conversation that this response belongs to. */
        fun responseConversationParam(): Optional<ResponseConversationParam> =
            Optional.ofNullable(responseConversationParam)

        fun isId(): Boolean = id != null

        fun isResponseConversationParam(): Boolean = responseConversationParam != null

        /** The unique ID of the conversation. */
        fun asId(): String = id.getOrThrow("id")

        /** The conversation that this response belongs to. */
        fun asResponseConversationParam(): ResponseConversationParam =
            responseConversationParam.getOrThrow("responseConversationParam")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                id != null -> visitor.visitId(id)
                responseConversationParam != null ->
                    visitor.visitResponseConversationParam(responseConversationParam)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Conversation = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitId(id: String) {}

                    override fun visitResponseConversationParam(
                        responseConversationParam: ResponseConversationParam
                    ) {
                        responseConversationParam.validate()
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
                    override fun visitId(id: String) = 1

                    override fun visitResponseConversationParam(
                        responseConversationParam: ResponseConversationParam
                    ) = responseConversationParam.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Conversation &&
                id == other.id &&
                responseConversationParam == other.responseConversationParam
        }

        override fun hashCode(): Int = Objects.hash(id, responseConversationParam)

        override fun toString(): String =
            when {
                id != null -> "Conversation{id=$id}"
                responseConversationParam != null ->
                    "Conversation{responseConversationParam=$responseConversationParam}"
                _json != null -> "Conversation{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Conversation")
            }

        companion object {

            /** The unique ID of the conversation. */
            @JvmStatic fun ofId(id: String) = Conversation(id = id)

            /** The conversation that this response belongs to. */
            @JvmStatic
            fun ofResponseConversationParam(responseConversationParam: ResponseConversationParam) =
                Conversation(responseConversationParam = responseConversationParam)
        }

        /**
         * An interface that defines how to map each variant of [Conversation] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            /** The unique ID of the conversation. */
            fun visitId(id: String): T

            /** The conversation that this response belongs to. */
            fun visitResponseConversationParam(
                responseConversationParam: ResponseConversationParam
            ): T

            /**
             * Maps an unknown variant of [Conversation] to a value of type [T].
             *
             * An instance of [Conversation] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Conversation: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Conversation>(Conversation::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Conversation {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<ResponseConversationParam>())?.let {
                                Conversation(responseConversationParam = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Conversation(id = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Conversation(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Conversation>(Conversation::class) {

            override fun serialize(
                value: Conversation,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.id != null -> generator.writeObject(value.id)
                    value.responseConversationParam != null ->
                        generator.writeObject(value.responseConversationParam)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Conversation")
                }
            }
        }
    }

    /** Text, image, or file inputs to the model, used to generate a response */
    @JsonDeserialize(using = Input.Deserializer::class)
    @JsonSerialize(using = Input.Serializer::class)
    class Input
    private constructor(
        private val string: String? = null,
        private val responseInputItems: List<ResponseInputItem>? = null,
        private val _json: JsonValue? = null,
    ) {

        /** A text input to the model, equivalent to a text input with the `user` role. */
        fun string(): Optional<String> = Optional.ofNullable(string)

        /** A list of one or many input items to the model, containing different content types. */
        fun responseInputItems(): Optional<List<ResponseInputItem>> =
            Optional.ofNullable(responseInputItems)

        fun isString(): Boolean = string != null

        fun isResponseInputItems(): Boolean = responseInputItems != null

        /** A text input to the model, equivalent to a text input with the `user` role. */
        fun asString(): String = string.getOrThrow("string")

        /** A list of one or many input items to the model, containing different content types. */
        fun asResponseInputItems(): List<ResponseInputItem> =
            responseInputItems.getOrThrow("responseInputItems")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                string != null -> visitor.visitString(string)
                responseInputItems != null -> visitor.visitResponseInputItems(responseInputItems)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Input = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitString(string: String) {}

                    override fun visitResponseInputItems(
                        responseInputItems: List<ResponseInputItem>
                    ) {
                        responseInputItems.forEach { it.validate() }
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
                    override fun visitString(string: String) = 1

                    override fun visitResponseInputItems(
                        responseInputItems: List<ResponseInputItem>
                    ) = responseInputItems.sumOf { it.validity().toInt() }

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Input &&
                string == other.string &&
                responseInputItems == other.responseInputItems
        }

        override fun hashCode(): Int = Objects.hash(string, responseInputItems)

        override fun toString(): String =
            when {
                string != null -> "Input{string=$string}"
                responseInputItems != null -> "Input{responseInputItems=$responseInputItems}"
                _json != null -> "Input{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Input")
            }

        companion object {

            /** A text input to the model, equivalent to a text input with the `user` role. */
            @JvmStatic fun ofString(string: String) = Input(string = string)

            /**
             * A list of one or many input items to the model, containing different content types.
             */
            @JvmStatic
            fun ofResponseInputItems(responseInputItems: List<ResponseInputItem>) =
                Input(responseInputItems = responseInputItems.toImmutable())
        }

        /** An interface that defines how to map each variant of [Input] to a value of type [T]. */
        interface Visitor<out T> {

            /** A text input to the model, equivalent to a text input with the `user` role. */
            fun visitString(string: String): T

            /**
             * A list of one or many input items to the model, containing different content types.
             */
            fun visitResponseInputItems(responseInputItems: List<ResponseInputItem>): T

            /**
             * Maps an unknown variant of [Input] to a value of type [T].
             *
             * An instance of [Input] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Input: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Input>(Input::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Input {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Input(string = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<List<ResponseInputItem>>())?.let {
                                Input(responseInputItems = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Input(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Input>(Input::class) {

            override fun serialize(
                value: Input,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.string != null -> generator.writeObject(value.string)
                    value.responseInputItems != null ->
                        generator.writeObject(value.responseInputItems)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Input")
                }
            }
        }
    }

    /**
     * Configuration options for a text response from the model. Can be plain text or structured
     * JSON data. Learn more:
     * - [Text inputs and outputs](https://platform.openai.com/docs/guides/text)
     * - [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs)
     */
    class Text
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val format: JsonField<ResponseFormatTextConfig>,
        private val verbosity: JsonField<Verbosity>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("format")
            @ExcludeMissing
            format: JsonField<ResponseFormatTextConfig> = JsonMissing.of(),
            @JsonProperty("verbosity")
            @ExcludeMissing
            verbosity: JsonField<Verbosity> = JsonMissing.of(),
        ) : this(format, verbosity, mutableMapOf())

        /**
         * An object specifying the format that the model must output.
         *
         * Configuring `{ "type": "json_schema" }` enables Structured Outputs, which ensures the
         * model will match your supplied JSON schema. Learn more in the
         * [Structured Outputs guide](https://platform.openai.com/docs/guides/structured-outputs).
         *
         * The default format is `{ "type": "text" }` with no additional options.
         *
         * **Not recommended for gpt-4o and newer models:**
         *
         * Setting to `{ "type": "json_object" }` enables the older JSON mode, which ensures the
         * message the model generates is valid JSON. Using `json_schema` is preferred for models
         * that support it.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun format(): Optional<ResponseFormatTextConfig> = format.getOptional("format")

        /**
         * Constrains the verbosity of the model's response. Lower values will result in more
         * concise responses, while higher values will result in more verbose responses. Currently
         * supported values are `low`, `medium`, and `high`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun verbosity(): Optional<Verbosity> = verbosity.getOptional("verbosity")

        /**
         * Returns the raw JSON value of [format].
         *
         * Unlike [format], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("format")
        @ExcludeMissing
        fun _format(): JsonField<ResponseFormatTextConfig> = format

        /**
         * Returns the raw JSON value of [verbosity].
         *
         * Unlike [verbosity], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("verbosity")
        @ExcludeMissing
        fun _verbosity(): JsonField<Verbosity> = verbosity

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

            /** Returns a mutable builder for constructing an instance of [Text]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Text]. */
        class Builder internal constructor() {

            private var format: JsonField<ResponseFormatTextConfig> = JsonMissing.of()
            private var verbosity: JsonField<Verbosity> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(text: Text) = apply {
                format = text.format
                verbosity = text.verbosity
                additionalProperties = text.additionalProperties.toMutableMap()
            }

            /**
             * An object specifying the format that the model must output.
             *
             * Configuring `{ "type": "json_schema" }` enables Structured Outputs, which ensures the
             * model will match your supplied JSON schema. Learn more in the
             * [Structured Outputs guide](https://platform.openai.com/docs/guides/structured-outputs).
             *
             * The default format is `{ "type": "text" }` with no additional options.
             *
             * **Not recommended for gpt-4o and newer models:**
             *
             * Setting to `{ "type": "json_object" }` enables the older JSON mode, which ensures the
             * message the model generates is valid JSON. Using `json_schema` is preferred for
             * models that support it.
             */
            fun format(format: ResponseFormatTextConfig) = format(JsonField.of(format))

            /**
             * Sets [Builder.format] to an arbitrary JSON value.
             *
             * You should usually call [Builder.format] with a well-typed [ResponseFormatTextConfig]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun format(format: JsonField<ResponseFormatTextConfig>) = apply { this.format = format }

            /** Alias for calling [format] with `ResponseFormatTextConfig.ofText(text)`. */
            fun format(text: ResponseFormatText) = format(ResponseFormatTextConfig.ofText(text))

            /**
             * Alias for calling [format] with `ResponseFormatTextConfig.ofJsonSchema(jsonSchema)`.
             */
            fun format(jsonSchema: ResponseFormatTextJsonSchemaConfig) =
                format(ResponseFormatTextConfig.ofJsonSchema(jsonSchema))

            /**
             * Alias for calling [format] with `ResponseFormatTextConfig.ofJsonObject(jsonObject)`.
             */
            fun format(jsonObject: ResponseFormatJsonObject) =
                format(ResponseFormatTextConfig.ofJsonObject(jsonObject))

            /**
             * Constrains the verbosity of the model's response. Lower values will result in more
             * concise responses, while higher values will result in more verbose responses.
             * Currently supported values are `low`, `medium`, and `high`.
             */
            fun verbosity(verbosity: Verbosity?) = verbosity(JsonField.ofNullable(verbosity))

            /** Alias for calling [Builder.verbosity] with `verbosity.orElse(null)`. */
            fun verbosity(verbosity: Optional<Verbosity>) = verbosity(verbosity.getOrNull())

            /**
             * Sets [Builder.verbosity] to an arbitrary JSON value.
             *
             * You should usually call [Builder.verbosity] with a well-typed [Verbosity] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun verbosity(verbosity: JsonField<Verbosity>) = apply { this.verbosity = verbosity }

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
             */
            fun build(): Text = Text(format, verbosity, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Text = apply {
            if (validated) {
                return@apply
            }

            format().ifPresent { it.validate() }
            verbosity().ifPresent { it.validate() }
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
            (format.asKnown().getOrNull()?.validity() ?: 0) +
                (verbosity.asKnown().getOrNull()?.validity() ?: 0)

        /**
         * Constrains the verbosity of the model's response. Lower values will result in more
         * concise responses, while higher values will result in more verbose responses. Currently
         * supported values are `low`, `medium`, and `high`.
         */
        class Verbosity @JsonCreator private constructor(private val value: JsonField<String>) :
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

                @JvmStatic fun of(value: String) = Verbosity(JsonField.of(value))
            }

            /** An enum containing [Verbosity]'s known values. */
            enum class Known {
                LOW,
                MEDIUM,
                HIGH,
            }

            /**
             * An enum containing [Verbosity]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Verbosity] can contain an unknown value in a couple of cases:
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
                 * An enum member indicating that [Verbosity] was instantiated with an unknown
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
                    else -> throw OpenAIInvalidDataException("Unknown Verbosity: $value")
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

            fun validate(): Verbosity = apply {
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

                return other is Verbosity && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Text &&
                format == other.format &&
                verbosity == other.verbosity &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(format, verbosity, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Text{format=$format, verbosity=$verbosity, additionalProperties=$additionalProperties}"
    }

    /** Controls which tool the model should use, if any. */
    @JsonDeserialize(using = ToolChoice.Deserializer::class)
    @JsonSerialize(using = ToolChoice.Serializer::class)
    class ToolChoice
    private constructor(
        private val options: ToolChoiceOptions? = null,
        private val allowed: ToolChoiceAllowed? = null,
        private val types: ToolChoiceTypes? = null,
        private val function: ToolChoiceFunction? = null,
        private val mcp: ToolChoiceMcp? = null,
        private val custom: ToolChoiceCustom? = null,
        private val applyPatch: ToolChoiceApplyPatch? = null,
        private val shell: ToolChoiceShell? = null,
        private val _json: JsonValue? = null,
    ) {

        /**
         * Controls which (if any) tool is called by the model.
         *
         * `none` means the model will not call any tool and instead generates a message.
         *
         * `auto` means the model can pick between generating a message or calling one or more
         * tools.
         *
         * `required` means the model must call one or more tools.
         */
        fun options(): Optional<ToolChoiceOptions> = Optional.ofNullable(options)

        /** Constrains the tools available to the model to a pre-defined set. */
        fun allowed(): Optional<ToolChoiceAllowed> = Optional.ofNullable(allowed)

        /**
         * Indicates that the model should use a built-in tool to generate a response.
         * [Learn more about built-in tools](https://platform.openai.com/docs/guides/tools).
         */
        fun types(): Optional<ToolChoiceTypes> = Optional.ofNullable(types)

        /** Use this option to force the model to call a specific function. */
        fun function(): Optional<ToolChoiceFunction> = Optional.ofNullable(function)

        /** Use this option to force the model to call a specific tool on a remote MCP server. */
        fun mcp(): Optional<ToolChoiceMcp> = Optional.ofNullable(mcp)

        /** Use this option to force the model to call a specific custom tool. */
        fun custom(): Optional<ToolChoiceCustom> = Optional.ofNullable(custom)

        /** Forces the model to call the apply_patch tool when executing a tool call. */
        fun applyPatch(): Optional<ToolChoiceApplyPatch> = Optional.ofNullable(applyPatch)

        /** Forces the model to call the shell tool when a tool call is required. */
        fun shell(): Optional<ToolChoiceShell> = Optional.ofNullable(shell)

        fun isOptions(): Boolean = options != null

        fun isAllowed(): Boolean = allowed != null

        fun isTypes(): Boolean = types != null

        fun isFunction(): Boolean = function != null

        fun isMcp(): Boolean = mcp != null

        fun isCustom(): Boolean = custom != null

        fun isApplyPatch(): Boolean = applyPatch != null

        fun isShell(): Boolean = shell != null

        /**
         * Controls which (if any) tool is called by the model.
         *
         * `none` means the model will not call any tool and instead generates a message.
         *
         * `auto` means the model can pick between generating a message or calling one or more
         * tools.
         *
         * `required` means the model must call one or more tools.
         */
        fun asOptions(): ToolChoiceOptions = options.getOrThrow("options")

        /** Constrains the tools available to the model to a pre-defined set. */
        fun asAllowed(): ToolChoiceAllowed = allowed.getOrThrow("allowed")

        /**
         * Indicates that the model should use a built-in tool to generate a response.
         * [Learn more about built-in tools](https://platform.openai.com/docs/guides/tools).
         */
        fun asTypes(): ToolChoiceTypes = types.getOrThrow("types")

        /** Use this option to force the model to call a specific function. */
        fun asFunction(): ToolChoiceFunction = function.getOrThrow("function")

        /** Use this option to force the model to call a specific tool on a remote MCP server. */
        fun asMcp(): ToolChoiceMcp = mcp.getOrThrow("mcp")

        /** Use this option to force the model to call a specific custom tool. */
        fun asCustom(): ToolChoiceCustom = custom.getOrThrow("custom")

        /** Forces the model to call the apply_patch tool when executing a tool call. */
        fun asApplyPatch(): ToolChoiceApplyPatch = applyPatch.getOrThrow("applyPatch")

        /** Forces the model to call the shell tool when a tool call is required. */
        fun asShell(): ToolChoiceShell = shell.getOrThrow("shell")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                options != null -> visitor.visitOptions(options)
                allowed != null -> visitor.visitAllowed(allowed)
                types != null -> visitor.visitTypes(types)
                function != null -> visitor.visitFunction(function)
                mcp != null -> visitor.visitMcp(mcp)
                custom != null -> visitor.visitCustom(custom)
                applyPatch != null -> visitor.visitApplyPatch(applyPatch)
                shell != null -> visitor.visitShell(shell)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): ToolChoice = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitOptions(options: ToolChoiceOptions) {
                        options.validate()
                    }

                    override fun visitAllowed(allowed: ToolChoiceAllowed) {
                        allowed.validate()
                    }

                    override fun visitTypes(types: ToolChoiceTypes) {
                        types.validate()
                    }

                    override fun visitFunction(function: ToolChoiceFunction) {
                        function.validate()
                    }

                    override fun visitMcp(mcp: ToolChoiceMcp) {
                        mcp.validate()
                    }

                    override fun visitCustom(custom: ToolChoiceCustom) {
                        custom.validate()
                    }

                    override fun visitApplyPatch(applyPatch: ToolChoiceApplyPatch) {
                        applyPatch.validate()
                    }

                    override fun visitShell(shell: ToolChoiceShell) {
                        shell.validate()
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
                    override fun visitOptions(options: ToolChoiceOptions) = options.validity()

                    override fun visitAllowed(allowed: ToolChoiceAllowed) = allowed.validity()

                    override fun visitTypes(types: ToolChoiceTypes) = types.validity()

                    override fun visitFunction(function: ToolChoiceFunction) = function.validity()

                    override fun visitMcp(mcp: ToolChoiceMcp) = mcp.validity()

                    override fun visitCustom(custom: ToolChoiceCustom) = custom.validity()

                    override fun visitApplyPatch(applyPatch: ToolChoiceApplyPatch) =
                        applyPatch.validity()

                    override fun visitShell(shell: ToolChoiceShell) = shell.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ToolChoice &&
                options == other.options &&
                allowed == other.allowed &&
                types == other.types &&
                function == other.function &&
                mcp == other.mcp &&
                custom == other.custom &&
                applyPatch == other.applyPatch &&
                shell == other.shell
        }

        override fun hashCode(): Int =
            Objects.hash(options, allowed, types, function, mcp, custom, applyPatch, shell)

        override fun toString(): String =
            when {
                options != null -> "ToolChoice{options=$options}"
                allowed != null -> "ToolChoice{allowed=$allowed}"
                types != null -> "ToolChoice{types=$types}"
                function != null -> "ToolChoice{function=$function}"
                mcp != null -> "ToolChoice{mcp=$mcp}"
                custom != null -> "ToolChoice{custom=$custom}"
                applyPatch != null -> "ToolChoice{applyPatch=$applyPatch}"
                shell != null -> "ToolChoice{shell=$shell}"
                _json != null -> "ToolChoice{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid ToolChoice")
            }

        companion object {

            /**
             * Controls which (if any) tool is called by the model.
             *
             * `none` means the model will not call any tool and instead generates a message.
             *
             * `auto` means the model can pick between generating a message or calling one or more
             * tools.
             *
             * `required` means the model must call one or more tools.
             */
            @JvmStatic fun ofOptions(options: ToolChoiceOptions) = ToolChoice(options = options)

            /** Constrains the tools available to the model to a pre-defined set. */
            @JvmStatic fun ofAllowed(allowed: ToolChoiceAllowed) = ToolChoice(allowed = allowed)

            /**
             * Indicates that the model should use a built-in tool to generate a response.
             * [Learn more about built-in tools](https://platform.openai.com/docs/guides/tools).
             */
            @JvmStatic fun ofTypes(types: ToolChoiceTypes) = ToolChoice(types = types)

            /** Use this option to force the model to call a specific function. */
            @JvmStatic
            fun ofFunction(function: ToolChoiceFunction) = ToolChoice(function = function)

            /**
             * Use this option to force the model to call a specific tool on a remote MCP server.
             */
            @JvmStatic fun ofMcp(mcp: ToolChoiceMcp) = ToolChoice(mcp = mcp)

            /** Use this option to force the model to call a specific custom tool. */
            @JvmStatic fun ofCustom(custom: ToolChoiceCustom) = ToolChoice(custom = custom)

            /** Forces the model to call the apply_patch tool when executing a tool call. */
            @JvmStatic
            fun ofApplyPatch(applyPatch: ToolChoiceApplyPatch) = ToolChoice(applyPatch = applyPatch)

            /** Forces the model to call the shell tool when a tool call is required. */
            @JvmStatic fun ofShell(shell: ToolChoiceShell) = ToolChoice(shell = shell)
        }

        /**
         * An interface that defines how to map each variant of [ToolChoice] to a value of type [T].
         */
        interface Visitor<out T> {

            /**
             * Controls which (if any) tool is called by the model.
             *
             * `none` means the model will not call any tool and instead generates a message.
             *
             * `auto` means the model can pick between generating a message or calling one or more
             * tools.
             *
             * `required` means the model must call one or more tools.
             */
            fun visitOptions(options: ToolChoiceOptions): T

            /** Constrains the tools available to the model to a pre-defined set. */
            fun visitAllowed(allowed: ToolChoiceAllowed): T

            /**
             * Indicates that the model should use a built-in tool to generate a response.
             * [Learn more about built-in tools](https://platform.openai.com/docs/guides/tools).
             */
            fun visitTypes(types: ToolChoiceTypes): T

            /** Use this option to force the model to call a specific function. */
            fun visitFunction(function: ToolChoiceFunction): T

            /**
             * Use this option to force the model to call a specific tool on a remote MCP server.
             */
            fun visitMcp(mcp: ToolChoiceMcp): T

            /** Use this option to force the model to call a specific custom tool. */
            fun visitCustom(custom: ToolChoiceCustom): T

            /** Forces the model to call the apply_patch tool when executing a tool call. */
            fun visitApplyPatch(applyPatch: ToolChoiceApplyPatch): T

            /** Forces the model to call the shell tool when a tool call is required. */
            fun visitShell(shell: ToolChoiceShell): T

            /**
             * Maps an unknown variant of [ToolChoice] to a value of type [T].
             *
             * An instance of [ToolChoice] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown ToolChoice: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<ToolChoice>(ToolChoice::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): ToolChoice {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<ToolChoiceOptions>())?.let {
                                ToolChoice(options = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<ToolChoiceAllowed>())?.let {
                                ToolChoice(allowed = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<ToolChoiceTypes>())?.let {
                                ToolChoice(types = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<ToolChoiceFunction>())?.let {
                                ToolChoice(function = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<ToolChoiceMcp>())?.let {
                                ToolChoice(mcp = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<ToolChoiceCustom>())?.let {
                                ToolChoice(custom = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<ToolChoiceApplyPatch>())?.let {
                                ToolChoice(applyPatch = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<ToolChoiceShell>())?.let {
                                ToolChoice(shell = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> ToolChoice(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<ToolChoice>(ToolChoice::class) {

            override fun serialize(
                value: ToolChoice,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.options != null -> generator.writeObject(value.options)
                    value.allowed != null -> generator.writeObject(value.allowed)
                    value.types != null -> generator.writeObject(value.types)
                    value.function != null -> generator.writeObject(value.function)
                    value.mcp != null -> generator.writeObject(value.mcp)
                    value.custom != null -> generator.writeObject(value.custom)
                    value.applyPatch != null -> generator.writeObject(value.applyPatch)
                    value.shell != null -> generator.writeObject(value.shell)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid ToolChoice")
                }
            }
        }
    }

    /**
     * The truncation strategy to use for the model response. - `auto`: If the input to this
     * Response exceeds the model's context window size, the model will truncate the response to fit
     * the context window by dropping items from the beginning of the conversation. - `disabled`
     * (default): If the input size will exceed the context window size for a model, the request
     * will fail with a 400 error.
     */
    class Truncation @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val AUTO = of("auto")

            @JvmField val DISABLED = of("disabled")

            @JvmStatic fun of(value: String) = Truncation(JsonField.of(value))
        }

        /** An enum containing [Truncation]'s known values. */
        enum class Known {
            AUTO,
            DISABLED,
        }

        /**
         * An enum containing [Truncation]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Truncation] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            AUTO,
            DISABLED,
            /**
             * An enum member indicating that [Truncation] was instantiated with an unknown value.
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
                AUTO -> Value.AUTO
                DISABLED -> Value.DISABLED
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
                AUTO -> Known.AUTO
                DISABLED -> Known.DISABLED
                else -> throw OpenAIInvalidDataException("Unknown Truncation: $value")
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

        fun validate(): Truncation = apply {
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

            return other is Truncation && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InputTokenCountParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "InputTokenCountParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
