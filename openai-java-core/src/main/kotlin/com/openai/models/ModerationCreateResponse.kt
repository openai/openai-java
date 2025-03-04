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
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import java.util.Objects

/** Represents if a given text input is potentially harmful. */
@NoAutoDetect
class ModerationCreateResponse
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("model") @ExcludeMissing private val model: JsonField<String> = JsonMissing.of(),
    @JsonProperty("results")
    @ExcludeMissing
    private val results: JsonField<List<Moderation>> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The unique identifier for the moderation request. */
    fun id(): String = id.getRequired("id")

    /** The model used to generate the moderation results. */
    fun model(): String = model.getRequired("model")

    /** A list of moderation objects. */
    fun results(): List<Moderation> = results.getRequired("results")

    /** The unique identifier for the moderation request. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** The model used to generate the moderation results. */
    @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

    /** A list of moderation objects. */
    @JsonProperty("results") @ExcludeMissing fun _results(): JsonField<List<Moderation>> = results

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ModerationCreateResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        model()
        results().forEach { it.validate() }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ModerationCreateResponse].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .model()
         * .results()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ModerationCreateResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var model: JsonField<String>? = null
        private var results: JsonField<MutableList<Moderation>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(moderationCreateResponse: ModerationCreateResponse) = apply {
            id = moderationCreateResponse.id
            model = moderationCreateResponse.model
            results = moderationCreateResponse.results.map { it.toMutableList() }
            additionalProperties = moderationCreateResponse.additionalProperties.toMutableMap()
        }

        /** The unique identifier for the moderation request. */
        fun id(id: String) = id(JsonField.of(id))

        /** The unique identifier for the moderation request. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The model used to generate the moderation results. */
        fun model(model: String) = model(JsonField.of(model))

        /** The model used to generate the moderation results. */
        fun model(model: JsonField<String>) = apply { this.model = model }

        /** A list of moderation objects. */
        fun results(results: List<Moderation>) = results(JsonField.of(results))

        /** A list of moderation objects. */
        fun results(results: JsonField<List<Moderation>>) = apply {
            this.results = results.map { it.toMutableList() }
        }

        /** A list of moderation objects. */
        fun addResult(result: Moderation) = apply {
            results =
                (results ?: JsonField.of(mutableListOf())).also {
                    checkKnown("results", it).add(result)
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

        fun build(): ModerationCreateResponse =
            ModerationCreateResponse(
                checkRequired("id", id),
                checkRequired("model", model),
                checkRequired("results", results).map { it.toImmutable() },
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ModerationCreateResponse && id == other.id && model == other.model && results == other.results && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, model, results, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ModerationCreateResponse{id=$id, model=$model, results=$results, additionalProperties=$additionalProperties}"
}
