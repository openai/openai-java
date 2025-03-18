// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import com.openai.core.NoAutoDetect
import com.openai.core.Params
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Retrieves a run step. */
class StepRetrieveParams
private constructor(
    private val threadId: String,
    private val runId: String,
    private val stepId: String,
    private val include: List<RunStepInclude>?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun threadId(): String = threadId

    fun runId(): String = runId

    fun stepId(): String = stepId

    /**
     * A list of additional fields to include in the response. Currently the only supported value is
     * `step_details.tool_calls[*].file_search.results[*].content` to fetch the file search result
     * content.
     *
     * See the
     * [file search tool documentation](https://platform.openai.com/docs/assistants/tools/file-search#customizing-file-search-settings)
     * for more information.
     */
    fun include(): Optional<List<RunStepInclude>> = Optional.ofNullable(include)

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> threadId
            1 -> runId
            2 -> stepId
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                include?.forEach { put("include[]", it.toString()) }
                putAll(additionalQueryParams)
            }
            .build()

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [StepRetrieveParams].
         *
         * The following fields are required:
         * ```java
         * .threadId()
         * .runId()
         * .stepId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [StepRetrieveParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

        private var threadId: String? = null
        private var runId: String? = null
        private var stepId: String? = null
        private var include: MutableList<RunStepInclude>? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(stepRetrieveParams: StepRetrieveParams) = apply {
            threadId = stepRetrieveParams.threadId
            runId = stepRetrieveParams.runId
            stepId = stepRetrieveParams.stepId
            include = stepRetrieveParams.include?.toMutableList()
            additionalHeaders = stepRetrieveParams.additionalHeaders.toBuilder()
            additionalQueryParams = stepRetrieveParams.additionalQueryParams.toBuilder()
        }

        fun threadId(threadId: String) = apply { this.threadId = threadId }

        fun runId(runId: String) = apply { this.runId = runId }

        fun stepId(stepId: String) = apply { this.stepId = stepId }

        /**
         * A list of additional fields to include in the response. Currently the only supported
         * value is `step_details.tool_calls[*].file_search.results[*].content` to fetch the file
         * search result content.
         *
         * See the
         * [file search tool documentation](https://platform.openai.com/docs/assistants/tools/file-search#customizing-file-search-settings)
         * for more information.
         */
        fun include(include: List<RunStepInclude>?) = apply {
            this.include = include?.toMutableList()
        }

        /** Alias for calling [Builder.include] with `include.orElse(null)`. */
        fun include(include: Optional<List<RunStepInclude>>) = include(include.getOrNull())

        /**
         * Adds a single [RunStepInclude] to [Builder.include].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addInclude(include: RunStepInclude) = apply {
            this.include = (this.include ?: mutableListOf()).apply { add(include) }
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
         * Returns an immutable instance of [StepRetrieveParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .threadId()
         * .runId()
         * .stepId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): StepRetrieveParams =
            StepRetrieveParams(
                checkRequired("threadId", threadId),
                checkRequired("runId", runId),
                checkRequired("stepId", stepId),
                include?.toImmutable(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is StepRetrieveParams && threadId == other.threadId && runId == other.runId && stepId == other.stepId && include == other.include && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(threadId, runId, stepId, include, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "StepRetrieveParams{threadId=$threadId, runId=$runId, stepId=$stepId, include=$include, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
