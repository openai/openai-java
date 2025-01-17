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
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
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
    @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
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
    fun type(): Type = type.getRequired("type")

    /** The ID of the tool call. */
    fun id(): Optional<String> = Optional.ofNullable(id.getNullable("id"))

    /** The Code Interpreter tool call definition. */
    fun codeInterpreter(): Optional<CodeInterpreter> =
        Optional.ofNullable(codeInterpreter.getNullable("code_interpreter"))

    /** The index of the tool call in the tool calls array. */
    @JsonProperty("index") @ExcludeMissing fun _index(): JsonField<Long> = index

    /**
     * The type of tool call. This is always going to be `code_interpreter` for this type of tool
     * call.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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
        type()
        id()
        codeInterpreter().ifPresent { it.validate() }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var index: JsonField<Long>? = null
        private var type: JsonField<Type>? = null
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
        fun type(type: Type) = type(JsonField.of(type))

        /**
         * The type of tool call. This is always going to be `code_interpreter` for this type of
         * tool call.
         */
        fun type(type: JsonField<Type>) = apply { this.type = type }

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
                checkRequired("type", type),
                id,
                codeInterpreter,
                additionalProperties.toImmutable(),
            )
    }

    /**
     * The type of tool call. This is always going to be `code_interpreter` for this type of tool
     * call.
     */
    class Type
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val CODE_INTERPRETER = of("code_interpreter")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            CODE_INTERPRETER,
        }

        enum class Value {
            CODE_INTERPRETER,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                CODE_INTERPRETER -> Value.CODE_INTERPRETER
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                CODE_INTERPRETER -> Known.CODE_INTERPRETER
                else -> throw OpenAIInvalidDataException("Unknown Type: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Type && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
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

        class Builder {

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
                    (outputs ?: JsonField.of(mutableListOf())).apply {
                        asKnown()
                            .orElseThrow {
                                IllegalStateException(
                                    "Field was set to non-list type: ${javaClass.simpleName}"
                                )
                            }
                            .add(output)
                    }
            }

            /** Text output from the Code Interpreter tool call as part of a run step. */
            fun addOutput(codeInterpreterLogs: CodeInterpreterLogs) =
                addOutput(Output.ofCodeInterpreterLogs(codeInterpreterLogs))

            /**
             * The outputs from the Code Interpreter tool call. Code Interpreter can output one or
             * more items, including text (`logs`) or images (`image`). Each of these are
             * represented by a different object type.
             */
            fun addOutput(codeInterpreterOutputImage: CodeInterpreterOutputImage) =
                addOutput(Output.ofCodeInterpreterOutputImage(codeInterpreterOutputImage))

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
            private val codeInterpreterLogs: CodeInterpreterLogs? = null,
            private val codeInterpreterOutputImage: CodeInterpreterOutputImage? = null,
            private val _json: JsonValue? = null,
        ) {

            /** Text output from the Code Interpreter tool call as part of a run step. */
            fun codeInterpreterLogs(): Optional<CodeInterpreterLogs> =
                Optional.ofNullable(codeInterpreterLogs)

            fun codeInterpreterOutputImage(): Optional<CodeInterpreterOutputImage> =
                Optional.ofNullable(codeInterpreterOutputImage)

            fun isCodeInterpreterLogs(): Boolean = codeInterpreterLogs != null

            fun isCodeInterpreterOutputImage(): Boolean = codeInterpreterOutputImage != null

            /** Text output from the Code Interpreter tool call as part of a run step. */
            fun asCodeInterpreterLogs(): CodeInterpreterLogs =
                codeInterpreterLogs.getOrThrow("codeInterpreterLogs")

            fun asCodeInterpreterOutputImage(): CodeInterpreterOutputImage =
                codeInterpreterOutputImage.getOrThrow("codeInterpreterOutputImage")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T {
                return when {
                    codeInterpreterLogs != null ->
                        visitor.visitCodeInterpreterLogs(codeInterpreterLogs)
                    codeInterpreterOutputImage != null ->
                        visitor.visitCodeInterpreterOutputImage(codeInterpreterOutputImage)
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
                        override fun visitCodeInterpreterLogs(
                            codeInterpreterLogs: CodeInterpreterLogs
                        ) {
                            codeInterpreterLogs.validate()
                        }

                        override fun visitCodeInterpreterOutputImage(
                            codeInterpreterOutputImage: CodeInterpreterOutputImage
                        ) {
                            codeInterpreterOutputImage.validate()
                        }
                    }
                )
                validated = true
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Output && codeInterpreterLogs == other.codeInterpreterLogs && codeInterpreterOutputImage == other.codeInterpreterOutputImage /* spotless:on */
            }

            override fun hashCode(): Int = /* spotless:off */ Objects.hash(codeInterpreterLogs, codeInterpreterOutputImage) /* spotless:on */

            override fun toString(): String =
                when {
                    codeInterpreterLogs != null ->
                        "Output{codeInterpreterLogs=$codeInterpreterLogs}"
                    codeInterpreterOutputImage != null ->
                        "Output{codeInterpreterOutputImage=$codeInterpreterOutputImage}"
                    _json != null -> "Output{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Output")
                }

            companion object {

                /** Text output from the Code Interpreter tool call as part of a run step. */
                @JvmStatic
                fun ofCodeInterpreterLogs(codeInterpreterLogs: CodeInterpreterLogs) =
                    Output(codeInterpreterLogs = codeInterpreterLogs)

                @JvmStatic
                fun ofCodeInterpreterOutputImage(
                    codeInterpreterOutputImage: CodeInterpreterOutputImage
                ) = Output(codeInterpreterOutputImage = codeInterpreterOutputImage)
            }

            interface Visitor<out T> {

                /** Text output from the Code Interpreter tool call as part of a run step. */
                fun visitCodeInterpreterLogs(codeInterpreterLogs: CodeInterpreterLogs): T

                fun visitCodeInterpreterOutputImage(
                    codeInterpreterOutputImage: CodeInterpreterOutputImage
                ): T

                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown Output: $json")
                }
            }

            class Deserializer : BaseDeserializer<Output>(Output::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Output {
                    val json = JsonValue.fromJsonNode(node)
                    val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                    when (type) {
                        "logs" -> {
                            tryDeserialize(node, jacksonTypeRef<CodeInterpreterLogs>()) {
                                    it.validate()
                                }
                                ?.let {
                                    return Output(codeInterpreterLogs = it, _json = json)
                                }
                        }
                        "image" -> {
                            tryDeserialize(node, jacksonTypeRef<CodeInterpreterOutputImage>()) {
                                    it.validate()
                                }
                                ?.let {
                                    return Output(codeInterpreterOutputImage = it, _json = json)
                                }
                        }
                    }

                    return Output(_json = json)
                }
            }

            class Serializer : BaseSerializer<Output>(Output::class) {

                override fun serialize(
                    value: Output,
                    generator: JsonGenerator,
                    provider: SerializerProvider
                ) {
                    when {
                        value.codeInterpreterLogs != null ->
                            generator.writeObject(value.codeInterpreterLogs)
                        value.codeInterpreterOutputImage != null ->
                            generator.writeObject(value.codeInterpreterOutputImage)
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
