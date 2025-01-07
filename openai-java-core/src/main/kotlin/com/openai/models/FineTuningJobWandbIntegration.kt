// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import java.util.Objects
import java.util.Optional

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

    /** The name of the project that the new run will be created under. */
    fun project(): String = project.getRequired("project")

    /**
     * The entity to use for the run. This allows you to set the team or username of the WandB user
     * that you would like associated with the run. If not set, the default entity for the
     * registered WandB API key is used.
     */
    fun entity(): Optional<String> = Optional.ofNullable(entity.getNullable("entity"))

    /** A display name to set for the run. If not set, we will use the Job ID as the name. */
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
     * The entity to use for the run. This allows you to set the team or username of the WandB user
     * that you would like associated with the run. If not set, the default entity for the
     * registered WandB API key is used.
     */
    @JsonProperty("entity") @ExcludeMissing fun _entity(): JsonField<String> = entity

    /** A display name to set for the run. If not set, we will use the Job ID as the name. */
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

    fun validate(): FineTuningJobWandbIntegration = apply {
        if (!validated) {
            project()
            entity()
            name()
            tags()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

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

        /** The name of the project that the new run will be created under. */
        fun project(project: JsonField<String>) = apply { this.project = project }

        /**
         * The entity to use for the run. This allows you to set the team or username of the WandB
         * user that you would like associated with the run. If not set, the default entity for the
         * registered WandB API key is used.
         */
        fun entity(entity: String?) = entity(JsonField.ofNullable(entity))

        /**
         * The entity to use for the run. This allows you to set the team or username of the WandB
         * user that you would like associated with the run. If not set, the default entity for the
         * registered WandB API key is used.
         */
        fun entity(entity: Optional<String>) = entity(entity.orElse(null))

        /**
         * The entity to use for the run. This allows you to set the team or username of the WandB
         * user that you would like associated with the run. If not set, the default entity for the
         * registered WandB API key is used.
         */
        fun entity(entity: JsonField<String>) = apply { this.entity = entity }

        /** A display name to set for the run. If not set, we will use the Job ID as the name. */
        fun name(name: String?) = name(JsonField.ofNullable(name))

        /** A display name to set for the run. If not set, we will use the Job ID as the name. */
        fun name(name: Optional<String>) = name(name.orElse(null))

        /** A display name to set for the run. If not set, we will use the Job ID as the name. */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /**
         * A list of tags to be attached to the newly created run. These tags are passed through
         * directly to WandB. Some default tags are generated by OpenAI: "openai/finetune",
         * "openai/{base-model}", "openai/{ftjob-abcdef}".
         */
        fun tags(tags: List<String>) = tags(JsonField.of(tags))

        /**
         * A list of tags to be attached to the newly created run. These tags are passed through
         * directly to WandB. Some default tags are generated by OpenAI: "openai/finetune",
         * "openai/{base-model}", "openai/{ftjob-abcdef}".
         */
        fun tags(tags: JsonField<List<String>>) = apply {
            this.tags = tags.map { it.toMutableList() }
        }

        /**
         * A list of tags to be attached to the newly created run. These tags are passed through
         * directly to WandB. Some default tags are generated by OpenAI: "openai/finetune",
         * "openai/{base-model}", "openai/{ftjob-abcdef}".
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

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        fun build(): FineTuningJobWandbIntegration =
            FineTuningJobWandbIntegration(
                checkNotNull(project) { "`project` is required but was not set" },
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
