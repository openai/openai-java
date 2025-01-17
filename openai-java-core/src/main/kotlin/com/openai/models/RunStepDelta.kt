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
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.getOrThrow
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** The delta containing the fields that have changed on the run step. */
@NoAutoDetect
class RunStepDelta
@JsonCreator
private constructor(
    @JsonProperty("step_details")
    @ExcludeMissing
    private val stepDetails: JsonField<StepDetails> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The details of the run step. */
    fun stepDetails(): Optional<StepDetails> =
        Optional.ofNullable(stepDetails.getNullable("step_details"))

    /** The details of the run step. */
    @JsonProperty("step_details")
    @ExcludeMissing
    fun _stepDetails(): JsonField<StepDetails> = stepDetails

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): RunStepDelta = apply {
        if (validated) {
            return@apply
        }

        stepDetails().ifPresent { it.validate() }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var stepDetails: JsonField<StepDetails> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(runStepDelta: RunStepDelta) = apply {
            stepDetails = runStepDelta.stepDetails
            additionalProperties = runStepDelta.additionalProperties.toMutableMap()
        }

        /** The details of the run step. */
        fun stepDetails(stepDetails: StepDetails) = stepDetails(JsonField.of(stepDetails))

        /** The details of the run step. */
        fun stepDetails(stepDetails: JsonField<StepDetails>) = apply {
            this.stepDetails = stepDetails
        }

        /** Details of the message creation by the run step. */
        fun stepDetails(runStepDeltaMessageDelta: RunStepDeltaMessageDelta) =
            stepDetails(StepDetails.ofRunStepDeltaMessageDelta(runStepDeltaMessageDelta))

        /** Details of the tool call. */
        fun stepDetails(toolCallDeltaObject: ToolCallDeltaObject) =
            stepDetails(StepDetails.ofToolCallDeltaObject(toolCallDeltaObject))

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

        fun build(): RunStepDelta = RunStepDelta(stepDetails, additionalProperties.toImmutable())
    }

    /** The details of the run step. */
    @JsonDeserialize(using = StepDetails.Deserializer::class)
    @JsonSerialize(using = StepDetails.Serializer::class)
    class StepDetails
    private constructor(
        private val runStepDeltaMessageDelta: RunStepDeltaMessageDelta? = null,
        private val toolCallDeltaObject: ToolCallDeltaObject? = null,
        private val _json: JsonValue? = null,
    ) {

        /** Details of the message creation by the run step. */
        fun runStepDeltaMessageDelta(): Optional<RunStepDeltaMessageDelta> =
            Optional.ofNullable(runStepDeltaMessageDelta)

        /** Details of the tool call. */
        fun toolCallDeltaObject(): Optional<ToolCallDeltaObject> =
            Optional.ofNullable(toolCallDeltaObject)

        fun isRunStepDeltaMessageDelta(): Boolean = runStepDeltaMessageDelta != null

        fun isToolCallDeltaObject(): Boolean = toolCallDeltaObject != null

        /** Details of the message creation by the run step. */
        fun asRunStepDeltaMessageDelta(): RunStepDeltaMessageDelta =
            runStepDeltaMessageDelta.getOrThrow("runStepDeltaMessageDelta")

        /** Details of the tool call. */
        fun asToolCallDeltaObject(): ToolCallDeltaObject =
            toolCallDeltaObject.getOrThrow("toolCallDeltaObject")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                runStepDeltaMessageDelta != null ->
                    visitor.visitRunStepDeltaMessageDelta(runStepDeltaMessageDelta)
                toolCallDeltaObject != null -> visitor.visitToolCallDeltaObject(toolCallDeltaObject)
                else -> visitor.unknown(_json)
            }
        }

        private var validated: Boolean = false

        fun validate(): StepDetails = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitRunStepDeltaMessageDelta(
                        runStepDeltaMessageDelta: RunStepDeltaMessageDelta
                    ) {
                        runStepDeltaMessageDelta.validate()
                    }

                    override fun visitToolCallDeltaObject(
                        toolCallDeltaObject: ToolCallDeltaObject
                    ) {
                        toolCallDeltaObject.validate()
                    }
                }
            )
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is StepDetails && runStepDeltaMessageDelta == other.runStepDeltaMessageDelta && toolCallDeltaObject == other.toolCallDeltaObject /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(runStepDeltaMessageDelta, toolCallDeltaObject) /* spotless:on */

        override fun toString(): String =
            when {
                runStepDeltaMessageDelta != null ->
                    "StepDetails{runStepDeltaMessageDelta=$runStepDeltaMessageDelta}"
                toolCallDeltaObject != null ->
                    "StepDetails{toolCallDeltaObject=$toolCallDeltaObject}"
                _json != null -> "StepDetails{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid StepDetails")
            }

        companion object {

            /** Details of the message creation by the run step. */
            @JvmStatic
            fun ofRunStepDeltaMessageDelta(runStepDeltaMessageDelta: RunStepDeltaMessageDelta) =
                StepDetails(runStepDeltaMessageDelta = runStepDeltaMessageDelta)

            /** Details of the tool call. */
            @JvmStatic
            fun ofToolCallDeltaObject(toolCallDeltaObject: ToolCallDeltaObject) =
                StepDetails(toolCallDeltaObject = toolCallDeltaObject)
        }

        interface Visitor<out T> {

            /** Details of the message creation by the run step. */
            fun visitRunStepDeltaMessageDelta(runStepDeltaMessageDelta: RunStepDeltaMessageDelta): T

            /** Details of the tool call. */
            fun visitToolCallDeltaObject(toolCallDeltaObject: ToolCallDeltaObject): T

            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown StepDetails: $json")
            }
        }

        class Deserializer : BaseDeserializer<StepDetails>(StepDetails::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): StepDetails {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "message_creation" -> {
                        tryDeserialize(node, jacksonTypeRef<RunStepDeltaMessageDelta>()) {
                                it.validate()
                            }
                            ?.let {
                                return StepDetails(runStepDeltaMessageDelta = it, _json = json)
                            }
                    }
                    "tool_calls" -> {
                        tryDeserialize(node, jacksonTypeRef<ToolCallDeltaObject>()) {
                                it.validate()
                            }
                            ?.let {
                                return StepDetails(toolCallDeltaObject = it, _json = json)
                            }
                    }
                }

                return StepDetails(_json = json)
            }
        }

        class Serializer : BaseSerializer<StepDetails>(StepDetails::class) {

            override fun serialize(
                value: StepDetails,
                generator: JsonGenerator,
                provider: SerializerProvider
            ) {
                when {
                    value.runStepDeltaMessageDelta != null ->
                        generator.writeObject(value.runStepDeltaMessageDelta)
                    value.toolCallDeltaObject != null ->
                        generator.writeObject(value.toolCallDeltaObject)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid StepDetails")
                }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is RunStepDelta && stepDetails == other.stepDetails && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(stepDetails, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RunStepDelta{stepDetails=$stepDetails, additionalProperties=$additionalProperties}"
}
