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
import com.openai.core.Params
import com.openai.core.allMaxBy
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Compact a conversation. Returns a compacted response object.
 *
 * Learn when and how to compact long-running conversations in the
 * [conversation state guide](https://platform.openai.com/docs/guides/conversation-state#managing-the-context-window).
 * For ZDR-compatible compaction details, see
 * [Compaction (advanced)](https://platform.openai.com/docs/guides/conversation-state#compaction-advanced).
 */
class ResponseCompactParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Model ID used to generate the response, like `gpt-5` or `o3`. OpenAI offers a wide range of
     * models with different capabilities, performance characteristics, and price points. Refer to
     * the [model guide](https://platform.openai.com/docs/models) to browse and compare available
     * models.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun model(): Optional<Model> = body.model()

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
     * Returns the raw JSON value of [model].
     *
     * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _model(): JsonField<Model> = body._model()

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
     * Returns the raw JSON value of [previousResponseId].
     *
     * Unlike [previousResponseId], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _previousResponseId(): JsonField<String> = body._previousResponseId()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ResponseCompactParams].
         *
         * The following fields are required:
         * ```java
         * .model()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseCompactParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(responseCompactParams: ResponseCompactParams) = apply {
            body = responseCompactParams.body.toBuilder()
            additionalHeaders = responseCompactParams.additionalHeaders.toBuilder()
            additionalQueryParams = responseCompactParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [model]
         * - [input]
         * - [instructions]
         * - [previousResponseId]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * Model ID used to generate the response, like `gpt-5` or `o3`. OpenAI offers a wide range
         * of models with different capabilities, performance characteristics, and price points.
         * Refer to the [model guide](https://platform.openai.com/docs/models) to browse and compare
         * available models.
         */
        fun model(model: Model?) = apply { body.model(model) }

        /** Alias for calling [Builder.model] with `model.orElse(null)`. */
        fun model(model: Optional<Model>) = model(model.getOrNull())

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
         * Returns an immutable instance of [ResponseCompactParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .model()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ResponseCompactParams =
            ResponseCompactParams(
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
        private val model: JsonField<Model>,
        private val input: JsonField<Input>,
        private val instructions: JsonField<String>,
        private val previousResponseId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("model") @ExcludeMissing model: JsonField<Model> = JsonMissing.of(),
            @JsonProperty("input") @ExcludeMissing input: JsonField<Input> = JsonMissing.of(),
            @JsonProperty("instructions")
            @ExcludeMissing
            instructions: JsonField<String> = JsonMissing.of(),
            @JsonProperty("previous_response_id")
            @ExcludeMissing
            previousResponseId: JsonField<String> = JsonMissing.of(),
        ) : this(model, input, instructions, previousResponseId, mutableMapOf())

        /**
         * Model ID used to generate the response, like `gpt-5` or `o3`. OpenAI offers a wide range
         * of models with different capabilities, performance characteristics, and price points.
         * Refer to the [model guide](https://platform.openai.com/docs/models) to browse and compare
         * available models.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun model(): Optional<Model> = model.getOptional("model")

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
         * Returns the raw JSON value of [model].
         *
         * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<Model> = model

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
         * Returns the raw JSON value of [previousResponseId].
         *
         * Unlike [previousResponseId], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("previous_response_id")
        @ExcludeMissing
        fun _previousResponseId(): JsonField<String> = previousResponseId

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

            /**
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .model()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var model: JsonField<Model>? = null
            private var input: JsonField<Input> = JsonMissing.of()
            private var instructions: JsonField<String> = JsonMissing.of()
            private var previousResponseId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                model = body.model
                input = body.input
                instructions = body.instructions
                previousResponseId = body.previousResponseId
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * Model ID used to generate the response, like `gpt-5` or `o3`. OpenAI offers a wide
             * range of models with different capabilities, performance characteristics, and price
             * points. Refer to the [model guide](https://platform.openai.com/docs/models) to browse
             * and compare available models.
             */
            fun model(model: Model?) = model(JsonField.ofNullable(model))

            /** Alias for calling [Builder.model] with `model.orElse(null)`. */
            fun model(model: Optional<Model>) = model(model.getOrNull())

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
             *
             * The following fields are required:
             * ```java
             * .model()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("model", model),
                    input,
                    instructions,
                    previousResponseId,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            model()
            input().ifPresent { it.validate() }
            instructions()
            previousResponseId()
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
            (if (model.asKnown().isPresent) 1 else 0) +
                (input.asKnown().getOrNull()?.validity() ?: 0) +
                (if (instructions.asKnown().isPresent) 1 else 0) +
                (if (previousResponseId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                model == other.model &&
                input == other.input &&
                instructions == other.instructions &&
                previousResponseId == other.previousResponseId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(model, input, instructions, previousResponseId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{model=$model, input=$input, instructions=$instructions, previousResponseId=$previousResponseId, additionalProperties=$additionalProperties}"
    }

    /**
     * Model ID used to generate the response, like `gpt-5` or `o3`. OpenAI offers a wide range of
     * models with different capabilities, performance characteristics, and price points. Refer to
     * the [model guide](https://platform.openai.com/docs/models) to browse and compare available
     * models.
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

            @JvmField val GPT_5_2 = of("gpt-5.2")

            @JvmField val GPT_5_2_2025_12_11 = of("gpt-5.2-2025-12-11")

            @JvmField val GPT_5_2_CHAT_LATEST = of("gpt-5.2-chat-latest")

            @JvmField val GPT_5_2_PRO = of("gpt-5.2-pro")

            @JvmField val GPT_5_2_PRO_2025_12_11 = of("gpt-5.2-pro-2025-12-11")

            @JvmField val GPT_5_1 = of("gpt-5.1")

            @JvmField val GPT_5_1_2025_11_13 = of("gpt-5.1-2025-11-13")

            @JvmField val GPT_5_1_CODEX = of("gpt-5.1-codex")

            @JvmField val GPT_5_1_MINI = of("gpt-5.1-mini")

            @JvmField val GPT_5_1_CHAT_LATEST = of("gpt-5.1-chat-latest")

            @JvmField val GPT_5 = of("gpt-5")

            @JvmField val GPT_5_MINI = of("gpt-5-mini")

            @JvmField val GPT_5_NANO = of("gpt-5-nano")

            @JvmField val GPT_5_2025_08_07 = of("gpt-5-2025-08-07")

            @JvmField val GPT_5_MINI_2025_08_07 = of("gpt-5-mini-2025-08-07")

            @JvmField val GPT_5_NANO_2025_08_07 = of("gpt-5-nano-2025-08-07")

            @JvmField val GPT_5_CHAT_LATEST = of("gpt-5-chat-latest")

            @JvmField val GPT_4_1 = of("gpt-4.1")

            @JvmField val GPT_4_1_MINI = of("gpt-4.1-mini")

            @JvmField val GPT_4_1_NANO = of("gpt-4.1-nano")

            @JvmField val GPT_4_1_2025_04_14 = of("gpt-4.1-2025-04-14")

            @JvmField val GPT_4_1_MINI_2025_04_14 = of("gpt-4.1-mini-2025-04-14")

            @JvmField val GPT_4_1_NANO_2025_04_14 = of("gpt-4.1-nano-2025-04-14")

            @JvmField val O4_MINI = of("o4-mini")

            @JvmField val O4_MINI_2025_04_16 = of("o4-mini-2025-04-16")

            @JvmField val O3 = of("o3")

            @JvmField val O3_2025_04_16 = of("o3-2025-04-16")

            @JvmField val O3_MINI = of("o3-mini")

            @JvmField val O3_MINI_2025_01_31 = of("o3-mini-2025-01-31")

            @JvmField val O1 = of("o1")

            @JvmField val O1_2024_12_17 = of("o1-2024-12-17")

            @JvmField val O1_PREVIEW = of("o1-preview")

            @JvmField val O1_PREVIEW_2024_09_12 = of("o1-preview-2024-09-12")

            @JvmField val O1_MINI = of("o1-mini")

            @JvmField val O1_MINI_2024_09_12 = of("o1-mini-2024-09-12")

            @JvmField val GPT_4O = of("gpt-4o")

            @JvmField val GPT_4O_2024_11_20 = of("gpt-4o-2024-11-20")

            @JvmField val GPT_4O_2024_08_06 = of("gpt-4o-2024-08-06")

            @JvmField val GPT_4O_2024_05_13 = of("gpt-4o-2024-05-13")

            @JvmField val GPT_4O_AUDIO_PREVIEW = of("gpt-4o-audio-preview")

            @JvmField val GPT_4O_AUDIO_PREVIEW_2024_10_01 = of("gpt-4o-audio-preview-2024-10-01")

            @JvmField val GPT_4O_AUDIO_PREVIEW_2024_12_17 = of("gpt-4o-audio-preview-2024-12-17")

            @JvmField val GPT_4O_AUDIO_PREVIEW_2025_06_03 = of("gpt-4o-audio-preview-2025-06-03")

            @JvmField val GPT_4O_MINI_AUDIO_PREVIEW = of("gpt-4o-mini-audio-preview")

            @JvmField
            val GPT_4O_MINI_AUDIO_PREVIEW_2024_12_17 = of("gpt-4o-mini-audio-preview-2024-12-17")

            @JvmField val GPT_4O_SEARCH_PREVIEW = of("gpt-4o-search-preview")

            @JvmField val GPT_4O_MINI_SEARCH_PREVIEW = of("gpt-4o-mini-search-preview")

            @JvmField val GPT_4O_SEARCH_PREVIEW_2025_03_11 = of("gpt-4o-search-preview-2025-03-11")

            @JvmField
            val GPT_4O_MINI_SEARCH_PREVIEW_2025_03_11 = of("gpt-4o-mini-search-preview-2025-03-11")

            @JvmField val CHATGPT_4O_LATEST = of("chatgpt-4o-latest")

            @JvmField val CODEX_MINI_LATEST = of("codex-mini-latest")

            @JvmField val GPT_4O_MINI = of("gpt-4o-mini")

            @JvmField val GPT_4O_MINI_2024_07_18 = of("gpt-4o-mini-2024-07-18")

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

            @JvmField val GPT_3_5_TURBO_0301 = of("gpt-3.5-turbo-0301")

            @JvmField val GPT_3_5_TURBO_0613 = of("gpt-3.5-turbo-0613")

            @JvmField val GPT_3_5_TURBO_1106 = of("gpt-3.5-turbo-1106")

            @JvmField val GPT_3_5_TURBO_0125 = of("gpt-3.5-turbo-0125")

            @JvmField val GPT_3_5_TURBO_16K_0613 = of("gpt-3.5-turbo-16k-0613")

            @JvmField val O1_PRO = of("o1-pro")

            @JvmField val O1_PRO_2025_03_19 = of("o1-pro-2025-03-19")

            @JvmField val O3_PRO = of("o3-pro")

            @JvmField val O3_PRO_2025_06_10 = of("o3-pro-2025-06-10")

            @JvmField val O3_DEEP_RESEARCH = of("o3-deep-research")

            @JvmField val O3_DEEP_RESEARCH_2025_06_26 = of("o3-deep-research-2025-06-26")

            @JvmField val O4_MINI_DEEP_RESEARCH = of("o4-mini-deep-research")

            @JvmField val O4_MINI_DEEP_RESEARCH_2025_06_26 = of("o4-mini-deep-research-2025-06-26")

            @JvmField val COMPUTER_USE_PREVIEW = of("computer-use-preview")

            @JvmField val COMPUTER_USE_PREVIEW_2025_03_11 = of("computer-use-preview-2025-03-11")

            @JvmField val GPT_5_CODEX = of("gpt-5-codex")

            @JvmField val GPT_5_PRO = of("gpt-5-pro")

            @JvmField val GPT_5_PRO_2025_10_06 = of("gpt-5-pro-2025-10-06")

            @JvmField val GPT_5_1_CODEX_MAX = of("gpt-5.1-codex-max")

            @JvmStatic fun of(value: String) = Model(JsonField.of(value))
        }

        /** An enum containing [Model]'s known values. */
        enum class Known {
            GPT_5_2,
            GPT_5_2_2025_12_11,
            GPT_5_2_CHAT_LATEST,
            GPT_5_2_PRO,
            GPT_5_2_PRO_2025_12_11,
            GPT_5_1,
            GPT_5_1_2025_11_13,
            GPT_5_1_CODEX,
            GPT_5_1_MINI,
            GPT_5_1_CHAT_LATEST,
            GPT_5,
            GPT_5_MINI,
            GPT_5_NANO,
            GPT_5_2025_08_07,
            GPT_5_MINI_2025_08_07,
            GPT_5_NANO_2025_08_07,
            GPT_5_CHAT_LATEST,
            GPT_4_1,
            GPT_4_1_MINI,
            GPT_4_1_NANO,
            GPT_4_1_2025_04_14,
            GPT_4_1_MINI_2025_04_14,
            GPT_4_1_NANO_2025_04_14,
            O4_MINI,
            O4_MINI_2025_04_16,
            O3,
            O3_2025_04_16,
            O3_MINI,
            O3_MINI_2025_01_31,
            O1,
            O1_2024_12_17,
            O1_PREVIEW,
            O1_PREVIEW_2024_09_12,
            O1_MINI,
            O1_MINI_2024_09_12,
            GPT_4O,
            GPT_4O_2024_11_20,
            GPT_4O_2024_08_06,
            GPT_4O_2024_05_13,
            GPT_4O_AUDIO_PREVIEW,
            GPT_4O_AUDIO_PREVIEW_2024_10_01,
            GPT_4O_AUDIO_PREVIEW_2024_12_17,
            GPT_4O_AUDIO_PREVIEW_2025_06_03,
            GPT_4O_MINI_AUDIO_PREVIEW,
            GPT_4O_MINI_AUDIO_PREVIEW_2024_12_17,
            GPT_4O_SEARCH_PREVIEW,
            GPT_4O_MINI_SEARCH_PREVIEW,
            GPT_4O_SEARCH_PREVIEW_2025_03_11,
            GPT_4O_MINI_SEARCH_PREVIEW_2025_03_11,
            CHATGPT_4O_LATEST,
            CODEX_MINI_LATEST,
            GPT_4O_MINI,
            GPT_4O_MINI_2024_07_18,
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
            GPT_3_5_TURBO_0301,
            GPT_3_5_TURBO_0613,
            GPT_3_5_TURBO_1106,
            GPT_3_5_TURBO_0125,
            GPT_3_5_TURBO_16K_0613,
            O1_PRO,
            O1_PRO_2025_03_19,
            O3_PRO,
            O3_PRO_2025_06_10,
            O3_DEEP_RESEARCH,
            O3_DEEP_RESEARCH_2025_06_26,
            O4_MINI_DEEP_RESEARCH,
            O4_MINI_DEEP_RESEARCH_2025_06_26,
            COMPUTER_USE_PREVIEW,
            COMPUTER_USE_PREVIEW_2025_03_11,
            GPT_5_CODEX,
            GPT_5_PRO,
            GPT_5_PRO_2025_10_06,
            GPT_5_1_CODEX_MAX,
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
            GPT_5_2,
            GPT_5_2_2025_12_11,
            GPT_5_2_CHAT_LATEST,
            GPT_5_2_PRO,
            GPT_5_2_PRO_2025_12_11,
            GPT_5_1,
            GPT_5_1_2025_11_13,
            GPT_5_1_CODEX,
            GPT_5_1_MINI,
            GPT_5_1_CHAT_LATEST,
            GPT_5,
            GPT_5_MINI,
            GPT_5_NANO,
            GPT_5_2025_08_07,
            GPT_5_MINI_2025_08_07,
            GPT_5_NANO_2025_08_07,
            GPT_5_CHAT_LATEST,
            GPT_4_1,
            GPT_4_1_MINI,
            GPT_4_1_NANO,
            GPT_4_1_2025_04_14,
            GPT_4_1_MINI_2025_04_14,
            GPT_4_1_NANO_2025_04_14,
            O4_MINI,
            O4_MINI_2025_04_16,
            O3,
            O3_2025_04_16,
            O3_MINI,
            O3_MINI_2025_01_31,
            O1,
            O1_2024_12_17,
            O1_PREVIEW,
            O1_PREVIEW_2024_09_12,
            O1_MINI,
            O1_MINI_2024_09_12,
            GPT_4O,
            GPT_4O_2024_11_20,
            GPT_4O_2024_08_06,
            GPT_4O_2024_05_13,
            GPT_4O_AUDIO_PREVIEW,
            GPT_4O_AUDIO_PREVIEW_2024_10_01,
            GPT_4O_AUDIO_PREVIEW_2024_12_17,
            GPT_4O_AUDIO_PREVIEW_2025_06_03,
            GPT_4O_MINI_AUDIO_PREVIEW,
            GPT_4O_MINI_AUDIO_PREVIEW_2024_12_17,
            GPT_4O_SEARCH_PREVIEW,
            GPT_4O_MINI_SEARCH_PREVIEW,
            GPT_4O_SEARCH_PREVIEW_2025_03_11,
            GPT_4O_MINI_SEARCH_PREVIEW_2025_03_11,
            CHATGPT_4O_LATEST,
            CODEX_MINI_LATEST,
            GPT_4O_MINI,
            GPT_4O_MINI_2024_07_18,
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
            GPT_3_5_TURBO_0301,
            GPT_3_5_TURBO_0613,
            GPT_3_5_TURBO_1106,
            GPT_3_5_TURBO_0125,
            GPT_3_5_TURBO_16K_0613,
            O1_PRO,
            O1_PRO_2025_03_19,
            O3_PRO,
            O3_PRO_2025_06_10,
            O3_DEEP_RESEARCH,
            O3_DEEP_RESEARCH_2025_06_26,
            O4_MINI_DEEP_RESEARCH,
            O4_MINI_DEEP_RESEARCH_2025_06_26,
            COMPUTER_USE_PREVIEW,
            COMPUTER_USE_PREVIEW_2025_03_11,
            GPT_5_CODEX,
            GPT_5_PRO,
            GPT_5_PRO_2025_10_06,
            GPT_5_1_CODEX_MAX,
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
                GPT_5_2 -> Value.GPT_5_2
                GPT_5_2_2025_12_11 -> Value.GPT_5_2_2025_12_11
                GPT_5_2_CHAT_LATEST -> Value.GPT_5_2_CHAT_LATEST
                GPT_5_2_PRO -> Value.GPT_5_2_PRO
                GPT_5_2_PRO_2025_12_11 -> Value.GPT_5_2_PRO_2025_12_11
                GPT_5_1 -> Value.GPT_5_1
                GPT_5_1_2025_11_13 -> Value.GPT_5_1_2025_11_13
                GPT_5_1_CODEX -> Value.GPT_5_1_CODEX
                GPT_5_1_MINI -> Value.GPT_5_1_MINI
                GPT_5_1_CHAT_LATEST -> Value.GPT_5_1_CHAT_LATEST
                GPT_5 -> Value.GPT_5
                GPT_5_MINI -> Value.GPT_5_MINI
                GPT_5_NANO -> Value.GPT_5_NANO
                GPT_5_2025_08_07 -> Value.GPT_5_2025_08_07
                GPT_5_MINI_2025_08_07 -> Value.GPT_5_MINI_2025_08_07
                GPT_5_NANO_2025_08_07 -> Value.GPT_5_NANO_2025_08_07
                GPT_5_CHAT_LATEST -> Value.GPT_5_CHAT_LATEST
                GPT_4_1 -> Value.GPT_4_1
                GPT_4_1_MINI -> Value.GPT_4_1_MINI
                GPT_4_1_NANO -> Value.GPT_4_1_NANO
                GPT_4_1_2025_04_14 -> Value.GPT_4_1_2025_04_14
                GPT_4_1_MINI_2025_04_14 -> Value.GPT_4_1_MINI_2025_04_14
                GPT_4_1_NANO_2025_04_14 -> Value.GPT_4_1_NANO_2025_04_14
                O4_MINI -> Value.O4_MINI
                O4_MINI_2025_04_16 -> Value.O4_MINI_2025_04_16
                O3 -> Value.O3
                O3_2025_04_16 -> Value.O3_2025_04_16
                O3_MINI -> Value.O3_MINI
                O3_MINI_2025_01_31 -> Value.O3_MINI_2025_01_31
                O1 -> Value.O1
                O1_2024_12_17 -> Value.O1_2024_12_17
                O1_PREVIEW -> Value.O1_PREVIEW
                O1_PREVIEW_2024_09_12 -> Value.O1_PREVIEW_2024_09_12
                O1_MINI -> Value.O1_MINI
                O1_MINI_2024_09_12 -> Value.O1_MINI_2024_09_12
                GPT_4O -> Value.GPT_4O
                GPT_4O_2024_11_20 -> Value.GPT_4O_2024_11_20
                GPT_4O_2024_08_06 -> Value.GPT_4O_2024_08_06
                GPT_4O_2024_05_13 -> Value.GPT_4O_2024_05_13
                GPT_4O_AUDIO_PREVIEW -> Value.GPT_4O_AUDIO_PREVIEW
                GPT_4O_AUDIO_PREVIEW_2024_10_01 -> Value.GPT_4O_AUDIO_PREVIEW_2024_10_01
                GPT_4O_AUDIO_PREVIEW_2024_12_17 -> Value.GPT_4O_AUDIO_PREVIEW_2024_12_17
                GPT_4O_AUDIO_PREVIEW_2025_06_03 -> Value.GPT_4O_AUDIO_PREVIEW_2025_06_03
                GPT_4O_MINI_AUDIO_PREVIEW -> Value.GPT_4O_MINI_AUDIO_PREVIEW
                GPT_4O_MINI_AUDIO_PREVIEW_2024_12_17 -> Value.GPT_4O_MINI_AUDIO_PREVIEW_2024_12_17
                GPT_4O_SEARCH_PREVIEW -> Value.GPT_4O_SEARCH_PREVIEW
                GPT_4O_MINI_SEARCH_PREVIEW -> Value.GPT_4O_MINI_SEARCH_PREVIEW
                GPT_4O_SEARCH_PREVIEW_2025_03_11 -> Value.GPT_4O_SEARCH_PREVIEW_2025_03_11
                GPT_4O_MINI_SEARCH_PREVIEW_2025_03_11 -> Value.GPT_4O_MINI_SEARCH_PREVIEW_2025_03_11
                CHATGPT_4O_LATEST -> Value.CHATGPT_4O_LATEST
                CODEX_MINI_LATEST -> Value.CODEX_MINI_LATEST
                GPT_4O_MINI -> Value.GPT_4O_MINI
                GPT_4O_MINI_2024_07_18 -> Value.GPT_4O_MINI_2024_07_18
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
                GPT_3_5_TURBO_0301 -> Value.GPT_3_5_TURBO_0301
                GPT_3_5_TURBO_0613 -> Value.GPT_3_5_TURBO_0613
                GPT_3_5_TURBO_1106 -> Value.GPT_3_5_TURBO_1106
                GPT_3_5_TURBO_0125 -> Value.GPT_3_5_TURBO_0125
                GPT_3_5_TURBO_16K_0613 -> Value.GPT_3_5_TURBO_16K_0613
                O1_PRO -> Value.O1_PRO
                O1_PRO_2025_03_19 -> Value.O1_PRO_2025_03_19
                O3_PRO -> Value.O3_PRO
                O3_PRO_2025_06_10 -> Value.O3_PRO_2025_06_10
                O3_DEEP_RESEARCH -> Value.O3_DEEP_RESEARCH
                O3_DEEP_RESEARCH_2025_06_26 -> Value.O3_DEEP_RESEARCH_2025_06_26
                O4_MINI_DEEP_RESEARCH -> Value.O4_MINI_DEEP_RESEARCH
                O4_MINI_DEEP_RESEARCH_2025_06_26 -> Value.O4_MINI_DEEP_RESEARCH_2025_06_26
                COMPUTER_USE_PREVIEW -> Value.COMPUTER_USE_PREVIEW
                COMPUTER_USE_PREVIEW_2025_03_11 -> Value.COMPUTER_USE_PREVIEW_2025_03_11
                GPT_5_CODEX -> Value.GPT_5_CODEX
                GPT_5_PRO -> Value.GPT_5_PRO
                GPT_5_PRO_2025_10_06 -> Value.GPT_5_PRO_2025_10_06
                GPT_5_1_CODEX_MAX -> Value.GPT_5_1_CODEX_MAX
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
                GPT_5_2 -> Known.GPT_5_2
                GPT_5_2_2025_12_11 -> Known.GPT_5_2_2025_12_11
                GPT_5_2_CHAT_LATEST -> Known.GPT_5_2_CHAT_LATEST
                GPT_5_2_PRO -> Known.GPT_5_2_PRO
                GPT_5_2_PRO_2025_12_11 -> Known.GPT_5_2_PRO_2025_12_11
                GPT_5_1 -> Known.GPT_5_1
                GPT_5_1_2025_11_13 -> Known.GPT_5_1_2025_11_13
                GPT_5_1_CODEX -> Known.GPT_5_1_CODEX
                GPT_5_1_MINI -> Known.GPT_5_1_MINI
                GPT_5_1_CHAT_LATEST -> Known.GPT_5_1_CHAT_LATEST
                GPT_5 -> Known.GPT_5
                GPT_5_MINI -> Known.GPT_5_MINI
                GPT_5_NANO -> Known.GPT_5_NANO
                GPT_5_2025_08_07 -> Known.GPT_5_2025_08_07
                GPT_5_MINI_2025_08_07 -> Known.GPT_5_MINI_2025_08_07
                GPT_5_NANO_2025_08_07 -> Known.GPT_5_NANO_2025_08_07
                GPT_5_CHAT_LATEST -> Known.GPT_5_CHAT_LATEST
                GPT_4_1 -> Known.GPT_4_1
                GPT_4_1_MINI -> Known.GPT_4_1_MINI
                GPT_4_1_NANO -> Known.GPT_4_1_NANO
                GPT_4_1_2025_04_14 -> Known.GPT_4_1_2025_04_14
                GPT_4_1_MINI_2025_04_14 -> Known.GPT_4_1_MINI_2025_04_14
                GPT_4_1_NANO_2025_04_14 -> Known.GPT_4_1_NANO_2025_04_14
                O4_MINI -> Known.O4_MINI
                O4_MINI_2025_04_16 -> Known.O4_MINI_2025_04_16
                O3 -> Known.O3
                O3_2025_04_16 -> Known.O3_2025_04_16
                O3_MINI -> Known.O3_MINI
                O3_MINI_2025_01_31 -> Known.O3_MINI_2025_01_31
                O1 -> Known.O1
                O1_2024_12_17 -> Known.O1_2024_12_17
                O1_PREVIEW -> Known.O1_PREVIEW
                O1_PREVIEW_2024_09_12 -> Known.O1_PREVIEW_2024_09_12
                O1_MINI -> Known.O1_MINI
                O1_MINI_2024_09_12 -> Known.O1_MINI_2024_09_12
                GPT_4O -> Known.GPT_4O
                GPT_4O_2024_11_20 -> Known.GPT_4O_2024_11_20
                GPT_4O_2024_08_06 -> Known.GPT_4O_2024_08_06
                GPT_4O_2024_05_13 -> Known.GPT_4O_2024_05_13
                GPT_4O_AUDIO_PREVIEW -> Known.GPT_4O_AUDIO_PREVIEW
                GPT_4O_AUDIO_PREVIEW_2024_10_01 -> Known.GPT_4O_AUDIO_PREVIEW_2024_10_01
                GPT_4O_AUDIO_PREVIEW_2024_12_17 -> Known.GPT_4O_AUDIO_PREVIEW_2024_12_17
                GPT_4O_AUDIO_PREVIEW_2025_06_03 -> Known.GPT_4O_AUDIO_PREVIEW_2025_06_03
                GPT_4O_MINI_AUDIO_PREVIEW -> Known.GPT_4O_MINI_AUDIO_PREVIEW
                GPT_4O_MINI_AUDIO_PREVIEW_2024_12_17 -> Known.GPT_4O_MINI_AUDIO_PREVIEW_2024_12_17
                GPT_4O_SEARCH_PREVIEW -> Known.GPT_4O_SEARCH_PREVIEW
                GPT_4O_MINI_SEARCH_PREVIEW -> Known.GPT_4O_MINI_SEARCH_PREVIEW
                GPT_4O_SEARCH_PREVIEW_2025_03_11 -> Known.GPT_4O_SEARCH_PREVIEW_2025_03_11
                GPT_4O_MINI_SEARCH_PREVIEW_2025_03_11 -> Known.GPT_4O_MINI_SEARCH_PREVIEW_2025_03_11
                CHATGPT_4O_LATEST -> Known.CHATGPT_4O_LATEST
                CODEX_MINI_LATEST -> Known.CODEX_MINI_LATEST
                GPT_4O_MINI -> Known.GPT_4O_MINI
                GPT_4O_MINI_2024_07_18 -> Known.GPT_4O_MINI_2024_07_18
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
                GPT_3_5_TURBO_0301 -> Known.GPT_3_5_TURBO_0301
                GPT_3_5_TURBO_0613 -> Known.GPT_3_5_TURBO_0613
                GPT_3_5_TURBO_1106 -> Known.GPT_3_5_TURBO_1106
                GPT_3_5_TURBO_0125 -> Known.GPT_3_5_TURBO_0125
                GPT_3_5_TURBO_16K_0613 -> Known.GPT_3_5_TURBO_16K_0613
                O1_PRO -> Known.O1_PRO
                O1_PRO_2025_03_19 -> Known.O1_PRO_2025_03_19
                O3_PRO -> Known.O3_PRO
                O3_PRO_2025_06_10 -> Known.O3_PRO_2025_06_10
                O3_DEEP_RESEARCH -> Known.O3_DEEP_RESEARCH
                O3_DEEP_RESEARCH_2025_06_26 -> Known.O3_DEEP_RESEARCH_2025_06_26
                O4_MINI_DEEP_RESEARCH -> Known.O4_MINI_DEEP_RESEARCH
                O4_MINI_DEEP_RESEARCH_2025_06_26 -> Known.O4_MINI_DEEP_RESEARCH_2025_06_26
                COMPUTER_USE_PREVIEW -> Known.COMPUTER_USE_PREVIEW
                COMPUTER_USE_PREVIEW_2025_03_11 -> Known.COMPUTER_USE_PREVIEW_2025_03_11
                GPT_5_CODEX -> Known.GPT_5_CODEX
                GPT_5_PRO -> Known.GPT_5_PRO
                GPT_5_PRO_2025_10_06 -> Known.GPT_5_PRO_2025_10_06
                GPT_5_1_CODEX_MAX -> Known.GPT_5_1_CODEX_MAX
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

        private var validated: Boolean = false

        fun validate(): Model = apply {
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

            return other is Model && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ResponseCompactParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "ResponseCompactParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
