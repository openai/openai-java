// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.core.NoAutoDetect
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/** Returns a list of run steps belonging to a run. */
class BetaThreadRunStepListParams
constructor(
    private val threadId: String,
    private val runId: String,
    private val after: String?,
    private val before: String?,
    private val include: List<RunStepInclude>?,
    private val limit: Long?,
    private val order: Order?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) {

    fun threadId(): String = threadId

    fun runId(): String = runId

    /**
     * A cursor for use in pagination. `after` is an object ID that defines your place in the list.
     * For instance, if you make a list request and receive 100 objects, ending with obj_foo, your
     * subsequent call can include after=obj_foo in order to fetch the next page of the list.
     */
    fun after(): Optional<String> = Optional.ofNullable(after)

    /**
     * A cursor for use in pagination. `before` is an object ID that defines your place in the list.
     * For instance, if you make a list request and receive 100 objects, starting with obj_foo, your
     * subsequent call can include before=obj_foo in order to fetch the previous page of the list.
     */
    fun before(): Optional<String> = Optional.ofNullable(before)

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

    /**
     * A limit on the number of objects to be returned. Limit can range between 1 and 100, and the
     * default is 20.
     */
    fun limit(): Optional<Long> = Optional.ofNullable(limit)

    /**
     * Sort order by the `created_at` timestamp of the objects. `asc` for ascending order and `desc`
     * for descending order.
     */
    fun order(): Optional<Order> = Optional.ofNullable(order)

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic internal fun getHeaders(): Headers = additionalHeaders

    @JvmSynthetic
    internal fun getQueryParams(): QueryParams {
        val queryParams = QueryParams.builder()
        this.after?.let { queryParams.put("after", listOf(it.toString())) }
        this.before?.let { queryParams.put("before", listOf(it.toString())) }
        this.include?.let { queryParams.put("include[]", it.map(Any::toString)) }
        this.limit?.let { queryParams.put("limit", listOf(it.toString())) }
        this.order?.let { queryParams.put("order", listOf(it.toString())) }
        queryParams.putAll(additionalQueryParams)
        return queryParams.build()
    }

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> threadId
            1 -> runId
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
        private var after: String? = null
        private var before: String? = null
        private var include: MutableList<RunStepInclude>? = null
        private var limit: Long? = null
        private var order: Order? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(betaThreadRunStepListParams: BetaThreadRunStepListParams) = apply {
            threadId = betaThreadRunStepListParams.threadId
            runId = betaThreadRunStepListParams.runId
            after = betaThreadRunStepListParams.after
            before = betaThreadRunStepListParams.before
            include = betaThreadRunStepListParams.include?.toMutableList()
            limit = betaThreadRunStepListParams.limit
            order = betaThreadRunStepListParams.order
            additionalHeaders = betaThreadRunStepListParams.additionalHeaders.toBuilder()
            additionalQueryParams = betaThreadRunStepListParams.additionalQueryParams.toBuilder()
        }

        fun threadId(threadId: String) = apply { this.threadId = threadId }

        fun runId(runId: String) = apply { this.runId = runId }

        /**
         * A cursor for use in pagination. `after` is an object ID that defines your place in the
         * list. For instance, if you make a list request and receive 100 objects, ending with
         * obj_foo, your subsequent call can include after=obj_foo in order to fetch the next page
         * of the list.
         */
        fun after(after: String?) = apply { this.after = after }

        /**
         * A cursor for use in pagination. `after` is an object ID that defines your place in the
         * list. For instance, if you make a list request and receive 100 objects, ending with
         * obj_foo, your subsequent call can include after=obj_foo in order to fetch the next page
         * of the list.
         */
        fun after(after: Optional<String>) = after(after.orElse(null))

        /**
         * A cursor for use in pagination. `before` is an object ID that defines your place in the
         * list. For instance, if you make a list request and receive 100 objects, starting with
         * obj_foo, your subsequent call can include before=obj_foo in order to fetch the previous
         * page of the list.
         */
        fun before(before: String?) = apply { this.before = before }

        /**
         * A cursor for use in pagination. `before` is an object ID that defines your place in the
         * list. For instance, if you make a list request and receive 100 objects, starting with
         * obj_foo, your subsequent call can include before=obj_foo in order to fetch the previous
         * page of the list.
         */
        fun before(before: Optional<String>) = before(before.orElse(null))

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

        /**
         * A limit on the number of objects to be returned. Limit can range between 1 and 100, and
         * the default is 20.
         */
        fun limit(limit: Long?) = apply { this.limit = limit }

        /**
         * A limit on the number of objects to be returned. Limit can range between 1 and 100, and
         * the default is 20.
         */
        fun limit(limit: Long) = limit(limit as Long?)

        /**
         * A limit on the number of objects to be returned. Limit can range between 1 and 100, and
         * the default is 20.
         */
        @Suppress("USELESS_CAST") // See https://youtrack.jetbrains.com/issue/KT-74228
        fun limit(limit: Optional<Long>) = limit(limit.orElse(null) as Long?)

        /**
         * Sort order by the `created_at` timestamp of the objects. `asc` for ascending order and
         * `desc` for descending order.
         */
        fun order(order: Order?) = apply { this.order = order }

        /**
         * Sort order by the `created_at` timestamp of the objects. `asc` for ascending order and
         * `desc` for descending order.
         */
        fun order(order: Optional<Order>) = order(order.orElse(null))

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

        fun build(): BetaThreadRunStepListParams =
            BetaThreadRunStepListParams(
                checkNotNull(threadId) { "`threadId` is required but was not set" },
                checkNotNull(runId) { "`runId` is required but was not set" },
                after,
                before,
                include?.toImmutable(),
                limit,
                order,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    class Order
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val ASC = of("asc")

            @JvmField val DESC = of("desc")

            @JvmStatic fun of(value: String) = Order(JsonField.of(value))
        }

        enum class Known {
            ASC,
            DESC,
        }

        enum class Value {
            ASC,
            DESC,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                ASC -> Value.ASC
                DESC -> Value.DESC
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                ASC -> Known.ASC
                DESC -> Known.DESC
                else -> throw OpenAIInvalidDataException("Unknown Order: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Order && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is BetaThreadRunStepListParams && threadId == other.threadId && runId == other.runId && after == other.after && before == other.before && include == other.include && limit == other.limit && order == other.order && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(threadId, runId, after, before, include, limit, order, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "BetaThreadRunStepListParams{threadId=$threadId, runId=$runId, after=$after, before=$before, include=$include, limit=$limit, order=$order, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
