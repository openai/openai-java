// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.alpha.graders

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
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.Params
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.graders.gradermodels.MultiGrader
import com.openai.models.graders.gradermodels.PythonGrader
import com.openai.models.graders.gradermodels.ScoreModelGrader
import com.openai.models.graders.gradermodels.StringCheckGrader
import com.openai.models.graders.gradermodels.TextSimilarityGrader
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Run a grader. */
class GraderRunParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The grader used for the fine-tuning job.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun grader(): Grader = body.grader()

    /**
     * The model sample to be evaluated. This value will be used to populate the `sample` namespace.
     * See [the guide](https://platform.openai.com/docs/guides/graders) for more details. The
     * `output_json` variable will be populated if the model sample is a valid JSON string.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun modelSample(): String = body.modelSample()

    /**
     * The dataset item provided to the grader. This will be used to populate the `item` namespace.
     * See [the guide](https://platform.openai.com/docs/guides/graders) for more details.
     */
    fun _item(): JsonValue = body._item()

    /**
     * Returns the raw JSON value of [grader].
     *
     * Unlike [grader], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _grader(): JsonField<Grader> = body._grader()

    /**
     * Returns the raw JSON value of [modelSample].
     *
     * Unlike [modelSample], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _modelSample(): JsonField<String> = body._modelSample()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [GraderRunParams].
         *
         * The following fields are required:
         * ```java
         * .grader()
         * .modelSample()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [GraderRunParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(graderRunParams: GraderRunParams) = apply {
            body = graderRunParams.body.toBuilder()
            additionalHeaders = graderRunParams.additionalHeaders.toBuilder()
            additionalQueryParams = graderRunParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [grader]
         * - [modelSample]
         * - [item]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** The grader used for the fine-tuning job. */
        fun grader(grader: Grader) = apply { body.grader(grader) }

        /**
         * Sets [Builder.grader] to an arbitrary JSON value.
         *
         * You should usually call [Builder.grader] with a well-typed [Grader] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun grader(grader: JsonField<Grader>) = apply { body.grader(grader) }

        /** Alias for calling [grader] with `Grader.ofStringCheck(stringCheck)`. */
        fun grader(stringCheck: StringCheckGrader) = apply { body.grader(stringCheck) }

        /** Alias for calling [grader] with `Grader.ofTextSimilarity(textSimilarity)`. */
        fun grader(textSimilarity: TextSimilarityGrader) = apply { body.grader(textSimilarity) }

        /** Alias for calling [grader] with `Grader.ofPython(python)`. */
        fun grader(python: PythonGrader) = apply { body.grader(python) }

        /** Alias for calling [grader] with `Grader.ofScoreModel(scoreModel)`. */
        fun grader(scoreModel: ScoreModelGrader) = apply { body.grader(scoreModel) }

        /** Alias for calling [grader] with `Grader.ofMulti(multi)`. */
        fun grader(multi: MultiGrader) = apply { body.grader(multi) }

        /**
         * The model sample to be evaluated. This value will be used to populate the `sample`
         * namespace. See [the guide](https://platform.openai.com/docs/guides/graders) for more
         * details. The `output_json` variable will be populated if the model sample is a valid JSON
         * string.
         */
        fun modelSample(modelSample: String) = apply { body.modelSample(modelSample) }

        /**
         * Sets [Builder.modelSample] to an arbitrary JSON value.
         *
         * You should usually call [Builder.modelSample] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun modelSample(modelSample: JsonField<String>) = apply { body.modelSample(modelSample) }

        /**
         * The dataset item provided to the grader. This will be used to populate the `item`
         * namespace. See [the guide](https://platform.openai.com/docs/guides/graders) for more
         * details.
         */
        fun item(item: JsonValue) = apply { body.item(item) }

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
         * Returns an immutable instance of [GraderRunParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .grader()
         * .modelSample()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): GraderRunParams =
            GraderRunParams(body.build(), additionalHeaders.build(), additionalQueryParams.build())
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    private constructor(
        private val grader: JsonField<Grader>,
        private val modelSample: JsonField<String>,
        private val item: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("grader") @ExcludeMissing grader: JsonField<Grader> = JsonMissing.of(),
            @JsonProperty("model_sample")
            @ExcludeMissing
            modelSample: JsonField<String> = JsonMissing.of(),
            @JsonProperty("item") @ExcludeMissing item: JsonValue = JsonMissing.of(),
        ) : this(grader, modelSample, item, mutableMapOf())

        /**
         * The grader used for the fine-tuning job.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun grader(): Grader = grader.getRequired("grader")

        /**
         * The model sample to be evaluated. This value will be used to populate the `sample`
         * namespace. See [the guide](https://platform.openai.com/docs/guides/graders) for more
         * details. The `output_json` variable will be populated if the model sample is a valid JSON
         * string.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun modelSample(): String = modelSample.getRequired("model_sample")

        /**
         * The dataset item provided to the grader. This will be used to populate the `item`
         * namespace. See [the guide](https://platform.openai.com/docs/guides/graders) for more
         * details.
         */
        @JsonProperty("item") @ExcludeMissing fun _item(): JsonValue = item

        /**
         * Returns the raw JSON value of [grader].
         *
         * Unlike [grader], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("grader") @ExcludeMissing fun _grader(): JsonField<Grader> = grader

        /**
         * Returns the raw JSON value of [modelSample].
         *
         * Unlike [modelSample], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("model_sample")
        @ExcludeMissing
        fun _modelSample(): JsonField<String> = modelSample

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
             * .grader()
             * .modelSample()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var grader: JsonField<Grader>? = null
            private var modelSample: JsonField<String>? = null
            private var item: JsonValue = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                grader = body.grader
                modelSample = body.modelSample
                item = body.item
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** The grader used for the fine-tuning job. */
            fun grader(grader: Grader) = grader(JsonField.of(grader))

            /**
             * Sets [Builder.grader] to an arbitrary JSON value.
             *
             * You should usually call [Builder.grader] with a well-typed [Grader] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun grader(grader: JsonField<Grader>) = apply { this.grader = grader }

            /** Alias for calling [grader] with `Grader.ofStringCheck(stringCheck)`. */
            fun grader(stringCheck: StringCheckGrader) = grader(Grader.ofStringCheck(stringCheck))

            /** Alias for calling [grader] with `Grader.ofTextSimilarity(textSimilarity)`. */
            fun grader(textSimilarity: TextSimilarityGrader) =
                grader(Grader.ofTextSimilarity(textSimilarity))

            /** Alias for calling [grader] with `Grader.ofPython(python)`. */
            fun grader(python: PythonGrader) = grader(Grader.ofPython(python))

            /** Alias for calling [grader] with `Grader.ofScoreModel(scoreModel)`. */
            fun grader(scoreModel: ScoreModelGrader) = grader(Grader.ofScoreModel(scoreModel))

            /** Alias for calling [grader] with `Grader.ofMulti(multi)`. */
            fun grader(multi: MultiGrader) = grader(Grader.ofMulti(multi))

            /**
             * The model sample to be evaluated. This value will be used to populate the `sample`
             * namespace. See [the guide](https://platform.openai.com/docs/guides/graders) for more
             * details. The `output_json` variable will be populated if the model sample is a valid
             * JSON string.
             */
            fun modelSample(modelSample: String) = modelSample(JsonField.of(modelSample))

            /**
             * Sets [Builder.modelSample] to an arbitrary JSON value.
             *
             * You should usually call [Builder.modelSample] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun modelSample(modelSample: JsonField<String>) = apply {
                this.modelSample = modelSample
            }

            /**
             * The dataset item provided to the grader. This will be used to populate the `item`
             * namespace. See [the guide](https://platform.openai.com/docs/guides/graders) for more
             * details.
             */
            fun item(item: JsonValue) = apply { this.item = item }

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
             * .grader()
             * .modelSample()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("grader", grader),
                    checkRequired("modelSample", modelSample),
                    item,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            grader().validate()
            modelSample()
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
            (grader.asKnown().getOrNull()?.validity() ?: 0) +
                (if (modelSample.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                grader == other.grader &&
                modelSample == other.modelSample &&
                item == other.item &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(grader, modelSample, item, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{grader=$grader, modelSample=$modelSample, item=$item, additionalProperties=$additionalProperties}"
    }

    /** The grader used for the fine-tuning job. */
    @JsonDeserialize(using = Grader.Deserializer::class)
    @JsonSerialize(using = Grader.Serializer::class)
    class Grader
    private constructor(
        private val stringCheck: StringCheckGrader? = null,
        private val textSimilarity: TextSimilarityGrader? = null,
        private val python: PythonGrader? = null,
        private val scoreModel: ScoreModelGrader? = null,
        private val multi: MultiGrader? = null,
        private val _json: JsonValue? = null,
    ) {

        /**
         * A StringCheckGrader object that performs a string comparison between input and reference
         * using a specified operation.
         */
        fun stringCheck(): Optional<StringCheckGrader> = Optional.ofNullable(stringCheck)

        /** A TextSimilarityGrader object which grades text based on similarity metrics. */
        fun textSimilarity(): Optional<TextSimilarityGrader> = Optional.ofNullable(textSimilarity)

        /** A PythonGrader object that runs a python script on the input. */
        fun python(): Optional<PythonGrader> = Optional.ofNullable(python)

        /** A ScoreModelGrader object that uses a model to assign a score to the input. */
        fun scoreModel(): Optional<ScoreModelGrader> = Optional.ofNullable(scoreModel)

        /**
         * A MultiGrader object combines the output of multiple graders to produce a single score.
         */
        fun multi(): Optional<MultiGrader> = Optional.ofNullable(multi)

        fun isStringCheck(): Boolean = stringCheck != null

        fun isTextSimilarity(): Boolean = textSimilarity != null

        fun isPython(): Boolean = python != null

        fun isScoreModel(): Boolean = scoreModel != null

        fun isMulti(): Boolean = multi != null

        /**
         * A StringCheckGrader object that performs a string comparison between input and reference
         * using a specified operation.
         */
        fun asStringCheck(): StringCheckGrader = stringCheck.getOrThrow("stringCheck")

        /** A TextSimilarityGrader object which grades text based on similarity metrics. */
        fun asTextSimilarity(): TextSimilarityGrader = textSimilarity.getOrThrow("textSimilarity")

        /** A PythonGrader object that runs a python script on the input. */
        fun asPython(): PythonGrader = python.getOrThrow("python")

        /** A ScoreModelGrader object that uses a model to assign a score to the input. */
        fun asScoreModel(): ScoreModelGrader = scoreModel.getOrThrow("scoreModel")

        /**
         * A MultiGrader object combines the output of multiple graders to produce a single score.
         */
        fun asMulti(): MultiGrader = multi.getOrThrow("multi")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                stringCheck != null -> visitor.visitStringCheck(stringCheck)
                textSimilarity != null -> visitor.visitTextSimilarity(textSimilarity)
                python != null -> visitor.visitPython(python)
                scoreModel != null -> visitor.visitScoreModel(scoreModel)
                multi != null -> visitor.visitMulti(multi)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Grader = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitStringCheck(stringCheck: StringCheckGrader) {
                        stringCheck.validate()
                    }

                    override fun visitTextSimilarity(textSimilarity: TextSimilarityGrader) {
                        textSimilarity.validate()
                    }

                    override fun visitPython(python: PythonGrader) {
                        python.validate()
                    }

                    override fun visitScoreModel(scoreModel: ScoreModelGrader) {
                        scoreModel.validate()
                    }

                    override fun visitMulti(multi: MultiGrader) {
                        multi.validate()
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
                    override fun visitStringCheck(stringCheck: StringCheckGrader) =
                        stringCheck.validity()

                    override fun visitTextSimilarity(textSimilarity: TextSimilarityGrader) =
                        textSimilarity.validity()

                    override fun visitPython(python: PythonGrader) = python.validity()

                    override fun visitScoreModel(scoreModel: ScoreModelGrader) =
                        scoreModel.validity()

                    override fun visitMulti(multi: MultiGrader) = multi.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Grader &&
                stringCheck == other.stringCheck &&
                textSimilarity == other.textSimilarity &&
                python == other.python &&
                scoreModel == other.scoreModel &&
                multi == other.multi
        }

        override fun hashCode(): Int =
            Objects.hash(stringCheck, textSimilarity, python, scoreModel, multi)

        override fun toString(): String =
            when {
                stringCheck != null -> "Grader{stringCheck=$stringCheck}"
                textSimilarity != null -> "Grader{textSimilarity=$textSimilarity}"
                python != null -> "Grader{python=$python}"
                scoreModel != null -> "Grader{scoreModel=$scoreModel}"
                multi != null -> "Grader{multi=$multi}"
                _json != null -> "Grader{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Grader")
            }

        companion object {

            /**
             * A StringCheckGrader object that performs a string comparison between input and
             * reference using a specified operation.
             */
            @JvmStatic
            fun ofStringCheck(stringCheck: StringCheckGrader) = Grader(stringCheck = stringCheck)

            /** A TextSimilarityGrader object which grades text based on similarity metrics. */
            @JvmStatic
            fun ofTextSimilarity(textSimilarity: TextSimilarityGrader) =
                Grader(textSimilarity = textSimilarity)

            /** A PythonGrader object that runs a python script on the input. */
            @JvmStatic fun ofPython(python: PythonGrader) = Grader(python = python)

            /** A ScoreModelGrader object that uses a model to assign a score to the input. */
            @JvmStatic
            fun ofScoreModel(scoreModel: ScoreModelGrader) = Grader(scoreModel = scoreModel)

            /**
             * A MultiGrader object combines the output of multiple graders to produce a single
             * score.
             */
            @JvmStatic fun ofMulti(multi: MultiGrader) = Grader(multi = multi)
        }

        /** An interface that defines how to map each variant of [Grader] to a value of type [T]. */
        interface Visitor<out T> {

            /**
             * A StringCheckGrader object that performs a string comparison between input and
             * reference using a specified operation.
             */
            fun visitStringCheck(stringCheck: StringCheckGrader): T

            /** A TextSimilarityGrader object which grades text based on similarity metrics. */
            fun visitTextSimilarity(textSimilarity: TextSimilarityGrader): T

            /** A PythonGrader object that runs a python script on the input. */
            fun visitPython(python: PythonGrader): T

            /** A ScoreModelGrader object that uses a model to assign a score to the input. */
            fun visitScoreModel(scoreModel: ScoreModelGrader): T

            /**
             * A MultiGrader object combines the output of multiple graders to produce a single
             * score.
             */
            fun visitMulti(multi: MultiGrader): T

            /**
             * Maps an unknown variant of [Grader] to a value of type [T].
             *
             * An instance of [Grader] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Grader: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Grader>(Grader::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Grader {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "string_check" -> {
                        return tryDeserialize(node, jacksonTypeRef<StringCheckGrader>())?.let {
                            Grader(stringCheck = it, _json = json)
                        } ?: Grader(_json = json)
                    }
                    "text_similarity" -> {
                        return tryDeserialize(node, jacksonTypeRef<TextSimilarityGrader>())?.let {
                            Grader(textSimilarity = it, _json = json)
                        } ?: Grader(_json = json)
                    }
                    "python" -> {
                        return tryDeserialize(node, jacksonTypeRef<PythonGrader>())?.let {
                            Grader(python = it, _json = json)
                        } ?: Grader(_json = json)
                    }
                    "score_model" -> {
                        return tryDeserialize(node, jacksonTypeRef<ScoreModelGrader>())?.let {
                            Grader(scoreModel = it, _json = json)
                        } ?: Grader(_json = json)
                    }
                    "multi" -> {
                        return tryDeserialize(node, jacksonTypeRef<MultiGrader>())?.let {
                            Grader(multi = it, _json = json)
                        } ?: Grader(_json = json)
                    }
                }

                return Grader(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Grader>(Grader::class) {

            override fun serialize(
                value: Grader,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.stringCheck != null -> generator.writeObject(value.stringCheck)
                    value.textSimilarity != null -> generator.writeObject(value.textSimilarity)
                    value.python != null -> generator.writeObject(value.python)
                    value.scoreModel != null -> generator.writeObject(value.scoreModel)
                    value.multi != null -> generator.writeObject(value.multi)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Grader")
                }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is GraderRunParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "GraderRunParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
