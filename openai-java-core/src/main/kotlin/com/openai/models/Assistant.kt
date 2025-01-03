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
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/** Represents an `assistant` that can call the model and use tools. */
@NoAutoDetect
class Assistant
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("object")
    @ExcludeMissing
    private val object_: JsonField<Object> = JsonMissing.of(),
    @JsonProperty("created_at")
    @ExcludeMissing
    private val createdAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("name") @ExcludeMissing private val name: JsonField<String> = JsonMissing.of(),
    @JsonProperty("description")
    @ExcludeMissing
    private val description: JsonField<String> = JsonMissing.of(),
    @JsonProperty("model") @ExcludeMissing private val model: JsonField<String> = JsonMissing.of(),
    @JsonProperty("instructions")
    @ExcludeMissing
    private val instructions: JsonField<String> = JsonMissing.of(),
    @JsonProperty("tools")
    @ExcludeMissing
    private val tools: JsonField<List<AssistantTool>> = JsonMissing.of(),
    @JsonProperty("tool_resources")
    @ExcludeMissing
    private val toolResources: JsonField<ToolResources> = JsonMissing.of(),
    @JsonProperty("metadata") @ExcludeMissing private val metadata: JsonValue = JsonMissing.of(),
    @JsonProperty("temperature")
    @ExcludeMissing
    private val temperature: JsonField<Double> = JsonMissing.of(),
    @JsonProperty("top_p") @ExcludeMissing private val topP: JsonField<Double> = JsonMissing.of(),
    @JsonProperty("response_format")
    @ExcludeMissing
    private val responseFormat: JsonField<AssistantResponseFormatOption> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The identifier, which can be referenced in API endpoints. */
    fun id(): String = id.getRequired("id")

    /** The object type, which is always `assistant`. */
    fun object_(): Object = object_.getRequired("object")

    /** The Unix timestamp (in seconds) for when the assistant was created. */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /** The name of the assistant. The maximum length is 256 characters. */
    fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

    /** The description of the assistant. The maximum length is 512 characters. */
    fun description(): Optional<String> =
        Optional.ofNullable(description.getNullable("description"))

    /**
     * ID of the model to use. You can use the
     * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all of
     * your available models, or see our [Model overview](https://platform.openai.com/docs/models)
     * for descriptions of them.
     */
    fun model(): String = model.getRequired("model")

    /**
     * The system instructions that the assistant uses. The maximum length is 256,000 characters.
     */
    fun instructions(): Optional<String> =
        Optional.ofNullable(instructions.getNullable("instructions"))

    /**
     * A list of tool enabled on the assistant. There can be a maximum of 128 tools per assistant.
     * Tools can be of types `code_interpreter`, `file_search`, or `function`.
     */
    fun tools(): List<AssistantTool> = tools.getRequired("tools")

    /**
     * A set of resources that are used by the assistant's tools. The resources are specific to the
     * type of tool. For example, the `code_interpreter` tool requires a list of file IDs, while the
     * `file_search` tool requires a list of vector store IDs.
     */
    fun toolResources(): Optional<ToolResources> =
        Optional.ofNullable(toolResources.getNullable("tool_resources"))

    /**
     * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
     * output more random, while lower values like 0.2 will make it more focused and deterministic.
     */
    fun temperature(): Optional<Double> =
        Optional.ofNullable(temperature.getNullable("temperature"))

    /**
     * An alternative to sampling with temperature, called nucleus sampling, where the model
     * considers the results of the tokens with top_p probability mass. So 0.1 means only the tokens
     * comprising the top 10% probability mass are considered.
     *
     * We generally recommend altering this or temperature but not both.
     */
    fun topP(): Optional<Double> = Optional.ofNullable(topP.getNullable("top_p"))

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
    fun responseFormat(): Optional<AssistantResponseFormatOption> =
        Optional.ofNullable(responseFormat.getNullable("response_format"))

    /** The identifier, which can be referenced in API endpoints. */
    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The object type, which is always `assistant`. */
    @JsonProperty("object") @ExcludeMissing fun _object_() = object_

    /** The Unix timestamp (in seconds) for when the assistant was created. */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt() = createdAt

    /** The name of the assistant. The maximum length is 256 characters. */
    @JsonProperty("name") @ExcludeMissing fun _name() = name

    /** The description of the assistant. The maximum length is 512 characters. */
    @JsonProperty("description") @ExcludeMissing fun _description() = description

    /**
     * ID of the model to use. You can use the
     * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all of
     * your available models, or see our [Model overview](https://platform.openai.com/docs/models)
     * for descriptions of them.
     */
    @JsonProperty("model") @ExcludeMissing fun _model() = model

    /**
     * The system instructions that the assistant uses. The maximum length is 256,000 characters.
     */
    @JsonProperty("instructions") @ExcludeMissing fun _instructions() = instructions

    /**
     * A list of tool enabled on the assistant. There can be a maximum of 128 tools per assistant.
     * Tools can be of types `code_interpreter`, `file_search`, or `function`.
     */
    @JsonProperty("tools") @ExcludeMissing fun _tools() = tools

    /**
     * A set of resources that are used by the assistant's tools. The resources are specific to the
     * type of tool. For example, the `code_interpreter` tool requires a list of file IDs, while the
     * `file_search` tool requires a list of vector store IDs.
     */
    @JsonProperty("tool_resources") @ExcludeMissing fun _toolResources() = toolResources

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format. Keys can be a maximum of 64
     * characters long and values can be a maximum of 512 characters long.
     */
    @JsonProperty("metadata") @ExcludeMissing fun _metadata() = metadata

    /**
     * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
     * output more random, while lower values like 0.2 will make it more focused and deterministic.
     */
    @JsonProperty("temperature") @ExcludeMissing fun _temperature() = temperature

    /**
     * An alternative to sampling with temperature, called nucleus sampling, where the model
     * considers the results of the tokens with top_p probability mass. So 0.1 means only the tokens
     * comprising the top 10% probability mass are considered.
     *
     * We generally recommend altering this or temperature but not both.
     */
    @JsonProperty("top_p") @ExcludeMissing fun _topP() = topP

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
    @JsonProperty("response_format") @ExcludeMissing fun _responseFormat() = responseFormat

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): Assistant = apply {
        if (!validated) {
            id()
            object_()
            createdAt()
            name()
            description()
            model()
            instructions()
            tools()
            toolResources().map { it.validate() }
            temperature()
            topP()
            responseFormat()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var object_: JsonField<Object> = JsonMissing.of()
        private var createdAt: JsonField<Long> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var description: JsonField<String> = JsonMissing.of()
        private var model: JsonField<String> = JsonMissing.of()
        private var instructions: JsonField<String> = JsonMissing.of()
        private var tools: JsonField<List<AssistantTool>> = JsonMissing.of()
        private var toolResources: JsonField<ToolResources> = JsonMissing.of()
        private var metadata: JsonValue = JsonMissing.of()
        private var temperature: JsonField<Double> = JsonMissing.of()
        private var topP: JsonField<Double> = JsonMissing.of()
        private var responseFormat: JsonField<AssistantResponseFormatOption> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(assistant: Assistant) = apply {
            id = assistant.id
            object_ = assistant.object_
            createdAt = assistant.createdAt
            name = assistant.name
            description = assistant.description
            model = assistant.model
            instructions = assistant.instructions
            tools = assistant.tools
            toolResources = assistant.toolResources
            metadata = assistant.metadata
            temperature = assistant.temperature
            topP = assistant.topP
            responseFormat = assistant.responseFormat
            additionalProperties = assistant.additionalProperties.toMutableMap()
        }

        /** The identifier, which can be referenced in API endpoints. */
        fun id(id: String) = id(JsonField.of(id))

        /** The identifier, which can be referenced in API endpoints. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The object type, which is always `assistant`. */
        fun object_(object_: Object) = object_(JsonField.of(object_))

        /** The object type, which is always `assistant`. */
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

        /** The Unix timestamp (in seconds) for when the assistant was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /** The Unix timestamp (in seconds) for when the assistant was created. */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /** The name of the assistant. The maximum length is 256 characters. */
        fun name(name: String) = name(JsonField.of(name))

        /** The name of the assistant. The maximum length is 256 characters. */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** The description of the assistant. The maximum length is 512 characters. */
        fun description(description: String) = description(JsonField.of(description))

        /** The description of the assistant. The maximum length is 512 characters. */
        fun description(description: JsonField<String>) = apply { this.description = description }

        /**
         * ID of the model to use. You can use the
         * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all
         * of your available models, or see our
         * [Model overview](https://platform.openai.com/docs/models) for descriptions of them.
         */
        fun model(model: String) = model(JsonField.of(model))

        /**
         * ID of the model to use. You can use the
         * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all
         * of your available models, or see our
         * [Model overview](https://platform.openai.com/docs/models) for descriptions of them.
         */
        fun model(model: JsonField<String>) = apply { this.model = model }

        /**
         * The system instructions that the assistant uses. The maximum length is 256,000
         * characters.
         */
        fun instructions(instructions: String) = instructions(JsonField.of(instructions))

        /**
         * The system instructions that the assistant uses. The maximum length is 256,000
         * characters.
         */
        fun instructions(instructions: JsonField<String>) = apply {
            this.instructions = instructions
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
        fun tools(tools: JsonField<List<AssistantTool>>) = apply { this.tools = tools }

        /**
         * A set of resources that are used by the assistant's tools. The resources are specific to
         * the type of tool. For example, the `code_interpreter` tool requires a list of file IDs,
         * while the `file_search` tool requires a list of vector store IDs.
         */
        fun toolResources(toolResources: ToolResources) = toolResources(JsonField.of(toolResources))

        /**
         * A set of resources that are used by the assistant's tools. The resources are specific to
         * the type of tool. For example, the `code_interpreter` tool requires a list of file IDs,
         * while the `file_search` tool requires a list of vector store IDs.
         */
        fun toolResources(toolResources: JsonField<ToolResources>) = apply {
            this.toolResources = toolResources
        }

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format. Keys can be a
         * maximum of 64 characters long and values can be a maximum of 512 characters long.
         */
        fun metadata(metadata: JsonValue) = apply { this.metadata = metadata }

        /**
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic.
         */
        fun temperature(temperature: Double) = temperature(JsonField.of(temperature))

        /**
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic.
         */
        fun temperature(temperature: JsonField<Double>) = apply { this.temperature = temperature }

        /**
         * An alternative to sampling with temperature, called nucleus sampling, where the model
         * considers the results of the tokens with top_p probability mass. So 0.1 means only the
         * tokens comprising the top 10% probability mass are considered.
         *
         * We generally recommend altering this or temperature but not both.
         */
        fun topP(topP: Double) = topP(JsonField.of(topP))

        /**
         * An alternative to sampling with temperature, called nucleus sampling, where the model
         * considers the results of the tokens with top_p probability mass. So 0.1 means only the
         * tokens comprising the top 10% probability mass are considered.
         *
         * We generally recommend altering this or temperature but not both.
         */
        fun topP(topP: JsonField<Double>) = apply { this.topP = topP }

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
        fun responseFormat(responseFormat: AssistantResponseFormatOption) =
            responseFormat(JsonField.of(responseFormat))

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
            this.responseFormat = responseFormat
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

        fun build(): Assistant =
            Assistant(
                id,
                object_,
                createdAt,
                name,
                description,
                model,
                instructions,
                tools.map { it.toImmutable() },
                toolResources,
                metadata,
                temperature,
                topP,
                responseFormat,
                additionalProperties.toImmutable(),
            )
    }

    class Object
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val ASSISTANT = of("assistant")

            @JvmStatic fun of(value: String) = Object(JsonField.of(value))
        }

        enum class Known {
            ASSISTANT,
        }

        enum class Value {
            ASSISTANT,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                ASSISTANT -> Value.ASSISTANT
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                ASSISTANT -> Known.ASSISTANT
                else -> throw OpenAIInvalidDataException("Unknown Object: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Object && value == other.value /* spotless:on */
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

        @JsonProperty("code_interpreter") @ExcludeMissing fun _codeInterpreter() = codeInterpreter

        @JsonProperty("file_search") @ExcludeMissing fun _fileSearch() = fileSearch

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ToolResources = apply {
            if (!validated) {
                codeInterpreter().map { it.validate() }
                fileSearch().map { it.validate() }
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

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
             * available to the `code_interpreter`` tool. There can be a maximum of 20 files
             * associated with the tool.
             */
            fun fileIds(): Optional<List<String>> =
                Optional.ofNullable(fileIds.getNullable("file_ids"))

            /**
             * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs made
             * available to the `code_interpreter`` tool. There can be a maximum of 20 files
             * associated with the tool.
             */
            @JsonProperty("file_ids") @ExcludeMissing fun _fileIds() = fileIds

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): CodeInterpreter = apply {
                if (!validated) {
                    fileIds()
                    validated = true
                }
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var fileIds: JsonField<List<String>> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(codeInterpreter: CodeInterpreter) = apply {
                    fileIds = codeInterpreter.fileIds
                    additionalProperties = codeInterpreter.additionalProperties.toMutableMap()
                }

                /**
                 * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs made
                 * available to the `code_interpreter`` tool. There can be a maximum of 20 files
                 * associated with the tool.
                 */
                fun fileIds(fileIds: List<String>) = fileIds(JsonField.of(fileIds))

                /**
                 * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs made
                 * available to the `code_interpreter`` tool. There can be a maximum of 20 files
                 * associated with the tool.
                 */
                fun fileIds(fileIds: JsonField<List<String>>) = apply { this.fileIds = fileIds }

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
                        fileIds.map { it.toImmutable() },
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
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /**
             * The ID of the
             * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
             * attached to this assistant. There can be a maximum of 1 vector store attached to the
             * assistant.
             */
            fun vectorStoreIds(): Optional<List<String>> =
                Optional.ofNullable(vectorStoreIds.getNullable("vector_store_ids"))

            /**
             * The ID of the
             * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
             * attached to this assistant. There can be a maximum of 1 vector store attached to the
             * assistant.
             */
            @JsonProperty("vector_store_ids") @ExcludeMissing fun _vectorStoreIds() = vectorStoreIds

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): FileSearch = apply {
                if (!validated) {
                    vectorStoreIds()
                    validated = true
                }
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var vectorStoreIds: JsonField<List<String>> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(fileSearch: FileSearch) = apply {
                    vectorStoreIds = fileSearch.vectorStoreIds
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
                 * The ID of the
                 * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
                 * attached to this assistant. There can be a maximum of 1 vector store attached to
                 * the assistant.
                 */
                fun vectorStoreIds(vectorStoreIds: JsonField<List<String>>) = apply {
                    this.vectorStoreIds = vectorStoreIds
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
                        vectorStoreIds.map { it.toImmutable() },
                        additionalProperties.toImmutable()
                    )
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

        return /* spotless:off */ other is Assistant && id == other.id && object_ == other.object_ && createdAt == other.createdAt && name == other.name && description == other.description && model == other.model && instructions == other.instructions && tools == other.tools && toolResources == other.toolResources && metadata == other.metadata && temperature == other.temperature && topP == other.topP && responseFormat == other.responseFormat && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, object_, createdAt, name, description, model, instructions, tools, toolResources, metadata, temperature, topP, responseFormat, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Assistant{id=$id, object_=$object_, createdAt=$createdAt, name=$name, description=$description, model=$model, instructions=$instructions, tools=$tools, toolResources=$toolResources, metadata=$metadata, temperature=$temperature, topP=$topP, responseFormat=$responseFormat, additionalProperties=$additionalProperties}"
}
