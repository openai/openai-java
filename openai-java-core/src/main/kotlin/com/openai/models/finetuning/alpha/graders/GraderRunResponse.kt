// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.alpha.graders

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class GraderRunResponse
private constructor(
    private val metadata: JsonField<Metadata>,
    private val modelGraderTokenUsagePerModel: JsonField<ModelGraderTokenUsagePerModel>,
    private val reward: JsonField<Double>,
    private val subRewards: JsonField<SubRewards>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("metadata") @ExcludeMissing metadata: JsonField<Metadata> = JsonMissing.of(),
        @JsonProperty("model_grader_token_usage_per_model")
        @ExcludeMissing
        modelGraderTokenUsagePerModel: JsonField<ModelGraderTokenUsagePerModel> = JsonMissing.of(),
        @JsonProperty("reward") @ExcludeMissing reward: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("sub_rewards")
        @ExcludeMissing
        subRewards: JsonField<SubRewards> = JsonMissing.of(),
    ) : this(metadata, modelGraderTokenUsagePerModel, reward, subRewards, mutableMapOf())

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun metadata(): Metadata = metadata.getRequired("metadata")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun modelGraderTokenUsagePerModel(): ModelGraderTokenUsagePerModel =
        modelGraderTokenUsagePerModel.getRequired("model_grader_token_usage_per_model")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun reward(): Double = reward.getRequired("reward")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun subRewards(): SubRewards = subRewards.getRequired("sub_rewards")

    /**
     * Returns the raw JSON value of [metadata].
     *
     * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonField<Metadata> = metadata

    /**
     * Returns the raw JSON value of [modelGraderTokenUsagePerModel].
     *
     * Unlike [modelGraderTokenUsagePerModel], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("model_grader_token_usage_per_model")
    @ExcludeMissing
    fun _modelGraderTokenUsagePerModel(): JsonField<ModelGraderTokenUsagePerModel> =
        modelGraderTokenUsagePerModel

    /**
     * Returns the raw JSON value of [reward].
     *
     * Unlike [reward], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("reward") @ExcludeMissing fun _reward(): JsonField<Double> = reward

    /**
     * Returns the raw JSON value of [subRewards].
     *
     * Unlike [subRewards], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sub_rewards")
    @ExcludeMissing
    fun _subRewards(): JsonField<SubRewards> = subRewards

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
         * Returns a mutable builder for constructing an instance of [GraderRunResponse].
         *
         * The following fields are required:
         * ```java
         * .metadata()
         * .modelGraderTokenUsagePerModel()
         * .reward()
         * .subRewards()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [GraderRunResponse]. */
    class Builder internal constructor() {

        private var metadata: JsonField<Metadata>? = null
        private var modelGraderTokenUsagePerModel: JsonField<ModelGraderTokenUsagePerModel>? = null
        private var reward: JsonField<Double>? = null
        private var subRewards: JsonField<SubRewards>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(graderRunResponse: GraderRunResponse) = apply {
            metadata = graderRunResponse.metadata
            modelGraderTokenUsagePerModel = graderRunResponse.modelGraderTokenUsagePerModel
            reward = graderRunResponse.reward
            subRewards = graderRunResponse.subRewards
            additionalProperties = graderRunResponse.additionalProperties.toMutableMap()
        }

        fun metadata(metadata: Metadata) = metadata(JsonField.of(metadata))

        /**
         * Sets [Builder.metadata] to an arbitrary JSON value.
         *
         * You should usually call [Builder.metadata] with a well-typed [Metadata] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

        fun modelGraderTokenUsagePerModel(
            modelGraderTokenUsagePerModel: ModelGraderTokenUsagePerModel
        ) = modelGraderTokenUsagePerModel(JsonField.of(modelGraderTokenUsagePerModel))

        /**
         * Sets [Builder.modelGraderTokenUsagePerModel] to an arbitrary JSON value.
         *
         * You should usually call [Builder.modelGraderTokenUsagePerModel] with a well-typed
         * [ModelGraderTokenUsagePerModel] value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun modelGraderTokenUsagePerModel(
            modelGraderTokenUsagePerModel: JsonField<ModelGraderTokenUsagePerModel>
        ) = apply { this.modelGraderTokenUsagePerModel = modelGraderTokenUsagePerModel }

        fun reward(reward: Double) = reward(JsonField.of(reward))

        /**
         * Sets [Builder.reward] to an arbitrary JSON value.
         *
         * You should usually call [Builder.reward] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun reward(reward: JsonField<Double>) = apply { this.reward = reward }

        fun subRewards(subRewards: SubRewards) = subRewards(JsonField.of(subRewards))

        /**
         * Sets [Builder.subRewards] to an arbitrary JSON value.
         *
         * You should usually call [Builder.subRewards] with a well-typed [SubRewards] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun subRewards(subRewards: JsonField<SubRewards>) = apply { this.subRewards = subRewards }

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
         * Returns an immutable instance of [GraderRunResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .metadata()
         * .modelGraderTokenUsagePerModel()
         * .reward()
         * .subRewards()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): GraderRunResponse =
            GraderRunResponse(
                checkRequired("metadata", metadata),
                checkRequired("modelGraderTokenUsagePerModel", modelGraderTokenUsagePerModel),
                checkRequired("reward", reward),
                checkRequired("subRewards", subRewards),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): GraderRunResponse = apply {
        if (validated) {
            return@apply
        }

        metadata().validate()
        modelGraderTokenUsagePerModel().validate()
        reward()
        subRewards().validate()
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
        (metadata.asKnown().getOrNull()?.validity() ?: 0) +
            (modelGraderTokenUsagePerModel.asKnown().getOrNull()?.validity() ?: 0) +
            (if (reward.asKnown().isPresent) 1 else 0) +
            (subRewards.asKnown().getOrNull()?.validity() ?: 0)

    class Metadata
    private constructor(
        private val errors: JsonField<Errors>,
        private val executionTime: JsonField<Double>,
        private val name: JsonField<String>,
        private val sampledModelName: JsonField<String>,
        private val scores: JsonField<Scores>,
        private val tokenUsage: JsonField<Long>,
        private val type: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("errors") @ExcludeMissing errors: JsonField<Errors> = JsonMissing.of(),
            @JsonProperty("execution_time")
            @ExcludeMissing
            executionTime: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("sampled_model_name")
            @ExcludeMissing
            sampledModelName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("scores") @ExcludeMissing scores: JsonField<Scores> = JsonMissing.of(),
            @JsonProperty("token_usage")
            @ExcludeMissing
            tokenUsage: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
        ) : this(
            errors,
            executionTime,
            name,
            sampledModelName,
            scores,
            tokenUsage,
            type,
            mutableMapOf(),
        )

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun errors(): Errors = errors.getRequired("errors")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun executionTime(): Double = executionTime.getRequired("execution_time")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun sampledModelName(): Optional<String> =
            sampledModelName.getOptional("sampled_model_name")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun scores(): Scores = scores.getRequired("scores")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun tokenUsage(): Optional<Long> = tokenUsage.getOptional("token_usage")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun type(): String = type.getRequired("type")

        /**
         * Returns the raw JSON value of [errors].
         *
         * Unlike [errors], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("errors") @ExcludeMissing fun _errors(): JsonField<Errors> = errors

        /**
         * Returns the raw JSON value of [executionTime].
         *
         * Unlike [executionTime], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("execution_time")
        @ExcludeMissing
        fun _executionTime(): JsonField<Double> = executionTime

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [sampledModelName].
         *
         * Unlike [sampledModelName], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("sampled_model_name")
        @ExcludeMissing
        fun _sampledModelName(): JsonField<String> = sampledModelName

        /**
         * Returns the raw JSON value of [scores].
         *
         * Unlike [scores], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("scores") @ExcludeMissing fun _scores(): JsonField<Scores> = scores

        /**
         * Returns the raw JSON value of [tokenUsage].
         *
         * Unlike [tokenUsage], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("token_usage") @ExcludeMissing fun _tokenUsage(): JsonField<Long> = tokenUsage

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

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
             * Returns a mutable builder for constructing an instance of [Metadata].
             *
             * The following fields are required:
             * ```java
             * .errors()
             * .executionTime()
             * .name()
             * .sampledModelName()
             * .scores()
             * .tokenUsage()
             * .type()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Metadata]. */
        class Builder internal constructor() {

            private var errors: JsonField<Errors>? = null
            private var executionTime: JsonField<Double>? = null
            private var name: JsonField<String>? = null
            private var sampledModelName: JsonField<String>? = null
            private var scores: JsonField<Scores>? = null
            private var tokenUsage: JsonField<Long>? = null
            private var type: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(metadata: Metadata) = apply {
                errors = metadata.errors
                executionTime = metadata.executionTime
                name = metadata.name
                sampledModelName = metadata.sampledModelName
                scores = metadata.scores
                tokenUsage = metadata.tokenUsage
                type = metadata.type
                additionalProperties = metadata.additionalProperties.toMutableMap()
            }

            fun errors(errors: Errors) = errors(JsonField.of(errors))

            /**
             * Sets [Builder.errors] to an arbitrary JSON value.
             *
             * You should usually call [Builder.errors] with a well-typed [Errors] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun errors(errors: JsonField<Errors>) = apply { this.errors = errors }

            fun executionTime(executionTime: Double) = executionTime(JsonField.of(executionTime))

            /**
             * Sets [Builder.executionTime] to an arbitrary JSON value.
             *
             * You should usually call [Builder.executionTime] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun executionTime(executionTime: JsonField<Double>) = apply {
                this.executionTime = executionTime
            }

            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            fun sampledModelName(sampledModelName: String?) =
                sampledModelName(JsonField.ofNullable(sampledModelName))

            /**
             * Alias for calling [Builder.sampledModelName] with `sampledModelName.orElse(null)`.
             */
            fun sampledModelName(sampledModelName: Optional<String>) =
                sampledModelName(sampledModelName.getOrNull())

            /**
             * Sets [Builder.sampledModelName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sampledModelName] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sampledModelName(sampledModelName: JsonField<String>) = apply {
                this.sampledModelName = sampledModelName
            }

            fun scores(scores: Scores) = scores(JsonField.of(scores))

            /**
             * Sets [Builder.scores] to an arbitrary JSON value.
             *
             * You should usually call [Builder.scores] with a well-typed [Scores] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun scores(scores: JsonField<Scores>) = apply { this.scores = scores }

            fun tokenUsage(tokenUsage: Long?) = tokenUsage(JsonField.ofNullable(tokenUsage))

            /**
             * Alias for [Builder.tokenUsage].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun tokenUsage(tokenUsage: Long) = tokenUsage(tokenUsage as Long?)

            /** Alias for calling [Builder.tokenUsage] with `tokenUsage.orElse(null)`. */
            fun tokenUsage(tokenUsage: Optional<Long>) = tokenUsage(tokenUsage.getOrNull())

            /**
             * Sets [Builder.tokenUsage] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tokenUsage] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tokenUsage(tokenUsage: JsonField<Long>) = apply { this.tokenUsage = tokenUsage }

            fun type(type: String) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<String>) = apply { this.type = type }

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
             * Returns an immutable instance of [Metadata].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .errors()
             * .executionTime()
             * .name()
             * .sampledModelName()
             * .scores()
             * .tokenUsage()
             * .type()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Metadata =
                Metadata(
                    checkRequired("errors", errors),
                    checkRequired("executionTime", executionTime),
                    checkRequired("name", name),
                    checkRequired("sampledModelName", sampledModelName),
                    checkRequired("scores", scores),
                    checkRequired("tokenUsage", tokenUsage),
                    checkRequired("type", type),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Metadata = apply {
            if (validated) {
                return@apply
            }

            errors().validate()
            executionTime()
            name()
            sampledModelName()
            scores().validate()
            tokenUsage()
            type()
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
            (errors.asKnown().getOrNull()?.validity() ?: 0) +
                (if (executionTime.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (sampledModelName.asKnown().isPresent) 1 else 0) +
                (scores.asKnown().getOrNull()?.validity() ?: 0) +
                (if (tokenUsage.asKnown().isPresent) 1 else 0) +
                (if (type.asKnown().isPresent) 1 else 0)

        class Errors
        private constructor(
            private val formulaParseError: JsonField<Boolean>,
            private val invalidVariableError: JsonField<Boolean>,
            private val modelGraderParseError: JsonField<Boolean>,
            private val modelGraderRefusalError: JsonField<Boolean>,
            private val modelGraderServerError: JsonField<Boolean>,
            private val modelGraderServerErrorDetails: JsonField<String>,
            private val otherError: JsonField<Boolean>,
            private val pythonGraderRuntimeError: JsonField<Boolean>,
            private val pythonGraderRuntimeErrorDetails: JsonField<String>,
            private val pythonGraderServerError: JsonField<Boolean>,
            private val pythonGraderServerErrorType: JsonField<String>,
            private val sampleParseError: JsonField<Boolean>,
            private val truncatedObservationError: JsonField<Boolean>,
            private val unresponsiveRewardError: JsonField<Boolean>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("formula_parse_error")
                @ExcludeMissing
                formulaParseError: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("invalid_variable_error")
                @ExcludeMissing
                invalidVariableError: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("model_grader_parse_error")
                @ExcludeMissing
                modelGraderParseError: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("model_grader_refusal_error")
                @ExcludeMissing
                modelGraderRefusalError: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("model_grader_server_error")
                @ExcludeMissing
                modelGraderServerError: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("model_grader_server_error_details")
                @ExcludeMissing
                modelGraderServerErrorDetails: JsonField<String> = JsonMissing.of(),
                @JsonProperty("other_error")
                @ExcludeMissing
                otherError: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("python_grader_runtime_error")
                @ExcludeMissing
                pythonGraderRuntimeError: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("python_grader_runtime_error_details")
                @ExcludeMissing
                pythonGraderRuntimeErrorDetails: JsonField<String> = JsonMissing.of(),
                @JsonProperty("python_grader_server_error")
                @ExcludeMissing
                pythonGraderServerError: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("python_grader_server_error_type")
                @ExcludeMissing
                pythonGraderServerErrorType: JsonField<String> = JsonMissing.of(),
                @JsonProperty("sample_parse_error")
                @ExcludeMissing
                sampleParseError: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("truncated_observation_error")
                @ExcludeMissing
                truncatedObservationError: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("unresponsive_reward_error")
                @ExcludeMissing
                unresponsiveRewardError: JsonField<Boolean> = JsonMissing.of(),
            ) : this(
                formulaParseError,
                invalidVariableError,
                modelGraderParseError,
                modelGraderRefusalError,
                modelGraderServerError,
                modelGraderServerErrorDetails,
                otherError,
                pythonGraderRuntimeError,
                pythonGraderRuntimeErrorDetails,
                pythonGraderServerError,
                pythonGraderServerErrorType,
                sampleParseError,
                truncatedObservationError,
                unresponsiveRewardError,
                mutableMapOf(),
            )

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun formulaParseError(): Boolean = formulaParseError.getRequired("formula_parse_error")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun invalidVariableError(): Boolean =
                invalidVariableError.getRequired("invalid_variable_error")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun modelGraderParseError(): Boolean =
                modelGraderParseError.getRequired("model_grader_parse_error")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun modelGraderRefusalError(): Boolean =
                modelGraderRefusalError.getRequired("model_grader_refusal_error")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun modelGraderServerError(): Boolean =
                modelGraderServerError.getRequired("model_grader_server_error")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun modelGraderServerErrorDetails(): Optional<String> =
                modelGraderServerErrorDetails.getOptional("model_grader_server_error_details")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun otherError(): Boolean = otherError.getRequired("other_error")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun pythonGraderRuntimeError(): Boolean =
                pythonGraderRuntimeError.getRequired("python_grader_runtime_error")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun pythonGraderRuntimeErrorDetails(): Optional<String> =
                pythonGraderRuntimeErrorDetails.getOptional("python_grader_runtime_error_details")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun pythonGraderServerError(): Boolean =
                pythonGraderServerError.getRequired("python_grader_server_error")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun pythonGraderServerErrorType(): Optional<String> =
                pythonGraderServerErrorType.getOptional("python_grader_server_error_type")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun sampleParseError(): Boolean = sampleParseError.getRequired("sample_parse_error")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun truncatedObservationError(): Boolean =
                truncatedObservationError.getRequired("truncated_observation_error")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun unresponsiveRewardError(): Boolean =
                unresponsiveRewardError.getRequired("unresponsive_reward_error")

            /**
             * Returns the raw JSON value of [formulaParseError].
             *
             * Unlike [formulaParseError], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("formula_parse_error")
            @ExcludeMissing
            fun _formulaParseError(): JsonField<Boolean> = formulaParseError

            /**
             * Returns the raw JSON value of [invalidVariableError].
             *
             * Unlike [invalidVariableError], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("invalid_variable_error")
            @ExcludeMissing
            fun _invalidVariableError(): JsonField<Boolean> = invalidVariableError

            /**
             * Returns the raw JSON value of [modelGraderParseError].
             *
             * Unlike [modelGraderParseError], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("model_grader_parse_error")
            @ExcludeMissing
            fun _modelGraderParseError(): JsonField<Boolean> = modelGraderParseError

            /**
             * Returns the raw JSON value of [modelGraderRefusalError].
             *
             * Unlike [modelGraderRefusalError], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("model_grader_refusal_error")
            @ExcludeMissing
            fun _modelGraderRefusalError(): JsonField<Boolean> = modelGraderRefusalError

            /**
             * Returns the raw JSON value of [modelGraderServerError].
             *
             * Unlike [modelGraderServerError], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("model_grader_server_error")
            @ExcludeMissing
            fun _modelGraderServerError(): JsonField<Boolean> = modelGraderServerError

            /**
             * Returns the raw JSON value of [modelGraderServerErrorDetails].
             *
             * Unlike [modelGraderServerErrorDetails], this method doesn't throw if the JSON field
             * has an unexpected type.
             */
            @JsonProperty("model_grader_server_error_details")
            @ExcludeMissing
            fun _modelGraderServerErrorDetails(): JsonField<String> = modelGraderServerErrorDetails

            /**
             * Returns the raw JSON value of [otherError].
             *
             * Unlike [otherError], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("other_error")
            @ExcludeMissing
            fun _otherError(): JsonField<Boolean> = otherError

            /**
             * Returns the raw JSON value of [pythonGraderRuntimeError].
             *
             * Unlike [pythonGraderRuntimeError], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("python_grader_runtime_error")
            @ExcludeMissing
            fun _pythonGraderRuntimeError(): JsonField<Boolean> = pythonGraderRuntimeError

            /**
             * Returns the raw JSON value of [pythonGraderRuntimeErrorDetails].
             *
             * Unlike [pythonGraderRuntimeErrorDetails], this method doesn't throw if the JSON field
             * has an unexpected type.
             */
            @JsonProperty("python_grader_runtime_error_details")
            @ExcludeMissing
            fun _pythonGraderRuntimeErrorDetails(): JsonField<String> =
                pythonGraderRuntimeErrorDetails

            /**
             * Returns the raw JSON value of [pythonGraderServerError].
             *
             * Unlike [pythonGraderServerError], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("python_grader_server_error")
            @ExcludeMissing
            fun _pythonGraderServerError(): JsonField<Boolean> = pythonGraderServerError

            /**
             * Returns the raw JSON value of [pythonGraderServerErrorType].
             *
             * Unlike [pythonGraderServerErrorType], this method doesn't throw if the JSON field has
             * an unexpected type.
             */
            @JsonProperty("python_grader_server_error_type")
            @ExcludeMissing
            fun _pythonGraderServerErrorType(): JsonField<String> = pythonGraderServerErrorType

            /**
             * Returns the raw JSON value of [sampleParseError].
             *
             * Unlike [sampleParseError], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("sample_parse_error")
            @ExcludeMissing
            fun _sampleParseError(): JsonField<Boolean> = sampleParseError

            /**
             * Returns the raw JSON value of [truncatedObservationError].
             *
             * Unlike [truncatedObservationError], this method doesn't throw if the JSON field has
             * an unexpected type.
             */
            @JsonProperty("truncated_observation_error")
            @ExcludeMissing
            fun _truncatedObservationError(): JsonField<Boolean> = truncatedObservationError

            /**
             * Returns the raw JSON value of [unresponsiveRewardError].
             *
             * Unlike [unresponsiveRewardError], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("unresponsive_reward_error")
            @ExcludeMissing
            fun _unresponsiveRewardError(): JsonField<Boolean> = unresponsiveRewardError

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
                 * Returns a mutable builder for constructing an instance of [Errors].
                 *
                 * The following fields are required:
                 * ```java
                 * .formulaParseError()
                 * .invalidVariableError()
                 * .modelGraderParseError()
                 * .modelGraderRefusalError()
                 * .modelGraderServerError()
                 * .modelGraderServerErrorDetails()
                 * .otherError()
                 * .pythonGraderRuntimeError()
                 * .pythonGraderRuntimeErrorDetails()
                 * .pythonGraderServerError()
                 * .pythonGraderServerErrorType()
                 * .sampleParseError()
                 * .truncatedObservationError()
                 * .unresponsiveRewardError()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Errors]. */
            class Builder internal constructor() {

                private var formulaParseError: JsonField<Boolean>? = null
                private var invalidVariableError: JsonField<Boolean>? = null
                private var modelGraderParseError: JsonField<Boolean>? = null
                private var modelGraderRefusalError: JsonField<Boolean>? = null
                private var modelGraderServerError: JsonField<Boolean>? = null
                private var modelGraderServerErrorDetails: JsonField<String>? = null
                private var otherError: JsonField<Boolean>? = null
                private var pythonGraderRuntimeError: JsonField<Boolean>? = null
                private var pythonGraderRuntimeErrorDetails: JsonField<String>? = null
                private var pythonGraderServerError: JsonField<Boolean>? = null
                private var pythonGraderServerErrorType: JsonField<String>? = null
                private var sampleParseError: JsonField<Boolean>? = null
                private var truncatedObservationError: JsonField<Boolean>? = null
                private var unresponsiveRewardError: JsonField<Boolean>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(errors: Errors) = apply {
                    formulaParseError = errors.formulaParseError
                    invalidVariableError = errors.invalidVariableError
                    modelGraderParseError = errors.modelGraderParseError
                    modelGraderRefusalError = errors.modelGraderRefusalError
                    modelGraderServerError = errors.modelGraderServerError
                    modelGraderServerErrorDetails = errors.modelGraderServerErrorDetails
                    otherError = errors.otherError
                    pythonGraderRuntimeError = errors.pythonGraderRuntimeError
                    pythonGraderRuntimeErrorDetails = errors.pythonGraderRuntimeErrorDetails
                    pythonGraderServerError = errors.pythonGraderServerError
                    pythonGraderServerErrorType = errors.pythonGraderServerErrorType
                    sampleParseError = errors.sampleParseError
                    truncatedObservationError = errors.truncatedObservationError
                    unresponsiveRewardError = errors.unresponsiveRewardError
                    additionalProperties = errors.additionalProperties.toMutableMap()
                }

                fun formulaParseError(formulaParseError: Boolean) =
                    formulaParseError(JsonField.of(formulaParseError))

                /**
                 * Sets [Builder.formulaParseError] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.formulaParseError] with a well-typed [Boolean]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun formulaParseError(formulaParseError: JsonField<Boolean>) = apply {
                    this.formulaParseError = formulaParseError
                }

                fun invalidVariableError(invalidVariableError: Boolean) =
                    invalidVariableError(JsonField.of(invalidVariableError))

                /**
                 * Sets [Builder.invalidVariableError] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.invalidVariableError] with a well-typed
                 * [Boolean] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun invalidVariableError(invalidVariableError: JsonField<Boolean>) = apply {
                    this.invalidVariableError = invalidVariableError
                }

                fun modelGraderParseError(modelGraderParseError: Boolean) =
                    modelGraderParseError(JsonField.of(modelGraderParseError))

                /**
                 * Sets [Builder.modelGraderParseError] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.modelGraderParseError] with a well-typed
                 * [Boolean] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun modelGraderParseError(modelGraderParseError: JsonField<Boolean>) = apply {
                    this.modelGraderParseError = modelGraderParseError
                }

                fun modelGraderRefusalError(modelGraderRefusalError: Boolean) =
                    modelGraderRefusalError(JsonField.of(modelGraderRefusalError))

                /**
                 * Sets [Builder.modelGraderRefusalError] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.modelGraderRefusalError] with a well-typed
                 * [Boolean] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun modelGraderRefusalError(modelGraderRefusalError: JsonField<Boolean>) = apply {
                    this.modelGraderRefusalError = modelGraderRefusalError
                }

                fun modelGraderServerError(modelGraderServerError: Boolean) =
                    modelGraderServerError(JsonField.of(modelGraderServerError))

                /**
                 * Sets [Builder.modelGraderServerError] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.modelGraderServerError] with a well-typed
                 * [Boolean] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun modelGraderServerError(modelGraderServerError: JsonField<Boolean>) = apply {
                    this.modelGraderServerError = modelGraderServerError
                }

                fun modelGraderServerErrorDetails(modelGraderServerErrorDetails: String?) =
                    modelGraderServerErrorDetails(
                        JsonField.ofNullable(modelGraderServerErrorDetails)
                    )

                /**
                 * Alias for calling [Builder.modelGraderServerErrorDetails] with
                 * `modelGraderServerErrorDetails.orElse(null)`.
                 */
                fun modelGraderServerErrorDetails(modelGraderServerErrorDetails: Optional<String>) =
                    modelGraderServerErrorDetails(modelGraderServerErrorDetails.getOrNull())

                /**
                 * Sets [Builder.modelGraderServerErrorDetails] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.modelGraderServerErrorDetails] with a well-typed
                 * [String] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun modelGraderServerErrorDetails(
                    modelGraderServerErrorDetails: JsonField<String>
                ) = apply { this.modelGraderServerErrorDetails = modelGraderServerErrorDetails }

                fun otherError(otherError: Boolean) = otherError(JsonField.of(otherError))

                /**
                 * Sets [Builder.otherError] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.otherError] with a well-typed [Boolean] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun otherError(otherError: JsonField<Boolean>) = apply {
                    this.otherError = otherError
                }

                fun pythonGraderRuntimeError(pythonGraderRuntimeError: Boolean) =
                    pythonGraderRuntimeError(JsonField.of(pythonGraderRuntimeError))

                /**
                 * Sets [Builder.pythonGraderRuntimeError] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.pythonGraderRuntimeError] with a well-typed
                 * [Boolean] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun pythonGraderRuntimeError(pythonGraderRuntimeError: JsonField<Boolean>) = apply {
                    this.pythonGraderRuntimeError = pythonGraderRuntimeError
                }

                fun pythonGraderRuntimeErrorDetails(pythonGraderRuntimeErrorDetails: String?) =
                    pythonGraderRuntimeErrorDetails(
                        JsonField.ofNullable(pythonGraderRuntimeErrorDetails)
                    )

                /**
                 * Alias for calling [Builder.pythonGraderRuntimeErrorDetails] with
                 * `pythonGraderRuntimeErrorDetails.orElse(null)`.
                 */
                fun pythonGraderRuntimeErrorDetails(
                    pythonGraderRuntimeErrorDetails: Optional<String>
                ) = pythonGraderRuntimeErrorDetails(pythonGraderRuntimeErrorDetails.getOrNull())

                /**
                 * Sets [Builder.pythonGraderRuntimeErrorDetails] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.pythonGraderRuntimeErrorDetails] with a
                 * well-typed [String] value instead. This method is primarily for setting the field
                 * to an undocumented or not yet supported value.
                 */
                fun pythonGraderRuntimeErrorDetails(
                    pythonGraderRuntimeErrorDetails: JsonField<String>
                ) = apply { this.pythonGraderRuntimeErrorDetails = pythonGraderRuntimeErrorDetails }

                fun pythonGraderServerError(pythonGraderServerError: Boolean) =
                    pythonGraderServerError(JsonField.of(pythonGraderServerError))

                /**
                 * Sets [Builder.pythonGraderServerError] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.pythonGraderServerError] with a well-typed
                 * [Boolean] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun pythonGraderServerError(pythonGraderServerError: JsonField<Boolean>) = apply {
                    this.pythonGraderServerError = pythonGraderServerError
                }

                fun pythonGraderServerErrorType(pythonGraderServerErrorType: String?) =
                    pythonGraderServerErrorType(JsonField.ofNullable(pythonGraderServerErrorType))

                /**
                 * Alias for calling [Builder.pythonGraderServerErrorType] with
                 * `pythonGraderServerErrorType.orElse(null)`.
                 */
                fun pythonGraderServerErrorType(pythonGraderServerErrorType: Optional<String>) =
                    pythonGraderServerErrorType(pythonGraderServerErrorType.getOrNull())

                /**
                 * Sets [Builder.pythonGraderServerErrorType] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.pythonGraderServerErrorType] with a well-typed
                 * [String] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun pythonGraderServerErrorType(pythonGraderServerErrorType: JsonField<String>) =
                    apply {
                        this.pythonGraderServerErrorType = pythonGraderServerErrorType
                    }

                fun sampleParseError(sampleParseError: Boolean) =
                    sampleParseError(JsonField.of(sampleParseError))

                /**
                 * Sets [Builder.sampleParseError] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.sampleParseError] with a well-typed [Boolean]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun sampleParseError(sampleParseError: JsonField<Boolean>) = apply {
                    this.sampleParseError = sampleParseError
                }

                fun truncatedObservationError(truncatedObservationError: Boolean) =
                    truncatedObservationError(JsonField.of(truncatedObservationError))

                /**
                 * Sets [Builder.truncatedObservationError] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.truncatedObservationError] with a well-typed
                 * [Boolean] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun truncatedObservationError(truncatedObservationError: JsonField<Boolean>) =
                    apply {
                        this.truncatedObservationError = truncatedObservationError
                    }

                fun unresponsiveRewardError(unresponsiveRewardError: Boolean) =
                    unresponsiveRewardError(JsonField.of(unresponsiveRewardError))

                /**
                 * Sets [Builder.unresponsiveRewardError] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.unresponsiveRewardError] with a well-typed
                 * [Boolean] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun unresponsiveRewardError(unresponsiveRewardError: JsonField<Boolean>) = apply {
                    this.unresponsiveRewardError = unresponsiveRewardError
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

                /**
                 * Returns an immutable instance of [Errors].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .formulaParseError()
                 * .invalidVariableError()
                 * .modelGraderParseError()
                 * .modelGraderRefusalError()
                 * .modelGraderServerError()
                 * .modelGraderServerErrorDetails()
                 * .otherError()
                 * .pythonGraderRuntimeError()
                 * .pythonGraderRuntimeErrorDetails()
                 * .pythonGraderServerError()
                 * .pythonGraderServerErrorType()
                 * .sampleParseError()
                 * .truncatedObservationError()
                 * .unresponsiveRewardError()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Errors =
                    Errors(
                        checkRequired("formulaParseError", formulaParseError),
                        checkRequired("invalidVariableError", invalidVariableError),
                        checkRequired("modelGraderParseError", modelGraderParseError),
                        checkRequired("modelGraderRefusalError", modelGraderRefusalError),
                        checkRequired("modelGraderServerError", modelGraderServerError),
                        checkRequired(
                            "modelGraderServerErrorDetails",
                            modelGraderServerErrorDetails,
                        ),
                        checkRequired("otherError", otherError),
                        checkRequired("pythonGraderRuntimeError", pythonGraderRuntimeError),
                        checkRequired(
                            "pythonGraderRuntimeErrorDetails",
                            pythonGraderRuntimeErrorDetails,
                        ),
                        checkRequired("pythonGraderServerError", pythonGraderServerError),
                        checkRequired("pythonGraderServerErrorType", pythonGraderServerErrorType),
                        checkRequired("sampleParseError", sampleParseError),
                        checkRequired("truncatedObservationError", truncatedObservationError),
                        checkRequired("unresponsiveRewardError", unresponsiveRewardError),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Errors = apply {
                if (validated) {
                    return@apply
                }

                formulaParseError()
                invalidVariableError()
                modelGraderParseError()
                modelGraderRefusalError()
                modelGraderServerError()
                modelGraderServerErrorDetails()
                otherError()
                pythonGraderRuntimeError()
                pythonGraderRuntimeErrorDetails()
                pythonGraderServerError()
                pythonGraderServerErrorType()
                sampleParseError()
                truncatedObservationError()
                unresponsiveRewardError()
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
                (if (formulaParseError.asKnown().isPresent) 1 else 0) +
                    (if (invalidVariableError.asKnown().isPresent) 1 else 0) +
                    (if (modelGraderParseError.asKnown().isPresent) 1 else 0) +
                    (if (modelGraderRefusalError.asKnown().isPresent) 1 else 0) +
                    (if (modelGraderServerError.asKnown().isPresent) 1 else 0) +
                    (if (modelGraderServerErrorDetails.asKnown().isPresent) 1 else 0) +
                    (if (otherError.asKnown().isPresent) 1 else 0) +
                    (if (pythonGraderRuntimeError.asKnown().isPresent) 1 else 0) +
                    (if (pythonGraderRuntimeErrorDetails.asKnown().isPresent) 1 else 0) +
                    (if (pythonGraderServerError.asKnown().isPresent) 1 else 0) +
                    (if (pythonGraderServerErrorType.asKnown().isPresent) 1 else 0) +
                    (if (sampleParseError.asKnown().isPresent) 1 else 0) +
                    (if (truncatedObservationError.asKnown().isPresent) 1 else 0) +
                    (if (unresponsiveRewardError.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Errors && formulaParseError == other.formulaParseError && invalidVariableError == other.invalidVariableError && modelGraderParseError == other.modelGraderParseError && modelGraderRefusalError == other.modelGraderRefusalError && modelGraderServerError == other.modelGraderServerError && modelGraderServerErrorDetails == other.modelGraderServerErrorDetails && otherError == other.otherError && pythonGraderRuntimeError == other.pythonGraderRuntimeError && pythonGraderRuntimeErrorDetails == other.pythonGraderRuntimeErrorDetails && pythonGraderServerError == other.pythonGraderServerError && pythonGraderServerErrorType == other.pythonGraderServerErrorType && sampleParseError == other.sampleParseError && truncatedObservationError == other.truncatedObservationError && unresponsiveRewardError == other.unresponsiveRewardError && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(formulaParseError, invalidVariableError, modelGraderParseError, modelGraderRefusalError, modelGraderServerError, modelGraderServerErrorDetails, otherError, pythonGraderRuntimeError, pythonGraderRuntimeErrorDetails, pythonGraderServerError, pythonGraderServerErrorType, sampleParseError, truncatedObservationError, unresponsiveRewardError, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Errors{formulaParseError=$formulaParseError, invalidVariableError=$invalidVariableError, modelGraderParseError=$modelGraderParseError, modelGraderRefusalError=$modelGraderRefusalError, modelGraderServerError=$modelGraderServerError, modelGraderServerErrorDetails=$modelGraderServerErrorDetails, otherError=$otherError, pythonGraderRuntimeError=$pythonGraderRuntimeError, pythonGraderRuntimeErrorDetails=$pythonGraderRuntimeErrorDetails, pythonGraderServerError=$pythonGraderServerError, pythonGraderServerErrorType=$pythonGraderServerErrorType, sampleParseError=$sampleParseError, truncatedObservationError=$truncatedObservationError, unresponsiveRewardError=$unresponsiveRewardError, additionalProperties=$additionalProperties}"
        }

        class Scores
        @JsonCreator
        private constructor(
            @com.fasterxml.jackson.annotation.JsonValue
            private val additionalProperties: Map<String, JsonValue>
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [Scores]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Scores]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(scores: Scores) = apply {
                    additionalProperties = scores.additionalProperties.toMutableMap()
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

                /**
                 * Returns an immutable instance of [Scores].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Scores = Scores(additionalProperties.toImmutable())
            }

            private var validated: Boolean = false

            fun validate(): Scores = apply {
                if (validated) {
                    return@apply
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
                additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Scores && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() = "Scores{additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Metadata && errors == other.errors && executionTime == other.executionTime && name == other.name && sampledModelName == other.sampledModelName && scores == other.scores && tokenUsage == other.tokenUsage && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(errors, executionTime, name, sampledModelName, scores, tokenUsage, type, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Metadata{errors=$errors, executionTime=$executionTime, name=$name, sampledModelName=$sampledModelName, scores=$scores, tokenUsage=$tokenUsage, type=$type, additionalProperties=$additionalProperties}"
    }

    class ModelGraderTokenUsagePerModel
    @JsonCreator
    private constructor(
        @com.fasterxml.jackson.annotation.JsonValue
        private val additionalProperties: Map<String, JsonValue>
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of
             * [ModelGraderTokenUsagePerModel].
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ModelGraderTokenUsagePerModel]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(modelGraderTokenUsagePerModel: ModelGraderTokenUsagePerModel) =
                apply {
                    additionalProperties =
                        modelGraderTokenUsagePerModel.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [ModelGraderTokenUsagePerModel].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): ModelGraderTokenUsagePerModel =
                ModelGraderTokenUsagePerModel(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): ModelGraderTokenUsagePerModel = apply {
            if (validated) {
                return@apply
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
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ModelGraderTokenUsagePerModel && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ModelGraderTokenUsagePerModel{additionalProperties=$additionalProperties}"
    }

    class SubRewards
    @JsonCreator
    private constructor(
        @com.fasterxml.jackson.annotation.JsonValue
        private val additionalProperties: Map<String, JsonValue>
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [SubRewards]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [SubRewards]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(subRewards: SubRewards) = apply {
                additionalProperties = subRewards.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [SubRewards].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): SubRewards = SubRewards(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): SubRewards = apply {
            if (validated) {
                return@apply
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
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is SubRewards && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "SubRewards{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is GraderRunResponse && metadata == other.metadata && modelGraderTokenUsagePerModel == other.modelGraderTokenUsagePerModel && reward == other.reward && subRewards == other.subRewards && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(metadata, modelGraderTokenUsagePerModel, reward, subRewards, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "GraderRunResponse{metadata=$metadata, modelGraderTokenUsagePerModel=$modelGraderTokenUsagePerModel, reward=$reward, subRewards=$subRewards, additionalProperties=$additionalProperties}"
}
