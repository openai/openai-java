// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.core.NoAutoDetect
import com.openai.core.Params
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/** Returns a list of vector store files in a batch. */
class BetaVectorStoreFileBatchListFilesParams
private constructor(
    private val vectorStoreId: String,
    private val batchId: String,
    private val after: String?,
    private val before: String?,
    private val filter: Filter?,
    private val limit: Long?,
    private val order: Order?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

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

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams {
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

    /** A builder for [BetaVectorStoreFileBatchListFilesParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

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

        /** Filter by file status. One of `in_progress`, `completed`, `failed`, `cancelled`. */
        fun filter(filter: Filter?) = apply { this.filter = filter }

        /** Filter by file status. One of `in_progress`, `completed`, `failed`, `cancelled`. */
        fun filter(filter: Optional<Filter>) = filter(filter.orElse(null))

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

        fun build(): BetaVectorStoreFileBatchListFilesParams =
            BetaVectorStoreFileBatchListFilesParams(
                checkRequired("vectorStoreId", vectorStoreId),
                checkRequired("batchId", batchId),
                after,
                before,
                filter,
                limit,
                order,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    /** Filter by file status. One of `in_progress`, `completed`, `failed`, `cancelled`. */
    class Filter
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val IN_PROGRESS = of("in_progress")

            @JvmField val COMPLETED = of("completed")

            @JvmField val FAILED = of("failed")

            @JvmField val CANCELLED = of("cancelled")

            @JvmStatic fun of(value: String) = Filter(JsonField.of(value))
        }

        /** An enum containing [Filter]'s known values. */
        enum class Known {
            IN_PROGRESS,
            COMPLETED,
            FAILED,
            CANCELLED,
        }

        /**
         * An enum containing [Filter]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Filter] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            IN_PROGRESS,
            COMPLETED,
            FAILED,
            CANCELLED,
            /** An enum member indicating that [Filter] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                IN_PROGRESS -> Value.IN_PROGRESS
                COMPLETED -> Value.COMPLETED
                FAILED -> Value.FAILED
                CANCELLED -> Value.CANCELLED
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws OpenAIInvalidDataException if this class instance's value is a not a known
         *   member.
         */
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

    /**
     * Sort order by the `created_at` timestamp of the objects. `asc` for ascending order and `desc`
     * for descending order.
     */
    class Order
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val ASC = of("asc")

            @JvmField val DESC = of("desc")

            @JvmStatic fun of(value: String) = Order(JsonField.of(value))
        }

        /** An enum containing [Order]'s known values. */
        enum class Known {
            ASC,
            DESC,
        }

        /**
         * An enum containing [Order]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Order] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            ASC,
            DESC,
            /** An enum member indicating that [Order] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                ASC -> Value.ASC
                DESC -> Value.DESC
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws OpenAIInvalidDataException if this class instance's value is a not a known
         *   member.
         */
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
