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
import com.openai.core.getOrThrow
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Details of the Code Interpreter tool call the run step was involved in. */
@NoAutoDetect
class CodeInterpreterToolCall
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("code_interpreter")
    @ExcludeMissing
    private val codeInterpreter: JsonField<CodeInterpreter> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The ID of the tool call. */
    fun id(): String = id.getRequired("id")

    /** The Code Interpreter tool call definition. */
    fun codeInterpreter(): CodeInterpreter = codeInterpreter.getRequired("code_interpreter")

    /**
     * The type of tool call. This is always going to be `code_interpreter` for this type of tool
     * call.
     */
    fun type(): Type = type.getRequired("type")

    /** The ID of the tool call. */
    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The Code Interpreter tool call definition. */
    @JsonProperty("code_interpreter") @ExcludeMissing fun _codeInterpreter() = codeInterpreter

    /**
     * The type of tool call. This is always going to be `code_interpreter` for this type of tool
     * call.
     */
    @JsonProperty("type") @ExcludeMissing fun _type() = type

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): CodeInterpreterToolCall = apply {
        if (!validated) {
            id()
            codeInterpreter().validate()
            type()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var codeInterpreter: JsonField<CodeInterpreter> = JsonMissing.of()
        private var type: JsonField<Type> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(codeInterpreterToolCall: CodeInterpreterToolCall) = apply {
            id = codeInterpreterToolCall.id
            codeInterpreter = codeInterpreterToolCall.codeInterpreter
            type = codeInterpreterToolCall.type
            additionalProperties = codeInterpreterToolCall.additionalProperties.toMutableMap()
        }

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

        fun build(): CodeInterpreterToolCall =
            CodeInterpreterToolCall(
                id,
                codeInterpreter,
                type,
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
        fun input(): String = input.getRequired("input")

        /**
         * The outputs from the Code Interpreter tool call. Code Interpreter can output one or more
         * items, including text (`logs`) or images (`image`). Each of these are represented by a
         * different object type.
         */
        fun outputs(): List<Output> = outputs.getRequired("outputs")

        /** The input to the Code Interpreter tool call. */
        @JsonProperty("input") @ExcludeMissing fun _input() = input

        /**
         * The outputs from the Code Interpreter tool call. Code Interpreter can output one or more
         * items, including text (`logs`) or images (`image`). Each of these are represented by a
         * different object type.
         */
        @JsonProperty("outputs") @ExcludeMissing fun _outputs() = outputs

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): CodeInterpreter = apply {
            if (!validated) {
                input()
                outputs()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var input: JsonField<String> = JsonMissing.of()
            private var outputs: JsonField<List<Output>> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(codeInterpreter: CodeInterpreter) = apply {
                input = codeInterpreter.input
                outputs = codeInterpreter.outputs
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
            fun outputs(outputs: JsonField<List<Output>>) = apply { this.outputs = outputs }

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
                    outputs.map { it.toImmutable() },
                    additionalProperties.toImmutable(),
                )
        }

        /** Text output from the Code Interpreter tool call as part of a run step. */
        @JsonDeserialize(using = Output.Deserializer::class)
        @JsonSerialize(using = Output.Serializer::class)
        class Output
        private constructor(
            private val logs: LogsOutput? = null,
            private val image: ImageOutput? = null,
            private val _json: JsonValue? = null,
        ) {

            private var validated: Boolean = false

            /** Text output from the Code Interpreter tool call as part of a run step. */
            fun logs(): Optional<LogsOutput> = Optional.ofNullable(logs)

            fun image(): Optional<ImageOutput> = Optional.ofNullable(image)

            fun isLogs(): Boolean = logs != null

            fun isImage(): Boolean = image != null

            /** Text output from the Code Interpreter tool call as part of a run step. */
            fun asLogs(): LogsOutput = logs.getOrThrow("logs")

            fun asImage(): ImageOutput = image.getOrThrow("image")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T {
                return when {
                    logs != null -> visitor.visitLogs(logs)
                    image != null -> visitor.visitImage(image)
                    else -> visitor.unknown(_json)
                }
            }

            fun validate(): Output = apply {
                if (!validated) {
                    if (logs == null && image == null) {
                        throw OpenAIInvalidDataException("Unknown Output: $_json")
                    }
                    logs?.validate()
                    image?.validate()
                    validated = true
                }
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
                @JvmStatic fun ofLogs(logs: LogsOutput) = Output(logs = logs)

                @JvmStatic fun ofImage(image: ImageOutput) = Output(image = image)
            }

            interface Visitor<out T> {

                fun visitLogs(logs: LogsOutput): T

                fun visitImage(image: ImageOutput): T

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
                            tryDeserialize(node, jacksonTypeRef<LogsOutput>()) { it.validate() }
                                ?.let {
                                    return Output(logs = it, _json = json)
                                }
                        }
                        "image" -> {
                            tryDeserialize(node, jacksonTypeRef<ImageOutput>()) { it.validate() }
                                ?.let {
                                    return Output(image = it, _json = json)
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
                        value.logs != null -> generator.writeObject(value.logs)
                        value.image != null -> generator.writeObject(value.image)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Output")
                    }
                }
            }

            /** Text output from the Code Interpreter tool call as part of a run step. */
            @NoAutoDetect
            class LogsOutput
            @JsonCreator
            private constructor(
                @JsonProperty("logs")
                @ExcludeMissing
                private val logs: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type")
                @ExcludeMissing
                private val type: JsonField<Type> = JsonMissing.of(),
                @JsonAnySetter
                private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
            ) {

                /** The text output from the Code Interpreter tool call. */
                fun logs(): String = logs.getRequired("logs")

                /** Always `logs`. */
                fun type(): Type = type.getRequired("type")

                /** The text output from the Code Interpreter tool call. */
                @JsonProperty("logs") @ExcludeMissing fun _logs() = logs

                /** Always `logs`. */
                @JsonProperty("type") @ExcludeMissing fun _type() = type

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                private var validated: Boolean = false

                fun validate(): LogsOutput = apply {
                    if (!validated) {
                        logs()
                        type()
                        validated = true
                    }
                }

                fun toBuilder() = Builder().from(this)

                companion object {

                    @JvmStatic fun builder() = Builder()
                }

                class Builder {

                    private var logs: JsonField<String> = JsonMissing.of()
                    private var type: JsonField<Type> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(logsOutput: LogsOutput) = apply {
                        logs = logsOutput.logs
                        type = logsOutput.type
                        additionalProperties = logsOutput.additionalProperties.toMutableMap()
                    }

                    /** The text output from the Code Interpreter tool call. */
                    fun logs(logs: String) = logs(JsonField.of(logs))

                    /** The text output from the Code Interpreter tool call. */
                    fun logs(logs: JsonField<String>) = apply { this.logs = logs }

                    /** Always `logs`. */
                    fun type(type: Type) = type(JsonField.of(type))

                    /** Always `logs`. */
                    fun type(type: JsonField<Type>) = apply { this.type = type }

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

                    fun build(): LogsOutput =
                        LogsOutput(
                            logs,
                            type,
                            additionalProperties.toImmutable(),
                        )
                }

                class Type
                @JsonCreator
                private constructor(
                    private val value: JsonField<String>,
                ) : Enum {

                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    companion object {

                        @JvmField val LOGS = of("logs")

                        @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                    }

                    enum class Known {
                        LOGS,
                    }

                    enum class Value {
                        LOGS,
                        _UNKNOWN,
                    }

                    fun value(): Value =
                        when (this) {
                            LOGS -> Value.LOGS
                            else -> Value._UNKNOWN
                        }

                    fun known(): Known =
                        when (this) {
                            LOGS -> Known.LOGS
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

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is LogsOutput && logs == other.logs && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(logs, type, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "LogsOutput{logs=$logs, type=$type, additionalProperties=$additionalProperties}"
            }

            @NoAutoDetect
            class ImageOutput
            @JsonCreator
            private constructor(
                @JsonProperty("image")
                @ExcludeMissing
                private val image: JsonField<Image> = JsonMissing.of(),
                @JsonProperty("type")
                @ExcludeMissing
                private val type: JsonField<Type> = JsonMissing.of(),
                @JsonAnySetter
                private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
            ) {

                fun image(): Image = image.getRequired("image")

                /** Always `image`. */
                fun type(): Type = type.getRequired("type")

                @JsonProperty("image") @ExcludeMissing fun _image() = image

                /** Always `image`. */
                @JsonProperty("type") @ExcludeMissing fun _type() = type

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                private var validated: Boolean = false

                fun validate(): ImageOutput = apply {
                    if (!validated) {
                        image().validate()
                        type()
                        validated = true
                    }
                }

                fun toBuilder() = Builder().from(this)

                companion object {

                    @JvmStatic fun builder() = Builder()
                }

                class Builder {

                    private var image: JsonField<Image> = JsonMissing.of()
                    private var type: JsonField<Type> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(imageOutput: ImageOutput) = apply {
                        image = imageOutput.image
                        type = imageOutput.type
                        additionalProperties = imageOutput.additionalProperties.toMutableMap()
                    }

                    fun image(image: Image) = image(JsonField.of(image))

                    fun image(image: JsonField<Image>) = apply { this.image = image }

                    /** Always `image`. */
                    fun type(type: Type) = type(JsonField.of(type))

                    /** Always `image`. */
                    fun type(type: JsonField<Type>) = apply { this.type = type }

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

                    fun build(): ImageOutput =
                        ImageOutput(
                            image,
                            type,
                            additionalProperties.toImmutable(),
                        )
                }

                @NoAutoDetect
                class Image
                @JsonCreator
                private constructor(
                    @JsonProperty("file_id")
                    @ExcludeMissing
                    private val fileId: JsonField<String> = JsonMissing.of(),
                    @JsonAnySetter
                    private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
                ) {

                    /**
                     * The [file](https://platform.openai.com/docs/api-reference/files) ID of the
                     * image.
                     */
                    fun fileId(): String = fileId.getRequired("file_id")

                    /**
                     * The [file](https://platform.openai.com/docs/api-reference/files) ID of the
                     * image.
                     */
                    @JsonProperty("file_id") @ExcludeMissing fun _fileId() = fileId

                    @JsonAnyGetter
                    @ExcludeMissing
                    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                    private var validated: Boolean = false

                    fun validate(): Image = apply {
                        if (!validated) {
                            fileId()
                            validated = true
                        }
                    }

                    fun toBuilder() = Builder().from(this)

                    companion object {

                        @JvmStatic fun builder() = Builder()
                    }

                    class Builder {

                        private var fileId: JsonField<String> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(image: Image) = apply {
                            fileId = image.fileId
                            additionalProperties = image.additionalProperties.toMutableMap()
                        }

                        /**
                         * The [file](https://platform.openai.com/docs/api-reference/files) ID of
                         * the image.
                         */
                        fun fileId(fileId: String) = fileId(JsonField.of(fileId))

                        /**
                         * The [file](https://platform.openai.com/docs/api-reference/files) ID of
                         * the image.
                         */
                        fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        fun build(): Image = Image(fileId, additionalProperties.toImmutable())
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is Image && fileId == other.fileId && additionalProperties == other.additionalProperties /* spotless:on */
                    }

                    /* spotless:off */
                    private val hashCode: Int by lazy { Objects.hash(fileId, additionalProperties) }
                    /* spotless:on */

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Image{fileId=$fileId, additionalProperties=$additionalProperties}"
                }

                class Type
                @JsonCreator
                private constructor(
                    private val value: JsonField<String>,
                ) : Enum {

                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    companion object {

                        @JvmField val IMAGE = of("image")

                        @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                    }

                    enum class Known {
                        IMAGE,
                    }

                    enum class Value {
                        IMAGE,
                        _UNKNOWN,
                    }

                    fun value(): Value =
                        when (this) {
                            IMAGE -> Value.IMAGE
                            else -> Value._UNKNOWN
                        }

                    fun known(): Known =
                        when (this) {
                            IMAGE -> Known.IMAGE
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

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is ImageOutput && image == other.image && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(image, type, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "ImageOutput{image=$image, type=$type, additionalProperties=$additionalProperties}"
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is CodeInterpreterToolCall && id == other.id && codeInterpreter == other.codeInterpreter && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, codeInterpreter, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CodeInterpreterToolCall{id=$id, codeInterpreter=$codeInterpreter, type=$type, additionalProperties=$additionalProperties}"
}
