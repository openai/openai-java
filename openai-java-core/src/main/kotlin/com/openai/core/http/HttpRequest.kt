package com.openai.core.http

import com.openai.core.checkRequired
import com.openai.core.toImmutable

class HttpRequest
private constructor(
    @get:JvmName("method") val method: HttpMethod,
    @get:JvmName("baseUrl") val baseUrl: String,
    @get:JvmName("pathSegments") val pathSegments: List<String>,
    @get:JvmName("headers") val headers: Headers,
    @get:JvmName("queryParams") val queryParams: QueryParams,
    @get:JvmName("body") val body: HttpRequestBody?,
) {

    fun toBuilder(): Builder = Builder().from(this)

    override fun toString(): String =
        "HttpRequest{method=$method, baseUrl=$baseUrl, pathSegments=$pathSegments, headers=$headers, queryParams=$queryParams, body=$body}"

    companion object {
        @JvmStatic fun builder() = Builder()
    }

    class Builder internal constructor() {

        private var method: HttpMethod? = null
        private var baseUrl: String? = null
        private var pathSegments: MutableList<String> = mutableListOf()
        private var headers: Headers.Builder = Headers.builder()
        private var queryParams: QueryParams.Builder = QueryParams.builder()
        private var body: HttpRequestBody? = null

        @JvmSynthetic
        internal fun from(request: HttpRequest) = apply {
            method = request.method
            baseUrl = request.baseUrl
            pathSegments = request.pathSegments.toMutableList()
            headers = request.headers.toBuilder()
            queryParams = request.queryParams.toBuilder()
            body = request.body
        }

        fun method(method: HttpMethod) = apply { this.method = method }

        fun baseUrl(baseUrl: String) = apply { this.baseUrl = baseUrl }

        fun pathSegments(pathSegments: List<String>) = apply {
            this.pathSegments = pathSegments.toMutableList()
        }

        fun addPathSegment(pathSegment: String) = apply { pathSegments.add(pathSegment) }

        fun addPathSegments(vararg pathSegments: String) = apply {
            this.pathSegments.addAll(pathSegments)
        }

        fun headers(headers: Headers) = apply {
            this.headers.clear()
            putAllheaders(headers)
        }

        fun headers(headers: Map<String, Iterable<String>>) = apply {
            this.headers.clear()
            putAllheaders(headers)
        }

        fun putHeader(name: String, value: String) = apply { headers.put(name, value) }

        fun putheaders(name: String, values: Iterable<String>) = apply { headers.put(name, values) }

        fun putAllheaders(headers: Headers) = apply { this.headers.putAll(headers) }

        fun putAllheaders(headers: Map<String, Iterable<String>>) = apply {
            this.headers.putAll(headers)
        }

        fun replaceheaders(name: String, value: String) = apply { headers.replace(name, value) }

        fun replaceheaders(name: String, values: Iterable<String>) = apply {
            headers.replace(name, values)
        }

        fun replaceAllheaders(headers: Headers) = apply { this.headers.replaceAll(headers) }

        fun replaceAllheaders(headers: Map<String, Iterable<String>>) = apply {
            this.headers.replaceAll(headers)
        }

        fun removeheaders(name: String) = apply { headers.remove(name) }

        fun removeAllheaders(names: Set<String>) = apply { headers.removeAll(names) }

        fun queryParams(queryParams: QueryParams) = apply {
            this.queryParams.clear()
            putAllquery_params(queryParams)
        }

        fun queryParams(queryParams: Map<String, Iterable<String>>) = apply {
            this.queryParams.clear()
            putAllquery_params(queryParams)
        }

        fun putQueryParam(key: String, value: String) = apply { queryParams.put(key, value) }

        fun putquery_params(key: String, values: Iterable<String>) = apply {
            queryParams.put(key, values)
        }

        fun putAllquery_params(queryParams: QueryParams) = apply {
            this.queryParams.putAll(queryParams)
        }

        fun putAllquery_params(queryParams: Map<String, Iterable<String>>) = apply {
            this.queryParams.putAll(queryParams)
        }

        fun replacequery_params(key: String, value: String) = apply {
            queryParams.replace(key, value)
        }

        fun replacequery_params(key: String, values: Iterable<String>) = apply {
            queryParams.replace(key, values)
        }

        fun replaceAllquery_params(queryParams: QueryParams) = apply {
            this.queryParams.replaceAll(queryParams)
        }

        fun replaceAllquery_params(queryParams: Map<String, Iterable<String>>) = apply {
            this.queryParams.replaceAll(queryParams)
        }

        fun removequery_params(key: String) = apply { queryParams.remove(key) }

        fun removeAllquery_params(keys: Set<String>) = apply { queryParams.removeAll(keys) }

        fun body(body: HttpRequestBody) = apply { this.body = body }

        fun build(): HttpRequest =
            HttpRequest(
                checkRequired("method", method),
                checkRequired("baseUrl", baseUrl),
                pathSegments.toImmutable(),
                headers.build(),
                queryParams.build(),
                body,
            )
    }
}
