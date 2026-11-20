package com.openai.helpers

import com.openai.client.OpenAIClient
import com.openai.core.ClientOptions
import com.openai.core.JsonValue
import com.openai.core.Params
import com.openai.core.RequestOptions
import com.openai.core.SecurityOptions
import com.openai.core.getPackageVersion
import com.openai.core.handlers.errorBodyHandler
import com.openai.core.handlers.errorHandler
import com.openai.core.http.Headers
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.QueryParams
import com.openai.core.http.json
import com.openai.core.prepare
import java.util.Collections

/**
 * Blocking requests to paths not yet exposed by generated services. Uses a snapshot of the supplied
 * client's configuration and its existing transport. The caller owns the client and must close
 * successful responses. Non-2xx responses use the SDK's normal exception mapping and are closed.
 *
 * Paths are unencoded resource paths relative to the configured base URL. Query values belong in
 * [Request.Builder.putQueryParam], not the path. There is no per-request destination override.
 */
class CustomRequests private constructor(private val options: ClientOptions) {
    private val errors = errorHandler(errorBodyHandler(options.jsonMapper))

    companion object {
        /** Capture configuration through the public client configuration hook. */
        @JvmStatic
        fun from(client: OpenAIClient): CustomRequests {
            var options: ClientOptions? = null
            client.withOptions { builder -> options = builder.build() }
            val captured = checkNotNull(options) { "Client did not provide its configuration" }
            val configured =
                if (captured.headers.names().any { it.equals("User-Agent", ignoreCase = true) })
                    captured
                else
                    captured
                        .toBuilder()
                        .defaultUserAgent(
                            "${client.javaClass.simpleName}/Java ${getPackageVersion()}"
                        )
                        .build()
            return CustomRequests(configured)
        }
    }

    /**
     * Sends a request using normal authentication, retry and timeout policy. Returns an unparsed
     * response whose body may be binary or streamed. Response schema validation does not apply.
     */
    @JvmOverloads
    fun execute(
        request: Request,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): HttpResponse {
        val httpRequest =
            HttpRequest.builder()
                .method(request.method)
                .baseUrl(options.baseUrl())
                .pathSegments(request.pathSegments)
                .apply { request.body?.let { body(json(options.jsonMapper, it)) } }
                .build()
                .prepare(options, request, request.securityOptions)
        return errors.handle(
            options.httpClient.execute(
                httpRequest,
                requestOptions.applyDefaults(RequestOptions.from(options)),
            )
        )
    }

    /** Immutable custom request; JSON bodies use [JsonValue] to retain arbitrary API fields. */
    class Request private constructor(builder: Builder) : Params {
        internal val method = checkNotNull(builder.method) { "method is required" }
        internal val pathSegments =
            Collections.unmodifiableList(
                ArrayList(checkNotNull(builder.pathSegments) { "path is required" })
            )
        internal val body = builder.body
        internal val securityOptions = builder.securityOptions
        private val headers = builder.headers.build()
        private val queryParams = builder.queryParams.build()

        override fun _headers(): Headers = headers

        override fun _queryParams(): QueryParams = queryParams

        companion object {
            @JvmStatic fun builder() = Builder()
        }

        class Builder internal constructor() {
            internal var method: HttpMethod? = null
            internal var pathSegments: List<String>? = null
            internal var body: JsonValue? = null
            internal var securityOptions = SecurityOptions.builder().bearerAuth(true).build()
            internal val headers = Headers.builder()
            internal val queryParams = QueryParams.builder()

            fun method(method: HttpMethod) = apply {
                require(method != HttpMethod.CONNECT && method != HttpMethod.TRACE) {
                    "CONNECT and TRACE are not supported"
                }
                this.method = method
            }

            /** An unencoded path, optionally starting with one slash; '/' targets the base URL. */
            fun path(path: String) = apply {
                require(
                    path.isNotEmpty() &&
                        !path.startsWith("//") &&
                        !path.contains(Regex("^[a-zA-Z][a-zA-Z0-9+.-]*:"))
                ) {
                    "Path must be relative to the configured base URL"
                }
                require(path.none { it == '?' || it == '#' || it == '\\' || it.isISOControl() }) {
                    "Path must not contain a query, fragment, backslash or control character"
                }
                val relative = path.removePrefix("/")
                val segments = if (relative.isEmpty()) emptyList() else relative.split('/')
                require(segments.none { it.isEmpty() || it == "." || it == ".." }) {
                    "Path must not contain empty or dot segments"
                }
                pathSegments = segments
            }

            /** A JSON value, including JsonValue.from(null) for an explicit JSON null body. */
            fun body(body: JsonValue) = apply { this.body = body }

            /** Authentication schemes for this endpoint. Defaults to ordinary bearer auth. */
            fun securityOptions(securityOptions: SecurityOptions) = apply {
                this.securityOptions = securityOptions
            }

            fun putHeader(name: String, value: String) = apply { headers.put(name, value) }

            fun putQueryParam(name: String, value: String) = apply { queryParams.put(name, value) }

            fun build(): Request {
                require(body == null || (method != HttpMethod.GET && method != HttpMethod.HEAD)) {
                    "GET and HEAD requests must not have a body"
                }
                return Request(this)
            }
        }
    }
}
