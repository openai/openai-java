// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.Params
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * When a run has the `status: "requires_action"` and `required_action.type` is
 * `submit_tool_outputs`, this endpoint can be used to submit the outputs from the tool calls once
 * they're all completed. All outputs must be submitted in a single request.
 */
class RunSubmitToolOutputsParams
private constructor(
    private val threadId: String,
    private val runId: String,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun threadId(): String = threadId

    fun runId(): String = runId

    /**
     * A list of tools for which the outputs are being submitted.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun toolOutputs(): List<ToolOutput> = body.toolOutputs()

    /**
     * Returns the raw JSON value of [toolOutputs].
     *
     * Unlike [toolOutputs], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _toolOutputs(): JsonField<List<ToolOutput>> = body._toolOutputs()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [RunSubmitToolOutputsParams].
         *
         * The following fields are required:
         * ```java
         * .threadId()
         * .runId()
         * .toolOutputs()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RunSubmitToolOutputsParams]. */
    class Builder internal constructor() {

        private var threadId: String? = null
        private var runId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(runSubmitToolOutputsParams: RunSubmitToolOutputsParams) = apply {
            threadId = runSubmitToolOutputsParams.threadId
            runId = runSubmitToolOutputsParams.runId
            body = runSubmitToolOutputsParams.body.toBuilder()
            additionalHeaders = runSubmitToolOutputsParams.additionalHeaders.toBuilder()
            additionalQueryParams = runSubmitToolOutputsParams.additionalQueryParams.toBuilder()
        }

        fun threadId(threadId: String) = apply { this.threadId = threadId }

        fun runId(runId: String) = apply { this.runId = runId }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [toolOutputs]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** A list of tools for which the outputs are being submitted. */
        fun toolOutputs(toolOutputs: List<ToolOutput>) = apply { body.toolOutputs(toolOutputs) }

        /**
         * Sets [Builder.toolOutputs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.toolOutputs] with a well-typed `List<ToolOutput>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun toolOutputs(toolOutputs: JsonField<List<ToolOutput>>) = apply {
            body.toolOutputs(toolOutputs)
        }

        /**
         * Adds a single [ToolOutput] to [toolOutputs].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
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

        /**
         * Returns an immutable instance of [RunSubmitToolOutputsParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .threadId()
         * .runId()
         * .toolOutputs()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): RunSubmitToolOutputsParams =
            RunSubmitToolOutputsParams(
                checkRequired("threadId", threadId),
                checkRequired("runId", runId),
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> threadId
            1 -> runId
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    private constructor(
        private val toolOutputs: JsonField<List<ToolOutput>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("tool_outputs")
            @ExcludeMissing
            toolOutputs: JsonField<List<ToolOutput>> = JsonMissing.of()
        ) : this(toolOutputs, mutableMapOf())

        /**
         * A list of tools for which the outputs are being submitted.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun toolOutputs(): List<ToolOutput> = toolOutputs.getRequired("tool_outputs")

        /**
         * Returns the raw JSON value of [toolOutputs].
         *
         * Unlike [toolOutputs], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tool_outputs")
        @ExcludeMissing
        fun _toolOutputs(): JsonField<List<ToolOutput>> = toolOutputs

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
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .toolOutputs()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var toolOutputs: JsonField<MutableList<ToolOutput>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                toolOutputs = body.toolOutputs.map { it.toMutableList() }
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** A list of tools for which the outputs are being submitted. */
            fun toolOutputs(toolOutputs: List<ToolOutput>) = toolOutputs(JsonField.of(toolOutputs))

            /**
             * Sets [Builder.toolOutputs] to an arbitrary JSON value.
             *
             * You should usually call [Builder.toolOutputs] with a well-typed `List<ToolOutput>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun toolOutputs(toolOutputs: JsonField<List<ToolOutput>>) = apply {
                this.toolOutputs = toolOutputs.map { it.toMutableList() }
            }

            /**
             * Adds a single [ToolOutput] to [toolOutputs].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addToolOutput(toolOutput: ToolOutput) = apply {
                toolOutputs =
                    (toolOutputs ?: JsonField.of(mutableListOf())).also {
                        checkKnown("toolOutputs", it).add(toolOutput)
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

            /**
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .toolOutputs()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("toolOutputs", toolOutputs).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            toolOutputs().forEach { it.validate() }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (toolOutputs.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && toolOutputs == other.toolOutputs && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(toolOutputs, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{toolOutputs=$toolOutputs, additionalProperties=$additionalProperties}"
    }

    class ToolOutput
    private constructor(
        private val output: JsonField<String>,
        private val toolCallId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("output") @ExcludeMissing output: JsonField<String> = JsonMissing.of(),
            @JsonProperty("tool_call_id")
            @ExcludeMissing
            toolCallId: JsonField<String> = JsonMissing.of(),
        ) : this(output, toolCallId, mutableMapOf())

        /**
         * The output of the tool call to be submitted to continue the run.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun output(): Optional<String> = Optional.ofNullable(output.getNullable("output"))

        /**
         * The ID of the tool call in the `required_action` object within the run object the output
         * is being submitted for.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun toolCallId(): Optional<String> =
            Optional.ofNullable(toolCallId.getNullable("tool_call_id"))

        /**
         * Returns the raw JSON value of [output].
         *
         * Unlike [output], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output") @ExcludeMissing fun _output(): JsonField<String> = output

        /**
         * Returns the raw JSON value of [toolCallId].
         *
         * Unlike [toolCallId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tool_call_id")
        @ExcludeMissing
        fun _toolCallId(): JsonField<String> = toolCallId

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

            /** Returns a mutable builder for constructing an instance of [ToolOutput]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ToolOutput]. */
        class Builder internal constructor() {

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

            /**
             * Sets [Builder.output] to an arbitrary JSON value.
             *
             * You should usually call [Builder.output] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun output(output: JsonField<String>) = apply { this.output = output }

            /**
             * The ID of the tool call in the `required_action` object within the run object the
             * output is being submitted for.
             */
            fun toolCallId(toolCallId: String) = toolCallId(JsonField.of(toolCallId))

            /**
             * Sets [Builder.toolCallId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.toolCallId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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

            /**
             * Returns an immutable instance of [ToolOutput].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): ToolOutput =
                ToolOutput(output, toolCallId, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): ToolOutput = apply {
            if (validated) {
                return@apply
            }

            output()
            toolCallId()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (output.asKnown().isPresent) 1 else 0) +
                (if (toolCallId.asKnown().isPresent) 1 else 0)

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

        return /* spotless:off */ other is RunSubmitToolOutputsParams && threadId == other.threadId && runId == other.runId && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(threadId, runId, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "RunSubmitToolOutputsParams{threadId=$threadId, runId=$runId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
