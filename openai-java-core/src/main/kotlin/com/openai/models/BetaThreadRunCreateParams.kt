// File generated from our OpenAPI spec by Stainless.

package com.openai.models

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
import com.openai.core.NoAutoDetect
import com.openai.core.Params
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Create a run. */
class BetaThreadRunCreateParams
private constructor(
    private val threadId: String,
    private val include: List<RunStepInclude>?,
    private val body: BetaThreadRunCreateBody,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun threadId(): String = threadId

    /**
     * A list of additional fields to include in the response. Currently the only supported value is
     * `step_details.tool_calls[*].file_search.results[*].content` to fetch the file search result
     * content.
     *
     * See the
     * [file search tool documentation](https://platform.openai.com/docs/assistants/tools/file-search#customizing-file-search-settings)
     * for more information.
     */
    fun include(): Optional<List<RunStepInclude>> = Optional.ofNullable(include)

    /**
     * The ID of the [assistant](https://platform.openai.com/docs/api-reference/assistants) to use
     * to execute this run.
     */
    fun assistantId(): String = body.assistantId()

    /**
     * Appends additional instructions at the end of the instructions for the run. This is useful
     * for modifying the behavior on a per-run basis without overriding other instructions.
     */
    fun additionalInstructions(): Optional<String> = body.additionalInstructions()

    /** Adds additional messages to the thread before creating the run. */
    fun additionalMessages(): Optional<List<AdditionalMessage>> = body.additionalMessages()

    /**
     * Overrides the
     * [instructions](https://platform.openai.com/docs/api-reference/assistants/createAssistant) of
     * the assistant. This is useful for modifying the behavior on a per-run basis.
     */
    fun instructions(): Optional<String> = body.instructions()

    /**
     * The maximum number of completion tokens that may be used over the course of the run. The run
     * will make a best effort to use only the number of completion tokens specified, across
     * multiple turns of the run. If the run exceeds the number of completion tokens specified, the
     * run will end with status `incomplete`. See `incomplete_details` for more info.
     */
    fun maxCompletionTokens(): Optional<Long> = body.maxCompletionTokens()

    /**
     * The maximum number of prompt tokens that may be used over the course of the run. The run will
     * make a best effort to use only the number of prompt tokens specified, across multiple turns
     * of the run. If the run exceeds the number of prompt tokens specified, the run will end with
     * status `incomplete`. See `incomplete_details` for more info.
     */
    fun maxPromptTokens(): Optional<Long> = body.maxPromptTokens()

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format. Keys can be a maximum of 64
     * characters long and values can be a maximum of 512 characters long.
     */
    fun _metadata(): JsonValue = body._metadata()

    /**
     * The ID of the [Model](https://platform.openai.com/docs/api-reference/models) to be used to
     * execute this run. If a value is provided here, it will override the model associated with the
     * assistant. If not, the model associated with the assistant will be used.
     */
    fun model(): Optional<ChatModel> = body.model()

    /**
     * Whether to enable
     * [parallel function calling](https://platform.openai.com/docs/guides/function-calling#configuring-parallel-function-calling)
     * during tool use.
     */
    fun parallelToolCalls(): Optional<Boolean> = body.parallelToolCalls()

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
     */
    fun responseFormat(): Optional<AssistantResponseFormatOption> = body.responseFormat()

    /**
     * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
     * output more random, while lower values like 0.2 will make it more focused and deterministic.
     */
    fun temperature(): Optional<Double> = body.temperature()

    /**
     * Controls which (if any) tool is called by the model. `none` means the model will not call any
     * tools and instead generates a message. `auto` is the default value and means the model can
     * pick between generating a message or calling one or more tools. `required` means the model
     * must call one or more tools before responding to the user. Specifying a particular tool like
     * `{"type": "file_search"}` or `{"type": "function", "function": {"name": "my_function"}}`
     * forces the model to call that tool.
     */
    fun toolChoice(): Optional<AssistantToolChoiceOption> = body.toolChoice()

    /**
     * Override the tools the assistant can use for this run. This is useful for modifying the
     * behavior on a per-run basis.
     */
    fun tools(): Optional<List<AssistantTool>> = body.tools()

    /**
     * An alternative to sampling with temperature, called nucleus sampling, where the model
     * considers the results of the tokens with top_p probability mass. So 0.1 means only the tokens
     * comprising the top 10% probability mass are considered.
     *
     * We generally recommend altering this or temperature but not both.
     */
    fun topP(): Optional<Double> = body.topP()

    /**
     * Controls for how a thread will be truncated prior to the run. Use this to control the intial
     * context window of the run.
     */
    fun truncationStrategy(): Optional<TruncationStrategy> = body.truncationStrategy()

    /**
     * The ID of the [assistant](https://platform.openai.com/docs/api-reference/assistants) to use
     * to execute this run.
     */
    fun _assistantId(): JsonField<String> = body._assistantId()

    /**
     * Appends additional instructions at the end of the instructions for the run. This is useful
     * for modifying the behavior on a per-run basis without overriding other instructions.
     */
    fun _additionalInstructions(): JsonField<String> = body._additionalInstructions()

    /** Adds additional messages to the thread before creating the run. */
    fun _additionalMessages(): JsonField<List<AdditionalMessage>> = body._additionalMessages()

    /**
     * Overrides the
     * [instructions](https://platform.openai.com/docs/api-reference/assistants/createAssistant) of
     * the assistant. This is useful for modifying the behavior on a per-run basis.
     */
    fun _instructions(): JsonField<String> = body._instructions()

    /**
     * The maximum number of completion tokens that may be used over the course of the run. The run
     * will make a best effort to use only the number of completion tokens specified, across
     * multiple turns of the run. If the run exceeds the number of completion tokens specified, the
     * run will end with status `incomplete`. See `incomplete_details` for more info.
     */
    fun _maxCompletionTokens(): JsonField<Long> = body._maxCompletionTokens()

    /**
     * The maximum number of prompt tokens that may be used over the course of the run. The run will
     * make a best effort to use only the number of prompt tokens specified, across multiple turns
     * of the run. If the run exceeds the number of prompt tokens specified, the run will end with
     * status `incomplete`. See `incomplete_details` for more info.
     */
    fun _maxPromptTokens(): JsonField<Long> = body._maxPromptTokens()

    /**
     * The ID of the [Model](https://platform.openai.com/docs/api-reference/models) to be used to
     * execute this run. If a value is provided here, it will override the model associated with the
     * assistant. If not, the model associated with the assistant will be used.
     */
    fun _model(): JsonField<ChatModel> = body._model()

    /**
     * Whether to enable
     * [parallel function calling](https://platform.openai.com/docs/guides/function-calling#configuring-parallel-function-calling)
     * during tool use.
     */
    fun _parallelToolCalls(): JsonField<Boolean> = body._parallelToolCalls()

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
     */
    fun _responseFormat(): JsonField<AssistantResponseFormatOption> = body._responseFormat()

    /**
     * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
     * output more random, while lower values like 0.2 will make it more focused and deterministic.
     */
    fun _temperature(): JsonField<Double> = body._temperature()

    /**
     * Controls which (if any) tool is called by the model. `none` means the model will not call any
     * tools and instead generates a message. `auto` is the default value and means the model can
     * pick between generating a message or calling one or more tools. `required` means the model
     * must call one or more tools before responding to the user. Specifying a particular tool like
     * `{"type": "file_search"}` or `{"type": "function", "function": {"name": "my_function"}}`
     * forces the model to call that tool.
     */
    fun _toolChoice(): JsonField<AssistantToolChoiceOption> = body._toolChoice()

    /**
     * Override the tools the assistant can use for this run. This is useful for modifying the
     * behavior on a per-run basis.
     */
    fun _tools(): JsonField<List<AssistantTool>> = body._tools()

    /**
     * An alternative to sampling with temperature, called nucleus sampling, where the model
     * considers the results of the tokens with top_p probability mass. So 0.1 means only the tokens
     * comprising the top 10% probability mass are considered.
     *
     * We generally recommend altering this or temperature but not both.
     */
    fun _topP(): JsonField<Double> = body._topP()

    /**
     * Controls for how a thread will be truncated prior to the run. Use this to control the intial
     * context window of the run.
     */
    fun _truncationStrategy(): JsonField<TruncationStrategy> = body._truncationStrategy()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic internal fun _body(): BetaThreadRunCreateBody = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams {
        val queryParams = QueryParams.builder()
        this.include?.let { queryParams.put("include[]", it.map(Any::toString)) }
        queryParams.putAll(additionalQueryParams)
        return queryParams.build()
    }

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> threadId
            else -> ""
        }
    }

    @NoAutoDetect
    class BetaThreadRunCreateBody
    @JsonCreator
    internal constructor(
        @JsonProperty("assistant_id")
        @ExcludeMissing
        private val assistantId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("additional_instructions")
        @ExcludeMissing
        private val additionalInstructions: JsonField<String> = JsonMissing.of(),
        @JsonProperty("additional_messages")
        @ExcludeMissing
        private val additionalMessages: JsonField<List<AdditionalMessage>> = JsonMissing.of(),
        @JsonProperty("instructions")
        @ExcludeMissing
        private val instructions: JsonField<String> = JsonMissing.of(),
        @JsonProperty("max_completion_tokens")
        @ExcludeMissing
        private val maxCompletionTokens: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("max_prompt_tokens")
        @ExcludeMissing
        private val maxPromptTokens: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("metadata")
        @ExcludeMissing
        private val metadata: JsonValue = JsonMissing.of(),
        @JsonProperty("model")
        @ExcludeMissing
        private val model: JsonField<ChatModel> = JsonMissing.of(),
        @JsonProperty("parallel_tool_calls")
        @ExcludeMissing
        private val parallelToolCalls: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("response_format")
        @ExcludeMissing
        private val responseFormat: JsonField<AssistantResponseFormatOption> = JsonMissing.of(),
        @JsonProperty("temperature")
        @ExcludeMissing
        private val temperature: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("tool_choice")
        @ExcludeMissing
        private val toolChoice: JsonField<AssistantToolChoiceOption> = JsonMissing.of(),
        @JsonProperty("tools")
        @ExcludeMissing
        private val tools: JsonField<List<AssistantTool>> = JsonMissing.of(),
        @JsonProperty("top_p")
        @ExcludeMissing
        private val topP: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("truncation_strategy")
        @ExcludeMissing
        private val truncationStrategy: JsonField<TruncationStrategy> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * The ID of the [assistant](https://platform.openai.com/docs/api-reference/assistants) to
         * use to execute this run.
         */
        fun assistantId(): String = assistantId.getRequired("assistant_id")

        /**
         * Appends additional instructions at the end of the instructions for the run. This is
         * useful for modifying the behavior on a per-run basis without overriding other
         * instructions.
         */
        fun additionalInstructions(): Optional<String> =
            Optional.ofNullable(additionalInstructions.getNullable("additional_instructions"))

        /** Adds additional messages to the thread before creating the run. */
        fun additionalMessages(): Optional<List<AdditionalMessage>> =
            Optional.ofNullable(additionalMessages.getNullable("additional_messages"))

        /**
         * Overrides the
         * [instructions](https://platform.openai.com/docs/api-reference/assistants/createAssistant)
         * of the assistant. This is useful for modifying the behavior on a per-run basis.
         */
        fun instructions(): Optional<String> =
            Optional.ofNullable(instructions.getNullable("instructions"))

        /**
         * The maximum number of completion tokens that may be used over the course of the run. The
         * run will make a best effort to use only the number of completion tokens specified, across
         * multiple turns of the run. If the run exceeds the number of completion tokens specified,
         * the run will end with status `incomplete`. See `incomplete_details` for more info.
         */
        fun maxCompletionTokens(): Optional<Long> =
            Optional.ofNullable(maxCompletionTokens.getNullable("max_completion_tokens"))

        /**
         * The maximum number of prompt tokens that may be used over the course of the run. The run
         * will make a best effort to use only the number of prompt tokens specified, across
         * multiple turns of the run. If the run exceeds the number of prompt tokens specified, the
         * run will end with status `incomplete`. See `incomplete_details` for more info.
         */
        fun maxPromptTokens(): Optional<Long> =
            Optional.ofNullable(maxPromptTokens.getNullable("max_prompt_tokens"))

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format. Keys can be a
         * maximum of 64 characters long and values can be a maximum of 512 characters long.
         */
        @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonValue = metadata

        /**
         * The ID of the [Model](https://platform.openai.com/docs/api-reference/models) to be used
         * to execute this run. If a value is provided here, it will override the model associated
         * with the assistant. If not, the model associated with the assistant will be used.
         */
        fun model(): Optional<ChatModel> = Optional.ofNullable(model.getNullable("model"))

        /**
         * Whether to enable
         * [parallel function calling](https://platform.openai.com/docs/guides/function-calling#configuring-parallel-function-calling)
         * during tool use.
         */
        fun parallelToolCalls(): Optional<Boolean> =
            Optional.ofNullable(parallelToolCalls.getNullable("parallel_tool_calls"))

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
        fun responseFormat(): Optional<AssistantResponseFormatOption> =
            Optional.ofNullable(responseFormat.getNullable("response_format"))

        /**
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic.
         */
        fun temperature(): Optional<Double> =
            Optional.ofNullable(temperature.getNullable("temperature"))

        /**
         * Controls which (if any) tool is called by the model. `none` means the model will not call
         * any tools and instead generates a message. `auto` is the default value and means the
         * model can pick between generating a message or calling one or more tools. `required`
         * means the model must call one or more tools before responding to the user. Specifying a
         * particular tool like `{"type": "file_search"}` or `{"type": "function", "function":
         * {"name": "my_function"}}` forces the model to call that tool.
         */
        fun toolChoice(): Optional<AssistantToolChoiceOption> =
            Optional.ofNullable(toolChoice.getNullable("tool_choice"))

        /**
         * Override the tools the assistant can use for this run. This is useful for modifying the
         * behavior on a per-run basis.
         */
        fun tools(): Optional<List<AssistantTool>> = Optional.ofNullable(tools.getNullable("tools"))

        /**
         * An alternative to sampling with temperature, called nucleus sampling, where the model
         * considers the results of the tokens with top_p probability mass. So 0.1 means only the
         * tokens comprising the top 10% probability mass are considered.
         *
         * We generally recommend altering this or temperature but not both.
         */
        fun topP(): Optional<Double> = Optional.ofNullable(topP.getNullable("top_p"))

        /**
         * Controls for how a thread will be truncated prior to the run. Use this to control the
         * intial context window of the run.
         */
        fun truncationStrategy(): Optional<TruncationStrategy> =
            Optional.ofNullable(truncationStrategy.getNullable("truncation_strategy"))

        /**
         * The ID of the [assistant](https://platform.openai.com/docs/api-reference/assistants) to
         * use to execute this run.
         */
        @JsonProperty("assistant_id")
        @ExcludeMissing
        fun _assistantId(): JsonField<String> = assistantId

        /**
         * Appends additional instructions at the end of the instructions for the run. This is
         * useful for modifying the behavior on a per-run basis without overriding other
         * instructions.
         */
        @JsonProperty("additional_instructions")
        @ExcludeMissing
        fun _additionalInstructions(): JsonField<String> = additionalInstructions

        /** Adds additional messages to the thread before creating the run. */
        @JsonProperty("additional_messages")
        @ExcludeMissing
        fun _additionalMessages(): JsonField<List<AdditionalMessage>> = additionalMessages

        /**
         * Overrides the
         * [instructions](https://platform.openai.com/docs/api-reference/assistants/createAssistant)
         * of the assistant. This is useful for modifying the behavior on a per-run basis.
         */
        @JsonProperty("instructions")
        @ExcludeMissing
        fun _instructions(): JsonField<String> = instructions

        /**
         * The maximum number of completion tokens that may be used over the course of the run. The
         * run will make a best effort to use only the number of completion tokens specified, across
         * multiple turns of the run. If the run exceeds the number of completion tokens specified,
         * the run will end with status `incomplete`. See `incomplete_details` for more info.
         */
        @JsonProperty("max_completion_tokens")
        @ExcludeMissing
        fun _maxCompletionTokens(): JsonField<Long> = maxCompletionTokens

        /**
         * The maximum number of prompt tokens that may be used over the course of the run. The run
         * will make a best effort to use only the number of prompt tokens specified, across
         * multiple turns of the run. If the run exceeds the number of prompt tokens specified, the
         * run will end with status `incomplete`. See `incomplete_details` for more info.
         */
        @JsonProperty("max_prompt_tokens")
        @ExcludeMissing
        fun _maxPromptTokens(): JsonField<Long> = maxPromptTokens

        /**
         * The ID of the [Model](https://platform.openai.com/docs/api-reference/models) to be used
         * to execute this run. If a value is provided here, it will override the model associated
         * with the assistant. If not, the model associated with the assistant will be used.
         */
        @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<ChatModel> = model

        /**
         * Whether to enable
         * [parallel function calling](https://platform.openai.com/docs/guides/function-calling#configuring-parallel-function-calling)
         * during tool use.
         */
        @JsonProperty("parallel_tool_calls")
        @ExcludeMissing
        fun _parallelToolCalls(): JsonField<Boolean> = parallelToolCalls

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
        @JsonProperty("response_format")
        @ExcludeMissing
        fun _responseFormat(): JsonField<AssistantResponseFormatOption> = responseFormat

        /**
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic.
         */
        @JsonProperty("temperature")
        @ExcludeMissing
        fun _temperature(): JsonField<Double> = temperature

        /**
         * Controls which (if any) tool is called by the model. `none` means the model will not call
         * any tools and instead generates a message. `auto` is the default value and means the
         * model can pick between generating a message or calling one or more tools. `required`
         * means the model must call one or more tools before responding to the user. Specifying a
         * particular tool like `{"type": "file_search"}` or `{"type": "function", "function":
         * {"name": "my_function"}}` forces the model to call that tool.
         */
        @JsonProperty("tool_choice")
        @ExcludeMissing
        fun _toolChoice(): JsonField<AssistantToolChoiceOption> = toolChoice

        /**
         * Override the tools the assistant can use for this run. This is useful for modifying the
         * behavior on a per-run basis.
         */
        @JsonProperty("tools") @ExcludeMissing fun _tools(): JsonField<List<AssistantTool>> = tools

        /**
         * An alternative to sampling with temperature, called nucleus sampling, where the model
         * considers the results of the tokens with top_p probability mass. So 0.1 means only the
         * tokens comprising the top 10% probability mass are considered.
         *
         * We generally recommend altering this or temperature but not both.
         */
        @JsonProperty("top_p") @ExcludeMissing fun _topP(): JsonField<Double> = topP

        /**
         * Controls for how a thread will be truncated prior to the run. Use this to control the
         * intial context window of the run.
         */
        @JsonProperty("truncation_strategy")
        @ExcludeMissing
        fun _truncationStrategy(): JsonField<TruncationStrategy> = truncationStrategy

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): BetaThreadRunCreateBody = apply {
            if (validated) {
                return@apply
            }

            assistantId()
            additionalInstructions()
            additionalMessages().ifPresent { it.forEach { it.validate() } }
            instructions()
            maxCompletionTokens()
            maxPromptTokens()
            model()
            parallelToolCalls()
            responseFormat().ifPresent { it.validate() }
            temperature()
            toolChoice().ifPresent { it.validate() }
            tools().ifPresent { it.forEach { it.validate() } }
            topP()
            truncationStrategy().ifPresent { it.validate() }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [BetaThreadRunCreateBody]. */
        class Builder internal constructor() {

            private var assistantId: JsonField<String>? = null
            private var additionalInstructions: JsonField<String> = JsonMissing.of()
            private var additionalMessages: JsonField<MutableList<AdditionalMessage>>? = null
            private var instructions: JsonField<String> = JsonMissing.of()
            private var maxCompletionTokens: JsonField<Long> = JsonMissing.of()
            private var maxPromptTokens: JsonField<Long> = JsonMissing.of()
            private var metadata: JsonValue = JsonMissing.of()
            private var model: JsonField<ChatModel> = JsonMissing.of()
            private var parallelToolCalls: JsonField<Boolean> = JsonMissing.of()
            private var responseFormat: JsonField<AssistantResponseFormatOption> = JsonMissing.of()
            private var temperature: JsonField<Double> = JsonMissing.of()
            private var toolChoice: JsonField<AssistantToolChoiceOption> = JsonMissing.of()
            private var tools: JsonField<MutableList<AssistantTool>>? = null
            private var topP: JsonField<Double> = JsonMissing.of()
            private var truncationStrategy: JsonField<TruncationStrategy> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(betaThreadRunCreateBody: BetaThreadRunCreateBody) = apply {
                assistantId = betaThreadRunCreateBody.assistantId
                additionalInstructions = betaThreadRunCreateBody.additionalInstructions
                additionalMessages =
                    betaThreadRunCreateBody.additionalMessages.map { it.toMutableList() }
                instructions = betaThreadRunCreateBody.instructions
                maxCompletionTokens = betaThreadRunCreateBody.maxCompletionTokens
                maxPromptTokens = betaThreadRunCreateBody.maxPromptTokens
                metadata = betaThreadRunCreateBody.metadata
                model = betaThreadRunCreateBody.model
                parallelToolCalls = betaThreadRunCreateBody.parallelToolCalls
                responseFormat = betaThreadRunCreateBody.responseFormat
                temperature = betaThreadRunCreateBody.temperature
                toolChoice = betaThreadRunCreateBody.toolChoice
                tools = betaThreadRunCreateBody.tools.map { it.toMutableList() }
                topP = betaThreadRunCreateBody.topP
                truncationStrategy = betaThreadRunCreateBody.truncationStrategy
                additionalProperties = betaThreadRunCreateBody.additionalProperties.toMutableMap()
            }

            /**
             * The ID of the [assistant](https://platform.openai.com/docs/api-reference/assistants)
             * to use to execute this run.
             */
            fun assistantId(assistantId: String) = assistantId(JsonField.of(assistantId))

            /**
             * The ID of the [assistant](https://platform.openai.com/docs/api-reference/assistants)
             * to use to execute this run.
             */
            fun assistantId(assistantId: JsonField<String>) = apply {
                this.assistantId = assistantId
            }

            /**
             * Appends additional instructions at the end of the instructions for the run. This is
             * useful for modifying the behavior on a per-run basis without overriding other
             * instructions.
             */
            fun additionalInstructions(additionalInstructions: String?) =
                additionalInstructions(JsonField.ofNullable(additionalInstructions))

            /**
             * Appends additional instructions at the end of the instructions for the run. This is
             * useful for modifying the behavior on a per-run basis without overriding other
             * instructions.
             */
            fun additionalInstructions(additionalInstructions: Optional<String>) =
                additionalInstructions(additionalInstructions.orElse(null))

            /**
             * Appends additional instructions at the end of the instructions for the run. This is
             * useful for modifying the behavior on a per-run basis without overriding other
             * instructions.
             */
            fun additionalInstructions(additionalInstructions: JsonField<String>) = apply {
                this.additionalInstructions = additionalInstructions
            }

            /** Adds additional messages to the thread before creating the run. */
            fun additionalMessages(additionalMessages: List<AdditionalMessage>?) =
                additionalMessages(JsonField.ofNullable(additionalMessages))

            /** Adds additional messages to the thread before creating the run. */
            fun additionalMessages(additionalMessages: Optional<List<AdditionalMessage>>) =
                additionalMessages(additionalMessages.orElse(null))

            /** Adds additional messages to the thread before creating the run. */
            fun additionalMessages(additionalMessages: JsonField<List<AdditionalMessage>>) = apply {
                this.additionalMessages = additionalMessages.map { it.toMutableList() }
            }

            /** Adds additional messages to the thread before creating the run. */
            fun addAdditionalMessage(additionalMessage: AdditionalMessage) = apply {
                additionalMessages =
                    (additionalMessages ?: JsonField.of(mutableListOf())).apply {
                        asKnown()
                            .orElseThrow {
                                IllegalStateException(
                                    "Field was set to non-list type: ${javaClass.simpleName}"
                                )
                            }
                            .add(additionalMessage)
                    }
            }

            /**
             * Overrides the
             * [instructions](https://platform.openai.com/docs/api-reference/assistants/createAssistant)
             * of the assistant. This is useful for modifying the behavior on a per-run basis.
             */
            fun instructions(instructions: String?) =
                instructions(JsonField.ofNullable(instructions))

            /**
             * Overrides the
             * [instructions](https://platform.openai.com/docs/api-reference/assistants/createAssistant)
             * of the assistant. This is useful for modifying the behavior on a per-run basis.
             */
            fun instructions(instructions: Optional<String>) =
                instructions(instructions.orElse(null))

            /**
             * Overrides the
             * [instructions](https://platform.openai.com/docs/api-reference/assistants/createAssistant)
             * of the assistant. This is useful for modifying the behavior on a per-run basis.
             */
            fun instructions(instructions: JsonField<String>) = apply {
                this.instructions = instructions
            }

            /**
             * The maximum number of completion tokens that may be used over the course of the run.
             * The run will make a best effort to use only the number of completion tokens
             * specified, across multiple turns of the run. If the run exceeds the number of
             * completion tokens specified, the run will end with status `incomplete`. See
             * `incomplete_details` for more info.
             */
            fun maxCompletionTokens(maxCompletionTokens: Long?) =
                maxCompletionTokens(JsonField.ofNullable(maxCompletionTokens))

            /**
             * The maximum number of completion tokens that may be used over the course of the run.
             * The run will make a best effort to use only the number of completion tokens
             * specified, across multiple turns of the run. If the run exceeds the number of
             * completion tokens specified, the run will end with status `incomplete`. See
             * `incomplete_details` for more info.
             */
            fun maxCompletionTokens(maxCompletionTokens: Long) =
                maxCompletionTokens(maxCompletionTokens as Long?)

            /**
             * The maximum number of completion tokens that may be used over the course of the run.
             * The run will make a best effort to use only the number of completion tokens
             * specified, across multiple turns of the run. If the run exceeds the number of
             * completion tokens specified, the run will end with status `incomplete`. See
             * `incomplete_details` for more info.
             */
            @Suppress("USELESS_CAST") // See https://youtrack.jetbrains.com/issue/KT-74228
            fun maxCompletionTokens(maxCompletionTokens: Optional<Long>) =
                maxCompletionTokens(maxCompletionTokens.orElse(null) as Long?)

            /**
             * The maximum number of completion tokens that may be used over the course of the run.
             * The run will make a best effort to use only the number of completion tokens
             * specified, across multiple turns of the run. If the run exceeds the number of
             * completion tokens specified, the run will end with status `incomplete`. See
             * `incomplete_details` for more info.
             */
            fun maxCompletionTokens(maxCompletionTokens: JsonField<Long>) = apply {
                this.maxCompletionTokens = maxCompletionTokens
            }

            /**
             * The maximum number of prompt tokens that may be used over the course of the run. The
             * run will make a best effort to use only the number of prompt tokens specified, across
             * multiple turns of the run. If the run exceeds the number of prompt tokens specified,
             * the run will end with status `incomplete`. See `incomplete_details` for more info.
             */
            fun maxPromptTokens(maxPromptTokens: Long?) =
                maxPromptTokens(JsonField.ofNullable(maxPromptTokens))

            /**
             * The maximum number of prompt tokens that may be used over the course of the run. The
             * run will make a best effort to use only the number of prompt tokens specified, across
             * multiple turns of the run. If the run exceeds the number of prompt tokens specified,
             * the run will end with status `incomplete`. See `incomplete_details` for more info.
             */
            fun maxPromptTokens(maxPromptTokens: Long) = maxPromptTokens(maxPromptTokens as Long?)

            /**
             * The maximum number of prompt tokens that may be used over the course of the run. The
             * run will make a best effort to use only the number of prompt tokens specified, across
             * multiple turns of the run. If the run exceeds the number of prompt tokens specified,
             * the run will end with status `incomplete`. See `incomplete_details` for more info.
             */
            @Suppress("USELESS_CAST") // See https://youtrack.jetbrains.com/issue/KT-74228
            fun maxPromptTokens(maxPromptTokens: Optional<Long>) =
                maxPromptTokens(maxPromptTokens.orElse(null) as Long?)

            /**
             * The maximum number of prompt tokens that may be used over the course of the run. The
             * run will make a best effort to use only the number of prompt tokens specified, across
             * multiple turns of the run. If the run exceeds the number of prompt tokens specified,
             * the run will end with status `incomplete`. See `incomplete_details` for more info.
             */
            fun maxPromptTokens(maxPromptTokens: JsonField<Long>) = apply {
                this.maxPromptTokens = maxPromptTokens
            }

            /**
             * Set of 16 key-value pairs that can be attached to an object. This can be useful for
             * storing additional information about the object in a structured format. Keys can be a
             * maximum of 64 characters long and values can be a maximum of 512 characters long.
             */
            fun metadata(metadata: JsonValue) = apply { this.metadata = metadata }

            /**
             * The ID of the [Model](https://platform.openai.com/docs/api-reference/models) to be
             * used to execute this run. If a value is provided here, it will override the model
             * associated with the assistant. If not, the model associated with the assistant will
             * be used.
             */
            fun model(model: ChatModel?) = model(JsonField.ofNullable(model))

            /**
             * The ID of the [Model](https://platform.openai.com/docs/api-reference/models) to be
             * used to execute this run. If a value is provided here, it will override the model
             * associated with the assistant. If not, the model associated with the assistant will
             * be used.
             */
            fun model(model: Optional<ChatModel>) = model(model.orElse(null))

            /**
             * The ID of the [Model](https://platform.openai.com/docs/api-reference/models) to be
             * used to execute this run. If a value is provided here, it will override the model
             * associated with the assistant. If not, the model associated with the assistant will
             * be used.
             */
            fun model(model: JsonField<ChatModel>) = apply { this.model = model }

            /**
             * The ID of the [Model](https://platform.openai.com/docs/api-reference/models) to be
             * used to execute this run. If a value is provided here, it will override the model
             * associated with the assistant. If not, the model associated with the assistant will
             * be used.
             */
            fun model(value: String) = model(ChatModel.of(value))

            /**
             * Whether to enable
             * [parallel function calling](https://platform.openai.com/docs/guides/function-calling#configuring-parallel-function-calling)
             * during tool use.
             */
            fun parallelToolCalls(parallelToolCalls: Boolean) =
                parallelToolCalls(JsonField.of(parallelToolCalls))

            /**
             * Whether to enable
             * [parallel function calling](https://platform.openai.com/docs/guides/function-calling#configuring-parallel-function-calling)
             * during tool use.
             */
            fun parallelToolCalls(parallelToolCalls: JsonField<Boolean>) = apply {
                this.parallelToolCalls = parallelToolCalls
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
            fun responseFormat(responseFormat: Optional<AssistantResponseFormatOption>) =
                responseFormat(responseFormat.orElse(null))

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
            fun responseFormat(responseFormat: JsonField<AssistantResponseFormatOption>) = apply {
                this.responseFormat = responseFormat
            }

            /** `auto` is the default value */
            fun responseFormatAuto() = responseFormat(AssistantResponseFormatOption.ofAuto())

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
            fun responseFormat(responseFormatText: ResponseFormatText) =
                responseFormat(
                    AssistantResponseFormatOption.ofResponseFormatText(responseFormatText)
                )

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
            fun responseFormat(responseFormatJsonObject: ResponseFormatJsonObject) =
                responseFormat(
                    AssistantResponseFormatOption.ofResponseFormatJsonObject(
                        responseFormatJsonObject
                    )
                )

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
             * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make
             * the output more random, while lower values like 0.2 will make it more focused and
             * deterministic.
             */
            fun temperature(temperature: Double) = temperature(temperature as Double?)

            /**
             * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make
             * the output more random, while lower values like 0.2 will make it more focused and
             * deterministic.
             */
            @Suppress("USELESS_CAST") // See https://youtrack.jetbrains.com/issue/KT-74228
            fun temperature(temperature: Optional<Double>) =
                temperature(temperature.orElse(null) as Double?)

            /**
             * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make
             * the output more random, while lower values like 0.2 will make it more focused and
             * deterministic.
             */
            fun temperature(temperature: JsonField<Double>) = apply {
                this.temperature = temperature
            }

            /**
             * Controls which (if any) tool is called by the model. `none` means the model will not
             * call any tools and instead generates a message. `auto` is the default value and means
             * the model can pick between generating a message or calling one or more tools.
             * `required` means the model must call one or more tools before responding to the user.
             * Specifying a particular tool like `{"type": "file_search"}` or `{"type": "function",
             * "function": {"name": "my_function"}}` forces the model to call that tool.
             */
            fun toolChoice(toolChoice: AssistantToolChoiceOption?) =
                toolChoice(JsonField.ofNullable(toolChoice))

            /**
             * Controls which (if any) tool is called by the model. `none` means the model will not
             * call any tools and instead generates a message. `auto` is the default value and means
             * the model can pick between generating a message or calling one or more tools.
             * `required` means the model must call one or more tools before responding to the user.
             * Specifying a particular tool like `{"type": "file_search"}` or `{"type": "function",
             * "function": {"name": "my_function"}}` forces the model to call that tool.
             */
            fun toolChoice(toolChoice: Optional<AssistantToolChoiceOption>) =
                toolChoice(toolChoice.orElse(null))

            /**
             * Controls which (if any) tool is called by the model. `none` means the model will not
             * call any tools and instead generates a message. `auto` is the default value and means
             * the model can pick between generating a message or calling one or more tools.
             * `required` means the model must call one or more tools before responding to the user.
             * Specifying a particular tool like `{"type": "file_search"}` or `{"type": "function",
             * "function": {"name": "my_function"}}` forces the model to call that tool.
             */
            fun toolChoice(toolChoice: JsonField<AssistantToolChoiceOption>) = apply {
                this.toolChoice = toolChoice
            }

            /**
             * `none` means the model will not call any tools and instead generates a message.
             * `auto` means the model can pick between generating a message or calling one or more
             * tools. `required` means the model must call one or more tools before responding to
             * the user.
             */
            fun toolChoice(auto: AssistantToolChoiceOption.Auto) =
                toolChoice(AssistantToolChoiceOption.ofAuto(auto))

            /**
             * Specifies a tool the model should use. Use to force the model to call a specific
             * tool.
             */
            fun toolChoice(assistantToolChoice: AssistantToolChoice) =
                toolChoice(AssistantToolChoiceOption.ofAssistantToolChoice(assistantToolChoice))

            /**
             * Override the tools the assistant can use for this run. This is useful for modifying
             * the behavior on a per-run basis.
             */
            fun tools(tools: List<AssistantTool>?) = tools(JsonField.ofNullable(tools))

            /**
             * Override the tools the assistant can use for this run. This is useful for modifying
             * the behavior on a per-run basis.
             */
            fun tools(tools: Optional<List<AssistantTool>>) = tools(tools.orElse(null))

            /**
             * Override the tools the assistant can use for this run. This is useful for modifying
             * the behavior on a per-run basis.
             */
            fun tools(tools: JsonField<List<AssistantTool>>) = apply {
                this.tools = tools.map { it.toMutableList() }
            }

            /**
             * Override the tools the assistant can use for this run. This is useful for modifying
             * the behavior on a per-run basis.
             */
            fun addTool(tool: AssistantTool) = apply {
                tools =
                    (tools ?: JsonField.of(mutableListOf())).apply {
                        asKnown()
                            .orElseThrow {
                                IllegalStateException(
                                    "Field was set to non-list type: ${javaClass.simpleName}"
                                )
                            }
                            .add(tool)
                    }
            }

            /**
             * Override the tools the assistant can use for this run. This is useful for modifying
             * the behavior on a per-run basis.
             */
            fun addTool(codeInterpreter: CodeInterpreterTool) =
                addTool(AssistantTool.ofCodeInterpreter(codeInterpreter))

            /**
             * Override the tools the assistant can use for this run. This is useful for modifying
             * the behavior on a per-run basis.
             */
            fun addTool(fileSearch: FileSearchTool) =
                addTool(AssistantTool.ofFileSearch(fileSearch))

            /**
             * Override the tools the assistant can use for this run. This is useful for modifying
             * the behavior on a per-run basis.
             */
            fun addTool(function: FunctionTool) = addTool(AssistantTool.ofFunction(function))

            /**
             * An alternative to sampling with temperature, called nucleus sampling, where the model
             * considers the results of the tokens with top_p probability mass. So 0.1 means only
             * the tokens comprising the top 10% probability mass are considered.
             *
             * We generally recommend altering this or temperature but not both.
             */
            fun topP(topP: Double?) = topP(JsonField.ofNullable(topP))

            /**
             * An alternative to sampling with temperature, called nucleus sampling, where the model
             * considers the results of the tokens with top_p probability mass. So 0.1 means only
             * the tokens comprising the top 10% probability mass are considered.
             *
             * We generally recommend altering this or temperature but not both.
             */
            fun topP(topP: Double) = topP(topP as Double?)

            /**
             * An alternative to sampling with temperature, called nucleus sampling, where the model
             * considers the results of the tokens with top_p probability mass. So 0.1 means only
             * the tokens comprising the top 10% probability mass are considered.
             *
             * We generally recommend altering this or temperature but not both.
             */
            @Suppress("USELESS_CAST") // See https://youtrack.jetbrains.com/issue/KT-74228
            fun topP(topP: Optional<Double>) = topP(topP.orElse(null) as Double?)

            /**
             * An alternative to sampling with temperature, called nucleus sampling, where the model
             * considers the results of the tokens with top_p probability mass. So 0.1 means only
             * the tokens comprising the top 10% probability mass are considered.
             *
             * We generally recommend altering this or temperature but not both.
             */
            fun topP(topP: JsonField<Double>) = apply { this.topP = topP }

            /**
             * Controls for how a thread will be truncated prior to the run. Use this to control the
             * intial context window of the run.
             */
            fun truncationStrategy(truncationStrategy: TruncationStrategy?) =
                truncationStrategy(JsonField.ofNullable(truncationStrategy))

            /**
             * Controls for how a thread will be truncated prior to the run. Use this to control the
             * intial context window of the run.
             */
            fun truncationStrategy(truncationStrategy: Optional<TruncationStrategy>) =
                truncationStrategy(truncationStrategy.orElse(null))

            /**
             * Controls for how a thread will be truncated prior to the run. Use this to control the
             * intial context window of the run.
             */
            fun truncationStrategy(truncationStrategy: JsonField<TruncationStrategy>) = apply {
                this.truncationStrategy = truncationStrategy
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

            fun build(): BetaThreadRunCreateBody =
                BetaThreadRunCreateBody(
                    checkRequired("assistantId", assistantId),
                    additionalInstructions,
                    (additionalMessages ?: JsonMissing.of()).map { it.toImmutable() },
                    instructions,
                    maxCompletionTokens,
                    maxPromptTokens,
                    metadata,
                    model,
                    parallelToolCalls,
                    responseFormat,
                    temperature,
                    toolChoice,
                    (tools ?: JsonMissing.of()).map { it.toImmutable() },
                    topP,
                    truncationStrategy,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is BetaThreadRunCreateBody && assistantId == other.assistantId && additionalInstructions == other.additionalInstructions && additionalMessages == other.additionalMessages && instructions == other.instructions && maxCompletionTokens == other.maxCompletionTokens && maxPromptTokens == other.maxPromptTokens && metadata == other.metadata && model == other.model && parallelToolCalls == other.parallelToolCalls && responseFormat == other.responseFormat && temperature == other.temperature && toolChoice == other.toolChoice && tools == other.tools && topP == other.topP && truncationStrategy == other.truncationStrategy && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(assistantId, additionalInstructions, additionalMessages, instructions, maxCompletionTokens, maxPromptTokens, metadata, model, parallelToolCalls, responseFormat, temperature, toolChoice, tools, topP, truncationStrategy, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "BetaThreadRunCreateBody{assistantId=$assistantId, additionalInstructions=$additionalInstructions, additionalMessages=$additionalMessages, instructions=$instructions, maxCompletionTokens=$maxCompletionTokens, maxPromptTokens=$maxPromptTokens, metadata=$metadata, model=$model, parallelToolCalls=$parallelToolCalls, responseFormat=$responseFormat, temperature=$temperature, toolChoice=$toolChoice, tools=$tools, topP=$topP, truncationStrategy=$truncationStrategy, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BetaThreadRunCreateParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

        private var threadId: String? = null
        private var include: MutableList<RunStepInclude>? = null
        private var body: BetaThreadRunCreateBody.Builder = BetaThreadRunCreateBody.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(betaThreadRunCreateParams: BetaThreadRunCreateParams) = apply {
            threadId = betaThreadRunCreateParams.threadId
            include = betaThreadRunCreateParams.include?.toMutableList()
            body = betaThreadRunCreateParams.body.toBuilder()
            additionalHeaders = betaThreadRunCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = betaThreadRunCreateParams.additionalQueryParams.toBuilder()
        }

        fun threadId(threadId: String) = apply { this.threadId = threadId }

        /**
         * A list of additional fields to include in the response. Currently the only supported
         * value is `step_details.tool_calls[*].file_search.results[*].content` to fetch the file
         * search result content.
         *
         * See the
         * [file search tool documentation](https://platform.openai.com/docs/assistants/tools/file-search#customizing-file-search-settings)
         * for more information.
         */
        fun include(include: List<RunStepInclude>?) = apply {
            this.include = include?.toMutableList()
        }

        /**
         * A list of additional fields to include in the response. Currently the only supported
         * value is `step_details.tool_calls[*].file_search.results[*].content` to fetch the file
         * search result content.
         *
         * See the
         * [file search tool documentation](https://platform.openai.com/docs/assistants/tools/file-search#customizing-file-search-settings)
         * for more information.
         */
        fun include(include: Optional<List<RunStepInclude>>) = include(include.orElse(null))

        /**
         * A list of additional fields to include in the response. Currently the only supported
         * value is `step_details.tool_calls[*].file_search.results[*].content` to fetch the file
         * search result content.
         *
         * See the
         * [file search tool documentation](https://platform.openai.com/docs/assistants/tools/file-search#customizing-file-search-settings)
         * for more information.
         */
        fun addInclude(include: RunStepInclude) = apply {
            this.include = (this.include ?: mutableListOf()).apply { add(include) }
        }

        /**
         * The ID of the [assistant](https://platform.openai.com/docs/api-reference/assistants) to
         * use to execute this run.
         */
        fun assistantId(assistantId: String) = apply { body.assistantId(assistantId) }

        /**
         * The ID of the [assistant](https://platform.openai.com/docs/api-reference/assistants) to
         * use to execute this run.
         */
        fun assistantId(assistantId: JsonField<String>) = apply { body.assistantId(assistantId) }

        /**
         * Appends additional instructions at the end of the instructions for the run. This is
         * useful for modifying the behavior on a per-run basis without overriding other
         * instructions.
         */
        fun additionalInstructions(additionalInstructions: String?) = apply {
            body.additionalInstructions(additionalInstructions)
        }

        /**
         * Appends additional instructions at the end of the instructions for the run. This is
         * useful for modifying the behavior on a per-run basis without overriding other
         * instructions.
         */
        fun additionalInstructions(additionalInstructions: Optional<String>) =
            additionalInstructions(additionalInstructions.orElse(null))

        /**
         * Appends additional instructions at the end of the instructions for the run. This is
         * useful for modifying the behavior on a per-run basis without overriding other
         * instructions.
         */
        fun additionalInstructions(additionalInstructions: JsonField<String>) = apply {
            body.additionalInstructions(additionalInstructions)
        }

        /** Adds additional messages to the thread before creating the run. */
        fun additionalMessages(additionalMessages: List<AdditionalMessage>?) = apply {
            body.additionalMessages(additionalMessages)
        }

        /** Adds additional messages to the thread before creating the run. */
        fun additionalMessages(additionalMessages: Optional<List<AdditionalMessage>>) =
            additionalMessages(additionalMessages.orElse(null))

        /** Adds additional messages to the thread before creating the run. */
        fun additionalMessages(additionalMessages: JsonField<List<AdditionalMessage>>) = apply {
            body.additionalMessages(additionalMessages)
        }

        /** Adds additional messages to the thread before creating the run. */
        fun addAdditionalMessage(additionalMessage: AdditionalMessage) = apply {
            body.addAdditionalMessage(additionalMessage)
        }

        /**
         * Overrides the
         * [instructions](https://platform.openai.com/docs/api-reference/assistants/createAssistant)
         * of the assistant. This is useful for modifying the behavior on a per-run basis.
         */
        fun instructions(instructions: String?) = apply { body.instructions(instructions) }

        /**
         * Overrides the
         * [instructions](https://platform.openai.com/docs/api-reference/assistants/createAssistant)
         * of the assistant. This is useful for modifying the behavior on a per-run basis.
         */
        fun instructions(instructions: Optional<String>) = instructions(instructions.orElse(null))

        /**
         * Overrides the
         * [instructions](https://platform.openai.com/docs/api-reference/assistants/createAssistant)
         * of the assistant. This is useful for modifying the behavior on a per-run basis.
         */
        fun instructions(instructions: JsonField<String>) = apply {
            body.instructions(instructions)
        }

        /**
         * The maximum number of completion tokens that may be used over the course of the run. The
         * run will make a best effort to use only the number of completion tokens specified, across
         * multiple turns of the run. If the run exceeds the number of completion tokens specified,
         * the run will end with status `incomplete`. See `incomplete_details` for more info.
         */
        fun maxCompletionTokens(maxCompletionTokens: Long?) = apply {
            body.maxCompletionTokens(maxCompletionTokens)
        }

        /**
         * The maximum number of completion tokens that may be used over the course of the run. The
         * run will make a best effort to use only the number of completion tokens specified, across
         * multiple turns of the run. If the run exceeds the number of completion tokens specified,
         * the run will end with status `incomplete`. See `incomplete_details` for more info.
         */
        fun maxCompletionTokens(maxCompletionTokens: Long) =
            maxCompletionTokens(maxCompletionTokens as Long?)

        /**
         * The maximum number of completion tokens that may be used over the course of the run. The
         * run will make a best effort to use only the number of completion tokens specified, across
         * multiple turns of the run. If the run exceeds the number of completion tokens specified,
         * the run will end with status `incomplete`. See `incomplete_details` for more info.
         */
        @Suppress("USELESS_CAST") // See https://youtrack.jetbrains.com/issue/KT-74228
        fun maxCompletionTokens(maxCompletionTokens: Optional<Long>) =
            maxCompletionTokens(maxCompletionTokens.orElse(null) as Long?)

        /**
         * The maximum number of completion tokens that may be used over the course of the run. The
         * run will make a best effort to use only the number of completion tokens specified, across
         * multiple turns of the run. If the run exceeds the number of completion tokens specified,
         * the run will end with status `incomplete`. See `incomplete_details` for more info.
         */
        fun maxCompletionTokens(maxCompletionTokens: JsonField<Long>) = apply {
            body.maxCompletionTokens(maxCompletionTokens)
        }

        /**
         * The maximum number of prompt tokens that may be used over the course of the run. The run
         * will make a best effort to use only the number of prompt tokens specified, across
         * multiple turns of the run. If the run exceeds the number of prompt tokens specified, the
         * run will end with status `incomplete`. See `incomplete_details` for more info.
         */
        fun maxPromptTokens(maxPromptTokens: Long?) = apply {
            body.maxPromptTokens(maxPromptTokens)
        }

        /**
         * The maximum number of prompt tokens that may be used over the course of the run. The run
         * will make a best effort to use only the number of prompt tokens specified, across
         * multiple turns of the run. If the run exceeds the number of prompt tokens specified, the
         * run will end with status `incomplete`. See `incomplete_details` for more info.
         */
        fun maxPromptTokens(maxPromptTokens: Long) = maxPromptTokens(maxPromptTokens as Long?)

        /**
         * The maximum number of prompt tokens that may be used over the course of the run. The run
         * will make a best effort to use only the number of prompt tokens specified, across
         * multiple turns of the run. If the run exceeds the number of prompt tokens specified, the
         * run will end with status `incomplete`. See `incomplete_details` for more info.
         */
        @Suppress("USELESS_CAST") // See https://youtrack.jetbrains.com/issue/KT-74228
        fun maxPromptTokens(maxPromptTokens: Optional<Long>) =
            maxPromptTokens(maxPromptTokens.orElse(null) as Long?)

        /**
         * The maximum number of prompt tokens that may be used over the course of the run. The run
         * will make a best effort to use only the number of prompt tokens specified, across
         * multiple turns of the run. If the run exceeds the number of prompt tokens specified, the
         * run will end with status `incomplete`. See `incomplete_details` for more info.
         */
        fun maxPromptTokens(maxPromptTokens: JsonField<Long>) = apply {
            body.maxPromptTokens(maxPromptTokens)
        }

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format. Keys can be a
         * maximum of 64 characters long and values can be a maximum of 512 characters long.
         */
        fun metadata(metadata: JsonValue) = apply { body.metadata(metadata) }

        /**
         * The ID of the [Model](https://platform.openai.com/docs/api-reference/models) to be used
         * to execute this run. If a value is provided here, it will override the model associated
         * with the assistant. If not, the model associated with the assistant will be used.
         */
        fun model(model: ChatModel?) = apply { body.model(model) }

        /**
         * The ID of the [Model](https://platform.openai.com/docs/api-reference/models) to be used
         * to execute this run. If a value is provided here, it will override the model associated
         * with the assistant. If not, the model associated with the assistant will be used.
         */
        fun model(model: Optional<ChatModel>) = model(model.orElse(null))

        /**
         * The ID of the [Model](https://platform.openai.com/docs/api-reference/models) to be used
         * to execute this run. If a value is provided here, it will override the model associated
         * with the assistant. If not, the model associated with the assistant will be used.
         */
        fun model(model: JsonField<ChatModel>) = apply { body.model(model) }

        /**
         * The ID of the [Model](https://platform.openai.com/docs/api-reference/models) to be used
         * to execute this run. If a value is provided here, it will override the model associated
         * with the assistant. If not, the model associated with the assistant will be used.
         */
        fun model(value: String) = apply { body.model(value) }

        /**
         * Whether to enable
         * [parallel function calling](https://platform.openai.com/docs/guides/function-calling#configuring-parallel-function-calling)
         * during tool use.
         */
        fun parallelToolCalls(parallelToolCalls: Boolean) = apply {
            body.parallelToolCalls(parallelToolCalls)
        }

        /**
         * Whether to enable
         * [parallel function calling](https://platform.openai.com/docs/guides/function-calling#configuring-parallel-function-calling)
         * during tool use.
         */
        fun parallelToolCalls(parallelToolCalls: JsonField<Boolean>) = apply {
            body.parallelToolCalls(parallelToolCalls)
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
        fun responseFormat(responseFormat: Optional<AssistantResponseFormatOption>) =
            responseFormat(responseFormat.orElse(null))

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
        fun responseFormat(responseFormat: JsonField<AssistantResponseFormatOption>) = apply {
            body.responseFormat(responseFormat)
        }

        /** `auto` is the default value */
        fun responseFormatAuto() = apply { body.responseFormatAuto() }

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
        fun responseFormat(responseFormatText: ResponseFormatText) = apply {
            body.responseFormat(responseFormatText)
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
        fun responseFormat(responseFormatJsonObject: ResponseFormatJsonObject) = apply {
            body.responseFormat(responseFormatJsonObject)
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
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic.
         */
        fun temperature(temperature: Double) = temperature(temperature as Double?)

        /**
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic.
         */
        @Suppress("USELESS_CAST") // See https://youtrack.jetbrains.com/issue/KT-74228
        fun temperature(temperature: Optional<Double>) =
            temperature(temperature.orElse(null) as Double?)

        /**
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic.
         */
        fun temperature(temperature: JsonField<Double>) = apply { body.temperature(temperature) }

        /**
         * Controls which (if any) tool is called by the model. `none` means the model will not call
         * any tools and instead generates a message. `auto` is the default value and means the
         * model can pick between generating a message or calling one or more tools. `required`
         * means the model must call one or more tools before responding to the user. Specifying a
         * particular tool like `{"type": "file_search"}` or `{"type": "function", "function":
         * {"name": "my_function"}}` forces the model to call that tool.
         */
        fun toolChoice(toolChoice: AssistantToolChoiceOption?) = apply {
            body.toolChoice(toolChoice)
        }

        /**
         * Controls which (if any) tool is called by the model. `none` means the model will not call
         * any tools and instead generates a message. `auto` is the default value and means the
         * model can pick between generating a message or calling one or more tools. `required`
         * means the model must call one or more tools before responding to the user. Specifying a
         * particular tool like `{"type": "file_search"}` or `{"type": "function", "function":
         * {"name": "my_function"}}` forces the model to call that tool.
         */
        fun toolChoice(toolChoice: Optional<AssistantToolChoiceOption>) =
            toolChoice(toolChoice.orElse(null))

        /**
         * Controls which (if any) tool is called by the model. `none` means the model will not call
         * any tools and instead generates a message. `auto` is the default value and means the
         * model can pick between generating a message or calling one or more tools. `required`
         * means the model must call one or more tools before responding to the user. Specifying a
         * particular tool like `{"type": "file_search"}` or `{"type": "function", "function":
         * {"name": "my_function"}}` forces the model to call that tool.
         */
        fun toolChoice(toolChoice: JsonField<AssistantToolChoiceOption>) = apply {
            body.toolChoice(toolChoice)
        }

        /**
         * `none` means the model will not call any tools and instead generates a message. `auto`
         * means the model can pick between generating a message or calling one or more tools.
         * `required` means the model must call one or more tools before responding to the user.
         */
        fun toolChoice(auto: AssistantToolChoiceOption.Auto) = apply { body.toolChoice(auto) }

        /**
         * Specifies a tool the model should use. Use to force the model to call a specific tool.
         */
        fun toolChoice(assistantToolChoice: AssistantToolChoice) = apply {
            body.toolChoice(assistantToolChoice)
        }

        /**
         * Override the tools the assistant can use for this run. This is useful for modifying the
         * behavior on a per-run basis.
         */
        fun tools(tools: List<AssistantTool>?) = apply { body.tools(tools) }

        /**
         * Override the tools the assistant can use for this run. This is useful for modifying the
         * behavior on a per-run basis.
         */
        fun tools(tools: Optional<List<AssistantTool>>) = tools(tools.orElse(null))

        /**
         * Override the tools the assistant can use for this run. This is useful for modifying the
         * behavior on a per-run basis.
         */
        fun tools(tools: JsonField<List<AssistantTool>>) = apply { body.tools(tools) }

        /**
         * Override the tools the assistant can use for this run. This is useful for modifying the
         * behavior on a per-run basis.
         */
        fun addTool(tool: AssistantTool) = apply { body.addTool(tool) }

        /**
         * Override the tools the assistant can use for this run. This is useful for modifying the
         * behavior on a per-run basis.
         */
        fun addTool(codeInterpreter: CodeInterpreterTool) = apply { body.addTool(codeInterpreter) }

        /**
         * Override the tools the assistant can use for this run. This is useful for modifying the
         * behavior on a per-run basis.
         */
        fun addTool(fileSearch: FileSearchTool) = apply { body.addTool(fileSearch) }

        /**
         * Override the tools the assistant can use for this run. This is useful for modifying the
         * behavior on a per-run basis.
         */
        fun addTool(function: FunctionTool) = apply { body.addTool(function) }

        /**
         * An alternative to sampling with temperature, called nucleus sampling, where the model
         * considers the results of the tokens with top_p probability mass. So 0.1 means only the
         * tokens comprising the top 10% probability mass are considered.
         *
         * We generally recommend altering this or temperature but not both.
         */
        fun topP(topP: Double?) = apply { body.topP(topP) }

        /**
         * An alternative to sampling with temperature, called nucleus sampling, where the model
         * considers the results of the tokens with top_p probability mass. So 0.1 means only the
         * tokens comprising the top 10% probability mass are considered.
         *
         * We generally recommend altering this or temperature but not both.
         */
        fun topP(topP: Double) = topP(topP as Double?)

        /**
         * An alternative to sampling with temperature, called nucleus sampling, where the model
         * considers the results of the tokens with top_p probability mass. So 0.1 means only the
         * tokens comprising the top 10% probability mass are considered.
         *
         * We generally recommend altering this or temperature but not both.
         */
        @Suppress("USELESS_CAST") // See https://youtrack.jetbrains.com/issue/KT-74228
        fun topP(topP: Optional<Double>) = topP(topP.orElse(null) as Double?)

        /**
         * An alternative to sampling with temperature, called nucleus sampling, where the model
         * considers the results of the tokens with top_p probability mass. So 0.1 means only the
         * tokens comprising the top 10% probability mass are considered.
         *
         * We generally recommend altering this or temperature but not both.
         */
        fun topP(topP: JsonField<Double>) = apply { body.topP(topP) }

        /**
         * Controls for how a thread will be truncated prior to the run. Use this to control the
         * intial context window of the run.
         */
        fun truncationStrategy(truncationStrategy: TruncationStrategy?) = apply {
            body.truncationStrategy(truncationStrategy)
        }

        /**
         * Controls for how a thread will be truncated prior to the run. Use this to control the
         * intial context window of the run.
         */
        fun truncationStrategy(truncationStrategy: Optional<TruncationStrategy>) =
            truncationStrategy(truncationStrategy.orElse(null))

        /**
         * Controls for how a thread will be truncated prior to the run. Use this to control the
         * intial context window of the run.
         */
        fun truncationStrategy(truncationStrategy: JsonField<TruncationStrategy>) = apply {
            body.truncationStrategy(truncationStrategy)
        }

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

        fun build(): BetaThreadRunCreateParams =
            BetaThreadRunCreateParams(
                checkRequired("threadId", threadId),
                include?.toImmutable(),
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    @NoAutoDetect
    class AdditionalMessage
    @JsonCreator
    private constructor(
        @JsonProperty("content")
        @ExcludeMissing
        private val content: JsonField<Content> = JsonMissing.of(),
        @JsonProperty("role") @ExcludeMissing private val role: JsonField<Role> = JsonMissing.of(),
        @JsonProperty("attachments")
        @ExcludeMissing
        private val attachments: JsonField<List<Attachment>> = JsonMissing.of(),
        @JsonProperty("metadata")
        @ExcludeMissing
        private val metadata: JsonValue = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The text contents of the message. */
        fun content(): Content = content.getRequired("content")

        /**
         * The role of the entity that is creating the message. Allowed values include:
         * - `user`: Indicates the message is sent by an actual user and should be used in most
         *   cases to represent user-generated messages.
         * - `assistant`: Indicates the message is generated by the assistant. Use this value to
         *   insert messages from the assistant into the conversation.
         */
        fun role(): Role = role.getRequired("role")

        /** A list of files attached to the message, and the tools they should be added to. */
        fun attachments(): Optional<List<Attachment>> =
            Optional.ofNullable(attachments.getNullable("attachments"))

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format. Keys can be a
         * maximum of 64 characters long and values can be a maximum of 512 characters long.
         */
        @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonValue = metadata

        /** The text contents of the message. */
        @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<Content> = content

        /**
         * The role of the entity that is creating the message. Allowed values include:
         * - `user`: Indicates the message is sent by an actual user and should be used in most
         *   cases to represent user-generated messages.
         * - `assistant`: Indicates the message is generated by the assistant. Use this value to
         *   insert messages from the assistant into the conversation.
         */
        @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<Role> = role

        /** A list of files attached to the message, and the tools they should be added to. */
        @JsonProperty("attachments")
        @ExcludeMissing
        fun _attachments(): JsonField<List<Attachment>> = attachments

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): AdditionalMessage = apply {
            if (validated) {
                return@apply
            }

            content().validate()
            role()
            attachments().ifPresent { it.forEach { it.validate() } }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [AdditionalMessage]. */
        class Builder internal constructor() {

            private var content: JsonField<Content>? = null
            private var role: JsonField<Role>? = null
            private var attachments: JsonField<MutableList<Attachment>>? = null
            private var metadata: JsonValue = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(additionalMessage: AdditionalMessage) = apply {
                content = additionalMessage.content
                role = additionalMessage.role
                attachments = additionalMessage.attachments.map { it.toMutableList() }
                metadata = additionalMessage.metadata
                additionalProperties = additionalMessage.additionalProperties.toMutableMap()
            }

            /** The text contents of the message. */
            fun content(content: Content) = content(JsonField.of(content))

            /** The text contents of the message. */
            fun content(content: JsonField<Content>) = apply { this.content = content }

            /** The text contents of the message. */
            fun content(text: String) = content(Content.ofText(text))

            /**
             * An array of content parts with a defined type, each can be of type `text` or images
             * can be passed with `image_url` or `image_file`. Image types are only supported on
             * [Vision-compatible models](https://platform.openai.com/docs/models).
             */
            fun contentOfArrayOfContentParts(arrayOfContentParts: List<MessageContentPartParam>) =
                content(Content.ofArrayOfContentParts(arrayOfContentParts))

            /**
             * The role of the entity that is creating the message. Allowed values include:
             * - `user`: Indicates the message is sent by an actual user and should be used in most
             *   cases to represent user-generated messages.
             * - `assistant`: Indicates the message is generated by the assistant. Use this value to
             *   insert messages from the assistant into the conversation.
             */
            fun role(role: Role) = role(JsonField.of(role))

            /**
             * The role of the entity that is creating the message. Allowed values include:
             * - `user`: Indicates the message is sent by an actual user and should be used in most
             *   cases to represent user-generated messages.
             * - `assistant`: Indicates the message is generated by the assistant. Use this value to
             *   insert messages from the assistant into the conversation.
             */
            fun role(role: JsonField<Role>) = apply { this.role = role }

            /** A list of files attached to the message, and the tools they should be added to. */
            fun attachments(attachments: List<Attachment>?) =
                attachments(JsonField.ofNullable(attachments))

            /** A list of files attached to the message, and the tools they should be added to. */
            fun attachments(attachments: Optional<List<Attachment>>) =
                attachments(attachments.orElse(null))

            /** A list of files attached to the message, and the tools they should be added to. */
            fun attachments(attachments: JsonField<List<Attachment>>) = apply {
                this.attachments = attachments.map { it.toMutableList() }
            }

            /** A list of files attached to the message, and the tools they should be added to. */
            fun addAttachment(attachment: Attachment) = apply {
                attachments =
                    (attachments ?: JsonField.of(mutableListOf())).apply {
                        asKnown()
                            .orElseThrow {
                                IllegalStateException(
                                    "Field was set to non-list type: ${javaClass.simpleName}"
                                )
                            }
                            .add(attachment)
                    }
            }

            /**
             * Set of 16 key-value pairs that can be attached to an object. This can be useful for
             * storing additional information about the object in a structured format. Keys can be a
             * maximum of 64 characters long and values can be a maximum of 512 characters long.
             */
            fun metadata(metadata: JsonValue) = apply { this.metadata = metadata }

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

            fun build(): AdditionalMessage =
                AdditionalMessage(
                    checkRequired("content", content),
                    checkRequired("role", role),
                    (attachments ?: JsonMissing.of()).map { it.toImmutable() },
                    metadata,
                    additionalProperties.toImmutable(),
                )
        }

        /** The text contents of the message. */
        @JsonDeserialize(using = Content.Deserializer::class)
        @JsonSerialize(using = Content.Serializer::class)
        class Content
        private constructor(
            private val text: String? = null,
            private val arrayOfContentParts: List<MessageContentPartParam>? = null,
            private val _json: JsonValue? = null,
        ) {

            /** The text contents of the message. */
            fun text(): Optional<String> = Optional.ofNullable(text)

            /**
             * An array of content parts with a defined type, each can be of type `text` or images
             * can be passed with `image_url` or `image_file`. Image types are only supported on
             * [Vision-compatible models](https://platform.openai.com/docs/models).
             */
            fun arrayOfContentParts(): Optional<List<MessageContentPartParam>> =
                Optional.ofNullable(arrayOfContentParts)

            fun isText(): Boolean = text != null

            fun isArrayOfContentParts(): Boolean = arrayOfContentParts != null

            /** The text contents of the message. */
            fun asText(): String = text.getOrThrow("text")

            /**
             * An array of content parts with a defined type, each can be of type `text` or images
             * can be passed with `image_url` or `image_file`. Image types are only supported on
             * [Vision-compatible models](https://platform.openai.com/docs/models).
             */
            fun asArrayOfContentParts(): List<MessageContentPartParam> =
                arrayOfContentParts.getOrThrow("arrayOfContentParts")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T {
                return when {
                    text != null -> visitor.visitText(text)
                    arrayOfContentParts != null ->
                        visitor.visitArrayOfContentParts(arrayOfContentParts)
                    else -> visitor.unknown(_json)
                }
            }

            private var validated: Boolean = false

            fun validate(): Content = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitText(text: String) {}

                        override fun visitArrayOfContentParts(
                            arrayOfContentParts: List<MessageContentPartParam>
                        ) {
                            arrayOfContentParts.forEach { it.validate() }
                        }
                    }
                )
                validated = true
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Content && text == other.text && arrayOfContentParts == other.arrayOfContentParts /* spotless:on */
            }

            override fun hashCode(): Int = /* spotless:off */ Objects.hash(text, arrayOfContentParts) /* spotless:on */

            override fun toString(): String =
                when {
                    text != null -> "Content{text=$text}"
                    arrayOfContentParts != null ->
                        "Content{arrayOfContentParts=$arrayOfContentParts}"
                    _json != null -> "Content{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Content")
                }

            companion object {

                /** The text contents of the message. */
                @JvmStatic fun ofText(text: String) = Content(text = text)

                /**
                 * An array of content parts with a defined type, each can be of type `text` or
                 * images can be passed with `image_url` or `image_file`. Image types are only
                 * supported on [Vision-compatible models](https://platform.openai.com/docs/models).
                 */
                @JvmStatic
                fun ofArrayOfContentParts(arrayOfContentParts: List<MessageContentPartParam>) =
                    Content(arrayOfContentParts = arrayOfContentParts)
            }

            /**
             * An interface that defines how to map each variant of [Content] to a value of type
             * [T].
             */
            interface Visitor<out T> {

                /** The text contents of the message. */
                fun visitText(text: String): T

                /**
                 * An array of content parts with a defined type, each can be of type `text` or
                 * images can be passed with `image_url` or `image_file`. Image types are only
                 * supported on [Vision-compatible models](https://platform.openai.com/docs/models).
                 */
                fun visitArrayOfContentParts(arrayOfContentParts: List<MessageContentPartParam>): T

                /**
                 * Maps an unknown variant of [Content] to a value of type [T].
                 *
                 * An instance of [Content] can contain an unknown variant if it was deserialized
                 * from data that doesn't match any known variant. For example, if the SDK is on an
                 * older version than the API, then the API may respond with new variants that the
                 * SDK is unaware of.
                 *
                 * @throws OpenAIInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown Content: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<Content>(Content::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Content {
                    val json = JsonValue.fromJsonNode(node)

                    tryDeserialize(node, jacksonTypeRef<String>())?.let {
                        return Content(text = it, _json = json)
                    }
                    tryDeserialize(node, jacksonTypeRef<List<MessageContentPartParam>>()) {
                            it.forEach { it.validate() }
                        }
                        ?.let {
                            return Content(arrayOfContentParts = it, _json = json)
                        }

                    return Content(_json = json)
                }
            }

            internal class Serializer : BaseSerializer<Content>(Content::class) {

                override fun serialize(
                    value: Content,
                    generator: JsonGenerator,
                    provider: SerializerProvider
                ) {
                    when {
                        value.text != null -> generator.writeObject(value.text)
                        value.arrayOfContentParts != null ->
                            generator.writeObject(value.arrayOfContentParts)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Content")
                    }
                }
            }
        }

        /**
         * The role of the entity that is creating the message. Allowed values include:
         * - `user`: Indicates the message is sent by an actual user and should be used in most
         *   cases to represent user-generated messages.
         * - `assistant`: Indicates the message is generated by the assistant. Use this value to
         *   insert messages from the assistant into the conversation.
         */
        class Role
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

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

                @JvmField val USER = of("user")

                @JvmField val ASSISTANT = of("assistant")

                @JvmStatic fun of(value: String) = Role(JsonField.of(value))
            }

            /** An enum containing [Role]'s known values. */
            enum class Known {
                USER,
                ASSISTANT,
            }

            /**
             * An enum containing [Role]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Role] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                USER,
                ASSISTANT,
                /** An enum member indicating that [Role] was instantiated with an unknown value. */
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
                    USER -> Value.USER
                    ASSISTANT -> Value.ASSISTANT
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
                    USER -> Known.USER
                    ASSISTANT -> Known.ASSISTANT
                    else -> throw OpenAIInvalidDataException("Unknown Role: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Role && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        @NoAutoDetect
        class Attachment
        @JsonCreator
        private constructor(
            @JsonProperty("file_id")
            @ExcludeMissing
            private val fileId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("tools")
            @ExcludeMissing
            private val tools: JsonField<List<Tool>> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /** The ID of the file to attach to the message. */
            fun fileId(): Optional<String> = Optional.ofNullable(fileId.getNullable("file_id"))

            /** The tools to add this file to. */
            fun tools(): Optional<List<Tool>> = Optional.ofNullable(tools.getNullable("tools"))

            /** The ID of the file to attach to the message. */
            @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

            /** The tools to add this file to. */
            @JsonProperty("tools") @ExcludeMissing fun _tools(): JsonField<List<Tool>> = tools

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): Attachment = apply {
                if (validated) {
                    return@apply
                }

                fileId()
                tools().ifPresent { it.forEach { it.validate() } }
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Attachment]. */
            class Builder internal constructor() {

                private var fileId: JsonField<String> = JsonMissing.of()
                private var tools: JsonField<MutableList<Tool>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(attachment: Attachment) = apply {
                    fileId = attachment.fileId
                    tools = attachment.tools.map { it.toMutableList() }
                    additionalProperties = attachment.additionalProperties.toMutableMap()
                }

                /** The ID of the file to attach to the message. */
                fun fileId(fileId: String) = fileId(JsonField.of(fileId))

                /** The ID of the file to attach to the message. */
                fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

                /** The tools to add this file to. */
                fun tools(tools: List<Tool>) = tools(JsonField.of(tools))

                /** The tools to add this file to. */
                fun tools(tools: JsonField<List<Tool>>) = apply {
                    this.tools = tools.map { it.toMutableList() }
                }

                /** The tools to add this file to. */
                fun addTool(tool: Tool) = apply {
                    tools =
                        (tools ?: JsonField.of(mutableListOf())).apply {
                            asKnown()
                                .orElseThrow {
                                    IllegalStateException(
                                        "Field was set to non-list type: ${javaClass.simpleName}"
                                    )
                                }
                                .add(tool)
                        }
                }

                /** The tools to add this file to. */
                fun addTool(codeInterpreter: CodeInterpreterTool) =
                    addTool(Tool.ofCodeInterpreter(codeInterpreter))

                /** The tools to add this file to. */
                fun addToolFileSearch() = addTool(Tool.ofFileSearch())

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

                fun build(): Attachment =
                    Attachment(
                        fileId,
                        (tools ?: JsonMissing.of()).map { it.toImmutable() },
                        additionalProperties.toImmutable(),
                    )
            }

            @JsonDeserialize(using = Tool.Deserializer::class)
            @JsonSerialize(using = Tool.Serializer::class)
            class Tool
            private constructor(
                private val codeInterpreter: CodeInterpreterTool? = null,
                private val fileSearch: JsonValue? = null,
                private val _json: JsonValue? = null,
            ) {

                fun codeInterpreter(): Optional<CodeInterpreterTool> =
                    Optional.ofNullable(codeInterpreter)

                fun fileSearch(): Optional<JsonValue> = Optional.ofNullable(fileSearch)

                fun isCodeInterpreter(): Boolean = codeInterpreter != null

                fun isFileSearch(): Boolean = fileSearch != null

                fun asCodeInterpreter(): CodeInterpreterTool =
                    codeInterpreter.getOrThrow("codeInterpreter")

                fun asFileSearch(): JsonValue = fileSearch.getOrThrow("fileSearch")

                fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                fun <T> accept(visitor: Visitor<T>): T {
                    return when {
                        codeInterpreter != null -> visitor.visitCodeInterpreter(codeInterpreter)
                        fileSearch != null -> visitor.visitFileSearch(fileSearch)
                        else -> visitor.unknown(_json)
                    }
                }

                private var validated: Boolean = false

                fun validate(): Tool = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitCodeInterpreter(
                                codeInterpreter: CodeInterpreterTool
                            ) {
                                codeInterpreter.validate()
                            }

                            override fun visitFileSearch(fileSearch: JsonValue) {
                                fileSearch.let {
                                    if (it != JsonValue.from(mapOf("type" to "file_search"))) {
                                        throw OpenAIInvalidDataException(
                                            "'fileSearch' is invalid, received $it"
                                        )
                                    }
                                }
                            }
                        }
                    )
                    validated = true
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Tool && codeInterpreter == other.codeInterpreter && fileSearch == other.fileSearch /* spotless:on */
                }

                override fun hashCode(): Int = /* spotless:off */ Objects.hash(codeInterpreter, fileSearch) /* spotless:on */

                override fun toString(): String =
                    when {
                        codeInterpreter != null -> "Tool{codeInterpreter=$codeInterpreter}"
                        fileSearch != null -> "Tool{fileSearch=$fileSearch}"
                        _json != null -> "Tool{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid Tool")
                    }

                companion object {

                    @JvmStatic
                    fun ofCodeInterpreter(codeInterpreter: CodeInterpreterTool) =
                        Tool(codeInterpreter = codeInterpreter)

                    @JvmStatic
                    fun ofFileSearch() =
                        Tool(fileSearch = JsonValue.from(mapOf("type" to "file_search")))
                }

                /**
                 * An interface that defines how to map each variant of [Tool] to a value of type
                 * [T].
                 */
                interface Visitor<out T> {

                    fun visitCodeInterpreter(codeInterpreter: CodeInterpreterTool): T

                    fun visitFileSearch(fileSearch: JsonValue): T

                    /**
                     * Maps an unknown variant of [Tool] to a value of type [T].
                     *
                     * An instance of [Tool] can contain an unknown variant if it was deserialized
                     * from data that doesn't match any known variant. For example, if the SDK is on
                     * an older version than the API, then the API may respond with new variants
                     * that the SDK is unaware of.
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
                            "code_interpreter" -> {
                                tryDeserialize(node, jacksonTypeRef<CodeInterpreterTool>()) {
                                        it.validate()
                                    }
                                    ?.let {
                                        return Tool(codeInterpreter = it, _json = json)
                                    }
                            }
                            "file_search" -> {
                                tryDeserialize(node, jacksonTypeRef<JsonValue>()) {
                                        it.let {
                                            if (
                                                it != JsonValue.from(mapOf("type" to "file_search"))
                                            ) {
                                                throw OpenAIInvalidDataException(
                                                    "'fileSearch' is invalid, received $it"
                                                )
                                            }
                                        }
                                    }
                                    ?.let {
                                        return Tool(fileSearch = it, _json = json)
                                    }
                            }
                        }

                        return Tool(_json = json)
                    }
                }

                internal class Serializer : BaseSerializer<Tool>(Tool::class) {

                    override fun serialize(
                        value: Tool,
                        generator: JsonGenerator,
                        provider: SerializerProvider
                    ) {
                        when {
                            value.codeInterpreter != null ->
                                generator.writeObject(value.codeInterpreter)
                            value.fileSearch != null -> generator.writeObject(value.fileSearch)
                            value._json != null -> generator.writeObject(value._json)
                            else -> throw IllegalStateException("Invalid Tool")
                        }
                    }
                }
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Attachment && fileId == other.fileId && tools == other.tools && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(fileId, tools, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Attachment{fileId=$fileId, tools=$tools, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is AdditionalMessage && content == other.content && role == other.role && attachments == other.attachments && metadata == other.metadata && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(content, role, attachments, metadata, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "AdditionalMessage{content=$content, role=$role, attachments=$attachments, metadata=$metadata, additionalProperties=$additionalProperties}"
    }

    /**
     * Controls for how a thread will be truncated prior to the run. Use this to control the intial
     * context window of the run.
     */
    @NoAutoDetect
    class TruncationStrategy
    @JsonCreator
    private constructor(
        @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
        @JsonProperty("last_messages")
        @ExcludeMissing
        private val lastMessages: JsonField<Long> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * The truncation strategy to use for the thread. The default is `auto`. If set to
         * `last_messages`, the thread will be truncated to the n most recent messages in the
         * thread. When set to `auto`, messages in the middle of the thread will be dropped to fit
         * the context length of the model, `max_prompt_tokens`.
         */
        fun type(): Type = type.getRequired("type")

        /**
         * The number of most recent messages from the thread when constructing the context for the
         * run.
         */
        fun lastMessages(): Optional<Long> =
            Optional.ofNullable(lastMessages.getNullable("last_messages"))

        /**
         * The truncation strategy to use for the thread. The default is `auto`. If set to
         * `last_messages`, the thread will be truncated to the n most recent messages in the
         * thread. When set to `auto`, messages in the middle of the thread will be dropped to fit
         * the context length of the model, `max_prompt_tokens`.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

        /**
         * The number of most recent messages from the thread when constructing the context for the
         * run.
         */
        @JsonProperty("last_messages")
        @ExcludeMissing
        fun _lastMessages(): JsonField<Long> = lastMessages

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): TruncationStrategy = apply {
            if (validated) {
                return@apply
            }

            type()
            lastMessages()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [TruncationStrategy]. */
        class Builder internal constructor() {

            private var type: JsonField<Type>? = null
            private var lastMessages: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(truncationStrategy: TruncationStrategy) = apply {
                type = truncationStrategy.type
                lastMessages = truncationStrategy.lastMessages
                additionalProperties = truncationStrategy.additionalProperties.toMutableMap()
            }

            /**
             * The truncation strategy to use for the thread. The default is `auto`. If set to
             * `last_messages`, the thread will be truncated to the n most recent messages in the
             * thread. When set to `auto`, messages in the middle of the thread will be dropped to
             * fit the context length of the model, `max_prompt_tokens`.
             */
            fun type(type: Type) = type(JsonField.of(type))

            /**
             * The truncation strategy to use for the thread. The default is `auto`. If set to
             * `last_messages`, the thread will be truncated to the n most recent messages in the
             * thread. When set to `auto`, messages in the middle of the thread will be dropped to
             * fit the context length of the model, `max_prompt_tokens`.
             */
            fun type(type: JsonField<Type>) = apply { this.type = type }

            /**
             * The number of most recent messages from the thread when constructing the context for
             * the run.
             */
            fun lastMessages(lastMessages: Long?) = lastMessages(JsonField.ofNullable(lastMessages))

            /**
             * The number of most recent messages from the thread when constructing the context for
             * the run.
             */
            fun lastMessages(lastMessages: Long) = lastMessages(lastMessages as Long?)

            /**
             * The number of most recent messages from the thread when constructing the context for
             * the run.
             */
            @Suppress("USELESS_CAST") // See https://youtrack.jetbrains.com/issue/KT-74228
            fun lastMessages(lastMessages: Optional<Long>) =
                lastMessages(lastMessages.orElse(null) as Long?)

            /**
             * The number of most recent messages from the thread when constructing the context for
             * the run.
             */
            fun lastMessages(lastMessages: JsonField<Long>) = apply {
                this.lastMessages = lastMessages
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

            fun build(): TruncationStrategy =
                TruncationStrategy(
                    checkRequired("type", type),
                    lastMessages,
                    additionalProperties.toImmutable(),
                )
        }

        /**
         * The truncation strategy to use for the thread. The default is `auto`. If set to
         * `last_messages`, the thread will be truncated to the n most recent messages in the
         * thread. When set to `auto`, messages in the middle of the thread will be dropped to fit
         * the context length of the model, `max_prompt_tokens`.
         */
        class Type
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

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

                @JvmField val LAST_MESSAGES = of("last_messages")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            enum class Known {
                AUTO,
                LAST_MESSAGES,
            }

            /**
             * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Type] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                AUTO,
                LAST_MESSAGES,
                /** An enum member indicating that [Type] was instantiated with an unknown value. */
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
                    LAST_MESSAGES -> Value.LAST_MESSAGES
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
                    LAST_MESSAGES -> Known.LAST_MESSAGES
                    else -> throw OpenAIInvalidDataException("Unknown Type: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Type && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is TruncationStrategy && type == other.type && lastMessages == other.lastMessages && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(type, lastMessages, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "TruncationStrategy{type=$type, lastMessages=$lastMessages, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is BetaThreadRunCreateParams && threadId == other.threadId && include == other.include && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(threadId, include, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "BetaThreadRunCreateParams{threadId=$threadId, include=$include, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
