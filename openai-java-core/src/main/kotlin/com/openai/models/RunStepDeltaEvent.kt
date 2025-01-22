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
import com.openai.core.checkRequired
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects

/** Represents a run step delta i.e. any changed fields on a run step during streaming. */
@NoAutoDetect
class RunStepDeltaEvent
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("delta")
    @ExcludeMissing
    private val delta: JsonField<RunStepDelta> = JsonMissing.of(),
    @JsonProperty("object") @ExcludeMissing private val object_: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The identifier of the run step, which can be referenced in API endpoints. */
    fun id(): String = id.getRequired("id")

    /** The delta containing the fields that have changed on the run step. */
    fun delta(): RunStepDelta = delta.getRequired("delta")

    /** The object type, which is always `thread.run.step.delta`. */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /** The identifier of the run step, which can be referenced in API endpoints. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** The delta containing the fields that have changed on the run step. */
    @JsonProperty("delta") @ExcludeMissing fun _delta(): JsonField<RunStepDelta> = delta

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): RunStepDeltaEvent = apply {
        if (validated) {
            return@apply
        }

        id()
        delta().validate()
        _object_().let {
            if (it != JsonValue.from("thread.run.step.delta")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String>? = null
        private var delta: JsonField<RunStepDelta>? = null
        private var object_: JsonValue = JsonValue.from("thread.run.step.delta")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(runStepDeltaEvent: RunStepDeltaEvent) = apply {
            id = runStepDeltaEvent.id
            delta = runStepDeltaEvent.delta
            object_ = runStepDeltaEvent.object_
            additionalProperties = runStepDeltaEvent.additionalProperties.toMutableMap()
        }

        /** The identifier of the run step, which can be referenced in API endpoints. */
        fun id(id: String) = id(JsonField.of(id))

        /** The identifier of the run step, which can be referenced in API endpoints. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The delta containing the fields that have changed on the run step. */
        fun delta(delta: RunStepDelta) = delta(JsonField.of(delta))

        /** The delta containing the fields that have changed on the run step. */
        fun delta(delta: JsonField<RunStepDelta>) = apply { this.delta = delta }

        /** The object type, which is always `thread.run.step.delta`. */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

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

        fun build(): RunStepDeltaEvent =
            RunStepDeltaEvent(
                checkRequired("id", id),
                checkRequired("delta", delta),
                object_,
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is RunStepDeltaEvent && id == other.id && delta == other.delta && object_ == other.object_ && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, delta, object_, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RunStepDeltaEvent{id=$id, delta=$delta, object_=$object_, additionalProperties=$additionalProperties}"
}
