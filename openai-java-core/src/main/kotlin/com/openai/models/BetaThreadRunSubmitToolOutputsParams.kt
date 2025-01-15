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
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import java.util.Objects
import java.util.Optional

/**
 * When a run has the `status: "requires_action"` and `required_action.type` is
 * `submit_tool_outputs`, this endpoint can be used to submit the outputs from the tool calls once
 * they're all completed. All outputs must be submitted in a single request.
 */
class BetaThreadRunSubmitToolOutputsParams
constructor(
    private val threadId: String,
    private val runId: String,
    private val body: BetaThreadRunSubmitToolOutputsBody,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) {

    fun threadId(): String = threadId

    fun runId(): String = runId

    /** A list of tools for which the outputs are being submitted. */
    fun toolOutputs(): List<ToolOutput> = body.toolOutputs()

    /** A list of tools for which the outputs are being submitted. */
    fun _toolOutputs(): JsonField<List<ToolOutput>> = body._toolOutputs()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic internal fun getBody(): BetaThreadRunSubmitToolOutputsBody = body

    @JvmSynthetic internal fun getHeaders(): Headers = additionalHeaders

    @JvmSynthetic internal fun getQueryParams(): QueryParams = additionalQueryParams

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> threadId
            1 -> runId
            else -> ""
        }
    }

    @NoAutoDetect
    class BetaThreadRunSubmitToolOutputsBody
    @JsonCreator
    internal constructor(
        @JsonProperty("tool_outputs")
        @ExcludeMissing
        private val toolOutputs: JsonField<List<ToolOutput>> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** A list of tools for which the outputs are being submitted. */
        fun toolOutputs(): List<ToolOutput> = toolOutputs.getRequired("tool_outputs")

        /** A list of tools for which the outputs are being submitted. */
        @JsonProperty("tool_outputs")
        @ExcludeMissing
        fun _toolOutputs(): JsonField<List<ToolOutput>> = toolOutputs

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): BetaThreadRunSubmitToolOutputsBody = apply {
            if (validated) {
                return@apply
            }

            toolOutputs().forEach { it.validate() }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var toolOutputs: JsonField<MutableList<ToolOutput>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(
                betaThreadRunSubmitToolOutputsBody: BetaThreadRunSubmitToolOutputsBody
            ) = apply {
                toolOutputs =
                    betaThreadRunSubmitToolOutputsBody.toolOutputs.map { it.toMutableList() }
                additionalProperties =
                    betaThreadRunSubmitToolOutputsBody.additionalProperties.toMutableMap()
            }

            /** A list of tools for which the outputs are being submitted. */
            fun toolOutputs(toolOutputs: List<ToolOutput>) = toolOutputs(JsonField.of(toolOutputs))

            /** A list of tools for which the outputs are being submitted. */
            fun toolOutputs(toolOutputs: JsonField<List<ToolOutput>>) = apply {
                this.toolOutputs = toolOutputs.map { it.toMutableList() }
            }

            /** A list of tools for which the outputs are being submitted. */
            fun addToolOutput(toolOutput: ToolOutput) = apply {
                toolOutputs =
                    (toolOutputs ?: JsonField.of(mutableListOf())).apply {
                        asKnown()
                            .orElseThrow {
                                IllegalStateException(
                                    "Field was set to non-list type: ${javaClass.simpleName}"
                                )
                            }
                            .add(toolOutput)
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

            fun build(): BetaThreadRunSubmitToolOutputsBody =
                BetaThreadRunSubmitToolOutputsBody(
                    checkRequired("toolOutputs", toolOutputs).map { it.toImmutable() },
                    additionalProperties.toImmutable()
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is BetaThreadRunSubmitToolOutputsBody && toolOutputs == other.toolOutputs && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(toolOutputs, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "BetaThreadRunSubmitToolOutputsBody{toolOutputs=$toolOutputs, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var threadId: String? = null
        private var runId: String? = null
        private var body: BetaThreadRunSubmitToolOutputsBody.Builder =
            BetaThreadRunSubmitToolOutputsBody.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(
            betaThreadRunSubmitToolOutputsParams: BetaThreadRunSubmitToolOutputsParams
        ) = apply {
            threadId = betaThreadRunSubmitToolOutputsParams.threadId
            runId = betaThreadRunSubmitToolOutputsParams.runId
            body = betaThreadRunSubmitToolOutputsParams.body.toBuilder()
            additionalHeaders = betaThreadRunSubmitToolOutputsParams.additionalHeaders.toBuilder()
            additionalQueryParams =
                betaThreadRunSubmitToolOutputsParams.additionalQueryParams.toBuilder()
        }

        fun threadId(threadId: String) = apply { this.threadId = threadId }

        fun runId(runId: String) = apply { this.runId = runId }

        /** A list of tools for which the outputs are being submitted. */
        fun toolOutputs(toolOutputs: List<ToolOutput>) = apply { body.toolOutputs(toolOutputs) }

        /** A list of tools for which the outputs are being submitted. */
        fun toolOutputs(toolOutputs: JsonField<List<ToolOutput>>) = apply {
            body.toolOutputs(toolOutputs)
        }

        /** A list of tools for which the outputs are being submitted. */
        fun addToolOutput(toolOutput: ToolOutput) = apply { body.addToolOutput(toolOutput) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        fun build(): BetaThreadRunSubmitToolOutputsParams =
            BetaThreadRunSubmitToolOutputsParams(
                checkRequired("threadId", threadId),
                checkRequired("runId", runId),
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    @NoAutoDetect
    class ToolOutput
    @JsonCreator
    private constructor(
        @JsonProperty("output")
        @ExcludeMissing
        private val output: JsonField<String> = JsonMissing.of(),
        @JsonProperty("tool_call_id")
        @ExcludeMissing
        private val toolCallId: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The output of the tool call to be submitted to continue the run. */
        fun output(): Optional<String> = Optional.ofNullable(output.getNullable("output"))

        /**
         * The ID of the tool call in the `required_action` object within the run object the output
         * is being submitted for.
         */
        fun toolCallId(): Optional<String> =
            Optional.ofNullable(toolCallId.getNullable("tool_call_id"))

        /** The output of the tool call to be submitted to continue the run. */
        @JsonProperty("output") @ExcludeMissing fun _output(): JsonField<String> = output

        /**
         * The ID of the tool call in the `required_action` object within the run object the output
         * is being submitted for.
         */
        @JsonProperty("tool_call_id")
        @ExcludeMissing
        fun _toolCallId(): JsonField<String> = toolCallId

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ToolOutput = apply {
            if (validated) {
                return@apply
            }

            output()
            toolCallId()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var output: JsonField<String> = JsonMissing.of()
            private var toolCallId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(toolOutput: ToolOutput) = apply {
                output = toolOutput.output
                toolCallId = toolOutput.toolCallId
                additionalProperties = toolOutput.additionalProperties.toMutableMap()
            }

            /** The output of the tool call to be submitted to continue the run. */
            fun output(output: String) = output(JsonField.of(output))

            /** The output of the tool call to be submitted to continue the run. */
            fun output(output: JsonField<String>) = apply { this.output = output }

            /**
             * The ID of the tool call in the `required_action` object within the run object the
             * output is being submitted for.
             */
            fun toolCallId(toolCallId: String) = toolCallId(JsonField.of(toolCallId))

            /**
             * The ID of the tool call in the `required_action` object within the run object the
             * output is being submitted for.
             */
            fun toolCallId(toolCallId: JsonField<String>) = apply { this.toolCallId = toolCallId }

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

            fun build(): ToolOutput =
                ToolOutput(
                    output,
                    toolCallId,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ToolOutput && output == other.output && toolCallId == other.toolCallId && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(output, toolCallId, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ToolOutput{output=$output, toolCallId=$toolCallId, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is BetaThreadRunSubmitToolOutputsParams && threadId == other.threadId && runId == other.runId && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(threadId, runId, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "BetaThreadRunSubmitToolOutputsParams{threadId=$threadId, runId=$runId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
