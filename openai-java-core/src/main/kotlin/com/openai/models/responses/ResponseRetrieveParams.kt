// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.openai.core.Params
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Retrieves a model response with the given ID. */
class ResponseRetrieveParams
private constructor(
    private val responseId: String?,
    private val include: List<ResponseIncludable>?,
    private val includeObfuscation: Boolean?,
    private val startingAfter: Long?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun responseId(): Optional<String> = Optional.ofNullable(responseId)

    /**
     * Additional fields to include in the response. See the `include` parameter for Response
     * creation above for more information.
     */
    fun include(): Optional<List<ResponseIncludable>> = Optional.ofNullable(include)

    /**
     * When true, stream obfuscation will be enabled. Stream obfuscation adds random characters to
     * an `obfuscation` field on streaming delta events to normalize payload sizes as a mitigation
     * to certain side-channel attacks. These obfuscation fields are included by default, but add a
     * small amount of overhead to the data stream. You can set `include_obfuscation` to false to
     * optimize for bandwidth if you trust the network links between your application and the OpenAI
     * API.
     */
    fun includeObfuscation(): Optional<Boolean> = Optional.ofNullable(includeObfuscation)

    /** The sequence number of the event after which to start streaming. */
    fun startingAfter(): Optional<Long> = Optional.ofNullable(startingAfter)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): ResponseRetrieveParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [ResponseRetrieveParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseRetrieveParams]. */
    class Builder internal constructor() {

        private var responseId: String? = null
        private var include: MutableList<ResponseIncludable>? = null
        private var includeObfuscation: Boolean? = null
        private var startingAfter: Long? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(responseRetrieveParams: ResponseRetrieveParams) = apply {
            responseId = responseRetrieveParams.responseId
            include = responseRetrieveParams.include?.toMutableList()
            includeObfuscation = responseRetrieveParams.includeObfuscation
            startingAfter = responseRetrieveParams.startingAfter
            additionalHeaders = responseRetrieveParams.additionalHeaders.toBuilder()
            additionalQueryParams = responseRetrieveParams.additionalQueryParams.toBuilder()
        }

        fun responseId(responseId: String?) = apply { this.responseId = responseId }

        /** Alias for calling [Builder.responseId] with `responseId.orElse(null)`. */
        fun responseId(responseId: Optional<String>) = responseId(responseId.getOrNull())

        /**
         * Additional fields to include in the response. See the `include` parameter for Response
         * creation above for more information.
         */
        fun include(include: List<ResponseIncludable>?) = apply {
            this.include = include?.toMutableList()
        }

        /** Alias for calling [Builder.include] with `include.orElse(null)`. */
        fun include(include: Optional<List<ResponseIncludable>>) = include(include.getOrNull())

        /**
         * Adds a single [ResponseIncludable] to [Builder.include].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addInclude(include: ResponseIncludable) = apply {
            this.include = (this.include ?: mutableListOf()).apply { add(include) }
        }

        /**
         * When true, stream obfuscation will be enabled. Stream obfuscation adds random characters
         * to an `obfuscation` field on streaming delta events to normalize payload sizes as a
         * mitigation to certain side-channel attacks. These obfuscation fields are included by
         * default, but add a small amount of overhead to the data stream. You can set
         * `include_obfuscation` to false to optimize for bandwidth if you trust the network links
         * between your application and the OpenAI API.
         */
        fun includeObfuscation(includeObfuscation: Boolean?) = apply {
            this.includeObfuscation = includeObfuscation
        }

        /**
         * Alias for [Builder.includeObfuscation].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun includeObfuscation(includeObfuscation: Boolean) =
            includeObfuscation(includeObfuscation as Boolean?)

        /**
         * Alias for calling [Builder.includeObfuscation] with `includeObfuscation.orElse(null)`.
         */
        fun includeObfuscation(includeObfuscation: Optional<Boolean>) =
            includeObfuscation(includeObfuscation.getOrNull())

        /** The sequence number of the event after which to start streaming. */
        fun startingAfter(startingAfter: Long?) = apply { this.startingAfter = startingAfter }

        /**
         * Alias for [Builder.startingAfter].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun startingAfter(startingAfter: Long) = startingAfter(startingAfter as Long?)

        /** Alias for calling [Builder.startingAfter] with `startingAfter.orElse(null)`. */
        fun startingAfter(startingAfter: Optional<Long>) = startingAfter(startingAfter.getOrNull())

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
         * Returns an immutable instance of [ResponseRetrieveParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ResponseRetrieveParams =
            ResponseRetrieveParams(
                responseId,
                include?.toImmutable(),
                includeObfuscation,
                startingAfter,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> responseId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                include?.forEach { put("include[]", it.toString()) }
                includeObfuscation?.let { put("include_obfuscation", it.toString()) }
                startingAfter?.let { put("starting_after", it.toString()) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ResponseRetrieveParams &&
            responseId == other.responseId &&
            include == other.include &&
            includeObfuscation == other.includeObfuscation &&
            startingAfter == other.startingAfter &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            responseId,
            include,
            includeObfuscation,
            startingAfter,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "ResponseRetrieveParams{responseId=$responseId, include=$include, includeObfuscation=$includeObfuscation, startingAfter=$startingAfter, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
