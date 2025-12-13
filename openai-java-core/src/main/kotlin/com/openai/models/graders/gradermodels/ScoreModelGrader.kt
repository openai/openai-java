// File generated from our OpenAPI spec by Stainless.

package com.openai.models.graders.gradermodels

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
import com.openai.core.allMaxBy
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.ReasoningEffort
import com.openai.models.responses.ResponseInputAudio
import com.openai.models.responses.ResponseInputText
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A ScoreModelGrader object that uses a model to assign a score to the input. */
class ScoreModelGrader
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val input: JsonField<List<Input>>,
    private val model: JsonField<String>,
    private val name: JsonField<String>,
    private val type: JsonValue,
    private val range: JsonField<List<Double>>,
    private val samplingParams: JsonField<SamplingParams>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("input") @ExcludeMissing input: JsonField<List<Input>> = JsonMissing.of(),
        @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("range") @ExcludeMissing range: JsonField<List<Double>> = JsonMissing.of(),
        @JsonProperty("sampling_params")
        @ExcludeMissing
        samplingParams: JsonField<SamplingParams> = JsonMissing.of(),
    ) : this(input, model, name, type, range, samplingParams, mutableMapOf())

    /**
     * The input messages evaluated by the grader. Supports text, output text, input image, and
     * input audio content blocks, and may include template strings.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun input(): List<Input> = input.getRequired("input")

    /**
     * The model to use for the evaluation.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun model(): String = model.getRequired("model")

    /**
     * The name of the grader.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = name.getRequired("name")

    /**
     * The object type, which is always `score_model`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("score_model")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * The range of the score. Defaults to `[0, 1]`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun range(): Optional<List<Double>> = range.getOptional("range")

    /**
     * The sampling parameters for the model.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun samplingParams(): Optional<SamplingParams> = samplingParams.getOptional("sampling_params")

    /**
     * Returns the raw JSON value of [input].
     *
     * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("input") @ExcludeMissing fun _input(): JsonField<List<Input>> = input

    /**
     * Returns the raw JSON value of [model].
     *
     * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [range].
     *
     * Unlike [range], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("range") @ExcludeMissing fun _range(): JsonField<List<Double>> = range

    /**
     * Returns the raw JSON value of [samplingParams].
     *
     * Unlike [samplingParams], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sampling_params")
    @ExcludeMissing
    fun _samplingParams(): JsonField<SamplingParams> = samplingParams

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
         * Returns a mutable builder for constructing an instance of [ScoreModelGrader].
         *
         * The following fields are required:
         * ```java
         * .input()
         * .model()
         * .name()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ScoreModelGrader]. */
    class Builder internal constructor() {

        private var input: JsonField<MutableList<Input>>? = null
        private var model: JsonField<String>? = null
        private var name: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("score_model")
        private var range: JsonField<MutableList<Double>>? = null
        private var samplingParams: JsonField<SamplingParams> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(scoreModelGrader: ScoreModelGrader) = apply {
            input = scoreModelGrader.input.map { it.toMutableList() }
            model = scoreModelGrader.model
            name = scoreModelGrader.name
            type = scoreModelGrader.type
            range = scoreModelGrader.range.map { it.toMutableList() }
            samplingParams = scoreModelGrader.samplingParams
            additionalProperties = scoreModelGrader.additionalProperties.toMutableMap()
        }

        /**
         * The input messages evaluated by the grader. Supports text, output text, input image, and
         * input audio content blocks, and may include template strings.
         */
        fun input(input: List<Input>) = input(JsonField.of(input))

        /**
         * Sets [Builder.input] to an arbitrary JSON value.
         *
         * You should usually call [Builder.input] with a well-typed `List<Input>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun input(input: JsonField<List<Input>>) = apply {
            this.input = input.map { it.toMutableList() }
        }

        /**
         * Adds a single [Input] to [Builder.input].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addInput(input: Input) = apply {
            this.input =
                (this.input ?: JsonField.of(mutableListOf())).also {
                    checkKnown("input", it).add(input)
                }
        }

        /** The model to use for the evaluation. */
        fun model(model: String) = model(JsonField.of(model))

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(model: JsonField<String>) = apply { this.model = model }

        /** The name of the grader. */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("score_model")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** The range of the score. Defaults to `[0, 1]`. */
        fun range(range: List<Double>) = range(JsonField.of(range))

        /**
         * Sets [Builder.range] to an arbitrary JSON value.
         *
         * You should usually call [Builder.range] with a well-typed `List<Double>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun range(range: JsonField<List<Double>>) = apply {
            this.range = range.map { it.toMutableList() }
        }

        /**
         * Adds a single [Double] to [Builder.range].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addRange(range: Double) = apply {
            this.range =
                (this.range ?: JsonField.of(mutableListOf())).also {
                    checkKnown("range", it).add(range)
                }
        }

        /** The sampling parameters for the model. */
        fun samplingParams(samplingParams: SamplingParams) =
            samplingParams(JsonField.of(samplingParams))

        /**
         * Sets [Builder.samplingParams] to an arbitrary JSON value.
         *
         * You should usually call [Builder.samplingParams] with a well-typed [SamplingParams] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun samplingParams(samplingParams: JsonField<SamplingParams>) = apply {
            this.samplingParams = samplingParams
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
         * Returns an immutable instance of [ScoreModelGrader].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .input()
         * .model()
         * .name()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ScoreModelGrader =
            ScoreModelGrader(
                checkRequired("input", input).map { it.toImmutable() },
                checkRequired("model", model),
                checkRequired("name", name),
                type,
                (range ?: JsonMissing.of()).map { it.toImmutable() },
                samplingParams,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ScoreModelGrader = apply {
        if (validated) {
            return@apply
        }

        input().forEach { it.validate() }
        model()
        name()
        _type().let {
            if (it != JsonValue.from("score_model")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        range()
        samplingParams().ifPresent { it.validate() }
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (input.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (model.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("score_model")) 1 else 0 } +
            (range.asKnown().getOrNull()?.size ?: 0) +
            (samplingParams.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * A message input to the model with a role indicating instruction following hierarchy.
     * Instructions given with the `developer` or `system` role take precedence over instructions
     * given with the `user` role. Messages with the `assistant` role are presumed to have been
     * generated by the model in previous interactions.
     */
    class Input
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val content: JsonField<Content>,
        private val role: JsonField<Role>,
        private val type: JsonField<Type>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("content") @ExcludeMissing content: JsonField<Content> = JsonMissing.of(),
            @JsonProperty("role") @ExcludeMissing role: JsonField<Role> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
        ) : this(content, role, type, mutableMapOf())

        /**
         * Inputs to the model - can contain template strings. Supports text, output text, input
         * images, and input audio, either as a single item or an array of items.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun content(): Content = content.getRequired("content")

        /**
         * The role of the message input. One of `user`, `assistant`, `system`, or `developer`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun role(): Role = role.getRequired("role")

        /**
         * The type of the message input. Always `message`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun type(): Optional<Type> = type.getOptional("type")

        /**
         * Returns the raw JSON value of [content].
         *
         * Unlike [content], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<Content> = content

        /**
         * Returns the raw JSON value of [role].
         *
         * Unlike [role], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<Role> = role

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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
             * Returns a mutable builder for constructing an instance of [Input].
             *
             * The following fields are required:
             * ```java
             * .content()
             * .role()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Input]. */
        class Builder internal constructor() {

            private var content: JsonField<Content>? = null
            private var role: JsonField<Role>? = null
            private var type: JsonField<Type> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(input: Input) = apply {
                content = input.content
                role = input.role
                type = input.type
                additionalProperties = input.additionalProperties.toMutableMap()
            }

            /**
             * Inputs to the model - can contain template strings. Supports text, output text, input
             * images, and input audio, either as a single item or an array of items.
             */
            fun content(content: Content) = content(JsonField.of(content))

            /**
             * Sets [Builder.content] to an arbitrary JSON value.
             *
             * You should usually call [Builder.content] with a well-typed [Content] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun content(content: JsonField<Content>) = apply { this.content = content }

            /** Alias for calling [content] with `Content.ofTextInput(textInput)`. */
            fun content(textInput: String) = content(Content.ofTextInput(textInput))

            /**
             * Alias for calling [content] with `Content.ofResponseInputText(responseInputText)`.
             */
            fun content(responseInputText: ResponseInputText) =
                content(Content.ofResponseInputText(responseInputText))

            /** Alias for calling [content] with `Content.ofOutputText(outputText)`. */
            fun content(outputText: Content.OutputText) = content(Content.ofOutputText(outputText))

            /**
             * Alias for calling [content] with `Content.ofEvalItemInputImage(evalItemInputImage)`.
             */
            fun content(evalItemInputImage: Content.EvalItemInputImage) =
                content(Content.ofEvalItemInputImage(evalItemInputImage))

            /**
             * Alias for calling [content] with `Content.ofResponseInputAudio(responseInputAudio)`.
             */
            fun content(responseInputAudio: ResponseInputAudio) =
                content(Content.ofResponseInputAudio(responseInputAudio))

            /**
             * Alias for calling [content] with
             * `Content.ofAnArrayOfInputTextOutputTextInputImageAndInputAudio(anArrayOfInputTextOutputTextInputImageAndInputAudio)`.
             */
            fun contentOfAnArrayOfInputTextOutputTextInputImageAndInputAudio(
                anArrayOfInputTextOutputTextInputImageAndInputAudio:
                    List<Content.UnnamedSchemaWithArrayParent1>
            ) =
                content(
                    Content.ofAnArrayOfInputTextOutputTextInputImageAndInputAudio(
                        anArrayOfInputTextOutputTextInputImageAndInputAudio
                    )
                )

            /**
             * The role of the message input. One of `user`, `assistant`, `system`, or `developer`.
             */
            fun role(role: Role) = role(JsonField.of(role))

            /**
             * Sets [Builder.role] to an arbitrary JSON value.
             *
             * You should usually call [Builder.role] with a well-typed [Role] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun role(role: JsonField<Role>) = apply { this.role = role }

            /** The type of the message input. Always `message`. */
            fun type(type: Type) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [Type] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<Type>) = apply { this.type = type }

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
             * Returns an immutable instance of [Input].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .content()
             * .role()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Input =
                Input(
                    checkRequired("content", content),
                    checkRequired("role", role),
                    type,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Input = apply {
            if (validated) {
                return@apply
            }

            content().validate()
            role().validate()
            type().ifPresent { it.validate() }
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
            (content.asKnown().getOrNull()?.validity() ?: 0) +
                (role.asKnown().getOrNull()?.validity() ?: 0) +
                (type.asKnown().getOrNull()?.validity() ?: 0)

        /**
         * Inputs to the model - can contain template strings. Supports text, output text, input
         * images, and input audio, either as a single item or an array of items.
         */
        @JsonDeserialize(using = Content.Deserializer::class)
        @JsonSerialize(using = Content.Serializer::class)
        class Content
        private constructor(
            private val textInput: String? = null,
            private val responseInputText: ResponseInputText? = null,
            private val outputText: OutputText? = null,
            private val evalItemInputImage: EvalItemInputImage? = null,
            private val responseInputAudio: ResponseInputAudio? = null,
            private val anArrayOfInputTextOutputTextInputImageAndInputAudio:
                List<UnnamedSchemaWithArrayParent1>? =
                null,
            private val _json: JsonValue? = null,
        ) {

            /** A text input to the model. */
            fun textInput(): Optional<String> = Optional.ofNullable(textInput)

            /** A text input to the model. */
            fun responseInputText(): Optional<ResponseInputText> =
                Optional.ofNullable(responseInputText)

            /** A text output from the model. */
            fun outputText(): Optional<OutputText> = Optional.ofNullable(outputText)

            /** An image input block used within EvalItem content arrays. */
            fun evalItemInputImage(): Optional<EvalItemInputImage> =
                Optional.ofNullable(evalItemInputImage)

            /** An audio input to the model. */
            fun responseInputAudio(): Optional<ResponseInputAudio> =
                Optional.ofNullable(responseInputAudio)

            /**
             * A list of inputs, each of which may be either an input text, output text, input
             * image, or input audio object.
             */
            fun anArrayOfInputTextOutputTextInputImageAndInputAudio():
                Optional<List<UnnamedSchemaWithArrayParent1>> =
                Optional.ofNullable(anArrayOfInputTextOutputTextInputImageAndInputAudio)

            fun isTextInput(): Boolean = textInput != null

            fun isResponseInputText(): Boolean = responseInputText != null

            fun isOutputText(): Boolean = outputText != null

            fun isEvalItemInputImage(): Boolean = evalItemInputImage != null

            fun isResponseInputAudio(): Boolean = responseInputAudio != null

            fun isAnArrayOfInputTextOutputTextInputImageAndInputAudio(): Boolean =
                anArrayOfInputTextOutputTextInputImageAndInputAudio != null

            /** A text input to the model. */
            fun asTextInput(): String = textInput.getOrThrow("textInput")

            /** A text input to the model. */
            fun asResponseInputText(): ResponseInputText =
                responseInputText.getOrThrow("responseInputText")

            /** A text output from the model. */
            fun asOutputText(): OutputText = outputText.getOrThrow("outputText")

            /** An image input block used within EvalItem content arrays. */
            fun asEvalItemInputImage(): EvalItemInputImage =
                evalItemInputImage.getOrThrow("evalItemInputImage")

            /** An audio input to the model. */
            fun asResponseInputAudio(): ResponseInputAudio =
                responseInputAudio.getOrThrow("responseInputAudio")

            /**
             * A list of inputs, each of which may be either an input text, output text, input
             * image, or input audio object.
             */
            fun asAnArrayOfInputTextOutputTextInputImageAndInputAudio():
                List<UnnamedSchemaWithArrayParent1> =
                anArrayOfInputTextOutputTextInputImageAndInputAudio.getOrThrow(
                    "anArrayOfInputTextOutputTextInputImageAndInputAudio"
                )

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    textInput != null -> visitor.visitTextInput(textInput)
                    responseInputText != null -> visitor.visitResponseInputText(responseInputText)
                    outputText != null -> visitor.visitOutputText(outputText)
                    evalItemInputImage != null ->
                        visitor.visitEvalItemInputImage(evalItemInputImage)
                    responseInputAudio != null ->
                        visitor.visitResponseInputAudio(responseInputAudio)
                    anArrayOfInputTextOutputTextInputImageAndInputAudio != null ->
                        visitor.visitAnArrayOfInputTextOutputTextInputImageAndInputAudio(
                            anArrayOfInputTextOutputTextInputImageAndInputAudio
                        )
                    else -> visitor.unknown(_json)
                }

            private var validated: Boolean = false

            fun validate(): Content = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitTextInput(textInput: String) {}

                        override fun visitResponseInputText(responseInputText: ResponseInputText) {
                            responseInputText.validate()
                        }

                        override fun visitOutputText(outputText: OutputText) {
                            outputText.validate()
                        }

                        override fun visitEvalItemInputImage(
                            evalItemInputImage: EvalItemInputImage
                        ) {
                            evalItemInputImage.validate()
                        }

                        override fun visitResponseInputAudio(
                            responseInputAudio: ResponseInputAudio
                        ) {
                            responseInputAudio.validate()
                        }

                        override fun visitAnArrayOfInputTextOutputTextInputImageAndInputAudio(
                            anArrayOfInputTextOutputTextInputImageAndInputAudio:
                                List<UnnamedSchemaWithArrayParent1>
                        ) {
                            anArrayOfInputTextOutputTextInputImageAndInputAudio.forEach {
                                it.validate()
                            }
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
                        override fun visitTextInput(textInput: String) = 1

                        override fun visitResponseInputText(responseInputText: ResponseInputText) =
                            responseInputText.validity()

                        override fun visitOutputText(outputText: OutputText) = outputText.validity()

                        override fun visitEvalItemInputImage(
                            evalItemInputImage: EvalItemInputImage
                        ) = evalItemInputImage.validity()

                        override fun visitResponseInputAudio(
                            responseInputAudio: ResponseInputAudio
                        ) = responseInputAudio.validity()

                        override fun visitAnArrayOfInputTextOutputTextInputImageAndInputAudio(
                            anArrayOfInputTextOutputTextInputImageAndInputAudio:
                                List<UnnamedSchemaWithArrayParent1>
                        ) =
                            anArrayOfInputTextOutputTextInputImageAndInputAudio.sumOf {
                                it.validity().toInt()
                            }

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Content &&
                    textInput == other.textInput &&
                    responseInputText == other.responseInputText &&
                    outputText == other.outputText &&
                    evalItemInputImage == other.evalItemInputImage &&
                    responseInputAudio == other.responseInputAudio &&
                    anArrayOfInputTextOutputTextInputImageAndInputAudio ==
                        other.anArrayOfInputTextOutputTextInputImageAndInputAudio
            }

            override fun hashCode(): Int =
                Objects.hash(
                    textInput,
                    responseInputText,
                    outputText,
                    evalItemInputImage,
                    responseInputAudio,
                    anArrayOfInputTextOutputTextInputImageAndInputAudio,
                )

            override fun toString(): String =
                when {
                    textInput != null -> "Content{textInput=$textInput}"
                    responseInputText != null -> "Content{responseInputText=$responseInputText}"
                    outputText != null -> "Content{outputText=$outputText}"
                    evalItemInputImage != null -> "Content{evalItemInputImage=$evalItemInputImage}"
                    responseInputAudio != null -> "Content{responseInputAudio=$responseInputAudio}"
                    anArrayOfInputTextOutputTextInputImageAndInputAudio != null ->
                        "Content{anArrayOfInputTextOutputTextInputImageAndInputAudio=$anArrayOfInputTextOutputTextInputImageAndInputAudio}"
                    _json != null -> "Content{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Content")
                }

            companion object {

                /** A text input to the model. */
                @JvmStatic fun ofTextInput(textInput: String) = Content(textInput = textInput)

                /** A text input to the model. */
                @JvmStatic
                fun ofResponseInputText(responseInputText: ResponseInputText) =
                    Content(responseInputText = responseInputText)

                /** A text output from the model. */
                @JvmStatic
                fun ofOutputText(outputText: OutputText) = Content(outputText = outputText)

                /** An image input block used within EvalItem content arrays. */
                @JvmStatic
                fun ofEvalItemInputImage(evalItemInputImage: EvalItemInputImage) =
                    Content(evalItemInputImage = evalItemInputImage)

                /** An audio input to the model. */
                @JvmStatic
                fun ofResponseInputAudio(responseInputAudio: ResponseInputAudio) =
                    Content(responseInputAudio = responseInputAudio)

                /**
                 * A list of inputs, each of which may be either an input text, output text, input
                 * image, or input audio object.
                 */
                @JvmStatic
                fun ofAnArrayOfInputTextOutputTextInputImageAndInputAudio(
                    anArrayOfInputTextOutputTextInputImageAndInputAudio:
                        List<UnnamedSchemaWithArrayParent1>
                ) =
                    Content(
                        anArrayOfInputTextOutputTextInputImageAndInputAudio =
                            anArrayOfInputTextOutputTextInputImageAndInputAudio.toImmutable()
                    )
            }

            /**
             * An interface that defines how to map each variant of [Content] to a value of type
             * [T].
             */
            interface Visitor<out T> {

                /** A text input to the model. */
                fun visitTextInput(textInput: String): T

                /** A text input to the model. */
                fun visitResponseInputText(responseInputText: ResponseInputText): T

                /** A text output from the model. */
                fun visitOutputText(outputText: OutputText): T

                /** An image input block used within EvalItem content arrays. */
                fun visitEvalItemInputImage(evalItemInputImage: EvalItemInputImage): T

                /** An audio input to the model. */
                fun visitResponseInputAudio(responseInputAudio: ResponseInputAudio): T

                /**
                 * A list of inputs, each of which may be either an input text, output text, input
                 * image, or input audio object.
                 */
                fun visitAnArrayOfInputTextOutputTextInputImageAndInputAudio(
                    anArrayOfInputTextOutputTextInputImageAndInputAudio:
                        List<UnnamedSchemaWithArrayParent1>
                ): T

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

                    val bestMatches =
                        sequenceOf(
                                tryDeserialize(node, jacksonTypeRef<ResponseInputText>())?.let {
                                    Content(responseInputText = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<OutputText>())?.let {
                                    Content(outputText = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<EvalItemInputImage>())?.let {
                                    Content(evalItemInputImage = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<ResponseInputAudio>())?.let {
                                    Content(responseInputAudio = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                    Content(textInput = it, _json = json)
                                },
                                tryDeserialize(
                                        node,
                                        jacksonTypeRef<List<UnnamedSchemaWithArrayParent1>>(),
                                    )
                                    ?.let {
                                        Content(
                                            anArrayOfInputTextOutputTextInputImageAndInputAudio =
                                                it,
                                            _json = json,
                                        )
                                    },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants.
                        0 -> Content(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
                        else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                    }
                }
            }

            internal class Serializer : BaseSerializer<Content>(Content::class) {

                override fun serialize(
                    value: Content,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.textInput != null -> generator.writeObject(value.textInput)
                        value.responseInputText != null ->
                            generator.writeObject(value.responseInputText)
                        value.outputText != null -> generator.writeObject(value.outputText)
                        value.evalItemInputImage != null ->
                            generator.writeObject(value.evalItemInputImage)
                        value.responseInputAudio != null ->
                            generator.writeObject(value.responseInputAudio)
                        value.anArrayOfInputTextOutputTextInputImageAndInputAudio != null ->
                            generator.writeObject(
                                value.anArrayOfInputTextOutputTextInputImageAndInputAudio
                            )
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Content")
                    }
                }
            }

            /** A text output from the model. */
            class OutputText
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val text: JsonField<String>,
                private val type: JsonValue,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("text")
                    @ExcludeMissing
                    text: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                ) : this(text, type, mutableMapOf())

                /**
                 * The text output from the model.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun text(): String = text.getRequired("text")

                /**
                 * The type of the output text. Always `output_text`.
                 *
                 * Expected to always return the following:
                 * ```java
                 * JsonValue.from("output_text")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                /**
                 * Returns the raw JSON value of [text].
                 *
                 * Unlike [text], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

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
                     * Returns a mutable builder for constructing an instance of [OutputText].
                     *
                     * The following fields are required:
                     * ```java
                     * .text()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [OutputText]. */
                class Builder internal constructor() {

                    private var text: JsonField<String>? = null
                    private var type: JsonValue = JsonValue.from("output_text")
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(outputText: OutputText) = apply {
                        text = outputText.text
                        type = outputText.type
                        additionalProperties = outputText.additionalProperties.toMutableMap()
                    }

                    /** The text output from the model. */
                    fun text(text: String) = text(JsonField.of(text))

                    /**
                     * Sets [Builder.text] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.text] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun text(text: JsonField<String>) = apply { this.text = text }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("output_text")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun type(type: JsonValue) = apply { this.type = type }

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

                    /**
                     * Returns an immutable instance of [OutputText].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .text()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): OutputText =
                        OutputText(
                            checkRequired("text", text),
                            type,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): OutputText = apply {
                    if (validated) {
                        return@apply
                    }

                    text()
                    _type().let {
                        if (it != JsonValue.from("output_text")) {
                            throw OpenAIInvalidDataException("'type' is invalid, received $it")
                        }
                    }
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
                    (if (text.asKnown().isPresent) 1 else 0) +
                        type.let { if (it == JsonValue.from("output_text")) 1 else 0 }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is OutputText &&
                        text == other.text &&
                        type == other.type &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(text, type, additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "OutputText{text=$text, type=$type, additionalProperties=$additionalProperties}"
            }

            /** An image input block used within EvalItem content arrays. */
            class EvalItemInputImage
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val imageUrl: JsonField<String>,
                private val type: JsonValue,
                private val detail: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("image_url")
                    @ExcludeMissing
                    imageUrl: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                    @JsonProperty("detail")
                    @ExcludeMissing
                    detail: JsonField<String> = JsonMissing.of(),
                ) : this(imageUrl, type, detail, mutableMapOf())

                /**
                 * The URL of the image input.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun imageUrl(): String = imageUrl.getRequired("image_url")

                /**
                 * The type of the image input. Always `input_image`.
                 *
                 * Expected to always return the following:
                 * ```java
                 * JsonValue.from("input_image")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                /**
                 * The detail level of the image to be sent to the model. One of `high`, `low`, or
                 * `auto`. Defaults to `auto`.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun detail(): Optional<String> = detail.getOptional("detail")

                /**
                 * Returns the raw JSON value of [imageUrl].
                 *
                 * Unlike [imageUrl], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("image_url")
                @ExcludeMissing
                fun _imageUrl(): JsonField<String> = imageUrl

                /**
                 * Returns the raw JSON value of [detail].
                 *
                 * Unlike [detail], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("detail") @ExcludeMissing fun _detail(): JsonField<String> = detail

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
                     * Returns a mutable builder for constructing an instance of
                     * [EvalItemInputImage].
                     *
                     * The following fields are required:
                     * ```java
                     * .imageUrl()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [EvalItemInputImage]. */
                class Builder internal constructor() {

                    private var imageUrl: JsonField<String>? = null
                    private var type: JsonValue = JsonValue.from("input_image")
                    private var detail: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(evalItemInputImage: EvalItemInputImage) = apply {
                        imageUrl = evalItemInputImage.imageUrl
                        type = evalItemInputImage.type
                        detail = evalItemInputImage.detail
                        additionalProperties =
                            evalItemInputImage.additionalProperties.toMutableMap()
                    }

                    /** The URL of the image input. */
                    fun imageUrl(imageUrl: String) = imageUrl(JsonField.of(imageUrl))

                    /**
                     * Sets [Builder.imageUrl] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.imageUrl] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun imageUrl(imageUrl: JsonField<String>) = apply { this.imageUrl = imageUrl }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("input_image")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun type(type: JsonValue) = apply { this.type = type }

                    /**
                     * The detail level of the image to be sent to the model. One of `high`, `low`,
                     * or `auto`. Defaults to `auto`.
                     */
                    fun detail(detail: String) = detail(JsonField.of(detail))

                    /**
                     * Sets [Builder.detail] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.detail] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun detail(detail: JsonField<String>) = apply { this.detail = detail }

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

                    /**
                     * Returns an immutable instance of [EvalItemInputImage].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .imageUrl()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): EvalItemInputImage =
                        EvalItemInputImage(
                            checkRequired("imageUrl", imageUrl),
                            type,
                            detail,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): EvalItemInputImage = apply {
                    if (validated) {
                        return@apply
                    }

                    imageUrl()
                    _type().let {
                        if (it != JsonValue.from("input_image")) {
                            throw OpenAIInvalidDataException("'type' is invalid, received $it")
                        }
                    }
                    detail()
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
                    (if (imageUrl.asKnown().isPresent) 1 else 0) +
                        type.let { if (it == JsonValue.from("input_image")) 1 else 0 } +
                        (if (detail.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is EvalItemInputImage &&
                        imageUrl == other.imageUrl &&
                        type == other.type &&
                        detail == other.detail &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(imageUrl, type, detail, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "EvalItemInputImage{imageUrl=$imageUrl, type=$type, detail=$detail, additionalProperties=$additionalProperties}"
            }

            /** A text input to the model. */
            @JsonDeserialize(using = UnnamedSchemaWithArrayParent1.Deserializer::class)
            @JsonSerialize(using = UnnamedSchemaWithArrayParent1.Serializer::class)
            class UnnamedSchemaWithArrayParent1
            private constructor(
                private val textInput: String? = null,
                private val responseInputText: ResponseInputText? = null,
                private val outputText: OutputText? = null,
                private val evalItemInputImage: EvalItemInputImage? = null,
                private val responseInputAudio: ResponseInputAudio? = null,
                private val _json: JsonValue? = null,
            ) {

                /** A text input to the model. */
                fun textInput(): Optional<String> = Optional.ofNullable(textInput)

                /** A text input to the model. */
                fun responseInputText(): Optional<ResponseInputText> =
                    Optional.ofNullable(responseInputText)

                /** A text output from the model. */
                fun outputText(): Optional<OutputText> = Optional.ofNullable(outputText)

                /** An image input block used within EvalItem content arrays. */
                fun evalItemInputImage(): Optional<EvalItemInputImage> =
                    Optional.ofNullable(evalItemInputImage)

                /** An audio input to the model. */
                fun responseInputAudio(): Optional<ResponseInputAudio> =
                    Optional.ofNullable(responseInputAudio)

                fun isTextInput(): Boolean = textInput != null

                fun isResponseInputText(): Boolean = responseInputText != null

                fun isOutputText(): Boolean = outputText != null

                fun isEvalItemInputImage(): Boolean = evalItemInputImage != null

                fun isResponseInputAudio(): Boolean = responseInputAudio != null

                /** A text input to the model. */
                fun asTextInput(): String = textInput.getOrThrow("textInput")

                /** A text input to the model. */
                fun asResponseInputText(): ResponseInputText =
                    responseInputText.getOrThrow("responseInputText")

                /** A text output from the model. */
                fun asOutputText(): OutputText = outputText.getOrThrow("outputText")

                /** An image input block used within EvalItem content arrays. */
                fun asEvalItemInputImage(): EvalItemInputImage =
                    evalItemInputImage.getOrThrow("evalItemInputImage")

                /** An audio input to the model. */
                fun asResponseInputAudio(): ResponseInputAudio =
                    responseInputAudio.getOrThrow("responseInputAudio")

                fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                fun <T> accept(visitor: Visitor<T>): T =
                    when {
                        textInput != null -> visitor.visitTextInput(textInput)
                        responseInputText != null ->
                            visitor.visitResponseInputText(responseInputText)
                        outputText != null -> visitor.visitOutputText(outputText)
                        evalItemInputImage != null ->
                            visitor.visitEvalItemInputImage(evalItemInputImage)
                        responseInputAudio != null ->
                            visitor.visitResponseInputAudio(responseInputAudio)
                        else -> visitor.unknown(_json)
                    }

                private var validated: Boolean = false

                fun validate(): UnnamedSchemaWithArrayParent1 = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitTextInput(textInput: String) {}

                            override fun visitResponseInputText(
                                responseInputText: ResponseInputText
                            ) {
                                responseInputText.validate()
                            }

                            override fun visitOutputText(outputText: OutputText) {
                                outputText.validate()
                            }

                            override fun visitEvalItemInputImage(
                                evalItemInputImage: EvalItemInputImage
                            ) {
                                evalItemInputImage.validate()
                            }

                            override fun visitResponseInputAudio(
                                responseInputAudio: ResponseInputAudio
                            ) {
                                responseInputAudio.validate()
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
                            override fun visitTextInput(textInput: String) = 1

                            override fun visitResponseInputText(
                                responseInputText: ResponseInputText
                            ) = responseInputText.validity()

                            override fun visitOutputText(outputText: OutputText) =
                                outputText.validity()

                            override fun visitEvalItemInputImage(
                                evalItemInputImage: EvalItemInputImage
                            ) = evalItemInputImage.validity()

                            override fun visitResponseInputAudio(
                                responseInputAudio: ResponseInputAudio
                            ) = responseInputAudio.validity()

                            override fun unknown(json: JsonValue?) = 0
                        }
                    )

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is UnnamedSchemaWithArrayParent1 &&
                        textInput == other.textInput &&
                        responseInputText == other.responseInputText &&
                        outputText == other.outputText &&
                        evalItemInputImage == other.evalItemInputImage &&
                        responseInputAudio == other.responseInputAudio
                }

                override fun hashCode(): Int =
                    Objects.hash(
                        textInput,
                        responseInputText,
                        outputText,
                        evalItemInputImage,
                        responseInputAudio,
                    )

                override fun toString(): String =
                    when {
                        textInput != null -> "UnnamedSchemaWithArrayParent1{textInput=$textInput}"
                        responseInputText != null ->
                            "UnnamedSchemaWithArrayParent1{responseInputText=$responseInputText}"
                        outputText != null ->
                            "UnnamedSchemaWithArrayParent1{outputText=$outputText}"
                        evalItemInputImage != null ->
                            "UnnamedSchemaWithArrayParent1{evalItemInputImage=$evalItemInputImage}"
                        responseInputAudio != null ->
                            "UnnamedSchemaWithArrayParent1{responseInputAudio=$responseInputAudio}"
                        _json != null -> "UnnamedSchemaWithArrayParent1{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid UnnamedSchemaWithArrayParent1")
                    }

                companion object {

                    /** A text input to the model. */
                    @JvmStatic
                    fun ofTextInput(textInput: String) =
                        UnnamedSchemaWithArrayParent1(textInput = textInput)

                    /** A text input to the model. */
                    @JvmStatic
                    fun ofResponseInputText(responseInputText: ResponseInputText) =
                        UnnamedSchemaWithArrayParent1(responseInputText = responseInputText)

                    /** A text output from the model. */
                    @JvmStatic
                    fun ofOutputText(outputText: OutputText) =
                        UnnamedSchemaWithArrayParent1(outputText = outputText)

                    /** An image input block used within EvalItem content arrays. */
                    @JvmStatic
                    fun ofEvalItemInputImage(evalItemInputImage: EvalItemInputImage) =
                        UnnamedSchemaWithArrayParent1(evalItemInputImage = evalItemInputImage)

                    /** An audio input to the model. */
                    @JvmStatic
                    fun ofResponseInputAudio(responseInputAudio: ResponseInputAudio) =
                        UnnamedSchemaWithArrayParent1(responseInputAudio = responseInputAudio)
                }

                /**
                 * An interface that defines how to map each variant of
                 * [UnnamedSchemaWithArrayParent1] to a value of type [T].
                 */
                interface Visitor<out T> {

                    /** A text input to the model. */
                    fun visitTextInput(textInput: String): T

                    /** A text input to the model. */
                    fun visitResponseInputText(responseInputText: ResponseInputText): T

                    /** A text output from the model. */
                    fun visitOutputText(outputText: OutputText): T

                    /** An image input block used within EvalItem content arrays. */
                    fun visitEvalItemInputImage(evalItemInputImage: EvalItemInputImage): T

                    /** An audio input to the model. */
                    fun visitResponseInputAudio(responseInputAudio: ResponseInputAudio): T

                    /**
                     * Maps an unknown variant of [UnnamedSchemaWithArrayParent1] to a value of type
                     * [T].
                     *
                     * An instance of [UnnamedSchemaWithArrayParent1] can contain an unknown variant
                     * if it was deserialized from data that doesn't match any known variant. For
                     * example, if the SDK is on an older version than the API, then the API may
                     * respond with new variants that the SDK is unaware of.
                     *
                     * @throws OpenAIInvalidDataException in the default implementation.
                     */
                    fun unknown(json: JsonValue?): T {
                        throw OpenAIInvalidDataException(
                            "Unknown UnnamedSchemaWithArrayParent1: $json"
                        )
                    }
                }

                internal class Deserializer :
                    BaseDeserializer<UnnamedSchemaWithArrayParent1>(
                        UnnamedSchemaWithArrayParent1::class
                    ) {

                    override fun ObjectCodec.deserialize(
                        node: JsonNode
                    ): UnnamedSchemaWithArrayParent1 {
                        val json = JsonValue.fromJsonNode(node)

                        val bestMatches =
                            sequenceOf(
                                    tryDeserialize(node, jacksonTypeRef<ResponseInputText>())?.let {
                                        UnnamedSchemaWithArrayParent1(
                                            responseInputText = it,
                                            _json = json,
                                        )
                                    },
                                    tryDeserialize(node, jacksonTypeRef<OutputText>())?.let {
                                        UnnamedSchemaWithArrayParent1(outputText = it, _json = json)
                                    },
                                    tryDeserialize(node, jacksonTypeRef<EvalItemInputImage>())
                                        ?.let {
                                            UnnamedSchemaWithArrayParent1(
                                                evalItemInputImage = it,
                                                _json = json,
                                            )
                                        },
                                    tryDeserialize(node, jacksonTypeRef<ResponseInputAudio>())
                                        ?.let {
                                            UnnamedSchemaWithArrayParent1(
                                                responseInputAudio = it,
                                                _json = json,
                                            )
                                        },
                                    tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                        UnnamedSchemaWithArrayParent1(textInput = it, _json = json)
                                    },
                                )
                                .filterNotNull()
                                .allMaxBy { it.validity() }
                                .toList()
                        return when (bestMatches.size) {
                            // This can happen if what we're deserializing is completely
                            // incompatible with all the possible variants (e.g. deserializing from
                            // array).
                            0 -> UnnamedSchemaWithArrayParent1(_json = json)
                            1 -> bestMatches.single()
                            // If there's more than one match with the highest validity, then use
                            // the first completely valid match, or simply the first match if none
                            // are completely valid.
                            else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                        }
                    }
                }

                internal class Serializer :
                    BaseSerializer<UnnamedSchemaWithArrayParent1>(
                        UnnamedSchemaWithArrayParent1::class
                    ) {

                    override fun serialize(
                        value: UnnamedSchemaWithArrayParent1,
                        generator: JsonGenerator,
                        provider: SerializerProvider,
                    ) {
                        when {
                            value.textInput != null -> generator.writeObject(value.textInput)
                            value.responseInputText != null ->
                                generator.writeObject(value.responseInputText)
                            value.outputText != null -> generator.writeObject(value.outputText)
                            value.evalItemInputImage != null ->
                                generator.writeObject(value.evalItemInputImage)
                            value.responseInputAudio != null ->
                                generator.writeObject(value.responseInputAudio)
                            value._json != null -> generator.writeObject(value._json)
                            else ->
                                throw IllegalStateException("Invalid UnnamedSchemaWithArrayParent1")
                        }
                    }
                }

                /** A text output from the model. */
                class OutputText
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val text: JsonField<String>,
                    private val type: JsonValue,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("text")
                        @ExcludeMissing
                        text: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                    ) : this(text, type, mutableMapOf())

                    /**
                     * The text output from the model.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun text(): String = text.getRequired("text")

                    /**
                     * The type of the output text. Always `output_text`.
                     *
                     * Expected to always return the following:
                     * ```java
                     * JsonValue.from("output_text")
                     * ```
                     *
                     * However, this method can be useful for debugging and logging (e.g. if the
                     * server responded with an unexpected value).
                     */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                    /**
                     * Returns the raw JSON value of [text].
                     *
                     * Unlike [text], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

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
                         * Returns a mutable builder for constructing an instance of [OutputText].
                         *
                         * The following fields are required:
                         * ```java
                         * .text()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [OutputText]. */
                    class Builder internal constructor() {

                        private var text: JsonField<String>? = null
                        private var type: JsonValue = JsonValue.from("output_text")
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(outputText: OutputText) = apply {
                            text = outputText.text
                            type = outputText.type
                            additionalProperties = outputText.additionalProperties.toMutableMap()
                        }

                        /** The text output from the model. */
                        fun text(text: String) = text(JsonField.of(text))

                        /**
                         * Sets [Builder.text] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.text] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun text(text: JsonField<String>) = apply { this.text = text }

                        /**
                         * Sets the field to an arbitrary JSON value.
                         *
                         * It is usually unnecessary to call this method because the field defaults
                         * to the following:
                         * ```java
                         * JsonValue.from("output_text")
                         * ```
                         *
                         * This method is primarily for setting the field to an undocumented or not
                         * yet supported value.
                         */
                        fun type(type: JsonValue) = apply { this.type = type }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [OutputText].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .text()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): OutputText =
                            OutputText(
                                checkRequired("text", text),
                                type,
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    fun validate(): OutputText = apply {
                        if (validated) {
                            return@apply
                        }

                        text()
                        _type().let {
                            if (it != JsonValue.from("output_text")) {
                                throw OpenAIInvalidDataException("'type' is invalid, received $it")
                            }
                        }
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
                        (if (text.asKnown().isPresent) 1 else 0) +
                            type.let { if (it == JsonValue.from("output_text")) 1 else 0 }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is OutputText &&
                            text == other.text &&
                            type == other.type &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(text, type, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "OutputText{text=$text, type=$type, additionalProperties=$additionalProperties}"
                }

                /** An image input block used within EvalItem content arrays. */
                class EvalItemInputImage
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val imageUrl: JsonField<String>,
                    private val type: JsonValue,
                    private val detail: JsonField<String>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("image_url")
                        @ExcludeMissing
                        imageUrl: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                        @JsonProperty("detail")
                        @ExcludeMissing
                        detail: JsonField<String> = JsonMissing.of(),
                    ) : this(imageUrl, type, detail, mutableMapOf())

                    /**
                     * The URL of the image input.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun imageUrl(): String = imageUrl.getRequired("image_url")

                    /**
                     * The type of the image input. Always `input_image`.
                     *
                     * Expected to always return the following:
                     * ```java
                     * JsonValue.from("input_image")
                     * ```
                     *
                     * However, this method can be useful for debugging and logging (e.g. if the
                     * server responded with an unexpected value).
                     */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                    /**
                     * The detail level of the image to be sent to the model. One of `high`, `low`,
                     * or `auto`. Defaults to `auto`.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun detail(): Optional<String> = detail.getOptional("detail")

                    /**
                     * Returns the raw JSON value of [imageUrl].
                     *
                     * Unlike [imageUrl], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("image_url")
                    @ExcludeMissing
                    fun _imageUrl(): JsonField<String> = imageUrl

                    /**
                     * Returns the raw JSON value of [detail].
                     *
                     * Unlike [detail], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("detail")
                    @ExcludeMissing
                    fun _detail(): JsonField<String> = detail

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
                         * Returns a mutable builder for constructing an instance of
                         * [EvalItemInputImage].
                         *
                         * The following fields are required:
                         * ```java
                         * .imageUrl()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [EvalItemInputImage]. */
                    class Builder internal constructor() {

                        private var imageUrl: JsonField<String>? = null
                        private var type: JsonValue = JsonValue.from("input_image")
                        private var detail: JsonField<String> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(evalItemInputImage: EvalItemInputImage) = apply {
                            imageUrl = evalItemInputImage.imageUrl
                            type = evalItemInputImage.type
                            detail = evalItemInputImage.detail
                            additionalProperties =
                                evalItemInputImage.additionalProperties.toMutableMap()
                        }

                        /** The URL of the image input. */
                        fun imageUrl(imageUrl: String) = imageUrl(JsonField.of(imageUrl))

                        /**
                         * Sets [Builder.imageUrl] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.imageUrl] with a well-typed [String]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun imageUrl(imageUrl: JsonField<String>) = apply {
                            this.imageUrl = imageUrl
                        }

                        /**
                         * Sets the field to an arbitrary JSON value.
                         *
                         * It is usually unnecessary to call this method because the field defaults
                         * to the following:
                         * ```java
                         * JsonValue.from("input_image")
                         * ```
                         *
                         * This method is primarily for setting the field to an undocumented or not
                         * yet supported value.
                         */
                        fun type(type: JsonValue) = apply { this.type = type }

                        /**
                         * The detail level of the image to be sent to the model. One of `high`,
                         * `low`, or `auto`. Defaults to `auto`.
                         */
                        fun detail(detail: String) = detail(JsonField.of(detail))

                        /**
                         * Sets [Builder.detail] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.detail] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun detail(detail: JsonField<String>) = apply { this.detail = detail }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [EvalItemInputImage].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .imageUrl()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): EvalItemInputImage =
                            EvalItemInputImage(
                                checkRequired("imageUrl", imageUrl),
                                type,
                                detail,
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    fun validate(): EvalItemInputImage = apply {
                        if (validated) {
                            return@apply
                        }

                        imageUrl()
                        _type().let {
                            if (it != JsonValue.from("input_image")) {
                                throw OpenAIInvalidDataException("'type' is invalid, received $it")
                            }
                        }
                        detail()
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
                        (if (imageUrl.asKnown().isPresent) 1 else 0) +
                            type.let { if (it == JsonValue.from("input_image")) 1 else 0 } +
                            (if (detail.asKnown().isPresent) 1 else 0)

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is EvalItemInputImage &&
                            imageUrl == other.imageUrl &&
                            type == other.type &&
                            detail == other.detail &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(imageUrl, type, detail, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "EvalItemInputImage{imageUrl=$imageUrl, type=$type, detail=$detail, additionalProperties=$additionalProperties}"
                }
            }
        }

        /** The role of the message input. One of `user`, `assistant`, `system`, or `developer`. */
        class Role @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val SYSTEM = of("system")

                @JvmField val DEVELOPER = of("developer")

                @JvmStatic fun of(value: String) = Role(JsonField.of(value))
            }

            /** An enum containing [Role]'s known values. */
            enum class Known {
                USER,
                ASSISTANT,
                SYSTEM,
                DEVELOPER,
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
                SYSTEM,
                DEVELOPER,
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
                    SYSTEM -> Value.SYSTEM
                    DEVELOPER -> Value.DEVELOPER
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
                    SYSTEM -> Known.SYSTEM
                    DEVELOPER -> Known.DEVELOPER
                    else -> throw OpenAIInvalidDataException("Unknown Role: $value")
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

            fun validate(): Role = apply {
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

                return other is Role && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /** The type of the message input. Always `message`. */
        class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val MESSAGE = of("message")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            enum class Known {
                MESSAGE
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
                MESSAGE,
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
                    MESSAGE -> Value.MESSAGE
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
                    MESSAGE -> Known.MESSAGE
                    else -> throw OpenAIInvalidDataException("Unknown Type: $value")
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

            fun validate(): Type = apply {
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

                return other is Type && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Input &&
                content == other.content &&
                role == other.role &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(content, role, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Input{content=$content, role=$role, type=$type, additionalProperties=$additionalProperties}"
    }

    /** The sampling parameters for the model. */
    class SamplingParams
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val maxCompletionsTokens: JsonField<Long>,
        private val reasoningEffort: JsonField<ReasoningEffort>,
        private val seed: JsonField<Long>,
        private val temperature: JsonField<Double>,
        private val topP: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("max_completions_tokens")
            @ExcludeMissing
            maxCompletionsTokens: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("reasoning_effort")
            @ExcludeMissing
            reasoningEffort: JsonField<ReasoningEffort> = JsonMissing.of(),
            @JsonProperty("seed") @ExcludeMissing seed: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("temperature")
            @ExcludeMissing
            temperature: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("top_p") @ExcludeMissing topP: JsonField<Double> = JsonMissing.of(),
        ) : this(maxCompletionsTokens, reasoningEffort, seed, temperature, topP, mutableMapOf())

        /**
         * The maximum number of tokens the grader model may generate in its response.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun maxCompletionsTokens(): Optional<Long> =
            maxCompletionsTokens.getOptional("max_completions_tokens")

        /**
         * Constrains effort on reasoning for
         * [reasoning models](https://platform.openai.com/docs/guides/reasoning). Currently
         * supported values are `none`, `minimal`, `low`, `medium`, `high`, and `xhigh`. Reducing
         * reasoning effort can result in faster responses and fewer tokens used on reasoning in a
         * response.
         * - `gpt-5.1` defaults to `none`, which does not perform reasoning. The supported reasoning
         *   values for `gpt-5.1` are `none`, `low`, `medium`, and `high`. Tool calls are supported
         *   for all reasoning values in gpt-5.1.
         * - All models before `gpt-5.1` default to `medium` reasoning effort, and do not support
         *   `none`.
         * - The `gpt-5-pro` model defaults to (and only supports) `high` reasoning effort.
         * - `xhigh` is supported for all models after `gpt-5.1-codex-max`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun reasoningEffort(): Optional<ReasoningEffort> =
            reasoningEffort.getOptional("reasoning_effort")

        /**
         * A seed value to initialize the randomness, during sampling.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun seed(): Optional<Long> = seed.getOptional("seed")

        /**
         * A higher temperature increases randomness in the outputs.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun temperature(): Optional<Double> = temperature.getOptional("temperature")

        /**
         * An alternative to temperature for nucleus sampling; 1.0 includes all tokens.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun topP(): Optional<Double> = topP.getOptional("top_p")

        /**
         * Returns the raw JSON value of [maxCompletionsTokens].
         *
         * Unlike [maxCompletionsTokens], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("max_completions_tokens")
        @ExcludeMissing
        fun _maxCompletionsTokens(): JsonField<Long> = maxCompletionsTokens

        /**
         * Returns the raw JSON value of [reasoningEffort].
         *
         * Unlike [reasoningEffort], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("reasoning_effort")
        @ExcludeMissing
        fun _reasoningEffort(): JsonField<ReasoningEffort> = reasoningEffort

        /**
         * Returns the raw JSON value of [seed].
         *
         * Unlike [seed], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("seed") @ExcludeMissing fun _seed(): JsonField<Long> = seed

        /**
         * Returns the raw JSON value of [temperature].
         *
         * Unlike [temperature], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("temperature")
        @ExcludeMissing
        fun _temperature(): JsonField<Double> = temperature

        /**
         * Returns the raw JSON value of [topP].
         *
         * Unlike [topP], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("top_p") @ExcludeMissing fun _topP(): JsonField<Double> = topP

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

            /** Returns a mutable builder for constructing an instance of [SamplingParams]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [SamplingParams]. */
        class Builder internal constructor() {

            private var maxCompletionsTokens: JsonField<Long> = JsonMissing.of()
            private var reasoningEffort: JsonField<ReasoningEffort> = JsonMissing.of()
            private var seed: JsonField<Long> = JsonMissing.of()
            private var temperature: JsonField<Double> = JsonMissing.of()
            private var topP: JsonField<Double> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(samplingParams: SamplingParams) = apply {
                maxCompletionsTokens = samplingParams.maxCompletionsTokens
                reasoningEffort = samplingParams.reasoningEffort
                seed = samplingParams.seed
                temperature = samplingParams.temperature
                topP = samplingParams.topP
                additionalProperties = samplingParams.additionalProperties.toMutableMap()
            }

            /** The maximum number of tokens the grader model may generate in its response. */
            fun maxCompletionsTokens(maxCompletionsTokens: Long?) =
                maxCompletionsTokens(JsonField.ofNullable(maxCompletionsTokens))

            /**
             * Alias for [Builder.maxCompletionsTokens].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun maxCompletionsTokens(maxCompletionsTokens: Long) =
                maxCompletionsTokens(maxCompletionsTokens as Long?)

            /**
             * Alias for calling [Builder.maxCompletionsTokens] with
             * `maxCompletionsTokens.orElse(null)`.
             */
            fun maxCompletionsTokens(maxCompletionsTokens: Optional<Long>) =
                maxCompletionsTokens(maxCompletionsTokens.getOrNull())

            /**
             * Sets [Builder.maxCompletionsTokens] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxCompletionsTokens] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun maxCompletionsTokens(maxCompletionsTokens: JsonField<Long>) = apply {
                this.maxCompletionsTokens = maxCompletionsTokens
            }

            /**
             * Constrains effort on reasoning for
             * [reasoning models](https://platform.openai.com/docs/guides/reasoning). Currently
             * supported values are `none`, `minimal`, `low`, `medium`, `high`, and `xhigh`.
             * Reducing reasoning effort can result in faster responses and fewer tokens used on
             * reasoning in a response.
             * - `gpt-5.1` defaults to `none`, which does not perform reasoning. The supported
             *   reasoning values for `gpt-5.1` are `none`, `low`, `medium`, and `high`. Tool calls
             *   are supported for all reasoning values in gpt-5.1.
             * - All models before `gpt-5.1` default to `medium` reasoning effort, and do not
             *   support `none`.
             * - The `gpt-5-pro` model defaults to (and only supports) `high` reasoning effort.
             * - `xhigh` is supported for all models after `gpt-5.1-codex-max`.
             */
            fun reasoningEffort(reasoningEffort: ReasoningEffort?) =
                reasoningEffort(JsonField.ofNullable(reasoningEffort))

            /** Alias for calling [Builder.reasoningEffort] with `reasoningEffort.orElse(null)`. */
            fun reasoningEffort(reasoningEffort: Optional<ReasoningEffort>) =
                reasoningEffort(reasoningEffort.getOrNull())

            /**
             * Sets [Builder.reasoningEffort] to an arbitrary JSON value.
             *
             * You should usually call [Builder.reasoningEffort] with a well-typed [ReasoningEffort]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun reasoningEffort(reasoningEffort: JsonField<ReasoningEffort>) = apply {
                this.reasoningEffort = reasoningEffort
            }

            /** A seed value to initialize the randomness, during sampling. */
            fun seed(seed: Long?) = seed(JsonField.ofNullable(seed))

            /**
             * Alias for [Builder.seed].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun seed(seed: Long) = seed(seed as Long?)

            /** Alias for calling [Builder.seed] with `seed.orElse(null)`. */
            fun seed(seed: Optional<Long>) = seed(seed.getOrNull())

            /**
             * Sets [Builder.seed] to an arbitrary JSON value.
             *
             * You should usually call [Builder.seed] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun seed(seed: JsonField<Long>) = apply { this.seed = seed }

            /** A higher temperature increases randomness in the outputs. */
            fun temperature(temperature: Double?) = temperature(JsonField.ofNullable(temperature))

            /**
             * Alias for [Builder.temperature].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun temperature(temperature: Double) = temperature(temperature as Double?)

            /** Alias for calling [Builder.temperature] with `temperature.orElse(null)`. */
            fun temperature(temperature: Optional<Double>) = temperature(temperature.getOrNull())

            /**
             * Sets [Builder.temperature] to an arbitrary JSON value.
             *
             * You should usually call [Builder.temperature] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun temperature(temperature: JsonField<Double>) = apply {
                this.temperature = temperature
            }

            /** An alternative to temperature for nucleus sampling; 1.0 includes all tokens. */
            fun topP(topP: Double?) = topP(JsonField.ofNullable(topP))

            /**
             * Alias for [Builder.topP].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun topP(topP: Double) = topP(topP as Double?)

            /** Alias for calling [Builder.topP] with `topP.orElse(null)`. */
            fun topP(topP: Optional<Double>) = topP(topP.getOrNull())

            /**
             * Sets [Builder.topP] to an arbitrary JSON value.
             *
             * You should usually call [Builder.topP] with a well-typed [Double] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
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

            /**
             * Returns an immutable instance of [SamplingParams].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): SamplingParams =
                SamplingParams(
                    maxCompletionsTokens,
                    reasoningEffort,
                    seed,
                    temperature,
                    topP,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): SamplingParams = apply {
            if (validated) {
                return@apply
            }

            maxCompletionsTokens()
            reasoningEffort().ifPresent { it.validate() }
            seed()
            temperature()
            topP()
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
            (if (maxCompletionsTokens.asKnown().isPresent) 1 else 0) +
                (reasoningEffort.asKnown().getOrNull()?.validity() ?: 0) +
                (if (seed.asKnown().isPresent) 1 else 0) +
                (if (temperature.asKnown().isPresent) 1 else 0) +
                (if (topP.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is SamplingParams &&
                maxCompletionsTokens == other.maxCompletionsTokens &&
                reasoningEffort == other.reasoningEffort &&
                seed == other.seed &&
                temperature == other.temperature &&
                topP == other.topP &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                maxCompletionsTokens,
                reasoningEffort,
                seed,
                temperature,
                topP,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "SamplingParams{maxCompletionsTokens=$maxCompletionsTokens, reasoningEffort=$reasoningEffort, seed=$seed, temperature=$temperature, topP=$topP, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ScoreModelGrader &&
            input == other.input &&
            model == other.model &&
            name == other.name &&
            type == other.type &&
            range == other.range &&
            samplingParams == other.samplingParams &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(input, model, name, type, range, samplingParams, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ScoreModelGrader{input=$input, model=$model, name=$name, type=$type, range=$range, samplingParams=$samplingParams, additionalProperties=$additionalProperties}"
}
