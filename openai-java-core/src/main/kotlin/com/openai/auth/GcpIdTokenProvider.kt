package com.openai.auth

import com.fasterxml.jackson.databind.json.JsonMapper
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.errors.SubjectTokenProviderException
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException

private const val DEFAULT_AUDIENCE_GCP = "https://api.openai.com/v1"
private const val GCP_METADATA_BASE_URL =
    "http://metadata.google.internal/computeMetadata/v1/instance/service-accounts"

/**
 * A [SubjectTokenProvider] that fetches an OIDC identity token from the GCP Instance Metadata
 * server.
 *
 * It calls the local metadata server and returns the raw JWT identity token.
 */
class GcpIdTokenProvider private constructor(private val audience: String) : SubjectTokenProvider {

    override fun tokenType(): SubjectTokenType = SubjectTokenType.ID

    override fun getToken(httpClient: HttpClient, jsonMapper: JsonMapper): String {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl(GCP_METADATA_BASE_URL)
                .addPathSegment("default")
                .addPathSegment("identity")
                .putHeader("Metadata-Flavor", "Google")
                .putQueryParam("audience", audience)
                .putQueryParam("format", "full")
                .build()

        return try {
            val response = httpClient.execute(request)
            response.use {
                if (response.statusCode() != 200) {
                    throw SubjectTokenProviderException(
                        provider = "gcp-metadata",
                        message = "metadata server returned status ${response.statusCode()}",
                    )
                }

                val token = response.body().bufferedReader().readText().trim()

                if (token.isEmpty()) {
                    throw SubjectTokenProviderException(
                        provider = "gcp-metadata",
                        message = "metadata server returned empty token",
                    )
                }

                token
            }
        } catch (e: SubjectTokenProviderException) {
            throw e
        } catch (e: Exception) {
            throw SubjectTokenProviderException(
                provider = "gcp-metadata",
                message = "failed to fetch token from metadata server",
                cause = e,
            )
        }
    }

    override fun getTokenAsync(
        httpClient: HttpClient,
        jsonMapper: JsonMapper,
    ): CompletableFuture<String> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl(GCP_METADATA_BASE_URL)
                .addPathSegment("default")
                .addPathSegment("identity")
                .putHeader("Metadata-Flavor", "Google")
                .putQueryParam("audience", audience)
                .putQueryParam("format", "full")
                .build()

        return httpClient
            .executeAsync(request)
            .thenApply { response ->
                response.use {
                    if (response.statusCode() != 200) {
                        throw SubjectTokenProviderException(
                            provider = "gcp-metadata",
                            message = "metadata server returned status ${response.statusCode()}",
                        )
                    }

                    val token = response.body().bufferedReader().readText().trim()

                    if (token.isEmpty()) {
                        throw SubjectTokenProviderException(
                            provider = "gcp-metadata",
                            message = "metadata server returned empty token",
                        )
                    }

                    token
                }
            }
            .exceptionally { e ->
                val cause = if (e is CompletionException) e.cause ?: e else e
                if (cause is SubjectTokenProviderException) throw cause
                throw SubjectTokenProviderException(
                    provider = "gcp-metadata",
                    message = "failed to fetch token from metadata server",
                    cause = cause,
                )
            }
    }

    companion object {
        @JvmStatic fun builder() = Builder()
    }

    class Builder internal constructor() {

        private var audience: String = DEFAULT_AUDIENCE_GCP

        /**
         * The audience URI to include in the identity token (default: `https://api.openai.com/v1`).
         */
        fun audience(audience: String) = apply { this.audience = audience }

        fun build(): GcpIdTokenProvider = GcpIdTokenProvider(audience)
    }
}
