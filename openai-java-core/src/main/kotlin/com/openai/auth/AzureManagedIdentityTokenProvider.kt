package com.openai.auth

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.errors.SubjectTokenProviderException
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException

private const val DEFAULT_AUDIENCE = "https://management.azure.com/"
private const val DEFAULT_AZURE_API_VERSION = "2018-02-01"
private const val AZURE_IMDS_BASE_URL = "http://169.254.169.254/metadata/identity/oauth2/token"

/**
 * A [SubjectTokenProvider] that fetches an identity token from the Azure Instance Metadata Service
 * (IMDS).
 *
 * It calls the local IMDS endpoint and returns the `access_token` from the response.
 */
class AzureManagedIdentityTokenProvider
private constructor(private val resource: String, private val apiVersion: String) :
    SubjectTokenProvider {

    override fun tokenType(): SubjectTokenType = SubjectTokenType.JWT

    override fun getToken(httpClient: HttpClient, jsonMapper: JsonMapper): String {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl(AZURE_IMDS_BASE_URL)
                .putHeader("Metadata", "true")
                .putQueryParam("api-version", apiVersion)
                .putQueryParam("resource", resource)
                .build()

        return try {
            val response = httpClient.execute(request)
            response.use {
                if (response.statusCode() != 200) {
                    throw SubjectTokenProviderException(
                        provider = "azure-imds",
                        message = "IMDS returned status ${response.statusCode()}",
                    )
                }

                val result =
                    jsonMapper.readValue(response.body(), jacksonTypeRef<AzureIMDSResponse>())

                if (result.accessToken.isEmpty()) {
                    throw SubjectTokenProviderException(
                        provider = "azure-imds",
                        message = "IMDS response missing 'access_token' field",
                    )
                }

                result.accessToken
            }
        } catch (e: SubjectTokenProviderException) {
            throw e
        } catch (e: Exception) {
            throw SubjectTokenProviderException(
                provider = "azure-imds",
                message = "failed to fetch token from IMDS",
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
                .baseUrl(AZURE_IMDS_BASE_URL)
                .putHeader("Metadata", "true")
                .putQueryParam("api-version", apiVersion)
                .putQueryParam("resource", resource)
                .build()

        return httpClient
            .executeAsync(request)
            .thenApply { response ->
                response.use {
                    if (response.statusCode() != 200) {
                        throw SubjectTokenProviderException(
                            provider = "azure-imds",
                            message = "IMDS returned status ${response.statusCode()}",
                        )
                    }

                    val result =
                        jsonMapper.readValue(response.body(), jacksonTypeRef<AzureIMDSResponse>())

                    if (result.accessToken.isEmpty()) {
                        throw SubjectTokenProviderException(
                            provider = "azure-imds",
                            message = "IMDS response missing 'access_token' field",
                        )
                    }

                    result.accessToken
                }
            }
            .exceptionally { e ->
                val cause = if (e is CompletionException) e.cause ?: e else e
                if (cause is SubjectTokenProviderException) throw cause
                throw SubjectTokenProviderException(
                    provider = "azure-imds",
                    message = "failed to fetch token from IMDS",
                    cause = cause,
                )
            }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private data class AzureIMDSResponse(@JsonProperty("access_token") val accessToken: String)

    companion object {
        @JvmStatic fun builder() = Builder()
    }

    class Builder internal constructor() {

        private var resource: String = DEFAULT_AUDIENCE
        private var apiVersion: String = DEFAULT_AZURE_API_VERSION

        /**
         * The Azure resource URI to request a token for (default: `https://management.azure.com/`).
         */
        fun resource(resource: String) = apply { this.resource = resource }

        /** The IMDS API version to use (default: `2018-02-01`). */
        fun apiVersion(apiVersion: String) = apply { this.apiVersion = apiVersion }

        fun build(): AzureManagedIdentityTokenProvider =
            AzureManagedIdentityTokenProvider(resource, apiVersion)
    }
}
