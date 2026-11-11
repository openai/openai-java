// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.finetuning.alpha.graders

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonNull
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.core.collectAllProperties
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class GraderRunResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
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
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun metadata(): java.util.Optional<Metadata> = metadata.getOptional("metadata")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun metadataOrThrow(): Metadata = metadata.getRequired("metadata")

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun modelGraderTokenUsagePerModel(): java.util.Optional<ModelGraderTokenUsagePerModel> =
        modelGraderTokenUsagePerModel.getOptional("model_grader_token_usage_per_model")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun modelGraderTokenUsagePerModelOrThrow(): ModelGraderTokenUsagePerModel =
        modelGraderTokenUsagePerModel.getRequired("model_grader_token_usage_per_model")

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun reward(): java.util.Optional<Double> = reward.getOptional("reward")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun rewardOrThrow(): Double = reward.getRequired("reward")

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun subRewards(): java.util.Optional<SubRewards> = subRewards.getOptional("sub_rewards")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun subRewardsOrThrow(): SubRewards = subRewards.getRequired("sub_rewards")

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

    /**
     * Returns an immutable snapshot of all present JSON properties, including declared and
     * additional properties.
     *
     * Keys use their JSON names. Declared properties take precedence over additional properties
     * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
     * values are preserved.
     */
    fun _allProperties(): Map<String, JsonValue> =
        collectAllProperties(
            additionalProperties,
            "metadata" to this.metadata,
            "model_grader_token_usage_per_model" to this.modelGraderTokenUsagePerModel,
            "reward" to this.reward,
            "sub_rewards" to this.subRewards,
        )

    @JvmSynthetic
    internal fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    @JsonAnyGetter
    @ExcludeMissing
    private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

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

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): GraderRunResponse = apply {
        if (validated) {
            return@apply
        }

        metadataOrThrow().validate()
        modelGraderTokenUsagePerModelOrThrow().validate()
        rewardOrThrow()
        subRewardsOrThrow().validate()
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
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
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
         * The schema requires this property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun errors(): java.util.Optional<Errors> = errors.getOptional("errors")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun errorsOrThrow(): Errors = errors.getRequired("errors")

        /**
         * The schema requires this property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun executionTime(): java.util.Optional<Double> =
            executionTime.getOptional("execution_time")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun executionTimeOrThrow(): Double = executionTime.getRequired("execution_time")

        /**
         * The schema requires this property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun name(): java.util.Optional<String> = name.getOptional("name")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun nameOrThrow(): String = name.getRequired("name")

        /**
         * The schema requires this property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun sampledModelName(): java.util.Optional<String> =
            sampledModelName.getOptional("sampled_model_name")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun sampledModelNameOrThrow(): String = sampledModelName.getRequired("sampled_model_name")

        /**
         * The schema requires this property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun scores(): java.util.Optional<Scores> = scores.getOptional("scores")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun scoresOrThrow(): Scores = scores.getRequired("scores")

        /**
         * The schema requires this property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun tokenUsage(): java.util.Optional<Long> = tokenUsage.getOptional("token_usage")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun tokenUsageOrThrow(): Long = tokenUsage.getRequired("token_usage")

        /**
         * The schema requires this property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun type(): java.util.Optional<String> = type.getOptional("type")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun typeOrThrow(): String = type.getRequired("type")

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

        /**
         * Returns an immutable snapshot of all present JSON properties, including declared and
         * additional properties.
         *
         * Keys use their JSON names. Declared properties take precedence over additional properties
         * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
         * values are preserved.
         */
        fun _allProperties(): Map<String, JsonValue> =
            collectAllProperties(
                additionalProperties,
                "errors" to this.errors,
                "execution_time" to this.executionTime,
                "name" to this.name,
                "sampled_model_name" to this.sampledModelName,
                "scores" to this.scores,
                "token_usage" to this.tokenUsage,
                "type" to this.type,
            )

        @JvmSynthetic
        internal fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        @JsonAnyGetter
        @ExcludeMissing
        private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

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
             * .scores()
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
            private var sampledModelName: JsonField<String>? = JsonNull.of()
            private var scores: JsonField<Scores>? = null
            private var tokenUsage: JsonField<Long>? = JsonNull.of()
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
             * .scores()
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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Metadata = apply {
            if (validated) {
                return@apply
            }

            errorsOrThrow().validate()
            executionTimeOrThrow()
            nameOrThrow()
            sampledModelName()
            scoresOrThrow().validate()
            tokenUsage()
            typeOrThrow()
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
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
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
             * The schema requires this property. Returns empty if the JSON property is missing or
             * null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun formulaParseError(): java.util.Optional<Boolean> =
                formulaParseError.getOptional("formula_parse_error")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun formulaParseErrorOrThrow(): Boolean =
                formulaParseError.getRequired("formula_parse_error")

            /**
             * The schema requires this property. Returns empty if the JSON property is missing or
             * null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun invalidVariableError(): java.util.Optional<Boolean> =
                invalidVariableError.getOptional("invalid_variable_error")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun invalidVariableErrorOrThrow(): Boolean =
                invalidVariableError.getRequired("invalid_variable_error")

            /**
             * The schema requires this property. Returns empty if the JSON property is missing or
             * null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun modelGraderParseError(): java.util.Optional<Boolean> =
                modelGraderParseError.getOptional("model_grader_parse_error")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun modelGraderParseErrorOrThrow(): Boolean =
                modelGraderParseError.getRequired("model_grader_parse_error")

            /**
             * The schema requires this property. Returns empty if the JSON property is missing or
             * null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun modelGraderRefusalError(): java.util.Optional<Boolean> =
                modelGraderRefusalError.getOptional("model_grader_refusal_error")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun modelGraderRefusalErrorOrThrow(): Boolean =
                modelGraderRefusalError.getRequired("model_grader_refusal_error")

            /**
             * The schema requires this property. Returns empty if the JSON property is missing or
             * null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun modelGraderServerError(): java.util.Optional<Boolean> =
                modelGraderServerError.getOptional("model_grader_server_error")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun modelGraderServerErrorOrThrow(): Boolean =
                modelGraderServerError.getRequired("model_grader_server_error")

            /**
             * The schema requires this property. Returns empty if the JSON property is missing or
             * null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun modelGraderServerErrorDetails(): java.util.Optional<String> =
                modelGraderServerErrorDetails.getOptional("model_grader_server_error_details")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun modelGraderServerErrorDetailsOrThrow(): String =
                modelGraderServerErrorDetails.getRequired("model_grader_server_error_details")

            /**
             * The schema requires this property. Returns empty if the JSON property is missing or
             * null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun otherError(): java.util.Optional<Boolean> = otherError.getOptional("other_error")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun otherErrorOrThrow(): Boolean = otherError.getRequired("other_error")

            /**
             * The schema requires this property. Returns empty if the JSON property is missing or
             * null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun pythonGraderRuntimeError(): java.util.Optional<Boolean> =
                pythonGraderRuntimeError.getOptional("python_grader_runtime_error")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun pythonGraderRuntimeErrorOrThrow(): Boolean =
                pythonGraderRuntimeError.getRequired("python_grader_runtime_error")

            /**
             * The schema requires this property. Returns empty if the JSON property is missing or
             * null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun pythonGraderRuntimeErrorDetails(): java.util.Optional<String> =
                pythonGraderRuntimeErrorDetails.getOptional("python_grader_runtime_error_details")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun pythonGraderRuntimeErrorDetailsOrThrow(): String =
                pythonGraderRuntimeErrorDetails.getRequired("python_grader_runtime_error_details")

            /**
             * The schema requires this property. Returns empty if the JSON property is missing or
             * null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun pythonGraderServerError(): java.util.Optional<Boolean> =
                pythonGraderServerError.getOptional("python_grader_server_error")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun pythonGraderServerErrorOrThrow(): Boolean =
                pythonGraderServerError.getRequired("python_grader_server_error")

            /**
             * The schema requires this property. Returns empty if the JSON property is missing or
             * null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun pythonGraderServerErrorType(): java.util.Optional<String> =
                pythonGraderServerErrorType.getOptional("python_grader_server_error_type")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun pythonGraderServerErrorTypeOrThrow(): String =
                pythonGraderServerErrorType.getRequired("python_grader_server_error_type")

            /**
             * The schema requires this property. Returns empty if the JSON property is missing or
             * null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun sampleParseError(): java.util.Optional<Boolean> =
                sampleParseError.getOptional("sample_parse_error")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun sampleParseErrorOrThrow(): Boolean =
                sampleParseError.getRequired("sample_parse_error")

            /**
             * The schema requires this property. Returns empty if the JSON property is missing or
             * null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun truncatedObservationError(): java.util.Optional<Boolean> =
                truncatedObservationError.getOptional("truncated_observation_error")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun truncatedObservationErrorOrThrow(): Boolean =
                truncatedObservationError.getRequired("truncated_observation_error")

            /**
             * The schema requires this property. Returns empty if the JSON property is missing or
             * null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun unresponsiveRewardError(): java.util.Optional<Boolean> =
                unresponsiveRewardError.getOptional("unresponsive_reward_error")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun unresponsiveRewardErrorOrThrow(): Boolean =
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

            /**
             * Returns an immutable snapshot of all present JSON properties, including declared and
             * additional properties.
             *
             * Keys use their JSON names. Declared properties take precedence over additional
             * properties with the same name. Missing properties are omitted, while explicit nulls
             * and unrecognized values are preserved.
             */
            fun _allProperties(): Map<String, JsonValue> =
                collectAllProperties(
                    additionalProperties,
                    "formula_parse_error" to this.formulaParseError,
                    "invalid_variable_error" to this.invalidVariableError,
                    "model_grader_parse_error" to this.modelGraderParseError,
                    "model_grader_refusal_error" to this.modelGraderRefusalError,
                    "model_grader_server_error" to this.modelGraderServerError,
                    "model_grader_server_error_details" to this.modelGraderServerErrorDetails,
                    "other_error" to this.otherError,
                    "python_grader_runtime_error" to this.pythonGraderRuntimeError,
                    "python_grader_runtime_error_details" to this.pythonGraderRuntimeErrorDetails,
                    "python_grader_server_error" to this.pythonGraderServerError,
                    "python_grader_server_error_type" to this.pythonGraderServerErrorType,
                    "sample_parse_error" to this.sampleParseError,
                    "truncated_observation_error" to this.truncatedObservationError,
                    "unresponsive_reward_error" to this.unresponsiveRewardError,
                )

            @JvmSynthetic
            internal fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            @JsonAnyGetter
            @ExcludeMissing
            private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

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
                 * .otherError()
                 * .pythonGraderRuntimeError()
                 * .pythonGraderServerError()
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
                private var modelGraderServerErrorDetails: JsonField<String>? = JsonNull.of()
                private var otherError: JsonField<Boolean>? = null
                private var pythonGraderRuntimeError: JsonField<Boolean>? = null
                private var pythonGraderRuntimeErrorDetails: JsonField<String>? = JsonNull.of()
                private var pythonGraderServerError: JsonField<Boolean>? = null
                private var pythonGraderServerErrorType: JsonField<String>? = JsonNull.of()
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
                 * .otherError()
                 * .pythonGraderRuntimeError()
                 * .pythonGraderServerError()
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

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Errors = apply {
                if (validated) {
                    return@apply
                }

                formulaParseErrorOrThrow()
                invalidVariableErrorOrThrow()
                modelGraderParseErrorOrThrow()
                modelGraderRefusalErrorOrThrow()
                modelGraderServerErrorOrThrow()
                modelGraderServerErrorDetails()
                otherErrorOrThrow()
                pythonGraderRuntimeErrorOrThrow()
                pythonGraderRuntimeErrorDetails()
                pythonGraderServerErrorOrThrow()
                pythonGraderServerErrorType()
                sampleParseErrorOrThrow()
                truncatedObservationErrorOrThrow()
                unresponsiveRewardErrorOrThrow()
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

                return other is Errors &&
                    formulaParseError == other.formulaParseError &&
                    invalidVariableError == other.invalidVariableError &&
                    modelGraderParseError == other.modelGraderParseError &&
                    modelGraderRefusalError == other.modelGraderRefusalError &&
                    modelGraderServerError == other.modelGraderServerError &&
                    modelGraderServerErrorDetails == other.modelGraderServerErrorDetails &&
                    otherError == other.otherError &&
                    pythonGraderRuntimeError == other.pythonGraderRuntimeError &&
                    pythonGraderRuntimeErrorDetails == other.pythonGraderRuntimeErrorDetails &&
                    pythonGraderServerError == other.pythonGraderServerError &&
                    pythonGraderServerErrorType == other.pythonGraderServerErrorType &&
                    sampleParseError == other.sampleParseError &&
                    truncatedObservationError == other.truncatedObservationError &&
                    unresponsiveRewardError == other.unresponsiveRewardError &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
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
                    additionalProperties,
                )
            }

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

            /**
             * Returns an immutable snapshot of all present JSON properties, including declared and
             * additional properties.
             *
             * Keys use their JSON names. Declared properties take precedence over additional
             * properties with the same name. Missing properties are omitted, while explicit nulls
             * and unrecognized values are preserved.
             */
            fun _allProperties(): Map<String, JsonValue> =
                collectAllProperties(additionalProperties)

            @JvmSynthetic
            internal fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            @JsonAnyGetter
            @ExcludeMissing
            private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

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

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
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

                return other is Scores && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Scores{additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Metadata &&
                errors == other.errors &&
                executionTime == other.executionTime &&
                name == other.name &&
                sampledModelName == other.sampledModelName &&
                scores == other.scores &&
                tokenUsage == other.tokenUsage &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                errors,
                executionTime,
                name,
                sampledModelName,
                scores,
                tokenUsage,
                type,
                additionalProperties,
            )
        }

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

        /**
         * Returns an immutable snapshot of all present JSON properties, including declared and
         * additional properties.
         *
         * Keys use their JSON names. Declared properties take precedence over additional properties
         * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
         * values are preserved.
         */
        fun _allProperties(): Map<String, JsonValue> = collectAllProperties(additionalProperties)

        @JvmSynthetic
        internal fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        @JsonAnyGetter
        @ExcludeMissing
        private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
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

            return other is ModelGraderTokenUsagePerModel &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

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

        /**
         * Returns an immutable snapshot of all present JSON properties, including declared and
         * additional properties.
         *
         * Keys use their JSON names. Declared properties take precedence over additional properties
         * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
         * values are preserved.
         */
        fun _allProperties(): Map<String, JsonValue> = collectAllProperties(additionalProperties)

        @JvmSynthetic
        internal fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        @JsonAnyGetter
        @ExcludeMissing
        private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
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

            return other is SubRewards && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "SubRewards{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is GraderRunResponse &&
            metadata == other.metadata &&
            modelGraderTokenUsagePerModel == other.modelGraderTokenUsagePerModel &&
            reward == other.reward &&
            subRewards == other.subRewards &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            metadata,
            modelGraderTokenUsagePerModel,
            reward,
            subRewards,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "GraderRunResponse{metadata=$metadata, modelGraderTokenUsagePerModel=$modelGraderTokenUsagePerModel, reward=$reward, subRewards=$subRewards, additionalProperties=$additionalProperties}"
}
