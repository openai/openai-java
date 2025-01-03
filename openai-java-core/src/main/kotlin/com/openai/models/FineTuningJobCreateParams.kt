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
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.getOrThrow
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

class FineTuningJobCreateParams
constructor(
    private val body: FineTuningJobCreateBody,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) {

    /**
     * The name of the model to fine-tune. You can select one of the
     * [supported models](https://platform.openai.com/docs/guides/fine-tuning#which-models-can-be-fine-tuned).
     */
    fun model(): Model = body.model()

    /**
     * The ID of an uploaded file that contains training data.
     *
     * See [upload file](https://platform.openai.com/docs/api-reference/files/create) for how to
     * upload a file.
     *
     * Your dataset must be formatted as a JSONL file. Additionally, you must upload your file with
     * the purpose `fine-tune`.
     *
     * The contents of the file should differ depending on if the model uses the
     * [chat](https://platform.openai.com/docs/api-reference/fine-tuning/chat-input),
     * [completions](https://platform.openai.com/docs/api-reference/fine-tuning/completions-input)
     * format, or if the fine-tuning method uses the
     * [preference](https://platform.openai.com/docs/api-reference/fine-tuning/preference-input)
     * format.
     *
     * See the [fine-tuning guide](https://platform.openai.com/docs/guides/fine-tuning) for more
     * details.
     */
    fun trainingFile(): String = body.trainingFile()

    /**
     * The hyperparameters used for the fine-tuning job. This value is now deprecated in favor of
     * `method`, and should be passed in under the `method` parameter.
     */
    fun hyperparameters(): Optional<Hyperparameters> = body.hyperparameters()

    /** A list of integrations to enable for your fine-tuning job. */
    fun integrations(): Optional<List<Integration>> = body.integrations()

    /** The method used for fine-tuning. */
    fun method(): Optional<Method> = body.method()

    /**
     * The seed controls the reproducibility of the job. Passing in the same seed and job parameters
     * should produce the same results, but may differ in rare cases. If a seed is not specified,
     * one will be generated for you.
     */
    fun seed(): Optional<Long> = body.seed()

    /**
     * A string of up to 64 characters that will be added to your fine-tuned model name.
     *
     * For example, a `suffix` of "custom-model-name" would produce a model name like
     * `ft:gpt-4o-mini:openai:custom-model-name:7p4lURel`.
     */
    fun suffix(): Optional<String> = body.suffix()

    /**
     * The ID of an uploaded file that contains validation data.
     *
     * If you provide this file, the data is used to generate validation metrics periodically during
     * fine-tuning. These metrics can be viewed in the fine-tuning results file. The same data
     * should not be present in both train and validation files.
     *
     * Your dataset must be formatted as a JSONL file. You must upload your file with the purpose
     * `fine-tune`.
     *
     * See the [fine-tuning guide](https://platform.openai.com/docs/guides/fine-tuning) for more
     * details.
     */
    fun validationFile(): Optional<String> = body.validationFile()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    @JvmSynthetic internal fun getBody(): FineTuningJobCreateBody = body

    @JvmSynthetic internal fun getHeaders(): Headers = additionalHeaders

    @JvmSynthetic internal fun getQueryParams(): QueryParams = additionalQueryParams

    @NoAutoDetect
    class FineTuningJobCreateBody
    @JsonCreator
    internal constructor(
        @JsonProperty("model") private val model: Model,
        @JsonProperty("training_file") private val trainingFile: String,
        @JsonProperty("hyperparameters") private val hyperparameters: Hyperparameters?,
        @JsonProperty("integrations") private val integrations: List<Integration>?,
        @JsonProperty("method") private val method: Method?,
        @JsonProperty("seed") private val seed: Long?,
        @JsonProperty("suffix") private val suffix: String?,
        @JsonProperty("validation_file") private val validationFile: String?,
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * The name of the model to fine-tune. You can select one of the
         * [supported models](https://platform.openai.com/docs/guides/fine-tuning#which-models-can-be-fine-tuned).
         */
        @JsonProperty("model") fun model(): Model = model

        /**
         * The ID of an uploaded file that contains training data.
         *
         * See [upload file](https://platform.openai.com/docs/api-reference/files/create) for how to
         * upload a file.
         *
         * Your dataset must be formatted as a JSONL file. Additionally, you must upload your file
         * with the purpose `fine-tune`.
         *
         * The contents of the file should differ depending on if the model uses the
         * [chat](https://platform.openai.com/docs/api-reference/fine-tuning/chat-input),
         * [completions](https://platform.openai.com/docs/api-reference/fine-tuning/completions-input)
         * format, or if the fine-tuning method uses the
         * [preference](https://platform.openai.com/docs/api-reference/fine-tuning/preference-input)
         * format.
         *
         * See the [fine-tuning guide](https://platform.openai.com/docs/guides/fine-tuning) for more
         * details.
         */
        @JsonProperty("training_file") fun trainingFile(): String = trainingFile

        /**
         * The hyperparameters used for the fine-tuning job. This value is now deprecated in favor
         * of `method`, and should be passed in under the `method` parameter.
         */
        @JsonProperty("hyperparameters")
        fun hyperparameters(): Optional<Hyperparameters> = Optional.ofNullable(hyperparameters)

        /** A list of integrations to enable for your fine-tuning job. */
        @JsonProperty("integrations")
        fun integrations(): Optional<List<Integration>> = Optional.ofNullable(integrations)

        /** The method used for fine-tuning. */
        @JsonProperty("method") fun method(): Optional<Method> = Optional.ofNullable(method)

        /**
         * The seed controls the reproducibility of the job. Passing in the same seed and job
         * parameters should produce the same results, but may differ in rare cases. If a seed is
         * not specified, one will be generated for you.
         */
        @JsonProperty("seed") fun seed(): Optional<Long> = Optional.ofNullable(seed)

        /**
         * A string of up to 64 characters that will be added to your fine-tuned model name.
         *
         * For example, a `suffix` of "custom-model-name" would produce a model name like
         * `ft:gpt-4o-mini:openai:custom-model-name:7p4lURel`.
         */
        @JsonProperty("suffix") fun suffix(): Optional<String> = Optional.ofNullable(suffix)

        /**
         * The ID of an uploaded file that contains validation data.
         *
         * If you provide this file, the data is used to generate validation metrics periodically
         * during fine-tuning. These metrics can be viewed in the fine-tuning results file. The same
         * data should not be present in both train and validation files.
         *
         * Your dataset must be formatted as a JSONL file. You must upload your file with the
         * purpose `fine-tune`.
         *
         * See the [fine-tuning guide](https://platform.openai.com/docs/guides/fine-tuning) for more
         * details.
         */
        @JsonProperty("validation_file")
        fun validationFile(): Optional<String> = Optional.ofNullable(validationFile)

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var model: Model? = null
            private var trainingFile: String? = null
            private var hyperparameters: Hyperparameters? = null
            private var integrations: MutableList<Integration>? = null
            private var method: Method? = null
            private var seed: Long? = null
            private var suffix: String? = null
            private var validationFile: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(fineTuningJobCreateBody: FineTuningJobCreateBody) = apply {
                model = fineTuningJobCreateBody.model
                trainingFile = fineTuningJobCreateBody.trainingFile
                hyperparameters = fineTuningJobCreateBody.hyperparameters
                integrations = fineTuningJobCreateBody.integrations?.toMutableList()
                method = fineTuningJobCreateBody.method
                seed = fineTuningJobCreateBody.seed
                suffix = fineTuningJobCreateBody.suffix
                validationFile = fineTuningJobCreateBody.validationFile
                additionalProperties = fineTuningJobCreateBody.additionalProperties.toMutableMap()
            }

            /**
             * The name of the model to fine-tune. You can select one of the
             * [supported models](https://platform.openai.com/docs/guides/fine-tuning#which-models-can-be-fine-tuned).
             */
            fun model(model: Model) = apply { this.model = model }

            /**
             * The name of the model to fine-tune. You can select one of the
             * [supported models](https://platform.openai.com/docs/guides/fine-tuning#which-models-can-be-fine-tuned).
             */
            fun model(value: String) = apply { model = Model.of(value) }

            /**
             * The ID of an uploaded file that contains training data.
             *
             * See [upload file](https://platform.openai.com/docs/api-reference/files/create) for
             * how to upload a file.
             *
             * Your dataset must be formatted as a JSONL file. Additionally, you must upload your
             * file with the purpose `fine-tune`.
             *
             * The contents of the file should differ depending on if the model uses the
             * [chat](https://platform.openai.com/docs/api-reference/fine-tuning/chat-input),
             * [completions](https://platform.openai.com/docs/api-reference/fine-tuning/completions-input)
             * format, or if the fine-tuning method uses the
             * [preference](https://platform.openai.com/docs/api-reference/fine-tuning/preference-input)
             * format.
             *
             * See the [fine-tuning guide](https://platform.openai.com/docs/guides/fine-tuning) for
             * more details.
             */
            fun trainingFile(trainingFile: String) = apply { this.trainingFile = trainingFile }

            /**
             * The hyperparameters used for the fine-tuning job. This value is now deprecated in
             * favor of `method`, and should be passed in under the `method` parameter.
             */
            fun hyperparameters(hyperparameters: Hyperparameters) = apply {
                this.hyperparameters = hyperparameters
            }

            /** A list of integrations to enable for your fine-tuning job. */
            fun integrations(integrations: List<Integration>) = apply {
                this.integrations = integrations.toMutableList()
            }

            /** A list of integrations to enable for your fine-tuning job. */
            fun addIntegration(integration: Integration) = apply {
                integrations = (integrations ?: mutableListOf()).apply { add(integration) }
            }

            /** The method used for fine-tuning. */
            fun method(method: Method) = apply { this.method = method }

            /**
             * The seed controls the reproducibility of the job. Passing in the same seed and job
             * parameters should produce the same results, but may differ in rare cases. If a seed
             * is not specified, one will be generated for you.
             */
            fun seed(seed: Long) = apply { this.seed = seed }

            /**
             * A string of up to 64 characters that will be added to your fine-tuned model name.
             *
             * For example, a `suffix` of "custom-model-name" would produce a model name like
             * `ft:gpt-4o-mini:openai:custom-model-name:7p4lURel`.
             */
            fun suffix(suffix: String) = apply { this.suffix = suffix }

            /**
             * The ID of an uploaded file that contains validation data.
             *
             * If you provide this file, the data is used to generate validation metrics
             * periodically during fine-tuning. These metrics can be viewed in the fine-tuning
             * results file. The same data should not be present in both train and validation files.
             *
             * Your dataset must be formatted as a JSONL file. You must upload your file with the
             * purpose `fine-tune`.
             *
             * See the [fine-tuning guide](https://platform.openai.com/docs/guides/fine-tuning) for
             * more details.
             */
            fun validationFile(validationFile: String) = apply {
                this.validationFile = validationFile
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

            fun build(): FineTuningJobCreateBody =
                FineTuningJobCreateBody(
                    checkNotNull(model) { "`model` is required but was not set" },
                    checkNotNull(trainingFile) { "`trainingFile` is required but was not set" },
                    hyperparameters,
                    integrations?.toImmutable(),
                    method,
                    seed,
                    suffix,
                    validationFile,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is FineTuningJobCreateBody && model == other.model && trainingFile == other.trainingFile && hyperparameters == other.hyperparameters && integrations == other.integrations && method == other.method && seed == other.seed && suffix == other.suffix && validationFile == other.validationFile && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(model, trainingFile, hyperparameters, integrations, method, seed, suffix, validationFile, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "FineTuningJobCreateBody{model=$model, trainingFile=$trainingFile, hyperparameters=$hyperparameters, integrations=$integrations, method=$method, seed=$seed, suffix=$suffix, validationFile=$validationFile, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var body: FineTuningJobCreateBody.Builder = FineTuningJobCreateBody.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(fineTuningJobCreateParams: FineTuningJobCreateParams) = apply {
            body = fineTuningJobCreateParams.body.toBuilder()
            additionalHeaders = fineTuningJobCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = fineTuningJobCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * The name of the model to fine-tune. You can select one of the
         * [supported models](https://platform.openai.com/docs/guides/fine-tuning#which-models-can-be-fine-tuned).
         */
        fun model(model: Model) = apply { body.model(model) }

        /**
         * The name of the model to fine-tune. You can select one of the
         * [supported models](https://platform.openai.com/docs/guides/fine-tuning#which-models-can-be-fine-tuned).
         */
        fun model(value: String) = apply { body.model(value) }

        /**
         * The ID of an uploaded file that contains training data.
         *
         * See [upload file](https://platform.openai.com/docs/api-reference/files/create) for how to
         * upload a file.
         *
         * Your dataset must be formatted as a JSONL file. Additionally, you must upload your file
         * with the purpose `fine-tune`.
         *
         * The contents of the file should differ depending on if the model uses the
         * [chat](https://platform.openai.com/docs/api-reference/fine-tuning/chat-input),
         * [completions](https://platform.openai.com/docs/api-reference/fine-tuning/completions-input)
         * format, or if the fine-tuning method uses the
         * [preference](https://platform.openai.com/docs/api-reference/fine-tuning/preference-input)
         * format.
         *
         * See the [fine-tuning guide](https://platform.openai.com/docs/guides/fine-tuning) for more
         * details.
         */
        fun trainingFile(trainingFile: String) = apply { body.trainingFile(trainingFile) }

        /**
         * The hyperparameters used for the fine-tuning job. This value is now deprecated in favor
         * of `method`, and should be passed in under the `method` parameter.
         */
        fun hyperparameters(hyperparameters: Hyperparameters) = apply {
            body.hyperparameters(hyperparameters)
        }

        /** A list of integrations to enable for your fine-tuning job. */
        fun integrations(integrations: List<Integration>) = apply {
            body.integrations(integrations)
        }

        /** A list of integrations to enable for your fine-tuning job. */
        fun addIntegration(integration: Integration) = apply { body.addIntegration(integration) }

        /** The method used for fine-tuning. */
        fun method(method: Method) = apply { body.method(method) }

        /**
         * The seed controls the reproducibility of the job. Passing in the same seed and job
         * parameters should produce the same results, but may differ in rare cases. If a seed is
         * not specified, one will be generated for you.
         */
        fun seed(seed: Long) = apply { body.seed(seed) }

        /**
         * A string of up to 64 characters that will be added to your fine-tuned model name.
         *
         * For example, a `suffix` of "custom-model-name" would produce a model name like
         * `ft:gpt-4o-mini:openai:custom-model-name:7p4lURel`.
         */
        fun suffix(suffix: String) = apply { body.suffix(suffix) }

        /**
         * The ID of an uploaded file that contains validation data.
         *
         * If you provide this file, the data is used to generate validation metrics periodically
         * during fine-tuning. These metrics can be viewed in the fine-tuning results file. The same
         * data should not be present in both train and validation files.
         *
         * Your dataset must be formatted as a JSONL file. You must upload your file with the
         * purpose `fine-tune`.
         *
         * See the [fine-tuning guide](https://platform.openai.com/docs/guides/fine-tuning) for more
         * details.
         */
        fun validationFile(validationFile: String) = apply { body.validationFile(validationFile) }

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

        fun build(): FineTuningJobCreateParams =
            FineTuningJobCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    class Model
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val BABBAGE_002 = of("babbage-002")

            @JvmField val DAVINCI_002 = of("davinci-002")

            @JvmField val GPT_3_5_TURBO = of("gpt-3.5-turbo")

            @JvmField val GPT_4O_MINI = of("gpt-4o-mini")

            @JvmStatic fun of(value: String) = Model(JsonField.of(value))
        }

        enum class Known {
            BABBAGE_002,
            DAVINCI_002,
            GPT_3_5_TURBO,
            GPT_4O_MINI,
        }

        enum class Value {
            BABBAGE_002,
            DAVINCI_002,
            GPT_3_5_TURBO,
            GPT_4O_MINI,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                BABBAGE_002 -> Value.BABBAGE_002
                DAVINCI_002 -> Value.DAVINCI_002
                GPT_3_5_TURBO -> Value.GPT_3_5_TURBO
                GPT_4O_MINI -> Value.GPT_4O_MINI
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                BABBAGE_002 -> Known.BABBAGE_002
                DAVINCI_002 -> Known.DAVINCI_002
                GPT_3_5_TURBO -> Known.GPT_3_5_TURBO
                GPT_4O_MINI -> Known.GPT_4O_MINI
                else -> throw OpenAIInvalidDataException("Unknown Model: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Model && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * The hyperparameters used for the fine-tuning job. This value is now deprecated in favor of
     * `method`, and should be passed in under the `method` parameter.
     */
    @NoAutoDetect
    class Hyperparameters
    @JsonCreator
    private constructor(
        @JsonProperty("batch_size") private val batchSize: BatchSize?,
        @JsonProperty("learning_rate_multiplier")
        private val learningRateMultiplier: LearningRateMultiplier?,
        @JsonProperty("n_epochs") private val nEpochs: NEpochs?,
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Number of examples in each batch. A larger batch size means that model parameters are
         * updated less frequently, but with lower variance.
         */
        @JsonProperty("batch_size")
        fun batchSize(): Optional<BatchSize> = Optional.ofNullable(batchSize)

        /**
         * Scaling factor for the learning rate. A smaller learning rate may be useful to avoid
         * overfitting.
         */
        @JsonProperty("learning_rate_multiplier")
        fun learningRateMultiplier(): Optional<LearningRateMultiplier> =
            Optional.ofNullable(learningRateMultiplier)

        /**
         * The number of epochs to train the model for. An epoch refers to one full cycle through
         * the training dataset.
         */
        @JsonProperty("n_epochs") fun nEpochs(): Optional<NEpochs> = Optional.ofNullable(nEpochs)

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var batchSize: BatchSize? = null
            private var learningRateMultiplier: LearningRateMultiplier? = null
            private var nEpochs: NEpochs? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(hyperparameters: Hyperparameters) = apply {
                batchSize = hyperparameters.batchSize
                learningRateMultiplier = hyperparameters.learningRateMultiplier
                nEpochs = hyperparameters.nEpochs
                additionalProperties = hyperparameters.additionalProperties.toMutableMap()
            }

            /**
             * Number of examples in each batch. A larger batch size means that model parameters are
             * updated less frequently, but with lower variance.
             */
            fun batchSize(batchSize: BatchSize) = apply { this.batchSize = batchSize }

            fun batchSize(behavior: BatchSize.Behavior) = apply {
                this.batchSize = BatchSize.ofBehavior(behavior)
            }

            fun batchSize(integer: Long) = apply { this.batchSize = BatchSize.ofInteger(integer) }

            /**
             * Scaling factor for the learning rate. A smaller learning rate may be useful to avoid
             * overfitting.
             */
            fun learningRateMultiplier(learningRateMultiplier: LearningRateMultiplier) = apply {
                this.learningRateMultiplier = learningRateMultiplier
            }

            fun learningRateMultiplier(behavior: LearningRateMultiplier.Behavior) = apply {
                this.learningRateMultiplier = LearningRateMultiplier.ofBehavior(behavior)
            }

            fun learningRateMultiplier(number: Double) = apply {
                this.learningRateMultiplier = LearningRateMultiplier.ofNumber(number)
            }

            /**
             * The number of epochs to train the model for. An epoch refers to one full cycle
             * through the training dataset.
             */
            fun nEpochs(nEpochs: NEpochs) = apply { this.nEpochs = nEpochs }

            fun nEpochs(behavior: NEpochs.Behavior) = apply {
                this.nEpochs = NEpochs.ofBehavior(behavior)
            }

            fun nEpochs(integer: Long) = apply { this.nEpochs = NEpochs.ofInteger(integer) }

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

            fun build(): Hyperparameters =
                Hyperparameters(
                    batchSize,
                    learningRateMultiplier,
                    nEpochs,
                    additionalProperties.toImmutable(),
                )
        }

        /**
         * Number of examples in each batch. A larger batch size means that model parameters are
         * updated less frequently, but with lower variance.
         */
        @JsonDeserialize(using = BatchSize.Deserializer::class)
        @JsonSerialize(using = BatchSize.Serializer::class)
        class BatchSize
        private constructor(
            private val behavior: Behavior? = null,
            private val integer: Long? = null,
            private val _json: JsonValue? = null,
        ) {

            fun behavior(): Optional<Behavior> = Optional.ofNullable(behavior)

            fun integer(): Optional<Long> = Optional.ofNullable(integer)

            fun isBehavior(): Boolean = behavior != null

            fun isInteger(): Boolean = integer != null

            fun asBehavior(): Behavior = behavior.getOrThrow("behavior")

            fun asInteger(): Long = integer.getOrThrow("integer")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T {
                return when {
                    behavior != null -> visitor.visitBehavior(behavior)
                    integer != null -> visitor.visitInteger(integer)
                    else -> visitor.unknown(_json)
                }
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is BatchSize && behavior == other.behavior && integer == other.integer /* spotless:on */
            }

            override fun hashCode(): Int = /* spotless:off */ Objects.hash(behavior, integer) /* spotless:on */

            override fun toString(): String =
                when {
                    behavior != null -> "BatchSize{behavior=$behavior}"
                    integer != null -> "BatchSize{integer=$integer}"
                    _json != null -> "BatchSize{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid BatchSize")
                }

            companion object {

                @JvmStatic fun ofBehavior(behavior: Behavior) = BatchSize(behavior = behavior)

                @JvmStatic fun ofInteger(integer: Long) = BatchSize(integer = integer)
            }

            interface Visitor<out T> {

                fun visitBehavior(behavior: Behavior): T

                fun visitInteger(integer: Long): T

                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown BatchSize: $json")
                }
            }

            class Deserializer : BaseDeserializer<BatchSize>(BatchSize::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): BatchSize {
                    val json = JsonValue.fromJsonNode(node)

                    tryDeserialize(node, jacksonTypeRef<Behavior>())?.let {
                        return BatchSize(behavior = it, _json = json)
                    }
                    tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                        return BatchSize(integer = it, _json = json)
                    }

                    return BatchSize(_json = json)
                }
            }

            class Serializer : BaseSerializer<BatchSize>(BatchSize::class) {

                override fun serialize(
                    value: BatchSize,
                    generator: JsonGenerator,
                    provider: SerializerProvider
                ) {
                    when {
                        value.behavior != null -> generator.writeObject(value.behavior)
                        value.integer != null -> generator.writeObject(value.integer)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid BatchSize")
                    }
                }
            }

            class Behavior
            @JsonCreator
            private constructor(
                private val value: JsonField<String>,
            ) : Enum {

                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val AUTO = of("auto")

                    @JvmStatic fun of(value: String) = Behavior(JsonField.of(value))
                }

                enum class Known {
                    AUTO,
                }

                enum class Value {
                    AUTO,
                    _UNKNOWN,
                }

                fun value(): Value =
                    when (this) {
                        AUTO -> Value.AUTO
                        else -> Value._UNKNOWN
                    }

                fun known(): Known =
                    when (this) {
                        AUTO -> Known.AUTO
                        else -> throw OpenAIInvalidDataException("Unknown Behavior: $value")
                    }

                fun asString(): String = _value().asStringOrThrow()

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Behavior && value == other.value /* spotless:on */
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }
        }

        /**
         * Scaling factor for the learning rate. A smaller learning rate may be useful to avoid
         * overfitting.
         */
        @JsonDeserialize(using = LearningRateMultiplier.Deserializer::class)
        @JsonSerialize(using = LearningRateMultiplier.Serializer::class)
        class LearningRateMultiplier
        private constructor(
            private val behavior: Behavior? = null,
            private val number: Double? = null,
            private val _json: JsonValue? = null,
        ) {

            fun behavior(): Optional<Behavior> = Optional.ofNullable(behavior)

            fun number(): Optional<Double> = Optional.ofNullable(number)

            fun isBehavior(): Boolean = behavior != null

            fun isNumber(): Boolean = number != null

            fun asBehavior(): Behavior = behavior.getOrThrow("behavior")

            fun asNumber(): Double = number.getOrThrow("number")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T {
                return when {
                    behavior != null -> visitor.visitBehavior(behavior)
                    number != null -> visitor.visitNumber(number)
                    else -> visitor.unknown(_json)
                }
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is LearningRateMultiplier && behavior == other.behavior && number == other.number /* spotless:on */
            }

            override fun hashCode(): Int = /* spotless:off */ Objects.hash(behavior, number) /* spotless:on */

            override fun toString(): String =
                when {
                    behavior != null -> "LearningRateMultiplier{behavior=$behavior}"
                    number != null -> "LearningRateMultiplier{number=$number}"
                    _json != null -> "LearningRateMultiplier{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid LearningRateMultiplier")
                }

            companion object {

                @JvmStatic
                fun ofBehavior(behavior: Behavior) = LearningRateMultiplier(behavior = behavior)

                @JvmStatic fun ofNumber(number: Double) = LearningRateMultiplier(number = number)
            }

            interface Visitor<out T> {

                fun visitBehavior(behavior: Behavior): T

                fun visitNumber(number: Double): T

                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown LearningRateMultiplier: $json")
                }
            }

            class Deserializer :
                BaseDeserializer<LearningRateMultiplier>(LearningRateMultiplier::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): LearningRateMultiplier {
                    val json = JsonValue.fromJsonNode(node)

                    tryDeserialize(node, jacksonTypeRef<Behavior>())?.let {
                        return LearningRateMultiplier(behavior = it, _json = json)
                    }
                    tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                        return LearningRateMultiplier(number = it, _json = json)
                    }

                    return LearningRateMultiplier(_json = json)
                }
            }

            class Serializer :
                BaseSerializer<LearningRateMultiplier>(LearningRateMultiplier::class) {

                override fun serialize(
                    value: LearningRateMultiplier,
                    generator: JsonGenerator,
                    provider: SerializerProvider
                ) {
                    when {
                        value.behavior != null -> generator.writeObject(value.behavior)
                        value.number != null -> generator.writeObject(value.number)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid LearningRateMultiplier")
                    }
                }
            }

            class Behavior
            @JsonCreator
            private constructor(
                private val value: JsonField<String>,
            ) : Enum {

                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val AUTO = of("auto")

                    @JvmStatic fun of(value: String) = Behavior(JsonField.of(value))
                }

                enum class Known {
                    AUTO,
                }

                enum class Value {
                    AUTO,
                    _UNKNOWN,
                }

                fun value(): Value =
                    when (this) {
                        AUTO -> Value.AUTO
                        else -> Value._UNKNOWN
                    }

                fun known(): Known =
                    when (this) {
                        AUTO -> Known.AUTO
                        else -> throw OpenAIInvalidDataException("Unknown Behavior: $value")
                    }

                fun asString(): String = _value().asStringOrThrow()

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Behavior && value == other.value /* spotless:on */
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }
        }

        /**
         * The number of epochs to train the model for. An epoch refers to one full cycle through
         * the training dataset.
         */
        @JsonDeserialize(using = NEpochs.Deserializer::class)
        @JsonSerialize(using = NEpochs.Serializer::class)
        class NEpochs
        private constructor(
            private val behavior: Behavior? = null,
            private val integer: Long? = null,
            private val _json: JsonValue? = null,
        ) {

            fun behavior(): Optional<Behavior> = Optional.ofNullable(behavior)

            fun integer(): Optional<Long> = Optional.ofNullable(integer)

            fun isBehavior(): Boolean = behavior != null

            fun isInteger(): Boolean = integer != null

            fun asBehavior(): Behavior = behavior.getOrThrow("behavior")

            fun asInteger(): Long = integer.getOrThrow("integer")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T {
                return when {
                    behavior != null -> visitor.visitBehavior(behavior)
                    integer != null -> visitor.visitInteger(integer)
                    else -> visitor.unknown(_json)
                }
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is NEpochs && behavior == other.behavior && integer == other.integer /* spotless:on */
            }

            override fun hashCode(): Int = /* spotless:off */ Objects.hash(behavior, integer) /* spotless:on */

            override fun toString(): String =
                when {
                    behavior != null -> "NEpochs{behavior=$behavior}"
                    integer != null -> "NEpochs{integer=$integer}"
                    _json != null -> "NEpochs{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid NEpochs")
                }

            companion object {

                @JvmStatic fun ofBehavior(behavior: Behavior) = NEpochs(behavior = behavior)

                @JvmStatic fun ofInteger(integer: Long) = NEpochs(integer = integer)
            }

            interface Visitor<out T> {

                fun visitBehavior(behavior: Behavior): T

                fun visitInteger(integer: Long): T

                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown NEpochs: $json")
                }
            }

            class Deserializer : BaseDeserializer<NEpochs>(NEpochs::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): NEpochs {
                    val json = JsonValue.fromJsonNode(node)

                    tryDeserialize(node, jacksonTypeRef<Behavior>())?.let {
                        return NEpochs(behavior = it, _json = json)
                    }
                    tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                        return NEpochs(integer = it, _json = json)
                    }

                    return NEpochs(_json = json)
                }
            }

            class Serializer : BaseSerializer<NEpochs>(NEpochs::class) {

                override fun serialize(
                    value: NEpochs,
                    generator: JsonGenerator,
                    provider: SerializerProvider
                ) {
                    when {
                        value.behavior != null -> generator.writeObject(value.behavior)
                        value.integer != null -> generator.writeObject(value.integer)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid NEpochs")
                    }
                }
            }

            class Behavior
            @JsonCreator
            private constructor(
                private val value: JsonField<String>,
            ) : Enum {

                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val AUTO = of("auto")

                    @JvmStatic fun of(value: String) = Behavior(JsonField.of(value))
                }

                enum class Known {
                    AUTO,
                }

                enum class Value {
                    AUTO,
                    _UNKNOWN,
                }

                fun value(): Value =
                    when (this) {
                        AUTO -> Value.AUTO
                        else -> Value._UNKNOWN
                    }

                fun known(): Known =
                    when (this) {
                        AUTO -> Known.AUTO
                        else -> throw OpenAIInvalidDataException("Unknown Behavior: $value")
                    }

                fun asString(): String = _value().asStringOrThrow()

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Behavior && value == other.value /* spotless:on */
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Hyperparameters && batchSize == other.batchSize && learningRateMultiplier == other.learningRateMultiplier && nEpochs == other.nEpochs && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(batchSize, learningRateMultiplier, nEpochs, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Hyperparameters{batchSize=$batchSize, learningRateMultiplier=$learningRateMultiplier, nEpochs=$nEpochs, additionalProperties=$additionalProperties}"
    }

    @NoAutoDetect
    class Integration
    @JsonCreator
    private constructor(
        @JsonProperty("type") private val type: Type,
        @JsonProperty("wandb") private val wandb: Wandb,
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * The type of integration to enable. Currently, only "wandb" (Weights and Biases) is
         * supported.
         */
        @JsonProperty("type") fun type(): Type = type

        /**
         * The settings for your integration with Weights and Biases. This payload specifies the
         * project that metrics will be sent to. Optionally, you can set an explicit display name
         * for your run, add tags to your run, and set a default entity (team, username, etc) to be
         * associated with your run.
         */
        @JsonProperty("wandb") fun wandb(): Wandb = wandb

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var type: Type? = null
            private var wandb: Wandb? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(integration: Integration) = apply {
                type = integration.type
                wandb = integration.wandb
                additionalProperties = integration.additionalProperties.toMutableMap()
            }

            /**
             * The type of integration to enable. Currently, only "wandb" (Weights and Biases) is
             * supported.
             */
            fun type(type: Type) = apply { this.type = type }

            /**
             * The settings for your integration with Weights and Biases. This payload specifies the
             * project that metrics will be sent to. Optionally, you can set an explicit display
             * name for your run, add tags to your run, and set a default entity (team, username,
             * etc) to be associated with your run.
             */
            fun wandb(wandb: Wandb) = apply { this.wandb = wandb }

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

            fun build(): Integration =
                Integration(
                    checkNotNull(type) { "`type` is required but was not set" },
                    checkNotNull(wandb) { "`wandb` is required but was not set" },
                    additionalProperties.toImmutable(),
                )
        }

        class Type
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val WANDB = of("wandb")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            enum class Known {
                WANDB,
            }

            enum class Value {
                WANDB,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    WANDB -> Value.WANDB
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    WANDB -> Known.WANDB
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

        /**
         * The settings for your integration with Weights and Biases. This payload specifies the
         * project that metrics will be sent to. Optionally, you can set an explicit display name
         * for your run, add tags to your run, and set a default entity (team, username, etc) to be
         * associated with your run.
         */
        @NoAutoDetect
        class Wandb
        @JsonCreator
        private constructor(
            @JsonProperty("project") private val project: String,
            @JsonProperty("name") private val name: String?,
            @JsonProperty("entity") private val entity: String?,
            @JsonProperty("tags") private val tags: List<String>?,
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /** The name of the project that the new run will be created under. */
            @JsonProperty("project") fun project(): String = project

            /**
             * A display name to set for the run. If not set, we will use the Job ID as the name.
             */
            @JsonProperty("name") fun name(): Optional<String> = Optional.ofNullable(name)

            /**
             * The entity to use for the run. This allows you to set the team or username of the
             * WandB user that you would like associated with the run. If not set, the default
             * entity for the registered WandB API key is used.
             */
            @JsonProperty("entity") fun entity(): Optional<String> = Optional.ofNullable(entity)

            /**
             * A list of tags to be attached to the newly created run. These tags are passed through
             * directly to WandB. Some default tags are generated by OpenAI: "openai/finetune",
             * "openai/{base-model}", "openai/{ftjob-abcdef}".
             */
            @JsonProperty("tags") fun tags(): Optional<List<String>> = Optional.ofNullable(tags)

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var project: String? = null
                private var name: String? = null
                private var entity: String? = null
                private var tags: MutableList<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(wandb: Wandb) = apply {
                    project = wandb.project
                    name = wandb.name
                    entity = wandb.entity
                    tags = wandb.tags?.toMutableList()
                    additionalProperties = wandb.additionalProperties.toMutableMap()
                }

                /** The name of the project that the new run will be created under. */
                fun project(project: String) = apply { this.project = project }

                /**
                 * A display name to set for the run. If not set, we will use the Job ID as the
                 * name.
                 */
                fun name(name: String) = apply { this.name = name }

                /**
                 * The entity to use for the run. This allows you to set the team or username of the
                 * WandB user that you would like associated with the run. If not set, the default
                 * entity for the registered WandB API key is used.
                 */
                fun entity(entity: String) = apply { this.entity = entity }

                /**
                 * A list of tags to be attached to the newly created run. These tags are passed
                 * through directly to WandB. Some default tags are generated by OpenAI:
                 * "openai/finetune", "openai/{base-model}", "openai/{ftjob-abcdef}".
                 */
                fun tags(tags: List<String>) = apply { this.tags = tags.toMutableList() }

                /**
                 * A list of tags to be attached to the newly created run. These tags are passed
                 * through directly to WandB. Some default tags are generated by OpenAI:
                 * "openai/finetune", "openai/{base-model}", "openai/{ftjob-abcdef}".
                 */
                fun addTag(tag: String) = apply {
                    tags = (tags ?: mutableListOf()).apply { add(tag) }
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

                fun build(): Wandb =
                    Wandb(
                        checkNotNull(project) { "`project` is required but was not set" },
                        name,
                        entity,
                        tags?.toImmutable(),
                        additionalProperties.toImmutable(),
                    )
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Wandb && project == other.project && name == other.name && entity == other.entity && tags == other.tags && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(project, name, entity, tags, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Wandb{project=$project, name=$name, entity=$entity, tags=$tags, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Integration && type == other.type && wandb == other.wandb && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(type, wandb, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Integration{type=$type, wandb=$wandb, additionalProperties=$additionalProperties}"
    }

    /** The method used for fine-tuning. */
    @NoAutoDetect
    class Method
    @JsonCreator
    private constructor(
        @JsonProperty("type") private val type: Type?,
        @JsonProperty("supervised") private val supervised: Supervised?,
        @JsonProperty("dpo") private val dpo: Dpo?,
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The type of method. Is either `supervised` or `dpo`. */
        @JsonProperty("type") fun type(): Optional<Type> = Optional.ofNullable(type)

        /** Configuration for the supervised fine-tuning method. */
        @JsonProperty("supervised")
        fun supervised(): Optional<Supervised> = Optional.ofNullable(supervised)

        /** Configuration for the DPO fine-tuning method. */
        @JsonProperty("dpo") fun dpo(): Optional<Dpo> = Optional.ofNullable(dpo)

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var type: Type? = null
            private var supervised: Supervised? = null
            private var dpo: Dpo? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(method: Method) = apply {
                type = method.type
                supervised = method.supervised
                dpo = method.dpo
                additionalProperties = method.additionalProperties.toMutableMap()
            }

            /** The type of method. Is either `supervised` or `dpo`. */
            fun type(type: Type) = apply { this.type = type }

            /** Configuration for the supervised fine-tuning method. */
            fun supervised(supervised: Supervised) = apply { this.supervised = supervised }

            /** Configuration for the DPO fine-tuning method. */
            fun dpo(dpo: Dpo) = apply { this.dpo = dpo }

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

            fun build(): Method =
                Method(
                    type,
                    supervised,
                    dpo,
                    additionalProperties.toImmutable(),
                )
        }

        /** Configuration for the DPO fine-tuning method. */
        @NoAutoDetect
        class Dpo
        @JsonCreator
        private constructor(
            @JsonProperty("hyperparameters") private val hyperparameters: Hyperparameters?,
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /** The hyperparameters used for the fine-tuning job. */
            @JsonProperty("hyperparameters")
            fun hyperparameters(): Optional<Hyperparameters> = Optional.ofNullable(hyperparameters)

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var hyperparameters: Hyperparameters? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(dpo: Dpo) = apply {
                    hyperparameters = dpo.hyperparameters
                    additionalProperties = dpo.additionalProperties.toMutableMap()
                }

                /** The hyperparameters used for the fine-tuning job. */
                fun hyperparameters(hyperparameters: Hyperparameters) = apply {
                    this.hyperparameters = hyperparameters
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

                fun build(): Dpo = Dpo(hyperparameters, additionalProperties.toImmutable())
            }

            /** The hyperparameters used for the fine-tuning job. */
            @NoAutoDetect
            class Hyperparameters
            @JsonCreator
            private constructor(
                @JsonProperty("beta") private val beta: Beta?,
                @JsonProperty("batch_size") private val batchSize: BatchSize?,
                @JsonProperty("learning_rate_multiplier")
                private val learningRateMultiplier: LearningRateMultiplier?,
                @JsonProperty("n_epochs") private val nEpochs: NEpochs?,
                @JsonAnySetter
                private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
            ) {

                /**
                 * The beta value for the DPO method. A higher beta value will increase the weight
                 * of the penalty between the policy and reference model.
                 */
                @JsonProperty("beta") fun beta(): Optional<Beta> = Optional.ofNullable(beta)

                /**
                 * Number of examples in each batch. A larger batch size means that model parameters
                 * are updated less frequently, but with lower variance.
                 */
                @JsonProperty("batch_size")
                fun batchSize(): Optional<BatchSize> = Optional.ofNullable(batchSize)

                /**
                 * Scaling factor for the learning rate. A smaller learning rate may be useful to
                 * avoid overfitting.
                 */
                @JsonProperty("learning_rate_multiplier")
                fun learningRateMultiplier(): Optional<LearningRateMultiplier> =
                    Optional.ofNullable(learningRateMultiplier)

                /**
                 * The number of epochs to train the model for. An epoch refers to one full cycle
                 * through the training dataset.
                 */
                @JsonProperty("n_epochs")
                fun nEpochs(): Optional<NEpochs> = Optional.ofNullable(nEpochs)

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun toBuilder() = Builder().from(this)

                companion object {

                    @JvmStatic fun builder() = Builder()
                }

                class Builder {

                    private var beta: Beta? = null
                    private var batchSize: BatchSize? = null
                    private var learningRateMultiplier: LearningRateMultiplier? = null
                    private var nEpochs: NEpochs? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(hyperparameters: Hyperparameters) = apply {
                        beta = hyperparameters.beta
                        batchSize = hyperparameters.batchSize
                        learningRateMultiplier = hyperparameters.learningRateMultiplier
                        nEpochs = hyperparameters.nEpochs
                        additionalProperties = hyperparameters.additionalProperties.toMutableMap()
                    }

                    /**
                     * The beta value for the DPO method. A higher beta value will increase the
                     * weight of the penalty between the policy and reference model.
                     */
                    fun beta(beta: Beta) = apply { this.beta = beta }

                    fun beta(auto: Beta.Auto) = apply { this.beta = Beta.ofAuto(auto) }

                    fun beta(manual: Double) = apply { this.beta = Beta.ofManual(manual) }

                    /**
                     * Number of examples in each batch. A larger batch size means that model
                     * parameters are updated less frequently, but with lower variance.
                     */
                    fun batchSize(batchSize: BatchSize) = apply { this.batchSize = batchSize }

                    fun batchSize(auto: BatchSize.Auto) = apply {
                        this.batchSize = BatchSize.ofAuto(auto)
                    }

                    fun batchSize(manual: Long) = apply {
                        this.batchSize = BatchSize.ofManual(manual)
                    }

                    /**
                     * Scaling factor for the learning rate. A smaller learning rate may be useful
                     * to avoid overfitting.
                     */
                    fun learningRateMultiplier(learningRateMultiplier: LearningRateMultiplier) =
                        apply {
                            this.learningRateMultiplier = learningRateMultiplier
                        }

                    fun learningRateMultiplier(auto: LearningRateMultiplier.Auto) = apply {
                        this.learningRateMultiplier = LearningRateMultiplier.ofAuto(auto)
                    }

                    fun learningRateMultiplier(manual: Double) = apply {
                        this.learningRateMultiplier = LearningRateMultiplier.ofManual(manual)
                    }

                    /**
                     * The number of epochs to train the model for. An epoch refers to one full
                     * cycle through the training dataset.
                     */
                    fun nEpochs(nEpochs: NEpochs) = apply { this.nEpochs = nEpochs }

                    fun nEpochs(auto: NEpochs.Auto) = apply { this.nEpochs = NEpochs.ofAuto(auto) }

                    fun nEpochs(manual: Long) = apply { this.nEpochs = NEpochs.ofManual(manual) }

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

                    fun build(): Hyperparameters =
                        Hyperparameters(
                            beta,
                            batchSize,
                            learningRateMultiplier,
                            nEpochs,
                            additionalProperties.toImmutable(),
                        )
                }

                /**
                 * Number of examples in each batch. A larger batch size means that model parameters
                 * are updated less frequently, but with lower variance.
                 */
                @JsonDeserialize(using = BatchSize.Deserializer::class)
                @JsonSerialize(using = BatchSize.Serializer::class)
                class BatchSize
                private constructor(
                    private val auto: Auto? = null,
                    private val manual: Long? = null,
                    private val _json: JsonValue? = null,
                ) {

                    fun auto(): Optional<Auto> = Optional.ofNullable(auto)

                    fun manual(): Optional<Long> = Optional.ofNullable(manual)

                    fun isAuto(): Boolean = auto != null

                    fun isManual(): Boolean = manual != null

                    fun asAuto(): Auto = auto.getOrThrow("auto")

                    fun asManual(): Long = manual.getOrThrow("manual")

                    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                    fun <T> accept(visitor: Visitor<T>): T {
                        return when {
                            auto != null -> visitor.visitAuto(auto)
                            manual != null -> visitor.visitManual(manual)
                            else -> visitor.unknown(_json)
                        }
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is BatchSize && auto == other.auto && manual == other.manual /* spotless:on */
                    }

                    override fun hashCode(): Int = /* spotless:off */ Objects.hash(auto, manual) /* spotless:on */

                    override fun toString(): String =
                        when {
                            auto != null -> "BatchSize{auto=$auto}"
                            manual != null -> "BatchSize{manual=$manual}"
                            _json != null -> "BatchSize{_unknown=$_json}"
                            else -> throw IllegalStateException("Invalid BatchSize")
                        }

                    companion object {

                        @JvmStatic fun ofAuto(auto: Auto) = BatchSize(auto = auto)

                        @JvmStatic fun ofManual(manual: Long) = BatchSize(manual = manual)
                    }

                    interface Visitor<out T> {

                        fun visitAuto(auto: Auto): T

                        fun visitManual(manual: Long): T

                        fun unknown(json: JsonValue?): T {
                            throw OpenAIInvalidDataException("Unknown BatchSize: $json")
                        }
                    }

                    class Deserializer : BaseDeserializer<BatchSize>(BatchSize::class) {

                        override fun ObjectCodec.deserialize(node: JsonNode): BatchSize {
                            val json = JsonValue.fromJsonNode(node)

                            tryDeserialize(node, jacksonTypeRef<Auto>())?.let {
                                return BatchSize(auto = it, _json = json)
                            }
                            tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                                return BatchSize(manual = it, _json = json)
                            }

                            return BatchSize(_json = json)
                        }
                    }

                    class Serializer : BaseSerializer<BatchSize>(BatchSize::class) {

                        override fun serialize(
                            value: BatchSize,
                            generator: JsonGenerator,
                            provider: SerializerProvider
                        ) {
                            when {
                                value.auto != null -> generator.writeObject(value.auto)
                                value.manual != null -> generator.writeObject(value.manual)
                                value._json != null -> generator.writeObject(value._json)
                                else -> throw IllegalStateException("Invalid BatchSize")
                            }
                        }
                    }

                    class Auto
                    @JsonCreator
                    private constructor(
                        private val value: JsonField<String>,
                    ) : Enum {

                        @com.fasterxml.jackson.annotation.JsonValue
                        fun _value(): JsonField<String> = value

                        companion object {

                            @JvmField val AUTO = of("auto")

                            @JvmStatic fun of(value: String) = Auto(JsonField.of(value))
                        }

                        enum class Known {
                            AUTO,
                        }

                        enum class Value {
                            AUTO,
                            _UNKNOWN,
                        }

                        fun value(): Value =
                            when (this) {
                                AUTO -> Value.AUTO
                                else -> Value._UNKNOWN
                            }

                        fun known(): Known =
                            when (this) {
                                AUTO -> Known.AUTO
                                else -> throw OpenAIInvalidDataException("Unknown Auto: $value")
                            }

                        fun asString(): String = _value().asStringOrThrow()

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return /* spotless:off */ other is Auto && value == other.value /* spotless:on */
                        }

                        override fun hashCode() = value.hashCode()

                        override fun toString() = value.toString()
                    }
                }

                /**
                 * The beta value for the DPO method. A higher beta value will increase the weight
                 * of the penalty between the policy and reference model.
                 */
                @JsonDeserialize(using = Beta.Deserializer::class)
                @JsonSerialize(using = Beta.Serializer::class)
                class Beta
                private constructor(
                    private val auto: Auto? = null,
                    private val manual: Double? = null,
                    private val _json: JsonValue? = null,
                ) {

                    fun auto(): Optional<Auto> = Optional.ofNullable(auto)

                    fun manual(): Optional<Double> = Optional.ofNullable(manual)

                    fun isAuto(): Boolean = auto != null

                    fun isManual(): Boolean = manual != null

                    fun asAuto(): Auto = auto.getOrThrow("auto")

                    fun asManual(): Double = manual.getOrThrow("manual")

                    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                    fun <T> accept(visitor: Visitor<T>): T {
                        return when {
                            auto != null -> visitor.visitAuto(auto)
                            manual != null -> visitor.visitManual(manual)
                            else -> visitor.unknown(_json)
                        }
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is Beta && auto == other.auto && manual == other.manual /* spotless:on */
                    }

                    override fun hashCode(): Int = /* spotless:off */ Objects.hash(auto, manual) /* spotless:on */

                    override fun toString(): String =
                        when {
                            auto != null -> "Beta{auto=$auto}"
                            manual != null -> "Beta{manual=$manual}"
                            _json != null -> "Beta{_unknown=$_json}"
                            else -> throw IllegalStateException("Invalid Beta")
                        }

                    companion object {

                        @JvmStatic fun ofAuto(auto: Auto) = Beta(auto = auto)

                        @JvmStatic fun ofManual(manual: Double) = Beta(manual = manual)
                    }

                    interface Visitor<out T> {

                        fun visitAuto(auto: Auto): T

                        fun visitManual(manual: Double): T

                        fun unknown(json: JsonValue?): T {
                            throw OpenAIInvalidDataException("Unknown Beta: $json")
                        }
                    }

                    class Deserializer : BaseDeserializer<Beta>(Beta::class) {

                        override fun ObjectCodec.deserialize(node: JsonNode): Beta {
                            val json = JsonValue.fromJsonNode(node)

                            tryDeserialize(node, jacksonTypeRef<Auto>())?.let {
                                return Beta(auto = it, _json = json)
                            }
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                return Beta(manual = it, _json = json)
                            }

                            return Beta(_json = json)
                        }
                    }

                    class Serializer : BaseSerializer<Beta>(Beta::class) {

                        override fun serialize(
                            value: Beta,
                            generator: JsonGenerator,
                            provider: SerializerProvider
                        ) {
                            when {
                                value.auto != null -> generator.writeObject(value.auto)
                                value.manual != null -> generator.writeObject(value.manual)
                                value._json != null -> generator.writeObject(value._json)
                                else -> throw IllegalStateException("Invalid Beta")
                            }
                        }
                    }

                    class Auto
                    @JsonCreator
                    private constructor(
                        private val value: JsonField<String>,
                    ) : Enum {

                        @com.fasterxml.jackson.annotation.JsonValue
                        fun _value(): JsonField<String> = value

                        companion object {

                            @JvmField val AUTO = of("auto")

                            @JvmStatic fun of(value: String) = Auto(JsonField.of(value))
                        }

                        enum class Known {
                            AUTO,
                        }

                        enum class Value {
                            AUTO,
                            _UNKNOWN,
                        }

                        fun value(): Value =
                            when (this) {
                                AUTO -> Value.AUTO
                                else -> Value._UNKNOWN
                            }

                        fun known(): Known =
                            when (this) {
                                AUTO -> Known.AUTO
                                else -> throw OpenAIInvalidDataException("Unknown Auto: $value")
                            }

                        fun asString(): String = _value().asStringOrThrow()

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return /* spotless:off */ other is Auto && value == other.value /* spotless:on */
                        }

                        override fun hashCode() = value.hashCode()

                        override fun toString() = value.toString()
                    }
                }

                /**
                 * Scaling factor for the learning rate. A smaller learning rate may be useful to
                 * avoid overfitting.
                 */
                @JsonDeserialize(using = LearningRateMultiplier.Deserializer::class)
                @JsonSerialize(using = LearningRateMultiplier.Serializer::class)
                class LearningRateMultiplier
                private constructor(
                    private val auto: Auto? = null,
                    private val manual: Double? = null,
                    private val _json: JsonValue? = null,
                ) {

                    fun auto(): Optional<Auto> = Optional.ofNullable(auto)

                    fun manual(): Optional<Double> = Optional.ofNullable(manual)

                    fun isAuto(): Boolean = auto != null

                    fun isManual(): Boolean = manual != null

                    fun asAuto(): Auto = auto.getOrThrow("auto")

                    fun asManual(): Double = manual.getOrThrow("manual")

                    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                    fun <T> accept(visitor: Visitor<T>): T {
                        return when {
                            auto != null -> visitor.visitAuto(auto)
                            manual != null -> visitor.visitManual(manual)
                            else -> visitor.unknown(_json)
                        }
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is LearningRateMultiplier && auto == other.auto && manual == other.manual /* spotless:on */
                    }

                    override fun hashCode(): Int = /* spotless:off */ Objects.hash(auto, manual) /* spotless:on */

                    override fun toString(): String =
                        when {
                            auto != null -> "LearningRateMultiplier{auto=$auto}"
                            manual != null -> "LearningRateMultiplier{manual=$manual}"
                            _json != null -> "LearningRateMultiplier{_unknown=$_json}"
                            else -> throw IllegalStateException("Invalid LearningRateMultiplier")
                        }

                    companion object {

                        @JvmStatic fun ofAuto(auto: Auto) = LearningRateMultiplier(auto = auto)

                        @JvmStatic
                        fun ofManual(manual: Double) = LearningRateMultiplier(manual = manual)
                    }

                    interface Visitor<out T> {

                        fun visitAuto(auto: Auto): T

                        fun visitManual(manual: Double): T

                        fun unknown(json: JsonValue?): T {
                            throw OpenAIInvalidDataException(
                                "Unknown LearningRateMultiplier: $json"
                            )
                        }
                    }

                    class Deserializer :
                        BaseDeserializer<LearningRateMultiplier>(LearningRateMultiplier::class) {

                        override fun ObjectCodec.deserialize(
                            node: JsonNode
                        ): LearningRateMultiplier {
                            val json = JsonValue.fromJsonNode(node)

                            tryDeserialize(node, jacksonTypeRef<Auto>())?.let {
                                return LearningRateMultiplier(auto = it, _json = json)
                            }
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                return LearningRateMultiplier(manual = it, _json = json)
                            }

                            return LearningRateMultiplier(_json = json)
                        }
                    }

                    class Serializer :
                        BaseSerializer<LearningRateMultiplier>(LearningRateMultiplier::class) {

                        override fun serialize(
                            value: LearningRateMultiplier,
                            generator: JsonGenerator,
                            provider: SerializerProvider
                        ) {
                            when {
                                value.auto != null -> generator.writeObject(value.auto)
                                value.manual != null -> generator.writeObject(value.manual)
                                value._json != null -> generator.writeObject(value._json)
                                else ->
                                    throw IllegalStateException("Invalid LearningRateMultiplier")
                            }
                        }
                    }

                    class Auto
                    @JsonCreator
                    private constructor(
                        private val value: JsonField<String>,
                    ) : Enum {

                        @com.fasterxml.jackson.annotation.JsonValue
                        fun _value(): JsonField<String> = value

                        companion object {

                            @JvmField val AUTO = of("auto")

                            @JvmStatic fun of(value: String) = Auto(JsonField.of(value))
                        }

                        enum class Known {
                            AUTO,
                        }

                        enum class Value {
                            AUTO,
                            _UNKNOWN,
                        }

                        fun value(): Value =
                            when (this) {
                                AUTO -> Value.AUTO
                                else -> Value._UNKNOWN
                            }

                        fun known(): Known =
                            when (this) {
                                AUTO -> Known.AUTO
                                else -> throw OpenAIInvalidDataException("Unknown Auto: $value")
                            }

                        fun asString(): String = _value().asStringOrThrow()

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return /* spotless:off */ other is Auto && value == other.value /* spotless:on */
                        }

                        override fun hashCode() = value.hashCode()

                        override fun toString() = value.toString()
                    }
                }

                /**
                 * The number of epochs to train the model for. An epoch refers to one full cycle
                 * through the training dataset.
                 */
                @JsonDeserialize(using = NEpochs.Deserializer::class)
                @JsonSerialize(using = NEpochs.Serializer::class)
                class NEpochs
                private constructor(
                    private val auto: Auto? = null,
                    private val manual: Long? = null,
                    private val _json: JsonValue? = null,
                ) {

                    fun auto(): Optional<Auto> = Optional.ofNullable(auto)

                    fun manual(): Optional<Long> = Optional.ofNullable(manual)

                    fun isAuto(): Boolean = auto != null

                    fun isManual(): Boolean = manual != null

                    fun asAuto(): Auto = auto.getOrThrow("auto")

                    fun asManual(): Long = manual.getOrThrow("manual")

                    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                    fun <T> accept(visitor: Visitor<T>): T {
                        return when {
                            auto != null -> visitor.visitAuto(auto)
                            manual != null -> visitor.visitManual(manual)
                            else -> visitor.unknown(_json)
                        }
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is NEpochs && auto == other.auto && manual == other.manual /* spotless:on */
                    }

                    override fun hashCode(): Int = /* spotless:off */ Objects.hash(auto, manual) /* spotless:on */

                    override fun toString(): String =
                        when {
                            auto != null -> "NEpochs{auto=$auto}"
                            manual != null -> "NEpochs{manual=$manual}"
                            _json != null -> "NEpochs{_unknown=$_json}"
                            else -> throw IllegalStateException("Invalid NEpochs")
                        }

                    companion object {

                        @JvmStatic fun ofAuto(auto: Auto) = NEpochs(auto = auto)

                        @JvmStatic fun ofManual(manual: Long) = NEpochs(manual = manual)
                    }

                    interface Visitor<out T> {

                        fun visitAuto(auto: Auto): T

                        fun visitManual(manual: Long): T

                        fun unknown(json: JsonValue?): T {
                            throw OpenAIInvalidDataException("Unknown NEpochs: $json")
                        }
                    }

                    class Deserializer : BaseDeserializer<NEpochs>(NEpochs::class) {

                        override fun ObjectCodec.deserialize(node: JsonNode): NEpochs {
                            val json = JsonValue.fromJsonNode(node)

                            tryDeserialize(node, jacksonTypeRef<Auto>())?.let {
                                return NEpochs(auto = it, _json = json)
                            }
                            tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                                return NEpochs(manual = it, _json = json)
                            }

                            return NEpochs(_json = json)
                        }
                    }

                    class Serializer : BaseSerializer<NEpochs>(NEpochs::class) {

                        override fun serialize(
                            value: NEpochs,
                            generator: JsonGenerator,
                            provider: SerializerProvider
                        ) {
                            when {
                                value.auto != null -> generator.writeObject(value.auto)
                                value.manual != null -> generator.writeObject(value.manual)
                                value._json != null -> generator.writeObject(value._json)
                                else -> throw IllegalStateException("Invalid NEpochs")
                            }
                        }
                    }

                    class Auto
                    @JsonCreator
                    private constructor(
                        private val value: JsonField<String>,
                    ) : Enum {

                        @com.fasterxml.jackson.annotation.JsonValue
                        fun _value(): JsonField<String> = value

                        companion object {

                            @JvmField val AUTO = of("auto")

                            @JvmStatic fun of(value: String) = Auto(JsonField.of(value))
                        }

                        enum class Known {
                            AUTO,
                        }

                        enum class Value {
                            AUTO,
                            _UNKNOWN,
                        }

                        fun value(): Value =
                            when (this) {
                                AUTO -> Value.AUTO
                                else -> Value._UNKNOWN
                            }

                        fun known(): Known =
                            when (this) {
                                AUTO -> Known.AUTO
                                else -> throw OpenAIInvalidDataException("Unknown Auto: $value")
                            }

                        fun asString(): String = _value().asStringOrThrow()

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return /* spotless:off */ other is Auto && value == other.value /* spotless:on */
                        }

                        override fun hashCode() = value.hashCode()

                        override fun toString() = value.toString()
                    }
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Hyperparameters && beta == other.beta && batchSize == other.batchSize && learningRateMultiplier == other.learningRateMultiplier && nEpochs == other.nEpochs && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(beta, batchSize, learningRateMultiplier, nEpochs, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Hyperparameters{beta=$beta, batchSize=$batchSize, learningRateMultiplier=$learningRateMultiplier, nEpochs=$nEpochs, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Dpo && hyperparameters == other.hyperparameters && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(hyperparameters, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Dpo{hyperparameters=$hyperparameters, additionalProperties=$additionalProperties}"
        }

        /** Configuration for the supervised fine-tuning method. */
        @NoAutoDetect
        class Supervised
        @JsonCreator
        private constructor(
            @JsonProperty("hyperparameters") private val hyperparameters: Hyperparameters?,
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /** The hyperparameters used for the fine-tuning job. */
            @JsonProperty("hyperparameters")
            fun hyperparameters(): Optional<Hyperparameters> = Optional.ofNullable(hyperparameters)

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var hyperparameters: Hyperparameters? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(supervised: Supervised) = apply {
                    hyperparameters = supervised.hyperparameters
                    additionalProperties = supervised.additionalProperties.toMutableMap()
                }

                /** The hyperparameters used for the fine-tuning job. */
                fun hyperparameters(hyperparameters: Hyperparameters) = apply {
                    this.hyperparameters = hyperparameters
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

                fun build(): Supervised =
                    Supervised(hyperparameters, additionalProperties.toImmutable())
            }

            /** The hyperparameters used for the fine-tuning job. */
            @NoAutoDetect
            class Hyperparameters
            @JsonCreator
            private constructor(
                @JsonProperty("batch_size") private val batchSize: BatchSize?,
                @JsonProperty("learning_rate_multiplier")
                private val learningRateMultiplier: LearningRateMultiplier?,
                @JsonProperty("n_epochs") private val nEpochs: NEpochs?,
                @JsonAnySetter
                private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
            ) {

                /**
                 * Number of examples in each batch. A larger batch size means that model parameters
                 * are updated less frequently, but with lower variance.
                 */
                @JsonProperty("batch_size")
                fun batchSize(): Optional<BatchSize> = Optional.ofNullable(batchSize)

                /**
                 * Scaling factor for the learning rate. A smaller learning rate may be useful to
                 * avoid overfitting.
                 */
                @JsonProperty("learning_rate_multiplier")
                fun learningRateMultiplier(): Optional<LearningRateMultiplier> =
                    Optional.ofNullable(learningRateMultiplier)

                /**
                 * The number of epochs to train the model for. An epoch refers to one full cycle
                 * through the training dataset.
                 */
                @JsonProperty("n_epochs")
                fun nEpochs(): Optional<NEpochs> = Optional.ofNullable(nEpochs)

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun toBuilder() = Builder().from(this)

                companion object {

                    @JvmStatic fun builder() = Builder()
                }

                class Builder {

                    private var batchSize: BatchSize? = null
                    private var learningRateMultiplier: LearningRateMultiplier? = null
                    private var nEpochs: NEpochs? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(hyperparameters: Hyperparameters) = apply {
                        batchSize = hyperparameters.batchSize
                        learningRateMultiplier = hyperparameters.learningRateMultiplier
                        nEpochs = hyperparameters.nEpochs
                        additionalProperties = hyperparameters.additionalProperties.toMutableMap()
                    }

                    /**
                     * Number of examples in each batch. A larger batch size means that model
                     * parameters are updated less frequently, but with lower variance.
                     */
                    fun batchSize(batchSize: BatchSize) = apply { this.batchSize = batchSize }

                    fun batchSize(auto: BatchSize.Auto) = apply {
                        this.batchSize = BatchSize.ofAuto(auto)
                    }

                    fun batchSize(manual: Long) = apply {
                        this.batchSize = BatchSize.ofManual(manual)
                    }

                    /**
                     * Scaling factor for the learning rate. A smaller learning rate may be useful
                     * to avoid overfitting.
                     */
                    fun learningRateMultiplier(learningRateMultiplier: LearningRateMultiplier) =
                        apply {
                            this.learningRateMultiplier = learningRateMultiplier
                        }

                    fun learningRateMultiplier(auto: LearningRateMultiplier.Auto) = apply {
                        this.learningRateMultiplier = LearningRateMultiplier.ofAuto(auto)
                    }

                    fun learningRateMultiplier(manual: Double) = apply {
                        this.learningRateMultiplier = LearningRateMultiplier.ofManual(manual)
                    }

                    /**
                     * The number of epochs to train the model for. An epoch refers to one full
                     * cycle through the training dataset.
                     */
                    fun nEpochs(nEpochs: NEpochs) = apply { this.nEpochs = nEpochs }

                    fun nEpochs(auto: NEpochs.Auto) = apply { this.nEpochs = NEpochs.ofAuto(auto) }

                    fun nEpochs(manual: Long) = apply { this.nEpochs = NEpochs.ofManual(manual) }

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

                    fun build(): Hyperparameters =
                        Hyperparameters(
                            batchSize,
                            learningRateMultiplier,
                            nEpochs,
                            additionalProperties.toImmutable(),
                        )
                }

                /**
                 * Number of examples in each batch. A larger batch size means that model parameters
                 * are updated less frequently, but with lower variance.
                 */
                @JsonDeserialize(using = BatchSize.Deserializer::class)
                @JsonSerialize(using = BatchSize.Serializer::class)
                class BatchSize
                private constructor(
                    private val auto: Auto? = null,
                    private val manual: Long? = null,
                    private val _json: JsonValue? = null,
                ) {

                    fun auto(): Optional<Auto> = Optional.ofNullable(auto)

                    fun manual(): Optional<Long> = Optional.ofNullable(manual)

                    fun isAuto(): Boolean = auto != null

                    fun isManual(): Boolean = manual != null

                    fun asAuto(): Auto = auto.getOrThrow("auto")

                    fun asManual(): Long = manual.getOrThrow("manual")

                    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                    fun <T> accept(visitor: Visitor<T>): T {
                        return when {
                            auto != null -> visitor.visitAuto(auto)
                            manual != null -> visitor.visitManual(manual)
                            else -> visitor.unknown(_json)
                        }
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is BatchSize && auto == other.auto && manual == other.manual /* spotless:on */
                    }

                    override fun hashCode(): Int = /* spotless:off */ Objects.hash(auto, manual) /* spotless:on */

                    override fun toString(): String =
                        when {
                            auto != null -> "BatchSize{auto=$auto}"
                            manual != null -> "BatchSize{manual=$manual}"
                            _json != null -> "BatchSize{_unknown=$_json}"
                            else -> throw IllegalStateException("Invalid BatchSize")
                        }

                    companion object {

                        @JvmStatic fun ofAuto(auto: Auto) = BatchSize(auto = auto)

                        @JvmStatic fun ofManual(manual: Long) = BatchSize(manual = manual)
                    }

                    interface Visitor<out T> {

                        fun visitAuto(auto: Auto): T

                        fun visitManual(manual: Long): T

                        fun unknown(json: JsonValue?): T {
                            throw OpenAIInvalidDataException("Unknown BatchSize: $json")
                        }
                    }

                    class Deserializer : BaseDeserializer<BatchSize>(BatchSize::class) {

                        override fun ObjectCodec.deserialize(node: JsonNode): BatchSize {
                            val json = JsonValue.fromJsonNode(node)

                            tryDeserialize(node, jacksonTypeRef<Auto>())?.let {
                                return BatchSize(auto = it, _json = json)
                            }
                            tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                                return BatchSize(manual = it, _json = json)
                            }

                            return BatchSize(_json = json)
                        }
                    }

                    class Serializer : BaseSerializer<BatchSize>(BatchSize::class) {

                        override fun serialize(
                            value: BatchSize,
                            generator: JsonGenerator,
                            provider: SerializerProvider
                        ) {
                            when {
                                value.auto != null -> generator.writeObject(value.auto)
                                value.manual != null -> generator.writeObject(value.manual)
                                value._json != null -> generator.writeObject(value._json)
                                else -> throw IllegalStateException("Invalid BatchSize")
                            }
                        }
                    }

                    class Auto
                    @JsonCreator
                    private constructor(
                        private val value: JsonField<String>,
                    ) : Enum {

                        @com.fasterxml.jackson.annotation.JsonValue
                        fun _value(): JsonField<String> = value

                        companion object {

                            @JvmField val AUTO = of("auto")

                            @JvmStatic fun of(value: String) = Auto(JsonField.of(value))
                        }

                        enum class Known {
                            AUTO,
                        }

                        enum class Value {
                            AUTO,
                            _UNKNOWN,
                        }

                        fun value(): Value =
                            when (this) {
                                AUTO -> Value.AUTO
                                else -> Value._UNKNOWN
                            }

                        fun known(): Known =
                            when (this) {
                                AUTO -> Known.AUTO
                                else -> throw OpenAIInvalidDataException("Unknown Auto: $value")
                            }

                        fun asString(): String = _value().asStringOrThrow()

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return /* spotless:off */ other is Auto && value == other.value /* spotless:on */
                        }

                        override fun hashCode() = value.hashCode()

                        override fun toString() = value.toString()
                    }
                }

                /**
                 * Scaling factor for the learning rate. A smaller learning rate may be useful to
                 * avoid overfitting.
                 */
                @JsonDeserialize(using = LearningRateMultiplier.Deserializer::class)
                @JsonSerialize(using = LearningRateMultiplier.Serializer::class)
                class LearningRateMultiplier
                private constructor(
                    private val auto: Auto? = null,
                    private val manual: Double? = null,
                    private val _json: JsonValue? = null,
                ) {

                    fun auto(): Optional<Auto> = Optional.ofNullable(auto)

                    fun manual(): Optional<Double> = Optional.ofNullable(manual)

                    fun isAuto(): Boolean = auto != null

                    fun isManual(): Boolean = manual != null

                    fun asAuto(): Auto = auto.getOrThrow("auto")

                    fun asManual(): Double = manual.getOrThrow("manual")

                    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                    fun <T> accept(visitor: Visitor<T>): T {
                        return when {
                            auto != null -> visitor.visitAuto(auto)
                            manual != null -> visitor.visitManual(manual)
                            else -> visitor.unknown(_json)
                        }
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is LearningRateMultiplier && auto == other.auto && manual == other.manual /* spotless:on */
                    }

                    override fun hashCode(): Int = /* spotless:off */ Objects.hash(auto, manual) /* spotless:on */

                    override fun toString(): String =
                        when {
                            auto != null -> "LearningRateMultiplier{auto=$auto}"
                            manual != null -> "LearningRateMultiplier{manual=$manual}"
                            _json != null -> "LearningRateMultiplier{_unknown=$_json}"
                            else -> throw IllegalStateException("Invalid LearningRateMultiplier")
                        }

                    companion object {

                        @JvmStatic fun ofAuto(auto: Auto) = LearningRateMultiplier(auto = auto)

                        @JvmStatic
                        fun ofManual(manual: Double) = LearningRateMultiplier(manual = manual)
                    }

                    interface Visitor<out T> {

                        fun visitAuto(auto: Auto): T

                        fun visitManual(manual: Double): T

                        fun unknown(json: JsonValue?): T {
                            throw OpenAIInvalidDataException(
                                "Unknown LearningRateMultiplier: $json"
                            )
                        }
                    }

                    class Deserializer :
                        BaseDeserializer<LearningRateMultiplier>(LearningRateMultiplier::class) {

                        override fun ObjectCodec.deserialize(
                            node: JsonNode
                        ): LearningRateMultiplier {
                            val json = JsonValue.fromJsonNode(node)

                            tryDeserialize(node, jacksonTypeRef<Auto>())?.let {
                                return LearningRateMultiplier(auto = it, _json = json)
                            }
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                return LearningRateMultiplier(manual = it, _json = json)
                            }

                            return LearningRateMultiplier(_json = json)
                        }
                    }

                    class Serializer :
                        BaseSerializer<LearningRateMultiplier>(LearningRateMultiplier::class) {

                        override fun serialize(
                            value: LearningRateMultiplier,
                            generator: JsonGenerator,
                            provider: SerializerProvider
                        ) {
                            when {
                                value.auto != null -> generator.writeObject(value.auto)
                                value.manual != null -> generator.writeObject(value.manual)
                                value._json != null -> generator.writeObject(value._json)
                                else ->
                                    throw IllegalStateException("Invalid LearningRateMultiplier")
                            }
                        }
                    }

                    class Auto
                    @JsonCreator
                    private constructor(
                        private val value: JsonField<String>,
                    ) : Enum {

                        @com.fasterxml.jackson.annotation.JsonValue
                        fun _value(): JsonField<String> = value

                        companion object {

                            @JvmField val AUTO = of("auto")

                            @JvmStatic fun of(value: String) = Auto(JsonField.of(value))
                        }

                        enum class Known {
                            AUTO,
                        }

                        enum class Value {
                            AUTO,
                            _UNKNOWN,
                        }

                        fun value(): Value =
                            when (this) {
                                AUTO -> Value.AUTO
                                else -> Value._UNKNOWN
                            }

                        fun known(): Known =
                            when (this) {
                                AUTO -> Known.AUTO
                                else -> throw OpenAIInvalidDataException("Unknown Auto: $value")
                            }

                        fun asString(): String = _value().asStringOrThrow()

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return /* spotless:off */ other is Auto && value == other.value /* spotless:on */
                        }

                        override fun hashCode() = value.hashCode()

                        override fun toString() = value.toString()
                    }
                }

                /**
                 * The number of epochs to train the model for. An epoch refers to one full cycle
                 * through the training dataset.
                 */
                @JsonDeserialize(using = NEpochs.Deserializer::class)
                @JsonSerialize(using = NEpochs.Serializer::class)
                class NEpochs
                private constructor(
                    private val auto: Auto? = null,
                    private val manual: Long? = null,
                    private val _json: JsonValue? = null,
                ) {

                    fun auto(): Optional<Auto> = Optional.ofNullable(auto)

                    fun manual(): Optional<Long> = Optional.ofNullable(manual)

                    fun isAuto(): Boolean = auto != null

                    fun isManual(): Boolean = manual != null

                    fun asAuto(): Auto = auto.getOrThrow("auto")

                    fun asManual(): Long = manual.getOrThrow("manual")

                    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                    fun <T> accept(visitor: Visitor<T>): T {
                        return when {
                            auto != null -> visitor.visitAuto(auto)
                            manual != null -> visitor.visitManual(manual)
                            else -> visitor.unknown(_json)
                        }
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is NEpochs && auto == other.auto && manual == other.manual /* spotless:on */
                    }

                    override fun hashCode(): Int = /* spotless:off */ Objects.hash(auto, manual) /* spotless:on */

                    override fun toString(): String =
                        when {
                            auto != null -> "NEpochs{auto=$auto}"
                            manual != null -> "NEpochs{manual=$manual}"
                            _json != null -> "NEpochs{_unknown=$_json}"
                            else -> throw IllegalStateException("Invalid NEpochs")
                        }

                    companion object {

                        @JvmStatic fun ofAuto(auto: Auto) = NEpochs(auto = auto)

                        @JvmStatic fun ofManual(manual: Long) = NEpochs(manual = manual)
                    }

                    interface Visitor<out T> {

                        fun visitAuto(auto: Auto): T

                        fun visitManual(manual: Long): T

                        fun unknown(json: JsonValue?): T {
                            throw OpenAIInvalidDataException("Unknown NEpochs: $json")
                        }
                    }

                    class Deserializer : BaseDeserializer<NEpochs>(NEpochs::class) {

                        override fun ObjectCodec.deserialize(node: JsonNode): NEpochs {
                            val json = JsonValue.fromJsonNode(node)

                            tryDeserialize(node, jacksonTypeRef<Auto>())?.let {
                                return NEpochs(auto = it, _json = json)
                            }
                            tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                                return NEpochs(manual = it, _json = json)
                            }

                            return NEpochs(_json = json)
                        }
                    }

                    class Serializer : BaseSerializer<NEpochs>(NEpochs::class) {

                        override fun serialize(
                            value: NEpochs,
                            generator: JsonGenerator,
                            provider: SerializerProvider
                        ) {
                            when {
                                value.auto != null -> generator.writeObject(value.auto)
                                value.manual != null -> generator.writeObject(value.manual)
                                value._json != null -> generator.writeObject(value._json)
                                else -> throw IllegalStateException("Invalid NEpochs")
                            }
                        }
                    }

                    class Auto
                    @JsonCreator
                    private constructor(
                        private val value: JsonField<String>,
                    ) : Enum {

                        @com.fasterxml.jackson.annotation.JsonValue
                        fun _value(): JsonField<String> = value

                        companion object {

                            @JvmField val AUTO = of("auto")

                            @JvmStatic fun of(value: String) = Auto(JsonField.of(value))
                        }

                        enum class Known {
                            AUTO,
                        }

                        enum class Value {
                            AUTO,
                            _UNKNOWN,
                        }

                        fun value(): Value =
                            when (this) {
                                AUTO -> Value.AUTO
                                else -> Value._UNKNOWN
                            }

                        fun known(): Known =
                            when (this) {
                                AUTO -> Known.AUTO
                                else -> throw OpenAIInvalidDataException("Unknown Auto: $value")
                            }

                        fun asString(): String = _value().asStringOrThrow()

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return /* spotless:off */ other is Auto && value == other.value /* spotless:on */
                        }

                        override fun hashCode() = value.hashCode()

                        override fun toString() = value.toString()
                    }
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Hyperparameters && batchSize == other.batchSize && learningRateMultiplier == other.learningRateMultiplier && nEpochs == other.nEpochs && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(batchSize, learningRateMultiplier, nEpochs, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Hyperparameters{batchSize=$batchSize, learningRateMultiplier=$learningRateMultiplier, nEpochs=$nEpochs, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Supervised && hyperparameters == other.hyperparameters && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(hyperparameters, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Supervised{hyperparameters=$hyperparameters, additionalProperties=$additionalProperties}"
        }

        class Type
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val SUPERVISED = of("supervised")

                @JvmField val DPO = of("dpo")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            enum class Known {
                SUPERVISED,
                DPO,
            }

            enum class Value {
                SUPERVISED,
                DPO,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    SUPERVISED -> Value.SUPERVISED
                    DPO -> Value.DPO
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    SUPERVISED -> Known.SUPERVISED
                    DPO -> Known.DPO
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

            return /* spotless:off */ other is Method && type == other.type && supervised == other.supervised && dpo == other.dpo && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(type, supervised, dpo, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Method{type=$type, supervised=$supervised, dpo=$dpo, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FineTuningJobCreateParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "FineTuningJobCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
