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
import com.openai.core.NoAutoDetect
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.ChatModel
import com.openai.models.Metadata
import com.openai.models.Reasoning
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

@NoAutoDetect
class Response
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("created_at")
    @ExcludeMissing
    private val createdAt: JsonField<Double> = JsonMissing.of(),
    @JsonProperty("error")
    @ExcludeMissing
    private val error: JsonField<ResponseError> = JsonMissing.of(),
    @JsonProperty("incomplete_details")
    @ExcludeMissing
    private val incompleteDetails: JsonField<IncompleteDetails> = JsonMissing.of(),
    @JsonProperty("instructions")
    @ExcludeMissing
    private val instructions: JsonField<String> = JsonMissing.of(),
    @JsonProperty("metadata")
    @ExcludeMissing
    private val metadata: JsonField<Metadata> = JsonMissing.of(),
    @JsonProperty("model")
    @ExcludeMissing
    private val model: JsonField<ChatModel> = JsonMissing.of(),
    @JsonProperty("object") @ExcludeMissing private val object_: JsonValue = JsonMissing.of(),
    @JsonProperty("output")
    @ExcludeMissing
    private val output: JsonField<List<ResponseOutputItem>> = JsonMissing.of(),
    @JsonProperty("parallel_tool_calls")
    @ExcludeMissing
    private val parallelToolCalls: JsonField<Boolean> = JsonMissing.of(),
    @JsonProperty("temperature")
    @ExcludeMissing
    private val temperature: JsonField<Double> = JsonMissing.of(),
    @JsonProperty("tool_choice")
    @ExcludeMissing
    private val toolChoice: JsonField<ToolChoice> = JsonMissing.of(),
    @JsonProperty("tools")
    @ExcludeMissing
    private val tools: JsonField<List<Tool>> = JsonMissing.of(),
    @JsonProperty("top_p") @ExcludeMissing private val topP: JsonField<Double> = JsonMissing.of(),
    @JsonProperty("max_output_tokens")
    @ExcludeMissing
    private val maxOutputTokens: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("previous_response_id")
    @ExcludeMissing
    private val previousResponseId: JsonField<String> = JsonMissing.of(),
    @JsonProperty("reasoning")
    @ExcludeMissing
    private val reasoning: JsonField<Reasoning> = JsonMissing.of(),
    @JsonProperty("status")
    @ExcludeMissing
    private val status: JsonField<ResponseStatus> = JsonMissing.of(),
    @JsonProperty("text")
    @ExcludeMissing
    private val text: JsonField<ResponseTextConfig> = JsonMissing.of(),
    @JsonProperty("truncation")
    @ExcludeMissing
    private val truncation: JsonField<Truncation> = JsonMissing.of(),
    @JsonProperty("usage")
    @ExcludeMissing
    private val usage: JsonField<ResponseUsage> = JsonMissing.of(),
    @JsonProperty("user") @ExcludeMissing private val user: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** Unique identifier for this Response. */
    fun id(): String = id.getRequired("id")

    /** Unix timestamp (in seconds) of when this Response was created. */
    fun createdAt(): Double = createdAt.getRequired("created_at")

    /** An error object returned when the model fails to generate a Response. */
    fun error(): Optional<ResponseError> = Optional.ofNullable(error.getNullable("error"))

    /** Details about why the response is incomplete. */
    fun incompleteDetails(): Optional<IncompleteDetails> =
        Optional.ofNullable(incompleteDetails.getNullable("incomplete_details"))

    /**
     * Inserts a system (or developer) message as the first item in the model's context.
     *
     * When using along with `previous_response_id`, the instructions from a previous response will
     * be not be carried over to the next response. This makes it simple to swap out system (or
     * developer) messages in new responses.
     */
    fun instructions(): Optional<String> =
        Optional.ofNullable(instructions.getNullable("instructions"))

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format, and querying for objects via
     * API or the dashboard.
     *
     * Keys are strings with a maximum length of 64 characters. Values are strings with a maximum
     * length of 512 characters.
     */
    fun metadata(): Optional<Metadata> = Optional.ofNullable(metadata.getNullable("metadata"))

    /**
     * Model ID used to generate the response, like `gpt-4o` or `o1`. OpenAI offers a wide range of
     * models with different capabilities, performance characteristics, and price points. Refer to
     * the [model guide](https://platform.openai.com/docs/models) to browse and compare available
     * models.
     */
    fun model(): ChatModel = model.getRequired("model")

    /** The object type of this resource - always set to `response`. */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * An array of content items generated by the model.
     * - The length and order of items in the `output` array is dependent on the model's response.
     * - Rather than accessing the first item in the `output` array and assuming it's an `assistant`
     *   message with the content generated by the model, you might consider using the `output_text`
     *   property where supported in SDKs.
     */
    fun output(): List<ResponseOutputItem> = output.getRequired("output")

    /** Whether to allow the model to run tool calls in parallel. */
    fun parallelToolCalls(): Boolean = parallelToolCalls.getRequired("parallel_tool_calls")

    /**
     * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
     * output more random, while lower values like 0.2 will make it more focused and deterministic.
     * We generally recommend altering this or `top_p` but not both.
     */
    fun temperature(): Optional<Double> =
        Optional.ofNullable(temperature.getNullable("temperature"))

    /**
     * How the model should select which tool (or tools) to use when generating a response. See the
     * `tools` parameter to see how to specify which tools the model can call.
     */
    fun toolChoice(): ToolChoice = toolChoice.getRequired("tool_choice")

    /**
     * An array of tools the model may call while generating a response. You can specify which tool
     * to use by setting the `tool_choice` parameter.
     *
     * The two categories of tools you can provide the model are:
     * - **Built-in tools**: Tools that are provided by OpenAI that extend the model's capabilities,
     *   like [web search](https://platform.openai.com/docs/guides/tools-web-search) or
     *   [file search](https://platform.openai.com/docs/guides/tools-file-search). Learn more about
     *   [built-in tools](https://platform.openai.com/docs/guides/tools).
     * - **Function calls (custom tools)**: Functions that are defined by you, enabling the model to
     *   call your own code. Learn more about
     *   [function calling](https://platform.openai.com/docs/guides/function-calling).
     */
    fun tools(): List<Tool> = tools.getRequired("tools")

    /**
     * An alternative to sampling with temperature, called nucleus sampling, where the model
     * considers the results of the tokens with top_p probability mass. So 0.1 means only the tokens
     * comprising the top 10% probability mass are considered.
     *
     * We generally recommend altering this or `temperature` but not both.
     */
    fun topP(): Optional<Double> = Optional.ofNullable(topP.getNullable("top_p"))

    /**
     * An upper bound for the number of tokens that can be generated for a response, including
     * visible output tokens and
     * [reasoning tokens](https://platform.openai.com/docs/guides/reasoning).
     */
    fun maxOutputTokens(): Optional<Long> =
        Optional.ofNullable(maxOutputTokens.getNullable("max_output_tokens"))

    /**
     * The unique ID of the previous response to the model. Use this to create multi-turn
     * conversations. Learn more about
     * [conversation state](https://platform.openai.com/docs/guides/conversation-state).
     */
    fun previousResponseId(): Optional<String> =
        Optional.ofNullable(previousResponseId.getNullable("previous_response_id"))

    /**
     * **o-series models only**
     *
     * Configuration options for
     * [reasoning models](https://platform.openai.com/docs/guides/reasoning).
     */
    fun reasoning(): Optional<Reasoning> = Optional.ofNullable(reasoning.getNullable("reasoning"))

    /**
     * The status of the response generation. One of `completed`, `failed`, `in_progress`, or
     * `incomplete`.
     */
    fun status(): Optional<ResponseStatus> = Optional.ofNullable(status.getNullable("status"))

    /**
     * Configuration options for a text response from the model. Can be plain text or structured
     * JSON data. Learn more:
     * - [Text inputs and outputs](https://platform.openai.com/docs/guides/text)
     * - [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs)
     */
    fun text(): Optional<ResponseTextConfig> = Optional.ofNullable(text.getNullable("text"))

    /**
     * The truncation strategy to use for the model response.
     * - `auto`: If the context of this response and previous ones exceeds the model's context
     *   window size, the model will truncate the response to fit the context window by dropping
     *   input items in the middle of the conversation.
     * - `disabled` (default): If a model response will exceed the context window size for a model,
     *   the request will fail with a 400 error.
     */
    fun truncation(): Optional<Truncation> =
        Optional.ofNullable(truncation.getNullable("truncation"))

    /**
     * Represents token usage details including input tokens, output tokens, a breakdown of output
     * tokens, and the total tokens used.
     */
    fun usage(): Optional<ResponseUsage> = Optional.ofNullable(usage.getNullable("usage"))

    /**
     * A unique identifier representing your end-user, which can help OpenAI to monitor and detect
     * abuse.
     * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
     */
    fun user(): Optional<String> = Optional.ofNullable(user.getNullable("user"))

    /** Unique identifier for this Response. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** Unix timestamp (in seconds) of when this Response was created. */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt(): JsonField<Double> = createdAt

    /** An error object returned when the model fails to generate a Response. */
    @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<ResponseError> = error

    /** Details about why the response is incomplete. */
    @JsonProperty("incomplete_details")
    @ExcludeMissing
    fun _incompleteDetails(): JsonField<IncompleteDetails> = incompleteDetails

    /**
     * Inserts a system (or developer) message as the first item in the model's context.
     *
     * When using along with `previous_response_id`, the instructions from a previous response will
     * be not be carried over to the next response. This makes it simple to swap out system (or
     * developer) messages in new responses.
     */
    @JsonProperty("instructions")
    @ExcludeMissing
    fun _instructions(): JsonField<String> = instructions

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format, and querying for objects via
     * API or the dashboard.
     *
     * Keys are strings with a maximum length of 64 characters. Values are strings with a maximum
     * length of 512 characters.
     */
    @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonField<Metadata> = metadata

    /**
     * Model ID used to generate the response, like `gpt-4o` or `o1`. OpenAI offers a wide range of
     * models with different capabilities, performance characteristics, and price points. Refer to
     * the [model guide](https://platform.openai.com/docs/models) to browse and compare available
     * models.
     */
    @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<ChatModel> = model

    /**
     * An array of content items generated by the model.
     * - The length and order of items in the `output` array is dependent on the model's response.
     * - Rather than accessing the first item in the `output` array and assuming it's an `assistant`
     *   message with the content generated by the model, you might consider using the `output_text`
     *   property where supported in SDKs.
     */
    @JsonProperty("output")
    @ExcludeMissing
    fun _output(): JsonField<List<ResponseOutputItem>> = output

    /** Whether to allow the model to run tool calls in parallel. */
    @JsonProperty("parallel_tool_calls")
    @ExcludeMissing
    fun _parallelToolCalls(): JsonField<Boolean> = parallelToolCalls

    /**
     * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
     * output more random, while lower values like 0.2 will make it more focused and deterministic.
     * We generally recommend altering this or `top_p` but not both.
     */
    @JsonProperty("temperature") @ExcludeMissing fun _temperature(): JsonField<Double> = temperature

    /**
     * How the model should select which tool (or tools) to use when generating a response. See the
     * `tools` parameter to see how to specify which tools the model can call.
     */
    @JsonProperty("tool_choice")
    @ExcludeMissing
    fun _toolChoice(): JsonField<ToolChoice> = toolChoice

    /**
     * An array of tools the model may call while generating a response. You can specify which tool
     * to use by setting the `tool_choice` parameter.
     *
     * The two categories of tools you can provide the model are:
     * - **Built-in tools**: Tools that are provided by OpenAI that extend the model's capabilities,
     *   like [web search](https://platform.openai.com/docs/guides/tools-web-search) or
     *   [file search](https://platform.openai.com/docs/guides/tools-file-search). Learn more about
     *   [built-in tools](https://platform.openai.com/docs/guides/tools).
     * - **Function calls (custom tools)**: Functions that are defined by you, enabling the model to
     *   call your own code. Learn more about
     *   [function calling](https://platform.openai.com/docs/guides/function-calling).
     */
    @JsonProperty("tools") @ExcludeMissing fun _tools(): JsonField<List<Tool>> = tools

    /**
     * An alternative to sampling with temperature, called nucleus sampling, where the model
     * considers the results of the tokens with top_p probability mass. So 0.1 means only the tokens
     * comprising the top 10% probability mass are considered.
     *
     * We generally recommend altering this or `temperature` but not both.
     */
    @JsonProperty("top_p") @ExcludeMissing fun _topP(): JsonField<Double> = topP

    /**
     * An upper bound for the number of tokens that can be generated for a response, including
     * visible output tokens and
     * [reasoning tokens](https://platform.openai.com/docs/guides/reasoning).
     */
    @JsonProperty("max_output_tokens")
    @ExcludeMissing
    fun _maxOutputTokens(): JsonField<Long> = maxOutputTokens

    /**
     * The unique ID of the previous response to the model. Use this to create multi-turn
     * conversations. Learn more about
     * [conversation state](https://platform.openai.com/docs/guides/conversation-state).
     */
    @JsonProperty("previous_response_id")
    @ExcludeMissing
    fun _previousResponseId(): JsonField<String> = previousResponseId

    /**
     * **o-series models only**
     *
     * Configuration options for
     * [reasoning models](https://platform.openai.com/docs/guides/reasoning).
     */
    @JsonProperty("reasoning") @ExcludeMissing fun _reasoning(): JsonField<Reasoning> = reasoning

    /**
     * The status of the response generation. One of `completed`, `failed`, `in_progress`, or
     * `incomplete`.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<ResponseStatus> = status

    /**
     * Configuration options for a text response from the model. Can be plain text or structured
     * JSON data. Learn more:
     * - [Text inputs and outputs](https://platform.openai.com/docs/guides/text)
     * - [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs)
     */
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<ResponseTextConfig> = text

    /**
     * The truncation strategy to use for the model response.
     * - `auto`: If the context of this response and previous ones exceeds the model's context
     *   window size, the model will truncate the response to fit the context window by dropping
     *   input items in the middle of the conversation.
     * - `disabled` (default): If a model response will exceed the context window size for a model,
     *   the request will fail with a 400 error.
     */
    @JsonProperty("truncation")
    @ExcludeMissing
    fun _truncation(): JsonField<Truncation> = truncation

    /**
     * Represents token usage details including input tokens, output tokens, a breakdown of output
     * tokens, and the total tokens used.
     */
    @JsonProperty("usage") @ExcludeMissing fun _usage(): JsonField<ResponseUsage> = usage

    /**
     * A unique identifier representing your end-user, which can help OpenAI to monitor and detect
     * abuse.
     * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
     */
    @JsonProperty("user") @ExcludeMissing fun _user(): JsonField<String> = user

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): Response = apply {
        if (validated) {
            return@apply
        }

        id()
        createdAt()
        error().ifPresent { it.validate() }
        incompleteDetails().ifPresent { it.validate() }
        instructions()
        metadata().ifPresent { it.validate() }
        model()
        _object_().let {
            if (it != JsonValue.from("response")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        output().forEach { it.validate() }
        parallelToolCalls()
        temperature()
        toolChoice().validate()
        tools().forEach { it.validate() }
        topP()
        maxOutputTokens()
        previousResponseId()
        reasoning().ifPresent { it.validate() }
        status()
        text().ifPresent { it.validate() }
        truncation()
        usage().ifPresent { it.validate() }
        user()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [Response].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .error()
         * .incompleteDetails()
         * .instructions()
         * .metadata()
         * .model()
         * .output()
         * .parallelToolCalls()
         * .temperature()
         * .toolChoice()
         * .tools()
         * .topP()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Response]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var createdAt: JsonField<Double>? = null
        private var error: JsonField<ResponseError>? = null
        private var incompleteDetails: JsonField<IncompleteDetails>? = null
        private var instructions: JsonField<String>? = null
        private var metadata: JsonField<Metadata>? = null
        private var model: JsonField<ChatModel>? = null
        private var object_: JsonValue = JsonValue.from("response")
        private var output: JsonField<MutableList<ResponseOutputItem>>? = null
        private var parallelToolCalls: JsonField<Boolean>? = null
        private var temperature: JsonField<Double>? = null
        private var toolChoice: JsonField<ToolChoice>? = null
        private var tools: JsonField<MutableList<Tool>>? = null
        private var topP: JsonField<Double>? = null
        private var maxOutputTokens: JsonField<Long> = JsonMissing.of()
        private var previousResponseId: JsonField<String> = JsonMissing.of()
        private var reasoning: JsonField<Reasoning> = JsonMissing.of()
        private var status: JsonField<ResponseStatus> = JsonMissing.of()
        private var text: JsonField<ResponseTextConfig> = JsonMissing.of()
        private var truncation: JsonField<Truncation> = JsonMissing.of()
        private var usage: JsonField<ResponseUsage> = JsonMissing.of()
        private var user: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(response: Response) = apply {
            id = response.id
            createdAt = response.createdAt
            error = response.error
            incompleteDetails = response.incompleteDetails
            instructions = response.instructions
            metadata = response.metadata
            model = response.model
            object_ = response.object_
            output = response.output.map { it.toMutableList() }
            parallelToolCalls = response.parallelToolCalls
            temperature = response.temperature
            toolChoice = response.toolChoice
            tools = response.tools.map { it.toMutableList() }
            topP = response.topP
            maxOutputTokens = response.maxOutputTokens
            previousResponseId = response.previousResponseId
            reasoning = response.reasoning
            status = response.status
            text = response.text
            truncation = response.truncation
            usage = response.usage
            user = response.user
            additionalProperties = response.additionalProperties.toMutableMap()
        }

        /** Unique identifier for this Response. */
        fun id(id: String) = id(JsonField.of(id))

        /** Unique identifier for this Response. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Unix timestamp (in seconds) of when this Response was created. */
        fun createdAt(createdAt: Double) = createdAt(JsonField.of(createdAt))

        /** Unix timestamp (in seconds) of when this Response was created. */
        fun createdAt(createdAt: JsonField<Double>) = apply { this.createdAt = createdAt }

        /** An error object returned when the model fails to generate a Response. */
        fun error(error: ResponseError?) = error(JsonField.ofNullable(error))

        /** An error object returned when the model fails to generate a Response. */
        fun error(error: Optional<ResponseError>) = error(error.getOrNull())

        /** An error object returned when the model fails to generate a Response. */
        fun error(error: JsonField<ResponseError>) = apply { this.error = error }

        /** Details about why the response is incomplete. */
        fun incompleteDetails(incompleteDetails: IncompleteDetails?) =
            incompleteDetails(JsonField.ofNullable(incompleteDetails))

        /** Details about why the response is incomplete. */
        fun incompleteDetails(incompleteDetails: Optional<IncompleteDetails>) =
            incompleteDetails(incompleteDetails.getOrNull())

        /** Details about why the response is incomplete. */
        fun incompleteDetails(incompleteDetails: JsonField<IncompleteDetails>) = apply {
            this.incompleteDetails = incompleteDetails
        }

        /**
         * Inserts a system (or developer) message as the first item in the model's context.
         *
         * When using along with `previous_response_id`, the instructions from a previous response
         * will be not be carried over to the next response. This makes it simple to swap out system
         * (or developer) messages in new responses.
         */
        fun instructions(instructions: String?) = instructions(JsonField.ofNullable(instructions))

        /**
         * Inserts a system (or developer) message as the first item in the model's context.
         *
         * When using along with `previous_response_id`, the instructions from a previous response
         * will be not be carried over to the next response. This makes it simple to swap out system
         * (or developer) messages in new responses.
         */
        fun instructions(instructions: Optional<String>) = instructions(instructions.getOrNull())

        /**
         * Inserts a system (or developer) message as the first item in the model's context.
         *
         * When using along with `previous_response_id`, the instructions from a previous response
         * will be not be carried over to the next response. This makes it simple to swap out system
         * (or developer) messages in new responses.
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

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard.
         *
         * Keys are strings with a maximum length of 64 characters. Values are strings with a
         * maximum length of 512 characters.
         */
        fun metadata(metadata: Optional<Metadata>) = metadata(metadata.getOrNull())

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard.
         *
         * Keys are strings with a maximum length of 64 characters. Values are strings with a
         * maximum length of 512 characters.
         */
        fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

        /**
         * Model ID used to generate the response, like `gpt-4o` or `o1`. OpenAI offers a wide range
         * of models with different capabilities, performance characteristics, and price points.
         * Refer to the [model guide](https://platform.openai.com/docs/models) to browse and compare
         * available models.
         */
        fun model(model: ChatModel) = model(JsonField.of(model))

        /**
         * Model ID used to generate the response, like `gpt-4o` or `o1`. OpenAI offers a wide range
         * of models with different capabilities, performance characteristics, and price points.
         * Refer to the [model guide](https://platform.openai.com/docs/models) to browse and compare
         * available models.
         */
        fun model(model: JsonField<ChatModel>) = apply { this.model = model }

        /**
         * Model ID used to generate the response, like `gpt-4o` or `o1`. OpenAI offers a wide range
         * of models with different capabilities, performance characteristics, and price points.
         * Refer to the [model guide](https://platform.openai.com/docs/models) to browse and compare
         * available models.
         */
        fun model(value: String) = model(ChatModel.of(value))

        /** The object type of this resource - always set to `response`. */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /**
         * An array of content items generated by the model.
         * - The length and order of items in the `output` array is dependent on the model's
         *   response.
         * - Rather than accessing the first item in the `output` array and assuming it's an
         *   `assistant` message with the content generated by the model, you might consider using
         *   the `output_text` property where supported in SDKs.
         */
        fun output(output: List<ResponseOutputItem>) = output(JsonField.of(output))

        /**
         * An array of content items generated by the model.
         * - The length and order of items in the `output` array is dependent on the model's
         *   response.
         * - Rather than accessing the first item in the `output` array and assuming it's an
         *   `assistant` message with the content generated by the model, you might consider using
         *   the `output_text` property where supported in SDKs.
         */
        fun output(output: JsonField<List<ResponseOutputItem>>) = apply {
            this.output = output.map { it.toMutableList() }
        }

        /**
         * An array of content items generated by the model.
         * - The length and order of items in the `output` array is dependent on the model's
         *   response.
         * - Rather than accessing the first item in the `output` array and assuming it's an
         *   `assistant` message with the content generated by the model, you might consider using
         *   the `output_text` property where supported in SDKs.
         */
        fun addOutput(output: ResponseOutputItem) = apply {
            this.output =
                (this.output ?: JsonField.of(mutableListOf())).also {
                    checkKnown("output", it).add(output)
                }
        }

        /** An output message from the model. */
        fun addOutput(message: ResponseOutputMessage) =
            addOutput(ResponseOutputItem.ofMessage(message))

        /**
         * The results of a file search tool call. See the
         * [file search guide](https://platform.openai.com/docs/guides/tools-file-search) for more
         * information.
         */
        fun addOutput(fileSearchCall: ResponseFileSearchToolCall) =
            addOutput(ResponseOutputItem.ofFileSearchCall(fileSearchCall))

        /**
         * A tool call to run a function. See the
         * [function calling guide](https://platform.openai.com/docs/guides/function-calling) for
         * more information.
         */
        fun addOutput(functionCall: ResponseFunctionToolCall) =
            addOutput(ResponseOutputItem.ofFunctionCall(functionCall))

        /**
         * The results of a web search tool call. See the
         * [web search guide](https://platform.openai.com/docs/guides/tools-web-search) for more
         * information.
         */
        fun addOutput(webSearchCall: ResponseFunctionWebSearch) =
            addOutput(ResponseOutputItem.ofWebSearchCall(webSearchCall))

        /**
         * A tool call to a computer use tool. See the
         * [computer use guide](https://platform.openai.com/docs/guides/tools-computer-use) for more
         * information.
         */
        fun addOutput(computerCall: ResponseComputerToolCall) =
            addOutput(ResponseOutputItem.ofComputerCall(computerCall))

        /**
         * A description of the chain of thought used by a reasoning model while generating a
         * response.
         */
        fun addOutput(reasoning: ResponseReasoningItem) =
            addOutput(ResponseOutputItem.ofReasoning(reasoning))

        /** Whether to allow the model to run tool calls in parallel. */
        fun parallelToolCalls(parallelToolCalls: Boolean) =
            parallelToolCalls(JsonField.of(parallelToolCalls))

        /** Whether to allow the model to run tool calls in parallel. */
        fun parallelToolCalls(parallelToolCalls: JsonField<Boolean>) = apply {
            this.parallelToolCalls = parallelToolCalls
        }

        /**
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic. We generally recommend altering this or `top_p` but not both.
         */
        fun temperature(temperature: Double?) = temperature(JsonField.ofNullable(temperature))

        /**
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic. We generally recommend altering this or `top_p` but not both.
         */
        fun temperature(temperature: Double) = temperature(temperature as Double?)

        /**
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic. We generally recommend altering this or `top_p` but not both.
         */
        fun temperature(temperature: Optional<Double>) = temperature(temperature.getOrNull())

        /**
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic. We generally recommend altering this or `top_p` but not both.
         */
        fun temperature(temperature: JsonField<Double>) = apply { this.temperature = temperature }

        /**
         * How the model should select which tool (or tools) to use when generating a response. See
         * the `tools` parameter to see how to specify which tools the model can call.
         */
        fun toolChoice(toolChoice: ToolChoice) = toolChoice(JsonField.of(toolChoice))

        /**
         * How the model should select which tool (or tools) to use when generating a response. See
         * the `tools` parameter to see how to specify which tools the model can call.
         */
        fun toolChoice(toolChoice: JsonField<ToolChoice>) = apply { this.toolChoice = toolChoice }

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
        fun toolChoice(options: ToolChoiceOptions) = toolChoice(ToolChoice.ofOptions(options))

        /**
         * Indicates that the model should use a built-in tool to generate a response.
         * [Learn more about built-in tools](https://platform.openai.com/docs/guides/tools).
         */
        fun toolChoice(types: ToolChoiceTypes) = toolChoice(ToolChoice.ofTypes(types))

        /** Use this option to force the model to call a specific function. */
        fun toolChoice(function: ToolChoiceFunction) = toolChoice(ToolChoice.ofFunction(function))

        /**
         * An array of tools the model may call while generating a response. You can specify which
         * tool to use by setting the `tool_choice` parameter.
         *
         * The two categories of tools you can provide the model are:
         * - **Built-in tools**: Tools that are provided by OpenAI that extend the model's
         *   capabilities, like
         *   [web search](https://platform.openai.com/docs/guides/tools-web-search) or
         *   [file search](https://platform.openai.com/docs/guides/tools-file-search). Learn more
         *   about [built-in tools](https://platform.openai.com/docs/guides/tools).
         * - **Function calls (custom tools)**: Functions that are defined by you, enabling the
         *   model to call your own code. Learn more about
         *   [function calling](https://platform.openai.com/docs/guides/function-calling).
         */
        fun tools(tools: List<Tool>) = tools(JsonField.of(tools))

        /**
         * An array of tools the model may call while generating a response. You can specify which
         * tool to use by setting the `tool_choice` parameter.
         *
         * The two categories of tools you can provide the model are:
         * - **Built-in tools**: Tools that are provided by OpenAI that extend the model's
         *   capabilities, like
         *   [web search](https://platform.openai.com/docs/guides/tools-web-search) or
         *   [file search](https://platform.openai.com/docs/guides/tools-file-search). Learn more
         *   about [built-in tools](https://platform.openai.com/docs/guides/tools).
         * - **Function calls (custom tools)**: Functions that are defined by you, enabling the
         *   model to call your own code. Learn more about
         *   [function calling](https://platform.openai.com/docs/guides/function-calling).
         */
        fun tools(tools: JsonField<List<Tool>>) = apply {
            this.tools = tools.map { it.toMutableList() }
        }

        /**
         * An array of tools the model may call while generating a response. You can specify which
         * tool to use by setting the `tool_choice` parameter.
         *
         * The two categories of tools you can provide the model are:
         * - **Built-in tools**: Tools that are provided by OpenAI that extend the model's
         *   capabilities, like
         *   [web search](https://platform.openai.com/docs/guides/tools-web-search) or
         *   [file search](https://platform.openai.com/docs/guides/tools-file-search). Learn more
         *   about [built-in tools](https://platform.openai.com/docs/guides/tools).
         * - **Function calls (custom tools)**: Functions that are defined by you, enabling the
         *   model to call your own code. Learn more about
         *   [function calling](https://platform.openai.com/docs/guides/function-calling).
         */
        fun addTool(tool: Tool) = apply {
            tools =
                (tools ?: JsonField.of(mutableListOf())).also { checkKnown("tools", it).add(tool) }
        }

        /**
         * A tool that searches for relevant content from uploaded files. Learn more about the
         * [file search tool](https://platform.openai.com/docs/guides/tools-file-search).
         */
        fun addTool(fileSearch: FileSearchTool) = addTool(Tool.ofFileSearch(fileSearch))

        /**
         * A tool that searches for relevant content from uploaded files. Learn more about the
         * [file search tool](https://platform.openai.com/docs/guides/tools-file-search).
         */
        fun addFileSearchTool(vectorStoreIds: List<String>) =
            addTool(FileSearchTool.builder().vectorStoreIds(vectorStoreIds).build())

        /**
         * Defines a function in your own code the model can choose to call. Learn more about
         * [function calling](https://platform.openai.com/docs/guides/function-calling).
         */
        fun addTool(function: FunctionTool) = addTool(Tool.ofFunction(function))

        /**
         * A tool that controls a virtual computer. Learn more about the
         * [computer tool](https://platform.openai.com/docs/guides/tools-computer-use).
         */
        fun addTool(computerUsePreview: ComputerTool) =
            addTool(Tool.ofComputerUsePreview(computerUsePreview))

        /**
         * This tool searches the web for relevant results to use in a response. Learn more about
         * the [web search tool](https://platform.openai.com/docs/guides/tools-web-search).
         */
        fun addTool(webSearch: WebSearchTool) = addTool(Tool.ofWebSearch(webSearch))

        /**
         * An alternative to sampling with temperature, called nucleus sampling, where the model
         * considers the results of the tokens with top_p probability mass. So 0.1 means only the
         * tokens comprising the top 10% probability mass are considered.
         *
         * We generally recommend altering this or `temperature` but not both.
         */
        fun topP(topP: Double?) = topP(JsonField.ofNullable(topP))

        /**
         * An alternative to sampling with temperature, called nucleus sampling, where the model
         * considers the results of the tokens with top_p probability mass. So 0.1 means only the
         * tokens comprising the top 10% probability mass are considered.
         *
         * We generally recommend altering this or `temperature` but not both.
         */
        fun topP(topP: Double) = topP(topP as Double?)

        /**
         * An alternative to sampling with temperature, called nucleus sampling, where the model
         * considers the results of the tokens with top_p probability mass. So 0.1 means only the
         * tokens comprising the top 10% probability mass are considered.
         *
         * We generally recommend altering this or `temperature` but not both.
         */
        fun topP(topP: Optional<Double>) = topP(topP.getOrNull())

        /**
         * An alternative to sampling with temperature, called nucleus sampling, where the model
         * considers the results of the tokens with top_p probability mass. So 0.1 means only the
         * tokens comprising the top 10% probability mass are considered.
         *
         * We generally recommend altering this or `temperature` but not both.
         */
        fun topP(topP: JsonField<Double>) = apply { this.topP = topP }

        /**
         * An upper bound for the number of tokens that can be generated for a response, including
         * visible output tokens and
         * [reasoning tokens](https://platform.openai.com/docs/guides/reasoning).
         */
        fun maxOutputTokens(maxOutputTokens: Long?) =
            maxOutputTokens(JsonField.ofNullable(maxOutputTokens))

        /**
         * An upper bound for the number of tokens that can be generated for a response, including
         * visible output tokens and
         * [reasoning tokens](https://platform.openai.com/docs/guides/reasoning).
         */
        fun maxOutputTokens(maxOutputTokens: Long) = maxOutputTokens(maxOutputTokens as Long?)

        /**
         * An upper bound for the number of tokens that can be generated for a response, including
         * visible output tokens and
         * [reasoning tokens](https://platform.openai.com/docs/guides/reasoning).
         */
        fun maxOutputTokens(maxOutputTokens: Optional<Long>) =
            maxOutputTokens(maxOutputTokens.getOrNull())

        /**
         * An upper bound for the number of tokens that can be generated for a response, including
         * visible output tokens and
         * [reasoning tokens](https://platform.openai.com/docs/guides/reasoning).
         */
        fun maxOutputTokens(maxOutputTokens: JsonField<Long>) = apply {
            this.maxOutputTokens = maxOutputTokens
        }

        /**
         * The unique ID of the previous response to the model. Use this to create multi-turn
         * conversations. Learn more about
         * [conversation state](https://platform.openai.com/docs/guides/conversation-state).
         */
        fun previousResponseId(previousResponseId: String?) =
            previousResponseId(JsonField.ofNullable(previousResponseId))

        /**
         * The unique ID of the previous response to the model. Use this to create multi-turn
         * conversations. Learn more about
         * [conversation state](https://platform.openai.com/docs/guides/conversation-state).
         */
        fun previousResponseId(previousResponseId: Optional<String>) =
            previousResponseId(previousResponseId.getOrNull())

        /**
         * The unique ID of the previous response to the model. Use this to create multi-turn
         * conversations. Learn more about
         * [conversation state](https://platform.openai.com/docs/guides/conversation-state).
         */
        fun previousResponseId(previousResponseId: JsonField<String>) = apply {
            this.previousResponseId = previousResponseId
        }

        /**
         * **o-series models only**
         *
         * Configuration options for
         * [reasoning models](https://platform.openai.com/docs/guides/reasoning).
         */
        fun reasoning(reasoning: Reasoning?) = reasoning(JsonField.ofNullable(reasoning))

        /**
         * **o-series models only**
         *
         * Configuration options for
         * [reasoning models](https://platform.openai.com/docs/guides/reasoning).
         */
        fun reasoning(reasoning: Optional<Reasoning>) = reasoning(reasoning.getOrNull())

        /**
         * **o-series models only**
         *
         * Configuration options for
         * [reasoning models](https://platform.openai.com/docs/guides/reasoning).
         */
        fun reasoning(reasoning: JsonField<Reasoning>) = apply { this.reasoning = reasoning }

        /**
         * The status of the response generation. One of `completed`, `failed`, `in_progress`, or
         * `incomplete`.
         */
        fun status(status: ResponseStatus) = status(JsonField.of(status))

        /**
         * The status of the response generation. One of `completed`, `failed`, `in_progress`, or
         * `incomplete`.
         */
        fun status(status: JsonField<ResponseStatus>) = apply { this.status = status }

        /**
         * Configuration options for a text response from the model. Can be plain text or structured
         * JSON data. Learn more:
         * - [Text inputs and outputs](https://platform.openai.com/docs/guides/text)
         * - [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs)
         */
        fun text(text: ResponseTextConfig) = text(JsonField.of(text))

        /**
         * Configuration options for a text response from the model. Can be plain text or structured
         * JSON data. Learn more:
         * - [Text inputs and outputs](https://platform.openai.com/docs/guides/text)
         * - [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs)
         */
        fun text(text: JsonField<ResponseTextConfig>) = apply { this.text = text }

        /**
         * The truncation strategy to use for the model response.
         * - `auto`: If the context of this response and previous ones exceeds the model's context
         *   window size, the model will truncate the response to fit the context window by dropping
         *   input items in the middle of the conversation.
         * - `disabled` (default): If a model response will exceed the context window size for a
         *   model, the request will fail with a 400 error.
         */
        fun truncation(truncation: Truncation?) = truncation(JsonField.ofNullable(truncation))

        /**
         * The truncation strategy to use for the model response.
         * - `auto`: If the context of this response and previous ones exceeds the model's context
         *   window size, the model will truncate the response to fit the context window by dropping
         *   input items in the middle of the conversation.
         * - `disabled` (default): If a model response will exceed the context window size for a
         *   model, the request will fail with a 400 error.
         */
        fun truncation(truncation: Optional<Truncation>) = truncation(truncation.getOrNull())

        /**
         * The truncation strategy to use for the model response.
         * - `auto`: If the context of this response and previous ones exceeds the model's context
         *   window size, the model will truncate the response to fit the context window by dropping
         *   input items in the middle of the conversation.
         * - `disabled` (default): If a model response will exceed the context window size for a
         *   model, the request will fail with a 400 error.
         */
        fun truncation(truncation: JsonField<Truncation>) = apply { this.truncation = truncation }

        /**
         * Represents token usage details including input tokens, output tokens, a breakdown of
         * output tokens, and the total tokens used.
         */
        fun usage(usage: ResponseUsage) = usage(JsonField.of(usage))

        /**
         * Represents token usage details including input tokens, output tokens, a breakdown of
         * output tokens, and the total tokens used.
         */
        fun usage(usage: JsonField<ResponseUsage>) = apply { this.usage = usage }

        /**
         * A unique identifier representing your end-user, which can help OpenAI to monitor and
         * detect abuse.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
         */
        fun user(user: String) = user(JsonField.of(user))

        /**
         * A unique identifier representing your end-user, which can help OpenAI to monitor and
         * detect abuse.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
         */
        fun user(user: JsonField<String>) = apply { this.user = user }

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

        fun build(): Response =
            Response(
                checkRequired("id", id),
                checkRequired("createdAt", createdAt),
                checkRequired("error", error),
                checkRequired("incompleteDetails", incompleteDetails),
                checkRequired("instructions", instructions),
                checkRequired("metadata", metadata),
                checkRequired("model", model),
                object_,
                checkRequired("output", output).map { it.toImmutable() },
                checkRequired("parallelToolCalls", parallelToolCalls),
                checkRequired("temperature", temperature),
                checkRequired("toolChoice", toolChoice),
                checkRequired("tools", tools).map { it.toImmutable() },
                checkRequired("topP", topP),
                maxOutputTokens,
                previousResponseId,
                reasoning,
                status,
                text,
                truncation,
                usage,
                user,
                additionalProperties.toImmutable(),
            )
    }

    /** Details about why the response is incomplete. */
    @NoAutoDetect
    class IncompleteDetails
    @JsonCreator
    private constructor(
        @JsonProperty("reason")
        @ExcludeMissing
        private val reason: JsonField<Reason> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The reason why the response is incomplete. */
        fun reason(): Optional<Reason> = Optional.ofNullable(reason.getNullable("reason"))

        /** The reason why the response is incomplete. */
        @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<Reason> = reason

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): IncompleteDetails = apply {
            if (validated) {
                return@apply
            }

            reason()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [IncompleteDetails]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [IncompleteDetails]. */
        class Builder internal constructor() {

            private var reason: JsonField<Reason> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(incompleteDetails: IncompleteDetails) = apply {
                reason = incompleteDetails.reason
                additionalProperties = incompleteDetails.additionalProperties.toMutableMap()
            }

            /** The reason why the response is incomplete. */
            fun reason(reason: Reason) = reason(JsonField.of(reason))

            /** The reason why the response is incomplete. */
            fun reason(reason: JsonField<Reason>) = apply { this.reason = reason }

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

            fun build(): IncompleteDetails =
                IncompleteDetails(reason, additionalProperties.toImmutable())
        }

        /** The reason why the response is incomplete. */
        class Reason @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val MAX_OUTPUT_TOKENS = of("max_output_tokens")

                @JvmField val CONTENT_FILTER = of("content_filter")

                @JvmStatic fun of(value: String) = Reason(JsonField.of(value))
            }

            /** An enum containing [Reason]'s known values. */
            enum class Known {
                MAX_OUTPUT_TOKENS,
                CONTENT_FILTER,
            }

            /**
             * An enum containing [Reason]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Reason] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                MAX_OUTPUT_TOKENS,
                CONTENT_FILTER,
                /**
                 * An enum member indicating that [Reason] was instantiated with an unknown value.
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
                    MAX_OUTPUT_TOKENS -> Value.MAX_OUTPUT_TOKENS
                    CONTENT_FILTER -> Value.CONTENT_FILTER
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
                    MAX_OUTPUT_TOKENS -> Known.MAX_OUTPUT_TOKENS
                    CONTENT_FILTER -> Known.CONTENT_FILTER
                    else -> throw OpenAIInvalidDataException("Unknown Reason: $value")
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

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Reason && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is IncompleteDetails && reason == other.reason && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(reason, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "IncompleteDetails{reason=$reason, additionalProperties=$additionalProperties}"
    }

    /**
     * How the model should select which tool (or tools) to use when generating a response. See the
     * `tools` parameter to see how to specify which tools the model can call.
     */
    @JsonDeserialize(using = ToolChoice.Deserializer::class)
    @JsonSerialize(using = ToolChoice.Serializer::class)
    class ToolChoice
    private constructor(
        private val options: ToolChoiceOptions? = null,
        private val types: ToolChoiceTypes? = null,
        private val function: ToolChoiceFunction? = null,
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

        /**
         * Indicates that the model should use a built-in tool to generate a response.
         * [Learn more about built-in tools](https://platform.openai.com/docs/guides/tools).
         */
        fun types(): Optional<ToolChoiceTypes> = Optional.ofNullable(types)

        /** Use this option to force the model to call a specific function. */
        fun function(): Optional<ToolChoiceFunction> = Optional.ofNullable(function)

        fun isOptions(): Boolean = options != null

        fun isTypes(): Boolean = types != null

        fun isFunction(): Boolean = function != null

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

        /**
         * Indicates that the model should use a built-in tool to generate a response.
         * [Learn more about built-in tools](https://platform.openai.com/docs/guides/tools).
         */
        fun asTypes(): ToolChoiceTypes = types.getOrThrow("types")

        /** Use this option to force the model to call a specific function. */
        fun asFunction(): ToolChoiceFunction = function.getOrThrow("function")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                options != null -> visitor.visitOptions(options)
                types != null -> visitor.visitTypes(types)
                function != null -> visitor.visitFunction(function)
                else -> visitor.unknown(_json)
            }
        }

        private var validated: Boolean = false

        fun validate(): ToolChoice = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitOptions(options: ToolChoiceOptions) {}

                    override fun visitTypes(types: ToolChoiceTypes) {
                        types.validate()
                    }

                    override fun visitFunction(function: ToolChoiceFunction) {
                        function.validate()
                    }
                }
            )
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ToolChoice && options == other.options && types == other.types && function == other.function /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(options, types, function) /* spotless:on */

        override fun toString(): String =
            when {
                options != null -> "ToolChoice{options=$options}"
                types != null -> "ToolChoice{types=$types}"
                function != null -> "ToolChoice{function=$function}"
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

            /**
             * Indicates that the model should use a built-in tool to generate a response.
             * [Learn more about built-in tools](https://platform.openai.com/docs/guides/tools).
             */
            @JvmStatic fun ofTypes(types: ToolChoiceTypes) = ToolChoice(types = types)

            /** Use this option to force the model to call a specific function. */
            @JvmStatic
            fun ofFunction(function: ToolChoiceFunction) = ToolChoice(function = function)
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

            /**
             * Indicates that the model should use a built-in tool to generate a response.
             * [Learn more about built-in tools](https://platform.openai.com/docs/guides/tools).
             */
            fun visitTypes(types: ToolChoiceTypes): T

            /** Use this option to force the model to call a specific function. */
            fun visitFunction(function: ToolChoiceFunction): T

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

                tryDeserialize(node, jacksonTypeRef<ToolChoiceOptions>())?.let {
                    return ToolChoice(options = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<ToolChoiceTypes>()) { it.validate() }
                    ?.let {
                        return ToolChoice(types = it, _json = json)
                    }
                tryDeserialize(node, jacksonTypeRef<ToolChoiceFunction>()) { it.validate() }
                    ?.let {
                        return ToolChoice(function = it, _json = json)
                    }

                return ToolChoice(_json = json)
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
                    value.types != null -> generator.writeObject(value.types)
                    value.function != null -> generator.writeObject(value.function)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid ToolChoice")
                }
            }
        }
    }

    /**
     * The truncation strategy to use for the model response.
     * - `auto`: If the context of this response and previous ones exceeds the model's context
     *   window size, the model will truncate the response to fit the context window by dropping
     *   input items in the middle of the conversation.
     * - `disabled` (default): If a model response will exceed the context window size for a model,
     *   the request will fail with a 400 error.
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Truncation && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is Response && id == other.id && createdAt == other.createdAt && error == other.error && incompleteDetails == other.incompleteDetails && instructions == other.instructions && metadata == other.metadata && model == other.model && object_ == other.object_ && output == other.output && parallelToolCalls == other.parallelToolCalls && temperature == other.temperature && toolChoice == other.toolChoice && tools == other.tools && topP == other.topP && maxOutputTokens == other.maxOutputTokens && previousResponseId == other.previousResponseId && reasoning == other.reasoning && status == other.status && text == other.text && truncation == other.truncation && usage == other.usage && user == other.user && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, createdAt, error, incompleteDetails, instructions, metadata, model, object_, output, parallelToolCalls, temperature, toolChoice, tools, topP, maxOutputTokens, previousResponseId, reasoning, status, text, truncation, usage, user, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Response{id=$id, createdAt=$createdAt, error=$error, incompleteDetails=$incompleteDetails, instructions=$instructions, metadata=$metadata, model=$model, object_=$object_, output=$output, parallelToolCalls=$parallelToolCalls, temperature=$temperature, toolChoice=$toolChoice, tools=$tools, topP=$topP, maxOutputTokens=$maxOutputTokens, previousResponseId=$previousResponseId, reasoning=$reasoning, status=$status, text=$text, truncation=$truncation, usage=$usage, user=$user, additionalProperties=$additionalProperties}"
}
