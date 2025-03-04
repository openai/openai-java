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
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Details of the Code Interpreter tool call the run step was involved in. */
@NoAutoDetect
class CodeInterpreterToolCallDelta
@JsonCreator
private constructor(
    @JsonProperty("index") @ExcludeMissing private val index: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("code_interpreter")
    @ExcludeMissing
    private val codeInterpreter: JsonField<CodeInterpreter> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The index of the tool call in the tool calls array. */
    fun index(): Long = index.getRequired("index")

    /**
     * The type of tool call. This is always going to be `code_interpreter` for this type of tool
     * call.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /** The ID of the tool call. */
    fun id(): Optional<String> = Optional.ofNullable(id.getNullable("id"))

    /** The Code Interpreter tool call definition. */
    fun codeInterpreter(): Optional<CodeInterpreter> =
        Optional.ofNullable(codeInterpreter.getNullable("code_interpreter"))

    /** The index of the tool call in the tool calls array. */
    @JsonProperty("index") @ExcludeMissing fun _index(): JsonField<Long> = index

    /** The ID of the tool call. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** The Code Interpreter tool call definition. */
    @JsonProperty("code_interpreter")
    @ExcludeMissing
    fun _codeInterpreter(): JsonField<CodeInterpreter> = codeInterpreter

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): CodeInterpreterToolCallDelta = apply {
        if (validated) {
            return@apply
        }

        index()
        _type().let {
            if (it != JsonValue.from("code_interpreter")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        id()
        codeInterpreter().ifPresent { it.validate() }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CodeInterpreterToolCallDelta]. */
    class Builder internal constructor() {

        private var index: JsonField<Long>? = null
        private var type: JsonValue = JsonValue.from("code_interpreter")
        private var id: JsonField<String> = JsonMissing.of()
        private var codeInterpreter: JsonField<CodeInterpreter> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(codeInterpreterToolCallDelta: CodeInterpreterToolCallDelta) = apply {
            index = codeInterpreterToolCallDelta.index
            type = codeInterpreterToolCallDelta.type
            id = codeInterpreterToolCallDelta.id
            codeInterpreter = codeInterpreterToolCallDelta.codeInterpreter
            additionalProperties = codeInterpreterToolCallDelta.additionalProperties.toMutableMap()
        }

        /** The index of the tool call in the tool calls array. */
        fun index(index: Long) = index(JsonField.of(index))

        /** The index of the tool call in the tool calls array. */
        fun index(index: JsonField<Long>) = apply { this.index = index }

        /**
         * The type of tool call. This is always going to be `code_interpreter` for this type of
         * tool call.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** The ID of the tool call. */
        fun id(id: String) = id(JsonField.of(id))

        /** The ID of the tool call. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The Code Interpreter tool call definition. */
        fun codeInterpreter(codeInterpreter: CodeInterpreter) =
            codeInterpreter(JsonField.of(codeInterpreter))

        /** The Code Interpreter tool call definition. */
        fun codeInterpreter(codeInterpreter: JsonField<CodeInterpreter>) = apply {
            this.codeInterpreter = codeInterpreter
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

        fun build(): CodeInterpreterToolCallDelta =
            CodeInterpreterToolCallDelta(
                checkRequired("index", index),
                type,
                id,
                codeInterpreter,
                additionalProperties.toImmutable(),
            )
    }

    /** The Code Interpreter tool call definition. */
    @NoAutoDetect
    class CodeInterpreter
    @JsonCreator
    private constructor(
        @JsonProperty("input")
        @ExcludeMissing
        private val input: JsonField<String> = JsonMissing.of(),
        @JsonProperty("outputs")
        @ExcludeMissing
        private val outputs: JsonField<List<Output>> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The input to the Code Interpreter tool call. */
        fun input(): Optional<String> = Optional.ofNullable(input.getNullable("input"))

        /**
         * The outputs from the Code Interpreter tool call. Code Interpreter can output one or more
         * items, including text (`logs`) or images (`image`). Each of these are represented by a
         * different object type.
         */
        fun outputs(): Optional<List<Output>> = Optional.ofNullable(outputs.getNullable("outputs"))

        /** The input to the Code Interpreter tool call. */
        @JsonProperty("input") @ExcludeMissing fun _input(): JsonField<String> = input

        /**
         * The outputs from the Code Interpreter tool call. Code Interpreter can output one or more
         * items, including text (`logs`) or images (`image`). Each of these are represented by a
         * different object type.
         */
        @JsonProperty("outputs") @ExcludeMissing fun _outputs(): JsonField<List<Output>> = outputs

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): CodeInterpreter = apply {
            if (validated) {
                return@apply
            }

            input()
            outputs().ifPresent { it.forEach { it.validate() } }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [CodeInterpreter]. */
        class Builder internal constructor() {

            private var input: JsonField<String> = JsonMissing.of()
            private var outputs: JsonField<MutableList<Output>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(codeInterpreter: CodeInterpreter) = apply {
                input = codeInterpreter.input
                outputs = codeInterpreter.outputs.map { it.toMutableList() }
                additionalProperties = codeInterpreter.additionalProperties.toMutableMap()
            }

            /** The input to the Code Interpreter tool call. */
            fun input(input: String) = input(JsonField.of(input))

            /** The input to the Code Interpreter tool call. */
            fun input(input: JsonField<String>) = apply { this.input = input }

            /**
             * The outputs from the Code Interpreter tool call. Code Interpreter can output one or
             * more items, including text (`logs`) or images (`image`). Each of these are
             * represented by a different object type.
             */
            fun outputs(outputs: List<Output>) = outputs(JsonField.of(outputs))

            /**
             * The outputs from the Code Interpreter tool call. Code Interpreter can output one or
             * more items, including text (`logs`) or images (`image`). Each of these are
             * represented by a different object type.
             */
            fun outputs(outputs: JsonField<List<Output>>) = apply {
                this.outputs = outputs.map { it.toMutableList() }
            }

            /**
             * The outputs from the Code Interpreter tool call. Code Interpreter can output one or
             * more items, including text (`logs`) or images (`image`). Each of these are
             * represented by a different object type.
             */
            fun addOutput(output: Output) = apply {
                outputs =
                    (outputs ?: JsonField.of(mutableListOf())).also {
                        checkKnown("outputs", it).add(output)
                    }
            }

            /** Text output from the Code Interpreter tool call as part of a run step. */
            fun addOutput(logs: CodeInterpreterLogs) = addOutput(Output.ofLogs(logs))

            /** Text output from the Code Interpreter tool call as part of a run step. */
            fun addLogsOutput(index: Long) =
                addOutput(CodeInterpreterLogs.builder().index(index).build())

            /**
             * The outputs from the Code Interpreter tool call. Code Interpreter can output one or
             * more items, including text (`logs`) or images (`image`). Each of these are
             * represented by a different object type.
             */
            fun addOutput(image: CodeInterpreterOutputImage) = addOutput(Output.ofImage(image))

            /**
             * The outputs from the Code Interpreter tool call. Code Interpreter can output one or
             * more items, including text (`logs`) or images (`image`). Each of these are
             * represented by a different object type.
             */
            fun addImageOutput(index: Long) =
                addOutput(CodeInterpreterOutputImage.builder().index(index).build())

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

            fun build(): CodeInterpreter =
                CodeInterpreter(
                    input,
                    (outputs ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toImmutable(),
                )
        }

        /** Text output from the Code Interpreter tool call as part of a run step. */
        @JsonDeserialize(using = Output.Deserializer::class)
        @JsonSerialize(using = Output.Serializer::class)
        class Output
        private constructor(
            private val logs: CodeInterpreterLogs? = null,
            private val image: CodeInterpreterOutputImage? = null,
            private val _json: JsonValue? = null,
        ) {

            /** Text output from the Code Interpreter tool call as part of a run step. */
            fun logs(): Optional<CodeInterpreterLogs> = Optional.ofNullable(logs)

            fun image(): Optional<CodeInterpreterOutputImage> = Optional.ofNullable(image)

            fun isLogs(): Boolean = logs != null

            fun isImage(): Boolean = image != null

            /** Text output from the Code Interpreter tool call as part of a run step. */
            fun asLogs(): CodeInterpreterLogs = logs.getOrThrow("logs")

            fun asImage(): CodeInterpreterOutputImage = image.getOrThrow("image")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T {
                return when {
                    logs != null -> visitor.visitLogs(logs)
                    image != null -> visitor.visitImage(image)
                    else -> visitor.unknown(_json)
                }
            }

            private var validated: Boolean = false

            fun validate(): Output = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitLogs(logs: CodeInterpreterLogs) {
                            logs.validate()
                        }

                        override fun visitImage(image: CodeInterpreterOutputImage) {
                            image.validate()
                        }
                    }
                )
                validated = true
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Output && logs == other.logs && image == other.image /* spotless:on */
            }

            override fun hashCode(): Int = /* spotless:off */ Objects.hash(logs, image) /* spotless:on */

            override fun toString(): String =
                when {
                    logs != null -> "Output{logs=$logs}"
                    image != null -> "Output{image=$image}"
                    _json != null -> "Output{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Output")
                }

            companion object {

                /** Text output from the Code Interpreter tool call as part of a run step. */
                @JvmStatic fun ofLogs(logs: CodeInterpreterLogs) = Output(logs = logs)

                @JvmStatic fun ofImage(image: CodeInterpreterOutputImage) = Output(image = image)
            }

            /**
             * An interface that defines how to map each variant of [Output] to a value of type [T].
             */
            interface Visitor<out T> {

                /** Text output from the Code Interpreter tool call as part of a run step. */
                fun visitLogs(logs: CodeInterpreterLogs): T

                fun visitImage(image: CodeInterpreterOutputImage): T

                /**
                 * Maps an unknown variant of [Output] to a value of type [T].
                 *
                 * An instance of [Output] can contain an unknown variant if it was deserialized
                 * from data that doesn't match any known variant. For example, if the SDK is on an
                 * older version than the API, then the API may respond with new variants that the
                 * SDK is unaware of.
                 *
                 * @throws OpenAIInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown Output: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<Output>(Output::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Output {
                    val json = JsonValue.fromJsonNode(node)
                    val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                    when (type) {
                        "logs" -> {
                            tryDeserialize(node, jacksonTypeRef<CodeInterpreterLogs>()) {
                                    it.validate()
                                }
                                ?.let {
                                    return Output(logs = it, _json = json)
                                }
                        }
                        "image" -> {
                            tryDeserialize(node, jacksonTypeRef<CodeInterpreterOutputImage>()) {
                                    it.validate()
                                }
                                ?.let {
                                    return Output(image = it, _json = json)
                                }
                        }
                    }

                    return Output(_json = json)
                }
            }

            internal class Serializer : BaseSerializer<Output>(Output::class) {

                override fun serialize(
                    value: Output,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.logs != null -> generator.writeObject(value.logs)
                        value.image != null -> generator.writeObject(value.image)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Output")
                    }
                }
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is CodeInterpreter && input == other.input && outputs == other.outputs && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(input, outputs, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "CodeInterpreter{input=$input, outputs=$outputs, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is CodeInterpreterToolCallDelta && index == other.index && type == other.type && id == other.id && codeInterpreter == other.codeInterpreter && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(index, type, id, codeInterpreter, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CodeInterpreterToolCallDelta{index=$index, type=$type, id=$id, codeInterpreter=$codeInterpreter, additionalProperties=$additionalProperties}"
}
