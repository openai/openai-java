package com.openai.auth

import com.fasterxml.jackson.databind.json.JsonMapper
import com.openai.core.http.HttpClient
import java.util.concurrent.CompletableFuture

enum class SubjectTokenType {
    JWT,
    ID,
}

/**
 * Provides a subject token for use in workload identity federation.
 *
 * Implementations are responsible for obtaining a short-lived credential from the local environment
 * (e.g. a cloud metadata server or a mounted Kubernetes secret) and returning it as a plain string.
 */
interface SubjectTokenProvider {
    /** Returns the format of the token produced by [getToken] and [getTokenAsync]. */
    fun tokenType(): SubjectTokenType

    /**
     * Synchronously fetches a subject token.
     *
     * @param httpClient the HTTP client to use for any network requests
     * @param jsonMapper the JSON mapper to use for deserializing responses
     * @return the raw token string
     */
    fun getToken(httpClient: HttpClient, jsonMapper: JsonMapper): String

    /**
     * Asynchronously fetches a subject token.
     *
     * @param httpClient the HTTP client to use for any network requests
     * @param jsonMapper the JSON mapper to use for deserializing responses
     * @return a [CompletableFuture] that completes with the raw token string
     */
    fun getTokenAsync(httpClient: HttpClient, jsonMapper: JsonMapper): CompletableFuture<String>
}
