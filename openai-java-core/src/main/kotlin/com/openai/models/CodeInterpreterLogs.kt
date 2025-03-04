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
import java.util.Optional

/** Text output from the Code Interpreter tool call as part of a run step. */
@NoAutoDetect
class CodeInterpreterLogs
@JsonCreator
private constructor(
    @JsonProperty("index") @ExcludeMissing private val index: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonProperty("logs") @ExcludeMissing private val logs: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The index of the output in the outputs array. */
    fun index(): Long = index.getRequired("index")

    /** Always `logs`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /** The text output from the Code Interpreter tool call. */
    fun logs(): Optional<String> = Optional.ofNullable(logs.getNullable("logs"))

    /** The index of the output in the outputs array. */
    @JsonProperty("index") @ExcludeMissing fun _index(): JsonField<Long> = index

    /** The text output from the Code Interpreter tool call. */
    @JsonProperty("logs") @ExcludeMissing fun _logs(): JsonField<String> = logs

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): CodeInterpreterLogs = apply {
        if (validated) {
            return@apply
        }

        index()
        _type().let {
            if (it != JsonValue.from("logs")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        logs()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [CodeInterpreterLogs].
         *
         * The following fields are required:
         * ```java
         * .index()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CodeInterpreterLogs]. */
    class Builder internal constructor() {

        private var index: JsonField<Long>? = null
        private var type: JsonValue = JsonValue.from("logs")
        private var logs: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(codeInterpreterLogs: CodeInterpreterLogs) = apply {
            index = codeInterpreterLogs.index
            type = codeInterpreterLogs.type
            logs = codeInterpreterLogs.logs
            additionalProperties = codeInterpreterLogs.additionalProperties.toMutableMap()
        }

        /** The index of the output in the outputs array. */
        fun index(index: Long) = index(JsonField.of(index))

        /** The index of the output in the outputs array. */
        fun index(index: JsonField<Long>) = apply { this.index = index }

        /** Always `logs`. */
        fun type(type: JsonValue) = apply { this.type = type }

        /** The text output from the Code Interpreter tool call. */
        fun logs(logs: String) = logs(JsonField.of(logs))

        /** The text output from the Code Interpreter tool call. */
        fun logs(logs: JsonField<String>) = apply { this.logs = logs }

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

        fun build(): CodeInterpreterLogs =
            CodeInterpreterLogs(
                checkRequired("index", index),
                type,
                logs,
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is CodeInterpreterLogs && index == other.index && type == other.type && logs == other.logs && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(index, type, logs, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CodeInterpreterLogs{index=$index, type=$type, logs=$logs, additionalProperties=$additionalProperties}"
}
