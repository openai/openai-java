// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.jobs

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * The settings for your integration with Weights and Biases. This payload specifies the project
 * that metrics will be sent to. Optionally, you can set an explicit display name for your run, add
 * tags to your run, and set a default entity (team, username, etc) to be associated with your run.
 */
@NoAutoDetect
class FineTuningJobWandbIntegration
@JsonCreator
private constructor(
    @JsonProperty("project")
    @ExcludeMissing
    private val project: JsonField<String> = JsonMissing.of(),
    @JsonProperty("entity")
    @ExcludeMissing
    private val entity: JsonField<String> = JsonMissing.of(),
    @JsonProperty("name") @ExcludeMissing private val name: JsonField<String> = JsonMissing.of(),
    @JsonProperty("tags")
    @ExcludeMissing
    private val tags: JsonField<List<String>> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * The name of the project that the new run will be created under.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun project(): String = project.getRequired("project")

    /**
     * The entity to use for the run. This allows you to set the team or username of the WandB user
     * that you would like associated with the run. If not set, the default entity for the
     * registered WandB API key is used.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun entity(): Optional<String> = Optional.ofNullable(entity.getNullable("entity"))

    /**
     * A display name to set for the run. If not set, we will use the Job ID as the name.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

    /**
     * A list of tags to be attached to the newly created run. These tags are passed through
     * directly to WandB. Some default tags are generated by OpenAI: "openai/finetune",
     * "openai/{base-model}", "openai/{ftjob-abcdef}".
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tags(): Optional<List<String>> = Optional.ofNullable(tags.getNullable("tags"))

    /**
     * Returns the raw JSON value of [project].
     *
     * Unlike [project], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("project") @ExcludeMissing fun _project(): JsonField<String> = project

    /**
     * Returns the raw JSON value of [entity].
     *
     * Unlike [entity], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("entity") @ExcludeMissing fun _entity(): JsonField<String> = entity

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [tags].
     *
     * Unlike [tags], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tags") @ExcludeMissing fun _tags(): JsonField<List<String>> = tags

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): FineTuningJobWandbIntegration = apply {
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

        /**
         * Returns a mutable builder for constructing an instance of
         * [FineTuningJobWandbIntegration].
         *
         * The following fields are required:
         * ```java
         * .project()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FineTuningJobWandbIntegration]. */
    class Builder internal constructor() {

        private var project: JsonField<String>? = null
        private var entity: JsonField<String> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var tags: JsonField<MutableList<String>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fineTuningJobWandbIntegration: FineTuningJobWandbIntegration) = apply {
            project = fineTuningJobWandbIntegration.project
            entity = fineTuningJobWandbIntegration.entity
            name = fineTuningJobWandbIntegration.name
            tags = fineTuningJobWandbIntegration.tags.map { it.toMutableList() }
            additionalProperties = fineTuningJobWandbIntegration.additionalProperties.toMutableMap()
        }

        /** The name of the project that the new run will be created under. */
        fun project(project: String) = project(JsonField.of(project))

        /**
         * Sets [Builder.project] to an arbitrary JSON value.
         *
         * You should usually call [Builder.project] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun project(project: JsonField<String>) = apply { this.project = project }

        /**
         * The entity to use for the run. This allows you to set the team or username of the WandB
         * user that you would like associated with the run. If not set, the default entity for the
         * registered WandB API key is used.
         */
        fun entity(entity: String?) = entity(JsonField.ofNullable(entity))

        /** Alias for calling [Builder.entity] with `entity.orElse(null)`. */
        fun entity(entity: Optional<String>) = entity(entity.getOrNull())

        /**
         * Sets [Builder.entity] to an arbitrary JSON value.
         *
         * You should usually call [Builder.entity] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun entity(entity: JsonField<String>) = apply { this.entity = entity }

        /** A display name to set for the run. If not set, we will use the Job ID as the name. */
        fun name(name: String?) = name(JsonField.ofNullable(name))

        /** Alias for calling [Builder.name] with `name.orElse(null)`. */
        fun name(name: Optional<String>) = name(name.getOrNull())

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /**
         * A list of tags to be attached to the newly created run. These tags are passed through
         * directly to WandB. Some default tags are generated by OpenAI: "openai/finetune",
         * "openai/{base-model}", "openai/{ftjob-abcdef}".
         */
        fun tags(tags: List<String>) = tags(JsonField.of(tags))

        /**
         * Sets [Builder.tags] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tags] with a well-typed `List<String>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun tags(tags: JsonField<List<String>>) = apply {
            this.tags = tags.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [tags].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTag(tag: String) = apply {
            tags = (tags ?: JsonField.of(mutableListOf())).also { checkKnown("tags", it).add(tag) }
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
         * Returns an immutable instance of [FineTuningJobWandbIntegration].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .project()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FineTuningJobWandbIntegration =
            FineTuningJobWandbIntegration(
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

        return /* spotless:off */ other is FineTuningJobWandbIntegration && project == other.project && entity == other.entity && name == other.name && tags == other.tags && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(project, entity, name, tags, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FineTuningJobWandbIntegration{project=$project, entity=$entity, name=$name, tags=$tags, additionalProperties=$additionalProperties}"
}
