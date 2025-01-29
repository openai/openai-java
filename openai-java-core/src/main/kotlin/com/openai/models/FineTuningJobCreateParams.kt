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

/**
 * Creates a fine-tuning job which begins the process of creating a new model from a given dataset.
 *
 * Response includes details of the enqueued job including job status and the name of the fine-tuned
 * models once complete.
 *
 * [Learn more about fine-tuning](https://platform.openai.com/docs/guides/fine-tuning)
 */
class FineTuningJobCreateParams
private constructor(
    private val body: FineTuningJobCreateBody,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

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
    @Deprecated("deprecated")
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

    /**
     * The name of the model to fine-tune. You can select one of the
     * [supported models](https://platform.openai.com/docs/guides/fine-tuning#which-models-can-be-fine-tuned).
     */
    fun _model(): JsonField<Model> = body._model()

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
    fun _trainingFile(): JsonField<String> = body._trainingFile()

    /**
     * The hyperparameters used for the fine-tuning job. This value is now deprecated in favor of
     * `method`, and should be passed in under the `method` parameter.
     */
    @Deprecated("deprecated")
    fun _hyperparameters(): JsonField<Hyperparameters> = body._hyperparameters()

    /** A list of integrations to enable for your fine-tuning job. */
    fun _integrations(): JsonField<List<Integration>> = body._integrations()

    /** The method used for fine-tuning. */
    fun _method(): JsonField<Method> = body._method()

    /**
     * The seed controls the reproducibility of the job. Passing in the same seed and job parameters
     * should produce the same results, but may differ in rare cases. If a seed is not specified,
     * one will be generated for you.
     */
    fun _seed(): JsonField<Long> = body._seed()

    /**
     * A string of up to 64 characters that will be added to your fine-tuned model name.
     *
     * For example, a `suffix` of "custom-model-name" would produce a model name like
     * `ft:gpt-4o-mini:openai:custom-model-name:7p4lURel`.
     */
    fun _suffix(): JsonField<String> = body._suffix()

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
    fun _validationFile(): JsonField<String> = body._validationFile()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic internal fun _body(): FineTuningJobCreateBody = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    @NoAutoDetect
    class FineTuningJobCreateBody
    @JsonCreator
    internal constructor(
        @JsonProperty("model")
        @ExcludeMissing
        private val model: JsonField<Model> = JsonMissing.of(),
        @JsonProperty("training_file")
        @ExcludeMissing
        private val trainingFile: JsonField<String> = JsonMissing.of(),
        @JsonProperty("hyperparameters")
        @ExcludeMissing
        private val hyperparameters: JsonField<Hyperparameters> = JsonMissing.of(),
        @JsonProperty("integrations")
        @ExcludeMissing
        private val integrations: JsonField<List<Integration>> = JsonMissing.of(),
        @JsonProperty("method")
        @ExcludeMissing
        private val method: JsonField<Method> = JsonMissing.of(),
        @JsonProperty("seed") @ExcludeMissing private val seed: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("suffix")
        @ExcludeMissing
        private val suffix: JsonField<String> = JsonMissing.of(),
        @JsonProperty("validation_file")
        @ExcludeMissing
        private val validationFile: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * The name of the model to fine-tune. You can select one of the
         * [supported models](https://platform.openai.com/docs/guides/fine-tuning#which-models-can-be-fine-tuned).
         */
        fun model(): Model = model.getRequired("model")

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
        fun trainingFile(): String = trainingFile.getRequired("training_file")

        /**
         * The hyperparameters used for the fine-tuning job. This value is now deprecated in favor
         * of `method`, and should be passed in under the `method` parameter.
         */
        @Deprecated("deprecated")
        fun hyperparameters(): Optional<Hyperparameters> =
            Optional.ofNullable(hyperparameters.getNullable("hyperparameters"))

        /** A list of integrations to enable for your fine-tuning job. */
        fun integrations(): Optional<List<Integration>> =
            Optional.ofNullable(integrations.getNullable("integrations"))

        /** The method used for fine-tuning. */
        fun method(): Optional<Method> = Optional.ofNullable(method.getNullable("method"))

        /**
         * The seed controls the reproducibility of the job. Passing in the same seed and job
         * parameters should produce the same results, but may differ in rare cases. If a seed is
         * not specified, one will be generated for you.
         */
        fun seed(): Optional<Long> = Optional.ofNullable(seed.getNullable("seed"))

        /**
         * A string of up to 64 characters that will be added to your fine-tuned model name.
         *
         * For example, a `suffix` of "custom-model-name" would produce a model name like
         * `ft:gpt-4o-mini:openai:custom-model-name:7p4lURel`.
         */
        fun suffix(): Optional<String> = Optional.ofNullable(suffix.getNullable("suffix"))

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
        fun validationFile(): Optional<String> =
            Optional.ofNullable(validationFile.getNullable("validation_file"))

        /**
         * The name of the model to fine-tune. You can select one of the
         * [supported models](https://platform.openai.com/docs/guides/fine-tuning#which-models-can-be-fine-tuned).
         */
        @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<Model> = model

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
        @JsonProperty("training_file")
        @ExcludeMissing
        fun _trainingFile(): JsonField<String> = trainingFile

        /**
         * The hyperparameters used for the fine-tuning job. This value is now deprecated in favor
         * of `method`, and should be passed in under the `method` parameter.
         */
        @Deprecated("deprecated")
        @JsonProperty("hyperparameters")
        @ExcludeMissing
        fun _hyperparameters(): JsonField<Hyperparameters> = hyperparameters

        /** A list of integrations to enable for your fine-tuning job. */
        @JsonProperty("integrations")
        @ExcludeMissing
        fun _integrations(): JsonField<List<Integration>> = integrations

        /** The method used for fine-tuning. */
        @JsonProperty("method") @ExcludeMissing fun _method(): JsonField<Method> = method

        /**
         * The seed controls the reproducibility of the job. Passing in the same seed and job
         * parameters should produce the same results, but may differ in rare cases. If a seed is
         * not specified, one will be generated for you.
         */
        @JsonProperty("seed") @ExcludeMissing fun _seed(): JsonField<Long> = seed

        /**
         * A string of up to 64 characters that will be added to your fine-tuned model name.
         *
         * For example, a `suffix` of "custom-model-name" would produce a model name like
         * `ft:gpt-4o-mini:openai:custom-model-name:7p4lURel`.
         */
        @JsonProperty("suffix") @ExcludeMissing fun _suffix(): JsonField<String> = suffix

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
        @ExcludeMissing
        fun _validationFile(): JsonField<String> = validationFile

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): FineTuningJobCreateBody = apply {
            if (validated) {
                return@apply
            }

            model()
            trainingFile()
            hyperparameters().ifPresent { it.validate() }
            integrations().ifPresent { it.forEach { it.validate() } }
            method().ifPresent { it.validate() }
            seed()
            suffix()
            validationFile()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [FineTuningJobCreateBody]. */
        class Builder internal constructor() {

            private var model: JsonField<Model>? = null
            private var trainingFile: JsonField<String>? = null
            private var hyperparameters: JsonField<Hyperparameters> = JsonMissing.of()
            private var integrations: JsonField<MutableList<Integration>>? = null
            private var method: JsonField<Method> = JsonMissing.of()
            private var seed: JsonField<Long> = JsonMissing.of()
            private var suffix: JsonField<String> = JsonMissing.of()
            private var validationFile: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(fineTuningJobCreateBody: FineTuningJobCreateBody) = apply {
                model = fineTuningJobCreateBody.model
                trainingFile = fineTuningJobCreateBody.trainingFile
                hyperparameters = fineTuningJobCreateBody.hyperparameters
                integrations = fineTuningJobCreateBody.integrations.map { it.toMutableList() }
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
            fun model(model: Model) = model(JsonField.of(model))

            /**
             * The name of the model to fine-tune. You can select one of the
             * [supported models](https://platform.openai.com/docs/guides/fine-tuning#which-models-can-be-fine-tuned).
             */
            fun model(model: JsonField<Model>) = apply { this.model = model }

            /**
             * The name of the model to fine-tune. You can select one of the
             * [supported models](https://platform.openai.com/docs/guides/fine-tuning#which-models-can-be-fine-tuned).
             */
            fun model(value: String) = model(Model.of(value))

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
            fun trainingFile(trainingFile: String) = trainingFile(JsonField.of(trainingFile))

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
            fun trainingFile(trainingFile: JsonField<String>) = apply {
                this.trainingFile = trainingFile
            }

            /**
             * The hyperparameters used for the fine-tuning job. This value is now deprecated in
             * favor of `method`, and should be passed in under the `method` parameter.
             */
            @Deprecated("deprecated")
            fun hyperparameters(hyperparameters: Hyperparameters) =
                hyperparameters(JsonField.of(hyperparameters))

            /**
             * The hyperparameters used for the fine-tuning job. This value is now deprecated in
             * favor of `method`, and should be passed in under the `method` parameter.
             */
            @Deprecated("deprecated")
            fun hyperparameters(hyperparameters: JsonField<Hyperparameters>) = apply {
                this.hyperparameters = hyperparameters
            }

            /** A list of integrations to enable for your fine-tuning job. */
            fun integrations(integrations: List<Integration>?) =
                integrations(JsonField.ofNullable(integrations))

            /** A list of integrations to enable for your fine-tuning job. */
            fun integrations(integrations: Optional<List<Integration>>) =
                integrations(integrations.orElse(null))

            /** A list of integrations to enable for your fine-tuning job. */
            fun integrations(integrations: JsonField<List<Integration>>) = apply {
                this.integrations = integrations.map { it.toMutableList() }
            }

            /** A list of integrations to enable for your fine-tuning job. */
            fun addIntegration(integration: Integration) = apply {
                integrations =
                    (integrations ?: JsonField.of(mutableListOf())).apply {
                        asKnown()
                            .orElseThrow {
                                IllegalStateException(
                                    "Field was set to non-list type: ${javaClass.simpleName}"
                                )
                            }
                            .add(integration)
                    }
            }

            /** The method used for fine-tuning. */
            fun method(method: Method) = method(JsonField.of(method))

            /** The method used for fine-tuning. */
            fun method(method: JsonField<Method>) = apply { this.method = method }

            /**
             * The seed controls the reproducibility of the job. Passing in the same seed and job
             * parameters should produce the same results, but may differ in rare cases. If a seed
             * is not specified, one will be generated for you.
             */
            fun seed(seed: Long?) = seed(JsonField.ofNullable(seed))

            /**
             * The seed controls the reproducibility of the job. Passing in the same seed and job
             * parameters should produce the same results, but may differ in rare cases. If a seed
             * is not specified, one will be generated for you.
             */
            fun seed(seed: Long) = seed(seed as Long?)

            /**
             * The seed controls the reproducibility of the job. Passing in the same seed and job
             * parameters should produce the same results, but may differ in rare cases. If a seed
             * is not specified, one will be generated for you.
             */
            @Suppress("USELESS_CAST") // See https://youtrack.jetbrains.com/issue/KT-74228
            fun seed(seed: Optional<Long>) = seed(seed.orElse(null) as Long?)

            /**
             * The seed controls the reproducibility of the job. Passing in the same seed and job
             * parameters should produce the same results, but may differ in rare cases. If a seed
             * is not specified, one will be generated for you.
             */
            fun seed(seed: JsonField<Long>) = apply { this.seed = seed }

            /**
             * A string of up to 64 characters that will be added to your fine-tuned model name.
             *
             * For example, a `suffix` of "custom-model-name" would produce a model name like
             * `ft:gpt-4o-mini:openai:custom-model-name:7p4lURel`.
             */
            fun suffix(suffix: String?) = suffix(JsonField.ofNullable(suffix))

            /**
             * A string of up to 64 characters that will be added to your fine-tuned model name.
             *
             * For example, a `suffix` of "custom-model-name" would produce a model name like
             * `ft:gpt-4o-mini:openai:custom-model-name:7p4lURel`.
             */
            fun suffix(suffix: Optional<String>) = suffix(suffix.orElse(null))

            /**
             * A string of up to 64 characters that will be added to your fine-tuned model name.
             *
             * For example, a `suffix` of "custom-model-name" would produce a model name like
             * `ft:gpt-4o-mini:openai:custom-model-name:7p4lURel`.
             */
            fun suffix(suffix: JsonField<String>) = apply { this.suffix = suffix }

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
            fun validationFile(validationFile: String?) =
                validationFile(JsonField.ofNullable(validationFile))

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
            fun validationFile(validationFile: Optional<String>) =
                validationFile(validationFile.orElse(null))

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
            fun validationFile(validationFile: JsonField<String>) = apply {
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
                    checkRequired("model", model),
                    checkRequired("trainingFile", trainingFile),
                    hyperparameters,
                    (integrations ?: JsonMissing.of()).map { it.toImmutable() },
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

    /** A builder for [FineTuningJobCreateParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

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
        fun model(model: JsonField<Model>) = apply { body.model(model) }

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
        fun trainingFile(trainingFile: JsonField<String>) = apply {
            body.trainingFile(trainingFile)
        }

        /**
         * The hyperparameters used for the fine-tuning job. This value is now deprecated in favor
         * of `method`, and should be passed in under the `method` parameter.
         */
        @Deprecated("deprecated")
        fun hyperparameters(hyperparameters: Hyperparameters) = apply {
            body.hyperparameters(hyperparameters)
        }

        /**
         * The hyperparameters used for the fine-tuning job. This value is now deprecated in favor
         * of `method`, and should be passed in under the `method` parameter.
         */
        @Deprecated("deprecated")
        fun hyperparameters(hyperparameters: JsonField<Hyperparameters>) = apply {
            body.hyperparameters(hyperparameters)
        }

        /** A list of integrations to enable for your fine-tuning job. */
        fun integrations(integrations: List<Integration>?) = apply {
            body.integrations(integrations)
        }

        /** A list of integrations to enable for your fine-tuning job. */
        fun integrations(integrations: Optional<List<Integration>>) =
            integrations(integrations.orElse(null))

        /** A list of integrations to enable for your fine-tuning job. */
        fun integrations(integrations: JsonField<List<Integration>>) = apply {
            body.integrations(integrations)
        }

        /** A list of integrations to enable for your fine-tuning job. */
        fun addIntegration(integration: Integration) = apply { body.addIntegration(integration) }

        /** The method used for fine-tuning. */
        fun method(method: Method) = apply { body.method(method) }

        /** The method used for fine-tuning. */
        fun method(method: JsonField<Method>) = apply { body.method(method) }

        /**
         * The seed controls the reproducibility of the job. Passing in the same seed and job
         * parameters should produce the same results, but may differ in rare cases. If a seed is
         * not specified, one will be generated for you.
         */
        fun seed(seed: Long?) = apply { body.seed(seed) }

        /**
         * The seed controls the reproducibility of the job. Passing in the same seed and job
         * parameters should produce the same results, but may differ in rare cases. If a seed is
         * not specified, one will be generated for you.
         */
        fun seed(seed: Long) = seed(seed as Long?)

        /**
         * The seed controls the reproducibility of the job. Passing in the same seed and job
         * parameters should produce the same results, but may differ in rare cases. If a seed is
         * not specified, one will be generated for you.
         */
        @Suppress("USELESS_CAST") // See https://youtrack.jetbrains.com/issue/KT-74228
        fun seed(seed: Optional<Long>) = seed(seed.orElse(null) as Long?)

        /**
         * The seed controls the reproducibility of the job. Passing in the same seed and job
         * parameters should produce the same results, but may differ in rare cases. If a seed is
         * not specified, one will be generated for you.
         */
        fun seed(seed: JsonField<Long>) = apply { body.seed(seed) }

        /**
         * A string of up to 64 characters that will be added to your fine-tuned model name.
         *
         * For example, a `suffix` of "custom-model-name" would produce a model name like
         * `ft:gpt-4o-mini:openai:custom-model-name:7p4lURel`.
         */
        fun suffix(suffix: String?) = apply { body.suffix(suffix) }

        /**
         * A string of up to 64 characters that will be added to your fine-tuned model name.
         *
         * For example, a `suffix` of "custom-model-name" would produce a model name like
         * `ft:gpt-4o-mini:openai:custom-model-name:7p4lURel`.
         */
        fun suffix(suffix: Optional<String>) = suffix(suffix.orElse(null))

        /**
         * A string of up to 64 characters that will be added to your fine-tuned model name.
         *
         * For example, a `suffix` of "custom-model-name" would produce a model name like
         * `ft:gpt-4o-mini:openai:custom-model-name:7p4lURel`.
         */
        fun suffix(suffix: JsonField<String>) = apply { body.suffix(suffix) }

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
        fun validationFile(validationFile: String?) = apply { body.validationFile(validationFile) }

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
        fun validationFile(validationFile: Optional<String>) =
            validationFile(validationFile.orElse(null))

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
        fun validationFile(validationFile: JsonField<String>) = apply {
            body.validationFile(validationFile)
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

        fun build(): FineTuningJobCreateParams =
            FineTuningJobCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    /**
     * The name of the model to fine-tune. You can select one of the
     * [supported models](https://platform.openai.com/docs/guides/fine-tuning#which-models-can-be-fine-tuned).
     */
    class Model
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

            @JvmField val BABBAGE_002 = of("babbage-002")

            @JvmField val DAVINCI_002 = of("davinci-002")

            @JvmField val GPT_3_5_TURBO = of("gpt-3.5-turbo")

            @JvmField val GPT_4O_MINI = of("gpt-4o-mini")

            @JvmStatic fun of(value: String) = Model(JsonField.of(value))
        }

        /** An enum containing [Model]'s known values. */
        enum class Known {
            BABBAGE_002,
            DAVINCI_002,
            GPT_3_5_TURBO,
            GPT_4O_MINI,
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
            BABBAGE_002,
            DAVINCI_002,
            GPT_3_5_TURBO,
            GPT_4O_MINI,
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
                BABBAGE_002 -> Value.BABBAGE_002
                DAVINCI_002 -> Value.DAVINCI_002
                GPT_3_5_TURBO -> Value.GPT_3_5_TURBO
                GPT_4O_MINI -> Value.GPT_4O_MINI
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
    @Deprecated("deprecated")
    @NoAutoDetect
    class Hyperparameters
    @JsonCreator
    private constructor(
        @JsonProperty("batch_size")
        @ExcludeMissing
        private val batchSize: JsonField<BatchSize> = JsonMissing.of(),
        @JsonProperty("learning_rate_multiplier")
        @ExcludeMissing
        private val learningRateMultiplier: JsonField<LearningRateMultiplier> = JsonMissing.of(),
        @JsonProperty("n_epochs")
        @ExcludeMissing
        private val nEpochs: JsonField<NEpochs> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Number of examples in each batch. A larger batch size means that model parameters are
         * updated less frequently, but with lower variance.
         */
        fun batchSize(): Optional<BatchSize> =
            Optional.ofNullable(batchSize.getNullable("batch_size"))

        /**
         * Scaling factor for the learning rate. A smaller learning rate may be useful to avoid
         * overfitting.
         */
        fun learningRateMultiplier(): Optional<LearningRateMultiplier> =
            Optional.ofNullable(learningRateMultiplier.getNullable("learning_rate_multiplier"))

        /**
         * The number of epochs to train the model for. An epoch refers to one full cycle through
         * the training dataset.
         */
        fun nEpochs(): Optional<NEpochs> = Optional.ofNullable(nEpochs.getNullable("n_epochs"))

        /**
         * Number of examples in each batch. A larger batch size means that model parameters are
         * updated less frequently, but with lower variance.
         */
        @JsonProperty("batch_size")
        @ExcludeMissing
        fun _batchSize(): JsonField<BatchSize> = batchSize

        /**
         * Scaling factor for the learning rate. A smaller learning rate may be useful to avoid
         * overfitting.
         */
        @JsonProperty("learning_rate_multiplier")
        @ExcludeMissing
        fun _learningRateMultiplier(): JsonField<LearningRateMultiplier> = learningRateMultiplier

        /**
         * The number of epochs to train the model for. An epoch refers to one full cycle through
         * the training dataset.
         */
        @JsonProperty("n_epochs") @ExcludeMissing fun _nEpochs(): JsonField<NEpochs> = nEpochs

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Hyperparameters = apply {
            if (validated) {
                return@apply
            }

            batchSize().ifPresent { it.validate() }
            learningRateMultiplier().ifPresent { it.validate() }
            nEpochs().ifPresent { it.validate() }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Hyperparameters]. */
        class Builder internal constructor() {

            private var batchSize: JsonField<BatchSize> = JsonMissing.of()
            private var learningRateMultiplier: JsonField<LearningRateMultiplier> = JsonMissing.of()
            private var nEpochs: JsonField<NEpochs> = JsonMissing.of()
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
            fun batchSize(batchSize: BatchSize) = batchSize(JsonField.of(batchSize))

            /**
             * Number of examples in each batch. A larger batch size means that model parameters are
             * updated less frequently, but with lower variance.
             */
            fun batchSize(batchSize: JsonField<BatchSize>) = apply { this.batchSize = batchSize }

            /**
             * Number of examples in each batch. A larger batch size means that model parameters are
             * updated less frequently, but with lower variance.
             */
            fun batchSizeAuto() = batchSize(BatchSize.ofAuto())

            /**
             * Number of examples in each batch. A larger batch size means that model parameters are
             * updated less frequently, but with lower variance.
             */
            fun batchSize(integer: Long) = batchSize(BatchSize.ofInteger(integer))

            /**
             * Scaling factor for the learning rate. A smaller learning rate may be useful to avoid
             * overfitting.
             */
            fun learningRateMultiplier(learningRateMultiplier: LearningRateMultiplier) =
                learningRateMultiplier(JsonField.of(learningRateMultiplier))

            /**
             * Scaling factor for the learning rate. A smaller learning rate may be useful to avoid
             * overfitting.
             */
            fun learningRateMultiplier(learningRateMultiplier: JsonField<LearningRateMultiplier>) =
                apply {
                    this.learningRateMultiplier = learningRateMultiplier
                }

            /**
             * Scaling factor for the learning rate. A smaller learning rate may be useful to avoid
             * overfitting.
             */
            fun learningRateMultiplierAuto() =
                learningRateMultiplier(LearningRateMultiplier.ofAuto())

            /**
             * Scaling factor for the learning rate. A smaller learning rate may be useful to avoid
             * overfitting.
             */
            fun learningRateMultiplier(number: Double) =
                learningRateMultiplier(LearningRateMultiplier.ofNumber(number))

            /**
             * The number of epochs to train the model for. An epoch refers to one full cycle
             * through the training dataset.
             */
            fun nEpochs(nEpochs: NEpochs) = nEpochs(JsonField.of(nEpochs))

            /**
             * The number of epochs to train the model for. An epoch refers to one full cycle
             * through the training dataset.
             */
            fun nEpochs(nEpochs: JsonField<NEpochs>) = apply { this.nEpochs = nEpochs }

            /**
             * The number of epochs to train the model for. An epoch refers to one full cycle
             * through the training dataset.
             */
            fun nEpochsAuto() = nEpochs(NEpochs.ofAuto())

            /**
             * The number of epochs to train the model for. An epoch refers to one full cycle
             * through the training dataset.
             */
            fun nEpochs(integer: Long) = nEpochs(NEpochs.ofInteger(integer))

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
            private val auto: JsonValue? = null,
            private val integer: Long? = null,
            private val _json: JsonValue? = null,
        ) {

            fun auto(): Optional<JsonValue> = Optional.ofNullable(auto)

            fun integer(): Optional<Long> = Optional.ofNullable(integer)

            fun isAuto(): Boolean = auto != null

            fun isInteger(): Boolean = integer != null

            fun asAuto(): JsonValue = auto.getOrThrow("auto")

            fun asInteger(): Long = integer.getOrThrow("integer")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T {
                return when {
                    auto != null -> visitor.visitAuto(auto)
                    integer != null -> visitor.visitInteger(integer)
                    else -> visitor.unknown(_json)
                }
            }

            private var validated: Boolean = false

            fun validate(): BatchSize = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitAuto(auto: JsonValue) {
                            auto.let {
                                if (it != JsonValue.from("auto")) {
                                    throw OpenAIInvalidDataException(
                                        "'auto' is invalid, received $it"
                                    )
                                }
                            }
                        }

                        override fun visitInteger(integer: Long) {}
                    }
                )
                validated = true
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is BatchSize && auto == other.auto && integer == other.integer /* spotless:on */
            }

            override fun hashCode(): Int = /* spotless:off */ Objects.hash(auto, integer) /* spotless:on */

            override fun toString(): String =
                when {
                    auto != null -> "BatchSize{auto=$auto}"
                    integer != null -> "BatchSize{integer=$integer}"
                    _json != null -> "BatchSize{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid BatchSize")
                }

            companion object {

                @JvmStatic fun ofAuto() = BatchSize(auto = JsonValue.from("auto"))

                @JvmStatic fun ofInteger(integer: Long) = BatchSize(integer = integer)
            }

            /**
             * An interface that defines how to map each variant of [BatchSize] to a value of type
             * [T].
             */
            interface Visitor<out T> {

                fun visitAuto(auto: JsonValue): T

                fun visitInteger(integer: Long): T

                /**
                 * Maps an unknown variant of [BatchSize] to a value of type [T].
                 *
                 * An instance of [BatchSize] can contain an unknown variant if it was deserialized
                 * from data that doesn't match any known variant. For example, if the SDK is on an
                 * older version than the API, then the API may respond with new variants that the
                 * SDK is unaware of.
                 *
                 * @throws OpenAIInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown BatchSize: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<BatchSize>(BatchSize::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): BatchSize {
                    val json = JsonValue.fromJsonNode(node)

                    tryDeserialize(node, jacksonTypeRef<JsonValue>()) {
                            it.let {
                                if (it != JsonValue.from("auto")) {
                                    throw OpenAIInvalidDataException(
                                        "'auto' is invalid, received $it"
                                    )
                                }
                            }
                        }
                        ?.let {
                            return BatchSize(auto = it, _json = json)
                        }
                    tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                        return BatchSize(integer = it, _json = json)
                    }

                    return BatchSize(_json = json)
                }
            }

            internal class Serializer : BaseSerializer<BatchSize>(BatchSize::class) {

                override fun serialize(
                    value: BatchSize,
                    generator: JsonGenerator,
                    provider: SerializerProvider
                ) {
                    when {
                        value.auto != null -> generator.writeObject(value.auto)
                        value.integer != null -> generator.writeObject(value.integer)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid BatchSize")
                    }
                }
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
            private val auto: JsonValue? = null,
            private val number: Double? = null,
            private val _json: JsonValue? = null,
        ) {

            fun auto(): Optional<JsonValue> = Optional.ofNullable(auto)

            fun number(): Optional<Double> = Optional.ofNullable(number)

            fun isAuto(): Boolean = auto != null

            fun isNumber(): Boolean = number != null

            fun asAuto(): JsonValue = auto.getOrThrow("auto")

            fun asNumber(): Double = number.getOrThrow("number")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T {
                return when {
                    auto != null -> visitor.visitAuto(auto)
                    number != null -> visitor.visitNumber(number)
                    else -> visitor.unknown(_json)
                }
            }

            private var validated: Boolean = false

            fun validate(): LearningRateMultiplier = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitAuto(auto: JsonValue) {
                            auto.let {
                                if (it != JsonValue.from("auto")) {
                                    throw OpenAIInvalidDataException(
                                        "'auto' is invalid, received $it"
                                    )
                                }
                            }
                        }

                        override fun visitNumber(number: Double) {}
                    }
                )
                validated = true
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is LearningRateMultiplier && auto == other.auto && number == other.number /* spotless:on */
            }

            override fun hashCode(): Int = /* spotless:off */ Objects.hash(auto, number) /* spotless:on */

            override fun toString(): String =
                when {
                    auto != null -> "LearningRateMultiplier{auto=$auto}"
                    number != null -> "LearningRateMultiplier{number=$number}"
                    _json != null -> "LearningRateMultiplier{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid LearningRateMultiplier")
                }

            companion object {

                @JvmStatic fun ofAuto() = LearningRateMultiplier(auto = JsonValue.from("auto"))

                @JvmStatic fun ofNumber(number: Double) = LearningRateMultiplier(number = number)
            }

            /**
             * An interface that defines how to map each variant of [LearningRateMultiplier] to a
             * value of type [T].
             */
            interface Visitor<out T> {

                fun visitAuto(auto: JsonValue): T

                fun visitNumber(number: Double): T

                /**
                 * Maps an unknown variant of [LearningRateMultiplier] to a value of type [T].
                 *
                 * An instance of [LearningRateMultiplier] can contain an unknown variant if it was
                 * deserialized from data that doesn't match any known variant. For example, if the
                 * SDK is on an older version than the API, then the API may respond with new
                 * variants that the SDK is unaware of.
                 *
                 * @throws OpenAIInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown LearningRateMultiplier: $json")
                }
            }

            internal class Deserializer :
                BaseDeserializer<LearningRateMultiplier>(LearningRateMultiplier::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): LearningRateMultiplier {
                    val json = JsonValue.fromJsonNode(node)

                    tryDeserialize(node, jacksonTypeRef<JsonValue>()) {
                            it.let {
                                if (it != JsonValue.from("auto")) {
                                    throw OpenAIInvalidDataException(
                                        "'auto' is invalid, received $it"
                                    )
                                }
                            }
                        }
                        ?.let {
                            return LearningRateMultiplier(auto = it, _json = json)
                        }
                    tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                        return LearningRateMultiplier(number = it, _json = json)
                    }

                    return LearningRateMultiplier(_json = json)
                }
            }

            internal class Serializer :
                BaseSerializer<LearningRateMultiplier>(LearningRateMultiplier::class) {

                override fun serialize(
                    value: LearningRateMultiplier,
                    generator: JsonGenerator,
                    provider: SerializerProvider
                ) {
                    when {
                        value.auto != null -> generator.writeObject(value.auto)
                        value.number != null -> generator.writeObject(value.number)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid LearningRateMultiplier")
                    }
                }
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
            private val auto: JsonValue? = null,
            private val integer: Long? = null,
            private val _json: JsonValue? = null,
        ) {

            fun auto(): Optional<JsonValue> = Optional.ofNullable(auto)

            fun integer(): Optional<Long> = Optional.ofNullable(integer)

            fun isAuto(): Boolean = auto != null

            fun isInteger(): Boolean = integer != null

            fun asAuto(): JsonValue = auto.getOrThrow("auto")

            fun asInteger(): Long = integer.getOrThrow("integer")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T {
                return when {
                    auto != null -> visitor.visitAuto(auto)
                    integer != null -> visitor.visitInteger(integer)
                    else -> visitor.unknown(_json)
                }
            }

            private var validated: Boolean = false

            fun validate(): NEpochs = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitAuto(auto: JsonValue) {
                            auto.let {
                                if (it != JsonValue.from("auto")) {
                                    throw OpenAIInvalidDataException(
                                        "'auto' is invalid, received $it"
                                    )
                                }
                            }
                        }

                        override fun visitInteger(integer: Long) {}
                    }
                )
                validated = true
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is NEpochs && auto == other.auto && integer == other.integer /* spotless:on */
            }

            override fun hashCode(): Int = /* spotless:off */ Objects.hash(auto, integer) /* spotless:on */

            override fun toString(): String =
                when {
                    auto != null -> "NEpochs{auto=$auto}"
                    integer != null -> "NEpochs{integer=$integer}"
                    _json != null -> "NEpochs{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid NEpochs")
                }

            companion object {

                @JvmStatic fun ofAuto() = NEpochs(auto = JsonValue.from("auto"))

                @JvmStatic fun ofInteger(integer: Long) = NEpochs(integer = integer)
            }

            /**
             * An interface that defines how to map each variant of [NEpochs] to a value of type
             * [T].
             */
            interface Visitor<out T> {

                fun visitAuto(auto: JsonValue): T

                fun visitInteger(integer: Long): T

                /**
                 * Maps an unknown variant of [NEpochs] to a value of type [T].
                 *
                 * An instance of [NEpochs] can contain an unknown variant if it was deserialized
                 * from data that doesn't match any known variant. For example, if the SDK is on an
                 * older version than the API, then the API may respond with new variants that the
                 * SDK is unaware of.
                 *
                 * @throws OpenAIInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown NEpochs: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<NEpochs>(NEpochs::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): NEpochs {
                    val json = JsonValue.fromJsonNode(node)

                    tryDeserialize(node, jacksonTypeRef<JsonValue>()) {
                            it.let {
                                if (it != JsonValue.from("auto")) {
                                    throw OpenAIInvalidDataException(
                                        "'auto' is invalid, received $it"
                                    )
                                }
                            }
                        }
                        ?.let {
                            return NEpochs(auto = it, _json = json)
                        }
                    tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                        return NEpochs(integer = it, _json = json)
                    }

                    return NEpochs(_json = json)
                }
            }

            internal class Serializer : BaseSerializer<NEpochs>(NEpochs::class) {

                override fun serialize(
                    value: NEpochs,
                    generator: JsonGenerator,
                    provider: SerializerProvider
                ) {
                    when {
                        value.auto != null -> generator.writeObject(value.auto)
                        value.integer != null -> generator.writeObject(value.integer)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid NEpochs")
                    }
                }
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
        @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
        @JsonProperty("wandb")
        @ExcludeMissing
        private val wandb: JsonField<Wandb> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * The type of integration to enable. Currently, only "wandb" (Weights and Biases) is
         * supported.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The settings for your integration with Weights and Biases. This payload specifies the
         * project that metrics will be sent to. Optionally, you can set an explicit display name
         * for your run, add tags to your run, and set a default entity (team, username, etc) to be
         * associated with your run.
         */
        fun wandb(): Wandb = wandb.getRequired("wandb")

        /**
         * The settings for your integration with Weights and Biases. This payload specifies the
         * project that metrics will be sent to. Optionally, you can set an explicit display name
         * for your run, add tags to your run, and set a default entity (team, username, etc) to be
         * associated with your run.
         */
        @JsonProperty("wandb") @ExcludeMissing fun _wandb(): JsonField<Wandb> = wandb

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Integration = apply {
            if (validated) {
                return@apply
            }

            _type().let {
                if (it != JsonValue.from("wandb")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            wandb().validate()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Integration]. */
        class Builder internal constructor() {

            private var type: JsonValue = JsonValue.from("wandb")
            private var wandb: JsonField<Wandb>? = null
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
            fun type(type: JsonValue) = apply { this.type = type }

            /**
             * The settings for your integration with Weights and Biases. This payload specifies the
             * project that metrics will be sent to. Optionally, you can set an explicit display
             * name for your run, add tags to your run, and set a default entity (team, username,
             * etc) to be associated with your run.
             */
            fun wandb(wandb: Wandb) = wandb(JsonField.of(wandb))

            /**
             * The settings for your integration with Weights and Biases. This payload specifies the
             * project that metrics will be sent to. Optionally, you can set an explicit display
             * name for your run, add tags to your run, and set a default entity (team, username,
             * etc) to be associated with your run.
             */
            fun wandb(wandb: JsonField<Wandb>) = apply { this.wandb = wandb }

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
                    type,
                    checkRequired("wandb", wandb),
                    additionalProperties.toImmutable(),
                )
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
            @JsonProperty("project")
            @ExcludeMissing
            private val project: JsonField<String> = JsonMissing.of(),
            @JsonProperty("entity")
            @ExcludeMissing
            private val entity: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name")
            @ExcludeMissing
            private val name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("tags")
            @ExcludeMissing
            private val tags: JsonField<List<String>> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /** The name of the project that the new run will be created under. */
            fun project(): String = project.getRequired("project")

            /**
             * The entity to use for the run. This allows you to set the team or username of the
             * WandB user that you would like associated with the run. If not set, the default
             * entity for the registered WandB API key is used.
             */
            fun entity(): Optional<String> = Optional.ofNullable(entity.getNullable("entity"))

            /**
             * A display name to set for the run. If not set, we will use the Job ID as the name.
             */
            fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

            /**
             * A list of tags to be attached to the newly created run. These tags are passed through
             * directly to WandB. Some default tags are generated by OpenAI: "openai/finetune",
             * "openai/{base-model}", "openai/{ftjob-abcdef}".
             */
            fun tags(): Optional<List<String>> = Optional.ofNullable(tags.getNullable("tags"))

            /** The name of the project that the new run will be created under. */
            @JsonProperty("project") @ExcludeMissing fun _project(): JsonField<String> = project

            /**
             * The entity to use for the run. This allows you to set the team or username of the
             * WandB user that you would like associated with the run. If not set, the default
             * entity for the registered WandB API key is used.
             */
            @JsonProperty("entity") @ExcludeMissing fun _entity(): JsonField<String> = entity

            /**
             * A display name to set for the run. If not set, we will use the Job ID as the name.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * A list of tags to be attached to the newly created run. These tags are passed through
             * directly to WandB. Some default tags are generated by OpenAI: "openai/finetune",
             * "openai/{base-model}", "openai/{ftjob-abcdef}".
             */
            @JsonProperty("tags") @ExcludeMissing fun _tags(): JsonField<List<String>> = tags

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): Wandb = apply {
                if (validated) {
                    return@apply
                }

                project()
                entity()
                name()
                tags()
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Wandb]. */
            class Builder internal constructor() {

                private var project: JsonField<String>? = null
                private var entity: JsonField<String> = JsonMissing.of()
                private var name: JsonField<String> = JsonMissing.of()
                private var tags: JsonField<MutableList<String>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(wandb: Wandb) = apply {
                    project = wandb.project
                    entity = wandb.entity
                    name = wandb.name
                    tags = wandb.tags.map { it.toMutableList() }
                    additionalProperties = wandb.additionalProperties.toMutableMap()
                }

                /** The name of the project that the new run will be created under. */
                fun project(project: String) = project(JsonField.of(project))

                /** The name of the project that the new run will be created under. */
                fun project(project: JsonField<String>) = apply { this.project = project }

                /**
                 * The entity to use for the run. This allows you to set the team or username of the
                 * WandB user that you would like associated with the run. If not set, the default
                 * entity for the registered WandB API key is used.
                 */
                fun entity(entity: String?) = entity(JsonField.ofNullable(entity))

                /**
                 * The entity to use for the run. This allows you to set the team or username of the
                 * WandB user that you would like associated with the run. If not set, the default
                 * entity for the registered WandB API key is used.
                 */
                fun entity(entity: Optional<String>) = entity(entity.orElse(null))

                /**
                 * The entity to use for the run. This allows you to set the team or username of the
                 * WandB user that you would like associated with the run. If not set, the default
                 * entity for the registered WandB API key is used.
                 */
                fun entity(entity: JsonField<String>) = apply { this.entity = entity }

                /**
                 * A display name to set for the run. If not set, we will use the Job ID as the
                 * name.
                 */
                fun name(name: String?) = name(JsonField.ofNullable(name))

                /**
                 * A display name to set for the run. If not set, we will use the Job ID as the
                 * name.
                 */
                fun name(name: Optional<String>) = name(name.orElse(null))

                /**
                 * A display name to set for the run. If not set, we will use the Job ID as the
                 * name.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                /**
                 * A list of tags to be attached to the newly created run. These tags are passed
                 * through directly to WandB. Some default tags are generated by OpenAI:
                 * "openai/finetune", "openai/{base-model}", "openai/{ftjob-abcdef}".
                 */
                fun tags(tags: List<String>) = tags(JsonField.of(tags))

                /**
                 * A list of tags to be attached to the newly created run. These tags are passed
                 * through directly to WandB. Some default tags are generated by OpenAI:
                 * "openai/finetune", "openai/{base-model}", "openai/{ftjob-abcdef}".
                 */
                fun tags(tags: JsonField<List<String>>) = apply {
                    this.tags = tags.map { it.toMutableList() }
                }

                /**
                 * A list of tags to be attached to the newly created run. These tags are passed
                 * through directly to WandB. Some default tags are generated by OpenAI:
                 * "openai/finetune", "openai/{base-model}", "openai/{ftjob-abcdef}".
                 */
                fun addTag(tag: String) = apply {
                    tags =
                        (tags ?: JsonField.of(mutableListOf())).apply {
                            asKnown()
                                .orElseThrow {
                                    IllegalStateException(
                                        "Field was set to non-list type: ${javaClass.simpleName}"
                                    )
                                }
                                .add(tag)
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

                fun build(): Wandb =
                    Wandb(
                        checkRequired("project", project),
                        entity,
                        name,
                        (tags ?: JsonMissing.of()).map { it.toImmutable() },
                        additionalProperties.toImmutable(),
                    )
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Wandb && project == other.project && entity == other.entity && name == other.name && tags == other.tags && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(project, entity, name, tags, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Wandb{project=$project, entity=$entity, name=$name, tags=$tags, additionalProperties=$additionalProperties}"
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
        @JsonProperty("dpo") @ExcludeMissing private val dpo: JsonField<Dpo> = JsonMissing.of(),
        @JsonProperty("supervised")
        @ExcludeMissing
        private val supervised: JsonField<Supervised> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** Configuration for the DPO fine-tuning method. */
        fun dpo(): Optional<Dpo> = Optional.ofNullable(dpo.getNullable("dpo"))

        /** Configuration for the supervised fine-tuning method. */
        fun supervised(): Optional<Supervised> =
            Optional.ofNullable(supervised.getNullable("supervised"))

        /** The type of method. Is either `supervised` or `dpo`. */
        fun type(): Optional<Type> = Optional.ofNullable(type.getNullable("type"))

        /** Configuration for the DPO fine-tuning method. */
        @JsonProperty("dpo") @ExcludeMissing fun _dpo(): JsonField<Dpo> = dpo

        /** Configuration for the supervised fine-tuning method. */
        @JsonProperty("supervised")
        @ExcludeMissing
        fun _supervised(): JsonField<Supervised> = supervised

        /** The type of method. Is either `supervised` or `dpo`. */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Method = apply {
            if (validated) {
                return@apply
            }

            dpo().ifPresent { it.validate() }
            supervised().ifPresent { it.validate() }
            type()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Method]. */
        class Builder internal constructor() {

            private var dpo: JsonField<Dpo> = JsonMissing.of()
            private var supervised: JsonField<Supervised> = JsonMissing.of()
            private var type: JsonField<Type> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(method: Method) = apply {
                dpo = method.dpo
                supervised = method.supervised
                type = method.type
                additionalProperties = method.additionalProperties.toMutableMap()
            }

            /** Configuration for the DPO fine-tuning method. */
            fun dpo(dpo: Dpo) = dpo(JsonField.of(dpo))

            /** Configuration for the DPO fine-tuning method. */
            fun dpo(dpo: JsonField<Dpo>) = apply { this.dpo = dpo }

            /** Configuration for the supervised fine-tuning method. */
            fun supervised(supervised: Supervised) = supervised(JsonField.of(supervised))

            /** Configuration for the supervised fine-tuning method. */
            fun supervised(supervised: JsonField<Supervised>) = apply {
                this.supervised = supervised
            }

            /** The type of method. Is either `supervised` or `dpo`. */
            fun type(type: Type) = type(JsonField.of(type))

            /** The type of method. Is either `supervised` or `dpo`. */
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

            fun build(): Method =
                Method(
                    dpo,
                    supervised,
                    type,
                    additionalProperties.toImmutable(),
                )
        }

        /** Configuration for the DPO fine-tuning method. */
        @NoAutoDetect
        class Dpo
        @JsonCreator
        private constructor(
            @JsonProperty("hyperparameters")
            @ExcludeMissing
            private val hyperparameters: JsonField<Hyperparameters> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /** The hyperparameters used for the fine-tuning job. */
            fun hyperparameters(): Optional<Hyperparameters> =
                Optional.ofNullable(hyperparameters.getNullable("hyperparameters"))

            /** The hyperparameters used for the fine-tuning job. */
            @JsonProperty("hyperparameters")
            @ExcludeMissing
            fun _hyperparameters(): JsonField<Hyperparameters> = hyperparameters

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): Dpo = apply {
                if (validated) {
                    return@apply
                }

                hyperparameters().ifPresent { it.validate() }
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Dpo]. */
            class Builder internal constructor() {

                private var hyperparameters: JsonField<Hyperparameters> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(dpo: Dpo) = apply {
                    hyperparameters = dpo.hyperparameters
                    additionalProperties = dpo.additionalProperties.toMutableMap()
                }

                /** The hyperparameters used for the fine-tuning job. */
                fun hyperparameters(hyperparameters: Hyperparameters) =
                    hyperparameters(JsonField.of(hyperparameters))

                /** The hyperparameters used for the fine-tuning job. */
                fun hyperparameters(hyperparameters: JsonField<Hyperparameters>) = apply {
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
                @JsonProperty("batch_size")
                @ExcludeMissing
                private val batchSize: JsonField<BatchSize> = JsonMissing.of(),
                @JsonProperty("beta")
                @ExcludeMissing
                private val beta: JsonField<Beta> = JsonMissing.of(),
                @JsonProperty("learning_rate_multiplier")
                @ExcludeMissing
                private val learningRateMultiplier: JsonField<LearningRateMultiplier> =
                    JsonMissing.of(),
                @JsonProperty("n_epochs")
                @ExcludeMissing
                private val nEpochs: JsonField<NEpochs> = JsonMissing.of(),
                @JsonAnySetter
                private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
            ) {

                /**
                 * Number of examples in each batch. A larger batch size means that model parameters
                 * are updated less frequently, but with lower variance.
                 */
                fun batchSize(): Optional<BatchSize> =
                    Optional.ofNullable(batchSize.getNullable("batch_size"))

                /**
                 * The beta value for the DPO method. A higher beta value will increase the weight
                 * of the penalty between the policy and reference model.
                 */
                fun beta(): Optional<Beta> = Optional.ofNullable(beta.getNullable("beta"))

                /**
                 * Scaling factor for the learning rate. A smaller learning rate may be useful to
                 * avoid overfitting.
                 */
                fun learningRateMultiplier(): Optional<LearningRateMultiplier> =
                    Optional.ofNullable(
                        learningRateMultiplier.getNullable("learning_rate_multiplier")
                    )

                /**
                 * The number of epochs to train the model for. An epoch refers to one full cycle
                 * through the training dataset.
                 */
                fun nEpochs(): Optional<NEpochs> =
                    Optional.ofNullable(nEpochs.getNullable("n_epochs"))

                /**
                 * Number of examples in each batch. A larger batch size means that model parameters
                 * are updated less frequently, but with lower variance.
                 */
                @JsonProperty("batch_size")
                @ExcludeMissing
                fun _batchSize(): JsonField<BatchSize> = batchSize

                /**
                 * The beta value for the DPO method. A higher beta value will increase the weight
                 * of the penalty between the policy and reference model.
                 */
                @JsonProperty("beta") @ExcludeMissing fun _beta(): JsonField<Beta> = beta

                /**
                 * Scaling factor for the learning rate. A smaller learning rate may be useful to
                 * avoid overfitting.
                 */
                @JsonProperty("learning_rate_multiplier")
                @ExcludeMissing
                fun _learningRateMultiplier(): JsonField<LearningRateMultiplier> =
                    learningRateMultiplier

                /**
                 * The number of epochs to train the model for. An epoch refers to one full cycle
                 * through the training dataset.
                 */
                @JsonProperty("n_epochs")
                @ExcludeMissing
                fun _nEpochs(): JsonField<NEpochs> = nEpochs

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                private var validated: Boolean = false

                fun validate(): Hyperparameters = apply {
                    if (validated) {
                        return@apply
                    }

                    batchSize().ifPresent { it.validate() }
                    beta().ifPresent { it.validate() }
                    learningRateMultiplier().ifPresent { it.validate() }
                    nEpochs().ifPresent { it.validate() }
                    validated = true
                }

                fun toBuilder() = Builder().from(this)

                companion object {

                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Hyperparameters]. */
                class Builder internal constructor() {

                    private var batchSize: JsonField<BatchSize> = JsonMissing.of()
                    private var beta: JsonField<Beta> = JsonMissing.of()
                    private var learningRateMultiplier: JsonField<LearningRateMultiplier> =
                        JsonMissing.of()
                    private var nEpochs: JsonField<NEpochs> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(hyperparameters: Hyperparameters) = apply {
                        batchSize = hyperparameters.batchSize
                        beta = hyperparameters.beta
                        learningRateMultiplier = hyperparameters.learningRateMultiplier
                        nEpochs = hyperparameters.nEpochs
                        additionalProperties = hyperparameters.additionalProperties.toMutableMap()
                    }

                    /**
                     * Number of examples in each batch. A larger batch size means that model
                     * parameters are updated less frequently, but with lower variance.
                     */
                    fun batchSize(batchSize: BatchSize) = batchSize(JsonField.of(batchSize))

                    /**
                     * Number of examples in each batch. A larger batch size means that model
                     * parameters are updated less frequently, but with lower variance.
                     */
                    fun batchSize(batchSize: JsonField<BatchSize>) = apply {
                        this.batchSize = batchSize
                    }

                    /**
                     * Number of examples in each batch. A larger batch size means that model
                     * parameters are updated less frequently, but with lower variance.
                     */
                    fun batchSizeAuto() = batchSize(BatchSize.ofAuto())

                    /**
                     * Number of examples in each batch. A larger batch size means that model
                     * parameters are updated less frequently, but with lower variance.
                     */
                    fun batchSize(manual: Long) = batchSize(BatchSize.ofManual(manual))

                    /**
                     * The beta value for the DPO method. A higher beta value will increase the
                     * weight of the penalty between the policy and reference model.
                     */
                    fun beta(beta: Beta) = beta(JsonField.of(beta))

                    /**
                     * The beta value for the DPO method. A higher beta value will increase the
                     * weight of the penalty between the policy and reference model.
                     */
                    fun beta(beta: JsonField<Beta>) = apply { this.beta = beta }

                    /**
                     * The beta value for the DPO method. A higher beta value will increase the
                     * weight of the penalty between the policy and reference model.
                     */
                    fun betaAuto() = beta(Beta.ofAuto())

                    /**
                     * The beta value for the DPO method. A higher beta value will increase the
                     * weight of the penalty between the policy and reference model.
                     */
                    fun beta(manual: Double) = beta(Beta.ofManual(manual))

                    /**
                     * Scaling factor for the learning rate. A smaller learning rate may be useful
                     * to avoid overfitting.
                     */
                    fun learningRateMultiplier(learningRateMultiplier: LearningRateMultiplier) =
                        learningRateMultiplier(JsonField.of(learningRateMultiplier))

                    /**
                     * Scaling factor for the learning rate. A smaller learning rate may be useful
                     * to avoid overfitting.
                     */
                    fun learningRateMultiplier(
                        learningRateMultiplier: JsonField<LearningRateMultiplier>
                    ) = apply { this.learningRateMultiplier = learningRateMultiplier }

                    /**
                     * Scaling factor for the learning rate. A smaller learning rate may be useful
                     * to avoid overfitting.
                     */
                    fun learningRateMultiplierAuto() =
                        learningRateMultiplier(LearningRateMultiplier.ofAuto())

                    /**
                     * Scaling factor for the learning rate. A smaller learning rate may be useful
                     * to avoid overfitting.
                     */
                    fun learningRateMultiplier(manual: Double) =
                        learningRateMultiplier(LearningRateMultiplier.ofManual(manual))

                    /**
                     * The number of epochs to train the model for. An epoch refers to one full
                     * cycle through the training dataset.
                     */
                    fun nEpochs(nEpochs: NEpochs) = nEpochs(JsonField.of(nEpochs))

                    /**
                     * The number of epochs to train the model for. An epoch refers to one full
                     * cycle through the training dataset.
                     */
                    fun nEpochs(nEpochs: JsonField<NEpochs>) = apply { this.nEpochs = nEpochs }

                    /**
                     * The number of epochs to train the model for. An epoch refers to one full
                     * cycle through the training dataset.
                     */
                    fun nEpochsAuto() = nEpochs(NEpochs.ofAuto())

                    /**
                     * The number of epochs to train the model for. An epoch refers to one full
                     * cycle through the training dataset.
                     */
                    fun nEpochs(manual: Long) = nEpochs(NEpochs.ofManual(manual))

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
                            beta,
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
                    private val auto: JsonValue? = null,
                    private val manual: Long? = null,
                    private val _json: JsonValue? = null,
                ) {

                    fun auto(): Optional<JsonValue> = Optional.ofNullable(auto)

                    fun manual(): Optional<Long> = Optional.ofNullable(manual)

                    fun isAuto(): Boolean = auto != null

                    fun isManual(): Boolean = manual != null

                    fun asAuto(): JsonValue = auto.getOrThrow("auto")

                    fun asManual(): Long = manual.getOrThrow("manual")

                    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                    fun <T> accept(visitor: Visitor<T>): T {
                        return when {
                            auto != null -> visitor.visitAuto(auto)
                            manual != null -> visitor.visitManual(manual)
                            else -> visitor.unknown(_json)
                        }
                    }

                    private var validated: Boolean = false

                    fun validate(): BatchSize = apply {
                        if (validated) {
                            return@apply
                        }

                        accept(
                            object : Visitor<Unit> {
                                override fun visitAuto(auto: JsonValue) {
                                    auto.let {
                                        if (it != JsonValue.from("auto")) {
                                            throw OpenAIInvalidDataException(
                                                "'auto' is invalid, received $it"
                                            )
                                        }
                                    }
                                }

                                override fun visitManual(manual: Long) {}
                            }
                        )
                        validated = true
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

                        @JvmStatic fun ofAuto() = BatchSize(auto = JsonValue.from("auto"))

                        @JvmStatic fun ofManual(manual: Long) = BatchSize(manual = manual)
                    }

                    /**
                     * An interface that defines how to map each variant of [BatchSize] to a value
                     * of type [T].
                     */
                    interface Visitor<out T> {

                        fun visitAuto(auto: JsonValue): T

                        fun visitManual(manual: Long): T

                        /**
                         * Maps an unknown variant of [BatchSize] to a value of type [T].
                         *
                         * An instance of [BatchSize] can contain an unknown variant if it was
                         * deserialized from data that doesn't match any known variant. For example,
                         * if the SDK is on an older version than the API, then the API may respond
                         * with new variants that the SDK is unaware of.
                         *
                         * @throws OpenAIInvalidDataException in the default implementation.
                         */
                        fun unknown(json: JsonValue?): T {
                            throw OpenAIInvalidDataException("Unknown BatchSize: $json")
                        }
                    }

                    internal class Deserializer : BaseDeserializer<BatchSize>(BatchSize::class) {

                        override fun ObjectCodec.deserialize(node: JsonNode): BatchSize {
                            val json = JsonValue.fromJsonNode(node)

                            tryDeserialize(node, jacksonTypeRef<JsonValue>()) {
                                    it.let {
                                        if (it != JsonValue.from("auto")) {
                                            throw OpenAIInvalidDataException(
                                                "'auto' is invalid, received $it"
                                            )
                                        }
                                    }
                                }
                                ?.let {
                                    return BatchSize(auto = it, _json = json)
                                }
                            tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                                return BatchSize(manual = it, _json = json)
                            }

                            return BatchSize(_json = json)
                        }
                    }

                    internal class Serializer : BaseSerializer<BatchSize>(BatchSize::class) {

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
                }

                /**
                 * The beta value for the DPO method. A higher beta value will increase the weight
                 * of the penalty between the policy and reference model.
                 */
                @JsonDeserialize(using = Beta.Deserializer::class)
                @JsonSerialize(using = Beta.Serializer::class)
                class Beta
                private constructor(
                    private val auto: JsonValue? = null,
                    private val manual: Double? = null,
                    private val _json: JsonValue? = null,
                ) {

                    fun auto(): Optional<JsonValue> = Optional.ofNullable(auto)

                    fun manual(): Optional<Double> = Optional.ofNullable(manual)

                    fun isAuto(): Boolean = auto != null

                    fun isManual(): Boolean = manual != null

                    fun asAuto(): JsonValue = auto.getOrThrow("auto")

                    fun asManual(): Double = manual.getOrThrow("manual")

                    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                    fun <T> accept(visitor: Visitor<T>): T {
                        return when {
                            auto != null -> visitor.visitAuto(auto)
                            manual != null -> visitor.visitManual(manual)
                            else -> visitor.unknown(_json)
                        }
                    }

                    private var validated: Boolean = false

                    fun validate(): Beta = apply {
                        if (validated) {
                            return@apply
                        }

                        accept(
                            object : Visitor<Unit> {
                                override fun visitAuto(auto: JsonValue) {
                                    auto.let {
                                        if (it != JsonValue.from("auto")) {
                                            throw OpenAIInvalidDataException(
                                                "'auto' is invalid, received $it"
                                            )
                                        }
                                    }
                                }

                                override fun visitManual(manual: Double) {}
                            }
                        )
                        validated = true
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

                        @JvmStatic fun ofAuto() = Beta(auto = JsonValue.from("auto"))

                        @JvmStatic fun ofManual(manual: Double) = Beta(manual = manual)
                    }

                    /**
                     * An interface that defines how to map each variant of [Beta] to a value of
                     * type [T].
                     */
                    interface Visitor<out T> {

                        fun visitAuto(auto: JsonValue): T

                        fun visitManual(manual: Double): T

                        /**
                         * Maps an unknown variant of [Beta] to a value of type [T].
                         *
                         * An instance of [Beta] can contain an unknown variant if it was
                         * deserialized from data that doesn't match any known variant. For example,
                         * if the SDK is on an older version than the API, then the API may respond
                         * with new variants that the SDK is unaware of.
                         *
                         * @throws OpenAIInvalidDataException in the default implementation.
                         */
                        fun unknown(json: JsonValue?): T {
                            throw OpenAIInvalidDataException("Unknown Beta: $json")
                        }
                    }

                    internal class Deserializer : BaseDeserializer<Beta>(Beta::class) {

                        override fun ObjectCodec.deserialize(node: JsonNode): Beta {
                            val json = JsonValue.fromJsonNode(node)

                            tryDeserialize(node, jacksonTypeRef<JsonValue>()) {
                                    it.let {
                                        if (it != JsonValue.from("auto")) {
                                            throw OpenAIInvalidDataException(
                                                "'auto' is invalid, received $it"
                                            )
                                        }
                                    }
                                }
                                ?.let {
                                    return Beta(auto = it, _json = json)
                                }
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                return Beta(manual = it, _json = json)
                            }

                            return Beta(_json = json)
                        }
                    }

                    internal class Serializer : BaseSerializer<Beta>(Beta::class) {

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
                }

                /**
                 * Scaling factor for the learning rate. A smaller learning rate may be useful to
                 * avoid overfitting.
                 */
                @JsonDeserialize(using = LearningRateMultiplier.Deserializer::class)
                @JsonSerialize(using = LearningRateMultiplier.Serializer::class)
                class LearningRateMultiplier
                private constructor(
                    private val auto: JsonValue? = null,
                    private val manual: Double? = null,
                    private val _json: JsonValue? = null,
                ) {

                    fun auto(): Optional<JsonValue> = Optional.ofNullable(auto)

                    fun manual(): Optional<Double> = Optional.ofNullable(manual)

                    fun isAuto(): Boolean = auto != null

                    fun isManual(): Boolean = manual != null

                    fun asAuto(): JsonValue = auto.getOrThrow("auto")

                    fun asManual(): Double = manual.getOrThrow("manual")

                    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                    fun <T> accept(visitor: Visitor<T>): T {
                        return when {
                            auto != null -> visitor.visitAuto(auto)
                            manual != null -> visitor.visitManual(manual)
                            else -> visitor.unknown(_json)
                        }
                    }

                    private var validated: Boolean = false

                    fun validate(): LearningRateMultiplier = apply {
                        if (validated) {
                            return@apply
                        }

                        accept(
                            object : Visitor<Unit> {
                                override fun visitAuto(auto: JsonValue) {
                                    auto.let {
                                        if (it != JsonValue.from("auto")) {
                                            throw OpenAIInvalidDataException(
                                                "'auto' is invalid, received $it"
                                            )
                                        }
                                    }
                                }

                                override fun visitManual(manual: Double) {}
                            }
                        )
                        validated = true
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

                        @JvmStatic
                        fun ofAuto() = LearningRateMultiplier(auto = JsonValue.from("auto"))

                        @JvmStatic
                        fun ofManual(manual: Double) = LearningRateMultiplier(manual = manual)
                    }

                    /**
                     * An interface that defines how to map each variant of [LearningRateMultiplier]
                     * to a value of type [T].
                     */
                    interface Visitor<out T> {

                        fun visitAuto(auto: JsonValue): T

                        fun visitManual(manual: Double): T

                        /**
                         * Maps an unknown variant of [LearningRateMultiplier] to a value of type
                         * [T].
                         *
                         * An instance of [LearningRateMultiplier] can contain an unknown variant if
                         * it was deserialized from data that doesn't match any known variant. For
                         * example, if the SDK is on an older version than the API, then the API may
                         * respond with new variants that the SDK is unaware of.
                         *
                         * @throws OpenAIInvalidDataException in the default implementation.
                         */
                        fun unknown(json: JsonValue?): T {
                            throw OpenAIInvalidDataException(
                                "Unknown LearningRateMultiplier: $json"
                            )
                        }
                    }

                    internal class Deserializer :
                        BaseDeserializer<LearningRateMultiplier>(LearningRateMultiplier::class) {

                        override fun ObjectCodec.deserialize(
                            node: JsonNode
                        ): LearningRateMultiplier {
                            val json = JsonValue.fromJsonNode(node)

                            tryDeserialize(node, jacksonTypeRef<JsonValue>()) {
                                    it.let {
                                        if (it != JsonValue.from("auto")) {
                                            throw OpenAIInvalidDataException(
                                                "'auto' is invalid, received $it"
                                            )
                                        }
                                    }
                                }
                                ?.let {
                                    return LearningRateMultiplier(auto = it, _json = json)
                                }
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                return LearningRateMultiplier(manual = it, _json = json)
                            }

                            return LearningRateMultiplier(_json = json)
                        }
                    }

                    internal class Serializer :
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
                }

                /**
                 * The number of epochs to train the model for. An epoch refers to one full cycle
                 * through the training dataset.
                 */
                @JsonDeserialize(using = NEpochs.Deserializer::class)
                @JsonSerialize(using = NEpochs.Serializer::class)
                class NEpochs
                private constructor(
                    private val auto: JsonValue? = null,
                    private val manual: Long? = null,
                    private val _json: JsonValue? = null,
                ) {

                    fun auto(): Optional<JsonValue> = Optional.ofNullable(auto)

                    fun manual(): Optional<Long> = Optional.ofNullable(manual)

                    fun isAuto(): Boolean = auto != null

                    fun isManual(): Boolean = manual != null

                    fun asAuto(): JsonValue = auto.getOrThrow("auto")

                    fun asManual(): Long = manual.getOrThrow("manual")

                    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                    fun <T> accept(visitor: Visitor<T>): T {
                        return when {
                            auto != null -> visitor.visitAuto(auto)
                            manual != null -> visitor.visitManual(manual)
                            else -> visitor.unknown(_json)
                        }
                    }

                    private var validated: Boolean = false

                    fun validate(): NEpochs = apply {
                        if (validated) {
                            return@apply
                        }

                        accept(
                            object : Visitor<Unit> {
                                override fun visitAuto(auto: JsonValue) {
                                    auto.let {
                                        if (it != JsonValue.from("auto")) {
                                            throw OpenAIInvalidDataException(
                                                "'auto' is invalid, received $it"
                                            )
                                        }
                                    }
                                }

                                override fun visitManual(manual: Long) {}
                            }
                        )
                        validated = true
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

                        @JvmStatic fun ofAuto() = NEpochs(auto = JsonValue.from("auto"))

                        @JvmStatic fun ofManual(manual: Long) = NEpochs(manual = manual)
                    }

                    /**
                     * An interface that defines how to map each variant of [NEpochs] to a value of
                     * type [T].
                     */
                    interface Visitor<out T> {

                        fun visitAuto(auto: JsonValue): T

                        fun visitManual(manual: Long): T

                        /**
                         * Maps an unknown variant of [NEpochs] to a value of type [T].
                         *
                         * An instance of [NEpochs] can contain an unknown variant if it was
                         * deserialized from data that doesn't match any known variant. For example,
                         * if the SDK is on an older version than the API, then the API may respond
                         * with new variants that the SDK is unaware of.
                         *
                         * @throws OpenAIInvalidDataException in the default implementation.
                         */
                        fun unknown(json: JsonValue?): T {
                            throw OpenAIInvalidDataException("Unknown NEpochs: $json")
                        }
                    }

                    internal class Deserializer : BaseDeserializer<NEpochs>(NEpochs::class) {

                        override fun ObjectCodec.deserialize(node: JsonNode): NEpochs {
                            val json = JsonValue.fromJsonNode(node)

                            tryDeserialize(node, jacksonTypeRef<JsonValue>()) {
                                    it.let {
                                        if (it != JsonValue.from("auto")) {
                                            throw OpenAIInvalidDataException(
                                                "'auto' is invalid, received $it"
                                            )
                                        }
                                    }
                                }
                                ?.let {
                                    return NEpochs(auto = it, _json = json)
                                }
                            tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                                return NEpochs(manual = it, _json = json)
                            }

                            return NEpochs(_json = json)
                        }
                    }

                    internal class Serializer : BaseSerializer<NEpochs>(NEpochs::class) {

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
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Hyperparameters && batchSize == other.batchSize && beta == other.beta && learningRateMultiplier == other.learningRateMultiplier && nEpochs == other.nEpochs && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(batchSize, beta, learningRateMultiplier, nEpochs, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Hyperparameters{batchSize=$batchSize, beta=$beta, learningRateMultiplier=$learningRateMultiplier, nEpochs=$nEpochs, additionalProperties=$additionalProperties}"
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
            @JsonProperty("hyperparameters")
            @ExcludeMissing
            private val hyperparameters: JsonField<Hyperparameters> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /** The hyperparameters used for the fine-tuning job. */
            fun hyperparameters(): Optional<Hyperparameters> =
                Optional.ofNullable(hyperparameters.getNullable("hyperparameters"))

            /** The hyperparameters used for the fine-tuning job. */
            @JsonProperty("hyperparameters")
            @ExcludeMissing
            fun _hyperparameters(): JsonField<Hyperparameters> = hyperparameters

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): Supervised = apply {
                if (validated) {
                    return@apply
                }

                hyperparameters().ifPresent { it.validate() }
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Supervised]. */
            class Builder internal constructor() {

                private var hyperparameters: JsonField<Hyperparameters> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(supervised: Supervised) = apply {
                    hyperparameters = supervised.hyperparameters
                    additionalProperties = supervised.additionalProperties.toMutableMap()
                }

                /** The hyperparameters used for the fine-tuning job. */
                fun hyperparameters(hyperparameters: Hyperparameters) =
                    hyperparameters(JsonField.of(hyperparameters))

                /** The hyperparameters used for the fine-tuning job. */
                fun hyperparameters(hyperparameters: JsonField<Hyperparameters>) = apply {
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
                @JsonProperty("batch_size")
                @ExcludeMissing
                private val batchSize: JsonField<BatchSize> = JsonMissing.of(),
                @JsonProperty("learning_rate_multiplier")
                @ExcludeMissing
                private val learningRateMultiplier: JsonField<LearningRateMultiplier> =
                    JsonMissing.of(),
                @JsonProperty("n_epochs")
                @ExcludeMissing
                private val nEpochs: JsonField<NEpochs> = JsonMissing.of(),
                @JsonAnySetter
                private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
            ) {

                /**
                 * Number of examples in each batch. A larger batch size means that model parameters
                 * are updated less frequently, but with lower variance.
                 */
                fun batchSize(): Optional<BatchSize> =
                    Optional.ofNullable(batchSize.getNullable("batch_size"))

                /**
                 * Scaling factor for the learning rate. A smaller learning rate may be useful to
                 * avoid overfitting.
                 */
                fun learningRateMultiplier(): Optional<LearningRateMultiplier> =
                    Optional.ofNullable(
                        learningRateMultiplier.getNullable("learning_rate_multiplier")
                    )

                /**
                 * The number of epochs to train the model for. An epoch refers to one full cycle
                 * through the training dataset.
                 */
                fun nEpochs(): Optional<NEpochs> =
                    Optional.ofNullable(nEpochs.getNullable("n_epochs"))

                /**
                 * Number of examples in each batch. A larger batch size means that model parameters
                 * are updated less frequently, but with lower variance.
                 */
                @JsonProperty("batch_size")
                @ExcludeMissing
                fun _batchSize(): JsonField<BatchSize> = batchSize

                /**
                 * Scaling factor for the learning rate. A smaller learning rate may be useful to
                 * avoid overfitting.
                 */
                @JsonProperty("learning_rate_multiplier")
                @ExcludeMissing
                fun _learningRateMultiplier(): JsonField<LearningRateMultiplier> =
                    learningRateMultiplier

                /**
                 * The number of epochs to train the model for. An epoch refers to one full cycle
                 * through the training dataset.
                 */
                @JsonProperty("n_epochs")
                @ExcludeMissing
                fun _nEpochs(): JsonField<NEpochs> = nEpochs

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                private var validated: Boolean = false

                fun validate(): Hyperparameters = apply {
                    if (validated) {
                        return@apply
                    }

                    batchSize().ifPresent { it.validate() }
                    learningRateMultiplier().ifPresent { it.validate() }
                    nEpochs().ifPresent { it.validate() }
                    validated = true
                }

                fun toBuilder() = Builder().from(this)

                companion object {

                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Hyperparameters]. */
                class Builder internal constructor() {

                    private var batchSize: JsonField<BatchSize> = JsonMissing.of()
                    private var learningRateMultiplier: JsonField<LearningRateMultiplier> =
                        JsonMissing.of()
                    private var nEpochs: JsonField<NEpochs> = JsonMissing.of()
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
                    fun batchSize(batchSize: BatchSize) = batchSize(JsonField.of(batchSize))

                    /**
                     * Number of examples in each batch. A larger batch size means that model
                     * parameters are updated less frequently, but with lower variance.
                     */
                    fun batchSize(batchSize: JsonField<BatchSize>) = apply {
                        this.batchSize = batchSize
                    }

                    /**
                     * Number of examples in each batch. A larger batch size means that model
                     * parameters are updated less frequently, but with lower variance.
                     */
                    fun batchSizeAuto() = batchSize(BatchSize.ofAuto())

                    /**
                     * Number of examples in each batch. A larger batch size means that model
                     * parameters are updated less frequently, but with lower variance.
                     */
                    fun batchSize(manual: Long) = batchSize(BatchSize.ofManual(manual))

                    /**
                     * Scaling factor for the learning rate. A smaller learning rate may be useful
                     * to avoid overfitting.
                     */
                    fun learningRateMultiplier(learningRateMultiplier: LearningRateMultiplier) =
                        learningRateMultiplier(JsonField.of(learningRateMultiplier))

                    /**
                     * Scaling factor for the learning rate. A smaller learning rate may be useful
                     * to avoid overfitting.
                     */
                    fun learningRateMultiplier(
                        learningRateMultiplier: JsonField<LearningRateMultiplier>
                    ) = apply { this.learningRateMultiplier = learningRateMultiplier }

                    /**
                     * Scaling factor for the learning rate. A smaller learning rate may be useful
                     * to avoid overfitting.
                     */
                    fun learningRateMultiplierAuto() =
                        learningRateMultiplier(LearningRateMultiplier.ofAuto())

                    /**
                     * Scaling factor for the learning rate. A smaller learning rate may be useful
                     * to avoid overfitting.
                     */
                    fun learningRateMultiplier(manual: Double) =
                        learningRateMultiplier(LearningRateMultiplier.ofManual(manual))

                    /**
                     * The number of epochs to train the model for. An epoch refers to one full
                     * cycle through the training dataset.
                     */
                    fun nEpochs(nEpochs: NEpochs) = nEpochs(JsonField.of(nEpochs))

                    /**
                     * The number of epochs to train the model for. An epoch refers to one full
                     * cycle through the training dataset.
                     */
                    fun nEpochs(nEpochs: JsonField<NEpochs>) = apply { this.nEpochs = nEpochs }

                    /**
                     * The number of epochs to train the model for. An epoch refers to one full
                     * cycle through the training dataset.
                     */
                    fun nEpochsAuto() = nEpochs(NEpochs.ofAuto())

                    /**
                     * The number of epochs to train the model for. An epoch refers to one full
                     * cycle through the training dataset.
                     */
                    fun nEpochs(manual: Long) = nEpochs(NEpochs.ofManual(manual))

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
                    private val auto: JsonValue? = null,
                    private val manual: Long? = null,
                    private val _json: JsonValue? = null,
                ) {

                    fun auto(): Optional<JsonValue> = Optional.ofNullable(auto)

                    fun manual(): Optional<Long> = Optional.ofNullable(manual)

                    fun isAuto(): Boolean = auto != null

                    fun isManual(): Boolean = manual != null

                    fun asAuto(): JsonValue = auto.getOrThrow("auto")

                    fun asManual(): Long = manual.getOrThrow("manual")

                    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                    fun <T> accept(visitor: Visitor<T>): T {
                        return when {
                            auto != null -> visitor.visitAuto(auto)
                            manual != null -> visitor.visitManual(manual)
                            else -> visitor.unknown(_json)
                        }
                    }

                    private var validated: Boolean = false

                    fun validate(): BatchSize = apply {
                        if (validated) {
                            return@apply
                        }

                        accept(
                            object : Visitor<Unit> {
                                override fun visitAuto(auto: JsonValue) {
                                    auto.let {
                                        if (it != JsonValue.from("auto")) {
                                            throw OpenAIInvalidDataException(
                                                "'auto' is invalid, received $it"
                                            )
                                        }
                                    }
                                }

                                override fun visitManual(manual: Long) {}
                            }
                        )
                        validated = true
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

                        @JvmStatic fun ofAuto() = BatchSize(auto = JsonValue.from("auto"))

                        @JvmStatic fun ofManual(manual: Long) = BatchSize(manual = manual)
                    }

                    /**
                     * An interface that defines how to map each variant of [BatchSize] to a value
                     * of type [T].
                     */
                    interface Visitor<out T> {

                        fun visitAuto(auto: JsonValue): T

                        fun visitManual(manual: Long): T

                        /**
                         * Maps an unknown variant of [BatchSize] to a value of type [T].
                         *
                         * An instance of [BatchSize] can contain an unknown variant if it was
                         * deserialized from data that doesn't match any known variant. For example,
                         * if the SDK is on an older version than the API, then the API may respond
                         * with new variants that the SDK is unaware of.
                         *
                         * @throws OpenAIInvalidDataException in the default implementation.
                         */
                        fun unknown(json: JsonValue?): T {
                            throw OpenAIInvalidDataException("Unknown BatchSize: $json")
                        }
                    }

                    internal class Deserializer : BaseDeserializer<BatchSize>(BatchSize::class) {

                        override fun ObjectCodec.deserialize(node: JsonNode): BatchSize {
                            val json = JsonValue.fromJsonNode(node)

                            tryDeserialize(node, jacksonTypeRef<JsonValue>()) {
                                    it.let {
                                        if (it != JsonValue.from("auto")) {
                                            throw OpenAIInvalidDataException(
                                                "'auto' is invalid, received $it"
                                            )
                                        }
                                    }
                                }
                                ?.let {
                                    return BatchSize(auto = it, _json = json)
                                }
                            tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                                return BatchSize(manual = it, _json = json)
                            }

                            return BatchSize(_json = json)
                        }
                    }

                    internal class Serializer : BaseSerializer<BatchSize>(BatchSize::class) {

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
                }

                /**
                 * Scaling factor for the learning rate. A smaller learning rate may be useful to
                 * avoid overfitting.
                 */
                @JsonDeserialize(using = LearningRateMultiplier.Deserializer::class)
                @JsonSerialize(using = LearningRateMultiplier.Serializer::class)
                class LearningRateMultiplier
                private constructor(
                    private val auto: JsonValue? = null,
                    private val manual: Double? = null,
                    private val _json: JsonValue? = null,
                ) {

                    fun auto(): Optional<JsonValue> = Optional.ofNullable(auto)

                    fun manual(): Optional<Double> = Optional.ofNullable(manual)

                    fun isAuto(): Boolean = auto != null

                    fun isManual(): Boolean = manual != null

                    fun asAuto(): JsonValue = auto.getOrThrow("auto")

                    fun asManual(): Double = manual.getOrThrow("manual")

                    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                    fun <T> accept(visitor: Visitor<T>): T {
                        return when {
                            auto != null -> visitor.visitAuto(auto)
                            manual != null -> visitor.visitManual(manual)
                            else -> visitor.unknown(_json)
                        }
                    }

                    private var validated: Boolean = false

                    fun validate(): LearningRateMultiplier = apply {
                        if (validated) {
                            return@apply
                        }

                        accept(
                            object : Visitor<Unit> {
                                override fun visitAuto(auto: JsonValue) {
                                    auto.let {
                                        if (it != JsonValue.from("auto")) {
                                            throw OpenAIInvalidDataException(
                                                "'auto' is invalid, received $it"
                                            )
                                        }
                                    }
                                }

                                override fun visitManual(manual: Double) {}
                            }
                        )
                        validated = true
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

                        @JvmStatic
                        fun ofAuto() = LearningRateMultiplier(auto = JsonValue.from("auto"))

                        @JvmStatic
                        fun ofManual(manual: Double) = LearningRateMultiplier(manual = manual)
                    }

                    /**
                     * An interface that defines how to map each variant of [LearningRateMultiplier]
                     * to a value of type [T].
                     */
                    interface Visitor<out T> {

                        fun visitAuto(auto: JsonValue): T

                        fun visitManual(manual: Double): T

                        /**
                         * Maps an unknown variant of [LearningRateMultiplier] to a value of type
                         * [T].
                         *
                         * An instance of [LearningRateMultiplier] can contain an unknown variant if
                         * it was deserialized from data that doesn't match any known variant. For
                         * example, if the SDK is on an older version than the API, then the API may
                         * respond with new variants that the SDK is unaware of.
                         *
                         * @throws OpenAIInvalidDataException in the default implementation.
                         */
                        fun unknown(json: JsonValue?): T {
                            throw OpenAIInvalidDataException(
                                "Unknown LearningRateMultiplier: $json"
                            )
                        }
                    }

                    internal class Deserializer :
                        BaseDeserializer<LearningRateMultiplier>(LearningRateMultiplier::class) {

                        override fun ObjectCodec.deserialize(
                            node: JsonNode
                        ): LearningRateMultiplier {
                            val json = JsonValue.fromJsonNode(node)

                            tryDeserialize(node, jacksonTypeRef<JsonValue>()) {
                                    it.let {
                                        if (it != JsonValue.from("auto")) {
                                            throw OpenAIInvalidDataException(
                                                "'auto' is invalid, received $it"
                                            )
                                        }
                                    }
                                }
                                ?.let {
                                    return LearningRateMultiplier(auto = it, _json = json)
                                }
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                return LearningRateMultiplier(manual = it, _json = json)
                            }

                            return LearningRateMultiplier(_json = json)
                        }
                    }

                    internal class Serializer :
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
                }

                /**
                 * The number of epochs to train the model for. An epoch refers to one full cycle
                 * through the training dataset.
                 */
                @JsonDeserialize(using = NEpochs.Deserializer::class)
                @JsonSerialize(using = NEpochs.Serializer::class)
                class NEpochs
                private constructor(
                    private val auto: JsonValue? = null,
                    private val manual: Long? = null,
                    private val _json: JsonValue? = null,
                ) {

                    fun auto(): Optional<JsonValue> = Optional.ofNullable(auto)

                    fun manual(): Optional<Long> = Optional.ofNullable(manual)

                    fun isAuto(): Boolean = auto != null

                    fun isManual(): Boolean = manual != null

                    fun asAuto(): JsonValue = auto.getOrThrow("auto")

                    fun asManual(): Long = manual.getOrThrow("manual")

                    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                    fun <T> accept(visitor: Visitor<T>): T {
                        return when {
                            auto != null -> visitor.visitAuto(auto)
                            manual != null -> visitor.visitManual(manual)
                            else -> visitor.unknown(_json)
                        }
                    }

                    private var validated: Boolean = false

                    fun validate(): NEpochs = apply {
                        if (validated) {
                            return@apply
                        }

                        accept(
                            object : Visitor<Unit> {
                                override fun visitAuto(auto: JsonValue) {
                                    auto.let {
                                        if (it != JsonValue.from("auto")) {
                                            throw OpenAIInvalidDataException(
                                                "'auto' is invalid, received $it"
                                            )
                                        }
                                    }
                                }

                                override fun visitManual(manual: Long) {}
                            }
                        )
                        validated = true
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

                        @JvmStatic fun ofAuto() = NEpochs(auto = JsonValue.from("auto"))

                        @JvmStatic fun ofManual(manual: Long) = NEpochs(manual = manual)
                    }

                    /**
                     * An interface that defines how to map each variant of [NEpochs] to a value of
                     * type [T].
                     */
                    interface Visitor<out T> {

                        fun visitAuto(auto: JsonValue): T

                        fun visitManual(manual: Long): T

                        /**
                         * Maps an unknown variant of [NEpochs] to a value of type [T].
                         *
                         * An instance of [NEpochs] can contain an unknown variant if it was
                         * deserialized from data that doesn't match any known variant. For example,
                         * if the SDK is on an older version than the API, then the API may respond
                         * with new variants that the SDK is unaware of.
                         *
                         * @throws OpenAIInvalidDataException in the default implementation.
                         */
                        fun unknown(json: JsonValue?): T {
                            throw OpenAIInvalidDataException("Unknown NEpochs: $json")
                        }
                    }

                    internal class Deserializer : BaseDeserializer<NEpochs>(NEpochs::class) {

                        override fun ObjectCodec.deserialize(node: JsonNode): NEpochs {
                            val json = JsonValue.fromJsonNode(node)

                            tryDeserialize(node, jacksonTypeRef<JsonValue>()) {
                                    it.let {
                                        if (it != JsonValue.from("auto")) {
                                            throw OpenAIInvalidDataException(
                                                "'auto' is invalid, received $it"
                                            )
                                        }
                                    }
                                }
                                ?.let {
                                    return NEpochs(auto = it, _json = json)
                                }
                            tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                                return NEpochs(manual = it, _json = json)
                            }

                            return NEpochs(_json = json)
                        }
                    }

                    internal class Serializer : BaseSerializer<NEpochs>(NEpochs::class) {

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

        /** The type of method. Is either `supervised` or `dpo`. */
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

                @JvmField val SUPERVISED = of("supervised")

                @JvmField val DPO = of("dpo")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            enum class Known {
                SUPERVISED,
                DPO,
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
                SUPERVISED,
                DPO,
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
                    SUPERVISED -> Value.SUPERVISED
                    DPO -> Value.DPO
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

            return /* spotless:off */ other is Method && dpo == other.dpo && supervised == other.supervised && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(dpo, supervised, type, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Method{dpo=$dpo, supervised=$supervised, type=$type, additionalProperties=$additionalProperties}"
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
