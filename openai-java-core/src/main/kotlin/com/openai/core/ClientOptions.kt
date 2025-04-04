// File generated from our OpenAPI spec by Stainless.

package com.openai.core

import com.fasterxml.jackson.databind.json.JsonMapper
import com.openai.azure.AzureOpenAIServiceVersion
import com.openai.azure.credential.AzureApiKeyCredential
import com.openai.core.http.Headers
import com.openai.core.http.HttpClient
import com.openai.core.http.PhantomReachableClosingHttpClient
import com.openai.core.http.QueryParams
import com.openai.core.http.RetryingHttpClient
import com.openai.credential.BearerTokenCredential
import com.openai.credential.Credential
import java.time.Clock
import java.util.Optional
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.ThreadFactory
import java.util.concurrent.atomic.AtomicLong
import kotlin.jvm.optionals.getOrNull

class ClientOptions
private constructor(
    private val originalHttpClient: HttpClient,
    @get:JvmName("httpClient") val httpClient: HttpClient,
    @get:JvmName("checkJacksonVersionCompatibility") val checkJacksonVersionCompatibility: Boolean,
    @get:JvmName("jsonMapper") val jsonMapper: JsonMapper,
    @get:JvmName("streamHandlerExecutor") val streamHandlerExecutor: Executor,
    @get:JvmName("clock") val clock: Clock,
    @get:JvmName("baseUrl") val baseUrl: String,
    @get:JvmName("headers") val headers: Headers,
    @get:JvmName("queryParams") val queryParams: QueryParams,
    @get:JvmName("responseValidation") val responseValidation: Boolean,
    @get:JvmName("timeout") val timeout: Timeout,
    @get:JvmName("maxRetries") val maxRetries: Int,
    @get:JvmName("credential") val credential: Credential,
    @get:JvmName("azureServiceVersion") val azureServiceVersion: AzureOpenAIServiceVersion?,
    private val organization: String?,
    private val project: String?,
) {

    init {
        if (checkJacksonVersionCompatibility) {
            checkJacksonVersionCompatibility()
        }
    }

    fun organization(): Optional<String> = Optional.ofNullable(organization)

    fun project(): Optional<String> = Optional.ofNullable(project)

    fun toBuilder() = Builder().from(this)

    companion object {

        const val PRODUCTION_URL = "https://api.openai.com/v1"

        /**
         * Returns a mutable builder for constructing an instance of [ClientOptions].
         *
         * The following fields are required:
         * ```java
         * .httpClient()
         * .apiKey()
         * ```
         */
        @JvmStatic fun builder() = Builder()

        @JvmStatic fun fromEnv(): ClientOptions = builder().fromEnv().build()
    }

    /** A builder for [ClientOptions]. */
    class Builder internal constructor() {

        private var httpClient: HttpClient? = null
        private var checkJacksonVersionCompatibility: Boolean = true
        private var jsonMapper: JsonMapper = jsonMapper()
        private var streamHandlerExecutor: Executor? = null
        private var clock: Clock = Clock.systemUTC()
        private var baseUrl: String = PRODUCTION_URL
        private var headers: Headers.Builder = Headers.builder()
        private var queryParams: QueryParams.Builder = QueryParams.builder()
        private var responseValidation: Boolean = false
        private var timeout: Timeout = Timeout.default()
        private var maxRetries: Int = 2
        private var credential: Credential? = null
        private var azureServiceVersion: AzureOpenAIServiceVersion? = null
        private var organization: String? = null
        private var project: String? = null

        @JvmSynthetic
        internal fun from(clientOptions: ClientOptions) = apply {
            httpClient = clientOptions.originalHttpClient
            checkJacksonVersionCompatibility = clientOptions.checkJacksonVersionCompatibility
            jsonMapper = clientOptions.jsonMapper
            streamHandlerExecutor = clientOptions.streamHandlerExecutor
            clock = clientOptions.clock
            baseUrl = clientOptions.baseUrl
            headers = clientOptions.headers.toBuilder()
            queryParams = clientOptions.queryParams.toBuilder()
            responseValidation = clientOptions.responseValidation
            timeout = clientOptions.timeout
            maxRetries = clientOptions.maxRetries
            credential = clientOptions.credential
            azureServiceVersion = clientOptions.azureServiceVersion
            organization = clientOptions.organization
            project = clientOptions.project
        }

        fun httpClient(httpClient: HttpClient) = apply { this.httpClient = httpClient }

        fun checkJacksonVersionCompatibility(checkJacksonVersionCompatibility: Boolean) = apply {
            this.checkJacksonVersionCompatibility = checkJacksonVersionCompatibility
        }

        fun jsonMapper(jsonMapper: JsonMapper) = apply { this.jsonMapper = jsonMapper }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        fun clock(clock: Clock) = apply { this.clock = clock }

        fun baseUrl(baseUrl: String) = apply { this.baseUrl = baseUrl }

        fun responseValidation(responseValidation: Boolean) = apply {
            this.responseValidation = responseValidation
        }

        fun timeout(timeout: Timeout) = apply { this.timeout = timeout }

        fun maxRetries(maxRetries: Int) = apply { this.maxRetries = maxRetries }

        fun apiKey(apiKey: String) = apply {
            this.credential = BearerTokenCredential.create(apiKey)
        }

        fun credential(credential: Credential) = apply { this.credential = credential }

        fun azureServiceVersion(azureServiceVersion: AzureOpenAIServiceVersion) = apply {
            this.azureServiceVersion = azureServiceVersion
        }

        fun organization(organization: String?) = apply { this.organization = organization }

        /** Alias for calling [Builder.organization] with `organization.orElse(null)`. */
        fun organization(organization: Optional<String>) = organization(organization.getOrNull())

        fun project(project: String?) = apply { this.project = project }

        /** Alias for calling [Builder.project] with `project.orElse(null)`. */
        fun project(project: Optional<String>) = project(project.getOrNull())

        fun headers(headers: Headers) = apply {
            this.headers.clear()
            putAllHeaders(headers)
        }

        fun headers(headers: Map<String, Iterable<String>>) = apply {
            this.headers.clear()
            putAllHeaders(headers)
        }

        fun putHeader(name: String, value: String) = apply { headers.put(name, value) }

        fun putHeaders(name: String, values: Iterable<String>) = apply { headers.put(name, values) }

        fun putAllHeaders(headers: Headers) = apply { this.headers.putAll(headers) }

        fun putAllHeaders(headers: Map<String, Iterable<String>>) = apply {
            this.headers.putAll(headers)
        }

        fun replaceHeaders(name: String, value: String) = apply { headers.replace(name, value) }

        fun replaceHeaders(name: String, values: Iterable<String>) = apply {
            headers.replace(name, values)
        }

        fun replaceAllHeaders(headers: Headers) = apply { this.headers.replaceAll(headers) }

        fun replaceAllHeaders(headers: Map<String, Iterable<String>>) = apply {
            this.headers.replaceAll(headers)
        }

        fun removeHeaders(name: String) = apply { headers.remove(name) }

        fun removeAllHeaders(names: Set<String>) = apply { headers.removeAll(names) }

        fun queryParams(queryParams: QueryParams) = apply {
            this.queryParams.clear()
            putAllQueryParams(queryParams)
        }

        fun queryParams(queryParams: Map<String, Iterable<String>>) = apply {
            this.queryParams.clear()
            putAllQueryParams(queryParams)
        }

        fun putQueryParam(key: String, value: String) = apply { queryParams.put(key, value) }

        fun putQueryParams(key: String, values: Iterable<String>) = apply {
            queryParams.put(key, values)
        }

        fun putAllQueryParams(queryParams: QueryParams) = apply {
            this.queryParams.putAll(queryParams)
        }

        fun putAllQueryParams(queryParams: Map<String, Iterable<String>>) = apply {
            this.queryParams.putAll(queryParams)
        }

        fun replaceQueryParams(key: String, value: String) = apply {
            queryParams.replace(key, value)
        }

        fun replaceQueryParams(key: String, values: Iterable<String>) = apply {
            queryParams.replace(key, values)
        }

        fun replaceAllQueryParams(queryParams: QueryParams) = apply {
            this.queryParams.replaceAll(queryParams)
        }

        fun replaceAllQueryParams(queryParams: Map<String, Iterable<String>>) = apply {
            this.queryParams.replaceAll(queryParams)
        }

        fun removeQueryParams(key: String) = apply { queryParams.remove(key) }

        fun removeAllQueryParams(keys: Set<String>) = apply { queryParams.removeAll(keys) }

        fun fromEnv() = apply {
            val openAIKey = System.getenv("OPENAI_API_KEY")
            val openAIOrgId = System.getenv("OPENAI_ORG_ID")
            val openAIProjectId = System.getenv("OPENAI_PROJECT_ID")
            val azureOpenAIKey = System.getenv("AZURE_OPENAI_KEY")
            val azureEndpoint = System.getenv("AZURE_OPENAI_ENDPOINT")

            when {
                !openAIKey.isNullOrEmpty() && !azureOpenAIKey.isNullOrEmpty() -> {
                    throw IllegalArgumentException(
                        "Both OpenAI and Azure OpenAI API keys, `OPENAI_API_KEY` and `AZURE_OPENAI_KEY`, are set. Please specify only one"
                    )
                }
                !openAIKey.isNullOrEmpty() -> {
                    credential(BearerTokenCredential.create(openAIKey))
                    organization(openAIOrgId)
                    project(openAIProjectId)
                }
                !azureOpenAIKey.isNullOrEmpty() -> {
                    credential(AzureApiKeyCredential.create(azureOpenAIKey))
                    baseUrl(azureEndpoint)
                }
                !azureEndpoint.isNullOrEmpty() -> {
                    // Both 'openAIKey' and 'azureOpenAIKey' are not set.
                    // Only 'azureEndpoint' is set here, and user still needs to call method
                    // '.credential(BearerTokenCredential(Supplier<String>))'
                    // to get the token through the supplier, which requires Azure Entra ID as a
                    // dependency.
                    baseUrl(azureEndpoint)
                }
            }
        }

        /**
         * Returns an immutable instance of [ClientOptions].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .httpClient()
         * .apiKey()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ClientOptions {
            val httpClient = checkRequired("httpClient", httpClient)
            val credential = checkRequired("credential", credential)

            val headers = Headers.builder()
            val queryParams = QueryParams.builder()
            headers.put("X-Stainless-Lang", "java")
            headers.put("X-Stainless-Arch", getOsArch())
            headers.put("X-Stainless-OS", getOsName())
            headers.put("X-Stainless-OS-Version", getOsVersion())
            headers.put("X-Stainless-Package-Version", getPackageVersion())
            headers.put("X-Stainless-Runtime", "JRE")
            headers.put("X-Stainless-Runtime-Version", getJavaVersion())
            organization?.let { headers.put("OpenAI-Organization", it) }
            project?.let { headers.put("OpenAI-Project", it) }

            when (credential) {
                is AzureApiKeyCredential -> {
                    headers.put("api-key", credential.apiKey())
                }
                is BearerTokenCredential -> {
                    headers.put("Authorization", "Bearer ${credential.token()}")
                }
                else -> {
                    throw IllegalArgumentException("Invalid credential type")
                }
            }

            if (isAzureEndpoint(baseUrl)) {
                // Default Azure OpenAI version is used if Azure user doesn't
                // specific a service API version in 'queryParams'.
                replaceQueryParams(
                    "api-version",
                    (azureServiceVersion ?: AzureOpenAIServiceVersion.latestStableVersion()).value,
                )
            }

            headers.replaceAll(this.headers.build())
            queryParams.replaceAll(this.queryParams.build())

            return ClientOptions(
                httpClient,
                PhantomReachableClosingHttpClient(
                    RetryingHttpClient.builder()
                        .httpClient(httpClient)
                        .clock(clock)
                        .maxRetries(maxRetries)
                        .build()
                ),
                checkJacksonVersionCompatibility,
                jsonMapper,
                streamHandlerExecutor
                    ?: Executors.newCachedThreadPool(
                        object : ThreadFactory {

                            private val threadFactory: ThreadFactory =
                                Executors.defaultThreadFactory()
                            private val count = AtomicLong(0)

                            override fun newThread(runnable: Runnable): Thread =
                                threadFactory.newThread(runnable).also {
                                    it.name =
                                        "openai-stream-handler-thread-${count.getAndIncrement()}"
                                }
                        }
                    ),
                clock,
                baseUrl,
                headers.build(),
                queryParams.build(),
                responseValidation,
                timeout,
                maxRetries,
                credential,
                azureServiceVersion,
                organization,
                project,
            )
        }
    }
}
