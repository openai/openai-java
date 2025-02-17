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

    /** A builder for [RunStepDelta]. */
    class Builder internal constructor() {

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
        fun stepDetails(messageCreation: RunStepDeltaMessageDelta) =
            stepDetails(StepDetails.ofMessageCreation(messageCreation))

        /** Details of the tool call. */
        fun stepDetails(toolCalls: ToolCallDeltaObject) =
            stepDetails(StepDetails.ofToolCalls(toolCalls))

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
        private val messageCreation: RunStepDeltaMessageDelta? = null,
        private val toolCalls: ToolCallDeltaObject? = null,
        private val _json: JsonValue? = null,
    ) {

        /** Details of the message creation by the run step. */
        fun messageCreation(): Optional<RunStepDeltaMessageDelta> =
            Optional.ofNullable(messageCreation)

        /** Details of the tool call. */
        fun toolCalls(): Optional<ToolCallDeltaObject> = Optional.ofNullable(toolCalls)

        fun isMessageCreation(): Boolean = messageCreation != null

        fun isToolCalls(): Boolean = toolCalls != null

        /** Details of the message creation by the run step. */
        fun asMessageCreation(): RunStepDeltaMessageDelta =
            messageCreation.getOrThrow("messageCreation")

        /** Details of the tool call. */
        fun asToolCalls(): ToolCallDeltaObject = toolCalls.getOrThrow("toolCalls")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                messageCreation != null -> visitor.visitMessageCreation(messageCreation)
                toolCalls != null -> visitor.visitToolCalls(toolCalls)
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
                    override fun visitMessageCreation(messageCreation: RunStepDeltaMessageDelta) {
                        messageCreation.validate()
                    }

                    override fun visitToolCalls(toolCalls: ToolCallDeltaObject) {
                        toolCalls.validate()
                    }
                }
            )
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is StepDetails && messageCreation == other.messageCreation && toolCalls == other.toolCalls /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(messageCreation, toolCalls) /* spotless:on */

        override fun toString(): String =
            when {
                messageCreation != null -> "StepDetails{messageCreation=$messageCreation}"
                toolCalls != null -> "StepDetails{toolCalls=$toolCalls}"
                _json != null -> "StepDetails{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid StepDetails")
            }

        companion object {

            /** Details of the message creation by the run step. */
            @JvmStatic
            fun ofMessageCreation(messageCreation: RunStepDeltaMessageDelta) =
                StepDetails(messageCreation = messageCreation)

            /** Details of the tool call. */
            @JvmStatic
            fun ofToolCalls(toolCalls: ToolCallDeltaObject) = StepDetails(toolCalls = toolCalls)
        }

        /**
         * An interface that defines how to map each variant of [StepDetails] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            /** Details of the message creation by the run step. */
            fun visitMessageCreation(messageCreation: RunStepDeltaMessageDelta): T

            /** Details of the tool call. */
            fun visitToolCalls(toolCalls: ToolCallDeltaObject): T

            /**
             * Maps an unknown variant of [StepDetails] to a value of type [T].
             *
             * An instance of [StepDetails] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown StepDetails: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<StepDetails>(StepDetails::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): StepDetails {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "message_creation" -> {
                        tryDeserialize(node, jacksonTypeRef<RunStepDeltaMessageDelta>()) {
                                it.validate()
                            }
                            ?.let {
                                return StepDetails(messageCreation = it, _json = json)
                            }
                    }
                    "tool_calls" -> {
                        tryDeserialize(node, jacksonTypeRef<ToolCallDeltaObject>()) {
                                it.validate()
                            }
                            ?.let {
                                return StepDetails(toolCalls = it, _json = json)
                            }
                    }
                }

                return StepDetails(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<StepDetails>(StepDetails::class) {

            override fun serialize(
                value: StepDetails,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.messageCreation != null -> generator.writeObject(value.messageCreation)
                    value.toolCalls != null -> generator.writeObject(value.toolCalls)
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
