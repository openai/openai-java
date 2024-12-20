// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.toImmutable
import java.util.Objects

/** Represents if a given text input is potentially harmful. */
@JsonDeserialize(builder = ModerationCreateResponse.Builder::class)
@NoAutoDetect
class ModerationCreateResponse
private constructor(
    private val id: JsonField<String>,
    private val model: JsonField<String>,
    private val results: JsonField<List<Moderation>>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    /** The unique identifier for the moderation request. */
    fun id(): String = id.getRequired("id")

    /** The model used to generate the moderation results. */
    fun model(): String = model.getRequired("model")

    /** A list of moderation objects. */
    fun results(): List<Moderation> = results.getRequired("results")

    /** The unique identifier for the moderation request. */
    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The model used to generate the moderation results. */
    @JsonProperty("model") @ExcludeMissing fun _model() = model

    /** A list of moderation objects. */
    @JsonProperty("results") @ExcludeMissing fun _results() = results

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ModerationCreateResponse = apply {
        if (!validated) {
            id()
            model()
            results().forEach { it.validate() }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var model: JsonField<String> = JsonMissing.of()
        private var results: JsonField<List<Moderation>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(moderationCreateResponse: ModerationCreateResponse) = apply {
            id = moderationCreateResponse.id
            model = moderationCreateResponse.model
            results = moderationCreateResponse.results
            additionalProperties = moderationCreateResponse.additionalProperties.toMutableMap()
        }

        /** The unique identifier for the moderation request. */
        fun id(id: String) = id(JsonField.of(id))

        /** The unique identifier for the moderation request. */
        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The model used to generate the moderation results. */
        fun model(model: String) = model(JsonField.of(model))

        /** The model used to generate the moderation results. */
        @JsonProperty("model")
        @ExcludeMissing
        fun model(model: JsonField<String>) = apply { this.model = model }

        /** A list of moderation objects. */
        fun results(results: List<Moderation>) = results(JsonField.of(results))

        /** A list of moderation objects. */
        @JsonProperty("results")
        @ExcludeMissing
        fun results(results: JsonField<List<Moderation>>) = apply { this.results = results }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        @JsonAnySetter
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
                id,
                model,
                results.map { it.toImmutable() },
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
