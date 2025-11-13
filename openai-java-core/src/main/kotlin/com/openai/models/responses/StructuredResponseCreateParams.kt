package com.openai.models.responses

import com.openai.core.JsonField
import com.openai.core.JsonSchemaLocalValidation
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.textConfigFromClass
import com.openai.models.ChatModel
import com.openai.models.Reasoning
import com.openai.models.ResponsesModel
import java.util.Objects
import java.util.Optional

/**
 * A wrapper for [ResponseCreateParams] that provides a type-safe [Builder] that can record the
 * [responseType] used to derive a JSON schema from an arbitrary class when using the _Structured
 * Outputs_ feature. When a JSON response is received, it is deserialized to an instance of that
 * type. See the SDK documentation for more details on _Structured Outputs_.
 *
 * @param T The type of the class that will be used to derive the JSON schema in the request and to
 *   which the JSON response will be deserialized.
 */
class StructuredResponseCreateParams<T : Any>(
    @get:JvmName("responseType") val responseType: Class<T>,
    /**
     * The raw, underlying response create parameters wrapped by this structured instance of the
     * parameters.
     */
    @get:JvmName("rawParams") val rawParams: ResponseCreateParams,
) {

    companion object {
        /** @see ResponseCreateParams.builder */
        @JvmStatic fun <T : Any> builder() = Builder<T>()
    }

    class Builder<T : Any> internal constructor() {
        private var responseType: Class<T>? = null
        private var paramsBuilder = ResponseCreateParams.builder()

        @JvmSynthetic
        internal fun wrap(
            responseType: Class<T>,
            paramsBuilder: ResponseCreateParams.Builder,
            localValidation: JsonSchemaLocalValidation,
        ) = apply {
            this.responseType = responseType
            this.paramsBuilder = paramsBuilder
            text(responseType, localValidation)
        }

        @JvmSynthetic
        internal fun wrap(
            textConfig: StructuredResponseTextConfig<T>,
            paramsBuilder: ResponseCreateParams.Builder,
        ) = apply {
            this.responseType = textConfig.responseType
            this.paramsBuilder = paramsBuilder
            text(textConfig)
        }

        /** Injects a given `ResponseCreateParams.Builder`. For use only when testing. */
        @JvmSynthetic
        internal fun inject(paramsBuilder: ResponseCreateParams.Builder) = apply {
            this.paramsBuilder = paramsBuilder
        }

        // The `body(...)` function is deliberately not supported.

        /** @see ResponseCreateParams.Builder.input */
        fun input(input: ResponseCreateParams.Input) = apply { paramsBuilder.input(input) }

        /** @see ResponseCreateParams.Builder.input */
        fun input(input: JsonField<ResponseCreateParams.Input>) = apply {
            paramsBuilder.input(input)
        }

        /** @see ResponseCreateParams.Builder.input */
        fun input(text: String) = apply { paramsBuilder.input(text) }

        /** @see ResponseCreateParams.Builder.inputOfResponse */
        fun inputOfResponse(response: List<ResponseInputItem>) = apply {
            paramsBuilder.inputOfResponse(response)
        }

        /** @see ResponseCreateParams.Builder.model */
        fun model(model: ResponsesModel) = apply { paramsBuilder.model(model) }

        /** @see ResponseCreateParams.Builder.model */
        fun model(model: JsonField<ResponsesModel>) = apply { paramsBuilder.model(model) }

        /** @see ResponseCreateParams.Builder.model */
        fun model(string: String) = apply { paramsBuilder.model(string) }

        /** @see ResponseCreateParams.Builder.model */
        fun model(chat: ChatModel) = apply { paramsBuilder.model(chat) }

        /** @see ResponseCreateParams.Builder.model */
        fun model(only: ResponsesModel.ResponsesOnlyModel) = apply { paramsBuilder.model(only) }

        /** @see ResponseCreateParams.Builder.background */
        fun background(background: Boolean?) = apply { paramsBuilder.background(background) }

        /** @see ResponseCreateParams.Builder.background */
        fun background(background: Boolean) = apply { paramsBuilder.background(background) }

        /** @see ResponseCreateParams.Builder.background */
        fun background(background: Optional<Boolean>) = apply {
            paramsBuilder.background(background)
        }

        /** @see ResponseCreateParams.Builder.background */
        fun background(background: JsonField<Boolean>) = apply {
            paramsBuilder.background(background)
        }

        /** @see ResponseCreateParams.Builder.conversation */
        fun conversation(conversation: ResponseCreateParams.Conversation?) = apply {
            paramsBuilder.conversation(conversation)
        }

        /** @see ResponseCreateParams.Builder.conversation */
        fun conversation(conversation: Optional<ResponseCreateParams.Conversation>) = apply {
            paramsBuilder.conversation(conversation)
        }

        /** @see ResponseCreateParams.Builder.conversation */
        fun conversation(conversation: JsonField<ResponseCreateParams.Conversation>) = apply {
            paramsBuilder.conversation(conversation)
        }

        /** @see ResponseCreateParams.Builder.conversation */
        fun conversation(id: String) = apply { paramsBuilder.conversation(id) }

        /** @see ResponseCreateParams.Builder.conversation */
        fun conversation(responseConversationParam: ResponseConversationParam) = apply {
            paramsBuilder.conversation(responseConversationParam)
        }

        /** @see ResponseCreateParams.Builder.include */
        fun include(include: List<ResponseIncludable>?) = apply { paramsBuilder.include(include) }

        /** @see ResponseCreateParams.Builder.include */
        fun include(include: Optional<List<ResponseIncludable>>) = apply {
            paramsBuilder.include(include)
        }

        /** @see ResponseCreateParams.Builder.include */
        fun include(include: JsonField<List<ResponseIncludable>>) = apply {
            paramsBuilder.include(include)
        }

        /** @see ResponseCreateParams.Builder.addInclude */
        fun addInclude(include: ResponseIncludable) = apply { paramsBuilder.addInclude(include) }

        /** @see ResponseCreateParams.Builder.instructions */
        fun instructions(instructions: String?) = apply { paramsBuilder.instructions(instructions) }

        /** @see ResponseCreateParams.Builder.instructions */
        fun instructions(instructions: Optional<String>) = apply {
            paramsBuilder.instructions(instructions)
        }

        /** @see ResponseCreateParams.Builder.instructions */
        fun instructions(instructions: JsonField<String>) = apply {
            paramsBuilder.instructions(instructions)
        }

        /** @see ResponseCreateParams.Builder.maxOutputTokens */
        fun maxOutputTokens(maxOutputTokens: Long?) = apply {
            paramsBuilder.maxOutputTokens(maxOutputTokens)
        }

        /** @see ResponseCreateParams.Builder.maxOutputTokens */
        fun maxOutputTokens(maxOutputTokens: Long) = apply {
            paramsBuilder.maxOutputTokens(maxOutputTokens)
        }

        /** @see ResponseCreateParams.Builder.maxOutputTokens */
        fun maxOutputTokens(maxOutputTokens: Optional<Long>) = apply {
            paramsBuilder.maxOutputTokens(maxOutputTokens)
        }

        /** @see ResponseCreateParams.Builder.maxOutputTokens */
        fun maxOutputTokens(maxOutputTokens: JsonField<Long>) = apply {
            paramsBuilder.maxOutputTokens(maxOutputTokens)
        }

        /** @see ResponseCreateParams.Builder.maxToolCalls */
        fun maxToolCalls(maxToolCalls: Long?) = apply { paramsBuilder.maxToolCalls(maxToolCalls) }

        /** @see ResponseCreateParams.Builder.maxToolCalls */
        fun maxToolCalls(maxToolCalls: Long) = apply { paramsBuilder.maxToolCalls(maxToolCalls) }

        /** @see ResponseCreateParams.Builder.maxToolCalls */
        fun maxToolCalls(maxToolCalls: Optional<Long>) = apply {
            paramsBuilder.maxToolCalls(maxToolCalls)
        }

        /** @see ResponseCreateParams.Builder.maxToolCalls */
        fun maxToolCalls(maxToolCalls: JsonField<Long>) = apply {
            paramsBuilder.maxToolCalls(maxToolCalls)
        }

        /** @see ResponseCreateParams.Builder.metadata */
        fun metadata(metadata: ResponseCreateParams.Metadata?) = apply {
            paramsBuilder.metadata(metadata)
        }

        /** @see ResponseCreateParams.Builder.metadata */
        fun metadata(metadata: Optional<ResponseCreateParams.Metadata>) = apply {
            paramsBuilder.metadata(metadata)
        }

        /** @see ResponseCreateParams.Builder.metadata */
        fun metadata(metadata: JsonField<ResponseCreateParams.Metadata>) = apply {
            paramsBuilder.metadata(metadata)
        }

        /** @see ResponseCreateParams.Builder.parallelToolCalls */
        fun parallelToolCalls(parallelToolCalls: Boolean?) = apply {
            paramsBuilder.parallelToolCalls(parallelToolCalls)
        }

        /** @see ResponseCreateParams.Builder.parallelToolCalls */
        fun parallelToolCalls(parallelToolCalls: Boolean) = apply {
            paramsBuilder.parallelToolCalls(parallelToolCalls)
        }

        /** @see ResponseCreateParams.Builder.parallelToolCalls */
        fun parallelToolCalls(parallelToolCalls: Optional<Boolean>) = apply {
            paramsBuilder.parallelToolCalls(parallelToolCalls)
        }

        /** @see ResponseCreateParams.Builder.parallelToolCalls */
        fun parallelToolCalls(parallelToolCalls: JsonField<Boolean>) = apply {
            paramsBuilder.parallelToolCalls(parallelToolCalls)
        }

        /** @see ResponseCreateParams.Builder.previousResponseId */
        fun previousResponseId(previousResponseId: String?) = apply {
            paramsBuilder.previousResponseId(previousResponseId)
        }

        /** @see ResponseCreateParams.Builder.previousResponseId */
        fun previousResponseId(previousResponseId: Optional<String>) = apply {
            paramsBuilder.previousResponseId(previousResponseId)
        }

        /** @see ResponseCreateParams.Builder.previousResponseId */
        fun previousResponseId(previousResponseId: JsonField<String>) = apply {
            paramsBuilder.previousResponseId(previousResponseId)
        }

        /** @see ResponseCreateParams.Builder.prompt */
        fun prompt(prompt: ResponsePrompt?) = apply { paramsBuilder.prompt(prompt) }

        /** @see ResponseCreateParams.Builder.prompt */
        fun prompt(prompt: Optional<ResponsePrompt>) = apply { paramsBuilder.prompt(prompt) }

        /** @see ResponseCreateParams.Builder.prompt */
        fun prompt(prompt: JsonField<ResponsePrompt>) = apply { paramsBuilder.prompt(prompt) }

        /** @see ResponseCreateParams.Builder.promptCacheKey */
        fun promptCacheKey(promptCacheKey: String) = apply {
            paramsBuilder.promptCacheKey(promptCacheKey)
        }

        /** @see ResponseCreateParams.Builder.promptCacheKey */
        fun promptCacheKey(promptCacheKey: JsonField<String>) = apply {
            paramsBuilder.promptCacheKey(promptCacheKey)
        }

        /** @see ResponseCreateParams.Builder.promptCacheRetention */
        fun promptCacheRetention(promptCacheRetention: ResponseCreateParams.PromptCacheRetention?) =
            apply {
                paramsBuilder.promptCacheRetention(promptCacheRetention)
            }

        /** @see ResponseCreateParams.Builder.promptCacheRetention */
        fun promptCacheRetention(
            promptCacheRetention: Optional<ResponseCreateParams.PromptCacheRetention>
        ) = apply { paramsBuilder.promptCacheRetention(promptCacheRetention) }

        /** @see ResponseCreateParams.Builder.promptCacheRetention */
        fun promptCacheRetention(
            promptCacheRetention: JsonField<ResponseCreateParams.PromptCacheRetention>
        ) = apply { paramsBuilder.promptCacheRetention(promptCacheRetention) }

        /** @see ResponseCreateParams.Builder.reasoning */
        fun reasoning(reasoning: Reasoning?) = apply { paramsBuilder.reasoning(reasoning) }

        /** @see ResponseCreateParams.Builder.reasoning */
        fun reasoning(reasoning: Optional<Reasoning>) = apply { paramsBuilder.reasoning(reasoning) }

        /** @see ResponseCreateParams.Builder.reasoning */
        fun reasoning(reasoning: JsonField<Reasoning>) = apply {
            paramsBuilder.reasoning(reasoning)
        }

        /** @see ResponseCreateParams.Builder.safetyIdentifier */
        fun safetyIdentifier(safetyIdentifier: String) = apply {
            paramsBuilder.safetyIdentifier(safetyIdentifier)
        }

        /** @see ResponseCreateParams.Builder.safetyIdentifier */
        fun safetyIdentifier(safetyIdentifier: JsonField<String>) = apply {
            paramsBuilder.safetyIdentifier(safetyIdentifier)
        }

        /** @see ResponseCreateParams.Builder.serviceTier */
        fun serviceTier(serviceTier: ResponseCreateParams.ServiceTier?) = apply {
            paramsBuilder.serviceTier(serviceTier)
        }

        /** @see ResponseCreateParams.Builder.serviceTier */
        fun serviceTier(serviceTier: Optional<ResponseCreateParams.ServiceTier>) = apply {
            paramsBuilder.serviceTier(serviceTier)
        }

        /** @see ResponseCreateParams.Builder.serviceTier */
        fun serviceTier(serviceTier: JsonField<ResponseCreateParams.ServiceTier>) = apply {
            paramsBuilder.serviceTier(serviceTier)
        }

        /** @see ResponseCreateParams.Builder.store */
        fun store(store: Boolean?) = apply { paramsBuilder.store(store) }

        /** @see ResponseCreateParams.Builder.store */
        fun store(store: Boolean) = apply { paramsBuilder.store(store) }

        /** @see ResponseCreateParams.Builder.store */
        fun store(store: Optional<Boolean>) = apply { paramsBuilder.store(store) }

        /** @see ResponseCreateParams.Builder.store */
        fun store(store: JsonField<Boolean>) = apply { paramsBuilder.store(store) }

        /** @see ResponseCreateParams.Builder.temperature */
        fun temperature(temperature: Double?) = apply { paramsBuilder.temperature(temperature) }

        /** @see ResponseCreateParams.Builder.temperature */
        fun temperature(temperature: Double) = apply { paramsBuilder.temperature(temperature) }

        /** @see ResponseCreateParams.Builder.temperature */
        fun temperature(temperature: Optional<Double>) = apply {
            paramsBuilder.temperature(temperature)
        }

        /** @see ResponseCreateParams.Builder.temperature */
        fun temperature(temperature: JsonField<Double>) = apply {
            paramsBuilder.temperature(temperature)
        }

        /**
         * Sets the text configuration's format to a JSON schema derived from the structure of the
         * given class.
         *
         * @see ResponseCreateParams.Builder.text
         */
        @JvmOverloads
        fun text(
            responseType: Class<T>,
            localValidation: JsonSchemaLocalValidation = JsonSchemaLocalValidation.YES,
        ) = apply {
            this.responseType = responseType
            paramsBuilder.text(textConfigFromClass(responseType, localValidation))
        }

        /**
         * Sets the text configuration to a [StructuredResponseTextConfig] where the format was set
         * to a JSON schema derived from the structure of a class.
         *
         * @see ResponseCreateParams.Builder.text
         */
        fun text(text: StructuredResponseTextConfig<T>) = apply {
            this.responseType = text.responseType
            paramsBuilder.text(text.rawConfig)
        }

        /** @see ResponseCreateParams.Builder.toolChoice */
        fun toolChoice(toolChoice: ResponseCreateParams.ToolChoice) = apply {
            paramsBuilder.toolChoice(toolChoice)
        }

        /** @see ResponseCreateParams.Builder.toolChoice */
        fun toolChoice(toolChoice: JsonField<ResponseCreateParams.ToolChoice>) = apply {
            paramsBuilder.toolChoice(toolChoice)
        }

        /** @see ResponseCreateParams.Builder.toolChoice */
        fun toolChoice(options: ToolChoiceOptions) = apply { paramsBuilder.toolChoice(options) }

        /** @see ResponseCreateParams.Builder.toolChoice */
        fun toolChoice(types: ToolChoiceTypes) = apply { paramsBuilder.toolChoice(types) }

        /** @see ResponseCreateParams.Builder.toolChoice */
        fun toolChoice(function: ToolChoiceFunction) = apply { paramsBuilder.toolChoice(function) }

        /** @see ResponseCreateParams.Builder.toolChoice */
        fun toolChoice(mcp: ToolChoiceMcp) = apply { paramsBuilder.toolChoice(mcp) }

        /** @see ResponseCreateParams.Builder.toolChoice */
        fun toolChoice(allowed: com.openai.models.responses.ToolChoiceAllowed) = apply {
            paramsBuilder.toolChoice(allowed)
        }

        /** @see ResponseCreateParams.Builder.toolChoice */
        fun toolChoice(custom: ToolChoiceCustom) = apply { paramsBuilder.toolChoice(custom) }

        /** @see ResponseCreateParams.Builder.toolChoice */
        fun toolChoice(applyPatch: ToolChoiceApplyPatch) = apply {
            paramsBuilder.toolChoice(applyPatch)
        }

        /** @see ResponseCreateParams.Builder.toolChoice */
        fun toolChoice(shell: ToolChoiceShell) = apply { paramsBuilder.toolChoice(shell) }

        /** @see ResponseCreateParams.Builder.tools */
        fun tools(tools: List<Tool>) = apply { paramsBuilder.tools(tools) }

        /** @see ResponseCreateParams.Builder.tools */
        fun tools(tools: JsonField<List<Tool>>) = apply { paramsBuilder.tools(tools) }

        /** @see ResponseCreateParams.Builder.addTool */
        fun addTool(tool: Tool) = apply { paramsBuilder.addTool(tool) }

        /** @see ResponseCreateParams.Builder.addTool */
        fun addTool(function: FunctionTool) = apply { paramsBuilder.addTool(function) }

        /** @see ResponseCreateParams.Builder.addTool */
        @JvmOverloads
        fun addTool(
            functionParametersType: Class<*>,
            localValidation: JsonSchemaLocalValidation = JsonSchemaLocalValidation.YES,
        ) = apply { paramsBuilder.addTool(functionParametersType, localValidation) }

        /** @see ResponseCreateParams.Builder.addTool */
        fun addTool(fileSearch: FileSearchTool) = apply { paramsBuilder.addTool(fileSearch) }

        /** @see ResponseCreateParams.Builder.addFileSearchTool */
        fun addFileSearchTool(vectorStoreIds: List<String>) = apply {
            paramsBuilder.addFileSearchTool(vectorStoreIds)
        }

        /** @see ResponseCreateParams.Builder.addTool */
        fun addTool(webSearch: WebSearchTool) = apply { paramsBuilder.addTool(webSearch) }

        /** @see ResponseCreateParams.Builder.addTool */
        fun addTool(webSearchPreview: WebSearchPreviewTool) = apply {
            paramsBuilder.addTool(webSearchPreview)
        }

        /** @see ResponseCreateParams.Builder.addTool */
        fun addTool(applyPatch: ApplyPatchTool) = apply { paramsBuilder.addTool(applyPatch) }

        /** @see ResponseCreateParams.Builder.addTool */
        fun addTool(computerUsePreview: ComputerTool) = apply {
            paramsBuilder.addTool(computerUsePreview)
        }

        /** @see ResponseCreateParams.Builder.addTool */
        fun addTool(mcp: Tool.Mcp) = apply { paramsBuilder.addTool(mcp) }

        /** @see ResponseCreateParams.Builder.addMcpTool */
        fun addMcpTool(serverLabel: String) = apply { paramsBuilder.addMcpTool(serverLabel) }

        /** @see ResponseCreateParams.Builder.addTool */
        fun addTool(codeInterpreter: Tool.CodeInterpreter) = apply {
            paramsBuilder.addTool(codeInterpreter)
        }

        /** @see ResponseCreateParams.Builder.addCodeInterpreterTool */
        fun addCodeInterpreterTool(container: Tool.CodeInterpreter.Container) = apply {
            paramsBuilder.addCodeInterpreterTool(container)
        }

        /** @see ResponseCreateParams.Builder.addCodeInterpreterTool */
        fun addCodeInterpreterTool(string: String) = apply {
            paramsBuilder.addCodeInterpreterTool(string)
        }

        /** @see ResponseCreateParams.Builder.addCodeInterpreterTool */
        fun addCodeInterpreterTool(
            codeInterpreterToolAuto: Tool.CodeInterpreter.Container.CodeInterpreterToolAuto
        ) = apply { paramsBuilder.addCodeInterpreterTool(codeInterpreterToolAuto) }

        /** @see ResponseCreateParams.Builder.addTool */
        fun addTool(imageGeneration: Tool.ImageGeneration) = apply {
            paramsBuilder.addTool(imageGeneration)
        }

        /** @see ResponseCreateParams.Builder.addToolLocalShell */
        fun addToolLocalShell() = apply { paramsBuilder.addToolLocalShell() }

        /** @see ResponseCreateParams.Builder.addTool */
        fun addTool(shell: FunctionShellTool) = apply { paramsBuilder.addTool(shell) }

        /** @see ResponseCreateParams.Builder.addTool */
        fun addTool(custom: CustomTool) = apply { paramsBuilder.addTool(custom) }

        /** @see ResponseCreateParams.Builder.addCustomTool */
        fun addCustomTool(name: String) = apply { paramsBuilder.addCustomTool(name) }

        /** @see ResponseCreateParams.Builder.topP */
        fun topP(topP: Double?) = apply { paramsBuilder.topP(topP) }

        /** @see ResponseCreateParams.Builder.topP */
        fun topP(topP: Double) = apply { paramsBuilder.topP(topP) }

        /** @see ResponseCreateParams.Builder.topP */
        fun topP(topP: Optional<Double>) = apply { paramsBuilder.topP(topP) }

        /** @see ResponseCreateParams.Builder.topP */
        fun topP(topP: JsonField<Double>) = apply { paramsBuilder.topP(topP) }

        /** @see ResponseCreateParams.Builder.topLogprobs */
        fun topLogprobs(topLogprobs: Long?) = apply { paramsBuilder.topLogprobs(topLogprobs) }

        /** @see ResponseCreateParams.Builder.topLogprobs */
        fun topLogprobs(topLogprobs: Long) = apply { paramsBuilder.topLogprobs(topLogprobs) }

        /** @see ResponseCreateParams.Builder.topLogprobs */
        fun topLogprobs(topLogprobs: Optional<Long>) = apply {
            paramsBuilder.topLogprobs(topLogprobs)
        }

        /** @see ResponseCreateParams.Builder.topLogprobs */
        fun topLogprobs(topLogprobs: JsonField<Long>) = apply {
            paramsBuilder.topLogprobs(topLogprobs)
        }

        /** @see ResponseCreateParams.Builder.truncation */
        fun truncation(truncation: ResponseCreateParams.Truncation?) = apply {
            paramsBuilder.truncation(truncation)
        }

        /** @see ResponseCreateParams.Builder.truncation */
        fun truncation(truncation: Optional<ResponseCreateParams.Truncation>) = apply {
            paramsBuilder.truncation(truncation)
        }

        /** @see ResponseCreateParams.Builder.truncation */
        fun truncation(truncation: JsonField<ResponseCreateParams.Truncation>) = apply {
            paramsBuilder.truncation(truncation)
        }

        /** @see ResponseCreateParams.Builder.streamOptions */
        fun streamOptions(streamOptions: ResponseCreateParams.StreamOptions?) = apply {
            paramsBuilder.streamOptions(streamOptions)
        }

        /** @see ResponseCreateParams.Builder.streamOptions */
        fun streamOptions(streamOptions: Optional<ResponseCreateParams.StreamOptions>) = apply {
            paramsBuilder.streamOptions(streamOptions)
        }

        /** @see ResponseCreateParams.Builder.streamOptions */
        fun streamOptions(streamOptions: JsonField<ResponseCreateParams.StreamOptions>) = apply {
            paramsBuilder.streamOptions(streamOptions)
        }

        /** @see ResponseCreateParams.Builder.user */
        fun user(user: String) = apply { paramsBuilder.user(user) }

        /** @see ResponseCreateParams.Builder.user */
        fun user(user: JsonField<String>) = apply { paramsBuilder.user(user) }

        /** @see ResponseCreateParams.Builder.additionalBodyProperties */
        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            paramsBuilder.additionalBodyProperties(additionalBodyProperties)
        }

        /** @see ResponseCreateParams.Builder.putAdditionalBodyProperty */
        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            paramsBuilder.putAdditionalBodyProperty(key, value)
        }

        /** @see ResponseCreateParams.Builder.putAllAdditionalBodyProperties */
        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                paramsBuilder.putAllAdditionalBodyProperties(additionalBodyProperties)
            }

        /** @see ResponseCreateParams.Builder.removeAdditionalBodyProperty */
        fun removeAdditionalBodyProperty(key: String) = apply {
            paramsBuilder.removeAdditionalBodyProperty(key)
        }

        /** @see ResponseCreateParams.Builder.removeAllAdditionalBodyProperties */
        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            paramsBuilder.removeAllAdditionalBodyProperties(keys)
        }

        /** @see ResponseCreateParams.Builder.additionalHeaders */
        fun additionalHeaders(additionalHeaders: Headers) = apply {
            paramsBuilder.additionalHeaders(additionalHeaders)
        }

        /** @see ResponseCreateParams.Builder.additionalHeaders */
        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            paramsBuilder.additionalHeaders(additionalHeaders)
        }

        /** @see ResponseCreateParams.Builder.putAdditionalHeader */
        fun putAdditionalHeader(name: String, value: String) = apply {
            paramsBuilder.putAdditionalHeader(name, value)
        }

        /** @see ResponseCreateParams.Builder.putAdditionalHeaders */
        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            paramsBuilder.putAdditionalHeaders(name, values)
        }

        /** @see ResponseCreateParams.Builder.putAllAdditionalHeaders */
        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            paramsBuilder.putAllAdditionalHeaders(additionalHeaders)
        }

        /** @see ResponseCreateParams.Builder.putAllAdditionalHeaders */
        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            paramsBuilder.putAllAdditionalHeaders(additionalHeaders)
        }

        /** @see ResponseCreateParams.Builder.replaceAdditionalHeaders */
        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            paramsBuilder.replaceAdditionalHeaders(name, value)
        }

        /** @see ResponseCreateParams.Builder.replaceAdditionalHeaders */
        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            paramsBuilder.replaceAdditionalHeaders(name, values)
        }

        /** @see ResponseCreateParams.Builder.replaceAllAdditionalHeaders */
        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            paramsBuilder.replaceAllAdditionalHeaders(additionalHeaders)
        }

        /** @see ResponseCreateParams.Builder.replaceAllAdditionalHeaders */
        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            paramsBuilder.replaceAllAdditionalHeaders(additionalHeaders)
        }

        /** @see ResponseCreateParams.Builder.removeAdditionalHeaders */
        fun removeAdditionalHeaders(name: String) = apply {
            paramsBuilder.removeAdditionalHeaders(name)
        }

        /** @see ResponseCreateParams.Builder.removeAllAdditionalHeaders */
        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            paramsBuilder.removeAllAdditionalHeaders(names)
        }

        /** @see ResponseCreateParams.Builder.additionalQueryParams */
        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            paramsBuilder.additionalQueryParams(additionalQueryParams)
        }

        /** @see ResponseCreateParams.Builder.additionalQueryParams */
        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            paramsBuilder.additionalQueryParams(additionalQueryParams)
        }

        /** @see ResponseCreateParams.Builder.putAdditionalQueryParam */
        fun putAdditionalQueryParam(key: String, value: String) = apply {
            paramsBuilder.putAdditionalQueryParam(key, value)
        }

        /** @see ResponseCreateParams.Builder.putAdditionalQueryParams */
        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            paramsBuilder.putAdditionalQueryParams(key, values)
        }

        /** @see ResponseCreateParams.Builder.putAllAdditionalQueryParams */
        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            paramsBuilder.putAllAdditionalQueryParams(additionalQueryParams)
        }

        /** @see ResponseCreateParams.Builder.putAllAdditionalQueryParams */
        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                paramsBuilder.putAllAdditionalQueryParams(additionalQueryParams)
            }

        /** @see ResponseCreateParams.Builder.replaceAdditionalQueryParams */
        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            paramsBuilder.replaceAdditionalQueryParams(key, value)
        }

        /** @see ResponseCreateParams.Builder.replaceAdditionalQueryParams */
        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            paramsBuilder.replaceAdditionalQueryParams(key, values)
        }

        /** @see ResponseCreateParams.Builder.replaceAllAdditionalQueryParams */
        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            paramsBuilder.replaceAllAdditionalQueryParams(additionalQueryParams)
        }

        /** @see ResponseCreateParams.Builder.replaceAllAdditionalQueryParams */
        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                paramsBuilder.replaceAllAdditionalQueryParams(additionalQueryParams)
            }

        /** @see ResponseCreateParams.Builder.removeAdditionalQueryParams */
        fun removeAdditionalQueryParams(key: String) = apply {
            paramsBuilder.removeAdditionalQueryParams(key)
        }

        /** @see ResponseCreateParams.Builder.removeAllAdditionalQueryParams */
        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            paramsBuilder.removeAllAdditionalQueryParams(keys)
        }

        /**
         * Returns an immutable instance of [StructuredResponseCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .input()
         * .model()
         * .text()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build() =
            StructuredResponseCreateParams<T>(
                checkRequired("responseType", responseType),
                paramsBuilder.build(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is StructuredResponseCreateParams<*> &&
            responseType == other.responseType &&
            rawParams == other.rawParams
    }

    private val hashCode: Int by lazy { Objects.hash(responseType, rawParams) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "${javaClass.simpleName}{responseType=$responseType, rawParams=$rawParams}"
}
