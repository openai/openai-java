// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.NoAutoDetect
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import java.util.Objects
import java.util.Optional

/** Retrieves a run step. */
class BetaThreadRunStepRetrieveParams
constructor(
    private val threadId: String,
    private val runId: String,
    private val stepId: String,
    private val include: List<RunStepInclude>?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) {

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

    @JvmSynthetic internal fun getHeaders(): Headers = additionalHeaders

    @JvmSynthetic
    internal fun getQueryParams(): QueryParams {
        val queryParams = QueryParams.builder()
        this.include?.let { queryParams.put("include[]", it.map(Any::toString)) }
        queryParams.putAll(additionalQueryParams)
        return queryParams.build()
    }

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> threadId
            1 -> runId
            2 -> stepId
            else -> ""
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var threadId: String? = null
        private var runId: String? = null
        private var stepId: String? = null
        private var include: MutableList<RunStepInclude>? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(betaThreadRunStepRetrieveParams: BetaThreadRunStepRetrieveParams) =
            apply {
                threadId = betaThreadRunStepRetrieveParams.threadId
                runId = betaThreadRunStepRetrieveParams.runId
                stepId = betaThreadRunStepRetrieveParams.stepId
                include = betaThreadRunStepRetrieveParams.include?.toMutableList()
                additionalHeaders = betaThreadRunStepRetrieveParams.additionalHeaders.toBuilder()
                additionalQueryParams =
                    betaThreadRunStepRetrieveParams.additionalQueryParams.toBuilder()
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

        /**
         * A list of additional fields to include in the response. Currently the only supported
         * value is `step_details.tool_calls[*].file_search.results[*].content` to fetch the file
         * search result content.
         *
         * See the
         * [file search tool documentation](https://platform.openai.com/docs/assistants/tools/file-search#customizing-file-search-settings)
         * for more information.
         */
        fun include(include: Optional<List<RunStepInclude>>) = include(include.orElse(null))

        /**
         * A list of additional fields to include in the response. Currently the only supported
         * value is `step_details.tool_calls[*].file_search.results[*].content` to fetch the file
         * search result content.
         *
         * See the
         * [file search tool documentation](https://platform.openai.com/docs/assistants/tools/file-search#customizing-file-search-settings)
         * for more information.
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

        fun build(): BetaThreadRunStepRetrieveParams =
            BetaThreadRunStepRetrieveParams(
                checkNotNull(threadId) { "`threadId` is required but was not set" },
                checkNotNull(runId) { "`runId` is required but was not set" },
                checkNotNull(stepId) { "`stepId` is required but was not set" },
                include?.toImmutable(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is BetaThreadRunStepRetrieveParams && threadId == other.threadId && runId == other.runId && stepId == other.stepId && include == other.include && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(threadId, runId, stepId, include, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "BetaThreadRunStepRetrieveParams{threadId=$threadId, runId=$runId, stepId=$stepId, include=$include, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
