// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.core.NoAutoDetect
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

class BetaVectorStoreFileBatchListFilesParams
constructor(
    private val vectorStoreId: String,
    private val batchId: String,
    private val after: String?,
    private val before: String?,
    private val filter: Filter?,
    private val limit: Long?,
    private val order: Order?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) {

    fun vectorStoreId(): String = vectorStoreId

    fun batchId(): String = batchId

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

    /** Filter by file status. One of `in_progress`, `completed`, `failed`, `cancelled`. */
    fun filter(): Optional<Filter> = Optional.ofNullable(filter)

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
        this.filter?.let { queryParams.put("filter", listOf(it.toString())) }
        this.limit?.let { queryParams.put("limit", listOf(it.toString())) }
        this.order?.let { queryParams.put("order", listOf(it.toString())) }
        queryParams.putAll(additionalQueryParams)
        return queryParams.build()
    }

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> vectorStoreId
            1 -> batchId
            else -> ""
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var vectorStoreId: String? = null
        private var batchId: String? = null
        private var after: String? = null
        private var before: String? = null
        private var filter: Filter? = null
        private var limit: Long? = null
        private var order: Order? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(
            betaVectorStoreFileBatchListFilesParams: BetaVectorStoreFileBatchListFilesParams
        ) = apply {
            vectorStoreId = betaVectorStoreFileBatchListFilesParams.vectorStoreId
            batchId = betaVectorStoreFileBatchListFilesParams.batchId
            after = betaVectorStoreFileBatchListFilesParams.after
            before = betaVectorStoreFileBatchListFilesParams.before
            filter = betaVectorStoreFileBatchListFilesParams.filter
            limit = betaVectorStoreFileBatchListFilesParams.limit
            order = betaVectorStoreFileBatchListFilesParams.order
            additionalHeaders =
                betaVectorStoreFileBatchListFilesParams.additionalHeaders.toBuilder()
            additionalQueryParams =
                betaVectorStoreFileBatchListFilesParams.additionalQueryParams.toBuilder()
        }

        fun vectorStoreId(vectorStoreId: String) = apply { this.vectorStoreId = vectorStoreId }

        fun batchId(batchId: String) = apply { this.batchId = batchId }

        /**
         * A cursor for use in pagination. `after` is an object ID that defines your place in the
         * list. For instance, if you make a list request and receive 100 objects, ending with
         * obj_foo, your subsequent call can include after=obj_foo in order to fetch the next page
         * of the list.
         */
        fun after(after: String) = apply { this.after = after }

        /**
         * A cursor for use in pagination. `before` is an object ID that defines your place in the
         * list. For instance, if you make a list request and receive 100 objects, starting with
         * obj_foo, your subsequent call can include before=obj_foo in order to fetch the previous
         * page of the list.
         */
        fun before(before: String) = apply { this.before = before }

        /** Filter by file status. One of `in_progress`, `completed`, `failed`, `cancelled`. */
        fun filter(filter: Filter) = apply { this.filter = filter }

        /**
         * A limit on the number of objects to be returned. Limit can range between 1 and 100, and
         * the default is 20.
         */
        fun limit(limit: Long) = apply { this.limit = limit }

        /**
         * Sort order by the `created_at` timestamp of the objects. `asc` for ascending order and
         * `desc` for descending order.
         */
        fun order(order: Order) = apply { this.order = order }

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

        fun build(): BetaVectorStoreFileBatchListFilesParams =
            BetaVectorStoreFileBatchListFilesParams(
                checkNotNull(vectorStoreId) { "`vectorStoreId` is required but was not set" },
                checkNotNull(batchId) { "`batchId` is required but was not set" },
                after,
                before,
                filter,
                limit,
                order,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    class Filter
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val IN_PROGRESS = of("in_progress")

            @JvmField val COMPLETED = of("completed")

            @JvmField val FAILED = of("failed")

            @JvmField val CANCELLED = of("cancelled")

            @JvmStatic fun of(value: String) = Filter(JsonField.of(value))
        }

        enum class Known {
            IN_PROGRESS,
            COMPLETED,
            FAILED,
            CANCELLED,
        }

        enum class Value {
            IN_PROGRESS,
            COMPLETED,
            FAILED,
            CANCELLED,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                IN_PROGRESS -> Value.IN_PROGRESS
                COMPLETED -> Value.COMPLETED
                FAILED -> Value.FAILED
                CANCELLED -> Value.CANCELLED
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                IN_PROGRESS -> Known.IN_PROGRESS
                COMPLETED -> Known.COMPLETED
                FAILED -> Known.FAILED
                CANCELLED -> Known.CANCELLED
                else -> throw OpenAIInvalidDataException("Unknown Filter: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Filter && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
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

        return /* spotless:off */ other is BetaVectorStoreFileBatchListFilesParams && vectorStoreId == other.vectorStoreId && batchId == other.batchId && after == other.after && before == other.before && filter == other.filter && limit == other.limit && order == other.order && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(vectorStoreId, batchId, after, before, filter, limit, order, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "BetaVectorStoreFileBatchListFilesParams{vectorStoreId=$vectorStoreId, batchId=$batchId, after=$after, before=$before, filter=$filter, limit=$limit, order=$order, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}