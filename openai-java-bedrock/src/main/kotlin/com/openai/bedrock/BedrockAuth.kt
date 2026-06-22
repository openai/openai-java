package com.openai.bedrock

import com.openai.core.http.Headers
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpRequestAuthenticator
import com.openai.errors.OpenAIException
import java.io.ByteArrayOutputStream
import java.net.URI
import java.time.Clock
import java.util.concurrent.CompletableFuture
import java.util.function.Supplier
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials
import software.amazon.awssdk.auth.credentials.AwsCredentials
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider
import software.amazon.awssdk.http.ContentStreamProvider
import software.amazon.awssdk.http.SdkHttpMethod
import software.amazon.awssdk.http.SdkHttpRequest
import software.amazon.awssdk.http.auth.aws.signer.AwsV4HttpSigner
import software.amazon.awssdk.http.auth.spi.signer.HttpSigner
import software.amazon.awssdk.http.auth.spi.signer.SignRequest
import software.amazon.awssdk.identity.spi.AwsCredentialsIdentity
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.regions.providers.DefaultAwsRegionProviderChain

internal const val BEDROCK_SERVICE = "bedrock-mantle"
internal const val ENV_BEARER_TOKEN = "AWS_BEARER_TOKEN_BEDROCK"
internal const val ENV_BASE_URL = "AWS_BEDROCK_BASE_URL"

internal data class BedrockConfiguration(
    val baseUrl: String,
    val authenticator: HttpRequestAuthenticator,
)

internal data class BedrockAuthOptions(
    val awsRegion: String?,
    val baseUrl: String?,
    val apiKey: String?,
    val tokenProvider: Supplier<String>?,
    val awsAccessKeyId: String?,
    val awsSecretAccessKey: String?,
    val awsSessionToken: String?,
    val awsProfile: String?,
    val awsCredentialsProvider: AwsCredentialsProvider?,
    val skipAuth: Boolean,
    val clock: Clock,
)

internal fun BedrockAuthOptions.resolve(
    getenv: (String) -> String? = System::getenv,
    regionProvider: () -> Region? = {
        try {
            DefaultAwsRegionProviderChain.builder().build().region
        } catch (_: RuntimeException) {
            null
        }
    },
): BedrockConfiguration {
    val normalizedRegion = normalize("awsRegion", awsRegion)
    val normalizedBaseUrl = normalize("baseUrl", baseUrl)
    val normalizedApiKey = normalize("apiKey", apiKey)
    val normalizedProfile = normalize("awsProfile", awsProfile)

    if (apiKey != null && normalizedApiKey == null) {
        throw OpenAIException("The Bedrock bearer credential must not be empty.")
    }
    if (tokenProvider != null && apiKey != null) {
        throw OpenAIException(
            "The `apiKey` and `bedrockTokenProvider` options are mutually exclusive. Configure only one."
        )
    }
    if (awsProfile != null && normalizedProfile == null) {
        throw OpenAIException("The Bedrock AWS `awsProfile` must not be empty.")
    }

    val staticCredentials = resolveStaticCredentials()
    val awsModeCount =
        listOf(staticCredentials != null, normalizedProfile != null, awsCredentialsProvider != null)
            .count { it }
    if (awsModeCount > 1) {
        throw OpenAIException(
            "Bedrock authentication is ambiguous. Configure exactly one explicit AWS mode: static credentials, profile, or credential provider."
        )
    }

    val explicitBearer = normalizedApiKey != null || tokenProvider != null
    val explicitAws = awsModeCount == 1
    if (explicitBearer && explicitAws) {
        throw OpenAIException(
            "Bearer and AWS credential authentication are mutually exclusive. Configure exactly one explicit mode: bearer credential, static AWS credentials, profile, or credential provider."
        )
    }
    if (skipAuth && (explicitBearer || explicitAws)) {
        throw OpenAIException(
            "Bedrock authentication is ambiguous. `skipAuth` cannot be combined with bearer or AWS credentials."
        )
    }

    val environmentBaseUrl = normalizeEnvironment(getenv(ENV_BASE_URL))
    val resolvedRegion =
        normalizedRegion
            ?: normalizeEnvironment(getenv("AWS_REGION"))
            ?: normalizeEnvironment(getenv("AWS_DEFAULT_REGION"))
            ?: regionProvider()?.id()
    val resolvedBaseUrl =
        normalizedBaseUrl
            ?: environmentBaseUrl
            ?: resolvedRegion?.let { "https://bedrock-mantle.$it.api.aws/openai/v1" }
            ?: throw OpenAIException(
                "Bedrock requires an AWS region. Pass `awsRegion` to the builder, or set `AWS_REGION` or `AWS_DEFAULT_REGION`."
            )
    val normalizedResolvedBaseUrl = normalizeBaseUrl(resolvedBaseUrl)

    if (skipAuth) {
        return BedrockConfiguration(
            normalizedResolvedBaseUrl,
            NoAuthAuthenticator(normalizedResolvedBaseUrl),
        )
    }

    val bearerSupplier =
        when {
            tokenProvider != null -> tokenProvider
            normalizedApiKey != null -> Supplier { normalizedApiKey }
            !explicitAws && normalizeEnvironment(getenv(ENV_BEARER_TOKEN)) != null ->
                Supplier {
                    normalizeEnvironment(getenv(ENV_BEARER_TOKEN))
                        ?: throw OpenAIException(
                            "Could not find credentials for Bedrock. Set `AWS_BEARER_TOKEN_BEDROCK` or configure AWS credential authentication."
                        )
                }
            else -> null
        }

    if (bearerSupplier != null) {
        return BedrockConfiguration(
            normalizedResolvedBaseUrl,
            BearerAuthenticator(normalizedResolvedBaseUrl, bearerSupplier),
        )
    }

    val region =
        resolvedRegion
            ?: throw OpenAIException(
                "Bedrock requires an AWS region. Pass `awsRegion` to the builder, or set `AWS_REGION` or `AWS_DEFAULT_REGION`."
            )
    val credentialsProvider =
        when {
            staticCredentials != null -> AwsCredentialsProvider { staticCredentials }
            normalizedProfile != null -> ProfileCredentialsProvider.create(normalizedProfile)
            awsCredentialsProvider != null -> awsCredentialsProvider
            else -> DefaultCredentialsProvider.builder().build()
        }

    return BedrockConfiguration(
        normalizedResolvedBaseUrl,
        SigV4Authenticator(
            baseUrl = normalizedResolvedBaseUrl,
            region = Region.of(region),
            credentialsProvider = credentialsProvider,
            defaultChain = !explicitAws,
            clock = clock,
        ),
    )
}

private fun BedrockAuthOptions.resolveStaticCredentials(): AwsCredentials? {
    val hasAccessKey = awsAccessKeyId != null
    val hasSecretKey = awsSecretAccessKey != null
    if (hasAccessKey != hasSecretKey || (awsSessionToken != null && !hasAccessKey)) {
        throw OpenAIException(
            "Static AWS credentials require both `awsAccessKeyId` and `awsSecretAccessKey`. An `awsSessionToken` may only be used with both."
        )
    }
    if (!hasAccessKey) return null

    val accessKey = awsAccessKeyId!!.trim()
    val secretKey = awsSecretAccessKey!!.trim()
    if (accessKey.isEmpty() || secretKey.isEmpty()) {
        throw OpenAIException(
            "Static AWS credentials require non-empty `awsAccessKeyId` and `awsSecretAccessKey` values."
        )
    }
    val sessionToken = awsSessionToken?.trim()
    if (awsSessionToken != null && sessionToken.isNullOrEmpty()) {
        throw OpenAIException("A static AWS `awsSessionToken` must not be empty when provided.")
    }

    return if (sessionToken == null) AwsBasicCredentials.create(accessKey, secretKey)
    else AwsSessionCredentials.create(accessKey, secretKey, sessionToken)
}

private fun normalize(name: String, value: String?): String? {
    val normalized = value?.trim()?.takeIf { it.isNotEmpty() }
    if (value != null && normalized == null && (name == "awsRegion" || name == "baseUrl")) {
        throw OpenAIException("The Bedrock `$name` must not be empty.")
    }
    return normalized
}

private fun normalizeEnvironment(value: String?): String? =
    value?.trim()?.takeIf { it.isNotEmpty() }

private fun normalizeBaseUrl(value: String): String =
    try {
        value.toHttpUrl().toString().removeSuffix("/")
    } catch (cause: IllegalArgumentException) {
        throw OpenAIException("The Bedrock `baseUrl` must be a valid HTTP URL.", cause)
    }

private abstract class OriginBoundAuthenticator(baseUrl: String) : HttpRequestAuthenticator {
    private val origin = baseUrl.toHttpUrl().origin()

    protected fun resolvedUrl(request: HttpRequest): HttpUrl {
        val url = request.resolveUrl()
        if (url.origin() != origin) {
            throw OpenAIException(
                "Bedrock provider authentication cannot be used with a request to a different origin."
            )
        }
        return url
    }
}

private class NoAuthAuthenticator(baseUrl: String) : OriginBoundAuthenticator(baseUrl) {
    override fun authenticate(request: HttpRequest): HttpRequest {
        resolvedUrl(request)
        return request
    }
}

private class BearerAuthenticator(baseUrl: String, private val tokenProvider: Supplier<String>) :
    OriginBoundAuthenticator(baseUrl) {
    override fun authenticate(request: HttpRequest): HttpRequest {
        resolvedUrl(request)
        assertNoAuthorization(request.headers)
        val token =
            try {
                tokenProvider.get()
            } catch (cause: Throwable) {
                throw OpenAIException("Failed to resolve a bearer credential for Bedrock.", cause)
            }
        if (token.isNullOrBlank()) {
            throw OpenAIException(
                "The Bedrock bearer credential provider must return a non-empty string."
            )
        }
        return request.toBuilder().replaceHeaders("Authorization", "Bearer $token").build()
    }
}

private class SigV4Authenticator(
    baseUrl: String,
    private val region: Region,
    private val credentialsProvider: AwsCredentialsProvider,
    private val defaultChain: Boolean,
    private val clock: Clock,
) : OriginBoundAuthenticator(baseUrl) {
    private val signer = AwsV4HttpSigner.create()

    override fun authenticate(request: HttpRequest): HttpRequest {
        val url = resolvedUrl(request)
        validateCanonicalRegion(url)
        assertNoAuthorization(request.headers)
        if (request.body?.repeatable() == false) {
            throw OpenAIException(
                "Bedrock SigV4 authentication requires a replayable request body. Buffer the body before sending or use bearer authentication."
            )
        }

        val preparedRequest =
            request
                .toBuilder()
                .removeAllHeaders(
                    setOf(
                        "Authorization",
                        "X-Amz-Date",
                        "X-Amz-Security-Token",
                        "X-Amz-Content-Sha256",
                    )
                )
                .apply {
                    request.body?.contentType()?.let { contentType ->
                        if (request.headers.values("Content-Type").isEmpty()) {
                            putHeader("Content-Type", contentType)
                        }
                    }
                }
                .build()
        val bodyBytes =
            preparedRequest.body?.let { body ->
                ByteArrayOutputStream().use { output ->
                    body.writeTo(output)
                    output.toByteArray()
                }
            }
        val awsRequest = preparedRequest.toAwsRequest(url.toUri())
        val credentials = resolveCredentials()
        val signed =
            signer.sign { signRequest: SignRequest.Builder<AwsCredentialsIdentity> ->
                signRequest
                    .identity(credentials)
                    .request(awsRequest)
                    .apply {
                        if (bodyBytes != null) {
                            payload(ContentStreamProvider.fromByteArray(bodyBytes))
                        }
                    }
                    .putProperty(AwsV4HttpSigner.SERVICE_SIGNING_NAME, BEDROCK_SERVICE)
                    .putProperty(AwsV4HttpSigner.REGION_NAME, region.id())
                    .putProperty(HttpSigner.SIGNING_CLOCK, clock)
            }

        return preparedRequest.toBuilder().headers(signed.request().headers()).build()
    }

    override fun authenticateAsync(request: HttpRequest): CompletableFuture<HttpRequest> =
        CompletableFuture.supplyAsync { authenticate(request) }

    override fun close() {
        (credentialsProvider as? AutoCloseable)?.close()
    }

    private fun resolveCredentials(): AwsCredentials {
        val credentials =
            try {
                credentialsProvider.resolveCredentials()
            } catch (cause: Throwable) {
                val message =
                    if (defaultChain)
                        "Could not find credentials for Bedrock. Pass AWS credentials to the builder or configure the default AWS credential chain."
                    else
                        "Failed to resolve AWS credentials for Bedrock. Verify your AWS profile, environment variables, or runtime identity configuration and try again."
                throw OpenAIException(message, cause)
            }
        if (
            credentials.accessKeyId().isNullOrBlank() ||
                credentials.secretAccessKey().isNullOrBlank() ||
                (credentials is AwsSessionCredentials && credentials.sessionToken().isBlank())
        ) {
            throw OpenAIException(
                "Failed to resolve AWS credentials for Bedrock. Verify your AWS profile, environment variables, or runtime identity configuration and try again."
            )
        }
        return credentials
    }

    private fun validateCanonicalRegion(url: HttpUrl) {
        val canonicalRegion =
            Regex("^bedrock-mantle\\.([a-z0-9-]+)\\.api\\.aws$", RegexOption.IGNORE_CASE)
                .matchEntire(url.host)
                ?.groupValues
                ?.get(1)
        if (canonicalRegion != null && canonicalRegion != region.id()) {
            throw OpenAIException(
                "The Bedrock endpoint region `$canonicalRegion` does not match the SigV4 region `${region.id()}`."
            )
        }
    }
}

private fun HttpRequest.toAwsRequest(uri: URI): SdkHttpRequest {
    val builder =
        SdkHttpRequest.builder().uri(uri).method(SdkHttpMethod.fromValue(method.name)).apply {
            this@toAwsRequest.headers.names().forEach { name ->
                if (!name.equals("connection", ignoreCase = true)) {
                    this@toAwsRequest.headers.values(name).forEach { value ->
                        appendHeader(name, value)
                    }
                }
            }
        }
    return builder.build()
}

private fun assertNoAuthorization(headers: Headers) {
    if (headers.values("Authorization").isNotEmpty()) {
        throw OpenAIException(
            "Bedrock provider authentication cannot be combined with a custom `Authorization` header."
        )
    }
}

private fun HttpRequest.resolveUrl(): HttpUrl =
    baseUrl
        .toHttpUrl()
        .newBuilder()
        .apply {
            pathSegments.forEach(::addPathSegment)
            queryParams.keys().forEach { key ->
                queryParams.values(key).forEach { value -> addQueryParameter(key, value) }
            }
        }
        .build()

private fun HttpUrl.origin(): String = "$scheme://$host:$port"
