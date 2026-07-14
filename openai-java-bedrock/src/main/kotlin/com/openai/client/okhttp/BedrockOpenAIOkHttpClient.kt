package com.openai.client.okhttp

import com.fasterxml.jackson.databind.json.JsonMapper
import com.openai.bedrock.BedrockAuthOptions
import com.openai.bedrock.resolve
import com.openai.client.OpenAIClient
import com.openai.core.LogLevel
import com.openai.core.Sleeper
import com.openai.core.Timeout
import com.openai.core.http.Headers
import com.openai.core.http.ProxyAuthenticator
import com.openai.core.http.QueryParams
import java.net.Proxy
import java.time.Clock
import java.time.Duration
import java.util.Optional
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.function.Supplier
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.X509TrustManager
import kotlin.jvm.optionals.getOrNull
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider
import software.amazon.awssdk.regions.Region

/**
 * Builds an [OpenAIClient] configured for OpenAI-compatible APIs on Amazon Bedrock.
 *
 * By default, authentication follows the normal AWS credential provider chain, including
 * environment variables, shared credentials and config files, named profiles, workload credentials,
 * and instance metadata. Requests are signed with AWS SigV4 on every attempt.
 */
class BedrockOpenAIOkHttpClient private constructor() {

    companion object {
        /** Returns a mutable builder for constructing a Bedrock client. */
        @JvmStatic fun builder() = Builder()

        /** Builds a client using the standard AWS credential and region provider chains. */
        @JvmStatic fun fromEnv(): OpenAIClient = builder().build()
    }

    class Builder internal constructor() {
        private val delegate = OpenAIOkHttpClient.builder().followRedirects(false)

        private var awsRegion: String? = null
        private var baseUrl: String? = null
        private var apiKey: String? = null
        private var tokenProvider: Supplier<String>? = null
        private var awsAccessKeyId: String? = null
        private var awsSecretAccessKey: String? = null
        private var awsSessionToken: String? = null
        private var awsProfile: String? = null
        private var awsCredentialsProvider: AwsCredentialsProvider? = null
        private var skipAuth: Boolean = false
        private var clock: Clock = Clock.systemUTC()

        /** Sets the AWS region used for endpoint resolution and SigV4 signing. */
        fun awsRegion(awsRegion: String?) = apply { this.awsRegion = awsRegion }

        /** Sets the AWS region used for endpoint resolution and SigV4 signing. */
        fun awsRegion(awsRegion: Region) = awsRegion(awsRegion.id())

        /** Alias for calling [awsRegion] with `awsRegion.orElse(null)`. */
        fun awsRegion(awsRegion: Optional<String>) = awsRegion(awsRegion.getOrNull())

        /**
         * Overrides the Bedrock API root. Defaults to `AWS_BEDROCK_BASE_URL`, then the regional
         * `https://bedrock-mantle.{region}.api.aws/openai/v1` endpoint.
         */
        fun baseUrl(baseUrl: String?) = apply { this.baseUrl = baseUrl }

        /** Alias for calling [baseUrl] with `baseUrl.orElse(null)`. */
        fun baseUrl(baseUrl: Optional<String>) = baseUrl(baseUrl.getOrNull())

        /** Uses an explicit Bedrock bearer credential instead of AWS SigV4. */
        fun apiKey(apiKey: String?) = apply { this.apiKey = apiKey }

        /** Alias for calling [apiKey] with `apiKey.orElse(null)`. */
        fun apiKey(apiKey: Optional<String>) = apiKey(apiKey.getOrNull())

        /** Resolves a fresh Bedrock bearer credential before every request attempt. */
        fun bedrockTokenProvider(tokenProvider: Supplier<String>) = apply {
            this.tokenProvider = tokenProvider
        }

        /** Sets an explicit AWS access key ID. Must be paired with [awsSecretAccessKey]. */
        fun awsAccessKeyId(awsAccessKeyId: String?) = apply { this.awsAccessKeyId = awsAccessKeyId }

        /** Sets an explicit AWS secret access key. Must be paired with [awsAccessKeyId]. */
        fun awsSecretAccessKey(awsSecretAccessKey: String?) = apply {
            this.awsSecretAccessKey = awsSecretAccessKey
        }

        /** Sets an optional session token for explicit temporary AWS credentials. */
        fun awsSessionToken(awsSessionToken: String?) = apply {
            this.awsSessionToken = awsSessionToken
        }

        /** Resolves AWS credentials from a named shared-config profile. */
        fun awsProfile(awsProfile: String?) = apply { this.awsProfile = awsProfile }

        /**
         * Uses a custom, refreshable AWS credentials provider. The caller retains ownership of the
         * provider and is responsible for closing it when it is no longer needed.
         */
        fun awsCredentialsProvider(awsCredentialsProvider: AwsCredentialsProvider) = apply {
            this.awsCredentialsProvider = awsCredentialsProvider
        }

        /**
         * Skips Bedrock authentication. This is intended for proxies or tests that authenticate
         * requests outside this SDK.
         */
        fun skipAuth(skipAuth: Boolean) = apply { this.skipAuth = skipAuth }

        fun dispatcherExecutorService(dispatcherExecutorService: ExecutorService?) = apply {
            delegate.dispatcherExecutorService(dispatcherExecutorService)
        }

        fun proxy(proxy: Proxy?) = apply { delegate.proxy(proxy) }

        fun proxyAuthenticator(proxyAuthenticator: ProxyAuthenticator?) = apply {
            delegate.proxyAuthenticator(proxyAuthenticator)
        }

        fun maxIdleConnections(maxIdleConnections: Int?) = apply {
            delegate.maxIdleConnections(maxIdleConnections)
        }

        fun keepAliveDuration(keepAliveDuration: Duration?) = apply {
            delegate.keepAliveDuration(keepAliveDuration)
        }

        fun sslSocketFactory(sslSocketFactory: SSLSocketFactory?) = apply {
            delegate.sslSocketFactory(sslSocketFactory)
        }

        fun trustManager(trustManager: X509TrustManager?) = apply {
            delegate.trustManager(trustManager)
        }

        fun hostnameVerifier(hostnameVerifier: HostnameVerifier?) = apply {
            delegate.hostnameVerifier(hostnameVerifier)
        }

        fun checkJacksonVersionCompatibility(check: Boolean) = apply {
            delegate.checkJacksonVersionCompatibility(check)
        }

        fun jsonMapper(jsonMapper: JsonMapper) = apply { delegate.jsonMapper(jsonMapper) }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            delegate.streamHandlerExecutor(streamHandlerExecutor)
        }

        fun sleeper(sleeper: Sleeper) = apply { delegate.sleeper(sleeper) }

        fun clock(clock: Clock) = apply {
            this.clock = clock
            delegate.clock(clock)
        }

        fun responseValidation(responseValidation: Boolean) = apply {
            delegate.responseValidation(responseValidation)
        }

        fun timeout(timeout: Timeout) = apply { delegate.timeout(timeout) }

        fun timeout(timeout: Duration) = apply { delegate.timeout(timeout) }

        fun maxRetries(maxRetries: Int) = apply { delegate.maxRetries(maxRetries) }

        fun logLevel(logLevel: LogLevel) = apply { delegate.logLevel(logLevel) }

        fun headers(headers: Headers) = apply { delegate.headers(headers) }

        fun headers(headers: Map<String, Iterable<String>>) = apply { delegate.headers(headers) }

        fun putHeader(name: String, value: String) = apply { delegate.putHeader(name, value) }

        fun putHeaders(name: String, values: Iterable<String>) = apply {
            delegate.putHeaders(name, values)
        }

        fun putAllHeaders(headers: Headers) = apply { delegate.putAllHeaders(headers) }

        fun replaceHeaders(name: String, value: String) = apply {
            delegate.replaceHeaders(name, value)
        }

        fun removeHeaders(name: String) = apply { delegate.removeHeaders(name) }

        fun queryParams(queryParams: QueryParams) = apply { delegate.queryParams(queryParams) }

        fun queryParams(queryParams: Map<String, Iterable<String>>) = apply {
            delegate.queryParams(queryParams)
        }

        fun putQueryParam(key: String, value: String) = apply { delegate.putQueryParam(key, value) }

        fun putQueryParams(key: String, values: Iterable<String>) = apply {
            delegate.putQueryParams(key, values)
        }

        fun removeQueryParams(key: String) = apply { delegate.removeQueryParams(key) }

        /** Returns a standard OpenAI client configured for Amazon Bedrock. */
        fun build(): OpenAIClient {
            val configuration =
                BedrockAuthOptions(
                        awsRegion = awsRegion,
                        baseUrl = baseUrl,
                        apiKey = apiKey,
                        tokenProvider = tokenProvider,
                        awsAccessKeyId = awsAccessKeyId,
                        awsSecretAccessKey = awsSecretAccessKey,
                        awsSessionToken = awsSessionToken,
                        awsProfile = awsProfile,
                        awsCredentialsProvider = awsCredentialsProvider,
                        skipAuth = skipAuth,
                        clock = clock,
                    )
                    .resolve(::getEnv)

            return delegate
                .baseUrl(configuration.baseUrl)
                .httpRequestAuthenticator(configuration.authenticator)
                .build()
        }

        @JvmSynthetic internal fun getEnv(name: String): String? = System.getenv(name)
    }
}
