package com.openai.models.chat.completions

import com.openai.core.JsonField
import com.openai.core.JsonSchemaLocalValidation
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.responseFormatFromClass
import com.openai.models.ChatModel
import com.openai.models.ReasoningEffort
import java.util.Objects
import java.util.Optional

/**
 * A wrapper for [ChatCompletionCreateParams] that provides a type-safe [Builder] that can record
 * the [responseType] used to derive a JSON schema from an arbitrary class when using the
 * _Structured Outputs_ feature. When a JSON response is received, it is deserialized to am instance
 * of that type. See the SDK documentation for more details on _Structured Outputs_.
 *
 * @param T The type of the class that will be used to derive the JSON schema in the request and to
 *   which the JSON response will be deserialized.
 */
class StructuredChatCompletionCreateParams<T : Any>
internal constructor(
    @get:JvmName("responseType") val responseType: Class<T>,
    /**
     * The raw, underlying chat completion create parameters wrapped by this structured instance of
     * the parameters.
     */
    @get:JvmName("rawParams") val rawParams: ChatCompletionCreateParams,
) {

    companion object {
        @JvmStatic fun <T : Any> builder() = Builder<T>()
    }

    class Builder<T : Any> internal constructor() {
        private var responseType: Class<T>? = null
        private var paramsBuilder = ChatCompletionCreateParams.builder()

        @JvmSynthetic
        internal fun wrap(
            responseType: Class<T>,
            paramsBuilder: ChatCompletionCreateParams.Builder,
            localValidation: JsonSchemaLocalValidation,
        ) = apply {
            this.responseType = responseType
            this.paramsBuilder = paramsBuilder
            // Convert the class to a JSON schema and apply it to the delegate `Builder`.
            responseFormat(responseType, localValidation)
        }

        /** Injects a given `ChatCompletionCreateParams.Builder`. For use only when testing. */
        @JvmSynthetic
        internal fun inject(paramsBuilder: ChatCompletionCreateParams.Builder) = apply {
            this.paramsBuilder = paramsBuilder
        }

        /** @see ChatCompletionCreateParams.Builder.body */
        fun body(body: ChatCompletionCreateParams.Body) = apply { paramsBuilder.body(body) }

        /** @see ChatCompletionCreateParams.Builder.messages */
        fun messages(messages: List<ChatCompletionMessageParam>) = apply {
            paramsBuilder.messages(messages)
        }

        /** @see ChatCompletionCreateParams.Builder.messages */
        fun messages(messages: JsonField<List<ChatCompletionMessageParam>>) = apply {
            paramsBuilder.messages(messages)
        }

        /** @see ChatCompletionCreateParams.Builder.addMessage */
        fun addMessage(message: ChatCompletionMessageParam) = apply {
            paramsBuilder.addMessage(message)
        }

        /** @see ChatCompletionCreateParams.Builder.addMessage */
        fun addMessage(developer: ChatCompletionDeveloperMessageParam) = apply {
            paramsBuilder.addMessage(developer)
        }

        /** @see ChatCompletionCreateParams.Builder.addDeveloperMessage */
        fun addDeveloperMessage(content: ChatCompletionDeveloperMessageParam.Content) = apply {
            paramsBuilder.addDeveloperMessage(content)
        }

        /** @see ChatCompletionCreateParams.Builder.addDeveloperMessage */
        fun addDeveloperMessage(text: String) = apply { paramsBuilder.addDeveloperMessage(text) }

        /** @see ChatCompletionCreateParams.Builder.addDeveloperMessageOfArrayOfContentParts */
        fun addDeveloperMessageOfArrayOfContentParts(
            arrayOfContentParts: List<ChatCompletionContentPartText>
        ) = apply { paramsBuilder.addDeveloperMessageOfArrayOfContentParts(arrayOfContentParts) }

        /** @see ChatCompletionCreateParams.Builder.addMessage */
        fun addMessage(system: ChatCompletionSystemMessageParam) = apply {
            paramsBuilder.addMessage(system)
        }

        /** @see ChatCompletionCreateParams.Builder.addSystemMessage */
        fun addSystemMessage(content: ChatCompletionSystemMessageParam.Content) = apply {
            paramsBuilder.addSystemMessage(content)
        }

        /** @see ChatCompletionCreateParams.Builder.addSystemMessage */
        fun addSystemMessage(text: String) = apply { paramsBuilder.addSystemMessage(text) }

        /** @see ChatCompletionCreateParams.Builder.addSystemMessageOfArrayOfContentParts */
        fun addSystemMessageOfArrayOfContentParts(
            arrayOfContentParts: List<ChatCompletionContentPartText>
        ) = apply { paramsBuilder.addSystemMessageOfArrayOfContentParts(arrayOfContentParts) }

        /** @see ChatCompletionCreateParams.Builder.addMessage */
        fun addMessage(user: ChatCompletionUserMessageParam) = apply {
            paramsBuilder.addMessage(user)
        }

        /** @see ChatCompletionCreateParams.Builder.addUserMessage */
        fun addUserMessage(content: ChatCompletionUserMessageParam.Content) = apply {
            paramsBuilder.addUserMessage(content)
        }

        /** @see ChatCompletionCreateParams.Builder.addUserMessage */
        fun addUserMessage(text: String) = apply { paramsBuilder.addUserMessage(text) }

        /** @see ChatCompletionCreateParams.Builder.addUserMessageOfArrayOfContentParts */
        fun addUserMessageOfArrayOfContentParts(
            arrayOfContentParts: List<ChatCompletionContentPart>
        ) = apply { paramsBuilder.addUserMessageOfArrayOfContentParts(arrayOfContentParts) }

        /** @see ChatCompletionCreateParams.Builder.addMessage */
        fun addMessage(assistant: ChatCompletionAssistantMessageParam) = apply {
            paramsBuilder.addMessage(assistant)
        }

        /** @see ChatCompletionCreateParams.Builder.addMessage */
        fun addMessage(assistant: ChatCompletionMessage) = apply {
            paramsBuilder.addMessage(assistant)
        }

        /** @see ChatCompletionCreateParams.Builder.addAssistantMessage */
        fun addAssistantMessage(content: ChatCompletionAssistantMessageParam.Content?) = apply {
            paramsBuilder.addAssistantMessage(content)
        }

        /** @see ChatCompletionCreateParams.Builder.addAssistantMessage */
        fun addAssistantMessage(content: Optional<ChatCompletionAssistantMessageParam.Content>) =
            apply {
                paramsBuilder.addAssistantMessage(content)
            }

        /** @see ChatCompletionCreateParams.Builder.addAssistantMessage */
        fun addAssistantMessage(text: String) = apply { paramsBuilder.addAssistantMessage(text) }

        /** @see ChatCompletionCreateParams.Builder.addAssistantMessageOfArrayOfContentParts */
        fun addAssistantMessageOfArrayOfContentParts(
            arrayOfContentParts:
                List<
                    ChatCompletionAssistantMessageParam.Content.ChatCompletionRequestAssistantMessageContentPart
                >
        ) = apply { paramsBuilder.addAssistantMessageOfArrayOfContentParts(arrayOfContentParts) }

        /** @see ChatCompletionCreateParams.Builder.addMessage */
        fun addMessage(tool: ChatCompletionToolMessageParam) = apply {
            paramsBuilder.addMessage(tool)
        }

        /** @see ChatCompletionCreateParams.Builder.addMessage */
        @Deprecated("deprecated")
        fun addMessage(function: ChatCompletionFunctionMessageParam) = apply {
            paramsBuilder.addMessage(function)
        }

        /** @see ChatCompletionCreateParams.Builder.model */
        fun model(model: ChatModel) = apply { paramsBuilder.model(model) }

        /** @see ChatCompletionCreateParams.Builder.model */
        fun model(model: JsonField<ChatModel>) = apply { paramsBuilder.model(model) }

        /** @see ChatCompletionCreateParams.Builder.model */
        fun model(value: String) = apply { paramsBuilder.model(value) }

        /** @see ChatCompletionCreateParams.Builder.audio */
        fun audio(audio: ChatCompletionAudioParam?) = apply { paramsBuilder.audio(audio) }

        /** @see ChatCompletionCreateParams.Builder.audio */
        fun audio(audio: Optional<ChatCompletionAudioParam>) = apply { paramsBuilder.audio(audio) }

        /** @see ChatCompletionCreateParams.Builder.audio */
        fun audio(audio: JsonField<ChatCompletionAudioParam>) = apply { paramsBuilder.audio(audio) }

        /** @see ChatCompletionCreateParams.Builder.frequencyPenalty */
        fun frequencyPenalty(frequencyPenalty: Double?) = apply {
            paramsBuilder.frequencyPenalty(frequencyPenalty)
        }

        /** @see ChatCompletionCreateParams.Builder.frequencyPenalty */
        fun frequencyPenalty(frequencyPenalty: Double) = apply {
            paramsBuilder.frequencyPenalty(frequencyPenalty)
        }

        /** @see ChatCompletionCreateParams.Builder.frequencyPenalty */
        fun frequencyPenalty(frequencyPenalty: Optional<Double>) = apply {
            paramsBuilder.frequencyPenalty(frequencyPenalty)
        }

        /** @see ChatCompletionCreateParams.Builder.frequencyPenalty */
        fun frequencyPenalty(frequencyPenalty: JsonField<Double>) = apply {
            paramsBuilder.frequencyPenalty(frequencyPenalty)
        }

        /** @see ChatCompletionCreateParams.Builder.functionCall */
        @Deprecated("deprecated")
        fun functionCall(functionCall: ChatCompletionCreateParams.FunctionCall) = apply {
            paramsBuilder.functionCall(functionCall)
        }

        /** @see ChatCompletionCreateParams.Builder.functionCall */
        @Deprecated("deprecated")
        fun functionCall(functionCall: JsonField<ChatCompletionCreateParams.FunctionCall>) = apply {
            paramsBuilder.functionCall(functionCall)
        }

        /** @see ChatCompletionCreateParams.Builder.functionCall */
        @Deprecated("deprecated")
        fun functionCall(mode: ChatCompletionCreateParams.FunctionCall.FunctionCallMode) = apply {
            paramsBuilder.functionCall(mode)
        }

        /** @see ChatCompletionCreateParams.Builder.functionCall */
        @Deprecated("deprecated")
        fun functionCall(functionCallOption: ChatCompletionFunctionCallOption) = apply {
            paramsBuilder.functionCall(functionCallOption)
        }

        /** @see ChatCompletionCreateParams.Builder.functions */
        @Deprecated("deprecated")
        fun functions(functions: List<ChatCompletionCreateParams.Function>) = apply {
            paramsBuilder.functions(functions)
        }

        /** @see ChatCompletionCreateParams.Builder.functions */
        @Deprecated("deprecated")
        fun functions(functions: JsonField<List<ChatCompletionCreateParams.Function>>) = apply {
            paramsBuilder.functions(functions)
        }

        /** @see ChatCompletionCreateParams.Builder.addFunction */
        @Deprecated("deprecated")
        fun addFunction(function: ChatCompletionCreateParams.Function) = apply {
            paramsBuilder.addFunction(function)
        }

        /** @see ChatCompletionCreateParams.Builder.logitBias */
        fun logitBias(logitBias: ChatCompletionCreateParams.LogitBias?) = apply {
            paramsBuilder.logitBias(logitBias)
        }

        /** @see ChatCompletionCreateParams.Builder.logitBias */
        fun logitBias(logitBias: Optional<ChatCompletionCreateParams.LogitBias>) = apply {
            paramsBuilder.logitBias(logitBias)
        }

        /** @see ChatCompletionCreateParams.Builder.logitBias */
        fun logitBias(logitBias: JsonField<ChatCompletionCreateParams.LogitBias>) = apply {
            paramsBuilder.logitBias(logitBias)
        }

        /** @see ChatCompletionCreateParams.Builder.logprobs */
        fun logprobs(logprobs: Boolean?) = apply { paramsBuilder.logprobs(logprobs) }

        /** @see ChatCompletionCreateParams.Builder.logprobs */
        fun logprobs(logprobs: Boolean) = apply { paramsBuilder.logprobs(logprobs) }

        /** @see ChatCompletionCreateParams.Builder.logprobs */
        fun logprobs(logprobs: Optional<Boolean>) = apply { paramsBuilder.logprobs(logprobs) }

        /** @see ChatCompletionCreateParams.Builder.logprobs */
        fun logprobs(logprobs: JsonField<Boolean>) = apply { paramsBuilder.logprobs(logprobs) }

        /** @see ChatCompletionCreateParams.Builder.maxCompletionTokens */
        fun maxCompletionTokens(maxCompletionTokens: Long?) = apply {
            paramsBuilder.maxCompletionTokens(maxCompletionTokens)
        }

        /** @see ChatCompletionCreateParams.Builder.maxCompletionTokens */
        fun maxCompletionTokens(maxCompletionTokens: Long) = apply {
            paramsBuilder.maxCompletionTokens(maxCompletionTokens)
        }

        /** @see ChatCompletionCreateParams.Builder.maxCompletionTokens */
        fun maxCompletionTokens(maxCompletionTokens: Optional<Long>) = apply {
            paramsBuilder.maxCompletionTokens(maxCompletionTokens)
        }

        /** @see ChatCompletionCreateParams.Builder.maxCompletionTokens */
        fun maxCompletionTokens(maxCompletionTokens: JsonField<Long>) = apply {
            paramsBuilder.maxCompletionTokens(maxCompletionTokens)
        }

        /** @see ChatCompletionCreateParams.Builder.maxTokens */
        @Deprecated("deprecated")
        fun maxTokens(maxTokens: Long?) = apply { paramsBuilder.maxTokens(maxTokens) }

        /** @see ChatCompletionCreateParams.Builder.maxTokens */
        @Deprecated("deprecated")
        fun maxTokens(maxTokens: Long) = apply { paramsBuilder.maxTokens(maxTokens) }

        /** @see ChatCompletionCreateParams.Builder.maxTokens */
        @Deprecated("deprecated")
        fun maxTokens(maxTokens: Optional<Long>) = apply { paramsBuilder.maxTokens(maxTokens) }

        /** @see ChatCompletionCreateParams.Builder.maxTokens */
        @Deprecated("deprecated")
        fun maxTokens(maxTokens: JsonField<Long>) = apply { paramsBuilder.maxTokens(maxTokens) }

        /** @see ChatCompletionCreateParams.Builder.metadata */
        fun metadata(metadata: ChatCompletionCreateParams.Metadata?) = apply {
            paramsBuilder.metadata(metadata)
        }

        /** @see ChatCompletionCreateParams.Builder.metadata */
        fun metadata(metadata: Optional<ChatCompletionCreateParams.Metadata>) = apply {
            paramsBuilder.metadata(metadata)
        }

        /** @see ChatCompletionCreateParams.Builder.metadata */
        fun metadata(metadata: JsonField<ChatCompletionCreateParams.Metadata>) = apply {
            paramsBuilder.metadata(metadata)
        }

        /** @see ChatCompletionCreateParams.Builder.modalities */
        fun modalities(modalities: List<ChatCompletionCreateParams.Modality>?) = apply {
            paramsBuilder.modalities(modalities)
        }

        /** @see ChatCompletionCreateParams.Builder.modalities */
        fun modalities(modalities: Optional<List<ChatCompletionCreateParams.Modality>>) = apply {
            paramsBuilder.modalities(modalities)
        }

        /** @see ChatCompletionCreateParams.Builder.modalities */
        fun modalities(modalities: JsonField<List<ChatCompletionCreateParams.Modality>>) = apply {
            paramsBuilder.modalities(modalities)
        }

        /** @see ChatCompletionCreateParams.Builder.addModality */
        fun addModality(modality: ChatCompletionCreateParams.Modality) = apply {
            paramsBuilder.addModality(modality)
        }

        /** @see ChatCompletionCreateParams.Builder.n */
        fun n(n: Long?) = apply { paramsBuilder.n(n) }

        /** @see ChatCompletionCreateParams.Builder.n */
        fun n(n: Long) = apply { paramsBuilder.n(n) }

        /** @see ChatCompletionCreateParams.Builder.n */
        fun n(n: Optional<Long>) = apply { paramsBuilder.n(n) }

        /** @see ChatCompletionCreateParams.Builder.n */
        fun n(n: JsonField<Long>) = apply { paramsBuilder.n(n) }

        /** @see ChatCompletionCreateParams.Builder.parallelToolCalls */
        fun parallelToolCalls(parallelToolCalls: Boolean) = apply {
            paramsBuilder.parallelToolCalls(parallelToolCalls)
        }

        /** @see ChatCompletionCreateParams.Builder.parallelToolCalls */
        fun parallelToolCalls(parallelToolCalls: JsonField<Boolean>) = apply {
            paramsBuilder.parallelToolCalls(parallelToolCalls)
        }

        /** @see ChatCompletionCreateParams.Builder.prediction */
        fun prediction(prediction: ChatCompletionPredictionContent?) = apply {
            paramsBuilder.prediction(prediction)
        }

        /** @see ChatCompletionCreateParams.Builder.prediction */
        fun prediction(prediction: Optional<ChatCompletionPredictionContent>) = apply {
            paramsBuilder.prediction(prediction)
        }

        /** @see ChatCompletionCreateParams.Builder.prediction */
        fun prediction(prediction: JsonField<ChatCompletionPredictionContent>) = apply {
            paramsBuilder.prediction(prediction)
        }

        /** @see ChatCompletionCreateParams.Builder.promptCacheKey */
        fun promptCacheKey(promptCacheKey: String) = apply {
            paramsBuilder.promptCacheKey(promptCacheKey)
        }

        /** @see ChatCompletionCreateParams.Builder.promptCacheKey */
        fun promptCacheKey(promptCacheKey: JsonField<String>) = apply {
            paramsBuilder.promptCacheKey(promptCacheKey)
        }

        /** @see ChatCompletionCreateParams.Builder.presencePenalty */
        fun presencePenalty(presencePenalty: Double?) = apply {
            paramsBuilder.presencePenalty(presencePenalty)
        }

        /** @see ChatCompletionCreateParams.Builder.presencePenalty */
        fun presencePenalty(presencePenalty: Double) = apply {
            paramsBuilder.presencePenalty(presencePenalty)
        }

        /** @see ChatCompletionCreateParams.Builder.presencePenalty */
        fun presencePenalty(presencePenalty: Optional<Double>) = apply {
            paramsBuilder.presencePenalty(presencePenalty)
        }

        /** @see ChatCompletionCreateParams.Builder.presencePenalty */
        fun presencePenalty(presencePenalty: JsonField<Double>) = apply {
            paramsBuilder.presencePenalty(presencePenalty)
        }

        /** @see ChatCompletionCreateParams.Builder.reasoningEffort */
        fun reasoningEffort(reasoningEffort: ReasoningEffort?) = apply {
            paramsBuilder.reasoningEffort(reasoningEffort)
        }

        /** @see ChatCompletionCreateParams.Builder.reasoningEffort */
        fun reasoningEffort(reasoningEffort: Optional<ReasoningEffort>) = apply {
            paramsBuilder.reasoningEffort(reasoningEffort)
        }

        /** @see ChatCompletionCreateParams.Builder.reasoningEffort */
        fun reasoningEffort(reasoningEffort: JsonField<ReasoningEffort>) = apply {
            paramsBuilder.reasoningEffort(reasoningEffort)
        }

        /** @see ChatCompletionCreateParams.Builder.safetyIdentifier */
        fun safetyIdentifier(safetyIdentifier: String) = apply {
            paramsBuilder.safetyIdentifier(safetyIdentifier)
        }

        /** @see ChatCompletionCreateParams.Builder.safetyIdentifier */
        fun safetyIdentifier(safetyIdentifier: JsonField<String>) = apply {
            paramsBuilder.safetyIdentifier(safetyIdentifier)
        }

        /**
         * Sets the response format to a JSON schema derived from the structure of the given class.
         *
         * @see ChatCompletionCreateParams.Builder.responseFormat
         */
        @JvmOverloads
        fun responseFormat(
            responseType: Class<T>,
            localValidation: JsonSchemaLocalValidation = JsonSchemaLocalValidation.YES,
        ) = apply {
            this.responseType = responseType
            paramsBuilder.responseFormat(responseFormatFromClass(responseType, localValidation))
        }

        /** @see ChatCompletionCreateParams.Builder.seed */
        fun seed(seed: Long?) = apply { paramsBuilder.seed(seed) }

        /** @see ChatCompletionCreateParams.Builder.seed */
        fun seed(seed: Long) = apply { paramsBuilder.seed(seed) }

        /** @see ChatCompletionCreateParams.Builder.seed */
        fun seed(seed: Optional<Long>) = apply { paramsBuilder.seed(seed) }

        /** @see ChatCompletionCreateParams.Builder.seed */
        fun seed(seed: JsonField<Long>) = apply { paramsBuilder.seed(seed) }

        /** @see ChatCompletionCreateParams.Builder.serviceTier */
        fun serviceTier(serviceTier: ChatCompletionCreateParams.ServiceTier?) = apply {
            paramsBuilder.serviceTier(serviceTier)
        }

        /** @see ChatCompletionCreateParams.Builder.serviceTier */
        fun serviceTier(serviceTier: Optional<ChatCompletionCreateParams.ServiceTier>) = apply {
            paramsBuilder.serviceTier(serviceTier)
        }

        /** @see ChatCompletionCreateParams.Builder.serviceTier */
        fun serviceTier(serviceTier: JsonField<ChatCompletionCreateParams.ServiceTier>) = apply {
            paramsBuilder.serviceTier(serviceTier)
        }

        /** @see ChatCompletionCreateParams.Builder.stop */
        fun stop(stop: ChatCompletionCreateParams.Stop?) = apply { paramsBuilder.stop(stop) }

        /** @see ChatCompletionCreateParams.Builder.stop */
        fun stop(stop: Optional<ChatCompletionCreateParams.Stop>) = apply {
            paramsBuilder.stop(stop)
        }

        /** @see ChatCompletionCreateParams.Builder.stop */
        fun stop(stop: JsonField<ChatCompletionCreateParams.Stop>) = apply {
            paramsBuilder.stop(stop)
        }

        /** @see ChatCompletionCreateParams.Builder.stop */
        fun stop(string: String) = apply { paramsBuilder.stop(string) }

        /** @see ChatCompletionCreateParams.Builder.stopOfStrings */
        fun stopOfStrings(strings: List<String>) = apply { paramsBuilder.stopOfStrings(strings) }

        /** @see ChatCompletionCreateParams.Builder.store */
        fun store(store: Boolean?) = apply { paramsBuilder.store(store) }

        /** @see ChatCompletionCreateParams.Builder.store */
        fun store(store: Boolean) = apply { paramsBuilder.store(store) }

        /** @see ChatCompletionCreateParams.Builder.store */
        fun store(store: Optional<Boolean>) = apply { paramsBuilder.store(store) }

        /** @see ChatCompletionCreateParams.Builder.store */
        fun store(store: JsonField<Boolean>) = apply { paramsBuilder.store(store) }

        /** @see ChatCompletionCreateParams.Builder.streamOptions */
        fun streamOptions(streamOptions: ChatCompletionStreamOptions?) = apply {
            paramsBuilder.streamOptions(streamOptions)
        }

        /** @see ChatCompletionCreateParams.Builder.streamOptions */
        fun streamOptions(streamOptions: Optional<ChatCompletionStreamOptions>) = apply {
            paramsBuilder.streamOptions(streamOptions)
        }

        /** @see ChatCompletionCreateParams.Builder.streamOptions */
        fun streamOptions(streamOptions: JsonField<ChatCompletionStreamOptions>) = apply {
            paramsBuilder.streamOptions(streamOptions)
        }

        /** @see ChatCompletionCreateParams.Builder.temperature */
        fun temperature(temperature: Double?) = apply { paramsBuilder.temperature(temperature) }

        /** @see ChatCompletionCreateParams.Builder.temperature */
        fun temperature(temperature: Double) = apply { paramsBuilder.temperature(temperature) }

        /** @see ChatCompletionCreateParams.Builder.temperature */
        fun temperature(temperature: Optional<Double>) = apply {
            paramsBuilder.temperature(temperature)
        }

        /** @see ChatCompletionCreateParams.Builder.temperature */
        fun temperature(temperature: JsonField<Double>) = apply {
            paramsBuilder.temperature(temperature)
        }

        /** @see ChatCompletionCreateParams.Builder.toolChoice */
        fun toolChoice(toolChoice: ChatCompletionToolChoiceOption) = apply {
            paramsBuilder.toolChoice(toolChoice)
        }

        /** @see ChatCompletionCreateParams.Builder.toolChoice */
        fun toolChoice(toolChoice: JsonField<ChatCompletionToolChoiceOption>) = apply {
            paramsBuilder.toolChoice(toolChoice)
        }

        /** @see ChatCompletionCreateParams.Builder.toolChoice */
        fun toolChoice(auto: ChatCompletionToolChoiceOption.Auto) = apply {
            paramsBuilder.toolChoice(auto)
        }

        /** @see ChatCompletionCreateParams.Builder.toolChoice */
        fun toolChoice(namedToolChoice: ChatCompletionNamedToolChoice) = apply {
            paramsBuilder.toolChoice(namedToolChoice)
        }

        /** @see ChatCompletionCreateParams.Builder.tools */
        fun tools(tools: List<ChatCompletionTool>) = apply { paramsBuilder.tools(tools) }

        /** @see ChatCompletionCreateParams.Builder.tools */
        fun tools(tools: JsonField<List<ChatCompletionTool>>) = apply { paramsBuilder.tools(tools) }

        /** @see ChatCompletionCreateParams.Builder.addTool */
        fun addTool(tool: ChatCompletionTool) = apply { paramsBuilder.addTool(tool) }

        /** @see ChatCompletionCreateParams.Builder.addTool */
        @JvmOverloads
        fun addTool(
            functionParametersType: Class<*>,
            localValidation: JsonSchemaLocalValidation = JsonSchemaLocalValidation.YES,
        ) = apply { paramsBuilder.addTool(functionParametersType, localValidation) }

        /** @see ChatCompletionCreateParams.Builder.topLogprobs */
        fun topLogprobs(topLogprobs: Long?) = apply { paramsBuilder.topLogprobs(topLogprobs) }

        /** @see ChatCompletionCreateParams.Builder.topLogprobs */
        fun topLogprobs(topLogprobs: Long) = apply { paramsBuilder.topLogprobs(topLogprobs) }

        /** @see ChatCompletionCreateParams.Builder.topLogprobs */
        fun topLogprobs(topLogprobs: Optional<Long>) = apply {
            paramsBuilder.topLogprobs(topLogprobs)
        }

        /** @see ChatCompletionCreateParams.Builder.topLogprobs */
        fun topLogprobs(topLogprobs: JsonField<Long>) = apply {
            paramsBuilder.topLogprobs(topLogprobs)
        }

        /** @see ChatCompletionCreateParams.Builder.topP */
        fun topP(topP: Double?) = apply { paramsBuilder.topP(topP) }

        /** @see ChatCompletionCreateParams.Builder.topP */
        fun topP(topP: Double) = apply { paramsBuilder.topP(topP) }

        /** @see ChatCompletionCreateParams.Builder.topP */
        fun topP(topP: Optional<Double>) = apply { paramsBuilder.topP(topP) }

        /** @see ChatCompletionCreateParams.Builder.topP */
        fun topP(topP: JsonField<Double>) = apply { paramsBuilder.topP(topP) }

        /** @see ChatCompletionCreateParams.Builder.user */
        fun user(user: String) = apply { paramsBuilder.user(user) }

        /** @see ChatCompletionCreateParams.Builder.user */
        fun user(user: JsonField<String>) = apply { paramsBuilder.user(user) }

        /** @see ChatCompletionCreateParams.Builder.webSearchOptions */
        fun webSearchOptions(webSearchOptions: ChatCompletionCreateParams.WebSearchOptions) =
            apply {
                paramsBuilder.webSearchOptions(webSearchOptions)
            }

        /** @see ChatCompletionCreateParams.Builder.webSearchOptions */
        fun webSearchOptions(
            webSearchOptions: JsonField<ChatCompletionCreateParams.WebSearchOptions>
        ) = apply { paramsBuilder.webSearchOptions(webSearchOptions) }

        /** @see ChatCompletionCreateParams.Builder.additionalBodyProperties */
        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            paramsBuilder.additionalBodyProperties(additionalBodyProperties)
        }

        /** @see ChatCompletionCreateParams.Builder.putAdditionalBodyProperty */
        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            paramsBuilder.putAdditionalBodyProperty(key, value)
        }

        /** @see ChatCompletionCreateParams.Builder.putAllAdditionalBodyProperties */
        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                paramsBuilder.putAllAdditionalBodyProperties(additionalBodyProperties)
            }

        /** @see ChatCompletionCreateParams.Builder.removeAdditionalBodyProperty */
        fun removeAdditionalBodyProperty(key: String) = apply {
            paramsBuilder.removeAdditionalBodyProperty(key)
        }

        /** @see ChatCompletionCreateParams.Builder.removeAllAdditionalBodyProperties */
        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            paramsBuilder.removeAllAdditionalBodyProperties(keys)
        }

        /** @see ChatCompletionCreateParams.Builder.additionalHeaders */
        fun additionalHeaders(additionalHeaders: Headers) = apply {
            paramsBuilder.additionalHeaders(additionalHeaders)
        }

        /** @see ChatCompletionCreateParams.Builder.additionalHeaders */
        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            paramsBuilder.additionalHeaders(additionalHeaders)
        }

        /** @see ChatCompletionCreateParams.Builder.putAdditionalHeader */
        fun putAdditionalHeader(name: String, value: String) = apply {
            paramsBuilder.putAdditionalHeader(name, value)
        }

        /** @see ChatCompletionCreateParams.Builder.putAdditionalHeaders */
        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            paramsBuilder.putAdditionalHeaders(name, values)
        }

        /** @see ChatCompletionCreateParams.Builder.putAllAdditionalHeaders */
        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            paramsBuilder.putAllAdditionalHeaders(additionalHeaders)
        }

        /** @see ChatCompletionCreateParams.Builder.putAllAdditionalHeaders */
        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            paramsBuilder.putAllAdditionalHeaders(additionalHeaders)
        }

        /** @see ChatCompletionCreateParams.Builder.replaceAdditionalHeaders */
        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            paramsBuilder.replaceAdditionalHeaders(name, value)
        }

        /** @see ChatCompletionCreateParams.Builder.replaceAdditionalHeaders */
        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            paramsBuilder.replaceAdditionalHeaders(name, values)
        }

        /** @see ChatCompletionCreateParams.Builder.replaceAllAdditionalHeaders */
        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            paramsBuilder.replaceAllAdditionalHeaders(additionalHeaders)
        }

        /** @see ChatCompletionCreateParams.Builder.replaceAllAdditionalHeaders */
        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            paramsBuilder.replaceAllAdditionalHeaders(additionalHeaders)
        }

        /** @see ChatCompletionCreateParams.Builder.removeAdditionalHeaders */
        fun removeAdditionalHeaders(name: String) = apply {
            paramsBuilder.removeAdditionalHeaders(name)
        }

        /** @see ChatCompletionCreateParams.Builder.removeAllAdditionalHeaders */
        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            paramsBuilder.removeAllAdditionalHeaders(names)
        }

        /** @see ChatCompletionCreateParams.Builder.additionalQueryParams */
        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            paramsBuilder.additionalQueryParams(additionalQueryParams)
        }

        /** @see ChatCompletionCreateParams.Builder.additionalQueryParams */
        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            paramsBuilder.additionalQueryParams(additionalQueryParams)
        }

        /** @see ChatCompletionCreateParams.Builder.putAdditionalQueryParam */
        fun putAdditionalQueryParam(key: String, value: String) = apply {
            paramsBuilder.putAdditionalQueryParam(key, value)
        }

        /** @see ChatCompletionCreateParams.Builder.putAdditionalQueryParams */
        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            paramsBuilder.putAdditionalQueryParams(key, values)
        }

        /** @see ChatCompletionCreateParams.Builder.putAllAdditionalQueryParams */
        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            paramsBuilder.putAllAdditionalQueryParams(additionalQueryParams)
        }

        /** @see ChatCompletionCreateParams.Builder.putAllAdditionalQueryParams */
        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                paramsBuilder.putAllAdditionalQueryParams(additionalQueryParams)
            }

        /** @see ChatCompletionCreateParams.Builder.replaceAdditionalQueryParams */
        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            paramsBuilder.replaceAdditionalQueryParams(key, value)
        }

        /** @see ChatCompletionCreateParams.Builder.replaceAdditionalQueryParams */
        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            paramsBuilder.replaceAdditionalQueryParams(key, values)
        }

        /** @see ChatCompletionCreateParams.Builder.replaceAllAdditionalQueryParams */
        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            paramsBuilder.replaceAllAdditionalQueryParams(additionalQueryParams)
        }

        /** @see ChatCompletionCreateParams.Builder.replaceAllAdditionalQueryParams */
        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                paramsBuilder.replaceAllAdditionalQueryParams(additionalQueryParams)
            }

        /** @see ChatCompletionCreateParams.Builder.removeAdditionalQueryParams */
        fun removeAdditionalQueryParams(key: String) = apply {
            paramsBuilder.removeAdditionalQueryParams(key)
        }

        /** @see ChatCompletionCreateParams.Builder.removeAllAdditionalQueryParams */
        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            paramsBuilder.removeAllAdditionalQueryParams(keys)
        }

        /**
         * Returns an immutable instance of [StructuredChatCompletionCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .messages()
         * .model()
         * .responseFormat()
         * ```
         *
         * @throws IllegalStateException If any required field is unset.
         */
        fun build() =
            StructuredChatCompletionCreateParams<T>(
                checkRequired("responseType", responseType),
                paramsBuilder.build(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is StructuredChatCompletionCreateParams<*> &&
            responseType == other.responseType &&
            rawParams == other.rawParams
    }

    private val hashCode: Int by lazy { Objects.hash(responseType, rawParams) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "${javaClass.simpleName}{responseType=$responseType, rawParams=$rawParams}"
}
