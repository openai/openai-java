// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

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
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Details of the Code Interpreter tool call the run step was involved in. */
class CodeInterpreterToolCallDelta
private constructor(
    private val index: JsonField<Long>,
    private val type: JsonValue,
    private val id: JsonField<String>,
    private val codeInterpreter: JsonField<CodeInterpreter>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("index") @ExcludeMissing index: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("code_interpreter")
        @ExcludeMissing
        codeInterpreter: JsonField<CodeInterpreter> = JsonMissing.of(),
    ) : this(index, type, id, codeInterpreter, mutableMapOf())

    /**
     * The index of the tool call in the tool calls array.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun index(): Long = index.getRequired("index")

    /**
     * The type of tool call. This is always going to be `code_interpreter` for this type of tool
     * call.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("code_interpreter")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * The ID of the tool call.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun id(): Optional<String> = Optional.ofNullable(id.getNullable("id"))

    /**
     * The Code Interpreter tool call definition.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun codeInterpreter(): Optional<CodeInterpreter> =
        Optional.ofNullable(codeInterpreter.getNullable("code_interpreter"))

    /**
     * Returns the raw JSON value of [index].
     *
     * Unlike [index], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("index") @ExcludeMissing fun _index(): JsonField<Long> = index

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [codeInterpreter].
     *
     * Unlike [codeInterpreter], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("code_interpreter")
    @ExcludeMissing
    fun _codeInterpreter(): JsonField<CodeInterpreter> = codeInterpreter

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [CodeInterpreterToolCallDelta].
         *
         * The following fields are required:
         * ```java
         * .index()
         * ```
         */
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

        /**
         * Sets [Builder.index] to an arbitrary JSON value.
         *
         * You should usually call [Builder.index] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun index(index: JsonField<Long>) = apply { this.index = index }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("code_interpreter")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** The ID of the tool call. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The Code Interpreter tool call definition. */
        fun codeInterpreter(codeInterpreter: CodeInterpreter) =
            codeInterpreter(JsonField.of(codeInterpreter))

        /**
         * Sets [Builder.codeInterpreter] to an arbitrary JSON value.
         *
         * You should usually call [Builder.codeInterpreter] with a well-typed [CodeInterpreter]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
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

        /**
         * Returns an immutable instance of [CodeInterpreterToolCallDelta].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .index()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CodeInterpreterToolCallDelta =
            CodeInterpreterToolCallDelta(
                checkRequired("index", index),
                type,
                id,
                codeInterpreter,
                additionalProperties.toMutableMap(),
            )
    }

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

    /** The Code Interpreter tool call definition. */
    class CodeInterpreter
    private constructor(
        private val input: JsonField<String>,
        private val outputs: JsonField<List<Output>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("input") @ExcludeMissing input: JsonField<String> = JsonMissing.of(),
            @JsonProperty("outputs")
            @ExcludeMissing
            outputs: JsonField<List<Output>> = JsonMissing.of(),
        ) : this(input, outputs, mutableMapOf())

        /**
         * The input to the Code Interpreter tool call.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun input(): Optional<String> = Optional.ofNullable(input.getNullable("input"))

        /**
         * The outputs from the Code Interpreter tool call. Code Interpreter can output one or more
         * items, including text (`logs`) or images (`image`). Each of these are represented by a
         * different object type.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun outputs(): Optional<List<Output>> = Optional.ofNullable(outputs.getNullable("outputs"))

        /**
         * Returns the raw JSON value of [input].
         *
         * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("input") @ExcludeMissing fun _input(): JsonField<String> = input

        /**
         * Returns the raw JSON value of [outputs].
         *
         * Unlike [outputs], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("outputs") @ExcludeMissing fun _outputs(): JsonField<List<Output>> = outputs

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [CodeInterpreter]. */
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

            /**
             * Sets [Builder.input] to an arbitrary JSON value.
             *
             * You should usually call [Builder.input] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun input(input: JsonField<String>) = apply { this.input = input }

            /**
             * The outputs from the Code Interpreter tool call. Code Interpreter can output one or
             * more items, including text (`logs`) or images (`image`). Each of these are
             * represented by a different object type.
             */
            fun outputs(outputs: List<Output>) = outputs(JsonField.of(outputs))

            /**
             * Sets [Builder.outputs] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputs] with a well-typed `List<Output>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputs(outputs: JsonField<List<Output>>) = apply {
                this.outputs = outputs.map { it.toMutableList() }
            }

            /**
             * Adds a single [Output] to [outputs].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addOutput(output: Output) = apply {
                outputs =
                    (outputs ?: JsonField.of(mutableListOf())).also {
                        checkKnown("outputs", it).add(output)
                    }
            }

            /** Alias for calling [addOutput] with `Output.ofLogs(logs)`. */
            fun addOutput(logs: CodeInterpreterLogs) = addOutput(Output.ofLogs(logs))

            /**
             * Alias for calling [addOutput] with the following:
             * ```java
             * CodeInterpreterLogs.builder()
             *     .index(index)
             *     .build()
             * ```
             */
            fun addLogsOutput(index: Long) =
                addOutput(CodeInterpreterLogs.builder().index(index).build())

            /** Alias for calling [addOutput] with `Output.ofImage(image)`. */
            fun addOutput(image: CodeInterpreterOutputImage) = addOutput(Output.ofImage(image))

            /**
             * Alias for calling [addOutput] with the following:
             * ```java
             * CodeInterpreterOutputImage.builder()
             *     .index(index)
             *     .build()
             * ```
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

            /**
             * Returns an immutable instance of [CodeInterpreter].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): CodeInterpreter =
                CodeInterpreter(
                    input,
                    (outputs ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): CodeInterpreter = apply {
            if (validated) {
                return@apply
            }

            input()
            outputs().ifPresent { it.forEach { it.validate() } }
            validated = true
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
                            return Output(
                                logs = deserialize(node, jacksonTypeRef<CodeInterpreterLogs>()),
                                _json = json,
                            )
                        }
                        "image" -> {
                            return Output(
                                image =
                                    deserialize(node, jacksonTypeRef<CodeInterpreterOutputImage>()),
                                _json = json,
                            )
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
