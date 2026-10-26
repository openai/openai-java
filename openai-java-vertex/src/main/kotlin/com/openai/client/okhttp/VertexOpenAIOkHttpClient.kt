package com.openai.client.okhttp

import com.fasterxml.jackson.databind.json.JsonMapper
import com.google.auth.oauth2.GoogleCredentials
import com.openai.client.OpenAIClient
import com.openai.core.LogLevel
import com.openai.core.Timeout
import com.openai.core.http.Headers
import com.openai.core.http.ProxyAuthenticator
import com.openai.vertex.VertexAuthenticator
import com.openai.vertex.vertexBaseUrl
import java.net.Proxy
import java.time.Duration
import java.util.concurrent.Executor
import java.util.function.Supplier

/** Configures the standard Responses client to use a Vertex project and Google credentials. */
class VertexOpenAIOkHttpClient private constructor() {

    companion object {
        @JvmStatic fun builder() = Builder()
    }

    class Builder internal constructor() {
        // Do not invoke fromEnv(): OpenAI API keys and project headers do not apply to Google.
        private val delegate = OpenAIOkHttpClient.builder().followRedirects(false)
        private var projectId: String? = null
        private var location: String? = null
        private var baseUrl: String? = null
        private var credentials: GoogleCredentials? = null
        private var tokenProvider: Supplier<String>? = null
        private var authenticationExecutor: Executor? = null

        /** Google project ID; defaults to GOOGLE_CLOUD_PROJECT. */
        fun projectId(projectId: String) = apply { this.projectId = projectId }

        /** Google Cloud location; defaults to GOOGLE_CLOUD_LOCATION. */
        fun location(location: String) = apply { this.location = location }

        /**
         * Full API root before /responses. When provided, projectId and location are not required.
         * Credentials are bound to this origin; use HTTPS to protect them in transit.
         */
        fun baseUrl(baseUrl: String) = apply { this.baseUrl = baseUrl }

        /** Uses caller-supplied credentials; otherwise resolves Application Default Credentials. */
        fun googleCredentials(credentials: GoogleCredentials) = apply {
            this.credentials = credentials
        }

        /**
         * Supplies an application-managed bearer token before every request attempt. The
         * application owns caching and refresh. The callback should respond to interruption when
         * authentication times out or the client closes. Requests fail if the default
         * authentication executor is saturated. Cannot be combined with googleCredentials.
         */
        fun tokenProvider(tokenProvider: Supplier<String>) = apply {
            this.tokenProvider = tokenProvider
        }

        /**
         * Uses a caller-owned executor for asynchronous authentication. The executor must dispatch
         * work off the calling thread. Synchronous requests use the client's bounded executor.
         */
        fun authenticationExecutor(executor: Executor) = apply {
            this.authenticationExecutor = executor
        }

        fun timeout(timeout: Timeout) = apply { delegate.timeout(timeout) }

        fun timeout(timeout: Duration) = apply { delegate.timeout(timeout) }

        fun maxRetries(maxRetries: Int) = apply { delegate.maxRetries(maxRetries) }

        fun proxy(proxy: Proxy?) = apply { delegate.proxy(proxy) }

        fun proxyAuthenticator(proxyAuthenticator: ProxyAuthenticator?) = apply {
            delegate.proxyAuthenticator(proxyAuthenticator)
        }

        fun jsonMapper(jsonMapper: JsonMapper) = apply { delegate.jsonMapper(jsonMapper) }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            delegate.streamHandlerExecutor(streamHandlerExecutor)
        }

        fun logLevel(logLevel: LogLevel) = apply { delegate.logLevel(logLevel) }

        fun headers(headers: Headers) = apply { delegate.headers(headers) }

        fun headers(headers: Map<String, Iterable<String>>) = apply { delegate.headers(headers) }

        fun putHeader(name: String, value: String) = apply { delegate.putHeader(name, value) }

        /** Returns a normal OpenAIClient. Use client.async() for async and streaming calls. */
        fun build(): OpenAIClient {
            require(credentials == null || tokenProvider == null) {
                "Set only one of googleCredentials and tokenProvider."
            }
            val resolvedBaseUrl =
                vertexBaseUrl(
                    baseUrl,
                    projectId ?: System.getenv("GOOGLE_CLOUD_PROJECT"),
                    location ?: System.getenv("GOOGLE_CLOUD_LOCATION"),
                )
            return delegate
                .baseUrl(resolvedBaseUrl)
                .httpRequestAuthenticator(
                    VertexAuthenticator(
                        resolvedBaseUrl,
                        credentials,
                        authenticationExecutor,
                        tokenProvider,
                    )
                )
                .build()
        }
    }
}
