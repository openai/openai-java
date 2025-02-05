// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.Params
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/** Create an assistant with a model and instructions. */
class BetaAssistantCreateParams
private constructor(
    private val body: BetaAssistantCreateBody,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * ID of the model to use. You can use the
     * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all of
     * your available models, or see our [Model overview](https://platform.openai.com/docs/models)
     * for descriptions of them.
     */
    fun model(): ChatModel = body.model()

    /** The description of the assistant. The maximum length is 512 characters. */
    fun description(): Optional<String> = body.description()

    /**
     * The system instructions that the assistant uses. The maximum length is 256,000 characters.
     */
    fun instructions(): Optional<String> = body.instructions()

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format, and querying for objects via
     * API or the dashboard.
     *
     * Keys are strings with a maximum length of 64 characters. Values are strings with a maximum
     * length of 512 characters.
     */
    fun metadata(): Optional<Metadata> = body.metadata()

    /** The name of the assistant. The maximum length is 256 characters. */
    fun name(): Optional<String> = body.name()

    /**
     * **o1 and o3-mini models only**
     *
     * Constrains effort on reasoning for
     * [reasoning models](https://platform.openai.com/docs/guides/reasoning). Currently supported
     * values are `low`, `medium`, and `high`. Reducing reasoning effort can result in faster
     * responses and fewer tokens used on reasoning in a response.
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
     */
    fun responseFormat(): Optional<AssistantResponseFormatOption> = body.responseFormat()

    /**
     * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
     * output more random, while lower values like 0.2 will make it more focused and deterministic.
     */
    fun temperature(): Optional<Double> = body.temperature()

    /**
     * A set of resources that are used by the assistant's tools. The resources are specific to the
     * type of tool. For example, the `code_interpreter` tool requires a list of file IDs, while the
     * `file_search` tool requires a list of vector store IDs.
     */
    fun toolResources(): Optional<ToolResources> = body.toolResources()

    /**
     * A list of tool enabled on the assistant. There can be a maximum of 128 tools per assistant.
     * Tools can be of types `code_interpreter`, `file_search`, or `function`.
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
     * ID of the model to use. You can use the
     * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all of
     * your available models, or see our [Model overview](https://platform.openai.com/docs/models)
     * for descriptions of them.
     */
    fun _model(): JsonField<ChatModel> = body._model()

    /** The description of the assistant. The maximum length is 512 characters. */
    fun _description(): JsonField<String> = body._description()

    /**
     * The system instructions that the assistant uses. The maximum length is 256,000 characters.
     */
    fun _instructions(): JsonField<String> = body._instructions()

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format, and querying for objects via
     * API or the dashboard.
     *
     * Keys are strings with a maximum length of 64 characters. Values are strings with a maximum
     * length of 512 characters.
     */
    fun _metadata(): JsonField<Metadata> = body._metadata()

    /** The name of the assistant. The maximum length is 256 characters. */
    fun _name(): JsonField<String> = body._name()

    /**
     * **o1 and o3-mini models only**
     *
     * Constrains effort on reasoning for
     * [reasoning models](https://platform.openai.com/docs/guides/reasoning). Currently supported
     * values are `low`, `medium`, and `high`. Reducing reasoning effort can result in faster
     * responses and fewer tokens used on reasoning in a response.
     */
    fun _reasoningEffort(): JsonField<ReasoningEffort> = body._reasoningEffort()

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
     * A set of resources that are used by the assistant's tools. The resources are specific to the
     * type of tool. For example, the `code_interpreter` tool requires a list of file IDs, while the
     * `file_search` tool requires a list of vector store IDs.
     */
    fun _toolResources(): JsonField<ToolResources> = body._toolResources()

    /**
     * A list of tool enabled on the assistant. There can be a maximum of 128 tools per assistant.
     * Tools can be of types `code_interpreter`, `file_search`, or `function`.
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

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic internal fun _body(): BetaAssistantCreateBody = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    @NoAutoDetect
    class BetaAssistantCreateBody
    @JsonCreator
    internal constructor(
        @JsonProperty("model")
        @ExcludeMissing
        private val model: JsonField<ChatModel> = JsonMissing.of(),
        @JsonProperty("description")
        @ExcludeMissing
        private val description: JsonField<String> = JsonMissing.of(),
        @JsonProperty("instructions")
        @ExcludeMissing
        private val instructions: JsonField<String> = JsonMissing.of(),
        @JsonProperty("metadata")
        @ExcludeMissing
        private val metadata: JsonField<Metadata> = JsonMissing.of(),
        @JsonProperty("name")
        @ExcludeMissing
        private val name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("reasoning_effort")
        @ExcludeMissing
        private val reasoningEffort: JsonField<ReasoningEffort> = JsonMissing.of(),
        @JsonProperty("response_format")
        @ExcludeMissing
        private val responseFormat: JsonField<AssistantResponseFormatOption> = JsonMissing.of(),
        @JsonProperty("temperature")
        @ExcludeMissing
        private val temperature: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("tool_resources")
        @ExcludeMissing
        private val toolResources: JsonField<ToolResources> = JsonMissing.of(),
        @JsonProperty("tools")
        @ExcludeMissing
        private val tools: JsonField<List<AssistantTool>> = JsonMissing.of(),
        @JsonProperty("top_p")
        @ExcludeMissing
        private val topP: JsonField<Double> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * ID of the model to use. You can use the
         * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all
         * of your available models, or see our
         * [Model overview](https://platform.openai.com/docs/models) for descriptions of them.
         */
        fun model(): ChatModel = model.getRequired("model")

        /** The description of the assistant. The maximum length is 512 characters. */
        fun description(): Optional<String> =
            Optional.ofNullable(description.getNullable("description"))

        /**
         * The system instructions that the assistant uses. The maximum length is 256,000
         * characters.
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
         */
        fun metadata(): Optional<Metadata> = Optional.ofNullable(metadata.getNullable("metadata"))

        /** The name of the assistant. The maximum length is 256 characters. */
        fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

        /**
         * **o1 and o3-mini models only**
         *
         * Constrains effort on reasoning for
         * [reasoning models](https://platform.openai.com/docs/guides/reasoning). Currently
         * supported values are `low`, `medium`, and `high`. Reducing reasoning effort can result in
         * faster responses and fewer tokens used on reasoning in a response.
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
         * A set of resources that are used by the assistant's tools. The resources are specific to
         * the type of tool. For example, the `code_interpreter` tool requires a list of file IDs,
         * while the `file_search` tool requires a list of vector store IDs.
         */
        fun toolResources(): Optional<ToolResources> =
            Optional.ofNullable(toolResources.getNullable("tool_resources"))

        /**
         * A list of tool enabled on the assistant. There can be a maximum of 128 tools per
         * assistant. Tools can be of types `code_interpreter`, `file_search`, or `function`.
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
         * ID of the model to use. You can use the
         * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all
         * of your available models, or see our
         * [Model overview](https://platform.openai.com/docs/models) for descriptions of them.
         */
        @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<ChatModel> = model

        /** The description of the assistant. The maximum length is 512 characters. */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

        /**
         * The system instructions that the assistant uses. The maximum length is 256,000
         * characters.
         */
        @JsonProperty("instructions")
        @ExcludeMissing
        fun _instructions(): JsonField<String> = instructions

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard.
         *
         * Keys are strings with a maximum length of 64 characters. Values are strings with a
         * maximum length of 512 characters.
         */
        @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonField<Metadata> = metadata

        /** The name of the assistant. The maximum length is 256 characters. */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * **o1 and o3-mini models only**
         *
         * Constrains effort on reasoning for
         * [reasoning models](https://platform.openai.com/docs/guides/reasoning). Currently
         * supported values are `low`, `medium`, and `high`. Reducing reasoning effort can result in
         * faster responses and fewer tokens used on reasoning in a response.
         */
        @JsonProperty("reasoning_effort")
        @ExcludeMissing
        fun _reasoningEffort(): JsonField<ReasoningEffort> = reasoningEffort

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
         * A set of resources that are used by the assistant's tools. The resources are specific to
         * the type of tool. For example, the `code_interpreter` tool requires a list of file IDs,
         * while the `file_search` tool requires a list of vector store IDs.
         */
        @JsonProperty("tool_resources")
        @ExcludeMissing
        fun _toolResources(): JsonField<ToolResources> = toolResources

        /**
         * A list of tool enabled on the assistant. There can be a maximum of 128 tools per
         * assistant. Tools can be of types `code_interpreter`, `file_search`, or `function`.
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

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): BetaAssistantCreateBody = apply {
            if (validated) {
                return@apply
            }

            model()
            description()
            instructions()
            metadata().ifPresent { it.validate() }
            name()
            reasoningEffort()
            responseFormat().ifPresent { it.validate() }
            temperature()
            toolResources().ifPresent { it.validate() }
            tools().ifPresent { it.forEach { it.validate() } }
            topP()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [BetaAssistantCreateBody]. */
        class Builder internal constructor() {

            private var model: JsonField<ChatModel>? = null
            private var description: JsonField<String> = JsonMissing.of()
            private var instructions: JsonField<String> = JsonMissing.of()
            private var metadata: JsonField<Metadata> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var reasoningEffort: JsonField<ReasoningEffort> = JsonMissing.of()
            private var responseFormat: JsonField<AssistantResponseFormatOption> = JsonMissing.of()
            private var temperature: JsonField<Double> = JsonMissing.of()
            private var toolResources: JsonField<ToolResources> = JsonMissing.of()
            private var tools: JsonField<MutableList<AssistantTool>>? = null
            private var topP: JsonField<Double> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(betaAssistantCreateBody: BetaAssistantCreateBody) = apply {
                model = betaAssistantCreateBody.model
                description = betaAssistantCreateBody.description
                instructions = betaAssistantCreateBody.instructions
                metadata = betaAssistantCreateBody.metadata
                name = betaAssistantCreateBody.name
                reasoningEffort = betaAssistantCreateBody.reasoningEffort
                responseFormat = betaAssistantCreateBody.responseFormat
                temperature = betaAssistantCreateBody.temperature
                toolResources = betaAssistantCreateBody.toolResources
                tools = betaAssistantCreateBody.tools.map { it.toMutableList() }
                topP = betaAssistantCreateBody.topP
                additionalProperties = betaAssistantCreateBody.additionalProperties.toMutableMap()
            }

            /**
             * ID of the model to use. You can use the
             * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see
             * all of your available models, or see our
             * [Model overview](https://platform.openai.com/docs/models) for descriptions of them.
             */
            fun model(model: ChatModel) = model(JsonField.of(model))

            /**
             * ID of the model to use. You can use the
             * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see
             * all of your available models, or see our
             * [Model overview](https://platform.openai.com/docs/models) for descriptions of them.
             */
            fun model(model: JsonField<ChatModel>) = apply { this.model = model }

            /**
             * ID of the model to use. You can use the
             * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see
             * all of your available models, or see our
             * [Model overview](https://platform.openai.com/docs/models) for descriptions of them.
             */
            fun model(value: String) = model(ChatModel.of(value))

            /** The description of the assistant. The maximum length is 512 characters. */
            fun description(description: String?) = description(JsonField.ofNullable(description))

            /** The description of the assistant. The maximum length is 512 characters. */
            fun description(description: Optional<String>) = description(description.orElse(null))

            /** The description of the assistant. The maximum length is 512 characters. */
            fun description(description: JsonField<String>) = apply {
                this.description = description
            }

            /**
             * The system instructions that the assistant uses. The maximum length is 256,000
             * characters.
             */
            fun instructions(instructions: String?) =
                instructions(JsonField.ofNullable(instructions))

            /**
             * The system instructions that the assistant uses. The maximum length is 256,000
             * characters.
             */
            fun instructions(instructions: Optional<String>) =
                instructions(instructions.orElse(null))

            /**
             * The system instructions that the assistant uses. The maximum length is 256,000
             * characters.
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

            /**
             * Set of 16 key-value pairs that can be attached to an object. This can be useful for
             * storing additional information about the object in a structured format, and querying
             * for objects via API or the dashboard.
             *
             * Keys are strings with a maximum length of 64 characters. Values are strings with a
             * maximum length of 512 characters.
             */
            fun metadata(metadata: Optional<Metadata>) = metadata(metadata.orElse(null))

            /**
             * Set of 16 key-value pairs that can be attached to an object. This can be useful for
             * storing additional information about the object in a structured format, and querying
             * for objects via API or the dashboard.
             *
             * Keys are strings with a maximum length of 64 characters. Values are strings with a
             * maximum length of 512 characters.
             */
            fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

            /** The name of the assistant. The maximum length is 256 characters. */
            fun name(name: String?) = name(JsonField.ofNullable(name))

            /** The name of the assistant. The maximum length is 256 characters. */
            fun name(name: Optional<String>) = name(name.orElse(null))

            /** The name of the assistant. The maximum length is 256 characters. */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /**
             * **o1 and o3-mini models only**
             *
             * Constrains effort on reasoning for
             * [reasoning models](https://platform.openai.com/docs/guides/reasoning). Currently
             * supported values are `low`, `medium`, and `high`. Reducing reasoning effort can
             * result in faster responses and fewer tokens used on reasoning in a response.
             */
            fun reasoningEffort(reasoningEffort: ReasoningEffort?) =
                reasoningEffort(JsonField.ofNullable(reasoningEffort))

            /**
             * **o1 and o3-mini models only**
             *
             * Constrains effort on reasoning for
             * [reasoning models](https://platform.openai.com/docs/guides/reasoning). Currently
             * supported values are `low`, `medium`, and `high`. Reducing reasoning effort can
             * result in faster responses and fewer tokens used on reasoning in a response.
             */
            fun reasoningEffort(reasoningEffort: Optional<ReasoningEffort>) =
                reasoningEffort(reasoningEffort.orElse(null))

            /**
             * **o1 and o3-mini models only**
             *
             * Constrains effort on reasoning for
             * [reasoning models](https://platform.openai.com/docs/guides/reasoning). Currently
             * supported values are `low`, `medium`, and `high`. Reducing reasoning effort can
             * result in faster responses and fewer tokens used on reasoning in a response.
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
             * A set of resources that are used by the assistant's tools. The resources are specific
             * to the type of tool. For example, the `code_interpreter` tool requires a list of file
             * IDs, while the `file_search` tool requires a list of vector store IDs.
             */
            fun toolResources(toolResources: ToolResources?) =
                toolResources(JsonField.ofNullable(toolResources))

            /**
             * A set of resources that are used by the assistant's tools. The resources are specific
             * to the type of tool. For example, the `code_interpreter` tool requires a list of file
             * IDs, while the `file_search` tool requires a list of vector store IDs.
             */
            fun toolResources(toolResources: Optional<ToolResources>) =
                toolResources(toolResources.orElse(null))

            /**
             * A set of resources that are used by the assistant's tools. The resources are specific
             * to the type of tool. For example, the `code_interpreter` tool requires a list of file
             * IDs, while the `file_search` tool requires a list of vector store IDs.
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
             * A list of tool enabled on the assistant. There can be a maximum of 128 tools per
             * assistant. Tools can be of types `code_interpreter`, `file_search`, or `function`.
             */
            fun tools(tools: JsonField<List<AssistantTool>>) = apply {
                this.tools = tools.map { it.toMutableList() }
            }

            /**
             * A list of tool enabled on the assistant. There can be a maximum of 128 tools per
             * assistant. Tools can be of types `code_interpreter`, `file_search`, or `function`.
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
             * A list of tool enabled on the assistant. There can be a maximum of 128 tools per
             * assistant. Tools can be of types `code_interpreter`, `file_search`, or `function`.
             */
            fun addTool(codeInterpreter: CodeInterpreterTool) =
                addTool(AssistantTool.ofCodeInterpreter(codeInterpreter))

            /**
             * A list of tool enabled on the assistant. There can be a maximum of 128 tools per
             * assistant. Tools can be of types `code_interpreter`, `file_search`, or `function`.
             */
            fun addTool(fileSearch: FileSearchTool) =
                addTool(AssistantTool.ofFileSearch(fileSearch))

            /**
             * A list of tool enabled on the assistant. There can be a maximum of 128 tools per
             * assistant. Tools can be of types `code_interpreter`, `file_search`, or `function`.
             */
            fun addTool(function: FunctionTool) = addTool(AssistantTool.ofFunction(function))

            /**
             * A list of tool enabled on the assistant. There can be a maximum of 128 tools per
             * assistant. Tools can be of types `code_interpreter`, `file_search`, or `function`.
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

            fun build(): BetaAssistantCreateBody =
                BetaAssistantCreateBody(
                    checkRequired("model", model),
                    description,
                    instructions,
                    metadata,
                    name,
                    reasoningEffort,
                    responseFormat,
                    temperature,
                    toolResources,
                    (tools ?: JsonMissing.of()).map { it.toImmutable() },
                    topP,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is BetaAssistantCreateBody && model == other.model && description == other.description && instructions == other.instructions && metadata == other.metadata && name == other.name && reasoningEffort == other.reasoningEffort && responseFormat == other.responseFormat && temperature == other.temperature && toolResources == other.toolResources && tools == other.tools && topP == other.topP && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(model, description, instructions, metadata, name, reasoningEffort, responseFormat, temperature, toolResources, tools, topP, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "BetaAssistantCreateBody{model=$model, description=$description, instructions=$instructions, metadata=$metadata, name=$name, reasoningEffort=$reasoningEffort, responseFormat=$responseFormat, temperature=$temperature, toolResources=$toolResources, tools=$tools, topP=$topP, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BetaAssistantCreateParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

        private var body: BetaAssistantCreateBody.Builder = BetaAssistantCreateBody.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(betaAssistantCreateParams: BetaAssistantCreateParams) = apply {
            body = betaAssistantCreateParams.body.toBuilder()
            additionalHeaders = betaAssistantCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = betaAssistantCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * ID of the model to use. You can use the
         * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all
         * of your available models, or see our
         * [Model overview](https://platform.openai.com/docs/models) for descriptions of them.
         */
        fun model(model: ChatModel) = apply { body.model(model) }

        /**
         * ID of the model to use. You can use the
         * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all
         * of your available models, or see our
         * [Model overview](https://platform.openai.com/docs/models) for descriptions of them.
         */
        fun model(model: JsonField<ChatModel>) = apply { body.model(model) }

        /**
         * ID of the model to use. You can use the
         * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all
         * of your available models, or see our
         * [Model overview](https://platform.openai.com/docs/models) for descriptions of them.
         */
        fun model(value: String) = apply { body.model(value) }

        /** The description of the assistant. The maximum length is 512 characters. */
        fun description(description: String?) = apply { body.description(description) }

        /** The description of the assistant. The maximum length is 512 characters. */
        fun description(description: Optional<String>) = description(description.orElse(null))

        /** The description of the assistant. The maximum length is 512 characters. */
        fun description(description: JsonField<String>) = apply { body.description(description) }

        /**
         * The system instructions that the assistant uses. The maximum length is 256,000
         * characters.
         */
        fun instructions(instructions: String?) = apply { body.instructions(instructions) }

        /**
         * The system instructions that the assistant uses. The maximum length is 256,000
         * characters.
         */
        fun instructions(instructions: Optional<String>) = instructions(instructions.orElse(null))

        /**
         * The system instructions that the assistant uses. The maximum length is 256,000
         * characters.
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

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard.
         *
         * Keys are strings with a maximum length of 64 characters. Values are strings with a
         * maximum length of 512 characters.
         */
        fun metadata(metadata: Optional<Metadata>) = metadata(metadata.orElse(null))

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard.
         *
         * Keys are strings with a maximum length of 64 characters. Values are strings with a
         * maximum length of 512 characters.
         */
        fun metadata(metadata: JsonField<Metadata>) = apply { body.metadata(metadata) }

        /** The name of the assistant. The maximum length is 256 characters. */
        fun name(name: String?) = apply { body.name(name) }

        /** The name of the assistant. The maximum length is 256 characters. */
        fun name(name: Optional<String>) = name(name.orElse(null))

        /** The name of the assistant. The maximum length is 256 characters. */
        fun name(name: JsonField<String>) = apply { body.name(name) }

        /**
         * **o1 and o3-mini models only**
         *
         * Constrains effort on reasoning for
         * [reasoning models](https://platform.openai.com/docs/guides/reasoning). Currently
         * supported values are `low`, `medium`, and `high`. Reducing reasoning effort can result in
         * faster responses and fewer tokens used on reasoning in a response.
         */
        fun reasoningEffort(reasoningEffort: ReasoningEffort?) = apply {
            body.reasoningEffort(reasoningEffort)
        }

        /**
         * **o1 and o3-mini models only**
         *
         * Constrains effort on reasoning for
         * [reasoning models](https://platform.openai.com/docs/guides/reasoning). Currently
         * supported values are `low`, `medium`, and `high`. Reducing reasoning effort can result in
         * faster responses and fewer tokens used on reasoning in a response.
         */
        fun reasoningEffort(reasoningEffort: Optional<ReasoningEffort>) =
            reasoningEffort(reasoningEffort.orElse(null))

        /**
         * **o1 and o3-mini models only**
         *
         * Constrains effort on reasoning for
         * [reasoning models](https://platform.openai.com/docs/guides/reasoning). Currently
         * supported values are `low`, `medium`, and `high`. Reducing reasoning effort can result in
         * faster responses and fewer tokens used on reasoning in a response.
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
         * A set of resources that are used by the assistant's tools. The resources are specific to
         * the type of tool. For example, the `code_interpreter` tool requires a list of file IDs,
         * while the `file_search` tool requires a list of vector store IDs.
         */
        fun toolResources(toolResources: ToolResources?) = apply {
            body.toolResources(toolResources)
        }

        /**
         * A set of resources that are used by the assistant's tools. The resources are specific to
         * the type of tool. For example, the `code_interpreter` tool requires a list of file IDs,
         * while the `file_search` tool requires a list of vector store IDs.
         */
        fun toolResources(toolResources: Optional<ToolResources>) =
            toolResources(toolResources.orElse(null))

        /**
         * A set of resources that are used by the assistant's tools. The resources are specific to
         * the type of tool. For example, the `code_interpreter` tool requires a list of file IDs,
         * while the `file_search` tool requires a list of vector store IDs.
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
         * A list of tool enabled on the assistant. There can be a maximum of 128 tools per
         * assistant. Tools can be of types `code_interpreter`, `file_search`, or `function`.
         */
        fun tools(tools: JsonField<List<AssistantTool>>) = apply { body.tools(tools) }

        /**
         * A list of tool enabled on the assistant. There can be a maximum of 128 tools per
         * assistant. Tools can be of types `code_interpreter`, `file_search`, or `function`.
         */
        fun addTool(tool: AssistantTool) = apply { body.addTool(tool) }

        /**
         * A list of tool enabled on the assistant. There can be a maximum of 128 tools per
         * assistant. Tools can be of types `code_interpreter`, `file_search`, or `function`.
         */
        fun addTool(codeInterpreter: CodeInterpreterTool) = apply { body.addTool(codeInterpreter) }

        /**
         * A list of tool enabled on the assistant. There can be a maximum of 128 tools per
         * assistant. Tools can be of types `code_interpreter`, `file_search`, or `function`.
         */
        fun addTool(fileSearch: FileSearchTool) = apply { body.addTool(fileSearch) }

        /**
         * A list of tool enabled on the assistant. There can be a maximum of 128 tools per
         * assistant. Tools can be of types `code_interpreter`, `file_search`, or `function`.
         */
        fun addTool(function: FunctionTool) = apply { body.addTool(function) }

        /**
         * A list of tool enabled on the assistant. There can be a maximum of 128 tools per
         * assistant. Tools can be of types `code_interpreter`, `file_search`, or `function`.
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

        fun build(): BetaAssistantCreateParams =
            BetaAssistantCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    /**
     * **o1 and o3-mini models only**
     *
     * Constrains effort on reasoning for
     * [reasoning models](https://platform.openai.com/docs/guides/reasoning). Currently supported
     * values are `low`, `medium`, and `high`. Reducing reasoning effort can result in faster
     * responses and fewer tokens used on reasoning in a response.
     */
    class ReasoningEffort
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

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

            @JvmField val LOW = of("low")

            @JvmField val MEDIUM = of("medium")

            @JvmField val HIGH = of("high")

            @JvmStatic fun of(value: String) = ReasoningEffort(JsonField.of(value))
        }

        /** An enum containing [ReasoningEffort]'s known values. */
        enum class Known {
            LOW,
            MEDIUM,
            HIGH,
        }

        /**
         * An enum containing [ReasoningEffort]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [ReasoningEffort] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            LOW,
            MEDIUM,
            HIGH,
            /**
             * An enum member indicating that [ReasoningEffort] was instantiated with an unknown
             * value.
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
                LOW -> Value.LOW
                MEDIUM -> Value.MEDIUM
                HIGH -> Value.HIGH
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
                LOW -> Known.LOW
                MEDIUM -> Known.MEDIUM
                HIGH -> Known.HIGH
                else -> throw OpenAIInvalidDataException("Unknown ReasoningEffort: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ReasoningEffort && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * A set of resources that are used by the assistant's tools. The resources are specific to the
     * type of tool. For example, the `code_interpreter` tool requires a list of file IDs, while the
     * `file_search` tool requires a list of vector store IDs.
     */
    @NoAutoDetect
    class ToolResources
    @JsonCreator
    private constructor(
        @JsonProperty("code_interpreter")
        @ExcludeMissing
        private val codeInterpreter: JsonField<CodeInterpreter> = JsonMissing.of(),
        @JsonProperty("file_search")
        @ExcludeMissing
        private val fileSearch: JsonField<FileSearch> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun codeInterpreter(): Optional<CodeInterpreter> =
            Optional.ofNullable(codeInterpreter.getNullable("code_interpreter"))

        fun fileSearch(): Optional<FileSearch> =
            Optional.ofNullable(fileSearch.getNullable("file_search"))

        @JsonProperty("code_interpreter")
        @ExcludeMissing
        fun _codeInterpreter(): JsonField<CodeInterpreter> = codeInterpreter

        @JsonProperty("file_search")
        @ExcludeMissing
        fun _fileSearch(): JsonField<FileSearch> = fileSearch

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ToolResources = apply {
            if (validated) {
                return@apply
            }

            codeInterpreter().ifPresent { it.validate() }
            fileSearch().ifPresent { it.validate() }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

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

            fun codeInterpreter(codeInterpreter: JsonField<CodeInterpreter>) = apply {
                this.codeInterpreter = codeInterpreter
            }

            fun fileSearch(fileSearch: FileSearch) = fileSearch(JsonField.of(fileSearch))

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

            fun build(): ToolResources =
                ToolResources(
                    codeInterpreter,
                    fileSearch,
                    additionalProperties.toImmutable(),
                )
        }

        @NoAutoDetect
        class CodeInterpreter
        @JsonCreator
        private constructor(
            @JsonProperty("file_ids")
            @ExcludeMissing
            private val fileIds: JsonField<List<String>> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /**
             * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs made
             * available to the `code_interpreter` tool. There can be a maximum of 20 files
             * associated with the tool.
             */
            fun fileIds(): Optional<List<String>> =
                Optional.ofNullable(fileIds.getNullable("file_ids"))

            /**
             * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs made
             * available to the `code_interpreter` tool. There can be a maximum of 20 files
             * associated with the tool.
             */
            @JsonProperty("file_ids")
            @ExcludeMissing
            fun _fileIds(): JsonField<List<String>> = fileIds

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): CodeInterpreter = apply {
                if (validated) {
                    return@apply
                }

                fileIds()
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

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
                 * available to the `code_interpreter` tool. There can be a maximum of 20 files
                 * associated with the tool.
                 */
                fun fileIds(fileIds: List<String>) = fileIds(JsonField.of(fileIds))

                /**
                 * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs made
                 * available to the `code_interpreter` tool. There can be a maximum of 20 files
                 * associated with the tool.
                 */
                fun fileIds(fileIds: JsonField<List<String>>) = apply {
                    this.fileIds = fileIds.map { it.toMutableList() }
                }

                /**
                 * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs made
                 * available to the `code_interpreter` tool. There can be a maximum of 20 files
                 * associated with the tool.
                 */
                fun addFileId(fileId: String) = apply {
                    fileIds =
                        (fileIds ?: JsonField.of(mutableListOf())).apply {
                            asKnown()
                                .orElseThrow {
                                    IllegalStateException(
                                        "Field was set to non-list type: ${javaClass.simpleName}"
                                    )
                                }
                                .add(fileId)
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

                fun build(): CodeInterpreter =
                    CodeInterpreter(
                        (fileIds ?: JsonMissing.of()).map { it.toImmutable() },
                        additionalProperties.toImmutable()
                    )
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

        @NoAutoDetect
        class FileSearch
        @JsonCreator
        private constructor(
            @JsonProperty("vector_store_ids")
            @ExcludeMissing
            private val vectorStoreIds: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("vector_stores")
            @ExcludeMissing
            private val vectorStores: JsonField<List<VectorStore>> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /**
             * The
             * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
             * attached to this assistant. There can be a maximum of 1 vector store attached to the
             * assistant.
             */
            fun vectorStoreIds(): Optional<List<String>> =
                Optional.ofNullable(vectorStoreIds.getNullable("vector_store_ids"))

            /**
             * A helper to create a
             * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
             * with file_ids and attach it to this assistant. There can be a maximum of 1 vector
             * store attached to the assistant.
             */
            fun vectorStores(): Optional<List<VectorStore>> =
                Optional.ofNullable(vectorStores.getNullable("vector_stores"))

            /**
             * The
             * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
             * attached to this assistant. There can be a maximum of 1 vector store attached to the
             * assistant.
             */
            @JsonProperty("vector_store_ids")
            @ExcludeMissing
            fun _vectorStoreIds(): JsonField<List<String>> = vectorStoreIds

            /**
             * A helper to create a
             * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
             * with file_ids and attach it to this assistant. There can be a maximum of 1 vector
             * store attached to the assistant.
             */
            @JsonProperty("vector_stores")
            @ExcludeMissing
            fun _vectorStores(): JsonField<List<VectorStore>> = vectorStores

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): FileSearch = apply {
                if (validated) {
                    return@apply
                }

                vectorStoreIds()
                vectorStores().ifPresent { it.forEach { it.validate() } }
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [FileSearch]. */
            class Builder internal constructor() {

                private var vectorStoreIds: JsonField<MutableList<String>>? = null
                private var vectorStores: JsonField<MutableList<VectorStore>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(fileSearch: FileSearch) = apply {
                    vectorStoreIds = fileSearch.vectorStoreIds.map { it.toMutableList() }
                    vectorStores = fileSearch.vectorStores.map { it.toMutableList() }
                    additionalProperties = fileSearch.additionalProperties.toMutableMap()
                }

                /**
                 * The
                 * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
                 * attached to this assistant. There can be a maximum of 1 vector store attached to
                 * the assistant.
                 */
                fun vectorStoreIds(vectorStoreIds: List<String>) =
                    vectorStoreIds(JsonField.of(vectorStoreIds))

                /**
                 * The
                 * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
                 * attached to this assistant. There can be a maximum of 1 vector store attached to
                 * the assistant.
                 */
                fun vectorStoreIds(vectorStoreIds: JsonField<List<String>>) = apply {
                    this.vectorStoreIds = vectorStoreIds.map { it.toMutableList() }
                }

                /**
                 * The
                 * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
                 * attached to this assistant. There can be a maximum of 1 vector store attached to
                 * the assistant.
                 */
                fun addVectorStoreId(vectorStoreId: String) = apply {
                    vectorStoreIds =
                        (vectorStoreIds ?: JsonField.of(mutableListOf())).apply {
                            asKnown()
                                .orElseThrow {
                                    IllegalStateException(
                                        "Field was set to non-list type: ${javaClass.simpleName}"
                                    )
                                }
                                .add(vectorStoreId)
                        }
                }

                /**
                 * A helper to create a
                 * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
                 * with file_ids and attach it to this assistant. There can be a maximum of 1 vector
                 * store attached to the assistant.
                 */
                fun vectorStores(vectorStores: List<VectorStore>) =
                    vectorStores(JsonField.of(vectorStores))

                /**
                 * A helper to create a
                 * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
                 * with file_ids and attach it to this assistant. There can be a maximum of 1 vector
                 * store attached to the assistant.
                 */
                fun vectorStores(vectorStores: JsonField<List<VectorStore>>) = apply {
                    this.vectorStores = vectorStores.map { it.toMutableList() }
                }

                /**
                 * A helper to create a
                 * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
                 * with file_ids and attach it to this assistant. There can be a maximum of 1 vector
                 * store attached to the assistant.
                 */
                fun addVectorStore(vectorStore: VectorStore) = apply {
                    vectorStores =
                        (vectorStores ?: JsonField.of(mutableListOf())).apply {
                            asKnown()
                                .orElseThrow {
                                    IllegalStateException(
                                        "Field was set to non-list type: ${javaClass.simpleName}"
                                    )
                                }
                                .add(vectorStore)
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

                fun build(): FileSearch =
                    FileSearch(
                        (vectorStoreIds ?: JsonMissing.of()).map { it.toImmutable() },
                        (vectorStores ?: JsonMissing.of()).map { it.toImmutable() },
                        additionalProperties.toImmutable(),
                    )
            }

            @NoAutoDetect
            class VectorStore
            @JsonCreator
            private constructor(
                @JsonProperty("chunking_strategy")
                @ExcludeMissing
                private val chunkingStrategy: JsonField<FileChunkingStrategyParam> =
                    JsonMissing.of(),
                @JsonProperty("file_ids")
                @ExcludeMissing
                private val fileIds: JsonField<List<String>> = JsonMissing.of(),
                @JsonProperty("metadata")
                @ExcludeMissing
                private val metadata: JsonField<Metadata> = JsonMissing.of(),
                @JsonAnySetter
                private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
            ) {

                /**
                 * The chunking strategy used to chunk the file(s). If not set, will use the `auto`
                 * strategy. Only applicable if `file_ids` is non-empty.
                 */
                fun chunkingStrategy(): Optional<FileChunkingStrategyParam> =
                    Optional.ofNullable(chunkingStrategy.getNullable("chunking_strategy"))

                /**
                 * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs to add
                 * to the vector store. There can be a maximum of 10000 files in a vector store.
                 */
                fun fileIds(): Optional<List<String>> =
                    Optional.ofNullable(fileIds.getNullable("file_ids"))

                /**
                 * Set of 16 key-value pairs that can be attached to an object. This can be useful
                 * for storing additional information about the object in a structured format, and
                 * querying for objects via API or the dashboard.
                 *
                 * Keys are strings with a maximum length of 64 characters. Values are strings with
                 * a maximum length of 512 characters.
                 */
                fun metadata(): Optional<Metadata> =
                    Optional.ofNullable(metadata.getNullable("metadata"))

                /**
                 * The chunking strategy used to chunk the file(s). If not set, will use the `auto`
                 * strategy. Only applicable if `file_ids` is non-empty.
                 */
                @JsonProperty("chunking_strategy")
                @ExcludeMissing
                fun _chunkingStrategy(): JsonField<FileChunkingStrategyParam> = chunkingStrategy

                /**
                 * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs to add
                 * to the vector store. There can be a maximum of 10000 files in a vector store.
                 */
                @JsonProperty("file_ids")
                @ExcludeMissing
                fun _fileIds(): JsonField<List<String>> = fileIds

                /**
                 * Set of 16 key-value pairs that can be attached to an object. This can be useful
                 * for storing additional information about the object in a structured format, and
                 * querying for objects via API or the dashboard.
                 *
                 * Keys are strings with a maximum length of 64 characters. Values are strings with
                 * a maximum length of 512 characters.
                 */
                @JsonProperty("metadata")
                @ExcludeMissing
                fun _metadata(): JsonField<Metadata> = metadata

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                private var validated: Boolean = false

                fun validate(): VectorStore = apply {
                    if (validated) {
                        return@apply
                    }

                    chunkingStrategy().ifPresent { it.validate() }
                    fileIds()
                    metadata().ifPresent { it.validate() }
                    validated = true
                }

                fun toBuilder() = Builder().from(this)

                companion object {

                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [VectorStore]. */
                class Builder internal constructor() {

                    private var chunkingStrategy: JsonField<FileChunkingStrategyParam> =
                        JsonMissing.of()
                    private var fileIds: JsonField<MutableList<String>>? = null
                    private var metadata: JsonField<Metadata> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(vectorStore: VectorStore) = apply {
                        chunkingStrategy = vectorStore.chunkingStrategy
                        fileIds = vectorStore.fileIds.map { it.toMutableList() }
                        metadata = vectorStore.metadata
                        additionalProperties = vectorStore.additionalProperties.toMutableMap()
                    }

                    /**
                     * The chunking strategy used to chunk the file(s). If not set, will use the
                     * `auto` strategy. Only applicable if `file_ids` is non-empty.
                     */
                    fun chunkingStrategy(chunkingStrategy: FileChunkingStrategyParam) =
                        chunkingStrategy(JsonField.of(chunkingStrategy))

                    /**
                     * The chunking strategy used to chunk the file(s). If not set, will use the
                     * `auto` strategy. Only applicable if `file_ids` is non-empty.
                     */
                    fun chunkingStrategy(chunkingStrategy: JsonField<FileChunkingStrategyParam>) =
                        apply {
                            this.chunkingStrategy = chunkingStrategy
                        }

                    /**
                     * The default strategy. This strategy currently uses a `max_chunk_size_tokens`
                     * of `800` and `chunk_overlap_tokens` of `400`.
                     */
                    fun chunkingStrategy(auto: AutoFileChunkingStrategyParam) =
                        chunkingStrategy(FileChunkingStrategyParam.ofAuto(auto))

                    /**
                     * The chunking strategy used to chunk the file(s). If not set, will use the
                     * `auto` strategy. Only applicable if `file_ids` is non-empty.
                     */
                    fun chunkingStrategy(static_: StaticFileChunkingStrategyObjectParam) =
                        chunkingStrategy(FileChunkingStrategyParam.ofStatic(static_))

                    /**
                     * The chunking strategy used to chunk the file(s). If not set, will use the
                     * `auto` strategy. Only applicable if `file_ids` is non-empty.
                     */
                    fun staticChunkingStrategy(static_: StaticFileChunkingStrategy) =
                        chunkingStrategy(
                            StaticFileChunkingStrategyObjectParam.builder().static_(static_).build()
                        )

                    /**
                     * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs to
                     * add to the vector store. There can be a maximum of 10000 files in a vector
                     * store.
                     */
                    fun fileIds(fileIds: List<String>) = fileIds(JsonField.of(fileIds))

                    /**
                     * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs to
                     * add to the vector store. There can be a maximum of 10000 files in a vector
                     * store.
                     */
                    fun fileIds(fileIds: JsonField<List<String>>) = apply {
                        this.fileIds = fileIds.map { it.toMutableList() }
                    }

                    /**
                     * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs to
                     * add to the vector store. There can be a maximum of 10000 files in a vector
                     * store.
                     */
                    fun addFileId(fileId: String) = apply {
                        fileIds =
                            (fileIds ?: JsonField.of(mutableListOf())).apply {
                                asKnown()
                                    .orElseThrow {
                                        IllegalStateException(
                                            "Field was set to non-list type: ${javaClass.simpleName}"
                                        )
                                    }
                                    .add(fileId)
                            }
                    }

                    /**
                     * Set of 16 key-value pairs that can be attached to an object. This can be
                     * useful for storing additional information about the object in a structured
                     * format, and querying for objects via API or the dashboard.
                     *
                     * Keys are strings with a maximum length of 64 characters. Values are strings
                     * with a maximum length of 512 characters.
                     */
                    fun metadata(metadata: Metadata?) = metadata(JsonField.ofNullable(metadata))

                    /**
                     * Set of 16 key-value pairs that can be attached to an object. This can be
                     * useful for storing additional information about the object in a structured
                     * format, and querying for objects via API or the dashboard.
                     *
                     * Keys are strings with a maximum length of 64 characters. Values are strings
                     * with a maximum length of 512 characters.
                     */
                    fun metadata(metadata: Optional<Metadata>) = metadata(metadata.orElse(null))

                    /**
                     * Set of 16 key-value pairs that can be attached to an object. This can be
                     * useful for storing additional information about the object in a structured
                     * format, and querying for objects via API or the dashboard.
                     *
                     * Keys are strings with a maximum length of 64 characters. Values are strings
                     * with a maximum length of 512 characters.
                     */
                    fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

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

                    fun build(): VectorStore =
                        VectorStore(
                            chunkingStrategy,
                            (fileIds ?: JsonMissing.of()).map { it.toImmutable() },
                            metadata,
                            additionalProperties.toImmutable(),
                        )
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is VectorStore && chunkingStrategy == other.chunkingStrategy && fileIds == other.fileIds && metadata == other.metadata && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(chunkingStrategy, fileIds, metadata, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "VectorStore{chunkingStrategy=$chunkingStrategy, fileIds=$fileIds, metadata=$metadata, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is FileSearch && vectorStoreIds == other.vectorStoreIds && vectorStores == other.vectorStores && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(vectorStoreIds, vectorStores, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "FileSearch{vectorStoreIds=$vectorStoreIds, vectorStores=$vectorStores, additionalProperties=$additionalProperties}"
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

        return /* spotless:off */ other is BetaAssistantCreateParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "BetaAssistantCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
