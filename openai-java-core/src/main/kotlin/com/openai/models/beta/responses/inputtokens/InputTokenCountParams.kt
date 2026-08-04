// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses.inputtokens

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
import com.openai.models.beta.responses.BetaApplyPatchTool
import com.openai.models.beta.responses.BetaComputerTool
import com.openai.models.beta.responses.BetaComputerUsePreviewTool
import com.openai.models.beta.responses.BetaCustomTool
import com.openai.models.beta.responses.BetaFileSearchTool
import com.openai.models.beta.responses.BetaFunctionShellTool
import com.openai.models.beta.responses.BetaFunctionTool
import com.openai.models.beta.responses.BetaNamespaceTool
import com.openai.models.beta.responses.BetaResponseConversationParam
import com.openai.models.beta.responses.BetaResponseFormatTextConfig
import com.openai.models.beta.responses.BetaResponseFormatTextJsonSchemaConfig
import com.openai.models.beta.responses.BetaResponseInputItem
import com.openai.models.beta.responses.BetaTool
import com.openai.models.beta.responses.BetaToolChoiceAllowed
import com.openai.models.beta.responses.BetaToolChoiceApplyPatch
import com.openai.models.beta.responses.BetaToolChoiceCustom
import com.openai.models.beta.responses.BetaToolChoiceFunction
import com.openai.models.beta.responses.BetaToolChoiceMcp
import com.openai.models.beta.responses.BetaToolChoiceOptions
import com.openai.models.beta.responses.BetaToolChoiceShell
import com.openai.models.beta.responses.BetaToolChoiceTypes
import com.openai.models.beta.responses.BetaToolSearchTool
import com.openai.models.beta.responses.BetaWebSearchPreviewTool
import com.openai.models.beta.responses.BetaWebSearchTool
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Returns input token counts of the request.
 *
 * Returns an object with `object` set to `response.input_tokens` and an `input_tokens` count.
 */
class InputTokenCountParams
private constructor(
    private val betas: List<Beta>?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun betas(): Optional<List<Beta>> = Optional.ofNullable(betas)

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
     * A model-owned style preset to apply to this request. Omit this parameter to use the model's
     * default style. Supported values may expand over time. Values must be at most 64 characters.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun personality(): Optional<Personality> = body.personality()

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
    fun tools(): Optional<List<BetaTool>> = body.tools()

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
    @Deprecated("deprecated") fun truncation(): Optional<Truncation> = body.truncation()

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
     * Returns the raw JSON value of [personality].
     *
     * Unlike [personality], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _personality(): JsonField<Personality> = body._personality()

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
    fun _tools(): JsonField<List<BetaTool>> = body._tools()

    /**
     * Returns the raw JSON value of [truncation].
     *
     * Unlike [truncation], this method doesn't throw if the JSON field has an unexpected type.
     */
    @Deprecated("deprecated") fun _truncation(): JsonField<Truncation> = body._truncation()

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

        private var betas: MutableList<Beta>? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(inputTokenCountParams: InputTokenCountParams) = apply {
            betas = inputTokenCountParams.betas?.toMutableList()
            body = inputTokenCountParams.body.toBuilder()
            additionalHeaders = inputTokenCountParams.additionalHeaders.toBuilder()
            additionalQueryParams = inputTokenCountParams.additionalQueryParams.toBuilder()
        }

        fun betas(betas: List<Beta>?) = apply { this.betas = betas?.toMutableList() }

        /** Alias for calling [Builder.betas] with `betas.orElse(null)`. */
        fun betas(betas: Optional<List<Beta>>) = betas(betas.getOrNull())

        /**
         * Adds a single [Beta] to [betas].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addBeta(beta: Beta) = apply { betas = (betas ?: mutableListOf()).apply { add(beta) } }

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
         * `Conversation.ofBetaResponseConversationParam(betaResponseConversationParam)`.
         */
        fun conversation(betaResponseConversationParam: BetaResponseConversationParam) = apply {
            body.conversation(betaResponseConversationParam)
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

        /**
         * Alias for calling [input] with `Input.ofBetaResponseInputItems(betaResponseInputItems)`.
         */
        fun inputOfBetaResponseInputItems(betaResponseInputItems: List<BetaResponseInputItem>) =
            apply {
                body.inputOfBetaResponseInputItems(betaResponseInputItems)
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
         * A model-owned style preset to apply to this request. Omit this parameter to use the
         * model's default style. Supported values may expand over time. Values must be at most 64
         * characters.
         */
        fun personality(personality: Personality) = apply { body.personality(personality) }

        /**
         * Sets [Builder.personality] to an arbitrary JSON value.
         *
         * You should usually call [Builder.personality] with a well-typed [Personality] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun personality(personality: JsonField<Personality>) = apply {
            body.personality(personality)
        }

        /**
         * Sets [personality] to an arbitrary [String].
         *
         * You should usually call [personality] with a well-typed [Personality] constant instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun personality(value: String) = apply { body.personality(value) }

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

        /**
         * Alias for calling [toolChoice] with
         * `ToolChoice.ofBetaToolChoiceOptions(betaToolChoiceOptions)`.
         */
        fun toolChoice(betaToolChoiceOptions: BetaToolChoiceOptions) = apply {
            body.toolChoice(betaToolChoiceOptions)
        }

        /**
         * Alias for calling [toolChoice] with
         * `ToolChoice.ofBetaToolChoiceAllowed(betaToolChoiceAllowed)`.
         */
        fun toolChoice(betaToolChoiceAllowed: BetaToolChoiceAllowed) = apply {
            body.toolChoice(betaToolChoiceAllowed)
        }

        /**
         * Alias for calling [toolChoice] with
         * `ToolChoice.ofBetaToolChoiceTypes(betaToolChoiceTypes)`.
         */
        fun toolChoice(betaToolChoiceTypes: BetaToolChoiceTypes) = apply {
            body.toolChoice(betaToolChoiceTypes)
        }

        /**
         * Alias for calling [toolChoice] with
         * `ToolChoice.ofBetaToolChoiceFunction(betaToolChoiceFunction)`.
         */
        fun toolChoice(betaToolChoiceFunction: BetaToolChoiceFunction) = apply {
            body.toolChoice(betaToolChoiceFunction)
        }

        /**
         * Alias for calling [toolChoice] with `ToolChoice.ofBetaToolChoiceMcp(betaToolChoiceMcp)`.
         */
        fun toolChoice(betaToolChoiceMcp: BetaToolChoiceMcp) = apply {
            body.toolChoice(betaToolChoiceMcp)
        }

        /**
         * Alias for calling [toolChoice] with
         * `ToolChoice.ofBetaToolChoiceCustom(betaToolChoiceCustom)`.
         */
        fun toolChoice(betaToolChoiceCustom: BetaToolChoiceCustom) = apply {
            body.toolChoice(betaToolChoiceCustom)
        }

        /**
         * Alias for calling [toolChoice] with
         * `ToolChoice.ofBetaSpecificProgrammaticToolCallingParam()`.
         */
        fun toolChoiceBetaSpecificProgrammaticToolCallingParam() = apply {
            body.toolChoiceBetaSpecificProgrammaticToolCallingParam()
        }

        /**
         * Alias for calling [toolChoice] with
         * `ToolChoice.ofBetaToolChoiceApplyPatch(betaToolChoiceApplyPatch)`.
         */
        fun toolChoice(betaToolChoiceApplyPatch: BetaToolChoiceApplyPatch) = apply {
            body.toolChoice(betaToolChoiceApplyPatch)
        }

        /**
         * Alias for calling [toolChoice] with
         * `ToolChoice.ofBetaToolChoiceShell(betaToolChoiceShell)`.
         */
        fun toolChoice(betaToolChoiceShell: BetaToolChoiceShell) = apply {
            body.toolChoice(betaToolChoiceShell)
        }

        /**
         * An array of tools the model may call while generating a response. You can specify which
         * tool to use by setting the `tool_choice` parameter.
         */
        fun tools(tools: List<BetaTool>?) = apply { body.tools(tools) }

        /** Alias for calling [Builder.tools] with `tools.orElse(null)`. */
        fun tools(tools: Optional<List<BetaTool>>) = tools(tools.getOrNull())

        /**
         * Sets [Builder.tools] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tools] with a well-typed `List<BetaTool>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun tools(tools: JsonField<List<BetaTool>>) = apply { body.tools(tools) }

        /**
         * Adds a single [BetaTool] to [tools].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTool(tool: BetaTool) = apply { body.addTool(tool) }

        /** Alias for calling [addTool] with `BetaTool.ofFunction(function)`. */
        fun addTool(function: BetaFunctionTool) = apply { body.addTool(function) }

        /** Alias for calling [addTool] with `BetaTool.ofFileSearch(fileSearch)`. */
        fun addTool(fileSearch: BetaFileSearchTool) = apply { body.addTool(fileSearch) }

        /**
         * Alias for calling [addTool] with the following:
         * ```java
         * BetaFileSearchTool.builder()
         *     .vectorStoreIds(vectorStoreIds)
         *     .build()
         * ```
         */
        fun addFileSearchTool(vectorStoreIds: List<String>) = apply {
            body.addFileSearchTool(vectorStoreIds)
        }

        /** Alias for calling [addTool] with `BetaTool.ofComputer(computer)`. */
        fun addTool(computer: BetaComputerTool) = apply { body.addTool(computer) }

        /** Alias for calling [addTool] with `BetaTool.ofComputerUsePreview(computerUsePreview)`. */
        fun addTool(computerUsePreview: BetaComputerUsePreviewTool) = apply {
            body.addTool(computerUsePreview)
        }

        /** Alias for calling [addTool] with `BetaTool.ofWebSearch(webSearch)`. */
        fun addTool(webSearch: BetaWebSearchTool) = apply { body.addTool(webSearch) }

        /** Alias for calling [addTool] with `BetaTool.ofMcp(mcp)`. */
        fun addTool(mcp: BetaTool.Mcp) = apply { body.addTool(mcp) }

        /**
         * Alias for calling [addTool] with the following:
         * ```java
         * BetaTool.Mcp.builder()
         *     .serverLabel(serverLabel)
         *     .build()
         * ```
         */
        fun addMcpTool(serverLabel: String) = apply { body.addMcpTool(serverLabel) }

        /** Alias for calling [addTool] with `BetaTool.ofCodeInterpreter(codeInterpreter)`. */
        fun addTool(codeInterpreter: BetaTool.CodeInterpreter) = apply {
            body.addTool(codeInterpreter)
        }

        /**
         * Alias for calling [addTool] with the following:
         * ```java
         * BetaTool.CodeInterpreter.builder()
         *     .container(container)
         *     .build()
         * ```
         */
        fun addCodeInterpreterTool(container: BetaTool.CodeInterpreter.Container) = apply {
            body.addCodeInterpreterTool(container)
        }

        /**
         * Alias for calling [addCodeInterpreterTool] with
         * `BetaTool.CodeInterpreter.Container.ofString(string)`.
         */
        fun addCodeInterpreterTool(string: String) = apply { body.addCodeInterpreterTool(string) }

        /**
         * Alias for calling [addCodeInterpreterTool] with
         * `BetaTool.CodeInterpreter.Container.ofCodeInterpreterToolAuto(codeInterpreterToolAuto)`.
         */
        fun addCodeInterpreterTool(
            codeInterpreterToolAuto: BetaTool.CodeInterpreter.Container.CodeInterpreterToolAuto
        ) = apply { body.addCodeInterpreterTool(codeInterpreterToolAuto) }

        /** Alias for calling [addTool] with `BetaTool.ofProgrammaticToolCalling()`. */
        fun addToolProgrammaticToolCalling() = apply { body.addToolProgrammaticToolCalling() }

        /** Alias for calling [addTool] with `BetaTool.ofImageGeneration(imageGeneration)`. */
        fun addTool(imageGeneration: BetaTool.ImageGeneration) = apply {
            body.addTool(imageGeneration)
        }

        /** Alias for calling [addTool] with `BetaTool.ofLocalShell()`. */
        fun addToolLocalShell() = apply { body.addToolLocalShell() }

        /** Alias for calling [addTool] with `BetaTool.ofShell(shell)`. */
        fun addTool(shell: BetaFunctionShellTool) = apply { body.addTool(shell) }

        /** Alias for calling [addTool] with `BetaTool.ofCustom(custom)`. */
        fun addTool(custom: BetaCustomTool) = apply { body.addTool(custom) }

        /**
         * Alias for calling [addTool] with the following:
         * ```java
         * BetaCustomTool.builder()
         *     .name(name)
         *     .build()
         * ```
         */
        fun addCustomTool(name: String) = apply { body.addCustomTool(name) }

        /** Alias for calling [addTool] with `BetaTool.ofNamespace(namespace)`. */
        fun addTool(namespace: BetaNamespaceTool) = apply { body.addTool(namespace) }

        /** Alias for calling [addTool] with `BetaTool.ofToolSearch(toolSearch)`. */
        fun addTool(toolSearch: BetaToolSearchTool) = apply { body.addTool(toolSearch) }

        /** Alias for calling [addTool] with `BetaTool.ofWebSearchPreview(webSearchPreview)`. */
        fun addTool(webSearchPreview: BetaWebSearchPreviewTool) = apply {
            body.addTool(webSearchPreview)
        }

        /** Alias for calling [addTool] with `BetaTool.ofApplyPatch(applyPatch)`. */
        fun addTool(applyPatch: BetaApplyPatchTool) = apply { body.addTool(applyPatch) }

        /**
         * The truncation strategy to use for the model response. - `auto`: If the input to this
         * Response exceeds the model's context window size, the model will truncate the response to
         * fit the context window by dropping items from the beginning of the conversation. -
         * `disabled` (default): If the input size will exceed the context window size for a model,
         * the request will fail with a 400 error.
         */
        @Deprecated("deprecated")
        fun truncation(truncation: Truncation) = apply { body.truncation(truncation) }

        /**
         * Sets [Builder.truncation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.truncation] with a well-typed [Truncation] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        @Deprecated("deprecated")
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
                betas?.toImmutable(),
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers =
        Headers.builder()
            .apply {
                betas?.forEach { put("openai-beta", it.toString()) }
                putAll(additionalHeaders)
            }
            .build()

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val conversation: JsonField<Conversation>,
        private val input: JsonField<Input>,
        private val instructions: JsonField<String>,
        private val model: JsonField<String>,
        private val parallelToolCalls: JsonField<Boolean>,
        private val personality: JsonField<Personality>,
        private val previousResponseId: JsonField<String>,
        private val reasoning: JsonField<Reasoning>,
        private val text: JsonField<Text>,
        private val toolChoice: JsonField<ToolChoice>,
        private val tools: JsonField<List<BetaTool>>,
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
            @JsonProperty("personality")
            @ExcludeMissing
            personality: JsonField<Personality> = JsonMissing.of(),
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
            @JsonProperty("tools")
            @ExcludeMissing
            tools: JsonField<List<BetaTool>> = JsonMissing.of(),
            @JsonProperty("truncation")
            @ExcludeMissing
            truncation: JsonField<Truncation> = JsonMissing.of(),
        ) : this(
            conversation,
            input,
            instructions,
            model,
            parallelToolCalls,
            personality,
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
         * A model-owned style preset to apply to this request. Omit this parameter to use the
         * model's default style. Supported values may expand over time. Values must be at most 64
         * characters.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun personality(): Optional<Personality> = personality.getOptional("personality")

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
        fun tools(): Optional<List<BetaTool>> = tools.getOptional("tools")

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
        @Deprecated("deprecated")
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
         * Returns the raw JSON value of [personality].
         *
         * Unlike [personality], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("personality")
        @ExcludeMissing
        fun _personality(): JsonField<Personality> = personality

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
        @JsonProperty("tools") @ExcludeMissing fun _tools(): JsonField<List<BetaTool>> = tools

        /**
         * Returns the raw JSON value of [truncation].
         *
         * Unlike [truncation], this method doesn't throw if the JSON field has an unexpected type.
         */
        @Deprecated("deprecated")
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
            private var personality: JsonField<Personality> = JsonMissing.of()
            private var previousResponseId: JsonField<String> = JsonMissing.of()
            private var reasoning: JsonField<Reasoning> = JsonMissing.of()
            private var text: JsonField<Text> = JsonMissing.of()
            private var toolChoice: JsonField<ToolChoice> = JsonMissing.of()
            private var tools: JsonField<MutableList<BetaTool>>? = null
            private var truncation: JsonField<Truncation> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                conversation = body.conversation
                input = body.input
                instructions = body.instructions
                model = body.model
                parallelToolCalls = body.parallelToolCalls
                personality = body.personality
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
             * `Conversation.ofBetaResponseConversationParam(betaResponseConversationParam)`.
             */
            fun conversation(betaResponseConversationParam: BetaResponseConversationParam) =
                conversation(
                    Conversation.ofBetaResponseConversationParam(betaResponseConversationParam)
                )

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

            /**
             * Alias for calling [input] with
             * `Input.ofBetaResponseInputItems(betaResponseInputItems)`.
             */
            fun inputOfBetaResponseInputItems(betaResponseInputItems: List<BetaResponseInputItem>) =
                input(Input.ofBetaResponseInputItems(betaResponseInputItems))

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
             * A model-owned style preset to apply to this request. Omit this parameter to use the
             * model's default style. Supported values may expand over time. Values must be at most
             * 64 characters.
             */
            fun personality(personality: Personality) = personality(JsonField.of(personality))

            /**
             * Sets [Builder.personality] to an arbitrary JSON value.
             *
             * You should usually call [Builder.personality] with a well-typed [Personality] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun personality(personality: JsonField<Personality>) = apply {
                this.personality = personality
            }

            /**
             * Sets [personality] to an arbitrary [String].
             *
             * You should usually call [personality] with a well-typed [Personality] constant
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun personality(value: String) = personality(Personality.of(value))

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

            /**
             * Alias for calling [toolChoice] with
             * `ToolChoice.ofBetaToolChoiceOptions(betaToolChoiceOptions)`.
             */
            fun toolChoice(betaToolChoiceOptions: BetaToolChoiceOptions) =
                toolChoice(ToolChoice.ofBetaToolChoiceOptions(betaToolChoiceOptions))

            /**
             * Alias for calling [toolChoice] with
             * `ToolChoice.ofBetaToolChoiceAllowed(betaToolChoiceAllowed)`.
             */
            fun toolChoice(betaToolChoiceAllowed: BetaToolChoiceAllowed) =
                toolChoice(ToolChoice.ofBetaToolChoiceAllowed(betaToolChoiceAllowed))

            /**
             * Alias for calling [toolChoice] with
             * `ToolChoice.ofBetaToolChoiceTypes(betaToolChoiceTypes)`.
             */
            fun toolChoice(betaToolChoiceTypes: BetaToolChoiceTypes) =
                toolChoice(ToolChoice.ofBetaToolChoiceTypes(betaToolChoiceTypes))

            /**
             * Alias for calling [toolChoice] with
             * `ToolChoice.ofBetaToolChoiceFunction(betaToolChoiceFunction)`.
             */
            fun toolChoice(betaToolChoiceFunction: BetaToolChoiceFunction) =
                toolChoice(ToolChoice.ofBetaToolChoiceFunction(betaToolChoiceFunction))

            /**
             * Alias for calling [toolChoice] with
             * `ToolChoice.ofBetaToolChoiceMcp(betaToolChoiceMcp)`.
             */
            fun toolChoice(betaToolChoiceMcp: BetaToolChoiceMcp) =
                toolChoice(ToolChoice.ofBetaToolChoiceMcp(betaToolChoiceMcp))

            /**
             * Alias for calling [toolChoice] with
             * `ToolChoice.ofBetaToolChoiceCustom(betaToolChoiceCustom)`.
             */
            fun toolChoice(betaToolChoiceCustom: BetaToolChoiceCustom) =
                toolChoice(ToolChoice.ofBetaToolChoiceCustom(betaToolChoiceCustom))

            /**
             * Alias for calling [toolChoice] with
             * `ToolChoice.ofBetaSpecificProgrammaticToolCallingParam()`.
             */
            fun toolChoiceBetaSpecificProgrammaticToolCallingParam() =
                toolChoice(ToolChoice.ofBetaSpecificProgrammaticToolCallingParam())

            /**
             * Alias for calling [toolChoice] with
             * `ToolChoice.ofBetaToolChoiceApplyPatch(betaToolChoiceApplyPatch)`.
             */
            fun toolChoice(betaToolChoiceApplyPatch: BetaToolChoiceApplyPatch) =
                toolChoice(ToolChoice.ofBetaToolChoiceApplyPatch(betaToolChoiceApplyPatch))

            /**
             * Alias for calling [toolChoice] with
             * `ToolChoice.ofBetaToolChoiceShell(betaToolChoiceShell)`.
             */
            fun toolChoice(betaToolChoiceShell: BetaToolChoiceShell) =
                toolChoice(ToolChoice.ofBetaToolChoiceShell(betaToolChoiceShell))

            /**
             * An array of tools the model may call while generating a response. You can specify
             * which tool to use by setting the `tool_choice` parameter.
             */
            fun tools(tools: List<BetaTool>?) = tools(JsonField.ofNullable(tools))

            /** Alias for calling [Builder.tools] with `tools.orElse(null)`. */
            fun tools(tools: Optional<List<BetaTool>>) = tools(tools.getOrNull())

            /**
             * Sets [Builder.tools] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tools] with a well-typed `List<BetaTool>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tools(tools: JsonField<List<BetaTool>>) = apply {
                this.tools = tools.map { it.toMutableList() }
            }

            /**
             * Adds a single [BetaTool] to [tools].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTool(tool: BetaTool) = apply {
                tools =
                    (tools ?: JsonField.of(mutableListOf())).also {
                        checkKnown("tools", it).add(tool)
                    }
            }

            /** Alias for calling [addTool] with `BetaTool.ofFunction(function)`. */
            fun addTool(function: BetaFunctionTool) = addTool(BetaTool.ofFunction(function))

            /** Alias for calling [addTool] with `BetaTool.ofFileSearch(fileSearch)`. */
            fun addTool(fileSearch: BetaFileSearchTool) = addTool(BetaTool.ofFileSearch(fileSearch))

            /**
             * Alias for calling [addTool] with the following:
             * ```java
             * BetaFileSearchTool.builder()
             *     .vectorStoreIds(vectorStoreIds)
             *     .build()
             * ```
             */
            fun addFileSearchTool(vectorStoreIds: List<String>) =
                addTool(BetaFileSearchTool.builder().vectorStoreIds(vectorStoreIds).build())

            /** Alias for calling [addTool] with `BetaTool.ofComputer(computer)`. */
            fun addTool(computer: BetaComputerTool) = addTool(BetaTool.ofComputer(computer))

            /**
             * Alias for calling [addTool] with `BetaTool.ofComputerUsePreview(computerUsePreview)`.
             */
            fun addTool(computerUsePreview: BetaComputerUsePreviewTool) =
                addTool(BetaTool.ofComputerUsePreview(computerUsePreview))

            /** Alias for calling [addTool] with `BetaTool.ofWebSearch(webSearch)`. */
            fun addTool(webSearch: BetaWebSearchTool) = addTool(BetaTool.ofWebSearch(webSearch))

            /** Alias for calling [addTool] with `BetaTool.ofMcp(mcp)`. */
            fun addTool(mcp: BetaTool.Mcp) = addTool(BetaTool.ofMcp(mcp))

            /**
             * Alias for calling [addTool] with the following:
             * ```java
             * BetaTool.Mcp.builder()
             *     .serverLabel(serverLabel)
             *     .build()
             * ```
             */
            fun addMcpTool(serverLabel: String) =
                addTool(BetaTool.Mcp.builder().serverLabel(serverLabel).build())

            /** Alias for calling [addTool] with `BetaTool.ofCodeInterpreter(codeInterpreter)`. */
            fun addTool(codeInterpreter: BetaTool.CodeInterpreter) =
                addTool(BetaTool.ofCodeInterpreter(codeInterpreter))

            /**
             * Alias for calling [addTool] with the following:
             * ```java
             * BetaTool.CodeInterpreter.builder()
             *     .container(container)
             *     .build()
             * ```
             */
            fun addCodeInterpreterTool(container: BetaTool.CodeInterpreter.Container) =
                addTool(BetaTool.CodeInterpreter.builder().container(container).build())

            /**
             * Alias for calling [addCodeInterpreterTool] with
             * `BetaTool.CodeInterpreter.Container.ofString(string)`.
             */
            fun addCodeInterpreterTool(string: String) =
                addCodeInterpreterTool(BetaTool.CodeInterpreter.Container.ofString(string))

            /**
             * Alias for calling [addCodeInterpreterTool] with
             * `BetaTool.CodeInterpreter.Container.ofCodeInterpreterToolAuto(codeInterpreterToolAuto)`.
             */
            fun addCodeInterpreterTool(
                codeInterpreterToolAuto: BetaTool.CodeInterpreter.Container.CodeInterpreterToolAuto
            ) =
                addCodeInterpreterTool(
                    BetaTool.CodeInterpreter.Container.ofCodeInterpreterToolAuto(
                        codeInterpreterToolAuto
                    )
                )

            /** Alias for calling [addTool] with `BetaTool.ofProgrammaticToolCalling()`. */
            fun addToolProgrammaticToolCalling() = addTool(BetaTool.ofProgrammaticToolCalling())

            /** Alias for calling [addTool] with `BetaTool.ofImageGeneration(imageGeneration)`. */
            fun addTool(imageGeneration: BetaTool.ImageGeneration) =
                addTool(BetaTool.ofImageGeneration(imageGeneration))

            /** Alias for calling [addTool] with `BetaTool.ofLocalShell()`. */
            fun addToolLocalShell() = addTool(BetaTool.ofLocalShell())

            /** Alias for calling [addTool] with `BetaTool.ofShell(shell)`. */
            fun addTool(shell: BetaFunctionShellTool) = addTool(BetaTool.ofShell(shell))

            /** Alias for calling [addTool] with `BetaTool.ofCustom(custom)`. */
            fun addTool(custom: BetaCustomTool) = addTool(BetaTool.ofCustom(custom))

            /**
             * Alias for calling [addTool] with the following:
             * ```java
             * BetaCustomTool.builder()
             *     .name(name)
             *     .build()
             * ```
             */
            fun addCustomTool(name: String) = addTool(BetaCustomTool.builder().name(name).build())

            /** Alias for calling [addTool] with `BetaTool.ofNamespace(namespace)`. */
            fun addTool(namespace: BetaNamespaceTool) = addTool(BetaTool.ofNamespace(namespace))

            /** Alias for calling [addTool] with `BetaTool.ofToolSearch(toolSearch)`. */
            fun addTool(toolSearch: BetaToolSearchTool) = addTool(BetaTool.ofToolSearch(toolSearch))

            /** Alias for calling [addTool] with `BetaTool.ofWebSearchPreview(webSearchPreview)`. */
            fun addTool(webSearchPreview: BetaWebSearchPreviewTool) =
                addTool(BetaTool.ofWebSearchPreview(webSearchPreview))

            /** Alias for calling [addTool] with `BetaTool.ofApplyPatch(applyPatch)`. */
            fun addTool(applyPatch: BetaApplyPatchTool) = addTool(BetaTool.ofApplyPatch(applyPatch))

            /**
             * The truncation strategy to use for the model response. - `auto`: If the input to this
             * Response exceeds the model's context window size, the model will truncate the
             * response to fit the context window by dropping items from the beginning of the
             * conversation. - `disabled` (default): If the input size will exceed the context
             * window size for a model, the request will fail with a 400 error.
             */
            @Deprecated("deprecated")
            fun truncation(truncation: Truncation) = truncation(JsonField.of(truncation))

            /**
             * Sets [Builder.truncation] to an arbitrary JSON value.
             *
             * You should usually call [Builder.truncation] with a well-typed [Truncation] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            @Deprecated("deprecated")
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
                    personality,
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

            conversation().ifPresent { it.validate() }
            input().ifPresent { it.validate() }
            instructions()
            model()
            parallelToolCalls()
            personality()
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
                (if (personality.asKnown().isPresent) 1 else 0) +
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
                personality == other.personality &&
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
                personality,
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
            "Body{conversation=$conversation, input=$input, instructions=$instructions, model=$model, parallelToolCalls=$parallelToolCalls, personality=$personality, previousResponseId=$previousResponseId, reasoning=$reasoning, text=$text, toolChoice=$toolChoice, tools=$tools, truncation=$truncation, additionalProperties=$additionalProperties}"
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
        private val betaResponseConversationParam: BetaResponseConversationParam? = null,
        private val _json: JsonValue? = null,
    ) {

        /** The unique ID of the conversation. */
        fun id(): Optional<String> = Optional.ofNullable(id)

        /** The conversation that this response belongs to. */
        fun betaResponseConversationParam(): Optional<BetaResponseConversationParam> =
            Optional.ofNullable(betaResponseConversationParam)

        fun isId(): Boolean = id != null

        fun isBetaResponseConversationParam(): Boolean = betaResponseConversationParam != null

        /** The unique ID of the conversation. */
        fun asId(): String = id.getOrThrow("id")

        /** The conversation that this response belongs to. */
        fun asBetaResponseConversationParam(): BetaResponseConversationParam =
            betaResponseConversationParam.getOrThrow("betaResponseConversationParam")

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
         * Optional<String> result = conversation.accept(new Conversation.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitId(String id) {
         *         return Optional.of(id.toString());
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
                id != null -> visitor.visitId(id)
                betaResponseConversationParam != null ->
                    visitor.visitBetaResponseConversationParam(betaResponseConversationParam)
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
        fun validate(): Conversation = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitId(id: String) {}

                    override fun visitBetaResponseConversationParam(
                        betaResponseConversationParam: BetaResponseConversationParam
                    ) {
                        betaResponseConversationParam.validate()
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

                    override fun visitBetaResponseConversationParam(
                        betaResponseConversationParam: BetaResponseConversationParam
                    ) = betaResponseConversationParam.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Conversation &&
                id == other.id &&
                betaResponseConversationParam == other.betaResponseConversationParam
        }

        override fun hashCode(): Int = Objects.hash(id, betaResponseConversationParam)

        override fun toString(): String =
            when {
                id != null -> "Conversation{id=$id}"
                betaResponseConversationParam != null ->
                    "Conversation{betaResponseConversationParam=$betaResponseConversationParam}"
                _json != null -> "Conversation{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Conversation")
            }

        companion object {

            /** The unique ID of the conversation. */
            @JvmStatic fun ofId(id: String) = Conversation(id = id)

            /** The conversation that this response belongs to. */
            @JvmStatic
            fun ofBetaResponseConversationParam(
                betaResponseConversationParam: BetaResponseConversationParam
            ) = Conversation(betaResponseConversationParam = betaResponseConversationParam)
        }

        /**
         * An interface that defines how to map each variant of [Conversation] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            /** The unique ID of the conversation. */
            fun visitId(id: String): T

            /** The conversation that this response belongs to. */
            fun visitBetaResponseConversationParam(
                betaResponseConversationParam: BetaResponseConversationParam
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
                            tryDeserialize(node, jacksonTypeRef<BetaResponseConversationParam>())
                                ?.let {
                                    Conversation(betaResponseConversationParam = it, _json = json)
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
                    value.betaResponseConversationParam != null ->
                        generator.writeObject(value.betaResponseConversationParam)
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
        private val betaResponseInputItems: List<BetaResponseInputItem>? = null,
        private val _json: JsonValue? = null,
    ) {

        /** A text input to the model, equivalent to a text input with the `user` role. */
        fun string(): Optional<String> = Optional.ofNullable(string)

        /** A list of one or many input items to the model, containing different content types. */
        fun betaResponseInputItems(): Optional<List<BetaResponseInputItem>> =
            Optional.ofNullable(betaResponseInputItems)

        fun isString(): Boolean = string != null

        fun isBetaResponseInputItems(): Boolean = betaResponseInputItems != null

        /** A text input to the model, equivalent to a text input with the `user` role. */
        fun asString(): String = string.getOrThrow("string")

        /** A list of one or many input items to the model, containing different content types. */
        fun asBetaResponseInputItems(): List<BetaResponseInputItem> =
            betaResponseInputItems.getOrThrow("betaResponseInputItems")

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
         * Optional<String> result = input.accept(new Input.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitString(String string) {
         *         return Optional.of(string.toString());
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
                string != null -> visitor.visitString(string)
                betaResponseInputItems != null ->
                    visitor.visitBetaResponseInputItems(betaResponseInputItems)
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
        fun validate(): Input = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitString(string: String) {}

                    override fun visitBetaResponseInputItems(
                        betaResponseInputItems: List<BetaResponseInputItem>
                    ) {
                        betaResponseInputItems.forEach { it.validate() }
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

                    override fun visitBetaResponseInputItems(
                        betaResponseInputItems: List<BetaResponseInputItem>
                    ) = betaResponseInputItems.sumOf { it.validity().toInt() }

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Input &&
                string == other.string &&
                betaResponseInputItems == other.betaResponseInputItems
        }

        override fun hashCode(): Int = Objects.hash(string, betaResponseInputItems)

        override fun toString(): String =
            when {
                string != null -> "Input{string=$string}"
                betaResponseInputItems != null ->
                    "Input{betaResponseInputItems=$betaResponseInputItems}"
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
            fun ofBetaResponseInputItems(betaResponseInputItems: List<BetaResponseInputItem>) =
                Input(betaResponseInputItems = betaResponseInputItems.toImmutable())
        }

        /** An interface that defines how to map each variant of [Input] to a value of type [T]. */
        interface Visitor<out T> {

            /** A text input to the model, equivalent to a text input with the `user` role. */
            fun visitString(string: String): T

            /**
             * A list of one or many input items to the model, containing different content types.
             */
            fun visitBetaResponseInputItems(betaResponseInputItems: List<BetaResponseInputItem>): T

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
                            tryDeserialize(node, jacksonTypeRef<List<BetaResponseInputItem>>())
                                ?.let { Input(betaResponseInputItems = it, _json = json) },
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
                    value.betaResponseInputItems != null ->
                        generator.writeObject(value.betaResponseInputItems)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Input")
                }
            }
        }
    }

    /**
     * A model-owned style preset to apply to this request. Omit this parameter to use the model's
     * default style. Supported values may expand over time. Values must be at most 64 characters.
     */
    class Personality @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

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

            @JvmField val FRIENDLY = of("friendly")

            @JvmField val PRAGMATIC = of("pragmatic")

            @JvmStatic fun of(value: String) = Personality(JsonField.of(value))
        }

        /** An enum containing [Personality]'s known values. */
        enum class Known {
            FRIENDLY,
            PRAGMATIC,
        }

        /**
         * An enum containing [Personality]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Personality] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            FRIENDLY,
            PRAGMATIC,
            /**
             * An enum member indicating that [Personality] was instantiated with an unknown value.
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
                FRIENDLY -> Value.FRIENDLY
                PRAGMATIC -> Value.PRAGMATIC
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
                FRIENDLY -> Known.FRIENDLY
                PRAGMATIC -> Known.PRAGMATIC
                else -> throw OpenAIInvalidDataException("Unknown Personality: $value")
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
        fun validate(): Personality = apply {
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

            return other is Personality && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * **gpt-5 and o-series models only** Configuration options for
     * [reasoning models](https://platform.openai.com/docs/guides/reasoning).
     */
    class Reasoning
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val context: JsonField<Context>,
        private val effort: JsonField<Effort>,
        private val generateSummary: JsonField<GenerateSummary>,
        private val mode: JsonField<Mode>,
        private val summary: JsonField<Summary>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("context") @ExcludeMissing context: JsonField<Context> = JsonMissing.of(),
            @JsonProperty("effort") @ExcludeMissing effort: JsonField<Effort> = JsonMissing.of(),
            @JsonProperty("generate_summary")
            @ExcludeMissing
            generateSummary: JsonField<GenerateSummary> = JsonMissing.of(),
            @JsonProperty("mode") @ExcludeMissing mode: JsonField<Mode> = JsonMissing.of(),
            @JsonProperty("summary") @ExcludeMissing summary: JsonField<Summary> = JsonMissing.of(),
        ) : this(context, effort, generateSummary, mode, summary, mutableMapOf())

        /**
         * Controls which reasoning items are rendered back to the model on later turns. If omitted
         * or set to `auto`, the model determines the context mode. The `gpt-5.6` model family
         * defaults to `all_turns`; earlier models default to `current_turn`.
         *
         * When returned on a response, this is the effective reasoning context mode used for the
         * response.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun context(): Optional<Context> = context.getOptional("context")

        /**
         * Constrains effort on reasoning for reasoning models. Currently supported values are
         * `none`, `minimal`, `low`, `medium`, `high`, `xhigh`, and `max`. Reducing reasoning effort
         * can result in faster responses and fewer tokens used on reasoning in a response. Not all
         * reasoning models support every value. See the
         * [reasoning guide](https://platform.openai.com/docs/guides/reasoning) for model-specific
         * support.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun effort(): Optional<Effort> = effort.getOptional("effort")

        /**
         * **Deprecated:** use `summary` instead.
         *
         * A summary of the reasoning performed by the model. This can be useful for debugging and
         * understanding the model's reasoning process. One of `auto`, `concise`, or `detailed`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        @Deprecated("deprecated")
        fun generateSummary(): Optional<GenerateSummary> =
            generateSummary.getOptional("generate_summary")

        /**
         * Controls the reasoning execution mode for the request.
         *
         * When returned on a response, this is the effective execution mode.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun mode(): Optional<Mode> = mode.getOptional("mode")

        /**
         * A summary of the reasoning performed by the model. This can be useful for debugging and
         * understanding the model's reasoning process. One of `auto`, `concise`, or `detailed`.
         *
         * `concise` is supported for `computer-use-preview` models and all reasoning models after
         * `gpt-5`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun summary(): Optional<Summary> = summary.getOptional("summary")

        /**
         * Returns the raw JSON value of [context].
         *
         * Unlike [context], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("context") @ExcludeMissing fun _context(): JsonField<Context> = context

        /**
         * Returns the raw JSON value of [effort].
         *
         * Unlike [effort], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("effort") @ExcludeMissing fun _effort(): JsonField<Effort> = effort

        /**
         * Returns the raw JSON value of [generateSummary].
         *
         * Unlike [generateSummary], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @Deprecated("deprecated")
        @JsonProperty("generate_summary")
        @ExcludeMissing
        fun _generateSummary(): JsonField<GenerateSummary> = generateSummary

        /**
         * Returns the raw JSON value of [mode].
         *
         * Unlike [mode], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("mode") @ExcludeMissing fun _mode(): JsonField<Mode> = mode

        /**
         * Returns the raw JSON value of [summary].
         *
         * Unlike [summary], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("summary") @ExcludeMissing fun _summary(): JsonField<Summary> = summary

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

            /** Returns a mutable builder for constructing an instance of [Reasoning]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Reasoning]. */
        class Builder internal constructor() {

            private var context: JsonField<Context> = JsonMissing.of()
            private var effort: JsonField<Effort> = JsonMissing.of()
            private var generateSummary: JsonField<GenerateSummary> = JsonMissing.of()
            private var mode: JsonField<Mode> = JsonMissing.of()
            private var summary: JsonField<Summary> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(reasoning: Reasoning) = apply {
                context = reasoning.context
                effort = reasoning.effort
                generateSummary = reasoning.generateSummary
                mode = reasoning.mode
                summary = reasoning.summary
                additionalProperties = reasoning.additionalProperties.toMutableMap()
            }

            /**
             * Controls which reasoning items are rendered back to the model on later turns. If
             * omitted or set to `auto`, the model determines the context mode. The `gpt-5.6` model
             * family defaults to `all_turns`; earlier models default to `current_turn`.
             *
             * When returned on a response, this is the effective reasoning context mode used for
             * the response.
             */
            fun context(context: Context?) = context(JsonField.ofNullable(context))

            /** Alias for calling [Builder.context] with `context.orElse(null)`. */
            fun context(context: Optional<Context>) = context(context.getOrNull())

            /**
             * Sets [Builder.context] to an arbitrary JSON value.
             *
             * You should usually call [Builder.context] with a well-typed [Context] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun context(context: JsonField<Context>) = apply { this.context = context }

            /**
             * Constrains effort on reasoning for reasoning models. Currently supported values are
             * `none`, `minimal`, `low`, `medium`, `high`, `xhigh`, and `max`. Reducing reasoning
             * effort can result in faster responses and fewer tokens used on reasoning in a
             * response. Not all reasoning models support every value. See the
             * [reasoning guide](https://platform.openai.com/docs/guides/reasoning) for
             * model-specific support.
             */
            fun effort(effort: Effort?) = effort(JsonField.ofNullable(effort))

            /** Alias for calling [Builder.effort] with `effort.orElse(null)`. */
            fun effort(effort: Optional<Effort>) = effort(effort.getOrNull())

            /**
             * Sets [Builder.effort] to an arbitrary JSON value.
             *
             * You should usually call [Builder.effort] with a well-typed [Effort] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun effort(effort: JsonField<Effort>) = apply { this.effort = effort }

            /**
             * **Deprecated:** use `summary` instead.
             *
             * A summary of the reasoning performed by the model. This can be useful for debugging
             * and understanding the model's reasoning process. One of `auto`, `concise`, or
             * `detailed`.
             */
            @Deprecated("deprecated")
            fun generateSummary(generateSummary: GenerateSummary?) =
                generateSummary(JsonField.ofNullable(generateSummary))

            /** Alias for calling [Builder.generateSummary] with `generateSummary.orElse(null)`. */
            @Deprecated("deprecated")
            fun generateSummary(generateSummary: Optional<GenerateSummary>) =
                generateSummary(generateSummary.getOrNull())

            /**
             * Sets [Builder.generateSummary] to an arbitrary JSON value.
             *
             * You should usually call [Builder.generateSummary] with a well-typed [GenerateSummary]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            @Deprecated("deprecated")
            fun generateSummary(generateSummary: JsonField<GenerateSummary>) = apply {
                this.generateSummary = generateSummary
            }

            /**
             * Controls the reasoning execution mode for the request.
             *
             * When returned on a response, this is the effective execution mode.
             */
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
             * Sets [mode] to an arbitrary [String].
             *
             * You should usually call [mode] with a well-typed [Mode] constant instead. This method
             * is primarily for setting the field to an undocumented or not yet supported value.
             */
            fun mode(value: String) = mode(Mode.of(value))

            /**
             * A summary of the reasoning performed by the model. This can be useful for debugging
             * and understanding the model's reasoning process. One of `auto`, `concise`, or
             * `detailed`.
             *
             * `concise` is supported for `computer-use-preview` models and all reasoning models
             * after `gpt-5`.
             */
            fun summary(summary: Summary?) = summary(JsonField.ofNullable(summary))

            /** Alias for calling [Builder.summary] with `summary.orElse(null)`. */
            fun summary(summary: Optional<Summary>) = summary(summary.getOrNull())

            /**
             * Sets [Builder.summary] to an arbitrary JSON value.
             *
             * You should usually call [Builder.summary] with a well-typed [Summary] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun summary(summary: JsonField<Summary>) = apply { this.summary = summary }

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
            fun build(): Reasoning =
                Reasoning(
                    context,
                    effort,
                    generateSummary,
                    mode,
                    summary,
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
        fun validate(): Reasoning = apply {
            if (validated) {
                return@apply
            }

            context().ifPresent { it.validate() }
            effort().ifPresent { it.validate() }
            generateSummary().ifPresent { it.validate() }
            mode()
            summary().ifPresent { it.validate() }
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
            (context.asKnown().getOrNull()?.validity() ?: 0) +
                (effort.asKnown().getOrNull()?.validity() ?: 0) +
                (generateSummary.asKnown().getOrNull()?.validity() ?: 0) +
                (if (mode.asKnown().isPresent) 1 else 0) +
                (summary.asKnown().getOrNull()?.validity() ?: 0)

        /**
         * Controls which reasoning items are rendered back to the model on later turns. If omitted
         * or set to `auto`, the model determines the context mode. The `gpt-5.6` model family
         * defaults to `all_turns`; earlier models default to `current_turn`.
         *
         * When returned on a response, this is the effective reasoning context mode used for the
         * response.
         */
        class Context @JsonCreator private constructor(private val value: JsonField<String>) :
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

                @JvmField val AUTO = of("auto")

                @JvmField val CURRENT_TURN = of("current_turn")

                @JvmField val ALL_TURNS = of("all_turns")

                @JvmStatic fun of(value: String) = Context(JsonField.of(value))
            }

            /** An enum containing [Context]'s known values. */
            enum class Known {
                AUTO,
                CURRENT_TURN,
                ALL_TURNS,
            }

            /**
             * An enum containing [Context]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Context] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                AUTO,
                CURRENT_TURN,
                ALL_TURNS,
                /**
                 * An enum member indicating that [Context] was instantiated with an unknown value.
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
                    AUTO -> Value.AUTO
                    CURRENT_TURN -> Value.CURRENT_TURN
                    ALL_TURNS -> Value.ALL_TURNS
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
                    AUTO -> Known.AUTO
                    CURRENT_TURN -> Known.CURRENT_TURN
                    ALL_TURNS -> Known.ALL_TURNS
                    else -> throw OpenAIInvalidDataException("Unknown Context: $value")
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
            fun validate(): Context = apply {
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

                return other is Context && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /**
         * Constrains effort on reasoning for reasoning models. Currently supported values are
         * `none`, `minimal`, `low`, `medium`, `high`, `xhigh`, and `max`. Reducing reasoning effort
         * can result in faster responses and fewer tokens used on reasoning in a response. Not all
         * reasoning models support every value. See the
         * [reasoning guide](https://platform.openai.com/docs/guides/reasoning) for model-specific
         * support.
         */
        class Effort @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val NONE = of("none")

                @JvmField val MINIMAL = of("minimal")

                @JvmField val LOW = of("low")

                @JvmField val MEDIUM = of("medium")

                @JvmField val HIGH = of("high")

                @JvmField val XHIGH = of("xhigh")

                @JvmField val MAX = of("max")

                @JvmStatic fun of(value: String) = Effort(JsonField.of(value))
            }

            /** An enum containing [Effort]'s known values. */
            enum class Known {
                NONE,
                MINIMAL,
                LOW,
                MEDIUM,
                HIGH,
                XHIGH,
                MAX,
            }

            /**
             * An enum containing [Effort]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Effort] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                NONE,
                MINIMAL,
                LOW,
                MEDIUM,
                HIGH,
                XHIGH,
                MAX,
                /**
                 * An enum member indicating that [Effort] was instantiated with an unknown value.
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
                    NONE -> Value.NONE
                    MINIMAL -> Value.MINIMAL
                    LOW -> Value.LOW
                    MEDIUM -> Value.MEDIUM
                    HIGH -> Value.HIGH
                    XHIGH -> Value.XHIGH
                    MAX -> Value.MAX
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
                    NONE -> Known.NONE
                    MINIMAL -> Known.MINIMAL
                    LOW -> Known.LOW
                    MEDIUM -> Known.MEDIUM
                    HIGH -> Known.HIGH
                    XHIGH -> Known.XHIGH
                    MAX -> Known.MAX
                    else -> throw OpenAIInvalidDataException("Unknown Effort: $value")
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
            fun validate(): Effort = apply {
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

                return other is Effort && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /**
         * **Deprecated:** use `summary` instead.
         *
         * A summary of the reasoning performed by the model. This can be useful for debugging and
         * understanding the model's reasoning process. One of `auto`, `concise`, or `detailed`.
         */
        @Deprecated("deprecated")
        class GenerateSummary
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

                @JvmField val AUTO = of("auto")

                @JvmField val CONCISE = of("concise")

                @JvmField val DETAILED = of("detailed")

                @JvmStatic fun of(value: String) = GenerateSummary(JsonField.of(value))
            }

            /** An enum containing [GenerateSummary]'s known values. */
            enum class Known {
                AUTO,
                CONCISE,
                DETAILED,
            }

            /**
             * An enum containing [GenerateSummary]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [GenerateSummary] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                AUTO,
                CONCISE,
                DETAILED,
                /**
                 * An enum member indicating that [GenerateSummary] was instantiated with an unknown
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
                    AUTO -> Value.AUTO
                    CONCISE -> Value.CONCISE
                    DETAILED -> Value.DETAILED
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
                    AUTO -> Known.AUTO
                    CONCISE -> Known.CONCISE
                    DETAILED -> Known.DETAILED
                    else -> throw OpenAIInvalidDataException("Unknown GenerateSummary: $value")
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
            fun validate(): GenerateSummary = apply {
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

                return other is GenerateSummary && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /**
         * Controls the reasoning execution mode for the request.
         *
         * When returned on a response, this is the effective execution mode.
         */
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

                @JvmField val STANDARD = of("standard")

                @JvmField val PRO = of("pro")

                @JvmStatic fun of(value: String) = Mode(JsonField.of(value))
            }

            /** An enum containing [Mode]'s known values. */
            enum class Known {
                STANDARD,
                PRO,
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
                STANDARD,
                PRO,
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
                    STANDARD -> Value.STANDARD
                    PRO -> Value.PRO
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
                    STANDARD -> Known.STANDARD
                    PRO -> Known.PRO
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

        /**
         * A summary of the reasoning performed by the model. This can be useful for debugging and
         * understanding the model's reasoning process. One of `auto`, `concise`, or `detailed`.
         *
         * `concise` is supported for `computer-use-preview` models and all reasoning models after
         * `gpt-5`.
         */
        class Summary @JsonCreator private constructor(private val value: JsonField<String>) :
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

                @JvmField val AUTO = of("auto")

                @JvmField val CONCISE = of("concise")

                @JvmField val DETAILED = of("detailed")

                @JvmStatic fun of(value: String) = Summary(JsonField.of(value))
            }

            /** An enum containing [Summary]'s known values. */
            enum class Known {
                AUTO,
                CONCISE,
                DETAILED,
            }

            /**
             * An enum containing [Summary]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Summary] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                AUTO,
                CONCISE,
                DETAILED,
                /**
                 * An enum member indicating that [Summary] was instantiated with an unknown value.
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
                    AUTO -> Value.AUTO
                    CONCISE -> Value.CONCISE
                    DETAILED -> Value.DETAILED
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
                    AUTO -> Known.AUTO
                    CONCISE -> Known.CONCISE
                    DETAILED -> Known.DETAILED
                    else -> throw OpenAIInvalidDataException("Unknown Summary: $value")
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
            fun validate(): Summary = apply {
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

                return other is Summary && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Reasoning &&
                context == other.context &&
                effort == other.effort &&
                generateSummary == other.generateSummary &&
                mode == other.mode &&
                summary == other.summary &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(context, effort, generateSummary, mode, summary, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Reasoning{context=$context, effort=$effort, generateSummary=$generateSummary, mode=$mode, summary=$summary, additionalProperties=$additionalProperties}"
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
        private val format: JsonField<BetaResponseFormatTextConfig>,
        private val verbosity: JsonField<Verbosity>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("format")
            @ExcludeMissing
            format: JsonField<BetaResponseFormatTextConfig> = JsonMissing.of(),
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
        fun format(): Optional<BetaResponseFormatTextConfig> = format.getOptional("format")

        /**
         * Constrains the verbosity of the model's response. Lower values will result in more
         * concise responses, while higher values will result in more verbose responses. Currently
         * supported values are `low`, `medium`, and `high`. The default is `medium`.
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
        fun _format(): JsonField<BetaResponseFormatTextConfig> = format

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

            private var format: JsonField<BetaResponseFormatTextConfig> = JsonMissing.of()
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
            fun format(format: BetaResponseFormatTextConfig) = format(JsonField.of(format))

            /**
             * Sets [Builder.format] to an arbitrary JSON value.
             *
             * You should usually call [Builder.format] with a well-typed
             * [BetaResponseFormatTextConfig] value instead. This method is primarily for setting
             * the field to an undocumented or not yet supported value.
             */
            fun format(format: JsonField<BetaResponseFormatTextConfig>) = apply {
                this.format = format
            }

            /** Alias for calling [format] with `BetaResponseFormatTextConfig.ofText()`. */
            fun formatText() = format(BetaResponseFormatTextConfig.ofText())

            /**
             * Alias for calling [format] with
             * `BetaResponseFormatTextConfig.ofJsonSchema(jsonSchema)`.
             */
            fun format(jsonSchema: BetaResponseFormatTextJsonSchemaConfig) =
                format(BetaResponseFormatTextConfig.ofJsonSchema(jsonSchema))

            /** Alias for calling [format] with `BetaResponseFormatTextConfig.ofJsonObject()`. */
            fun formatJsonObject() = format(BetaResponseFormatTextConfig.ofJsonObject())

            /**
             * Constrains the verbosity of the model's response. Lower values will result in more
             * concise responses, while higher values will result in more verbose responses.
             * Currently supported values are `low`, `medium`, and `high`. The default is `medium`.
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
         * supported values are `low`, `medium`, and `high`. The default is `medium`.
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
        private val betaToolChoiceOptions: BetaToolChoiceOptions? = null,
        private val betaToolChoiceAllowed: BetaToolChoiceAllowed? = null,
        private val betaToolChoiceTypes: BetaToolChoiceTypes? = null,
        private val betaToolChoiceFunction: BetaToolChoiceFunction? = null,
        private val betaToolChoiceMcp: BetaToolChoiceMcp? = null,
        private val betaToolChoiceCustom: BetaToolChoiceCustom? = null,
        private val betaSpecificProgrammaticToolCallingParam: JsonValue? = null,
        private val betaToolChoiceApplyPatch: BetaToolChoiceApplyPatch? = null,
        private val betaToolChoiceShell: BetaToolChoiceShell? = null,
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
        fun betaToolChoiceOptions(): Optional<BetaToolChoiceOptions> =
            Optional.ofNullable(betaToolChoiceOptions)

        /** Constrains the tools available to the model to a pre-defined set. */
        fun betaToolChoiceAllowed(): Optional<BetaToolChoiceAllowed> =
            Optional.ofNullable(betaToolChoiceAllowed)

        /**
         * Indicates that the model should use a built-in tool to generate a response.
         * [Learn more about built-in tools](https://platform.openai.com/docs/guides/tools).
         */
        fun betaToolChoiceTypes(): Optional<BetaToolChoiceTypes> =
            Optional.ofNullable(betaToolChoiceTypes)

        /** Use this option to force the model to call a specific function. */
        fun betaToolChoiceFunction(): Optional<BetaToolChoiceFunction> =
            Optional.ofNullable(betaToolChoiceFunction)

        /** Use this option to force the model to call a specific tool on a remote MCP server. */
        fun betaToolChoiceMcp(): Optional<BetaToolChoiceMcp> =
            Optional.ofNullable(betaToolChoiceMcp)

        /** Use this option to force the model to call a specific custom tool. */
        fun betaToolChoiceCustom(): Optional<BetaToolChoiceCustom> =
            Optional.ofNullable(betaToolChoiceCustom)

        fun betaSpecificProgrammaticToolCallingParam(): Optional<JsonValue> =
            Optional.ofNullable(betaSpecificProgrammaticToolCallingParam)

        /** Forces the model to call the apply_patch tool when executing a tool call. */
        fun betaToolChoiceApplyPatch(): Optional<BetaToolChoiceApplyPatch> =
            Optional.ofNullable(betaToolChoiceApplyPatch)

        /** Forces the model to call the shell tool when a tool call is required. */
        fun betaToolChoiceShell(): Optional<BetaToolChoiceShell> =
            Optional.ofNullable(betaToolChoiceShell)

        fun isBetaToolChoiceOptions(): Boolean = betaToolChoiceOptions != null

        fun isBetaToolChoiceAllowed(): Boolean = betaToolChoiceAllowed != null

        fun isBetaToolChoiceTypes(): Boolean = betaToolChoiceTypes != null

        fun isBetaToolChoiceFunction(): Boolean = betaToolChoiceFunction != null

        fun isBetaToolChoiceMcp(): Boolean = betaToolChoiceMcp != null

        fun isBetaToolChoiceCustom(): Boolean = betaToolChoiceCustom != null

        fun isBetaSpecificProgrammaticToolCallingParam(): Boolean =
            betaSpecificProgrammaticToolCallingParam != null

        fun isBetaToolChoiceApplyPatch(): Boolean = betaToolChoiceApplyPatch != null

        fun isBetaToolChoiceShell(): Boolean = betaToolChoiceShell != null

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
        fun asBetaToolChoiceOptions(): BetaToolChoiceOptions =
            betaToolChoiceOptions.getOrThrow("betaToolChoiceOptions")

        /** Constrains the tools available to the model to a pre-defined set. */
        fun asBetaToolChoiceAllowed(): BetaToolChoiceAllowed =
            betaToolChoiceAllowed.getOrThrow("betaToolChoiceAllowed")

        /**
         * Indicates that the model should use a built-in tool to generate a response.
         * [Learn more about built-in tools](https://platform.openai.com/docs/guides/tools).
         */
        fun asBetaToolChoiceTypes(): BetaToolChoiceTypes =
            betaToolChoiceTypes.getOrThrow("betaToolChoiceTypes")

        /** Use this option to force the model to call a specific function. */
        fun asBetaToolChoiceFunction(): BetaToolChoiceFunction =
            betaToolChoiceFunction.getOrThrow("betaToolChoiceFunction")

        /** Use this option to force the model to call a specific tool on a remote MCP server. */
        fun asBetaToolChoiceMcp(): BetaToolChoiceMcp =
            betaToolChoiceMcp.getOrThrow("betaToolChoiceMcp")

        /** Use this option to force the model to call a specific custom tool. */
        fun asBetaToolChoiceCustom(): BetaToolChoiceCustom =
            betaToolChoiceCustom.getOrThrow("betaToolChoiceCustom")

        fun asBetaSpecificProgrammaticToolCallingParam(): JsonValue =
            betaSpecificProgrammaticToolCallingParam.getOrThrow(
                "betaSpecificProgrammaticToolCallingParam"
            )

        /** Forces the model to call the apply_patch tool when executing a tool call. */
        fun asBetaToolChoiceApplyPatch(): BetaToolChoiceApplyPatch =
            betaToolChoiceApplyPatch.getOrThrow("betaToolChoiceApplyPatch")

        /** Forces the model to call the shell tool when a tool call is required. */
        fun asBetaToolChoiceShell(): BetaToolChoiceShell =
            betaToolChoiceShell.getOrThrow("betaToolChoiceShell")

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
         * Optional<String> result = toolChoice.accept(new ToolChoice.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitBetaToolChoiceOptions(BetaToolChoiceOptions betaToolChoiceOptions) {
         *         return Optional.of(betaToolChoiceOptions.toString());
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
                betaToolChoiceOptions != null ->
                    visitor.visitBetaToolChoiceOptions(betaToolChoiceOptions)
                betaToolChoiceAllowed != null ->
                    visitor.visitBetaToolChoiceAllowed(betaToolChoiceAllowed)
                betaToolChoiceTypes != null -> visitor.visitBetaToolChoiceTypes(betaToolChoiceTypes)
                betaToolChoiceFunction != null ->
                    visitor.visitBetaToolChoiceFunction(betaToolChoiceFunction)
                betaToolChoiceMcp != null -> visitor.visitBetaToolChoiceMcp(betaToolChoiceMcp)
                betaToolChoiceCustom != null ->
                    visitor.visitBetaToolChoiceCustom(betaToolChoiceCustom)
                betaSpecificProgrammaticToolCallingParam != null ->
                    visitor.visitBetaSpecificProgrammaticToolCallingParam(
                        betaSpecificProgrammaticToolCallingParam
                    )
                betaToolChoiceApplyPatch != null ->
                    visitor.visitBetaToolChoiceApplyPatch(betaToolChoiceApplyPatch)
                betaToolChoiceShell != null -> visitor.visitBetaToolChoiceShell(betaToolChoiceShell)
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
        fun validate(): ToolChoice = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitBetaToolChoiceOptions(
                        betaToolChoiceOptions: BetaToolChoiceOptions
                    ) {
                        betaToolChoiceOptions.validate()
                    }

                    override fun visitBetaToolChoiceAllowed(
                        betaToolChoiceAllowed: BetaToolChoiceAllowed
                    ) {
                        betaToolChoiceAllowed.validate()
                    }

                    override fun visitBetaToolChoiceTypes(
                        betaToolChoiceTypes: BetaToolChoiceTypes
                    ) {
                        betaToolChoiceTypes.validate()
                    }

                    override fun visitBetaToolChoiceFunction(
                        betaToolChoiceFunction: BetaToolChoiceFunction
                    ) {
                        betaToolChoiceFunction.validate()
                    }

                    override fun visitBetaToolChoiceMcp(betaToolChoiceMcp: BetaToolChoiceMcp) {
                        betaToolChoiceMcp.validate()
                    }

                    override fun visitBetaToolChoiceCustom(
                        betaToolChoiceCustom: BetaToolChoiceCustom
                    ) {
                        betaToolChoiceCustom.validate()
                    }

                    override fun visitBetaSpecificProgrammaticToolCallingParam(
                        betaSpecificProgrammaticToolCallingParam: JsonValue
                    ) {
                        betaSpecificProgrammaticToolCallingParam.let {
                            if (
                                it != JsonValue.from(mapOf("type" to "programmatic_tool_calling"))
                            ) {
                                throw OpenAIInvalidDataException(
                                    "'betaSpecificProgrammaticToolCallingParam' is invalid, received $it"
                                )
                            }
                        }
                    }

                    override fun visitBetaToolChoiceApplyPatch(
                        betaToolChoiceApplyPatch: BetaToolChoiceApplyPatch
                    ) {
                        betaToolChoiceApplyPatch.validate()
                    }

                    override fun visitBetaToolChoiceShell(
                        betaToolChoiceShell: BetaToolChoiceShell
                    ) {
                        betaToolChoiceShell.validate()
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
                    override fun visitBetaToolChoiceOptions(
                        betaToolChoiceOptions: BetaToolChoiceOptions
                    ) = betaToolChoiceOptions.validity()

                    override fun visitBetaToolChoiceAllowed(
                        betaToolChoiceAllowed: BetaToolChoiceAllowed
                    ) = betaToolChoiceAllowed.validity()

                    override fun visitBetaToolChoiceTypes(
                        betaToolChoiceTypes: BetaToolChoiceTypes
                    ) = betaToolChoiceTypes.validity()

                    override fun visitBetaToolChoiceFunction(
                        betaToolChoiceFunction: BetaToolChoiceFunction
                    ) = betaToolChoiceFunction.validity()

                    override fun visitBetaToolChoiceMcp(betaToolChoiceMcp: BetaToolChoiceMcp) =
                        betaToolChoiceMcp.validity()

                    override fun visitBetaToolChoiceCustom(
                        betaToolChoiceCustom: BetaToolChoiceCustom
                    ) = betaToolChoiceCustom.validity()

                    override fun visitBetaSpecificProgrammaticToolCallingParam(
                        betaSpecificProgrammaticToolCallingParam: JsonValue
                    ) =
                        betaSpecificProgrammaticToolCallingParam.let {
                            if (it == JsonValue.from(mapOf("type" to "programmatic_tool_calling")))
                                1
                            else 0
                        }

                    override fun visitBetaToolChoiceApplyPatch(
                        betaToolChoiceApplyPatch: BetaToolChoiceApplyPatch
                    ) = betaToolChoiceApplyPatch.validity()

                    override fun visitBetaToolChoiceShell(
                        betaToolChoiceShell: BetaToolChoiceShell
                    ) = betaToolChoiceShell.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ToolChoice &&
                betaToolChoiceOptions == other.betaToolChoiceOptions &&
                betaToolChoiceAllowed == other.betaToolChoiceAllowed &&
                betaToolChoiceTypes == other.betaToolChoiceTypes &&
                betaToolChoiceFunction == other.betaToolChoiceFunction &&
                betaToolChoiceMcp == other.betaToolChoiceMcp &&
                betaToolChoiceCustom == other.betaToolChoiceCustom &&
                betaSpecificProgrammaticToolCallingParam ==
                    other.betaSpecificProgrammaticToolCallingParam &&
                betaToolChoiceApplyPatch == other.betaToolChoiceApplyPatch &&
                betaToolChoiceShell == other.betaToolChoiceShell
        }

        override fun hashCode(): Int =
            Objects.hash(
                betaToolChoiceOptions,
                betaToolChoiceAllowed,
                betaToolChoiceTypes,
                betaToolChoiceFunction,
                betaToolChoiceMcp,
                betaToolChoiceCustom,
                betaSpecificProgrammaticToolCallingParam,
                betaToolChoiceApplyPatch,
                betaToolChoiceShell,
            )

        override fun toString(): String =
            when {
                betaToolChoiceOptions != null ->
                    "ToolChoice{betaToolChoiceOptions=$betaToolChoiceOptions}"
                betaToolChoiceAllowed != null ->
                    "ToolChoice{betaToolChoiceAllowed=$betaToolChoiceAllowed}"
                betaToolChoiceTypes != null ->
                    "ToolChoice{betaToolChoiceTypes=$betaToolChoiceTypes}"
                betaToolChoiceFunction != null ->
                    "ToolChoice{betaToolChoiceFunction=$betaToolChoiceFunction}"
                betaToolChoiceMcp != null -> "ToolChoice{betaToolChoiceMcp=$betaToolChoiceMcp}"
                betaToolChoiceCustom != null ->
                    "ToolChoice{betaToolChoiceCustom=$betaToolChoiceCustom}"
                betaSpecificProgrammaticToolCallingParam != null ->
                    "ToolChoice{betaSpecificProgrammaticToolCallingParam=$betaSpecificProgrammaticToolCallingParam}"
                betaToolChoiceApplyPatch != null ->
                    "ToolChoice{betaToolChoiceApplyPatch=$betaToolChoiceApplyPatch}"
                betaToolChoiceShell != null ->
                    "ToolChoice{betaToolChoiceShell=$betaToolChoiceShell}"
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
            @JvmStatic
            fun ofBetaToolChoiceOptions(betaToolChoiceOptions: BetaToolChoiceOptions) =
                ToolChoice(betaToolChoiceOptions = betaToolChoiceOptions)

            /** Constrains the tools available to the model to a pre-defined set. */
            @JvmStatic
            fun ofBetaToolChoiceAllowed(betaToolChoiceAllowed: BetaToolChoiceAllowed) =
                ToolChoice(betaToolChoiceAllowed = betaToolChoiceAllowed)

            /**
             * Indicates that the model should use a built-in tool to generate a response.
             * [Learn more about built-in tools](https://platform.openai.com/docs/guides/tools).
             */
            @JvmStatic
            fun ofBetaToolChoiceTypes(betaToolChoiceTypes: BetaToolChoiceTypes) =
                ToolChoice(betaToolChoiceTypes = betaToolChoiceTypes)

            /** Use this option to force the model to call a specific function. */
            @JvmStatic
            fun ofBetaToolChoiceFunction(betaToolChoiceFunction: BetaToolChoiceFunction) =
                ToolChoice(betaToolChoiceFunction = betaToolChoiceFunction)

            /**
             * Use this option to force the model to call a specific tool on a remote MCP server.
             */
            @JvmStatic
            fun ofBetaToolChoiceMcp(betaToolChoiceMcp: BetaToolChoiceMcp) =
                ToolChoice(betaToolChoiceMcp = betaToolChoiceMcp)

            /** Use this option to force the model to call a specific custom tool. */
            @JvmStatic
            fun ofBetaToolChoiceCustom(betaToolChoiceCustom: BetaToolChoiceCustom) =
                ToolChoice(betaToolChoiceCustom = betaToolChoiceCustom)

            @JvmStatic
            fun ofBetaSpecificProgrammaticToolCallingParam() =
                ToolChoice(
                    betaSpecificProgrammaticToolCallingParam =
                        JsonValue.from(mapOf("type" to "programmatic_tool_calling"))
                )

            /** Forces the model to call the apply_patch tool when executing a tool call. */
            @JvmStatic
            fun ofBetaToolChoiceApplyPatch(betaToolChoiceApplyPatch: BetaToolChoiceApplyPatch) =
                ToolChoice(betaToolChoiceApplyPatch = betaToolChoiceApplyPatch)

            /** Forces the model to call the shell tool when a tool call is required. */
            @JvmStatic
            fun ofBetaToolChoiceShell(betaToolChoiceShell: BetaToolChoiceShell) =
                ToolChoice(betaToolChoiceShell = betaToolChoiceShell)
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
            fun visitBetaToolChoiceOptions(betaToolChoiceOptions: BetaToolChoiceOptions): T

            /** Constrains the tools available to the model to a pre-defined set. */
            fun visitBetaToolChoiceAllowed(betaToolChoiceAllowed: BetaToolChoiceAllowed): T

            /**
             * Indicates that the model should use a built-in tool to generate a response.
             * [Learn more about built-in tools](https://platform.openai.com/docs/guides/tools).
             */
            fun visitBetaToolChoiceTypes(betaToolChoiceTypes: BetaToolChoiceTypes): T

            /** Use this option to force the model to call a specific function. */
            fun visitBetaToolChoiceFunction(betaToolChoiceFunction: BetaToolChoiceFunction): T

            /**
             * Use this option to force the model to call a specific tool on a remote MCP server.
             */
            fun visitBetaToolChoiceMcp(betaToolChoiceMcp: BetaToolChoiceMcp): T

            /** Use this option to force the model to call a specific custom tool. */
            fun visitBetaToolChoiceCustom(betaToolChoiceCustom: BetaToolChoiceCustom): T

            fun visitBetaSpecificProgrammaticToolCallingParam(
                betaSpecificProgrammaticToolCallingParam: JsonValue
            ): T

            /** Forces the model to call the apply_patch tool when executing a tool call. */
            fun visitBetaToolChoiceApplyPatch(betaToolChoiceApplyPatch: BetaToolChoiceApplyPatch): T

            /** Forces the model to call the shell tool when a tool call is required. */
            fun visitBetaToolChoiceShell(betaToolChoiceShell: BetaToolChoiceShell): T

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
                            tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                ?.let {
                                    ToolChoice(
                                        betaSpecificProgrammaticToolCallingParam = it,
                                        _json = json,
                                    )
                                }
                                ?.takeIf { it.isValid() },
                            tryDeserialize(node, jacksonTypeRef<BetaToolChoiceOptions>())?.let {
                                ToolChoice(betaToolChoiceOptions = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<BetaToolChoiceAllowed>())?.let {
                                ToolChoice(betaToolChoiceAllowed = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<BetaToolChoiceTypes>())?.let {
                                ToolChoice(betaToolChoiceTypes = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<BetaToolChoiceFunction>())?.let {
                                ToolChoice(betaToolChoiceFunction = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<BetaToolChoiceMcp>())?.let {
                                ToolChoice(betaToolChoiceMcp = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<BetaToolChoiceCustom>())?.let {
                                ToolChoice(betaToolChoiceCustom = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<BetaToolChoiceApplyPatch>())?.let {
                                ToolChoice(betaToolChoiceApplyPatch = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<BetaToolChoiceShell>())?.let {
                                ToolChoice(betaToolChoiceShell = it, _json = json)
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
                    value.betaToolChoiceOptions != null ->
                        generator.writeObject(value.betaToolChoiceOptions)
                    value.betaToolChoiceAllowed != null ->
                        generator.writeObject(value.betaToolChoiceAllowed)
                    value.betaToolChoiceTypes != null ->
                        generator.writeObject(value.betaToolChoiceTypes)
                    value.betaToolChoiceFunction != null ->
                        generator.writeObject(value.betaToolChoiceFunction)
                    value.betaToolChoiceMcp != null ->
                        generator.writeObject(value.betaToolChoiceMcp)
                    value.betaToolChoiceCustom != null ->
                        generator.writeObject(value.betaToolChoiceCustom)
                    value.betaSpecificProgrammaticToolCallingParam != null ->
                        generator.writeObject(value.betaSpecificProgrammaticToolCallingParam)
                    value.betaToolChoiceApplyPatch != null ->
                        generator.writeObject(value.betaToolChoiceApplyPatch)
                    value.betaToolChoiceShell != null ->
                        generator.writeObject(value.betaToolChoiceShell)
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
    @Deprecated("deprecated")
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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
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

    class Beta @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val RESPONSES_MULTI_AGENT_V1 = of("responses_multi_agent=v1")

            @JvmStatic fun of(value: String) = Beta(JsonField.of(value))
        }

        /** An enum containing [Beta]'s known values. */
        enum class Known {
            RESPONSES_MULTI_AGENT_V1
        }

        /**
         * An enum containing [Beta]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Beta] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            RESPONSES_MULTI_AGENT_V1,
            /** An enum member indicating that [Beta] was instantiated with an unknown value. */
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
                RESPONSES_MULTI_AGENT_V1 -> Value.RESPONSES_MULTI_AGENT_V1
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
                RESPONSES_MULTI_AGENT_V1 -> Known.RESPONSES_MULTI_AGENT_V1
                else -> throw OpenAIInvalidDataException("Unknown Beta: $value")
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
        fun validate(): Beta = apply {
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

            return other is Beta && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InputTokenCountParams &&
            betas == other.betas &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(betas, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "InputTokenCountParams{betas=$betas, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
