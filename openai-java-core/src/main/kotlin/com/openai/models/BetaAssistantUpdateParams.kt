// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import java.util.Objects
import java.util.Optional

class BetaAssistantUpdateParams
constructor(
    private val assistantId: String,
    private val body: BetaAssistantUpdateBody,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) {

    fun assistantId(): String = assistantId

    /** The description of the assistant. The maximum length is 512 characters. */
    fun description(): Optional<String> = body.description()

    /**
     * The system instructions that the assistant uses. The maximum length is 256,000 characters.
     */
    fun instructions(): Optional<String> = body.instructions()

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format. Keys can be a maximum of 64
     * characters long and values can be a maximum of 512 characters long.
     */
    fun metadata(): Optional<JsonValue> = body.metadata()

    /**
     * ID of the model to use. You can use the
     * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all of
     * your available models, or see our [Model overview](https://platform.openai.com/docs/models)
     * for descriptions of them.
     */
    fun model(): Optional<String> = body.model()

    /** The name of the assistant. The maximum length is 256 characters. */
    fun name(): Optional<String> = body.name()

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

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    @JvmSynthetic internal fun getBody(): BetaAssistantUpdateBody = body

    @JvmSynthetic internal fun getHeaders(): Headers = additionalHeaders

    @JvmSynthetic internal fun getQueryParams(): QueryParams = additionalQueryParams

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> assistantId
            else -> ""
        }
    }

    @NoAutoDetect
    class BetaAssistantUpdateBody
    @JsonCreator
    internal constructor(
        @JsonProperty("description") private val description: String?,
        @JsonProperty("instructions") private val instructions: String?,
        @JsonProperty("metadata") private val metadata: JsonValue?,
        @JsonProperty("model") private val model: String?,
        @JsonProperty("name") private val name: String?,
        @JsonProperty("response_format") private val responseFormat: AssistantResponseFormatOption?,
        @JsonProperty("temperature") private val temperature: Double?,
        @JsonProperty("tool_resources") private val toolResources: ToolResources?,
        @JsonProperty("tools") private val tools: List<AssistantTool>?,
        @JsonProperty("top_p") private val topP: Double?,
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The description of the assistant. The maximum length is 512 characters. */
        @JsonProperty("description")
        fun description(): Optional<String> = Optional.ofNullable(description)

        /**
         * The system instructions that the assistant uses. The maximum length is 256,000
         * characters.
         */
        @JsonProperty("instructions")
        fun instructions(): Optional<String> = Optional.ofNullable(instructions)

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format. Keys can be a
         * maximum of 64 characters long and values can be a maximum of 512 characters long.
         */
        @JsonProperty("metadata")
        fun metadata(): Optional<JsonValue> = Optional.ofNullable(metadata)

        /**
         * ID of the model to use. You can use the
         * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all
         * of your available models, or see our
         * [Model overview](https://platform.openai.com/docs/models) for descriptions of them.
         */
        @JsonProperty("model") fun model(): Optional<String> = Optional.ofNullable(model)

        /** The name of the assistant. The maximum length is 256 characters. */
        @JsonProperty("name") fun name(): Optional<String> = Optional.ofNullable(name)

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
        fun responseFormat(): Optional<AssistantResponseFormatOption> =
            Optional.ofNullable(responseFormat)

        /**
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic.
         */
        @JsonProperty("temperature")
        fun temperature(): Optional<Double> = Optional.ofNullable(temperature)

        /**
         * A set of resources that are used by the assistant's tools. The resources are specific to
         * the type of tool. For example, the `code_interpreter` tool requires a list of file IDs,
         * while the `file_search` tool requires a list of vector store IDs.
         */
        @JsonProperty("tool_resources")
        fun toolResources(): Optional<ToolResources> = Optional.ofNullable(toolResources)

        /**
         * A list of tool enabled on the assistant. There can be a maximum of 128 tools per
         * assistant. Tools can be of types `code_interpreter`, `file_search`, or `function`.
         */
        @JsonProperty("tools")
        fun tools(): Optional<List<AssistantTool>> = Optional.ofNullable(tools)

        /**
         * An alternative to sampling with temperature, called nucleus sampling, where the model
         * considers the results of the tokens with top_p probability mass. So 0.1 means only the
         * tokens comprising the top 10% probability mass are considered.
         *
         * We generally recommend altering this or temperature but not both.
         */
        @JsonProperty("top_p") fun topP(): Optional<Double> = Optional.ofNullable(topP)

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var description: String? = null
            private var instructions: String? = null
            private var metadata: JsonValue? = null
            private var model: String? = null
            private var name: String? = null
            private var responseFormat: AssistantResponseFormatOption? = null
            private var temperature: Double? = null
            private var toolResources: ToolResources? = null
            private var tools: MutableList<AssistantTool>? = null
            private var topP: Double? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(betaAssistantUpdateBody: BetaAssistantUpdateBody) = apply {
                description = betaAssistantUpdateBody.description
                instructions = betaAssistantUpdateBody.instructions
                metadata = betaAssistantUpdateBody.metadata
                model = betaAssistantUpdateBody.model
                name = betaAssistantUpdateBody.name
                responseFormat = betaAssistantUpdateBody.responseFormat
                temperature = betaAssistantUpdateBody.temperature
                toolResources = betaAssistantUpdateBody.toolResources
                tools = betaAssistantUpdateBody.tools?.toMutableList()
                topP = betaAssistantUpdateBody.topP
                additionalProperties = betaAssistantUpdateBody.additionalProperties.toMutableMap()
            }

            /** The description of the assistant. The maximum length is 512 characters. */
            fun description(description: String?) = apply { this.description = description }

            /** The description of the assistant. The maximum length is 512 characters. */
            fun description(description: Optional<String>) = description(description.orElse(null))

            /**
             * The system instructions that the assistant uses. The maximum length is 256,000
             * characters.
             */
            fun instructions(instructions: String?) = apply { this.instructions = instructions }

            /**
             * The system instructions that the assistant uses. The maximum length is 256,000
             * characters.
             */
            fun instructions(instructions: Optional<String>) =
                instructions(instructions.orElse(null))

            /**
             * Set of 16 key-value pairs that can be attached to an object. This can be useful for
             * storing additional information about the object in a structured format. Keys can be a
             * maximum of 64 characters long and values can be a maximum of 512 characters long.
             */
            fun metadata(metadata: JsonValue?) = apply { this.metadata = metadata }

            /**
             * Set of 16 key-value pairs that can be attached to an object. This can be useful for
             * storing additional information about the object in a structured format. Keys can be a
             * maximum of 64 characters long and values can be a maximum of 512 characters long.
             */
            fun metadata(metadata: Optional<JsonValue>) = metadata(metadata.orElse(null))

            /**
             * ID of the model to use. You can use the
             * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see
             * all of your available models, or see our
             * [Model overview](https://platform.openai.com/docs/models) for descriptions of them.
             */
            fun model(model: String?) = apply { this.model = model }

            /**
             * ID of the model to use. You can use the
             * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see
             * all of your available models, or see our
             * [Model overview](https://platform.openai.com/docs/models) for descriptions of them.
             */
            fun model(model: Optional<String>) = model(model.orElse(null))

            /** The name of the assistant. The maximum length is 256 characters. */
            fun name(name: String?) = apply { this.name = name }

            /** The name of the assistant. The maximum length is 256 characters. */
            fun name(name: Optional<String>) = name(name.orElse(null))

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
            fun responseFormat(responseFormat: AssistantResponseFormatOption?) = apply {
                this.responseFormat = responseFormat
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
            fun responseFormat(responseFormat: Optional<AssistantResponseFormatOption>) =
                responseFormat(responseFormat.orElse(null))

            /** `auto` is the default value */
            fun responseFormat(behavior: AssistantResponseFormatOption.Behavior) = apply {
                this.responseFormat = AssistantResponseFormatOption.ofBehavior(behavior)
            }

            fun responseFormat(responseFormatText: ResponseFormatText) = apply {
                this.responseFormat =
                    AssistantResponseFormatOption.ofResponseFormatText(responseFormatText)
            }

            fun responseFormat(responseFormatJsonObject: ResponseFormatJsonObject) = apply {
                this.responseFormat =
                    AssistantResponseFormatOption.ofResponseFormatJsonObject(
                        responseFormatJsonObject
                    )
            }

            fun responseFormat(responseFormatJsonSchema: ResponseFormatJsonSchema) = apply {
                this.responseFormat =
                    AssistantResponseFormatOption.ofResponseFormatJsonSchema(
                        responseFormatJsonSchema
                    )
            }

            /**
             * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make
             * the output more random, while lower values like 0.2 will make it more focused and
             * deterministic.
             */
            fun temperature(temperature: Double?) = apply { this.temperature = temperature }

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
             * A set of resources that are used by the assistant's tools. The resources are specific
             * to the type of tool. For example, the `code_interpreter` tool requires a list of file
             * IDs, while the `file_search` tool requires a list of vector store IDs.
             */
            fun toolResources(toolResources: ToolResources?) = apply {
                this.toolResources = toolResources
            }

            /**
             * A set of resources that are used by the assistant's tools. The resources are specific
             * to the type of tool. For example, the `code_interpreter` tool requires a list of file
             * IDs, while the `file_search` tool requires a list of vector store IDs.
             */
            fun toolResources(toolResources: Optional<ToolResources>) =
                toolResources(toolResources.orElse(null))

            /**
             * A list of tool enabled on the assistant. There can be a maximum of 128 tools per
             * assistant. Tools can be of types `code_interpreter`, `file_search`, or `function`.
             */
            fun tools(tools: List<AssistantTool>?) = apply { this.tools = tools?.toMutableList() }

            /**
             * A list of tool enabled on the assistant. There can be a maximum of 128 tools per
             * assistant. Tools can be of types `code_interpreter`, `file_search`, or `function`.
             */
            fun tools(tools: Optional<List<AssistantTool>>) = tools(tools.orElse(null))

            /**
             * A list of tool enabled on the assistant. There can be a maximum of 128 tools per
             * assistant. Tools can be of types `code_interpreter`, `file_search`, or `function`.
             */
            fun addTool(tool: AssistantTool) = apply {
                tools = (tools ?: mutableListOf()).apply { add(tool) }
            }

            /**
             * An alternative to sampling with temperature, called nucleus sampling, where the model
             * considers the results of the tokens with top_p probability mass. So 0.1 means only
             * the tokens comprising the top 10% probability mass are considered.
             *
             * We generally recommend altering this or temperature but not both.
             */
            fun topP(topP: Double?) = apply { this.topP = topP }

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

            fun build(): BetaAssistantUpdateBody =
                BetaAssistantUpdateBody(
                    description,
                    instructions,
                    metadata,
                    model,
                    name,
                    responseFormat,
                    temperature,
                    toolResources,
                    tools?.toImmutable(),
                    topP,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is BetaAssistantUpdateBody && description == other.description && instructions == other.instructions && metadata == other.metadata && model == other.model && name == other.name && responseFormat == other.responseFormat && temperature == other.temperature && toolResources == other.toolResources && tools == other.tools && topP == other.topP && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(description, instructions, metadata, model, name, responseFormat, temperature, toolResources, tools, topP, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "BetaAssistantUpdateBody{description=$description, instructions=$instructions, metadata=$metadata, model=$model, name=$name, responseFormat=$responseFormat, temperature=$temperature, toolResources=$toolResources, tools=$tools, topP=$topP, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var assistantId: String? = null
        private var body: BetaAssistantUpdateBody.Builder = BetaAssistantUpdateBody.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(betaAssistantUpdateParams: BetaAssistantUpdateParams) = apply {
            assistantId = betaAssistantUpdateParams.assistantId
            body = betaAssistantUpdateParams.body.toBuilder()
            additionalHeaders = betaAssistantUpdateParams.additionalHeaders.toBuilder()
            additionalQueryParams = betaAssistantUpdateParams.additionalQueryParams.toBuilder()
        }

        fun assistantId(assistantId: String) = apply { this.assistantId = assistantId }

        /** The description of the assistant. The maximum length is 512 characters. */
        fun description(description: String?) = apply { body.description(description) }

        /** The description of the assistant. The maximum length is 512 characters. */
        fun description(description: Optional<String>) = description(description.orElse(null))

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
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format. Keys can be a
         * maximum of 64 characters long and values can be a maximum of 512 characters long.
         */
        fun metadata(metadata: JsonValue?) = apply { body.metadata(metadata) }

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format. Keys can be a
         * maximum of 64 characters long and values can be a maximum of 512 characters long.
         */
        fun metadata(metadata: Optional<JsonValue>) = metadata(metadata.orElse(null))

        /**
         * ID of the model to use. You can use the
         * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all
         * of your available models, or see our
         * [Model overview](https://platform.openai.com/docs/models) for descriptions of them.
         */
        fun model(model: String?) = apply { body.model(model) }

        /**
         * ID of the model to use. You can use the
         * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all
         * of your available models, or see our
         * [Model overview](https://platform.openai.com/docs/models) for descriptions of them.
         */
        fun model(model: Optional<String>) = model(model.orElse(null))

        /** The name of the assistant. The maximum length is 256 characters. */
        fun name(name: String?) = apply { body.name(name) }

        /** The name of the assistant. The maximum length is 256 characters. */
        fun name(name: Optional<String>) = name(name.orElse(null))

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

        /** `auto` is the default value */
        fun responseFormat(behavior: AssistantResponseFormatOption.Behavior) = apply {
            body.responseFormat(behavior)
        }

        fun responseFormat(responseFormatText: ResponseFormatText) = apply {
            body.responseFormat(responseFormatText)
        }

        fun responseFormat(responseFormatJsonObject: ResponseFormatJsonObject) = apply {
            body.responseFormat(responseFormatJsonObject)
        }

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
         * A list of tool enabled on the assistant. There can be a maximum of 128 tools per
         * assistant. Tools can be of types `code_interpreter`, `file_search`, or `function`.
         */
        fun tools(tools: List<AssistantTool>?) = apply { body.tools(tools) }

        /**
         * A list of tool enabled on the assistant. There can be a maximum of 128 tools per
         * assistant. Tools can be of types `code_interpreter`, `file_search`, or `function`.
         */
        fun tools(tools: Optional<List<AssistantTool>>) = tools(tools.orElse(null))

        /**
         * A list of tool enabled on the assistant. There can be a maximum of 128 tools per
         * assistant. Tools can be of types `code_interpreter`, `file_search`, or `function`.
         */
        fun addTool(tool: AssistantTool) = apply { body.addTool(tool) }

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

        fun build(): BetaAssistantUpdateParams =
            BetaAssistantUpdateParams(
                checkNotNull(assistantId) { "`assistantId` is required but was not set" },
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
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
        @JsonProperty("code_interpreter") private val codeInterpreter: CodeInterpreter?,
        @JsonProperty("file_search") private val fileSearch: FileSearch?,
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        @JsonProperty("code_interpreter")
        fun codeInterpreter(): Optional<CodeInterpreter> = Optional.ofNullable(codeInterpreter)

        @JsonProperty("file_search")
        fun fileSearch(): Optional<FileSearch> = Optional.ofNullable(fileSearch)

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var codeInterpreter: CodeInterpreter? = null
            private var fileSearch: FileSearch? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(toolResources: ToolResources) = apply {
                codeInterpreter = toolResources.codeInterpreter
                fileSearch = toolResources.fileSearch
                additionalProperties = toolResources.additionalProperties.toMutableMap()
            }

            fun codeInterpreter(codeInterpreter: CodeInterpreter?) = apply {
                this.codeInterpreter = codeInterpreter
            }

            fun codeInterpreter(codeInterpreter: Optional<CodeInterpreter>) =
                codeInterpreter(codeInterpreter.orElse(null))

            fun fileSearch(fileSearch: FileSearch?) = apply { this.fileSearch = fileSearch }

            fun fileSearch(fileSearch: Optional<FileSearch>) = fileSearch(fileSearch.orElse(null))

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
            @JsonProperty("file_ids") private val fileIds: List<String>?,
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /**
             * Overrides the list of [file](https://platform.openai.com/docs/api-reference/files)
             * IDs made available to the `code_interpreter` tool. There can be a maximum of 20 files
             * associated with the tool.
             */
            @JsonProperty("file_ids")
            fun fileIds(): Optional<List<String>> = Optional.ofNullable(fileIds)

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var fileIds: MutableList<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(codeInterpreter: CodeInterpreter) = apply {
                    fileIds = codeInterpreter.fileIds?.toMutableList()
                    additionalProperties = codeInterpreter.additionalProperties.toMutableMap()
                }

                /**
                 * Overrides the list of
                 * [file](https://platform.openai.com/docs/api-reference/files) IDs made available
                 * to the `code_interpreter` tool. There can be a maximum of 20 files associated
                 * with the tool.
                 */
                fun fileIds(fileIds: List<String>?) = apply {
                    this.fileIds = fileIds?.toMutableList()
                }

                /**
                 * Overrides the list of
                 * [file](https://platform.openai.com/docs/api-reference/files) IDs made available
                 * to the `code_interpreter` tool. There can be a maximum of 20 files associated
                 * with the tool.
                 */
                fun fileIds(fileIds: Optional<List<String>>) = fileIds(fileIds.orElse(null))

                /**
                 * Overrides the list of
                 * [file](https://platform.openai.com/docs/api-reference/files) IDs made available
                 * to the `code_interpreter` tool. There can be a maximum of 20 files associated
                 * with the tool.
                 */
                fun addFileId(fileId: String) = apply {
                    fileIds = (fileIds ?: mutableListOf()).apply { add(fileId) }
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
                    CodeInterpreter(fileIds?.toImmutable(), additionalProperties.toImmutable())
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
            @JsonProperty("vector_store_ids") private val vectorStoreIds: List<String>?,
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /**
             * Overrides the
             * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
             * attached to this assistant. There can be a maximum of 1 vector store attached to the
             * assistant.
             */
            @JsonProperty("vector_store_ids")
            fun vectorStoreIds(): Optional<List<String>> = Optional.ofNullable(vectorStoreIds)

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var vectorStoreIds: MutableList<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(fileSearch: FileSearch) = apply {
                    vectorStoreIds = fileSearch.vectorStoreIds?.toMutableList()
                    additionalProperties = fileSearch.additionalProperties.toMutableMap()
                }

                /**
                 * Overrides the
                 * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
                 * attached to this assistant. There can be a maximum of 1 vector store attached to
                 * the assistant.
                 */
                fun vectorStoreIds(vectorStoreIds: List<String>?) = apply {
                    this.vectorStoreIds = vectorStoreIds?.toMutableList()
                }

                /**
                 * Overrides the
                 * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
                 * attached to this assistant. There can be a maximum of 1 vector store attached to
                 * the assistant.
                 */
                fun vectorStoreIds(vectorStoreIds: Optional<List<String>>) =
                    vectorStoreIds(vectorStoreIds.orElse(null))

                /**
                 * Overrides the
                 * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
                 * attached to this assistant. There can be a maximum of 1 vector store attached to
                 * the assistant.
                 */
                fun addVectorStoreId(vectorStoreId: String) = apply {
                    vectorStoreIds =
                        (vectorStoreIds ?: mutableListOf()).apply { add(vectorStoreId) }
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
                    FileSearch(vectorStoreIds?.toImmutable(), additionalProperties.toImmutable())
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

        return /* spotless:off */ other is BetaAssistantUpdateParams && assistantId == other.assistantId && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(assistantId, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "BetaAssistantUpdateParams{assistantId=$assistantId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
