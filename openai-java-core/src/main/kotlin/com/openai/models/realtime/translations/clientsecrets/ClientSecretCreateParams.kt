// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.realtime.translations.clientsecrets

import com.openai.core.JsonValue
import com.openai.core.Params
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.models.realtime.RealtimeTranslationClientSecretCreateRequest
import java.util.Objects

/**
 * Create a Realtime translation client secret with an associated translation session configuration.
 *
 * Client secrets are short-lived tokens that can be passed to a client app, such as a web frontend
 * or mobile client, which grants access to the Realtime Translation API without leaking your main
 * API key. You can configure a custom TTL for each client secret.
 *
 * Returns the created client secret and the effective translation session object. The client secret
 * is a string that looks like `ek_1234`.
 */
class ClientSecretCreateParams
private constructor(
    private val realtimeTranslationClientSecretCreateRequest:
        RealtimeTranslationClientSecretCreateRequest,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** Create a translation session and client secret for the Realtime API. */
    fun realtimeTranslationClientSecretCreateRequest():
        RealtimeTranslationClientSecretCreateRequest = realtimeTranslationClientSecretCreateRequest

    fun _additionalBodyProperties(): Map<String, JsonValue> =
        realtimeTranslationClientSecretCreateRequest._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ClientSecretCreateParams].
         *
         * The following fields are required:
         * ```java
         * .realtimeTranslationClientSecretCreateRequest()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ClientSecretCreateParams]. */
    class Builder internal constructor() {

        private var realtimeTranslationClientSecretCreateRequest:
            RealtimeTranslationClientSecretCreateRequest? =
            null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(clientSecretCreateParams: ClientSecretCreateParams) = apply {
            realtimeTranslationClientSecretCreateRequest =
                clientSecretCreateParams.realtimeTranslationClientSecretCreateRequest
            additionalHeaders = clientSecretCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = clientSecretCreateParams.additionalQueryParams.toBuilder()
        }

        /** Create a translation session and client secret for the Realtime API. */
        fun realtimeTranslationClientSecretCreateRequest(
            realtimeTranslationClientSecretCreateRequest:
                RealtimeTranslationClientSecretCreateRequest
        ) = apply {
            this.realtimeTranslationClientSecretCreateRequest =
                realtimeTranslationClientSecretCreateRequest
        }

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
         * Returns an immutable instance of [ClientSecretCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .realtimeTranslationClientSecretCreateRequest()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ClientSecretCreateParams =
            ClientSecretCreateParams(
                checkRequired(
                    "realtimeTranslationClientSecretCreateRequest",
                    realtimeTranslationClientSecretCreateRequest,
                ),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): RealtimeTranslationClientSecretCreateRequest =
        realtimeTranslationClientSecretCreateRequest

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ClientSecretCreateParams &&
            realtimeTranslationClientSecretCreateRequest ==
                other.realtimeTranslationClientSecretCreateRequest &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            realtimeTranslationClientSecretCreateRequest,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "ClientSecretCreateParams{realtimeTranslationClientSecretCreateRequest=$realtimeTranslationClientSecretCreateRequest, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
